# Chapter 3 — Call Stack

> "The Call Stack is the heart of JavaScript execution. Every line of JavaScript code you write eventually passes through the Call Stack."

---

# Table of Contents

1. What is the Call Stack?
2. Why Do We Need a Call Stack?
3. Why is it Called a Stack?
4. Stack Principle (LIFO)
5. Stack Frame
6. Push Operation
7. Pop Operation
8. Single Threaded Nature
9. Function Calls
10. Nested Function Calls
11. Return Statements
12. Recursion
13. Stack Overflow
14. Complete Execution Walkthrough
15. Relationship with Execution Context
16. Relationship with Event Loop
17. Memory vs Stack
18. Common Mistakes
19. Interview Questions
20. Exercises
21. Summary

---

# 1. What is the Call Stack?

The Call Stack is a data structure used by JavaScript to keep track of **which function is currently executing**.

Think of it as a **to-do list**.

Whenever a function starts, JavaScript places it on the stack.

When the function finishes, JavaScript removes it.

---

Example

```js
console.log("Hello");
```

Internally

```
Call Stack

↓

console.log()

↓

Print

↓

Remove
```

---

# 2. Why Do We Need a Call Stack?

Imagine you are reading a book.

You cannot read page 50 before page 10.

You must remember

- where you are
- which chapter
- which paragraph

Similarly,

JavaScript must remember

- which function is executing
- where to return
- which line comes next

The Call Stack stores this information.

---

# 3. Why is it Called a Stack?

Because it follows the **LIFO** rule.

Last In

First Out

Example

Books

```
Book C
Book B
Book A
```

Remove order

```
Book C

↓

Book B

↓

Book A
```

Exactly how the Call Stack works.

---

# 4. Stack Principle (LIFO)

Suppose

```js
main()

↓

one()

↓

two()

↓

three()
```

Stack

```
three()

two()

one()

main()
```

Who returns first?

```
three()

↓

two()

↓

one()

↓

main()
```

Last entered.

First removed.

---

# 5. Stack Frame

Each function on the stack is called a **Stack Frame**.

Example

```js
function greet(){

}

greet();
```

Stack

```
+-------------+

greet()

+-------------+

Global()

+-------------+
```

Every frame contains

- local variables
- parameters
- return address
- execution context

---

# 6. Push Operation

Whenever a function starts

JavaScript performs

```
Push
```

Example

```js
function one(){}

one();
```

Before

```
Global
```

After

```
one()

↓

Global
```

---

# 7. Pop Operation

When function finishes

```
Pop
```

Example

```
one()

↓

removed

↓

Global
```

---

# 8. JavaScript is Single Threaded

There is only **one Call Stack**.

That means

```
Function A

↓

Function B

↓

Function C
```

Cannot execute together.

Only one runs at a time.

---

# 9. Function Calls

Example

```js
function hello(){

}

hello();
```

Step 1

```
Global
```

Step 2

```
hello()

Global
```

Step 3

```
Global
```

Done.

---

# 10. Nested Function Calls

Example

```js
function one(){

    two();

}

function two(){

    three();

}

function three(){

}
```

Execution

```
Global

↓

one()

↓

two()

↓

three()
```

Stack

```
+-------------+

three()

+-------------+

two()

+-------------+

one()

+-------------+

Global()

+-------------+
```

Now return

```
three()

↓

two()

↓

one()

↓

Global()
```

---

# 11. Dry Run

```js
function one(){

    console.log("One");

}

function two(){

    one();

}

two();
```

Initial

```
Global
```

Call two

```
two()

Global
```

Inside two

```
one()

two()

Global
```

After one finishes

```
two()

Global
```

After two finishes

```
Global
```

---

# 12. Return Statement

Example

```js
function add(){

    return 10;

}

add();
```

After return

Stack frame removed.

---

# 13. Recursion

Example

```js
function count(n){

    if(n==0)
        return;

    count(n-1);

}

count(3);
```

Stack

```
count(3)

count(2)

count(1)

count(0)

Global
```

Return

```
count(0)

↓

count(1)

↓

count(2)

↓

count(3)
```

---

# 14. Stack Overflow

Example

```js
function hello(){

    hello();

}

hello();
```

What happens?

```
hello()

↓

hello()

↓

hello()

↓

hello()

↓

hello()

↓

...
```

Eventually

```
Maximum Call Stack Size Exceeded
```

Reason

Stack memory becomes full.

---

# 15. Call Stack and Execution Context

Every Stack Frame contains an Execution Context.

```
Call Stack

↓

Execution Context

↓

Variables

Functions

this

Scope
```

The stack stores execution contexts, not just function names.

---

# 16. Call Stack and Event Loop

The Event Loop only pushes callbacks onto the Call Stack when it is empty.

Example

```js
console.log("A");

setTimeout(() => {

console.log("B");

},0);

console.log("C");
```

Stack

```
console.log(A)

↓

console.log(C)

↓

empty

↓

setTimeout callback

↓

console.log(B)
```

Output

```
A

C

B
```

---

# 17. Memory vs Call Stack

Heap

```
Objects

Arrays

Functions
```

Call Stack

```
Function Calls

Execution Context

Local Variables
```

Do not confuse them.

---

# 18. Common Mistakes

❌ Thinking all functions execute together.

Wrong.

Only one function executes at a time.

---

❌ Thinking Call Stack stores objects.

Wrong.

Heap stores objects.

---

❌ Thinking recursion creates one frame.

Wrong.

Every recursive call creates a new stack frame.

---

# 19. Interview Questions

## What is the Call Stack?

A LIFO data structure that keeps track of function execution.

---

## Why is JavaScript single threaded?

Because JavaScript has one Call Stack.

---

## What is a Stack Frame?

A Stack Frame is the information stored for one function call.

---

## What causes Stack Overflow?

Infinite recursion or too many nested function calls.

---

## Does every function call create a new Execution Context?

Yes.

---

# 20. Exercises

Predict the Call Stack.

Example 1

```js
function one(){

}

one();
```

---

Example 2

```js
function one(){

    two();

}

function two(){

}

one();
```

Draw the stack after every line.

---

Example 3

```js
function fact(n){

    if(n==1)
        return 1;

    return n*fact(n-1);

}

fact(4);
```

Draw all stack frames.

---

# 21. Summary

- The Call Stack keeps track of executing functions.
- It follows the LIFO principle.
- Each function call creates a Stack Frame.
- Every Stack Frame contains an Execution Context.
- JavaScript is single-threaded because it has one Call Stack.
- Recursive functions create multiple stack frames.
- Infinite recursion causes Stack Overflow.
- The Event Loop waits until the Call Stack is empty before scheduling asynchronous callbacks.

---

# Next Chapter

➡️ **04-Web-APIs.md**

You'll learn:

- What Web APIs are
- Why `setTimeout()` isn't part of JavaScript
- DOM APIs
- Fetch API
- Timers
- Storage APIs
- Event listeners
- Browser architecture
- Node.js equivalents