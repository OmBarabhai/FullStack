# forEach()

# Part 1 – Introduction & Fundamentals

> **"`forEach()` is a JavaScript array method used to execute a callback function once for every element in an array. It is mainly used when you want to perform an action (side effect) such as printing values, updating objects, or modifying external variables. Unlike `map()`, it does not return a new array."**

---

# Table of Contents

1. Introduction
2. Why `forEach()` Was Introduced
3. Syntax
4. Parameters
5. Return Value
6. Internal Working
7. Callback Function
8. Visualization
9. Memory Behavior
10. First Examples
11. `forEach()` vs `for...of`
12. Best Practices
13. Common Mistakes
14. Interview Questions
15. Coding Exercises
16. Summary

---

# 1. Introduction

Suppose we have

```js
const numbers = [10,20,30];
```

We want to print every number.

Without `forEach()`

```js
for(let i=0;i<numbers.length;i++){

    console.log(numbers[i]);

}
```

Using `forEach()`

```js
numbers.forEach(

    num=>{

        console.log(num);

    }

);
```

Output

```
10

20

30
```

---

# 2. Why `forEach()` Was Introduced

Before ES5,

developers mainly used

- `for`
- `while`
- `for...in`

to iterate over arrays.

Example

```js
const fruits = [

    "Apple",

    "Banana",

    "Orange"

];

for(let i=0;i<fruits.length;i++){

    console.log(fruits[i]);

}
```

More code.

---

Using `forEach()`

```js
fruits.forEach(

    fruit=>{

        console.log(fruit);

    }

);
```

Cleaner and easier to read.

---

# 3. Syntax

```js
array.forEach(

    callback

);
```

or

```js
array.forEach(

    (

        currentValue,

        index,

        array

    )=>{

    }

);
```

---

# 4. Parameters

The callback receives

| Parameter | Description |
|-----------|-------------|
| currentValue | Current element |
| index | Current index |
| array | Original array |

---

Example

```js
const numbers = [10,20];

numbers.forEach(

    (

        num,

        index

    )=>{

        console.log(

            num,

            index

        );

    }

);
```

Output

```
10 0

20 1
```

---

# 5. Return Value

`forEach()`

returns

```js
undefined
```

Example

```js
const numbers = [1,2,3];

const result = numbers.forEach(

    num=>num*2

);

console.log(result);
```

Output

```js
undefined
```

Unlike

```js
map()
```

`forEach()`

does **not** create a new array.

---

# 6. Internal Working

Suppose

```js
const numbers = [1,2,3];
```

Execution

```
Take

↓

1

↓

Execute Callback

------------

Take

↓

2

↓

Execute Callback

------------

Take

↓

3

↓

Execute Callback

------------

Finish

↓

undefined
```

---

# 7. Callback Function

Example

```js
const numbers = [10,20,30];

numbers.forEach(

    num=>{

        console.log(

            num

        );

    }

);
```

The callback runs

```
One Time

↓

Per Element
```

---

# 8. Visualization

Original Array

```
[

10,

20,

30

]
```

Execution

```
10

↓

Callback

------------

20

↓

Callback

------------

30

↓

Callback
```

Unlike

```
map()

↓

No New Array
```

---

# 9. Memory Behavior

Original

```
Memory A

↓

[10,20,30]
```

Execution

```
Callback

↓

Print

------------

Callback

↓

Print

------------

Callback

↓

Print
```

No new array is created.

Original array usually remains unchanged (unless you modify it inside the callback).

---

# 10. First Examples

## Print Numbers

```js
const numbers = [1,2,3];

numbers.forEach(

    num=>{

        console.log(num);

    }

);
```

Output

```
1

2

3
```

---

## Print Squares

```js
const numbers = [2,4,6];

numbers.forEach(

    num=>{

        console.log(

            num*num

        );

    }

);
```

Output

```
4

16

36
```

---

## Print Strings

```js
const fruits = [

    "Apple",

    "Banana",

    "Orange"

];

fruits.forEach(

    fruit=>{

        console.log(fruit);

    }

);
```

Output

```
Apple

Banana

Orange
```

---

# 11. `forEach()` vs `for...of`

### `forEach()`

```js
numbers.forEach(

    num=>{

        console.log(num);

    }

);
```

---

### `for...of`

```js
for(const num of numbers){

    console.log(num);

}
```

Difference

| `forEach()` | `for...of` |
|--------------|------------|
| Uses callback | Uses loop |
| Cannot use `break` | Can use `break` |
| Cannot use `continue` | Can use `continue` |
| Returns `undefined` | Loop statement |

---

# 12. Best Practices

✅ Use `forEach()` for performing actions.

---

✅ Use `map()` when creating a new array.

---

✅ Keep callback functions short.

---

✅ Use descriptive variable names.

---

# 13. Common Mistakes

### Expecting a New Array

Wrong

```js
const result = numbers.forEach(

    num=>num*2

);

console.log(result);
```

Output

```js
undefined
```

---

### Using `return`

Wrong

```js
numbers.forEach(

    num=>{

        return num*2;

    }

);
```

Returned values are ignored.

---

### Using `break`

Wrong

```js
numbers.forEach(

    num=>{

        if(num===2){

            break;

        }

    }

);
```

This causes a syntax error because `break` works only inside loops.

---

# 14. Interview Questions

### What does `forEach()` return?

---

### Does `forEach()` create a new array?

---

### Can `break` be used inside `forEach()`?

---

### Can `continue` be used inside `forEach()`?

---

### Difference between `forEach()` and `map()`?

---

# 15. Coding Exercises

### Exercise 1

Print every number.

---

### Exercise 2

Print the square of every number.

---

### Exercise 3

Print every fruit name.

---

### Exercise 4

Predict the output.

```js
const result = [1,2,3].forEach(

    num=>num*2

);

console.log(result);
```

---

### Exercise 5

Explain why `forEach()` returns `undefined`.

---

# 16. Summary

- `forEach()` executes a callback once for every array element.
- It is used for side effects like printing, logging, or updating values.
- It returns `undefined`.
- It does not create a new array.
- It cannot use `break` or `continue`.
- It is one of the most commonly used array iteration methods in JavaScript.

---

# Next Part

➡️ **Part 2 – Callback Function, Internal Working, Parameters, Memory & Execution Flow**

You'll learn:

- Callback Parameters
- Step-by-Step Execution
- Internal Working
- Memory Behavior
- Dry Runs
- Execution Flow
- Side Effects
- Performance
- Interview Traps

# forEach()

# Part 2 – Callback Function, Internal Working, Parameters, Memory & Execution Flow

> **"`forEach()` visits every element of an array one by one and executes a callback function. It is designed for performing actions (side effects) rather than creating or returning a new array."**

---

# Table of Contents

1. Callback Function
2. Callback Parameters
3. Internal Working
4. Step-by-Step Execution
5. Dry Runs
6. Memory Visualization
7. Execution Flow
8. Side Effects
9. Best Practices
10. Common Mistakes
11. Interview Questions
12. Coding Exercises
13. Summary

---

# 1. Callback Function

The callback function runs

```
One Time

↓

For Every Element
```

Syntax

```js
array.forEach(

    (currentValue)=>{

    }

);
```

Example

```js
const numbers = [10,20,30];

numbers.forEach(

    num=>{

        console.log(num);

    }

);
```

Output

```
10

20

30
```

---

# 2. Callback Parameters

The callback receives

| Parameter | Description |
|-----------|-------------|
| currentValue | Current element |
| index | Current index |
| array | Original array |

---

## First Parameter

```js
const fruits = [

    "Apple",

    "Banana"

];

fruits.forEach(

    fruit=>{

        console.log(fruit);

    }

);
```

Output

```
Apple

Banana
```

---

## Second Parameter

```js
const fruits = [

    "Apple",

    "Banana"

];

fruits.forEach(

    (

        fruit,

        index

    )=>{

        console.log(

            index,

            fruit

        );

    }

);
```

Output

```
0 Apple

1 Banana
```

---

## Third Parameter

```js
const fruits = [

    "Apple",

    "Banana"

];

fruits.forEach(

    (

        fruit,

        index,

        array

    )=>{

        console.log(array);

    }

);
```

Output

```
["Apple","Banana"]

["Apple","Banana"]
```

---

# 3. Internal Working

Suppose

```js
const numbers = [1,2,3];
```

Execution

```
Take

↓

1

↓

Execute Callback

------------

Take

↓

2

↓

Execute Callback

------------

Take

↓

3

↓

Execute Callback

------------

Finish

↓

undefined
```

---

# 4. Step-by-Step Execution

Example

```js
const numbers = [5,10,15];

numbers.forEach(

    num=>{

        console.log(

            num*2

        );

    }

);
```

---

Step 1

```
Take

↓

5

↓

Callback

↓

Print

↓

10
```

---

Step 2

```
Take

↓

10

↓

Callback

↓

Print

↓

20
```

---

Step 3

```
Take

↓

15

↓

Callback

↓

Print

↓

30
```

---

Finished

```
undefined
```

---

# 5. Dry Runs

## Example 1

```js
const names = [

    "Om",

    "Raj",

    "Amit"

];

names.forEach(

    name=>{

        console.log(name);

    }

);
```

Execution

```
Om

↓

Print

------------

Raj

↓

Print

------------

Amit

↓

Print
```

---

## Example 2

```js
const numbers = [2,4,6];

numbers.forEach(

    num=>{

        console.log(

            num*num

        );

    }

);
```

Output

```
4

16

36
```

---

## Example 3

```js
const letters = [

    "A",

    "B",

    "C"

];

letters.forEach(

    (

        letter,

        index

    )=>{

        console.log(

            index,

            letter

        );

    }

);
```

Output

```
0 A

1 B

2 C
```

---

# 6. Memory Visualization

Original

```
Memory A

↓

[10,20,30]
```

Execution

```
Callback

↓

Print

------------

Callback

↓

Print

------------

Callback

↓

Print
```

No new array is created.

Unless you manually modify values,

the original array remains unchanged.

---

# 7. Execution Flow

```
Array

↓

Take Element

↓

Execute Callback

↓

Perform Action

↓

Next Element

↓

Execute Callback

↓

Repeat

↓

Finish

↓

undefined
```

---

# 8. Side Effects

The primary purpose of `forEach()` is to create **side effects**.

Examples

✅ Printing

```js
numbers.forEach(

    num=>console.log(num)

);
```

---

✅ Updating External Variable

```js
let sum = 0;

numbers.forEach(

    num=>{

        sum += num;

    }

);

console.log(sum);
```

Output

```js
6
```

---

✅ Updating Objects

```js
const users = [

    {

        name:"Om"

    },

    {

        name:"Raj"

    }

];

users.forEach(

    user=>{

        user.active = true;

    }

);

console.log(users);
```

Output

```js
[
{
name:"Om",
active:true
},
{
name:"Raj",
active:true
}
]
```

---

# 9. Best Practices

✅ Use `forEach()` for logging and printing.

---

✅ Use `forEach()` for updating existing objects.

---

✅ Use `map()` when you need a new array.

---

✅ Keep callback functions small.

---

# 10. Common Mistakes

### Expecting a Return Value

Wrong

```js
const result = numbers.forEach(

    num=>num*2

);

console.log(result);
```

Output

```js
undefined
```

---

### Trying to Stop the Loop

Wrong

```js
numbers.forEach(

    num=>{

        if(num===2){

            return;

        }

    }

);
```

`return` only exits the current callback.

The loop continues.

---

### Using `break`

Wrong

```js
numbers.forEach(

    num=>{

        break;

    }

);
```

Syntax Error

---

# 11. Interview Questions

### What does `forEach()` return?

---

### Can `break` be used inside `forEach()`?

---

### Can `continue` be used inside `forEach()`?

---

### When should `forEach()` be used?

---

### Difference between `forEach()` and `map()`?

---

### Can `forEach()` modify objects?

---

# 12. Coding Exercises

### Exercise 1

Print every number.

---

### Exercise 2

Print the square of every number.

---

### Exercise 3

Print index and value.

---

### Exercise 4

Calculate the sum using `forEach()`.

---

### Exercise 5

Add a new property

```js
active:true
```

to every object.

---

### Exercise 6

Predict the output.

```js
let sum = 0;

[1,2,3].forEach(

    num=>{

        sum += num;

    }

);

console.log(sum);
```

---

# 13. Summary

- `forEach()` executes a callback for every element.
- It performs actions instead of creating new arrays.
- It returns `undefined`.
- It is commonly used for printing, logging, updating objects, and calculating values using external variables.
- It cannot be stopped using `break` or `continue`.
- It is one of the most frequently used iteration methods in JavaScript.

---

# Next Part

➡️ **Part 3 – `forEach()` with Objects, Real-World Examples, React & Node.js**

You'll learn:

- Arrays of Objects
- Updating Objects
- API Processing
- React Examples
- Node.js Examples
- `forEach()` + DOM
- Real Interview Problems
- Best Industry Practices

# forEach()

# Part 3 – `forEach()` with Objects, Real-World Examples, React & Node.js

> **"`forEach()` is one of the most commonly used methods in JavaScript applications. It is primarily used for performing actions such as updating objects, logging data, rendering UI elements, processing API responses, and handling side effects. Unlike `map()`, it is not intended to transform data into a new array."**

---

# Table of Contents

1. Working with Objects
2. Updating Objects
3. Chaining with Other Methods
4. Real-World Examples
5. React Examples
6. Node.js Examples
7. `forEach()` vs `map()`
8. Best Practices
9. Common Mistakes
10. Interview Questions
11. Coding Exercises
12. Summary

---

# 1. Working with Objects

Suppose we have

```js
const users = [

    {

        name:"Om",

        age:22

    },

    {

        name:"Raj",

        age:24

    }

];
```

Print every user.

```js
users.forEach(

    user=>{

        console.log(user.name);

    }

);
```

Output

```
Om

Raj
```

---

Print Multiple Properties

```js
users.forEach(

    user=>{

        console.log(

            user.name,

            user.age

        );

    }

);
```

Output

```
Om 22

Raj 24
```

---

# 2. Updating Objects

One of the biggest uses of `forEach()` is updating existing objects.

```js
const employees = [

    {

        name:"Om"

    },

    {

        name:"Raj"

    }

];

employees.forEach(

    employee=>{

        employee.active = true;

    }

);

console.log(employees);
```

Output

```js
[
{
name:"Om",
active:true
},
{
name:"Raj",
active:true
}
]
```

---

Increase Salary

```js
const employees = [

    {

        salary:50000

    },

    {

        salary:60000

    }

];

employees.forEach(

    employee=>{

        employee.salary += 5000;

    }

);

console.log(employees);
```

Output

```js
[
{
salary:55000
},
{
salary:65000
}
]
```

---

# 3. Chaining with Other Methods

Usually

```
filter()

↓

forEach()
```

Example

```js
const numbers = [

    10,

    15,

    20,

    25

];

numbers

.filter(

    num=>num>15

)

.forEach(

    num=>{

        console.log(num);

    }

);
```

Output

```
20

25
```

---

Using

```
map()

↓

forEach()
```

```js
const numbers = [

    1,

    2,

    3

];

numbers

.map(

    num=>num*10

)

.forEach(

    num=>{

        console.log(num);

    }

);
```

Output

```
10

20

30
```

---

# 4. Real-World Examples

## Shopping Cart

```js
const cart = [

    {

        product:"Laptop",

        quantity:1

    },

    {

        product:"Mouse",

        quantity:2

    }

];

cart.forEach(

    item=>{

        console.log(

            item.product,

            item.quantity

        );

    }

);
```

Output

```
Laptop 1

Mouse 2
```

---

## API Response

```js
const users = [

    {

        id:1,

        name:"Om"

    },

    {

        id:2,

        name:"Raj"

    }

];

users.forEach(

    user=>{

        console.log(

            `User ${user.id}: ${user.name}`

        );

    }

);
```

Output

```
User 1: Om

User 2: Raj
```

---

## Notifications

```js
const notifications = [

    "Welcome",

    "Payment Received",

    "Profile Updated"

];

notifications.forEach(

    message=>{

        console.log(

            "Notification:",

            message

        );

    }

);
```

Output

```
Notification: Welcome

Notification: Payment Received

Notification: Profile Updated
```

---

# 5. React Examples

Suppose

```jsx
const users = [

    {

        name:"Om"

    },

    {

        name:"Raj"

    }

];
```

Logging

```jsx
useEffect(()=>{

    users.forEach(

        user=>{

            console.log(user.name);

        }

    );

},[]);
```

---

Updating Objects

```jsx
users.forEach(

    user=>{

        user.active = true;

    }

);
```

---

⚠️ **Note**

For rendering JSX,

prefer

```jsx
map()
```

instead of

```jsx
forEach()
```

because `map()` returns a new array of JSX elements.

---

# 6. Node.js Examples

## Processing Logs

```js
const logs = [

    "Server Started",

    "Database Connected",

    "User Logged In"

];

logs.forEach(

    log=>{

        console.log(log);

    }

);
```

Output

```
Server Started

Database Connected

User Logged In
```

---

## Sending Emails

```js
const users = [

    "om@gmail.com",

    "raj@gmail.com"

];

users.forEach(

    email=>{

        console.log(

            `Sending Email To ${email}`

        );

    }

);
```

Output

```
Sending Email To om@gmail.com

Sending Email To raj@gmail.com
```

---

# 7. `forEach()` vs `map()`

### `forEach()`

```js
numbers.forEach(

    num=>num*2

);
```

Output

```js
undefined
```

---

### `map()`

```js
const result = numbers.map(

    num=>num*2

);

console.log(result);
```

Output

```js
[
2,
4,
6
]
```

---

Comparison

| `forEach()` | `map()` |
|--------------|----------|
| Returns `undefined` | Returns New Array |
| Used for Actions | Used for Transformation |
| Side Effects | Pure Transformation |
| Cannot Chain Results | Can Chain Easily |

---

# 8. Best Practices

✅ Use `forEach()` for logging.

---

✅ Use `forEach()` for updating objects.

---

✅ Use `forEach()` when you do **not** need a returned array.

---

✅ Use `map()` for rendering React components.

---

# 9. Common Mistakes

### Using `forEach()` to Build Arrays

Wrong

```js
const result = numbers.forEach(

    num=>num*2

);
```

Correct

```js
const result = numbers.map(

    num=>num*2

);
```

---

### Rendering JSX

Wrong

```jsx
users.forEach(

    user=>

        <User />

);
```

Correct

```jsx
users.map(

    user=>

        <User />

);
```

---

### Expecting `return` to Collect Values

Wrong

```js
numbers.forEach(

    num=>{

        return num*2;

    }

);
```

Returned values are ignored.

---

# 10. Interview Questions

### When should `forEach()` be used?

---

### Why doesn't `forEach()` return a new array?

---

### Difference between `forEach()` and `map()`?

---

### Can `forEach()` modify objects?

---

### Why is `map()` preferred in React rendering?

---

### Can `forEach()` be chained?

---

# 11. Coding Exercises

### Exercise 1

Print every employee name.

---

### Exercise 2

Increase every employee's salary by 10%.

---

### Exercise 3

Print all products in a shopping cart.

---

### Exercise 4

Print every API user.

---

### Exercise 5

Add

```js
verified:true
```

to every user.

---

### Exercise 6

Print only users older than 25 using

```js
filter()

↓

forEach()
```

---

### Exercise 7

Explain why `forEach()` is not used to render React components.

---

# 12. Summary

- `forEach()` is designed for performing actions, not transformations.
- It is widely used for updating objects, logging, processing API responses, and handling side effects.
- It returns `undefined`.
- It works well with `filter()` and `map()` in method chains.
- In React, `map()` should be used for rendering, while `forEach()` is better for side effects.
- `forEach()` is one of the most frequently used methods in production JavaScript code.

---

# Next Part

➡️ **Part 4 – Advanced `forEach()`, Performance, Memory, Interview Mastery & Debugging**

You'll learn:

- Performance Analysis
- Memory Behavior
- `forEach()` vs `for...of`
- `forEach()` vs `for`
- Debugging
- Predict the Output
- Interview Traps
- Advanced Coding Exercises
- Quick Revision Sheet
- Complete Interview Revision

# forEach()

# Part 4 – Advanced `forEach()`, Performance, Memory, Interview Mastery & Debugging

> **"`forEach()` is one of the most frequently used iteration methods in JavaScript. It is simple, readable, and ideal for performing side effects. Understanding its limitations, performance, and differences from loops and other array methods is essential for interviews and production code."**

---

# Table of Contents

1. Advanced Usage
2. Performance Analysis
3. Memory Behavior
4. `forEach()` vs Other Methods
5. Debugging `forEach()`
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

## Building an Object

```js
const fruits = [

    "apple",

    "banana",

    "apple",

    "orange"

];

const frequency = {};

fruits.forEach(

    fruit => {

        frequency[fruit] =

            (frequency[fruit] || 0) + 1;

    }

);

console.log(frequency);
```

Output

```js
{
apple:2,
banana:1,
orange:1
}
```

---

## Calculate Total

```js
const prices = [

    100,

    200,

    300

];

let total = 0;

prices.forEach(

    price => {

        total += price;

    }

);

console.log(total);
```

Output

```js
600
```

---

## Update Objects

```js
const users = [

    {

        name:"Om"

    },

    {

        name:"Raj"

    }

];

users.forEach(

    user => {

        user.active = true;

    }

);

console.log(users);
```

Output

```js
[
{
name:"Om",
active:true
},
{
name:"Raj",
active:true
}
]
```

---

# 2. Performance Analysis

Time Complexity

```
O(n)
```

Every element is visited once.

---

Space Complexity

```
O(1)
```

when only performing actions.

If external objects or arrays are created,

space depends on your implementation.

---

Comparison

| Method | Time | Space |
|----------|------|--------|
| forEach() | O(n) | O(1)* |
| map() | O(n) | O(n) |
| filter() | O(n) | O(n) |
| reduce() | O(n) | Depends |
| sort() | O(n log n) | Depends |

\*Ignoring any extra data structures you create manually.

---

# 3. Memory Behavior

Original

```
Memory A

↓

[10,20,30]
```

Execution

```
Element

↓

Callback

↓

Action

↓

Next Element
```

Unlike

```js
map()
```

No new array is created automatically.

---

If objects are modified

```
Memory A

↓

Same Objects

↓

Updated Values
```

---

# 4. `forEach()` vs Other Methods

| Method | Purpose | Returns |
|---------|----------|----------|
| `forEach()` | Perform Action | `undefined` |
| `map()` | Transform | New Array |
| `filter()` | Select | New Array |
| `find()` | Find First | Element |
| `reduce()` | Combine | Any Value |

---

## `forEach()` vs `for...of`

### `forEach()`

```js
numbers.forEach(

    num => {

        console.log(num);

    }

);
```

---

### `for...of`

```js
for(const num of numbers){

    console.log(num);

}
```

Comparison

| forEach() | for...of |
|------------|-----------|
| Callback | Loop |
| No break | Supports break |
| No continue | Supports continue |
| Returns undefined | Loop Statement |

---

## `forEach()` vs `for`

### `for`

```js
for(

    let i=0;

    i<numbers.length;

    i++

){

    console.log(numbers[i]);

}
```

---

### `forEach()`

```js
numbers.forEach(

    num=>{

        console.log(num);

    }

);
```

`for`

gives more control.

`forEach()`

gives cleaner syntax.

---

# 5. Debugging `forEach()`

Wrong

```js
const result = [1,2,3].forEach(

    num =>

        num * 2

);

console.log(result);
```

Output

```js
undefined
```

Reason

```
forEach()

↓

Ignores Return Values
```

---

Wrong

```js
numbers.forEach(

    num=>{

        if(num===2){

            break;

        }

    }

);
```

Output

```
Syntax Error
```

---

Correct

Use

```js
for...of
```

if you need

```
break

continue
```

---

# 6. Predict the Output

## Example 1

```js
let sum = 0;

[1,2,3].forEach(

    num=>{

        sum += num;

    }

);

console.log(sum);
```

Output

```js
6
```

---

## Example 2

```js
const result = [1,2]

.forEach(

    num=>num*2

);

console.log(result);
```

Output

```js
undefined
```

---

## Example 3

```js
const users = [

    {

        age:20

    },

    {

        age:25

    }

];

users.forEach(

    user=>{

        user.age++;

    }

);

console.log(users);
```

Output

```js
[
{
age:21
},
{
age:26
}
]
```

---

# 7. Interview Traps

### Trap 1

Does `forEach()` return a new array?

```
No
```

---

### Trap 2

Can `break` be used?

```
No
```

---

### Trap 3

Can `continue` be used?

```
No
```

---

### Trap 4

Can objects be modified?

```
Yes
```

---

### Trap 5

Should `forEach()` be used in React rendering?

```
No

Use

map()
```

---

# 8. Best Practices

✅ Use `forEach()` for logging.

---

✅ Use `forEach()` for updating existing objects.

---

✅ Use `map()` when creating new arrays.

---

✅ Prefer `for...of` if you need early exit.

---

✅ Keep callback functions short.

---

# 9. Common Mistakes

### Expecting Return Values

Wrong

```js
const result = numbers.forEach(

    num=>num*2

);
```

---

### Using `break`

Wrong

```js
break;
```

inside `forEach()`.

---

### Using `continue`

Wrong

```js
continue;
```

inside `forEach()`.

---

### Rendering React Components

Wrong

```jsx
users.forEach(

    user=>

        <User />

);
```

Correct

```jsx
users.map(

    user=>

        <User />

);
```

---

### Using `forEach()` for Searching

Wrong

```js
numbers.forEach(...);
```

Better

```js
find()
```

or

```js
some()
```

---

# 10. Interview Questions

### What does `forEach()` return?

---

### Difference between `forEach()` and `map()`?

---

### Difference between `forEach()` and `for...of`?

---

### Can `break` be used?

---

### Can `continue` be used?

---

### Time Complexity?

---

### Space Complexity?

---

### Why isn't `forEach()` used for React rendering?

---

# 11. Coding Exercises

### Exercise 1

Print every student name.

---

### Exercise 2

Increase every employee salary by 20%.

---

### Exercise 3

Count the total price of products.

---

### Exercise 4

Create a frequency counter using `forEach()`.

---

### Exercise 5

Add

```js
verified:true
```

to every user.

---

### Exercise 6

Explain why this returns `undefined`.

```js
const result = numbers.forEach(

    num=>num*2

);
```

---

### Exercise 7

Why can't `break` be used inside `forEach()`?

---

# 12. Quick Revision Sheet

```
forEach()

↓

Visit Element

↓

Execute Callback

↓

Perform Action

↓

Repeat

↓

undefined
```

Remember

```
Print

↓

forEach()

Transform

↓

map()

Select

↓

filter()

Find

↓

find()

Combine

↓

reduce()

Flatten

↓

flat()

Transform + Flatten

↓

flatMap()
```

---

# 13. Summary

- `forEach()` performs an action for every element.
- It returns **`undefined`**.
- It never creates a new array.
- Time Complexity is **O(n)**.
- It cannot use `break` or `continue`.
- It is ideal for logging, updating objects, API processing, and side effects.
- In React, use `map()` for rendering and `forEach()` for side effects only.

---

# Chapter Complete ✅

You now understand:

- ✔ What `forEach()` is
- ✔ Callback Function
- ✔ Internal Working
- ✔ Parameters
- ✔ Memory Behavior
- ✔ Performance Analysis
- ✔ `forEach()` vs `map()`
- ✔ `forEach()` vs `for`
- ✔ `forEach()` vs `for...of`
- ✔ React Usage
- ✔ Node.js Usage
- ✔ Interview Questions
- ✔ Common Mistakes
- ✔ Best Practices
- ✔ Coding Exercises

---

# What's Next?

➡️ **13-chaining.md**

You'll master:

- What Method Chaining is
- Why Chaining is Powerful
- `map()` → `filter()` → `reduce()`
- `flatMap()` → `filter()`
- `sort()` → `map()`
- Chaining Rules
- Memory & Performance
- React & Node.js Examples
- Interview Questions
- Advanced Coding Problems

# forEach()

# Part 4 – Advanced `forEach()`, Performance, Memory, Interview Mastery & Debugging

> **"`forEach()` is one of the most frequently used iteration methods in JavaScript. It is simple, readable, and ideal for performing side effects. Understanding its limitations, performance, and differences from loops and other array methods is essential for interviews and production code."**

---

# Table of Contents

1. Advanced Usage
2. Performance Analysis
3. Memory Behavior
4. `forEach()` vs Other Methods
5. Debugging `forEach()`
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

## Building an Object

```js
const fruits = [

    "apple",

    "banana",

    "apple",

    "orange"

];

const frequency = {};

fruits.forEach(

    fruit => {

        frequency[fruit] =

            (frequency[fruit] || 0) + 1;

    }

);

console.log(frequency);
```

Output

```js
{
apple:2,
banana:1,
orange:1
}
```

---

## Calculate Total

```js
const prices = [

    100,

    200,

    300

];

let total = 0;

prices.forEach(

    price => {

        total += price;

    }

);

console.log(total);
```

Output

```js
600
```

---

## Update Objects

```js
const users = [

    {

        name:"Om"

    },

    {

        name:"Raj"

    }

];

users.forEach(

    user => {

        user.active = true;

    }

);

console.log(users);
```

Output

```js
[
{
name:"Om",
active:true
},
{
name:"Raj",
active:true
}
]
```

---

# 2. Performance Analysis

Time Complexity

```
O(n)
```

Every element is visited once.

---

Space Complexity

```
O(1)
```

when only performing actions.

If external objects or arrays are created,

space depends on your implementation.

---

Comparison

| Method | Time | Space |
|----------|------|--------|
| forEach() | O(n) | O(1)* |
| map() | O(n) | O(n) |
| filter() | O(n) | O(n) |
| reduce() | O(n) | Depends |
| sort() | O(n log n) | Depends |

\*Ignoring any extra data structures you create manually.

---

# 3. Memory Behavior

Original

```
Memory A

↓

[10,20,30]
```

Execution

```
Element

↓

Callback

↓

Action

↓

Next Element
```

Unlike

```js
map()
```

No new array is created automatically.

---

If objects are modified

```
Memory A

↓

Same Objects

↓

Updated Values
```

---

# 4. `forEach()` vs Other Methods

| Method | Purpose | Returns |
|---------|----------|----------|
| `forEach()` | Perform Action | `undefined` |
| `map()` | Transform | New Array |
| `filter()` | Select | New Array |
| `find()` | Find First | Element |
| `reduce()` | Combine | Any Value |

---

## `forEach()` vs `for...of`

### `forEach()`

```js
numbers.forEach(

    num => {

        console.log(num);

    }

);
```

---

### `for...of`

```js
for(const num of numbers){

    console.log(num);

}
```

Comparison

| forEach() | for...of |
|------------|-----------|
| Callback | Loop |
| No break | Supports break |
| No continue | Supports continue |
| Returns undefined | Loop Statement |

---

## `forEach()` vs `for`

### `for`

```js
for(

    let i=0;

    i<numbers.length;

    i++

){

    console.log(numbers[i]);

}
```

---

### `forEach()`

```js
numbers.forEach(

    num=>{

        console.log(num);

    }

);
```

`for`

gives more control.

`forEach()`

gives cleaner syntax.

---

# 5. Debugging `forEach()`

Wrong

```js
const result = [1,2,3].forEach(

    num =>

        num * 2

);

console.log(result);
```

Output

```js
undefined
```

Reason

```
forEach()

↓

Ignores Return Values
```

---

Wrong

```js
numbers.forEach(

    num=>{

        if(num===2){

            break;

        }

    }

);
```

Output

```
Syntax Error
```

---

Correct

Use

```js
for...of
```

if you need

```
break

continue
```

---

# 6. Predict the Output

## Example 1

```js
let sum = 0;

[1,2,3].forEach(

    num=>{

        sum += num;

    }

);

console.log(sum);
```

Output

```js
6
```

---

## Example 2

```js
const result = [1,2]

.forEach(

    num=>num*2

);

console.log(result);
```

Output

```js
undefined
```

---

## Example 3

```js
const users = [

    {

        age:20

    },

    {

        age:25

    }

];

users.forEach(

    user=>{

        user.age++;

    }

);

console.log(users);
```

Output

```js
[
{
age:21
},
{
age:26
}
]
```

---

# 7. Interview Traps

### Trap 1

Does `forEach()` return a new array?

```
No
```

---

### Trap 2

Can `break` be used?

```
No
```

---

### Trap 3

Can `continue` be used?

```
No
```

---

### Trap 4

Can objects be modified?

```
Yes
```

---

### Trap 5

Should `forEach()` be used in React rendering?

```
No

Use

map()
```

---

# 8. Best Practices

✅ Use `forEach()` for logging.

---

✅ Use `forEach()` for updating existing objects.

---

✅ Use `map()` when creating new arrays.

---

✅ Prefer `for...of` if you need early exit.

---

✅ Keep callback functions short.

---

# 9. Common Mistakes

### Expecting Return Values

Wrong

```js
const result = numbers.forEach(

    num=>num*2

);
```

---

### Using `break`

Wrong

```js
break;
```

inside `forEach()`.

---

### Using `continue`

Wrong

```js
continue;
```

inside `forEach()`.

---

### Rendering React Components

Wrong

```jsx
users.forEach(

    user=>

        <User />

);
```

Correct

```jsx
users.map(

    user=>

        <User />

);
```

---

### Using `forEach()` for Searching

Wrong

```js
numbers.forEach(...);
```

Better

```js
find()
```

or

```js
some()
```

---

# 10. Interview Questions

### What does `forEach()` return?

---

### Difference between `forEach()` and `map()`?

---

### Difference between `forEach()` and `for...of`?

---

### Can `break` be used?

---

### Can `continue` be used?

---

### Time Complexity?

---

### Space Complexity?

---

### Why isn't `forEach()` used for React rendering?

---

# 11. Coding Exercises

### Exercise 1

Print every student name.

---

### Exercise 2

Increase every employee salary by 20%.

---

### Exercise 3

Count the total price of products.

---

### Exercise 4

Create a frequency counter using `forEach()`.

---

### Exercise 5

Add

```js
verified:true
```

to every user.

---

### Exercise 6

Explain why this returns `undefined`.

```js
const result = numbers.forEach(

    num=>num*2

);
```

---

### Exercise 7

Why can't `break` be used inside `forEach()`?

---

# 12. Quick Revision Sheet

```
forEach()

↓

Visit Element

↓

Execute Callback

↓

Perform Action

↓

Repeat

↓

undefined
```

Remember

```
Print

↓

forEach()

Transform

↓

map()

Select

↓

filter()

Find

↓

find()

Combine

↓

reduce()

Flatten

↓

flat()

Transform + Flatten

↓

flatMap()
```

---

# 13. Summary

- `forEach()` performs an action for every element.
- It returns **`undefined`**.
- It never creates a new array.
- Time Complexity is **O(n)**.
- It cannot use `break` or `continue`.
- It is ideal for logging, updating objects, API processing, and side effects.
- In React, use `map()` for rendering and `forEach()` for side effects only.

---

# Chapter Complete ✅

You now understand:

- ✔ What `forEach()` is
- ✔ Callback Function
- ✔ Internal Working
- ✔ Parameters
- ✔ Memory Behavior
- ✔ Performance Analysis
- ✔ `forEach()` vs `map()`
- ✔ `forEach()` vs `for`
- ✔ `forEach()` vs `for...of`
- ✔ React Usage
- ✔ Node.js Usage
- ✔ Interview Questions
- ✔ Common Mistakes
- ✔ Best Practices
- ✔ Coding Exercises

---

# What's Next?

➡️ **13-chaining.md**

You'll master:

- What Method Chaining is
- Why Chaining is Powerful
- `map()` → `filter()` → `reduce()`
- `flatMap()` → `filter()`
- `sort()` → `map()`
- Chaining Rules
- Memory & Performance
- React & Node.js Examples
- Interview Questions
- Advanced Coding Problems