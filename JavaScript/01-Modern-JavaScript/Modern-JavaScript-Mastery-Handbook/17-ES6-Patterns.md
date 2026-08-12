# ES6 Patterns

> **"ES6 Patterns are practical ways of combining modern JavaScript features to write cleaner, more maintainable code."**

---

# Part 1 — Core Patterns

## 1. What Are ES6 Patterns?

An ES6 pattern is a reusable way of writing common JavaScript code using modern features such as:

* Destructuring
* Spread
* Rest
* Default parameters
* Modules
* Functions
* Object methods

You have already learned these features individually. Here, learn how they are **combined**.

---

## 2. Object Destructuring Pattern

```js
const user = {
    name: "Om",
    age: 22
};

const { name, age } = user;
```

Common uses:

```js
const { name: userName } = user;

const { city = "Pune" } = user;
```

---

## 3. Array Destructuring Pattern

```js
const numbers = [10, 20, 30];

const [first, second, third] = numbers;
```

Skip values:

```js
const [first, , third] = numbers;
```

Swap:

```js
let a = 10;
let b = 20;

[a, b] = [b, a];
```

---

## 4. Default + Destructuring

Very common with functions:

```js
function greet({ name = "Guest" }) {
    console.log(name);
}

greet({});
```

Output:

```text
Guest
```

---

# Part 2 — Combining Modern Features

## 5. Spread for Object Updates

Instead of modifying the original object:

```js
const updatedUser = {
    ...user,
    age: 23
};
```

Useful for:

* updates
* merging
* React state

---

## 6. Spread for Arrays

Copy:

```js
const copy = [...numbers];
```

Merge:

```js
const result = [...arr1, ...arr2];
```

Add an element immutably:

```js
const updated = [...numbers, 40];
```

---

## 7. Rest for Flexible Functions

```js
function sum(...numbers) {
    return numbers.reduce(
        (total, number) => total + number,
        0
    );
}

console.log(sum(1, 2, 3, 4));
```

Output:

```text
10
```

Remember:

```text
Spread → expand
Rest   → collect
```

---

## 8. Configuration Object Pattern

Instead of:

```js
createUser("Om", 22, true, "Pune");
```

Prefer:

```js
createUser({
    name: "Om",
    age: 22,
    isAdmin: true,
    city: "Pune"
});
```

This is easier to extend and read.

---

## 9. Method Chaining Pattern

Combine operations:

```js
const result = users
    .filter(user => user.active)
    .map(user => user.name)
    .sort();
```

Flow:

```text
users
  ↓
filter()
  ↓
map()
  ↓
sort()
  ↓
result
```

Detailed array-method chaining is covered in Functional JavaScript.

---

## 10. Factory Function Pattern

A factory function creates objects.

```js
function createUser(name, age) {
    return {
        name,
        age,

        greet() {
            console.log(`Hello ${name}`);
        }
    };
}

const user = createUser("Om", 22);

user.greet();
```

Output:

```text
Hello Om
```

Remember:

```text
Factory Function
      ↓
Creates and returns objects
```

---

## 11. Simple Module Pattern

A function can hide internal data and expose selected operations.

```js
function createCounter() {
    let count = 0;

    return {
        increment() {
            count++;
        },

        getCount() {
            return count;
        }
    };
}

const counter = createCounter();

counter.increment();

console.log(counter.getCount());
```

Output:

```text
1
```

The `count` variable is not directly accessible.

> You already learned ES Modules separately. This is only the basic closure-based pattern.

---

# Part 3 — Practical Patterns

## 12. Immutable Update Pattern

### Object

```js
const updatedUser = {
    ...user,
    age: 23
};
```

### Array

```js
const updatedNumbers = [
    ...numbers,
    10
];
```

### Remove an item

```js
const updatedNumbers = numbers.filter(
    number => number !== 5
);
```

This pattern is especially important in React.

---

## 13. Destructure Function Parameters

Instead of:

```js
function printUser(user) {
    console.log(user.name);
    console.log(user.age);
}
```

Use:

```js
function printUser({ name, age }) {
    console.log(name);
    console.log(age);
}
```

This is common in React props.

---

## 14. Combine Optional Chaining + Nullish Coalescing

```js
const city = user.address?.city ?? "Unknown";
```

This combines two modern JavaScript features:

```text
?. → safe access
?? → default for null/undefined
```

---

## 15. Combine Destructuring + Spread

```js
const {
    name,
    ...details
} = user;

const updatedUser = {
    name,
    ...details,
    active: true
};
```

This pattern is useful when separating or updating object data.

---

## 16. Real-world React Pattern

```jsx
function UserCard({ user }) {
    const { name, age } = user;

    return (
        <div>
            <h2>{name}</h2>
            <p>{age}</p>
        </div>
    );
}
```

State update:

```jsx
setUser({
    ...user,
    age: 23
});
```

List rendering:

```jsx
users
    .filter(user => user.active)
    .map(user => (
        <UserCard
            key={user.id}
            user={user}
        />
    ));
```

---

## 17. Real-world Node.js Pattern

Configuration:

```js
const config = {
    ...defaults,
    ...customConfig
};
```

Request data:

```js
const { username, email } = req.body;
```

These combinations appear frequently in Node.js and Express.

---

# Part 4 — Interview, OA & Revision

## 18. Common Mistakes

### Spread vs Rest

```text
Spread → expands values

Rest → collects values
```

---

### Destructuring vs Object Creation

```js
const { name } = user;
```

Extracts a value.

```js
const newUser = { name };
```

Creates an object.

---

### Mutating Instead of Updating

Prefer:

```js
const updated = {
    ...user,
    age: 23
};
```

when you need to preserve the original object.

---

### Overusing Chaining

This can become difficult to read:

```js
users
    .filter(...)
    .map(...)
    .sort(...)
    .reverse()
    .slice(...)
```

Use readable steps when a chain becomes complicated.

---

## 19. Interview Questions

### What is an ES6 pattern?

A reusable way of combining modern JavaScript features to solve common coding problems.

### Why use a configuration object?

It makes functions easier to read and extend.

### What is a factory function?

A function that creates and returns an object.

### Why is object spread useful?

It makes copying and immutable-style updates concise.

### Spread vs Rest?

```text
Spread → expand
Rest   → collect
```

### Why is destructuring common in React?

It makes props and state data easier to access.

---

## 20. Hands-on Practice

### Exercise 1

Swap two variables using destructuring.

### Exercise 2

Merge two objects using spread.

### Exercise 3

Create an immutable update for:

```js
const user = {
    name: "Om",
    age: 22
};
```

Change `age` to `23`.

### Exercise 4

Create:

```js
createStudent(name, age)
```

using a factory function.

### Exercise 5

Write:

```js
function printUser({ name, age }) {}
```

and call it with an object.

### Exercise 6

Write:

```js
users
    .filter(...)
    .map(...)
```

for active users.

---

# 21. Final Revision Map

```text
ES6 PATTERNS
     │
     ├── Destructuring
     ├── Spread / Rest
     ├── Defaults
     ├── Immutable Updates
     ├── Configuration Objects
     ├── Chaining
     ├── Factory Functions
     └── Module / Closure Pattern
```

The goal is **not to memorize patterns**.

Understand:

```text
Feature
  ↓
Combine features
  ↓
Solve common problem
```

---

# 22. Mastery Checklist

* [ ] I can combine destructuring with function parameters.
* [ ] I can use spread for object updates.
* [ ] I can use spread for arrays.
* [ ] I understand spread vs rest.
* [ ] I understand configuration objects.
* [ ] I understand factory functions.
* [ ] I can write immutable-style updates.
* [ ] I understand basic method chaining.
* [ ] I recognize these patterns in React and Node.js.

---

# Summary

The important ES6 patterns for now are:

```text
Destructuring
Spread / Rest
Default Parameters
Immutable Updates
Configuration Objects
Method Chaining
Factory Functions
Function-parameter Destructuring
```

You have already learned the individual features in earlier chapters. This chapter simply teaches you to **combine them in practical code**.

Deeper Functional Programming, closures, array-method mastery, and prototypes are covered in their dedicated topics.

---

# What's Next?

➡️ **18-Interview-Questions.md**
