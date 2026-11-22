# 03 — Call Stack

**Folder:** `03-Asynchronous-JavaScript`

## 1. What Is the Call Stack?

The **Call Stack** is the stack used by JavaScript execution to keep track of the currently active execution contexts.

A useful mental model:

```text
Call Stack
    ↓
Tracks "where JavaScript is currently executing"
```

When a function is called, its execution context is pushed onto the stack.

When the function returns, its context is removed.

MDN describes the call stack as the stack of execution contexts used to transfer control flow into and out of functions. citehttps://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Execution_model

---

# 2. Stack = LIFO

The Call Stack follows:

```text
LIFO
Last In
First Out
```

Think of a stack of plates:

```text
      ┌─────────┐
TOP → │ Plate 3 │
      ├─────────┤
      │ Plate 2 │
      ├─────────┤
      │ Plate 1 │
      └─────────┘
```

The last plate placed on top is the first one removed.

The Call Stack works the same way.

---

# 3. Simple Function Example

```js
function greet() {
    console.log("Hello");
}

greet();
```

High-level flow:

```text
Global
   ↓
greet()
   ↓
console.log()
```

When `greet()` finishes, its execution context is removed and JavaScript returns to the caller.

---

# 4. Nested Function Calls

Consider:

```js
function first() {
    second();
}

function second() {
    third();
}

function third() {
    console.log("Hello");
}

first();
```

When `third()` is executing:

```text
CALL STACK

┌──────────────┐
│ third()      │ ← top / currently executing
├──────────────┤
│ second()     │
├──────────────┤
│ first()      │
├──────────────┤
│ Global       │
└──────────────┘
```

The stack grows as calls are made.

```text
Global
   ↓
first()
   ↓
second()
   ↓
third()
```

Then it shrinks in reverse order:

```text
third() returns
   ↓
second() returns
   ↓
first() returns
   ↓
Global continues
```

MDN uses the same stack-frame model for nested function calls: a new frame is created for each call, and the top frame is popped when the function returns. citehttps://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Execution_model

---

# 5. Push and Pop

The easiest way to understand the stack is:

```text
Function call
    ↓
PUSH

Function return
    ↓
POP
```

Example:

```js
function a() {
    b();
}

function b() {
    c();
}

function c() {
    console.log("Done");
}

a();
```

Execution:

```text
Start:

[Global]

a() called:

[Global]
[a]

b() called:

[Global]
[a]
[b]

c() called:

[Global]
[a]
[b]
[c]
```

After `c()` returns:

```text
[Global]
[a]
[b]
```

After `b()` returns:

```text
[Global]
[a]
```

After `a()` returns:

```text
[Global]
```

---

# 6. Why the Call Stack Matters

The stack tells JavaScript:

```text
Which function is running?
Where should execution return?
Which function called the current function?
What execution context is currently active?
```

Without this tracking, nested function execution would not work correctly.

---

# 7. Connection to Execution Context

You just learned:

```text
Execution Context
```

Now connect it:

```text
Execution Context
        ↓
individual execution state/frame

Call Stack
        ↓
stores/tracks active execution contexts
```

Think:

```text
Execution Context = one frame
Call Stack        = stack of active frames
```

They are related, but they are not the same thing.

---

# 8. Current Stack Frame

Consider:

```js
function add(a, b) {
    const result = a + b;
    return result;
}

const total = add(10, 20);
```

When `add()` is executing, its active context tracks information such as:

```text
a → 10
b → 20
result → 30
```

Conceptually:

```text
CALL STACK

┌─────────────────────┐
│ add()               │
│ a = 10              │
│ b = 20              │
│ result = 30         │
├─────────────────────┤
│ Global              │
└─────────────────────┘
```

The exact internal representation is engine/specification territory. Treat this diagram as a learning model.

---

# 9. Return to the Caller

Consider:

```js
function calculate() {
    return 10 + 20;
}

const result = calculate();

console.log(result);
```

The flow is:

```text
Global
   ↓
calculate()
   ↓
return 30
   ↓
calculate() removed
   ↓
Global resumes
   ↓
result = 30
   ↓
console.log(result)
```

Important:

> Returning from a function removes its active execution frame from the call stack and resumes the caller.

---

# 10. Recursion and the Call Stack

This connects directly to your DSA/recursion experience.

```js
function count(n) {
    if (n === 0) {
        return;
    }

    count(n - 1);
}

count(3);
```

While `count(0)` is executing:

```text
CALL STACK

┌───────────────┐
│ count(0)      │
├───────────────┤
│ count(1)      │
├───────────────┤
│ count(2)      │
├───────────────┤
│ count(3)      │
├───────────────┤
│ Global        │
└───────────────┘
```

Each recursive call creates another execution context and therefore another stack frame.

When the base case returns:

```text
count(0) POP
count(1) POP
count(2) POP
count(3) POP
```

MDN specifically notes that recursive calls create additional execution contexts and therefore consume more stack space. citehttps://developer.mozilla.org/en-US/docs/Web/API/HTML_DOM_API/Microtask_guide/In_depth

---

# 11. Stack Overflow

The stack has finite capacity.

If a program keeps creating function calls without returning, eventually the stack limit can be exceeded.

Example:

```js
function infinite() {
    infinite();
}

infinite();
```

Flow:

```text
infinite()
   ↓
infinite()
   ↓
infinite()
   ↓
infinite()
   ↓
...
```

The stack keeps growing.

Eventually JavaScript throws a stack-related error such as:

```text
RangeError: Maximum call stack size exceeded
```

The exact error wording can vary by engine. citehttps://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Errors/Too_much_recursion

---

# 12. Why the Base Case Matters

Your recursion knowledge directly applies.

Bad:

```js
function count(n) {
    count(n - 1);
}
```

There is no stopping condition.

Better:

```js
function count(n) {
    if (n === 0) {
        return;
    }

    count(n - 1);
}
```

The base case eventually causes the function calls to return.

```text
More calls
    ↓
Base case
    ↓
Returns
    ↓
Stack starts shrinking
```

---

# 13. Synchronous Execution and the Call Stack

Consider:

```js
console.log("A");
console.log("B");
console.log("C");
```

The current JavaScript execution progresses synchronously.

The stack tracks the currently executing work.

Now:

```js
function one() {
    console.log("1");
}

one();

console.log("2");
```

Conceptually:

```text
Global
   ↓
one()
   ↓
console.log("1")
   ↓
one() returns
   ↓
Global resumes
   ↓
console.log("2")
```

The next statement does not execute until the current synchronous execution step returns control.

---

# 14. Call Stack + Your Functional JavaScript

Your previous code:

```js
const total = req
    .map(({ resTime }) => resTime)
    .reduce((acc, value) => acc + value, 0);
```

uses function calls and callbacks.

At a high level:

```text
Current JS execution
       ↓
map()
       ↓
map callback executions
       ↓
reduce()
       ↓
reduce callback executions
       ↓
result
```

The important point:

```text
Callbacks execute
        +
Call Stack tracks active execution
```

But:

```text
Callback
≠
Asynchronous
```

Your `map()` / `reduce()` work is useful here because you already know callbacks in a synchronous context.

---

# 15. Call Stack + setTimeout()

Now compare:

```js
console.log("A");

setTimeout(() => {
    console.log("Timer");
}, 0);

console.log("B");
```

The timer callback does **not** simply get pushed onto the Call Stack immediately when `setTimeout()` is called.

The host schedules the timer, and later the callback becomes eligible to run through the runtime's scheduling mechanism.

For now think:

```text
JavaScript
   ↓
Call Stack
   ↓
setTimeout()
   ↓
Host timer mechanism
   ↓
callback becomes eligible
   ↓
queue / event-loop processing
   ↓
Call Stack
   ↓
callback executes
```

Do not memorize the full queue details yet.

They are the next parts.

---

# 16. Stack Is Not the Queue

This distinction is essential.

### Call Stack

```text
LIFO
```

Tracks currently active execution.

### Job / Task Queues

```text
Queue
```

Hold work that is waiting for an execution turn.

Simplified:

```text
CALL STACK             QUEUE

┌───────────┐          ┌───────────┐
│ current   │          │ waiting   │
│ execution │          │ callbacks │
└───────────┘          └───────────┘
```

Later:

```text
Task Queue
Microtask Queue
Event Loop
```

will be studied separately.

---

# 17. Call Stack Is Synchronous Work's Center

A useful learning model:

```text
Current JavaScript work
        ↓
    Call Stack
        ↓
   execute code
        ↓
  return / pop
```

While JavaScript is executing a long synchronous operation, other queued JavaScript callbacks cannot simply interrupt it.

This is why expensive synchronous work can block the main thread.

---

# 18. Run-to-Completion

A JavaScript job runs to completion before the next job gets its execution turn.

Example:

```js
console.log("Start");

function work() {
    for (let i = 0; i < 1000000000; i++) {}
}

work();

console.log("End");
```

The runtime does not normally insert another queued JavaScript callback into the middle of this ongoing job.

This principle becomes important for the Event Loop and microtasks.

MDN describes jobs as running to completion before the next job begins. citehttps://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Execution_model

---

# 19. Debugging With a Stack Trace

When JavaScript throws an error, you may see a stack trace.

For example:

```js
function first() {
    second();
}

function second() {
    third();
}

function third() {
    throw new Error("Something went wrong");
}

first();
```

The stack trace helps show the chain:

```text
third()
second()
first()
global
```

This is extremely useful when debugging.

The exact `Error.prototype.stack` format is not standardized, but major JavaScript engines provide stack traces for debugging. citehttps://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Error/stack

---

# 20. Common Mistakes

### ❌ "Call Stack stores all functions forever"

No.

It stores active execution frames.

When a function returns, its active frame is removed.

### ❌ "Call Stack is the Event Loop"

No.

```text
Call Stack → active execution
Event Loop  → scheduling coordination
```

### ❌ "A callback is placed directly on the Call Stack whenever it is created"

No.

A callback is only executed when it gets an execution turn.

### ❌ "setTimeout(0) executes immediately"

No.

It does not mean "run this function immediately."

It schedules the callback to be handled later.

### ❌ "Recursion is always bad"

No.

Recursion is valid and useful.

The problem is uncontrolled recursion or excessive depth.

### ❌ "Execution Context and Call Stack are identical"

No.

An execution context is an individual execution frame/state; the call stack tracks active contexts.

---

# 21. Practice

## Practice 1 — Draw the Stack

```js
function a() {
    b();
}

function b() {
    c();
}

function c() {
    console.log("C");
}

a();
```

Draw the stack while `c()` is executing.

---

## Practice 2 — Push / Pop

For:

```js
function one() {
    two();
}

function two() {
    console.log("two");
}

one();
```

Write:

```text
Push:
...

Push:
...

Pop:
...

Pop:
...
```

---

## Practice 3 — Recursion

For:

```js
function count(n) {
    if (n === 0) return;
    count(n - 1);
}

count(3);
```

Draw the stack while `count(0)` is running.

---

## Practice 4 — Stack Overflow

Explain why this fails:

```js
function loop() {
    loop();
}

loop();
```

---

## Practice 5 — Predict

Before learning the Event Loop in detail, predict:

```js
console.log("Start");

setTimeout(() => {
    console.log("Timer");
}, 0);

console.log("End");
```

Write:

```text
Expected output:
1.
2.
3.

Reason:
...
```

Do not use the answer from another source.

---

# 22. Interview Questions

### What is the Call Stack?

A LIFO stack that tracks active execution contexts and function calls.

### What happens when a function is called?

Its execution context is added to the active execution stack.

### What happens when a function returns?

Its active context is removed and execution resumes in the caller.

### What is LIFO?

Last In, First Out.

### Why does recursion use stack space?

Each recursive invocation creates another execution context/frame.

### What causes stack overflow?

Excessive or unbounded nested function calls that exceed the available stack capacity.

### Is the Call Stack the same as the Event Loop?

No.

### Does `setTimeout(fn, 0)` execute `fn` immediately?

No. The callback must wait for the runtime's scheduling mechanism to make it eligible and for JavaScript to get an execution turn.

---

# 23. Completion Checklist

Before moving forward:

- [ ] I understand LIFO.
- [ ] I understand push/pop.
- [ ] I can draw the stack for nested functions.
- [ ] I can connect execution contexts to stack frames.
- [ ] I can explain recursion using the stack.
- [ ] I understand stack overflow.
- [ ] I understand why `setTimeout(..., 0)` is not immediate execution.
- [ ] I can distinguish Call Stack from queues.
- [ ] I understand run-to-completion at a high level.
- [ ] I know why stack traces are useful.
- [ ] I can connect my synchronous `map()` / `reduce()` callbacks to the Call Stack.

---

# 24. Quick Revision

```text
Function call
      ↓
Execution Context / Frame
      ↓
PUSH onto Call Stack
      ↓
Function executes
      ↓
RETURN
      ↓
POP
      ↓
Caller resumes
```

For recursion:

```text
call
 ↓
call
 ↓
call
 ↓
base case
 ↓
return
 ↓
POP
 ↓
return
 ↓
POP
```

Remember:

```text
Call Stack = active execution
LIFO = Last In, First Out

Execution Context ≠ Call Stack

Callback ≠ asynchronous

Recursion → more stack frames

Too much recursion → stack overflow

Queue ≠ Call Stack
```

---

# Final Mental Model

```text
                 JAVASCRIPT EXECUTION

                        Global
                          │
                     function call
                          ▼
                    Execution
                     Context
                          │
                          ▼
                     CALL STACK
                 ┌──────────────────┐
                 │ current function │
                 ├──────────────────┤
                 │ caller           │
                 ├──────────────────┤
                 │ caller           │
                 └──────────────────┘
                          │
                     function return
                          ▼
                    POP / resume
```

The next step is to connect this stack to the environment that handles work outside immediate JavaScript execution.

**Next:** `04-Web-APIs.md`
