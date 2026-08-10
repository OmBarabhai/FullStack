# sort()

# Part 1 – Introduction & Fundamentals

> **"`sort()` is a JavaScript array method used to arrange array elements in a specific order. It can sort strings, numbers, objects, dates, and custom data. Unlike `map()` or `filter()`, `sort()` modifies the original array."**

---

# Table of Contents

1. Introduction
2. Why `sort()` Was Introduced
3. Syntax
4. Parameters
5. Return Value
6. Internal Working
7. Default Sorting Behavior
8. Visualization
9. Memory Behavior
10. First Examples
11. `sort()` vs `toSorted()`
12. Best Practices
13. Common Mistakes
14. Interview Questions
15. Coding Exercises
16. Summary

---

# 1. Introduction

Suppose we have an array.

```js
const fruits = ["Banana","Apple","Orange"];
```

We want them in alphabetical order.

Expected Output

```js
["Apple","Banana","Orange"]
```

Instead of writing sorting algorithms,

we use `sort()`.

```js
const fruits = ["Banana","Apple","Orange"];

fruits.sort();

console.log(fruits);
```

Output

```js
["Apple","Banana","Orange"]
```

---

# 2. Why `sort()` Was Introduced

Before JavaScript had a built-in sorting method,

developers had to write sorting algorithms like

- Bubble Sort
- Selection Sort
- Merge Sort
- Quick Sort

Example

```js
const numbers = [30,10,20];

for(let i=0;i<numbers.length;i++){

    for(let j=i+1;j<numbers.length;j++){

        if(numbers[i]>numbers[j]){

            let temp=numbers[i];

            numbers[i]=numbers[j];

            numbers[j]=temp;

        }

    }

}

console.log(numbers);
```

Too much code.

---

Using `sort()`

```js
const fruits = ["Banana","Apple","Orange"];

fruits.sort();

console.log(fruits);
```

Much simpler.

---

# 3. Syntax

```js
array.sort()
```

or

```js
array.sort(compareFunction)
```

---

Example

```js
numbers.sort(

    (a,b)=>{

    }

);
```

---

# 4. Parameters

`sort()` accepts an optional callback called the **Compare Function**.

```js
array.sort(

    (a,b)=>{

    }

);
```

| Parameter | Description |
|-----------|-------------|
| `a` | First value |
| `b` | Second value |

---

Return Value

| Return | Meaning |
|---------|----------|
| Negative | `a` comes first |
| Positive | `b` comes first |
| Zero | Keep original order |

---

Example

```js
const numbers = [30,10,20];

numbers.sort(

    (a,b)=>a-b

);

console.log(numbers);
```

Output

```js
[10,20,30]
```

---

# 5. Return Value

`sort()` returns

```
The Same Array
```

It does **not** create a new array.

Example

```js
const numbers = [3,1,2];

const result = numbers.sort();

console.log(result);
```

Output

```js
[1,2,3]
```

Both

```js
numbers
```

and

```js
result
```

refer to the **same array**.

---

# 6. Internal Working

Suppose

```js
const fruits = [

    "Banana",

    "Apple",

    "Orange"

];
```

Execution

```
sort()

↓

Compare

↓

Swap

↓

Compare Again

↓

Repeat

↓

Sorted Array
```

The actual sorting algorithm depends on the JavaScript engine.

---

# 7. Default Sorting Behavior

Important Interview Topic ⭐

JavaScript sorts values as **strings** by default.

Example

```js
const numbers = [1,100,20,3];

numbers.sort();

console.log(numbers);
```

Output

```js
[1,100,20,3]
```

Wrong numeric order!

Reason

JavaScript converts numbers into strings.

```
1

100

20

3
```

Alphabetical comparison

```
"1"

↓

"100"

↓

"20"

↓

"3"
```

---

Correct Numeric Sorting

```js
const numbers = [1,100,20,3];

numbers.sort(

    (a,b)=>a-b

);

console.log(numbers);
```

Output

```js
[1,3,20,100]
```

---

# 8. Visualization

Default Sort

```
100

↓

"100"

↓

Compare Alphabetically

↓

Wrong Order
```

---

Numeric Sort

```
Compare

↓

100 - 20

↓

Positive

↓

Swap

↓

Correct Order
```

---

# 9. Memory Behavior

Original

```
numbers

↓

Memory A

↓

[30,10,20]
```

After Sorting

```
Memory A

↓

[10,20,30]
```

Notice

The original array changes.

Unlike

```
map()

filter()

reduce()
```

`sort()` is **mutable**.

---

# 10. First Examples

## Alphabetical Sorting

```js
const fruits = [

    "Banana",

    "Apple",

    "Orange"

];

fruits.sort();

console.log(fruits);
```

Output

```js
["Apple","Banana","Orange"]
```

---

## Numeric Ascending

```js
const numbers = [50,20,100,10];

numbers.sort(

    (a,b)=>a-b

);

console.log(numbers);
```

Output

```js
[10,20,50,100]
```

---

## Numeric Descending

```js
const numbers = [50,20,100,10];

numbers.sort(

    (a,b)=>b-a

);

console.log(numbers);
```

Output

```js
[100,50,20,10]
```

---

# 11. `sort()` vs `toSorted()`

`sort()`

```js
const numbers = [3,2,1];

numbers.sort();

console.log(numbers);
```

Original array changes.

---

`toSorted()`

```js
const numbers = [3,2,1];

const result = numbers.toSorted();

console.log(numbers);

console.log(result);
```

Output

```js
numbers

↓

[3,2,1]

result

↓

[1,2,3]
```

`toSorted()` creates a **new array**.

---

# 12. Best Practices

✅ Always use a compare function for numbers.

```js
(a,b)=>a-b
```

---

✅ Use `toSorted()` if you don't want to modify the original array.

---

✅ Keep compare functions simple.

---

# 13. Common Mistakes

### Forgetting Compare Function

Wrong

```js
[100,20,3].sort();
```

Output

```js
[100,20,3]
```

Not numerically sorted.

---

### Assuming `sort()` Creates a New Array

Wrong

```js
const result = numbers.sort();
```

Both variables point to the same array.

---

### Comparing Strings with Subtraction

Wrong

```js
(a,b)=>a-b
```

for strings.

Use

```js
a.localeCompare(b)
```

instead.

---

# 14. Interview Questions

### What does `sort()` return?

---

### Does `sort()` modify the original array?

---

### Why does `[1,100,20].sort()` produce the wrong order?

---

### Difference between `sort()` and `toSorted()`?

---

### Why should we use a compare function?

---

# 15. Coding Exercises

### Exercise 1

Sort numbers in ascending order.

---

### Exercise 2

Sort numbers in descending order.

---

### Exercise 3

Sort fruit names alphabetically.

---

### Exercise 4

Predict the output.

```js
const arr = [100,2,30];

arr.sort();

console.log(arr);
```

---

### Exercise 5

Sort without modifying the original array.

---

# 16. Summary

- `sort()` arranges array elements.
- By default, it sorts values as strings.
- Use `(a,b)=>a-b` for numeric ascending order.
- Use `(a,b)=>b-a` for numeric descending order.
- `sort()` modifies the original array.
- `toSorted()` creates a new sorted array.
- `sort()` is one of the most frequently asked JavaScript interview topics.

---

# Next Part

➡️ **Part 2 – Compare Function, Callback, Internal Working & Execution Flow**

You'll learn:

- Compare Function in Depth
- Callback Parameters
- How `sort()` Decides Order
- Step-by-Step Dry Runs
- Execution Flow
- Memory Visualization
- Stable Sorting
- Debugging
- Interview Traps


# sort()

# Part 3 – sort() with Numbers, Strings, Objects & Real-World Examples

> **"`sort()` is one of the most useful array methods because it can arrange numbers, strings, dates, and objects in any order using a custom compare function. It is widely used in dashboards, tables, e-commerce, analytics, React applications, and backend APIs."**

---

# Table of Contents

1. Sorting Numbers
2. Sorting Strings
3. Sorting Objects
4. Multi-Level Sorting
5. Sorting Dates
6. Chaining with `sort()`
7. Real-world Examples
8. React Examples
9. Node.js Examples
10. Best Practices
11. Common Mistakes
12. Interview Questions
13. Coding Exercises
14. Summary

---

# 1. Sorting Numbers

## Ascending Order

```js
const numbers = [50,10,30,20];

numbers.sort(

    (a,b)=>a-b

);

console.log(numbers);
```

Output

```js
[10,20,30,50]
```

---

## Descending Order

```js
const numbers = [50,10,30,20];

numbers.sort(

    (a,b)=>b-a

);

console.log(numbers);
```

Output

```js
[50,30,20,10]
```

---

# 2. Sorting Strings

## Alphabetical Order

```js
const fruits = [

    "Banana",

    "Apple",

    "Orange",

    "Mango"

];

fruits.sort(

    (a,b)=>a.localeCompare(b)

);

console.log(fruits);
```

Output

```js
["Apple","Banana","Mango","Orange"]
```

---

## Reverse Alphabetical

```js
const fruits = [

    "Banana",

    "Apple",

    "Orange",

    "Mango"

];

fruits.sort(

    (a,b)=>b.localeCompare(a)

);

console.log(fruits);
```

Output

```js
["Orange","Mango","Banana","Apple"]
```

---

# 3. Sorting Objects

## Sort by Age

```js
const users = [

    {

        name:"Om",

        age:24

    },

    {

        name:"Raj",

        age:30

    },

    {

        name:"Amit",

        age:20

    }

];

users.sort(

    (a,b)=>a.age-b.age

);

console.log(users);
```

Output

```js
[
 {name:"Amit",age:20},
 {name:"Om",age:24},
 {name:"Raj",age:30}
]
```

---

## Sort by Salary

```js
const employees = [

    {

        name:"Om",

        salary:50000

    },

    {

        name:"Raj",

        salary:80000

    },

    {

        name:"Amit",

        salary:60000

    }

];

employees.sort(

    (a,b)=>b.salary-a.salary

);

console.log(employees);
```

Output

```js
[
 {name:"Raj",salary:80000},
 {name:"Amit",salary:60000},
 {name:"Om",salary:50000}
]
```

---

# 4. Multi-Level Sorting

Sometimes multiple values are equal.

Then we sort using another property.

Example

```js
const students = [

    {

        name:"Raj",

        marks:90

    },

    {

        name:"Om",

        marks:90

    },

    {

        name:"Amit",

        marks:80

    }

];

students.sort(

    (a,b)=>

        a.marks-b.marks ||

        a.name.localeCompare(b.name)

);

console.log(students);
```

Output

```js
[
 {name:"Amit",marks:80},
 {name:"Om",marks:90},
 {name:"Raj",marks:90}
]
```

Explanation

```
First

↓

Sort by Marks

↓

If Marks Equal

↓

Sort by Name
```

---

# 5. Sorting Dates

```js
const dates = [

    new Date("2026-01-10"),

    new Date("2025-08-20"),

    new Date("2027-05-01")

];

dates.sort(

    (a,b)=>a-b

);

console.log(dates);
```

Output

```
Oldest Date

↓

Newest Date
```

---

Newest First

```js
dates.sort(

    (a,b)=>b-a

);
```

---

# 6. Chaining with `sort()`

Example

```js
const numbers = [5,2,9,4,8];

const result = numbers

.filter(

    num=>num%2===0

)

.sort(

    (a,b)=>a-b

);

console.log(result);
```

Output

```js
[2,4,8]
```

Execution

```
Array

↓

filter()

↓

Even Numbers

↓

sort()

↓

Ascending Order
```

---

Another Example

```js
const users = [

    {

        name:"Om",

        age:24

    },

    {

        name:"Raj",

        age:30

    }

];

const names = users

.sort(

    (a,b)=>a.age-b.age

)

.map(

    user=>user.name

);

console.log(names);
```

Output

```js
["Om","Raj"]
```

---

# 7. Real-world Examples

## Leaderboard

```js
const scores = [

    {

        player:"Om",

        score:250

    },

    {

        player:"Raj",

        score:500

    },

    {

        player:"Amit",

        score:300

    }

];

scores.sort(

    (a,b)=>b.score-a.score

);

console.log(scores);
```

---

## Shopping Website

Sort products by price.

```js
products.sort(

    (a,b)=>a.price-b.price

);
```

---

## Employee Dashboard

Sort employees by salary.

```js
employees.sort(

    (a,b)=>b.salary-a.salary

);
```

---

## Student Result

Sort by marks.

```js
students.sort(

    (a,b)=>b.marks-a.marks

);
```

---

# 8. React Examples

Sort Todo Items

```jsx
const sortedTodos =

todos.toSorted(

    (a,b)=>a.priority-b.priority

);
```

---

Sort Products

```jsx
const sortedProducts =

products.toSorted(

    (a,b)=>a.price-b.price

);
```

Using `toSorted()` avoids mutating React state.

---

# 9. Node.js Examples

Sort Orders

```js
orders.sort(

    (a,b)=>

        b.total-a.total

);
```

---

Sort Logs

```js
logs.sort(

    (a,b)=>

        b.timestamp-a.timestamp

);
```

---

Sort Users

```js
users.sort(

    (a,b)=>

        a.name.localeCompare(b.name)

);
```

---

# 10. Best Practices

✅ Use `a-b` for ascending numbers.

---

✅ Use `b-a` for descending numbers.

---

✅ Use `localeCompare()` for strings.

---

✅ Use `toSorted()` in React to avoid mutating state.

---

✅ Keep compare functions readable.

---

# 11. Common Mistakes

### Sorting Numbers Without Compare Function

Wrong

```js
[100,2,30].sort();
```

Output

```js
[100,2,30]
```

---

### Mutating Original Array

```js
numbers.sort();
```

Changes

```js
numbers
```

itself.

---

### Sorting Strings Using `-`

Wrong

```js
(a,b)=>a-b
```

Correct

```js
(a,b)=>a.localeCompare(b)
```

---

### Forgetting Secondary Sorting

Wrong

```js
students.sort(

    (a,b)=>a.marks-b.marks

);
```

When marks are equal, names may not appear in the desired order.

---

# 12. Interview Questions

### How do you sort numbers?

---

### Why do we use `localeCompare()`?

---

### How do you sort objects?

---

### How do you sort by multiple properties?

---

### How do you sort dates?

---

### Difference between `sort()` and `toSorted()`?

---

# 13. Coding Exercises

### Exercise 1

Sort products by price.

---

### Exercise 2

Sort students by marks.

---

### Exercise 3

Sort employees by salary.

---

### Exercise 4

Sort names alphabetically.

---

### Exercise 5

Sort users by age and then by name.

---

### Exercise 6

Sort dates from newest to oldest.

---

# 14. Summary

- `sort()` can sort numbers, strings, objects, and dates.
- Use `(a,b)=>a-b` for ascending numeric order.
- Use `(a,b)=>b-a` for descending numeric order.
- Use `localeCompare()` for strings.
- Multi-level sorting allows sorting by multiple properties.
- `sort()` is widely used in leaderboards, e-commerce websites, dashboards, analytics, and backend APIs.
- In React, prefer `toSorted()` to avoid mutating state.

---

# Next Part

➡️ **Part 4 – Advanced sort(), Performance, Memory, Interview Mastery & Debugging**

You'll learn:

- Performance Analysis
- Memory Behavior
- Stable Sorting
- `sort()` vs `toSorted()`
- `sort()` vs `reverse()`
- Debugging
- Predict the Output
- Interview Traps
- Advanced Coding Exercises
- Quick Revision Sheet

# sort()

# Part 4 – Advanced `sort()`, Performance, Memory, Interview Mastery & Debugging

> **"Mastering `sort()` means understanding how JavaScript rearranges elements internally, how compare functions affect ordering, why `sort()` mutates the original array, and when to use `toSorted()` instead."**

---

# Table of Contents

1. Advanced Usage
2. Performance Considerations
3. Memory Behavior
4. `sort()` vs Other Array Methods
5. Debugging `sort()`
6. Predict the Output
7. Interview Traps
8. Best Practices
9. Common Mistakes
10. Interview Questions
11. Coding Exercises
12. Quick Revision Sheet
13. Summary

---

# 1. Advanced Usage

## Sorting Objects by Multiple Properties

```js
const employees = [

    {

        name:"Raj",

        age:25,

        salary:50000

    },

    {

        name:"Om",

        age:25,

        salary:70000

    },

    {

        name:"Amit",

        age:30,

        salary:60000

    }

];

employees.sort(

    (a,b)=>

        a.age-b.age ||

        b.salary-a.salary

);

console.log(employees);
```

Output

```js
[
 {name:"Om",age:25,salary:70000},
 {name:"Raj",age:25,salary:50000},
 {name:"Amit",age:30,salary:60000}
]
```

---

## Case-Insensitive Sorting

```js
const names = [

    "raj",

    "Om",

    "amit",

    "Zara"

];

names.sort(

    (a,b)=>

        a.toLowerCase()

        .localeCompare(

            b.toLowerCase()

        )

);

console.log(names);
```

Output

```js
["amit","Om","raj","Zara"]
```

---

# 2. Performance Considerations

Average Time Complexity

```
O(n log n)
```

Worst Case

```
O(n log n)
```

(JavaScript engines use optimized sorting algorithms.)

---

Space Complexity

Usually

```
O(log n)
```

or

```
O(n)
```

depending on the JavaScript engine.

---

Large Array

```
1 Million Elements

↓

sort()

↓

Many Comparisons

↓

Sorted Array
```

Sorting is significantly more expensive than

```
map()

filter()

find()

some()

every()
```

---

# 3. Memory Behavior

Original

```
numbers

↓

Memory A

↓

[30,10,20]
```

After Sorting

```
Memory A

↓

[10,20,30]
```

Notice

The same array changes.

No new array is created.

---

Using `toSorted()`

```
Memory A

↓

[30,10,20]

------------

Memory B

↓

[10,20,30]
```

Original remains unchanged.

---

# 4. `sort()` vs Other Array Methods

| Method | Returns | Mutates Original | Purpose |
|---------|----------|-----------------|----------|
| `sort()` | Same Array | ✅ Yes | Sort elements |
| `toSorted()` | New Array | ❌ No | Immutable sorting |
| `reverse()` | Same Array | ✅ Yes | Reverse order |
| `map()` | New Array | ❌ No | Transform |
| `filter()` | New Array | ❌ No | Select |
| `reduce()` | Any Value | ❌ No | Combine values |

---

## `sort()` vs `toSorted()`

### `sort()`

```js
const arr = [3,1,2];

arr.sort();

console.log(arr);
```

Output

```js
[1,2,3]
```

Original changed.

---

### `toSorted()`

```js
const arr = [3,1,2];

const sorted = arr.toSorted();

console.log(arr);

console.log(sorted);
```

Output

```js
arr

↓

[3,1,2]

sorted

↓

[1,2,3]
```

---

## `sort()` vs `reverse()`

```js
const numbers = [1,2,3];

numbers.reverse();

console.log(numbers);
```

Output

```js
[3,2,1]
```

`reverse()` does **not** sort.

It only reverses the current order.

---

# 5. Debugging `sort()`

Wrong

```js
const numbers = [100,20,3];

numbers.sort();

console.log(numbers);
```

Output

```js
[100,20,3]
```

Reason

```
Default String Comparison
```

---

Correct

```js
numbers.sort(

    (a,b)=>a-b

);
```

Output

```js
[3,20,100]
```

---

Debug Compare Function

```js
numbers.sort(

    (a,b)=>{

        console.log(a,b);

        return a-b;

    }

);
```

Useful for understanding comparisons.

---

# 6. Predict the Output

## Example 1

```js
const arr = [20,5,10];

arr.sort(

    (a,b)=>a-b

);

console.log(arr);
```

Output

```js
[5,10,20]
```

---

## Example 2

```js
const arr = ["C","A","B"];

arr.sort();

console.log(arr);
```

Output

```js
["A","B","C"]
```

---

## Example 3

```js
const arr = [2,10,1];

arr.sort();

console.log(arr);
```

Output

```js
[1,10,2]
```

Reason

```
Default String Sorting
```

---

# 7. Interview Traps

## Trap 1

Does `sort()` modify the original array?

```
Yes
```

---

## Trap 2

Does `toSorted()` modify the original array?

```
No
```

---

## Trap 3

Should numbers always use a compare function?

```
Yes
```

---

## Trap 4

Can `sort()` sort objects?

```
Yes

Using a compare function.
```

---

## Trap 5

Should compare functions return `true` or `false`?

```
No
```

Return

```
Negative

Zero

Positive
```

---

# 8. Best Practices

✅ Always use compare functions for numeric sorting.

---

✅ Use `localeCompare()` for strings.

---

✅ Prefer `toSorted()` in React.

---

✅ Keep compare functions readable.

---

✅ Remember that `sort()` mutates the original array.

---

# 9. Common Mistakes

### Forgetting Compare Function

Wrong

```js
[50,2,100].sort();
```

---

### Returning Boolean

Wrong

```js
(a,b)=>a>b
```

Correct

```js
(a,b)=>a-b
```

---

### Assuming `sort()` Creates a New Array

Wrong

```js
const sorted = numbers.sort();
```

Both variables reference the same array.

---

### Sorting Objects Without Property

Wrong

```js
users.sort();
```

Correct

```js
users.sort(

    (a,b)=>a.age-b.age

);
```

---

# 10. Interview Questions

### What is the time complexity of `sort()`?

---

### Does `sort()` modify the original array?

---

### Difference between `sort()` and `toSorted()`?

---

### Why does numeric sorting require a compare function?

---

### Why should `localeCompare()` be used for strings?

---

### Can `sort()` sort objects?

---

### Difference between `sort()` and `reverse()`?

---

# 11. Coding Exercises

### Exercise 1

Sort numbers in ascending order.

---

### Exercise 2

Sort numbers in descending order.

---

### Exercise 3

Sort employees by salary.

---

### Exercise 4

Sort students by marks and then by name.

---

### Exercise 5

Sort products by price.

---

### Exercise 6

Sort dates from newest to oldest.

---

### Exercise 7

Create a sorted copy of an array without changing the original.

---

# 12. Quick Revision Sheet

```
sort()

↓

Compare Function

↓

Negative

↓

Keep Order

------------

Positive

↓

Swap

------------

Zero

↓

Keep Existing Order

↓

Repeat

↓

Sorted Array
```

Remember

```
Transform

↓

map()

Select

↓

filter()

Find

↓

find()

Any Match

↓

some()

All Match

↓

every()

Combine

↓

reduce()

Sort

↓

sort()

Immutable Sort

↓

toSorted()
```

---

# 13. Summary

- `sort()` rearranges array elements.
- Default sorting is alphabetical (string-based).
- Use `(a,b)=>a-b` for ascending numeric sorting.
- Use `(a,b)=>b-a` for descending numeric sorting.
- `sort()` mutates the original array.
- `toSorted()` returns a new sorted array.
- Average Time Complexity is **O(n log n)**.
- `sort()` is one of the most frequently asked JavaScript interview topics.

---

# Chapter Complete ✅

You now understand:

- ✔ What `sort()` is
- ✔ Default Sorting
- ✔ Compare Function
- ✔ Numeric Sorting
- ✔ String Sorting
- ✔ Object Sorting
- ✔ Multi-Level Sorting
- ✔ Stable Sorting
- ✔ Memory Behavior
- ✔ Performance Analysis
- ✔ React Usage
- ✔ Node.js Usage
- ✔ Interview Questions
- ✔ Common Mistakes
- ✔ Best Practices
- ✔ Coding Exercises

---

# What's Next?

➡️ **10-flat().md**

You'll master:

- What `flat()` is
- Flattening Nested Arrays
- Depth Parameter
- Infinity Depth
- Memory Behavior
- Performance Analysis
- `flat()` vs `concat()`
- React Examples
- Node.js Examples
- Interview Questions
- Advanced Coding Problems