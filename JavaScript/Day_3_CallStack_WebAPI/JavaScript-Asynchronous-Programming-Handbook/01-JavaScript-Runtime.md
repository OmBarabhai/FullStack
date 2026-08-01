# JavaScript Runtime

> "JavaScript is just a language. Something must execute that language. That 'something' is called the JavaScript Runtime."

---

# Table of Contents

1. What is a Runtime?
2. Why Do We Need a Runtime?
3. Runtime vs Language
4. JavaScript Runtime Architecture
5. Components of a JavaScript Runtime
6. JavaScript Engine
7. Memory Heap
8. Call Stack
9. Web APIs
10. Callback Queue (Task Queue)
11. Microtask Queue
12. Event Loop
13. Complete Execution Flow
14. Browser Runtime
15. Node.js Runtime
16. Browser vs Node Runtime
17. Real-World Analogy
18. Interview Questions
19. Common Misconceptions
20. Summary

---

# 1. What is a Runtime?

A **Runtime** is the environment where a programming language executes.

Think of JavaScript as a recipe.

A recipe cannot cook food by itself.

It needs:

- Kitchen
- Stove
- Gas
- Utensils

Similarly,

JavaScript code cannot run by itself.

It needs an environment.

That environment is called the **JavaScript Runtime**.

---

## Real Life Analogy

Imagine you write

```js
console.log("Hello");
```

Can JavaScript print this itself?

No.

Something has to execute it.

```
JavaScript Code

↓

Runtime

↓

Output
```

---

# 2. Why Do We Need a Runtime?

JavaScript itself only defines:

- Variables
- Functions
- Objects
- Arrays
- Classes
- Loops

It **does NOT know**:

❌ How to display a webpage

❌ How to wait 5 seconds

❌ How to make HTTP requests

❌ How to read files

❌ How to create timers

Those capabilities come from the runtime.

---

Example

```js
setTimeout(() => {
    console.log("Hello");
},1000)
```

Question

Who created `setTimeout()`?

JavaScript?

❌ No

Browser Runtime

✅ Yes

---

# 3. Runtime vs Language

JavaScript Language

```
Variables

Functions

Objects

Classes

Loops
```

Runtime

```
setTimeout()

fetch()

DOM

Event Loop

Web APIs
```

Very common interview question.

---

# 4. JavaScript Runtime Architecture

High-level architecture

```
                JavaScript Runtime

+-------------------------------------------+

        JavaScript Engine
      (V8 / SpiderMonkey)

+-------------------------------------------+

Heap Memory

Call Stack

+-------------------------------------------+

Browser APIs

↓

Timer

↓

DOM

↓

Fetch

↓

Storage

+-------------------------------------------+

Microtask Queue

↓

Callback Queue

↓

Event Loop

+-------------------------------------------+
```

Everything above works together.

---

# 5. Components of Runtime

A runtime consists of:

```
JavaScript Runtime

│

├── JavaScript Engine

├── Heap

├── Call Stack

├── Web APIs

├── Callback Queue

├── Microtask Queue

└── Event Loop
```

We'll study every one separately.

---

# 6. JavaScript Engine

The JavaScript Engine reads and executes JavaScript code.

Popular engines

| Browser | Engine |
|----------|--------|
| Chrome | V8 |
| Edge | V8 |
| Node.js | V8 |
| Firefox | SpiderMonkey |
| Safari | JavaScriptCore |

---

Engine Responsibilities

- Parse code
- Compile code
- Execute code
- Manage memory
- Optimize performance
- Perform garbage collection

---

Execution

```
Code

↓

Parser

↓

Compiler

↓

Machine Code

↓

CPU
```

---

# 7. Memory Heap

Heap is the area where objects are stored.

Example

```js
const person = {
    name:"Om",
    age:22
}
```

The object lives inside Heap Memory.

```
Heap

+----------------+

Object

name

age

+----------------+
```

Heap is large and unordered.

---

# 8. Call Stack

Call Stack stores currently executing functions.

Example

```js
function one(){

}

one();
```

Execution

```
Call Stack

↓

main()

↓

one()

↓

return

↓

empty
```

Only one function executes at a time.

This is why JavaScript is called **single-threaded**.

---

# 9. Web APIs

Web APIs are provided by the Browser.

Examples

```
setTimeout()

fetch()

DOM

localStorage

navigator

console

addEventListener()
```

These are **NOT** part of JavaScript.

Interview Question

Is `setTimeout()` part of JavaScript?

Answer:

No.

It is provided by the Browser Runtime.

---

# 10. Callback Queue (Task Queue)

When asynchronous work completes,

its callback goes into the Callback Queue.

Example

```js
setTimeout(()=>{
console.log("Hello")
},1000)
```

Flow

```
Timer

↓

Callback Queue

↓

Event Loop

↓

Call Stack
```

---

# 11. Microtask Queue

Promises use another queue.

Example

```js
Promise.resolve()
.then(()=>console.log("Done"))
```

This callback enters

```
Microtask Queue
```

Microtasks have higher priority.

Priority

```
Call Stack

↓

Microtask Queue

↓

Callback Queue
```

---

# 12. Event Loop

The Event Loop continuously checks

```
Is Call Stack Empty?
```

If YES

Move

Microtask

↓

Call Stack

If none

Move

Callback Queue

↓

Call Stack

---

Animation

```
Call Stack

↓

Empty?

↓

Yes

↓

Microtask Queue

↓

Callback Queue

↓

Repeat Forever
```

---

# 13. Complete Execution Flow

```
Write Code

↓

JavaScript Engine

↓

Call Stack

↓

Browser APIs

↓

Queue

↓

Event Loop

↓

Call Stack

↓

Output
```

---

# 14. Browser Runtime

Browser Runtime provides

- DOM
- Timers
- Fetch
- Storage
- Console
- Events

```
Chrome

↓

V8 Engine

↓

Browser APIs

↓

Event Loop
```

---

# 15. Node.js Runtime

Node.js replaces Browser APIs with

```
File System

HTTP

TCP

OS

Process

Streams
```

Node.js uses

```
V8

+

libuv
```

---

# 16. Browser vs Node Runtime

| Browser | Node |
|----------|------|
| DOM | File System |
| fetch | HTTP Module |
| Window | Global |
| Web APIs | libuv APIs |

---

# 17. Real World Analogy

Restaurant

Customer

↓

Waiter

↓

Kitchen

↓

Food Ready

↓

Manager

↓

Customer

Mapping

Customer → User

Waiter → JavaScript

Kitchen → Browser APIs

Food Ready → Queue

Manager → Event Loop

---

# 18. Interview Questions

## What is JavaScript Runtime?

A runtime is the environment that executes JavaScript code and provides additional features like timers, DOM APIs, networking, and the event loop.

---

## Is setTimeout part of JavaScript?

No.

It is provided by the runtime (browser or Node.js).

---

## What is V8?

Google's JavaScript Engine.

---

## Difference between Engine and Runtime?

Engine executes JavaScript.

Runtime includes the engine plus APIs like timers, networking, queues, and the event loop.

---

## Does JavaScript know fetch()?

No.

The runtime provides it.

---

# 19. Common Misconceptions

❌ JavaScript = Runtime

Wrong.

JavaScript is only the language.

---

❌ fetch is JavaScript

Wrong.

Browser provides it.

---

❌ setTimeout is JavaScript

Wrong.

Browser or Node.js provides it.

---

❌ Promise is a Web API

Wrong.

Promises are part of JavaScript itself.

Their callbacks are scheduled by the runtime.

---

# 20. Summary

- JavaScript is only a language.
- A runtime is required to execute JavaScript.
- The runtime contains:
  - JavaScript Engine
  - Heap
  - Call Stack
  - Web APIs
  - Callback Queue
  - Microtask Queue
  - Event Loop
- Browser and Node.js provide different runtime APIs.
- Understanding the runtime is the foundation for mastering asynchronous JavaScript.

---

# Next Chapter

➡️ **02-Execution-Context.md**

You'll learn:

- What happens before the first line of code executes.
- Creation Phase.
- Execution Phase.
- Global Execution Context.
- Function Execution Context.
- Memory creation.
- Hoisting.
- Scope.
- Lexical Environment.