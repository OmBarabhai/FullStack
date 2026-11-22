# Part 1 — `filter()` Fundamentals

> **Goal:** Understand what `filter()` does, its syntax, callback basics, return value, and when to use it.

---

## 1. What is `filter()`?

`filter()` is used when you want to **select elements that satisfy a condition**.

```js
const numbers = [10, 25, 30, 15, 40];

const result = numbers.filter(num => num > 20);

console.log(result);
```

Output:

```text
[25, 30, 40]
```

Mental model:

```text
[10, 25, 30, 15, 40]
              ↓
           filter()
              ↓
       check each element
              ↓
       keep matching ones
              ↓
        [25, 30, 40]
```

---

## 2. Basic Syntax

```js
const result = array.filter(callback);
```

Common syntax:

```js
const result = numbers.filter(num => num > 20);
```

The callback answers:

> **"Should this element be kept?"**

---

## 3. Callback Function

The function passed to `filter()` is the callback.

```js
const numbers = [5, 10, 15, 20];

const result = numbers.filter(num => num >= 15);

console.log(result);
```

Output:

```text
[15, 20]
```

Flow:

```text
5  → false → discard
10 → false → discard
15 → true  → keep
20 → true  → keep
```

---

## 4. Callback Parameters

The callback can receive:

```js
array.filter((element, index, array) => {
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

numbers.filter((value, index) => {
    console.log(index, value);
    return true;
});
```

Output:

```text
0 10
1 20
2 30
```

Most of the time you only need:

```js
numbers.filter(num => num > 10);
```

---

## 5. Return Value

`filter()` returns a **new array** containing only the elements that pass the condition.

```js
const numbers = [5, 10, 15, 20];

const result = numbers.filter(num => num >= 15);

console.log(numbers);
console.log(result);
```

Output:

```text
[5, 10, 15, 20]
[15, 20]
```

So:

```text
Original array → unchanged
Result        → new array
```

---

## 6. `filter()` vs `map()`

This is one of the most important distinctions.

### `map()`

Transforms every element:

```js
const result = numbers.map(num => num * 2);
```

```text
1 → 2
2 → 4
3 → 6
```

### `filter()`

Selects elements:

```js
const result = numbers.filter(num => num > 2);
```

```text
1 → discard
2 → discard
3 → keep
```

Remember:

```text
map    → transform
filter → select
```

---

## 7. Simple Examples

### Even Numbers

```js
const numbers = [1, 2, 3, 4, 5, 6];

const even = numbers.filter(
    num => num % 2 === 0
);

console.log(even);
```

Output:

```text
[2, 4, 6]
```

### Numbers Greater Than 100

```js
const numbers = [50, 120, 200, 80];

const result = numbers.filter(
    num => num > 100
);

console.log(result);
```

Output:

```text
[120, 200]
```

### Strings

```js
const names = ["Om", "Raj", "Rahul", "Amit"];

const result = names.filter(
    name => name.length > 3
);

console.log(result);
```

Output:

```text
["Rahul", "Amit"]
```

---

## 8. Filtering Objects

This is extremely important for real projects.

```js
const users = [
    { name: "Om", active: true },
    { name: "Raj", active: false },
    { name: "Amit", active: true }
];

const activeUsers = users.filter(
    user => user.active
);

console.log(activeUsers);
```

Result:

```js
[
    { name: "Om", active: true },
    { name: "Amit", active: true }
]
```

Notice that `filter()` returns the **whole matching object**.

---

## 9. When Should You Use `filter()`?

Use `filter()` when:

```text
You have an array
      ↓
You want to keep only matching elements
      ↓
You need a new array
```

Examples:

```js
users.filter(user => user.active);

products.filter(product => product.inStock);

students.filter(student => student.marks >= 40);
```

---

## 10. Quick Method Selection

```text
Transform every element
        ↓
      map()

Select matching elements
        ↓
     filter()

Find one matching element
        ↓
      find()
```

This distinction will become increasingly important as you learn the remaining array methods.

---

## 11. Hands-on Practice

Write these yourself.

### Exercise 1

```js
const numbers = [1, 2, 3, 4, 5, 6];
```

Return only even numbers.

### Exercise 2

```js
const numbers = [10, 50, 120, 200];
```

Return numbers greater than `100`.

### Exercise 3

```js
const names = ["Om", "Rahul", "Raj", "Amit"];
```

Return names with length greater than `3`.

### Exercise 4

```js
const students = [
    { name: "Om", marks: 90 },
    { name: "Raj", marks: 35 },
    { name: "Amit", marks: 75 }
];
```

Return students who passed with marks `>= 40`.

### Exercise 5 — Predict Output

```js
const numbers = [10, 20, 30];

const result = numbers.filter(
    num => num >= 20
);

console.log(result);
```

---

# Part 1 Checkpoint

Before moving to Part 2, you should be able to answer:

```text
What does filter() do?
What does it return?
What should the callback decide?
What are the callback parameters?
Does filter() modify the original array?
What is the difference between map() and filter()?
```

### One-line memory rule

```text
filter() = select matching elements → new array
```

**Part 1 complete.**
# Part 2 — `filter()` Internal Working & Callback Flow

> **Goal:** Understand how `filter()` processes each element, how the callback decides whether to keep it, and how to dry-run it confidently.

---

## 1. How `filter()` Works

Consider:

```js
const numbers = [5, 10, 15];

const result = numbers.filter(num => num > 8);
```

Conceptually:

```text
numbers
   ↓
filter()
   ↓
take current element
   ↓
call callback
   ↓
truthy?
   ├── yes → keep element
   └── no  → discard element
   ↓
next element
   ↓
repeat
   ↓
return new array
```

The important difference from `map()`:

```text
map()
 ↓
callback returns a value
 ↓
value goes into result

filter()
 ↓
callback decides keep/discard
 ↓
original element goes into result
```

---

## 2. Step-by-Step Execution

```js
const numbers = [5, 10, 15];

const result = numbers.filter(num => num > 8);
```

### First element

```text
5
↓
5 > 8
↓
false
↓
discard
```

Result:

```text
[]
```

### Second element

```text
10
↓
10 > 8
↓
true
↓
keep 10
```

Result:

```text
[10]
```

### Third element

```text
15
↓
15 > 8
↓
true
↓
keep 15
```

Final result:

```text
[10, 15]
```

---

## 3. Callback Return Controls the Result

The callback does **not** need to literally return `true` or `false`.

It returns a value that `filter()` evaluates as truthy or falsy.

Example:

```js
const numbers = [1, 2, 3];

const result = numbers.filter(() => true);

console.log(result);
```

Output:

```text
[1, 2, 3]
```

Because `true` is truthy.

Example:

```js
const result = numbers.filter(() => false);

console.log(result);
```

Output:

```text
[]
```

Because `false` is falsy.

In normal code, however, prefer clear conditions:

```js
numbers.filter(num => num > 10);
```

---

## 4. Truthy and Falsy

Important falsy values include:

```text
false
0
""
null
undefined
NaN
```

Truthy examples include:

```text
true
1
-1
"hello"
[]
{}
```

So:

```js
const numbers = [1, 2, 3];

const result = numbers.filter(() => 1);

console.log(result);
```

returns:

```text
[1, 2, 3]
```

because `1` is truthy.

But:

```js
const result = numbers.filter(() => 0);
```

returns:

```text
[]
```

because `0` is falsy.

### Practical rule

Use:

```js
num => num > 10
```

rather than deliberately returning random truthy/falsy values.

---

## 5. Callback Parameters

The callback can receive:

```js
array.filter((element, index, array) => {
    // ...
});
```

Example:

```js
const numbers = [10, 20, 30];

const result = numbers.filter((value, index) => {
    console.log(index, value);

    return value > 10;
});
```

Output during execution:

```text
0 10
1 20
2 30
```

Result:

```text
[20, 30]
```

Third parameter:

```js
const numbers = [10, 20, 30];

numbers.filter((value, index, array) => {
    console.log(array);
    return true;
});
```

The third parameter is the original array.

Most code only needs:

```js
numbers.filter(num => num > 10);
```

---

## 6. Why `return` Matters

This works:

```js
const result = numbers.filter(num => num > 10);
```

This also works:

```js
const result = numbers.filter(num => {
    return num > 10;
});
```

But this does not:

```js
const result = numbers.filter(num => {
    num > 10;
});
```

Why?

```text
callback runs
      ↓
no return
      ↓
undefined
      ↓
undefined is falsy
      ↓
element discarded
```

Therefore:

```text
[10, 20, 30]
      ↓
all callbacks return undefined
      ↓
[]
```

This is a very common OA/interview trap.

---

## 7. `filter()` Keeps the Original Element

This is important when filtering objects.

```js
const users = [
    { name: "Om", active: true },
    { name: "Raj", active: false }
];

const activeUsers = users.filter(
    user => user.active
);
```

The result contains the matching **original object references**.

```text
users
  ↓
Object A ← active
Object B ← inactive

filter()
  ↓

activeUsers
  ↓
Object A
```

So `filter()` creates a new array, but it does not clone the objects inside it.

---

## 8. Dry Run Practice

Try this before looking at the answer:

```js
const numbers = [2, 4, 7, 8];

const even = numbers.filter(
    num => num % 2 === 0
);
```

Dry run:

```text
2 → 2 % 2 === 0 → true  → keep
4 → 4 % 2 === 0 → true  → keep
7 → 7 % 2 === 0 → false → discard
8 → 8 % 2 === 0 → true  → keep
```

Final:

```text
[2, 4, 8]
```

---

## 9. Another Dry Run

```js
const numbers = [10, 15, 20];

const result = numbers.filter(
    (num, index) => num > index * 10
);
```

Think:

```text
index 0:
10 > 0  → true

index 1:
15 > 10 → true

index 2:
20 > 20 → false
```

Result:

```text
[10, 15]
```

---

## 10. `filter()` vs `map()` — Internal Difference

### `map()`

```text
Element
   ↓
Callback
   ↓
Returned value
   ↓
Result array
```

Example:

```js
[1, 2, 3].map(x => x * 10);
```

Result:

```text
[10, 20, 30]
```

### `filter()`

```text
Element
   ↓
Callback
   ↓
Truthy?
 ┌───┴───┐
yes     no
 ↓       ↓
keep   discard
```

Example:

```js
[1, 2, 3].filter(x => x > 1);
```

Result:

```text
[2, 3]
```

---

## 11. What You Need to Remember

```text
filter()
 ↓
visits each processed element
 ↓
runs callback
 ↓
truthy?
 ↓
keep / discard
 ↓
return new array
```

And:

```text
map()
→ changes each element into a new value

filter()
→ decides which elements remain
```

---

# Part 2 Checkpoint

You should now be able to explain:

```text
[x] How filter() executes
[x] How the callback controls keep/discard
[x] Truthy vs falsy in filter()
[x] Callback parameters
[x] Why missing return gives []
[x] Why filter() returns original object references
[x] Difference between map() and filter()
[x] Dry-run a filter() call
```

**Next → Part 3: `filter()` with objects, strings, multiple conditions, API data, React, and real-world patterns.**
# Part 3 — `filter()` with Objects, Conditions & Real-world Data

> **Goal:** Learn how to use `filter()` with real application data such as users, products, API responses, React state, and Node.js results.

---

## 1. Filtering Objects

One of the most common uses of `filter()` is selecting objects from an array.

```js
const students = [
    { name: "Om", marks: 92 },
    { name: "Nakul", marks: 70 },
    { name: "Pavan", marks: 85 }
];

const toppers = students.filter(
    student => student.marks >= 80
);

console.log(toppers);
```

Result:

```js
[
    { name: "Om", marks: 92 },
    { name: "Pavan", marks: 85 }
]
```

`filter()` keeps the **whole matching element**.

---

## 2. Filtering Boolean Properties

```js
const users = [
    { id: 1, name: "Om", active: true },
    { id: 2, name: "Nakul", active: false },
    { id: 3, name: "Pavan", active: true }
];

const activeUsers = users.filter(
    user => user.active
);

console.log(activeUsers);
```

Result:

```js
[
    { id: 1, name: "Om", active: true },
    { id: 3, name: "Pavan", active: true }
]
```

This pattern is very common for users, products, orders, and tasks.

---

## 3. Multiple Conditions

### AND — `&&`

Both conditions must be true.

```js
const employees = [
    { name: "Om", age: 24, salary: 50000 },
    { name: "Nakul", age: 20, salary: 30000 },
    { name: "Pavan", age: 30, salary: 60000 }
];

const result = employees.filter(employee =>
    employee.age >= 25 &&
    employee.salary >= 50000
);

console.log(result);
```

Result:

```js
[
    { name: "Pavan", age: 30, salary: 60000 }
]
```

Mental model:

```text
A && B

A must be true
AND
B must be true
```

---

### OR — `||`

At least one condition must be true.

```js
const result = employees.filter(employee =>
    employee.salary >= 60000 ||
    employee.age <= 20
);

console.log(result);
```

---

## 4. Negating a Condition

Use `!` when you want the opposite condition.

```js
const users = [
    { id: 1, name: "Om", active: true },
    { id: 2, name: "Nakul", active: false },
    { id: 3, name: "Pavan", active: true }
];

const inactiveUsers = users.filter(
    user => !user.active
);

console.log(inactiveUsers);
```

Result:

```js
[
    { id: 2, name: "Nakul", active: false }
]
```

---

## 5. Filtering Strings

```js
const names = [
    "Om",
    "Nakul",
    "Pavan"
];

const result = names.filter(
    name => name.length > 3
);

console.log(result);
```

Output:

```text
["Nakul", "Pavan"]
```

Other common conditions:

```js
names.filter(name => name.startsWith("P"));

names.filter(name => name.endsWith("n"));

names.filter(name => name.includes("a"));
```

---

## 6. Filtering Nested Arrays

```js
const matrix = [
    [1, 2],
    [3, 4],
    [5, 6]
];

const result = matrix.filter(
    row => row[0] > 2
);

console.log(result);
```

Output:

```text
[
    [3, 4],
    [5, 6]
]
```

Here each `row` is treated as one element.

---

## 7. `filter()` + `map()`

This is one of the most important practical patterns.

```js
const users = [
    { id: 1, name: "Om", verified: true },
    { id: 2, name: "Nakul", verified: false },
    { id: 3, name: "Pavan", verified: true }
];

const verifiedNames = users
    .filter(user => user.verified)
    .map(user => user.name);

console.log(verifiedNames);
```

Output:

```text
["Om", "Pavan"]
```

Flow:

```text
All Users
   ↓
filter()
   ↓
Verified Users
   ↓
map()
   ↓
Names
```

Remember:

```text
filter → select
map    → transform
```

---

## 8. API Data Transformation

Suppose an API returns:

```js
const users = [
    { id: 1, name: "Om", verified: true },
    { id: 2, name: "Nakul", verified: false },
    { id: 3, name: "Pavan", verified: true }
];
```

Get only verified users:

```js
const verifiedUsers = users.filter(
    user => user.verified
);
```

Get only their names:

```js
const verifiedNames = users
    .filter(user => user.verified)
    .map(user => user.name);
```

Output:

```text
["Om", "Pavan"]
```

This kind of data transformation appears frequently in web applications.

---

## 9. React Usage

Display only active users:

```jsx
users
    .filter(user => user.active)
    .map(user => (
        <UserCard
            key={user.id}
            user={user}
        />
    ));
```

With:

```js
const users = [
    { id: 1, name: "Om", active: true },
    { id: 2, name: "Nakul", active: false },
    { id: 3, name: "Pavan", active: true }
];
```

Mental model:

```text
React state
    ↓
filter()
    ↓
relevant data
    ↓
map()
    ↓
UI
```

---

## 10. Node.js Usage

Filtering users:

```js
const users = [
    { id: 1, name: "Om", active: true },
    { id: 2, name: "Nakul", active: false },
    { id: 3, name: "Pavan", active: true }
];

const activeUsers = users.filter(
    user => user.active
);
```

Then transform them:

```js
const names = activeUsers.map(
    user => user.name
);

console.log(names);
```

Output:

```text
["Om", "Pavan"]
```

---

## 11. Object Reference Behavior

Important interview point:

```js
const users = [
    {
        id: 1,
        name: "Om",
        active: true
    }
];

const result = users.filter(
    user => user.active
);
```

`result` is a **new array**, but the object inside can still be the same reference.

```text
users
  ↓
Object A

result
  ↓
Object A
```

Therefore:

```js
result[0].name = "Nakul";

console.log(users[0].name);
```

Output:

```text
Nakul
```

Why?

```text
New array
   ≠
New objects
```

---

## 12. `filter()` Is Not for Transformation

Wrong:

```js
const result = numbers.filter(
    num => num * 2
);
```

This does not double the values.

The expression `num * 2` is used as a truthy/falsy condition.

Use:

```js
const result = numbers.map(
    num => num * 2
);
```

---

## 13. `filter()` vs `find()`

If you need **all matching elements**:

```js
users.filter(
    user => user.id === 1
);
```

If you need **one matching element**:

```js
users.find(
    user => user.id === 1
);
```

Remember:

```text
filter → array of matches
find   → first match
```

---

## 14. Real-world Challenge

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

Solve:

### Task 1

Return products that are in stock.

### Task 2

Return products with price greater than `2000`.

### Task 3

Return names of products that are in stock.

Use:

```text
filter()
+
map()
```

### Task 4

Return products where:

```text
inStock === true
AND
price > 2000
```


**Part 3 complete.**

# Part 3 Checkpoint

You should now be able to:

```text
[x] Filter arrays of objects
[x] Filter using boolean properties
[x] Use && and ||
[x] Negate conditions with !
[x] Filter strings
[x] Filter nested arrays
[x] Combine filter() + map()
[x] Process API-style data
[x] Use filter() in React
[x] Use filter() in Node.js
[x] Understand object-reference behavior
[x] Know when find() is better than filter()
```

### One-line memory rule

```text
filter() = keep elements that satisfy the condition
```

**Part 3 complete.**


# Part 4 — `filter()` Pitfalls, Polyfill, Interview & Project Practice

> **Goal:** Finish `filter()` at the level needed for interviews, OAs, and real projects. You should be able to explain its behavior, debug it, choose it correctly, and implement a basic `myFilter()`.

---

## 1. The Core Rule

Remember:

```text
       filter()
         ↓
    visit each element
         ↓
    run callback
         ↓
       truthy?
 ┌───────┴───────┐
yes             no
 ↓               ↓
keep           discard
 └───────┬───────┘
         ↓
   new result array
```

Example:

```js
const numbers = [10, 20, 30, 40];

const result = numbers.filter(
    num => num > 20
);

console.log(result);
```

Output:

```text
[30, 40]
```

---

# 2. Pitfall — Forgetting `return`

Wrong:

```js
const result = [10, 20, 30].filter(num => {
    num > 10;
});

console.log(result);
```

Output:

```text
[]
```

Why?

```text
callback
   ↓
no return
   ↓
undefined
   ↓
falsy
   ↓
discard
```

Correct:

```js
const result = [10, 20, 30].filter(num => {
    return num > 10;
});
```

Or:

```js
const result = [10, 20, 30].filter(num => num > 10);
```

---

# 3. Pitfall — Truthy vs Falsy

`filter()` keeps an element when the callback result is truthy.

For example:

```js
const numbers = [1, 2, 3];

const result = numbers.filter(() => 1);
```

Output:

```text
[1, 2, 3]
```

Because `1` is truthy.

But:

```js
const result = numbers.filter(() => 0);
```

Output:

```text
[]
```

Because `0` is falsy.

For real projects, prefer clear conditions:

```js
users.filter(user => user.active);
```

rather than intentionally returning arbitrary truthy values.

---

# 4. Pitfall — `filter()` vs `find()`

Suppose:

```js
const users = [
    { id: 1, name: "Om" },
    { id: 2, name: "Nakul" },
    { id: 3, name: "Pavan" }
];
```

Need all matching users:

```js
const result = users.filter(
    user => user.id > 1
);
```

Result:

```js
[
    { id: 2, name: "Nakul" },
    { id: 3, name: "Pavan" }
]
```

Need one matching user:

```js
const result = users.find(
    user => user.id === 2
);
```

Result:

```js
{ id: 2, name: "Nakul" }
```

Remember:

```text
filter → array of matches
find   → first matching element
```

---

# 5. Pitfall — `filter()` vs `some()`

Need the matching elements:

```js
const activeUsers = users.filter(
    user => user.active
);
```

Need only to know whether at least one exists:

```js
const hasActiveUser = users.some(
    user => user.active
);
```

Remember:

```text
filter → returns elements
some   → returns boolean
```

---

# 6. Pitfall — `filter()` vs `every()`

```js
const allAdults = users.every(
    user => user.age >= 18
);
```

This asks:

> "Does every user satisfy the condition?"

Whereas:

```js
const adults = users.filter(
    user => user.age >= 18
);
```

asks:

> "Which users satisfy the condition?"

---

# 7. Pitfall — Object References

```js
const users = [
    { name: "Om", active: true },
    { name: "Nakul", active: false },
    { name: "Pavan", active: true }
];

const result = users.filter(
    user => user.active
);
```

`result` is a new array, but matching objects are still the same object references.

So:

```js
result[0].name = "Nakul";

console.log(users[0].name);
```

Output:

```text
Nakul
```

Important:

```text
new array
   ≠
new objects
```

---

# 8. Performance

For `n` elements:

```text
Time  → O(n)
Space → O(n)
```

Why?

`filter()` checks each processed element and creates a result array.

Don't over-focus on optimization here. For normal application code, choosing the correct method and keeping the condition clear matters more.

---

# 9. Build Your Own `myFilter()`

This is the most useful implementation exercise for interviews.

```js
function myFilter(arr, callback) {
    const result = [];

    for (let i = 0; i < arr.length; i++) {
        if (callback(arr[i], i, arr)) {
            result.push(arr[i]);
        }
    }

    return result;
}
```

Test:

```js
const numbers = [1, 2, 3, 4, 5];

const result = myFilter(
    numbers,
    num => num % 2 === 0
);

console.log(result);
```

Output:

```text
[2, 4]
```

---

# 10. Understand `myFilter()`

Don't memorize it.

Understand:

```text
myFilter(arr, callback)
        ↓
create result[]
        ↓
visit each element
        ↓
call callback(element, index, arr)
        ↓
truthy?
   ↓ yes
push original element
        ↓
continue
        ↓
return result
```

The key difference from `myMap()`:

```text
myMap()
    ↓
push callback result

myFilter()
    ↓
push original element
    ↓
only when callback is truthy
```

---

# 11. Write `myFilter()` From Memory

Now close your notes and implement:

```js
function myFilter(arr, callback) {
    // your implementation
}
```

Requirements:

```text
[ ] accepts array
[ ] accepts callback
[ ] passes element
[ ] passes index
[ ] passes original array
[ ] checks callback result
[ ] keeps matching element
[ ] returns new array
```

---

# 12. Interview Questions

### What is `filter()`?

A method that creates a new array containing elements whose callback result is truthy.

### Does `filter()` modify the original array?

The array itself is not modified.

### What does the callback receive?

```text
element
index
original array
```

### What happens if the callback returns `undefined`?

The element is discarded because `undefined` is falsy.

### Does `filter()` stop after finding a match?

No. It continues through the remaining processed elements.

### What is the complexity?

```text
Time  → O(n)
Space → O(n)
```

### `filter()` vs `find()`?

```text
filter → all matching elements
find   → first matching element
```

### `filter()` vs `some()`?

```text
filter → new array
some   → boolean
```

### Can `filter()` return objects?

Yes. It returns the matching original elements.

---

# 13. OA Output Practice

### Question 1

```js
const result = [1, 2, 3].filter(
    num => num > 1
);

console.log(result);
```

Answer:

```text
[2, 3]
```

---

### Question 2

```js
const result = [1, 2, 3].filter(() => true);

console.log(result);
```

Answer:

```text
[1, 2, 3]
```

---

### Question 3

```js
const result = [1, 2, 3].filter(() => false);

console.log(result);
```

Answer:

```text
[]
```

---

### Question 4

```js
const result = [1, 2, 3].filter(num => {
    num > 1;
});

console.log(result);
```

Answer:

```text
[]
```

Reason:

```text
no return
→ undefined
→ falsy
```

---

### Question 5

```js
const users = [
    { name: "Om", active: true },
    { name: "Nakul", active: false },
    { name: "Pavan", active: true }
];

const result = users.filter(
    user => user.active
);

result[0].name = "Nakul";

console.log(users[0].name);
```

Answer:

```text
Nakul
```

Reason:

```text
same object reference
```

---

# 14. Final Project Challenge

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

Implement:

### Task 1

Get all products in stock.

### Task 2

Get products costing more than `2000`.

### Task 3

Get products that are both:

```text
inStock === true
AND
price > 2000
```

### Task 4

Get names of products satisfying Task 3:

```js
filter()
+
map()
```

### Task 5

Implement `myFilter()` and solve Task 2 using your own method.

---

# 15. Final Method Selection

```text
Transform every element
        ↓
      map()

Select matching elements
        ↓
     filter()

Find first match
        ↓
      find()

Find index
        ↓
   findIndex()

At least one?
        ↓
      some()

All?
        ↓
     every()

Build one result
        ↓
     reduce()

Perform an action
        ↓
    forEach()
```

---

# 16. Completion Checklist

Before moving to `04-find.md`:

```text
[x] I can explain filter() in one sentence.
[x] I can use filter() without notes.
[x] I understand truthy/falsy in filter().
[x] I understand the callback parameters.
[x] I can filter objects.
[x] I can use &&, ||, and !.
[x] I know filter() vs map().
[x] I know filter() vs find().
[x] I know filter() vs some().
[x] I understand object-reference behavior.
[x] I know O(n) time and O(n) result-space.
[x] I can implement myFilter() from memory.
[x] I can solve a project-style filtering problem.
[x] I can predict common OA outputs.
```

---

# Final Takeaway

```text
filter()
   ↓
check every processed element
   ↓
callback decides keep/discard
   ↓
keep original matching element
   ↓
return new array
```

### One-line memory rule

> **`filter()` = select elements that satisfy a condition.**

`filter()` is now complete. ✅

**Next → `04-find.md`**
