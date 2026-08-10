# Object Methods

> **"JavaScript Objects are collections of key-value pairs. Object Methods provide powerful ways to inspect, copy, merge, freeze, seal, and manipulate objects. These methods are used extensively in React, Node.js, Express, MongoDB, and modern JavaScript applications."**

---

# Table of Contents

1. Introduction
2. Why Object Methods?
3. Object.keys()
4. Object.values()
5. Object.entries()
6. Object.fromEntries()
7. Object.assign()
8. Object.freeze()
9. Object.seal()
10. Object.hasOwn()
11. Object.create()
12. Object.is()
13. Iterating Objects
14. Shallow Copy vs Deep Copy
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

Objects store data using key-value pairs.

Example

```js
const user = {
  name: "Om",
  age: 22,
};
```

Unlike arrays,

objects don't have methods like

```
map()

filter()

reduce()
```

Instead,

JavaScript provides

```
Object.keys()

Object.values()

Object.entries()

Object.assign()

Object.freeze()

Object.seal()

...
```

---

# 2. Why Object Methods?

Without Object Methods

```js
const user = {
  name: "Om",
  age: 22,
};

for (let key in user) {
  console.log(key);
}
```

With Object Methods

```js
Object.keys(user);
```

Cleaner.

More readable.

More powerful.

---

# 3. Object.keys()

Returns an array of property names.

Example

```js
const user = {
  name: "Om",
  age: 22,
};

console.log(
Object.keys(user)
);
```

Output

```js
[
"name",
"age"
]
```

Visualization

```
Object

↓

name

age

↓

Array

↓

["name","age"]
```

Common Uses

- Count properties
- Loop over keys
- Validation

---

# 4. Object.values()

Returns all values.

```js
const user = {
  name: "Om",
  age: 22,
};

console.log(
Object.values(user)
);
```

Output

```js
[
"Om",
22
]
```

---

# 5. Object.entries()

Returns

```
[key,value]
```

pairs.

Example

```js
const user = {
  name: "Om",
  age: 22,
};

console.log(
Object.entries(user)
);
```

Output

```js
[
["name","Om"],
["age",22]
]
```

Useful for loops.

```js
for (const [key, value] of Object.entries(user)) {
  console.log(key, value);
}
```

Output

```
name Om

age 22
```

---

# 6. Object.fromEntries()

Converts entries back into an object.

Example

```js
const entries = [
  ["name", "Om"],
  ["age", 22],
];

const user =
Object.fromEntries(entries);

console.log(user);
```

Output

```js
{
name:"Om",
age:22
}
```

Useful after transforming entries.

---

# 7. Object.assign()

Copies or merges objects.

Example

```js
const user = {
  name: "Om",
};

const details = {
  age: 22,
};

const person =
Object.assign({}, user, details);

console.log(person);
```

Output

```js
{
name:"Om",
age:22
}
```

Equivalent ES6

```js
const person = {
  ...user,
  ...details,
};
```

---

# 8. Object.freeze()

Makes an object completely immutable.

Example

```js
const user = {
  name: "Om",
};

Object.freeze(user);

user.name = "Raj";

console.log(user.name);
```

Output

```
Om
```

Cannot

- Add
- Delete
- Modify

Visualization

```
Object

↓

Freeze

↓

Read Only
```

---

# 9. Object.seal()

Allows modification,

but prevents

- Adding properties
- Removing properties

Example

```js
const user = {
  name: "Om",
};

Object.seal(user);

user.name = "Raj";

console.log(user.name);
```

Output

```
Raj
```

Adding

```js
user.age = 22;
```

Ignored.

---

Comparison

| Method | Modify | Add | Delete |
|---------|--------|-----|--------|
| freeze | ❌ | ❌ | ❌ |
| seal | ✅ | ❌ | ❌ |

---

# 10. Object.hasOwn()

Checks whether a property belongs directly to the object.

Example

```js
const user = {
  name: "Om",
};

console.log(
Object.hasOwn(user, "name")
);
```

Output

```
true
```

Missing property

```js
Object.hasOwn(user, "city");
```

Output

```
false
```

Older Way

```js
user.hasOwnProperty("name");
```

Modern JavaScript recommends

```js
Object.hasOwn()
```

---

# 11. Object.create()

Creates a new object using another object as its prototype.

Example

```js
const person = {
  greet() {
    console.log("Hello");
  },
};

const user =
Object.create(person);

user.greet();
```

Output

```
Hello
```

Prototype Chain

```
user

↓

person

↓

Object
```

---

# 12. Object.is()

Checks whether two values are exactly the same.

Example

```js
console.log(
Object.is(10,10)
);
```

Output

```
true
```

Interesting Example

```js
console.log(
Object.is(NaN, NaN)
);
```

Output

```
true
```

Unlike

```js
NaN === NaN
```

Output

```
false
```

---

# 13. Iterating Objects

Using keys

```js
const user = {
  name: "Om",
  age: 22,
};

Object.keys(user).forEach(key=>{
  console.log(key);
});
```

---

Using values

```js
Object.values(user).forEach(value=>{
  console.log(value);
});
```

---

Using entries

```js
for(const [key,value] of Object.entries(user)){
    console.log(key,value);
}
```

---

# 14. Shallow Copy vs Deep Copy

Object.assign()

```js
const copy =
Object.assign({}, user);
```

Spread

```js
const copy = {
...user
}
```

Both create a

```
Shallow Copy
```

Nested objects remain shared.

Example

```js
const user = {
  address: {
    city: "Pune",
  },
};

const copy = {
  ...user,
};

copy.address.city = "Mumbai";

console.log(user.address.city);
```

Output

```
Mumbai
```

---

# 15. Real-world Examples

API Response

```js
Object.keys(response);
```

Validation

```js
if(Object.hasOwn(user,"email")){
}
```

Merge Config

```js
const config = {
  ...defaults,
  ...custom,
};
```

---

# 16. React Examples

Updating State

```jsx
setUser({
  ...user,
  age:23
});
```

Checking Props

```jsx
Object.keys(props)
```

Rendering

```jsx
Object.entries(user)
.map(...)
```

---

# 17. Node.js Examples

Environment Variables

```js
Object.keys(process.env)
```

Configuration

```js
const config = {
  ...defaults,
  ...env,
};
```

Database

```js
Object.values(document)
```

---

# 18. Best Practices

✅ Prefer Spread over Object.assign() for simple copying.

✅ Use Object.entries() when both key and value are required.

✅ Use Object.freeze() for constants.

✅ Use Object.hasOwn() instead of hasOwnProperty().

---

# 19. Common Mistakes

### Thinking Object.keys() returns values

Wrong

```js
Object.keys(user)
```

Returns

```
Keys
```

---

### Thinking freeze() affects nested objects

Wrong

```js
Object.freeze(user);
```

Nested objects can still change.

---

### Using hasOwnProperty()

Prefer

```js
Object.hasOwn()
```

---

### Assuming Object.assign() creates a deep copy

Wrong.

Only shallow copy.

---

# 20. Interview Questions

### Difference between Object.keys() and Object.values()?

Keys

```
["name","age"]
```

Values

```
["Om",22]
```

---

### Difference between Object.entries() and Object.fromEntries()?

entries()

Object → Array

fromEntries()

Array → Object

---

### Difference between freeze() and seal()?

freeze()

Nothing changes.

seal()

Only existing properties can change.

---

### Difference between Object.assign() and Spread?

Mostly similar.

Spread is cleaner and more common in modern JavaScript.

---

### What does Object.hasOwn() do?

Checks whether a property belongs directly to the object.

---

# 21. Coding Exercises

### Exercise 1

Print all keys of

```js
const user = {
name:"Om",
age:22
}
```

---

### Exercise 2

Print all values.

---

### Exercise 3

Loop using

```js
Object.entries()
```

---

### Exercise 4

Merge two objects.

---

### Exercise 5

Freeze an object and try modifying it.

---

### Exercise 6

Seal an object and observe what can and cannot change.

---

### Exercise 7

Convert

```js
[
["name","Om"],
["age",22]
]
```

into an object.

---

# 22. Summary

- Objects store key-value pairs.
- `Object.keys()` returns property names.
- `Object.values()` returns property values.
- `Object.entries()` returns key-value pairs.
- `Object.fromEntries()` converts entries back into an object.
- `Object.assign()` and the Spread Operator create shallow copies.
- `Object.freeze()` makes an object immutable.
- `Object.seal()` allows modification but prevents adding/removing properties.
- `Object.hasOwn()` checks if a property exists directly on the object.
- These methods are widely used in React, Node.js, Express, and modern JavaScript.

---

# What's Next?

➡️ **15-Higher-Order-Functions.md**

You'll learn:

- What Higher-Order Functions are
- Callback Functions
- First-Class Functions
- Function Composition
- Pure vs Impure Functions
- Closures with HOFs
- Real-world React Examples
- Interview Questions
- Coding Exercises