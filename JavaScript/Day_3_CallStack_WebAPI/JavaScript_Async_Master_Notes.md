# JavaScript Async Programming Master Notes

## 1. Why JavaScript Needs Asynchronous Programming

JavaScript is **single-threaded**, meaning it executes one task at a
time using a single Call Stack.

If JavaScript waited for slow operations like API requests or timers,
the entire page would freeze. To avoid this, it delegates these tasks to
the browser.

------------------------------------------------------------------------

## 2. JavaScript Runtime Components

### Call Stack

-   Executes synchronous code.
-   Functions are pushed when called.
-   Functions are popped after execution.

### Browser Web APIs

These are provided by the browser, not JavaScript.

Examples: - fetch() - setTimeout() - DOM APIs - console

### Callback Queue (Task Queue)

Completed callbacks from timers and events wait here.

### Microtask Queue

Higher priority queue used by: - Promise.then() - Promise.catch() -
Promise.finally() - queueMicrotask()

### Event Loop

Continuously checks: 1. Is the Call Stack empty? 2. Execute every
Microtask. 3. Execute one Callback Queue task. 4. Repeat.

------------------------------------------------------------------------

## 3. Execution Flow

``` js
console.log("Start");

fetch("https://example.com")
  .then(() => console.log("Data"));

console.log("End");
```

Step-by-step:

1.  Print Start.
2.  Browser starts fetch().
3.  JavaScript continues immediately.
4.  Print End.
5.  Response arrives.
6.  Promise callback enters Microtask Queue.
7.  Event Loop waits until Call Stack is empty.
8.  Callback executes.

Output:

    Start
    End
    Data

------------------------------------------------------------------------

## 4. Visual Diagram

    Your Code
        |
        v
    +-------------+
    | Call Stack  |
    +-------------+
          |
          v
    +-------------+
    | Browser API |
    +-------------+
          |
          v
    +-----------------+
    | Microtask Queue |
    +-----------------+
          |
          v
    +---------------+
    | Callback Queue|
    +---------------+
          ^
          |
    +-------------+
    | Event Loop  |
    +-------------+

------------------------------------------------------------------------

## 5. Callback Queue vs Microtask Queue

  Callback Queue   Microtask Queue
  ---------------- -----------------
  setTimeout       Promise.then
  setInterval      Promise.catch
  DOM events       queueMicrotask

**Microtasks always execute before Callback Queue tasks.**

------------------------------------------------------------------------

## 6. Interview Questions

### Why is JavaScript single-threaded?

Because it has one Call Stack and executes one instruction at a time.

### Who performs fetch()?

The Browser Web API performs the network request.

### What does the Event Loop do?

It moves ready callbacks into the Call Stack when it becomes empty.

### Why does `End` print before `Data`?

Because fetch() is asynchronous. JavaScript does not wait for the
network request.

------------------------------------------------------------------------

## 7. Common Mistakes

❌ Thinking fetch() blocks execution.

❌ Thinking Event Loop executes code.

The Event Loop only schedules execution.

------------------------------------------------------------------------

## 8. Remember This

    Synchronous
    ↓

    Call Stack

    ↓

    Asynchronous Task

    ↓

    Browser Web API

    ↓

    Queue

    ↓

    Event Loop

    ↓

    Call Stack

    ↓

    Output

This execution model is the foundation for Promises, async/await, React,
Node.js, and modern JavaScript interviews.
