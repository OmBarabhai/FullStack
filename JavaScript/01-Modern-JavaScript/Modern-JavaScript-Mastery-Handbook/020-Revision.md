# ES6 Revision Guide

> **"Learning is not complete until you can recall, explain, and apply the concepts without looking at notes."**

This chapter is your **final revision handbook**. Before moving to React or appearing for interviews, use this guide to revise everything quickly and efficiently.

---

# Table of Contents

1. Why Revision Matters
2. One-Day Revision Plan
3. Three-Day Revision Plan
4. Seven-Day Revision Plan
5. 30-Day Retention Plan
6. Interview Revision Checklist
7. ES6 One-Page Cheat Sheet
8. Common Mistakes Checklist
9. Rapid Fire Questions
10. Mini Coding Challenges
11. Self-Evaluation Scorecard
12. Final Interview Readiness Checklist
13. Summary

---

# 1. Why Revision Matters

Learning something once is not enough.

Without revision:

```
Learn

↓

Forget

↓

Learn Again

↓

Forget Again
```

With revision:

```
Learn

↓

Revise

↓

Practice

↓

Recall

↓

Long-Term Memory
```

---

# 2. One-Day Revision Plan

Complete this in **60–90 minutes**.

| Topic | Time |
|---------|------|
| let / const / var | 5 min |
| Arrow Functions | 5 min |
| Template Literals | 5 min |
| Default Parameters | 5 min |
| Rest & Spread | 10 min |
| Destructuring | 10 min |
| Optional Chaining | 5 min |
| Nullish Coalescing | 5 min |
| Modules | 5 min |
| Array Methods | 15 min |
| Object Methods | 10 min |
| HOF & FP | 15 min |

---

# 3. Three-Day Revision Plan

## Day 1

- let / const / var
- Arrow Functions
- Template Literals
- Default Parameters
- Rest Parameters
- Spread Operator
- Destructuring

---

## Day 2

- Optional Chaining
- Nullish Coalescing
- Modules
- Array Methods
- Object Methods

---

## Day 3

- Higher Order Functions
- Functional Programming
- ES6 Patterns
- Coding Problems
- Interview Questions

---

# 4. Seven-Day Revision Plan

| Day | Topics |
|------|--------|
| 1 | Variables + Functions |
| 2 | Destructuring + Spread + Rest |
| 3 | Optional Chaining + Nullish |
| 4 | Modules + Object Methods |
| 5 | Array Methods |
| 6 | HOF + Functional Programming |
| 7 | Interview Questions + Coding Practice |

---

# 5. 30-Day Retention Plan

Use **Spaced Repetition**.

| Revision | Day |
|----------|-----|
| Learn | Day 1 |
| Revision 1 | Day 2 |
| Revision 2 | Day 4 |
| Revision 3 | Day 7 |
| Revision 4 | Day 15 |
| Revision 5 | Day 30 |

This helps move knowledge into long-term memory.

---

# 6. Interview Revision Checklist

Before every interview, ask yourself:

## Variables

- [ ] Difference between var, let and const?
- [ ] Hoisting?
- [ ] TDZ?

---

## Functions

- [ ] Arrow Function?
- [ ] Default Parameters?
- [ ] Rest Parameters?
- [ ] Spread Operator?

---

## Objects

- [ ] Destructuring?
- [ ] Object.keys()?
- [ ] Object.values()?
- [ ] Object.entries()?
- [ ] Object.freeze()?
- [ ] Object.seal()?

---

## Arrays

- [ ] map()
- [ ] filter()
- [ ] reduce()
- [ ] find()
- [ ] some()
- [ ] every()
- [ ] sort()

---

## ES2020

- [ ] Optional Chaining
- [ ] Nullish Coalescing

---

## Functional Programming

- [ ] Pure Function
- [ ] Higher Order Function
- [ ] Callback
- [ ] Closure
- [ ] Immutability

---

## Modules

- [ ] import
- [ ] export
- [ ] Named Export
- [ ] Default Export

---

# 7. ES6 One-Page Cheat Sheet

## Variables

```js
let

const

var
```

---

## Arrow Function

```js
const add = (a, b) => a + b;
```

---

## Template Literal

```js
`Hello ${name}`
```

---

## Default Parameter

```js
function greet(name = "Guest") {}
```

---

## Rest Parameter

```js
function sum(...nums) {}
```

---

## Spread

```js
const copy = [...arr];

const obj = { ...user };
```

---

## Destructuring

```js
const { name } = user;

const [a, b] = arr;
```

---

## Optional Chaining

```js
user.address?.city
```

---

## Nullish Coalescing

```js
value ?? defaultValue
```

---

## Modules

```js
export

import
```

---

## map()

```js
arr.map()
```

---

## filter()

```js
arr.filter()
```

---

## reduce()

```js
arr.reduce()
```

---

## find()

```js
arr.find()
```

---

## Object.keys()

```js
Object.keys()
```

---

## Object.entries()

```js
Object.entries()
```

---

# 8. Common Mistakes Checklist

Before submitting code:

- [ ] Did I mutate the original array?
- [ ] Did I forget `return` inside `map()`?
- [ ] Did I use `find()` instead of `filter()` when only one item was needed?
- [ ] Did I forget the comparator in `sort()`?
- [ ] Am I using `||` where `??` is more appropriate?
- [ ] Did I accidentally use `var`?
- [ ] Did I forget to handle `null` or `undefined`?
- [ ] Did I choose the right array method?

---

# 9. Rapid Fire Questions

Answer these without looking at notes.

1. Difference between `let` and `const`?
2. What is TDZ?
3. What is hoisting?
4. Difference between Rest and Spread?
5. Difference between `map()` and `forEach()`?
6. Difference between `find()` and `filter()`?
7. Difference between `some()` and `every()`?
8. Difference between `||` and `??`?
9. What is Optional Chaining?
10. What is a Higher Order Function?
11. What is a Callback?
12. What is a Pure Function?
13. What is Immutability?
14. Difference between Named Export and Default Export?
15. What is Function Composition?
16. Difference between `Object.freeze()` and `Object.seal()`?
17. What does `Object.entries()` return?
18. Why use destructuring?
19. Why use modules?
20. Why is ES6 important?

If you can confidently answer all 20, you're in excellent shape.

---

# 10. Mini Coding Challenges

Solve these without referring to notes.

1. Double an array using `map()`.
2. Filter odd numbers.
3. Find a student by ID.
4. Sum an array using `reduce()`.
5. Merge two objects.
6. Swap variables.
7. Destructure a nested object.
8. Create a curried multiply function.
9. Write a memoized function.
10. Build a reusable factory function.

---

# 11. Self-Evaluation Scorecard

Rate yourself from **1–5**.

| Topic | Score |
|---------|------:|
| let / const / var | |
| Arrow Functions | |
| Template Literals | |
| Destructuring | |
| Spread | |
| Rest | |
| Default Parameters | |
| Optional Chaining | |
| Nullish Coalescing | |
| Modules | |
| Array Methods | |
| Object Methods | |
| Higher Order Functions | |
| Functional Programming | |
| ES6 Patterns | |

Scoring

- **65–75** → Interview Ready ✅
- **50–64** → Revise Weak Areas ⚠️
- **Below 50** → Practice More ❌

---

# 12. Final Interview Readiness Checklist

Before moving to React, ensure you can:

- [ ] Explain every ES6 feature in your own words.
- [ ] Solve array/object problems without Googling.
- [ ] Predict outputs of ES6 code.
- [ ] Explain why one approach is better than another.
- [ ] Write clean, modern JavaScript.
- [ ] Use `map()`, `filter()`, and `reduce()` confidently.
- [ ] Explain HOFs and Functional Programming.
- [ ] Work with Modules.
- [ ] Handle optional values safely using `?.` and `??`.
- [ ] Build small utilities using ES6 features.

If all boxes are checked, you're ready to start React.

---

# 13. Summary

Congratulations! 🎉

You have completed the **ES6 Mastery Handbook**.

You covered:

- Variables
- Functions
- Template Literals
- Default Parameters
- Rest Parameters
- Spread Operator
- Destructuring
- Optional Chaining
- Nullish Coalescing
- Modules
- Array Methods
- Object Methods
- Higher Order Functions
- Functional Programming
- ES6 Patterns
- Interview Questions
- Coding Problems
- Revision Strategy

This handbook provides a solid ES6 foundation for:

- React
- Node.js
- Express
- Next.js
- MERN Stack
- Frontend Interviews
- Full Stack Interviews

---

# Final Advice

Don't just **read** JavaScript.

**Write it. Debug it. Explain it. Teach it.**

That's how mastery happens.

🚀 **Next Step:** Move to **React** with confidence.