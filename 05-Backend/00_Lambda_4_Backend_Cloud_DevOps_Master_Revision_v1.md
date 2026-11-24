# Lambda 4.0 — Backend, Cloud & DevOps Master Revision

> One consolidated revision guide for Lambda 4.0. It combines the original Node.js lecture material, project-backed learning and the public course outline. The existing nine Node.js chapter notes remain as deeper references; this is the central course revision, not a new file per lecture.

## Course source

**AlgoCamp — Lambda 4.0: Ultimate Backend, Cloud & DevOps**  
**Instructor:** Sanket Singh

- Course page: https://courses.algocamp.io/learn/backend-development-in-node
- Public launch: https://www.youtube.com/watch?v=P1xzd308WaY
- Course details/final-call video: https://www.youtube.com/watch?v=x4Kl3r3m8zw
- Expanded public syllabus mirror (secondary): https://sjeexplore.in/topic/1843-sanket-singh-lambda-40-ultimate-backend-cloud-devops-course/

The public outline covers Node.js, TypeScript, Express, REST, gRPC, GraphQL, architecture, MySQL/MongoDB, indexing, replication/sharding, authentication, Redis, AWS, Docker, DevOps, messaging and testing. The secondary syllabus mirror adds detail such as Go, Zod, tRPC, BullMQ, Kubernetes and Prometheus/Grafana. The official course page did not expose a complete lesson-by-lesson syllabus to this audit.

**Coverage labels**
- **Lecture-backed:** matching lecture note and/or original transcript exists.
- **Project-backed:** concept appears in Todo, Comsy or NexusMeet material.
- **Syllabus revision:** named in the public/expanded outline, but a complete matching transcript was not found. This is a concise learning reference, not a reconstruction of the instructor's full lecture.
- **Cross-reference:** detailed notes exist elsewhere in your repository; use them instead of duplicating them.

## Course map

1. Node.js runtime, V8, libuv, event loop, modules, filesystem and networking.
2. TypeScript, OOP, Express, REST, GraphQL, gRPC and application architecture.
3. MySQL, MongoDB, Mongoose, indexes, transactions and distributed data.
4. Authentication, authorization, file uploads, WebSockets and caching.
5. System design, queues, AWS, Docker, Kubernetes, CI/CD, testing and observability.

---

# 1. Backend request lifecycle

A backend receives a request, executes application logic, may access a database/file/other service and returns a response.

~~~text
Client
  ↓ HTTP request
Node.js process
  ↓
Express middleware and route
  ↓
Controller / service
  ↓
Database or external service (if needed)
  ↓
HTTP response to client
~~~

A client initiates a request. A server accepts and processes it, then returns a response. A backend can act as a client when it calls a database or another service.

# 2. Node.js runtime and internals

**Lecture-backed — Lectures 01–04.**

## 2.1 JavaScript, V8, Node.js and libuv

| Term | Responsibility |
|---|---|
| JavaScript | Programming language |
| V8 | Engine that parses and executes JavaScript |
| Node.js | Runtime embedding V8 and providing server-side APIs |
| libuv | Event-loop, OS I/O integration and worker pool for selected operations |
| Express | Web framework built on Node.js |

~~~text
Application JavaScript
       |
       v
Node.js runtime
  |-- V8: executes JavaScript
  |-- Node APIs: HTTP, filesystem, process, networking
  |-- libuv: event loop and asynchronous I/O
  +-- Operating system: low-level resource and I/O work
~~~

V8 execution, simplified:
1. Parsing checks syntax and builds an AST.
2. Ignition interprets bytecode.
3. Runtime feedback is collected.
4. TurboFan may optimize frequently executed code.
5. Optimized code may be de-optimized if assumptions stop holding.

- **AST:** structured representation of source code.
- **Bytecode:** lower-level instructions executed by an interpreter.
- **JIT:** compilation/optimization during execution.
- **Garbage collection:** reclaims memory for objects no longer reachable.

### Memory

- **Call stack:** tracks active function calls; deep recursion can overflow it.
- **Heap:** commonly stores dynamically allocated objects.
- **Memory leak:** data remains referenced after the application no longer needs it.

The engine can optimize value representation/storage. Do not assume every JavaScript variable always has one fixed physical location.

## 2.2 Program, process, thread and concurrency

| Term | Meaning |
|---|---|
| Program | Code stored on disk |
| Process | Running instance of a program, managed by the OS |
| Thread | Execution path within a process |
| Context switch | OS saves one execution context and restores another |
| Race condition | Result depends on timing/order of concurrent access to shared state |

Threads in one process normally share process memory/resources but have their own execution state and stack.

- **Concurrency:** tasks make progress during overlapping periods; they may take turns or wait.
- **Parallelism:** tasks execute at the same instant on separate execution resources.
- **CPU-bound:** computation dominates.
- **I/O-bound:** waiting for network/database/file work dominates.

One CPU core can interleave tasks but cannot execute them all at the same instant.

## 2.3 Is Node.js single-threaded?

A precise answer:

> Ordinary application JavaScript callbacks for a Node.js isolate generally run on its main JavaScript thread. The complete runtime also uses OS I/O facilities, a libuv worker pool for selected operations, and optional worker threads or child processes.

| Work | Typical mechanism |
|---|---|
| Network socket I/O | OS asynchronous/event-notification facilities |
| Many filesystem operations | Often libuv worker pool |
| Selected crypto/compression/DNS lookup operations | Often libuv worker pool |
| Long CPU-heavy JavaScript on main thread | Blocks that JavaScript thread |
| CPU-heavy JavaScript moved to Worker | Additional JavaScript thread |
| Separate isolated work | Child process |

~~~text
JS starts asynchronous I/O
          |
          v
OS/runtime handles waiting
          |
          v
JS thread processes other work
          |
          v
I/O completion becomes ready
          |
          v
Callback runs on JS thread
~~~

**Non-blocking does not mean instant.** The operation still takes time; JavaScript simply does not wait synchronously. Not every asynchronous operation uses the libuv worker pool. Network sockets commonly use OS I/O mechanisms rather than one worker-pool thread per connection.

## 2.4 Event loop and microtasks

| Phase | Main purpose |
|---|---|
| Timers | Eligible setTimeout/setInterval callbacks |
| Pending callbacks | Certain deferred system/I/O callbacks |
| Idle/prepare | Internal libuv work |
| Poll | Processes I/O events; may wait for I/O |
| Check | setImmediate callbacks |
| Close callbacks | Some close-event callbacks |

- Promise handlers run as microtasks.
- process.nextTick() uses Node's next-tick queue.
- In common CommonJS contexts, next-tick callbacks are generally drained before Promise microtasks.
- These queues are not additional libuv phases.

Dry run (CommonJS):

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

Synchronous work runs first. In this CommonJS context, Node drains the next-tick queue before Promise microtasks.

setTimeout(fn, 0) is not immediate. setImmediate runs in the Check phase. Their top-level relative order can vary by context/runtime state.

**Event-loop blockers:** long synchronous JavaScript, CPU-heavy loops and synchronous APIs.


# 3. Node.js modules, npm and file I/O

**Lecture-backed — Lectures 05–06.**

## 3.1 CommonJS, ESM and npm

A module is a reusable unit of code. It separates responsibilities and exposes values other files need.

CommonJS:

~~~js
// math.cjs
const add = (a, b) => a + b;
module.exports = { add };

// app.cjs
const { add } = require("./math.cjs");
~~~

ES modules:

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
| .js follows package-scope rules | "type": "module" makes package-scope .js files ESM |

- exports initially refers to module.exports; reassigning exports alone does not replace module.exports.
- **npm** installs and manages packages.
- **package.json** stores metadata, scripts and dependency declarations.
- **package-lock.json** records the resolved dependency tree.
- **dependencies** are needed at runtime; **devDependencies** are mainly development/testing tools.

~~~bash
npm init -y
npm install express
npm install --save-dev nodemon
npm run dev
~~~

## 3.2 File-system APIs

Node's built-in filesystem module supports reading, writing, appending, deleting and watching files.

| API | Completion style |
|---|---|
| node:fs | Common callback APIs |
| node:fs/promises | Promise APIs used with async/await |

~~~js
import { readFile } from "node:fs/promises";

const text = await readFile(
  new URL("./data.txt", import.meta.url),
  "utf8"
);
~~~

- With "utf8", readFile returns text.
- Without an encoding, it returns a Buffer (raw bytes).
- Synchronous file operations block the JavaScript thread.
- Async I/O lets JavaScript do other work while the file operation is pending.

## 3.3 CommonJS and ESM path handling

Lecture 06 demonstrates that __dirname is available in CommonJS module scope but is not directly available in ES modules.

| Expression | Meaning |
|---|---|
| __dirname | Current CommonJS module directory |
| import.meta.url | Current ES module URL |
| process.cwd() | Process working directory; may differ from script directory |
| node:path helpers | Build filesystem paths |

A path can be:
- **Absolute:** full path from a filesystem root.
- **Relative:** path interpreted from a base/current directory.

For ESM, new URL("./file.html", import.meta.url) locates a file relative to the module. Do not assume process.cwd() equals the directory containing the script.

### Top-level await

ES modules support top-level await. In CommonJS, place await inside an async function. Module format changes which syntax and module variables are available.

## 3.4 Templates, CSR and SSR

A **template** contains reusable markup/placeholders. A template engine combines it with data to generate output, often HTML. Examples include EJS and Handlebars.

- Escape untrusted values; inserting raw HTML can create XSS.
- **CSR:** much of the UI is rendered/updated in the browser.
- **SSR:** server generates HTML for the request; client JavaScript may hydrate/run afterwards.
- Templating and SSR are related but not identical. Writing an HTML file is not automatically a complete SSR request.

## 3.5 Backend engineering priorities from Lecture 06

The instructor's discussion names **databases, networking and scaling** as the first backend engineering foundations, before the technology stack. The practical order is:

1. Design data/storage properly.
2. Understand how machines communicate over networks.
3. Understand how to scale without failures/data loss.
4. Then choose the language/framework that fits the workload and team.

The lecture uses monoliths and different language stacks to emphasize that architecture/data/networking decisions often matter more than choosing a fashionable language prematurely.

# 4. Networking and web request flow

**Lecture-backed — Lecture 07.**

## 4.1 Client, server and IP

- A **client** is a process capable of raising a request.
- A **server** is a process/machine capable of accepting a request, processing it and returning a response.
- A machine is addressed on an IP network using an IP address.
- A URL is human-friendly and identifies a resource; it is not the same as an IP address.
- IP addresses may be static or dynamic. In AWS, a stable public IPv4 address can be provided using an Elastic IP.

## 4.2 DNS resolution

When a user enters a domain such as www.example.com, the client needs an IP address to contact.

~~~text
Client enters URL
      |
      v
Check available local/browser/OS DNS cache
      |
      v
Ask configured DNS resolver if needed
      |
      v
DNS returns address record(s)
      |
      v
Client connects to destination IP
~~~

The lecture explains:
- The client and server need IP addresses for network communication.
- The client typically asks a configured DNS resolver for the address corresponding to the domain.
- DNS is itself a server system.
- DNS answers can be cached to avoid repeated lookups.
- DNS is hierarchical (root, top-level domains and authoritative records).
- Domain registrars manage DNS records/updates; changes may take time to propagate.
- Not every company runs its own DNS infrastructure.

The transcript gives Google Public DNS 8.8.8.8 as an example. Treat IP examples as illustrative, not as a value to hard-code in an application.

## 4.3 Protocols and layers

A **protocol** is a set of rules for communication. Network protocols define how messages are formatted, addressed, transmitted and interpreted.

~~~text
URL parsing
   |
   v
DNS resolution (if cache does not have answer)
   |
   v
Connect to destination IP + port
   |
   v
Transport protocol (TCP for conventional HTTP/1.1 or HTTP/2)
   |
   v
TLS for HTTPS
   |
   v
HTTP request → server handles request → HTTP response
~~~

This is a conceptual path; connections and DNS answers can be reused. HTTP/3 uses QUIC over UDP.

### TCP vs UDP

| TCP | UDP |
|---|---|
| Reliable, ordered byte stream | Datagrams without built-in delivery/order guarantee |
| Retransmission, flow and congestion control | No built-in retransmission/ordering |
| Used for HTTP/1.1 and HTTP/2 in common deployments | Used by real-time systems and QUIC under HTTP/3 |

TCP three-way handshake:

~~~text
Client  ---- SYN ---->   Server
Client  <-- SYN-ACK --   Server
Client  ---- ACK ---->   Server
Connection established
~~~

## 4.4 Web server vs application server vs database server

The lecture introduces different server responsibilities:

| Server role | Main responsibility |
|---|---|
| Web server | Handles HTTP and commonly serves static HTML/CSS/JS/assets |
| Application server | Executes dynamic business logic and produces data/responses |
| Database server | Stores and queries persistent data |

Modern products can overlap in capabilities; the distinction is about responsibilities, not an absolute rule that one machine performs only one role.

Static content is mostly pre-existing assets. Dynamic content depends on data/business logic (for example, a personalized profile or account balance).

## 4.5 Load balancing and separation of concerns

The live lesson introduces load balancing as a way to handle more traffic and mentions a backup load balancer.

- One server can become overloaded or fail.
- A load balancer distributes requests among healthy servers.
- Health checking/failover improves availability.
- Multiple servers should not rely on isolated in-memory state if requests can reach any instance.

The advanced L4/L7 comparison appears later as syllabus revision; Lecture 07 introduces the problem at a high level.

