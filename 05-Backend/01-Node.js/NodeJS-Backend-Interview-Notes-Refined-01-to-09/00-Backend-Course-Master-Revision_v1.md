# Backend Course — Master Conceptual Revision (v1)

> **Scope:** The nine Node.js/backend lectures currently present in this course folder. Use this file for one-pass revision; open the linked lecture notes when you need the fuller explanation. This is not a substitute for material from backend modules that have not yet been added to the course folder.

## Course map

| Lecture | Core question |
|---|---|
| 01. Node.js runtime and V8 | How does JavaScript run outside the browser? |
| 02. Processes, threads and concurrency | How does the OS execute multiple tasks? |
| 03. Node.js threading model | How does Node handle I/O, and what can block it? |
| 04. Event loop and microtasks | When do callbacks and Promise handlers execute? |
| 05. Modules and npm | How is Node code separated and reused? |
| 06. File I/O, paths and rendering | How does Node read files and produce HTML? |
| 07. Networking | How does a client locate and communicate with a server? |
| 08. Storage, latency and scaling | What affects backend performance? |
| 09. HTTP, APIs and REST | How does a client communicate with a backend? |

---

## 1. Node.js, V8 and libuv

| Term | Meaning |
|---|---|
| JavaScript | The programming language |
| V8 | The engine that parses and executes JavaScript |
| Node.js | The runtime that embeds V8 and provides server-side APIs |
| libuv | Provides event-loop/I/O infrastructure and a worker pool for selected operations |
| Express | A web framework built on Node.js |

**Mental model:** JavaScript is the language → V8 executes it → Node.js provides the runtime APIs → libuv helps coordinate asynchronous work.

### V8 execution — simplified

```text
Source code → Parsing / AST → Ignition bytecode execution
           → hot code may be optimized by TurboFan
           → assumptions may fail → de-optimization
```

- **AST:** structured representation of parsed source code.
- **Bytecode:** lower-level instructions executed by an interpreter.
- **Hot code:** frequently executed code that may be optimized.
- **Garbage collection:** reclaims memory held by objects that are no longer reachable.
- **Call stack:** tracks active function calls; excessive recursion can cause stack overflow.
- **Heap:** commonly holds dynamically allocated objects.

**Interview answer:** Node.js is a JavaScript runtime built around V8. V8 executes JavaScript; Node.js adds filesystem, process, networking and other runtime APIs.

## 2. Program, process, thread and concurrency

- **Program:** code stored on disk, such as `server.js`.
- **Process:** a running instance of a program, managed by the OS.
- **Thread:** an execution path inside a process. Threads normally share process memory but have their own execution state and stack.
- **Context switch:** the OS saves one execution context and restores another.
- **Race condition:** the result depends on timing when concurrent work accesses shared state without adequate coordination.

| Processes | Threads in one process |
|---|---|
| Separate address spaces | Share process memory/resources |
| Stronger isolation | Shared data needs synchronization |
| Often communicate through IPC | Can share data directly |
| Generally more overhead | Generally lighter, but still has overhead |

**Concurrency** means tasks make progress over overlapping periods; they may take turns or wait. **Parallelism** means tasks execute at the same instant on separate execution resources.

| CPU-bound | I/O-bound |
|---|---|
| Computation dominates | Waiting for data or external work dominates |
| Heavy calculations, compression | Database/network/file operations |
| Improve algorithm; consider workers/processes | Non-blocking I/O can keep JS available |

## 3. Node.js threading model

**Is Node.js single-threaded?**

Ordinary application JavaScript callbacks for a Node.js isolate generally run on its main JavaScript thread. The full runtime also uses OS I/O facilities, a libuv worker pool for selected operations, and optional worker threads or child processes.

```text
JavaScript starts async I/O
          ↓
OS / runtime handles the waiting
          ↓
JS thread can process other ready work
          ↓
I/O completion becomes ready
          ↓
Callback runs on the JS thread
```

| Mechanism | Main purpose |
|---|---|
| OS networking facilities | Commonly handle network socket I/O |
| libuv worker pool | Selected filesystem, crypto, compression and DNS lookup work |
| `worker_threads` | Execute JavaScript in additional threads; useful for CPU-heavy JS |
| Child process | Run work in a separate OS process with stronger isolation |

**Non-blocking does not mean instant.** It means the JavaScript thread does not wait synchronously for I/O to complete. A long synchronous loop or blocking API still blocks that JS thread.

**Trap:** not every asynchronous operation uses the libuv worker pool; asynchronous does not automatically mean parallel. The libuv pool commonly has four threads by default; changing `UV_THREADPOOL_SIZE` does not guarantee improved performance.

## 4. Event loop and microtasks

The event loop coordinates when eligible callbacks can run. Callback JavaScript normally runs on the JS thread.

| Phase | Remember |
|---|---|
| Timers | Eligible `setTimeout` / `setInterval` callbacks |
| Pending callbacks | Certain deferred system/I/O callbacks |
| Idle / prepare | Internal libuv work |
| Poll | Processes I/O events; can wait for I/O |
| Check | `setImmediate()` callbacks |
| Close callbacks | Some close-event callbacks |

- Promise handlers (`then`, `catch`, `finally`) run as microtasks.
- `process.nextTick()` uses Node's next-tick queue.
- In common CommonJS contexts, next-tick callbacks are generally drained before Promise microtasks.
- These queues are not additional libuv phases.

### Dry run (CommonJS)

```js
console.log("A");
process.nextTick(() => console.log("nextTick"));
Promise.resolve().then(() => console.log("promise"));
console.log("B");
```

Output:

```text
A
B
nextTick
promise
```

Synchronous statements run first. Then, in this CommonJS context, Node drains the next-tick queue before Promise microtasks.

`setTimeout(fn, 0)` is not immediate. `setImmediate(fn)` runs in the Check phase. Their top-level relative order can vary; do not memorize a universal order.

## 5. Modules and npm

A **module** is a reusable unit of code. It lets us separate responsibilities and expose selected values.

**CommonJS:**

```js
// math.cjs
const add = (a, b) => a + b;
module.exports = { add };

// app.cjs
const { add } = require("./math.cjs");
```

**ES modules:**

```js
// math.js
export const add = (a, b) => a + b;

// app.js
import { add } from "./math.js";
```

| CommonJS | ES modules |
|---|---|
| `require()` | `import` |
| `module.exports` | `export` / `export default` |
| `.cjs` explicitly means CJS | `.mjs` explicitly means ESM |
| `.js` defaults according to package scope | `"type": "module"` makes package-scope `.js` files ESM |

`exports` initially references `module.exports`; reassigning `exports` alone does not replace `module.exports`.

**npm** installs and manages packages. `package.json` stores metadata, scripts, dependency declarations and configuration. `dependencies` are needed at runtime; `devDependencies` are mainly development/testing tools.

## 6. File I/O, paths and rendering

Node's built-in `fs` module reads, writes, appends, deletes and watches files.

| API | Completion style |
|---|---|
| `node:fs` | Common callback-based APIs |
| `node:fs/promises` | Promise-based APIs for `async`/`await` |

```js
import { readFile } from "node:fs/promises";
const text = await readFile(new URL("./data.txt", import.meta.url), "utf8");
```

With `"utf8"`, the result is text; without an encoding, `readFile()` returns a `Buffer` (raw bytes). Synchronous file operations block the JS thread.

| Path expression | Meaning |
|---|---|
| `__dirname` | Current CommonJS module directory |
| `import.meta.url` | Current ES module URL |
| `process.cwd()` | Process working directory; may differ from script directory |
| `node:path` helpers | Build filesystem paths |

A **template** contains reusable markup and placeholders. A template engine (for example, EJS) combines it with data to produce output. Escape untrusted values; inserting untrusted raw HTML can cause **XSS**.

- **CSR:** much of the UI is rendered/updated in the browser.
- **SSR:** the server generates HTML for the request; the client may then hydrate/run JavaScript.
- Templating and SSR are related but not identical.

## 7. Networking: DNS, IP, TCP/UDP and ports

A **client** initiates a request; a **server** listens, processes work and responds. A backend can also act as a client when calling another service.

```text
Browser parses URL
       ↓
DNS/cache resolves hostname
       ↓
Connect to destination IP + port
       ↓
Transport setup (TCP for conventional HTTPS)
       ↓
TLS protects HTTPS traffic
       ↓
HTTP request → server processes → HTTP response
```

An existing connection may be reused and DNS can be cached. HTTP/3 uses QUIC over UDP, not TCP.

| Term | Meaning |
|---|---|
| Domain | Human-readable name |
| DNS | Resolves names to records |
| IP address | Address used for IP communication |
| URL | Resource locator with scheme/host/path and possibly port |
| Port | Transport endpoint identifier |
| Socket | Communication endpoint commonly described by address, port and transport |

Five-layer TCP/IP teaching model:

| Layer | Examples |
|---|---|
| Application | HTTP, DNS, SMTP |
| Transport | TCP, UDP |
| Network / Internet | IPv4, IPv6 |
| Data link | Ethernet, Wi-Fi |
| Physical | Copper, fiber, radio |

Encapsulation: **application data → TCP segment / UDP datagram → IP packet → link-layer frame → bits/signals**.

| TCP | UDP |
|---|---|
| Reliable, ordered byte stream | Datagrams without built-in delivery/order guarantee |
| Retransmission, flow and congestion control | Does not provide those by itself |
| Commonly used by HTTP/1.1 and HTTP/2 | Used by real-time apps and by QUIC under HTTP/3 |

TCP handshake: **SYN → SYN-ACK → ACK**. DNS finds records; IP/routing moves packets; TCP/UDP transport data; ports direct traffic to the intended endpoint.

## 8. Storage, latency, throughput and scaling

| Term | Meaning |
|---|---|
| Latency | Time an operation/request takes |
| Throughput | Work completed per unit time |
| Bandwidth | Data-transfer capacity/rate |
| QPS | Queries or requests per second, depending on context |

`Average requests/second = Requests per day ÷ 86,400`

This is an average, not a peak-load estimate. Latency may include network time, queueing, application work, storage access and response transfer.

Simplified storage hierarchy:

```text
CPU registers → CPU caches (L1/L2/L3) → RAM → SSD/HDD → remote storage
```

- **RAM** is volatile working memory.
- **SSD/HDD** are persistent secondary storage.
- **Sequential access** reads nearby/ordered data; **random access** jumps between locations. Random seeks are especially costly on mechanical HDDs.

A **cache** stores data in a faster place to reduce repeated work/access time.

- **Hit:** requested item is in cache.
- **Miss:** item must be fetched/computed elsewhere.
- **TTL:** configured expiry time.
- **Invalidation:** removing or refreshing stale data.

Caching reduces repeated work but introduces freshness/invalidation concerns.

- **Vertical scaling:** add CPU/RAM or other resources to one machine.
- **Horizontal scaling:** add machines/instances and distribute work.

Adding instances does not fix every bottleneck; an overloaded database, slow query, network dependency or inefficient algorithm may remain the limit. Measure first.

## 9. HTTP, APIs and REST

An **API** defines how one software component uses another. A network API communicates across a network.

An HTTP request commonly has a **method**, **URL/target**, **headers** and optional **body**. A response has a **status code**, headers and optional body. HTTPS protects HTTP traffic using TLS; it does not replace application validation or authorization.

| Method | Typical intent | Safe? | Idempotent? |
|---|---|---:|---:|
| GET | Retrieve | Yes | Yes |
| POST | Submit/process/create | No | Usually no |
| PUT | Replace/create target representation | No | Intended yes |
| PATCH | Partially modify | No | Depends on operation |
| DELETE | Remove | No | Intended yes |

- **Safe:** intended effect is read-only.
- **Idempotent:** repeating the same request has the same intended effect as doing it once.

Resource-oriented examples:

```text
GET    /api/todos       List todos
GET    /api/todos/42    Get todo 42
POST   /api/todos       Create a todo
PATCH  /api/todos/42    Update selected fields
DELETE /api/todos/42    Delete a todo
```

REST is an architectural style. A RESTful HTTP API commonly models resources in URLs and uses HTTP method semantics; JSON alone does not make an API fully RESTful.

| Status | Meaning |
|---|---|
| 200 | OK |
| 201 | Created |
| 204 | No Content |
| 400 | Bad Request |
| 401 | Missing/invalid authentication |
| 403 | Not permitted |
| 404 | Not Found |
| 409 | Conflict |
| 429 | Too Many Requests |
| 500 | Internal Server Error |
| 503 | Service Unavailable |

Other API styles: **GraphQL** lets clients select fields using a schema; **gRPC** is typed RPC commonly using Protocol Buffers and HTTP/2; **SOAP** is an XML-based messaging protocol.

| Version | Key distinction |
|---|---|
| HTTP/1.1 | Persistent connections; text-based message format |
| HTTP/2 | Binary framing and multiplexed streams over TCP |
| HTTP/3 | QUIC over UDP |

**Serialization** converts data into a transferable/storable representation; **deserialization** reconstructs usable data. JSON is common, but uploads often use `multipart/form-data` and some payloads are binary.

---

## 10. One request: connect the topics

```text
Frontend / browser (client)
          │ HTTP request
          ▼
DNS + network transport (IP, TCP/UDP, TLS as applicable)
          │
          ▼
Node.js server process
          ├─ Express route / application logic (if used)
          ├─ JavaScript runs on the main JS thread
          ├─ Event loop coordinates asynchronous work
          └─ OS I/O / selected libuv worker-pool operations
          │
          ▼
Database, file or another service (only if the route needs it)
          │ result becomes ready
          ▼
JavaScript builds the response → HTTP response to client
```

This is a combined conceptual path, not a claim that every request uses every component shown.

## 11. Interview recall

1. **JavaScript vs. V8 vs. Node.js?** Language vs. engine vs. runtime.
2. **Program vs. process vs. thread?** Stored code vs. running instance vs. execution path.
3. **Concurrency vs. parallelism?** Overlapping progress vs. simultaneous execution.
4. **CPU-bound vs. I/O-bound?** Computation dominates vs. waiting dominates.
5. **Is Node.js single-threaded?** App JS normally runs on a main thread per isolate; the runtime also uses OS I/O, selected pool operations and optional workers/processes.
6. **What blocks the event loop?** Long synchronous JavaScript and blocking APIs.
7. **Does every async operation use libuv's pool?** No.
8. **Which phase runs `setImmediate()`?** Check.
9. **CommonJS vs. ESM?** `require/module.exports` vs. `import/export`.
10. **`process.cwd()` vs. `__dirname`?** Process working directory vs. CommonJS module directory.
11. **DNS vs. IP vs. port?** Name resolution vs. network address vs. transport endpoint.
12. **TCP vs. UDP?** Reliable ordered byte stream vs. datagrams without built-in delivery/order guarantee.
13. **Latency vs. throughput?** Time per operation vs. work per unit time.
14. **Cache hit vs. miss?** Found in cache vs. must be fetched/computed.
15. **PUT vs. PATCH?** Replace target representation vs. partial modification.
16. **401 vs. 403?** Missing/invalid authentication vs. not permitted.
17. **What is REST?** Architectural style commonly implemented with resource-oriented HTTP APIs and HTTP semantics.

## Final self-check

- [ ] Explain JavaScript, V8, Node.js and libuv.
- [ ] Distinguish process, thread, concurrency and parallelism.
- [ ] Explain I/O-bound vs. CPU-bound work and what blocks Node.js.
- [ ] Trace the event-loop phases and the Promise/nextTick dry run.
- [ ] Use and distinguish CommonJS and ES modules.
- [ ] Explain sync/async file I/O, Buffer/text and module-relative paths.
- [ ] Describe DNS, IP, TCP/UDP, ports and the browser-to-server flow.
- [ ] Distinguish latency, throughput, bandwidth, caching and scaling.
- [ ] Design a basic resource-oriented HTTP API and select suitable methods/status codes.

## Detailed lecture notes

1. [Node.js Runtime and V8](01-NodeJS-Runtime-and-V8.md)
2. [Processes, Threads and Concurrency](02-Processes-Threads-and-Concurrency.md)
3. [Node.js Threading Model](03-NodeJS-Threading-Model.md)
4. [libuv Event Loop and Microtasks](04-libuv-Event-Loop-and-Microtasks.md)
5. [Modules and npm](05-NodeJS-Modules-and-npm.md)
6. [File I/O, Paths and Rendering](06-File-IO-Paths-and-Rendering.md)
7. [Networking: DNS, TCP/IP and Ports](07-Networking-DNS-TCP-IP.md)
8. [Storage, Latency and Scaling](08-Storage-Latency-and-Scaling.md)
9. [HTTP, APIs and REST](09-HTTP-APIs-and-REST.md)
