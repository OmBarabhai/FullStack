# Functional Programming Cheat Sheet

# Part 1 – The Ultimate 10-Minute JavaScript Functional Programming Revision Guide

> **"This chapter is designed for quick revision before interviews. Instead of reading hundreds of pages, you can revise every important JavaScript functional programming concept in under 10 minutes."**

---

# Table of Contents

1. Functional Programming Overview
2. Array Method Decision Tree
3. Complete Method Comparison
4. Syntax Cheat Sheet
5. Return Values
6. Mutating vs Non-Mutating Methods
7. Time Complexity
8. Space Complexity
9. Pattern Recognition
10. React Cheat Sheet
11. Node.js Cheat Sheet
12. Modern ES2023+ Methods
13. Summary

---

# 1. Functional Programming Overview

Functional Programming means

```
Input

↓

Transformation

↓

Output
```

Instead of changing data,

we create

```
New Data
```

using

```
map()

filter()

reduce()

flatMap()

etc.
```

---

# Core Principles

✅ Pure Functions

---

✅ Immutability

---

✅ Function Composition

---

✅ Higher Order Functions

---

✅ Declarative Programming

---

# 2. Array Method Decision Tree

```
Need New Array?

↓

YES

↓

Need Transformation?

↓

map()

----------------

Need Selection?

↓

filter()

----------------

Need First Match?

↓

find()

----------------

Need First Index?

↓

findIndex()

----------------

Need Boolean?

↓

some()

every()

----------------

Need One Value?

↓

reduce()

----------------

Need Flatten?

↓

flat()

----------------

Need Flatten + Transform?

↓

flatMap()

----------------

Need Sort?

↓

sort()

----------------

Need Side Effect?

↓

forEach()
```

---

# 3. Complete Method Comparison

| Method | Purpose | Returns | Mutable |
|---------|----------|----------|----------|
| map() | Transform | New Array | ❌ |
| filter() | Select | New Array | ❌ |
| find() | First Match | Element | ❌ |
| findIndex() | First Index | Number | ❌ |
| some() | Any Match | Boolean | ❌ |
| every() | All Match | Boolean | ❌ |
| reduce() | Aggregate | Any Value | ❌ |
| flat() | Flatten | New Array | ❌ |
| flatMap() | Flatten + Transform | New Array | ❌ |
| sort() | Sort | Same Array | ✅ |
| forEach() | Side Effect | undefined | ❌ |

---

# 4. Syntax Cheat Sheet

## map()

```js
array.map(item => ...)
```

---

## filter()

```js
array.filter(item => ...)
```

---

## find()

```js
array.find(item => ...)
```

---

## findIndex()

```js
array.findIndex(item => ...)
```

---

## some()

```js
array.some(item => ...)
```

---

## every()

```js
array.every(item => ...)
```

---

## reduce()

```js
array.reduce(

(acc,current)=>...,

initialValue

)
```

---

## flat()

```js
array.flat()
```

---

## flatMap()

```js
array.flatMap(item => ...)
```

---

## sort()

```js
array.sort((a,b)=>a-b)
```

---

## forEach()

```js
array.forEach(item => ...)
```

---

# 5. Return Values

| Method | Returns |
|----------|----------|
| map() | Array |
| filter() | Array |
| find() | Element |
| findIndex() | Number |
| some() | Boolean |
| every() | Boolean |
| reduce() | Any |
| flat() | Array |
| flatMap() | Array |
| sort() | Same Array |
| forEach() | undefined |

---

# 6. Mutating vs Non-Mutating

## Mutating

```
sort()

reverse()

splice()

fill()

copyWithin()
```

---

## Non-Mutating

```
map()

filter()

find()

findIndex()

reduce()

flat()

flatMap()

slice()

concat()
```

---

# 7. Time Complexity

| Method | Time |
|----------|------|
| map() | O(n) |
| filter() | O(n) |
| find() | O(n) |
| findIndex() | O(n) |
| some() | O(n) Worst |
| every() | O(n) Worst |
| reduce() | O(n) |
| flat() | O(n) |
| flatMap() | O(n) |
| forEach() | O(n) |
| sort() | O(n log n) |

---

# 8. Space Complexity

| Method | Space |
|----------|-------|
| map() | O(n) |
| filter() | O(n) |
| flat() | O(n) |
| flatMap() | O(n) |
| reduce() | Depends |
| find() | O(1) |
| some() | O(1) |
| every() | O(1) |
| forEach() | O(1) |
| sort() | Engine Dependent |

---

# 9. Pattern Recognition

| Requirement | Method |
|--------------|---------|
| Transform | map() |
| Filter | filter() |
| Find | find() |
| Index | findIndex() |
| Any Condition | some() |
| Every Condition | every() |
| Sum | reduce() |
| Average | reduce() |
| Maximum | reduce() |
| Minimum | reduce() |
| Frequency Counter | reduce() |
| Grouping | reduce() |
| Lookup Table | reduce() |
| Flatten | flat() |
| Flatten + Transform | flatMap() |
| Print | forEach() |
| Sort | sort() |

---

# 10. React Cheat Sheet

| Requirement | Method |
|-------------|---------|
| Render List | map() |
| Filter Data | filter() |
| Search Item | find() |
| Calculate Totals | reduce() |
| Validation | some() / every() |
| Side Effects | forEach() inside useEffect |

---

Example

```jsx
users

.filter(user=>user.active)

.map(user=>

<User

key={user.id}

user={user}

/>

)
```

---

# 11. Node.js Cheat Sheet

| Requirement | Method |
|-------------|---------|
| API Transformation | map() |
| Database Filtering | filter() |
| Revenue | reduce() |
| Nested JSON | flatMap() |
| Logging | forEach() |
| Validation | every() |
| Sorting | sort() |

---

Example

```js
const revenue =

orders.reduce(

(total,order)=>

total+order.amount,

0

);
```

---

# 12. Modern ES2023+ Methods

| Method | Purpose |
|----------|----------|
| toSorted() | Immutable Sort |
| toReversed() | Immutable Reverse |
| toSpliced() | Immutable Splice |
| with() | Immutable Replace |
| findLast() | Last Match |
| findLastIndex() | Last Index |

Example

```js
const sorted =

numbers.toSorted(

(a,b)=>a-b

);
```

Original array

```
Never Changes
```

---

# Interview Formula

```
Read Problem

↓

Identify Pattern

↓

Choose Method

↓

Analyze Complexity

↓

Write Code

↓

Optimize

↓

Explain
```

---

# Most Asked Interview Methods

```
reduce()

↓

filter()

↓

map()

↓

find()

↓

sort()

↓

flatMap()
```

---

# Common Interview Mistakes

❌ map() instead of filter()

---

❌ forEach() instead of map()

---

❌ Missing compare function in sort()

---

❌ Using reduce() for everything

---

❌ Forgetting immutability

---

❌ Ignoring edge cases

---

# One Page Revision

```
Transform

↓

map()

----------------

Select

↓

filter()

----------------

Find One

↓

find()

----------------

Find Index

↓

findIndex()

----------------

Check Any

↓

some()

----------------

Check All

↓

every()

----------------

Aggregate

↓

reduce()

----------------

Flatten

↓

flat()

----------------

Flatten + Transform

↓

flatMap()

----------------

Sort

↓

sort()

----------------

Side Effects

↓

forEach()
```

---

# 🎉 Functional Programming Mastery Complete

You have mastered

- ✅ Functional Programming Fundamentals
- ✅ map()
- ✅ filter()
- ✅ find()
- ✅ findIndex()
- ✅ some()
- ✅ every()
- ✅ reduce()
- ✅ sort()
- ✅ flat()
- ✅ flatMap()
- ✅ forEach()
- ✅ Method Chaining
- ✅ Real World Patterns
- ✅ Interview Patterns
- ✅ ES2023+ Array Methods
- ✅ Complexity Analysis
- ✅ React Usage
- ✅ Node.js Usage
- ✅ FAANG Interview Thinking
- ✅ Functional Programming Cheat Sheet

---

# What's Next?

➡️ **Day 3 – JavaScript Execution Model**

Topics:

- Execution Context
- Call Stack
- Hoisting
- Scope
- Lexical Environment
- Closures
- this Keyword
- Event Loop
- Web APIs
- Callback Queue
- Microtask Queue
- Promises
- Async/Await
- Memory Management
- Garbage Collection
- JavaScript Engine Internals