# Higher-Order Functions (HOF)

> **"A Higher-Order Function (HOF) is a function that either accepts another function as an argument, returns a function, or both. Higher-Order Functions are one of the foundations of modern JavaScript, React, Node.js, and Functional Programming."**

---

# Table of Contents

1. What is a Higher-Order Function?
2. Why Higher-Order Functions?
3. First-Class Functions
4. Callback Functions
5. Passing Functions as Arguments
6. Returning Functions
7. Built-in Higher-Order Functions
8. Creating Your Own HOF
9. Closures with HOFs
10. Function Composition
11. Pure vs Impure Functions
12. Real-world Examples
13. React Examples
14. Node.js Examples
15. Performance Considerations
16. Best Practices
17. Common Mistakes
18. Interview Questions
19. Coding Exercises
20. Summary

---

# 1. What is a Higher-Order Function?

A Higher-Order Function is a function that:

- Accepts another function as a parameter
- Returns another function
- Or does both

Diagram

```
Function

↓

Receives Function

OR

Returns Function

↓

Higher-Order Function
```

---

Example

```js
function greet() {
    console.log("Hello");
}

function execute(fn) {
    fn();
}

execute(greet);
```

Output

```
Hello
```

Here

```
execute()

↓

Higher-Order Function

greet()

↓

Callback Function
```

---

# 2. Why Higher-Order Functions?

Without HOF

```js
console.log("Task Started");

console.log("Task Finished");
```

Repeated code everywhere.

---

With HOF

```js
function logger(task) {
    console.log("Task Started");

    task();

    console.log("Task Finished");
}

logger(() => {
    console.log("Reading File");
});
```

Output

```
Task Started

Reading File

Task Finished
```

Reusable.

---

# 3. First-Class Functions

JavaScript treats functions like variables.

Functions can be

- Stored in variables
- Passed as arguments
- Returned from functions
- Stored in objects
- Stored inside arrays

Example

```js
const greet = function () {
    console.log("Hello");
};

greet();
```

Output

```
Hello
```

---

Function inside Object

```js
const user = {
    greet() {
        console.log("Hi");
    }
};

user.greet();
```

---

Function inside Array

```js
const arr = [
    () => console.log("One"),
    () => console.log("Two")
];

arr[0]();
```

---

# 4. Callback Functions

A callback is simply a function passed into another function.

Example

```js
function calculate(a, b, operation) {
    return operation(a, b);
}

function add(x, y) {
    return x + y;
}

console.log(
calculate(5, 3, add)
);
```

Output

```
8
```

Visualization

```
calculate()

↓

Receives

↓

add()

↓

Executes

↓

Returns
```

---

Anonymous Callback

```js
calculate(
5,
3,
function(a,b){
    return a*b;
}
);
```

---

Arrow Function Callback

```js
calculate(
5,
3,
(a,b)=>a*b
);
```

---

# 5. Passing Functions as Arguments

Example

```js
function execute(task){
    task();
}

execute(function(){
    console.log("Running");
});
```

Output

```
Running
```

---

# 6. Returning Functions

Functions can return other functions.

Example

```js
function multiply(x){

    return function(y){
        return x * y;
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

Visualization

```
multiply(2)

↓

Returns Function

↓

double

↓

double(10)

↓

20
```

---

# 7. Built-in Higher-Order Functions

JavaScript already has many HOFs.

```
map()

filter()

reduce()

find()

findIndex()

some()

every()

forEach()

sort()
```

Example

```js
const nums = [1,2,3];

nums.map(num=>num*2);
```

`map()` is a Higher-Order Function because it accepts a callback.

---

# 8. Creating Your Own HOF

Example

```js
function repeat(times, task){

    for(let i=0;i<times;i++){

        task();

    }

}

repeat(3,()=>{

    console.log("Hello");

});
```

Output

```
Hello

Hello

Hello
```

---

Another Example

```js
function logger(fn){

    console.log("Started");

    fn();

    console.log("Finished");

}

logger(()=>{

    console.log("Learning JS");

});
```

---

# 9. Closures with HOFs

Example

```js
function counter(){

    let count = 0;

    return function(){

        count++;

        return count;

    };

}

const increment =
counter();

console.log(
increment()
);

console.log(
increment()
);
```

Output

```
1

2
```

Explanation

Returned function remembers

```
count
```

Even after

```
counter()
```

has finished.

This is a **Closure**.

---

# 10. Function Composition

Combining multiple functions.

Example

```js
const add =
x => x + 2;

const multiply =
x => x * 3;

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

# 11. Pure vs Impure Functions

## Pure Function

Same input

↓

Same output

```js
function square(x){

    return x*x;

}
```

---

## Impure Function

Depends on external state.

```js
let total = 0;

function add(x){

    total += x;

}
```

Avoid impure functions whenever possible.

---

# 12. Real-world Examples

Button Click

```js
button.addEventListener(
"click",
handleClick
);
```

`addEventListener()` is a Higher-Order Function.

---

setTimeout

```js
setTimeout(
()=>{
console.log("Done");
},
1000
);
```

---

Promise

```js
fetch(url)
.then(data=>{

});
```

---

Array Methods

```js
users.map(
user=>user.name
);
```

---

# 13. React Examples

Rendering List

```jsx
users.map(user=>(
<User
key={user.id}
user={user}
/>
))
```

---

Button

```jsx
<button
onClick={handleClick}
>
Click
</button>
```

---

Hooks

```jsx
useEffect(()=>{

},[]);
```

The callback passed to `useEffect()` is a function.

---

# 14. Node.js Examples

Reading Files

```js
fs.readFile(
"path",
(err,data)=>{

}
);
```

---

Express

```js
app.get(
"/",
(req,res)=>{

}
);
```

---

Middleware

```js
app.use(
(req,res,next)=>{

}
);
```

---

# 15. Performance Considerations

Creating unnecessary functions repeatedly may increase memory usage.

Example

```jsx
<button
onClick={()=>{
console.log("Clicked");
}}
>
```

In React,

creating new functions every render may affect optimization.

---

# 16. Best Practices

✅ Keep callbacks small.

✅ Use arrow functions when appropriate.

✅ Prefer pure functions.

✅ Reuse callback functions.

✅ Use HOFs instead of repetitive loops.

---

# 17. Common Mistakes

### Calling Instead of Passing

Wrong

```js
setTimeout(
greet(),
1000
);
```

Correct

```js
setTimeout(
greet,
1000
);
```

---

### Forgetting Return in map()

Wrong

```js
numbers.map(num=>{
num*2;
});
```

Returns

```
undefined
```

---

### Confusing Callback with HOF

Higher-Order Function

```
map()
```

Callback

```
num=>num*2
```

---

# 18. Interview Questions

### What is a Higher-Order Function?

A function that accepts another function or returns another function.

---

### What is a Callback?

A function passed as an argument to another function.

---

### Why is `map()` a Higher-Order Function?

Because it receives a callback.

---

### Is every callback a Higher-Order Function?

No.

The callback is passed **to** a Higher-Order Function.

---

### Can a function return another function?

Yes.

Closures are built using this concept.

---

### Give examples of Higher-Order Functions.

- map()
- filter()
- reduce()
- find()
- sort()
- forEach()
- setTimeout()
- addEventListener()

---

# 19. Coding Exercises

### Exercise 1

Create a Higher-Order Function

```js
repeat(5, callback)
```

---

### Exercise 2

Create a calculator using callbacks.

---

### Exercise 3

Create a function that returns another function.

---

### Exercise 4

Implement your own version of

```js
map()
```

using a loop.

---

### Exercise 5

Implement your own

```js
filter()
```

---

### Exercise 6

Build a simple logger HOF.

---

# 20. Summary

- Functions are first-class citizens in JavaScript.
- Higher-Order Functions accept or return functions.
- Callbacks are functions passed to HOFs.
- `map()`, `filter()`, `reduce()`, `setTimeout()`, `addEventListener()`, and Promise methods are Higher-Order Functions.
- Closures are often created by functions returning functions.
- Higher-Order Functions make code reusable, modular, and expressive.
- React, Express, Node.js, and modern JavaScript rely heavily on this concept.

---

# What's Next?

➡️ **16-Functional-Programming.md**

You'll learn:

- What Functional Programming is
- Pure Functions
- Immutability
- Side Effects
- Function Composition
- Declarative vs Imperative Programming
- Currying
- Memoization
- Interview Questions
- Coding Exercises