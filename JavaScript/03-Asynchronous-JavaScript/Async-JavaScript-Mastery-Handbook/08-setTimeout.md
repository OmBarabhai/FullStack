# 08 — setTimeout()

**Folder:** `03-Asynchronous-JavaScript`

> **Core idea:** `setTimeout()` schedules a callback for a later execution opportunity. It does not pause JavaScript.

---

## 1. What Is `setTimeout()`?

`setTimeout()` schedules a function to run after a specified delay.

```js
setTimeout(callback, delay);
```

Example:

```js
setTimeout(() => {
    console.log("Hello");
}, 2000);
```

Mental model:

```text
setTimeout()
     ↓
register timer
     ↓
JavaScript continues
     ↓
delay condition satisfied
     ↓
callback becomes eligible
     ↓
later execution opportunity
```

The delay is not a guarantee that the callback executes exactly at that time. It may run later.

---

## 2. Syntax

```js
setTimeout(callback, delay);
```

It can also receive arguments:

```js
setTimeout((name) => {
    console.log(name);
}, 1000, "Om");
```

Prefer passing a function:

```js
setTimeout(() => {
    console.log("Hello");
}, 1000);
```

Avoid passing a string of code to execute. MDN strongly discourages this because it involves dynamic code execution and security concerns.

---

## 3. How It Works

Consider:

```js
console.log("Start");

setTimeout(() => {
    console.log("Timer");
}, 3000);

console.log("End");
```

Conceptual flow:

```text
console.log("Start")
        ↓
Start

setTimeout()
        ↓
timer registered

JavaScript continues
        ↓
console.log("End")
        ↓
End

...time passes...

timer becomes eligible
        ↓
callback gets an execution opportunity
        ↓
Timer
```

Output:

```text
Start
End
Timer
```

`setTimeout()` returns without blocking the following JavaScript.

---

## 4. Why It Does Not Block

```js
setTimeout(() => {
    console.log("Hello");
}, 5000);

console.log("World");
```

Do not think:

```text
wait 5 seconds
↓
Hello
↓
World
```

Think:

```text
schedule timer
↓
continue JavaScript
↓
World
↓
later
↓
Hello
```

Output:

```text
World
Hello
```

A timer is not a sleep operation.

---

## 5. Complete Execution Model

For this course:

```text
JavaScript
    ↓
Call Stack
    ↓
setTimeout()
    ↓
Host timer mechanism
    ↓
delay condition satisfied
    ↓
callback becomes eligible
    ↓
task scheduling
    ↓
later JavaScript execution turn
    ↓
callback executes
```

Keep the responsibilities separate:

```text
Timer system
→ tracks timer

Task/scheduling system
→ makes work eligible

Call Stack
→ executes JavaScript
```

---

## 6. Delay Is Not Exact Execution Time

```js
setTimeout(() => {
    console.log("Done");
}, 1000);
```

Do not interpret `1000` as:

> callback executes exactly 1000 ms later.

Instead:

```text
1000 ms
   ↓
timer can become eligible
   ↓
callback still needs an execution opportunity
```

If JavaScript is busy:

```js
setTimeout(() => {
    console.log("Timer");
}, 0);

for (let i = 0; i < 1000000000; i++) {}

console.log("Done");
```

the callback can execute later.

MDN documents that actual timeout delays may be longer than specified because currently executing code and runtime/browser scheduling can delay the callback. citeturn453198search0

---

## 7. `setTimeout(0)`

Very common interview question:

```js
setTimeout(() => {
    console.log("B");
}, 0);
```

Does this mean:

```text
execute immediately
```

No.

Example:

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

Why:

```text
A
↓
schedule timer
↓
C
↓
current JavaScript work finishes
↓
timer callback becomes eligible
↓
later execution opportunity
↓
B
```

MDN explicitly notes that a zero delay executes on a later event cycle rather than immediately. citeturn453198search0

---

## 8. Multiple Timers

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

Timeline:

```text
~1s → timer 2 eligible
~2s → timer 3 eligible
~3s → timer 1 eligible
```

But the actual callback execution can be later than those times.

---

## 9. Nested `setTimeout()`

```js
setTimeout(() => {
    console.log("A");

    setTimeout(() => {
        console.log("B");
    }, 1000);
}, 1000);
```

Conceptual timing:

```text
first timer
   ↓
~1 second
   ↓
A
   ↓
second timer registered
   ↓
~1 more second
   ↓
B
```

The second delay begins when the second timer is registered, not when the first timer was created.

---

## 10. Cancelling a Timeout

`setTimeout()` returns a timeout identifier.

```js
const id = setTimeout(() => {
    console.log("Hello");
}, 3000);
```

Cancel it:

```js
clearTimeout(id);
```

Now the pending callback is cancelled.

MDN documents the returned timeout identifier and `clearTimeout()` cancellation behavior. citeturn453198search0

---

## 11. `clearTimeout()` After Execution

```js
const id = setTimeout(() => {
    console.log("Hello");
}, 1000);

setTimeout(() => {
    clearTimeout(id);
}, 2000);
```

The first timer has already executed before the cancellation code runs.

Cancellation is useful while the timeout is still pending.

---

## 12. Timer IDs

```js
const id = setTimeout(() => {
    console.log("Hello");
}, 1000);

console.log(id);
```

The returned value identifies the timer.

Use it with:

```js
clearTimeout(id);
```

Do not depend on the exact numeric value across runtimes.

---

## 13. Nested Timer Restrictions

Browsers can apply minimum delays to deeply nested timer calls.

MDN documents a 4 ms minimum in the relevant deeply nested timer case. citeturn453198search0

For now remember:

```text
Deep timer nesting
        ↓
Browser may enforce a minimum delay
```

Do not memorize implementation trivia yet.

---

## 14. Background Tab Throttling

Browsers may throttle timers in inactive/background pages to reduce CPU and battery usage.

The exact policy differs by browser and situation. citeturn453198search0

Therefore:

```js
setTimeout(fn, 1000);
```

should never be treated as a hard real-time guarantee.

---

## 15. `this` Inside Timer Callbacks

A common trap:

```js
const obj = {
    value: 10,

    show() {
        setTimeout(function () {
            console.log(this.value);
        }, 0);
    }
};
```

The regular callback does not automatically inherit `obj` as its `this`.

An arrow function can capture the surrounding `this`:

```js
const obj = {
    value: 10,

    show() {
        setTimeout(() => {
            console.log(this.value);
        }, 0);
    }
};
```

Keep this as a preview. Your dedicated `this` topic comes later.

MDN documents the `this` behavior of functions passed to `setTimeout()`. citeturn453198search0

---

## 16. `setTimeout()` vs `setInterval()`

Use:

```text
setTimeout()
→ one scheduled execution
```

Use:

```text
setInterval()
→ repeated scheduled execution
```

MDN recommends `setTimeout()` when you want a function called once after a delay and `setInterval()` for repeated calls. citeturn453198search2

---

# 17. HANDS-ON LAB

**Do not only read this chapter. Run the experiments.**

Create:

```text
03-Asynchronous-JavaScript/Code/setTimeout.js
```

For every experiment:

```text
Predict
↓
Run
↓
Observe
↓
Explain
```

---

## Lab 1 — Basic Timer

```js
console.log("Start");

setTimeout(() => {
    console.log("Timer");
}, 2000);

console.log("End");
```

Before running:

```text
Prediction:
1.
2.
3.
```

Then record:

```text
Actual:
Why:
```

---

## Lab 2 — `setTimeout(0)`

```js
console.log("A");

setTimeout(() => {
    console.log("B");
}, 0);

console.log("C");
```

Prediction first.

Then explain why the actual result is:

```text
A
C
B
```

Do not answer only:

> "because setTimeout is asynchronous."

Explain the execution flow.

---

## Lab 3 — Multiple Timers

```js
setTimeout(() => {
    console.log("One");
}, 3000);

setTimeout(() => {
    console.log("Two");
}, 1000);

setTimeout(() => {
    console.log("Three");
}, 2000);
```

Predict the order before executing.

---

## Lab 4 — Timer vs Blocking Code

```js
console.log("Start");

setTimeout(() => {
    console.log("Timer");
}, 0);

for (let i = 0; i < 1000000000; i++) {}

console.log("End");
```

Observe that synchronous work can delay the timer callback.

Reduce the loop count if your machine becomes too slow.

---

## Lab 5 — Nested Timers

```js
setTimeout(() => {
    console.log("A");

    setTimeout(() => {
        console.log("B");
    }, 1000);
}, 1000);
```

Measure approximately how much time passes between `A` and `B`.

Question:

> When does the second timer's delay begin?

---

## Lab 6 — `clearTimeout()`

```js
const id = setTimeout(() => {
    console.log("You should NOT see this");
}, 3000);

clearTimeout(id);

console.log("Cancelled");
```

Verify:

```text
Cancelled
```

---

## Lab 7 — Cancel Conditionally

Write your own program:

```text
Start a timer for 5 seconds.

After 2 seconds,
cancel that timer.
```

Do not copy a solution.

---

## Lab 8 — Prediction Challenge

```js
console.log("1");

setTimeout(() => {
    console.log("2");
}, 0);

setTimeout(() => {
    console.log("3");
}, 0);

console.log("4");
```

Do:

```text
Prediction
↓
Run
↓
Actual
↓
Explain
```

---

# 18. DevAPI Hands-On

Use your project to simulate request latency:

```js
const request = {
    id: 101,
    status: 200,
    resTime: 2000
};

console.log("Request started");

setTimeout(() => {
    console.log("Response received");
    console.log(request);
}, request.resTime);

console.log("Request processing...");
```

Expected conceptual flow:

```text
Request started
        ↓
timer registered
        ↓
Request processing...
        ↓
~2 seconds
        ↓
Response received
```

Then extend it to print:

```text
Request started
Request processing...
Response received
Status: 200
```

This is a **simulation**, not a real HTTP request.

Later:

```text
setTimeout simulation
        ↓
Promise
        ↓
async/await
        ↓
fetch()
```

---

# 19. Debugging Practice

Find the problem:

```js
setTimeout(console.log("Hello"), 1000);
```

Ask:

```text
What does setTimeout expect?

What are we passing?

What executes immediately?
```

Correct:

```js
setTimeout(() => {
    console.log("Hello");
}, 1000);
```

Difference:

```text
console.log("Hello")
→ executes now

() => console.log("Hello")
→ function passed for later execution
```

---

# 20. Common Mistakes

### `setTimeout()` pauses JavaScript

Wrong.

It schedules the callback and returns.

### `setTimeout(fn, 0)` means immediate execution

Wrong.

It schedules a later execution opportunity.

### Delay is exact

Wrong.

The callback can execute later. citeturn453198search0

### Timer blocks JavaScript

Wrong.

Long synchronous JavaScript blocks execution; a timer itself does not.

### Callback goes directly onto the Call Stack

Too simplified.

The callback must receive a valid execution opportunity.

### `clearTimeout()` can cancel a callback after it already ran

No.

Cancellation is useful while the timeout is still pending.

### `setTimeout(console.log("Hello"), 1000)` is correct

Wrong.

`console.log()` runs immediately.

Use a function.

---

# 21. Dry Runs

## Example 1

```js
console.log(1);

setTimeout(() => {
    console.log(2);
}, 1000);

console.log(3);
```

Output:

```text
1
3
2
```

---

## Example 2

```js
setTimeout(() => {
    console.log("A");
}, 0);

console.log("B");
```

Output:

```text
B
A
```

---

## Example 3

```js
console.log("Start");

setTimeout(() => {
    console.log("Middle");
}, 2000);

console.log("End");
```

Output:

```text
Start
End
Middle
```

---

## Example 4

```js
setTimeout(() => {
    console.log(1);
}, 0);

setTimeout(() => {
    console.log(2);
}, 0);

console.log(3);
```

Output:

```text
3
1
2
```

---

## Example 5 — Blocking

```js
setTimeout(() => {
    console.log("Timer");
}, 0);

console.log("Start");

for (let i = 0; i < 1000000000; i++) {}

console.log("End");
```

Ordering:

```text
Start
End
Timer
```

---

# 22. Interview Questions

### What is `setTimeout()`?

An API that schedules a callback for a later execution opportunity after the specified delay.

### Does `setTimeout()` block JavaScript?

No.

### What does the delay represent?

It indicates when the timer can become eligible; actual execution can occur later. citeturn453198search0

### Is `setTimeout(0)` immediate?

No.

### What does `setTimeout()` return?

A timeout identifier that can be passed to `clearTimeout()`. citeturn453198search0

### How do you cancel a timeout?

```js
clearTimeout(id);
```

### Does a timer interrupt a running synchronous function?

No.

### What is the difference between `setTimeout()` and `setInterval()`?

```text
setTimeout
→ one scheduled execution

setInterval
→ repeated scheduled executions
```

### What happens with:

```js
setTimeout(console.log("Hello"), 1000);
```

`console.log("Hello")` is executed immediately, and its return value is passed to `setTimeout()`. The correct approach is to pass a function.

---

# 23. Completion Checklist

- [ ] I understand what `setTimeout()` does.
- [ ] I know it does not pause JavaScript.
- [ ] I understand delay vs actual execution time.
- [ ] I understand `setTimeout(0)`.
- [ ] I can dry-run multiple timers.
- [ ] I understand nested timers.
- [ ] I can cancel a timeout.
- [ ] I understand why `setTimeout(console.log(...), 1000)` is wrong.
- [ ] I understand timer behavior during blocking synchronous work.
- [ ] I understand the basic `this` issue with regular timer callbacks.
- [ ] I completed the hands-on labs.
- [ ] I completed the DevAPI timer simulation.
- [ ] I can predict timer output before running it.

---

# 24. Quick Revision

```text
setTimeout()
    ↓
register timer
    ↓
JavaScript continues
    ↓
timer delay satisfied
    ↓
callback becomes eligible
    ↓
later execution opportunity
    ↓
callback executes
```

Remember:

```text
setTimeout()
≠ sleep()

setTimeout(0)
≠ immediate

delay
≠ exact execution time

clearTimeout(id)
→ cancel pending timeout
```

---

# Final Mental Model

```text
                  setTimeout()

                       │
                       ▼

                Host Timer System

                       │
                delay satisfied
                       ▼

              Callback becomes ready

                       │
                       ▼

                Task / Scheduling

                       │
                       ▼

              JavaScript execution turn

                       │
                       ▼

                Callback Executes
```

**Next:** `09-setInterval.md`
