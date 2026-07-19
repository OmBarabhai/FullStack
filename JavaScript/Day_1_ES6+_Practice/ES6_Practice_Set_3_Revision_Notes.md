# 🚀 ES6+ Practice Set 3 – Quick Revision Notes

> **Focus:** Arrays • Objects • Destructuring • Loops • Template Literals • Arrow Functions

---

# 📚 Topics Covered

* Arrays
* Objects
* Arrow Functions
* Object Destructuring
* Array Destructuring
* Nested Destructuring
* Template Literals
* Searching Arrays
* Loops
* Conditional Statements

---

# 1️⃣ Array Information

### Problem

Return

* Number of items
* First item
* Last item

### Example

```javascript
const formatArray = (arr) =>
  `The array has ${arr.length} items, and the first item is "${arr[0]}", and the last item is "${arr[arr.length - 1]}".`;
```

### Remember

* `.length`
* First → `arr[0]`
* Last → `arr[arr.length-1]`
* Return a **string**, not the array.

---

# 2️⃣ Object + Template Literal

### Problem

Return product details.

```javascript
const formatProduct = ({ name, price, inStock }) =>
  `${name} costs INR ${price} and is ${
    inStock ? "in stock" : "out of stock"
  }.`;
```

### Concepts

* Object destructuring
* Template literals
* Ternary operator

---

# 3️⃣ Searching Objects Inside an Array

### Problem

Find an object by name.

```javascript
const findPerson = (people, personName) => {
  for (let i = 0; i < people.length; i++) {
    if (people[i].name === personName) {
      return people[i];
    }
  }

  return null;
};
```

### Remember

```text
Array

↓

Loop

↓

Compare

↓

Return Object
```

Don't destructure before searching.

---

# 4️⃣ Array Destructuring

```javascript
const pickFirstAndSecond = ([first, second]) => ({
  first,
  second,
});
```

### Remember

```javascript
[first, second]
```

extracts the first two values.

---

# 5️⃣ Arrow Functions

Instead of

```javascript
if (condition) {
  return true;
}
return false;
```

Simply write

```javascript
const startsWithA = (str) => str.charAt(0) === "A";
```

Comparison operators already return booleans.

---

# 6️⃣ First Element

```javascript
const printFirstCharacter = (arr) => arr[0];
```

---

# 7️⃣ Last Five Elements

Remember

Question asks

> Return an **array**

Not

```javascript
console.log()
```

Concept

```text
Last Index

↓

length - 1

↓

Start from

length - 5
```

---

# 8️⃣ Second Element

```javascript
const printSecondCharacter = (arr) => arr[1] * 20;
```

Remember

Second element

```javascript
arr[1]
```

---

# 9️⃣ Template Literals

```javascript
const sayHello = (arr) => `Hello ${arr[1]}`;
```

Use template literals instead of string concatenation whenever possible.

---

# 🔟 Sum of Even Indices

```javascript
const sumOfEvenIndices = (arr) => {
  let sum = 0;

  for (let i = 0; i < arr.length; i++) {
    if (i % 2 === 0) {
      sum += arr[i];
    }
  }

  return sum;
};
```

### Remember

Even **index**

```text
0

2

4

6
```

Not even numbers.

---

# 1️⃣1️⃣ First Two Elements

```javascript
const sumFirstTwoElements = ([first, second]) =>
  first + second;
```

Destructuring makes the solution cleaner.

---

# 1️⃣2️⃣ First Multiple of Five

```javascript
const printMultipleOfFive = (arr) => {
  for (let i = 0; i < arr.length; i++) {
    if (arr[i] % 5 === 0) {
      return arr[i];
    }
  }

  return null;
};
```

### Remember

Return the **first** matching value.

---

# 1️⃣3️⃣ Object Destructuring

```javascript
const getAddress = ({ postalCode, city }) => ({
  postalCode,
  city,
});
```

Returns only the required properties.

---

# 1️⃣4️⃣ Template Literals + Destructuring

```javascript
const printData = ({ name, country }) =>
  `${name} lives in ${country}`;
```

---

# 1️⃣5️⃣ Nested Destructuring

Better

```javascript
const printProductDetails = ({
  name,
  specification: { size },
}) => `${name} which is of ${size}`;
```

Instead of

```javascript
specification.size
```

extract `size` directly.

---

# ❌ Common Mistakes

## Returning vs Printing

Wrong

```javascript
console.log(value);
```

Correct

```javascript
return value;
```

---

## Returning Wrong Type

Always identify whether the function should return

* Number
* String
* Boolean
* Object
* Array

---

## Ignoring Conditions

Whenever a question says

> based on...

expect

```javascript
if
```

or

```javascript
condition ? value1 : value2
```

---

## Unnecessary Ternary

Wrong

```javascript
condition ? true : false
```

Correct

```javascript
condition
```

---

## Forgetting Destructuring

Question mentions destructuring?

Use

```javascript
const { name } = person;
```

or

```javascript
const [first] = arr;
```

---

## Overusing ES6

Don't force destructuring everywhere.

Sometimes a simple loop is the correct solution.

---

# 🎯 Interview Revision

Be able to answer:

* What is object destructuring?
* What is array destructuring?
* Difference between object and array destructuring?
* Why use template literals?
* Why return instead of `console.log()`?
* Why use arrow functions?
* When should you use loops?
* How do you search an array manually?
* What is nested destructuring?
* Why is `i % 2 === 0` used for even indices?

---

# 🧠 Quick Memory Map

```text
Practice Set 3

├── Arrays
│   ├── First
│   ├── Second
│   ├── Last
│   ├── Last Five
│   ├── Even Indices
│   ├── Search
│   └── Destructuring
│
├── Objects
│   ├── Destructuring
│   ├── Nested Destructuring
│   └── Template Literals
│
├── Functions
│   ├── Arrow Functions
│   ├── return
│   └── Parameters
│
└── Strings
    └── Template Literals
```

---

# ✅ Revision Checklist

* [ ] I know when to return a string, object, array, number, or boolean.
* [ ] I can search an array using a `for` loop.
* [ ] I know how to destructure arrays and objects.
* [ ] I understand nested destructuring.
* [ ] I know when to use template literals.
* [ ] I know why `return` is different from `console.log()`.
* [ ] I can identify even indices using `i % 2 === 0`.
* [ ] I know when destructuring improves readability.
* [ ] I can decide when a loop is more appropriate than destructuring.
* [ ] I can solve similar questions without looking at the answers.

---

# 🚀 Key Takeaway

For every problem, ask yourself:

1. **What is the input?**
2. **What should I return?**
3. **What is the return type?**
4. **Which ES6 feature fits best?**
5. **Can I write it more clearly?**

Understanding these five questions will help you solve new problems confidently, not just memorize solutions.
