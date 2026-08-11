# Part 1 — Higher-Order Functions: Fundamentals

## 1. What is a Higher-Order Function?

A **Higher-Order Function (HOF)** is a function that:

* accepts another function as an argument, **or**
* returns another function, **or**
* does both.

### Example

```js
function execute(fn) {
    fn();
}

function greet() {
    console.log("Hello");
}

execute(greet);
```

Output:

```text
Hello
```

Here:

```text
execute()
   ↓
receives greet
   ↓
Higher-Order Function
```

And:

```text
greet
   ↓
function passed as argument
   ↓
Callback
```

---

## 2. Core Mental Model

Remember this:

```text
Function
   │
   ├── receives another function
   │
   └── returns another function
          ↓
   Higher-Order Function
```

### Example — Receives a Function

```js
function run(task) {
    task();
}
```

`run()` is a HOF because it receives `task`.

### Example — Returns a Function

```js
function createGreeting() {
    return function () {
        console.log("Hello");
    };
}
```

`createGreeting()` is a HOF because it returns a function.

---

## 3. Why HOFs Matter

Without HOF:

```js
function doubleNumbers(numbers) {
    const result = [];

    for (const number of numbers) {
        result.push(number * 2);
    }

    return result;
}
```

With a reusable function:

```js
function transform(numbers, operation) {
    const result = [];

    for (const number of numbers) {
        result.push(operation(number));
    }

    return result;
}
```

Now we can change the behavior:

```js
transform([1, 2, 3], number => number * 2);
```

or:

```js
transform([1, 2, 3], number => number + 10);
```

The **loop stays the same**, while the behavior changes.

That is the main power of HOFs:

> **Pass behavior as a value.**

---

## 4. Important Distinction

### Callback

A function **passed into** another function.

```js
number => number * 2
```

### Higher-Order Function

The function that **receives or returns** a function.

```js
transform(numbers, callback)
```

So:

```text
transform()
     ↓
HOF

number => number * 2
     ↓
Callback
```

### Remember

> **Callback = function being passed.**
> **HOF = function receiving/returning a function.**

---

## 5. First Example to Remember

```js
function calculate(a, b, operation) {
    return operation(a, b);
}

function add(x, y) {
    return x + y;
}

console.log(calculate(10, 20, add));
```

Output:

```text
30
```

Flow:

```text
calculate(10, 20, add)
             ↓
          operation
             ↓
            add
             ↓
         add(10, 20)
             ↓
             30
```

This is the fundamental HOF pattern you need to understand before moving forward.
# Part 2 — First-Class Functions

JavaScript treats **functions as values**.

That means a function can be used like other values such as strings or numbers.

---

## 1. Store a Function in a Variable

```js
const greet = function () {
    console.log("Hello");
};

greet();
```

Output:

```text
Hello
```

Here:

```text
function
   ↓
stored inside
   ↓
greet
```

You can also use an arrow function:

```js
const add = (a, b) => a + b;

console.log(add(2, 3));
```

Output:

```text
5
```

---

## 2. Pass a Function as an Argument

A function can be passed to another function.

```js
function execute(task) {
    task();
}

function greet() {
    console.log("Hello");
}

execute(greet);
```

Output:

```text
Hello
```

Here:

```text
greet
  ↓
passed as value
  ↓
execute()
```

This is the foundation of **callbacks and Higher-Order Functions**.

---

## 3. Return a Function

A function can return another function.

```js
function createGreeting() {
    return function () {
        console.log("Hello");
    };
}

const greet = createGreeting();

greet();
```

Output:

```text
Hello
```

Flow:

```text
createGreeting()
       ↓
returns function
       ↓
greet
       ↓
greet()
```

This pattern later connects directly to **closures**.

---

## 4. Store Functions in an Object

Functions can be object properties.

```js
const user = {
    name: "Om",

    greet() {
        console.log("Hello");
    }
};

user.greet();
```

Output:

```text
Hello
```

The function is a **method** of the object.

---

## 5. Store Functions in an Array

Functions can also be stored inside arrays.

```js
const operations = [
    x => x + 1,
    x => x * 2
];

console.log(operations[0](5));
console.log(operations[1](5));
```

Output:

```text
6
10
```

The array contains functions as values.

---

## 6. Why First-Class Functions Matter

Because functions can be treated as values, JavaScript can do this:

```js
function calculate(a, b, operation) {
    return operation(a, b);
}

const add = (a, b) => a + b;

const multiply = (a, b) => a * b;

console.log(calculate(5, 3, add));
console.log(calculate(5, 3, multiply));
```

Output:

```text
8
15
```

The same `calculate()` function can perform different operations.

```text
calculate()
     │
     ├── add
     │
     └── multiply
```

This is one of the main reasons Higher-Order Functions are so useful.

---

## Interview Point

### What does "functions are first-class citizens" mean?

It means JavaScript allows functions to be treated as values.

They can be:

```text
✅ stored in variables
✅ passed as arguments
✅ returned from functions
✅ stored in objects
✅ stored in arrays
```
# Part 3 — Callback Functions

A **callback function** is a function that is **passed as an argument to another function** so that the receiving function can call it.

---

## 1. Basic Example

```js
function execute(task) {
    task();
}

function greet() {
    console.log("Hello");
}

execute(greet);
```

Output:

```text
Hello
```

Flow:

```text
greet
  ↓
passed to execute()
  ↓
task
  ↓
task()
  ↓
Hello
```

Here:

```text
execute() → Higher-Order Function
greet     → Callback Function
```

---

## 2. Callback with Parameters

A callback can receive values from the function that calls it.

```js
function calculate(a, b, operation) {
    return operation(a, b);
}

function add(x, y) {
    return x + y;
}

console.log(calculate(10, 20, add));
```

Output:

```text
30
```

The important part is:

```js
operation(a, b);
```

The function `add` is passed in and later called with `a` and `b`.

---

## 3. Anonymous Callback

We don't always need to create a separate function.

```js
function calculate(a, b, operation) {
    return operation(a, b);
}

const result = calculate(10, 20, function (x, y) {
    return x * y;
});

console.log(result);
```

Output:

```text
200
```

---

## 4. Arrow Function Callback

The same thing can be written more concisely:

```js
const result = calculate(
    10,
    20,
    (x, y) => x * y
);

console.log(result);
```

Output:

```text
200
```

This style is extremely common in modern JavaScript.

---

## 5. Callback vs Calling a Function

This is an important interview/OA trap.

### Passing the function

```js
execute(greet);
```

Means:

> "Give `greet` to `execute`."

### Calling the function

```js
execute(greet());
```

Means:

> "Run `greet` now and give its return value to `execute`."

Compare:

```js
setTimeout(greet, 1000);
```

✅ Correct — pass the function.

```js
setTimeout(greet(), 1000);
```

❌ Usually wrong — `greet()` executes immediately.

---

## 6. Real JavaScript Examples

Callbacks appear everywhere.

### Array Methods

```js
const numbers = [1, 2, 3];

numbers.map(num => num * 2);
```

Here:

```text
map()                  → HOF
num => num * 2         → callback
```

---

### setTimeout

```js
setTimeout(() => {
    console.log("Done");
}, 1000);
```

The arrow function is passed as a callback.

---

### Event Listener

```js
button.addEventListener("click", handleClick);
```

`handleClick` is the callback.

---

## 7. Callback Mental Model

```text
            FUNCTION
                ↓
       passed to another
            function
                ↓
           CALLBACK
                ↓
     receiving function
         calls it
                ↓
            RESULT
```

### Most important distinction

```text
Callback
    ↓
Function passed to another function

Higher-Order Function
    ↓
Function that receives/returns functions
```

---

## Interview Questions

### What is a callback?

> A callback is a function passed as an argument to another function and invoked by that function.

### Is a callback always asynchronous?

**No.**

This is synchronous:

```js
[1, 2, 3].map(x => x * 2);
```

This is asynchronous:

```js
setTimeout(() => {
    console.log("Done");
}, 1000);
```

So:

> **Callback ≠ asynchronous.**

This is an important interview point.

### Can a callback receive arguments?

Yes.

```js
function execute(callback) {
    callback("Om");
}

execute(name => {
    console.log(name);
});
```

Output:

```text
Om
```

---

### Part 3 takeaway

```text
Callback
   =
function passed to another function

Callback can be:
   ↓
synchronous
   OR
asynchronous
```
# Part 4 — HOF: Interview, OA & Practice

This is the **final part** for Higher-Order Functions. We won't add more theory here because closures, functional programming, and array methods are covered elsewhere in your roadmap.

---

## 1. Interview Questions

### Q1. What is a Higher-Order Function?

A function that **accepts another function as an argument, returns a function, or both**.

---

### Q2. What is a callback function?

A function passed as an argument to another function.

```js
function execute(callback) {
    callback();
}
```

Here:

```text
execute() → HOF
callback  → Callback
```

---

### Q3. Is every callback asynchronous?

**No.**

Synchronous:

```js
[1, 2, 3].map(x => x * 2);
```

Asynchronous:

```js
setTimeout(() => {
    console.log("Done");
}, 1000);
```

A callback can be either synchronous or asynchronous.

---

### Q4. Why is `map()` a HOF?

Because `map()` accepts a function:

```js
numbers.map(num => num * 2);
```

Here:

```text
map()              → HOF
num => num * 2     → Callback
```

---

### Q5. What are First-Class Functions?

Functions can be treated as values:

```text
Store
Pass
Return
Use in objects
Use in arrays
```

---

### Q6. What's the difference between HOF and Callback?

```text
Callback
   ↓
Function being passed

HOF
   ↓
Function receiving/returning a function
```

---

## 2. Common OA Pitfalls

### Pitfall 1 — Calling Instead of Passing

```js
function greet() {
    console.log("Hello");
}

setTimeout(greet, 1000);
```

✅ Passes the function.

```js
setTimeout(greet(), 1000);
```

❌ Calls `greet()` immediately.

---

### Pitfall 2 — Callback Is Not Automatically Async

```js
function execute(callback) {
    console.log("Before");
    callback();
    console.log("After");
}

execute(() => console.log("Callback"));
```

Output:

```text
Before
Callback
After
```

The callback executes synchronously.

---

### Pitfall 3 — Confusing Function and Function Call

```js
greet
```

means:

> Function itself.

```js
greet()
```

means:

> Execute the function.

This distinction is extremely important in JavaScript.

---

# 3. Coding Practice

### Problem 1 — Execute

Implement:

```js
execute(callback)
```

Expected:

```js
execute(() => {
    console.log("Hello");
});
```

Output:

```text
Hello
```

---

### Problem 2 — Calculator

Implement:

```js
calculate(a, b, operation)
```

Example:

```js
calculate(10, 5, (a, b) => a + b);
calculate(10, 5, (a, b) => a * b);
```

Expected:

```text
15
50
```

---

### Problem 3 — Repeat

Implement:

```js
repeat(3, callback)
```

Expected:

```text
Hello
Hello
Hello
```

---

### Problem 4 — Return a Function

Implement:

```js
createMultiplier(5)
```

so that:

```js
const multiplyByFive = createMultiplier(5);

console.log(multiplyByFive(4));
```

outputs:

```text
20
```

---

### Problem 5 — Simple `myMap()`

Implement a basic version without using `.map()`:

```js
function myMap(arr, callback) {
    // implementation
}
```

Example:

```js
const result = myMap(
    [1, 2, 3],
    num => num * 2
);

console.log(result);
```

Expected:

```text
[2, 4, 6]
```

This is the **first step toward polyfills**. Full polyfill edge cases will be handled later during your final JavaScript revision.

---

# 4. Final Revision

Remember these:

```text
1. Functions are first-class values.

2. A callback is a function passed to another function.

3. A HOF accepts or returns functions.

4. A callback does NOT necessarily mean asynchronous.

5. map/filter/reduce are common HOFs.

6. HOFs allow behavior to be passed as a value.

7. Returning functions can create closures.
```

### One-minute interview answer

> **A Higher-Order Function is a function that accepts another function as an argument or returns another function. The passed function is commonly called a callback. JavaScript supports this because functions are first-class values. Examples include `map`, `filter`, `reduce`, `setTimeout`, and `addEventListener`.**

**Part 4 complete. HOF is done.**
