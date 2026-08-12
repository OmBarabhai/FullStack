# Functional Programming (FP)

> **"Functional Programming is a programming style that emphasizes pure functions, immutable data, predictable behavior, and composing small functions."**

---

# Table of Contents

1. Part 1 — Fundamentals
2. Part 2 — Core Concepts
3. Part 3 — Practical Usage
4. Part 4 — Interview & Revision
5. Final Summary

---

# Part 1 — Fundamentals

## 1. What is Functional Programming?

Functional Programming (FP) is a programming style where we try to build programs using functions and predictable data transformations.

Main ideas:

* Pure functions
* Immutability
* Fewer unnecessary side effects
* Small reusable functions
* Function composition

Example:

### Imperative

```js
const numbers = [1, 2, 3];

const doubled = [];

for (const number of numbers) {
    doubled.push(number * 2);
}
```

### Functional style

```js
const numbers = [1, 2, 3];

const doubled = numbers.map(number => number * 2);
```

The goal is not to avoid every loop or every side effect.

The goal is to make code easier to reason about.

---

# 2. Imperative vs Declarative

### Imperative

Explain **how** to do something.

```js
let total = 0;

for (let i = 1; i <= 5; i++) {
    total += i;
}
```

### Declarative

Describe **what** you want.

```js
const numbers = [1, 2, 3, 4, 5];

const total = numbers.reduce(
    (sum, number) => sum + number,
    0
);
```

Remember:

```text
Imperative → How
Declarative → What
```

---

# Part 2 — Core Concepts

# 3. Pure Functions

A pure function:

1. Gives the same output for the same input.
2. Does not modify external state.

```js
function add(a, b) {
    return a + b;
}
```

```js
add(10, 20); // 30
add(10, 20); // 30
```

The result is predictable.

---

# 4. Impure Functions

An impure function depends on or changes external state.

```js
let total = 0;

function add(value) {
    total += value;
}
```

The result depends on the previous state of `total`.

---

# 5. Side Effects

A side effect is an operation that affects something outside the function's returned value.

Common examples:

```text
console.log()
DOM updates
API requests
Database operations
File operations
Changing external variables
```

Example:

```js
function greet() {
    console.log("Hello");
}
```

`console.log()` is a side effect.

A function can still be useful even when it has side effects. The important point is to understand where those effects happen.

---

# 6. Immutability

Immutability means avoiding direct modification of existing data.

### Mutation

```js
const numbers = [1, 2, 3];

numbers.push(4);
```

The original array changes.

### Immutable-style update

```js
const numbers = [1, 2, 3];

const updated = [...numbers, 4];
```

Now:

```text
numbers → [1, 2, 3]

updated → [1, 2, 3, 4]
```

Objects:

```js
const user = {
    name: "Om",
    age: 22
};

const updatedUser = {
    ...user,
    age: 23
};
```

This idea becomes very important in React.

---

# 7. Function Composition

Composition means combining smaller functions.

```js
const addTwo = x => x + 2;

const multiplyByThree = x => x * 3;

const result = multiplyByThree(addTwo(5));

console.log(result);
```

Output:

```text
21
```

Flow:

```text
5
 ↓
addTwo()
 ↓
7
 ↓
multiplyByThree()
 ↓
21
```

The main idea:

```text
Small functions
      ↓
Combine
      ↓
Larger behavior
```

---

# 8. First-Class Functions and HOF

JavaScript allows functions to be treated as values.

You already learned this in:

```text
15-Higher-Order-Functions.md
```

So remember only:

```text
Functions can be:
- stored
- passed
- returned
```

Common HOFs:

```text
map()
filter()
reduce()
find()
some()
every()
forEach()
```

Do not relearn their details here.

---

# 9. Currying — Basic Awareness

Currying transforms:

```text
f(a, b)
```

into:

```text
f(a)(b)
```

Example:

```js
const multiply = a => b => a * b;

const double = multiply(2);

console.log(double(10));
```

Output:

```text
20
```

For this folder, understand the idea and syntax only.

---

# 10. Partial Application — Basic Awareness

Partial application means creating a function with some arguments already fixed.

```js
function multiply(a, b) {
    return a * b;
}

const double = number => multiply(2, number);

console.log(double(10));
```

Output:

```text
20
```

You do not need a deep comparison with currying here.

---

# 11. Memoization — Basic Awareness

Memoization means caching previous results.

Simple idea:

```text
Input
 ↓
Already cached?
 ↓ yes → return cached result
 ↓ no
Calculate
 ↓
Store result
 ↓
Return result
```

Example:

```js
const cache = {};

function square(number) {
    if (cache[number] !== undefined) {
        return cache[number];
    }

    const result = number * number;

    cache[number] = result;

    return result;
}
```

For now, understand the concept.

---

# Part 3 — Practical Usage

# 12. JavaScript

Functional patterns are common in JavaScript:

```js
const activeUsers = users
    .filter(user => user.active)
    .map(user => user.name);
```

Flow:

```text
users
 ↓
filter()
 ↓
active users
 ↓
map()
 ↓
names
```

---

# 13. React

React commonly uses immutable updates.

```jsx
const updatedUser = {
    ...user,
    age: 23
};
```

Rendering lists:

```jsx
users.map(user => (
    <UserCard
        key={user.id}
        user={user}
    />
))
```

The important idea is:

```text
Data
 ↓
Transform
 ↓
UI
```

---

# 14. Node.js

Functional-style transformations are common when processing API/database data.

```js
const emails = users
    .filter(user => user.active)
    .map(user => user.email);
```

This is useful for transforming data between application layers.

---

# 15. Common Mistakes

### Mistake 1 — Mutating Existing Data

```js
user.age = 23;
```

Prefer an immutable-style update when appropriate:

```js
const updatedUser = {
    ...user,
    age: 23
};
```

---

### Mistake 2 — Using `map()` Only for Side Effects

Avoid:

```js
numbers.map(number => console.log(number));
```

When you only want to perform an action, `forEach()` is clearer:

```js
numbers.forEach(number => {
    console.log(number);
});
```

---

### Mistake 3 — Thinking Functional Programming Means "Never Use Loops"

It does not.

Functional Programming is a **style**, not a rule that bans loops.

---

# Part 4 — Interview & Revision

# 16. Interview Questions

### What is Functional Programming?

A programming style that emphasizes predictable functions, immutability, and controlled side effects.

---

### What is a pure function?

A function that gives the same output for the same input and does not modify external state.

---

### What is immutability?

Avoiding direct modification of existing data and creating updated values instead.

---

### What is a side effect?

An operation that affects something outside the function's returned value.

---

### Imperative vs Declarative?

```text
Imperative → how
Declarative → what
```

---

### What is function composition?

Combining smaller functions so that the output of one becomes the input of another.

---

### What is currying?

Transforming:

```js
f(a, b)
```

into:

```js
f(a)(b)
```

---

### What is memoization?

Caching previous results so repeated calculations can be faster.

---

# 17. Quick Revision Map

```text
FUNCTIONAL PROGRAMMING
        │
        ├── Pure Functions
        │      ↓
        │   Predictable
        │
        ├── Immutability
        │      ↓
        │   Don't directly mutate
        │
        ├── Side Effects
        │      ↓
        │   Control external changes
        │
        ├── Composition
        │      ↓
        │   Combine functions
        │
        ├── Currying
        │      ↓
        │   f(a)(b)
        │
        └── Memoization
               ↓
           Cache results
```

---

# 18. Hands-on Practice

Write these yourself:

### Exercise 1

Write a pure function:

```js
calculateArea(width, height)
```

---

### Exercise 2

Create a new array without modifying:

```js
const numbers = [1, 2, 3];
```

Add `4` immutably.

---

### Exercise 3

Update:

```js
const user = {
    name: "Om",
    age: 22
};
```

to age `23` without modifying the original object.

---

### Exercise 4

Compose:

```text
add 5
then multiply by 2
```

---

### Exercise 5

Create a simple curried function:

```js
multiply(a)(b)
```

---

### Exercise 6

Explain whether this function is pure:

```js
let count = 0;

function increment() {
    count++;
}
```

---

# 19. What You Need to Know Before Moving On

You should be comfortable with:

```text
[ ] What Functional Programming means
[ ] Pure vs impure functions
[ ] Side effects
[ ] Immutability
[ ] Imperative vs declarative
[ ] Basic function composition
[ ] Basic currying
[ ] Basic memoization
[ ] Why React uses immutable updates
```

You do **not** need to master Functional Programming theory here.

The deeper array-method patterns and functional problem-solving belong in:

```text
02-Functional-JavaScript
```

and deeper function behavior belongs in:

```text
04-Functions-Scope-Closures
```

---

# Summary

Functional Programming is mainly about writing code that is:

```text
Predictable
Reusable
Composable
Less dependent on shared mutable state
```

For this Modern JavaScript folder, remember:

```text
Pure Functions
+
Immutability
+
Controlled Side Effects
+
Composition
=
Functional Programming Foundation
```

**Next → `17-ES6-Patterns.md`**
