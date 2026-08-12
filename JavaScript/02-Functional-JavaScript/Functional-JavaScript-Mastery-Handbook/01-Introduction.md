# Functional Programming — Introduction

> Functional Programming (FP) is a programming style that focuses on transforming data with functions and keeping code predictable, reusable, and easy to reason about.

---

# Part 1 — Fundamentals

## 1. What is Functional Programming?

Functional Programming focuses on:

* transforming data
* using reusable functions
* reducing unnecessary mutation
* writing predictable code

Example:

```js
const numbers = [1, 2, 3];

const doubled = numbers.map(num => num * 2);

console.log(doubled);
```

Output:

```text
[2, 4, 6]
```

Mental model:

```text
Input
  ↓
Function
  ↓
Transformed Output
```

---

## 2. Why Learn Functional Programming?

Functional-style code is common in:

* JavaScript
* React
* Node.js
* APIs
* data processing
* coding interviews

It is especially useful when working with arrays of objects and API data.

---

# Part 2 — Core Concepts

## 3. Pure Functions

A pure function gives the same output for the same input and does not modify external state.

```js
function add(a, b) {
    return a + b;
}
```

```js
add(2, 3); // 5
add(2, 3); // 5
```

---

## 4. Immutability

Instead of directly changing existing data, create updated data.

Avoid:

```js
const numbers = [1, 2, 3];

numbers.push(4);
```

Prefer:

```js
const updated = [...numbers, 4];
```

The original array remains unchanged.

---

## 5. Higher-Order Functions

A Higher-Order Function accepts a function, returns a function, or both.

You learned the fundamentals in Folder 01.

Here, just remember that array methods use callbacks:

```js
const doubled = numbers.map(num => num * 2);
```

Detailed HOF concepts are not repeated here.

---

# Part 3 — Functional Array Workflow

## 6. Core Array Methods

These are the main tools you will learn in this folder:

| Method        | Purpose                       |
| ------------- | ----------------------------- |
| `map()`       | Transform                     |
| `filter()`    | Select                        |
| `find()`      | Find first match              |
| `findIndex()` | Find first matching index     |
| `some()`      | Check if at least one matches |
| `every()`     | Check if all match            |
| `reduce()`    | Build one result              |
| `sort()`      | Sort                          |
| `flat()`      | Flatten                       |
| `flatMap()`   | Transform + flatten           |
| `forEach()`   | Perform an action             |

You will learn each method separately.

---

## 7. Typical Workflow

Functional code often combines methods:

```js
const total = products
    .filter(product => product.price > 100)
    .map(product => product.price)
    .reduce((sum, price) => sum + price, 0);
```

Think:

```text
products
   ↓
filter()
   ↓
selected products
   ↓
map()
   ↓
prices
   ↓
reduce()
   ↓
total
```

Do not try to master chaining yet. It will be covered separately.

---

# Part 4 — Practical Foundation

## 8. Real-world Example

API-style data:

```js
const users = [
    { name: "Om", active: true },
    { name: "Rahul", active: false },
    { name: "Amit", active: true }
];

const activeNames = users
    .filter(user => user.active)
    .map(user => user.name);

console.log(activeNames);
```

Output:

```text
["Om", "Amit"]
```

This type of transformation is very common in React and Node.js.

---

## 9. Common Mistakes

### Using `map()` to select values

Wrong:

```js
numbers.map(num => num > 10);
```

This produces booleans.

Use:

```js
numbers.filter(num => num > 10);
```

---

### Mutating the original array unnecessarily

Avoid:

```js
numbers.push(10);
```

when you need to preserve the original array.

---

### Making chains too complicated

Readable:

```js
const activeUsers = users.filter(user => user.active);

const names = activeUsers.map(user => user.name);
```

This is sometimes easier to maintain than one very long chain.

---

# 10. Interview Essentials

### What is Functional Programming?

A programming style that emphasizes functions, predictable transformations, and reduced mutation.

### What is a pure function?

A function that gives the same output for the same input and does not modify external state.

### What is immutability?

Avoiding direct modification of existing data.

### Why are array methods important?

They provide clear ways to transform, search, select, and process array data.

---

# 11. Hands-on Practice

### Exercise 1

Convert a loop that doubles numbers into `map()`.

### Exercise 2

Filter numbers greater than `10`.

### Exercise 3

Find the first student with marks above `90`.

### Exercise 4

Calculate an array total using `reduce()`.

### Exercise 5

Given an array of users, return the names of active users.

---

# Final Goal

After this introduction, you should understand:

```text
Functional Programming
        ↓
Transform data with functions
        ↓
Use array methods
        ↓
Avoid unnecessary mutation
        ↓
Build reusable transformations
```

You do not need to master Functional Programming theory in this file.

The next files provide the actual mastery:

```text
02-map.md
03-filter.md
04-find.md
05-findIndex.md
06-some.md
07-every.md
08-reduce.md
...
```

# What's Next?

➡️ **02-map.md**
