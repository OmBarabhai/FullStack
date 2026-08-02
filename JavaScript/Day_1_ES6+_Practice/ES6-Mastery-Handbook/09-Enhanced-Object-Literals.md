# Enhanced Object Literals

> **"Enhanced Object Literals (ES6) provide a shorter and more powerful way to create objects. They reduce boilerplate code by introducing property shorthand, method shorthand, computed property names, and dynamic object creation."**

---

# Table of Contents

1. What are Enhanced Object Literals?
2. Why Were They Introduced?
3. Property Shorthand
4. Method Shorthand
5. Computed Property Names
6. Dynamic Object Creation
7. Combining Objects
8. Real-world Examples
9. React Examples
10. Node.js Examples
11. Best Practices
12. Common Mistakes
13. Interview Questions
14. Coding Exercises
15. Summary

---

# 1. What are Enhanced Object Literals?

Before ES6, creating objects often required repeating variable names.

Example (ES5)

```js
const name = "Om";
const age = 22;

const person = {
  name: name,
  age: age,
};

console.log(person);
```

Output

```js
{
  name: "Om",
  age: 22
}
```

ES6 introduced a cleaner syntax.

```js
const name = "Om";
const age = 22;

const person = {
  name,
  age,
};

console.log(person);
```

Output

```js
{
  name: "Om",
  age: 22
}
```

---

# 2. Why Were They Introduced?

Before ES6

```js
const username = "Om";

const user = {
  username: username,
};
```

After ES6

```js
const username = "Om";

const user = {
  username,
};
```

Benefits

- Less code
- Cleaner syntax
- Easier to read
- Used extensively in React and Node.js

---

# 3. Property Shorthand

If the variable name and property name are the same, JavaScript automatically assigns the value.

Example

```js
const title = "JavaScript";
const price = 999;

const course = {
  title,
  price,
};

console.log(course);
```

Output

```js
{
  title: "JavaScript",
  price: 999
}
```

Visualization

```
title

↓

"JavaScript"

↓

Object

↓

title : "JavaScript"
```

---

# 4. Method Shorthand

Before ES6

```js
const person = {
  greet: function () {
    console.log("Hello");
  },
};

person.greet();
```

ES6

```js
const person = {
  greet() {
    console.log("Hello");
  },
};

person.greet();
```

Output

```
Hello
```

Benefits

- Cleaner
- Easier to read
- Most modern codebases use this syntax

---

# 5. Computed Property Names

Property names can be created dynamically.

Example

```js
const key = "language";

const course = {
  [key]: "JavaScript",
};

console.log(course);
```

Output

```js
{
  language: "JavaScript"
}
```

Without Computed Properties

```js
const course = {
  key: "JavaScript",
};
```

Output

```js
{
  key: "JavaScript"
}
```

Notice the difference.

---

Another Example

```js
const field = "price";

const product = {
  name: "Laptop",
  [field]: 70000,
};

console.log(product);
```

Output

```js
{
  name: "Laptop",
  price: 70000
}
```

---

# 6. Dynamic Object Creation

Objects can be created dynamically.

Example

```js
function createUser(name, age) {
  return {
    name,
    age,
  };
}

console.log(createUser("Om", 22));
```

Output

```js
{
  name: "Om",
  age: 22
}
```

Another Example

```js
const key = "city";
const value = "Pune";

const address = {
  [key]: value,
};

console.log(address);
```

Output

```js
{
  city: "Pune"
}
```

---

# 7. Combining Objects

Enhanced Object Literals work well with the Spread Operator.

```js
const personalInfo = {
  name: "Om",
};

const jobInfo = {
  company: "OpenAI",
};

const employee = {
  ...personalInfo,
  ...jobInfo,
};

console.log(employee);
```

Output

```js
{
  name: "Om",
  company: "OpenAI"
}
```

---

# 8. Real-world Examples

### API Response

```js
const id = 101;
const name = "Laptop";

const response = {
  id,
  name,
};

console.log(response);
```

---

### Configuration Object

```js
const host = "localhost";
const port = 5000;

const config = {
  host,
  port,
};
```

---

### Dynamic Filters

```js
const filter = "category";

const query = {
  [filter]: "Electronics",
};

console.log(query);
```

---

# 9. React Examples

Props Object

```jsx
const title = "MacBook";
const price = 99999;

<Card title={title} price={price} />
```

Equivalent Object

```js
{
  title,
  price
}
```

State Update

```jsx
setUser({
  ...user,
  age: 23,
});
```

---

# 10. Node.js Examples

Express

```js
const username = req.body.username;
const email = req.body.email;

const user = {
  username,
  email,
};
```

MongoDB

```js
const document = {
  name,
  email,
  age,
};
```

Configuration

```js
const PORT = 5000;

const config = {
  PORT,
};
```

---

# 11. Best Practices

✅ Use property shorthand whenever variable and property names are the same.

✅ Use method shorthand instead of `function`.

✅ Use computed property names for dynamic keys.

✅ Combine with the Spread Operator for cleaner code.

---

# 12. Common Mistakes

### Forgetting Brackets in Computed Properties

Wrong

```js
const key = "name";

const obj = {
  key: "Om",
};
```

Output

```js
{
  key: "Om"
}
```

Correct

```js
const obj = {
  [key]: "Om",
};
```

Output

```js
{
  name: "Om"
}
```

---

### Mixing Shorthand Incorrectly

Wrong

```js
const name = "Om";

const user = {
  name: name,
  name,
};
```

Duplicate property.

---

### Confusing Property Shorthand with Destructuring

Property Shorthand

```js
const user = {
  name,
};
```

Destructuring

```js
const { name } = user;
```

They solve different problems.

---

# 13. Interview Questions

### What are Enhanced Object Literals?

They are ES6 features that simplify object creation using shorthand syntax.

---

### What is Property Shorthand?

```js
const name = "Om";

const user = {
  name,
};
```

---

### What is Method Shorthand?

```js
const user = {
  greet() {
    console.log("Hello");
  },
};
```

---

### What are Computed Property Names?

Dynamic property names.

```js
const key = "age";

const person = {
  [key]: 22,
};
```

---

### Where are Enhanced Object Literals used?

- React
- Node.js
- Express
- MongoDB
- API Responses
- Configuration Objects

---

# 14. Coding Exercises

### Exercise 1

Convert

```js
const name = "Om";

const user = {
  name: name,
};
```

to ES6.

---

### Exercise 2

Convert

```js
const obj = {
  greet: function () {
    console.log("Hi");
  },
};
```

using method shorthand.

---

### Exercise 3

Create

```js
{
  city: "Pune"
}
```

using computed property names.

---

### Exercise 4

Create a function

```js
createProduct(name, price)
```

that returns

```js
{
  name,
  price
}
```

---

### Exercise 5

Predict Output

```js
const key = "language";

const obj = {
  [key]: "JavaScript",
};

console.log(obj);
```

---

# 15. Summary

- Enhanced Object Literals simplify object creation.
- Property shorthand removes duplicate variable names.
- Method shorthand replaces `function`.
- Computed property names allow dynamic keys.
- Frequently used with the Spread Operator.
- Widely used in React, Express, Node.js, MongoDB, and API development.
- Makes modern JavaScript cleaner, shorter, and easier to maintain.

---

# What's Next?

➡️ **10-Optional-Chaining.md**

You'll learn:

- Why Optional Chaining was introduced
- Safe Property Access
- Nested Objects
- Optional Function Calls
- Array Access
- Real-world API Examples
- React Examples
- Node.js Examples
- Interview Questions
- Coding Exercises