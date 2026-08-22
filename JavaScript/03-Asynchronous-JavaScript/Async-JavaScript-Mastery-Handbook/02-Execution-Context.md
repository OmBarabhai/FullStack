# 02 — Execution Context

**Folder:** `03-Asynchronous-JavaScript`

## 1. What Is an Execution Context?

An **execution context** is the environment in which a piece of JavaScript code is evaluated and executed.

A simple mental model:

```text
Execution Context
│
├── Code being executed
├── Variables / bindings
├── Current `this`
├── Scope-related information
└── Other execution state
```

Every time JavaScript needs to execute code, it does so inside an execution context.

MDN describes an execution context as the smallest unit of execution and explains that it keeps track of things such as the code being evaluated, its bindings, the current realm, and `this`. citeturn0search0

---

# 2. Why Do We Need Execution Contexts?

Consider:

```js
const name = "Om";

function greet() {
    const message = "Hello";
    console.log(message, name);
}

greet();
```

JavaScript needs to know:

```text
Where is `name`?
Where is `message`?
Which function is currently running?
What should happen after the function returns?
What is `this` in the current context?
```

Execution contexts provide the conceptual structure needed to keep track of this information.

---

# 3. Global Execution Context

When the main JavaScript code begins executing, a **global execution context** is created.

Example:

```js
const name = "Om";

console.log(name);
```

Conceptually:

```text
Global Execution Context
│
├── name → "Om"
├── global-level code
└── other execution state
```

The global context represents the execution of the main body of the script/module.

It is the starting point of normal JavaScript execution.

---

# 4. Function Execution Context

Every function call creates a new execution context.

Example:

```js
function greet(name) {
    const message = "Hello " + name;
    return message;
}

greet("Om");
```

When `greet("Om")` is called:

```text
Global Context
      ↓
greet() Context
```

The function context needs to track things such as:

```text
name
message
function execution state
this
```

When the function finishes, its execution context is no longer the currently active context.

MDN describes each function call as creating a new execution context that is pushed onto the execution-context stack and later removed when the function returns. citeturn0search4

---

# 5. Execution Context vs Call Stack

These two terms are related but **not identical**.

### Execution Context

The environment/state associated with executing a particular piece of code.

### Call Stack

The stack structure that tracks active execution contexts.

Think:

```text
Execution Context = a frame
Call Stack        = collection of active frames
```

Example:

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

Conceptually:

```text
CALL STACK
┌──────────────┐
│ third()      │ ← currently running
├──────────────┤
│ second()     │
├──────────────┤
│ first()      │
├──────────────┤
│ Global       │
└──────────────┘
```

The detailed stack behavior is the next dedicated topic.

---

# 6. Function Call Step-by-Step

Consider:

```js
function add(a, b) {
    const result = a + b;
    return result;
}

const total = add(10, 20);
```

Conceptually:

### Step 1 — Global code starts

```text
Global Execution Context
```

### Step 2 — `add()` is called

```text
Global
   ↓
add()
```

A new function execution context is created.

### Step 3 — Parameters are available

```text
a → 10
b → 20
```

### Step 4 — Local variable is created

```text
result → 30
```

### Step 5 — Function returns

```text
return 30
```

### Step 6 — Control returns to the caller

```text
Global
```

Then:

```js
total
```

receives:

```text
30
```

---

# 7. Nested Function Calls

This is where execution contexts become especially useful.

```js
function first() {
    const a = 10;
    second();
}

function second() {
    const b = 20;
    third();
}

function third() {
    const c = 30;
    console.log("Done");
}

first();
```

Execution flow:

```text
Global
  ↓
first()
  ↓
second()
  ↓
third()
```

At the deepest point:

```text
CALL STACK

┌─────────────┐
│ third()     │
├─────────────┤
│ second()    │
├─────────────┤
│ first()     │
├─────────────┤
│ Global      │
└─────────────┘
```

When `third()` finishes:

```text
third() removed
```

Then:

```text
second()
```

continues.

Then `second()` finishes:

```text
second() removed
```

Then `first()` continues.

This is the bridge to the next topic:

```text
Execution Context
        ↓
Call Stack
```

---

# 8. What Does an Execution Context Track?

At your current learning level, remember these four important ideas:

```text
1. Code being executed
2. Variables / bindings
3. Scope-related information
4. `this`
```

There is more detail in the ECMAScript specification, but you do not need to memorize specification internals yet.

The goal is to understand **why each function call needs its own execution state**.

---

# 9. Variables Are Context-Dependent

Example:

```js
const x = 10;

function test() {
    const x = 20;
    console.log(x);
}

test();

console.log(x);
```

Output:

```text
20
10
```

Why?

Because the function has its own execution context and its own local binding:

```text
Global Context
└── x → 10

test() Context
└── x → 20
```

The two `x` variables are different bindings.

---

# 10. Connection to Scope

Execution context and scope are related, but do not treat them as the same concept.

### Scope

Describes where identifiers can be accessed.

### Execution Context

Describes the execution state/environment for currently running code.

Example:

```js
const x = 10;

function test() {
    const y = 20;
    console.log(x, y);
}

test();
```

The function can access:

```text
y → local
x → outer scope
```

The detailed lexical-scope and closure mechanics belong to your later:

```text
04-Functions-Scope-Closures
```

For now, understand the connection only.

---

# 11. Execution Context and `this`

An execution context also has information related to the current `this` value.

Example:

```js
function show() {
    console.log(this);
}
```

The value of `this` depends on how the function is called and the surrounding execution rules.

Do not attempt to master `this` here.

Your dedicated topic later:

```text
04-Functions-Scope-Closures
└── 09-this.md
```

will cover it properly.

For this Part, remember:

```text
Execution Context
        ↓
includes current `this` information
```

---

# 12. Global vs Function Context

### Global code

```js
const app = "DevAPI";

console.log(app);
```

Conceptually:

```text
Global Execution Context
```

### Function call

```js
function start() {
    const status = "running";
}

start();
```

Conceptually:

```text
Global Execution Context
        ↓
Function Execution Context
```

Every function invocation creates its own execution context.

---

# 13. Execution Contexts and Recursion

This is especially useful because you already have recursion experience.

Consider:

```js
function count(n) {
    if (n === 0) {
        return;
    }

    count(n - 1);
}

count(3);
```

Conceptually:

```text
Global
  ↓
count(3)
  ↓
count(2)
  ↓
count(1)
  ↓
count(0)
```

Each recursive call creates another execution context.

So:

```text
count(3) → Context 1
count(2) → Context 2
count(1) → Context 3
count(0) → Context 4
```

This is one reason recursion uses additional stack space.

The call-stack mechanics will be studied next.

---

# 14. Execution Context and Your Previous Functional JavaScript

Your Folder 02 code:

```js
const totResTime = req
    .map(({ resTime }) => resTime)
    .reduce((acc, currResTime) => {
        return currResTime + acc;
    }, 0);
```

contains function calls and callbacks.

The callbacks execute within execution contexts created for those function invocations.

But remember:

```text
Execution Context
≠
Asynchronous
```

A function can have an execution context during completely synchronous execution.

This is an important distinction.

---

# 15. Execution Context and Asynchronous JavaScript

Now connect this to the current folder.

Consider:

```js
setTimeout(() => {
    console.log("Done");
}, 0);
```

The callback does not execute immediately just because it was written.

When it eventually gets a turn to execute, JavaScript creates/uses the execution state required to run that callback.

Conceptually:

```text
Timer completes
      ↓
Callback becomes eligible
      ↓
Callback gets execution turn
      ↓
Execution Context
      ↓
Call Stack
      ↓
Callback runs
```

The detailed queue and event-loop rules come later.

---

# 16. Execution Context vs Scope vs Closure

Keep these three concepts separate:

```text
Execution Context
    ↓
Current execution state

Scope
    ↓
Where identifiers are accessible

Closure
    ↓
Function retains access to its surrounding lexical environment
```

Example:

```js
function outer() {
    const message = "Hello";

    return function inner() {
        console.log(message);
    };
}

const fn = outer();

fn();
```

The function `inner` can still access `message`.

This is a closure.

Do not study closure deeply here. It belongs in Folder 04.

---

# 17. Important Correction: "Execution Context Is an Object"

Avoid thinking:

```text
Execution Context = normal JavaScript object
```

That is misleading.

Execution context is a **specification/runtime concept** describing the state needed to execute code.

It is not something you normally create manually with:

```js
new ExecutionContext()
```

There is no ordinary JavaScript API like that.

---

# 18. Important Correction: "Every Line Creates a New Context"

Wrong.

For example:

```js
const a = 10;
const b = 20;
const c = a + b;
```

These statements execute within the same current execution context.

A function call creates a new function execution context:

```js
function add() {
    // new function execution context when called
}

add();
```

So:

```text
Statement
≠
New execution context

Function call
→ new execution context
```

Other language constructs can have additional execution-context behavior, but that detail is not required here.

---

# 19. High-Level Model

Keep this model:

```text
JavaScript starts
       ↓
Global Execution Context
       ↓
Function called
       ↓
New Function Execution Context
       ↓
Function calls another function
       ↓
Another Execution Context
       ↓
Function returns
       ↓
Context leaves active execution stack
```

Combined with the next topic:

```text
Execution Context
       ↓
Call Stack
```

---

# 20. Practice

## Practice 1

How many function execution contexts are created here?

```js
function one() {
    two();
}

function two() {
    three();
}

function three() {
    console.log("Done");
}

one();
```

Do not count the global context unless asked separately.

---

## Practice 2

Draw the active stack at the moment `three()` is executing.

```text
?
?
?
?
```

---

## Practice 3

Explain why these two values can coexist:

```js
const x = 10;

function test() {
    const x = 20;
    console.log(x);
}

test();
```

---

## Practice 4

For this recursive code:

```js
function count(n) {
    if (n === 0) return;
    count(n - 1);
}

count(3);
```

Draw the execution-context chain when `count(0)` is executing.

---

## Practice 5

Explain the difference:

```text
Execution Context
Call Stack
Scope
Closure
```

Do not memorize definitions. Explain the responsibility of each.

---

# 21. Interview Questions

### Q1. What is an execution context?

It is the runtime/specification environment used to execute a piece of JavaScript code and track the state required for that execution.

### Q2. What is the global execution context?

The execution context used to execute the main/global body of JavaScript code.

### Q3. Does every function call create a new execution context?

Yes, a function invocation creates a function execution context.

### Q4. Is an execution context the same as the call stack?

No.

```text
Execution Context → individual execution frame/state
Call Stack        → stack tracking active execution contexts
```

### Q5. Why does recursion create multiple execution contexts?

Because each recursive function invocation creates a new function execution context.

### Q6. Is execution context the same as scope?

No.

Scope describes identifier accessibility; execution context describes the state/environment used while code is executing.

### Q7. Does an execution context make code asynchronous?

No.

Execution contexts exist during synchronous and asynchronous callback execution.

---

# 22. Completion Checklist

Before moving to the next Part, you should be able to:

- [ ] Explain what an execution context is
- [ ] Explain global execution context
- [ ] Explain function execution context
- [ ] Explain why function calls create new contexts
- [ ] Distinguish execution context from call stack
- [ ] Explain the connection between context and local variables
- [ ] Explain the basic connection to `this`
- [ ] Explain why recursion creates multiple contexts
- [ ] Distinguish execution context from scope
- [ ] Distinguish execution context from closure
- [ ] Connect execution context to Folder 02 callbacks
- [ ] Draw a simple nested-call stack

---

# 23. Quick Revision

```text
Execution Context
        ↓
Environment/state required to execute code
        ↓
Global code → Global Context
Function call → Function Context
        ↓
Active contexts are tracked by the Call Stack
```

Remember:

```text
Execution Context ≠ Call Stack
Execution Context ≠ Scope
Execution Context ≠ Closure
Callback ≠ Asynchronous
Function call → new function execution context
Recursion → multiple function execution contexts
```

---

# Final Mental Model

```text
                JavaScript Execution
                        │
                        ▼
              Global Execution Context
                        │
                 function call
                        ▼
             Function Execution Context
                        │
                 function call
                        ▼
             Another Execution Context
                        │
                        ▼
                  Call Stack
                        │
                 return / finish
                        ▼
              Previous context resumes
```

**Next:** `03-Call-Stack.md`
