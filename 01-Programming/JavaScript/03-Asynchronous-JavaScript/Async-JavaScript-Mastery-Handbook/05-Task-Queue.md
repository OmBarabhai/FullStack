# 05 — Task Queue (Callback Queue)

**Folder:** `03-Asynchronous-JavaScript`

> **Core idea:** A task queue holds callbacks that are ready for a future JavaScript execution turn; it does not execute JavaScript itself.

---

# 1. What Is the Task Queue?

The **Task Queue**, commonly discussed as the **task queue** in the browser event-loop model, is a place where tasks wait until JavaScript can receive an execution turn.

A useful mental model:

```text
Host / Browser
      ↓
Task becomes ready
      ↓
Task Queue
      ↓
Event Loop / scheduling
      ↓
Call Stack
      ↓
JavaScript executes
```

Important:

```text
Task Queue
→ waits

Call Stack
→ executes
```

The queue itself does not execute callbacks.

---

# 2. Why Is the Task Queue Needed?

JavaScript execution on the main thread cannot normally execute two JavaScript jobs at the same time.

Consider:

```js
setTimeout(() => {
    console.log("Hello");
}, 1000);

console.log("World");
```

The timer callback cannot simply interrupt whatever JavaScript is already executing.

Instead:

```text
Timer becomes ready
      ↓
Task waits
      ↓
JavaScript finishes current work
      ↓
Callback gets an execution turn
```

This separation helps the runtime coordinate asynchronous work with JavaScript execution.

---

# 3. Task Is Not the Same as "Any Callback"

This distinction is important.

A task is a scheduled unit of work in the host/event-loop model.

For learning purposes, examples include:

```text
timer callbacks
user interaction events
some other host-scheduled tasks
```

Do not memorize:

```text
"Every callback = Task Queue"
```

because different asynchronous mechanisms have different scheduling rules.

In particular:

```text
Promise reactions
→ microtask/job processing

Timer/event tasks
→ task processing
```

The distinction becomes critical in the Event Loop and Microtask Queue topics.

---

# 4. Synchronous vs Asynchronous

Synchronous example:

```js
console.log("A");
console.log("B");
console.log("C");
```

Conceptually:

```text
A
 ↓
B
 ↓
C
```

The current JavaScript execution proceeds directly through these statements.

Now:

```js
console.log("A");

setTimeout(() => {
    console.log("B");
}, 0);

console.log("C");
```

The high-level result is:

```text
A
C
B
```

Why?

```text
A
 ↓
setTimeout() schedules timer
 ↓
C
 ↓
timer callback becomes eligible
 ↓
task scheduling
 ↓
callback gets a later execution turn
 ↓
B
```

The callback is not inserted in the middle of the current synchronous execution.

---

# 5. FIFO — But Do Not Oversimplify It

You will often hear:

```text
FIFO
First In
First Out
```

This is a useful basic queue model.

Example:

```text
Queue

Front                 Rear
  ↓                     ↓
 [A] [B] [C]
```

If these tasks are eligible in that order:

```text
A
↓
B
↓
C
```

But do not turn this into an absolute rule that every asynchronous callback globally executes in one simple FIFO line.

Real browser scheduling has:

```text
different task sources
different scheduling rules
microtasks
rendering opportunities
```

For beginner reasoning, use FIFO as the basic queue model and learn the more precise event-loop rules later.

---

# 6. How a Timer Reaches the Task Queue

Example:

```js
setTimeout(() => {
    console.log("Hello");
}, 2000);
```

High-level flow:

```text
JavaScript
    ↓
setTimeout()
    ↓
Timer registered with host
    ↓
JavaScript continues
    ↓
Timer delay elapses
    ↓
Callback becomes eligible as a task
    ↓
Task waits for an execution turn
    ↓
Call Stack can receive it
    ↓
Callback executes
```

Important:

```text
2000 ms
≠
"execute exactly at 2000 ms"
```

The delay indicates when the callback can become eligible.

It may execute later.

---

# 7. Step-by-Step Dry Run

Consider:

```js
console.log("A");

setTimeout(() => {
    console.log("B");
}, 2000);

console.log("C");
```

## Step 1

```js
console.log("A");
```

Output:

```text
A
```

---

## Step 2

```js
setTimeout(...)
```

The host registers the timer.

The current JavaScript execution does not stop.

---

## Step 3

```js
console.log("C");
```

Output becomes:

```text
A
C
```

---

## Step 4

After the timer delay has elapsed:

```text
callback becomes eligible
```

The callback can now wait for its execution turn.

---

## Step 5

When JavaScript is able to receive the task:

```text
Task
  ↓
Call Stack
  ↓
console.log("B")
```

Final output:

```text
A
C
B
```

---

# 8. Call Stack + Task Queue

The relationship is:

```text
             Task Queue
                 │
                 │ ready task
                 ▼
            Event Loop
                 │
                 ▼
             Call Stack
                 │
                 ▼
          JavaScript runs
```

The important separation:

```text
Task Queue
→ stores/waits

Call Stack
→ executes
```

A task is not executing while it is merely waiting in the queue.

---

# 9. `setTimeout(0)` Myth

A very common misconception:

```js
setTimeout(fn, 0);
```

means:

> "Run `fn` immediately."

Wrong.

It means approximately:

> "Make the timer callback eligible as soon as the timer constraints allow; it still has to wait for an execution turn."

Example:

```js
console.log("A");

setTimeout(() => {
    console.log("B");
}, 0);

console.log("C");
```

Expected output:

```text
A
C
B
```

Why?

```text
console.log("A")
        ↓
setTimeout()
        ↓
console.log("C")
        ↓
current synchronous work completes
        ↓
timer task becomes eligible
        ↓
callback gets a later turn
        ↓
console.log("B")
```

So:

```text
0 ms delay
≠
0 ms execution time
```

---

# 10. Multiple Timers

Example:

```js
setTimeout(() => {
    console.log("1");
}, 1000);

setTimeout(() => {
    console.log("2");
}, 3000);

setTimeout(() => {
    console.log("3");
}, 2000);
```

At the simplest level:

```text
~1s → timer 1 eligible
~2s → timer 3 eligible
~3s → timer 2 eligible
```

So, if nothing else delays execution:

```text
1
3
2
```

But remember:

> Timers provide a minimum delay/eligibility condition, not an exact execution timestamp.

---

# 11. Blocking the Call Stack

Now consider:

```js
setTimeout(() => {
    console.log("Timer");
}, 0);

for (let i = 0; i < 1000000000; i++) {
    // expensive synchronous work
}

console.log("Done");
```

The timer can become eligible while the long loop is running.

But the callback cannot execute in the middle of that ongoing JavaScript job.

Conceptually:

```text
Timer becomes ready
        ↓
Task waits
        ↓
Long synchronous work continues
        ↓
"Done"
        ↓
current job finishes
        ↓
callback gets an execution turn
```

This is one of the most important reasons:

```text
setTimeout(..., 0)
```

does not guarantee immediate execution.

---

# 12. User Events

A browser can detect user actions such as:

```text
click
keydown
keyup
pointer events
other browser events
```

Example:

```js
button.addEventListener("click", () => {
    console.log("Clicked");
});
```

High-level model:

```text
User click
    ↓
Browser handles event
    ↓
event task becomes eligible
    ↓
JavaScript execution turn
    ↓
callback executes
```

Do not think the event callback is permanently sitting inside the Call Stack waiting for the user.

The stack only contains active JavaScript execution.

---

# 13. Network Work and Tasks

Do not use the simplified rule:

```text
"Every network callback goes into the Task Queue."
```

Network operations are more complicated because:

```text
Fetch
→ Promise
→ Promise reactions
→ microtask processing
```

can be involved.

This is why the distinction between:

```text
Task
vs
Microtask
```

is important.

We will study Fetch and Promises more precisely later.

---

# 14. Task Queue vs Microtask Queue

This is one of the most important distinctions in this folder.

### Task

Examples include:

```text
timer tasks
user interaction tasks
other host tasks
```

### Microtask

Examples include:

```js
Promise.then(...)
Promise.catch(...)
Promise.finally(...)
queueMicrotask(...)
```

Simplified model:

```text
Current JavaScript task
        ↓
Microtasks
        ↓
Next task
```

The runtime processes microtasks at defined points between tasks, and this ordering is why Promise callbacks can run before a timer task that was scheduled around the same time.

The detailed microtask rules will be covered separately.

---

# 15. Why the Queue Does Not Execute Code

Suppose:

```text
Task Queue
────────────
callback A
callback B
callback C
```

These callbacks are only waiting.

The queue itself does not "run" them.

Execution happens when the runtime gives JavaScript a turn:

```text
Task Queue
    ↓
Scheduling / Event Loop
    ↓
Call Stack
    ↓
callback executes
```

This distinction is extremely important for interviews.

---

# 16. Common Mistakes

### ❌ "`setTimeout(0)` executes immediately"

Wrong.

It still waits for a later execution opportunity.

### ❌ "The Task Queue executes callbacks"

Wrong.

It holds ready work.

JavaScript executes when the callback gets an execution turn.

### ❌ "The Call Stack and Task Queue are the same"

Wrong.

```text
Call Stack → active execution
Task Queue → waiting tasks
```

### ❌ "Every asynchronous callback is a task"

Too broad.

Different mechanisms have different scheduling semantics.

### ❌ "Timer 1000 ms always executes before timer 2000 ms exactly one second later"

Not guaranteed.

Other work can delay execution.

### ❌ "A timer can interrupt a running synchronous function"

Not in the normal single-threaded JavaScript execution model.

The current JavaScript work must yield/finish before another task gets its turn.

---

# 17. Dry Run 1

```js
console.log(1);

setTimeout(() => {
    console.log(2);
}, 0);

console.log(3);
```

Reasoning:

```text
1
 ↓
timer scheduled
 ↓
3
 ↓
current synchronous work completes
 ↓
timer task
 ↓
2
```

Output:

```text
1
3
2
```

---

# 18. Dry Run 2

```js
setTimeout(() => {
    console.log(1);
}, 3000);

setTimeout(() => {
    console.log(2);
}, 1000);

setTimeout(() => {
    console.log(3);
}, 2000);
```

Basic expected order:

```text
2
3
1
```

Reason:

```text
~1s → 2 eligible
~2s → 3 eligible
~3s → 1 eligible
```

Again, exact runtime timing can be later than those delays.

---

# 19. Dry Run 3 — Blocking

```js
console.log("Start");

setTimeout(() => {
    console.log("Timer");
}, 0);

for (let i = 0; i < 1000000000; i++) {}

console.log("End");
```

Expected ordering:

```text
Start
End
Timer
```

The timer cannot interrupt the long synchronous loop.

---

# 20. Dry Run 4 — Event

```js
button.addEventListener("click", () => {
    console.log("Clicked");
});
```

Conceptual flow:

```text
User click
    ↓
Browser event handling
    ↓
event task
    ↓
JavaScript execution turn
    ↓
callback
    ↓
"Clicked"
```

The callback is not permanently stored on the Call Stack.

---

# 21. Interview Questions

### What is the Task Queue?

A scheduling queue containing tasks that are ready for a future JavaScript execution turn.

### Does the Task Queue execute callbacks?

No.

It stores/waits for tasks.

### What executes a callback?

The callback executes when it gets a JavaScript execution turn on the Call Stack.

### Does `setTimeout(fn, 0)` run immediately?

No.

The callback becomes eligible after the timer constraints, but it still has to wait for an execution opportunity.

### Why does `setTimeout(0)` run after current synchronous code?

Because the current JavaScript job must finish before the callback gets another execution turn.

### Is everything asynchronous a task?

No.

Different scheduling mechanisms use different queues/job semantics.

### What is FIFO?

First In, First Out.

It is a useful basic model for queue behavior, but browser scheduling is more nuanced than one universal FIFO queue.

---

# 22. Practice

## Exercise 1

Predict:

```js
console.log("A");

setTimeout(() => {
    console.log("B");
}, 0);

console.log("C");
```

---

## Exercise 2

Predict:

```js
setTimeout(() => {
    console.log(1);
}, 3000);

setTimeout(() => {
    console.log(2);
}, 1000);

setTimeout(() => {
    console.log(3);
}, 2000);
```

---

## Exercise 3

Explain why:

```js
setTimeout(fn, 0);
```

does not mean:

```text
run immediately
```

---

## Exercise 4

What is the Task Queue likely waiting to contain here?

```js
setTimeout(() => {
    console.log("Timer");
}, 0);

console.log("End");
```

Explain before running.

---

## Exercise 5

Predict:

```js
console.log("Start");

setTimeout(() => {
    console.log("Timer");
}, 0);

for (let i = 0; i < 1000000000; i++) {}

console.log("End");
```

Explain the relationship between:

```text
timer
Call Stack
Task
```

---

## Exercise 6 — Important

Explain the difference between:

```text
Task Queue
Microtask Queue
```

Do not use only:

> "One is faster."

That is not a sufficient explanation.

---

# 23. Completion Checklist

Before moving forward:

- [ ] I understand what a task queue is.
- [ ] I understand that the queue does not execute JavaScript.
- [ ] I understand the relationship between Call Stack and Task Queue.
- [ ] I understand the basic FIFO model.
- [ ] I understand why `setTimeout(0)` is not immediate.
- [ ] I understand timer delay vs actual execution time.
- [ ] I understand how a long synchronous task can delay a timer callback.
- [ ] I can dry-run multiple timers.
- [ ] I can explain the high-level path of a browser event.
- [ ] I understand that not every asynchronous mechanism should be reduced to "Task Queue."
- [ ] I know Task Queue and Microtask Queue are different concepts.

---

# 24. Quick Revision

```text
Asynchronous work becomes ready
            ↓
       Task / scheduling
            ↓
        Task Queue
            ↓
     JavaScript gets a turn
            ↓
        Call Stack
            ↓
        Callback runs
```

Remember:

```text
Call Stack
→ active execution

Task Queue
→ waiting tasks

setTimeout(0)
→ not immediate

Timer delay
→ eligibility, not exact execution time

Long synchronous work
→ can delay callbacks

Task
≠
Microtask
```

---

# Final Mental Model

```text
                HOST / BROWSER

           Timer / Event becomes ready
                    │
                    ▼
               TASK QUEUE
                    │
                    ▼
            Event Loop / Scheduling
                    │
                    ▼
                CALL STACK
                    │
                    ▼
             JavaScript executes
                    │
                    ▼
                 returns
```

The next chapter will add the missing coordinator:

**Next:** `06-Event-Loop.md`
