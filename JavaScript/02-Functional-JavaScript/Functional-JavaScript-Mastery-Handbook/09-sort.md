Yes — for `sort()`, **4 parts are enough**. It is more important than `some()`/`every()` because of the compare function, mutation, object sorting, and common OA traps. Your uploaded file already covers those areas.

We should keep it focused:

```text
Part 1 → Fundamentals
Part 2 → Compare function + dry runs
Part 3 → Objects + real-world sorting
Part 4 → Pitfalls + interview/OA + final practice
```

No need for a Part 5.

# `09-sort()` — Part 1

## 1. What is `sort()`?

`sort()` rearranges the elements of an array into an order.

```js
const fruits = ["Banana", "Apple", "Orange"];

fruits.sort();

console.log(fruits);
```

Output:

```text
["Apple", "Banana", "Orange"]
```

---

## 2. Important: `sort()` Mutates the Original Array

```js
const numbers = [3, 1, 2];

const result = numbers.sort();

console.log(numbers);
console.log(result);
```

Both contain:

```text
[1, 2, 3]
```

`sort()` changes the original array and returns that same array.

Think:

```text
numbers
   ↓
same array
   ↓
sorted in place
```

This is one of the most important things to remember.

---

## 3. Default Sorting Is String-Based ⭐

This is a very common interview/OA question.

```js
const numbers = [1, 100, 20, 3];

numbers.sort();

console.log(numbers);
```

Result:

```text
[1, 100, 20, 3]
```

Why?

JavaScript's default sorting compares values as strings.

Conceptually:

```text
1   → "1"
100 → "100"
20  → "20"
3   → "3"
```

So this is **not numeric sorting**.

---

## 4. Numeric Ascending Sort

Use a compare function:

```js
const numbers = [1, 100, 20, 3];

numbers.sort((a, b) => a - b);

console.log(numbers);
```

Output:

```text
[1, 3, 20, 100]
```

Memory rule:

```text
(a, b) => a - b
→ ascending
```

---

## 5. Numeric Descending Sort

```js
const numbers = [1, 100, 20, 3];

numbers.sort((a, b) => b - a);

console.log(numbers);
```

Output:

```text
[100, 20, 3, 1]
```

Memory rule:

```text
(a, b) => b - a
→ descending
```

---

## 6. Compare Function

The compare function receives:

```js
(a, b)
```

It tells `sort()` which value should come first.

### Negative

```js
(a, b) => a - b
```

If result is negative:

```text
a comes before b
```

### Positive

```text
b comes before a
```

### Zero

```text
keep their relative order
```

This return-value rule is fundamental for interviews.

---

## 7. Simple Example

```js
const numbers = [30, 10];

numbers.sort((a, b) => a - b);
```

Compare:

```text
a = 30
b = 10

30 - 10 = 20
```

Positive:

```text
b comes first
```

So:

```text
[10, 30]
```

We will study the compare function much more carefully in Part 2.

---

## 8. String Sorting

For strings, use:

```js
const fruits = ["Banana", "Apple", "Orange"];

fruits.sort((a, b) => a.localeCompare(b));

console.log(fruits);
```

Output:

```text
["Apple", "Banana", "Orange"]
```

For reverse alphabetical order:

```js
fruits.sort((a, b) => b.localeCompare(a));
```

Remember:

```text
numbers → a - b
strings → localeCompare()
```

---

## 9. `sort()` vs `toSorted()`

`sort()`:

```js
const numbers = [3, 2, 1];

numbers.sort();

console.log(numbers);
```

Original changes.

`toSorted()`:

```js
const numbers = [3, 2, 1];

const sorted = numbers.toSorted();

console.log(numbers);
console.log(sorted);
```

Result:

```text
numbers → [3, 2, 1]
sorted  → [1, 2, 3]
```

So:

```text
sort()
→ mutates original

toSorted()
→ returns new array
```

Your source specifically highlights this distinction.

---

## 10. Basic Sorting Objects

Later we will go deeper, but understand the basic idea now:

```js
const users = [
    { name: "Om", age: 24 },
    { name: "Nakul", age: 30 },
    { name: "Pavan", age: 20 }
];

users.sort((a, b) => a.age - b.age);

console.log(users);
```

Result:

```text
Pavan → 20
Om    → 24
Nakul → 30
```

Pattern:

```text
(a, b) => a.property - b.property
```

---

# 11. When You Should Think of `sort()`

Use `sort()` when you need:

```text
ascending numbers
descending numbers
alphabetical strings
object sorting
leaderboards
price sorting
age sorting
date sorting
```

Examples:

```text
Products → price
Students → marks
Users → age
Employees → salary
Leaderboard → score
```

---

# Interview Essentials

### What does `sort()` do?

It rearranges array elements into an order.

### Does `sort()` mutate the original array?

Yes.

### How do you sort numbers ascending?

```js
(a, b) => a - b
```

### How do you sort numbers descending?

```js
(a, b) => b - a
```

### Why does `[1, 100, 20, 3].sort()` look wrong?

Because default sorting is string-based.

### `sort()` vs `toSorted()`?

```text
sort()     → mutates original
toSorted() → creates new sorted array
```

---

# Practice

### Exercise 1

Sort:

```js
const numbers = [50, 10, 30, 20];
```

ascending.

### Exercise 2

Sort the same array descending.

### Exercise 3

Sort:

```js
const names = ["Nakul", "Om", "Pavan"];
```

alphabetically.

### Exercise 4

Predict:

```js
const arr = [100, 2, 30];

arr.sort();

console.log(arr);
```

### Exercise 5

Explain why:

```js
[10, 2, 5].sort()
```

doesn't perform numeric ascending sorting.

---

# Part 1 Checkpoint

```text
[ ] I know what sort() does.
[ ] I know it mutates the original array.
[ ] I understand default string sorting.
[ ] I can sort numbers ascending.
[ ] I can sort numbers descending.
[ ] I understand compare function basics.
[ ] I know localeCompare().
[ ] I know sort() vs toSorted().
[ ] I can sort objects by a property.
```

### Memory Rule

```text
sort()
→ arrange elements

(a, b) => a - b
→ ascending numbers

(a, b) => b - a
→ descending numbers
```

**`sort()` Part 1 complete ✅**

Next → **Part 2: compare function dry runs, how `sort()` decides order, and output-based interview questions.**
