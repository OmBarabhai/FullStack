# JavaScript Runtime

## 1. What Is the JavaScript Runtime?

JavaScript code does not execute in isolation.

When JavaScript runs, it operates inside a **JavaScript runtime environment**.

A runtime provides the environment and components required to execute JavaScript and, depending on the environment, provides additional APIs.

Common JavaScript runtime environments include:

- Browser environments
- Node.js

The important idea:

```text
JavaScript Code
      ↓
JavaScript Engine
      ↓
Runtime Environment
      ↓
Program Execution
```

---

## 2. JavaScript Engine vs JavaScript Runtime

These are related, but they are not the same thing.

### JavaScript Engine

The engine is responsible for executing JavaScript.

Examples:

- V8 — used by Chrome and Node.js
- SpiderMonkey — used by Firefox
- JavaScriptCore — used by Safari

The engine handles JavaScript execution.

### Runtime

The runtime provides the larger environment around the engine.

For example, a browser runtime can provide APIs such as:

```text
setTimeout()
fetch()
DOM APIs
Web Storage
console
```

Node.js provides its own runtime capabilities and APIs.

Therefore:

```text
Runtime
├── JavaScript Engine
├── Runtime APIs
└── Other environment capabilities
```

Do not memorize this as a list. Understand the relationship.

---

## 3. Browser Runtime

When JavaScript runs inside a browser, the environment contains more than the JavaScript engine.

A simplified model:

```text
Browser Runtime
│
├── JavaScript Engine
│
├── Web APIs
│   ├── DOM
│   ├── fetch()
│   ├── setTimeout()
│   └── other browser APIs
│
├── Task Queues
└── Event Loop
```

This is important because JavaScript itself does not directly perform every environment operation.

For example:

```js
setTimeout(() => {
    console.log("Hello");
}, 1000);
```

The timer operation is handled by the runtime environment.

The JavaScript engine executes the callback when the runtime eventually makes it available for execution.

---

## 4. Node.js Runtime

Node.js also uses the V8 JavaScript engine, but it is not a browser.

A simplified model:

```text
Node.js Runtime
│
├── V8 JavaScript Engine
├── Node.js APIs
├── Event Loop
└── libuv
```

This is why JavaScript can run outside a browser.

For example, Node.js can provide capabilities for:

```text
File system
Networking
Servers
Streams
Timers
Processes
```

These are runtime capabilities rather than ordinary JavaScript language syntax.

---

## 5. Important Mental Model

Do not think:

```text
JavaScript = Browser
```

Instead:

```text
JavaScript Language
        ↓
JavaScript Engine
        ↓
Runtime Environment
        ↓
Environment-specific APIs
```

The same JavaScript language can therefore run in different environments.

For example:

```text
Browser
→ JavaScript + Browser APIs

Node.js
→ JavaScript + Node.js APIs
```

---

## 6. Connection to Folder 02 — Functional JavaScript

You already completed `map()`, `filter()`, `find()`, `findIndex()`, `some()`, `every()`, `reduce()`, `sort()`, and chaining. Do **not** relearn them here.

The important connection is:

> A callback does not automatically mean asynchronous execution.

For example:

```js
const total = [10, 20, 30].reduce((acc, value) => {
    return acc + value;
}, 0);
```

The `reduce()` callback normally executes synchronously as part of the current JavaScript execution.

```text
Current JavaScript execution
        ↓
     reduce()
        ↓
 callback executes
        ↓
      result
```

So:

```text
callback ≠ asynchronous
```

A callback can be synchronous or asynchronous depending on the API that uses it. This is an important bridge from Folder 02 to asynchronous JavaScript.

Your DevAPI code is currently mostly synchronous data processing. Later it will evolve toward:

```text
Static request data
      ↓
Functional processing
      ↓
Actual asynchronous request
      ↓
Promise
      ↓
async/await
      ↓
Error handling
```

---

## 7. Why This Matters for Asynchronous JavaScript

This topic is the foundation for the rest of this folder.

Later we will study:

```text
Runtime
   ↓
Execution Context
   ↓
Call Stack
   ↓
Web APIs / Runtime APIs
   ↓
Task Queue
   ↓
Microtask Queue
   ↓
Event Loop
   ↓
Promises
   ↓
async / await
```

If you understand the runtime model first, the later topics become much easier to reason about.

---

## 8. First Look at Heap and Call Stack

You will study these in detail later, but know their roles now.

### Heap

The heap is associated with dynamically allocated data such as objects.

```js
const user = { name: "Om" };
```

Think of the object as data held in memory, with `user` referring to it. This is a conceptual model, not an exact physical memory diagram.

### Call Stack

The Call Stack tracks active JavaScript execution contexts/function calls.

```js
function first() {
    second();
}

function second() {
    console.log("Hello");
}

first();
```

Conceptually:

```text
console.log()
second()
first()
```

The detailed stack behavior belongs to Part 03.

---

## 8. Simple Example

Consider:

```js
console.log("A");

setTimeout(() => {
    console.log("B");
}, 0);

console.log("C");
```

Do not focus on the answer yet.

The important question is:

> Why does `setTimeout()` involve the runtime instead of simply executing its callback immediately?

That question leads directly into:

- Call Stack
- Runtime APIs
- Task Queue
- Event Loop

We will investigate those in the next topics.

---

## 9. Common Confusions

### Confusion 1

> "JavaScript is asynchronous."

Not exactly.

JavaScript execution itself is primarily synchronous.

Asynchronous behavior comes from the interaction between JavaScript execution and the surrounding runtime mechanisms.

---

### Confusion 2

> "V8 is Node.js."

No.

V8 is the JavaScript engine.

Node.js is a runtime environment that uses V8.

---

### Confusion 3

> "setTimeout() is JavaScript language syntax."

No.

`setTimeout()` is provided by the environment.

The exact APIs available depend on the runtime.

---

### Confusion 4

> "The event loop is the JavaScript engine."

No.

The event loop is part of the runtime's mechanism for coordinating asynchronous work with JavaScript execution.

---

## 10. Interview-Level Understanding

You should be able to answer:

### Q1. What is a JavaScript runtime?

A JavaScript runtime is the environment in which JavaScript executes. It includes the JavaScript engine plus environment-specific capabilities and mechanisms used by the program.

### Q2. What is the difference between an engine and a runtime?

The engine executes JavaScript. The runtime provides the broader environment around that engine, including APIs and mechanisms for interacting with the environment.

### Q3. Is Node.js a JavaScript engine?

No. Node.js is a JavaScript runtime that uses the V8 engine.

### Q4. Why is the runtime important for asynchronous JavaScript?

Because operations such as timers, networking, and other environment tasks are coordinated by runtime mechanisms. Their results/callbacks can later become available for JavaScript execution.

---

## 11. Practice

### Task 1

Explain in your own words:

```text
JavaScript Engine
vs
JavaScript Runtime
```

### Task 2

Identify which category each belongs to:

```text
V8
Node.js
Browser
setTimeout()
JavaScript language
```

### Task 3

Predict what you think this prints:

```js
console.log("Start");

setTimeout(() => {
    console.log("Timer");
}, 0);

console.log("End");
```

Do not look up the answer first.

Write your prediction and explain your reasoning.

---

## 12. Completion Criteria

Do not mark this topic complete merely because you read it.

You should be able to:

- explain engine vs runtime
- explain browser vs Node.js runtime at a high level
- explain why runtime matters for asynchronous behavior
- identify that V8 is an engine, not Node.js
- reason about the role of `setTimeout()`
- attempt the practice tasks independently

Next:

# Call Stack
