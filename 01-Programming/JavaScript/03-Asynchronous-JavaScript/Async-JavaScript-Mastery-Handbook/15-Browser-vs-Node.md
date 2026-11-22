# Chapter 15 — Browser vs Node.js (Complete Handbook)

> **"JavaScript is one language, but it runs in different environments. The Browser and Node.js provide different capabilities around the same JavaScript engine."**

This chapter is extremely important for interviews because companies frequently ask:

- Why can `document.querySelector()` run in Chrome but not Node.js?
- What is V8?
- What is libuv?
- How is the Browser Event Loop different from the Node.js Event Loop?
- Why use Node.js for backend?

---

# Table of Contents

1. Introduction
2. What is a JavaScript Runtime?
3. Browser Architecture
4. Node.js Architecture
5. V8 JavaScript Engine
6. Browser APIs
7. Node APIs
8. Browser Event Loop
9. Node.js Event Loop
10. Browser vs Node Comparison
11. Memory Management
12. Execution Flow
13. Real World Examples
14. Common Interview Mistakes
15. Dry Runs
16. High Quality Diagrams
17. 40 Interview Questions
18. Coding Exercises
19. Summary

---

# 1. Introduction

Many beginners think

```
JavaScript = Browser
```

Wrong.

JavaScript runs inside many environments.

```
JavaScript

↓

Browser

Node.js

Electron

React Native

Deno

Bun
```

The language is the same.

Only the runtime changes.

---

# 2. What is a JavaScript Runtime?

JavaScript itself only knows

```
Variables

Functions

Objects

Arrays

Promises

Classes
```

It DOES NOT know

```
DOM

File System

HTTP Server

Window

Document
```

Those are provided by the runtime.

Visual

```
JavaScript Language

↓

Runtime

↓

Extra Features
```

---

# 3. Browser Architecture

```
                Browser

+----------------------------------+
|            HTML Parser           |
+----------------------------------+

+----------------------------------+
|             CSS Engine           |
+----------------------------------+

+----------------------------------+
|          Rendering Engine        |
+----------------------------------+

+----------------------------------+
|      JavaScript Engine (V8)      |
+----------------------------------+

+----------------------------------+
|             Web APIs             |
+----------------------------------+

+----------------------------------+
|          Event Loop              |
+----------------------------------+
```

---

Browser provides

```
DOM

window

document

fetch

setTimeout

setInterval

localStorage

sessionStorage

navigator

history

location
```

---

Example

```javascript
document.querySelector("h1");
```

Works in Browser

Fails in Node.js

---

# 4. Node.js Architecture

```
                 Node.js

+----------------------------------+
|        JavaScript (V8)           |
+----------------------------------+

+----------------------------------+
|             libuv                |
+----------------------------------+

+----------------------------------+
|      File System APIs            |
+----------------------------------+

+----------------------------------+
|      Network APIs                |
+----------------------------------+

+----------------------------------+
|      Event Loop                  |
+----------------------------------+

+----------------------------------+
|      Thread Pool                 |
+----------------------------------+
```

---

Node provides

```
fs

http

https

crypto

path

os

process

stream

buffer
```

---

Example

```javascript
const fs = require("fs");
```

Works in Node

Fails in Browser

---

# 5. V8 JavaScript Engine

Google created

```
V8 Engine
```

Used by

```
Chrome

Edge

Node.js

Electron
```

Responsibilities

```
Parse JS

Compile JS

Execute JS

Garbage Collection

Memory Management
```

Diagram

```
JavaScript

↓

Parser

↓

AST

↓

Compiler

↓

Machine Code

↓

CPU
```

---

# 6. Browser APIs

These are NOT part of JavaScript.

Provided by Browser.

```
DOM

↓

document

↓

window

↓

fetch

↓

setTimeout

↓

localStorage

↓

sessionStorage

↓

alert

↓

confirm
```

Example

```javascript
alert("Hello");
```

Browser

✅

Node

❌

---

# 7. Node APIs

Provided by Node.js

```
fs

http

path

crypto

os

child_process

stream

buffer
```

Example

```javascript
fs.readFile();
```

Browser

❌

Node

✅

---

# 8. Browser Event Loop

```
Call Stack

↓

Web APIs

↓

Callback Queue

↓

Microtask Queue

↓

Event Loop

↓

Call Stack
```

Microtask Queue has higher priority.

Order

```
Call Stack

↓

Microtask Queue

↓

Callback Queue
```

---

# 9. Node.js Event Loop

Node uses libuv.

Phases

```
Timers

↓

Pending Callbacks

↓

Idle

↓

Poll

↓

Check

↓

Close Callbacks
```

Visual

```
+------------------+
| Timers           |
+------------------+

↓

+------------------+
| Pending          |
+------------------+

↓

+------------------+
| Poll             |
+------------------+

↓

+------------------+
| Check            |
+------------------+

↓

+------------------+
| Close            |
+------------------+
```

---

# 10. Browser vs Node Comparison

| Feature | Browser | Node.js |
|----------|----------|----------|
| DOM | ✅ | ❌ |
| document | ✅ | ❌ |
| window | ✅ | ❌ |
| localStorage | ✅ | ❌ |
| fetch | ✅ | ✅ (Modern Node) |
| File System | ❌ | ✅ |
| HTTP Server | ❌ | ✅ |
| OS Access | ❌ | ✅ |
| process | ❌ | ✅ |
| require() | ❌ | ✅ (CommonJS) |

---

# 11. Memory Management

Both use

```
V8 Garbage Collector
```

Automatically removes

```
Unused Objects

Unused Variables

Unused Arrays
```

Diagram

```
Objects

↓

Unused

↓

Garbage Collector

↓

Memory Freed
```

---

# 12. Execution Flow

Browser

```
User Click

↓

Event

↓

Web API

↓

Callback Queue

↓

Event Loop

↓

Call Stack
```

---

Node

```
Request

↓

libuv

↓

Poll Phase

↓

Callback

↓

Call Stack
```

---

# 13. Real World Examples

Browser

```javascript
document.querySelector("#btn");
```

Node

```javascript
fs.readFile("file.txt");
```

---

Browser

```javascript
localStorage.setItem();
```

Node

```javascript
fs.writeFile();
```

---

Browser

```
UI

Buttons

Forms

DOM
```

Node

```
Server

Database

API

Authentication
```

---

# 14. Common Interview Mistakes

## Mistake 1

Thinking JavaScript has DOM.

Wrong.

Browser provides DOM.

---

## Mistake 2

Thinking Node is a language.

Wrong.

Node is a runtime.

---

## Mistake 3

Thinking V8 is Node.

Wrong.

Node uses V8.

V8 ≠ Node.

---

## Mistake 4

Thinking setTimeout belongs to JavaScript.

Wrong.

It belongs to Browser/Node runtime.

---

## Mistake 5

Thinking Browser and Node Event Loop are identical.

Wrong.

Browser

```
Microtask

↓

Callback Queue
```

Node

```
Timers

↓

Poll

↓

Check
```

---

# 15. Dry Runs

Example

Browser

```javascript
console.log(window.location);
```

Output

Works

---

Node

```javascript
console.log(window.location);
```

Output

```
ReferenceError
```

---

Browser

```javascript
document.body.style.background="red";
```

Works

---

Node

```javascript
document.body.style.background="red";
```

Error

---

Node

```javascript
const fs = require("fs");

console.log(fs.existsSync("a.txt"));
```

Works

Browser

Error

---

# 16. High Quality Diagrams

Browser Runtime

```
JavaScript

↓

V8

↓

Web APIs

↓

Event Loop

↓

DOM
```

---

Node Runtime

```
JavaScript

↓

V8

↓

libuv

↓

Thread Pool

↓

File System

↓

Event Loop
```

---

Overall

```
             JavaScript

                  │

      ┌───────────┴───────────┐

      │                       │

 Browser Runtime         Node Runtime

      │                       │

 Web APIs                libuv APIs

      │                       │

 DOM                  File System

      │                       │

 Event Loop          Event Loop
```

---

# 17. 40 Interview Questions

### 1. Is JavaScript only for browsers?

No.

---

### 2. What is Node.js?

A JavaScript runtime.

---

### 3. What is V8?

Google's JavaScript engine.

---

### 4. Does Node use V8?

Yes.

---

### 5. What provides DOM?

Browser.

---

### 6. Does JavaScript provide DOM?

No.

---

### 7. What is libuv?

Node's asynchronous I/O library.

---

### 8. Can Browser access files directly?

No.

---

### 9. Can Node access files?

Yes.

---

### 10. Does Browser have process object?

No.

---

### 11. Does Node have window?

No.

---

### 12. Does Browser have require()?

No.

---

### 13. Can Browser run HTTP server?

No.

---

### 14. Can Node create server?

Yes.

---

### 15. Why Node is good for backend?

Non-blocking I/O.

---

Continue practicing questions like:

- What is Event Loop?
- Browser vs Node APIs?
- Why libuv?
- Thread Pool?
- File System?
- Streams?
- Fetch in Node?
- CommonJS vs ES Modules?

---

# 18. Coding Exercises

## Exercise 1

Print

```javascript
process.version
```

(Node)

---

## Exercise 2

Print

```javascript
window.location
```

(Browser)

---

## Exercise 3

Read a file using fs.

---

## Exercise 4

Create HTTP server.

---

## Exercise 5

Manipulate DOM.

---

## Exercise 6

Explain why

```javascript
document.querySelector()
```

fails in Node.

---

# 19. Summary

- JavaScript is the language.
- Browser and Node.js are different runtimes.
- Browser provides DOM, Web APIs, and UI features.
- Node.js provides File System, Network APIs, and backend capabilities.
- Both use the V8 JavaScript engine.
- Browser Event Loop and Node.js Event Loop are similar in concept but differ internally.
- Understanding runtime differences is essential for frontend and backend interviews.

---

# Visual Memory Map

```
JavaScript

↓

Runtime

├──────────────┐

│              │

Browser      Node.js

│              │

DOM         File System

window      process

document    fs

Web APIs    libuv

Event Loop  Event Loop

↓

V8 Engine
```

---

# Next Chapter

➡️ **16-libuv.md**

You'll learn:

- What is libuv?
- Why Node.js needs libuv
- Thread Pool
- Non-blocking I/O
- Worker Threads
- File System Internals
- Networking
- Event Loop Phases
- Architecture Diagrams
- 40+ Interview Questions
- Deep backend internals