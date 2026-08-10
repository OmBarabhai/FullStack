# ES6 Interview Questions

> **"This chapter contains the most frequently asked ES6 interview questions from beginner to advanced level. Every answer is written in an interview-friendly manner and focuses on understanding rather than memorization."**

---

# Table of Contents

1. Introduction
2. Beginner Questions
3. Intermediate Questions
4. Advanced Questions
5. Scenario-Based Questions
6. Output-Based Questions
7. React-Oriented Questions
8. Node.js-Oriented Questions
9. Rapid Fire Questions
10. Coding Questions
11. HR-Friendly Explanations
12. Common Mistakes
13. Summary

---

# 1. Introduction

ES6 (ECMAScript 2015) introduced modern JavaScript features that are now used in almost every React, Node.js, Next.js, Express, Angular, and Vue project.

Interviewers usually test

- Concepts
- Practical usage
- Code readability
- Output prediction
- Real-world scenarios

---

# 2. Beginner Questions

---

## Q1. What is ES6?

**Answer**

ES6 (ECMAScript 2015) is a major update to JavaScript that introduced modern features such as:

- let
- const
- Arrow Functions
- Template Literals
- Classes
- Modules
- Destructuring
- Spread Operator
- Rest Parameters
- Promises

---

## Q2. Difference between var, let and const?

| var | let | const |
|------|------|--------|
| Function Scoped | Block Scoped | Block Scoped |
| Redeclaration Allowed | Not Allowed | Not Allowed |
| Reassignment Allowed | Yes | Yes (Object properties can change) |
| Hoisted | Hoisted | Hoisted (TDZ) |

---

## Q3. What is Temporal Dead Zone?

The period between entering a scope and initializing a `let` or `const` variable.

```js
console.log(a);

let a = 10;
```

Output

```
ReferenceError
```

---

## Q4. What are Arrow Functions?

Arrow Functions are shorter syntax for writing functions.

```js
const add = (a, b) => a + b;
```

---

## Q5. Difference between Function Declaration and Arrow Function?

| Function | Arrow |
|-----------|--------|
| Has its own `this` | Inherits `this` |
| Can be used before declaration | Cannot |
| Can be constructor | Cannot |

---

## Q6. What is Destructuring?

Extract values from arrays or objects.

```js
const { name } = user;
```

---

## Q7. What is Spread Operator?

Expands an iterable.

```js
const arr = [1,2];

const newArr = [...arr];
```

---

## Q8. What is Rest Operator?

Collects multiple values.

```js
function sum(...nums){}
```

---

## Q9. Difference between Spread and Rest?

Spread expands.

Rest collects.

---

## Q10. What are Template Literals?

Strings using backticks.

```js
`Hello ${name}`
```

---

# 3. Intermediate Questions

---

## Q11. What is Default Parameter?

```js
function greet(name="Guest"){}
```

---

## Q12. What is Optional Chaining?

Safely access nested properties.

```js
user.address?.city
```

---

## Q13. What is Nullish Coalescing?

Returns default value only for

- null
- undefined

```js
value ?? defaultValue
```

---

## Q14. Difference between || and ??

`||`

Checks all falsy values.

`??`

Checks only null and undefined.

---

## Q15. What are ES Modules?

JavaScript files using

```js
import

export
```

---

## Q16. Difference between Named Export and Default Export?

Named

```js
export function add(){}
```

Default

```js
export default add;
```

---

## Q17. Why use Modules?

- Reusability
- Maintainability
- Encapsulation

---

## Q18. What is Object Destructuring?

```js
const { age } = person;
```

---

## Q19. What is Array Destructuring?

```js
const [a,b] = arr;
```

---

## Q20. What are Higher-Order Functions?

Functions that

- accept functions
- return functions

Examples

```
map()

filter()

reduce()
```

---

# 4. Advanced Questions

---

## Q21. Explain Functional Programming.

Programming using

- Pure Functions
- Immutability
- Higher-Order Functions
- Function Composition

---

## Q22. What is Currying?

```js
f(a,b)

↓

f(a)(b)
```

---

## Q23. What is Memoization?

Caching function results.

---

## Q24. What is Function Composition?

Combining multiple small functions.

---

## Q25. Difference between Pure and Impure Functions?

Pure

- Same input
- Same output

Impure

Depends on external state.

---

## Q26. What are Side Effects?

Anything besides returning a value.

Examples

- API Call
- DOM Update
- Console
- Database

---

## Q27. What is Immutability?

Never modify original data.

Create new data.

---

## Q28. Why is Immutability important in React?

React detects state changes more efficiently when new objects or arrays are created instead of modifying existing ones.

---

## Q29. Why are Arrow Functions preferred in React?

- Shorter syntax
- Lexical `this`
- Cleaner callbacks

---

## Q30. Why is `map()` used in React?

To render lists.

```jsx
users.map(...)
```

---

# 5. Scenario-Based Questions

---

## Q31

Why is this wrong?

```js
user.age = 25;
```

Answer

It mutates the original object.

Use

```js
{
...user,
age:25
}
```

---

## Q32

Why does this fail?

```js
console.log(city);

let city="Pune";
```

Answer

Temporal Dead Zone.

---

## Q33

Difference

```js
const copy = obj;
```

vs

```js
const copy = {...obj};
```

First

Same reference.

Second

New object.

---

## Q34

Why does

```js
sort()
```

sometimes fail?

Because it sorts strings by default.

Need comparator.

---

## Q35

Why use

```js
Object.freeze()
```

To prevent modification.

---

# 6. Output-Based Questions

---

### Q36

```js
const a = 10;

console.log(a ?? 20);
```

Output

```
10
```

---

### Q37

```js
console.log(null ?? 50);
```

Output

```
50
```

---

### Q38

```js
console.log("" || "Hello");
```

Output

```
Hello
```

---

### Q39

```js
console.log("" ?? "Hello");
```

Output

```
""
```

---

### Q40

```js
const arr = [1,2,3];

const result =
arr.map(x=>x*2);

console.log(result);
```

Output

```
[2,4,6]
```

---

# 7. React-Oriented Questions

---

Why use

```
map()
```

To render components.

---

Why use Spread?

Immutable updates.

---

Why avoid mutation?

React may not detect changes correctly.

---

Why destructure props?

Cleaner code.

---

Why use default parameters?

Avoid undefined values.

---

# 8. Node.js-Oriented Questions

---

Why use Modules?

Split backend logic.

---

Why use Configuration Objects?

Cleaner APIs.

---

Why use Spread?

Merge configuration.

---

Why use Optional Chaining?

Safe API handling.

---

Why use Object.entries()?

Database transformations.

---

# 9. Rapid Fire Questions

- Is ES6 backward compatible?

Yes (after transpilation if needed).

---

- Can const objects change?

Properties can.

Reference cannot.

---

- Is Arrow Function hoisted?

No.

---

- Can Arrow Functions be constructors?

No.

---

- Which method returns a new array?

```
map()

filter()
```

---

- Which method mutates array?

```
sort()

reverse()
```

---

- Which operator copies arrays?

```
Spread
```

---

- Difference between map() and forEach()?

map returns new array.

forEach returns undefined.

---

- Difference between filter() and find()?

filter

All matches.

find

First match.

---

# 10. Coding Questions

1. Reverse an array using ES6.

2. Merge two objects.

3. Swap variables.

4. Find duplicate elements.

5. Remove duplicates using Set.

6. Convert array to object.

7. Convert object to array.

8. Flatten nested arrays.

9. Create custom map().

10. Create custom filter().

11. Group objects using reduce().

12. Deep clone an object.

13. Create a memoized function.

14. Create a curried function.

15. Build a configuration object function.

---

# 11. HR-Friendly Explanations

**What is ES6?**

> ES6 modernized JavaScript by introducing cleaner syntax, better modularity, and features that make applications easier to build and maintain.

---

**Why do companies prefer ES6?**

Because it improves readability, maintainability, scalability, and developer productivity.

---

**Which ES6 feature do you use the most?**

Common answers

- Arrow Functions
- Destructuring
- Modules
- Spread Operator
- Array Methods

---

# 12. Common Mistakes

❌ Using `var` in modern code.

❌ Mutating React state.

❌ Forgetting `return` inside `map()`.

❌ Using `filter()` instead of `find()`.

❌ Forgetting comparator in `sort()`.

❌ Confusing Rest and Spread.

❌ Using `||` instead of `??` for valid falsy values.

---

# 13. Summary

You should now be comfortable explaining:

- ES6 Overview
- let, const, var
- Arrow Functions
- Template Literals
- Destructuring
- Spread & Rest
- Default Parameters
- Optional Chaining
- Nullish Coalescing
- Modules
- Array Methods
- Object Methods
- Higher-Order Functions
- Functional Programming
- ES6 Patterns

These topics cover **95%+ of ES6 interview questions** asked in frontend (React), backend (Node.js), and full-stack JavaScript interviews.

---

# What's Next?

➡️ **19-Coding-Problems.md**

You'll solve **75+ curated ES6 coding problems** from beginner to advanced, focusing on real interview patterns, dry runs, multiple approaches, time complexity, and best practices.