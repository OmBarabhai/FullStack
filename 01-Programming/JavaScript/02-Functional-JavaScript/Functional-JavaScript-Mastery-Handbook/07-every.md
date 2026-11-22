# `every()`

> **`every()` checks whether all elements in an array satisfy a condition. It returns `true` only when every element passes; otherwise, it returns `false`.**

---

# Part 1 — Fundamentals, Practical Usage & Interview

## 1. What is `every()`?

Use `every()` when you need to know:

> **"Do all elements match this condition?"**

```js id="k3qj8f"
const numbers = [2, 4, 6, 8];

const result = numbers.every(
    num => num % 2 === 0
);

console.log(result);
```

Output:

```text id="d7l2cz"
true
```

---

## 2. One Element Fails

```js id="q7j1et"
const numbers = [2, 4, 5, 8];

const result = numbers.every(
    num => num % 2 === 0
);

console.log(result);
```

Output:

```text id="lyr4k6"
false
```

Why?

```text id="f6c6db"
2 → true
4 → true
5 → false
     ↓
   STOP
```

`8` is never checked.

---

## 3. Basic Syntax

```js id="s6c3xq"
const result = array.every(callback);
```

The callback can receive:

```js id="j4q26j"
array.every((element, index, array) => {
    // condition
});
```

| Parameter | Meaning         |
| --------- | --------------- |
| `element` | Current element |
| `index`   | Current index   |
| `array`   | Original array  |

Most of the time:

```js id="4n6x5c"
numbers.every(num => num > 0);
```

is enough.

---

## 4. Return Value

`every()` always returns:

```text id="6swxsp"
true
or
false
```

### All pass

```js id="lqv3ti"
const result = [10, 20, 30].every(
    num => num > 0
);

console.log(result);
```

Output:

```text
true
```

### One fails

```js id="p5a79c"
const result = [10, -20, 30].every(
    num => num > 0
);

console.log(result);
```

Output:

```text
false
```

---

## 5. How `every()` Works

```text id="z6b4iq"
Array
 ↓
take element
 ↓
run callback
 ↓
truthy?
 ├── no  → return false → STOP
 └── yes → next element
                    ↓
              all passed?
                    ↓
                  true
```

Example:

```js id="7e0k4f"
const numbers = [2, 4, 6];

const result = numbers.every(
    num => num % 2 === 0
);
```

Flow:

```text id="kgx1z1"
2 → true
4 → true
6 → true
    ↓
return true
```

---

## 6. `return` Matters

Correct:

```js id="s0t3d6"
const result = numbers.every(
    num => num > 0
);
```

Also correct:

```js id="nvf2as"
const result = numbers.every(num => {
    return num > 0;
});
```

Wrong:

```js id="x9v4ch"
const result = numbers.every(num => {
    num > 0;
});
```

No `return` means:

```text id="x4zq86"
undefined
↓
falsy
↓
every() returns false
```

---

## 7. `every()` vs `some()`

This is one of the most important interview comparisons.

```text id="mdd1qw"
some()
→ at least ONE must match

every()
→ ALL must match
```

Example:

```js id="q2n7hc"
const numbers = [2, 4, 5];

numbers.some(
    num => num % 2 !== 0
);
// true
```

At least one number is odd.

```js id="xnmxz9"
numbers.every(
    num => num % 2 === 0
);
// false
```

Not every number is even.

---

## 8. `every()` vs `filter()`

Need to know whether all users are active:

```js id="5g0f96"
const allActive = users.every(
    user => user.active
);
```

Result:

```text id="wl5usq"
true / false
```

Need the actual active users:

```js id="9oym03"
const activeUsers = users.filter(
    user => user.active
);
```

Result:

```text id="k86v5j"
array
```

Remember:

```text id="a6ph4q"
every()
→ validation

filter()
→ selection
```

---

## 9. `every()` vs `find()`

`every()`:

```js id="apzg2n"
const valid = users.every(
    user => user.verified
);
```

Returns:

```text
true / false
```

`find()`:

```js id="usj1nc"
const user = users.find(
    user => user.verified
);
```

Returns:

```text
matching object
```

Remember:

```text
every() → "Are ALL valid?"
find()  → "Give me the FIRST valid one."
```

---

## 10. Working with Objects

```js id="o50m3r"
const users = [
    { id: 1, name: "Om", active: true },
    { id: 2, name: "Nakul", active: true },
    { id: 3, name: "Pavan", active: false }
];

const allActive = users.every(
    user => user.active
);

console.log(allActive);
```

Output:

```text
false
```

Because `Pavan` is not active.

---

## 11. Real-world Validation

### Form Fields

```js id="mvd3bi"
const fields = [
    "Om",
    "Pune",
    "Developer"
];

const valid = fields.every(
    field => field !== ""
);

console.log(valid);
```

Output:

```text
true
```

### Products

```js id="j8x7d0"
const products = [
    { name: "Laptop", inStock: true },
    { name: "Mouse", inStock: true },
    { name: "Keyboard", inStock: false }
];

const allAvailable = products.every(
    product => product.inStock
);

console.log(allAvailable);
```

Output:

```text
false
```

---

## 12. React Usage

Check whether every input is valid:

```js id="jvnjhn"
const isValid = inputs.every(
    input => input.valid
);
```

Check whether all todos are completed:

```js id="a5s4lu"
const completed = todos.every(
    todo => todo.completed
);
```

The important idea:

```text
every()
→ useful when the UI needs a yes/no validation result
```

---

## 13. Common Mistakes

### Expecting an element

Wrong:

```js id="6v0nqf"
const result = users.every(
    user => user.active
);

console.log(result.name);
```

`every()` returns:

```text
true / false
```

not an object.

---

### Using `every()` when only one match matters

If you need:

> "Is there at least one admin?"

Use:

```js id="7o1x6d"
users.some(
    user => user.admin
);
```

Not:

```js id="d9xdk6"
users.every(
    user => user.admin
);
```

---

## 14. Complexity

```text
Best Case  → O(1)
Worst Case → O(n)
```

It can stop immediately when the first element fails.

---

# Interview Essentials

### What is `every()`?

A method that checks whether all elements satisfy a condition.

### What does it return?

```text
true / false
```

### Does it stop early?

Yes. It stops at the first falsy callback result.

### `every()` vs `some()`?

```text
every → all
some  → at least one
```

### `every()` vs `filter()`?

```text
every  → boolean validation
filter → matching array
```

### Does `every()` create a new array?

No.

---

# Practice

### Exercise 1

Check whether all numbers are positive:

```js
const numbers = [2, 5, 10, 20];
```

### Exercise 2

Check whether every user is active:

```js
const users = [
    { id: 1, name: "Om", active: true },
    { id: 2, name: "Nakul", active: true },
    { id: 3, name: "Pavan", active: false }
];
```

### Exercise 3

Check whether every product is in stock.

### Exercise 4

Check whether every filename ends with `.js`.

### Exercise 5 — Output

```js
const numbers = [2, 4, 6, 8];

const result = numbers.every(
    (value, index) => {
        console.log(index, value);
        return value % 2 === 0;
    }
);

console.log("Result:", result);
```

Output:

```text
0 2
1 4
2 6
3 8
Result: true
```

---

# Completion Checklist

```text
[x] I know what every() does.
[x] I know it returns boolean.
[x] I understand early stopping.
[x] I understand the callback.
[x] I know the return mistake.
[x] I know every() vs some().
[x] I know every() vs filter().
[x] I know every() vs find().
[x] I can use it with objects.
[x] I can use it for validation.
[x] I know O(1) best and O(n) worst case.
[x] I can solve basic OA/interview questions.
```

### Memory Rule

```text
every() = "Do ALL elements match?"
```

**`every()` complete ✅**

**Next → `08-reduce.md`**
