# 09 — setInterval()

**Folder:** `03-Asynchronous-JavaScript`

> **Core idea:** `setInterval()` repeatedly schedules a callback until the interval is cancelled.

---

## 1. What Is `setInterval()`?

`setInterval()` schedules a function to be called repeatedly after a specified delay.

```js
setInterval(callback, delay);
```

Example:

```js
setInterval(() => {
    console.log("Hello");
}, 1000);
```

Mental model:

```text
register interval
      ↓
delay
      ↓
callback becomes eligible
      ↓
later execution opportunity
      ↓
repeat
```

The delay is not an exact real-time guarantee. Actual callbacks can run later. citeturn282561search0turn282561search1

---

## 2. Syntax

```js
setInterval(callback, delay);
```

Example:

```js
const id = setInterval(() => {
    console.log("Tick");
}, 1000);
```

Stop it with:

```js
clearInterval(id);
```

`setInterval()` returns an identifier that can be passed to `clearInterval()`. citeturn282561search0turn282561search3

---

## 3. `setTimeout()` vs `setInterval()`

```text
setTimeout()
→ one scheduled execution

setInterval()
→ repeated scheduled executions
```

Example:

```js
setTimeout(() => {
    console.log("Hi");
}, 1000);
```

Runs once.

```js
setInterval(() => {
    console.log("Hi");
}, 1000);
```

Runs repeatedly until cancelled.

citeturn282561search0

---

## 4. How `setInterval()` Works

```js
console.log("Start");

setInterval(() => {
    console.log("Tick");
}, 2000);

console.log("End");
```

High-level flow:

```text
Start
   ↓
interval registered
   ↓
JavaScript continues
   ↓
End
   ↓
delay
   ↓
callback becomes eligible
   ↓
JavaScript execution turn
   ↓
Tick
   ↓
next interval opportunity
   ↓
Tick
   ↓
repeat
```

The interval does not block JavaScript.

---

## 5. Event Loop Interaction

```js
setInterval(() => {
    console.log("A");
}, 1000);
```

Conceptually:

```text
interval becomes due
      ↓
callback becomes eligible
      ↓
task/scheduling
      ↓
Call Stack gets a turn
      ↓
A
```

Then the interval can make the callback eligible again.

```text
Interval
   ↓
Scheduling
   ↓
Call Stack
   ↓
Callback
   ↓
Next interval opportunity
```

The timer mechanism itself does not execute JavaScript.

---

## 6. First Execution

```js
setInterval(() => {
    console.log("Tick");
}, 2000);
```

Conceptually:

```text
0s
↓
register interval

~2s
↓
first callback

~4s
↓
next callback

~6s
↓
next callback
```

These are approximate opportunities, not guaranteed execution timestamps. CPU load and other tasks can delay timer callbacks. citeturn282561search1

---

## 7. `clearInterval()`

```js
let count = 0;

const id = setInterval(() => {
    console.log(count);

    count++;

    if (count === 5) {
        clearInterval(id);
    }
}, 1000);
```

Output:

```text
0
1
2
3
4
```

`clearInterval()` cancels the repeating timer. citeturn282561search3

---

## 8. Multiple Intervals

```js
setInterval(() => {
    console.log("A");
}, 1000);

setInterval(() => {
    console.log("B");
}, 2000);
```

Conceptually:

```text
~1s → A
~2s → A / B become eligible around this period
~3s → A
~4s → A / B
...
```

Do not assume exact wall-clock ordering when multiple timers become ready around the same time.

---

## 9. Heavy Interval Callbacks

Consider:

```js
setInterval(() => {
    // expensive work
}, 100);
```

JavaScript does not run multiple callbacks simultaneously on the same execution thread.

The problem is:

```text
callback takes too long
        ↓
new work becomes delayed
        ↓
timing becomes inaccurate
        ↓
repeated async work can accumulate
```

This is especially important for network polling. MDN recommends recursive `setTimeout()` when work may take longer than the interval. citeturn282561search0

---

## 10. Recursive `setTimeout()`

Instead of:

```js
setInterval(task, 1000);
```

you can use:

```js
function repeat() {
    task();

    setTimeout(repeat, 1000);
}

repeat();
```

Conceptually:

```text
task
 ↓
schedule next timeout
 ↓
finish current task
 ↓
delay
 ↓
next task
```

This gives more control over when the next cycle is scheduled.

MDN specifically recommends recursive `setTimeout()` for cases such as polling where the previous operation should complete before the next cycle begins. citeturn282561search0

---

## 11. `setInterval()` vs Recursive `setTimeout()`

### `setInterval()`

```text
repeating timer
      ↓
callback
      ↓
repeat
```

Useful for:

```text
simple clocks
simple periodic UI updates
straightforward repeated work
```

### Recursive `setTimeout()`

```text
task
 ↓
schedule next timeout
 ↓
next task
```

Useful when:

```text
work duration varies
the next cycle should wait for the previous cycle
network calls must not accumulate
you need more scheduling control
```

Neither is universally "better."

Choose based on the behavior you need.

---

## 12. Nested Intervals

Dangerous pattern:

```js
setInterval(() => {

    console.log("Outer");

    setInterval(() => {
        console.log("Inner");
    }, 1000);

}, 3000);
```

Every outer execution creates another inner interval.

After:

```text
1 outer execution → 1 inner interval
2 outer executions → 2 inner intervals
3 outer executions → 3 inner intervals
```

The inner intervals continue independently unless they are also cancelled.

Avoid this unless intentional.

---

## 13. `this` Inside Interval Callbacks

This can be surprising:

```js
const counter = {
    value: 0,

    increment() {
        this.value++;
        console.log(this.value);
    }
};

setInterval(counter.increment, 1000);
```

Passing the method directly can lose the intended object context.

A common solution:

```js
setInterval(() => {
    counter.increment();
}, 1000);
```

or:

```js
setInterval(counter.increment.bind(counter), 1000);
```

This is a preview of your later `this` topic.

MDN documents the `this` behavior of functions passed to `setInterval()`. citeturn282561search0

---

## 14. Timer IDs

```js
const id = setInterval(() => {
    console.log("Tick");
}, 1000);
```

Then:

```js
clearInterval(id);
```

Browser timer IDs from `setTimeout()` and `setInterval()` share an ID pool. For code clarity, still use:

```text
setTimeout → clearTimeout
setInterval → clearInterval
```

citeturn282561search0turn282561search3

---

# 15. HANDS-ON LAB

Create:

```text
03-Asynchronous-JavaScript/Code/setInterval.js
```

Use this cycle for every experiment:

```text
Predict
↓
Run
↓
Observe
↓
Explain
```

Do not just copy the answer.

---

## Lab 1 — Basic Interval

```js
const id = setInterval(() => {
    console.log("Tick");
}, 1000);
```

Let it run for a few seconds.

Then stop it:

```js
clearInterval(id);
```

Question:

> What caused the repeated execution to stop?

---

## Lab 2 — Count and Stop

Build this yourself:

```text
1
2
3
4
5
```

Then stop automatically.

Use:

```text
setInterval()
+
clearInterval()
```

---

## Lab 3 — Interval + Timeout

```js
console.log("Start");

const id = setInterval(() => {
    console.log("Interval");
}, 1000);

setTimeout(() => {
    clearInterval(id);
    console.log("Stopped");
}, 5500);

console.log("End");
```

Predict the output before running.

---

## Lab 4 — Two Intervals

```js
const a = setInterval(() => {
    console.log("A");
}, 1000);

const b = setInterval(() => {
    console.log("B");
}, 2000);

setTimeout(() => {
    clearInterval(a);
    clearInterval(b);
    console.log("Stopped");
}, 6500);
```

Observe how multiple repeating timers coexist.

---

## Lab 5 — Recursive `setTimeout()`

Implement:

```text
Print "Running"
wait about 1 second
Print "Running"
...
Stop after 5 runs
```

Use recursive `setTimeout()`.

Do not use `setInterval()`.

---

## Lab 6 — Compare Both

Build two versions of the same task:

```text
Version A → setInterval()
Version B → recursive setTimeout()
```

Then answer:

```text
When is the next cycle scheduled?

What happens if the task takes longer?

Which gives more control?
```

---

## Lab 7 — Slow Callback

Run:

```js
const id = setInterval(() => {
    console.log("Tick");

    const start = Date.now();

    while (Date.now() - start < 700) {
        // intentionally block
    }
}, 500);

setTimeout(() => {
    clearInterval(id);
    console.log("Stopped");
}, 4000);
```

Observe:

```text
interval delay
vs
callback duration
```

Use a small duration; do not make the experiment freeze your machine.

---

# 16. DevAPI Hands-On

Use your DevAPI to build a simple request monitor.

Goal:

```text
Checking request...
Checking request...
Checking request...
Stopped
```

Use `setInterval()` to simulate repeated monitoring.

Then add:

```text
request id
status
response time
```

Example data:

```js
const request = {
    id: 101,
    status: 200,
    resTime: 2000
};
```

Next progression:

```text
setInterval simulation
        ↓
recursive setTimeout()
        ↓
Promise
        ↓
async/await
        ↓
real fetch()
```

---

# 17. Debugging Practice

Find the problem:

```js
const id = setInterval(() => {
    console.log("Running");
}, 1000);

if (count === 5) {
    clearInterval(id);
}
```

Ask:

```text
Where does count come from?

When is the condition checked?

When should the interval stop?
```

Fix it independently.

---

# 18. Common Mistakes

### `setInterval()` runs only once

Wrong.

It repeatedly schedules callback executions.

### Forgetting `clearInterval()`

The interval can continue running.

### Assuming interval timing is exact

Wrong.

Timers may execute later. citeturn282561search0turn282561search1

### Assuming long callbacks run simultaneously

Wrong.

JavaScript execution remains serialized.

The problem is delayed work and potentially accumulating asynchronous operations.

### Creating intervals inside intervals

This can create many active timers.

### Using `setInterval()` for unpredictable network work

Often a poor choice.

Recursive `setTimeout()` can provide better control. citeturn282561search0

### Passing an object method without considering `this`

The intended object context can be lost.

Use a wrapper or `bind()` when appropriate. citeturn282561search0

---

# 19. Dry Runs

## Example 1

```js
let count = 1;

const id = setInterval(() => {
    console.log(count);

    count++;

    if (count > 3) {
        clearInterval(id);
    }
}, 1000);
```

Output:

```text
1
2
3
```

---

## Example 2

```js
console.log("Start");

const id = setInterval(() => {
    console.log("Tick");
}, 1000);

setTimeout(() => {
    clearInterval(id);
}, 3500);

console.log("End");
```

Approximate result:

```text
Start
End
Tick
Tick
Tick
```

Then the interval stops.

---

## Example 3 — Nested Interval

```js
let outerCount = 0;

const outer = setInterval(() => {
    outerCount++;

    console.log("Outer", outerCount);

    setInterval(() => {
        console.log("Inner");
    }, 1000);

    if (outerCount === 2) {
        clearInterval(outer);
    }
}, 2000);
```

Question:

> How many inner intervals exist after the outer interval executes twice?

Answer:

```text
2
```

Those inner intervals must be cancelled separately.

---

# 20. Interview Questions

### What is `setInterval()`?

An API that repeatedly schedules a callback after a specified delay.

### Difference between `setTimeout()` and `setInterval()`?

```text
setTimeout → one delayed execution
setInterval → repeated execution
```

### How do you stop an interval?

```js
clearInterval(id);
```

### Does `setInterval()` guarantee exact timing?

No.

Callbacks can execute later than the requested interval. citeturn282561search0turn282561search1

### What if the callback takes longer than the interval?

Execution remains serialized. Repeated asynchronous work can become delayed or accumulate, especially for network polling.

### When might recursive `setTimeout()` be better?

When the next cycle should be scheduled after the current work completes or when you need more control over the schedule. citeturn282561search0

### Can nested intervals cause problems?

Yes. Repeatedly creating new intervals can leave many active timers running.

---

# 21. Completion Checklist

- [ ] I understand `setInterval()`.
- [ ] I know the difference from `setTimeout()`.
- [ ] I know how to stop an interval.
- [ ] I understand timing is not exact.
- [ ] I understand why slow work can delay repeated execution.
- [ ] I understand why network polling may accumulate work.
- [ ] I understand recursive `setTimeout()`.
- [ ] I can compare both scheduling styles.
- [ ] I understand the nested-interval problem.
- [ ] I understand the basic `this` issue.
- [ ] I completed the hands-on labs.
- [ ] I built a DevAPI monitoring simulation.
- [ ] I can predict interval behavior before running it.

---

# 22. Quick Revision

```text
setInterval()
      ↓
repeating timer
      ↓
callback becomes eligible
      ↓
JavaScript execution opportunity
      ↓
callback executes
      ↓
repeat
      ↓
clearInterval()
      ↓
stop future executions
```

Remember:

```text
setTimeout()
→ once

setInterval()
→ repeat

clearInterval()
→ stop

long callback
→ timing may be delayed

nested interval
→ potentially many active timers

recursive setTimeout()
→ more control for variable-duration work
```

---

# Final Mental Model

```text
                 setInterval()

                      │
                      ▼

              Repeating Timer

                      │
              interval becomes due
                      ▼

             callback becomes ready
                      │
                      ▼

             JavaScript execution
                      │
                      ▼

             callback executes
                      │
                      └─────────────┐
                                    │
                              next interval
                                    │
                                    ▼
                                  repeat
                                    │
                             clearInterval()
                                    ▼
                                   STOP
```

**Next:** `10-fetch.md`
