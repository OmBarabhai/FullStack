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


# Part 2 — `findIndex()` Internal Working & Callback Flow

> **Goal:** Understand how `findIndex()` checks elements, why it stops at the first match, how the callback controls the search, and how to dry-run it.

---

## 1. How `findIndex()` Works

Example:

```js
const numbers = [5, 10, 15, 20];

const index = numbers.findIndex(
    num => num > 10
);
```

Conceptually:

```text
numbers
   ↓
findIndex()
   ↓
take current element
   ↓
run callback
   ↓
truthy?
 ┌───────┴───────┐
yes             no
 ↓               ↓
return          next
index          element
 ↓
stop
```

The important difference from `find()`:

```text
find()
→ returns the matching element

findIndex()
→ returns the matching element's index
```

---

## 2. Step-by-Step Execution

```js
const numbers = [5, 10, 15, 20];

const index = numbers.findIndex(
    num => num > 10
);
```

### Step 1

```text
index 0 → 5
5 > 10
↓
false
↓
continue
```

### Step 2

```text
index 1 → 10
10 > 10
↓
false
↓
continue
```

### Step 3

```text
index 2 → 15
15 > 10
↓
true
↓
return index 2
↓
STOP
```

Final result:

```text
index = 2
```

`20` is never checked.

---

## 3. Callback Parameters

The callback can receive:

```js
array.findIndex((element, index, array) => {
    // ...
});
```

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

Notice the distinction:

```text
console.log()
→ prints execution information

findIndex()
→ returns the matching index
```

`30` is not checked because `20` matched first.

---

## 4. Callback Parameter Meaning

| Parameter | Meaning          |
| --------- | ---------------- |
| `element` | Current element  |
| `index`   | Current position |
| `array`   | Original array   |

Most of the time, you only need:

```js
numbers.findIndex(
    num => num > 15
);
```

---

## 5. Truthy and Falsy

`findIndex()` stops when the callback returns a **truthy** value.

Example:

```js
const numbers = [10, 20];

const index = numbers.findIndex(
    num => true
);

console.log(index);
```

Output:

```text
0
```

The first element immediately matches.

If the callback always returns `false`:

```js
const index = numbers.findIndex(
    num => false
);

console.log(index);
```

Output:

```text
-1
```

Remember:

```text
truthy → match → return index
falsy  → continue
```

---

## 6. Why `return` Matters

Correct:

```js
const index = numbers.findIndex(
    num => num > 10
);
```

Also correct:

```js
const index = numbers.findIndex(num => {
    return num > 10;
});
```

Wrong:

```js
const index = numbers.findIndex(num => {
    num > 10;
});
```

The callback returns:

```text
undefined
```

Therefore:

```text
undefined
↓
falsy
↓
continue searching
↓
no match
↓
-1
```

---

## 7. `findIndex()` Returns an Index

Given:

```js
const users = [
    { id: 1, name: "Om" },
    { id: 2, name: "Nakul" },
    { id: 3, name: "Pavan" }
];

const index = users.findIndex(
    user => user.id === 2
);
```

The value is:

```text
1
```

Not:

```js
{ id: 2, name: "Nakul" }
```

That is the job of `find()`.

```text
find()
→ element

findIndex()
→ index
```

---

## 8. Dry Run Practice

Try this:

```js
const numbers = [3, 7, 8, 10];

const index = numbers.findIndex(
    num => num % 2 === 0
);
```

Dry run:

```text
3 → odd  → continue
7 → odd  → continue
8 → even → return index 2
10 → not checked
```

Result:

```text
2
```

---

## 9. Object Dry Run

```js
const users = [
    { id: 1, name: "Om", active: false },
    { id: 2, name: "Nakul", active: true },
    { id: 3, name: "Pavan", active: true }
];

const index = users.findIndex(
    user => user.active
);
```

Execution:

```text
Om
↓
false
↓
continue

Nakul
↓
true
↓
return index 1
↓
STOP
```

`Pavan` is never checked.

---

## 10. `findIndex()` vs `filter()`

### `findIndex()`

```text
element
   ↓
callback
   ↓
truthy?
 ↓    ↓
yes   no
 ↓     ↓
index next
 ↓
STOP
```

### `filter()`

```text
element
   ↓
callback
   ↓
truthy?
 ↓       ↓
yes      no
 ↓        ↓
keep    discard
 ↓
continue
```

Therefore:

```text
findIndex()
→ first match
→ can stop early

filter()
→ all matches
→ continues
```

---

## 11. What You Need to Remember

```text
findIndex()
 ↓
check elements in order
 ↓
run callback
 ↓
truthy?
 ↓
return index
 ↓
STOP
```

No match:

```text
-1
```

### Part 2 Checkpoint

You should be able to explain:

```text
[x] How findIndex() processes elements
[x] Why it stops early
[x] Callback parameters
[x] Truthy/falsy behavior
[x] Why return matters
[x] Why no match returns -1
[x] findIndex() vs find()
[x] findIndex() vs filter()
[x] Dry-run findIndex()
[x] Console output vs returned value
```

### One-line memory rule

```text
findIndex() = return the index of the first matching element
```

**Part 2 complete.**


# Part 3 — `findIndex()` with Objects, Updates & Real-world Usage

> **Goal:** Use `findIndex()` with the kinds of arrays you will actually work with in projects: users, products, API data, and React state.

---

## 1. Finding an Object's Index

```js
const users = [
    { id: 1, name: "Om" },
    { id: 2, name: "Nakul" },
    { id: 3, name: "Pavan" }
];

const index = users.findIndex(
    user => user.id === 2
);

console.log(index);
```

Output:

```text
1
```

The object is at index `1`.

Remember:

```text
find()
→ gives the object

findIndex()
→ gives the object's position
```

---

## 2. Finding by Another Property

```js
const users = [
    { id: 1, name: "Om" },
    { id: 2, name: "Nakul" },
    { id: 3, name: "Pavan" }
];

const index = users.findIndex(
    user => user.name === "Pavan"
);

console.log(index);
```

Output:

```text
2
```

---

## 3. Multiple Conditions

```js
const users = [
    { id: 1, name: "Om", verified: true },
    { id: 2, name: "Nakul", verified: false },
    { id: 3, name: "Pavan", verified: true }
];

const index = users.findIndex(
    user =>
        user.verified &&
        user.id > 1
);

console.log(index);
```

Output:

```text
2
```

Why:

```text
Om    → verified but id = 1 → false
Nakul → not verified         → false
Pavan → verified + id > 1   → true
                              ↓
                            index 2
```

---

## 4. Finding a String's Index

```js
const names = [
    "Om",
    "Nakul",
    "Pavan"
];

const index = names.findIndex(
    name => name.length > 4
);

console.log(index);
```

Output:

```text
1
```

Because `"Nakul"` is the first name with length greater than `4`.

---

## 5. Finding in a Nested Array

```js
const matrix = [
    [1, 2],
    [5, 6],
    [8, 9]
];

const index = matrix.findIndex(
    row => row[0] > 4
);

console.log(index);
```

Output:

```text
1
```

The matching row is:

```text
[5, 6]
```

but `findIndex()` returns:

```text
1
```

---

# 6. Updating an Array Element

This is one of the most useful practical applications.

```js
const users = [
    { id: 1, name: "Om" },
    { id: 2, name: "Nakul" },
    { id: 3, name: "Pavan" }
];

const index = users.findIndex(
    user => user.id === 2
);

if (index !== -1) {
    users[index].name = "Pavan";
}

console.log(users);
```

The element at index `1` is updated.

Mental model:

```text
users
  ↓
findIndex()
  ↓
index = 1
  ↓
users[1]
  ↓
update
```

> This directly mutates the original array/object. Later, in React, you will usually use an immutable update instead.

---

## 7. Immutable Update Pattern

For React-style updates:

```js
const users = [
    { id: 1, name: "Om" },
    { id: 2, name: "Nakul" },
    { id: 3, name: "Pavan" }
];

const index = users.findIndex(
    user => user.id === 2
);

const updatedUsers =
    index === -1
        ? users
        : users.map((user, i) =>
            i === index
                ? { ...user, name: "Pavan" }
                : user
        );
```

The important idea is:

```text
findIndex()
→ locate position

map()
→ create updated array
```

You will see this pattern in React state updates.

---

# 8. Removing an Element

Basic JavaScript:

```js
const users = [
    { id: 1, name: "Om" },
    { id: 2, name: "Nakul" },
    { id: 3, name: "Pavan" }
];

const index = users.findIndex(
    user => user.id === 2
);

if (index !== -1) {
    users.splice(index, 1);
}

console.log(users);
```

Now `"Nakul"` is removed.

Flow:

```text
findIndex()
   ↓
find position
   ↓
splice()
   ↓
remove item
```

---

# 9. React Usage

A common pattern when updating state:

```jsx
const index = users.findIndex(
    user => user.id === selectedId
);
```

Then create a new array:

```jsx
const updatedUsers = users.map((user, i) =>
    i === index
        ? { ...user, active: true }
        : user
);
```

This combines:

```text
findIndex()
+
map()
+
spread
```

You do not need to memorize the complete pattern yet. Understand the roles:

```text
findIndex → locate
map       → update immutably
spread    → create new object
```

---

# 10. Node.js / API Usage

Suppose you have:

```js
const users = [
    { id: 1, name: "Om" },
    { id: 2, name: "Nakul" },
    { id: 3, name: "Pavan" }
];
```

Find where a user exists:

```js
const index = users.findIndex(
    user => user.id === 3
);
```

You can then use the index for an update or other operation.

---

# 11. Important `-1` Check

This is essential.

```js
const index = users.findIndex(
    user => user.id === 100
);

console.log(index);
```

Output:

```text
-1
```

Never blindly do:

```js
users[index].name = "Om";
```

because `index` may be `-1`.

Prefer:

```js
if (index !== -1) {
    users[index].name = "Om";
}
```

Remember:

```text
-1
↓
not found
```

---

# 12. `findIndex()` vs `indexOf()`

This distinction is important.

### `indexOf()`

Searches for an exact value:

```js
const numbers = [10, 20, 30];

const index = numbers.indexOf(20);

console.log(index);
```

Output:

```text
1
```

### `findIndex()`

Searches using a condition:

```js
const index = numbers.findIndex(
    num => num > 15
);

console.log(index);
```

Output:

```text
1
```

Remember:

```text
indexOf()
→ exact value

findIndex()
→ condition
```

---

# 13. Real-world Challenge

Given:

```js
const users = [
    { id: 1, name: "Om", verified: true },
    { id: 2, name: "Nakul", verified: false },
    { id: 3, name: "Pavan", verified: true }
];
```

### Task 1

Find the index of `"Pavan"`.

### Task 2

Find the index of the first verified user after `id > 1`.

### Task 3

Find the index of the user with `id === 2`, then change their name.

### Task 4

Remove the user with `id === 2`.

### Task 5

Explain why you must check:

```js
index !== -1
```

before using the index.

---

# Part 3 Checkpoint

You should now be able to:

```text
[x] Find object indexes
[x] Search using multiple conditions
[x] Search strings
[x] Search nested arrays
[x] Use findIndex() to locate an item
[x] Update an item using the index
[x] Remove an item using the index
[x] Understand immutable React-style updates
[x] Know findIndex() vs indexOf()
[x] Understand why -1 must be checked
```

### One-line memory rule

```text
findIndex() = locate the first matching element
```

**Part 3 complete.**
