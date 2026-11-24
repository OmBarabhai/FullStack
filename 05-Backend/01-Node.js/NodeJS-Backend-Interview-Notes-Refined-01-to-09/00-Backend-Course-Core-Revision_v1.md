# Backend Course — Core Conceptual Revision

> Covers the nine Node.js/backend lectures currently in this folder. Revise this file first; open the linked lecture when you need a fuller example or explanation.

## Course map

| # | Topic | Main idea |
|---|---|---|
| 01 | Node.js runtime and V8 | How JavaScript runs outside a browser |
| 02 | Processes, threads and concurrency | How the OS executes multiple tasks |
| 03 | Node.js threading model | I/O, CPU work and blocking |
| 04 | Event loop and microtasks | When callbacks execute |
| 05 | Modules and npm | How Node code is split and reused |
| 06 | File I/O and rendering | Files, paths, templates and rendering |
| 07 | Networking | How clients locate and communicate with servers |
| 08 | Storage and scaling | Latency, throughput, caching and capacity |
| 09 | HTTP, APIs and REST | How clients communicate with a backend |

---

## 1. Node.js, V8 and libuv

| Term | Meaning |
|---|---|
| JavaScript | The programming language |
| V8 | The engine that parses and executes JavaScript |
| Node.js | A runtime that embeds V8 and provides server-side APIs |
| libuv | Event-loop and asynchronous I/O infrastructure; worker pool for selected operations |
| Express | A web framework built on Node.js |

**Mental model:** JavaScript is the language → V8 executes it → Node.js provides runtime APIs → libuv helps coordinate asynchronous work.

### V8 execution — simplified

~~~text
JavaScript source
      ↓
Parsing / AST
      ↓
Ignition executes bytecode
      ↓
Frequently executed code may be optimized by TurboFan
      ↓
Optimized machine code
      ↓
De-optimization can happen if assumptions stop holding
~~~

- **AST:** structured representation of parsed source code.
- **Bytecode:** instructions executed by an interpreter such as Ignition.
- **Hot code:** frequently executed code that may be optimized.
- **Garbage collection:** reclaims memory held by objects that are no longer reachable.
- **Call stack:** tracks active function calls; excessive recursion can cause stack overflow.
- **Heap:** commonly holds dynamically allocated objects.

**Interview answer:** Node.js is a JavaScript runtime built around V8. V8 executes JavaScript; Node.js adds filesystem, process and networking APIs.

## 2. Program, process, thread and concurrency

- **Program:** code stored on disk, such as server.js.
- **Process:** a running instance of a program, managed by the operating system.
- **Thread:** an execution path inside a process. Threads normally share process memory but have their own execution state and stack.
- **Context switch:** the OS saves one execution context and restores another.
- **Race condition:** the result depends on timing when concurrent work accesses shared state without adequate coordination.

| Processes | Threads in one process |
|---|---|
| Separate address spaces | Share process memory/resources |
| Stronger isolation | Shared data needs synchronization |
| Often communicate through IPC | Can share data directly |
| Generally more overhead | Generally lighter, but still have overhead |

- **Concurrency:** tasks make progress over overlapping periods; they may take turns or wait.
- **Parallelism:** tasks execute at the same instant on separate execution resources.
- **CPU-bound:** computation dominates (heavy calculations, compression).
- **I/O-bound:** waiting dominates (database, network or file operations).

**Remember:** one CPU core can interleave tasks but does not execute them all at the exact same instant.

## 3. Node.js threading model

**Is Node.js single-threaded?**

Ordinary application JavaScript callbacks for a Node.js isolate generally run on its main JavaScript thread. The complete runtime also uses operating-system I/O facilities and a libuv worker pool for selected operations. Applications can create worker threads or child processes.

~~~text
JavaScript starts asynchronous I/O
                 ↓
       OS / runtime handles the wait
                 ↓
JavaScript thread can process other work
                 ↓
      I/O completion becomes ready
                 ↓
       Callback runs on JavaScript thread
~~~

| Mechanism | Main purpose |
|---|---|
| OS networking facilities | Commonly handle network socket I/O |
| libuv worker pool | Selected filesystem, crypto, compression and DNS lookup work |
| worker_threads | Additional JavaScript threads; useful for CPU-heavy JavaScript |
| Child process | Separate OS process with stronger isolation |

**Non-blocking does not mean instant.** It means the JavaScript thread does not wait synchronously for I/O to finish.

Long synchronous JavaScript, CPU-heavy loops and synchronous APIs block the main JavaScript thread. Not every asynchronous operation uses the libuv worker pool, and asynchronous does not automatically mean parallel.

## 4. Event loop and microtasks

The **event loop** coordinates when eligible callbacks can run. Callback JavaScript normally runs on the JavaScript thread.

| Phase | What to remember |
|---|---|
| Timers | Eligible setTimeout / setInterval callbacks |
| Pending callbacks | Certain deferred system/I/O callbacks |
| Idle / prepare | Internal libuv work |
| Poll | Processes I/O events; may wait for I/O |
| Check | setImmediate callbacks |
| Close callbacks | Some close-event callbacks |

- Promise handlers (then, catch, finally) run as microtasks.
- process.nextTick() uses Node’s next-tick queue.
- In common CommonJS contexts, next-tick callbacks are generally drained before Promise microtasks.
- These queues are not additional libuv phases.

### Dry run (CommonJS)

~~~js
console.log("A");
process.nextTick(() => console.log("nextTick"));
Promise.resolve().then(() => console.log("promise"));
console.log("B");
~~~

Output:

~~~text
A
B
nextTick
promise
~~~

Synchronous statements run first. Then, in this CommonJS context, Node drains the next-tick queue before Promise microtasks.

**Timer reminder:** setTimeout(fn, 0) is not immediate. setImmediate() runs in the Check phase. Their relative order at top level can vary; do not memorize a universal order.

## 5. Modules and npm

A **module** is a reusable unit of code. It separates responsibilities and exposes selected values.

### CommonJS

~~~js
// math.cjs
const add = (a, b) => a + b;
module.exports = { add };

// app.cjs
const { add } = require("./math.cjs");
~~~

### ES modules

~~~js
// math.js
export const add = (a, b) => a + b;

// app.js
import { add } from "./math.js";
~~~

| CommonJS | ES modules |
|---|---|
| require() | import |
| module.exports | export / export default |
| .cjs explicitly means CJS | .mjs explicitly means ESM |
| .js uses package scope rules | "type": "module" makes package-scope .js files ESM |

- exports initially refers to module.exports; reassigning exports alone does not replace module.exports.
- In ESM, __dirname is not directly available; use import.meta.url and path/URL utilities for module-relative paths.
- **npm** installs and manages packages.
- **package.json** stores project metadata, scripts and dependency declarations.
- **dependencies** are needed at runtime; **devDependencies** are mainly development/testing tools.

## 6. File I/O, paths and rendering

Node’s built-in fs module supports reading, writing, appending, deleting and watching files.

| API | Completion style |
|---|---|
| node:fs | Common callback-based APIs |
| node:fs/promises | Promise-based APIs used with async/await |

~~~js
import { readFile } from "node:fs/promises";
const text = await readFile(new URL("./data.txt", import.meta.url), "utf8");
~~~

- With "utf8", readFile returns text; without an encoding, it returns a Buffer (raw bytes).
- Synchronous file operations block the JavaScript thread.
- __dirname is the current CommonJS module directory.
- import.meta.url is the current ES module URL.
- process.cwd() is the process working directory; it can differ from the script directory.
- node:path helpers such as join() build filesystem paths.

A **template** contains reusable markup and placeholders. A template engine combines it with data to generate output (for example, EJS). Escape untrusted values; raw HTML insertion can cause **XSS**.

| CSR | SSR |
|---|---|
| Much of the UI is rendered/updated in the browser | Server generates HTML for the request |
| Client JavaScript builds/updates the page | Browser receives HTML and may then hydrate/run JavaScript |

Templating and SSR are related but not identical.

## 7. Networking: DNS, IP, TCP/UDP and ports

A **client** initiates a request. A **server** listens, processes work and responds. A backend service can also act as a client when it calls another service.

~~~text
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
~~~

A connection may be reused and DNS can be cached. HTTP/3 uses QUIC over UDP, not TCP.

| Term | Meaning |
|---|---|
| Domain | Human-readable name |
| DNS | Resolves names to records |
| IP address | Address used for IP communication |
| URL | Resource locator (scheme, host, path and possibly port) |
| Port | Transport endpoint identifier |
| Socket | Communication endpoint, commonly described by address, port and transport |

### Five-layer TCP/IP teaching model

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
| Common for HTTP/1.1 and HTTP/2 | Used by real-time apps and QUIC under HTTP/3 |

TCP handshake: **SYN → SYN-ACK → ACK**.

## 8. Storage, latency, throughput and scaling

| Term | Meaning |
|---|---|
| Latency | Time an operation/request takes |
| Throughput | Work completed per unit time |
| Bandwidth | Data-transfer capacity/rate |
| QPS | Queries or requests per second, depending on context |

~~~text
Average requests/second = Requests per day ÷ 86,400
~~~

This is an average, not a peak-load estimate. Latency can include network time, queueing, application work, storage access and response transfer.

Simplified storage hierarchy:

~~~text
CPU registers → CPU caches (L1/L2/L3) → RAM → SSD/HDD → remote storage
~~~

- **RAM** is volatile working memory.
- **SSD/HDD** are persistent secondary storage.
- **Sequential access** reads nearby/ordered data; **random access** jumps among locations. Random seeks are especially costly on mechanical HDDs.

A **cache** stores data in a faster place to reduce repeated work/access time.
- **Hit:** requested item is in cache.
- **Miss:** item must be fetched/computed elsewhere.
- **TTL:** configured expiry time.
- **Invalidation:** removing or refreshing stale data.

Caching reduces repeated work but adds data-freshness and invalidation concerns.

- **Vertical scaling:** add resources to one machine.
- **Horizontal scaling:** add machines/instances and distribute work.

Adding instances does not fix every bottleneck; a slow query, overloaded database, network dependency or inefficient algorithm may remain the limit. Measure first.

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

REST-style resource endpoints:

~~~text
GET    /api/todos       List todos
GET    /api/todos/42    Get todo 42
POST   /api/todos       Create a todo
PATCH  /api/todos/42    Update selected fields
DELETE /api/todos/42    Delete a todo
~~~

REST is an architectural style. A RESTful HTTP API commonly models resources in URLs and uses HTTP method semantics. JSON alone does not make an API fully RESTful.

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

**Serialization** converts data into a transferable/storable representation; **deserialization** reconstructs usable data.

---

## 10. One backend request — connect the lectures

~~~text
Frontend / browser (client)
          │ HTTP request
          ▼
DNS + network transport (IP, TCP/UDP, TLS as applicable)
          │
          ▼
Node.js server process
          ├─ Express route / application logic (if used)
          ├─ JavaScript runs on main JS thread
          ├─ Event loop coordinates asynchronous work
          └─ OS I/O / selected libuv worker-pool operations
          │
          ▼
Database, file or another service (only if required)
          │ result becomes ready
          ▼
JavaScript builds response → HTTP response to client
~~~

This is a combined conceptual path; not every request uses every component.

## 11. Quick interview recall

1. **JavaScript vs. V8 vs. Node.js?** Language vs. engine vs. runtime.
2. **Program vs. process vs. thread?** Stored code vs. running instance vs. execution path.
3. **Concurrency vs. parallelism?** Overlapping progress vs. simultaneous execution.
4. **CPU-bound vs. I/O-bound?** Computation dominates vs. waiting dominates.
5. **Is Node.js single-threaded?** App JS normally runs on a main thread per isolate; the runtime also uses OS I/O, selected pool operations and optional workers/processes.
6. **What blocks the event loop?** Long synchronous JavaScript and blocking APIs.
7. **Does every async operation use libuv’s pool?** No.
8. **Which phase runs setImmediate()?** Check.
9. **CommonJS vs. ESM?** require/module.exports vs. import/export.
10. **process.cwd() vs. __dirname?** Process working directory vs. CommonJS module directory.
11. **DNS vs. IP vs. port?** Name resolution vs. network address vs. transport endpoint.
12. **TCP vs. UDP?** Reliable ordered byte stream vs. datagrams without built-in delivery/order guarantee.
13. **Latency vs. throughput?** Time per operation vs. work per unit time.
14. **Cache hit vs. miss?** Found in cache vs. must be fetched/computed.
15. **PUT vs. PATCH?** Replace target representation vs. partial modification.
16. **401 vs. 403?** Missing/invalid authentication vs. not permitted.
17. **What is REST?** Architectural style commonly implemented with resource-oriented HTTP APIs and HTTP semantics.

## Self-check

- [ ] Explain JavaScript, V8, Node.js and libuv.
- [ ] Distinguish process, thread, concurrency and parallelism.
- [ ] Explain what blocks the Node.js main JavaScript thread.
- [ ] Trace event-loop phases and the Promise/nextTick dry run.
- [ ] Distinguish CommonJS and ES modules.
- [ ] Explain sync/async file I/O, Buffer/text and module-relative paths.
- [ ] Describe DNS, IP, TCP/UDP, ports and browser-to-server flow.
- [ ] Distinguish latency, throughput, bandwidth, caching and scaling.
- [ ] Design a simple resource-oriented HTTP API and choose methods/status codes.

## Detailed lecture notes

1. [01 — Node.js Runtime and V8](01-NodeJS-Runtime-and-V8.md)
2. [02 — Processes, Threads and Concurrency](02-Processes-Threads-and-Concurrency.md)
3. [03 — Node.js Threading Model](03-NodeJS-Threading-Model.md)
4. [04 — libuv Event Loop and Microtasks](04-libuv-Event-Loop-and-Microtasks.md)
5. [05 — Modules and npm](05-NodeJS-Modules-and-npm.md)
6. [06 — File I/O, Paths and Rendering](06-File-IO-Paths-and-Rendering.md)
7. [07 — Networking: DNS, TCP/IP and Ports](07-Networking-DNS-TCP-IP.md)
8. [08 — Storage, Latency and Scaling](08-Storage-Latency-and-Scaling.md)
9. [09 — HTTP, APIs and REST](09-HTTP-APIs-and-REST.md)
