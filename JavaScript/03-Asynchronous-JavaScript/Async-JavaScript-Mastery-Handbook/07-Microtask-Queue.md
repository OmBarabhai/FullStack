# 07 — Microtask Queue

**Folder:** `03-Asynchronous-JavaScript`

> **Core idea:** Microtasks are short pieces of JavaScript work processed at microtask checkpoints before the runtime proceeds to the next task.

---

## 1. What Is a Microtask?

A **microtask** is deferred JavaScript work that runs after the current JavaScript task completes and before the runtime proceeds to the next task.

Common examples:

```js
Promise.resolve().then(() => {});
Promise.resolve().catch(() => {});
Promise.resolve().finally(() => {});

queueMicrotask(() => {});
```

Promises use the microtask queue, and `queueMicrotask()` explicitly schedules a microtask.

Reference: https://developer.mozilla.org/en-US/docs/Web/API/HTML_DOM_API/Microtask_guide

---

## 2. Why Do Microtasks Exist?

Sometimes code needs to run:

```text
after current JavaScript finishes
but before the next task is processed
```

That is the role of a microtask.

A useful model:

```text
Current JavaScript
       ↓
Current task completes
       ↓
Microtask checkpoint
       ↓
Microtasks
       ↓
Next task
```

---

## 3. Task vs Microtask

| Microtask | Task |
|---|---|
| Promise reactions | `setTimeout()` |
| `catch()` reactions | `setInterval()` |
| `finally()` reactions | User-event tasks |
| `queueMicrotask()` | Other host tasks |

Important rule:

```text
After a task finishes,
pending microtasks are processed
before the next task.
```

Reference: https://developer.mozilla.org/en-US/docs/Web/API/HTML_DOM_API/Microtask_guide/In_depth

---

## 4. Microtask Queue Is Not the Call Stack

Do not mix these up.

```text
Call Stack
→ currently executing JavaScript

Microtask Queue
→ waiting microtasks
```

Example:

```js
Promise.resolve().then(() => {
    console.log("Promise");
});
```

The `.then()` callback is not executing when it is scheduled. It becomes a microtask to be processed later.

---

## 5. Promise Execution

```js
console.log("Start");

Promise.resolve().then(() => {
    console.log("Promise");
});

console.log("End");
```

Execution:

```text
Start
    ↓
Promise reaction scheduled
    ↓
End
    ↓
current task completes
    ↓
microtask checkpoint
    ↓
Promise callback
```

Output:

```text
Start
End
Promise
```

A `.then()` callback is not invoked synchronously even when the Promise is already fulfilled.

Reference: https://developer.mozilla.org/en-US/docs/Web/JavaScript/Guide/Using_promises

---

## 6. `queueMicrotask()`

```js
queueMicrotask(() => {
    console.log("Microtask");
});
```

Example:

```js
console.log("A");

queueMicrotask(() => {
    console.log("B");
});

console.log("C");
```

Output:

```text
A
C
B
```

Reference: https://developer.mozilla.org/en-US/docs/Web/API/Window/queueMicrotask

---

## 7. Promise vs `setTimeout()`

```js
setTimeout(() => {
    console.log("Timeout");
}, 0);

Promise.resolve().then(() => {
    console.log("Promise");
});
```

Typical ordering:

```text
Promise
Timeout
```

Reason:

```text
Current task finishes
        ↓
Promise reaction is a microtask
        ↓
Microtask checkpoint
        ↓
Promise
        ↓
Next task
        ↓
Timeout
```

Reference: https://developer.mozilla.org/en-US/docs/Web/JavaScript/Guide/Using_promises

---

## 8. Event Loop Mental Model

Avoid treating this as three permanent priority levels.

Use:

```text
JavaScript executes current task
        ↓
Microtask checkpoint
        ↓
Next eligible task
        ↓
Microtask checkpoint
        ↓
Repeat while runtime is active
```

During a microtask checkpoint:

```text
Run microtask
    ↓
Does it add another microtask?
    ↓
Yes → process that too
    ↓
Continue until queue is empty
```

Microtasks continue until the microtask queue is empty, even if they add more microtasks.

Reference: https://developer.mozilla.org/en-US/docs/Web/API/HTML_DOM_API/Microtask_guide

---

## 9. Multiple Microtasks

```js
Promise.resolve().then(() => {
    console.log(1);
});

Promise.resolve().then(() => {
    console.log(2);
});

Promise.resolve().then(() => {
    console.log(3);
});
```

They are scheduled in order:

```text
Microtask Queue

1
2
3
```

Output:

```text
1
2
3
```

Promise reactions registered in order are invoked in that order.

---

## 10. Promise Chain

```js
Promise.resolve()
    .then(() => {
        console.log(1);
    })
    .then(() => {
        console.log(2);
    })
    .then(() => {
        console.log(3);
    });
```

Output:

```text
1
2
3
```

Important:

```text
then(1)
   ↓
Promise settles
   ↓
next reaction becomes eligible
   ↓
then(2)
   ↓
then(3)
```

Do not imagine all chained callbacks as one synchronous block.

---

## 11. Microtasks Can Add Microtasks

```js
queueMicrotask(() => {
    console.log("A");

    queueMicrotask(() => {
        console.log("B");
    });
});

queueMicrotask(() => {
    console.log("C");
});
```

Initial queue:

```text
A
C
```

While `A` runs, it schedules `B`.

The queue becomes:

```text
C
B
```

Output:

```text
A
C
B
```

New microtasks are processed before the next task.

Reference: https://developer.mozilla.org/en-US/docs/Web/API/HTML_DOM_API/Microtask_guide

---

## 12. Microtask Starvation

Consider:

```js
function keepGoing() {
    queueMicrotask(keepGoing);
}

keepGoing();
```

Conceptually:

```text
Microtask
   ↓
Microtask
   ↓
Microtask
   ↓
Microtask
   ↓
...
```

Because microtasks are processed until the queue is empty, an unbounded chain can prevent later tasks from getting a turn.

This is called **microtask starvation**.

Use microtasks carefully.

---

## 13. `queueMicrotask()` vs Promise

Both schedule microtasks:

```js
queueMicrotask(() => {
    console.log("A");
});
```

and:

```js
Promise.resolve().then(() => {
    console.log("B");
});
```

But they are not identical APIs.

`queueMicrotask()` directly schedules a microtask without creating a Promise just for scheduling.

Reference: https://developer.mozilla.org/en-US/docs/Web/API/HTML_DOM_API/Microtask_guide

For normal application code:

```text
Promises
→ asynchronous control flow

queueMicrotask()
→ explicit microtask scheduling when specifically needed
```

---

## 14. Microtasks Do Not Interrupt Current JavaScript

```js
console.log("A");

queueMicrotask(() => {
    console.log("Microtask");
});

console.log("B");
```

Output:

```text
A
B
Microtask
```

The microtask does not jump into the middle of the current execution.

The current task finishes first.

This follows JavaScript's run-to-completion model.

Reference: https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Execution_model

---

# 15. Dry Run 1 — Promise + Timer

```js
console.log("1");

setTimeout(() => {
    console.log("2");
}, 0);

Promise.resolve().then(() => {
    console.log("3");
});

console.log("4");
```

Reasoning:

```text
1
↓
timer scheduled
↓
microtask scheduled
↓
4
↓
current task finishes
↓
microtask
↓
3
↓
next task
↓
2
```

Output:

```text
1
4
3
2
```

---

# 16. Dry Run 2 — Multiple Promises

```js
Promise.resolve().then(() => {
    console.log("A");
});

Promise.resolve().then(() => {
    console.log("B");
});

console.log("C");
```

Output:

```text
C
A
B
```

---

# 17. Dry Run 3 — `queueMicrotask()`

```js
console.log("Start");

queueMicrotask(() => {
    console.log("Microtask");
});

console.log("End");
```

Output:

```text
Start
End
Microtask
```

---

# 18. Dry Run 4 — Microtask Adds Microtask

```js
queueMicrotask(() => {
    console.log("A");

    queueMicrotask(() => {
        console.log("B");
    });
});

queueMicrotask(() => {
    console.log("C");
});

console.log("Start");
```

Output:

```text
Start
A
C
B
```

---

# 19. Common Misconceptions

### ❌ "Promises are synchronous"

The Promise constructor's executor runs synchronously, but `.then()`, `.catch()`, and `.finally()` reactions are scheduled asynchronously.

### ❌ "setTimeout(0) beats Promise"

In the usual same-turn comparison, Promise reactions are microtasks while timer callbacks are tasks.

### ❌ "Microtasks interrupt the current function"

No. Current JavaScript execution must finish first.

### ❌ "Only one microtask runs before the next task"

No. Microtasks are processed until the queue is empty.

### ❌ "Microtasks are always better because they have priority"

No. Too many microtasks can delay tasks and rendering opportunities.

---

# 20. Interview Questions

### What is a microtask?

A unit of deferred JavaScript work processed at a microtask checkpoint before the runtime proceeds to the next task.

### Which common APIs create microtasks?

```text
Promise reactions
queueMicrotask()
```

### Why does `Promise.then()` run before `setTimeout(..., 0)`?

Promise reactions are processed as microtasks, while timer callbacks are tasks.

### Does a microtask interrupt running JavaScript?

No.

### When are microtasks processed?

After the current task reaches a microtask checkpoint, before the runtime proceeds to the next task.

### Can microtasks create more microtasks?

Yes.

### What happens then?

They are processed before the next task as long as the microtask queue continues to have work.

### Can that cause problems?

Yes. An endless chain can starve later tasks.

### Is `queueMicrotask()` exactly the same as `Promise.then()`?

No. Both schedule microtasks, but they are different APIs.

---

# 21. Exercises

## Exercise 1

Predict:

```js
console.log("A");

Promise.resolve().then(() => {
    console.log("B");
});

console.log("C");
```

## Exercise 2

Predict:

```js
setTimeout(() => {
    console.log("A");
}, 0);

Promise.resolve().then(() => {
    console.log("B");
});

console.log("C");
```

## Exercise 3

Predict:

```js
console.log(1);

queueMicrotask(() => {
    console.log(2);
});

console.log(3);
```

## Exercise 4

Predict:

```js
console.log("Start");

Promise.resolve()
    .then(() => {
        console.log("One");
    })
    .then(() => {
        console.log("Two");
    });

setTimeout(() => {
    console.log("Timer");
}, 0);

console.log("End");
```

## Exercise 5

Predict:

```js
queueMicrotask(() => {
    console.log("A");

    queueMicrotask(() => {
        console.log("B");
    });
});

queueMicrotask(() => {
    console.log("C");
});
```

## Exercise 6 — Important

Explain the difference between:

```text
Task Queue
Microtask Queue
```

Do not answer only:

> "Microtasks are faster."

Explain the scheduling relationship.

---

# 22. Completion Checklist

- [ ] I understand what a microtask is.
- [ ] I understand why Promise reactions are microtasks.
- [ ] I understand `queueMicrotask()`.
- [ ] I can distinguish tasks from microtasks.
- [ ] I understand why Promise reactions usually run before timer tasks.
- [ ] I understand that microtasks do not interrupt current JavaScript.
- [ ] I know microtasks are processed until the queue is empty.
- [ ] I understand microtask starvation.
- [ ] I can dry-run Promise + timer examples.
- [ ] I can dry-run multiple Promise reactions.
- [ ] I understand why Promise chain callbacks are scheduled progressively.
- [ ] I can explain microtasks without saying only "VIP queue."

---

# 23. Quick Revision

```text
Current JavaScript task
        ↓
Current task finishes
        ↓
Microtask checkpoint
        ↓
Run pending microtasks
        ↓
If microtasks add more microtasks
        ↓
Keep processing
        ↓
Microtask queue empty
        ↓
Next task
```

Remember:

```text
Promise reactions
→ Microtasks

queueMicrotask()
→ Microtask

setTimeout()
→ Task

Microtask
≠
Call Stack

Microtask
≠
Task

Microtasks run after current work
and before the next task.
```

---

# Final Mental Model

```text
                  JAVASCRIPT RUNTIME

              Current JavaScript Task
                         │
                         ▼
                 Task completes
                         │
                         ▼
              Microtask Checkpoint
                         │
                ┌────────┴────────┐
                │                 │
          Microtasks?          None
                │                 │
                ▼                 ▼
          Run microtask       Next Task
                │
                ▼
         More microtasks?
                │
           Yes → repeat
                │
                ▼
          Queue empty
                │
                ▼
             Next Task
```

**Next:** `08-setTimeout.md`

References:
- https://developer.mozilla.org/en-US/docs/Web/API/HTML_DOM_API/Microtask_guide
- https://developer.mozilla.org/en-US/docs/Web/API/HTML_DOM_API/Microtask_guide/In_depth
- https://developer.mozilla.org/en-US/docs/Web/JavaScript/Guide/Using_promises
- https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Execution_model
