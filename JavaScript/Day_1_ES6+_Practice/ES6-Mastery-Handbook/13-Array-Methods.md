# Array Methods

> **"Array Methods are built-in functions that make working with arrays easier, shorter, and more readable. Modern JavaScript relies heavily on these methods instead of traditional loops."**

---

# Table of Contents

1. Introduction
2. Why Array Methods?
3. Mutating vs Non-Mutating Methods
4. forEach()
5. map()
6. filter()
7. find()
8. findIndex()
9. some()
10. every()
11. reduce()
12. sort()
13. reverse()
14. includes()
15. indexOf()
16. flat()
17. flatMap()
18. Chaining Methods
19. Real-world Examples
20. React Examples
21. Node.js Examples
22. Performance Notes
23. Best Practices
24. Common Mistakes
25. Interview Questions
26. Coding Exercises
27. Summary

---

# 1. Introduction

Arrays are one of the most commonly used data structures in JavaScript.

Example

```js
const numbers = [10, 20, 30, 40];
```

Instead of manually looping,

```js
for(let i = 0; i < numbers.length; i++){
    console.log(numbers[i]);
}
```

Modern JavaScript provides powerful built-in methods.

```js
numbers.forEach(num => console.log(num));
```

---

# 2. Why Array Methods?

Before ES5

```js
let doubled = [];

for (let i = 0; i < numbers.length; i++) {
    doubled.push(numbers[i] * 2);
}
```

ES6+

```js
const doubled = numbers.map(num => num * 2);
```

Benefits

- Cleaner
- Less code
- Easier to read
- Functional programming
- Used in React everywhere

---

# 3. Mutating vs Non-Mutating Methods

## Non-Mutating (Recommended)

They return a new array.

```
map()

filter()

find()

reduce()

slice()

concat()

flat()

flatMap()
```

Original array remains unchanged.

---

## Mutating

They modify the original array.

```
sort()

reverse()

splice()

push()

pop()

shift()

unshift()
```

Interview Question:

> Which methods modify the original array?

---

# 4. forEach()

Purpose

Execute a function for every element.

Returns

```
undefined
```

Example

```js
const numbers = [1,2,3];

numbers.forEach(num => {
    console.log(num);
});
```

Output

```
1
2
3
```

Use Case

- Logging
- DOM updates
- API processing

Don't use it when you need a new array.

---

# 5. map()

Purpose

Transform every element.

Returns

```
New Array
```

Example

```js
const numbers = [1,2,3];

const doubled =
numbers.map(num => num * 2);

console.log(doubled);
```

Output

```
[2,4,6]
```

Visualization

```
1 → 2

2 → 4

3 → 6
```

---

# 6. filter()

Purpose

Keep only matching elements.

Returns

```
New Array
```

Example

```js
const numbers = [1,2,3,4,5];

const even =
numbers.filter(num => num % 2 === 0);

console.log(even);
```

Output

```
[2,4]
```

Visualization

```
1 ❌

2 ✅

3 ❌

4 ✅

5 ❌
```

---

# 7. find()

Purpose

Return the first matching element.

Example

```js
const users = [
    {id:1},
    {id:2},
    {id:3}
];

const user =
users.find(u => u.id === 2);

console.log(user);
```

Output

```js
{
id:2
}
```

If not found

```
undefined
```

---

# 8. findIndex()

Purpose

Return the index of the first matching element.

Example

```js
const numbers = [5,10,15];

const index =
numbers.findIndex(n => n === 10);

console.log(index);
```

Output

```
1
```

Not found

```
-1
```

---

# 9. some()

Purpose

Check if at least one element satisfies the condition.

Example

```js
const numbers = [2,4,6,7];

console.log(
numbers.some(num => num % 2 !== 0)
);
```

Output

```
true
```

---

# 10. every()

Purpose

Check whether every element satisfies the condition.

Example

```js
const numbers = [2,4,6];

console.log(
numbers.every(num => num % 2 === 0)
);
```

Output

```
true
```

---

# 11. reduce()

Purpose

Reduce an array into a single value.

Example

```js
const numbers = [1,2,3,4];

const sum =
numbers.reduce(
(total,current)=>
total + current,
0
);

console.log(sum);
```

Output

```
10
```

Visualization

```
0

↓

1

↓

3

↓

6

↓

10
```

Used for

- Sum
- Average
- Maximum
- Grouping
- Frequency Counter

---

# 12. sort()

Purpose

Sort elements.

Example

```js
const numbers = [4,2,8];

numbers.sort();

console.log(numbers);
```

Output

```
[2,4,8]
```

Problem

```js
const numbers = [100,20,3];

numbers.sort();
```

Output

```
[100,20,3]
```

Because sort compares strings.

Correct

```js
numbers.sort(
(a,b)=>a-b
);
```

Output

```
[3,20,100]
```

---

# 13. reverse()

Purpose

Reverse the array.

Example

```js
const numbers = [1,2,3];

numbers.reverse();

console.log(numbers);
```

Output

```
[3,2,1]
```

Mutates original array.

---

# 14. includes()

Purpose

Check whether a value exists.

```js
const fruits =
["Apple","Banana"];

console.log(
fruits.includes("Banana")
);
```

Output

```
true
```

---

# 15. indexOf()

Purpose

Return the first occurrence index.

```js
const colors =
["Red","Blue"];

console.log(
colors.indexOf("Blue")
);
```

Output

```
1
```

---

# 16. flat()

Purpose

Flatten nested arrays.

```js
const arr =
[1,[2,[3]]];

console.log(
arr.flat(2)
);
```

Output

```
[1,2,3]
```

---

# 17. flatMap()

Equivalent to

```
map()

+

flat(1)
```

Example

```js
const words =
["hello world"];

const result =
words.flatMap(
word=>word.split(" ")
);

console.log(result);
```

Output

```
["hello","world"]
```

---

# 18. Chaining Methods

Example

```js
const numbers =
[1,2,3,4,5];

const result =
numbers
.filter(n=>n%2===0)
.map(n=>n*10);

console.log(result);
```

Output

```
[20,40]
```

Visualization

```
Array

↓

filter()

↓

map()

↓

Result
```

---

# 19. Real-world Examples

Shopping Cart

```js
const total =
cart.reduce(
(sum,item)=>
sum+item.price,
0
);
```

User Search

```js
const user =
users.find(
u=>u.id===10
);
```

Products

```js
const expensive =
products.filter(
p=>p.price>500
);
```

---

# 20. React Examples

Rendering

```jsx
users.map(user=>(
<UserCard
key={user.id}
user={user}
/>
))
```

Filtering

```jsx
products
.filter(
p=>p.inStock
)
.map(...)
```

---

# 21. Node.js Examples

MongoDB Results

```js
const emails =
users.map(
u=>u.email
);
```

API Response

```js
const active =
users.filter(
u=>u.active
);
```

---

# 22. Performance Notes

Approximate Time Complexity

| Method | Complexity |
|----------|-----------|
| forEach | O(n) |
| map | O(n) |
| filter | O(n) |
| find | O(n) |
| findIndex | O(n) |
| some | O(n) |
| every | O(n) |
| reduce | O(n) |
| includes | O(n) |
| indexOf | O(n) |
| sort | O(n log n) |
| reverse | O(n) |
| flat | O(n) |
| flatMap | O(n) |

---

# 23. Best Practices

✅ Use `map()` for transformations.

✅ Use `filter()` for selection.

✅ Use `find()` when only one element is needed.

✅ Use `reduce()` for aggregation.

✅ Avoid mutating arrays unless required.

---

# 24. Common Mistakes

❌ Using `map()` without returning a value.

```js
numbers.map(num => {
    num * 2;
});
```

Returns

```
[undefined, undefined, undefined]
```

---

❌ Using `filter()` expecting a single object.

Use `find()` instead.

---

❌ Forgetting comparator in `sort()`.

---

❌ Using `forEach()` expecting a returned array.

It returns

```
undefined
```

---

# 25. Interview Questions

### Difference between `map()` and `forEach()`?

| map() | forEach() |
|--------|-----------|
| Returns new array | Returns undefined |
| Transformation | Side effects |

---

### Difference between `find()` and `filter()`?

`find()`

Returns first match.

`filter()`

Returns all matches.

---

### Difference between `some()` and `every()`?

`some()`

At least one match.

`every()`

All must match.

---

### When should you use `reduce()`?

When reducing an array into a single value.

Examples

- Sum
- Average
- Maximum
- Frequency Map

---

### Which methods mutate arrays?

- sort()
- reverse()
- splice()
- push()
- pop()
- shift()
- unshift()

---

# 26. Coding Exercises

### Exercise 1

Double every number using `map()`.

---

### Exercise 2

Return all even numbers using `filter()`.

---

### Exercise 3

Find the first student with grade `"A"`.

---

### Exercise 4

Calculate the total cart value using `reduce()`.

---

### Exercise 5

Sort an array numerically.

---

### Exercise 6

Chain `filter()` and `map()` to return doubled even numbers.

---

# 27. Summary

- Array methods simplify working with arrays.
- Prefer `map()` for transformations.
- Prefer `filter()` for selecting elements.
- Use `find()` for a single result.
- Use `reduce()` for aggregation.
- Be careful with mutating methods like `sort()` and `reverse()`.
- Method chaining is widely used in React and modern JavaScript.
- Array methods are among the most frequently asked topics in JavaScript interviews.

---

# What's Next?

➡️ **14-Object-Methods.md**

You'll learn:

- `Object.keys()`
- `Object.values()`
- `Object.entries()`
- `Object.assign()`
- `Object.freeze()`
- `Object.seal()`
- `Object.hasOwn()`
- Real-world examples
- React & Node.js usage
- Interview questions
- Coding exercises