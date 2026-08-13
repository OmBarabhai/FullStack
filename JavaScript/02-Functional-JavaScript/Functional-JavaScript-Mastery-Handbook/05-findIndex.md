# `findIndex()`

> **`findIndex()` returns the index of the first element that satisfies a condition. If no element matches, it returns `-1`.**

# Part 1 — Fundamentals

## 1. What is `findIndex()`?

Use `findIndex()` when you need the **position** of the first matching element.

```js
const numbers = [10, 25, 30, 15, 40];

const index = numbers.findIndex(
    num => num > 20
);

console.log(index);
```

Output:

```text
1
```

Why?

```text
Index
0 → 10
1 → 25  ← first match
2 → 30
3 → 15
4 → 40
```

Important:

```text
findIndex()
→ returns 1

NOT
→ returns 25
```

---

## 2. Basic Syntax

```js
const index = array.findIndex(callback);
```

Example:

```js
const numbers = [5, 10, 15];

const index = numbers.findIndex(
    num => num === 10
);

console.log(index);
```

Output:

```text
1
```

---

## 3. What If There Is No Match?

```js
const numbers = [5, 10, 15];

const index = numbers.findIndex(
    num => num > 100
);

console.log(index);
```

Output:

```text
-1
```

Remember:

```text
Match    → matching index
No match → -1
```

---

## 4. Callback Parameters

The callback can receive:

```js
array.findIndex((element, index, array) => {
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

const result = numbers.findIndex(
    (value, index) => {
        console.log(index, value);
        return value > 15;
    }
);

console.log("Result:", result);
```

Console output:

```text
0 10
1 20
Result: 1
```

Notice:

```text
console.log()
→ prints execution information

findIndex()
→ returns the matching index
```

`30` is not checked because `20` is the first match.

---

## 5. `findIndex()` vs `find()`

This is the most important difference.

### `find()`

```js
const user = users.find(
    user => user.id === 2
);
```

Returns the element:

```js
{
    id: 2,
    name: "Nakul"
}
```

### `findIndex()`

```js
const index = users.findIndex(
    user => user.id === 2
);
```

Returns:

```text
1
```

Remember:

```text
find()
→ element

findIndex()
→ index
```

---

## 6. `findIndex()` vs `filter()`

### `filter()`

Returns all matching elements:

```js
const result = numbers.filter(
    num => num > 10
);
```

### `findIndex()`

Returns the position of the first matching element:

```js
const index = numbers.findIndex(
    num => num > 10
);
```

Remember:

```text
filter()
→ all matches → new array

findIndex()
→ first match → index
```

---

## 7. Searching Objects

A common real-world use:

```js
const users = [
    { id: 1, name: "Om" },
    { id: 2, name: "Nakul" },
    { id: 3, name: "Pavan" }
];

const index = users.findIndex(
    user => user.id === 3
);

console.log(index);
```

Output:

```text
2
```

This is useful when you need to know **where an object is located** so that you can later update or remove it.

---

## 8. When Should You Use `findIndex()`?

Use it when:

```text
You have an array
      ↓
You need the position of the first match
      ↓
findIndex()
```

Typical cases:

```text
Find item position
Update an item
Remove an item
Replace an item
Check whether an item exists
```

Example:

```js
const index = users.findIndex(
    user => user.id === 2
);

if (index !== -1) {
    // item exists
}
```

---

# Part 1 Practice

### Exercise 1

Find the index of `30`:

```js
const numbers = [10, 20, 30, 40];
```

### Exercise 2

Find the index of the first even number:

```js
const numbers = [3, 7, 9, 12, 14];
```

### Exercise 3

Given:

```js
const users = [
    { id: 1, name: "Om" },
    { id: 2, name: "Nakul" },
    { id: 3, name: "Pavan" }
];
```

Find the index of the user with `id === 3`.

### Exercise 4

Predict:

```js
const numbers = [10, 20, 30];

const index = numbers.findIndex(
    num => num > 15
);

console.log(index);
```

### Exercise 5

What does `findIndex()` return when no element matches?

---

# Part 1 Checkpoint

You should now know:

```text
[x] What findIndex() does
[x] Basic syntax
[x] Callback parameters
[x] Return value
[x] -1 when no match exists
[x] findIndex() vs find()
[x] findIndex() vs filter()
[x] Searching objects
[x] When findIndex() is useful
```

### One-line memory rule

```text
findIndex() = index of the first matching element
```

**Part 1 complete.**
