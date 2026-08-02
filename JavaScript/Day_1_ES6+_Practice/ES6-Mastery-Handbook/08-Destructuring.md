# Destructuring

> **"Destructuring allows you to unpack values from arrays or properties from objects into individual variables. It makes code shorter, cleaner, and easier to read."**

---

# Table of Contents

1. What is Destructuring?
2. Why Destructuring Was Introduced
3. Array Destructuring
4. Object Destructuring
5. Renaming Variables
6. Default Values
7. Skipping Elements
8. Swapping Variables
9. Nested Destructuring
10. Function Parameter Destructuring
11. Rest Operator with Destructuring
12. Real-world Examples
13. React Examples
14. Node.js Examples
15. Best Practices
16. Common Mistakes
17. Interview Questions
18. Coding Exercises
19. Summary

---

# 1. What is Destructuring?

Destructuring is an ES6 feature that lets you extract values from arrays or objects into variables.

Without Destructuring

```js
const person = {
  name: "Om",
  age: 22,
};

const name = person.name;
const age = person.age;

console.log(name);
console.log(age);
```

With Destructuring

```js
const person = {
  name: "Om",
  age: 22,
};

const { name, age } = person;

console.log(name);
console.log(age);
```

Output

```
Om
22
```

---

# 2. Why Destructuring Was Introduced

Before ES6

```js
const person = {
  name: "Om",
  age: 22,
};

const name = person.name;
const age = person.age;
const city = person.city;
```

After ES6

```js
const { name, age, city } = person;
```

Benefits

- Less code
- Cleaner code
- Better readability
- Easier function parameters
- Used heavily in React and Node.js

---

# 3. Array Destructuring

Arrays use **position**.

```js
const colors = ["Red", "Green", "Blue"];

const [first, second, third] = colors;

console.log(first);
console.log(second);
console.log(third);
```

Output

```
Red
Green
Blue
```

Visualization

```
colors

↓

[Red, Green, Blue]

↓

first = Red

second = Green

third = Blue
```

---

# 4. Object Destructuring

Objects use **property names**.

```js
const person = {
  name: "Om",
  age: 22,
};

const { name, age } = person;

console.log(name);
console.log(age);
```

Output

```
Om
22
```

Visualization

```
person

↓

name → Om

age → 22

↓

Variables

↓

name = Om

age = 22
```

---

# 5. Renaming Variables

Sometimes variable names should be different.

```js
const person = {
  name: "Om",
};

const { name: fullName } = person;

console.log(fullName);
```

Output

```
Om
```

Syntax

```js
propertyName : variableName
```

---

# 6. Default Values

If a property doesn't exist, use a default value.

```js
const person = {
  name: "Om",
};

const { name, age = 18 } = person;

console.log(age);
```

Output

```
18
```

Without Default

```js
const { age } = person;

console.log(age);
```

Output

```
undefined
```

---

# 7. Skipping Elements

Skip unwanted array values.

```js
const numbers = [10, 20, 30];

const [first, , third] = numbers;

console.log(first);
console.log(third);
```

Output

```
10
30
```

Visualization

```
10

↓

first

20

↓

Skipped

30

↓

third
```

---

# 8. Swapping Variables

Before ES6

```js
let a = 10;
let b = 20;

let temp = a;
a = b;
b = temp;
```

ES6

```js
let a = 10;
let b = 20;

[a, b] = [b, a];

console.log(a);
console.log(b);
```

Output

```
20
10
```

---

# 9. Nested Destructuring

Arrays

```js
const numbers = [1, [2, 3]];

const [a, [b, c]] = numbers;

console.log(a);
console.log(b);
console.log(c);
```

Output

```
1
2
3
```

Objects

```js
const person = {
  name: "Om",
  address: {
    city: "Pune",
  },
};

const {
  address: { city },
} = person;

console.log(city);
```

Output

```
Pune
```

---

# 10. Function Parameter Destructuring

Without Destructuring

```js
function greet(person) {
  console.log(person.name);
}
```

With Destructuring

```js
function greet({ name }) {
  console.log(name);
}

greet({
  name: "Om",
});
```

Output

```
Om
```

This is widely used in React.

---

# 11. Rest Operator with Destructuring

Arrays

```js
const numbers = [1, 2, 3, 4];

const [first, ...rest] = numbers;

console.log(first);
console.log(rest);
```

Output

```
1
[2,3,4]
```

Objects

```js
const person = {
  name: "Om",
  age: 22,
  city: "Pune",
};

const { name, ...details } = person;

console.log(details);
```

Output

```js
{
age:22,
city:"Pune"
}
```

---

# 12. Real-world Examples

API Response

```js
const response = {
  id: 1,
  name: "Laptop",
  price: 70000,
};

const { name, price } = response;
```

Configuration

```js
const config = {
  host: "localhost",
  port: 3000,
};

const { host, port } = config;
```

---

# 13. React Examples

Props

```jsx
function Card({ title, price }) {
  return (
    <h1>{title}</h1>
  );
}
```

State

```jsx
const [count, setCount] = useState(0);
```

This is array destructuring.

---

# 14. Node.js Examples

Express

```js
const { username, password } = req.body;
```

Environment Variables

```js
const { PORT } = process.env;
```

MongoDB

```js
const { name, email } = user;
```

---

# 15. Best Practices

✅ Destructure only required properties.

✅ Use default values.

✅ Rename variables when necessary.

✅ Use parameter destructuring for cleaner functions.

---

# 16. Common Mistakes

### Wrong Property Name

```js
const person = {
  name: "Om",
};

const { age } = person;

console.log(age);
```

Output

```
undefined
```

---

### Array Position Matters

```js
const numbers = [10, 20];

const [a, b] = numbers;
```

Changing order changes values.

---

### Object Order Doesn't Matter

```js
const person = {
  age: 22,
  name: "Om",
};

const { name, age } = person;
```

Works perfectly.

---

### Forgetting Nested Structure

Wrong

```js
const {
  city
} = person;
```

Correct

```js
const {
  address: { city },
} = person;
```

---

# 17. Interview Questions

### What is Destructuring?

A way to extract values from arrays and objects into variables.

---

### Difference between Array and Object Destructuring?

Array → Position

Object → Property Name

---

### Can you rename variables?

Yes.

```js
const { name: fullName } = person;
```

---

### Can destructuring have default values?

Yes.

```js
const { age = 18 } = person;
```

---

### How do you swap variables?

```js
[a, b] = [b, a];
```

---

### Where is destructuring commonly used?

- React Props
- React Hooks
- Express req.body
- MongoDB documents
- API responses

---

# 18. Coding Exercises

### Exercise 1

Extract

```js
const user = {
  name: "Om",
  age: 22,
};
```

into variables.

---

### Exercise 2

Swap

```js
let a = 5;
let b = 10;
```

using destructuring.

---

### Exercise 3

Extract

```js
const student = {
  address: {
    city: "Pune",
  },
};
```

Output

```
Pune
```

---

### Exercise 4

Use parameter destructuring

```js
function printName(user) {

}
```

---

### Exercise 5

Predict Output

```js
const numbers = [10,20,30];

const [a,,c] = numbers;

console.log(a,c);
```

---

# 19. Summary

- Destructuring extracts values from arrays and objects.
- Array destructuring depends on position.
- Object destructuring depends on property names.
- Supports renaming and default values.
- Allows nested destructuring.
- Rest Operator collects remaining values.
- Used extensively in React, Node.js, Express, and API handling.
- Makes code shorter, cleaner, and easier to maintain.

---

# What's Next?

➡️ **09-Enhanced-Object-Literals.md**

You'll learn:

- Property Shorthand
- Computed Property Names
- Method Shorthand
- Dynamic Object Creation
- Real-world React & Node.js Examples
- Interview Questions
- Coding Exercises