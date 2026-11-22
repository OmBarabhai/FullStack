# `reduce()`

> **`reduce()` processes an array and combines its elements into one final result using an accumulator.**

# Part 1 — Fundamentals

## 1. What is `reduce()`?

Suppose:

```js
const numbers = [10, 20, 30, 40];
```

We want the total:

```text
100
```

Using `reduce()`:

```js
const sum = numbers.reduce(
    (total, num) => total + num,
    0
);

console.log(sum);
```

Output:

```text
100
```

The basic idea is:

```text
Array
  ↓
reduce()
  ↓
running result
  ↓
final result
```

---

## 2. Basic Syntax

```js
array.reduce(callback, initialValue);
```

Example:

```js
const result = numbers.reduce(
    (accumulator, currentValue) => {
        return accumulator + currentValue;
    },
    0
);
```

Short form:

```js
const result = numbers.reduce(
    (acc, num) => acc + num,
    0
);
```

---

## 3. The Accumulator

The **accumulator** stores the running result.

```js
const numbers = [10, 20, 30];

const sum = numbers.reduce(
    (acc, num) => acc + num,
    0
);
```

Think:

```text
Start
acc = 0

0 + 10 = 10

10 + 20 = 30

30 + 30 = 60
```

Final:

```text
60
```

So:

```text
accumulator = running result
```

---

## 4. Initial Value

The second argument:

```js
0
```

is the initial accumulator value.

```js
const sum = numbers.reduce(
    (acc, num) => acc + num,
    0
);
```

For multiplication:

```js
const product = [2, 3, 4].reduce(
    (acc, num) => acc * num,
    1
);

console.log(product);
```

Output:

```text
24
```

Common starting values:

```text
sum       → 0
product   → 1
array     → []
object    → {}
```

For your learning, remember mainly:

```text
number → 0 / 1
array  → []
object → {}
```

---

## 5. What Does `reduce()` Return?

It returns **one final value**.

That value can be:

```text
number
string
object
array
boolean
```

Examples later will use objects and arrays.

For now, understand:

```text
map()
→ usually returns an array

reduce()
→ returns one final result
```

---

## 6. First Examples

### Sum

```js
const sum = [10, 20, 30].reduce(
    (acc, num) => acc + num,
    0
);

console.log(sum);
```

Output:

```text
60
```

### Product

```js
const product = [2, 3, 4].reduce(
    (acc, num) => acc * num,
    1
);

console.log(product);
```

Output:

```text
24
```

### Count

```js
const count = [10, 20, 30, 40].reduce(
    acc => acc + 1,
    0
);

console.log(count);
```

Output:

```text
4
```

---

## 7. `reduce()` vs `map()`

### `map()`

```js
const result = [1, 2, 3].map(
    num => num * 2
);
```

Result:

```text
[2, 4, 6]
```

It transforms each element.

### `reduce()`

```js
const result = [1, 2, 3].reduce(
    (sum, num) => sum + num,
    0
);
```

Result:

```text
6
```

Remember:

```text
map()
→ many values → many values

reduce()
→ many values → one result
```

---

## 8. `reduce()` vs `filter()`

```text
filter()
→ select elements

reduce()
→ combine/process elements
```

Example:

```js
const numbers = [10, 20, 30];

const filtered = numbers.filter(
    num => num > 10
);

// [20, 30]
```

Whereas:

```js
const total = numbers.reduce(
    (sum, num) => sum + num,
    0
);

// 60
```

---

## 9. Why `return` Matters

Correct:

```js
const sum = [1, 2, 3].reduce(
    (acc, num) => {
        return acc + num;
    },
    0
);
```

Wrong:

```js
const sum = [1, 2, 3].reduce(
    (acc, num) => {
        acc + num;
    },
    0
);
```

There is no `return`.

So:

```text
callback
 ↓
undefined
 ↓
next accumulator becomes undefined
```

This is one of the most important `reduce()` mistakes.

We will dry-run it properly in Part 2.

---

## 10. Callback Parameters

The callback can receive:

```js
array.reduce(
    (accumulator, currentValue, index, array) => {
        // ...
    },
    initialValue
);
```

| Parameter      | Meaning         |
| -------------- | --------------- |
| `accumulator`  | Running result  |
| `currentValue` | Current element |
| `index`        | Current index   |
| `array`        | Original array  |

Usually you only need:

```js
(acc, num) => ...
```

---

# Interview Essentials

### What is `reduce()`?

A method that processes an array and produces one final result using an accumulator.

### What is an accumulator?

The running result carried from one iteration to the next.

### What does `reduce()` return?

One final value.

### Why provide an initial value?

It gives the accumulator a clear starting point and makes the behavior safer, especially for empty arrays.

### Does `reduce()` modify the original array?

Not by itself.

### Time complexity?

```text
O(n)
```

---

# Practice

### Exercise 1

Find the sum:

```js
const numbers = [10, 20, 30, 40];
```

### Exercise 2

Find the product:

```js
const numbers = [2, 3, 4];
```

### Exercise 3

Count the elements:

```js
const numbers = [5, 10, 15, 20, 25];
```

### Exercise 4

Predict:

```js
const result = [1, 2, 3].reduce(
    (acc, num) => acc + num,
    0
);

console.log(result);
```

Answer:

```text
6
```

### Exercise 5

Explain why this is wrong:

```js
const result = [1, 2, 3].reduce(
    (acc, num) => {
        acc + num;
    },
    0
);
```

---

# Completion Checklist

```text
[x] I know what reduce() does.
[x] I understand accumulator.
[x] I understand currentValue.
[x] I understand initialValue.
[x] I know reduce() returns one final value.
[x] I know reduce() vs map().
[x] I know reduce() vs filter().
[x] I understand why return is required.
[x] I know O(n).
```

### Memory Rule

```text
reduce()
= many values
→ combine/process
→ one final result
```

**`reduce()` Part 1 complete ✅**

**Next → Part 2: Accumulator, internal execution, initial value, dry runs, and debugging.**


# `reduce()` — Part 2

> **Goal:** Understand the accumulator, callback execution, initial value, dry runs, and the most important `reduce()` behavior.

## 1. The Accumulator

The accumulator is the **running result**.

```js
const numbers = [10, 20, 30];

const result = numbers.reduce(
    (acc, num) => acc + num,
    0
);

console.log(result);
```

Think:

```text
Initial acc = 0

Iteration 1:
0 + 10 = 10
acc = 10

Iteration 2:
10 + 20 = 30
acc = 30

Iteration 3:
30 + 30 = 60
acc = 60
```

Final:

```text
60
```

The important rule:

```text
callback return
      ↓
becomes
      ↓
next accumulator
```

---

## 2. Callback Parameters

```js
array.reduce(
    (accumulator, currentValue, index, array) => {
        // ...
    },
    initialValue
);
```

| Parameter      | Meaning         |
| -------------- | --------------- |
| `accumulator`  | Running result  |
| `currentValue` | Current element |
| `index`        | Current index   |
| `array`        | Original array  |

Usually:

```js
(acc, num) => ...
```

is enough.

---

## 3. Step-by-Step Execution

```js
const numbers = [5, 10, 15];

const result = numbers.reduce(
    (acc, num) => acc + num,
    0
);
```

### Iteration 1

```text
acc = 0
num = 5

0 + 5
↓
5
```

New accumulator:

```text
5
```

### Iteration 2

```text
acc = 5
num = 10

5 + 10
↓
15
```

New accumulator:

```text
15
```

### Iteration 3

```text
acc = 15
num = 15

15 + 15
↓
30
```

Final:

```text
30
```

---

## 4. Dry Run — Product

```js
const numbers = [2, 3, 4];

const result = numbers.reduce(
    (acc, num) => acc * num,
    1
);
```

Execution:

```text
acc = 1

1 × 2 = 2

2 × 3 = 6

6 × 4 = 24
```

Result:

```text
24
```

---

## 5. Initial Value Matters

With:

```js
const numbers = [10, 20, 30];

numbers.reduce(
    (acc, num) => acc + num,
    0
);
```

The first accumulator is:

```text
0
```

and the first current value is:

```text
10
```

So:

```text
0 + 10
```

---

### Without Initial Value

```js
const numbers = [10, 20, 30];

const result = numbers.reduce(
    (acc, num) => acc + num
);
```

Conceptually:

```text
acc = first element = 10
current = 20

10 + 20 = 30

30 + 30 = 60
```

Result:

```text
60
```

For your code, prefer an explicit initial value:

```js
numbers.reduce(
    (acc, num) => acc + num,
    0
);
```

---

## 6. Empty Array Trap

This can fail:

```js
const numbers = [];

const result = numbers.reduce(
    (acc, num) => acc + num
);
```

There is no first element available to become the accumulator.

So JavaScript throws:

```text
TypeError
```

With an initial value:

```js
const result = numbers.reduce(
    (acc, num) => acc + num,
    0
);

console.log(result);
```

Result:

```text
0
```

This is one reason an initial value is important.

---

## 7. The Most Important `return` Rule

Correct:

```js
const result = [1, 2, 3].reduce(
    (acc, num) => {
        return acc + num;
    },
    0
);
```

Wrong:

```js
const result = [1, 2, 3].reduce(
    (acc, num) => {
        acc + num;
    },
    0
);
```

What happens?

```text
First iteration

0 + 1
↓
expression calculated
↓
NO return
↓
undefined
```

So the next accumulator becomes:

```text
undefined
```

This breaks the reduction.

---

## 8. Different Callback Styles

Arrow:

```js
const result = numbers.reduce(
    (acc, num) => acc + num,
    0
);
```

Arrow with braces:

```js
const result = numbers.reduce(
    (acc, num) => {
        return acc + num;
    },
    0
);
```

Normal function:

```js
const result = numbers.reduce(
    function(acc, num) {
        return acc + num;
    },
    0
);
```

All perform the same reduction.

---

## 9. Debugging `reduce()`

This is useful for OA questions.

```js
const numbers = [10, 20, 30];

const result = numbers.reduce(
    (acc, num) => {
        console.log("acc:", acc, "num:", num);
        return acc + num;
    },
    0
);

console.log("result:", result);
```

Console:

```text
acc: 0 num: 10
acc: 10 num: 20
acc: 30 num: 30
result: 60
```

Notice:

```text
console.log()
→ shows the current iteration

reduce()
→ returns the final accumulator
```

---

## 10. Mental Model

Always think:

```text
initialValue
     ↓
 accumulator
     ↓
 current element
     ↓
 callback
     ↓
 returned value
     ↓
 next accumulator
     ↓
 repeat
     ↓
 final accumulator
```

Example:

```text
0
↓
+10
↓
10
↓
+20
↓
30
↓
+30
↓
60
```

---

# Interview Essentials

### What is the accumulator?

The running result passed from one iteration to the next.

### What becomes the next accumulator?

The value returned by the callback.

### What happens without an initial value?

The first array element becomes the initial accumulator.

### What happens with an empty array and no initial value?

A `TypeError` is thrown.

### Why provide an initial value?

It makes the starting state explicit and safely handles empty arrays.

### Does `reduce()` stop early?

Normally, no. It processes every element.

### Time complexity?

```text
O(n)
```

---

# Practice

### Exercise 1

Dry-run:

```js
const result = [5, 10, 15].reduce(
    (acc, num) => acc + num,
    0
);
```

### Exercise 2

Dry-run:

```js
const result = [2, 3, 4].reduce(
    (acc, num) => acc * num,
    1
);
```

### Exercise 3

Predict:

```js
const result = [10, 20, 30].reduce(
    (acc, num) => acc + num
);

console.log(result);
```

### Exercise 4

Explain why this is wrong:

```js
const result = [1, 2, 3].reduce(
    (acc, num) => {
        acc + num;
    },
    0
);
```

### Exercise 5 — Debug

What will be printed?

```js
const result = [10, 20, 30].reduce(
    (acc, num) => {
        console.log(acc, num);
        return acc + num;
    },
    0
);

console.log(result);
```

---

# Part 2 Checkpoint

```text
[x] I understand accumulator.
[x] I understand currentValue.
[x] I understand how each iteration changes acc.
[x] I understand initialValue.
[x] I know what happens without initialValue.
[x] I know the empty-array trap.
[x] I understand why return is essential.
[x] I can dry-run reduce().
[x] I can read reduce() debugging output.
```

### Memory Rule

> **`reduce()` → return value becomes the next accumulator.**

**Part 2 complete ✅**

**Next → Part 3: `reduce()` with objects, frequency counters, grouping, cart totals, and machine-coding patterns.**

## Part 3 — `reduce()` with Objects, Real-world Patterns & Machine-Coding

> **Goal:** Learn the most useful ways `reduce()` appears in interviews and projects: totals, counting, frequency maps, grouping, and cart calculations.

---

### 1. Reduce an Array of Objects

```js
const students = [
    { name: "Om", marks: 90 },
    { name: "Nakul", marks: 80 },
    { name: "Pavan", marks: 70 }
];

const totalMarks = students.reduce(
    (total, student) => total + student.marks,
    0
);

console.log(totalMarks);
```

Output:

```text
240
```

Mental model:

```text
0
 ↓
+ 90 = 90
 ↓
+ 80 = 170
 ↓
+ 70 = 240
```

---

### 2. Total Salary / Price

```js
const employees = [
    { name: "Om", salary: 50000 },
    { name: "Nakul", salary: 60000 },
    { name: "Pavan", salary: 70000 }
];

const totalSalary = employees.reduce(
    (total, employee) => total + employee.salary,
    0
);
```

The pattern is:

```text
array of objects
      ↓
read property
      ↓
add to accumulator
```

---

### 3. Count Matching Objects

```js
const users = [
    { name: "Om", active: true },
    { name: "Nakul", active: false },
    { name: "Pavan", active: true }
];

const activeCount = users.reduce(
    (count, user) =>
        user.active ? count + 1 : count,
    0
);

console.log(activeCount);
```

Output:

```text
2
```

This is useful when you need:

```text
count
```

instead of the actual users.

---

### 4. Frequency Counter ⭐

This is one of the most important `reduce()` interview patterns.

```js
const names = [
    "Om",
    "Nakul",
    "Om",
    "Pavan",
    "Nakul",
    "Om"
];

const frequency = names.reduce(
    (count, name) => {
        count[name] = (count[name] || 0) + 1;
        return count;
    },
    {}
);

console.log(frequency);
```

Output:

```js
{
    Om: 3,
    Nakul: 2,
    Pavan: 1
}
```

Understand the accumulator:

```text
{}
 ↓
Om: 1
 ↓
Om: 2
 ↓
Nakul: 1
 ↓
Pavan: 1
 ↓
Nakul: 2
 ↓
Om: 3
```

The important pattern:

```js
count[key] = (count[key] || 0) + 1;
```

Remember the idea, not just the line.

---

### 5. Grouping Objects

`reduce()` can build an object whose keys represent groups.

```js
const users = [
    { name: "Om", role: "developer" },
    { name: "Nakul", role: "tester" },
    { name: "Pavan", role: "developer" }
];

const grouped = users.reduce(
    (groups, user) => {
        if (!groups[user.role]) {
            groups[user.role] = [];
        }

        groups[user.role].push(user);

        return groups;
    },
    {}
);

console.log(grouped);
```

Conceptually:

```text
{}
 ↓
developer → [Om]
 ↓
tester    → [Nakul]
 ↓
developer → [Om, Pavan]
```

This pattern is useful for API responses, reports, dashboards, and data processing.

---

### 6. Shopping Cart Total ⭐

Very common machine-coding pattern.

```js
const cart = [
    { product: "Laptop", price: 50000, quantity: 1 },
    { product: "Mouse", price: 1000, quantity: 2 }
];

const total = cart.reduce(
    (sum, item) =>
        sum + item.price * item.quantity,
    0
);

console.log(total);
```

Output:

```text
52000
```

Flow:

```text
0
 ↓
50000 × 1 = 50000
 ↓
50000 + 1000 × 2
 ↓
52000
```

---

### 7. `filter()` + `reduce()`

Very common in real applications.

```js
const numbers = [10, 20, 30, 40];

const total = numbers
    .filter(num => num > 20)
    .reduce((sum, num) => sum + num, 0);

console.log(total);
```

Output:

```text
70
```

Flow:

```text
[10,20,30,40]
      ↓
filter()
      ↓
[30,40]
      ↓
reduce()
      ↓
70
```

Remember:

```text
filter → select
reduce → combine
```

---

### 8. React Usage

Cart total:

```js
const total = cart.reduce(
    (sum, item) =>
        sum + item.price * item.quantity,
    0
);
```

Count completed items:

```js
const completedCount = todos.reduce(
    (count, todo) =>
        todo.completed ? count + 1 : count,
    0
);
```

The important point is not React itself.

It is:

```text
UI data
 ↓
reduce()
 ↓
derived value
```

---

### 9. Node.js Usage

Total revenue:

```js
const revenue = orders.reduce(
    (sum, order) => sum + order.amount,
    0
);
```

Count active users:

```js
const activeUsers = users.reduce(
    (count, user) =>
        user.active ? count + 1 : count,
    0
);
```

---

### 10. `reduce()` Can Return Different Types

This is important to understand.

```js
[1, 2, 3].reduce(
    (sum, num) => sum + num,
    0
);
// number
```

```js
["A", "B", "C"].reduce(
    (text, char) => text + char,
    ""
);
// string
```

```js
[1, 2, 3].reduce(
    (result, num) => {
        result.push(num * 2);
        return result;
    },
    []
);
// array
```

```js
["Om", "Nakul"].reduce(
    (result, name, index) => {
        result[index] = name;
        return result;
    },
    {}
);
// object
```

So:

```text
initial value
+
callback
→
determine the type/shape of the final result
```

---

### 11. Machine-Coding Patterns to Know

You do **not** need dozens of `reduce()` tricks.

Know these:

```text
1. Sum
2. Product
3. Count
4. Total from objects
5. Cart total
6. Frequency counter
7. Grouping
8. filter() + reduce()
```

These cover the practical patterns you'll repeatedly encounter.

---

### 12. Common Mistake — Using `reduce()` for Everything

Don't do this just because `reduce()` is powerful.

For example:

```js
const result = users.reduce(
    (arr, user) => {
        if (user.active) {
            arr.push(user);
        }
        return arr;
    },
    []
);
```

This works, but:

```js
const result = users.filter(
    user => user.active
);
```

is clearer.

Rule:

```text
Need transform?
→ map()

Need select?
→ filter()

Need one?
→ find()

Need yes/no?
→ some()/every()

Need combine/build a result?
→ reduce()
```

---

### 13. Part 3 Interview Questions

**Can `reduce()` return an object?**

Yes.

**Can `reduce()` return an array?**

Yes.

**Can `reduce()` return a string?**

Yes.

**Can `reduce()` be used for frequency counting?**

Yes.

**Can `reduce()` group objects?**

Yes.

**Why is `reduce()` useful in machine coding?**

Because it can derive totals, counts, grouped data, lookup objects, and other state-like values from arrays.

---

### 14. Practice

#### Exercise 1

Find total marks:

```js
const students = [
    { name: "Om", marks: 90 },
    { name: "Nakul", marks: 80 },
    { name: "Pavan", marks: 70 }
];
```

#### Exercise 2

Count active users.

#### Exercise 3

Build a frequency counter for:

```js
["Om", "Nakul", "Om", "Pavan", "Nakul"]
```

#### Exercise 4

Calculate shopping cart total.

#### Exercise 5

Group users by role.

#### Exercise 6

Use:

```text
filter() + reduce()
```

to calculate the sum of numbers greater than `50`.

---

# Part 3 Checkpoint

```text
[x] I can reduce arrays of objects.
[x] I can calculate totals.
[x] I can count matching items.
[x] I understand frequency counters.
[x] I understand grouping.
[x] I can calculate a cart total.
[x] I can combine filter() + reduce().
[x] I know when reduce() is clearer and when it is not.
[x] I can recognize reduce() patterns in machine coding.
```

### Memory Rule

```text
reduce()
= accumulate
= count
= group
= build
= calculate
```

**Part 3 complete ✅**

**Next → Part 4: pitfalls, polyfill (`myReduce()`), interview/OA traps, output questions, and final mastery.**

# `reduce()` — Part 4

> **Goal:** Finish `reduce()` for interviews, OAs, and practical projects. Focus only on the important pitfalls, a basic `myReduce()` implementation, output questions, and method selection. Your uploaded material specifically covers these areas.

---

## 1. Pitfall — Forgetting `return`

Wrong:

```js
const result = [1, 2, 3].reduce(
    (acc, num) => {
        acc + num;
    },
    0
);
```

The callback does not return the new accumulator.

Correct:

```js
const result = [1, 2, 3].reduce(
    (acc, num) => {
        return acc + num;
    },
    0
);

console.log(result);
```

Output:

```text
6
```

Remember:

```text
callback return
      ↓
next accumulator
```

---

## 2. Pitfall — Missing Initial Value

This can work:

```js
const result = [10, 20, 30].reduce(
    (acc, num) => acc + num
);
```

But JavaScript uses the first element as the initial accumulator.

```text
acc = 10
current = 20
```

For your code, prefer:

```js
const result = [10, 20, 30].reduce(
    (acc, num) => acc + num,
    0
);
```

Especially important for empty arrays:

```js
const result = [].reduce(
    (acc, num) => acc + num,
    0
);
```

Result:

```text
0
```

Without an initial value, an empty array causes a `TypeError`.

---

## 3. Pitfall — Using `reduce()` for Everything

`reduce()` is powerful, but don't force it everywhere.

Instead of:

```js
const activeUsers = users.reduce(
    (result, user) => {
        if (user.active) {
            result.push(user);
        }
        return result;
    },
    []
);
```

Use:

```js
const activeUsers = users.filter(
    user => user.active
);
```

Method selection:

```text
Transform → map()

Select → filter()

Find one → find()

Find position → findIndex()

Any match? → some()

All match? → every()

Combine/build result → reduce()
```

---

# 4. Build Your Own `myReduce()`

This is the main implementation exercise for `reduce()`.

### Basic version

```js
function myReduce(arr, callback, initialValue) {
    let accumulator = initialValue;

    for (let i = 0; i < arr.length; i++) {
        accumulator = callback(
            accumulator,
            arr[i],
            i,
            arr
        );
    }

    return accumulator;
}
```

Example:

```js
const numbers = [1, 2, 3];

const result = myReduce(
    numbers,
    (acc, num) => acc + num,
    0
);

console.log(result);
```

Output:

```text
6
```

---

## 5. Understand `myReduce()`

Don't memorize the code.

Think:

```text
initialValue
      ↓
accumulator
      ↓
current element
      ↓
callback()
      ↓
returned value
      ↓
new accumulator
      ↓
next element
      ↓
repeat
      ↓
final accumulator
```

The core line is:

```js
accumulator = callback(
    accumulator,
    arr[i],
    i,
    arr
);
```

That is the heart of `reduce()`.

---

## 6. What Your Basic Polyfill Doesn't Cover

The implementation above is intentionally a **learning polyfill**.

It does not reproduce every edge case of native `reduce()`, such as handling an omitted initial value exactly like the built-in method.

For your current goal, don't spend time implementing every specification detail.

You need to understand:

```text
accumulator
callback
initial value
return value
iteration
final result
```

That is the important interview/OA knowledge.

---

# 7. Output Practice

### Question 1

```js
const result = [1, 2, 3].reduce(
    (acc, num) => acc + num,
    0
);

console.log(result);
```

Answer:

```text
6
```

---

### Question 2

```js
const result = [2, 3, 4].reduce(
    (acc, num) => acc * num,
    1
);

console.log(result);
```

Answer:

```text
24
```

---

### Question 3

```js
const result = [10, 20, 30].reduce(
    (acc, num) => {
        console.log(acc, num);
        return acc + num;
    },
    0
);

console.log("Result:", result);
```

Console:

```text
0 10
10 20
30 30
Result: 60
```

---

### Question 4

```js
const result = [1, 2, 3].reduce(
    (acc, num) => {
        acc + num;
    },
    0
);

console.log(result);
```

The callback returns `undefined`, so the accumulator becomes incorrect.

The key interview point is:

```text
No return
→ undefined
→ next accumulator
```

---

### Question 5

```js
const result = [].reduce(
    (acc, num) => acc + num,
    0
);

console.log(result);
```

Answer:

```text
0
```

Because the initial accumulator is `0`.

---

# 8. Important Interview Questions

### What is an accumulator?

The running result passed from one iteration to the next.

### What becomes the next accumulator?

The value returned by the callback.

### Can `reduce()` return an object?

Yes.

### Can `reduce()` return an array?

Yes.

### Can `reduce()` return a string?

Yes.

### Why provide an initial value?

It provides a clear starting accumulator and makes empty-array behavior safe.

### Does `reduce()` stop early?

Normally, no. It processes every relevant element.

### Time complexity?

```text
O(n)
```

### Can `reduce()` replace loops?

Yes, many aggregation and transformation tasks can be expressed with it, but a loop can sometimes be clearer.

---

# 9. Final Machine-Coding Patterns

These are the **only `reduce()` patterns I want you to remember now**:

```text
1. Sum
2. Product
3. Count
4. Total from objects
5. Cart total
6. Frequency counter
7. Grouping
8. filter() + reduce()
```

Example cart:

```js
const cart = [
    { product: "Laptop", price: 50000, quantity: 1 },
    { product: "Mouse", price: 1000, quantity: 2 }
];

const total = cart.reduce(
    (sum, item) =>
        sum + item.price * item.quantity,
    0
);
```

This is directly useful in machine coding.

---

# 10. Final Checklist

```text
[ ] I understand accumulator.
[ ] I understand initialValue.
[ ] I can dry-run reduce().
[ ] I know why return is required.
[ ] I know the empty-array issue.
[ ] I can implement basic myReduce().
[ ] I can calculate totals.
[ ] I can count values.
[ ] I understand frequency counters.
[ ] I understand grouping.
[ ] I can calculate cart totals.
[ ] I know when NOT to use reduce().
[ ] I can answer common OA output questions.
```

# Final Mental Model

```text
reduce()
   ↓
start with initial value
   ↓
take element
   ↓
callback(accumulator, element)
   ↓
return new accumulator
   ↓
repeat
   ↓
final accumulator
```

### One-line memory rule

> **`reduce()` = many array elements → one accumulated result.**

**`reduce()` complete ✅**

**Next → `09-sort.md`**
Yes. You are confused because the **advanced `reduce()` patterns change what the accumulator represents**. We should slow down and rebuild Part 5 from the ground up.

The key rule from your `reduce()` material is:

> **Whatever the callback returns becomes the accumulator for the next iteration.**

So Part 5 should not just be a list of patterns. It should teach you **what `acc` is at every step**.

# `reduce()` — Part 5: Advanced Patterns Explained by Dry Run

## First: The One Rule You Must Understand

Take:

```js
const numbers = [10, 20, 30];

const result = numbers.reduce(
    (acc, num) => acc + num,
    0
);
```

There are **two important variables**:

```text
acc → accumulator → previous result
num → current value → current array element
```

Start:

```text
acc = 0
```

### Iteration 1

```text
acc = 0
num = 10
```

Callback:

```js
0 + 10
```

returns:

```text
10
```

Now:

```text
acc = 10
```

### Iteration 2

```text
acc = 10
num = 20
```

Callback:

```js
10 + 20
```

returns:

```text
30
```

Now:

```text
acc = 30
```

### Iteration 3

```text
acc = 30
num = 30
```

Callback:

```js
30 + 30
```

returns:

```text
60
```

Final:

```text
result = 60
```

### The most important visualization

```text
initialValue
     ↓
    acc

acc + current
     ↓
return value
     ↓
new acc
     ↓
next current
     ↓
repeat
```

Everything in Part 5 is the **same process**.

Only the **type/meaning of `acc` changes**.

---

# Pattern 1 — Sum

```js
const numbers = [10, 20, 30];

const sum = numbers.reduce(
    (acc, num) => acc + num,
    0
);
```

Here:

```text
acc = number
num = number
```

Dry run:

```text
Start:
acc = 0

1:
acc = 0
num = 10
return 10

2:
acc = 10
num = 20
return 30

3:
acc = 30
num = 30
return 60
```

Final:

```text
60
```

### Pattern

```text
accumulator = running total
```

---

# Pattern 2 — Count

```js
const numbers = [10, 20, 30, 40];

const count = numbers.reduce(
    acc => acc + 1,
    0
);
```

Here:

```text
acc = count
num = current element
```

We don't even need `num`.

Dry run:

```text
Start:
acc = 0

10:
0 + 1 = 1

20:
1 + 1 = 2

30:
2 + 1 = 3

40:
3 + 1 = 4
```

Final:

```text
4
```

Think:

```text
acc = "How many have I processed?"
```

---

# Pattern 3 — Count Matching Elements

```js
const numbers = [10, 15, 20, 25, 30];

const count = numbers.reduce(
    (acc, num) =>
        num > 20 ? acc + 1 : acc,
    0
);
```

Here:

```text
acc = count
num = current number
```

Dry run:

### Start

```text
acc = 0
```

### `num = 10`

```text
10 > 20 → false

return acc
return 0
```

```text
acc = 0
```

### `num = 15`

```text
15 > 20 → false

return 0
```

```text
acc = 0
```

### `num = 20`

```text
20 > 20 → false

return 0
```

```text
acc = 0
```

### `num = 25`

```text
25 > 20 → true

return 0 + 1
return 1
```

```text
acc = 1
```

### `num = 30`

```text
30 > 20 → true

return 1 + 1
return 2
```

Final:

```text
2
```

### Pattern

```text
acc = count
condition true
    ↓
acc + 1

condition false
    ↓
acc
```

---

# Pattern 4 — Sum Property from Objects

```js
const students = [
    { name: "Om", marks: 90 },
    { name: "Nakul", marks: 80 },
    { name: "Pavan", marks: 70 }
];

const totalMarks = students.reduce(
    (acc, student) => acc + student.marks,
    0
);
```

Here:

```text
acc     = running total
student = current object
```

### Iteration 1

```text
acc = 0
student = { name: "Om", marks: 90 }
```

We take:

```text
student.marks = 90
```

Then:

```text
0 + 90 = 90
```

New:

```text
acc = 90
```

### Iteration 2

```text
acc = 90
student = { name: "Nakul", marks: 80 }
```

```text
90 + 80 = 170
```

New:

```text
acc = 170
```

### Iteration 3

```text
acc = 170
student = { name: "Pavan", marks: 70 }
```

```text
170 + 70 = 240
```

Final:

```text
240
```

### Critical understanding

`acc` does **not** contain the student.

It contains:

```text
running total
```

`student` contains:

```text
current object
```

---

# Pattern 5 — Frequency Counter ⭐

This is the one confusing you.

Start with:

```js
const names = [
    "Om",
    "Nakul",
    "Om",
    "Pavan",
    "Nakul",
    "Om"
];

const freq = names.reduce(
    (count, name) => {
        count[name] = (count[name] || 0) + 1;
        return count;
    },
    {}
);
```

Now look carefully.

Here:

```text
count = accumulator object
name  = current string
```

The accumulator is **not a number anymore**.

It is:

```js
{}
```

That is the big idea.

---

## Frequency Counter Dry Run

### Start

Initial value:

```js
{}
```

So:

```text
count = {}
```

---

### Iteration 1

Current:

```text
name = "Om"
```

Current accumulator:

```js
{}
```

Check:

```js
count["Om"]
```

There is no `"Om"` yet.

So:

```js
count["Om"] || 0
```

becomes:

```text
undefined || 0
```

which gives:

```text
0
```

Then:

```js
0 + 1
```

So:

```js
count["Om"] = 1
```

Accumulator becomes:

```js
{
    Om: 1
}
```

Then:

```js
return count;
```

That returned object becomes the next accumulator.

---

### Iteration 2

Current:

```text
name = "Nakul"
```

Accumulator:

```js
{
    Om: 1
}
```

Check:

```js
count["Nakul"]
```

Doesn't exist.

So:

```text
0 + 1 = 1
```

Accumulator:

```js
{
    Om: 1,
    Nakul: 1
}
```

Return it.

---

### Iteration 3

Current:

```text
name = "Om"
```

Accumulator:

```js
{
    Om: 1,
    Nakul: 1
}
```

Now:

```js
count["Om"]
```

is:

```text
1
```

So:

```js
1 + 1
```

becomes:

```text
2
```

Accumulator:

```js
{
    Om: 2,
    Nakul: 1
}
```

---

### Iteration 4

Current:

```text
name = "Pavan"
```

Accumulator:

```js
{
    Om: 2,
    Nakul: 1
}
```

`Pavan` doesn't exist.

So:

```text
0 + 1 = 1
```

Accumulator:

```js
{
    Om: 2,
    Nakul: 1,
    Pavan: 1
}
```

---

### Iteration 5

Current:

```text
name = "Nakul"
```

Existing:

```text
count["Nakul"] = 1
```

So:

```text
1 + 1 = 2
```

Accumulator:

```js
{
    Om: 2,
    Nakul: 2,
    Pavan: 1
}
```

---

### Iteration 6

Current:

```text
name = "Om"
```

Existing:

```text
count["Om"] = 2
```

So:

```text
2 + 1 = 3
```

Final accumulator:

```js
{
    Om: 3,
    Nakul: 2,
    Pavan: 1
}
```

That is the answer.

---

# The Most Important Thing About Frequency Counter

This:

```js
count
```

is the **whole object being built**.

And this:

```js
count[name]
```

means:

> "How many times have I already seen this name?"

So:

```text
count
    ↓
whole result object

count[name]
    ↓
count for current name
```

---

# Your Compact Version

You wrote:

```js
const freq = names.reduce(
    (count, name) => (
        count[name] = count[name]
            ? count[name] + 1
            : 1,
        count
    ),
    {}
);
```

This does the same thing.

But for learning, I strongly recommend:

```js
const freq = names.reduce((count, name) => {
    count[name] = (count[name] || 0) + 1;

    return count;
}, {});
```

First understand **this**.

Then understand the compact version.

---

# Pattern 6 — Cart Total

```js
const cart = [
    { product: "Laptop", price: 50000, quantity: 1 },
    { product: "Mouse", price: 1000, quantity: 2 }
];

const total = cart.reduce(
    (acc, item) =>
        acc + item.price * item.quantity,
    0
);
```

Here:

```text
acc  = running cart total
item = current cart item
```

Dry run:

```text
Start:
acc = 0
```

Laptop:

```text
price = 50000
quantity = 1

50000 × 1 = 50000

0 + 50000 = 50000
```

New:

```text
acc = 50000
```

Mouse:

```text
price = 1000
quantity = 2

1000 × 2 = 2000

50000 + 2000 = 52000
```

Final:

```text
52000
```

---

# Pattern 7 — Grouping Objects

This one is another important advanced pattern.

```js
const users = [
    { name: "Om", role: "developer" },
    { name: "Nakul", role: "tester" },
    { name: "Pavan", role: "developer" }
];

const grouped = users.reduce(
    (groups, user) => {
        if (!groups[user.role]) {
            groups[user.role] = [];
        }

        groups[user.role].push(user);

        return groups;
    },
    {}
);
```

Here:

```text
groups = accumulator object
user   = current object
```

### Start

```js
{}
```

---

### Om

```text
user.role = "developer"
```

No developer group exists.

Create:

```js
{
    developer: []
}
```

Push Om:

```js
{
    developer: [
        { name: "Om", role: "developer" }
    ]
}
```

---

### Nakul

Role:

```text
tester
```

Create:

```js
{
    developer: [Om],
    tester: []
}
```

Push Nakul:

```js
{
    developer: [Om],
    tester: [Nakul]
}
```

---

### Pavan

Role:

```text
developer
```

Developer already exists.

Push Pavan:

```js
{
    developer: [Om, Pavan],
    tester: [Nakul]
}
```

Final.

### Pattern

```text
accumulator = object of groups

current value = current item

return accumulator
```

---

# Pattern 8 — Build Object by ID

```js
const users = [
    { id: 1, name: "Om" },
    { id: 2, name: "Nakul" },
    { id: 3, name: "Pavan" }
];

const userMap = users.reduce(
    (result, user) => {
        result[user.id] = user;
        return result;
    },
    {}
);
```

Dry run:

```text
Start:
{}
```

Om:

```text
id = 1

{
    1: Om
}
```

Nakul:

```text
{
    1: Om,
    2: Nakul
}
```

Pavan:

```text
{
    1: Om,
    2: Nakul,
    3: Pavan
}
```

Now:

```js
userMap[2]
```

gives Nakul's object.

This pattern is useful when converting an array into a lookup object.

---

# The Big Picture

Now notice that **`reduce()` itself didn't change**.

The structure is always:

```js
array.reduce(
    (acc, current) => {
        // do something
        return acc;
    },
    initialValue
);
```

What changes is the accumulator:

```text
Sum
acc = number

Count
acc = number

Frequency
acc = object

Grouping
acc = object

Cart
acc = number

Build array
acc = array
```

That's the secret to `reduce()`.

---

# What You Should Learn — Nothing More

For your interview/OA/machine-coding goal, these are enough:

```text
✅ Sum
✅ Product
✅ Count
✅ Conditional count
✅ Max / Min
✅ Object property total
✅ Cart total
✅ Frequency counter
✅ Grouping
✅ Build object by ID
✅ filter() + reduce()
✅ map() + reduce()
✅ myReduce()
```

You **do not** need 30 more advanced tricks.

### Your mental question when seeing `reduce()`

Ask:

> **"What should my accumulator represent?"**

Then:

```text
Need total?
→ acc = number

Need count?
→ acc = number

Need frequency?
→ acc = {}

Need grouping?
→ acc = {}

Need new array?
→ acc = []
```

Once you can answer that, `reduce()` becomes much less confusing.

**Part 5 should be this pattern-learning chapter, and after you can dry-run these examples, `reduce()` is complete.**
