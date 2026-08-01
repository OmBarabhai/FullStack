# Chapter 7 — Microtask Queue

> **"The Microtask Queue has higher priority than the Task Queue."**

This is one of the most frequently asked JavaScript interview topics.

---

# Table of Contents

1. What is the Microtask Queue?
2. Why was it introduced?
3. Task Queue vs Microtask Queue
4. Which APIs use the Microtask Queue?
5. Promise Execution Flow
6. queueMicrotask()
7. Event Loop Priority
8. Step-by-Step Dry Runs
9. Multiple Promises
10. Promise vs setTimeout
11. Promise vs setInterval
12. Promise Chain Execution
13. Common Misconceptions
14. Real-Life Analogy
15. Interview Questions
16. Coding Exercises
17. Summary

---

# 1. What is the Microtask Queue?

The Microtask Queue is a special queue used for **high-priority asynchronous callbacks**.

Unlike the Task Queue, the Event Loop **always empties the Microtask Queue first**.

Think of it as a VIP queue.

```
Call Stack

↓

Microtask Queue

↓

Task Queue
```

Priority

```
1️⃣ Call Stack

2️⃣ Microtask Queue

3️⃣ Task Queue
```

---

# 2. Why was it introduced?

Imagine updating data immediately after an operation.

```js
Promise.resolve().then(() => {
    console.log("Updated");
});
```

You don't want this waiting behind timers, clicks, or network callbacks.

So JavaScript created a **higher-priority queue**.

---

# 3. Task Queue vs Microtask Queue

| Microtask Queue | Task Queue |
|----------------|------------|
| Promise.then() | setTimeout() |
| catch() | setInterval() |
| finally() | DOM Events |
| queueMicrotask() | Message Events |

Rule:

> **Finish all Microtasks before processing the next Task.**

---

# 4. Which APIs use the Microtask Queue?

These create Microtasks:

```js
Promise.then()

Promise.catch()

Promise.finally()

queueMicrotask()
```

Not Microtasks

```js
setTimeout()

setInterval()

click

scroll

keydown
```

---

# 5. Promise Execution Flow

Example

```js
console.log("Start");

Promise.resolve().then(()=>{
    console.log("Promise");
});

console.log("End");
```

Execution

Step 1

```
Start
```

Step 2

Promise callback goes to

```
Microtask Queue
```

Step 3

```
End
```

Step 4

Call Stack empty

↓

Event Loop

↓

Microtask Queue

↓

Promise callback

Output

```
Start

End

Promise
```

---

# 6. queueMicrotask()

JavaScript provides

```js
queueMicrotask(()=>{
    console.log("Microtask");
});
```

This directly places a callback into the Microtask Queue.

Example

```js
console.log("A");

queueMicrotask(()=>{
console.log("B");
});

console.log("C");
```

Output

```
A

C

B
```

---

# 7. Event Loop Priority

Imagine

```
Microtask Queue

↓

Promise

Promise

Promise

----------------

Task Queue

↓

setTimeout

click

setInterval
```

The Event Loop executes

```
Promise

↓

Promise

↓

Promise

↓

setTimeout

↓

click
```

Microtasks always finish first.

---

# 8. Dry Run

Example

```js
console.log("1");

setTimeout(()=>{
console.log("2");
},0);

Promise.resolve().then(()=>{
console.log("3");
});

console.log("4");
```

Step 1

```
1
```

---

Step 2

Timer starts

↓

Task Queue

---

Step 3

Promise

↓

Microtask Queue

---

Step 4

```
4
```

Call Stack empty

↓

Microtask Queue

↓

```
3
```

↓

Task Queue

↓

```
2
```

Output

```
1

4

3

2
```

---

# 9. Multiple Promises

```js
Promise.resolve().then(()=>{
console.log(1);
});

Promise.resolve().then(()=>{
console.log(2);
});

Promise.resolve().then(()=>{
console.log(3);
});
```

Queue

```
1

↓

2

↓

3
```

Output

```
1

2

3
```

---

# 10. Promise vs setTimeout

```js
setTimeout(()=>{
console.log("Timeout");
},0);

Promise.resolve().then(()=>{
console.log("Promise");
});
```

Output

```
Promise

Timeout
```

Why?

Because

```
Microtask Queue

↓

Task Queue
```

---

# 11. Promise vs setInterval

```js
setInterval(()=>{
console.log("Interval");
},1000);

Promise.resolve().then(()=>{
console.log("Promise");
});
```

Output

```
Promise

Interval
```

Promise wins.

---

# 12. Promise Chain

```js
Promise.resolve()
.then(()=>{
console.log(1);
})
.then(()=>{
console.log(2);
})
.then(()=>{
console.log(3);
});
```

Execution

```
1

↓

2

↓

3
```

Each `.then()` schedules the next microtask after the previous one completes.

---

# 13. Common Misconceptions

### ❌ Promises are synchronous.

Wrong.

Only the Promise constructor runs immediately.

`.then()` callbacks are asynchronous.

---

### ❌ setTimeout(0) executes before Promise.

Wrong.

Promise always wins.

---

### ❌ Microtasks interrupt running code.

Wrong.

The current Call Stack must finish first.

---

### ❌ Only one Microtask executes.

Wrong.

The Event Loop empties the entire Microtask Queue before moving to the Task Queue.

---

# 14. Real-Life Analogy

Imagine an airport.

Normal passengers

```
Task Queue
```

VIP passengers

```
Microtask Queue
```

Before boarding starts

All VIP passengers enter first.

Only then do regular passengers board.

---

# 15. Interview Questions

### What is the Microtask Queue?

A high-priority queue for Promise callbacks and other microtasks.

---

### Which executes first?

```js
Promise.then()

or

setTimeout()
```

Answer

Promise.

---

### Does the Event Loop empty the entire Microtask Queue?

Yes.

Before taking a single Task.

---

### Is queueMicrotask() the same as Promise.then()?

Very similar.

Both schedule Microtasks.

---

### Why do Promises run before timers?

Because Microtasks have higher priority than Tasks.

---

# 16. Coding Exercises

## Exercise 1

Predict

```js
console.log("A");

Promise.resolve().then(()=>{
console.log("B");
});

console.log("C");
```

---

## Exercise 2

Predict

```js
setTimeout(()=>{
console.log("A");
},0);

Promise.resolve().then(()=>{
console.log("B");
});

console.log("C");
```

---

## Exercise 3

Predict

```js
console.log(1);

queueMicrotask(()=>{
console.log(2);
});

console.log(3);
```

---

## Exercise 4

Arrange execution order

```
Call Stack

Microtask Queue

Task Queue
```

for

```js
console.log("Start");

Promise.resolve().then(()=>{
console.log("Promise");
});

setTimeout(()=>{
console.log("Timer");
},0);

console.log("End");
```

---

# 17. Summary

- The Microtask Queue has higher priority than the Task Queue.
- Promise callbacks (`then`, `catch`, `finally`) are stored in the Microtask Queue.
- `queueMicrotask()` also creates a microtask.
- The Event Loop always empties the Microtask Queue before executing any Task.
- This is why `Promise.then()` executes before `setTimeout(..., 0)`.

---

# Visual Memory Trick

```
                Event Loop

                    │
                    ▼

        Is Call Stack Empty?

                    │
               Yes / No

                    │
                    ▼

      Check Microtask Queue First

                    │

      ┌─────────────┴─────────────┐
      │                           │
 Microtasks Exist?             No Microtasks
      │                           │
      ▼                           ▼
 Execute All               Check Task Queue
 Microtasks                      │
      │                           ▼
      └──────────────► Execute One Task
```

---

# Next Chapter

➡️ **08-setTimeout.md**

In the next chapter, you'll master:

- How `setTimeout()` actually works internally
- Why `setTimeout(0)` is never truly instant
- Browser timer internals
- Timer clamping
- Nested timers
- Interview puzzles
- Visual diagrams and dry runs
```