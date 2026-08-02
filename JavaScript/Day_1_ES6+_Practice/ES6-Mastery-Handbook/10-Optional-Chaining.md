# Optional Chaining (`?.`)

> **"Optional Chaining allows you to safely access deeply nested properties without throwing an error if an intermediate property is `null` or `undefined`."**

---

# Table of Contents

1. What is Optional Chaining?
2. Why Was It Introduced?
3. Syntax
4. Accessing Nested Objects
5. Optional Chaining with Arrays
6. Optional Chaining with Functions
7. Combining with Nullish Coalescing
8. Real-world Examples
9. React Examples
10. Node.js Examples
11. Best Practices
12. Common Mistakes
13. Interview Questions
14. Coding Exercises
15. Summary

---

# 1. What is Optional Chaining?

Optional Chaining (`?.`) is an ES2020 feature that allows you to safely access properties or call methods without worrying about `null` or `undefined`.

Without Optional Chaining

```js
const user = {
  name: "Om",
};

console.log(user.address.city);
```

Output

```
TypeError:
Cannot read properties of undefined
```

Because

```
user.address

↓

undefined

↓

.city ❌
```

---

With Optional Chaining

```js
const user = {
  name: "Om",
};

console.log(user.address?.city);
```

Output

```
undefined
```

No error occurs.

---

# 2. Why Was It Introduced?

Before ES2020

```js
if (
  user &&
  user.address &&
  user.address.city
) {
  console.log(user.address.city);
}
```

or

```js
const city =
  user &&
  user.address &&
  user.address.city;
```

Lots of repetitive checks.

Now

```js
const city = user.address?.city;
```

Much cleaner.

---

# 3. Syntax

Property Access

```js
object?.property
```

Method Call

```js
object?.method()
```

Array Access

```js
array?.[index]
```

---

# 4. Accessing Nested Objects

Example

```js
const employee = {
  name: "Om",
  company: {
    location: {
      city: "Pune",
    },
  },
};

console.log(employee.company?.location?.city);
```

Output

```
Pune
```

---

Missing Property

```js
const employee = {
  name: "Om",
};

console.log(employee.company?.location?.city);
```

Output

```
undefined
```

Visualization

```
employee

↓

company

↓

undefined

↓

Stops Here

↓

undefined
```

---

# 5. Optional Chaining with Arrays

Example

```js
const users = [
  {
    name: "Om",
  },
];

console.log(users?.[0]?.name);
```

Output

```
Om
```

---

Missing Element

```js
console.log(users?.[2]?.name);
```

Output

```
undefined
```

---

# 6. Optional Chaining with Functions

Sometimes a function may not exist.

Without Optional Chaining

```js
const user = {};

user.greet();
```

Output

```
TypeError
```

With Optional Chaining

```js
const user = {};

user.greet?.();
```

Output

```
undefined
```

---

Another Example

```js
const user = {
  greet() {
    console.log("Hello");
  },
};

user.greet?.();
```

Output

```
Hello
```

---

# 7. Combining with Nullish Coalescing

Very common in modern JavaScript.

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

Another Example

```js
const employee = {
  company: {
    city: "Pune",
  },
};

const city = employee.company?.city ?? "Mumbai";

console.log(city);
```

Output

```
Pune
```

---

# 8. Real-world Examples

API Response

```js
const response = {
  user: {
    profile: {
      name: "Om",
    },
  },
};

console.log(response.user?.profile?.name);
```

---

GitHub API

```js
console.log(data.owner?.login);
```

---

Weather API

```js
console.log(weather.current?.temp);
```

---

# 9. React Examples

Props

```jsx
function Card({ user }) {
  return (
    <h1>{user?.name}</h1>
  );
}
```

---

Fetching Data

```jsx
<h2>{user?.address?.city}</h2>
```

No crash before data loads.

---

# 10. Node.js Examples

Express

```js
const city =
req.body?.address?.city;
```

JWT Payload

```js
const role =
req.user?.role;
```

MongoDB

```js
const email =
user?.email;
```

---

# 11. Best Practices

✅ Use when nested objects may not exist.

✅ Combine with `??` for default values.

✅ Great for API responses.

✅ Great for React props and state.

---

# 12. Common Mistakes

### Optional Chaining Doesn't Create Properties

Wrong

```js
user.address?.city = "Pune";
```

Error.

Optional Chaining is only for **reading**, not writing.

---

### Doesn't Replace Validation

Wrong

```js
if (user?.age > 18)
```

If `age` is undefined,

comparison may not behave as expected.

---

### Confusing `?.` with `.`

```js
user.address.city
```

Throws error.

```js
user.address?.city
```

Returns undefined.

---

# 13. Interview Questions

### What is Optional Chaining?

A safe way to access nested properties without throwing errors.

---

### What does `?.` return?

If the value is

```
null

or

undefined
```

it returns

```
undefined
```

instead of throwing an error.

---

### Can Optional Chaining call methods?

Yes.

```js
user.greet?.();
```

---

### Can Optional Chaining access arrays?

Yes.

```js
users?.[0]
```

---

### Should Optional Chaining be combined with `??`?

Yes.

Very common.

```js
user.address?.city ?? "Unknown"
```

---

### Is Optional Chaining supported in modern browsers?

Yes.

Supported in all modern browsers and modern Node.js versions.

---

# 14. Coding Exercises

### Exercise 1

Safely print

```js
user.profile.name
```

using Optional Chaining.

---

### Exercise 2

Return

```
"No Email"
```

if

```js
user.email
```

doesn't exist.

---

### Exercise 3

Safely call

```js
user.login()
```

using Optional Chaining.

---

### Exercise 4

Safely print

```js
users[1].name
```

using Optional Chaining.

---

### Exercise 5

Predict Output

```js
const user = {};

console.log(user.address?.city);
```

---

# 15. Summary

- Optional Chaining (`?.`) safely accesses nested properties.
- Prevents `TypeError` when a property is `null` or `undefined`.
- Works with:
  - Objects
  - Arrays
  - Function calls
- Often combined with Nullish Coalescing (`??`) for default values.
- Commonly used in React, Node.js, Express, MongoDB, and API handling.
- Makes code cleaner, safer, and easier to maintain.

---

# What's Next?

➡️ **11-Nullish-Coalescing.md**

You'll learn:

- Why `??` was introduced
- Difference between `||` and `??`
- Handling `null` and `undefined`
- Default Values
- Real-world Examples
- React Examples
- Node.js Examples
- Interview Questions
- Coding Exercises