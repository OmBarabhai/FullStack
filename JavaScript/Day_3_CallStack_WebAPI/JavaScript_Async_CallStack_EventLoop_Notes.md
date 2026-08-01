# JavaScript Asynchronous Programming Fundamentals

## Goal

Understand **how JavaScript executes code** instead of memorizing
definitions.

------------------------------------------------------------------------

# Mental Model

Think of JavaScript like a restaurant.

-   **Customer** → Your code
-   **Manager** → JavaScript Engine
-   **Kitchen Departments** → Browser Web APIs
-   **Waiting Area** → Job Queue
-   **Waiter** → Event Loop

JavaScript (the manager) can do **only one task at a time**.

------------------------------------------------------------------------

# Single Threaded

JavaScript executes one operation at a time.

``` js
console.log("A");
console.log("B");
console.log("C");
```

Output:

    A
    B
    C

------------------------------------------------------------------------

# Call Stack

The **Call Stack** is where JavaScript keeps track of the function
currently executing.

Every function:

1.  Push onto the stack
2.  Execute
3.  Pop from the stack

Example:

``` js
console.log("Hello");
```

    Push console.log()
    ↓

    Execute

    ↓

    Pop

------------------------------------------------------------------------

# Why Asynchronous Programming?

Imagine:

``` js
console.log("Start");

fetch("https://example.com");

console.log("End");
```

If JavaScript waited for the network response:

    Start

    (wait several seconds)

    End

The entire webpage would freeze.

Instead, JavaScript delegates the work.

------------------------------------------------------------------------

# Browser Web APIs

These APIs belong to the browser, not JavaScript.

Examples:

-   fetch()
-   setTimeout()
-   DOM API
-   console

When JavaScript encounters:

``` js
fetch(url)
```

it hands the networking work to the Browser Web API and immediately
continues executing other code.

------------------------------------------------------------------------

# Job Queue

When the asynchronous task finishes:

    fetch()
    ↓

    Download complete

    ↓

    Callback placed into Job Queue

The callback waits until JavaScript becomes free.

------------------------------------------------------------------------

# Event Loop

The Event Loop continuously checks:

    Is the Call Stack empty?

If yes:

    Move callback

    ↓

    Call Stack

    ↓

    Execute callback

------------------------------------------------------------------------

# Complete Flow

``` text
JavaScript Code

        │
        ▼

   CALL STACK

        │
        ▼

fetch()

        │
        ▼

Browser Web API

(Network request)

        │
        ▼

Download Finished

        │
        ▼

JOB QUEUE

        │
        ▼

EVENT LOOP

        │
        ▼

CALL STACK

        │
        ▼

Callback Executes
```

------------------------------------------------------------------------

# Example

``` js
console.log("Start");

fetch("https://example.com")
  .then(() => {
    console.log("Got Data");
  });

console.log("End");
```

Execution:

1.  Print **Start**
2.  Browser starts fetch()
3.  Print **End**
4.  Fetch completes
5.  Callback enters Job Queue
6.  Event Loop moves callback to Call Stack
7.  Print **Got Data**

Output:

    Start
    End
    Got Data

------------------------------------------------------------------------

# Interview Answers

## What is the Call Stack?

The Call Stack is a data structure used by JavaScript to keep track of
currently executing functions. Functions are pushed onto the stack
before execution and removed after completion.

------------------------------------------------------------------------

## What are Web APIs?

Web APIs are browser-provided features such as `fetch()`,
`setTimeout()`, DOM APIs, and `console`. JavaScript delegates
asynchronous work to these APIs.

------------------------------------------------------------------------

## What is the Job Queue?

The Job Queue stores completed asynchronous callbacks until JavaScript
is ready to execute them.

------------------------------------------------------------------------

## What is the Event Loop?

The Event Loop continuously checks whether the Call Stack is empty. When
it is, it moves callbacks from the Job Queue to the Call Stack.

------------------------------------------------------------------------

## Why is JavaScript Single Threaded?

JavaScript executes only one operation at a time using a single Call
Stack. Asynchronous work is performed by Browser Web APIs, not by the
JavaScript engine itself.

------------------------------------------------------------------------

# Key Takeaways

-   JavaScript is single-threaded.
-   Synchronous code executes immediately on the Call Stack.
-   Browser Web APIs handle asynchronous operations.
-   Completed callbacks wait in the Job Queue.
-   The Event Loop moves callbacks to the Call Stack when it becomes
    empty.

Mastering this execution model makes Promises, `async/await`, API calls,
React, and Node.js much easier to understand.
