# Part 1 — What Are Array Methods?

> **Array methods are built-in JavaScript functions that help us work with arrays in a shorter and cleaner way.**

You only need the **basic foundation here**. Detailed learning of each method is already covered in `02-Functional-JavaScript`.

---

## 1. Basic Idea

An array:

```js
const numbers = [10, 20, 30];
```

Traditional approach:

```js
for (let i = 0; i < numbers.length; i++) {
    console.log(numbers[i]);
}
```

Modern JavaScript:

```js
numbers.forEach(num => {
    console.log(num);
});
```

Both work, but array methods make common operations easier to express.

---

## 2. Important Array Methods

For now, understand **what each method is generally used for**:

| Method        | Basic Purpose                     |
| ------------- | --------------------------------- |
| `forEach()`   | Do something for each element     |
| `map()`       | Create a transformed array        |
| `filter()`    | Select matching elements          |
| `find()`      | Find the first matching element   |
| `findIndex()` | Find the index of the first match |
| `some()`      | Check if at least one matches     |
| `every()`     | Check if all match                |
| `reduce()`    | Combine values into one result    |
| `sort()`      | Sort an array                     |
| `reverse()`   | Reverse an array                  |
| `includes()`  | Check whether a value exists      |
| `indexOf()`   | Find the index of a value         |
| `flat()`      | Flatten nested arrays             |
| `flatMap()`   | Map and flatten one level         |

---

## 3. Simple Mental Map

```text
Array
  │
  ├── Do something
  │     └── forEach()
  │
  ├── Transform
  │     └── map()
  │
  ├── Select
  │     └── filter()
  │
  ├── Find
  │     ├── find()
  │     └── findIndex()
  │
  ├── Check
  │     ├── some()
  │     └── every()
  │
  ├── Combine
  │     └── reduce()
  │
  └── Modify / Inspect
        ├── sort()
        ├── reverse()
        ├── includes()
        └── indexOf()
```

---

## 4. One Basic Example

```js
const numbers = [1, 2, 3, 4];

const doubled = numbers.map(num => num * 2);

console.log(doubled);
```

Output:

```text
[2, 4, 6, 8]
```

Here:

```text
numbers
   ↓
map()
   ↓
each number × 2
   ↓
[2, 4, 6, 8]
```

---

## 5. What You Need to Remember

```text
forEach() → Do something
map()     → Transform
filter()  → Select
find()    → Find one
some()    → At least one?
every()   → All?
reduce()  → One final result
```
# Part 2 — Why Array Methods?

Array methods make common array operations **shorter, cleaner, and easier to read**.

### 1. Traditional Approach

```js
const numbers = [1, 2, 3, 4];

const doubled = [];

for (let i = 0; i < numbers.length; i++) {
    doubled.push(numbers[i] * 2);
}

console.log(doubled);
```

Output:

```text
[2, 4, 6, 8]
```

### 2. Modern JavaScript

The same task can be written using `map()`:

```js
const numbers = [1, 2, 3, 4];

const doubled = numbers.map(num => num * 2);

console.log(doubled);
```

Output:

```text
[2, 4, 6, 8]
```

### 3. Why Use Them?

Array methods provide:

* **Less code**
* **Better readability**
* **Cleaner logic**
* **Reusable patterns**
* Common syntax used in **React, Node.js and modern JavaScript**

### 4. The Important Idea

Most array methods work by receiving a **callback function**.

```js
numbers.map(num => num * 2);
```

Think:

```text
numbers
   ↓
array method
   ↓
callback
   ↓
each element is processed
   ↓
result
```

You don't need to master callbacks here. They are studied more deeply in your **Functional JavaScript** section.

### 5. Method Selection

When you see an array problem, first ask:

```text
"What do I want to do?"
```

```text
Do something       → forEach()

Transform           → map()

Select              → filter()

Find one            → find()

Find position       → findIndex()

At least one?       → some()

All?                → every()

Combine             → reduce()
```

### 6. Basic Practice

Write these **yourself**:

**Exercise 1**

```js
const numbers = [1, 2, 3, 4, 5];
```

Create a new array containing every number multiplied by `2`.

**Exercise 2**

```js
const numbers = [10, 15, 20, 25, 30];
```

Create a new array containing only even numbers.

**Exercise 3**

```js
const users = [
    { name: "Om", age: 22 },
    { name: "Rahul", age: 25 }
];
```

Create an array containing only the users' names.

**Exercise 4**

```js
const numbers = [10, 20, 30, 40];
```

Check whether at least one number is greater than `35`.

**Exercise 5**

```js
const numbers = [10, 20, 30, 40];
```

Calculate the total.

# Part 3 — Mutating vs Non-Mutating Array Methods

> **Goal:** Understand only the basic difference. Detailed behavior will be covered later in `02-Functional-JavaScript`.

## 1. What Does Mutating Mean?

**Mutate means changing the original array.**

Example:

```js
const numbers = [1, 2, 3];

numbers.reverse();

console.log(numbers);
```

Output:

```text
[3, 2, 1]
```

The original array changed.

---

## 2. Non-Mutating Methods

These methods **do not change the original array**.

Common examples:

```text
map()
filter()
find()
findIndex()
some()
every()
reduce()
includes()
indexOf()
flat()
flatMap()
```

Example:

```js
const numbers = [1, 2, 3];

const doubled = numbers.map(num => num * 2);

console.log(numbers);
console.log(doubled);
```

Output:

```text
[1, 2, 3]
[2, 4, 6]
```

So:

```text
Original → unchanged
Result   → new result/value
```

---

## 3. Mutating Methods

These methods can change the original array:

```text
push()
pop()
shift()
unshift()
splice()
sort()
reverse()
```

Example:

```js
const numbers = [1, 2, 3];

numbers.push(4);

console.log(numbers);
```

Output:

```text
[1, 2, 3, 4]
```

---

## 4. Easy Mental Model

```text
NON-MUTATING
      ↓
Original array stays unchanged
```

```text
MUTATING
      ↓
Original array changes
```

---

## 5. Why This Matters

This concept becomes especially important in **React**, where we generally avoid directly modifying state arrays.

Instead of:

```js
users.push(newUser); // ❌
```

we commonly create a new array:

```js
const updatedUsers = [...users, newUser];
```

You'll use this concept much more when learning React.

---

## 6. Quick Reference

| Method        | Mutates Original? |
| ------------- | ----------------- |
| `map()`       | ❌                 |
| `filter()`    | ❌                 |
| `find()`      | ❌                 |
| `findIndex()` | ❌                 |
| `some()`      | ❌                 |
| `every()`     | ❌                 |
| `reduce()`    | ❌                 |
| `includes()`  | ❌                 |
| `indexOf()`   | ❌                 |
| `flat()`      | ❌                 |
| `flatMap()`   | ❌                 |
| `push()`      | ✅                 |
| `pop()`       | ✅                 |
| `shift()`     | ✅                 |
| `unshift()`   | ✅                 |
| `splice()`    | ✅                 |
| `sort()`      | ✅                 |
| `reverse()`   | ✅                 |

---

## 7. Hands-on Practice

### Exercise 1

Predict the output:

```js
const numbers = [1, 2, 3];

const result = numbers.map(num => num * 2);

console.log(numbers);
console.log(result);
```

### Exercise 2

Predict the output:

```js
const numbers = [1, 2, 3];

numbers.push(4);

console.log(numbers);
```

### Exercise 3

Does the original array change?

```js
const numbers = [1, 2, 3];

const result = numbers.filter(num => num > 1);
```

### Exercise 4

Does the original array change?

```js
const numbers = [3, 1, 2];

numbers.sort((a, b) => a - b);
```

### Exercise 5

Write:

```text
1 non-mutating method
1 mutating method
```

### Remember

> **Non-mutating → original stays unchanged.**
> **Mutating → original array changes.**

# Part 4 — `forEach()`

> **Goal:** Understand the basic purpose of `forEach()`. Detailed `forEach()` mastery, callback behavior, patterns, and extensive practice belong in `02-Functional-JavaScript`.

## 1. What is `forEach()`?

`forEach()` executes a function once for every element in an array.

```js
const numbers = [10, 20, 30];

numbers.forEach(num => {
    console.log(num);
});
```

Output:

```text
10
20
30
```

### Mental Model

```text
[10, 20, 30]
     ↓
  forEach()
     ↓
process every element
```

---

## 2. Basic Syntax

```js
array.forEach(callback);
```

Example:

```js
const fruits = ["Apple", "Banana", "Mango"];

fruits.forEach(fruit => {
    console.log(fruit);
});
```

---

## 3. Using the Index

The callback can also receive the element's index.

```js
const fruits = ["Apple", "Banana", "Mango"];

fruits.forEach((fruit, index) => {
    console.log(index, fruit);
});
```

Output:

```text
0 Apple
1 Banana
2 Mango
```

For now, remember:

```text
element → current value
index   → current position
```

---

## 4. Return Value

`forEach()` returns `undefined`.

```js
const numbers = [1, 2, 3];

const result = numbers.forEach(num => {
    console.log(num);
});

console.log(result);
```

Output:

```text
1
2
3
undefined
```

Therefore:

```text
forEach()
   ↓
perform an action
   ↓
returns undefined
```

If you need to create a **new transformed array**, use `map()` instead.

---

## 5. `forEach()` vs `map()`

```text
forEach()
   ↓
Perform an action

map()
   ↓
Create a new array
```

Example:

```js
numbers.forEach(num => {
    console.log(num);
});
```

vs.

```js
const doubled = numbers.map(num => num * 2);
```

---

## 6. Hands-on Practice

Write the code yourself.

### Exercise 1

```js
const numbers = [10, 20, 30, 40, 50];
```

Print every number using `forEach()`.

### Exercise 2

```js
const numbers = [1, 2, 3, 4, 5];
```

Print every number multiplied by `2`.

### Exercise 3

```js
const fruits = ["Apple", "Banana", "Mango"];
```

Print each fruit with its index.

Expected:

```text
0 Apple
1 Banana
2 Mango
```

### Exercise 4

Predict the output:

```js
const numbers = [1, 2, 3];

const result = numbers.forEach(num => {
    return num * 2;
});

console.log(result);
```

### Exercise 5

```js
const users = [
    { name: "Om", age: 22 },
    { name: "Rahul", age: 24 },
    { name: "Amit", age: 21 }
];
```

Use `forEach()` to print only the names.

---

### Remember

```text
forEach()
   ↓
Visits every element
   ↓
Runs a callback
   ↓
Used mainly for side effects/actions
   ↓
Returns undefined
```
# Part 5 — `map()`

> **Goal:** Understand the basic purpose of `map()`. Detailed `map()` mastery, callback behavior, dry runs, patterns, and extensive practice belong in `02-Functional-JavaScript`.

## 1. What is `map()`?

`map()` is used to **transform every element of an array** and create a **new array**.

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

Example:

```js
const numbers = [10, 20, 30];

const result = numbers.map(num => num + 5);

console.log(result);
```

Output:

```text
[15, 25, 35]
```

---

## 3. `map()` Returns a New Array

The original array remains unchanged.

```js
const numbers = [1, 2, 3];

const doubled = numbers.map(num => num * 2);

console.log(numbers);
console.log(doubled);
```

Output:

```text
[1, 2, 3]
[2, 4, 6]
```

Think:

```text
Original
[1, 2, 3]
   ↓
 map()
   ↓
New Array
[2, 4, 6]
```

---

## 4. `map()` with Objects

`map()` is very common when working with objects.

```js
const users = [
    { name: "Om", age: 22 },
    { name: "Rahul", age: 24 },
    { name: "Amit", age: 21 }
];

const names = users.map(user => user.name);

console.log(names);
```

Output:

```text
["Om", "Rahul", "Amit"]
```

---

## 5. `map()` vs `forEach()`

This is important:

```text
forEach()
   ↓
Perform an action
   ↓
Returns undefined
```

```text
map()
   ↓
Transform elements
   ↓
Returns a new array
```

Example:

```js
numbers.forEach(num => {
    console.log(num * 2);
});
```

vs.

```js
const doubled = numbers.map(num => num * 2);
```

### Rule

> **If you need a new array → think `map()`.**

---

## 6. Common Mistake

Don't forget to return the transformed value when using a block body.

❌ Wrong:

```js
const numbers = [1, 2, 3];

const doubled = numbers.map(num => {
    num * 2;
});

console.log(doubled);
```

Output:

```text
[undefined, undefined, undefined]
```

✅ Correct:

```js
const doubled = numbers.map(num => {
    return num * 2;
});
```

Or:

```js
const doubled = numbers.map(num => num * 2);
```

---

## 7. Hands-on Practice

**Write these yourself. Don't copy the solution.**

### Exercise 1

```js
const numbers = [1, 2, 3, 4, 5];
```

Create:

```text
[2, 4, 6, 8, 10]
```

using `map()`.

---

### Exercise 2

```js
const numbers = [10, 20, 30, 40];
```

Create an array where every number is increased by `5`.

Expected:

```text
[15, 25, 35, 45]
```

---

### Exercise 3

```js
const numbers = [2, 3, 4, 5];
```

Create an array containing the square of every number.

Expected:

```text
[4, 9, 16, 25]
```

---

### Exercise 4

```js
const users = [
    { name: "Om", age: 22 },
    { name: "Rahul", age: 24 },
    { name: "Amit", age: 21 }
];
```

Create:

```text
["Om", "Rahul", "Amit"]
```

---

### Exercise 5 — Predict Output

```js
const numbers = [1, 2, 3];

const result = numbers.map(num => num * 3);

console.log(numbers);
console.log(result);
```

What will be printed?

---

### Exercise 6 — Important

What is wrong with this code?

```js
const numbers = [1, 2, 3];

const result = numbers.map(num => {
    num + 10;
});

console.log(result);
```

---

### Remember

```text
map()
  ↓
Visit every element
  ↓
Transform each element
  ↓
Return the transformed value
  ↓
New array
```
# Part 6 — `filter()`

> **Goal:** Understand the basic purpose of `filter()`. Detailed `filter()` mastery, callback behavior, dry runs, patterns, and extensive practice belong in `02-Functional-JavaScript`.

## 1. What is `filter()`?

`filter()` is used to **select elements that satisfy a condition**.

It returns a **new array**.

```js
const numbers = [1, 2, 3, 4, 5];

const even = numbers.filter(num => num % 2 === 0);

console.log(even);
```

Output:

```text
[2, 4]
```

Mental model:

```text
[1, 2, 3, 4, 5]
        ↓
     filter()
        ↓
  Does it match?
        ↓
   1 ❌  2 ✅  3 ❌  4 ✅  5 ❌
        ↓
      [2, 4]
```

---

## 2. Basic Syntax

```js
const result = array.filter(callback);
```

The callback should return a condition:

```js
const result = numbers.filter(num => num > 10);
```

If the condition is:

```text
true  → keep element
false → remove element
```

---

## 3. Original Array Is Not Changed

```js
const numbers = [1, 2, 3, 4];

const result = numbers.filter(num => num > 2);

console.log(numbers);
console.log(result);
```

Output:

```text
[1, 2, 3, 4]
[3, 4]
```

Think:

```text
Original
[1, 2, 3, 4]
     ↓
   filter()
     ↓
New Array
[3, 4]
```

---

## 4. Filtering Objects

Very common in real applications.

```js
const users = [
    { name: "Om", age: 22 },
    { name: "Rahul", age: 17 },
    { name: "Amit", age: 25 }
];

const adults = users.filter(user => user.age >= 18);

console.log(adults);
```

Result:

```js
[
    { name: "Om", age: 22 },
    { name: "Amit", age: 25 }
]
```

---

## 5. `filter()` vs `find()`

This distinction is important.

```text
filter()
   ↓
Returns ALL matching elements
   ↓
New Array
```

```text
find()
   ↓
Returns FIRST matching element
   ↓
Single value
```

Example:

```js
const numbers = [10, 20, 20, 30];

numbers.filter(num => num === 20);
// [20, 20]

numbers.find(num => num === 20);
// 20
```

### Rule

> **Need all matches → `filter()`**
> **Need the first match → `find()`**

---

## 6. Common Mistake

`filter()` should return a condition.

❌ Wrong:

```js
const result = numbers.filter(num => {
    num > 10;
});
```

Because nothing is returned.

✅ Correct:

```js
const result = numbers.filter(num => {
    return num > 10;
});
```

Or:

```js
const result = numbers.filter(num => num > 10);
```

---

# 7. Hands-on Practice

**Write these yourself. Don't copy the solution.**

### Exercise 1 — Even Numbers

```js
const numbers = [1, 2, 3, 4, 5, 6];
```

Return only even numbers.

Expected:

```text
[2, 4, 6]
```

---

### Exercise 2 — Greater Than 50

```js
const numbers = [20, 60, 40, 80, 10, 90];
```

Return numbers greater than `50`.

Expected:

```text
[60, 80, 90]
```

---

### Exercise 3 — Adults

```js
const users = [
    { name: "Om", age: 22 },
    { name: "Rahul", age: 17 },
    { name: "Amit", age: 25 },
    { name: "Raj", age: 16 }
];
```

Return users whose age is `18` or above.

---

### Exercise 4 — Products

```js
const products = [
    { name: "Laptop", price: 70000 },
    { name: "Mouse", price: 500 },
    { name: "Keyboard", price: 1500 },
    { name: "Monitor", price: 12000 }
];
```

Return products whose price is greater than `5000`.

---

### Exercise 5 — Predict Output

```js
const numbers = [1, 2, 3, 4, 5];

const result = numbers.filter(num => num % 2 === 0);

console.log(numbers);
console.log(result);
```

What will be printed?

---

### Exercise 6 — Important

What is wrong here?

```js
const numbers = [10, 20, 30];

const result = numbers.filter(num => {
    num > 15;
});

console.log(result);
```

---

### Remember

```text
filter()
   ↓
Check every element
   ↓
Condition
   ↓
true  → keep
false → remove
   ↓
New array
```
# Part 7 — `find()` + `findIndex()`

> **Goal:** Learn the basic purpose and difference. Detailed patterns and problem-solving belong in `02-Functional-JavaScript`.

## 1. `find()`

`find()` returns the **first element** that satisfies a condition.

```js
const numbers = [10, 20, 30, 40];

const result = numbers.find(num => num > 20);

console.log(result);
```

Output:

```text
30
```

Mental model:

```text
[10, 20, 30, 40]
       ↓
     find()
       ↓
10 → false
20 → false
30 → true ✅
       ↓
      30
```

Once it finds the first match, it stops searching.

---

## 2. If Nothing Is Found

```js
const numbers = [10, 20, 30];

const result = numbers.find(num => num > 100);

console.log(result);
```

Output:

```text
undefined
```

So:

```text
Match found     → element
No match        → undefined
```

---

## 3. `find()` with Objects

Very common with API data.

```js
const users = [
    { id: 1, name: "Om" },
    { id: 2, name: "Rahul" },
    { id: 3, name: "Amit" }
];

const user = users.find(user => user.id === 2);

console.log(user);
```

Output:

```js
{
    id: 2,
    name: "Rahul"
}
```

---

# 4. `findIndex()`

`findIndex()` returns the **index of the first element** that satisfies a condition.

```js
const numbers = [10, 20, 30, 40];

const index = numbers.findIndex(num => num > 20);

console.log(index);
```

Output:

```text
2
```

Because:

```text
Index:   0    1    2    3
Value:  10   20   30   40
                  ↑
                match
```

---

## 5. If Nothing Is Found

```js
const numbers = [10, 20, 30];

const index = numbers.findIndex(num => num > 100);

console.log(index);
```

Output:

```text
-1
```

So:

```text
Match found     → index
No match        → -1
```

---

# 6. `find()` vs `findIndex()`

| Method        | Returns                         |
| ------------- | ------------------------------- |
| `find()`      | First matching element          |
| `findIndex()` | Index of first matching element |

Example:

```js
const numbers = [10, 20, 30, 40];

numbers.find(num => num > 20);
// 30

numbers.findIndex(num => num > 20);
// 2
```

### Easy Rule

```text
Need the VALUE?
       ↓
     find()

Need the POSITION?
       ↓
  findIndex()
```

---

# 7. `find()` vs `filter()`

Important distinction:

```text
find()
  ↓
First match
  ↓
Single value
```

```text
filter()
  ↓
All matches
  ↓
New array
```

Example:

```js
const numbers = [10, 20, 20, 30];

numbers.find(num => num === 20);
// 20

numbers.filter(num => num === 20);
// [20, 20]
```

---

# 8. Hands-on Practice

### Exercise 1

```js
const numbers = [5, 10, 15, 20, 25];
```

Find the first number greater than `12`.

---

### Exercise 2

```js
const numbers = [5, 10, 15, 20, 25];
```

Find the index of the first number greater than `12`.

---

### Exercise 3

```js
const users = [
    { id: 1, name: "Om" },
    { id: 2, name: "Rahul" },
    { id: 3, name: "Amit" }
];
```

Find the user whose `id` is `3`.

---

### Exercise 4

Using the same `users` array, find the **index** of the user whose `id` is `3`.

---

### Exercise 5 — Predict Output

```js
const numbers = [10, 20, 30];

console.log(numbers.find(num => num > 100));
```

---

### Exercise 6 — Predict Output

```js
const numbers = [10, 20, 30];

console.log(numbers.findIndex(num => num > 100));
```

---

### Remember

```text
find()
   ↓
First matching VALUE
   ↓
not found → undefined


findIndex()
   ↓
First matching INDEX
   ↓
not found → -1
```
# Part 8 — `some()` + `every()`

> **Goal:** Learn the basic purpose and difference. Detailed functional patterns and practice belong in `02-Functional-JavaScript`.

## 1. `some()`

`some()` checks whether **at least one** element satisfies a condition.

It returns a **boolean**:

```text
true
false
```

Example:

```js
const numbers = [1, 3, 5, 8];

const result = numbers.some(num => num % 2 === 0);

console.log(result);
```

Output:

```text
true
```

Because `8` is even.

Mental model:

```text
[1, 3, 5, 8]
      ↓
   some()
      ↓
Is at least ONE true?
      ↓
      YES
      ↓
     true
```

---

## 2. If Nothing Matches

```js
const numbers = [1, 3, 5, 7];

const result = numbers.some(num => num % 2 === 0);

console.log(result);
```

Output:

```text
false
```

Because there is no even number.

---

# 3. `every()`

`every()` checks whether **all elements** satisfy a condition.

It also returns:

```text
true
false
```

Example:

```js
const numbers = [2, 4, 6, 8];

const result = numbers.every(num => num % 2 === 0);

console.log(result);
```

Output:

```text
true
```

Every number is even.

Mental model:

```text
[2, 4, 6, 8]
      ↓
   every()
      ↓
Are ALL true?
      ↓
     YES
      ↓
    true
```

---

## 4. If One Element Fails

```js
const numbers = [2, 4, 6, 7];

const result = numbers.every(num => num % 2 === 0);

console.log(result);
```

Output:

```text
false
```

Because `7` is not even.

---

# 5. `some()` vs `every()`

This is the main thing to remember:

| Method    | Question                     |
| --------- | ---------------------------- |
| `some()`  | **Does at least one match?** |
| `every()` | **Do all match?**            |

Example:

```js
const numbers = [2, 4, 6, 7];
```

```js
numbers.some(num => num % 2 !== 0);
// true
```

Because `7` is odd.

```js
numbers.every(num => num % 2 === 0);
// false
```

Because `7` is not even.

---

# 6. Real-World Example

### `some()`

Check whether a cart contains an expensive product:

```js
const products = [
    { name: "Mouse", price: 500 },
    { name: "Laptop", price: 70000 },
    { name: "Keyboard", price: 1500 }
];

const hasExpensiveProduct =
    products.some(product => product.price > 50000);

console.log(hasExpensiveProduct);
```

Output:

```text
true
```

---

### `every()`

Check whether all products are in stock:

```js
const products = [
    { name: "Mouse", inStock: true },
    { name: "Laptop", inStock: true },
    { name: "Keyboard", inStock: true }
];

const allAvailable =
    products.every(product => product.inStock);

console.log(allAvailable);
```

Output:

```text
true
```

---

# 7. Important Difference from `find()`

```text
some()
   ↓
Returns true / false


every()
   ↓
Returns true / false


find()
   ↓
Returns an element


findIndex()
   ↓
Returns an index
```

---

# 8. Hands-on Practice

### Exercise 1

```js
const numbers = [10, 20, 30, 45];
```

Check whether **at least one** number is greater than `40`.

---

### Exercise 2

```js
const numbers = [2, 4, 6, 8];
```

Check whether **every** number is even.

---

### Exercise 3

```js
const numbers = [2, 4, 7, 8];
```

Check whether at least one number is odd.

---

### Exercise 4

```js
const users = [
    { name: "Om", age: 22 },
    { name: "Rahul", age: 25 },
    { name: "Amit", age: 17 }
];
```

Check whether **at least one user is under 18**.

---

### Exercise 5

Using the same `users` array, check whether **every user is 18 or older**.

---

### Exercise 6 — Predict Output

```js
const numbers = [2, 4, 6];

console.log(numbers.some(num => num > 10));
console.log(numbers.every(num => num > 10));
```

---

### Remember

```text
some()
  ↓
At least ONE?
  ↓
true / false
```

```text
every()
  ↓
ALL?
  ↓
true / false
```
# Part 9 — `reduce()`

> **Goal:** Learn the basic purpose of `reduce()`. Detailed accumulator behavior, dry runs, patterns, and extensive practice belong in `02-Functional-JavaScript`.

## 1. What is `reduce()`?

`reduce()` processes an array and **reduces it to one final result**.

That result can be:

* a number
* a string
* an object
* an array
* or another value

The most basic example is calculating a sum:

```js
const numbers = [1, 2, 3, 4];

const sum = numbers.reduce(
    (total, current) => total + current,
    0
);

console.log(sum);
```

Output:

```text
10
```

Mental model:

```text
[1, 2, 3, 4]
      ↓
   reduce()
      ↓
   one result
      ↓
      10
```

---

## 2. Basic Syntax

```js
const result = array.reduce(callback, initialValue);
```

For example:

```js
const numbers = [10, 20, 30];

const total = numbers.reduce(
    (sum, number) => sum + number,
    0
);

console.log(total);
```

Output:

```text
60
```

---

## 3. The Accumulator

The first parameter usually represents the **accumulated result**.

```js
numbers.reduce((total, current) => {
    return total + current;
}, 0);
```

Here:

```text
total   → accumulated result
current → current array element
0       → initial value
```

Think:

```text
initial
   ↓
  0
   ↓ + 1
  1
   ↓ + 2
  3
   ↓ + 3
  6
   ↓ + 4
 10
```

---

## 4. `reduce()` Can Do More Than Sum

### Calculate Product

```js
const numbers = [2, 3, 4];

const product = numbers.reduce(
    (result, num) => result * num,
    1
);

console.log(product);
```

Output:

```text
24
```

---

### Find Maximum

```js
const numbers = [10, 50, 20, 80, 30];

const maximum = numbers.reduce(
    (max, num) => Math.max(max, num),
    numbers[0]
);

console.log(maximum);
```

Output:

```text
80
```

These are just examples here. The deeper problem-solving patterns belong in Functional JavaScript.

---

## 5. `reduce()` vs `map()`

```text
map()
 ↓
Array → New Array
```

```text
reduce()
 ↓
Array → One final result
```

Example:

```js
const numbers = [1, 2, 3];

const doubled = numbers.map(num => num * 2);
// [2, 4, 6]
```

```js
const sum = numbers.reduce(
    (total, num) => total + num,
    0
);
// 6
```

### Easy Rule

> **Need a transformed array → `map()`**
> **Need one final result → `reduce()`**

---

## 6. Original Array

`reduce()` does not modify the original array.

```js
const numbers = [1, 2, 3];

const sum = numbers.reduce(
    (total, num) => total + num,
    0
);

console.log(numbers);
console.log(sum);
```

Output:

```text
[1, 2, 3]
6
```

---

# 7. Hands-on Practice

**Write these yourself.**

### Exercise 1 — Sum

```js
const numbers = [10, 20, 30, 40];
```

Calculate:

```text
100
```

using `reduce()`.

---

### Exercise 2 — Product

```js
const numbers = [2, 3, 4];
```

Calculate:

```text
24
```

---

### Exercise 3 — Maximum

```js
const numbers = [10, 50, 20, 90, 30];
```

Find the maximum using `reduce()`.

---

### Exercise 4 — Cart Total

```js
const cart = [
    { name: "Mouse", price: 500 },
    { name: "Keyboard", price: 1500 },
    { name: "Monitor", price: 12000 }
];
```

Calculate the total price using `reduce()`.

Expected:

```text
14000
```

---

### Exercise 5 — Predict Output

```js
const numbers = [1, 2, 3, 4];

const result = numbers.reduce(
    (total, num) => total + num,
    0
);

console.log(result);
```

---

### Exercise 6 — Dry Run Yourself

For:

```js
const numbers = [2, 4, 6];

const result = numbers.reduce(
    (total, num) => total + num,
    0
);
```

Write the accumulator after each step:

```text
Initial → ?

After 2 → ?

After 4 → ?

After 6 → ?
```

---

## Remember

```text
reduce()
    ↓
Process array
    ↓
Keep accumulated result
    ↓
Continue through elements
    ↓
One final result
```

### Quick Mental Map

```text
forEach() → Do something
map()     → Transform
filter()  → Select
find()    → Find one
some()    → At least one?
every()   → All?
reduce()  → Combine into one result
```
# Part 10 — Other Array Methods + Chaining Overview

> **Goal:** Know the remaining important methods at a high level. Detailed mastery belongs in `02-Functional-JavaScript`.

## 1. `sort()`

Used to sort an array.

```js
const numbers = [30, 10, 20];

numbers.sort((a, b) => a - b);

console.log(numbers);
```

Output:

```text
[10, 20, 30]
```

⚠️ `sort()` **mutates the original array**.

---

## 2. `reverse()`

Reverses the array.

```js
const numbers = [1, 2, 3];

numbers.reverse();

console.log(numbers);
```

Output:

```text
[3, 2, 1]
```

⚠️ `reverse()` **mutates the original array**.

---

## 3. `includes()`

Checks whether an array contains a value.

```js
const fruits = ["Apple", "Banana", "Mango"];

console.log(fruits.includes("Banana"));
```

Output:

```text
true
```

Returns:

```text
true / false
```

---

## 4. `indexOf()`

Returns the index of a value.

```js
const fruits = ["Apple", "Banana", "Mango"];

console.log(fruits.indexOf("Banana"));
```

Output:

```text
1
```

If the value doesn't exist:

```text
-1
```

---

## 5. `flat()`

Flattens nested arrays.

```js
const numbers = [1, [2, 3], [4, 5]];

const result = numbers.flat();

console.log(result);
```

Output:

```text
[1, 2, 3, 4, 5]
```

---

## 6. `flatMap()`

Combines:

```text
map()
+
flat(1)
```

Example:

```js
const words = ["hello world"];

const result = words.flatMap(word => word.split(" "));

console.log(result);
```

Output:

```text
["hello", "world"]
```

---

# 7. Method Chaining

Array methods can be connected together.

Example:

```js
const numbers = [1, 2, 3, 4, 5];

const result = numbers
    .filter(num => num % 2 === 0)
    .map(num => num * 10);

console.log(result);
```

Output:

```text
[20, 40]
```

Flow:

```text
[1, 2, 3, 4, 5]
        ↓
     filter()
        ↓
     [2, 4]
        ↓
      map()
        ↓
    [20, 40]
```

### Mental Model

```text
Array
  ↓
Method 1
  ↓
Result
  ↓
Method 2
  ↓
Result
```

Chaining is extremely common in modern JavaScript and React.

---

# 8. Quick Reference

| Method        | Basic Purpose       | Mutates? |
| ------------- | ------------------- | -------- |
| `forEach()`   | Perform action      | ❌        |
| `map()`       | Transform           | ❌        |
| `filter()`    | Select              | ❌        |
| `find()`      | Find first value    | ❌        |
| `findIndex()` | Find first index    | ❌        |
| `some()`      | At least one?       | ❌        |
| `every()`     | All?                | ❌        |
| `reduce()`    | One final result    | ❌        |
| `sort()`      | Sort                | ✅        |
| `reverse()`   | Reverse             | ✅        |
| `includes()`  | Check value         | ❌        |
| `indexOf()`   | Find index          | ❌        |
| `flat()`      | Flatten             | ❌        |
| `flatMap()`   | Transform + flatten | ❌        |

---

# 9. Basic Selection Guide

When you have an array problem:

```text
Do something?
    → forEach()

Transform every item?
    → map()

Keep matching items?
    → filter()

Need one matching item?
    → find()

Need its position?
    → findIndex()

Need to know if ANY matches?
    → some()

Need to know if ALL match?
    → every()

Need one final result?
    → reduce()

Need to check a value?
    → includes()

Need an index?
    → indexOf()

Need sorting?
    → sort()

Need reversing?
    → reverse()
```

---

# 10. Hands-on Practice

### Exercise 1

```js
const numbers = [30, 10, 20];
```

Sort the numbers in ascending order.

---

### Exercise 2

```js
const fruits = ["Apple", "Banana", "Mango"];
```

Check whether `"Mango"` exists.

---

### Exercise 3

```js
const numbers = [1, [2, 3], [4, 5]];
```

Flatten the array.

---

### Exercise 4

Predict the output:

```js
const numbers = [1, 2, 3, 4, 5];

const result = numbers
    .filter(num => num > 2)
    .map(num => num * 2);

console.log(result);
```

---

### Exercise 5

Identify the correct method:

```text
1. Get all products above ₹5000
2. Get one user by ID
3. Check if any user is an admin
4. Calculate total cart price
5. Create an array of product names
6. Check if every product is in stock
```

---

## Final Mental Map

```text
             ARRAY
               │
     ┌─────────┼─────────┐
     ↓         ↓         ↓
  ACTION    TRANSFORM   SELECT
 forEach()   map()     filter()
                         │
                         ↓
                      FIND
                  find/findIndex
                         │
                         ↓
                      CHECK
                  some/every
                         │
                         ↓
                     COMBINE
                     reduce()
```

**Part 1 — Array Methods is now complete. ✅**

The next step is **not more theory here**. Your `02-Functional-JavaScript` folder should now be used for **deep mastery + hands-on coding + dry runs + patterns + interview problems**.
