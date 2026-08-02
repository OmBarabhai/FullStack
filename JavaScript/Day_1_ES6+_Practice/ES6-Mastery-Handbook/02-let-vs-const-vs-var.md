# let vs const vs var

> **"Understanding `let`, `const`, and `var` is the foundation of modern JavaScript. Choosing the correct variable declaration helps you write predictable, maintainable, and bug-free code."**

---

# Table of Contents

1. Introduction
2. Why Variables Matter
3. History of Variable Declarations
4. Why `var` Was a Problem
5. Evolution of JavaScript
6. What is `var`?
7. What is `let`?
8. What is `const`?
9. Feature Comparison
10. Choosing Between `let` and `const`
11. Summary (Part 1)

---

# 1. Introduction

Variables are one of the first things every programmer learns.

Whether you are building:

- a website
- a mobile application
- a backend server
- a game
- an AI application

you will constantly use variables.

Everything in JavaScript starts with variables.

---

## What is a Variable?

A variable is simply a **named container** that stores data in memory.

Think of a variable as a labeled box.

```
        +-------------+
name -->|     Om      |
        +-------------+
```

The label is

```
name
```

The value inside the box is

```
Om
```

Whenever we need the value,

we simply use the variable name.

Example

```js
let name = "Om";

console.log(name);
```

Output

```
Om
```

---

## Another Example

```js
let age = 22;

console.log(age);
```

Output

```
22
```

The computer stores

```
age

↓

22
```

inside memory.

---

## Variables Make Programs Flexible

Imagine writing

```js
console.log("Om");
console.log("Om");
console.log("Om");
console.log("Om");
console.log("Om");
```

Now imagine your name changes.

You must update every line.

Instead,

store it once.

```js
const name = "Om";

console.log(name);
console.log(name);
console.log(name);
console.log(name);
console.log(name);
```

Now changing

```js
const name = "Raj";
```

updates the value everywhere.

This is one of the biggest reasons variables exist.

---

# 2. Why Variables Matter

Imagine building an E-commerce website.

A customer has

- Name
- Email
- Cart
- Address
- Phone Number
- Total Price

Without variables

you would have no place to store this information.

Example

```js
const customerName = "Om";

const totalPrice = 4999;

const city = "Pune";
```

Every application you use stores thousands of variables every second.

Examples

Instagram

```
username

followers

likes

comments

messages
```

YouTube

```
videoTitle

views

likes

duration
```

Bank Application

```
balance

accountNumber

pin

transactions
```

Everything is stored using variables.

---

# 3. History of Variable Declarations

JavaScript was created in **1995**.

Back then,

there was only one keyword.

```
var
```

For many years,

developers used only `var`.

```
1995

↓

var
```

As websites became larger,

developers started noticing problems.

Large companies like

- Google
- Facebook
- Microsoft

were writing millions of lines of JavaScript.

`var` started creating bugs that were difficult to debug.

---

## ES6 Changed Everything

In **2015**,

ECMAScript 6 (ES6) introduced

```
let

const
```

These solved many problems caused by `var`.

Timeline

```
1995

↓

JavaScript Created

↓

Only var

↓

Large Applications

↓

Many Bugs

↓

ES6 (2015)

↓

let

↓

const

↓

Modern JavaScript
```

Today,

professional developers rarely use `var`.

---

# 4. Why `var` Was a Problem

Before ES6,

JavaScript only had `var`.

Although it worked,

it introduced several issues that made large applications difficult to maintain.

The biggest problems were:

- No block scope
- Re-declaration
- Hoisting confusion
- Variables leaking outside blocks
- Loop-related bugs
- Accidental globals

Let's understand each one.

---

## Problem 1 — No Block Scope

Consider this code.

```js
if (true) {

    var age = 22;

}

console.log(age);
```

Output

```
22
```

Many beginners expect

```
ReferenceError
```

because they think

```
age
```

belongs only inside the block.

But `var` ignores block scope.

Visualization

```
Global Scope

│

├── if Block

│      │

│      └── var age = 22

│

└── age still exists ✅
```

This behavior caused many unexpected bugs.

---

## Problem 2 — Loop Variables Escape

```js
for (var i = 0; i < 3; i++) {

    console.log(i);

}

console.log(i);
```

Output

```
0
1
2
3
```

Most developers expected

```
ReferenceError
```

Instead,

`i` still exists.

Visualization

```
Global Scope

│

├── for Loop

│      │

│      └── var i

│

└── i still exists ✅
```

---

## Real Bug Example

Imagine

```js
for (var i = 0; i < users.length; i++) {

}
```

Hundreds of lines later

```js
console.log(i);
```

Output

```
101
```

The loop variable accidentally leaked into the rest of the program.

Large applications suffered from this issue frequently.

---

## Problem 3 — Re-declaration

JavaScript allows this.

```js
var city = "Pune";

var city = "Mumbai";

console.log(city);
```

Output

```
Mumbai
```

No error occurs.

Another developer may accidentally overwrite your variable.

---

## Problem 4 — Hoisting Confusion

```js
console.log(score);

var score = 100;
```

Output

```
undefined
```

Many beginners expect

```
ReferenceError
```

But JavaScript first creates the variable

```
score

↓

undefined
```

and only later assigns

```
100
```

We'll study this deeply in the Hoisting section.

---

## Problem 5 — Accidental Global Variables

In non-strict mode,

forgetting to declare a variable creates a global variable.

```js
function test() {

    message = "Hello";

}

test();

console.log(message);
```

Output

```
Hello
```

This pollutes the global scope.

Modern JavaScript avoids this completely.

---

## ES6 Solution

JavaScript introduced

```
let

const
```

These provide

- Block Scope
- Better Readability
- Better Maintainability
- Safer Code
- Fewer Bugs

Example

```js
if (true) {

    let age = 22;

}

console.log(age);
```

Output

```
ReferenceError: age is not defined
```

Now the variable remains inside the block.

Exactly what developers wanted.

---

# 5. Evolution of JavaScript

```
1995

↓

var

↓

Scope Problems

↓

Hoisting Confusion

↓

Loop Bugs

↓

Large Applications

↓

Need Better Variables

↓

ES6 (2015)

↓

let

↓

const

↓

Modern JavaScript
```

---

## Modern Development Rule

Professional developers usually follow this order.

```
Need a Variable?

↓

Will the value change?

↓

NO

↓

const ✅

--------------------

YES

↓

let ✅

--------------------

Avoid

↓

var ❌
```

If you're unsure,

start with

```
const
```

If later the value needs to change,

convert it to

```
let
```

---

# 6. What is `var`?

`var` is the original keyword used to declare variables in JavaScript.

Example

```js
var language = "JavaScript";

console.log(language);
```

Output

```
JavaScript
```

---

## Characteristics

- Function Scoped
- Can be Re-declared
- Can be Re-assigned
- Hoisted
- Initialized with `undefined`
- Can cause unexpected bugs
- Rarely used today

---

Example

```js
var language = "JavaScript";

language = "TypeScript";

console.log(language);
```

Output

```
TypeScript
```

---

## When Should You Use `var`?

Almost never.

You may still encounter it in

- old projects
- legacy codebases
- interview questions

Modern projects use

```
const

↓

let
```

instead.

---

# 7. What is `let`?

`let` declares a **block-scoped** variable.

It was introduced in ES6 to solve problems caused by `var`.

Example

```js
let age = 22;

console.log(age);
```

Output

```
22
```

---

## Characteristics

- Block Scoped
- Cannot be Re-declared in the same scope
- Can be Re-assigned
- Hoisted
- Exists in the Temporal Dead Zone
- Preferred when values change

---

Example

```js
let score = 50;

score = 100;

console.log(score);
```

Output

```
100
```

---

# 8. What is `const`?

`const` declares a variable whose **reference cannot be reassigned**.

It is the preferred way to declare variables in modern JavaScript.

Example

```js
const PI = 3.14159;

console.log(PI);
```

Output

```
3.14159
```

---

## Characteristics

- Block Scoped
- Cannot be Re-declared
- Cannot be Re-assigned
- Must be Initialized
- Hoisted
- Exists in TDZ
- Default choice in modern JavaScript

---

Example

```js
const country = "India";

console.log(country);
```

Output

```
India
```

---

# 9. Feature Comparison

| Feature | var | let | const |
|----------|:---:|:---:|:-----:|
| Scope | Function | Block | Block |
| Hoisted | ✅ | ✅ | ✅ |
| TDZ | ❌ | ✅ | ✅ |
| Re-declare | ✅ | ❌ | ❌ |
| Re-assign | ✅ | ✅ | ❌ |
| Initialization Required | ❌ | ❌ | ✅ |
| Recommended Today | ❌ | ✅ | ✅ |

---

## Interview Tip

Professional developers generally follow this rule.

```
const

↓

let

↓

Never var
```

In most production projects,

approximately

```
const → 80–90%

let → 10–20%

var → Almost Never
```

---

# 10. Choosing Between `let` and `const`

Ask yourself one simple question.

```
Will this value change?

↓

No

↓

const

----------------------

Yes

↓

let
```

Examples

```js
const PI = 3.14;

const company = "Google";

let score = 0;

let attempts = 1;
```

---

# 11. Summary (Part 1)

- Variables store data in memory.
- JavaScript originally had only `var`.
- `var` caused many issues in large applications.
- ES6 introduced `let` and `const`.
- `let` is block-scoped and allows re-assignment.
- `const` is block-scoped and prevents re-assignment.
- Prefer `const` by default.
- Use `let` only when the value changes.
- Avoid `var` in modern JavaScript.

---

## Next Part

In **Part 2**, we'll cover:

- Scope
- Global Scope
- Function Scope
- Block Scope
- Scope Chain
- Hoisting
- Temporal Dead Zone (TDZ)
- Memory Behavior
- Dry Runs
- Visual Diagrams
- Interview Questions

# 12. Scope

One of the biggest differences between **`var`**, **`let`**, and **`const`** is **Scope**.

Understanding scope is extremely important because it explains:

- Why some variables are accessible
- Why others throw `ReferenceError`
- Why `let` and `const` were introduced
- How JavaScript prevents accidental bugs

Many interview questions are directly based on scope.

---

## What is Scope?

**Scope** determines **where a variable can be accessed** in your program.

Think of scope as the **visibility** of a variable.

If a variable is inside its scope,

JavaScript can access it.

If it's outside,

JavaScript cannot find it.

---

## Real-Life Analogy

Imagine a house.

```
House

│

├── Living Room

├── Kitchen

├── Bedroom
```

Suppose your wallet is inside the bedroom.

```
Bedroom

↓

Wallet
```

Can someone standing in the kitchen immediately access it?

No.

They must enter the bedroom first.

Variables behave the same way.

---

## JavaScript has Three Types of Scope

```
Scope

│

├── Global Scope

├── Function Scope

└── Block Scope
```

We'll study each one in detail.

---

# 13. Global Scope

Variables declared outside every function and block belong to the **Global Scope**.

Example

```js
const company = "Google";

function printCompany() {
    console.log(company);
}

printCompany();

console.log(company);
```

Output

```
Google
Google
```

---

## Dry Run

Program Starts

↓

Global Execution Context Created

↓

company = "Google"

↓

Function Created

↓

printCompany()

↓

console.log(company)

↓

Google

↓

Back to Global

↓

console.log(company)

↓

Google

---

## Memory Visualization

```
Global Memory

│

├── company

│      ↓

│   "Google"

│

└── printCompany()
```

Since `company` is global,

everyone can access it.

---

## Diagram

```
Global Scope

│

├── company

│

├── function printCompany()

│      │

│      └── company ✅

│

└── console.log(company) ✅
```

---

## Another Example

```js
let age = 22;

if (true) {
    console.log(age);
}

console.log(age);
```

Output

```
22
22
```

Because `age` belongs to the global scope.

---

## Important Note

Global variables are accessible almost everywhere.

This sounds useful,

but having too many global variables is dangerous.

---

## Why?

Imagine a project with

```
500 files
```

and every file creates global variables.

Soon,

multiple developers may accidentally use the same variable names.

This causes conflicts.

---

## Best Practice

Avoid creating unnecessary global variables.

Keep variables inside the smallest scope possible.

---

# 14. Function Scope

A **Function Scope** is created every time a function executes.

Variables declared using **`var`** belong to the function where they are declared.

---

## Example 1

```js
function test() {

    var x = 10;

    console.log(x);

}

test();
```

Output

```
10
```

Why?

Because `x` exists inside the function.

---

## Example 2

```js
function test() {

    var x = 10;

}

test();

console.log(x);
```

Output

```
ReferenceError: x is not defined
```

---

## Dry Run

Program Starts

↓

Global Execution Context

↓

Function Created

↓

Call test()

↓

Create Function Execution Context

↓

x = 10

↓

Function Ends

↓

Function Execution Context Destroyed

↓

console.log(x)

↓

ReferenceError

---

## Scope Visualization

```
Global Scope

│

├── function test()

│      │

│      ├── x = 10

│      │

│      └── console.log(x) ✅

│

└── console.log(x) ❌
```

---

## Why?

When a function finishes,

its Execution Context is destroyed.

All local variables are removed from memory.

Therefore,

`x` no longer exists.

---

## Another Example

```js
function add() {

    var a = 5;

    var b = 10;

    console.log(a + b);

}

add();
```

Output

```
15
```

Outside the function

```js
console.log(a);
```

Output

```
ReferenceError
```

Because

```
a

↓

Function Scope
```

---

# 15. Block Scope

A **Block** is any code written between curly braces `{}`.

Examples

```js
if () {

}

for () {

}

while () {

}

switch () {

}

{

}
```

---

Variables declared using

```
let

const
```

are **Block Scoped**.

---

## Example

```js
{

    let age = 20;

}

console.log(age);
```

Output

```
ReferenceError
```

---

## Dry Run

Enter Block

↓

Create age

↓

age = 20

↓

Leave Block

↓

Destroy age

↓

console.log(age)

↓

ReferenceError

---

## Scope Diagram

```
Global Scope

│

├── Block

│      │

│      └── age = 20

│

└── console.log(age) ❌
```

---

## Example using if

```js
if (true) {

    let city = "Pune";

    console.log(city);

}

console.log(city);
```

Output

```
Pune

ReferenceError
```

---

## Example using const

```js
if (true) {

    const PI = 3.14;

}

console.log(PI);
```

Output

```
ReferenceError
```

---

## Example using var

```js
if (true) {

    var city = "Pune";

}

console.log(city);
```

Output

```
Pune
```

---

## Why?

Because

```
var

↓

Function Scope

NOT

↓

Block Scope
```

---

## Comparison

### var

```js
if (true) {

    var age = 20;

}

console.log(age);
```

Output

```
20
```

---

### let

```js
if (true) {

    let age = 20;

}

console.log(age);
```

Output

```
ReferenceError
```

---

### const

```js
if (true) {

    const age = 20;

}

console.log(age);
```

Output

```
ReferenceError
```

---

# 16. Scope Chain

When JavaScript cannot find a variable,

it searches **outward**.

This searching process is called the **Scope Chain**.

---

Example

```js
const country = "India";

function outer() {

    const state = "Maharashtra";

    function inner() {

        const city = "Pune";

        console.log(country);

        console.log(state);

        console.log(city);

    }

    inner();

}

outer();
```

Output

```
India
Maharashtra
Pune
```

---

## Scope Chain Diagram

```
Global Scope

│

└── country

      │

      ▼

outer()

│

└── state

      │

      ▼

inner()

│

└── city
```

JavaScript searches

```
city

↓

state

↓

country

↓

Not Found?

↓

ReferenceError
```

---

## Interview Tip

JavaScript searches

**Inside → Outside**

It never searches

**Outside → Inside**

For example,

Global Scope **cannot** access variables inside a function.

But a function **can** access global variables.

---

# 17. Scope Summary

| Scope | Accessible Where? |
|--------|-------------------|
| Global | Everywhere |
| Function | Inside Function Only |
| Block | Inside Block Only |

---

## Quick Revision

```
var

↓

Function Scope

--------------------

let

↓

Block Scope

--------------------

const

↓

Block Scope
```

---

## Next Part

In **Part 3**, we'll cover:

- Hoisting
- Memory Creation
- Temporal Dead Zone (TDZ)
- Re-declaration
- Re-assignment
- Memory Diagrams
- Dry Runs
- Interview Questions
- Common Mistakes

# 18. Hoisting

One of the most misunderstood concepts in JavaScript is **Hoisting**.

Many beginners think JavaScript executes code from top to bottom without any preparation.

That is **not true**.

Before executing your code,

JavaScript first scans the entire scope and allocates memory for variables and functions.

This process is called **Hoisting**.

---

## What is Hoisting?

**Hoisting** is JavaScript's behavior of **moving declarations to memory before execution begins.**

> **Important:** JavaScript does **not physically move your code**. It only allocates memory during the **Creation Phase** of the Execution Context.

---

## Real-Life Analogy

Imagine you are writing an exam.

Before you start writing,

the examiner gives you:

- Question paper
- Answer sheet
- Roll Number

Only then do you begin.

Similarly,

JavaScript first prepares memory,

then starts executing your code.

```
Program Starts

↓

Create Execution Context

↓

Allocate Memory

↓

Execute Code
```

---

# Creation Phase vs Execution Phase

Every Execution Context has two phases.

```
Execution Context

│

├── Creation Phase

└── Execution Phase
```

---

## Creation Phase

During this phase,

JavaScript

- Creates variables
- Stores function declarations
- Creates the Scope Chain
- Determines the value of `this`

No code is executed yet.

---

## Execution Phase

Now JavaScript starts executing code line by line.

Assignments happen here.

Function calls happen here.

Expressions are evaluated here.

---

# Hoisting with var

Example

```js
console.log(a);

var a = 10;
```

Output

```
undefined
```

---

## Why?

During Creation Phase

```
Memory

↓

a

↓

undefined
```

Execution Phase

```
console.log(a)

↓

undefined

↓

a = 10
```

---

## Dry Run

Creation Phase

```
a

↓

undefined
```

Execution Phase

```
console.log(a)

↓

undefined

↓

a = 10
```

Final Memory

```
a

↓

10
```

---

## Visualization

```
Creation Phase

Memory

┌────────────┐
│ a          │
│ undefined  │
└────────────┘

↓

Execution

console.log(a)

↓

undefined

↓

a = 10
```

---

# Hoisting with let

Example

```js
console.log(age);

let age = 22;
```

Output

```
ReferenceError
```

Many beginners think

```
undefined
```

should be printed.

It doesn't.

---

## Why?

`let` is hoisted,

but it is **not initialized**.

Instead,

it enters the

```
Temporal Dead Zone
```

until execution reaches

```js
let age = 22;
```

---

## Memory

Creation Phase

```
age

↓

Memory Reserved

↓

TDZ
```

Execution

```
console.log(age)

↓

ReferenceError
```

---

## Visualization

```
Creation Phase

Memory

┌────────────┐
│ age        │
│ TDZ        │
└────────────┘

↓

Execution

↓

ReferenceError

↓

let age = 22

↓

Initialized

↓

22
```

---

# Hoisting with const

Example

```js
console.log(PI);

const PI = 3.14;
```

Output

```
ReferenceError
```

Reason

Exactly the same as `let`.

It remains inside the

```
Temporal Dead Zone
```

until initialization.

---

# Are let and const Hoisted?

This is one of the most common interview questions.

Answer

✅ Yes

Both are hoisted.

However,

they remain inside the **Temporal Dead Zone** until initialization.

---

# Memory Comparison

## var

Creation Phase

```
Memory

↓

a

↓

undefined
```

Execution

```
a = 10
```

---

## let

Creation Phase

```
Memory Reserved

↓

TDZ
```

Execution

```
let a = 10

↓

Accessible
```

---

## const

Creation Phase

```
Memory Reserved

↓

TDZ
```

Execution

```
const PI = 3.14

↓

Accessible
```

---

# 19. Temporal Dead Zone (TDZ)

The **Temporal Dead Zone (TDZ)** is the time between

- entering a scope

and

- initializing a `let` or `const` variable.

During this time,

the variable exists,

but JavaScript does not allow access to it.

---

## Flow

```
Enter Scope

↓

Memory Reserved

↓

TDZ

↓

Initialization

↓

Accessible
```

---

## Example

```js
console.log(name);

let name = "Om";
```

Output

```
ReferenceError
```

---

## Dry Run

Creation Phase

```
name

↓

TDZ
```

Execution

```
console.log(name)

↓

ReferenceError

↓

let name = "Om"
```

---

## Another Example

```js
{

    console.log(age);

    let age = 22;

}
```

Output

```
ReferenceError
```

Because

```
Enter Block

↓

TDZ

↓

Initialization

↓

Accessible
```

---

# Why Does TDZ Exist?

The TDZ prevents accidental use of variables before they are initialized.

Without the TDZ,

developers might unknowingly use variables before assigning meaningful values.

This makes programs safer and easier to debug.

---

# 20. Re-declaration

## var

```js
var city = "Pune";

var city = "Mumbai";

console.log(city);
```

Output

```
Mumbai
```

---

Why?

`var` allows multiple declarations in the same scope.

---

## let

```js
let city = "Pune";

let city = "Mumbai";
```

Output

```
SyntaxError
```

---

## const

```js
const PI = 3.14;

const PI = 3.14159;
```

Output

```
SyntaxError
```

---

# Comparison

| Keyword | Re-declare |
|----------|------------|
| var | ✅ Yes |
| let | ❌ No |
| const | ❌ No |

---

# 21. Re-assignment

Re-assignment means changing the value of an existing variable.

---

## var

```js
var score = 10;

score = 20;

console.log(score);
```

Output

```
20
```

---

## let

```js
let score = 10;

score = 30;

console.log(score);
```

Output

```
30
```

---

## const

```js
const PI = 3.14;

PI = 3.14159;
```

Output

```
TypeError
```

---

# Comparison

| Keyword | Re-assign |
|----------|-----------|
| var | ✅ Yes |
| let | ✅ Yes |
| const | ❌ No |

---

# Interview Tip

Many students confuse

```
SyntaxError

ReferenceError

TypeError
```

Remember

- **ReferenceError** → Variable cannot be accessed (TDZ or not defined)
- **SyntaxError** → Invalid declaration (like redeclaring `let`/`const`)
- **TypeError** → Illegal operation (like reassigning a `const`)

---

# Next Part

Part 4 covers:

- Objects & Arrays with `const`
- Memory Behavior
- Best Practices
- React Examples
- Node.js Examples
- Common Mistakes
- Interview Questions
- Coding Exercises
- Quick Revision Sheet
- Chapter Summary

---


# let vs const vs var

# Part 4 – Real-World Usage & Interview Mastery

Congratulations! 🎉

By now, you've mastered:

- What `var`, `let`, and `const` are
- Why `let` and `const` were introduced
- Scope
- Global Scope
- Function Scope
- Block Scope
- Hoisting
- Temporal Dead Zone (TDZ)
- Re-declaration
- Re-assignment

Now it's time to learn how these concepts are used in **real-world applications** and prepare for **technical interviews**.

This part focuses on practical usage, React, Node.js, best practices, common mistakes, coding exercises, and revision.

---

# Table of Contents (Part 4)

22. Objects and Arrays with `const`
23. Memory Behavior
24. Best Practices
25. React Examples
26. Node.js Examples
27. Common Mistakes
28. Frequently Asked Interview Questions
29. Coding Exercises
30. Quick Revision Sheet
31. Chapter Summary

---

# Learning Objectives

After completing Part 4, you'll be able to:

- Explain why `const` objects can still be modified.
- Understand how JavaScript stores primitive values and reference values.
- Choose between `let` and `const` correctly.
- Follow modern JavaScript best practices.
- Write cleaner React and Node.js code.
- Avoid common interview mistakes.
- Solve interview coding questions confidently.

---

# let vs const vs var

# Part 4.1 – Objects & Arrays with `const`

> **"The biggest misconception in JavaScript is thinking that `const` makes objects and arrays immutable. In reality, `const` only prevents re-assignment of the variable, not modification of the data it references."**

---

# Table of Contents

1. Introduction
2. Primitive vs Reference Values
3. What Does `const` Actually Mean?
4. Objects with `const`
5. Arrays with `const`
6. Re-assignment vs Mutation
7. Why Objects Can Change
8. Why Arrays Can Change
9. Memory Visualization
10. Real-world Examples
11. React Examples
12. Node.js Examples
13. Best Practices
14. Common Mistakes
15. Interview Questions
16. Coding Exercises
17. Summary

---

# 1. Introduction

Many beginners think:

> **"`const` means the value can never change."**

This is **not always true**.

It depends on **what kind of value** the variable stores.

There are two kinds of values in JavaScript:

- Primitive Values
- Reference Values

Understanding this difference explains almost every interview question about `const`.

---

# 2. Primitive vs Reference Values

JavaScript stores data in two different ways.

## Primitive Values

Examples:

```js
10

true

false

"Om"

null

undefined

Symbol()

BigInt()
```

Primitive values are stored **directly**.

Example

```js
const age = 22;
```

Memory

```
age

↓

22
```

The variable directly stores the value.

---

## Reference Values

Examples

```js
Objects

Arrays

Functions

Dates

Maps

Sets
```

These are **not stored directly**.

Instead, JavaScript stores a **reference (memory address)**.

Example

```js
const user = {
    name: "Om"
};
```

Memory

```
user

↓

Address 0x100

↓

{
    name: "Om"
}
```

The variable stores the address, not the object itself.

---

# 3. What Does `const` Actually Mean?

Many developers misunderstand `const`.

`const` does **NOT** mean:

> "The value can never change."

It actually means:

> **"The variable must always point to the same memory location."**

Think of it like this:

```
const user

↓

Address 0x100

↓

Object
```

The address cannot change.

The object at that address **can**.

---

# 4. Objects with `const`

Example

```js
const user = {
    name: "Om",
    age: 22
};

user.age = 23;

console.log(user);
```

Output

```js
{
    name: "Om",
    age: 23
}
```

Why?

Because we changed a **property** of the object.

We did **not** change the variable.

Memory

```
Before

user

↓

0x100

↓

{
 age:22
}

------------------

After

user

↓

0x100

↓

{
 age:23
}
```

Same address.

Different property.

---

# 5. Arrays with `const`

Example

```js
const numbers = [1,2,3];

numbers.push(4);

console.log(numbers);
```

Output

```js
[1,2,3,4]
```

Why?

`push()` changes the existing array.

It does **not** create a new one.

Memory

```
numbers

↓

0x200

↓

[1,2,3]

↓

push()

↓

[1,2,3,4]
```

The reference never changed.

---

# 6. Re-assignment vs Mutation

This is the most important interview topic.

## Re-assignment

Changing the variable to point somewhere else.

Example

```js
const user = {
    name: "Om"
};

user = {};
```

Output

```
TypeError:
Assignment to constant variable.
```

Why?

Because `const` variables cannot point to a new object.

Memory

```
Before

user

↓

0x100

↓

{
 name:"Om"
}

Attempt

↓

user

↓

0x200

❌ Not Allowed
```

---

## Mutation

Changing the contents of the existing object.

Example

```js
const user = {
    name: "Om"
};

user.name = "Raj";

console.log(user);
```

Output

```js
{
    name: "Raj"
}
```

Allowed.

Because:

```
Reference

↓

Same

↓

Contents Changed
```

---

# 7. Why Objects Can Change

Imagine a house.

```
Address

↓

House
```

The address never changes.

But you can:

- Paint the walls
- Change furniture
- Buy a TV
- Replace doors

The house is still at the same address.

Objects work exactly like this.

---

# 8. Why Arrays Can Change

Arrays are also objects.

Example

```js
const fruits = ["Apple"];

fruits.push("Banana");
```

Memory

```
fruits

↓

0x300

↓

Apple

↓

Banana Added
```

Same address.

Only contents changed.

---

# 9. Memory Visualization

Primitive

```js
const age = 22;
```

Memory

```
age

↓

22
```

---

Object

```js
const user = {
    name:"Om"
};
```

Memory

```
user

↓

0x100

↓

Object
```

---

After Mutation

```
user

↓

0x100

↓

Updated Object
```

Notice:

Only the object changed.

The address stayed the same.

---

# 10. Real-world Examples

## User Profile

```js
const user = {
    name: "Om",
    age: 22
};

user.age = 23;
```

Useful when updating profile information.

---

## Shopping Cart

```js
const cart = [];

cart.push("Laptop");
cart.push("Mouse");
```

Instead of creating a new array every time, the existing cart is updated.

---

## Game Score

```js
const player = {
    score: 0
};

player.score += 100;
```

---

# 11. React Examples

React encourages immutable updates, but understanding `const` is still important.

```jsx
const user = {
    name: "Om"
};

// Avoid directly mutating state in React
// Prefer creating a new object:
setUser({
    ...user,
    name: "Raj"
});
```

Here, `const` keeps the variable reference fixed, while the spread operator creates a **new object** for React state updates.

---

# 12. Node.js Examples

Configuration object

```js
const config = {
    port: 5000
};

config.port = 8000;

console.log(config);
```

Output

```js
{
    port: 8000
}
```

The configuration object is updated without reassigning the variable.

---

# 13. Best Practices

✅ Use `const` by default.

✅ Modify object properties only when appropriate.

✅ Prefer creating new objects in React instead of mutating existing ones.

✅ Use meaningful variable names.

❌ Don't think `const` makes objects immutable.

---

# 14. Common Mistakes

### Mistake 1

```js
const user = {};

user = {};
```

❌ Error

---

### Mistake 2

```js
const numbers = [1,2];

numbers = [];
```

❌ Error

---

### Mistake 3

```js
const user = {
    age:22
};

user.age = 23;
```

Many beginners think this causes an error.

It doesn't.

---

# 15. Interview Questions

### Does `const` make objects immutable?

No.

---

### Why can object properties change?

Because only the reference is constant.

---

### Why does this fail?

```js
const user = {};

user = {};
```

Because it changes the reference.

---

### Why does this work?

```js
const user = {};

user.name = "Om";
```

Because it changes the object's contents, not the reference.

---

### Are arrays also reference types?

Yes.

---

# 16. Coding Exercises

### Exercise 1

Predict the output.

```js
const user = {
    age:22
};

user.age = 30;

console.log(user.age);
```

---

### Exercise 2

Predict the output.

```js
const numbers = [1,2];

numbers.push(3);

console.log(numbers);
```

---

### Exercise 3

Why does this fail?

```js
const user = {
    name:"Om"
};

user = {
    name:"Raj"
};
```

---

### Exercise 4

Create a shopping cart using a `const` array and add three products.

---

### Exercise 5

Explain the difference between **mutation** and **re-assignment** in your own words.

---

# 17. Summary

- `const` prevents **re-assignment**, not **mutation**.
- Primitive values are stored directly.
- Objects and arrays are stored by reference.
- Changing object properties is allowed.
- Changing array contents is allowed.
- Reassigning a `const` variable causes a `TypeError`.
- React often creates new objects instead of mutating existing ones.
- Understanding **reference vs value** is essential for mastering JavaScript memory behavior.

---

# Next Part

➡️ **Part 4.2 – Memory Behavior**

You'll learn:

- Stack Memory
- Heap Memory
- Primitive vs Reference Storage
- Copy by Value
- Copy by Reference
- Memory Diagrams
- Garbage Collection (Basics)
- Interview Questions
- Coding Exercises

# let vs const vs var

# Part 4.2 – Memory Behavior

> **"Understanding memory is the key to mastering `var`, `let`, `const`, objects, arrays, and JavaScript debugging. Most interview questions about variables ultimately come down to how values are stored in memory."**

---

# Table of Contents

1. Introduction
2. What is Memory?
3. Stack Memory
4. Heap Memory
5. Primitive Values in Memory
6. Reference Values in Memory
7. Copy by Value
8. Copy by Reference
9. Memory Behavior of `var`
10. Memory Behavior of `let`
11. Memory Behavior of `const`
12. Stack vs Heap Comparison
13. Memory Visualization
14. Garbage Collection (Basics)
15. Real-world Examples
16. React Examples
17. Node.js Examples
18. Best Practices
19. Common Mistakes
20. Interview Questions
21. Coding Exercises
22. Summary

---

# 1. Introduction

When we declare a variable, JavaScript stores it somewhere inside the computer's memory.

Example

```js
let age = 22;
```

Where is `22` stored?

How does JavaScript remember it?

Why can objects change when using `const`?

All of these questions are answered by understanding memory.

---

# 2. What is Memory?

Memory is a place where JavaScript stores data while your program is running.

Think of memory like a giant warehouse.

```
JavaScript Program

↓

Memory

↓

Stores

Variables

Objects

Arrays

Functions
```

Whenever you create a variable, JavaScript stores it in memory.

---

# 3. Stack Memory

The **Stack** stores:

- Primitive values
- Function calls
- Local variables
- Execution Contexts

Example

```js
let age = 22;
```

Memory

```
Stack

↓

age

↓

22
```

Stack memory is:

- Fast
- Small
- Automatically managed

---

# 4. Heap Memory

The **Heap** stores:

- Objects
- Arrays
- Functions
- Dates
- Maps
- Sets

Example

```js
const user = {
    name: "Om"
};
```

Memory

```
Stack

↓

user

↓

Address 0x100

----------------------

Heap

↓

0x100

↓

{
    name:"Om"
}
```

Objects are stored in Heap Memory.

---

# 5. Primitive Values in Memory

Primitive values are stored directly.

Example

```js
let age = 22;

let score = 100;

let isAdmin = true;
```

Memory

```
Stack

↓

age

↓

22

----------------

score

↓

100

----------------

isAdmin

↓

true
```

Each variable stores its own value.

---

# 6. Reference Values in Memory

Reference values are different.

Example

```js
const user = {
    name: "Om"
};
```

Memory

```
Stack

↓

user

↓

0x100

------------------

Heap

↓

0x100

↓

{
 name:"Om"
}
```

The variable stores only the memory address.

---

# 7. Copy by Value

Primitive values are copied by value.

Example

```js
let a = 10;

let b = a;

b = 20;

console.log(a);
console.log(b);
```

Output

```
10

20
```

Memory

```
Stack

a

↓

10

------------

b

↓

20
```

Changing `b` does not affect `a`.

---

# 8. Copy by Reference

Objects are copied by reference.

Example

```js
const user1 = {
    name: "Om"
};

const user2 = user1;

user2.name = "Raj";

console.log(user1.name);
```

Output

```
Raj
```

Memory

```
Stack

user1

↓

0x100

user2

↓

0x100

----------------------

Heap

↓

0x100

↓

{
 name:"Raj"
}
```

Both variables point to the same object.

---

# 9. Memory Behavior of `var`

Example

```js
console.log(age);

var age = 20;
```

Memory Creation Phase

```
Stack

↓

age

↓

undefined
```

Execution

```
undefined

↓

20
```

`var` is hoisted and initialized with `undefined`.

---

# 10. Memory Behavior of `let`

Example

```js
console.log(age);

let age = 20;
```

Memory Creation

```
Stack

↓

age

↓

TDZ
```

Execution

```
ReferenceError
```

After initialization

```
Stack

↓

age

↓

20
```

---

# 11. Memory Behavior of `const`

Example

```js
const PI = 3.14;
```

Memory

```
Stack

↓

PI

↓

3.14
```

Example

```js
const user = {
    name:"Om"
};
```

Memory

```
Stack

↓

user

↓

0x200

-------------------

Heap

↓

0x200

↓

{
 name:"Om"
}
```

The reference cannot change.

The object can.

---

# 12. Stack vs Heap Comparison

| Stack | Heap |
|--------|------|
| Stores primitive values | Stores objects and arrays |
| Faster | Slightly slower |
| Fixed size | Dynamic size |
| Automatically managed | Automatically managed |
| Stores values directly | Stores objects by reference |

---

# 13. Memory Visualization

Primitive

```js
let x = 10;
```

```
Stack

↓

x

↓

10
```

---

Reference

```js
const user = {
    name:"Om"
};
```

```
Stack

↓

user

↓

0x100

↓

Heap

↓

Object
```

---

Reference Copy

```js
const a = {
    city:"Pune"
};

const b = a;
```

Memory

```
Stack

a

↓

0x100

b

↓

0x100

-------------------

Heap

↓

{
 city:"Pune"
}
```

---

# 14. Garbage Collection (Basics)

JavaScript automatically removes memory that is no longer used.

Example

```js
let user = {
    name: "Om"
};

user = null;
```

If no other variable references the object, JavaScript can remove it from memory.

This process is called **Garbage Collection**.

---

# 15. Real-world Examples

## User Profile

```js
const user = {
    name: "Om",
    age: 22
};

user.age = 23;
```

Only the object changes.

The reference remains the same.

---

## Shopping Cart

```js
const cart = [];

cart.push("Laptop");
cart.push("Mouse");
```

The array grows without changing its reference.

---

## Bank Balance

```js
let balance = 1000;

let current = balance;

current += 500;
```

`balance` is not affected because primitives are copied by value.

---

# 16. React Examples

React encourages immutable updates.

```jsx
setUser({
    ...user,
    age: 23
});
```

A new object is created, allowing React to detect changes and re-render components.

---

# 17. Node.js Examples

Configuration

```js
const config = {
    port: 5000
};

config.port = 8000;
```

The object is updated without changing its reference.

---

# 18. Best Practices

✅ Understand the difference between value types and reference types.

✅ Use `const` for objects unless the reference needs to change.

✅ Avoid unnecessary object mutation in React.

✅ Remember that copying an object variable copies its reference, not the object itself.

---

# 19. Common Mistakes

### Mistake 1

Thinking objects are copied by value.

Wrong.

Objects are copied by reference.

---

### Mistake 2

Thinking `const` objects cannot change.

Wrong.

Only the reference is constant.

---

### Mistake 3

Thinking Spread creates a deep copy.

Wrong.

Spread creates a **shallow copy**.

---

# 20. Interview Questions

### What is Stack Memory?

Memory used for primitive values, function calls, and execution contexts.

---

### What is Heap Memory?

Memory used for objects, arrays, and other reference types.

---

### Why do objects behave differently from numbers?

Because objects are stored by reference.

---

### Why can `const` objects be modified?

Because only the reference is constant.

---

### What is Garbage Collection?

JavaScript's automatic process of freeing unused memory.

---

### What is the difference between Copy by Value and Copy by Reference?

Primitive values create independent copies.

Reference values point to the same object in memory.

---

# 21. Coding Exercises

### Exercise 1

Predict the output.

```js
let a = 10;

let b = a;

b = 20;

console.log(a);
console.log(b);
```

---

### Exercise 2

Predict the output.

```js
const user1 = {
    name: "Om"
};

const user2 = user1;

user2.name = "Raj";

console.log(user1.name);
```

---

### Exercise 3

Draw the memory diagram for:

```js
const arr1 = [1,2];

const arr2 = arr1;
```

---

### Exercise 4

Explain why this works.

```js
const config = {
    port: 5000
};

config.port = 8000;
```

---

### Exercise 5

Explain the difference between:

- Copy by Value
- Copy by Reference

using your own words.

---

# 22. Summary

- JavaScript stores data in memory.
- Primitive values are stored directly in Stack Memory.
- Objects and arrays are stored in Heap Memory.
- Variables store references to objects.
- Primitive values are copied by value.
- Objects and arrays are copied by reference.
- `const` prevents changing the reference, not the object's contents.
- JavaScript automatically removes unused objects using Garbage Collection.

---

# Next Part

➡️ **Part 4.3 – Best Practices, React & Node.js**

You'll learn:

- Modern JavaScript Best Practices
- When to use `const`
- When to use `let`
- Why `var` should be avoided
- React Coding Standards
- Node.js Coding Standards
- ESLint Recommendations
- Production-Level Examples

# let vs const vs var

# Part 4.3 – Best Practices, React & Node.js

> **"Modern JavaScript developers rarely use `var`. Instead, they follow best practices by using `const` by default and `let` only when values need to change. This leads to safer, cleaner, and more maintainable code."**

---

# Table of Contents

1. Introduction
2. Modern JavaScript Best Practices
3. When to Use `const`
4. When to Use `let`
5. Why `var` Should Be Avoided
6. Variable Naming Conventions
7. React Best Practices
8. React Examples
9. Node.js Best Practices
10. Node.js Examples
11. ESLint Recommendations
12. Production-Level Examples
13. Common Mistakes
14. Interview Questions
15. Coding Exercises
16. Summary

---

# 1. Introduction

Writing code that works is important.

Writing code that is:

- Easy to read
- Easy to debug
- Easy to maintain
- Safe from bugs

is even more important.

Modern JavaScript follows a few simple rules that every professional developer should know.

---

# 2. Modern JavaScript Best Practices

The most common rule is:

```
Use const by default.

↓

Use let only when the value changes.

↓

Avoid var.
```

This simple rule prevents many bugs.

---

# 3. When to Use `const`

Use `const` when the variable should not point to another value.

Examples

### Configuration

```js
const PORT = 5000;
```

---

### API URL

```js
const API_URL = "https://api.example.com";
```

---

### User Object

```js
const user = {
    name: "Om"
};
```

---

### Array

```js
const numbers = [1,2,3];
```

---

### Imported Modules

```js
const express = require("express");
```

---

Why?

Because these variables usually don't need to be reassigned.

---

# 4. When to Use `let`

Use `let` whenever the value is expected to change.

Examples

Counter

```js
let count = 0;

count++;
```

---

Loop

```js
for(let i = 0; i < 5; i++){
    console.log(i);
}
```

---

Game Score

```js
let score = 0;

score += 100;
```

---

Form Input

```js
let username = "";

username = "Om";
```

---

# 5. Why `var` Should Be Avoided

Problems with `var`

- Function scoped
- Ignores block scope
- Can be re-declared
- Can create accidental bugs
- Makes debugging difficult

Example

```js
if(true){
    var age = 22;
}

console.log(age);
```

Output

```
22
```

Many developers expect `age` to exist only inside the `if` block.

Because `var` ignores block scope, it is still accessible outside.

---

# 6. Variable Naming Conventions

Use meaningful names.

Good

```js
const firstName = "Om";

let totalPrice = 1000;

const isLoggedIn = true;
```

Bad

```js
const a = "Om";

let x = 100;

const abc = true;
```

Rules

- Use camelCase
- Use descriptive names
- Constants that never change are often written in UPPER_CASE

Example

```js
const MAX_USERS = 100;
```

---

# 7. React Best Practices

React projects mainly use `const`.

Why?

Because components usually aren't reassigned.

Example

```jsx
const App = () => {
    return <h1>Hello</h1>;
};
```

---

Props

```jsx
const Button = ({ text }) => {
    return <button>{text}</button>;
};
```

---

State

```jsx
const [count, setCount] = useState(0);
```

Notice

```
count

↓

const

setCount()

↓

Updates State
```

The variable is constant, but React updates the state internally.

---

# 8. React Examples

Updating Objects

```jsx
const [user, setUser] = useState({
    name: "Om"
});

setUser({
    ...user,
    name: "Raj"
});
```

---

Updating Arrays

```jsx
const [todos, setTodos] = useState([]);

setTodos([
    ...todos,
    "Learn JavaScript"
]);
```

---

Rendering Lists

```jsx
const fruits = ["Apple", "Banana"];

return (
    <>
        {fruits.map(fruit => (
            <p>{fruit}</p>
        ))}
    </>
);
```

---

# 9. Node.js Best Practices

Use `const` for:

- Express app
- Database connection
- Middleware
- Configuration
- Imported modules

Example

```js
const express = require("express");

const app = express();
```

---

Environment Variables

```js
const PORT = process.env.PORT || 5000;
```

---

Configuration

```js
const config = {
    host: "localhost",
    port: 5000
};
```

---

# 10. Node.js Examples

Express Server

```js
const express = require("express");

const app = express();

app.listen(5000);
```

---

Database

```js
const mongoose = require("mongoose");
```

---

Utility Function

```js
const logger = require("./logger");
```

---

# 11. ESLint Recommendations

Most JavaScript projects use ESLint.

Common rules:

✅ Prefer `const`

✅ Use `let` when necessary

❌ Avoid `var`

These rules help teams write consistent code.

---

# 12. Production-Level Examples

Example 1

```js
const config = {
    port: 5000,
    database: "MongoDB"
};
```

---

Example 2

```js
let retryCount = 0;

retryCount++;
```

---

Example 3

```js
const users = [];

users.push("Om");
```

---

# 13. Common Mistakes

### Mistake 1

Using `var`

```js
var count = 0;
```

Better

```js
let count = 0;
```

---

### Mistake 2

Using `let` when the value never changes

Wrong

```js
let PI = 3.14;
```

Better

```js
const PI = 3.14;
```

---

### Mistake 3

Trying to reassign a `const`

```js
const name = "Om";

name = "Raj";
```

Output

```
TypeError
```

---

### Mistake 4

Thinking `const` objects cannot change

Wrong

```js
const user = {
    name: "Om"
};

user.name = "Raj";
```

This works.

---

# 14. Interview Questions

### Which keyword should be used by default?

`const`

---

### When should `let` be used?

When the value changes.

---

### Why is `var` discouraged?

Because it is function-scoped and allows re-declaration, which can lead to bugs.

---

### Why does React mainly use `const`?

Components, props, and imports are usually not reassigned.

---

### Can `const` objects be modified?

Yes.

Their properties can change.

---

### Does `const` make data immutable?

No.

It only prevents re-assignment of the variable.

---

# 15. Coding Exercises

### Exercise 1

Choose the correct keyword.

```js
_____ PI = 3.14;
```

---

### Exercise 2

Choose the correct keyword.

```js
_____ score = 0;

score++;
```

---

### Exercise 3

Predict the output.

```js
const user = {
    age: 22
};

user.age = 25;

console.log(user.age);
```

---

### Exercise 4

Replace `var` with modern JavaScript.

```js
var count = 0;
```

---

### Exercise 5

Explain why React prefers `const` for components.

---

# 16. Summary

- Use `const` by default.
- Use `let` only when values change.
- Avoid `var` in modern JavaScript.
- Use meaningful variable names.
- React heavily relies on `const`.
- Node.js projects also prefer `const`.
- ESLint encourages `const` whenever possible.
- Following these practices leads to cleaner, safer, and more maintainable code.

---

# Next Part

➡️ **Part 4.4 – Common Mistakes & Interview Mastery**

You'll learn:

- 30+ Interview Questions
- Tricky Hoisting Questions
- TDZ Scenarios
- Predict the Output
- Debugging Exercises
- Real Interview Problems
- JavaScript Traps
- Best Interview Answers

# let vs const vs var

# Part 4.4 – Common Mistakes & Interview Mastery

> **"Most JavaScript interview questions on `var`, `let`, and `const` are based on common mistakes. Understanding why code fails is often more valuable than simply memorizing syntax."**

---

# Table of Contents

1. Introduction
2. Most Common Mistakes
3. Predict the Output Questions
4. Hoisting Traps
5. TDZ Traps
6. Scope Traps
7. `const` Object Traps
8. `var` vs `let` Interview Scenarios
9. Frequently Asked Interview Questions
10. Debugging Exercises
11. Coding Exercises
12. Quick Revision Sheet
13. Summary

---

# 1. Introduction

Almost every JavaScript interview asks questions about:

- Scope
- Hoisting
- TDZ
- `var`
- `let`
- `const`

These questions are designed to check your understanding rather than your ability to memorize definitions.

---

# 2. Most Common Mistakes

## Mistake 1 — Using `var` Inside Blocks

```js
if (true) {
    var age = 22;
}

console.log(age);
```

Output

```
22
```

Why?

`var` ignores block scope.

---

## Mistake 2 — Accessing `let` Before Declaration

```js
console.log(age);

let age = 22;
```

Output

```
ReferenceError:
Cannot access 'age' before initialization
```

Reason

The variable exists but is inside the **Temporal Dead Zone (TDZ).**

---

## Mistake 3 — Reassigning `const`

```js
const PI = 3.14;

PI = 3.14159;
```

Output

```
TypeError:
Assignment to constant variable.
```

---

## Mistake 4 — Thinking `const` Objects Cannot Change

```js
const user = {
    name: "Om"
};

user.name = "Raj";

console.log(user);
```

Output

```js
{
    name: "Raj"
}
```

The reference is constant.

The object is not.

---

## Mistake 5 — Redeclaring Variables

```js
let age = 20;

let age = 30;
```

Output

```
SyntaxError
```

---

# 3. Predict the Output Questions

### Question 1

```js
console.log(a);

var a = 10;
```

Output

```
undefined
```

---

### Question 2

```js
console.log(a);

let a = 10;
```

Output

```
ReferenceError
```

---

### Question 3

```js
const arr = [1];

arr.push(2);

console.log(arr);
```

Output

```
[1,2]
```

---

### Question 4

```js
var x = 10;

if(true){
    var x = 20;
}

console.log(x);
```

Output

```
20
```

---

### Question 5

```js
let x = 10;

if(true){
    let x = 20;

    console.log(x);
}

console.log(x);
```

Output

```
20

10
```

---

# 4. Hoisting Traps

### Trap 1

```js
console.log(city);

var city = "Pune";
```

Output

```
undefined
```

---

### Trap 2

```js
console.log(city);

let city = "Pune";
```

Output

```
ReferenceError
```

---

### Trap 3

```js
console.log(city);

const city = "Pune";
```

Output

```
ReferenceError
```

---

### Rule

```
var

↓

Hoisted

↓

undefined

----------------

let

↓

Hoisted

↓

TDZ

----------------

const

↓

Hoisted

↓

TDZ
```

---

# 5. TDZ Traps

### Example

```js
let age = 20;

{
    console.log(age);

    let age = 30;
}
```

Output

```
ReferenceError
```

Why?

The inner `age` shadows the outer `age` and remains in the TDZ until initialized.

---

Another Example

```js
{
    console.log(name);

    let name = "Om";
}
```

Output

```
ReferenceError
```

---

# 6. Scope Traps

### Example 1

```js
if(true){
    var age = 20;
}

console.log(age);
```

Output

```
20
```

---

### Example 2

```js
if(true){
    let age = 20;
}

console.log(age);
```

Output

```
ReferenceError
```

---

### Example 3

```js
function test(){

    var x = 10;

}

console.log(x);
```

Output

```
ReferenceError
```

---

# 7. `const` Object Traps

### Works

```js
const user = {
    age:22
};

user.age = 23;
```

---

### Doesn't Work

```js
const user = {
    age:22
};

user = {};
```

Output

```
TypeError
```

---

### Arrays

Works

```js
const numbers = [1,2];

numbers.push(3);
```

---

Doesn't Work

```js
const numbers = [1,2];

numbers = [];
```

Output

```
TypeError
```

---

# 8. `var` vs `let` Interview Scenarios

### Scenario 1

```js
for(var i=0;i<3;i++){

}

console.log(i);
```

Output

```
3
```

---

### Scenario 2

```js
for(let i=0;i<3;i++){

}

console.log(i);
```

Output

```
ReferenceError
```

---

### Scenario 3

```js
var name = "Om";

function test(){

    var name = "Raj";

    console.log(name);

}

test();

console.log(name);
```

Output

```
Raj

Om
```

---

# 9. Frequently Asked Interview Questions

### 1. Difference between `var`, `let`, and `const`?

---

### 2. What is Hoisting?

---

### 3. What is TDZ?

---

### 4. Are `let` and `const` hoisted?

Yes.

---

### 5. Why does `var` print `undefined`?

---

### 6. Why should `var` be avoided?

---

### 7. Does `const` make objects immutable?

---

### 8. Difference between Reassignment and Mutation?

---

### 9. Explain Block Scope.

---

### 10. Explain Function Scope.

---

### 11. What happens during Memory Creation Phase?

---

### 12. What happens during Execution Phase?

---

### 13. What errors are produced by:

- Redeclaration
- TDZ
- Reassignment

---

### 14. Explain Copy by Value.

---

### 15. Explain Copy by Reference.

---

# 10. Debugging Exercises

### Exercise 1

Find the bug.

```js
console.log(age);

let age = 20;
```

---

### Exercise 2

Find the bug.

```js
const PI = 3.14;

PI = 5;
```

---

### Exercise 3

Find the bug.

```js
let age = 20;

let age = 25;
```

---

### Exercise 4

Explain why this works.

```js
const user = {
    age:22
};

user.age++;
```

---

# 11. Coding Exercises

### Exercise 1

Predict the output.

```js
var a = 10;

{
    var a = 20;
}

console.log(a);
```

---

### Exercise 2

Predict the output.

```js
let a = 10;

{
    let a = 20;

    console.log(a);
}

console.log(a);
```

---

### Exercise 3

Predict the output.

```js
console.log(name);

var name = "Om";
```

---

### Exercise 4

Predict the output.

```js
console.log(name);

let name = "Om";
```

---

### Exercise 5

Explain why this code throws an error.

```js
const arr = [];

arr = [1,2];
```

---

# 12. Quick Revision Sheet

```
var

↓

Function Scope

↓

Hoisted

↓

undefined

↓

Redeclare ✅

↓

Reassign ✅

------------------------

let

↓

Block Scope

↓

Hoisted

↓

TDZ

↓

Redeclare ❌

↓

Reassign ✅

------------------------

const

↓

Block Scope

↓

Hoisted

↓

TDZ

↓

Redeclare ❌

↓

Reassign ❌

↓

Object Mutation ✅

↓

Reference Change ❌
```

---

# 13. Summary

- `var` is function-scoped and hoisted with `undefined`.
- `let` and `const` are block-scoped and exist in the TDZ until initialized.
- `const` prevents reassignment, not object or array mutation.
- Hoisting happens during the memory creation phase.
- TDZ prevents accidental access before initialization.
- Understanding scope, hoisting, and memory behavior helps you debug JavaScript effectively.
- These topics are among the most frequently tested in JavaScript interviews.

---

# Next Part

➡️ **Part 4.5 – Coding Practice, Cheat Sheet & Final Chapter Revision**

You'll learn:

- 25+ Interview Coding Problems
- Cheat Sheet
- 6-Time Revision Notes
- One-Page Quick Revision
- Chapter Summary
- Final Interview Tips
- JavaScript Variable Declaration Mind Map
# let vs const vs var

# Part 4.5 – Coding Practice, Cheat Sheet & Final Chapter Revision

> **"Knowledge becomes skill only after practice. This final part helps you revise, test yourself, and prepare for interviews with coding exercises, cheat sheets, and quick revision notes."**

---

# Table of Contents

1. Introduction
2. Interview Coding Problems
3. Predict the Output
4. Debugging Questions
5. Scenario-Based Questions
6. One-Page Cheat Sheet
7. 6-Time Revision Notes
8. Mind Map
9. Final Chapter Summary
10. Final Interview Tips

---

# 1. Introduction

Congratulations! 🎉

You have completed the complete chapter on:

- `var`
- `let`
- `const`

This final section is designed to help you revise everything quickly and confidently before interviews.

---

# 2. Interview Coding Problems

## Problem 1

Predict the output.

```js
console.log(a);

var a = 10;
```

---

## Problem 2

Predict the output.

```js
console.log(a);

let a = 10;
```

---

## Problem 3

Predict the output.

```js
console.log(a);

const a = 10;
```

---

## Problem 4

```js
if (true) {
    var age = 22;
}

console.log(age);
```

---

## Problem 5

```js
if (true) {
    let age = 22;
}

console.log(age);
```

---

## Problem 6

```js
const user = {
    name: "Om"
};

user.name = "Raj";

console.log(user);
```

---

## Problem 7

```js
const user = {
    name: "Om"
};

user = {};
```

---

## Problem 8

```js
let x = 10;

{
    let x = 20;

    console.log(x);
}

console.log(x);
```

---

## Problem 9

```js
for (var i = 0; i < 3; i++) {}

console.log(i);
```

---

## Problem 10

```js
for (let i = 0; i < 3; i++) {}

console.log(i);
```

---

# 3. Predict the Output

### Question 1

```js
var a = 5;

function test() {
    console.log(a);
}

test();
```

---

### Question 2

```js
let a = 5;

function test() {
    console.log(a);
}

test();
```

---

### Question 3

```js
const arr = [1];

arr.push(2);

console.log(arr.length);
```

---

### Question 4

```js
var city = "Pune";

{
    var city = "Mumbai";
}

console.log(city);
```

---

### Question 5

```js
let city = "Pune";

{
    let city = "Mumbai";

    console.log(city);
}

console.log(city);
```

---

# 4. Debugging Questions

### Debug 1

Find the error.

```js
console.log(age);

let age = 20;
```

---

### Debug 2

Find the error.

```js
const PI = 3.14;

PI = 5;
```

---

### Debug 3

Find the error.

```js
let age = 20;

let age = 25;
```

---

### Debug 4

Find the error.

```js
const arr = [];

arr = [1,2];
```

---

### Debug 5

Find the mistake.

```js
console.log(country);

var country1 = "India";
```

---

# 5. Scenario-Based Questions

### Scenario 1

You have a variable that never changes.

Which keyword should you use?

---

### Scenario 2

You have a counter that increases every second.

Which keyword should you use?

---

### Scenario 3

You need to store a configuration object.

Which keyword should you use?

---

### Scenario 4

You are writing a React Functional Component.

Which keyword should you use?

---

### Scenario 5

You are creating an Express application.

Which keyword should you use?

---

# 6. One-Page Cheat Sheet

## Variable Keywords

| Feature | `var` | `let` | `const` |
|----------|--------|--------|----------|
| Scope | Function | Block | Block |
| Hoisted | ✅ | ✅ | ✅ |
| Initial Value | `undefined` | TDZ | TDZ |
| Re-declare | ✅ | ❌ | ❌ |
| Re-assign | ✅ | ✅ | ❌ |
| Initialization Required | ❌ | ❌ | ✅ |

---

## Scope

```
Global Scope

↓

Function Scope

↓

Block Scope
```

---

## Hoisting

```
var

↓

undefined

----------------

let

↓

TDZ

----------------

const

↓

TDZ
```

---

## TDZ

```
Memory Created

↓

Variable Exists

↓

Cannot Access

↓

Initialization

↓

Accessible
```

---

## Objects

```
const user

↓

Reference Fixed

↓

Properties Can Change
```

---

## Arrays

```
const numbers

↓

Reference Fixed

↓

push()

pop()

splice()

Allowed
```

---

# 7. 6-Time Revision Notes

## Revision 1 (30 Seconds)

```
var

Function Scope

undefined

Redeclare

Reassign

--------------

let

Block Scope

TDZ

Reassign

--------------

const

Block Scope

TDZ

No Reassign
```

---

## Revision 2 (1 Minute)

Remember:

- Use `const` by default.
- Use `let` when values change.
- Avoid `var`.

---

## Revision 3 (2 Minutes)

Remember:

- `var` ignores block scope.
- `let` respects block scope.
- `const` respects block scope.

---

## Revision 4 (3 Minutes)

Remember:

- Objects are references.
- Arrays are references.
- `const` prevents reassignment.
- `const` does not prevent mutation.

---

## Revision 5 (5 Minutes)

Remember:

- Hoisting
- TDZ
- Scope
- Memory
- Reference vs Value

---

## Revision 6 (10 Minutes)

Review:

- All coding exercises
- Predict-the-output questions
- Common mistakes
- Interview questions

---

# 8. Mind Map

```
Variable Declarations

│

├── var

│   ├── Function Scope

│   ├── Hoisted

│   ├── undefined

│   ├── Redeclare

│   └── Reassign

│

├── let

│   ├── Block Scope

│   ├── TDZ

│   ├── Hoisted

│   └── Reassign

│

└── const

    ├── Block Scope

    ├── TDZ

    ├── No Reassign

    ├── Object Mutation

    └── Array Mutation
```

---

# 9. Final Chapter Summary

You have learned:

✅ Why `let` and `const` were introduced

✅ `var`

✅ `let`

✅ `const`

✅ Scope

✅ Global Scope

✅ Function Scope

✅ Block Scope

✅ Hoisting

✅ Temporal Dead Zone (TDZ)

✅ Re-declaration

✅ Re-assignment

✅ Primitive Values

✅ Reference Values

✅ Stack Memory

✅ Heap Memory

✅ Copy by Value

✅ Copy by Reference

✅ Objects with `const`

✅ Arrays with `const`

✅ Memory Behavior

✅ React Best Practices

✅ Node.js Best Practices

✅ Common Mistakes

✅ Interview Questions

✅ Coding Exercises

---

# 10. Final Interview Tips

✅ Prefer `const` by default.

✅ Use `let` only when the variable changes.

✅ Avoid `var` in modern JavaScript.

✅ Always understand **why** code behaves a certain way instead of memorizing outputs.

✅ Practice "Predict the Output" questions regularly.

✅ Remember the interview mantra:

```
var

↓

Function Scope

↓

undefined

---------------------

let

↓

Block Scope

↓

TDZ

---------------------

const

↓

Block Scope

↓

TDZ

↓

No Reassignment

↓

Object Mutation Allowed
```

---

# 🎯 Congratulations!

You have completed the **"let vs const vs var"** chapter.

You now understand:

- Internal Working
- Hoisting
- Temporal Dead Zone (TDZ)
- Scope
- Memory Behavior
- Best Practices
- React Usage
- Node.js Usage
- Common Mistakes
- Interview Preparation

This foundation will make the next ES6 topics—**Arrow Functions, Template Literals, Destructuring, Rest/Spread, Modules, and Closures**—much easier to learn.

---

# let vs const vs var

# Part 5.1 – Variable Shadowing

> **"Variable Shadowing occurs when a variable declared in an inner scope has the same name as a variable declared in an outer scope. The inner variable temporarily hides (shadows) the outer variable while execution remains inside that scope."**

---

# Table of Contents

1. Introduction
2. What is Variable Shadowing?
3. Why Shadowing Exists
4. Block Shadowing
5. Function Shadowing
6. Nested Shadowing
7. Scope Resolution (How JavaScript Finds Variables)
8. Memory Visualization
9. Real-world Examples
10. React Examples
11. Node.js Examples
12. Best Practices
13. Common Mistakes
14. Interview Questions
15. Coding Exercises
16. Summary

---

# 1. Introduction

While learning scope, many developers see code like this:

```js
let name = "Om";

{
    let name = "Raj";

    console.log(name);
}

console.log(name);
```

Output

```
Raj

Om
```

Many beginners think JavaScript changed the original variable.

It didn't.

This concept is called **Variable Shadowing**.

---

# 2. What is Variable Shadowing?

Variable Shadowing happens when an inner scope declares a variable with the **same name** as a variable in an outer scope.

The inner variable **hides** the outer variable while execution stays inside that scope.

Example

```js
let city = "Pune";

{
    let city = "Mumbai";

    console.log(city);
}

console.log(city);
```

Output

```
Mumbai

Pune
```

---

Visualization

```
Global Scope

city

↓

"Pune"

----------------------

Block Scope

city

↓

"Mumbai"
```

Inside the block,

JavaScript uses

```
"Mumbai"
```

Outside the block,

JavaScript uses

```
"Pune"
```

---

# 3. Why Shadowing Exists

JavaScript allows different scopes to have variables with the same name.

This helps developers avoid long variable names.

Example

```js
let count = 100;

function calculate() {

    let count = 0;

}
```

Both variables are different because they belong to different scopes.

---

# 4. Block Shadowing

Example

```js
let age = 22;

if(true){

    let age = 30;

    console.log(age);

}

console.log(age);
```

Output

```
30

22
```

Execution

```
Global

↓

age = 22

↓

Enter if Block

↓

New age = 30

↓

Leave Block

↓

Back to age = 22
```

The outer variable never changes.

---

# 5. Function Shadowing

Functions create their own scope.

Example

```js
let country = "India";

function showCountry(){

    let country = "USA";

    console.log(country);

}

showCountry();

console.log(country);
```

Output

```
USA

India
```

Memory

```
Global

country

↓

India

----------------------

Function

country

↓

USA
```

---

# 6. Nested Shadowing

JavaScript can have multiple nested scopes.

Example

```js
let value = 1;

{

    let value = 2;

    {

        let value = 3;

        console.log(value);

    }

    console.log(value);

}

console.log(value);
```

Output

```
3

2

1
```

Visualization

```
Global

↓

1

------------

Block

↓

2

------------

Nested Block

↓

3
```

Each scope has its own variable.

---

# 7. Scope Resolution (How JavaScript Finds Variables)

JavaScript always searches for variables from **inside to outside**.

Example

```js
let country = "India";

function outer(){

    let state = "Maharashtra";

    function inner(){

        console.log(state);

    }

    inner();

}

outer();
```

Output

```
Maharashtra
```

Search Process

```
inner()

↓

Find state?

↓

Yes

↓

Use state

↓

Stop Searching
```

---

Another Example

```js
let country = "India";

function outer(){

    function inner(){

        console.log(country);

    }

    inner();

}

outer();
```

Search Process

```
inner

↓

country?

↓

Not Found

↓

Go Outside

↓

Global Scope

↓

Found

↓

India
```

This process is called the **Scope Chain**.

---

# 8. Memory Visualization

Example

```js
let x = 10;

{

    let x = 20;

}
```

Memory

```
Global Memory

↓

x

↓

10

----------------------

Block Memory

↓

x

↓

20
```

Different memory locations.

No conflict.

---

# 9. Real-world Examples

### Shopping Cart

```js
let total = 500;

function checkout(){

    let total = 450;

    console.log(total);

}

checkout();

console.log(total);
```

Output

```
450

500
```

---

### Student Marks

```js
let marks = 90;

{

    let marks = 100;

    console.log(marks);

}
```

Output

```
100

90
```

---

# 10. React Examples

React Components

```jsx
const title = "Dashboard";

function Header(){

    const title = "Profile";

    return <h1>{title}</h1>;

}
```

The inner `title` shadows the outer one.

---

Props Example

```jsx
const user = "Om";

function Card(){

    const user = "Raj";

    return <h1>{user}</h1>;

}
```

Output

```
Raj
```

---

# 11. Node.js Examples

```js
const PORT = 5000;

function server(){

    const PORT = 8000;

    console.log(PORT);

}

server();

console.log(PORT);
```

Output

```
8000

5000
```

---

# 12. Best Practices

✅ Use shadowing only when it improves readability.

✅ Keep scopes small.

✅ Use meaningful variable names.

✅ Avoid unnecessary shadowing in large functions.

---

# 13. Common Mistakes

### Mistake 1

Thinking shadowing changes the outer variable.

Wrong.

Each scope has its own variable.

---

### Mistake 2

Thinking JavaScript updates both variables.

Wrong.

Only the current scope's variable changes.

---

### Mistake 3

Confusing Shadowing with Reassignment.

Shadowing

```js
let age = 20;

{
    let age = 30;
}
```

Reassignment

```js
let age = 20;

age = 30;
```

These are completely different.

---

# 14. Interview Questions

### What is Variable Shadowing?

A variable declared in an inner scope hides a variable with the same name from an outer scope.

---

### Does Shadowing modify the outer variable?

No.

---

### Which variable does JavaScript use?

The nearest variable in the current scope.

---

### Can functions create shadowing?

Yes.

---

### Can blocks create shadowing?

Yes.

---

### What is the Scope Chain?

JavaScript searches from the current scope outward until it finds the variable.

---

# 15. Coding Exercises

### Exercise 1

Predict the output.

```js
let x = 10;

{

    let x = 20;

    console.log(x);

}

console.log(x);
```

---

### Exercise 2

Predict the output.

```js
let city = "Pune";

function test(){

    let city = "Mumbai";

    console.log(city);

}

test();

console.log(city);
```

---

### Exercise 3

Draw the scope diagram for:

```js
let a = 1;

{

    let a = 2;

    {

        let a = 3;

    }

}
```

---

### Exercise 4

Explain why this prints different values.

```js
let score = 100;

function play(){

    let score = 50;

    console.log(score);

}

play();

console.log(score);
```

---

### Exercise 5

Explain the difference between:

- Variable Shadowing
- Variable Reassignment

---

# 16. Summary

- Variable Shadowing occurs when an inner scope declares a variable with the same name as an outer scope variable.
- The inner variable hides the outer variable only within its own scope.
- Shadowing does **not** modify the outer variable.
- JavaScript resolves variables using the Scope Chain (current scope → outer scope → global scope).
- Shadowing is common in React, Node.js, and real-world JavaScript applications.
- Understanding Shadowing is essential before learning **Closures**.

---

# Next Part

➡️ **Part 5.2 – Illegal Shadowing**

You'll learn:

- What Illegal Shadowing is
- Why JavaScript throws a `SyntaxError`
- `var` vs `let` Shadowing Rules
- Interview Traps
- Memory Diagrams
- Real-world Examples
- Coding Exercises

# Next Chapter

➡️ **03-Arrow-Functions.md**

You'll learn:

- Why Arrow Functions were introduced
- Function Expressions vs Arrow Functions
- Syntax
- Implicit vs Explicit Return
- Lexical `this`
- Arrow Functions with Callbacks
- Arrow Functions with Objects
- Arrow Functions in React
- Arrow Functions in Node.js
- Common Mistakes
- Interview Questions
- Coding Exercises
- Cheat Sheet
- Final Revision Notes