# Part 1 — `map()` Fundamentals

> **Goal:** Understand what `map()` does, its syntax, callback basics, return value, and when to use it. Deep pitfalls and `myMap()` implementation will come later in this same file.

## 1. What is `map()`?

`map()` is used when you want to **transform every element** of an array.

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
[1, 2, 3]
    ↓
  map()
    ↓
transform each element
    ↓
[2, 4, 6]
```

---

## 2. Basic Syntax

```js
const result = array.map(callback);
```

Common syntax:

```js
const result = numbers.map(num => num * 2);
```

The callback tells `map()`:

> **"What should I do with each element?"**

---

## 3. Callback Function

The function passed to `map()` is the callback.

```js
const numbers = [10, 20, 30];

const result = numbers.map(num => num + 5);

console.log(result);
```

Output:

```text
[15, 25, 35]
```

Flow:

```text
map()
  ↓
10 → callback → 15
20 → callback → 25
30 → callback → 35
  ↓
[15, 25, 35]
```

---

## 4. Callback Parameters

The callback can receive three values:

```js
array.map((element, index, array) => {
    // ...
});
```

| Parameter | Meaning         |
| --------- | --------------- |
| `element` | Current element |
| `index`   | Current index   |
| `array`   | Original array  |

Example:

```js
const numbers = [10, 20, 30];

numbers.map((value, index) => {
    console.log(index, value);
});
```

Output:

```text
0 10
1 20
2 30
```

Most of the time, you only need the first parameter:

```js
numbers.map(num => num * 2);
```

---

## 5. Return Value

`map()` returns a **new array**.

```js
const numbers = [1, 2, 3];

const result = numbers.map(num => num * 5);

console.log(numbers);
console.log(result);
```

Output:

```text
[1, 2, 3]
[5, 10, 15]
```

So:

```text
Original array → unchanged
Result        → new array
```

---

## 6. `map()` vs `for` Loop

Traditional approach:

```js
const numbers = [1, 2, 3];

const result = [];

for (let i = 0; i < numbers.length; i++) {
    result.push(numbers[i] * 2);
}
```

Using `map()`:

```js
const result = numbers.map(num => num * 2);
```

The key advantage is that `map()` directly expresses:

> **Transform every element and return the resulting array.**

---

## 7. Simple Examples

### Double

```js
const numbers = [1, 2, 3];

const result = numbers.map(num => num * 2);
```

Result:

```text
[2, 4, 6]
```

### Square

```js
const numbers = [2, 4, 6];

const squares = numbers.map(num => num * num);
```

Result:

```text
[4, 16, 36]
```

### Convert to String

```js
const numbers = [1, 2, 3];

const result = numbers.map(num => String(num));
```

Result:

```text
["1", "2", "3"]
```

---

## 8. When Should You Use `map()`?

Use `map()` when:

```text
You have an array
      ↓
You want to transform every element
      ↓
You need a new array
```

Examples:

```js
numbers.map(num => num * 2);

users.map(user => user.name);

products.map(product => product.price);
```

### Quick rule

```text
Transform → map()
Select    → filter()
Find one  → find()
```

---

## 9. Hands-on Practice

Write these yourself before checking any solution.

### Exercise 1

```js
const numbers = [1, 2, 3, 4];
```

Create:

```text
[2, 4, 6, 8]
```

### Exercise 2

```js
const numbers = [5, 10, 15];
```

Create:

```text
[10, 20, 30]
```

### Exercise 3

Convert:

```js
[1, 2, 3]
```

into:

```text
["1", "2", "3"]
```

### Exercise 4

```js
const numbers = [2, 3, 4];
```

Return their squares.

### Exercise 5 — Predict Output

```js
const numbers = [10, 20, 30];

const result = numbers.map(num => num + 1);

console.log(result);
```

---

## Part 1 Checkpoint

Before moving to Part 2, you should be able to answer:

```text
What does map() do?
What does it return?
What is the callback?
What are the callback parameters?
Does map() change the original array?
When should you use map()?
```

### One-line memory rule

```text
map() = transform every element → new array
```

**Part 1 complete.**


# Part 2 — `map()` Internal Working & Callback Flow

> **Goal:** Understand what actually happens when `map()` runs. You do not need JavaScript-engine internals here; you only need the execution flow well enough to dry-run and debug it.

## 1. How `map()` Works

Consider:

```js
const numbers = [2, 4, 6];

const result = numbers.map(num => num * 3);
```

Conceptually:

```text
numbers
   ↓
map()
   ↓
take current element
   ↓
call callback
   ↓
get returned value
   ↓
put value into new array
   ↓
next element
   ↓
repeat
   ↓
return new array
```

---

## 2. Step-by-Step Execution

For:

```js
const numbers = [2, 4, 6];

const result = numbers.map(num => num * 3);
```

### Step 1

Current element:

```text
2
```

Callback:

```js
2 * 3
```

Returns:

```text
6
```

Result so far:

```text
[6]
```

### Step 2

Current element:

```text
4
```

Callback:

```js
4 * 3
```

Returns:

```text
12
```

Result:

```text
[6, 12]
```

### Step 3

Current element:

```text
6
```

Callback:

```js
6 * 3
```

Returns:

```text
18
```

Final:

```text
[6, 12, 18]
```

---

## 3. Callback Gets Values

The callback can receive:

```js
const numbers = [10, 20, 30];

numbers.map((element, index, array) => {
    console.log(element, index);
});
```

Output:

```text
10 0
20 1
30 2
```

The third argument is the original array:

```js
numbers.map((element, index, array) => {
    console.log(array);
});
```

You normally don't need all three.

Most common:

```js
numbers.map(number => number * 2);
```

---

## 4. Why `return` Matters

This works:

```js
const result = numbers.map(num => num * 2);
```

Because the expression is implicitly returned.

This also works:

```js
const result = numbers.map(num => {
    return num * 2;
});
```

But this does not:

```js
const result = numbers.map(num => {
    num * 2;
});
```

Result:

```text
[undefined, undefined, undefined]
```

Why?

```text
callback runs
      ↓
no return
      ↓
undefined
      ↓
undefined stored in result
```

This is one of the most common `map()` interview/OA mistakes.

---

## 5. `map()` Does Not Return the Callback Directly

For:

```js
const result = numbers.map(num => num * 2);
```

The callback returns one value per element.

`map()` collects all those values:

```text
callback → 2
callback → 4
callback → 6

        ↓

result → [2, 4, 6]
```

So:

```text
Callback returns one value
        ↓
map() creates the array
```

---

## 6. Basic Memory Idea

For primitives:

```js
const numbers = [1, 2, 3];

const result = numbers.map(num => num * 2);
```

You have two arrays:

```text
numbers → [1, 2, 3]

result  → [2, 4, 6]
```

The original array is not replaced.

---

## 7. Important Object Reference Point

With objects:

```js
const users = [
    { name: "Om" },
    { name: "Raj" }
];

const result = users.map(user => user);
```

The new array contains references to the same objects.

So:

```js
result[0].name = "Amit";
```

can also affect:

```js
users[0].name
```

because the object itself was not copied.

To create new objects:

```js
const result = users.map(user => ({
    ...user
}));
```

For now, remember only:

```text
new array ≠ deep copy of objects
```

---

## 8. Dry Run Practice

Try this yourself before reading the answer:

```js
const numbers = [1, 3, 5];

const result = numbers.map((num, index) => {
    return num + index;
});
```

Dry run:

```text
1 + 0 = ?

3 + 1 = ?

5 + 2 = ?
```

Final result:

```text
[1, 4, 7]
```

---

## 9. Another Dry Run

```js
const numbers = [10, 20, 30];

const result = numbers.map((num, index) => {
    return num - index;
});
```

Think:

```text
10 - 0 = ?
20 - 1 = ?
30 - 2 = ?
```

Result:

```text
[10, 19, 28]
```

---

## 10. What You Need to Remember

```text
map()
 ↓
visits each element
 ↓
calls callback
 ↓
callback returns a value
 ↓
map stores that value
 ↓
new array
```

### Part 2 checkpoint

You should now be able to explain:

```text
1. How map() processes elements
2. What the callback does
3. What element/index/array mean
4. Why return is required
5. Why the result is a new array
6. Why object references can still be shared
```

**Next → Part 3: `map()` with objects, API data, React, and real-world transformations.**

# Part 3 — `map()` with Objects, API Data & Real-world Transformations

> **Goal:** Learn how `map()` is used to transform real application data such as users, products, API responses, and nested arrays.

---

## 1. Mapping an Array of Objects

Most real-world JavaScript data is an array of objects.

```js
const users = [
    { name: "Om", age: 22 },
    { name: "Raj", age: 25 },
    { name: "Amit", age: 20 }
];

const names = users.map(user => user.name);

console.log(names);
```

Output:

```text
["Om", "Raj", "Amit"]
```

Mental model:

```text
User Object
    ↓
user.name
    ↓
Name
```

Each object is transformed into one value.

---

## 2. Creating New Objects

`map()` can transform one object into another object.

```js
const users = [
    { name: "Om", age: 22 },
    { name: "Raj", age: 25 }
];

const result = users.map(user => ({
    name: user.name,
    age: user.age
}));

console.log(result);
```

You can also use spread:

```js
const result = users.map(user => ({
    ...user,
    country: "India"
}));
```

Result:

```js
[
    { name: "Om", age: 22, country: "India" },
    { name: "Raj", age: 25, country: "India" }
]
```

This creates new top-level objects.

---

## 3. Important: `map()` Does Not Deep Clone

Consider:

```js
const users = [
    {
        name: "Om",
        address: {
            city: "Pune"
        }
    }
];

const result = users.map(user => user);
```

The new array is different, but the object reference is the same.

Conceptually:

```text
users
  ↓
[ Object A ]

result
  ↓
[ Object A ]
```

Therefore:

```js
result[0].address.city = "Mumbai";

console.log(users[0].address.city);
```

Output:

```text
Mumbai
```

Why?

Because `map()` creates a **new array**, not a deep copy of every object inside it. ([MDN Web Docs][1])

When you need a new top-level object:

```js
const result = users.map(user => ({
    ...user,
    name: user.name.toUpperCase()
}));
```

---

## 4. Transforming API Data

Suppose an API gives:

```js
const response = [
    {
        id: 1,
        username: "om123",
        email: "om@example.com"
    },
    {
        id: 2,
        username: "raj123",
        email: "raj@example.com"
    }
];
```

Your frontend may only need:

```js
const users = response.map(user => ({
    id: user.id,
    name: user.username
}));
```

Result:

```js
[
    { id: 1, name: "om123" },
    { id: 2, name: "raj123" }
]
```

Mental model:

```text
API Response
     ↓
   map()
     ↓
UI-friendly Data
```

This is a very common pattern in real applications.

---

## 5. Product Transformation

```js
const products = [
    { name: "Laptop", price: 70000 },
    { name: "Mouse", price: 1000 }
];

const prices = products.map(product => product.price);

console.log(prices);
```

Output:

```text
[70000, 1000]
```

Or create a display object:

```js
const displayProducts = products.map(product => ({
    title: product.name,
    price: `₹${product.price}`
}));
```

---

## 6. Transforming Values

`map()` is not limited to objects.

### Numbers

```js
const numbers = [1, 2, 3];

const squares = numbers.map(num => num * num);
```

### Strings

```js
const names = ["om", "raj", "amit"];

const upperNames = names.map(name => name.toUpperCase());

console.log(upperNames);
```

Output:

```text
["OM", "RAJ", "AMIT"]
```

---

## 7. Nested Arrays

You can use `map()` inside another `map()`.

```js
const matrix = [
    [1, 2],
    [3, 4]
];

const doubled = matrix.map(row =>
    row.map(value => value * 2)
);

console.log(doubled);
```

Output:

```text
[
    [2, 4],
    [6, 8]
]
```

Mental model:

```text
Matrix
  ↓
outer map()
  ↓
Each row
  ↓
inner map()
  ↓
Each value
```

You don't need to memorize this pattern now. Just recognize that `map()` can be composed.

---

## 8. `filter()` + `map()`

A very common real-world pattern is:

```text
filter → select
map    → transform
```

Example:

```js
const users = [
    { name: "Om", active: true },
    { name: "Raj", active: false },
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

Flow:

```text
All Users
   ↓
filter()
   ↓
Active Users
   ↓
map()
   ↓
Names
```

Detailed chaining will be covered in `13-Chaining.md`.

---

## 9. React Usage

The most familiar React example:

```jsx
users.map(user => (
    <UserCard
        key={user.id}
        user={user}
    />
));
```

Here:

```text
users
  ↓
map()
  ↓
one component per user
```

Another example:

```jsx
const names = users.map(user => user.name);
```

The important point is:

> React commonly uses `map()` to transform data into elements.

---

## 10. Node.js Usage

Suppose you receive database results:

```js
const users = databaseResult;
```

Create a smaller response:

```js
const response = users.map(user => ({
    id: user.id,
    name: user.name,
    email: user.email
}));
```

This is useful when you want to control what data is returned by an API.

---

## 11. Important Behavior: `map()` Keeps the Array Shape

`map()` produces a result corresponding to the processed array indices.

Example:

```js
const numbers = [1, 2, 3];

const result = numbers.map(num => num * 10);
```

Result:

```text
[10, 20, 30]
```

You should not think of `map()` as:

```text
"Find some elements"
```

Think:

```text
"Transform each existing element into another value."
```

---

## 12. Sparse Arrays — Interview Awareness

A sparse array contains empty slots:

```js
const numbers = [1, , 3];

const result = numbers.map(num => num * 2);

console.log(result);
```

Conceptually:

```text
[1, empty, 3]
       ↓
     map()
       ↓
[2, empty, 6]
```

The callback is **not called for the empty slot**. The empty slot remains empty in the result. ([MDN Web Docs][1])

You don't need to practice sparse arrays heavily. Just recognize the behavior for interview questions.

---

## 13. Array-like Objects — Awareness Only

`map()` is an Array method, but its algorithm can also operate on array-like objects when called explicitly.

Example:

```js
const data = {
    0: 10,
    1: 20,
    2: 30,
    length: 3
};

const result = Array.prototype.map.call(
    data,
    value => value * 2
);

console.log(result);
```

Output:

```text
[20, 40, 60]
```

This works because `map()` uses a `length` and integer-indexed properties. ([MDN Web Docs][1])

For normal web development, you will usually just use real arrays.

---

## 14. When `map()` Is NOT the Right Choice

### Need to select items?

Use:

```js
filter()
```

### Need one matching item?

Use:

```js
find()
```

### Need to check a condition?

Use:

```js
some()
```

or:

```js
every()
```

### Need one final result?

Use:

```js
reduce()
```

### Need only to perform an action?

Use:

```js
forEach()
```

Mental model:

```text
Transform → map()
Select    → filter()
Find one  → find()
Check     → some()/every()
Combine   → reduce()
Action    → forEach()
```

---

## 15. Hands-on Practice

Write these yourself.

### Exercise 1 — User Names

```js
const users = [
    { name: "Om", age: 22 },
    { name: "Raj", age: 25 },
    { name: "Amit", age: 21 }
];
```

Return:

```text
["Om", "Raj", "Amit"]
```

---

### Exercise 2 — Product Prices

```js
const products = [
    { name: "Laptop", price: 70000 },
    { name: "Mouse", price: 1000 },
    { name: "Keyboard", price: 2000 }
];
```

Return only the prices.

---

### Exercise 3 — Create New Objects

For every user, create:

```js
{
    name: "...",
    isAdult: true
}
```

based on age.

---

### Exercise 4 — API Transformation

Given:

```js
const users = [
    { id: 1, username: "om123", email: "om@example.com" },
    { id: 2, username: "raj123", email: "raj@example.com" }
];
```

Create:

```js
[
    { id: 1, name: "om123" },
    { id: 2, name: "raj123" }
]
```

---

### Exercise 5 — Nested Array

Transform:

```js
const matrix = [
    [1, 2],
    [3, 4]
];
```

into:

```text
[
    [10, 20],
    [30, 40]
]
```

Use nested `map()`.

---

### Exercise 6 — Filter + Map

Given:

```js
const products = [
    { name: "Laptop", price: 70000, inStock: true },
    { name: "Mouse", price: 1000, inStock: false },
    { name: "Phone", price: 30000, inStock: true }
];
```

Return the names of products that are in stock.

---

# Part 3 Checkpoint

You should now understand:

```text
[ ] map() with primitive values
[ ] map() with objects
[ ] creating new objects
[ ] API data transformation
[ ] React list rendering
[ ] Node.js response transformation
[ ] nested map()
[ ] filter() + map()
[ ] new array ≠ deep copy
[ ] sparse-array awareness
[ ] when another array method is more appropriate
```

The key idea:

> **`map()` is a data-transformation tool. One input element produces one output element.**

# Part 4 — `map()` Pitfalls, Polyfill, Interview & Project Practice

> **Goal:** Finish `map()` at the level needed for interviews, OAs, and real projects. You should be able to choose it correctly, debug it, explain its behavior, and build a basic `myMap()` implementation.

---

# 1. The Most Important Rule

Remember:

```text
map()
 ↓
Transform every processed element
 ↓
Callback returns one value
 ↓
New array
```

Example:

```js
const numbers = [1, 2, 3];

const result = numbers.map(num => num * 2);
```

Result:

```text
[2, 4, 6]
```

---

# 2. Pitfall — Forgetting `return`

Wrong:

```js
const result = [1, 2, 3].map(num => {
    num * 2;
});

console.log(result);
```

Result:

```text
[undefined, undefined, undefined]
```

Why?

```text
callback executes
      ↓
no value returned
      ↓
undefined
      ↓
undefined goes into result
```

Correct:

```js
const result = [1, 2, 3].map(num => {
    return num * 2;
});
```

Or:

```js
const result = [1, 2, 3].map(num => num * 2);
```

---

# 3. Pitfall — `map()` Is Not `filter()`

Wrong:

```js
const result = [1, 2, 3, 4].map(
    num => num % 2 === 0
);
```

Result:

```text
[false, true, false, true]
```

You transformed each number into a boolean.

If you want the matching numbers:

```js
const result = [1, 2, 3, 4].filter(
    num => num % 2 === 0
);
```

Result:

```text
[2, 4]
```

Remember:

```text
map    → transform
filter → select
```

---

# 4. Pitfall — `map()` Is Not `forEach()`

Use `map()` when you need a new array:

```js
const doubled = numbers.map(num => num * 2);
```

Use `forEach()` when you only need to perform an action:

```js
numbers.forEach(num => {
    console.log(num);
});
```

Quick rule:

```text
Need new array? → map()

Need only an action? → forEach()
```

Calling `map()` and then ignoring its returned array is generally a sign that `forEach()` or a loop is more appropriate.

---

# 5. Pitfall — `map()` Does Not Deep Clone Objects

```js
const users = [
    { name: "Om" }
];

const result = users.map(user => user);
```

Now:

```text
users[0]
   ↓
same object
   ↑
result[0]
```

So:

```js
result[0].name = "Raj";

console.log(users[0].name);
```

Output:

```text
Raj
```

If you need a new top-level object:

```js
const result = users.map(user => ({
    ...user
}));
```

Important:

> New array does not mean deep copy of nested objects.

---

# 6. Pitfall — Sparse Arrays

A sparse array can contain empty slots:

```js
const numbers = [1, , 3];
```

`map()` does not call the callback for the empty slot. The hole remains a hole in the result.

Conceptually:

```text
[1, empty, 3]
       ↓
     map()
       ↓
[2, empty, 6]
```

This is mostly an **interview-awareness point**. Don't spend time mastering sparse-array edge cases.

---

# 7. Pitfall — Changing the Original Array Inside the Callback

Avoid code like:

```js
const result = numbers.map((num, index) => {
    numbers[index] = num * 10;
    return num;
});
```

This mixes transformation with mutation and makes the code harder to reason about.

Prefer:

```js
const result = numbers.map(num => num * 10);
```

Keep the transformation focused.

---

# 8. Object Transformation Pattern

A very common project pattern:

```js
const users = [
    { id: 1, username: "om123", email: "om@example.com" },
    { id: 2, username: "raj123", email: "raj@example.com" }
];

const response = users.map(user => ({
    id: user.id,
    name: user.username
}));
```

Result:

```js
[
    { id: 1, name: "om123" },
    { id: 2, name: "raj123" }
]
```

This is useful when converting database/API data into the shape required by the frontend.

---

# 9. React Project Pattern

```jsx
const products = [
    { id: 1, name: "Laptop" },
    { id: 2, name: "Mouse" }
];

const cards = products.map(product => (
    <ProductCard
        key={product.id}
        product={product}
    />
));
```

Mental model:

```text
API / State
    ↓
map()
    ↓
React elements
    ↓
UI
```

This is one of the core patterns you will use in React.

---

# 10. Node / Express Project Pattern

Suppose a database returns:

```js
const users = await User.find();
```

You might transform it before returning it:

```js
const response = users.map(user => ({
    id: user.id,
    name: user.name,
    email: user.email
}));

res.json(response);
```

The concept is:

```text
Database data
     ↓
map()
     ↓
API response shape
```

---

# 11. Build Your Own `myMap()`

This is the most valuable implementation exercise for this topic.

## Basic version

```js
function myMap(arr, callback) {
    const result = [];

    for (let i = 0; i < arr.length; i++) {
        result.push(
            callback(arr[i], i, arr)
        );
    }

    return result;
}
```

Use it:

```js
const numbers = [1, 2, 3];

const result = myMap(
    numbers,
    num => num * 2
);

console.log(result);
```

Output:

```text
[2, 4, 6]
```

---

# 12. Understand Your `myMap()`

Don't memorize the implementation.

Understand:

```text
myMap(arr, callback)
       ↓
create result[]
       ↓
visit elements
       ↓
callback(element, index, arr)
       ↓
take returned value
       ↓
push into result
       ↓
return result
```

The important relationship is:

```text
callback
   ↓
produces one value

myMap
   ↓
collects those values
```

---

# 13. Improve `myMap()` Yourself

After understanding the basic version, try writing it **without looking**.

Requirements:

```text
[ ] accepts array
[ ] accepts callback
[ ] passes element
[ ] passes index
[ ] passes original array
[ ] creates new result array
[ ] returns result
```

Do not worry about reproducing every edge case of the ECMAScript specification. The goal here is to understand the core mechanism.

---

# 14. Interview Questions

### Q1. What does `map()` do?

It transforms the elements of an array and returns a new array containing the callback results.

### Q2. Does `map()` modify the original array?

The array itself is not modified by `map()`.

However, the callback can still mutate external data or objects, so "non-mutating method" does not mean the callback can never cause mutations.

### Q3. What arguments does the callback receive?

```text
element
index
original array
```

### Q4. What happens if the callback doesn't return?

The corresponding result is `undefined`.

### Q5. What is the time complexity?

For a normal array:

```text
O(n)
```

### Q6. What is the extra space?

A new result array is created, so approximately:

```text
O(n)
```

excluding the memory held by referenced objects.

### Q7. Can `map()` transform objects?

Yes.

```js
users.map(user => user.name);
```

### Q8. Does `map()` deep clone objects?

No.

### Q9. Why is `map()` a Higher-Order Function?

Because it accepts a callback function.

### Q10. When should you use `map()`?

When one input element should produce one corresponding output element.

---

# 15. OA Output Practice

### Question 1

```js
const result = [1, 2, 3].map(x => x * 2);

console.log(result);
```

Answer:

```text
[2, 4, 6]
```

---

### Question 2

```js
const result = [1, 2, 3].map(x => {
    x * 2;
});

console.log(result);
```

Answer:

```text
[undefined, undefined, undefined]
```

---

### Question 3

```js
const users = [
    { name: "Om" },
    { name: "Raj" }
];

const result = users.map(user => user.name);

console.log(result);
```

Answer:

```text
["Om", "Raj"]
```

---

### Question 4

```js
const users = [
    { name: "Om" }
];

const result = users.map(user => user);

result[0].name = "Raj";

console.log(users[0].name);
```

Answer:

```text
Raj
```

Reason:

```text
same object reference
```

---

### Question 5

```js
const arr = [1, , 3];

const result = arr.map(x => x * 2);

console.log(result);
```

Answer:

```text
[2, empty, 6]
```

The empty slot is not processed by the callback.

---

# 16. Hands-on Final Practice

Do these **without looking at previous parts**.

### Exercise 1

Transform:

```js
[2, 4, 6, 8]
```

into:

```text
[4, 8, 12, 16]
```

### Exercise 2

Given:

```js
const users = [
    { name: "Om", age: 22 },
    { name: "Raj", age: 25 }
];
```

Return only the names.

### Exercise 3

Create a new object for every user with:

```js
{
    name,
    isAdult
}
```

### Exercise 4

Transform API data into a smaller response object.

### Exercise 5

Create a React-style list using `map()`.

### Exercise 6

Write `myMap()` completely from memory.

### Exercise 7 — Explain

Without looking at your notes, explain:

```text
Why does map() return a new array?
Why is return important?
Why doesn't map() deep-copy objects?
When should map() not be used?
```

---

# 17. Project-Level Challenge

Build this small transformation:

```js
const products = [
    {
        id: 1,
        name: "Laptop",
        price: 70000,
        inStock: true
    },
    {
        id: 2,
        name: "Mouse",
        price: 1000,
        inStock: false
    },
    {
        id: 3,
        name: "Keyboard",
        price: 2500,
        inStock: true
    }
];
```

Create a UI-ready array containing:

```js
[
    {
        id: 1,
        title: "Laptop",
        displayPrice: "₹70000"
    },
    ...
]
```

Use `map()`.

Then create only the names of products that are in stock using:

```text
filter()
+
map()
```

This is the kind of transformation you will actually perform in a MERN application.

---

# 18. Final `map()` Mental Model

```text
                    map()
                      ↓
               every element
                      ↓
                  callback
                      ↓
               return value
                      ↓
               new result[]
```

### Method Selection

```text
Transform every element
        ↓
      map()

Keep matching elements
        ↓
     filter()

Find first matching element
        ↓
      find()

Check at least one
        ↓
      some()

Check all
        ↓
      every()

Combine into one result
        ↓
      reduce()
```

---

# 19. Completion Checklist

Before moving to `filter()`, you should be able to:

* [ ] Explain `map()` in your own words.
* [ ] Use `map()` without notes.
* [ ] Explain the callback.
* [ ] Explain `element`, `index`, and `array`.
* [ ] Dry-run a `map()` call.
* [ ] Explain why missing `return` produces `undefined`.
* [ ] Transform arrays of objects.
* [ ] Transform API data.
* [ ] Use `map()` in a React-style list.
* [ ] Know `map()` vs `filter()` vs `forEach()`.
* [ ] Understand object-reference behavior.
* [ ] Know the basic sparse-array behavior.
* [ ] Implement `myMap()` from memory.
* [ ] Solve the project challenge.

---

# Final Takeaway

You do **not** need to memorize `map()`.

You need to understand this:

```text
map()
 ↓
takes an array
 ↓
runs a callback for each assigned element
 ↓
callback returns one value
 ↓
those values form a new array
```

That is enough to **use `map()` confidently in projects, answer common interview/OA questions, and implement a basic polyfill**.

`map()` is now complete. ✅

**Next → `03-filter.md`**
