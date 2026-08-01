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

# 19. Exercises

### Exercise 1

```js
console.log(a);

var a = 10;
```

Question:

Explain Creation Phase and Execution Phase.

---

### Exercise 2

```js
hello();

function hello(){
    console.log("Hi");
}
```

Why does this work?

---

### Exercise 3

```js
let x = 20;

console.log(x);
```

Explain the memory allocation process.

---

# 20. Summary

- JavaScript creates an Execution Context before running code.
- There are three types: Global, Function, and Eval.
- Every context has a Creation Phase and an Execution Phase.
- Variables are allocated memory before execution.
- Function declarations are hoisted completely.
- Every function call creates a new Function Execution Context.
- Execution Contexts are managed using the Call Stack.

---

# What's Next?

➡️ **Chapter 3 — Call Stack**

You'll learn:

- What the Call Stack is
- Stack Frames
- Push & Pop
- Nested Function Calls
- Recursion
- Stack Overflow
- Visual execution diagrams
- Dry runs
- Interview questions