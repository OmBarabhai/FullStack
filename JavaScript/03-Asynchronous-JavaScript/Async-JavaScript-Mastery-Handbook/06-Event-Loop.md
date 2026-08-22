# 06 — Event Loop

**Folder:** `03-Asynchronous-JavaScript`

> **Core idea:** The Event Loop coordinates when scheduled work gets an opportunity to execute JavaScript.

---

## 1. What Is the Event Loop?

The Event Loop is part of the runtime's scheduling/execution model.

A useful learning model is:

```text
Current JavaScript
       ↓
   Call Stack
       ↓
current work finishes
       ↓
runtime scheduling
       ↓
another execution turn
```

The Event Loop does not execute JavaScript itself. JavaScript executes when work receives an execution turn.

---

## 2. Why Is It Needed?

Consider:

```js
setTimeout(() => {
    console.log("Timer");
}, 0);
```

The callback cannot interrupt JavaScript that is already running.

The runtime needs to coordinate:

```text
currently executing JavaScript
+
ready tasks
+
microtasks
+
host/runtime activity
```

---

## 3. Event Loop + Task Queue

```text
Task becomes ready
      ↓
Task Queue / scheduling
      ↓
Event Loop
      ↓
Call Stack
      ↓
JavaScript executes
```

Keep the responsibilities separate:

```text
Task Queue
→ waiting tasks

Event Loop
→ coordinates execution opportunities

Call Stack
→ active JavaScript execution
```

---

## 4. Timer Dry Run

```js
console.log("A");

setTimeout(() => {
    console.log("B");
}, 0);

console.log("C");
```

Conceptually:

```text
A
↓
timer scheduled
↓
C
↓
current JavaScript task finishes
↓
timer callback becomes eligible
↓
callback gets a later execution turn
↓
B
```

Output:

```text
A
C
B
```

`setTimeout(fn, 0)` does not mean "execute immediately."

---

## 5. Event Loop + Microtasks

Example:

```js
console.log("A");

Promise.resolve().then(() => {
    console.log("Promise");
});

setTimeout(() => {
    console.log("Timer");
}, 0);

console.log("B");
```

Output:

```text
A
B
Promise
Timer
```

High-level flow:

```text
A
↓
Promise reaction scheduled
↓
Timer task scheduled
↓
B
↓
current task finishes
↓
pending microtasks
↓
Promise
↓
next task
↓
Timer
```

Important practical rule:

```text
Current task
    ↓
Pending microtasks
    ↓
Next task
```

Avoid the oversimplification that "the Event Loop always checks microtasks first" as a complete algorithm. The actual specification/runtime model has more detail.

---

## 6. A Better Mental Model

Do not memorize a fake algorithm such as:

```js
while (true) {
    if (stack.empty()) {
        ...
    }
}
```

Use:

```text
JavaScript executes a task
        ↓
microtask checkpoint
        ↓
another eligible task gets an execution opportunity
        ↓
microtask checkpoint
        ↓
repeat while runtime is active
```

Browser rendering can happen at appropriate points between work. Do not treat rendering as one rigid universal step.

---

## 7. Blocking the Event Loop

Consider:

```js
setTimeout(() => {
    console.log("Timer");
}, 0);

console.log("Start");

for (let i = 0; i < 1000000000; i++) {}

console.log("End");
```

Expected ordering:

```text
Start
End
Timer
```

Why?

```text
Timer becomes eligible
        ↓
long synchronous JavaScript continues
        ↓
End
        ↓
current work finishes
        ↓
Timer gets an execution turn
```

A timer does not interrupt a running synchronous JavaScript job.

This is why heavy synchronous JavaScript can make a browser UI feel blocked.

---

## 8. Browser Events

```js
button.addEventListener("click", () => {
    console.log("Clicked");
});
```

Conceptually:

```text
User action
    ↓
Browser event handling
    ↓
event work becomes eligible
    ↓
JavaScript execution turn
    ↓
click callback
```

Do not confuse:

```text
Browser Event
```

with:

```text
Event Loop
```

The event is an occurrence; the Event Loop is part of scheduling/execution coordination.

---

## 9. Event Loop + Fetch

```js
fetch("/users")
    .then(response => response.json())
    .then(users => {
        console.log(users);
    });
```

High-level model:

```text
JavaScript
    ↓
fetch()
    ↓
network work
    ↓
response becomes available
    ↓
Promise reaction
    ↓
microtask processing
    ↓
JavaScript callback executes
```

This connects:

```text
Web API
+
Promise
+
Microtask
+
Event Loop
```

---

## 10. Multiple Timers

```js
setTimeout(() => {
    console.log("One");
}, 1000);

setTimeout(() => {
    console.log("Two");
}, 2000);

setTimeout(() => {
    console.log("Three");
}, 3000);
```

Basic order, assuming no other delays:

```text
One
Two
Three
```

But timers are not exact execution timestamps.

A callback may execute later than its requested delay.

---

## 11. Node.js

The Event Loop concept is not browser-only.

Node.js also uses an event-driven asynchronous runtime model.

Node.js has its own runtime architecture and libuv integration, so browser and Node.js event-loop details are not identical.

For now, remember:

```text
Browser
→ browser event-loop/runtime model

Node.js
→ Node.js event-loop/runtime model
```

Both coordinate asynchronous work, but implementation details differ.

---

## 12. Common Misconceptions

### ❌ Event Loop executes JavaScript

Better:

```text
Event Loop / scheduling
→ coordinates execution opportunities

JavaScript execution
→ happens when work gets its turn
```

### ❌ `setTimeout(0)` means immediate execution

Wrong.

It schedules work for a later execution opportunity.

### ❌ Event Loop means browser only

Wrong.

Node.js has an event-driven event-loop model too.

### ❌ Microtasks always "win"

Too broad.

The practical rule for this course is:

```text
After a JavaScript task completes,
pending microtasks are processed
before the next task.
```

### ❌ Long timers block JavaScript

Wrong.

Long-running synchronous JavaScript blocks the current execution thread.

The timer itself does not block it.

---

## 13. Dry Run 1

```js
console.log("A");

setTimeout(() => {
    console.log("B");
}, 0);

console.log("C");
```

Output:

```text
A
C
B
```

---

## 14. Dry Run 2

```js
console.log(1);

Promise.resolve().then(() => {
    console.log(2);
});

setTimeout(() => {
    console.log(3);
}, 0);

console.log(4);
```

Output:

```text
1
4
2
3
```

Reason:

```text
Sync
 ↓
microtasks
 ↓
next task
```

---

## 15. Dry Run 3

```js
setTimeout(() => {
    console.log("Timer");
}, 0);

Promise.resolve().then(() => {
    console.log("Promise 1");
});

Promise.resolve().then(() => {
    console.log("Promise 2");
});

console.log("Sync");
```

Output:

```text
Sync
Promise 1
Promise 2
Timer
```

---

## 16. Dry Run 4 — Blocking

```js
setTimeout(() => {
    console.log("Timer");
}, 0);

console.log("Start");

for (let i = 0; i < 1000000000; i++) {}

console.log("End");
```

Output ordering:

```text
Start
End
Timer
```

---

## 17. Interview Questions

### What is the Event Loop?

The Event Loop is part of the runtime's scheduling model that coordinates when scheduled work can receive a JavaScript execution opportunity.

### Does the Event Loop execute callbacks?

No. It coordinates scheduling; JavaScript executes when the callback receives an execution turn.

### Why is it important?

It allows JavaScript to coordinate asynchronous work without blocking while waiting for every external operation.

### What happens after a task finishes?

Pending microtasks are processed before moving on to the next task.

### Why does `setTimeout(0)` run after synchronous code?

Because the timer callback is scheduled for a later execution opportunity.

### Why can heavy synchronous code freeze a UI?

Because the current JavaScript execution stays busy and cannot yield an execution opportunity for other JavaScript work and timely rendering.

---

## 18. Exercises

### Exercise 1

Predict:

```js
console.log("Start");

setTimeout(() => {
    console.log("Timer");
}, 0);

console.log("End");
```

Explain every transition.

### Exercise 2

Predict:

```js
console.log("A");

Promise.resolve().then(() => {
    console.log("B");
});

setTimeout(() => {
    console.log("C");
}, 0);

console.log("D");
```

Explain why `B` and `C` appear in that order.

### Exercise 3

Predict:

```js
Promise.resolve().then(() => {
    console.log(1);
});

Promise.resolve().then(() => {
    console.log(2);
});

setTimeout(() => {
    console.log(3);
}, 0);

console.log(4);
```

### Exercise 4

Explain why this can delay a timer callback:

```js
setTimeout(() => {
    console.log("Timer");
}, 0);

for (let i = 0; i < 1000000000; i++) {}
```

### Exercise 5

Explain the difference between:

```text
Call Stack
Task Queue
Microtask Queue
Event Loop
```

Use one complete example.

---

## 19. Completion Checklist

- [ ] I understand the purpose of the Event Loop.
- [ ] I can connect Event Loop + Call Stack + Task Queue.
- [ ] I can connect Event Loop + Microtask Queue.
- [ ] I understand why `setTimeout(0)` is not immediate.
- [ ] I understand why synchronous code can delay asynchronous callbacks.
- [ ] I can dry-run a timer example.
- [ ] I can dry-run a Promise + timer example.
- [ ] I understand the microtask-before-next-task rule.
- [ ] I understand Event Loop and Call Stack have different responsibilities.
- [ ] I know browser and Node.js implementations have differences.
- [ ] I can explain the Event Loop without memorizing a fake `while(true)` algorithm.

---

## 20. Quick Revision

```text
Current JavaScript task
        ↓
Task finishes
        ↓
Pending microtasks
        ↓
Next eligible task
        ↓
JavaScript executes
        ↓
Pending microtasks
        ↓
Repeat
```

Remember:

```text
Call Stack
→ current execution

Task Queue
→ tasks waiting

Microtask Queue
→ Promise reactions / microtasks

Event Loop
→ coordinates execution opportunities
```

Most useful rule:

```text
Current task
    ↓
Microtasks
    ↓
Next task
```

---

# Final Mental Model

```text
              JAVASCRIPT RUNTIME

             ┌────────────────┐
             │   Call Stack   │
             │  current work  │
             └───────▲────────┘
                     │
              execution turn
                     │
                Event Loop 
                 Scheduling
                ↗       ↖
              /          \ 
   ┌──────────────┐ ┌──────────────┐
   │ Microtasks   │ │    Tasks     │
   │ Promises     │ │ timers/events│
   └──────────────┘ └──────────────┘
```

**Next:** `07-Microtask-Queue.md`
