# filter()

# Part 1 – Introduction & Fundamentals

> **"`filter()` is a JavaScript array method that creates a new array containing only the elements that satisfy a given condition. It never modifies the original array."**

---

# Table of Contents

1. Introduction
2. Why `filter()` Was Introduced
3. Syntax
4. Parameters
5. Return Value
6. Internal Working
7. Visualization
8. Memory Behavior
9. First Examples
10. `filter()` vs `for` Loop
11. Best Practices
12. Common Mistakes
13. Interview Questions
14. Coding Exercises
15. Summary

---

# 1. Introduction

Suppose you have an array of numbers.

```js
const numbers = [10, 25, 30, 15, 40];
```

Now you only want numbers greater than **20**.

Expected Output

```js
[25, 30, 40]
```

Instead of writing loops manually, JavaScript provides **`filter()`**.

```js
const numbers = [10, 25, 30, 15, 40];

const result = numbers.filter(num => num > 20);

console.log(result);
```

Output

```js
[25, 30, 40]
```

---

# 2. Why `filter()` Was Introduced

Before ES5, developers manually filtered arrays.

Example

```js
const numbers = [10, 25, 30];

const result = [];

for (let i = 0; i < numbers.length; i++) {

    if (numbers[i] > 20) {

        result.push(numbers[i]);

    }

}

console.log(result);
```

Problems

- Too much code
- Manual array creation
- Less readable
- Easy to make mistakes

---

Using `filter()`

```js
const numbers = [10, 25, 30];

const result = numbers.filter(

    num => num > 20

);

console.log(result);
```

Cleaner and easier to understand.

---

# 3. Syntax

```js
array.filter(callback)
```

or

```js
array.filter(function(currentValue) {

});
```

Most common syntax

```js
array.filter(element => {

});
```

---

# 4. Parameters

The callback receives three parameters.

```js
array.filter(

    (element, index, array) => {

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

numbers.filter(

    (value,index) => {

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

Unlike `map()`, `filter()` does **not transform values**.

It decides whether each value should stay or be removed.

If callback returns

```js
true
```

↓

Element is kept.

If callback returns

```js
false
```

↓

Element is discarded.

---

Example

```js
const numbers = [5,10,15,20];

const result = numbers.filter(

    num => num >= 15

);

console.log(result);
```

Output

```js
[15,20]
```

Original array

```js
[5,10,15,20]
```

remains unchanged.

---

# 6. Internal Working

Suppose we have

```js
const numbers = [5,10,15];
```

Execution

```
filter()

↓

Take First Element

↓

Run Callback

↓

Condition?

↓

true

↓

Keep

↓

false

↓

Discard

↓

Repeat

↓

Return New Array
```

---

Example

```js
const numbers = [5,10,15];

const result = numbers.filter(

    num => num > 8

);

console.log(result);
```

Output

```js
[10,15]
```

---

# 7. Visualization

```
Original Array

↓

[5,10,15]

↓

filter()

↓

5

↓

false

↓

Discard

----------------

10

↓

true

↓

Keep

----------------

15

↓

true

↓

Keep

↓

New Array

↓

[10,15]
```

---

# 8. Memory Behavior

Original

```
numbers

↓

Memory A

↓

[5,10,15]
```

After filter

```
result

↓

Memory B

↓

[10,15]
```

Different arrays

```
Memory A

≠

Memory B
```

The original array is never modified.

---

# 9. First Examples

## Example 1

Even Numbers

```js
const numbers = [1,2,3,4,5,6];

const even = numbers.filter(

    num => num % 2 === 0

);

console.log(even);
```

Output

```js
[2,4,6]
```

---

## Example 2

Odd Numbers

```js
const numbers = [1,2,3,4,5];

const odd = numbers.filter(

    num => num % 2 !== 0

);

console.log(odd);
```

Output

```js
[1,3,5]
```

---

## Example 3

Marks Greater Than 80

```js
const marks = [90,70,85,60];

const topper = marks.filter(

    mark => mark > 80

);

console.log(topper);
```

Output

```js
[90,85]
```

---

# 10. `filter()` vs `for` Loop

Using `for`

```js
const result = [];

for (let i = 0; i < numbers.length; i++) {

    if (numbers[i] > 20) {

        result.push(numbers[i]);

    }

}
```

---

Using `filter()`

```js
const result = numbers.filter(

    num => num > 20

);
```

Comparison

| `for` Loop | `filter()` |
|------------|------------|
| Manual checking | Automatic |
| More code | Less code |
| Manual array | Automatic array |
| Harder to read | Cleaner |

---

# 11. Best Practices

✅ Use `filter()` only when selecting elements.

✅ Return a boolean expression.

✅ Keep callbacks small.

✅ Combine with `map()` when needed.

---

# 12. Common Mistakes

### Using `map()` instead of `filter()`

Wrong

```js
numbers.map(

    num => num > 20

);
```

Output

```js
[
false,
true,
true
]
```

---

Correct

```js
numbers.filter(

    num => num > 20

);
```

---

### Forgetting to return

Wrong

```js
numbers.filter(

    num => {

        num > 20;

    }

);
```

Output

```js
[]
```

---

Correct

```js
numbers.filter(

    num => {

        return num > 20;

    }

);
```

---

# 13. Interview Questions

### What is `filter()`?

---

### What does `filter()` return?

---

### Does `filter()` modify the original array?

---

### What should the callback return?

---

### Difference between `map()` and `filter()`?

---

# 14. Coding Exercises

### Exercise 1

Return all even numbers.

```js
[1,2,3,4,5,6]
```

---

### Exercise 2

Return all numbers greater than 100.

---

### Exercise 3

Predict the output.

```js
const arr = [10,20,30];

const result = arr.filter(

    num => num >= 20

);

console.log(result);
```

---

### Exercise 4

Return all strings with length greater than 5.

---

### Exercise 5

Explain why this returns an empty array.

```js
numbers.filter(

    num => {

        num > 5;

    }

);
```

---

# 15. Summary

- `filter()` selects elements based on a condition.
- It always returns a **new array**.
- The callback must return `true` or `false`.
- The original array remains unchanged.
- It is commonly used before `map()` and `reduce()`.
- `filter()` is one of the most frequently used methods in React, Node.js, and coding interviews.

---

# Next Part

➡️ **Part 2 – Callback Function, Truthy & Falsy, Internal Working & Execution Flow**

You'll learn:

- Callback Function
- Boolean Return Values
- Truthy & Falsy
- Step-by-Step Execution
- Dry Runs
- Memory Flow
- Callback Parameters
- Visual Diagrams

# filter()

# Part 2 – Callback Function, Truthy & Falsy, Internal Working & Execution Flow

> **"`filter()` works by executing a callback function for every element in an array. If the callback returns a truthy value, the element is kept. Otherwise, it is removed from the new array."**

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

The function passed inside `filter()` is called a **Callback Function**.

Example

```js
const numbers = [10,20,30];

const result = numbers.filter(

    num => num > 15

);

console.log(result);
```

Output

```js
[20,30]
```

Here

```js
num => num > 15
```

is the callback function.

---

# 2. Why Callback Functions?

Instead of JavaScript deciding which elements to keep,

**you provide the condition.**

Think of `filter()` like this:

```
filter()

↓

Visit Every Element

↓

Ask Callback

↓

Should I Keep It?

↓

Yes

↓

Keep

↓

No

↓

Discard

↓

Return New Array
```

---

Example

```js
const numbers = [2,4,6,7];

const even = numbers.filter(

    num => num % 2 === 0

);

console.log(even);
```

Output

```js
[2,4,6]
```

---

# 3. Callback Parameters

The callback receives three parameters.

```js
array.filter(

    (element, index, array) => {

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

numbers.filter(

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

numbers.filter(

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

numbers.filter(

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

Most developers think `filter()` only works with `true` and `false`.

Actually,

it works with **truthy** and **falsy** values.

---

## Truthy Values

These keep the element.

```js
true

1

100

"Hello"

[]

{}

-5
```

---

Example

```js
const numbers = [1,2,3];

const result = numbers.filter(

    num => 1

);

console.log(result);
```

Output

```js
[1,2,3]
```

Because

```
1

↓

Truthy
```

---

## Falsy Values

These remove the element.

```js
false

0

""

null

undefined

NaN
```

---

Example

```js
const numbers = [1,2,3];

const result = numbers.filter(

    num => 0

);

console.log(result);
```

Output

```js
[]
```

Because

```
0

↓

Falsy
```

---

Most Common Practice

Return a boolean expression.

```js
num > 10

price <= 100

user.isActive

student.score >= 40
```

---

# 5. Step-by-Step Execution

Example

```js
const numbers = [5,10,15];

const result = numbers.filter(

    num => num > 8

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
5 > 8
```

Result

```
false
```

Discard

---

### Step 2

Take

```
10
```

Condition

```js
10 > 8
```

Result

```
true
```

Keep

---

### Step 3

Take

```
15
```

Condition

```js
15 > 8
```

Result

```
true
```

Keep

---

Final Array

```js
[10,15]
```

---

# 6. Dry Run

Example

```js
const numbers = [2,4,7,8];

const even = numbers.filter(

    num => num % 2 === 0

);
```

Iteration 1

```
2

↓

Even

↓

Keep
```

---

Iteration 2

```
4

↓

Even

↓

Keep
```

---

Iteration 3

```
7

↓

Odd

↓

Discard
```

---

Iteration 4

```
8

↓

Even

↓

Keep
```

---

Final

```js
[2,4,8]
```

---

# 7. Memory Visualization

Original

```
numbers

↓

Memory A

↓

[2,4,7,8]
```

During `filter()`

```
New Empty Array

↓

Memory B

↓

[]
```

---

Iteration 1

```
[2]
```

---

Iteration 2

```
[2,4]
```

---

Iteration 3

```
Still

[2,4]
```

because

```
7

↓

Discarded
```

---

Iteration 4

```
[2,4,8]
```

Return

```
Memory B

↓

[2,4,8]
```

Original array

```
Memory A

↓

Unchanged
```

---

# 8. Execution Flow

```
Array

↓

filter()

↓

First Element

↓

Callback

↓

Truthy?

↓

Yes

↓

Store

↓

Falsy?

↓

Discard

↓

Repeat

↓

Return New Array
```

---

# 9. Return Value

The callback should return a condition.

Correct

```js
numbers.filter(

    num => num > 5

);
```

---

Wrong

```js
numbers.filter(

    num => {

        num > 5;

    }

);
```

Output

```js
[]
```

Reason

```
Nothing Returned

↓

undefined

↓

Falsy
```

---

# 10. Different Callback Styles

## Arrow Function

```js
numbers.filter(

    num => num > 10

);
```

---

## Arrow Function with Braces

```js
numbers.filter(

    num => {

        return num > 10;

    }

);
```

---

## Normal Function

```js
numbers.filter(

    function(num){

        return num > 10;

    }

);
```

All three produce the same result.

---

# 11. Best Practices

✅ Return boolean expressions.

---

✅ Keep callback functions short.

---

✅ Use meaningful variable names.

---

✅ Combine `filter()` with `map()` when appropriate.

---

# 12. Common Mistakes

### Forgetting `return`

Wrong

```js
numbers.filter(

    num => {

        num > 5;

    }

);
```

Returns

```js
[]
```

---

### Returning Strings

Technically valid

```js
numbers.filter(

    num => "Hello"

);
```

Works because

```
"Hello"

↓

Truthy
```

But avoid this.

Always return boolean expressions.

---

### Modifying Original Array

Avoid

```js
numbers.filter(

    num => {

        numbers[0] = 100;

        return true;

    }

);
```

---

# 13. Interview Questions

### What is a callback function?

---

### How many times is the callback executed?

---

### What happens if the callback returns `false`?

---

### What happens if the callback returns `undefined`?

---

### Can `filter()` return an empty array?

---

### Does `filter()` stop after finding one match?

---

### Why is `filter()` considered a Higher-Order Function?

---

# 14. Coding Exercises

### Exercise 1

Return all numbers greater than 50.

---

### Exercise 2

Return all even numbers.

---

### Exercise 3

Predict the output.

```js
const arr = [2,4,5];

const result = arr.filter(

    num => true

);

console.log(result);
```

---

### Exercise 4

Predict the output.

```js
const arr = [2,4,5];

const result = arr.filter(

    num => false

);

console.log(result);
```

---

### Exercise 5

Explain why this returns an empty array.

```js
const arr = [10,20];

const result = arr.filter(

    num => {

        num > 15;

    }

);
```

---

# 15. Summary

- `filter()` executes its callback once for every element.
- The callback receives `element`, `index`, and the original `array`.
- Truthy values keep an element.
- Falsy values discard an element.
- The callback should return a boolean expression.
- `filter()` always returns a **new array**.
- The original array remains unchanged.

---

# Next Part

➡️ **Part 3 – filter() with Objects, Strings, Multiple Conditions & Real-World Examples**

You'll learn:

- Filtering Objects
- Filtering Strings
- Multiple Conditions (`&&`, `||`)
- Nested Arrays
- Chaining with `map()`
- React Examples
- Node.js Examples
- Real-world Use Cases
- Object References
- Practical Interview Problems


# filter()

# Part 3 – filter() with Objects, Strings, Multiple Conditions & Real-World Examples

> **"`filter()` becomes truly powerful when working with objects, strings, API responses, and multiple conditions. It allows us to select exactly the data we need while leaving the original data untouched."**

---

# Table of Contents

1. Filtering Objects
2. Returning Matching Objects
3. Multiple Conditions
4. Filtering Strings
5. Filtering Nested Arrays
6. Chaining with `filter()`
7. Real-world Examples
8. React Examples
9. Node.js Examples
10. Best Practices
11. Common Mistakes
12. Interview Questions
13. Coding Exercises
14. Summary

---

# 1. Filtering Objects

One of the most common uses of `filter()` is selecting objects from an array.

Example

```js
const students = [

    {

        name: "Om",

        marks: 92

    },

    {

        name: "Raj",

        marks: 70

    },

    {

        name: "Amit",

        marks: 85

    }

];

const toppers = students.filter(

    student => student.marks >= 80

);

console.log(toppers);
```

Output

```js
[
    {
        name:"Om",
        marks:92
    },
    {
        name:"Amit",
        marks:85
    }
]
```

---

# 2. Returning Matching Objects

Unlike `map()`,

`filter()` returns the **entire object**, not just one property.

Example

```js
const users = [

    {

        id:1,

        name:"Om",

        active:true

    },

    {

        id:2,

        name:"Raj",

        active:false

    }

];

const activeUsers = users.filter(

    user => user.active

);

console.log(activeUsers);
```

Output

```js
[
    {
        id:1,
        name:"Om",
        active:true
    }
]
```

---

# 3. Multiple Conditions

Use **AND (`&&`)**

```js
const employees = [

    {

        name:"Om",

        age:24,

        salary:50000

    },

    {

        name:"Raj",

        age:20,

        salary:30000

    },

    {

        name:"Amit",

        age:30,

        salary:60000

    }

];

const result = employees.filter(

    employee =>

        employee.age >= 25 &&

        employee.salary >= 50000

);

console.log(result);
```

Output

```js
[
{
name:"Amit",
age:30,
salary:60000
}
]
```

---

Use **OR (`||`)**

```js
const result = employees.filter(

    employee =>

        employee.salary >= 60000 ||

        employee.age <= 20

);

console.log(result);
```

Output

```js
[
{
name:"Raj",
age:20,
salary:30000
},

{
name:"Amit",
age:30,
salary:60000
}
]
```

---

# 4. Filtering Strings

Example

```js
const fruits = [

    "Apple",

    "Banana",

    "Kiwi",

    "Mango"

];

const longNames = fruits.filter(

    fruit => fruit.length > 5

);

console.log(longNames);
```

Output

```js
[
"Banana"
]
```

---

Starts With

```js
const names = [

    "Om",

    "Raj",

    "Rohan",

    "Ankit"

];

const result = names.filter(

    name => name.startsWith("R")

);

console.log(result);
```

Output

```js
[
"Raj",

"Rohan"
]
```

---

Ends With

```js
const files = [

    "index.html",

    "style.css",

    "app.js",

    "notes.txt"

];

const jsFiles = files.filter(

    file => file.endsWith(".js")

);

console.log(jsFiles);
```

Output

```js
[
"app.js"
]
```

---

# 5. Filtering Nested Arrays

Example

```js
const matrix = [

    [1,2],

    [3,4],

    [5,6],

    [7,8]

];

const result = matrix.filter(

    row => row[0] > 3

);

console.log(result);
```

Output

```js
[
[5,6],

[7,8]
]
```

---

# 6. Chaining with `filter()`

Example

```js
const numbers = [

    10,

    20,

    30,

    40,

    50

];

const result = numbers

    .filter(

        num => num >= 30

    )

    .map(

        num => num * 2

    );

console.log(result);
```

Output

```js
[
60,

80,

100
]
```

Execution

```
Array

↓

filter()

↓

Matching Elements

↓

map()

↓

Transformed Elements

↓

Result
```

---

# 7. Real-world Examples

## Shopping Cart

```js
const cart = [

    {

        product:"Laptop",

        stock:true

    },

    {

        product:"Phone",

        stock:false

    }

];

const available = cart.filter(

    item => item.stock

);

console.log(available);
```

---

## Student Pass List

```js
const students = [

    {

        name:"Om",

        marks:90

    },

    {

        name:"Raj",

        marks:35

    }

];

const passed = students.filter(

    student => student.marks >= 40

);

console.log(passed);
```

---

## Active Users

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

const activeUsers = users.filter(

    user => user.active

);

console.log(activeUsers);
```

---

# 8. React Examples

Render only active users.

```jsx
function App(){

    return(

        <ul>

            {

                users

                    .filter(

                        user => user.active

                    )

                    .map(

                        user =>

                            <li key={user.id}>

                                {user.name}

                            </li>

                    )

            }

        </ul>

    );

}
```

---

Render only completed tasks.

```jsx
todos

.filter(

    todo => todo.completed

)

.map(

    todo =>

        <Todo

            key={todo.id}

            todo={todo}

        />

);
```

---

# 9. Node.js Examples

Filter active customers.

```js
const activeCustomers = customers.filter(

    customer => customer.active

);
```

---

Filter successful orders.

```js
const successfulOrders = orders.filter(

    order => order.status === "SUCCESS"

);
```

---

Filter API response.

```js
const verifiedUsers = apiResponse.filter(

    user => user.verified

);
```

---

# 10. Best Practices

✅ Return boolean expressions.

---

✅ Use meaningful variable names.

---

✅ Keep callback functions small.

---

✅ Combine `filter()` with `map()` instead of writing loops.

---

✅ Avoid modifying objects inside `filter()`.

---

# 11. Common Mistakes

### Returning Objects Instead of Boolean

Wrong

```js
users.filter(

    user => ({})

);
```

This returns every object because

```js
{}
```

is truthy.

---

Correct

```js
users.filter(

    user => user.age > 20

);
```

---

### Using `filter()` to Transform Data

Wrong

```js
numbers.filter(

    num => num * 2

);
```

Use

```js
map()
```

instead.

---

### Forgetting `return`

Wrong

```js
numbers.filter(

    num => {

        num > 5;

    }

);
```

Returns

```js
[]
```

---

# 12. Interview Questions

### Can `filter()` return objects?

---

### Can `filter()` return strings?

---

### Can we use multiple conditions?

---

### Difference between `find()` and `filter()`?

---

### Why is `filter()` commonly used before `map()`?

---

### Does `filter()` change object references?

---

# 13. Coding Exercises

### Exercise 1

Return students whose marks are greater than 75.

---

### Exercise 2

Return users whose age is above 18 **and** verified.

---

### Exercise 3

Return file names ending with `.js`.

---

### Exercise 4

Filter active products and then return only product names.

---

### Exercise 5

Predict the output.

```js
const users = [

    {

        name:"Om",

        age:20

    },

    {

        name:"Raj",

        age:30

    }

];

const result = users.filter(

    user => user.age > 25

);

console.log(result);
```

---

# 14. Summary

- `filter()` works with numbers, strings, objects, and nested arrays.
- It keeps elements that satisfy a condition.
- It returns the **entire matching element**, not just a property.
- Multiple conditions can be written using `&&` and `||`.
- `filter()` is commonly chained with `map()` and `reduce()`.
- It is heavily used in React for rendering filtered lists and in Node.js for processing API data.

---

# Next Part

➡️ **Part 4 – Advanced filter(), Performance, Memory, Interview Mastery & Debugging**

You'll learn:

- Performance Analysis
- Memory Behavior
- `filter()` vs `find()`
- `filter()` vs `some()`
- `filter()` vs `every()`
- Debugging
- Predict the Output
- Interview Traps
- Advanced Coding Exercises
- Quick Revision Sheet

# filter()

# Part 3 – filter() with Objects, Strings, Multiple Conditions & Real-World Examples

> **"`filter()` becomes truly powerful when working with objects, strings, API responses, and multiple conditions. It allows us to select exactly the data we need while leaving the original data untouched."**

---

# Table of Contents

1. Filtering Objects
2. Returning Matching Objects
3. Multiple Conditions
4. Filtering Strings
5. Filtering Nested Arrays
6. Chaining with `filter()`
7. Real-world Examples
8. React Examples
9. Node.js Examples
10. Best Practices
11. Common Mistakes
12. Interview Questions
13. Coding Exercises
14. Summary

---

# 1. Filtering Objects

One of the most common uses of `filter()` is selecting objects from an array.

Example

```js
const students = [

    {

        name: "Om",

        marks: 92

    },

    {

        name: "Raj",

        marks: 70

    },

    {

        name: "Amit",

        marks: 85

    }

];

const toppers = students.filter(

    student => student.marks >= 80

);

console.log(toppers);
```

Output

```js
[
    {
        name:"Om",
        marks:92
    },
    {
        name:"Amit",
        marks:85
    }
]
```

---

# 2. Returning Matching Objects

Unlike `map()`,

`filter()` returns the **entire object**, not just one property.

Example

```js
const users = [

    {

        id:1,

        name:"Om",

        active:true

    },

    {

        id:2,

        name:"Raj",

        active:false

    }

];

const activeUsers = users.filter(

    user => user.active

);

console.log(activeUsers);
```

Output

```js
[
    {
        id:1,
        name:"Om",
        active:true
    }
]
```

---

# 3. Multiple Conditions

Use **AND (`&&`)**

```js
const employees = [

    {

        name:"Om",

        age:24,

        salary:50000

    },

    {

        name:"Raj",

        age:20,

        salary:30000

    },

    {

        name:"Amit",

        age:30,

        salary:60000

    }

];

const result = employees.filter(

    employee =>

        employee.age >= 25 &&

        employee.salary >= 50000

);

console.log(result);
```

Output

```js
[
{
name:"Amit",
age:30,
salary:60000
}
]
```

---

Use **OR (`||`)**

```js
const result = employees.filter(

    employee =>

        employee.salary >= 60000 ||

        employee.age <= 20

);

console.log(result);
```

Output

```js
[
{
name:"Raj",
age:20,
salary:30000
},

{
name:"Amit",
age:30,
salary:60000
}
]
```

---

# 4. Filtering Strings

Example

```js
const fruits = [

    "Apple",

    "Banana",

    "Kiwi",

    "Mango"

];

const longNames = fruits.filter(

    fruit => fruit.length > 5

);

console.log(longNames);
```

Output

```js
[
"Banana"
]
```

---

Starts With

```js
const names = [

    "Om",

    "Raj",

    "Rohan",

    "Ankit"

];

const result = names.filter(

    name => name.startsWith("R")

);

console.log(result);
```

Output

```js
[
"Raj",

"Rohan"
]
```

---

Ends With

```js
const files = [

    "index.html",

    "style.css",

    "app.js",

    "notes.txt"

];

const jsFiles = files.filter(

    file => file.endsWith(".js")

);

console.log(jsFiles);
```

Output

```js
[
"app.js"
]
```

---

# 5. Filtering Nested Arrays

Example

```js
const matrix = [

    [1,2],

    [3,4],

    [5,6],

    [7,8]

];

const result = matrix.filter(

    row => row[0] > 3

);

console.log(result);
```

Output

```js
[
[5,6],

[7,8]
]
```

---

# 6. Chaining with `filter()`

Example

```js
const numbers = [

    10,

    20,

    30,

    40,

    50

];

const result = numbers

    .filter(

        num => num >= 30

    )

    .map(

        num => num * 2

    );

console.log(result);
```

Output

```js
[
60,

80,

100
]
```

Execution

```
Array

↓

filter()

↓

Matching Elements

↓

map()

↓

Transformed Elements

↓

Result
```

---

# 7. Real-world Examples

## Shopping Cart

```js
const cart = [

    {

        product:"Laptop",

        stock:true

    },

    {

        product:"Phone",

        stock:false

    }

];

const available = cart.filter(

    item => item.stock

);

console.log(available);
```

---

## Student Pass List

```js
const students = [

    {

        name:"Om",

        marks:90

    },

    {

        name:"Raj",

        marks:35

    }

];

const passed = students.filter(

    student => student.marks >= 40

);

console.log(passed);
```

---

## Active Users

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

const activeUsers = users.filter(

    user => user.active

);

console.log(activeUsers);
```

---

# 8. React Examples

Render only active users.

```jsx
function App(){

    return(

        <ul>

            {

                users

                    .filter(

                        user => user.active

                    )

                    .map(

                        user =>

                            <li key={user.id}>

                                {user.name}

                            </li>

                    )

            }

        </ul>

    );

}
```

---

Render only completed tasks.

```jsx
todos

.filter(

    todo => todo.completed

)

.map(

    todo =>

        <Todo

            key={todo.id}

            todo={todo}

        />

);
```

---

# 9. Node.js Examples

Filter active customers.

```js
const activeCustomers = customers.filter(

    customer => customer.active

);
```

---

Filter successful orders.

```js
const successfulOrders = orders.filter(

    order => order.status === "SUCCESS"

);
```

---

Filter API response.

```js
const verifiedUsers = apiResponse.filter(

    user => user.verified

);
```

---

# 10. Best Practices

✅ Return boolean expressions.

---

✅ Use meaningful variable names.

---

✅ Keep callback functions small.

---

✅ Combine `filter()` with `map()` instead of writing loops.

---

✅ Avoid modifying objects inside `filter()`.

---

# 11. Common Mistakes

### Returning Objects Instead of Boolean

Wrong

```js
users.filter(

    user => ({})

);
```

This returns every object because

```js
{}
```

is truthy.

---

Correct

```js
users.filter(

    user => user.age > 20

);
```

---

### Using `filter()` to Transform Data

Wrong

```js
numbers.filter(

    num => num * 2

);
```

Use

```js
map()
```

instead.

---

### Forgetting `return`

Wrong

```js
numbers.filter(

    num => {

        num > 5;

    }

);
```

Returns

```js
[]
```

---

# 12. Interview Questions

### Can `filter()` return objects?

---

### Can `filter()` return strings?

---

### Can we use multiple conditions?

---

### Difference between `find()` and `filter()`?

---

### Why is `filter()` commonly used before `map()`?

---

### Does `filter()` change object references?

---

# 13. Coding Exercises

### Exercise 1

Return students whose marks are greater than 75.

---

### Exercise 2

Return users whose age is above 18 **and** verified.

---

### Exercise 3

Return file names ending with `.js`.

---

### Exercise 4

Filter active products and then return only product names.

---

### Exercise 5

Predict the output.

```js
const users = [

    {

        name:"Om",

        age:20

    },

    {

        name:"Raj",

        age:30

    }

];

const result = users.filter(

    user => user.age > 25

);

console.log(result);
```

---

# 14. Summary

- `filter()` works with numbers, strings, objects, and nested arrays.
- It keeps elements that satisfy a condition.
- It returns the **entire matching element**, not just a property.
- Multiple conditions can be written using `&&` and `||`.
- `filter()` is commonly chained with `map()` and `reduce()`.
- It is heavily used in React for rendering filtered lists and in Node.js for processing API data.

---

# Next Part

➡️ **Part 4 – Advanced filter(), Performance, Memory, Interview Mastery & Debugging**

You'll learn:

- Performance Analysis
- Memory Behavior
- `filter()` vs `find()`
- `filter()` vs `some()`
- `filter()` vs `every()`
- Debugging
- Predict the Output
- Interview Traps
- Advanced Coding Exercises
- Quick Revision Sheet

# filter()

# Part 4 – Advanced `filter()`, Performance, Memory, Interview Mastery & Debugging

> **"Mastering `filter()` means understanding not only how to write conditions, but also how JavaScript processes arrays internally, manages memory, and how `filter()` compares with other array methods."**

---

# Table of Contents

1. Advanced Filtering
2. Performance Considerations
3. Memory Behavior
4. `filter()` vs Other Array Methods
5. Debugging `filter()`
6. Predict the Output
7. Interview Traps
8. Best Practices
9. Common Mistakes
10. Interview Questions
11. Coding Exercises
12. Quick Revision Sheet
13. Summary

---

# 1. Advanced Filtering

## Multiple Conditions

```js
const students = [

    {

        name: "Om",

        marks: 92,

        age: 22

    },

    {

        name: "Raj",

        marks: 75,

        age: 19

    },

    {

        name: "Amit",

        marks: 88,

        age: 24

    }

];

const result = students.filter(

    student =>

        student.marks >= 80 &&

        student.age >= 21

);

console.log(result);
```

Output

```js
[
    {
        name:"Om",
        marks:92,
        age:22
    },
    {
        name:"Amit",
        marks:88,
        age:24
    }
]
```

---

## Negating Conditions

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

const inactiveUsers = users.filter(

    user => !user.active

);

console.log(inactiveUsers);
```

Output

```js
[
{
name:"Raj",
active:false
}
]
```

---

# 2. Performance Considerations

Every call to `filter()`:

- visits every element
- executes the callback
- checks the condition
- creates a new array

Time Complexity

```
O(n)
```

Space Complexity

```
O(n)
```

because a new array is created.

---

Large Array Example

```
1 Million Elements

↓

filter()

↓

1 Million Condition Checks

↓

New Array Created
```

Although `filter()` is efficient,

it still performs one callback execution per element.

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
filtered

↓

Memory B

↓

[20,30]
```

Different arrays

```
Memory A

≠

Memory B
```

Original array remains unchanged.

---

Objects

```js
const users = [

    {

        name:"Om"

    }

];

const result = users.filter(

    user => true

);
```

Memory

```
users

↓

Memory A

↓

Object X

------------

result

↓

Memory B

↓

Object X
```

Both arrays reference the same object.

Changing

```js
result[0].name = "Raj";
```

also changes

```js
users[0].name
```

If you need separate objects,

combine `filter()` with `map()`.

```js
const result = users

.filter(

    user => user.active

)

.map(

    user => ({

        ...user

    })

);
```

---

# 4. `filter()` vs Other Array Methods

| Method | Returns | Purpose |
|---------|----------|----------|
| `filter()` | New Array | Keep matching elements |
| `find()` | First Element | Search |
| `findIndex()` | Index | Search Position |
| `some()` | Boolean | At Least One Match |
| `every()` | Boolean | All Match |
| `map()` | New Array | Transform |
| `reduce()` | Single Value | Aggregate |
| `forEach()` | `undefined` | Side Effects |

---

## `filter()` vs `find()`

`filter()`

```js
const result = users.filter(

    user => user.age > 18

);
```

Returns

```js
[
...
]
```

---

`find()`

```js
const result = users.find(

    user => user.age > 18

);
```

Returns

```js
{
...
}
```

Only the first match.

---

## `filter()` vs `some()`

`filter()`

```
Returns Array
```

---

`some()`

```
Returns Boolean
```

---

## `filter()` vs `every()`

`filter()`

```
Returns Matching Elements
```

---

`every()`

```
Checks Whether All Match
```

---

# 5. Debugging `filter()`

Wrong

```js
const result = [1,2,3].filter(

    num => {

        num > 1;

    }

);

console.log(result);
```

Output

```js
[]
```

Reason

```
No Return Statement
```

---

Correct

```js
const result = [1,2,3].filter(

    num => {

        return num > 1;

    }

);
```

Output

```js
[
2,
3
]
```

---

Debug Callback

```js
numbers.filter(

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
const arr = [2,4,6];

const result = arr.filter(

    num => true

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

## Example 2

```js
const arr = [2,4,6];

const result = arr.filter(

    num => false

);

console.log(result);
```

Output

```js
[]
```

---

## Example 3

```js
const arr = [10,20,30];

const result = arr.filter(

    num => num > 15

);

console.log(result);
```

Output

```js
[
20,
30
]
```

---

# 7. Interview Traps

## Trap 1

Does `filter()` stop after finding one match?

```
No
```

It checks every element.

---

## Trap 2

Can `filter()` return an empty array?

```
Yes
```

---

## Trap 3

Can `filter()` return the original array?

No.

It always returns a **new array**.

---

## Trap 4

Can `filter()` return objects?

```
Yes
```

---

## Trap 5

Should `filter()` be used only for side effects?

```
No
```

Use

```js
forEach()
```

instead.

---

# 8. Best Practices

✅ Return boolean expressions.

---

✅ Keep callbacks pure.

---

✅ Avoid modifying original objects.

---

✅ Chain with `map()` and `reduce()` when appropriate.

---

✅ Use descriptive variable names.

---

# 9. Common Mistakes

### Forgetting `return`

Wrong

```js
numbers.filter(

    num => {

        num > 5;

    }

);
```

Returns

```js
[]
```

---

### Returning Numbers

```js
numbers.filter(

    num => 1

);
```

Technically works because

```
1

↓

Truthy
```

Prefer

```js
num > 5
```

instead.

---

### Using `filter()` Instead of `find()`

Wrong

```js
users.filter(

    user => user.id === 5

)[0]
```

Better

```js
users.find(

    user => user.id === 5

);
```

---

# 10. Interview Questions

### What is the time complexity of `filter()`?

---

### What is the space complexity?

---

### Does `filter()` modify the original array?

---

### Why does `filter()` return a new array?

---

### Difference between `filter()` and `find()`?

---

### Difference between `filter()` and `some()`?

---

### Difference between `filter()` and `every()`?

---

### Can `filter()` return objects?

---

# 11. Coding Exercises

### Exercise 1

Return students older than 20.

---

### Exercise 2

Return users whose salary is above 50,000.

---

### Exercise 3

Filter active users and return only their names.

---

### Exercise 4

Predict the output.

```js
const arr = [1,2,3];

const result = arr.filter(

    num => true

);

console.log(result);
```

---

### Exercise 5

Explain why this returns an empty array.

```js
const arr = [10,20];

const result = arr.filter(

    num => {

        num > 10;

    }

);
```

---

# 12. Quick Revision Sheet

```
filter()

↓

Visit Every Element

↓

Run Callback

↓

Truthy?

↓

Keep

↓

Falsy?

↓

Discard

↓

Return New Array
```

Remember

```
Transform

↓

map()

Select

↓

filter()

Find One

↓

find()

Aggregate

↓

reduce()

Loop Only

↓

forEach()
```

---

# 13. Summary

- `filter()` checks every element in an array.
- It keeps elements whose callback returns a truthy value.
- It always returns a new array.
- Time Complexity is **O(n)**.
- Space Complexity is **O(n)**.
- Object references remain shared unless copied later.
- `filter()` is commonly combined with `map()` and `reduce()`.
- It is one of the most important array methods for React, Node.js, and coding interviews.

---

# Chapter Complete ✅

You now understand:

- ✔ What `filter()` is
- ✔ Internal Working
- ✔ Callback Function
- ✔ Truthy & Falsy
- ✔ Memory Behavior
- ✔ Object References
- ✔ Performance
- ✔ React Usage
- ✔ Node.js Usage
- ✔ Interview Questions
- ✔ Common Mistakes
- ✔ Best Practices
- ✔ Coding Exercises

---

# What's Next?

➡️ **04-find.md**

You'll master:

- What `find()` is
- Internal Working
- Callback Function
- Search Operations
- `find()` vs `filter()`
- `find()` vs `findIndex()`
- Objects & Arrays
- React & Node.js Examples
- Interview Questions
- Coding Exercises
- Memory Behavior
- Performance Analysis
```