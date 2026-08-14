# `some()`

> **`some()` checks whether at least one element in an array satisfies a condition. It returns `true` if a match exists; otherwise, it returns `false`.**

---

# Part 1 — Fundamentals, Practical Usage & Interview

## 1. What is `some()`?

Use `some()` when you only need to know:

> **"Does at least one element match?"**

```js
const numbers = [5, 8, 13, 20];

const result = numbers.some(
    num => num % 2 === 0
);

console.log(result);
```

Output:

```text
true
```

Why?

```text
5  → false
8  → true
      ↓
    STOP
```

`13` and `20` do not need to be checked.

---

## 2. Basic Syntax

```js
const result = array.some(callback);
```

Example:

```js
const numbers = [2, 4, 6];

const result = numbers.some(
    num => num > 5
);

console.log(result);
```

Output:

```text
true
```

---

## 3. Return Value

`some()` always returns a boolean:

```text
true
false
```

### At least one match

```js
const result = [10, 20, 30].some(
    num => num > 20
);

console.log(result);
```

Output:

```text
true
```

### No match

```js
const result = [10, 20, 30].some(
    num => num > 100
);

console.log(result);
```

Output:

```text
false
```

Remember:

```text
some()
→ boolean
```

It does **not** return the matching element.

---

## 4. Callback Parameters

The callback can receive:

```js
array.some((element, index, array) => {
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

const result = numbers.some(
    (value, index) => {
        console.log(index, value);
        return value > 15;
    }
);

console.log("Result:", result);
```

Console:

```text
0 10
1 20
Result: true
```

Notice:

```text
console.log()
→ prints execution information

some()
→ returns true/false
```

`30` is never checked because `20` matched.

---

## 5. How `some()` Works

```text
Array
 ↓
take element
 ↓
run callback
 ↓
truthy?
 ├── yes → return true → STOP
 └── no  → next element
```

Example:

```js
const numbers = [5, 10, 15, 20];

const result = numbers.some(
    num => num > 12
);
```

Execution:

```text
5  → false → continue
10 → false → continue
15 → true  → return true
20 → not checked
```

---

## 6. Why `return` Matters

Correct:

```js
const result = numbers.some(
    num => num > 10
);
```

Also correct:

```js
const result = numbers.some(num => {
    return num > 10;
});
```

Wrong:

```js
const result = numbers.some(num => {
    num > 10;
});
```

There is no `return`.

So the callback returns:

```text
undefined
```

`undefined` is falsy, so `some()` keeps checking.

If no element matches:

```text
false
```

---

## 7. `some()` vs `every()`

Very important interview distinction:

```text
some()
→ at least ONE must match

every()
→ ALL must match
```

Example:

```js
const numbers = [2, 4, 7];

numbers.some(
    num => num % 2 !== 0
);
// true
```

Because `7` is odd.

```js
numbers.every(
    num => num % 2 === 0
);
// false
```

Because `7` is not even.

---

## 8. `some()` vs `find()`

```text
some()
→ returns boolean

find()
→ returns element
```

Example:

```js
const users = [
    { id: 1, name: "Om", verified: false },
    { id: 2, name: "Nakul", verified: true },
    { id: 3, name: "Pavan", verified: true }
];
```

Need to know whether a verified user exists:

```js
const exists = users.some(
    user => user.verified
);

console.log(exists);
```

Output:

```text
true
```

Need the actual user:

```js
const user = users.find(
    user => user.verified
);

console.log(user);
```

Output:

```js
{
    id: 2,
    name: "Nakul",
    verified: true
}
```

Remember:

```text
some() → "Does one exist?"
find()  → "Give me the first one."
```

---

## 9. `some()` vs `filter()`

If you need the matching elements:

```js
const activeUsers = users.filter(
    user => user.verified
);
```

If you only need to know whether one exists:

```js
const hasVerifiedUser = users.some(
    user => user.verified
);
```

Remember:

```text
filter()
→ returns array

some()
→ returns boolean
```

---

## 10. Real-world Usage

### Permission Check

```js
const permissions = ["READ", "WRITE"];

const canDelete = permissions.some(
    permission => permission === "DELETE"
);

console.log(canDelete);
```

Output:

```text
false
```

---

### Product Availability

```js
const products = [
    { name: "Laptop", inStock: false },
    { name: "Mouse", inStock: true },
    { name: "Keyboard", inStock: false }
];

const available = products.some(
    product => product.inStock
);

console.log(available);
```

Output:

```text
true
```

---

### React

Check whether any todo is completed:

```js
const hasCompletedTodo = todos.some(
    todo => todo.completed
);
```

Useful when the UI only needs a yes/no decision.

---

## 11. Common Mistakes

### Expecting the matching element

Wrong:

```js
const user = users.some(
    user => user.id === 2
);

console.log(user.name);
```

`some()` returns:

```text
true
```

not the object.

Use `find()` when you need the object.

---

### Using `some()` instead of `filter()`

Wrong when you need all matching users:

```js
const usersFound = users.some(
    user => user.verified
);
```

This gives only:

```text
true / false
```

Use:

```js
const usersFound = users.filter(
    user => user.verified
);
```

---

## 12. Complexity

```text
Best Case  → O(1)
Worst Case → O(n)
```

Why?

It can stop immediately when the first element satisfies the condition.

---

# Interview Essentials

### What is `some()`?

A method that checks whether at least one element satisfies a condition.

### What does it return?

```text
true
false
```

### Does it stop early?

Yes, after the first truthy callback result.

### `some()` vs `every()`?

```text
some  → at least one
every → all
```

### `some()` vs `find()`?

```text
some → boolean
find → element
```

### Does `some()` create a new array?

No.

---

# Practice

### Exercise 1

Check whether an array contains an even number.

### Exercise 2

Given:

```js
const users = [
    { id: 1, name: "Om", verified: false },
    { id: 2, name: "Nakul", verified: false },
    { id: 3, name: "Pavan", verified: true }
];
```

Check whether any user is verified.

### Exercise 3

Check whether any product costs more than `50000`.

### Exercise 4 — Output

```js
const numbers = [1, 3, 5, 8];

const result = numbers.some(
    (value, index) => {
        console.log(index, value);
        return value % 2 === 0;
    }
);

console.log("Result:", result);
```

Output:

```text
0 1
1 3
2 5
3 8
Result: true
```

---

# Completion Checklist

```text
[x] I know what some() does.
[x] I know it returns boolean.
[x] I understand early stopping.
[x] I know some() vs every().
[x] I know some() vs find().
[x] I know some() vs filter().
[x] I can use it with objects.
[x] I understand the return mistake.
[x] I know O(1) best and O(n) worst case.
[x] I can solve basic OA questions.
```

### Memory Rule

```text
some() = "Does at least one element match?"
```

**`some()` complete ✅**

**Next → `07-every.md`**
