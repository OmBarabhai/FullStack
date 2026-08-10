# Functional Programming

# 01 – Introduction

> **"Functional Programming in JavaScript is a programming style where we solve problems by transforming data using small, reusable functions instead of repeatedly writing loops and modifying variables."**

---

# Table of Contents

1. What is Functional Programming?
2. Why Functional Programming?
3. Why Learn Functional Programming?
4. Evolution of JavaScript
5. Traditional Approach vs Functional Approach
6. Core Characteristics
7. Pure Functions
8. Immutability
9. Higher-Order Functions
10. Array Methods Overview
11. Functional Programming Workflow
12. Real-world Examples
13. React & Node.js Usage
14. Best Practices
15. Common Mistakes
16. Interview Questions
17. Coding Exercises
18. Summary

---

# 1. What is Functional Programming?

Functional Programming (FP) is a programming paradigm.

Instead of focusing on:

- changing variables
- writing many loops
- modifying existing data

it focuses on:

- transforming data
- using reusable functions
- writing predictable code

Example

Traditional

```js
const numbers = [1, 2, 3];

const result = [];

for (let i = 0; i < numbers.length; i++) {
    result.push(numbers[i] * 2);
}

console.log(result);
```

Output

```
[2, 4, 6]
```

---

Functional

```js
const numbers = [1, 2, 3];

const result = numbers.map(num => num * 2);

console.log(result);
```

Output

```
[2, 4, 6]
```

Both produce the same result.

The functional approach is shorter, cleaner, and easier to understand.

---

# 2. Why Functional Programming?

Before modern JavaScript, developers mostly used:

- `for`
- `while`
- nested loops
- manual conditions
- temporary variables

Example

```js
const numbers = [10, 20, 30];

let total = 0;

for (let i = 0; i < numbers.length; i++) {
    total += numbers[i];
}

console.log(total);
```

ES5 and ES6 introduced powerful array methods that reduce boilerplate code.

```js
const numbers = [10, 20, 30];

const total = numbers.reduce(
    (sum, num) => sum + num,
    0
);

console.log(total);
```

Output

```
60
```

---

# 3. Why Learn Functional Programming?

Almost every modern JavaScript project uses functional programming.

You will see it in:

- React
- Next.js
- Node.js
- Express
- Redux
- APIs
- Dashboards
- Data Processing
- Coding Interviews

If you don't know array methods well, modern JavaScript becomes difficult to read.

---

# 4. Evolution of JavaScript

### ES3

Mostly loops and functions.

```
for

while

if

switch
```

---

### ES5

Introduced powerful array methods.

```
map()

filter()

reduce()

forEach()

some()

every()

find()
```

---

### ES6+

Added modern syntax.

```
Arrow Functions

Destructuring

Spread

Rest

Template Literals

Modules

Classes
```

Together, ES5 array methods and ES6 syntax made Functional Programming much easier.

---

# 5. Traditional Approach vs Functional Approach

Traditional

```js
const numbers = [1, 2, 3];

const doubled = [];

for (let i = 0; i < numbers.length; i++) {
    doubled.push(numbers[i] * 2);
}
```

---

Functional

```js
const numbers = [1, 2, 3];

const doubled = numbers.map(num => num * 2);
```

Comparison

| Traditional | Functional |
|-------------|------------|
| Uses loops | Uses array methods |
| More code | Less code |
| Manual updates | Automatic transformations |
| Harder to read | Easier to read |

---

# 6. Core Characteristics

Functional Programming encourages:

- Small functions
- Reusable code
- Predictable output
- Less mutation
- Cleaner logic

Example

```js
const square = num => num * num;

console.log(square(5));
```

Output

```
25
```

---

# 7. Pure Functions

A Pure Function:

- always returns the same output for the same input
- does not modify outside data
- has no side effects

Example

```js
function add(a, b) {
    return a + b;
}

console.log(add(2, 3));
```

Output

```
5
```

This is predictable and easy to test.

---

# 8. Immutability

Immutability means:

**Don't change existing data. Create new data instead.**

Wrong

```js
const numbers = [1, 2, 3];

numbers.push(4);
```

Original array changes.

---

Better

```js
const numbers = [1, 2, 3];

const updated = [...numbers, 4];
```

Output

```
[1,2,3,4]
```

The original array remains unchanged.

---

# 9. Higher-Order Functions

A Higher-Order Function either:

- accepts another function as an argument
- returns another function

Example

```js
const numbers = [1, 2, 3];

const result = numbers.map(
    num => num * 2
);

console.log(result);
```

`map()` is a Higher-Order Function because it receives another function.

---

# 10. Array Methods Overview

| Method | Purpose |
|---------|---------|
| `map()` | Transform values |
| `filter()` | Keep matching values |
| `find()` | First matching value |
| `findIndex()` | First matching index |
| `some()` | At least one match |
| `every()` | All must match |
| `reduce()` | Combine into one value |
| `sort()` | Sort values |
| `flat()` | Flatten nested arrays |
| `flatMap()` | Map + Flatten |
| `forEach()` | Execute code for each element |

These methods form the foundation of modern Functional Programming in JavaScript.

---

# 11. Functional Programming Workflow

Example

```
Array

↓

filter()

↓

map()

↓

reduce()

↓

Final Result
```

Real Example

```js
const total = products
    .filter(product => product.price > 100)
    .map(product => product.price)
    .reduce((sum, price) => sum + price, 0);
```

---

# 12. Real-world Examples

Shopping Cart

```js
const expensiveProducts = products.filter(
    product => product.price > 1000
);
```

---

Student Marks

```js
const passed = students.filter(
    student => student.score >= 40
);
```

---

User Names

```js
const names = users.map(
    user => user.name
);
```

---

# 13. React & Node.js Usage

React

```jsx
const names = users.map(user => (
    <li key={user.id}>
        {user.name}
    </li>
));
```

---

Node.js

```js
const activeUsers = users.filter(
    user => user.isActive
);
```

Functional methods make code concise and easier to maintain.

---

# 14. Best Practices

✅ Prefer array methods over manual loops when appropriate.

✅ Write small reusable functions.

✅ Avoid mutating original arrays.

✅ Use method chaining carefully.

---

# 15. Common Mistakes

### Using `map()` when `filter()` is needed

Wrong

```js
numbers.map(num => num > 5);
```

---

Correct

```js
numbers.filter(num => num > 5);
```

---

### Modifying original arrays unnecessarily

Avoid changing existing data unless required.

---

### Overusing chaining

Long chains can become difficult to read.

Break them into smaller steps when needed.

---

# 16. Interview Questions

### What is Functional Programming?

---

### Why is Functional Programming popular in JavaScript?

---

### What is a Pure Function?

---

### What is Immutability?

---

### What is a Higher-Order Function?

---

### Why are array methods preferred over loops?

---

# 17. Coding Exercises

### Exercise 1

Convert this loop into `map()`.

```js
const numbers = [1, 2, 3];

const result = [];

for (let i = 0; i < numbers.length; i++) {
    result.push(numbers[i] * 2);
}
```

---

### Exercise 2

Filter all numbers greater than `10`.

---

### Exercise 3

Find the first student with marks above `90`.

---

### Exercise 4

Calculate the total of an array using `reduce()`.

---

### Exercise 5

Explain why `map()` is considered a Higher-Order Function.

---

# 18. Summary

- Functional Programming focuses on transforming data instead of modifying it.
- It encourages reusable and predictable functions.
- Modern JavaScript heavily relies on array methods.
- `map()`, `filter()`, `find()`, `reduce()`, and related methods are core tools.
- Functional Programming is widely used in React, Node.js, and coding interviews.

---

# What's Next?

➡️ **02-map.md**

You'll learn:

- What `map()` is
- Internal Working
- Callback Function
- Return Values
- Memory Behavior
- Real-world Examples
- React Examples
- Node.js Examples
- Interview Questions
- Coding Exercises
- Common Mistakes
- Best Practices