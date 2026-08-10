# Chapter 6 — Event Loop

> **"The Event Loop is the traffic police of JavaScript."**

It constantly checks whether JavaScript is free to execute another callback.

---

# Table of Contents

1. What is the Event Loop?
2. Why is the Event Loop Needed?
3. Event Loop Responsibilities
4. Complete Execution Cycle
5. Event Loop Algorithm
6. Event Loop Visualization
7. Step-by-Step Dry Run
8. Multiple Timers
9. DOM Events
10. Why JavaScript Never Stops
11. Event Loop + Task Queue
12. Event Loop + Microtask Queue
13. Browser Rendering
14. Common Misconceptions
15. Real-Life Analogy
16. Dry Runs
17. Interview Questions
18. Exercises
19. Summary

---

# 1. What is the Event Loop?

The Event Loop is a process inside the JavaScript Runtime.

It continuously checks

- Is the Call Stack empty?
- Are there callbacks waiting?
- If yes, move one callback into the Call Stack.

It never executes code itself.

It only manages execution.

---

# 2. Why is the Event Loop Needed?

Imagine JavaScript without an Event Loop.

```
Call Stack

↓

Empty

↓

Nothing happens
```

Now imagine

```
setTimeout()

↓

Browser finishes timer

↓

Callback waiting
```

How does the callback enter the Call Stack?

Answer

The Event Loop moves it.

Without the Event Loop,

callbacks would wait forever.

---

# 3. Responsibilities of the Event Loop

The Event Loop

✅ Watches the Call Stack

✅ Watches the Microtask Queue

✅ Watches the Task Queue

✅ Moves callbacks

It NEVER

❌ Executes JavaScript

❌ Runs functions

The Call Stack executes functions.

---

# 4. Complete Execution Cycle

```
JavaScript Code

↓

Call Stack

↓

Web API

↓

Task Queue

↓

Event Loop

↓

Call Stack
```

---

# 5. Event Loop Algorithm

Imagine the Event Loop repeating forever.

```
while(true){

    if(Call Stack is empty){

        if(Microtask Queue not empty){

            Move one microtask

        }

        else if(Task Queue not empty){

            Move one task

        }

    }

}
```

Notice

Microtasks have higher priority.

We'll study that later.

---

# 6. Visual Diagram

```
                 JavaScript Runtime

        +-----------------------------+

        |       Call Stack            |

        +-------------▲---------------+

                      |

               Event Loop

                      |

      +---------------+---------------+

      |                               |

Microtask Queue                 Task Queue

      |                               |

 Promise.then()                setTimeout()

 queueMicrotask()              click()

 catch()                       setInterval()

 finally()                     fetch callback

      ▲                               ▲

      |                               |

      +----------- Browser -----------+

```

---

# 7. Step-by-Step Example

Example

```js
console.log("A");

setTimeout(()=>{
    console.log("B");
},2000);

console.log("C");
```

---

Step 1

Call Stack

```
console.log("A")
```

Output

```
A
```

---

Step 2

```
setTimeout()
```

Browser starts timer.

Call Stack becomes empty.

---

Step 3

```
console.log("C")
```

Output

```
A
C
```

---

Step 4

Two seconds later

Browser pushes callback

```
Task Queue

↓

console.log("B")
```

---

Step 5

Event Loop checks

```
Call Stack Empty?

YES
```

Moves callback.

---

Step 6

Call Stack

```
console.log("B")
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
setTimeout(()=>{
console.log("One");
},1000);

setTimeout(()=>{
console.log("Two");
},2000);

setTimeout(()=>{
console.log("Three");
},3000);
```

Timeline

```
1 sec

↓

Queue

↓

One

-----------

2 sec

↓

Queue

↓

Two

-----------

3 sec

↓

Queue

↓

Three
```

Output

```
One

Two

Three
```

---

# 9. DOM Events

Example

```js
button.addEventListener("click",()=>{
console.log("Clicked");
});
```

User clicks.

Browser

↓

```
Task Queue

↓

click callback
```

Event Loop

↓

```
Call Stack
```

Output

```
Clicked
```

---

# 10. Why JavaScript Never Stops

The Event Loop runs forever.

Think

```
while(true){

check stack

check queues

move callback

repeat

}
```

Even when nothing happens,

the Event Loop keeps waiting.

---

# 11. Event Loop + Task Queue

Example

```js
setTimeout(()=>{
console.log(1);
},0);

console.log(2);
```

Execution

```
Call Stack

↓

2

↓

Empty

↓

Event Loop

↓

1
```

Output

```
2

1
```

---

# 12. Event Loop + Microtask Queue

Suppose

```
Task Queue

↓

setTimeout

---------------

Microtask Queue

↓

Promise.then()
```

Event Loop chooses

```
Promise.then()

FIRST
```

Microtasks always win.

---

# 13. Browser Rendering

The browser also paints the screen.

Simplified cycle

```
Run JS

↓

Run Microtasks

↓

Render Screen

↓

Run Task

↓

Render Again
```

This is why heavy JavaScript can freeze the UI.

---

# 14. Common Misconceptions

### ❌ Event Loop executes JavaScript.

Wrong.

Call Stack executes JavaScript.

---

### ❌ Event Loop is inside the Browser only.

Wrong.

Node.js also has an Event Loop.

---

### ❌ Event Loop waits for timers.

Wrong.

The Browser waits for timers.

The Event Loop only moves callbacks.

---

### ❌ Event Loop checks Task Queue first.

Wrong.

It checks the Microtask Queue first.

---

# 15. Real-Life Analogy

Imagine a restaurant.

Chef

↓

```
Call Stack
```

Orders

↓

```
Task Queue
```

Manager

↓

```
Event Loop
```

The manager never cooks.

He simply hands the next order to the chef whenever the chef is free.

---

# 16. Dry Runs

## Example 1

```js
console.log("A");

setTimeout(()=>{
console.log("B");
},0);

console.log("C");
```

Step-by-step

```
A

↓

Timer Starts

↓

C

↓

Timer completes

↓

Queue

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

## Example 2

```js
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

# 17. Interview Questions

### What is the Event Loop?

A process that continuously checks whether the Call Stack is empty and moves callbacks from the queues into it.

---

### Does the Event Loop execute code?

No.

The Call Stack executes code.

---

### What does the Event Loop monitor?

- Call Stack
- Microtask Queue
- Task Queue

---

### Why is the Event Loop important?

Without it, asynchronous callbacks would never execute.

---

### Which queue has higher priority?

Microtask Queue.

---

### Who creates the Task Queue?

The Browser (or Node.js runtime).

---

### Does the Event Loop ever stop?

No.

It keeps running as long as the runtime is alive.

---

# 18. Exercises

## Exercise 1

Predict the output

```js
console.log("Start");

setTimeout(()=>{
console.log("Timer");
},0);

console.log("End");
```

---

## Exercise 2

Draw

```
Call Stack

↓

Browser

↓

Task Queue

↓

Event Loop

↓

Call Stack
```

for

```js
setTimeout(()=>{
console.log("A");
},1000);
```

---

## Exercise 3

Explain why callbacks cannot enter the Call Stack directly.

---

## Exercise 4

Explain the role of the Event Loop using your own words.

---

# 19. Summary

- JavaScript is single-threaded.
- The Event Loop continuously checks the Call Stack.
- If the Call Stack is empty, it moves callbacks into it.
- The Event Loop does **not** execute JavaScript.
- The Call Stack executes JavaScript.
- Task Queue stores asynchronous callbacks.
- Microtask Queue has higher priority than the Task Queue.
- Understanding the Event Loop is the key to mastering asynchronous JavaScript.

---

# Memory Trick

Remember this sentence:

> **Browser does the work → Queue stores the callback → Event Loop delivers the callback → Call Stack executes the callback.**

```
Browser
   ↓
Queue
   ↓
Event Loop
   ↓
Call Stack
   ↓
Execution
```

---

# Next Chapter

➡️ **07-Microtask-Queue.md**

You'll learn:

- What is the Microtask Queue?
- Why Promises run before `setTimeout()`
- Promise execution order
- `queueMicrotask()`
- Advanced Event Loop behavior
- Interview puzzles and dry runs
- Visual comparisons between Microtask Queue and Task Queue