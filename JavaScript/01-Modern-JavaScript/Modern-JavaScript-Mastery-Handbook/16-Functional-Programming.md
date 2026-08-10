# Functional Programming (FP)

> **"Functional Programming is a programming paradigm where programs are built by composing pure functions, avoiding shared state, minimizing side effects, and treating functions as first-class citizens."**

---

# Table of Contents

1. What is Functional Programming?
2. Why Functional Programming?
3. Imperative vs Declarative Programming
4. Pure Functions
5. Impure Functions
6. Side Effects
7. Immutability
8. First-Class Functions
9. Higher-Order Functions
10. Function Composition
11. Currying
12. Partial Application
13. Memoization
14. Recursion in Functional Programming
15. Functional Programming in JavaScript
16. Functional Programming in React
17. Functional Programming in Node.js
18. Best Practices
19. Common Mistakes
20. Interview Questions
21. Coding Exercises
22. Summary

---

# 1. What is Functional Programming?

Functional Programming (FP) is a programming style where:

- Functions are the building blocks.
- Data is not modified directly.
- Functions avoid side effects.
- Same input always produces the same output.

Instead of changing data,

we create new data.

---

Example

Imperative

```js
let numbers = [1, 2, 3];

for (let i = 0; i < numbers.length; i++) {
  numbers[i] *= 2;
}
```

Functional

```js
const numbers = [1, 2, 3];

const doubled = numbers.map(num => num * 2);
```

---

# 2. Why Functional Programming?

Benefits

- Predictable code
- Easier debugging
- Easier testing
- Better reusability
- Fewer bugs
- Better React performance

Visualization

```
Input

↓

Pure Function

↓

Output
```

---

# 3. Imperative vs Declarative Programming

## Imperative

Tell JavaScript **how** to do something.

```js
let sum = 0;

for (let i = 0; i < 5; i++) {
  sum += i;
}
```

---

## Declarative

Tell JavaScript **what** you want.

```js
const numbers = [0,1,2,3,4];

const sum =
numbers.reduce(
(total,num)=>total+num,
0
);
```

---

Comparison

| Imperative | Declarative |
|------------|-------------|
| How | What |
| More code | Less code |
| Manual loops | Array methods |
| More errors | Easier to read |

---

# 4. Pure Functions

A Pure Function

- Same input
- Same output
- No side effects

Example

```js
function square(x){
    return x*x;
}
```

Output

```
square(5)

↓

25

Always
```

---

Another Example

```js
function add(a,b){
    return a+b;
}
```

Always predictable.

---

# 5. Impure Functions

Impure functions depend on external state or modify data.

Example

```js
let total = 0;

function add(value){

    total += value;

}
```

Output depends on previous calls.

Not predictable.

---

Another Example

```js
let count = 1;

function next(){

    return count++;

}
```

---

# 6. Side Effects

A Side Effect is anything outside returning a value.

Examples

- console.log()
- DOM Manipulation
- API Calls
- Database Queries
- File Reading
- Modifying Global Variables

Example

```js
function greet(){

    console.log("Hello");

}
```

Printing is a side effect.

---

Pure Version

```js
function greet(){

    return "Hello";

}
```

---

# 7. Immutability

Instead of modifying existing data,

create new data.

Wrong

```js
const numbers = [1,2,3];

numbers.push(4);
```

Original array changes.

---

Correct

```js
const numbers = [1,2,3];

const updated = [
...numbers,
4
];
```

Output

```
Original

↓

[1,2,3]

New

↓

[1,2,3,4]
```

---

Objects

Wrong

```js
user.age = 23;
```

Correct

```js
const updated = {
...user,
age:23
};
```

---

# 8. First-Class Functions

Functions behave like variables.

```js
const greet = ()=>{
    console.log("Hello");
};

greet();
```

---

Pass as Argument

```js
execute(greet);
```

---

Return from Function

```js
return function(){};
```

---

Store in Object

```js
const user = {
    greet(){}
};
```

---

# 9. Higher-Order Functions

Functions that

- Receive functions
- Return functions

Examples

```
map()

filter()

reduce()

find()

some()

every()

forEach()
```

Example

```js
numbers.map(
num=>num*2
);
```

---

# 10. Function Composition

Compose multiple small functions.

Example

```js
const add =
x=>x+2;

const multiply =
x=>x*3;

const result =
multiply(
add(5)
);

console.log(result);
```

Output

```
21
```

Visualization

```
5

↓

add

↓

7

↓

multiply

↓

21
```

---

# 11. Currying

Currying converts

```
f(a,b,c)
```

into

```
f(a)(b)(c)
```

Example

```js
function multiply(a){

    return function(b){

        return a*b;

    }

}

const double =
multiply(2);

console.log(
double(10)
);
```

Output

```
20
```

---

Arrow Version

```js
const multiply =
a=>b=>a*b;
```

---

# 12. Partial Application

Fix some arguments beforehand.

Example

```js
function multiply(a,b){

    return a*b;

}

const double =
num=>multiply(2,num);

console.log(
double(10)
);
```

Output

```
20
```

Difference

| Currying | Partial Application |
|----------|---------------------|
| One argument at a time | Pre-fills arguments |

---

# 13. Memoization

Stores previous results.

Without Memoization

```
fib(40)

↓

Repeated calculations
```

---

Simple Example

```js
const cache = {};

function square(num){

    if(cache[num]){
        return cache[num];
    }

    cache[num] = num*num;

    return cache[num];

}
```

Visualization

```
Input

↓

Cache?

↓

Yes

↓

Return Cached Value

↓

No

↓

Calculate

↓

Store

↓

Return
```

---

# 14. Recursion in Functional Programming

Instead of loops,

FP often uses recursion.

Example

```js
function factorial(n){

    if(n===1)
        return 1;

    return n *
    factorial(n-1);

}
```

---

# 15. Functional Programming in JavaScript

Examples

```js
map()

filter()

reduce()

find()

every()

some()

flatMap()
```

Modern JavaScript encourages FP.

---

# 16. Functional Programming in React

React heavily follows FP.

Rendering

```jsx
users.map(user=>

<User
key={user.id}
/>

)
```

Updating State

```jsx
setUser({

...user,

age:23

});
```

No mutation.

---

# 17. Functional Programming in Node.js

Example

```js
const emails =
users
.filter(
u=>u.active
)
.map(
u=>u.email
);
```

---

Middleware

```js
app.use(
(req,res,next)=>{

next();

}
);
```

---

# 18. Best Practices

✅ Prefer Pure Functions.

✅ Avoid Global Variables.

✅ Don't mutate arrays.

✅ Don't mutate objects.

✅ Prefer map(), filter(), reduce().

✅ Keep functions small.

---

# 19. Common Mistakes

### Mutating Original Array

Wrong

```js
array.push(10);
```

---

Correct

```js
[
...array,
10
]
```

---

### Using map() for Side Effects

Wrong

```js
numbers.map(
num=>console.log(num)
);
```

Use

```
forEach()
```

---

### Impure Function

Wrong

```js
let count = 0;

function increment(){

count++;

}
```

---

# 20. Interview Questions

## What is Functional Programming?

A programming style focused on pure functions, immutability, and avoiding side effects.

---

## What is a Pure Function?

A function that always produces the same output for the same input and has no side effects.

---

## What is Immutability?

Never modifying existing data.

Instead,

create new data.

---

## Difference between Pure and Impure Functions?

| Pure | Impure |
|------|---------|
| Same Output | Different Output |
| No Side Effects | Has Side Effects |

---

## What is Currying?

Converting

```js
f(a,b)
```

into

```js
f(a)(b)
```

---

## What is Memoization?

Caching previous function results to improve performance.

---

## Why does React encourage Functional Programming?

Because immutable updates make rendering predictable and efficient.

---

# 21. Coding Exercises

### Exercise 1

Convert an impure function into a pure function.

---

### Exercise 2

Use

```js
map()
```

instead of a loop.

---

### Exercise 3

Create a curried multiply function.

---

### Exercise 4

Write a memoized square function.

---

### Exercise 5

Update an object without mutation.

---

### Exercise 6

Compose two functions together.

---

# 22. Summary

- Functional Programming treats functions as the primary building blocks.
- Pure Functions are predictable and easy to test.
- Avoid side effects whenever possible.
- Use immutable updates with arrays and objects.
- JavaScript supports Functional Programming through first-class functions and higher-order functions.
- React relies heavily on immutable data and functional programming concepts.
- Understanding FP improves code quality, maintainability, and interview performance.

---

# What's Next?

➡️ **17-ES6-Patterns.md**

You'll learn:

- Common ES6 Coding Patterns
- Object & Array Transformations
- Chaining Methods
- Factory Functions
- Module Pattern
- Revealing Module Pattern
- Builder Pattern
- Functional Composition
- Real-world Interview Patterns
- Coding Exercises