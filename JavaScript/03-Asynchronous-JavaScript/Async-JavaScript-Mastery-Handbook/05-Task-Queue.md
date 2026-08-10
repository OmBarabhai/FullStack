# Chapter 5 — Task Queue (Callback Queue)

> **"The Task Queue is the waiting room for asynchronous callbacks."**

---

# Table of Contents

1. What is the Task Queue?
2. Why is the Task Queue Needed?
3. Synchronous vs Asynchronous Execution
4. FIFO Principle
5. How Callbacks Reach the Task Queue
6. Step-by-Step Execution
7. Call Stack + Web API + Task Queue
8. Multiple Timers
9. Multiple Events
10. setTimeout(0) Myth
11. Real Browser Execution
12. Common Callback Sources
13. Task Queue vs Microtask Queue
14. Common Mistakes
15. Dry Runs
16. Interview Questions
17. Exercises
18. Summary

---

# 1. What is the Task Queue?

The Task Queue (also called the Callback Queue or Macrotask Queue) is a queue where the browser stores callbacks **after asynchronous work is complete**.

It **does not execute** callbacks.

It only **holds them until JavaScript is ready**.

Think of it as a waiting room.

```
JavaScript Busy
↓

Callback waits

↓

Task Queue

↓

Event Loop

↓

Call Stack
```

---

# 2. Why is the Task Queue Needed?

JavaScript has only **one Call Stack**.

Imagine this:

```js
setTimeout(() => {
    console.log("Hello");
}, 1000);

console.log("World");
```

If the callback immediately entered the Call Stack,

what if JavaScript was still executing another function?

There would be two pieces of code trying to execute at once.

That cannot happen.

So the callback waits in the Task Queue.

---

# 3. Synchronous vs Asynchronous

Synchronous

```
console.log("A");
console.log("B");
console.log("C");
```

Execution

```
Call Stack

A

↓

B

↓

C
```

---

Asynchronous

```
console.log("A");

setTimeout(() => {
    console.log("B");
},1000);

console.log("C");
```

Execution

```
A

↓

Timer Starts

↓

C

↓

B
```

Output

```
A
C
B
```

---

# 4. FIFO Principle

Task Queue works on **FIFO**

First In

↓

First Out

Example

```
Queue

Front

A

B

C

Rear
```

Execution order

```
A

↓

B

↓

C
```

---

# 5. How Callbacks Reach the Task Queue

Example

```js
setTimeout(() => {
    console.log("Hello");
},2000);
```

Flow

```
Call Stack

↓

Browser Timer

↓

2 seconds completed

↓

Task Queue

↓

Event Loop

↓

Call Stack
```

Notice

The callback **never directly returns** to JavaScript.

It always waits in the queue.

---

# 6. Step-by-Step Execution

Example

```js
console.log("A");

setTimeout(() => {
    console.log("B");
},2000);

console.log("C");
```

---

## Step 1

```
Call Stack

console.log("A")
```

Output

```
A
```

---

## Step 2

```
setTimeout()

↓

Browser Timer starts
```

Call Stack becomes empty.

---

## Step 3

```
console.log("C")
```

Output

```
A
C
```

---

## Step 4

After two seconds

Browser pushes callback into Task Queue.

```
Task Queue

↓

console.log("B")
```

---

## Step 5

Event Loop checks

```
Is Call Stack empty?

YES
```

Move callback.

---

## Step 6

```
Call Stack

↓

console.log("B")
```

Output

```
A
C
B
```

---

# 7. Complete Visualization

```
console.log("A");

setTimeout(B,2000);

console.log("C");
```

Initially

```
Call Stack

↓

console.log(A)

↓

setTimeout

↓

console.log(C)
```

Browser

```
Timer

2 sec
```

Task Queue

```
Empty
```

---

After 2 seconds

```
Call Stack

Empty
```

Task Queue

```
B
```

---

Event Loop

Moves

```
B

↓

Call Stack
```

Output

```
A
C
B
```

---

# 8. Multiple Timers

Example

```js
setTimeout(()=>console.log(1),1000);

setTimeout(()=>console.log(2),3000);

setTimeout(()=>console.log(3),2000);
```

Timers finish

```
1 sec

↓

Queue

↓

1

---------------

2 sec

↓

Queue

↓

3

---------------

3 sec

↓

Queue

↓

2
```

Output

```
1
3
2
```

---

# 9. Multiple Events

Imagine

```
User clicks

↓

click callback

↓

Task Queue
```

Keyboard

↓

```
keypress callback

↓

Task Queue
```

Scroll

↓

```
scroll callback

↓

Task Queue
```

Everything waits.

---

# 10. setTimeout(0) Myth

Many beginners think

```js
setTimeout(fn,0);
```

runs immediately.

Wrong.

It still goes

```
Browser

↓

Task Queue

↓

Event Loop

↓

Call Stack
```

Example

```js
console.log("A");

setTimeout(()=>{
console.log("B");
},0);

console.log("C");
```

Output

```
A
C
B
```

Because the callback must wait for the Call Stack to become empty.

---

# 11. Real Browser Execution

Example

```js
button.addEventListener("click",()=>{
console.log("Clicked");
});
```

When the user clicks

```
Browser

↓

Task Queue

↓

Event Loop

↓

Call Stack

↓

console.log()
```

---

# 12. Common Callback Sources

These place callbacks into the Task Queue:

- `setTimeout`
- `setInterval`
- DOM Events (`click`, `scroll`, `keydown`)
- Message Events
- Network events (after completion)
- I/O callbacks

---

# 13. Task Queue vs Microtask Queue

Task Queue

- setTimeout
- setInterval
- DOM events

Microtask Queue

- Promise.then()
- catch()
- finally()
- queueMicrotask()

The Event Loop always processes **all Microtasks before the next Task**.

(We'll study this in the next chapters.)

---

# 14. Common Mistakes

❌ Thinking callbacks execute immediately.

Wrong.

---

❌ Thinking `setTimeout(0)` skips the queue.

Wrong.

---

❌ Thinking Task Queue executes code.

Wrong.

Only the **Call Stack executes code**.

---

# 15. Dry Run

```js
console.log(1);

setTimeout(() => {
    console.log(2);
},0);

console.log(3);
```

### Step 1

Call Stack

```
console.log(1)
```

Output

```
1
```

---

### Step 2

```
setTimeout()

↓

Browser Timer
```

---

### Step 3

```
console.log(3)
```

Output

```
1
3
```

---

### Step 4

Timer completes.

Task Queue

```
2
```

---

### Step 5

Call Stack empty.

Event Loop moves callback.

Output

```
1
3
2
```

---

# 16. Interview Questions

### What is the Task Queue?

A queue that stores completed asynchronous callbacks until the Call Stack becomes empty.

---

### Does the Task Queue execute callbacks?

No.

The Call Stack executes callbacks.

---

### Who moves callbacks from the Task Queue?

The Event Loop.

---

### Does `setTimeout(0)` execute immediately?

No.

It always waits until the Call Stack is empty.

---

### Why is the Task Queue needed?

Because JavaScript is single-threaded and cannot execute multiple functions simultaneously.

---

# 17. Exercises

## Exercise 1

Predict the output.

```js
console.log("A");

setTimeout(()=>{
    console.log("B");
},0);

console.log("C");
```

---

## Exercise 2

Predict the output.

```js
setTimeout(()=>{
    console.log(1);
},3000);

setTimeout(()=>{
    console.log(2);
},1000);

setTimeout(()=>{
    console.log(3);
},2000);
```

---

## Exercise 3

Explain why `setTimeout(fn,0)` still waits.

---

## Exercise 4

Draw the Task Queue after each step for:

```js
console.log("Start");

setTimeout(()=>{
    console.log("Timer");
},0);

console.log("End");
```

---

# 18. Summary

- The Task Queue stores completed asynchronous callbacks.
- It follows the FIFO (First In, First Out) principle.
- Only the Event Loop can move callbacks from the Task Queue to the Call Stack.
- The Call Stack is the only place where JavaScript executes code.
- `setTimeout(0)` does **not** execute immediately—it still waits for the Call Stack to become empty.
- Understanding the Task Queue is essential before learning the Event Loop and Microtask Queue.

---

# Next Chapter

➡️ **06-Event-Loop.md**

In the next chapter, you'll learn:

- What the Event Loop really does
- How it continuously checks the Call Stack
- How it coordinates the Task Queue and Microtask Queue
- Why Promises run before `setTimeout`
- Deep execution diagrams and interview-level dry runs