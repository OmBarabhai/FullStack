# JavaScript Runtime

> **"JavaScript is just a programming language. It cannot execute itself. It requires an environment to run. That environment is called the JavaScript Runtime."**

---

# Learning Objectives

After completing this chapter, you will be able to answer:

- What is a JavaScript Runtime?
- Why does JavaScript need a Runtime?
- What is the difference between ECMAScript, JavaScript, Engine, and Runtime?
- What components make up a Runtime?
- How does JavaScript code travel from source code to execution?
- What is the difference between Browser Runtime and Node.js Runtime?

> **Note**
>
> This chapter introduces every component of the Runtime at a high level.
> Each component (Execution Context, Call Stack, Web APIs, Event Loop, Promises, etc.) is covered in detail in the following chapters.

---

# Table of Contents

1. Introduction
2. What is a Runtime?
3. Why Does JavaScript Need a Runtime?
4. ECMAScript vs JavaScript vs Runtime
5. JavaScript Engine vs Runtime
6. JavaScript Runtime Architecture

---

# 1. Introduction

Many beginners think JavaScript itself performs tasks like:

- Creating timers
- Fetching data from APIs
- Manipulating HTML
- Reading files
- Handling user clicks

This is **not true.**

JavaScript is only a programming language.

It defines things such as:

- Variables
- Functions
- Objects
- Arrays
- Loops
- Classes
- Modules
- Promises

However, JavaScript alone **cannot**:

- Wait for 5 seconds
- Access the internet
- Read your computer's files
- Create a webpage
- Access the camera
- Store data in Local Storage

Someone else provides these capabilities.

That "someone" is the **JavaScript Runtime**.

---

## Think About It

Imagine writing this code:

```javascript
console.log("Hello World");
```

Question:

Who actually prints this text?

JavaScript?

No.

The Runtime executes the code and provides the `console` object.

Without a Runtime,

this code cannot run.

---

# 2. What is a Runtime?

A **Runtime** is the environment responsible for executing JavaScript code.

It provides everything required to run a JavaScript program successfully.

Think of it as the operating environment where JavaScript lives.

Without a Runtime,

JavaScript is simply text stored inside a file.

---

## Definition

> A JavaScript Runtime is an execution environment that runs JavaScript code and provides additional features such as memory management, APIs, asynchronous task handling, and communication with the operating system.

---

## Real-Life Analogy

Imagine you have a recipe.

A recipe contains instructions.

But can the recipe cook food?

No.

You need

- Kitchen
- Stove
- Gas
- Utensils
- Ingredients

Only then can cooking begin.

Similarly,

JavaScript is only the recipe.

The Runtime is the complete kitchen.

```
JavaScript Code

        │

        ▼

JavaScript Runtime

        │

        ▼

Program Executes
```

---

## Another Analogy

Imagine buying a car engine.

Can you drive using only the engine?

No.

You also need

- Wheels
- Steering
- Brakes
- Fuel
- Battery

Similarly,

JavaScript is only one part.

The Runtime is the complete vehicle.

---

# 3. Why Does JavaScript Need a Runtime?

JavaScript was originally designed to make web pages interactive.

The language itself only defines syntax and programming features.

It does **not** know how to interact with the outside world.

For example,

JavaScript does not know how to:

❌ Create a timer

❌ Download data from an API

❌ Access the DOM

❌ Store information in Local Storage

❌ Read a file

❌ Open a network connection

Those capabilities are provided by the Runtime.

---

## Example 1

```javascript
setTimeout(() => {
    console.log("Hello");
}, 1000);
```

Question:

Who created `setTimeout()`?

JavaScript?

❌ No

The Runtime provides it.

---

## Example 2

```javascript
fetch("https://api.example.com/users");
```

Question:

Who performs the HTTP request?

JavaScript?

❌ No

The Runtime performs the network request.

---

## Example 3

```javascript
document.querySelector("button");
```

Question:

Who created the `document` object?

JavaScript?

❌ No

The Browser Runtime provides it.

---

## Without a Runtime

JavaScript would only understand:

- Variables
- Functions
- Objects
- Arrays
- Classes
- Loops
- Promises

Everything else would be impossible.

---

# 4. ECMAScript vs JavaScript vs Runtime

One of the most common interview questions.

Many developers incorrectly think these three terms mean the same thing.

They do not.

---

## ECMAScript

ECMAScript is the official specification (rule book).

It defines:

- Syntax
- Keywords
- Classes
- Modules
- Promises
- Arrow Functions
- Async/Await

ECMAScript **does not execute code**.

It only defines the rules.

Think of it as a textbook.

---

## JavaScript

JavaScript is an implementation of the ECMAScript specification.

It follows the rules defined by ECMAScript.

When you write

```javascript
let age = 22;
```

you are writing JavaScript that follows ECMAScript rules.

---

## Runtime

The Runtime actually executes JavaScript code.

It provides:

- JavaScript Engine
- Memory
- APIs
- Event Loop
- Queues

Without the Runtime,

JavaScript cannot execute.

---

## Relationship

```
ECMAScript

↓

Defines Rules

↓

JavaScript

↓

Implements Those Rules

↓

Runtime

↓

Executes JavaScript
```

---

## Comparison Table

| ECMAScript | JavaScript | Runtime |
|------------|------------|---------|
| Specification | Programming Language | Execution Environment |
| Defines rules | Implements the rules | Executes JavaScript |
| Cannot run code | Can be written by developers | Runs the code |
| Maintained by ECMA | Used by developers | Provided by Browser or Node.js |

---

# 5. JavaScript Engine vs Runtime

Another very common interview question.

Many people confuse the JavaScript Engine with the Runtime.

They are not the same.

---

## JavaScript Engine

The Engine is responsible for reading and executing JavaScript code.

Responsibilities include:

- Parsing source code
- Compiling code
- Executing code
- Optimizing performance
- Garbage Collection

Popular JavaScript Engines

| Platform | Engine |
|----------|--------|
| Chrome | V8 |
| Edge | V8 |
| Node.js | V8 |
| Firefox | SpiderMonkey |
| Safari | JavaScriptCore |

---

## Runtime

The Runtime is much bigger.

It contains the JavaScript Engine and many additional components.

The Runtime provides:

- JavaScript Engine
- Memory Heap
- Call Stack
- Runtime APIs
- Event Loop
- Task Queues

---

## Engine vs Runtime

```
JavaScript Runtime

├── JavaScript Engine
├── Memory Heap
├── Call Stack
├── Runtime APIs
├── Event Loop
└── Queues
```

Think of it like this:

```
Engine = Heart

Runtime = Entire Human Body
```

The heart is important.

But the body contains much more than just the heart.

---

# 6. JavaScript Runtime Architecture

At a high level, every JavaScript Runtime contains the following major components.

```
                     JavaScript Runtime

┌────────────────────────────────────────────────────┐
│                                                    │
│               JavaScript Engine                    │
│                                                    │
│     ┌───────────────┐   ┌─────────────────────┐    │
│     │ Memory Heap   │   │    Call Stack       │    │
│     └───────────────┘   └─────────────────────┘    │
│                                                    │
└────────────────────────────────────────────────────┘

                      │
                      ▼

┌────────────────────────────────────────────────────┐
│                  Runtime APIs                      │
│                                                    │
│ DOM │ Timers │ Fetch │ Storage │ Events │ Console │
└────────────────────────────────────────────────────┘

                      │
                      ▼

┌────────────────────────────────────────────────────┐
│                  Event Loop                        │
└────────────────────────────────────────────────────┘

                      │
                      ▼

┌──────────────────────┬─────────────────────────────┐
│ Microtask Queue      │ Callback Queue              │
└──────────────────────┴─────────────────────────────┘
```

---

## Don't Worry Yet

You are **not expected to understand every component right now**.

Each one has its own dedicated chapter in this handbook.

| Component | Covered In |
|-----------|------------|
| Execution Context | Chapter 02 |
| Call Stack | Chapter 03 |
| Web APIs | Chapter 04 |
| Task Queue | Chapter 05 |
| Event Loop | Chapter 06 |
| Microtask Queue | Chapter 07 |
| setTimeout | Chapter 08 |
| fetch | Chapter 10 |
| Promises | Chapter 11 |
| Async/Await | Chapter 13 |

---

# End of Part 1

In the next part, we'll study:

- Components of the Runtime
- JavaScript Engine in detail
- Memory Heap
- Call Stack (Overview)
- Runtime Responsibilities

# JavaScript Runtime (Part 2)

---

# Table of Contents

7. Components of the JavaScript Runtime
8. JavaScript Engine
9. Memory Heap
10. Call Stack (Overview)
11. Runtime APIs (Overview)
12. Runtime Responsibilities
13. High-Level Execution Flow

---

# 7. Components of the JavaScript Runtime

The JavaScript Runtime is not a single program.

It is made up of several components that work together to execute JavaScript efficiently.

Think of a computer.

A computer isn't just a CPU.

It contains

- CPU
- RAM
- Storage
- Keyboard
- Mouse
- Display

All of these components work together.

Similarly,

a JavaScript Runtime contains several important components.

```
JavaScript Runtime

│

├── JavaScript Engine

├── Memory Heap

├── Call Stack

├── Runtime APIs

├── Event Loop

├── Microtask Queue

└── Callback Queue
```

Each component has a specific responsibility.

---

## Component Overview

| Component | Responsibility |
|------------|----------------|
| JavaScript Engine | Executes JavaScript code |
| Heap Memory | Stores objects and reference values |
| Call Stack | Keeps track of function execution |
| Runtime APIs | Provides timers, networking, DOM, etc. |
| Event Loop | Coordinates asynchronous execution |
| Microtask Queue | Stores Promise callbacks |
| Callback Queue | Stores timer and event callbacks |

> We will study each component in detail in later chapters.

---

# 8. JavaScript Engine

The JavaScript Engine is the heart of the Runtime.

Its primary job is to understand and execute JavaScript code.

Without the engine,

nothing can execute.

---

## Responsibilities of the Engine

The engine performs several tasks.

```
JavaScript Code

↓

Read

↓

Parse

↓

Compile

↓

Execute

↓

Return Result
```

Its responsibilities include:

- Reading JavaScript source code
- Checking syntax
- Converting code into machine instructions
- Executing instructions
- Optimizing execution
- Managing memory
- Garbage Collection

---

## Popular JavaScript Engines

| Runtime | Engine |
|----------|--------|
| Google Chrome | V8 |
| Microsoft Edge | V8 |
| Node.js | V8 |
| Firefox | SpiderMonkey |
| Safari | JavaScriptCore |

---

## How the Engine Works

Consider this code.

```javascript
let x = 10;

console.log(x);
```

The engine performs the following steps.

```
Source Code

↓

Lexical Analysis

↓

Parsing

↓

Abstract Syntax Tree (AST)

↓

Compilation

↓

Machine Code

↓

CPU Executes
```

You don't need to memorize every step right now.

We'll study the internal working of the engine later if required.

---

## Engine Responsibilities (Simple)

Imagine a teacher checking exam papers.

The teacher

- reads answers
- checks grammar
- evaluates answers
- gives marks

Similarly,

the engine

- reads code
- checks syntax
- executes instructions
- returns output

---

# 9. Memory Heap

JavaScript stores data in memory.

There are two major memory areas.

- Heap
- Call Stack

Let's first understand the Heap.

---

## What is Heap Memory?

Heap is a large memory area used to store

- Objects
- Arrays
- Functions
- Reference values

Example

```javascript
const student = {
    name: "Om",
    age: 22
};
```

The object is stored inside the Heap.

```
Heap Memory

+----------------------------+

student

↓

Object

name = Om

age = 22

+----------------------------+
```

---

## Why Heap?

Objects can become very large.

Imagine storing

- 10 students
- 100 students
- 10,000 students

Heap allows JavaScript to allocate memory dynamically.

---

## Primitive vs Reference Values

Primitive values

```javascript
let age = 22;
```

Reference values

```javascript
const person = {
    name: "Om"
};
```

Reference values point to objects stored inside the Heap.

---

## Important Note

You don't directly interact with the Heap.

The JavaScript Engine automatically allocates and frees memory when needed.

This process is called

**Garbage Collection**

We'll study Garbage Collection separately.

---

# 10. Call Stack (Overview)

One of the most important parts of the Runtime is the Call Stack.

For now,

only remember its purpose.

---

## What is the Call Stack?

The Call Stack keeps track of which function is currently executing.

Imagine a stack of books.

You can only place a new book on the top.

You can only remove the top book.

The Call Stack works the same way.

---

Example

```javascript
function greet() {
    console.log("Hello");
}

greet();
```

Execution

```
Call Stack

↓

Global()

↓

greet()

↓

console.log()

↓

Return

↓

Empty
```

Only one function executes at a time.

---

## Why is JavaScript Single Threaded?

JavaScript has only one Call Stack.

Since only one function can execute on the stack at a time,

JavaScript executes code sequentially.

This is why JavaScript is called

**Single-Threaded.**

---

## Important

This chapter only introduces the Call Stack.

The complete Call Stack, stack frames, recursion, stack overflow, push/pop operations, and execution flow are covered in **Chapter 03**.

---

# 11. Runtime APIs (Overview)

The Runtime provides many useful APIs that JavaScript itself does not include.

Depending on where JavaScript runs,

different APIs are available.

---

## Browser Runtime APIs

Examples

```
DOM

fetch()

setTimeout()

setInterval()

console

localStorage

sessionStorage

navigator

history

location

addEventListener()
```

These APIs allow JavaScript to interact with the browser.

---

## Node.js Runtime APIs

Node.js does not have a DOM.

Instead,

it provides server-side APIs.

Examples

```
fs

http

https

os

path

crypto

process

stream

child_process
```

These APIs allow JavaScript to interact with the operating system.

---

## Important Interview Question

Is `setTimeout()` part of JavaScript?

Answer

❌ No

It is provided by the Runtime.

---

Another Interview Question

Is `fetch()` part of JavaScript?

Answer

❌ No

The Runtime provides it.

---

# 12. Runtime Responsibilities

The Runtime performs many responsibilities beyond executing JavaScript.

Its responsibilities include

✓ Running JavaScript code

✓ Managing memory

✓ Creating Execution Contexts

✓ Managing the Call Stack

✓ Providing Runtime APIs

✓ Scheduling asynchronous operations

✓ Managing task queues

✓ Running the Event Loop

✓ Communicating with the operating system

Without these responsibilities,

modern JavaScript applications would not work.

---

# 13. High-Level Execution Flow

Let's see how everything works together.

Imagine this code.

```javascript
console.log("Hello");
```

High-Level Flow

```
JavaScript File

↓

JavaScript Engine

↓

Execution Context Created

↓

Call Stack

↓

console.log()

↓

Runtime Console API

↓

Output

↓

Program Ends
```

Another example

```javascript
setTimeout(() => {
    console.log("Done");
}, 1000);
```

High-Level Flow

```
JavaScript File

↓

Engine

↓

Call Stack

↓

Runtime Timer API

↓

Wait

↓

Queue

↓

Event Loop

↓

Call Stack

↓

console.log()

↓

Output
```

> Don't worry if the Event Loop or Queue seems confusing.
>
> They are introduced here only to show the complete picture.
> We will study them in detail in Chapters 05, 06, and 07.

---

# Key Takeaways

- A Runtime is made up of several components working together.
- The JavaScript Engine executes JavaScript code.
- Heap Memory stores objects and reference values.
- The Call Stack tracks function execution.
- The Runtime provides APIs such as `fetch()`, `setTimeout()`, and the DOM.
- The Runtime manages asynchronous operations using the Event Loop and queues.
- JavaScript itself does not provide browser or operating system APIs.

---

# What's Next?

In **Part 3**, we'll cover:

- Browser Runtime
- Node.js Runtime
- Browser vs Node.js
- Real-World Runtime Examples
- Common Misconceptions
- Interview Questions
- Revision Notes
- Summary

# JavaScript Runtime (Part 3)

---

# Table of Contents

14. Browser Runtime
15. Node.js Runtime
16. Browser vs Node.js Runtime
17. Real-World Examples
18. Common Misconceptions
19. Interview Questions
20. Quick Revision
21. Summary
22. What's Next?

---

# 14. Browser Runtime

When JavaScript runs inside a web browser (Chrome, Firefox, Safari, Edge), it gets access to many additional features that the JavaScript language itself does not provide.

These features are called **Browser APIs** or **Web APIs**.

The browser combines:

- JavaScript Engine
- Memory
- Call Stack
- Web APIs
- Event Loop
- Task Queues

to create the Browser Runtime.

---

## Browser Runtime Architecture

```
                  Browser Runtime

        ┌─────────────────────────────┐
        │ JavaScript Engine (V8 etc.) │
        └─────────────────────────────┘
                     │
                     ▼
        ┌─────────────────────────────┐
        │ Heap + Call Stack           │
        └─────────────────────────────┘
                     │
                     ▼
        ┌─────────────────────────────┐
        │ Browser APIs                │
        │                             │
        │ DOM                         │
        │ Timers                      │
        │ Fetch                       │
        │ Storage                     │
        │ Events                      │
        └─────────────────────────────┘
                     │
                     ▼
        ┌─────────────────────────────┐
        │ Event Loop                  │
        └─────────────────────────────┘
                     │
                     ▼
        ┌─────────────────────────────┐
        │ Queues                      │
        └─────────────────────────────┘
```

---

## Browser APIs

The browser provides many useful APIs.

Examples

```
document

window

console

fetch

setTimeout

setInterval

localStorage

sessionStorage

navigator

history

location

addEventListener

MutationObserver

IntersectionObserver
```

Notice that these APIs are **not** part of JavaScript.

---

## Example

```javascript
document.querySelector("h1");
```

Question

Who created `document`?

Answer

The Browser Runtime.

---

Another Example

```javascript
localStorage.setItem("name", "Om");
```

Question

Who provides `localStorage`?

Answer

The Browser Runtime.

---

# 15. Node.js Runtime

JavaScript is no longer limited to browsers.

Node.js allows JavaScript to run outside the browser.

Unlike browsers,

Node.js does **not** provide

❌ DOM

❌ Window

❌ Document

Instead,

it provides APIs that interact with the operating system.

---

## Node.js Runtime Architecture

```
                 Node.js Runtime

          ┌─────────────────────┐
          │ V8 Engine           │
          └─────────────────────┘
                     │
                     ▼
          ┌─────────────────────┐
          │ Heap + Call Stack   │
          └─────────────────────┘
                     │
                     ▼
          ┌─────────────────────┐
          │ Node APIs           │
          │                     │
          │ fs                  │
          │ http                │
          │ crypto              │
          │ os                  │
          │ process             │
          └─────────────────────┘
                     │
                     ▼
          ┌─────────────────────┐
          │ libuv               │
          └─────────────────────┘
```

---

## Common Node APIs

```
fs

http

https

os

crypto

process

stream

path

dns

url

events

timers
```

---

## Example

```javascript
const fs = require("fs");

fs.readFile("data.txt", () => {});
```

Question

Who provides `fs`?

Answer

Node.js Runtime.

---

# 16. Browser vs Node.js Runtime

Although both run JavaScript,

they provide different environments.

---

## Comparison Table

| Browser Runtime | Node.js Runtime |
|-----------------|-----------------|
| Runs inside browsers | Runs outside browsers |
| Has DOM | No DOM |
| Has Window object | No Window object |
| Has Document | No Document |
| Uses Browser APIs | Uses Node APIs |
| Used for Frontend | Used for Backend |

---

## APIs Comparison

| Browser | Node.js |
|----------|----------|
| document | fs |
| window | process |
| fetch | http |
| localStorage | path |
| navigator | os |
| history | crypto |

---

## Same JavaScript

Both environments still understand

```javascript
let x = 10;

function greet(){}

class Student{}
```

because these are JavaScript features.

Only the available APIs change.

---

# 17. Real-World Examples

---

## Example 1 — React Application

```javascript
fetch("/users")
```

Flow

```
React

↓

JavaScript

↓

Browser Runtime

↓

Network Request

↓

Server

↓

Response

↓

Browser Runtime

↓

JavaScript

↓

React Updates UI
```

---

## Example 2 — Express.js Server

```javascript
fs.readFile("users.json");
```

Flow

```
Express

↓

JavaScript

↓

Node Runtime

↓

Operating System

↓

File Read

↓

Node Runtime

↓

JavaScript

↓

Response
```

---

## Example 3 — Timer

```javascript
setTimeout(() => {
    console.log("Done");
},1000);
```

Flow

```
JavaScript

↓

Runtime Timer

↓

Wait

↓

Queue

↓

Event Loop

↓

Call Stack

↓

console.log()
```

We will study this flow in detail later.

---

# 18. Common Misconceptions

---

## ❌ JavaScript and Runtime are the same

Wrong.

JavaScript is the language.

The Runtime executes JavaScript.

---

## ❌ setTimeout is JavaScript

Wrong.

The Runtime provides it.

---

## ❌ fetch is JavaScript

Wrong.

The Runtime provides it.

---

## ❌ document is JavaScript

Wrong.

The Browser Runtime provides it.

---

## ❌ Promise is a Browser API

Wrong.

Promise is part of JavaScript.

Only Promise callbacks are managed by the Runtime.

---

## ❌ Node.js is a programming language

Wrong.

Node.js is a JavaScript Runtime.

---

## ❌ Browser and Node.js are identical

Wrong.

Both execute JavaScript,

but they provide different APIs.

---

# 19. Interview Questions

---

## What is JavaScript Runtime?

A Runtime is the environment that executes JavaScript code and provides additional APIs like timers, networking, storage, and asynchronous task handling.

---

## Why does JavaScript need a Runtime?

Because JavaScript alone cannot access the browser, operating system, timers, networking, or files.

---

## Difference between Engine and Runtime?

Engine executes JavaScript.

Runtime contains the Engine plus APIs, memory management, queues, and the Event Loop.

---

## What is V8?

Google's JavaScript Engine used in Chrome and Node.js.

---

## Is setTimeout part of JavaScript?

No.

The Runtime provides it.

---

## Is fetch part of JavaScript?

No.

The Runtime provides it.

---

## Is Promise a Browser API?

No.

Promise belongs to JavaScript.

---

## Is document part of JavaScript?

No.

It belongs to the Browser Runtime.

---

## Can Browser JavaScript read local files?

No.

For security reasons.

Node.js can.

---

## Why can Node.js access the file system?

Because the Node Runtime provides the File System API.

---

# 20. Quick Revision

```
JavaScript

↓

Programming Language

↓

Needs Runtime

↓

Runtime Contains

Engine

Heap

Call Stack

APIs

Event Loop

Queues
```

---

## Remember

✓ JavaScript ≠ Runtime

✓ Engine ⊂ Runtime

✓ Browser Runtime provides DOM

✓ Node Runtime provides File System

✓ JavaScript cannot execute itself

✓ Runtime executes JavaScript

✓ Browser APIs ≠ JavaScript

✓ Node APIs ≠ JavaScript

---

# 21. Summary

In this chapter, you learned that:

- JavaScript is only a programming language.
- A Runtime is required to execute JavaScript.
- The Runtime contains the JavaScript Engine and several supporting components.
- The Engine executes JavaScript code.
- Heap stores objects and reference values.
- Call Stack manages function execution.
- Browser and Node.js provide different runtime APIs.
- Browser APIs and Node APIs are not part of JavaScript.
- Understanding the Runtime is the foundation for asynchronous JavaScript.

---

# Chapter Revision Checklist

Before moving to the next chapter, make sure you can answer:

- [ ] What is a Runtime?
- [ ] Why does JavaScript need a Runtime?
- [ ] Difference between ECMAScript, JavaScript, Engine, and Runtime.
- [ ] Difference between Engine and Runtime.
- [ ] Name the main Runtime components.
- [ ] Difference between Browser Runtime and Node.js Runtime.
- [ ] Give five Browser APIs.
- [ ] Give five Node.js APIs.
- [ ] Explain why `setTimeout()` is not part of JavaScript.
- [ ] Explain why `fetch()` is not part of JavaScript.

If you can confidently answer all of these without looking at your notes, you are ready for the next chapter.

---

# What's Next?

➡️ **02-Execution-Context.md**

In the next chapter, you'll learn:

- What happens before JavaScript executes the first line of code.
- Global Execution Context (GEC)
- Function Execution Context (FEC)
- Creation Phase
- Execution Phase
- Memory Allocation
- Variable Hoisting
- Function Hoisting
- `this` Binding (Introduction)
- Lexical Environment (Introduction)

Execution Context is one of the most important concepts in JavaScript and forms the foundation for understanding the Call Stack and asynchronous behavior.