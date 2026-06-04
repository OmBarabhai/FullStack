# JavaScript Execution Context

![Execution Context](./Images/ExecContext.png)

---

# What is Execution Context?

Execution Context is the environment where JavaScript code is executed.

Whenever JavaScript runs code, it creates an execution context.

Think of it like:

```text
A container where JavaScript code executes
````

JavaScript is:

* Single-threaded
* Executes one task at a time
* Uses a Call Stack to manage execution

---

# Types of Execution Context

| Type                             | Meaning                               |
| -------------------------------- | ------------------------------------- |
| Global Execution Context (GEC)   | Created when JS file starts           |
| Function Execution Context (FEC) | Created whenever a function is called |
| Eval Execution Context           | Created by eval() (rarely used)       |

---

# 1. Global Execution Context (GEC)

When JavaScript starts running a file, it creates:

```js
let partyHost = "Vishwa";

function welcomeGuests() {
    console.log(`Welcome ${partyHost}`);
}

welcomeGuests();
```

JavaScript first creates:

```text
Global Execution Context
```

---

# Global Execution Context Phases

The GEC has 2 phases:

1. Memory Creation Phase
2. Code Execution Phase

---

# 2. Memory Creation Phase

Before executing code, JavaScript scans the entire program.

Memory is allocated for:

* Variables
* Functions

---

## Example

```js
var a = 10;

function test() {
    console.log("Hello");
}
```

### Memory Allocation

| Identifier | Initial Value                |
| ---------- | ---------------------------- |
| a          | undefined                    |
| test       | complete function definition |

---

# Important Point

## var

```js
var a = 10;
```

Initially stored as:

```text
undefined
```

---

## let and const

Stored in:

```text
Temporal Dead Zone (TDZ)
```

They cannot be accessed before initialization.

---

# 3. Code Execution Phase

JavaScript now executes code line by line.

Example:

```js
var a = 10;
```

Now:

```text
a = 10
```

---

# 4. Function Execution Context (FEC)

Whenever a function is invoked:

```js
welcomeGuests();
```

JavaScript creates a new Function Execution Context.

---

# Example

```js
let username = "Vishwa";

function greet() {
    let msg = "Hello";
    console.log(msg);
}

greet();
```

---

# Execution Flow

## Step 1 → GEC Created

```text
| GEC |
```

---

## Step 2 → Function Called

```js
greet();
```

A new Function Execution Context is created.

---

## Step 3 → Pushed into Call Stack

```text
| greet |
| GEC   |
```

---

## Step 4 → Function Executes

```js
console.log(msg);
```

Output:

```text
Hello
```

---

## Step 5 → Function Removed

```text
| GEC |
```

---

# 5. Call Stack

JavaScript uses a Call Stack to manage execution contexts.

The Call Stack follows:

```text
LIFO → Last In First Out
```

---

# Example

```js
function one() {
    two();
}

function two() {
    three();
}

function three() {
    console.log("JavaScript");
}

one();
```

---

# Call Stack Visualization

## Initially

```text
| GEC |
```

---

## one() called

```text
| one |
| GEC |
```

---

## two() called

```text
| two |
| one |
| GEC |
```

---

## three() called

```text
| three |
| two   |
| one   |
| GEC   |
```

---

## three() completed

```text
| two |
| one |
| GEC |
```

---

# 6. Dry Run of Given Example

```js
let partyHost = "Vishwa";

function welcomeGuests() {
    console.log(`Welcome to the party hosted by ${partyHost}`);
}

welcomeGuests();
```

---

# Step-by-Step Execution

## Step 1 → GEC Created

```text
| GEC |
```

---

# Memory Phase

| Variable      | Memory              |
| ------------- | ------------------- |
| partyHost     | uninitialized       |
| welcomeGuests | function definition |

---

# Execution Phase

```js
partyHost = "Vishwa";
```

---

# Function Call

```js
welcomeGuests();
```

---

# Call Stack

```text
| welcomeGuests |
| GEC           |
```

---

# Console Output

```text
Welcome to the party hosted by Vishwa
```

---

# Function Removed

```text
| GEC |
```

---

# 7. Lexical Environment

JavaScript uses lexical scoping.

Inner functions can access variables from parent scope.

---

# Example

```js
function outer() {

    let a = 10;

    function inner() {
        console.log(a);
    }

    inner();
}

outer();
```

Output:

```text
10
```

---

# Scope Chain

JavaScript searches variables in this order:

```text
Current Scope
    ↓
Parent Scope
    ↓
Global Scope
```

---

# 8. Hoisting

Hoisting means:

```text
Variables and functions are moved to memory before execution
```

---

# Variable Hoisting

```js
console.log(a);

var a = 10;
```

Output:

```text
undefined
```

Because JavaScript internally treats it as:

```js
var a;

console.log(a);

a = 10;
```

---

# Function Hoisting

```js
greet();

function greet() {
    console.log("Hello");
}
```

Functions work before declaration because the entire function is stored during memory creation phase.

---

# let and const Hoisting

```js
console.log(a);

let a = 10;
```

Output:

```text
ReferenceError
```

Because of the Temporal Dead Zone.

---

# 9. Temporal Dead Zone (TDZ)

The TDZ is the time between:

```text
Memory Allocation
```

and

```text
Initialization
```

for let and const variables.

---

# Example

```js
{
    console.log(a);
    let a = 5;
}
```

This throws an error.

---

# 10. Internal Structure of Execution Context

Every execution context contains:

| Component            | Purpose                        |
| -------------------- | ------------------------------ |
| Variable Environment | Stores variables and functions |
| Lexical Environment  | Handles scope chain            |
| this Binding         | Stores value of this           |

---

# 11. this Keyword

## In Browser Global Scope

```js
console.log(this);
```

Output:

```text
window
```

---

## In Strict Mode

```js
"use strict";

function test() {
    console.log(this);
}

test();
```

Output:

```text
undefined
```

---

# 12. Strict Mode

```js
"use strict";
```

Strict mode enables safer JavaScript execution.

---

# Benefits

* Prevents accidental global variables
* Helps catch errors
* Makes code secure

---

# Example

Without strict mode:

```js
x = 10;
```

Creates a global variable.

---

With strict mode:

```text
ReferenceError
```

---

# 13. Stack Overflow

Infinite recursion causes:

```text
Maximum call stack size exceeded
```

---

# Example

```js
function test() {
    test();
}

test();
```

---

# 14. Event Loop Relation

JavaScript executes synchronous code using the Call Stack.

Asynchronous tasks are handled by:

* Web APIs
* Callback Queue
* Event Loop

---

# Example

```js
console.log(1);

setTimeout(() => {
    console.log(2);
}, 0);

console.log(3);
```

Output:

```text
1
3
2
```

Because callback waits until the call stack becomes empty.

---

# 15. Interview Questions

---

# Q1. Difference between GEC and FEC?

| GEC                       | FEC                              |
| ------------------------- | -------------------------------- |
| Created once              | Created for every function call  |
| Global scope              | Function/local scope             |
| Exists until program ends | Removed after function execution |

---

# Q2. Why is JavaScript single-threaded?

Because JavaScript has only one Call Stack.

---

# Q3. What is Hoisting?

Memory allocation before execution.

---

# Q4. Difference between var, let, and const?

| var                    | let          | const        |
| ---------------------- | ------------ | ------------ |
| Function scoped        | Block scoped | Block scoped |
| Hoisted with undefined | TDZ          | TDZ          |
| Redeclaration allowed  | Not allowed  | Not allowed  |
| Reassignment allowed   | Allowed      | Not allowed  |

---

# Q5. What is TDZ?

The time period where let/const variables exist in memory but cannot be accessed.

---

# 16. Final Interview Summary

---

# JavaScript Execution Flow

```text
1. Global Execution Context created

2. Memory Creation Phase
   - variables stored
   - functions stored

3. Code Execution Phase
   - code executes line by line

4. Function call occurs
   - new Function Execution Context created

5. Context pushed into Call Stack

6. Function finishes
   - popped from stack
```

---

# Golden Interview Definition

> JavaScript executes code using Execution Contexts managed by the Call Stack. Every execution context goes through a Memory Creation Phase and a Code Execution Phase.

---

# Final Dry Run

```js
var x = 1;

function a() {

    var y = 2;

    b();
}

function b() {

    var z = 3;

    console.log(x);
}

a();
```

---

# Call Stack Flow

## Start

```text
| GEC |
```

---

## a() called

```text
| a   |
| GEC |
```

---

## b() called

```text
| b   |
| a   |
| GEC |
```

---

# Variable Lookup

Inside b():

```js
console.log(x);
```

JavaScript searches:

```text
b scope ❌
a scope ❌
global scope ✅
```

Output:

```text
1
```

---

# Topics Connected to Execution Context

* Hoisting
* Scope
* Closures
* Event Loop
* this keyword
* Call Stack
* Lexical Environment

---

```
```
