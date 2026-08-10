# some()

# Part 1 – Introduction & Fundamentals

> **"`some()` is a JavaScript array method that checks whether at least one element satisfies a given condition. It returns `true` if any element matches; otherwise, it returns `false`."**

---

# Table of Contents

1. Introduction
2. Why `some()` Was Introduced
3. Syntax
4. Parameters
5. Return Value
6. Internal Working
7. Visualization
8. Memory Behavior
9. First Examples
10. `some()` vs `for` Loop
11. Best Practices
12. Common Mistakes
13. Interview Questions
14. Coding Exercises
15. Summary

---

# 1. Introduction

Suppose we have an array.

```js
const numbers = [5, 8, 13, 20];
```

We want to know

> **Does this array contain at least one even number?**

Expected Output

```js
true
```

Instead of writing loops manually,

we use `some()`.

```js
const numbers = [5, 8, 13, 20];

const result = numbers.some(

    num => num % 2 === 0

);

console.log(result);
```

Output

```js
true
```

Notice

`some()` returns

```js
true
```

NOT

```js
8
```

and NOT

```js
[8,20]
```

---

# 2. Why `some()` Was Introduced

Before ES6

```js
const numbers = [5,8,13];

let found = false;

for(let i=0;i<numbers.length;i++){

    if(numbers[i] % 2 === 0){

        found = true;

        break;

    }

}

console.log(found);
```

Problems

- Manual loop
- Manual boolean variable
- Manual `break`
- More code

---

Using `some()`

```js
const found = numbers.some(

    num => num % 2 === 0

);

console.log(found);
```

Much cleaner.

---

# 3. Syntax

```js
array.some(callback)
```

Example

```js
array.some(

    element => {

    }

);
```

---

# 4. Parameters

The callback receives three parameters.

```js
array.some(

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

numbers.some(

    (value,index)=>{

        console.log(value,index);

        return false;

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

If at least one callback returns

```js
true
```

↓

Return

```js
true
```

immediately.

---

If no callback returns true

↓

Return

```js
false
```

---

Example

```js
const numbers = [1,3,5,8];

const result = numbers.some(

    num => num % 2 === 0

);

console.log(result);
```

Output

```js
true
```

---

No Match

```js
const numbers = [1,3,5];

const result = numbers.some(

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
const numbers = [5,10,15,20];
```

Execution

```
some()

↓

Take First Element

↓

Condition?

↓

true

↓

Return true

↓

Stop

----------------

false

↓

Next Element
```

Unlike `filter()`,

`some()` stops immediately after finding the first match.

---

Example

```js
const numbers = [5,10,15,20];

const result = numbers.some(

    num => num > 8

);

console.log(result);
```

Execution

```
5

↓

false

↓

Continue

------------

10

↓

true

↓

Return true

↓

Stop
```

Output

```js
true
```

---

# 7. Visualization

```
Original Array

↓

[5,10,15,20]

↓

some()

↓

5

↓

false

↓

Continue

------------

10

↓

true

↓

Return true

↓

Stop
```

Remaining elements

```
15

20
```

are never checked.

---

# 8. Memory Behavior

Original

```
numbers

↓

Memory A

↓

[5,10,15,20]
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

`some()` does **not create a new array**.

It only returns a boolean.

---

# 9. First Examples

## Example 1

Check Positive Number

```js
const numbers = [-2,-4,5,-8];

const result = numbers.some(

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

Check Negative Number

```js
const numbers = [2,4,6];

const result = numbers.some(

    num => num < 0

);

console.log(result);
```

Output

```js
false
```

---

## Example 3

Check Long String

```js
const fruits = [

    "Apple",

    "Banana",

    "Watermelon",

    "Kiwi"

];

const result = fruits.some(

    fruit => fruit.length > 8

);

console.log(result);
```

Output

```js
true
```

---

# 10. `some()` vs `for` Loop

Using `for`

```js
let found = false;

for(let num of numbers){

    if(num > 20){

        found = true;

        break;

    }

}
```

---

Using `some()`

```js
const found = numbers.some(

    num => num > 20

);
```

Comparison

| `for` Loop | `some()` |
|------------|----------|
| Manual loop | Automatic |
| Manual boolean | Returns boolean |
| Manual break | Stops automatically |
| More code | Cleaner |

---

# 11. Best Practices

✅ Use `some()` when checking if **at least one** element matches.

✅ Return boolean expressions.

✅ Keep callbacks simple.

✅ Use descriptive variable names.

---

# 12. Common Mistakes

### Expecting an Element

Wrong

```js
const result = numbers.some(

    num => num > 20

);

console.log(result.name);
```

`some()` returns a boolean,

not an object.

---

### Forgetting `return`

Wrong

```js
numbers.some(

    num => {

        num > 10;

    }

);
```

Output

```js
false
```

---

### Using `some()` Instead of `find()`

Wrong

```js
numbers.some(

    num => num > 20

);
```

when you actually need

```js
25
```

Use

```js
find()
```

instead.

---

# 13. Interview Questions

### What is `some()`?

---

### What does `some()` return?

---

### Does `some()` stop after the first match?

---

### What happens if no element matches?

---

### Does `some()` return an array?

---

# 14. Coding Exercises

### Exercise 1

Check whether an array contains an even number.

---

### Exercise 2

Check whether any student has marks greater than 90.

---

### Exercise 3

Predict the output.

```js
const arr = [1,2,3];

const result = arr.some(

    num => num > 2

);

console.log(result);
```

---

### Exercise 4

Check whether any string starts with `"A"`.

---

### Exercise 5

Explain why this returns `false`.

```js
numbers.some(

    num => {

        num > 5;

    }

);
```

---

# 15. Summary

- `some()` checks whether **at least one** element satisfies a condition.
- It returns **true** or **false**.
- It stops immediately after finding the first matching element.
- It does not return the matching element.
- It does not create a new array.
- It is commonly used for validations, permissions, authentication, and existence checks.

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
# some()

# Part 2 – Callback Function, Internal Working, Execution Flow & Truthy/Falsy

> **"`some()` executes a callback function for every element in an array until the callback returns a truthy value. As soon as one element satisfies the condition, `some()` immediately returns `true` and stops searching."**

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

The function passed to `some()` is called the **Callback Function**.

Example

```js
const numbers = [10,20,30];

const result = numbers.some(

    num => num > 15

);

console.log(result);
```

Output

```js
true
```

The callback is

```js
num => num > 15
```

---

# 2. Why Callback Functions?

Instead of JavaScript deciding what is considered a match,

**you provide the condition.**

Think of `some()` like this

```
some()

↓

Visit First Element

↓

Ask Callback

↓

Match?

↓

Yes

↓

Return true

↓

Stop

↓

No

↓

Next Element
```

---

Example

```js
const numbers = [3,5,8,10];

const result = numbers.some(

    num => num % 2 === 0

);

console.log(result);
```

Output

```js
true
```

Notice

Although

```
10
```

is also even,

`some()` stops after finding

```
8
```

---

# 3. Callback Parameters

The callback receives three parameters.

```js
array.some(

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

numbers.some(

    element => {

        console.log(element);

        return false;

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

numbers.some(

    (element,index)=>{

        console.log(index);

        return false;

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

numbers.some(

    (element,index,array)=>{

        console.log(array);

        return false;

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

`some()` checks **truthy** and **falsy** values.

---

Truthy Values

```
true

1

100

"Hello"

[]

{}

-10
```

Example

```js
const numbers = [10,20];

const result = numbers.some(

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

The first element immediately satisfies the condition.

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

const result = numbers.some(

    num => 0

);

console.log(result);
```

Output

```js
false
```

---

Best Practice

Always return boolean expressions.

```js
num > 10

price < 1000

user.active

student.marks >= 40
```

---

# 5. Step-by-Step Execution

Example

```js
const numbers = [5,10,15,20];

const result = numbers.some(

    num => num > 12

);
```

---

### Step 1

Take

```
5
```

Condition

```js
5 > 12
```

Result

```
false
```

Continue

---

### Step 2

Take

```
10
```

Condition

```js
10 > 12
```

Result

```
false
```

Continue

---

### Step 3

Take

```
15
```

Condition

```js
15 > 12
```

Result

```
true
```

Return

```
true
```

Stop immediately.

---

# 6. Dry Run

Example

```js
const numbers = [3,5,8,10];

const result = numbers.some(

    num => num % 2 === 0

);
```

Iteration 1

```
3

↓

Odd

↓

Continue
```

---

Iteration 2

```
5

↓

Odd

↓

Continue
```

---

Iteration 3

```
8

↓

Even

↓

Return true

↓

Stop
```

Element

```js
10
```

is never checked.

---

# 7. Memory Visualization

Original

```
numbers

↓

Memory A

↓

[3,5,8,10]
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

`some()` does **not create a new array**.

It only returns a boolean.

---

# 8. Execution Flow

```
Array

↓

some()

↓

First Element

↓

Callback

↓

Truthy?

↓

Return true

↓

Stop

↓

Falsy?

↓

Next Element
```

---

# 9. Return Value

Correct

```js
numbers.some(

    num => num > 5

);
```

---

Wrong

```js
numbers.some(

    num => {

        num > 5;

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
```

---

# 10. Different Callback Styles

## Arrow Function

```js
numbers.some(

    num => num > 10

);
```

---

## Arrow Function with Braces

```js
numbers.some(

    num => {

        return num > 10;

    }

);
```

---

## Normal Function

```js
numbers.some(

    function(num){

        return num > 10;

    }

);
```

All three produce the same output.

---

# 11. Best Practices

✅ Return boolean expressions.

---

✅ Use `some()` only when checking whether at least one element matches.

---

✅ Keep callback functions short.

---

✅ Use descriptive variable names.

---

# 12. Common Mistakes

### Forgetting `return`

Wrong

```js
numbers.some(

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
const result = numbers.some(

    num => num > 10

);

console.log(result.name);
```

`some()` returns a boolean.

---

### Using `some()` Instead of `find()`

Wrong

```js
numbers.some(

    num => num > 10

);
```

when you actually need

```js
20
```

Use

```js
find()
```

instead.

---

# 13. Interview Questions

### What is a callback function?

---

### How many times is the callback executed?

---

### Does `some()` stop early?

---

### What happens if no match exists?

---

### Can `some()` return an object?

---

### Why is `some()` considered a Higher-Order Function?

---

# 14. Coding Exercises

### Exercise 1

Check whether an array contains an odd number.

---

### Exercise 2

Check whether any student has marks above 90.

---

### Exercise 3

Predict the output.

```js
const arr = [2,4,6];

const result = arr.some(

    num => true

);

console.log(result);
```

---

### Exercise 4

Predict the output.

```js
const arr = [2,4,6];

const result = arr.some(

    num => false

);

console.log(result);
```

---

### Exercise 5

Explain why this returns `false`.

```js
const arr = [10,20];

const result = arr.some(

    num => {

        num > 15;

    }

);
```

---

# 15. Summary

- `some()` executes its callback once for each element until a match is found.
- The callback receives `element`, `index`, and the original `array`.
- Truthy values immediately return `true`.
- Falsy values continue searching.
- `some()` stops immediately after the first match.
- If no element matches, it returns `false`.
- It does not create a new array.

---

# Next Part

➡️ **Part 3 – some() with Objects, Strings, Arrays & Real-World Examples**

You'll learn:

- Using `some()` with Objects
- Multiple Conditions
- Arrays of Strings
- Nested Arrays
- React Examples
- Node.js Examples
- Form Validation
- Authentication Checks
- Permission Systems
- Real-world Interview Problems
# some()

# Part 3 – some() with Objects, Strings, Arrays & Real-World Examples

> **"`some()` is commonly used to check whether at least one object, string, or value satisfies a condition. It is heavily used in authentication, authorization, form validation, shopping carts, React state, and backend APIs."**

---

# Table of Contents

1. Using `some()` with Objects
2. Using Multiple Conditions
3. Using `some()` with Strings
4. Using `some()` with Nested Arrays
5. Chaining with `some()`
6. Real-world Examples
7. React Examples
8. Node.js Examples
9. Best Practices
10. Common Mistakes
11. Interview Questions
12. Coding Exercises
13. Summary

---

# 1. Using `some()` with Objects

Checking whether a student has scored above 90.

```js
const students = [

    {

        name:"Om",

        marks:95

    },

    {

        name:"Raj",

        marks:80

    },

    {

        name:"Amit",

        marks:75

    }

];

const hasTopper = students.some(

    student => student.marks > 90

);

console.log(hasTopper);
```

Output

```js
true
```

---

Another Example

```js
const users = [

    {

        id:1,

        active:false

    },

    {

        id:2,

        active:true

    }

];

const hasActiveUser = users.some(

    user => user.active

);

console.log(hasActiveUser);
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

        age:24,

        salary:50000

    },

    {

        name:"Raj",

        age:31,

        salary:35000

    },

    {

        name:"Amit",

        age:28,

        salary:70000

    }

];

const result = employees.some(

    employee =>

        employee.age > 25 &&

        employee.salary > 60000

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
const result = employees.some(

    employee =>

        employee.salary > 65000 ||

        employee.age < 25

);

console.log(result);
```

Output

```js
true
```

---

# 3. Using `some()` with Strings

Check whether any string starts with "A".

```js
const names = [

    "Om",

    "Raj",

    "Ankit",

    "Rahul"

];

const result = names.some(

    name => name.startsWith("A")

);

console.log(result);
```

Output

```js
true
```

---

Check whether any filename ends with `.js`.

```js
const files = [

    "index.html",

    "style.css",

    "app.js",

    "server.js"

];

const hasJavaScriptFile = files.some(

    file => file.endsWith(".js")

);

console.log(hasJavaScriptFile);
```

Output

```js
true
```

---

Check string length.

```js
const fruits = [

    "Apple",

    "Kiwi",

    "Banana"

];

const result = fruits.some(

    fruit => fruit.length > 8

);

console.log(result);
```

Output

```js
false
```

---

# 4. Using `some()` with Nested Arrays

Example

```js
const matrix = [

    [1,2],

    [5,6],

    [8,9]

];

const result = matrix.some(

    row => row[0] > 4

);

console.log(result);
```

Output

```js
true
```

---

# 5. Chaining with `some()`

Example

```js
const users = [

    {

        id:1,

        active:false

    },

    {

        id:2,

        active:true

    },

    {

        id:3,

        active:false

    }

];

const result = users

.filter(

    user => user.id > 0

)

.some(

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

some()

↓

Boolean
```

---

# 6. Real-world Examples

## Login System

Check whether a username exists.

```js
const users = [

    {

        username:"om"

    },

    {

        username:"raj"

    }

];

const exists = users.some(

    user => user.username === "raj"

);

console.log(exists);
```

Output

```js
true
```

---

## Shopping Cart

Check whether a product is already added.

```js
const cart = [

    {

        id:1,

        product:"Laptop"

    },

    {

        id:2,

        product:"Mouse"

    }

];

const exists = cart.some(

    item => item.id === 2

);

console.log(exists);
```

Output

```js
true
```

---

## Email Validation

```js
const users = [

    {

        email:"om@gmail.com"

    },

    {

        email:"raj@gmail.com"

    }

];

const emailExists = users.some(

    user => user.email === "raj@gmail.com"

);

console.log(emailExists);
```

Output

```js
true
```

---

## Permission Check

```js
const permissions = [

    "READ",

    "WRITE"

];

const canDelete = permissions.some(

    permission => permission === "DELETE"

);

console.log(canDelete);
```

Output

```js
false
```

---

# 7. React Examples

Check whether a Todo exists.

```jsx
const exists = todos.some(

    todo => todo.id === id

);
```

---

Check whether a user is logged in.

```jsx
const loggedIn = users.some(

    user => user.isLoggedIn

);
```

---

Disable Submit Button

```jsx
const hasErrors = errors.some(

    error => error !== ""

);
```

---

# 8. Node.js Examples

Check whether an employee exists.

```js
const employeeExists = employees.some(

    employee => employee.id === employeeId

);
```

---

Check whether an order exists.

```js
const orderExists = orders.some(

    order => order.orderId === id

);
```

---

Check whether a product exists.

```js
const exists = products.some(

    product => product.sku === sku

);
```

---

# 9. Best Practices

✅ Use `some()` when you only need a **Yes/No** answer.

---

✅ Return boolean expressions.

---

✅ Keep callback functions short.

---

✅ Prefer `some()` over `filter().length > 0`.

Example

Wrong

```js
users.filter(

    user => user.active

).length > 0;
```

Better

```js
users.some(

    user => user.active

);
```

---

# 10. Common Mistakes

### Expecting the Matching Object

Wrong

```js
const user = users.some(

    user => user.id === 2

);

console.log(user.name);
```

`some()` returns

```js
true
```

not an object.

---

### Using `some()` Instead of `find()`

Wrong

```js
const user = users.some(

    user => user.id === 2

);
```

Need object?

Use

```js
find()
```

---

### Forgetting `return`

Wrong

```js
numbers.some(

    num => {

        num > 5;

    }

);
```

Returns

```js
false
```

---

# 11. Interview Questions

### What does `some()` return?

---

### Does `some()` stop after finding one match?

---

### Difference between `some()` and `find()`?

---

### Difference between `some()` and `every()`?

---

### Why use `some()` instead of `filter().length > 0`?

---

### Can `some()` search arrays of objects?

---

# 12. Coding Exercises

### Exercise 1

Check whether any student scored above 90.

---

### Exercise 2

Check whether any employee earns more than ₹1,00,000.

---

### Exercise 3

Check whether any filename ends with `.js`.

---

### Exercise 4

Check whether any product belongs to the `"Electronics"` category.

---

### Exercise 5

Predict the output.

```js
const users = [

    {

        name:"Om",

        active:false

    },

    {

        name:"Raj",

        active:true

    }

];

const result = users.some(

    user => user.active

);

console.log(result);
```

---

# 13. Summary

- `some()` works with numbers, strings, objects, and nested arrays.
- It returns **true** if at least one element matches.
- It stops immediately after the first successful match.
- It returns **false** if no match exists.
- It is commonly used for authentication, authorization, validations, shopping carts, and form checks.
- It is heavily used in React applications, Node.js backends, and technical interviews.

---

# Next Part

➡️ **Part 4 – Advanced some(), Performance, Memory, Interview Mastery & Debugging**

You'll learn:

- Performance Analysis
- Memory Behavior
- `some()` vs `every()`
- `some()` vs `find()`
- `some()` vs `includes()`
- Debugging
- Predict the Output
- Interview Traps
- Advanced Coding Exercises
- Quick Revision Sheet

# some()

# Part 4 – Advanced `some()`, Performance, Memory, Interview Mastery & Debugging

> **"Mastering `some()` means understanding how JavaScript internally checks elements, when it stops searching, how it differs from `every()`, `find()`, and `includes()`, and why it is one of the most useful validation methods in modern JavaScript."**

---

# Table of Contents

1. Advanced Usage
2. Performance Considerations
3. Memory Behavior
4. `some()` vs Other Array Methods
5. Debugging `some()`
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

        age:24,

        salary:50000

    },

    {

        name:"Raj",

        age:30,

        salary:35000

    },

    {

        name:"Amit",

        age:28,

        salary:70000

    }

];

const result = employees.some(

    employee =>

        employee.age > 25 &&

        employee.salary > 60000

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
const result = employees.some(

    employee =>

        employee.salary > 65000 ||

        employee.age < 25

);

console.log(result);
```

Output

```js
true
```

Although both conditions may match different employees,

`some()` returns

```js
true
```

as soon as the **first** match is found.

---

# 2. Performance Considerations

Every call to `some()`

- visits elements one by one
- executes the callback
- stops immediately after the first match

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
const result = numbers.some(

    num => num > 5

);
```

If

```
First Element Matches

↓

Only One Callback Execution
```

If

```
Last Element Matches

↓

Every Element Is Checked
```

---

Large Array

```
1 Million Elements

↓

some()

↓

Stops Immediately

(if match found)

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

[10,20,30]
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

`some()` does **not** create a new array.

It only returns a boolean.

Memory

```
Memory A

↓

Array

↓

Boolean Returned
```

No copying occurs.

---

# 4. `some()` vs Other Array Methods

| Method | Returns | Stops Early | Purpose |
|---------|----------|------------|----------|
| `some()` | Boolean | ✅ Yes | At least one match |
| `every()` | Boolean | ✅ Yes | All must match |
| `find()` | Element | ✅ Yes | Return first element |
| `findIndex()` | Index | ✅ Yes | Return first index |
| `filter()` | Array | ❌ No | Return all matches |
| `includes()` | Boolean | ✅ Yes | Exact value check |

---

## `some()` vs `every()`

```js
const numbers = [2,4,5];
```

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

## `some()` vs `find()`

`some()`

```js
users.some(

    user => user.id === 2

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

    user => user.id === 2

);
```

Output

```js
{
id:2,
name:"Raj"
}
```

---

## `some()` vs `includes()`

`includes()`

Searches for an **exact value**.

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

`some()`

Searches using a condition.

```js
const numbers = [10,20,30];

console.log(

    numbers.some(

        num => num > 15

    )

);
```

Output

```js
true
```

---

# 5. Debugging `some()`

Wrong

```js
const result = [1,2,3].some(

    num => {

        num > 1;

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
```

---

Correct

```js
const result = [1,2,3].some(

    num => {

        return num > 1;

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
numbers.some(

    num => {

        console.log(num);

        return num > 5;

    }

);
```

Useful during interviews.

---

# 6. Predict the Output

## Example 1

```js
const arr = [1,2,3];

const result = arr.some(

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
const arr = [1,2,3];

const result = arr.some(

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

const result = arr.some(

    num => num > 15

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

Does `some()` return the matching element?

```
No
```

It returns a boolean.

---

## Trap 2

Does `some()` stop after the first match?

```
Yes
```

---

## Trap 3

Can `some()` return `false`?

```
Yes
```

If no element matches.

---

## Trap 4

Can `some()` search arrays of objects?

```
Yes
```

---

## Trap 5

Can `includes()` replace `some()`?

```
No
```

`includes()` compares exact values.

`some()` supports custom conditions.

---

# 8. Best Practices

✅ Use `some()` when you only need a Yes/No answer.

---

✅ Return boolean expressions.

---

✅ Prefer `some()` over `filter().length > 0`.

---

✅ Keep callback functions small.

---

✅ Use descriptive variable names.

---

# 9. Common Mistakes

### Forgetting `return`

Wrong

```js
numbers.some(

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
const result = users.some(

    user => user.id === 2

);

console.log(result.name);
```

`some()` returns a boolean.

---

### Using `some()` Instead of `find()`

Wrong

```js
users.some(

    user => user.id === 2

);
```

Need the object?

Use

```js
find()
```

---

# 10. Interview Questions

### What is the time complexity of `some()`?

---

### Best-case complexity?

---

### Worst-case complexity?

---

### Does `some()` modify the original array?

---

### Difference between `some()` and `every()`?

---

### Difference between `some()` and `find()`?

---

### Difference between `some()` and `includes()`?

---

### When should you use `some()`?

---

# 11. Coding Exercises

### Exercise 1

Check whether any student scored above 90.

---

### Exercise 2

Check whether any employee earns more than ₹1,00,000.

---

### Exercise 3

Check whether any filename ends with `.js`.

---

### Exercise 4

Check whether any user is active.

---

### Exercise 5

Explain why this returns `false`.

```js
const arr = [10,20];

const result = arr.some(

    num => {

        num > 10;

    }

);

console.log(result);
```

---

# 12. Quick Revision Sheet

```
some()

↓

Visit Element

↓

Run Callback

↓

Truthy?

↓

Return true

↓

Stop

↓

Falsy?

↓

Next Element

↓

No Match?

↓

Return false
```

Remember

```
Transform

↓

map()

Select Many

↓

filter()

Find One Element

↓

find()

Find Position

↓

findIndex()

At Least One?

↓

some()

All Elements?

↓

every()
```

---

# 13. Summary

- `some()` checks whether **at least one** element satisfies a condition.
- It returns a **boolean** (`true` or `false`).
- Best Case Time Complexity is **O(1)**.
- Worst Case Time Complexity is **O(n)**.
- It stops immediately after finding the first match.
- It does not create a new array.
- It is one of the most common methods used for validation, authentication, permissions, and interview coding problems.

---

# Chapter Complete ✅

You now understand:

- ✔ What `some()` is
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

➡️ **07-every.md**

You'll master:

- What `every()` is
- Internal Working
- Callback Function
- Short-Circuit Evaluation
- `every()` vs `some()`
- `every()` vs `filter()`
- React Examples
- Node.js Examples
- Memory Behavior
- Performance Analysis
- Interview Questions
- Coding Exercises

