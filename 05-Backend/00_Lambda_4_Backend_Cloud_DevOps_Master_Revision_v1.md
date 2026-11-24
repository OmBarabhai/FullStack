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


# 5. TypeScript, OOP and code design

**Syllabus revision — no complete TypeScript/OOP lecture transcript found in the audited library.**

## 5.1 TypeScript essentials

TypeScript adds static type checking to JavaScript development. Types are erased at runtime, so incoming HTTP JSON still needs runtime validation.

~~~ts
type Todo = {
  id: string;
  title: string;
  completed: boolean;
};

function markComplete(todo: Todo): Todo {
  return { ...todo, completed: true };
}
~~~

| Feature | Purpose |
|---|---|
| type alias | Name or compose a type |
| interface | Describe an object contract |
| union | Allow one of several types |
| generic | Reuse logic while preserving input/output types |
| utility type | Derive a type from another type |
| mapped type | Transform object properties |

Useful utility types:
- Partial<T>: make properties optional.
- Pick<T, K>: select properties.
- Omit<T, K>: exclude properties.
- Readonly<T>: readonly properties at type level.
- Record<K, V>: keyed object with values of type V.

~~~ts
function first<T>(items: T[]): T | undefined {
  return items[0];
}
~~~

The generic T keeps the output type connected to the input array's element type.

## 5.2 OOP and SOLID

- **Encapsulation:** keep state and behaviour together and control access.
- **Abstraction:** expose required behaviour while hiding implementation details.
- **Inheritance:** derive a type from a base type; use for a genuine is-a relationship.
- **Polymorphism:** different implementations share a contract.
- **Composition:** combine collaborators; often easier to evolve than deep inheritance.

| Principle | Meaning |
|---|---|
| Single Responsibility | One coherent reason for a module to change |
| Open/Closed | Extend behaviour without repeatedly changing stable core code |
| Liskov Substitution | A subtype should honour the base contract |
| Interface Segregation | Prefer focused interfaces over large interfaces |
| Dependency Inversion | High-level policy should depend on abstractions |

## 5.3 Design patterns

| Pattern | Core idea | Backend example |
|---|---|---|
| Singleton | One shared instance in a defined scope | Shared configuration/client |
| Factory | Centralize object creation | Choose payment provider |
| Builder | Construct complex objects step by step | Build query/configuration |
| Facade | Simplify a complex subsystem | One storage interface over providers |
| Strategy | Swap behaviour behind a contract | Pricing/retry policy |
| Observer | Notify subscribers about events | Domain event subscribers |
| Adapter | Convert one interface to another | Wrap third-party API |

Patterns are reusable design ideas, not a requirement to create classes for every feature.

## 5.4 Go overview

**Extended syllabus revision.** Keep JavaScript/TypeScript as the primary backend track unless Go exercises are required.

Go is statically typed and compiled. It uses goroutines for concurrent execution, channels for communication, and mutexes for shared-state coordination. The net/http package provides HTTP server/client primitives. Use context for cancellation/deadlines. Do not confuse Go goroutines with Node's event loop or libuv worker pool.

# 6. Express and API engineering

**Project-backed for Todo CRUD; lecture-backed for HTTP/REST.**

## 6.1 Express request lifecycle

~~~text
HTTP request
    ↓
Middleware (registration order)
    ↓
Router matches method + path
    ↓
Controller / route handler
    ↓
Service and database (when needed)
    ↓
HTTP response
~~~

Essential Express concepts:
- express() creates the application.
- app.use() registers middleware.
- Router groups related routes.
- req.body contains parsed body data when a parser is installed.
- req.params contains named path values such as /todos/:id.
- req.query contains URL query-string values.
- req.headers contains request metadata.
- res.status(), res.json() and res.send() build a response.
- next() passes control to later middleware; errors should reach error handling.

express.json() parses JSON. It does not validate fields, types or business rules. Middleware order matters.

## 6.2 Middleware, controller, service and repository

| Layer | Responsibility |
|---|---|
| Route | Maps method/path to handler |
| Controller | Reads HTTP input, calls service and builds response |
| Service | Applies business rules/workflow |
| Repository | Performs database reads/writes |
| Model/schema | Describes data and persistence rules |
| Middleware | Shared auth, validation, logging or error handling |

A single index.js is fine for a small exercise. Split code when it improves clarity and testability, not just to imitate a big application.

## 6.3 REST and HTTP methods

REST is an architectural style. Resource-oriented HTTP APIs commonly use nouns in URLs and HTTP method semantics.

| Method | Intent | Safe? | Idempotent? |
|---|---|---:|---:|
| GET | Retrieve | Yes | Yes |
| POST | Submit/create/process | No | Usually no |
| PUT | Replace target representation | No | Intended yes |
| PATCH | Partial modification | No | Depends on operation |
| DELETE | Remove | No | Intended yes |

- **Safe:** intended effect is read-only.
- **Idempotent:** repeating the same request has the same intended effect.

~~~text
GET    /api/v1/todos
GET    /api/v1/todos/:id
POST   /api/v1/todos
PATCH  /api/v1/todos/:id
DELETE /api/v1/todos/:id
~~~

Status codes:

| Code | Meaning |
|---|---|
| 200 | Successful request with response |
| 201 | Resource created |
| 204 | Success with no response body |
| 400 | Invalid/missing input |
| 401 | Missing/invalid authentication |
| 403 | Request is not permitted |
| 404 | Resource/route not found |
| 409 | Conflict with current state |
| 422 | Syntactically valid but semantically invalid (API convention) |
| 429 | Too many requests |
| 500 | Unexpected server error |
| 503 | Temporarily unavailable |

A REST-style API needs more than JSON: resource semantics, suitable methods/status codes, consistent representations and stateless request handling matter.

## 6.4 API styles

| Style | Main idea | Typical fit |
|---|---|---|
| REST | Resource-oriented HTTP endpoints | Public APIs and CRUD |
| GraphQL | Client selects fields through a typed schema | Clients need different response shapes |
| gRPC | Typed RPC, commonly Protocol Buffers over HTTP/2 | Service-to-service communication and streaming |
| tRPC | TypeScript-first typed procedures | TypeScript-aligned client/server applications |

GraphQL:
- Schema defines types, queries and mutations.
- Resolver implements field retrieval.
- N+1 query issue can occur; batching can help.
- Authorization still needs to be enforced.

gRPC:
- Define messages/services in .proto files.
- Generate typed client/server code.
- Supports unary and streaming RPC.
- Use for typed service contracts and service-to-service communication.

tRPC:
- Server exposes typed procedures.
- Client types can be inferred from server definitions.
- It is TypeScript-aligned; it is not the same protocol style as REST.

## 6.5 MVC, monolith, microservices and monorepo

- **MVC:** separates model/data, view/presentation and controller/request coordination.
- **Modular monolith:** one deployable application with clear internal modules.
- **Microservices:** independently deployable services aligned to business boundaries.
- **Monorepo:** one repository containing multiple apps/packages; not an application architecture.
- **Polyrepo:** separate repositories.

| Monolith | Microservices |
|---|---|
| Simpler deployment and local calls | Independent deployment/scaling |
| Easier initial transactions/debugging | Network failures and distributed consistency |
| Shared release/runtime | More operational and monitoring overhead |

Start with a modular monolith unless a real requirement justifies service separation.

## 6.6 Zod and runtime validation

**Syllabus revision.** TypeScript types do not validate untrusted JSON at runtime.

~~~ts
import { z } from "zod";

const createTodoSchema = z.object({
  title: z.string().trim().min(1).max(200),
  completed: z.boolean().optional()
});

const parsed = createTodoSchema.safeParse(req.body);

if (!parsed.success) {
  return res.status(400).json({ error: parsed.error.flatten() });
}

// Use parsed.data only after successful validation.
~~~

Validate type, length, format, allowed fields, missing vs null and query parameters. Validation is not authorization or database integrity.

## 6.7 Idempotent APIs and retries

A retry may cause the same create/payment/booking request to arrive more than once.

An idempotency-key design:
1. Client creates a key for one logical operation.
2. Server stores key, caller/scope and operation result/state.
3. Repeated requests with the same key return the prior result.
4. Concurrent duplicates need atomic uniqueness/locking rules.
5. Key retention is defined.

Useful for payments, bookings, orders and job submissions. A disabled frontend button is not a correctness guarantee.


# 7. Databases and data engineering

**Project-backed for MongoDB/Mongoose; syllabus revision for advanced database topics.**

## 7.1 SQL vs NoSQL

| Relational SQL | Document NoSQL |
|---|---|
| Tables, rows, columns and relationships | Collections and documents |
| Schema and constraints | Flexible document shape; validate in application/schema |
| Joins and relational constraints | Embed/reference by access pattern |
| Good for relational/transactional data | Good for document/aggregate access patterns |

Choose based on relationships, query patterns, transactions and consistency—not because one is always faster.

## 7.2 MySQL and relational modelling

- Database contains tables.
- Row is one record; column is one attribute.
- Primary key uniquely identifies a row.
- Foreign key enforces relationship.
- Unique constraint prevents duplicates.
- NOT NULL prevents missing values.
- JOIN combines related tables.
- Indexes accelerate selected query patterns.

Normalization:
- **1NF:** atomic values; avoid repeating groups.
- **2NF:** 1NF plus non-key attributes depend on the whole candidate key.
- **3NF:** 2NF plus no transitive dependency of non-key attributes on the key.

Normalization reduces duplication/update anomalies. Denormalization can be justified for measured read performance but adds consistency work.

## 7.3 MongoDB and Mongoose

| Term | Meaning |
|---|---|
| Database | Contains collections |
| Collection | Group of documents |
| Document | BSON record with fields, nested objects and arrays |
| _id | Unique document identifier |
| Schema | Mongoose structure, field types and validation |
| Model | Mongoose object compiled from schema, used for queries/writes |
| Document | Mongoose instance representing a record |
| Populate | Resolves configured references; not the same as SQL JOIN |

Typical Mongoose operations:
- Create: Model.create()
- Read: Model.find(), findOne(), findById()
- Update: updateOne(), findByIdAndUpdate()
- Delete: deleteOne(), findByIdAndDelete()

Comsy project notes identify MongoDB/Mongoose for users, labs/computers, bookings, issue reports and attendance. The Todo system-design exercise uses PostgreSQL as an illustrative alternative; that does not mean Comsy used PostgreSQL.

### Embed vs reference

- **Embed** related bounded data read/updated together.
- **Reference** shared/independently managed or unbounded data.
- Consider update frequency, growth and query patterns.

## 7.4 Indexes and query planning

An index helps the database find matching rows/documents without scanning everything.

- Index fields frequently used for filters, joins and sorting.
- Composite index field order matters.
- Unique indexes enforce uniqueness.
- Indexes consume storage and add work to writes.
- Too many indexes increase write/maintenance costs.
- Use EXPLAIN/query-plan tools; do not guess.

Query tuning:
1. Identify slow endpoint/query.
2. Inspect filters and sort order.
3. Check query plan and rows examined.
4. Add/adjust an index for a real workload.
5. Re-measure reads and writes.

## 7.5 Aggregation pipeline

~~~text
Collection
  ↓ $match     filter documents early
  ↓ $project   select/reshape fields
  ↓ $group     aggregate by key
  ↓ $sort      order results
  ↓ $limit     bound output
Result
~~~

Other stages: $unwind expands arrays; $lookup joins collections; $addFields derives fields; $count counts results. Watch document count and array expansion.

## 7.6 Transactions, ACID and isolation

| ACID | Meaning |
|---|---|
| Atomicity | All required changes commit or roll back |
| Consistency | Constraints/invariants hold before and after |
| Isolation | Concurrent transactions are controlled |
| Durability | Committed data survives failures according to database guarantees |

Common anomalies:
- **Dirty read:** read another transaction's uncommitted data.
- **Non-repeatable read:** repeated row read sees a different committed value.
- **Phantom read:** repeated predicate query sees a changed set.
- **Lost update:** concurrent writes overwrite one another.

Isolation levels trade concurrency against anomaly prevention; exact guarantees vary by database.

**Optimistic concurrency:** assume conflicts are uncommon; use version/conditional update and reject/retry if changed.

**Pessimistic concurrency:** lock relevant data before modifying it.

Prefer atomic conditional updates where possible. A read-then-write sequence may race.

Booking example: two users attempt the same room/time. Protect availability at the database/transaction boundary, not only in the UI.

## 7.7 Partitioning, replication and sharding

| Technique | What it does | Why |
|---|---|---|
| Partitioning | Splits one logical table/collection into smaller parts | Manage large data and prune query scope |
| Replication | Copies data to multiple nodes | Availability/read capacity |
| Sharding | Distributes partitions across database nodes | Horizontal capacity/storage/write scale |

- Async replication can have lag.
- Replicas improve reads only when consistency semantics are acceptable.
- Replication is not backup; deletions/corruption can replicate.
- Poor shard keys create hot spots/uneven distribution.
- Cross-shard reads/transactions are more complex.

## 7.8 ORM/ODM and recovery

- **ORM:** maps relational data to application objects (Prisma).
- **ODM:** maps document data to application objects/schema abstractions (Mongoose).
- Inspect generated queries in performance-sensitive code.
- A backup is useful only if it can be restored.
- **RPO:** acceptable data-loss window.
- **RTO:** acceptable recovery time.
- Define backup schedule, retention, encryption, access and restore drills.


# 8. Authentication and security

**Project-backed at high level in Comsy/NexusMeet; full session/OAuth lecture not found.**

## 8.1 Authentication vs authorization

- **Authentication:** who is making the request?
- **Authorization:** what may that identity do?

### Password storage

Never store plaintext passwords. Use a password-specific hashing algorithm such as bcrypt or Argon2 with salt and suitable work factor. Hashing is not encryption.

### Session authentication

~~~text
User logs in
    ↓
Server creates session record
    ↓
Browser receives session ID cookie
    ↓
Browser sends cookie on later requests
    ↓
Server resolves session → identity
~~~

Server-side revocation is straightforward, but multiple app instances need shared session storage.

### JWT authentication

A JWT commonly has header, payload and signature. Its payload is encoded, not encrypted by default; never put secrets in it.

~~~text
Credentials
   ↓
Server verifies password
   ↓
Issues short-lived access token
   ↓
Client sends Authorization: Bearer token
   ↓
Middleware verifies signature, expiry and claims
   ↓
Request continues with identity
~~~

- Validate signature, expiry, issuer, audience and allowed algorithm.
- Keep access tokens short-lived.
- Refresh tokens need secure storage, rotation and revocation strategy.
- A valid token proves identity/claims, not permission to every resource.
- Cookie-based authentication requires CSRF consideration.

### OAuth 2.0 and OpenID Connect

OAuth 2.0 is an authorization framework for delegated access. OpenID Connect adds an identity/authentication layer. OAuth is not simply another name for password login.

### RBAC

Role-based access control groups permissions into roles (admin, faculty, student). Check permissions on every protected server action. Hiding frontend buttons is not authorization.

## 8.2 Web security essentials

- HTTPS/TLS in transit.
- Validate every untrusted input boundary.
- Escape/encode output to prevent XSS.
- Protect cookie-authenticated browser actions against CSRF.
- Use parameterized queries/safe database APIs to prevent injection.
- Enforce object ownership and role checks on the server.
- Rate-limit sensitive endpoints such as login.
- Limit request and file sizes.
- Keep secrets outside Git.
- Avoid logging passwords, tokens and unnecessary personal data.

# 9. Real-time systems, uploads and caching

## 9.1 WebSocket, Socket.IO and SSE

**Project-backed for Socket.IO/WebSocket; detailed comparison is syllabus revision.**

| Technology | Model |
|---|---|
| HTTP | Request then response |
| WebSocket | Persistent bidirectional connection |
| Socket.IO | Higher-level real-time event library with rooms/reconnection; not identical to raw WebSocket |
| SSE | Server pushes events over HTTP; client-to-server actions generally use HTTP |

- **Event:** named message such as issueCreated or userJoined.
- **Room:** group of sockets for targeted broadcast.
- **Namespace:** separates logical channels.
- **Acknowledgement:** optional confirmation callback.
- **Presence:** tracks active connections; reconnects and multiple devices complicate it.

Security/scale:
- Authenticate the connection and authorize sensitive events.
- Broadcast only to intended rooms/users.
- Multi-instance deployments need a shared adapter/pub-sub so broadcasts reach sockets on other instances.
- Persist critical messages; socket delivery is not durable storage.

WebRTC handles media transport. Socket.IO is commonly used for signaling/control, not as media transport.

## 9.2 File uploads, Multer and S3

**Syllabus revision.**

~~~text
Client chooses file
      ↓ multipart/form-data
Express upload middleware parses file
      ↓
Validate size/type/ownership
      ↓
Store object in S3 (or stream directly)
      ↓
Save object key + metadata in database
      ↓
Return safe reference / URL
~~~

- **Multer:** parses multipart/form-data in Express.
- **S3:** object storage for file bytes.
- **Presigned URL:** time-limited permission for a specific upload/download operation.
- Direct-to-S3 avoids routing large file bytes through the application server, but the server must authorize and verify completion.

Security:
- Enforce size and allowed format.
- Don't trust client filename or Content-Type alone.
- Generate object keys server-side.
- Keep buckets private by default.
- Authorize downloads.
- Avoid storing large file bytes in ordinary DB rows without a reason.

## 9.3 Redis and caching

**Syllabus revision.** Redis is an in-memory data store with strings, hashes, lists, sets, sorted sets and streams.

Common uses: cache frequently accessed values; session/short-lived state; rate-limit counters; queue/job coordination; geospatial lookup.

### Cache-aside

~~~text
Request
  ↓
Check cache
  |-- hit --> return cached value
  |
  +-- miss --> query database
                 ↓
               store with TTL
                 ↓
               return value
~~~

- **Hit:** data found in cache.
- **Miss:** data must be fetched/computed.
- **TTL:** entry expiry.
- **Invalidation:** remove/refresh stale data.
- **Cache stampede:** many requests miss a hot key and overload the source.

Caching reduces repeated work but adds freshness, memory and invalidation concerns. The database normally remains source of truth.

## 9.4 BullMQ and background jobs

~~~text
API request
   ↓
Validate + persist main state
   ↓
Enqueue job
   ↓
Return response
   ↓
Worker processes later
   ↓
Success / retry / dead-letter handling
~~~

Use jobs for email, notifications, media transcoding and slow non-interactive work. Workers need idempotency, bounded concurrency, retry/backoff and failure tracking.


# 10. System design and distributed systems

## 10.1 Requirements before architecture

Clarify users/core operations, data model/ownership, traffic volume, read/write ratio, payload size, latency, availability, durability, privacy and security. Separate:
- **Functional requirements:** what system does.
- **Non-functional requirements:** performance, availability, durability, security, privacy and maintainability.

## 10.2 Latency, throughput, bandwidth and QPS

**Lecture-backed — Lecture 08 / storage-latency-capacity material.**

| Metric | Meaning |
|---|---|
| Latency | Time one operation/request takes |
| Throughput | Completed work per unit time |
| Bandwidth | Data-transfer capacity |
| QPS/RPS | Queries/requests per second |

~~~text
Average requests/second = requests per day / 86,400
~~~

Average rate hides peaks. Latency can include network transit, queueing, application processing, storage and response transfer. Find the bottleneck before adding infrastructure.

## 10.3 Load balancers, reverse proxies and gateways

| Component | Role |
|---|---|
| Load balancer | Distributes traffic across instances |
| Reverse proxy | Accepts client traffic and forwards it to internal services; may terminate TLS |
| API gateway | Front door for API routing/policies such as auth integration, quotas and rate limits |

- **L4:** transport-level routing (TCP/UDP address/port).
- **L7:** application-aware HTTP routing (host/path/headers).
- **NGINX:** commonly used as web server/reverse proxy.
- **Kong:** API gateway platform.

## 10.4 Vertical and horizontal scaling

- **Vertical:** add CPU/RAM/storage to one machine.
- **Horizontal:** add instances and distribute requests.
- Horizontal scaling requires state outside each process: shared DB, cache/session store, object storage or broker.
- Use health checks, graceful shutdown and connection draining.
- More instances do not fix a saturated DB or slow dependency.

## 10.5 CAP and consistency

During a network partition, a distributed data system trades off:
- **Consistency:** reads see the latest committed value according to the guarantee.
- **Availability:** requests to non-failing nodes receive responses.
- **Partition tolerance:** operation despite network partition.

CAP is about trade-offs during partitions; real designs also consider latency, replication, quorum and isolation.

## 10.6 Consistent hashing

Consistent hashing maps keys and nodes onto a hash ring. Each key maps to the next node in ring order. Adding/removing a node moves only part of the keyspace. Virtual nodes improve distribution. Useful for distributed caches/partition routing; it does not by itself solve replication, recovery or consistency.

## 10.7 Reliability patterns

- **Rate limiting:** bound requests per caller/window.
- **Quota:** longer-period usage allowance.
- **Circuit breaker:** stop repeated calls to an unhealthy dependency; allow later probe.
- **Timeout:** limit waiting time.
- **Retry:** repeat transient failures with bounded backoff/jitter.
- **Bulkhead:** isolate resource pools so one workload does not consume all capacity.
- **CORS:** browser mechanism controlling which origins may read responses; not authentication.

Retry only if repeating the operation is safe or protected by an idempotency key.

# 11. Messaging and queues

**Syllabus revision — no complete matching messaging lecture note found.**

## 11.1 Kafka vs RabbitMQ

| Kafka | RabbitMQ |
|---|---|
| Distributed append-only event log with partitions/offsets | Broker with exchanges, routing rules and queues |
| Strong for event streams, replay and throughput | Strong for task queues and flexible routing |
| Consumer groups coordinate partition work | Consumers receive queue messages and acknowledge |
| Ordering is per partition | Ordering depends on queue/consumer arrangement |

Core terms:
- **Producer:** publishes message/event.
- **Consumer:** reads/processes.
- **Topic:** named Kafka event stream.
- **Partition:** ordered log segment.
- **Consumer group:** consumers divide partition work.
- **Exchange/binding/routing key:** RabbitMQ routing concepts.
- **Acknowledgement:** tells broker message was handled.
- **DLQ:** dead-letter queue for messages that cannot be processed normally.

## 11.2 Delivery and retries

- **At-most-once:** no retry; messages may be lost.
- **At-least-once:** retries; duplicate deliveries may occur.
- Exactly-once claims depend on scope. Broker guarantees do not automatically make external DB/payment effects exactly once.
- Consumers should be idempotent.
- Use retry limits, backoff, DLQ and poison-message handling.
- Ordering constraints can limit parallelism; preserve only when required.

