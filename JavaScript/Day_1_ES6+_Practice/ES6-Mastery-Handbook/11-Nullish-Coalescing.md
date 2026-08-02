# Nullish Coalescing Operator (`??`)

> **"The Nullish Coalescing Operator (`??`) provides a default value only when the left-hand side is `null` or `undefined`. Unlike the OR (`||`) operator, it does not treat valid falsy values like `0`, `false`, or `''` as missing."**

---

# Table of Contents

1. What is Nullish Coalescing?
2. Why Was It Introduced?
3. Syntax
4. How `??` Works
5. Difference Between `||` and `??`
6. Working with Different Data Types
7. Combining Optional Chaining with `??`
8. Real-world Examples
9. React Examples
10. Node.js Examples
11. Best Practices
12. Common Mistakes
13. Interview Questions
14. Coding Exercises
15. Summary

---

# 1. What is Nullish Coalescing?

The Nullish Coalescing Operator (`??`) returns the **right-hand value only when the left-hand value is `null` or `undefined`.**

Syntax

```js
value ?? defaultValue
```

---

Example

```js
const name = null;

console.log(name ?? "Guest");
```

Output

```
Guest
```

---

Another Example

```js
const age = 22;

console.log(age ?? 18);
```

Output

```
22
```

---

# 2. Why Was It Introduced?

Before ES2020 developers mostly used OR (`||`).

Example

```js
const count = 0;

console.log(count || 10);
```

Output

```
10 ❌
```

Problem

`0` is a valid value.

But `||` treats it as false.

---

Using Nullish Coalescing

```js
const count = 0;

console.log(count ?? 10);
```

Output

```
0 ✅
```

Much better.

---

# 3. Syntax

```js
leftValue ?? rightValue
```

Meaning

```
If

leftValue

is

null

or

undefined

↓

Return rightValue

Otherwise

↓

Return leftValue
```

---

# 4. How `??` Works

Example

```js
console.log(null ?? "Hello");
```

Output

```
Hello
```

---

```js
console.log(undefined ?? "Hello");
```

Output

```
Hello
```

---

```js
console.log("Om" ?? "Guest");
```

Output

```
Om
```

---

```js
console.log(100 ?? 0);
```

Output

```
100
```

---

# 5. Difference Between `||` and `??`

## Using OR (`||`)

```js
console.log("" || "Default");
```

Output

```
Default
```

---

```js
console.log(0 || 10);
```

Output

```
10
```

---

```js
console.log(false || true);
```

Output

```
true
```

---

## Using Nullish (`??`)

```js
console.log("" ?? "Default");
```

Output

```
""
```

---

```js
console.log(0 ?? 10);
```

Output

```
0
```

---

```js
console.log(false ?? true);
```

Output

```
false
```

---

Comparison Table

| Value | `value || "Default"` | `value ?? "Default"` |
|---------|----------------------|----------------------|
| `null` | Default | Default |
| `undefined` | Default | Default |
| `0` | Default ❌ | 0 ✅ |
| `false` | Default ❌ | false ✅ |
| `""` | Default ❌ | "" ✅ |
| `"Om"` | Om | Om |

---

# 6. Working with Different Data Types

Number

```js
const score = 0;

console.log(score ?? 100);
```

Output

```
0
```

---

Boolean

```js
const isAdmin = false;

console.log(isAdmin ?? true);
```

Output

```
false
```

---

String

```js
const username = "";

console.log(username ?? "Guest");
```

Output

```
""
```

---

Undefined

```js
let city;

console.log(city ?? "Pune");
```

Output

```
Pune
```

---

Null

```js
const data = null;

console.log(data ?? []);
```

Output

```
[]
```

---

# 7. Combining Optional Chaining with `??`

This is one of the most common interview patterns.

```js
const user = {
  name: "Om",
};

const city = user.address?.city ?? "Unknown";

console.log(city);
```

Output

```
Unknown
```

---

Another Example

```js
const student = {
  address: {
    city: "Pune",
  },
};

const city = student.address?.city ?? "Mumbai";

console.log(city);
```

Output

```
Pune
```

---

Visualization

```
student

↓

address

↓

city

↓

Pune

↓

Not null

↓

Return Pune
```

---

# 8. Real-world Examples

API Response

```js
const response = {};

const username =
response.user?.name ?? "Guest";
```

---

Shopping Cart

```js
const quantity = 0;

console.log(quantity ?? 1);
```

Output

```
0
```

---

Configuration

```js
const PORT =
process.env.PORT ?? 3000;
```

---

# 9. React Examples

Props

```jsx
function User({ name }) {
  return (
    <h1>{name ?? "Guest"}</h1>
  );
}
```

---

API Data

```jsx
<h2>
{user?.profile?.name ?? "Loading..."}
</h2>
```

---

State

```jsx
const age =
user.age ?? 18;
```

---

# 10. Node.js Examples

Environment Variables

```js
const PORT =
process.env.PORT ?? 5000;
```

---

Express

```js
const city =
req.body.city ?? "Unknown";
```

---

MongoDB

```js
const email =
user.email ?? "Not Available";
```

---

# 11. Best Practices

✅ Use `??` instead of `||` when `0`, `false`, or `""` are valid values.

✅ Combine with Optional Chaining.

✅ Use for configuration defaults.

✅ Use for API responses.

---

# 12. Common Mistakes

### Confusing `||` with `??`

Wrong

```js
const score = 0;

console.log(score || 100);
```

Output

```
100 ❌
```

Correct

```js
console.log(score ?? 100);
```

Output

```
0 ✅
```

---

### Mixing `||` and `??`

Wrong

```js
a || b ?? c
```

Produces

```
SyntaxError
```

Correct

```js
(a || b) ?? c
```

or

```js
a || (b ?? c)
```

---

### Thinking `??` Checks All Falsy Values

Wrong.

It only checks

```
null

undefined
```

---

# 13. Interview Questions

## What is Nullish Coalescing?

It returns the right-hand value only if the left-hand value is `null` or `undefined`.

---

## Difference between `||` and `??`?

`||` checks **all falsy values**.

`??` checks only

- `null`
- `undefined`

---

## Why is `??` better for default values?

Because it preserves valid values like

- `0`
- `false`
- `""`

---

## Can Optional Chaining and `??` be used together?

Yes.

Very common.

```js
user.address?.city ?? "Unknown"
```

---

## Is `??` supported in modern JavaScript?

Yes.

It is supported in all modern browsers and modern Node.js versions.

---

# 14. Coding Exercises

### Exercise 1

Predict Output

```js
console.log(0 ?? 10);
```

---

### Exercise 2

Predict Output

```js
console.log(0 || 10);
```

---

### Exercise 3

Return

```
"Guest"
```

if

```js
user.name
```

is `null`.

---

### Exercise 4

Safely print

```js
user.address.city
```

using

- Optional Chaining
- Nullish Coalescing

---

### Exercise 5

Predict Output

```js
console.log("" ?? "Hello");
console.log("" || "Hello");
```

---

# 15. Summary

- `??` returns the right value only for `null` or `undefined`.
- Unlike `||`, it preserves valid falsy values.
- Works perfectly with Optional Chaining.
- Commonly used in React, Express, Node.js, MongoDB, and API handling.
- One of the most frequently asked ES2020 interview topics.

---

# What's Next?

➡️ **12-Modules.md**

You'll learn:

- Why JavaScript Modules were introduced
- Import and Export
- Named Exports
- Default Exports
- Module Scope
- ES Modules vs CommonJS
- Browser vs Node.js Modules
- Dynamic Imports
- Interview Questions
- Coding Exercises