# every()

# Part 1 – Introduction & Fundamentals

> **"`every()` is a JavaScript array method that checks whether every element in an array satisfies a given condition. It returns `true` only if all elements match the condition; otherwise, it returns `false`."**

---

# Table of Contents

1. Introduction
2. Why `every()` Was Introduced
3. Syntax
4. Parameters
5. Return Value
6. Internal Working
7. Visualization
8. Memory Behavior
9. First Examples
10. `every()` vs `for` Loop
11. Best Practices
12. Common Mistakes
13. Interview Questions
14. Coding Exercises
15. Summary

---

# 1. Introduction

Suppose we have an array.

```js
const numbers = [2,4,6,8];
```

We want to know

> **Are all numbers even?**

Expected Output

```js
true
```

Instead of writing loops,

we use `every()`.

```js
const numbers = [2,4,6,8];

const result = numbers.every(

    num => num % 2 === 0

);

console.log(result);
```

Output

```js
true
```

Notice

`every()` returns

```js
true
```

NOT

```js
2
```

and NOT

```js
[2,4,6,8]
```

---

# 2. Why `every()` Was Introduced

Before ES6

```js
const numbers = [2,4,6];

let allEven = true;

for(let i=0;i<numbers.length;i++){

    if(numbers[i] % 2 !== 0){

        allEven = false;

        break;

    }

}

console.log(allEven);
```

Problems

- Manual loop
- Manual boolean variable
- Manual `break`
- More code

---

Using `every()`

```js
const allEven = numbers.every(

    num => num % 2 === 0

);

console.log(allEven);
```

Much cleaner.

---

# 3. Syntax

```js
array.every(callback)
```

Example

```js
array.every(

    element => {

    }

);
```

---

# 4. Parameters

The callback receives three parameters.

```js
array.every(

    (element,index,array)=>{

    }

);
```

| Parameter | Description |
|-----------|-------------|
| `element` | Current element |
| `index` | Current index |
| `array` | Original array |

---

Example

```js
const numbers = [10,20,30];

numbers.every(

    (value,index)=>{

        console.log(value,index);

        return true;

    }

);
```

Output

```
10 0

20 1

30 2
```

---

# 5. Return Value

If every callback returns

```js
true
```

↓

Return

```js
true
```

---

If even one callback returns

```js
false
```

↓

Return

```js
false
```

immediately.

---

Example

```js
const numbers = [2,4,6];

const result = numbers.every(

    num => num % 2 === 0

);

console.log(result);
```

Output

```js
true
```

---

One Failure

```js
const numbers = [2,4,5,8];

const result = numbers.every(

    num => num % 2 === 0

);

console.log(result);
```

Output

```js
false
```

---

# 6. Internal Working

Suppose

```js
const numbers = [2,4,5,8];
```

Execution

```
every()

↓

Take First Element

↓

Condition?

↓

true

↓

Next Element

----------------

false

↓

Return false

↓

Stop
```

Unlike `filter()`,

`every()` stops immediately after the first failure.

---

Example

```js
const numbers = [2,4,5,8];

const result = numbers.every(

    num => num % 2 === 0

);

console.log(result);
```

Execution

```
2

↓

true

↓

Continue

------------

4

↓

true

↓

Continue

------------

5

↓

false

↓

Return false

↓

Stop
```

Output

```js
false
```

---

# 7. Visualization

```
Original Array

↓

[2,4,5,8]

↓

every()

↓

2

↓

true

↓

Continue

------------

4

↓

true

↓

Continue

------------

5

↓

false

↓

Return false

↓

Stop
```

Remaining element

```
8
```

is never checked.

---

# 8. Memory Behavior

Original

```
numbers

↓

Memory A

↓

[2,4,5,8]
```

Result

```
result

↓

false
```

Unlike

```
map()

filter()
```

`every()` does **not create a new array**.

It only returns a boolean.

---

# 9. First Examples

## Example 1

Check Positive Numbers

```js
const numbers = [2,5,10];

const result = numbers.every(

    num => num > 0

);

console.log(result);
```

Output

```js
true
```

---

## Example 2

Check Even Numbers

```js
const numbers = [2,4,6,9];

const result = numbers.every(

    num => num % 2 === 0

);

console.log(result);
```

Output

```js
false
```

---

## Example 3

Check String Length

```js
const fruits = [

    "Apple",

    "Banana",

    "Orange"

];

const result = fruits.every(

    fruit => fruit.length >= 5

);

console.log(result);
```

Output

```js
true
```

---

# 10. `every()` vs `for` Loop

Using `for`

```js
let valid = true;

for(let num of numbers){

    if(num < 0){

        valid = false;

        break;

    }

}
```

---

Using `every()`

```js
const valid = numbers.every(

    num => num > 0

);
```

Comparison

| `for` Loop | `every()` |
|------------|-----------|
| Manual loop | Automatic |
| Manual boolean | Returns boolean |
| Manual break | Stops automatically |
| More code | Cleaner |

---

# 11. Best Practices

✅ Use `every()` when all elements must satisfy a condition.

✅ Return boolean expressions.

✅ Keep callbacks simple.

✅ Use descriptive variable names.

---

# 12. Common Mistakes

### Expecting an Array

Wrong

```js
const result = numbers.every(

    num => num > 0

);

console.log(result.length);
```

`every()` returns a boolean.

---

### Forgetting `return`

Wrong

```js
numbers.every(

    num => {

        num > 0;

    }

);
```

Output

```js
false
```

---

### Using `every()` Instead of `some()`

Wrong

```js
numbers.every(

    num => num > 10

);
```

if you only want to know whether **one** element matches.

Use

```js
some()
```

instead.

---

# 13. Interview Questions

### What is `every()`?

---

### What does `every()` return?

---

### Does `every()` stop early?

---

### What happens if one element fails?

---

### Does `every()` return an array?

---

# 14. Coding Exercises

### Exercise 1

Check whether all numbers are positive.

---

### Exercise 2

Check whether all students scored above 40.

---

### Exercise 3

Predict the output.

```js
const arr = [2,4,6];

const result = arr.every(

    num => num % 2 === 0

);

console.log(result);
```

---

### Exercise 4

Check whether all filenames end with `.js`.

---

### Exercise 5

Explain why this returns `false`.

```js
numbers.every(

    num => {

        num > 5;

    }

);
```

---

# 15. Summary

- `every()` checks whether **all** elements satisfy a condition.
- It returns `true` or `false`.
- It stops immediately after the first failed condition.
- It does not return elements.
- It does not create a new array.
- It is widely used for validation, authentication, form checking, and business rules.

---

# Next Part

➡️ **Part 2 – Callback Function, Internal Working, Execution Flow & Truthy/Falsy**

You'll learn:

- Callback Function
- Callback Parameters
- Truthy & Falsy
- Step-by-Step Execution
- Dry Runs
- Execution Flow
- Memory Diagrams
- Return Behavior
- Debugging


# every()

# Part 2 – Callback Function, Internal Working, Execution Flow & Truthy/Falsy

> **"`every()` executes a callback function for each element in an array until the callback returns a falsy value. The moment one element fails the condition, `every()` immediately returns `false` and stops checking the remaining elements."**

---

# Table of Contents

1. Callback Function
2. Why Callback Functions?
3. Callback Parameters
4. Truthy & Falsy Values
5. Step-by-Step Execution
6. Dry Run
7. Memory Visualization
8. Execution Flow
9. Return Value
10. Different Callback Styles
11. Best Practices
12. Common Mistakes
13. Interview Questions
14. Coding Exercises
15. Summary

---

# 1. Callback Function

The function passed to `every()` is called the **Callback Function**.

Example

```js
const numbers = [2,4,6];

const result = numbers.every(

    num => num % 2 === 0

);

console.log(result);
```

Output

```js
true
```

The callback is

```js
num => num % 2 === 0
```

---

# 2. Why Callback Functions?

Instead of JavaScript deciding whether every element matches,

**you provide the condition.**

Think of `every()` like this

```
every()

↓

Visit First Element

↓

Ask Callback

↓

Pass?

↓

Yes

↓

Next Element

↓

Pass?

↓

Yes

↓

Next Element

↓

Fail?

↓

Return false

↓

Stop
```

---

Example

```js
const numbers = [2,4,5,8];

const result = numbers.every(

    num => num % 2 === 0

);

console.log(result);
```

Output

```js
false
```

Notice

`5`

fails the condition,

so

`8`

is never checked.

---

# 3. Callback Parameters

The callback receives three parameters.

```js
array.every(

    (element,index,array)=>{

    }

);
```

| Parameter | Description |
|-----------|-------------|
| `element` | Current element |
| `index` | Current index |
| `array` | Original array |

---

## First Parameter

Current Element

```js
const numbers = [10,20,30];

numbers.every(

    element => {

        console.log(element);

        return true;

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

## Second Parameter

Current Index

```js
const numbers = [10,20,30];

numbers.every(

    (element,index)=>{

        console.log(index);

        return true;

    }

);
```

Output

```
0

1

2
```

---

## Third Parameter

Original Array

```js
const numbers = [10,20,30];

numbers.every(

    (element,index,array)=>{

        console.log(array);

        return true;

    }

);
```

Output

```
[10,20,30]

[10,20,30]

[10,20,30]
```

---

# 4. Truthy & Falsy Values

Like other array methods,

`every()` uses **truthy** and **falsy** values.

---

Truthy Values

```
true

1

100

"Hello"

[]

{}

-5
```

Example

```js
const numbers = [10,20];

const result = numbers.every(

    num => 1

);

console.log(result);
```

Output

```js
true
```

Because

```
1

↓

Truthy
```

Every callback succeeds.

---

Falsy Values

```
false

0

""

null

undefined

NaN
```

Example

```js
const numbers = [10,20];

const result = numbers.every(

    num => 0

);

console.log(result);
```

Output

```js
false
```

The first callback already returns a falsy value.

---

Best Practice

Always return boolean expressions.

```js
num > 10

price < 500

user.active

student.marks >= 40
```

---

# 5. Step-by-Step Execution

Example

```js
const numbers = [2,4,5,8];

const result = numbers.every(

    num => num % 2 === 0

);
```

---

### Step 1

Take

```
2
```

Condition

```js
2 % 2 === 0
```

Result

```
true
```

Continue

---

### Step 2

Take

```
4
```

Condition

```js
4 % 2 === 0
```

Result

```
true
```

Continue

---

### Step 3

Take

```
5
```

Condition

```js
5 % 2 === 0
```

Result

```
false
```

Return

```
false
```

Stop immediately.

---

# 6. Dry Run

Example

```js
const numbers = [5,10,15];

const result = numbers.every(

    num => num > 0

);
```

Iteration 1

```
5

↓

Positive

↓

Continue
```

---

Iteration 2

```
10

↓

Positive

↓

Continue
```

---

Iteration 3

```
15

↓

Positive

↓

Return true
```

Output

```js
true
```

---

Example 2

```js
const numbers = [5,-10,15];

const result = numbers.every(

    num => num > 0

);
```

Execution

```
5

↓

true

↓

Continue

------------

-10

↓

false

↓

Stop

------------

15

↓

Never Checked
```

---

# 7. Memory Visualization

Original

```
numbers

↓

Memory A

↓

[2,4,5,8]
```

Result

```
result

↓

false
```

Unlike

```
map()

filter()
```

`every()` does **not create another array**.

Only a boolean is returned.

---

# 8. Execution Flow

```
Array

↓

every()

↓

First Element

↓

Callback

↓

Truthy?

↓

Next Element

↓

Falsy?

↓

Return false

↓

Stop

↓

All Elements Passed?

↓

Return true
```

---

# 9. Return Value

Correct

```js
numbers.every(

    num => num > 0

);
```

---

Wrong

```js
numbers.every(

    num => {

        num > 0;

    }

);
```

Output

```js
false
```

Reason

```
No Return

↓

undefined

↓

Falsy

↓

Stop
```

---

# 10. Different Callback Styles

## Arrow Function

```js
numbers.every(

    num => num > 0

);
```

---

## Arrow Function with Braces

```js
numbers.every(

    num => {

        return num > 0;

    }

);
```

---

## Normal Function

```js
numbers.every(

    function(num){

        return num > 0;

    }

);
```

All three produce the same result.

---

# 11. Best Practices

✅ Return boolean expressions.

---

✅ Use `every()` only when **all** elements must satisfy a condition.

---

✅ Keep callback functions short.

---

✅ Use descriptive variable names.

---

# 12. Common Mistakes

### Forgetting `return`

Wrong

```js
numbers.every(

    num => {

        num > 10;

    }

);
```

Returns

```js
false
```

---

### Expecting an Element

Wrong

```js
const result = numbers.every(

    num => num > 0

);

console.log(result.name);
```

`every()` returns a boolean.

---

### Using `every()` Instead of `some()`

Wrong

```js
numbers.every(

    num => num > 10

);
```

If you only need to know whether **one** element satisfies the condition,

use

```js
some()
```

instead.

---

# 13. Interview Questions

### What is a callback function?

---

### How many times is the callback executed?

---

### Does `every()` stop early?

---

### What happens if one element fails?

---

### Can `every()` return an object?

---

### Why is `every()` considered a Higher-Order Function?

---

# 14. Coding Exercises

### Exercise 1

Check whether all numbers are positive.

---

### Exercise 2

Check whether every student scored above 40.

---

### Exercise 3

Predict the output.

```js
const arr = [2,4,6];

const result = arr.every(

    num => true

);

console.log(result);
```

---

### Exercise 4

Predict the output.

```js
const arr = [2,4,6];

const result = arr.every(

    num => false

);

console.log(result);
```

---

### Exercise 5

Explain why this returns `false`.

```js
const arr = [10,20];

const result = arr.every(

    num => {

        num > 15;

    }

);

console.log(result);
```

---

# 15. Summary

- `every()` executes its callback for each element until one callback returns a falsy value.
- The callback receives `element`, `index`, and the original `array`.
- Truthy values continue checking.
- Falsy values stop the execution immediately.
- If all elements pass, `every()` returns `true`.
- If one element fails, `every()` returns `false`.
- It does not create a new array.

---

# Next Part

➡️ **Part 3 – every() with Objects, Strings, Arrays & Real-World Examples**

You'll learn:

- Using `every()` with Objects
- Multiple Conditions
- Arrays of Strings
- Nested Arrays
- React Examples
- Node.js Examples
- Form Validation
- Authentication Checks
- Permission Systems
- Real-world Interview Problems

# every()

# Part 3 – every() with Objects, Strings, Arrays & Real-World Examples

> **"`every()` is commonly used when every object, string, or value in an array must satisfy a condition. It is heavily used in form validation, permissions, authentication, business rules, React applications, and backend APIs."**

---

# Table of Contents

1. Using `every()` with Objects
2. Using Multiple Conditions
3. Using `every()` with Strings
4. Using `every()` with Nested Arrays
5. Chaining with `every()`
6. Real-world Examples
7. React Examples
8. Node.js Examples
9. Best Practices
10. Common Mistakes
11. Interview Questions
12. Coding Exercises
13. Summary

---

# 1. Using `every()` with Objects

Check whether every student passed.

```js
const students = [

    {

        name:"Om",

        marks:85

    },

    {

        name:"Raj",

        marks:78

    },

    {

        name:"Amit",

        marks:90

    }

];

const allPassed = students.every(

    student => student.marks >= 40

);

console.log(allPassed);
```

Output

```js
true
```

---

Check whether every user is active.

```js
const users = [

    {

        id:1,

        active:true

    },

    {

        id:2,

        active:true

    }

];

const allActive = users.every(

    user => user.active

);

console.log(allActive);
```

Output

```js
true
```

---

# 2. Using Multiple Conditions

Using AND (`&&`)

```js
const employees = [

    {

        name:"Om",

        age:25,

        salary:60000

    },

    {

        name:"Raj",

        age:30,

        salary:70000

    }

];

const result = employees.every(

    employee =>

        employee.age >= 18 &&

        employee.salary >= 30000

);

console.log(result);
```

Output

```js
true
```

---

Using OR (`||`)

```js
const users = [

    {

        name:"Om",

        verified:true,

        admin:false

    },

    {

        name:"Raj",

        verified:false,

        admin:true

    }

];

const result = users.every(

    user =>

        user.verified ||

        user.admin

);

console.log(result);
```

Output

```js
true
```

---

# 3. Using `every()` with Strings

Check whether every name starts with a capital letter.

```js
const names = [

    "Om",

    "Raj",

    "Amit"

];

const result = names.every(

    name =>

        name[0] === name[0].toUpperCase()

);

console.log(result);
```

Output

```js
true
```

---

Check whether every filename ends with `.js`.

```js
const files = [

    "app.js",

    "server.js",

    "config.js"

];

const result = files.every(

    file => file.endsWith(".js")

);

console.log(result);
```

Output

```js
true
```

---

Check minimum string length.

```js
const words = [

    "Apple",

    "Banana",

    "Orange"

];

const result = words.every(

    word => word.length >= 5

);

console.log(result);
```

Output

```js
true
```

---

# 4. Using `every()` with Nested Arrays

Example

```js
const matrix = [

    [1,2],

    [3,4],

    [5,6]

];

const result = matrix.every(

    row => row.length === 2

);

console.log(result);
```

Output

```js
true
```

---

# 5. Chaining with `every()`

Example

```js
const users = [

    {

        id:1,

        active:true

    },

    {

        id:2,

        active:true

    },

    {

        id:3,

        active:true

    }

];

const result = users

.filter(

    user => user.id > 0

)

.every(

    user => user.active

);

console.log(result);
```

Output

```js
true
```

Execution

```
Array

↓

filter()

↓

Filtered Array

↓

every()

↓

Boolean
```

---

# 6. Real-world Examples

## Form Validation

Check whether every field is filled.

```js
const fields = [

    "Om",

    "Pune",

    "Developer"

];

const valid = fields.every(

    field => field !== ""

);

console.log(valid);
```

Output

```js
true
```

---

## Login Validation

Check whether every credential exists.

```js
const credentials = [

    "admin",

    "password123"

];

const valid = credentials.every(

    value => value.length > 0

);

console.log(valid);
```

Output

```js
true
```

---

## Shopping Cart

Check whether every product is in stock.

```js
const cart = [

    {

        product:"Laptop",

        stock:true

    },

    {

        product:"Mouse",

        stock:true

    }

];

const available = cart.every(

    item => item.stock

);

console.log(available);
```

Output

```js
true
```

---

## Student Result

```js
const students = [

    {

        name:"Om",

        passed:true

    },

    {

        name:"Raj",

        passed:true

    }

];

const allPassed = students.every(

    student => student.passed

);

console.log(allPassed);
```

Output

```js
true
```

---

# 7. React Examples

Check whether every input is valid.

```jsx
const isValid = formFields.every(

    field => field.valid

);
```

---

Check whether every Todo is completed.

```jsx
const completed = todos.every(

    todo => todo.completed

);
```

---

Enable Submit Button

```jsx
const canSubmit = inputs.every(

    input => input.value !== ""

);
```

---

# 8. Node.js Examples

Check whether every employee is verified.

```js
const verified = employees.every(

    employee => employee.verified

);
```

---

Check whether every order is delivered.

```js
const delivered = orders.every(

    order => order.delivered

);
```

---

Check whether every product is available.

```js
const available = products.every(

    product => product.inStock

);
```

---

# 9. Best Practices

✅ Use `every()` when **all elements** must satisfy a condition.

---

✅ Return boolean expressions.

---

✅ Keep callback functions short.

---

✅ Prefer `every()` over `filter().length === array.length`.

Example

Wrong

```js
users.filter(

    user => user.active

).length === users.length;
```

Better

```js
users.every(

    user => user.active

);
```

---

# 10. Common Mistakes

### Expecting an Object

Wrong

```js
const user = users.every(

    user => user.active

);

console.log(user.name);
```

`every()` returns

```js
true
```

or

```js
false
```

---

### Using `every()` Instead of `some()`

Wrong

```js
const result = users.every(

    user => user.admin

);
```

If you only want to know whether **at least one** admin exists,

use

```js
some()
```

instead.

---

### Forgetting `return`

Wrong

```js
numbers.every(

    num => {

        num > 10;

    }

);
```

Returns

```js
false
```

---

# 11. Interview Questions

### What does `every()` return?

---

### Does `every()` stop after one failed condition?

---

### Difference between `every()` and `some()`?

---

### Difference between `every()` and `filter()`?

---

### Why use `every()` instead of `filter().length === array.length`?

---

### Can `every()` work with arrays of objects?

---

# 12. Coding Exercises

### Exercise 1

Check whether every student scored above 50.

---

### Exercise 2

Check whether every employee is verified.

---

### Exercise 3

Check whether every filename ends with `.js`.

---

### Exercise 4

Check whether every product is in stock.

---

### Exercise 5

Predict the output.

```js
const users = [

    {

        name:"Om",

        active:true

    },

    {

        name:"Raj",

        active:false

    }

];

const result = users.every(

    user => user.active

);

console.log(result);
```

---

# 13. Summary

- `every()` works with numbers, strings, objects, and nested arrays.
- It returns `true` only if every element satisfies the condition.
- It stops immediately after the first failed condition.
- It returns `false` if any element fails.
- It is widely used for validations, permissions, business rules, and form checking.
- It is heavily used in React applications, Node.js APIs, and coding interviews.

---

# Next Part

➡️ **Part 4 – Advanced every(), Performance, Memory, Interview Mastery & Debugging**

You'll learn:

- Performance Analysis
- Memory Behavior
- `every()` vs `some()`
- `every()` vs `filter()`
- `every()` vs `includes()`
- Debugging
- Predict the Output
- Interview Traps
- Advanced Coding Exercises
- Quick Revision Sheet


# every()

# Part 4 – Advanced `every()`, Performance, Memory, Interview Mastery & Debugging

> **"Mastering `every()` means understanding how JavaScript checks every element internally, when it stops execution, how it differs from `some()`, `filter()`, and `includes()`, and why it is one of the most useful validation methods in modern JavaScript."**

---

# Table of Contents

1. Advanced Usage
2. Performance Considerations
3. Memory Behavior
4. `every()` vs Other Array Methods
5. Debugging `every()`
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

## Multiple Conditions

```js
const employees = [

    {

        name:"Om",

        age:26,

        salary:70000

    },

    {

        name:"Raj",

        age:30,

        salary:50000

    },

    {

        name:"Amit",

        age:28,

        salary:80000

    }

];

const result = employees.every(

    employee =>

        employee.age >= 18 &&

        employee.salary >= 30000

);

console.log(result);
```

Output

```js
true
```

---

## Using OR

```js
const users = [

    {

        name:"Om",

        verified:true,

        admin:false

    },

    {

        name:"Raj",

        verified:false,

        admin:true

    }

];

const result = users.every(

    user =>

        user.verified ||

        user.admin

);

console.log(result);
```

Output

```js
true
```

---

# 2. Performance Considerations

Every call to `every()`

- visits elements one by one
- executes the callback
- stops immediately after the first failed condition

Time Complexity

Best Case

```
O(1)
```

Worst Case

```
O(n)
```

---

Example

```js
const result = numbers.every(

    num => num > 0

);
```

If

```
First Element Fails

↓

Only One Callback Execution
```

If

```
All Elements Pass

↓

Every Element Is Checked
```

---

Large Array

```
1 Million Elements

↓

every()

↓

Stops Immediately

(if one element fails)

↓

Efficient
```

---

# 3. Memory Behavior

Original

```
numbers

↓

Memory A

↓

[2,4,6,8]
```

Result

```
result

↓

true
```

Unlike

```
map()

filter()
```

`every()` does **not create a new array**.

Only one boolean value is returned.

Memory

```
Memory A

↓

Array

↓

Boolean Returned
```

No array copying occurs.

---

# 4. `every()` vs Other Array Methods

| Method | Returns | Stops Early | Purpose |
|---------|----------|------------|----------|
| `every()` | Boolean | ✅ Yes | All elements must match |
| `some()` | Boolean | ✅ Yes | At least one matches |
| `find()` | Element | ✅ Yes | First matching element |
| `findIndex()` | Index | ✅ Yes | Index of first match |
| `filter()` | Array | ❌ No | All matching elements |
| `includes()` | Boolean | ✅ Yes | Exact value exists |

---

## `every()` vs `some()`

```js
const numbers = [2,4,5];
```

`every()`

```js
numbers.every(

    num => num % 2 === 0

);
```

Output

```js
false
```

---

`some()`

```js
numbers.some(

    num => num % 2 === 0

);
```

Output

```js
true
```

---

## `every()` vs `find()`

`every()`

```js
users.every(

    user => user.active

);
```

Output

```js
true
```

---

`find()`

```js
users.find(

    user => user.active

);
```

Output

```js
{
id:1,
active:true
}
```

---

## `every()` vs `filter()`

`every()`

```js
users.every(

    user => user.active

);
```

Returns

```
Boolean
```

---

`filter()`

```js
users.filter(

    user => user.active

);
```

Returns

```
Array
```

---

## `every()` vs `includes()`

`includes()`

```js
const numbers = [10,20,30];

console.log(

    numbers.includes(20)

);
```

Output

```js
true
```

---

`every()`

```js
const numbers = [10,20,30];

console.log(

    numbers.every(

        num => num > 5

    )

);
```

Output

```js
true
```

---

# 5. Debugging `every()`

Wrong

```js
const result = [2,4,6].every(

    num => {

        num % 2 === 0;

    }

);

console.log(result);
```

Output

```js
false
```

Reason

```
No Return Statement

↓

undefined

↓

Falsy
```

---

Correct

```js
const result = [2,4,6].every(

    num => {

        return num % 2 === 0;

    }

);

console.log(result);
```

Output

```js
true
```

---

Debug Callback

```js
numbers.every(

    num => {

        console.log(num);

        return num > 0;

    }

);
```

Useful while debugging execution.

---

# 6. Predict the Output

## Example 1

```js
const arr = [2,4,6];

const result = arr.every(

    num => true

);

console.log(result);
```

Output

```js
true
```

---

## Example 2

```js
const arr = [2,4,6];

const result = arr.every(

    num => false

);

console.log(result);
```

Output

```js
false
```

---

## Example 3

```js
const arr = [10,20,30];

const result = arr.every(

    num => num > 5

);

console.log(result);
```

Output

```js
true
```

---

# 7. Interview Traps

## Trap 1

Does `every()` return matching elements?

```
No
```

It returns only

```
true

or

false
```

---

## Trap 2

Does `every()` stop after one failed condition?

```
Yes
```

---

## Trap 3

Can `every()` return `false`?

```
Yes

If even one element fails.
```

---

## Trap 4

Can `every()` work with arrays of objects?

```
Yes
```

---

## Trap 5

Can `includes()` replace `every()`?

```
No
```

`includes()`

checks exact values.

`every()`

checks custom conditions.

---

# 8. Best Practices

✅ Use `every()` when **all elements** must satisfy a condition.

---

✅ Return boolean expressions.

---

✅ Prefer `every()` over `filter().length === array.length`.

---

✅ Keep callback functions short.

---

✅ Use descriptive variable names.

---

# 9. Common Mistakes

### Forgetting `return`

Wrong

```js
numbers.every(

    num => {

        num > 10;

    }

);
```

Returns

```js
false
```

---

### Expecting an Object

Wrong

```js
const result = users.every(

    user => user.active

);

console.log(result.name);
```

`every()` returns a boolean.

---

### Using `every()` Instead of `some()`

Wrong

```js
users.every(

    user => user.admin

);
```

Need to know whether **at least one** admin exists?

Use

```js
some()
```

---

# 10. Interview Questions

### What is the time complexity of `every()`?

---

### Best-case complexity?

---

### Worst-case complexity?

---

### Does `every()` modify the original array?

---

### Difference between `every()` and `some()`?

---

### Difference between `every()` and `filter()`?

---

### Difference between `every()` and `find()`?

---

### When should you use `every()`?

---

# 11. Coding Exercises

### Exercise 1

Check whether every student passed.

---

### Exercise 2

Check whether every employee is verified.

---

### Exercise 3

Check whether every filename ends with `.js`.

---

### Exercise 4

Check whether every product is available.

---

### Exercise 5

Explain why this returns `false`.

```js
const arr = [10,20];

const result = arr.every(

    num => {

        num > 10;

    }

);

console.log(result);
```

---

# 12. Quick Revision Sheet

```
every()

↓

Visit Element

↓

Run Callback

↓

Truthy?

↓

Next Element

↓

Falsy?

↓

Return false

↓

Stop

↓

All Elements Passed?

↓

Return true
```

Remember

```
Transform

↓

map()

Select Many

↓

filter()

Find Element

↓

find()

Find Position

↓

findIndex()

One Match

↓

some()

All Match

↓

every()
```

---

# 13. Summary

- `every()` checks whether **all** elements satisfy a condition.
- It returns a **boolean** (`true` or `false`).
- Best Case Time Complexity is **O(1)**.
- Worst Case Time Complexity is **O(n)**.
- It stops immediately after the first failed condition.
- It does not create a new array.
- It is heavily used for validations, permissions, authentication, business rules, and coding interviews.

---

# Chapter Complete ✅

You now understand:

- ✔ What `every()` is
- ✔ Internal Working
- ✔ Callback Function
- ✔ Truthy & Falsy
- ✔ Memory Behavior
- ✔ Performance Analysis
- ✔ Objects & Arrays
- ✔ React Usage
- ✔ Node.js Usage
- ✔ Interview Questions
- ✔ Common Mistakes
- ✔ Best Practices
- ✔ Coding Exercises

---

# What's Next?

➡️ **08-reduce().md**

You'll master:

- What `reduce()` is
- Accumulator & Current Value
- Internal Working
- Memory Behavior
- Objects & Arrays
- Grouping Data
- Frequency Counter
- Flattening Arrays
- React Examples
- Node.js Examples
- Interview Questions
- Advanced Coding Problems