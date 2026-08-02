# Chapter 2 — Execution Context

> **"Before JavaScript executes even a single line of your code, it creates something called an Execution Context."**

Understanding Execution Context is one of the most important topics in JavaScript. It explains **how JavaScript prepares to run your code**, why **hoisting works**, how **memory is allocated**, and how **functions execute**.

---

# Table of Contents

1. What is an Execution Context?
2. Why Does JavaScript Need It?
3. Real-Life Analogy
4. Types of Execution Context
5. Global Execution Context
6. Function Execution Context
7. Eval Execution Context
8. Life Cycle of an Execution Context
9. Creation Phase
10. Execution Phase
11. Memory Allocation
12. Variable Hoisting
13. Function Hoisting
14. Function Invocation
15. Call Stack Relationship
16. Complete Dry Run
17. Interview Questions
18. Common Mistakes
19. Exercises
20. Summary

---

# 1. What is an Execution Context?

Execution Context is the **environment** in which JavaScript executes code.

Think of it as a **workspace**.

Whenever JavaScript runs code, it first creates a workspace that contains:

- Variables
- Functions
- Scope information
- The value of `this`

Only after creating this workspace does JavaScript begin executing the code.

---

Example

```js
let x = 10;

function greet() {
    console.log("Hello");
}

greet();
```

Before line 1 executes,

JavaScript first creates an Execution Context.

---

# 2. Why Does JavaScript Need It?

Imagine writing an exam.

Before writing,

you receive:

- Question paper
- Answer sheet
- Roll number
- Pen

Only then do you start writing.

Execution Context is JavaScript's "answer sheet."

Without it,

JavaScript wouldn't know:

- where variables are stored
- where functions exist
- what `this` refers to
- which scope to use

---

# 3. Real-Life Analogy

Imagine opening Microsoft Word.

Before typing,

Word creates:

- a blank page
- cursor
- memory
- formatting settings

Only then can you type.

Execution Context is that blank document.

---

# 4. Types of Execution Context

JavaScript has three types.

---

## Global Execution Context (GEC)

Created once.

It runs first.

Example

```js
console.log("Hello");
```

Entire program starts here.

---

## Function Execution Context (FEC)

Created every time a function is called.

```js
function add(){

}

add();
```

Calling `add()` creates a new Function Execution Context.

---

## Eval Execution Context

Created only when using

```js
eval()
```

Rarely used.

Almost never asked in interviews.

---

# 5. Global Execution Context

The first thing JavaScript creates.

Example

```js
let x = 10;

console.log(x);
```

Flow

```
Program Starts

↓

Create GEC

↓

Creation Phase

↓

Execution Phase

↓

Program Ends
```

There is only **one Global Execution Context**.

---

# 6. Function Execution Context

Every function call creates a new context.

Example

```js
function one(){

}

one();
one();
```

Execution

```
GEC

↓

FEC

↓

Destroyed

↓

FEC

↓

Destroyed
```

Each function call gets a fresh workspace.

---

# 7. Eval Execution Context

Example

```js
eval("console.log('Hello')");
```

Avoid using `eval`.

---

# 8. Life Cycle

Every Execution Context has two phases.

```
Creation Phase

↓

Execution Phase
```

---

# 9. Creation Phase

This happens **before any code executes.**

JavaScript:

- allocates memory
- creates variables
- stores function definitions
- decides `this`

Nothing has executed yet.

---

Example

```js
console.log(a);

var a = 10;
```

During Creation Phase

```
a

↓

undefined
```

Then execution begins.

---

# 10. Execution Phase

Now JavaScript executes line by line.

```
var a = 10;
```

updates

```
undefined

↓

10
```

---

# 11. Memory Allocation

Variables get memory.

Example

```js
var age = 20;

var name = "Om";
```

Creation Phase

```
Memory

age

↓

undefined

name

↓

undefined
```

Execution Phase

```
age

↓

20

name

↓

Om
```

---

# 12. Variable Hoisting

Example

```js
console.log(a);

var a = 5;
```

Output

```
undefined
```

Why?

Because memory was already created.

---

Example

```js
console.log(x);

let x = 10;
```

Output

```
ReferenceError
```

We'll study the Temporal Dead Zone later.

---

# 13. Function Hoisting

Functions are stored completely during Creation Phase.

Example

```js
greet();

function greet(){
    console.log("Hello");
}
```

Works perfectly.

---

Why?

Because the entire function is already in memory.

---

# 14. Function Invocation

Example

```js
function one(){

}

one();
```

Flow

```
Global Context

↓

Call one()

↓

Create Function Context

↓

Execute

↓

Destroy Context

↓

Return
```

---

# 15. Relation with Call Stack

Every Execution Context sits on the Call Stack.

```
Call Stack

↓

Global Context

↓

Function Context

↓

Function Context

↓

Return

↓

Empty
```

---

# 16. Dry Run

```js
var x = 10;

function hello(){
    var y = 20;
}

hello();
```

### Creation Phase

```
Memory

x

↓

undefined

hello

↓

Function
```

---

Execution

```
x = 10

↓

hello()

↓

New Function Context

↓

y = undefined

↓

y = 20

↓

Destroy Context
```

---

Final

```
Global

x = 10

hello = Function
```

---

# 17. Interview Questions

## What is Execution Context?

Execution Context is the environment in which JavaScript executes code. It stores variables, functions, scope information, and the value of `this`.

---

## How many Execution Contexts exist?

- Global
- Function
- Eval

---

## Which Execution Context is created first?

Global Execution Context.

---

## What are the two phases?

- Creation Phase
- Execution Phase

---

## Why does hoisting happen?

Because memory allocation occurs during the Creation Phase before code execution.

---

# 18. Common Mistakes

❌ Thinking Execution Context and Call Stack are the same.

No.

Execution Context is an object.

Call Stack stores Execution Contexts.

---

❌ Thinking JavaScript executes immediately.

No.

Creation Phase happens first.

---

❌ Thinking functions are created during execution.

Wrong.

Functions are stored during Creation Phase.

---
Here is a more interview-ready version of your **Exercises** and **Summary**. It fixes the `let` mistake and uses professional wording while remaining easy to understand.

---

# 19. Exercises

## Exercise 1

```js
console.log(a);

var a = 10;
```

### Question

Explain the Creation Phase and Execution Phase.

### Answer

### Step 1: Global Execution Context (GEC) is created

Before executing any code, JavaScript creates the Global Execution Context.

### Creation Phase

Memory Allocation:

```
a
↓
undefined
```

During this phase:

* Memory is allocated for `a`.
* Since `a` is declared using `var`, it is initialized with `undefined`.

### Execution Phase

JavaScript executes the code line by line.

```js
console.log(a);
```

Output

```
undefined
```

because `a` currently contains `undefined`.

Next,

```js
var a = 10;
```

updates the memory.

```
a
↓
10
```

---

## Exercise 2

```js
hello();

function hello() {
    console.log("Hi");
}
```

### Question

Why does this work?

### Answer

During the **Creation Phase**, JavaScript stores the **entire function definition** in memory.

Memory after Creation Phase:

```
hello
↓
Function
```

So when the Execution Phase begins,

```js
hello();
```

JavaScript already knows where the function exists and executes it successfully.

Output

```
Hi
```

This behavior is called **Function Hoisting**.

---

## Exercise 3

```js
let x = 20;

console.log(x);
```

### Question

Explain the memory allocation process.

### Answer

### Step 1: Global Execution Context (GEC) is created.

### Creation Phase

Memory is reserved for `x`, but it is **not initialized**.

```
x
↓
Uninitialized
(TDZ - Temporal Dead Zone)
```

Unlike `var`, `let` is **not assigned `undefined`** during the Creation Phase.

### Execution Phase

```js
let x = 20;
```

Now `x` is initialized.

```
x
↓
20
```

Next,

```js
console.log(x);
```

Output

```
20
```

If we tried to access `x` before initialization,

```js
console.log(x);

let x = 20;
```

JavaScript would throw:

```
ReferenceError
```

because `x` is inside the **Temporal Dead Zone (TDZ)**.

---

# 20. Summary

After completing this chapter, you should understand:

* ✅ JavaScript creates an **Execution Context** before executing any code.
* ✅ An Execution Context is the environment where JavaScript runs code.
* ✅ There are **three types** of Execution Context:

  * Global Execution Context (GEC)
  * Function Execution Context (FEC)
  * Eval Execution Context (rarely used)
* ✅ Every Execution Context goes through **two phases**:

  * Creation Phase
  * Execution Phase
* ✅ During the **Creation Phase**, JavaScript:

  * Allocates memory for variables.
  * Stores function declarations completely.
  * Determines the value of `this`.
* ✅ During the **Execution Phase**, JavaScript executes code line by line.
* ✅ Variables declared with `var` are initialized with `undefined`.
* ✅ Variables declared with `let` and `const` remain **uninitialized** until their declaration is executed (Temporal Dead Zone).
* ✅ Function declarations are fully hoisted and can be called before their definition.
* ✅ Every function call creates a new **Function Execution Context**.
* ✅ Execution Contexts are managed using the **Call Stack**.
* ✅ After a function finishes execution, its Function Execution Context is removed from the Call Stack.

---

## Key Interview Takeaways

* ✔️ Execution Context is **not** the Call Stack.
* ✔️ Hoisting happens during the **Creation Phase**.
* ✔️ `var` is initialized with `undefined`.
* ✔️ `let` and `const` stay in the **Temporal Dead Zone (TDZ)** until initialization.
* ✔️ Every function call creates a **new Execution Context**.
* ✔️ Function declarations are fully hoisted, while function expressions are not.

---

# What's Next?

➡️ **Chapter 3 – Call Stack**

In the next chapter, you'll learn:

* What is the Call Stack?
* Stack Frames
* Push & Pop Operations
* Nested Function Calls
* Recursion
* Stack Overflow
* Relationship between Execution Context and Call Stack
* Visual Execution Diagrams
* Dry Runs
* Common Interview Questions
* Coding Exercises

This version is technically accurate, interview-focused, and flows naturally from the concepts introduced in the chapter.
