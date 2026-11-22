# Chapter 19 — JavaScript Asynchronous Programming Interview Questions (Beginner → FAANG)

> **Goal:** Master the most frequently asked JavaScript asynchronous interview questions with explanations, follow-up questions, memory tricks, and interview tips.

---

# Table of Contents

1. Interview Preparation Strategy
2. Beginner Questions
3. Intermediate Questions
4. Advanced Questions
5. FAANG-Level Questions
6. Scenario-Based Questions
7. Coding Questions
8. Common Follow-Up Questions
9. Interview Cheat Sheet

---

# How to Prepare

When answering an interview question:

1. Define the concept.
2. Explain why it exists.
3. Explain how it works.
4. Give a real-world example.
5. Mention common mistakes.
6. Draw a diagram if needed.

---

# Beginner Level Questions

---

## Q1. What is JavaScript?

### Answer

JavaScript is a **single-threaded**, **synchronous**, **high-level programming language** used to build interactive web applications.

It can also perform asynchronous operations using:

- Web APIs (Browser)
- libuv (Node.js)

---

### Follow-up

Why is JavaScript called single-threaded?

Answer:

Because it has only **one Call Stack**, so only one function executes at a time.

---

## Q2. What is synchronous programming?

### Answer

Tasks execute one after another.

The next task starts only after the previous one finishes.

Example

```javascript
console.log("A");
console.log("B");
console.log("C");
```

Output

```
A
B
C
```

---

## Q3. What is asynchronous programming?

### Answer

Asynchronous programming allows long-running operations to happen without blocking the main thread.

Example

- API calls
- Timers
- File reading
- Database queries

---

## Q4. Why do we need asynchronous programming?

Without async programming,

Imagine

```
Download Image (5 sec)

↓

Everything freezes
```

With async

```
Download Image

↓

Continue executing JavaScript
```

---

## Q5. What is blocking code?

Code that prevents other code from executing.

Example

Large loop

```javascript
while(true){}
```

Everything freezes.

---

## Q6. What is non-blocking code?

Operations execute in the background while JavaScript continues.

Example

```javascript
fetch("/users");
```

---

## Q7. What is the JavaScript Runtime?

The Runtime consists of

```
JavaScript Engine

+

Call Stack

+

Memory Heap

+

Web APIs

+

Event Loop

+

Queues
```

---

## Q8. What is the Call Stack?

The Call Stack is a data structure that stores function execution order.

LIFO

```
Last In

↓

First Out
```

---

## Q9. What happens when a function is called?

Example

```javascript
hello();
```

Steps

```
Push hello()

↓

Execute

↓

Pop
```

---

## Q10. What is Stack Overflow?

When too many functions are pushed without returning.

Example

```javascript
function test(){
    test();
}

test();
```

Output

```
Maximum call stack exceeded
```

---

# Intermediate Questions

---

## Q11. What are Web APIs?

Browser-provided features.

Examples

- setTimeout
- fetch
- DOM
- Geolocation
- LocalStorage

These are **NOT** part of JavaScript.

---

## Q12. Is setTimeout part of JavaScript?

No.

It is provided by the browser (or libuv in Node.js).

---

## Q13. What is the Event Loop?

The Event Loop continuously checks

```
Call Stack

↓

Empty?

↓

Move task from Queue

↓

Execute
```

---

## Q14. Why is Event Loop needed?

Because JavaScript is single-threaded.

Without Event Loop,

Callbacks would never execute.

---

## Q15. What is Callback Queue?

Stores completed callbacks like

```
setTimeout

setInterval

DOM Events
```

---

## Q16. What is Microtask Queue?

Stores

- Promise.then()
- catch()
- finally()
- queueMicrotask()

Higher priority than Callback Queue.

---

## Q17. Which executes first?

```
Promise

OR

setTimeout
```

Answer

Promise.

Because

```
Microtask Queue

↓

Callback Queue
```

---

## Q18. What is Promise?

A Promise represents the future result of an asynchronous operation.

States

```
Pending

↓

Fulfilled

OR

Rejected
```

---

## Q19. What is Promise Chaining?

Executing asynchronous tasks sequentially.

Example

```javascript
fetch()
.then(...)
.then(...)
.catch(...)
```

---

## Q20. What is async/await?

Syntactic sugar over Promises.

Makes asynchronous code look synchronous.

---

# Advanced Questions

---

## Q21. Does async create a new thread?

No.

JavaScript still runs on a single thread.

---

## Q22. Does await block JavaScript?

No.

It only pauses the current async function.

Other code continues.

---

## Q23. Why doesn't fetch block execution?

Because

```
fetch()

↓

Browser

↓

Network

↓

Promise

↓

Microtask Queue
```

---

## Q24. Difference between callback and Promise?

Callback

```
Nested

Hard to read

Callback Hell
```

Promise

```
Cleaner

Chainable

Better error handling
```

---

## Q25. Difference between Promise and async/await?

Promise

```javascript
.then()
```

Async

```javascript
await
```

Both use Promises internally.

---

## Q26. What is callback hell?

Nested callbacks.

Example

```javascript
A(function(){

B(function(){

C(function(){

});

});

});
```

Hard to maintain.

---

## Q27. What is inversion of control?

Callbacks give control to another function.

Promises solve this issue.

---

## Q28. What happens internally when fetch is called?

```
Call Stack

↓

Browser

↓

Network

↓

Response

↓

Promise

↓

Microtask Queue

↓

Event Loop

↓

Call Stack
```

---

## Q29. What happens when Promise resolves?

Promise callback enters

```
Microtask Queue
```

---

## Q30. What happens if Call Stack is busy?

Queues wait.

Nothing executes until Call Stack becomes empty.

---

# FAANG-Level Questions

---

## Q31. Explain Event Loop with diagram.

Draw

```
Call Stack

↓

Event Loop

↓

Microtask Queue

↓

Callback Queue

↓

Web APIs
```

---

## Q32. Why are Promises faster than Timers?

Not actually faster.

They simply have higher priority.

---

## Q33. Explain fetch internally.

Mention

- Browser API
- Network Thread
- Promise
- Event Loop
- Microtask Queue

---

## Q34. Explain async/await internally.

Compiler converts

```javascript
await
```

into Promise handling.

---

## Q35. Why does setTimeout(fn,0) not execute immediately?

Because

```
Call Stack

↓

Event Loop

↓

Callback Queue
```

---

## Q36. Difference between Browser Event Loop and Node.js Event Loop?

Browser

Uses Web APIs.

Node

Uses libuv.

---

## Q37. Explain libuv.

libuv provides

- Thread Pool
- Event Loop
- File System
- Networking

for Node.js.

---

## Q38. What is starvation?

If Microtasks never stop,

Callback Queue never executes.

---

## Q39. Can JavaScript execute two functions simultaneously?

No.

Only one function executes at a time.

---

## Q40. Explain complete asynchronous execution.

Draw

```
JavaScript

↓

Call Stack

↓

Web API

↓

Network

↓

Promise

↓

Microtask Queue

↓

Event Loop

↓

Call Stack
```

---

# Scenario-Based Questions

---

## Amazon

How are products loaded?

Answer

Multiple asynchronous API calls.

---

## Netflix

How does streaming work?

Chunks are downloaded asynchronously.

---

## WhatsApp

How are messages received?

Using WebSockets asynchronously.

---

## Gmail

Why doesn't sending email freeze UI?

Because email is sent asynchronously.

---

## Google Maps

How does dragging stay smooth?

Only required map tiles are fetched asynchronously.

---

# Coding Interview Questions

Predict the output

```javascript
console.log("A");

setTimeout(() => console.log("B"), 0);

Promise.resolve().then(() => console.log("C"));

console.log("D");
```

Answer

```
A
D
C
B
```

---

```javascript
async function test(){

console.log(1);

await Promise.resolve();

console.log(2);

}

test();

console.log(3);
```

Answer

```
1
3
2
```

---

```javascript
Promise.resolve().then(() => {
    console.log("A");
});

Promise.resolve().then(() => {
    console.log("B");
});
```

Output

```
A
B
```

---

# Common Follow-Up Questions

- Is JavaScript multi-threaded?
- Does async create threads?
- Why are Promises preferred?
- Can Event Loop run while Call Stack is busy?
- Is fetch synchronous?
- Why is Promise callback faster than timer?
- Is await blocking?
- Can multiple Promises execute together?
- What happens when Promise rejects?
- Why is JavaScript called non-blocking?

---

# Interview Cheat Sheet

## Execution Order

```
Synchronous

↓

Microtask Queue

↓

Callback Queue
```

---

## Browser Runtime

```
JavaScript Engine

↓

Call Stack

↓

Web APIs

↓

Event Loop

↓

Microtask Queue

↓

Callback Queue
```

---

## Promise Lifecycle

```
Pending

↓

Fulfilled

OR

Rejected
```

---

## async/await

```
async

↓

Promise

↓

await pauses current function

↓

Other code runs

↓

Resume later
```

---

# Final Interview Tips

✅ Always explain with a diagram.

✅ Mention the Call Stack first.

✅ Then Web APIs or libuv.

✅ Then Event Loop.

✅ Then Queues.

✅ Finally execution order.

This structured explanation is what interviewers expect in companies like Amazon, Microsoft, Google, Adobe, Flipkart, Walmart, and many product-based startups.

---

# Next Chapter

➡️ **20-Coding-Problems.md**

Topics:

- 40+ coding exercises
- Event Loop implementation questions
- Promise exercises
- async/await practice
- fetch challenges
- Timer problems
- Output prediction coding rounds
- Mini interview problems