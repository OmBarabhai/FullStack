# Chapter 8 — setTimeout()

> **"setTimeout() does NOT pause JavaScript. It only schedules work for the future."**

This is one of the most misunderstood JavaScript APIs and one of the most frequently asked interview topics.

---

# Table of Contents

1. What is setTimeout()?
2. Syntax
3. How setTimeout() Works Internally
4. Why setTimeout() Doesn't Block JavaScript
5. Browser Internals
6. Complete Execution Flow
7. Visual Diagram
8. setTimeout(0)
9. Multiple Timers
10. Nested Timers
11. Cancelling Timers
12. Common Mistakes
13. Real-Life Examples
14. Dry Runs
15. Interview Questions
16. Coding Exercises
17. Summary

---

# 1. What is setTimeout()?

`setTimeout()` is a Browser (or Node.js) API that schedules a callback to run **after at least a specified delay**.

It **does NOT execute the callback immediately.**

Instead, it:

- Starts a timer.
- Waits for the timer to finish.
- Places the callback into the Task Queue.
- Waits for the Event Loop.
- Executes when the Call Stack is empty.

---

# 2. Syntax

```javascript
setTimeout(callback, delay);
```

Example

```javascript
setTimeout(() => {
    console.log("Hello");
}, 2000);
```

Meaning

```
Wait at least 2000 ms

↓

Queue callback

↓

Execute when Call Stack becomes empty
```

---

# 3. How setTimeout() Works Internally

Consider

```javascript
console.log("Start");

setTimeout(() => {
    console.log("Timer");
}, 3000);

console.log("End");
```

Execution

### Step 1

```
Call Stack

↓

console.log("Start")
```

Output

```
Start
```

---

### Step 2

```
Call Stack

↓

setTimeout()
```

Browser receives

```
Callback

Delay = 3000 ms
```

Browser starts timer.

JavaScript DOES NOT wait.

---

### Step 3

```
Call Stack

↓

console.log("End")
```

Output

```
Start

End
```

---

### Step 4

After 3 seconds

Browser pushes callback

```
Task Queue

↓

console.log("Timer")
```

---

### Step 5

Event Loop checks

```
Call Stack Empty?

YES
```

Moves callback.

---

### Step 6

```
Call Stack

↓

console.log("Timer")
```

Output

```
Start

End

Timer
```

---

# 4. Why Doesn't setTimeout() Block JavaScript?

Imagine

```javascript
setTimeout(()=>{
console.log("Hello");
},5000);

console.log("World");
```

If JavaScript waited 5 seconds...

Everything would freeze.

Instead

```
Timer

↓

Browser

↓

JavaScript continues
```

Output

```
World

Hello
```

---

# 5. Browser Internals

```
JavaScript

↓

Call Stack

↓

setTimeout()

↓

Browser Timer

↓

Task Queue

↓

Event Loop

↓

Call Stack

↓

Callback Executes
```

---

# 6. Complete Flow Diagram

```
          JavaScript

               │

               ▼

         setTimeout()

               │

               ▼

        Browser Timer

               │

        Delay Finished

               ▼

         Task Queue

               │

         Event Loop

               │

               ▼

         Call Stack

               │

               ▼

       Callback Executes
```

---

# 7. Visual Example

```javascript
console.log("A");

setTimeout(() => {
    console.log("B");
},2000);

console.log("C");
```

Timeline

```
0 sec

A

↓

Timer starts

↓

C

---------------

2 sec

↓

Task Queue

↓

Event Loop

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

# 8. setTimeout(0)

Many beginners think

```javascript
setTimeout(fn,0);
```

means

```
Run immediately.
```

Wrong.

It means

```
Run AFTER current JavaScript finishes.
```

Example

```javascript
console.log("A");

setTimeout(()=>{
console.log("B");
},0);

console.log("C");
```

Execution

```
A

↓

Timer

↓

C

↓

Queue

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

# 9. Multiple Timers

```javascript
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

Timeline

```
1 sec

↓

2

--------------

2 sec

↓

3

--------------

3 sec

↓

1
```

Output

```
2

3

1
```

---

# 10. Nested Timers

```javascript
setTimeout(()=>{
    console.log("A");

    setTimeout(()=>{
        console.log("B");
    },1000);

},1000);
```

Timeline

```
1 sec

↓

A

↓

Start second timer

↓

1 sec

↓

B
```

Output

```
A

B
```

---

# 11. Cancelling Timers

Every `setTimeout()` returns an ID.

```javascript
const id = setTimeout(() => {
    console.log("Hello");
},3000);
```

Cancel it

```javascript
clearTimeout(id);
```

Now

```
Hello

never prints.
```

---

# 12. Common Mistakes

### Mistake 1

Thinking

```javascript
setTimeout()

↓

Callback immediately runs
```

Wrong.

---

### Mistake 2

Thinking

```javascript
setTimeout(0)
```

means

```
Instant execution.
```

Wrong.

---

### Mistake 3

Thinking delay is exact.

Wrong.

It means

```
Minimum delay.
```

If JavaScript is busy...

The callback waits longer.

---

# 13. Real-Life Example

Imagine ordering food.

```
You place order

↓

Restaurant cooks

↓

Food ready

↓

Waiter brings food

↓

You eat
```

Mapping

```
Restaurant

↓

Browser

Food Ready

↓

Task Queue

Waiter

↓

Event Loop

Eat

↓

Call Stack
```

---

# 14. Dry Runs

## Example 1

```javascript
console.log(1);

setTimeout(()=>{
console.log(2);
},1000);

console.log(3);
```

Output

```
1

3

2
```

---

## Example 2

```javascript
setTimeout(()=>{
console.log("A");
},0);

console.log("B");
```

Output

```
B

A
```

---

## Example 3

```javascript
console.log("Start");

setTimeout(()=>{
console.log("Timer");
},0);

console.log("End");
```

Output

```
Start

End

Timer
```

---

# 15. Interview Questions

### What is setTimeout()?

A Browser (or Node.js) API that schedules a callback after at least the specified delay.

---

### Does setTimeout() pause JavaScript?

No.

---

### Where is the timer managed?

Browser Web APIs (or Node.js runtime).

---

### Where does the callback go after the timer finishes?

Task Queue.

---

### Who moves it into the Call Stack?

Event Loop.

---

### Is setTimeout(0) immediate?

No.

---

### Does delay guarantee exact timing?

No.

Only the **minimum delay** is guaranteed.

---

### Can setTimeout() be cancelled?

Yes.

Using

```javascript
clearTimeout(id);
```

---

# 16. Coding Exercises

## Exercise 1

Predict

```javascript
console.log("A");

setTimeout(()=>{
console.log("B");
},1000);

console.log("C");
```

---

## Exercise 2

Predict

```javascript
setTimeout(()=>{
console.log(1);
},0);

console.log(2);
```

---

## Exercise 3

Predict

```javascript
console.log("Start");

setTimeout(()=>{
console.log("Middle");
},2000);

console.log("End");
```

---

## Exercise 4

Cancel this timer

```javascript
const id = setTimeout(()=>{
console.log("Hello");
},5000);
```

---

# 17. Summary

- `setTimeout()` schedules future execution.
- It never blocks JavaScript.
- The browser manages the timer.
- After the delay, the callback enters the Task Queue.
- The Event Loop moves the callback to the Call Stack.
- `setTimeout(0)` still waits until the Call Stack is empty.
- The specified delay is a **minimum**, not an exact guarantee.
- `clearTimeout()` cancels scheduled timers.

---

# Visual Memory Trick

```
setTimeout()

        │
        ▼

 Browser Timer

        │
        ▼

 Delay Completed

        │
        ▼

 Task Queue

        │
        ▼

 Event Loop

        │
        ▼

 Call Stack

        │
        ▼

 Execute Callback
```

---

# Next Chapter

➡️ **09-setInterval.md**

You'll learn:

- How `setInterval()` works internally
- Difference between `setTimeout()` and `setInterval()`
- Why `setInterval()` can cause performance issues
- How to stop intervals with `clearInterval()`
- Recursive `setTimeout()` vs `setInterval()`
- Real-world examples, interview questions, and dry runs