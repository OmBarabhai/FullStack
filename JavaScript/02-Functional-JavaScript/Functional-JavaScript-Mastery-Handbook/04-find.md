### `04-find.md` Part 1 — Fundamentals

# `find()`

> **`find()` returns the first element in an array that satisfies a condition. If no element matches, it returns `undefined`.**

---

## 1. What is `find()`?

Use `find()` when you need **one matching element**.

```js
const numbers = [10, 25, 30, 15, 40];

const result = numbers.find(
    num => num > 20
);

console.log(result);
```

Output:

```text
25
```

Even though `30` and `40` also match, `find()` returns only the **first** match.

---

## 2. Basic Syntax

```js
const result = array.find(callback);
```

Common usage:

```js
const result = numbers.find(
    num => num > 20
);
```

The callback answers:

> **"Does this element match what I am looking for?"**

---

## 3. Callback Parameters

The callback can receive:

```js
array.find((element, index, array) => {
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

const result = numbers.find(
    (value, index) => {
        console.log(index, value);
        return value > 15;
    }
);
```

Output:

```text
0 10
1 20
```

Then it stops because `20` matches.

---

## 4. Return Value

### Match found

```js
const numbers = [5, 10, 15];

const result = numbers.find(
    num => num > 10
);

console.log(result);
```

Output:

```text
15
```

### No match

```js
const numbers = [1, 2, 3];

const result = numbers.find(
    num => num > 100
);

console.log(result);
```

Output:

```text
undefined
```

Remember:

```text
find()
→ one element
→ or undefined
```

---

## 5. How `find()` Differs from `filter()`

This is the most important comparison.

### `find()`

```js
const result = users.find(
    user => user.id === 2
);
```

Returns:

```text
one matching element
```

### `filter()`

```js
const result = users.filter(
    user => user.id === 2
);
```

Returns:

```text
an array of matching elements
```

Remember:

```text
find   → first match
filter → all matches
```

---

## 6. `find()` Stops Early

Example:

```js
const numbers = [5, 10, 15, 20];

const result = numbers.find(
    num => num > 10
);
```

Execution:

```text
5  → false → continue
10 → false → continue
15 → true  → return 15
20 → not checked
```

This is an important difference from `filter()`.

---

## 7. Searching Objects

A very common real-world use:

```js
const users = [
    { id: 1, name: "Om" },
    { id: 2, name: "Nakul" },
    { id: 3, name: "Pavan" }
];

const user = users.find(
    user => user.id === 2
);

console.log(user);
```

Output:

```js
{ id: 2, name: "Nakul" }
```

---

## 8. When Should You Use `find()`?

Use it when:

```text
You have an array
      ↓
You need ONE matching element
      ↓
Return that element
```

Examples:

```js
users.find(user => user.id === 10);

products.find(product => product.id === 5);

students.find(student => student.marks > 90);
```

---

## 9. Simple Examples

### First even number

```js
const numbers = [1, 3, 7, 8, 10];

const result = numbers.find(
    num => num % 2 === 0
);

console.log(result);
```

Output:

```text
8
```

### First string longer than 5 characters

```js
const names = [
    "Om",
    "Nakul",
    "Pavan"
];

const result = names.find(
    name => name.length > 5
);

console.log(result);
```

Output:

```text
undefined
```

---

## 10. Quick Method Selection

```text
Transform every element
        ↓
      map()

Select multiple elements
        ↓
     filter()

Find one element
        ↓
      find()
```

---

# Part 1 Practice

### Exercise 1

Find the first even number:

```js
const numbers = [3, 7, 9, 12, 14];
```

### Exercise 2

Find the first number greater than `50`.

### Exercise 3

Given:

```js
const users = [
    { id: 1, name: "Om" },
    { id: 2, name: "Nakul" },
    { id: 3, name: "Pavan" }
];
```

Find the user whose `id` is `3`.

### Exercise 4

Predict:

```js
const numbers = [5, 10, 15];

const result = numbers.find(
    num => num > 8
);

console.log(result);
```

### Exercise 5

What does `find()` return when there is no match?

---

# Part 1 Checkpoint

You should now know:

```text
[x] What find() does
[x] Basic syntax
[x] Callback
[x] Callback parameters
[x] Return value
[x] undefined when no match
[x] Why it stops early
[x] find() vs filter()
[x] Searching objects
```

### One-line memory rule

```text
find() = return the first element that matches
```

**Part 1 complete.**
Yes. Here is the **corrected Part 2** for `04-find.md`, with the distinction between **console output** and the **value returned by `find()`** made explicit.

# Part 2 — `find()` Internal Working & Callback Flow

> **Goal:** Understand how `find()` checks elements, why it stops early, how the callback controls the search, and how to separate callback output from the value returned by `find()`.

---

## 1. How `find()` Works

```js
const numbers = [5, 10, 15, 20];

const result = numbers.find(
    num => num > 12
);
```

Conceptually:

```text
numbers
   ↓
find()
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
element        element
 ↓
stop
```

---

## 2. Step-by-Step Execution

```js
const numbers = [5, 10, 15, 20];

const result = numbers.find(
    num => num > 12
);
```

### Step 1

```text
5
↓
5 > 12
↓
false
↓
continue
```

### Step 2

```text
10
↓
10 > 12
↓
false
↓
continue
```

### Step 3

```text
15
↓
15 > 12
↓
true
↓
find() returns 15
↓
stop
```

Final value:

```text
result = 15
```

`20` is never checked.

---

## 3. Callback Parameters

The callback can receive:

```js
array.find((element, index, array) => {
    // ...
});
```

Example:

```js
const numbers = [10, 20, 30];

const result = numbers.find(
    (value, index) => {
        console.log(index, value);
        return value > 15;
    }
);
```

### Console output

```text
0 10
1 20
```

### `result`

```text
20
```

These are **different things**:

```text
console.log()
    ↓
prints information

find()
    ↓
returns the matching element
```

Execution:

```text
index 0 → value 10
10 > 15 → false
↓
continue

index 1 → value 20
20 > 15 → true
↓
return 20
↓
STOP
```

There is no:

```text
2 30
```

because `find()` has already found the first match.

---

## 4. Callback Parameters Meaning

| Parameter | Meaning          |
| --------- | ---------------- |
| `element` | Current element  |
| `index`   | Current position |
| `array`   | Original array   |

Example:

```js
const numbers = [10, 20, 30];

numbers.find((element, index, array) => {
    console.log(element);
    console.log(index);
    console.log(array);

    return false;
});
```

Because the callback always returns `false`, all elements are checked.

---

## 5. Truthy and Falsy

`find()` stops when the callback returns a **truthy** value.

```js
const numbers = [10, 20];

const result = numbers.find(
    num => true
);

console.log(result);
```

Result:

```text
10
```

Why?

```text
first element
   ↓
callback returns true
   ↓
10 returned
   ↓
stop
```

If the callback always returns `false`:

```js
const result = numbers.find(
    num => false
);

console.log(result);
```

Result:

```text
undefined
```

---

## 6. Why `return` Matters

Correct:

```js
const result = numbers.find(
    num => num > 10
);
```

Also correct:

```js
const result = numbers.find(num => {
    return num > 10;
});
```

Wrong:

```js
const result = numbers.find(num => {
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
find() returns undefined
```

---

## 7. `find()` Returns the Element

```js
const users = [
    { id: 1, name: "Om" },
    { id: 2, name: "Nakul" },
    { id: 3, name: "Pavan" }
];

const user = users.find(
    user => user.id === 2
);
```

`user` is:

```js
{
    id: 2,
    name: "Nakul"
}
```

It is **not**:

```js
[
    {
        id: 2,
        name: "Nakul"
    }
]
```

That would be `filter()`.

---

## 8. Object Reference Behavior

`find()` returns the matching object itself.

```js
const users = [
    { id: 1, name: "Om" },
    { id: 2, name: "Nakul" }
];

const user = users.find(
    user => user.id === 2
);
```

Conceptually:

```text
users
  ↓
Object A
Object B ← user
```

So:

```js
user.name = "Pavan";

console.log(users[1].name);
```

Output:

```text
Pavan
```

Because both refer to the same object.

---

## 9. Dry Run

```js
const numbers = [3, 7, 8, 10];

const result = numbers.find(
    num => num % 2 === 0
);
```

Execution:

```text
3 → odd  → continue
7 → odd  → continue
8 → even → return 8
10 → not checked
```

Result:

```text
result = 8
```

---

## 10. Object Dry Run

```js
const users = [
    { id: 1, name: "Om", active: false },
    { id: 2, name: "Nakul", active: true },
    { id: 3, name: "Pavan", active: true }
];

const user = users.find(
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
return Nakul
↓
STOP
```

`Pavan` is never checked.

---

## 11. `find()` vs `filter()`

### `find()`

```text
element
   ↓
callback
   ↓
match?
   ↓
return first match
   ↓
STOP
```

### `filter()`

```text
element
   ↓
callback
   ↓
match?
 ↓       ↓
yes      no
 ↓        ↓
keep    discard
   ↓
continue checking
```

Therefore:

```text
find()
→ first match
→ may stop early

filter()
→ all matches
→ continues through the array
```

---

## 12. Important Interview Distinction

When a callback contains:

```js
console.log(value);
return condition;
```

remember:

```text
console.log(value)
        ↓
side effect / console output

return condition
        ↓
controls find()
```

Example:

```js
const result = [10, 20, 30].find(
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
Result: 20
```

This distinction is important in output-based OA questions.

---

# Part 2 Checkpoint

You should now understand:

```text
[x] How find() checks elements
[x] Why find() stops early
[x] Callback parameters
[x] Truthy/falsy behavior
[x] Why return matters
[x] No-match → undefined
[x] find() returns an element, not an array
[x] Object reference behavior
[x] Console output vs returned value
[x] find() vs filter()
[x] Dry-running find()
```

### One-line memory rule

```text
find() = return the first element whose callback is truthy
```

**Part 2 complete.**


# Part 3 — `find()` with Objects, Conditions & Real-world Data

> **Goal:** Learn how `find()` is used with objects, strings, API-style data, React, and Node.js.

---

## 1. Finding Objects

One of the most common uses of `find()` is searching an array of objects.

```js
const users = [
    { id: 1, name: "Om" },
    { id: 2, name: "Nakul" },
    { id: 3, name: "Pavan" }
];

const user = users.find(
    user => user.id === 2
);

console.log(user);
```

Output:

```js
{
    id: 2,
    name: "Nakul"
}
```

Remember:

```text
find()
 ↓
first matching object
```

---

## 2. Finding by Object Property

You can search using any property.

```js
const products = [
    { id: 1, name: "Laptop", price: 60000 },
    { id: 2, name: "Mouse", price: 1000 }
];

const product = products.find(
    product => product.name === "Mouse"
);

console.log(product);
```

Output:

```js
{
    id: 2,
    name: "Mouse",
    price: 1000
}
```

---

## 3. Multiple Conditions

### AND — `&&`

```js
const users = [
    { name: "Om", age: 22, verified: true },
    { name: "Nakul", age: 20, verified: false },
    { name: "Pavan", age: 25, verified: true }
];

const user = users.find(
    user =>
        user.age >= 21 &&
        user.verified
);

console.log(user);
```

Output:

```js
{
    name: "Om",
    age: 22,
    verified: true
}
```

`find()` stops at the **first** object satisfying both conditions.

---

## 4. OR — `||`

```js
const user = users.find(
    user =>
        user.name === "Nakul" ||
        user.verified
);

console.log(user);
```

The first matching element is returned.

---

## 5. Finding Strings

```js
const names = [
    "Om",
    "Nakul",
    "Pavan"
];

const result = names.find(
    name => name.length > 5
);

console.log(result);
```

Output:

```text
Nakul
```

Another example:

```js
const result = names.find(
    name => name.startsWith("P")
);
```

Output:

```text
Pavan
```

The important point is that `find()` still returns only the **first** matching string.

---

## 6. Finding in Nested Arrays

```js
const matrix = [
    [1, 2],
    [5, 6],
    [8, 9]
];

const row = matrix.find(
    row => row[0] > 4
);

console.log(row);
```

Output:

```text
[5, 6]
```

Here each row is treated as one element.

---

## 7. API-style Data

Suppose your application receives:

```js
const users = [
    { id: 1, name: "Om", verified: true },
    { id: 2, name: "Nakul", verified: false },
    { id: 3, name: "Pavan", verified: true }
];
```

Find a specific user:

```js
const user = users.find(
    user => user.id === 3
);
```

Result:

```js
{
    id: 3,
    name: "Pavan",
    verified: true
}
```

Find the first verified user:

```js
const verifiedUser = users.find(
    user => user.verified
);
```

Result:

```js
{
    id: 1,
    name: "Om",
    verified: true
}
```

Because `Om` is the first match.

---

## 8. React Usage

Finding selected data is a common React pattern:

```jsx
const selectedUser = users.find(
    user => user.id === selectedId
);
```

For products:

```jsx
const selectedProduct = products.find(
    product => product.id === productId
);
```

Mental model:

```text
React state
   ↓
find()
   ↓
selected object
   ↓
render
```

---

## 9. Node.js Usage

Find a customer:

```js
const customer = customers.find(
    customer => customer.id === customerId
);
```

Find an order:

```js
const order = orders.find(
    order => order.orderId === id
);
```

Find a user from API data:

```js
const user = apiResponse.find(
    user => user.email === email
);
```

---

## 10. Object Reference Reminder

`find()` returns the matching object itself, not a copy. This follows the same reference behavior discussed in Part 2.

```js
const users = [
    { id: 1, name: "Om" },
    { id: 2, name: "Nakul" },
    { id: 3, name: "Pavan" }
];

const user = users.find(
    user => user.id === 2
);

user.name = "Pavan";

console.log(users[1].name);
```

Output:

```text
Pavan
```

Mental model:

```text
users[1]
   ↑
   │ same object
   ↓
user
```

---

## 11. `find()` vs `filter()` in Real Projects

Suppose you need:

> "Give me all verified users."

Use:

```js
users.filter(
    user => user.verified
);
```

Suppose you need:

> "Give me the first verified user."

Use:

```js
users.find(
    user => user.verified
);
```

So:

```text
Need all?
    ↓
filter()

Need one?
    ↓
find()
```

---

## 12. Real-world Challenge

Given:

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

### Task 1

Find the product with:

```text
id === 3
```

### Task 2

Find the first product that is:

```text
inStock === true
```

### Task 3

Find the first product with:

```text
price > 50000
```

### Task 4

Find the first product where:

```text
inStock === true
AND
price > 2000
```

Try these without looking at the examples.

---

# Part 3 Checkpoint

You should now be able to:

```text
[x] Find objects by ID
[x] Find objects by properties
[x] Use && and ||
[x] Find strings
[x] Find nested-array elements
[x] Search API-style data
[x] Use find() in React
[x] Use find() in Node.js
[x] Understand object references
[x] Choose find() vs filter()
```

### One-line memory rule

```text
find() = find the first element that matches
```

**Part 3 complete.**


# Part 4 — `find()` Performance, Pitfalls, Interview & Final Practice

> **Goal:** Finish `find()` at the level needed for interviews, OAs, and real projects. You should be able to explain its early stopping behavior, choose it over related methods, debug it, and solve common output questions.

---

# 1. Performance

`find()` checks elements in order and **stops as soon as it finds a match**.

### Best Case

If the first element matches:

```text id="4fy0mm"
O(1)
```

Example:

```js
const numbers = [10, 20, 30];

const result = numbers.find(
    num => num > 5
);
```

Only the first element needs to be checked.

---

### Worst Case

If the match is near the end, or there is no match:

```text id="7zq2j8"
O(n)
```

Example:

```js
const numbers = [10, 20, 30];

const result = numbers.find(
    num => num > 100
);
```

All elements are checked.

---

# 2. Why `find()` Can Stop Early

Consider:

```js
const numbers = [5, 10, 15, 20];

const result = numbers.find(
    num => num > 10
);
```

Execution:

```text id="r4z9sc"
5  → false
10 → false
15 → true
20 → NOT checked
```

Result:

```text id="j6zq0y"
15
```

This is a key difference from `filter()`:

```text id="z01y3z"
find()
→ stops after first match

filter()
→ continues checking for all matches
```

---

# 3. Memory Behavior

`find()` does **not create a new array**.

```js
const numbers = [10, 20, 30];

const result = numbers.find(
    num => num === 20
);
```

Conceptually:

```text id="3l3ql9"
numbers
   ↓
[10, 20, 30]

find()
   ↓
20
```

So compared with `filter()`:

```text id="o3p7he"
find()   → returns one element
filter() → creates a new array
```

---

# 4. Object Reference Behavior

With objects:

```js
const users = [
    { id: 1, name: "Om" },
    { id: 2, name: "Nakul" },
    { id: 3, name: "Pavan" }
];

const user = users.find(
    user => user.id === 2
);
```

`user` refers to the matching object.

So:

```js
user.name = "Pavan";

console.log(users[1].name);
```

Output:

```text
Pavan
```

Remember:

```text id="k7m2x5"
find() returns an existing element
→ it does not clone the object
```

---

# 5. `find()` vs Other Methods

| Method        | Returns   | Stops Early | Main Purpose            |
| ------------- | --------- | ----------: | ----------------------- |
| `find()`      | Element   |           ✅ | First match             |
| `filter()`    | Array     |           ❌ | All matches             |
| `findIndex()` | Index     |           ✅ | Position of first match |
| `some()`      | Boolean   |           ✅ | At least one match      |
| `every()`     | Boolean   |           ✅ | All elements match      |
| `map()`       | Array     |           ❌ | Transform               |
| `reduce()`    | One value |           ❌ | Aggregate               |

The most important choices:

```text id="8r4vpt"
Need one element?
→ find()

Need all matching elements?
→ filter()

Need position?
→ findIndex()

Need only true/false?
→ some()
```

---

# 6. `find()` vs `filter()[0]`

Avoid:

```js
const user = users.filter(
    user => user.id === 2
)[0];
```

Prefer:

```js
const user = users.find(
    user => user.id === 2
);
```

Why?

```text id="ugr3y8"
find()
→ designed for one result
→ stops at first match

filter()[0]
→ creates an array first
→ then takes its first element
```

---

# 7. `find()` vs `findIndex()`

`find()`:

```js
const user = users.find(
    user => user.id === 2
);
```

Returns:

```js
{ id: 2, name: "Nakul" }
```

`findIndex()`:

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

```text id="u4v32c"
find()
→ element

findIndex()
→ index
```

---

# 8. `find()` vs `some()`

If you need the actual element:

```js
const user = users.find(
    user => user.id === 2
);
```

If you only need to know whether a match exists:

```js
const exists = users.some(
    user => user.id === 2
);
```

Result:

```text id="54k7af"
find() → object
some() → true / false
```

---

# 9. Common Pitfall — Expecting an Array

Wrong expectation:

```js
const result = users.find(
    user => user.id > 1
);

console.log(result.length);
```

`find()` returns one element, not an array.

For objects:

```text
result.length
```

may be `undefined`.

Use `filter()` when you actually need multiple matches.

---

# 10. Common Pitfall — No Match

```js
const user = users.find(
    user => user.id === 100
);
```

Result:

```text
undefined
```

Therefore, in real code:

```js
if (user) {
    console.log(user.name);
}
```

Or with optional chaining:

```js
console.log(user?.name);
```

---

# 11. Common Pitfall — Missing `return`

Wrong:

```js
const result = [10, 20, 30].find(num => {
    num > 15;
});
```

Result:

```text
undefined
```

Correct:

```js
const result = [10, 20, 30].find(num => {
    return num > 15;
});
```

---

# 12. Debugging `find()`

A useful interview debugging technique:

```js
const result = [10, 20, 30].find(
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
Result: 20
```

Notice the difference:

```text id="q8j5ba"
console.log()
→ prints execution information

find()
→ returns the matching element
```

This distinction is important for output-based questions.

---

# 13. Output Practice

### Question 1

```js
const result = [1, 2, 3].find(
    num => num > 1
);

console.log(result);
```

Answer:

```text
2
```

---

### Question 2

```js
const result = [1, 2, 3].find(
    num => false
);

console.log(result);
```

Answer:

```text
undefined
```

---

### Question 3

```js
const result = [10, 20, 30].find(
    num => num > 15
);

console.log(result);
```

Answer:

```text
20
```

---

### Question 4

```js
const result = [10, 20, 30].find(
    (value, index) => {
        console.log(index, value);
        return value > 15;
    }
);
```

Console output:

```text
0 10
1 20
```

Returned value:

```text
20
```

`30` is never checked.

---

# 14. Real-world Challenge

Use:

```js
const users = [
    { id: 1, name: "Om", verified: true },
    { id: 2, name: "Nakul", verified: false },
    { id: 3, name: "Pavan", verified: true }
];
```

### Task 1

Find the user with `id === 2`.

### Task 2

Find the first verified user.

### Task 3

Find the first user whose name starts with `"P"`.

### Task 4

Find the first user matching:

```text
verified === true
AND
id > 1
```

### Task 5

Explain why `filter()` is not the best method for these one-result searches.

---

# 15. Interview Questions

### What is `find()`?

A method that returns the first element whose callback result is truthy.

### What happens when no match exists?

It returns:

```text
undefined
```

### Does `find()` stop early?

Yes, after the first match.

### Best-case complexity?

```text
O(1)
```

### Worst-case complexity?

```text
O(n)
```

### Does `find()` create a new array?

No.

### `find()` vs `filter()`?

```text
find   → first match
filter → all matches
```

### `find()` vs `findIndex()`?

```text
find      → element
findIndex → index
```

### `find()` vs `some()`?

```text
find → element
some → boolean
```

---

# 16. Final Checklist

Before moving to `05-findIndex.md`:

```text
[ ] I can explain find() in one sentence.
[ ] I can use find() without notes.
[ ] I understand the callback.
[ ] I understand early stopping.
[ ] I know undefined when no match exists.
[ ] I know find() vs filter().
[ ] I know find() vs findIndex().
[ ] I know find() vs some().
[ ] I understand object references.
[ ] I can dry-run find().
[ ] I can debug console output vs return value.
[ ] I can use find() with API-style objects.
[ ] I can solve common OA questions.
```

---

# Final Takeaway

```text id="h6w1kv"
find()
 ↓
check elements in order
 ↓
callback
 ↓
truthy?
 ↓
return first matching element
 ↓
STOP
```

### One-line memory rule

> **`find()` = give me the first element that matches.**

`find()` is now complete. ✅

**Next → `05-findIndex.md`**
