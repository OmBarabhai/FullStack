# map()

# Part 1 – Introduction & Fundamentals

> **"`map()` is one of the most important array methods in JavaScript. It creates a new array by transforming every element of an existing array without modifying the original array."**

---

# Table of Contents

1. Introduction
2. Why `map()` Was Introduced
3. Syntax
4. Parameters
5. Return Value
6. Internal Working
7. Visualization
8. Memory Behavior
9. First Examples
10. `map()` vs `for` Loop
11. Best Practices
12. Common Mistakes
13. Interview Questions
14. Coding Exercises
15. Summary

---

# 1. Introduction

Imagine you have an array of numbers.

```js
const numbers = [1, 2, 3, 4];
```

Now you want every number multiplied by 2.

Expected Output

```js
[2, 4, 6, 8]
```

Instead of writing a loop manually, JavaScript provides **`map()`**.

```js
const numbers = [1, 2, 3, 4];

const doubled = numbers.map(num => num * 2);

console.log(doubled);
```

Output

```js
[2, 4, 6, 8]
```

---

# 2. Why `map()` Was Introduced

Before ES5, developers used loops for every transformation.

Example

```js
const numbers = [1, 2, 3];

const result = [];

for (let i = 0; i < numbers.length; i++) {

    result.push(numbers[i] * 2);

}

console.log(result);
```

Problems

- More code
- Manual array creation
- Easy to make mistakes
- Less readable

---

Using `map()`

```js
const numbers = [1, 2, 3];

const result = numbers.map(num => num * 2);

console.log(result);
```

Cleaner, shorter, and easier to read.

---

# 3. Syntax

```js
array.map(callback)
```

or

```js
array.map(function(currentValue) {

});
```

Most common syntax

```js
array.map(element => {

});
```

---

# 4. Parameters

The callback function can receive three parameters.

```js
array.map((element, index, array) => {

});
```

| Parameter | Description |
|-----------|-------------|
| `element` | Current element being processed |
| `index` | Current index |
| `array` | Original array |

---

Example

```js
const numbers = [10, 20, 30];

numbers.map((value, index) => {

    console.log(value, index);

});
```

Output

```
10 0

20 1

30 2
```

---

# 5. Return Value

`map()` **always returns a new array**.

Example

```js
const numbers = [1, 2, 3];

const result = numbers.map(num => num * 5);

console.log(result);
```

Output

```js
[5, 10, 15]
```

Original array

```js
console.log(numbers);
```

Output

```js
[1, 2, 3]
```

The original array is **not modified**.

---

# 6. Internal Working

Suppose we have

```js
const numbers = [2, 4, 6];
```

Execution

```
map()

↓

Take First Element

↓

Run Callback

↓

Store Returned Value

↓

Next Element

↓

Run Callback

↓

Store Returned Value

↓

Repeat Until End

↓

Return New Array
```

---

Example

```js
const numbers = [2, 4, 6];

const result = numbers.map(num => num + 1);

console.log(result);
```

Output

```js
[3, 5, 7]
```

---

# 7. Visualization

```
Original Array

↓

[1,2,3]

↓

map()

↓

1 → 2

2 → 4

3 → 6

↓

New Array

↓

[2,4,6]
```

Notice:

```
Original Array

↓

Unchanged
```

---

# 8. Memory Behavior

Original Array

```
numbers

↓

[1,2,3]
```

`map()` creates

```
New Array

↓

[2,4,6]
```

Memory

```
numbers

↓

Memory A

------------

result

↓

Memory B
```

Different memory locations.

That is why changing one does not affect the other.

---

# 9. First Examples

## Example 1

Multiply by 3

```js
const numbers = [1, 2, 3];

const result = numbers.map(num => num * 3);

console.log(result);
```

Output

```js
[3, 6, 9]
```

---

## Example 2

Convert to Strings

```js
const numbers = [1, 2, 3];

const result = numbers.map(num => String(num));

console.log(result);
```

Output

```js
["1","2","3"]
```

---

## Example 3

Square Numbers

```js
const numbers = [2, 4, 6];

const squares = numbers.map(num => num * num);

console.log(squares);
```

Output

```js
[4,16,36]
```

---

# 10. `map()` vs `for` Loop

Using `for`

```js
const result = [];

for (let i = 0; i < numbers.length; i++) {

    result.push(numbers[i] * 2);

}
```

---

Using `map()`

```js
const result = numbers.map(num => num * 2);
```

Comparison

| `for` Loop | `map()` |
|------------|----------|
| More code | Less code |
| Manual array | Automatic new array |
| Easy to make mistakes | Cleaner |
| More readable? ❌ | More readable ✅ |

---

# 11. Best Practices

✅ Use `map()` when you want to transform every element.

✅ Always return something from the callback.

✅ Prefer Arrow Functions for simple transformations.

✅ Don't modify the original array inside `map()`.

---

# 12. Common Mistakes

### Forgetting to return

Wrong

```js
const numbers = [1, 2, 3];

const result = numbers.map(num => {

    num * 2;

});
```

Output

```js
[undefined, undefined, undefined]
```

---

Correct

```js
const result = numbers.map(num => num * 2);
```

---

### Using `map()` when you only need a loop

If you don't need the returned array,

use

```js
forEach()
```

instead.

---

# 13. Interview Questions

### What is `map()`?

---

### Does `map()` modify the original array?

---

### What does `map()` return?

---

### Can `map()` change object properties?

---

### Difference between `map()` and `forEach()`?

---

# 14. Coding Exercises

### Exercise 1

Multiply every number by 10.

```js
const numbers = [1,2,3];
```

---

### Exercise 2

Convert

```js
[1,2,3]
```

into

```js
["1","2","3"]
```

---

### Exercise 3

Return the square of every number.

---

### Exercise 4

Predict the output.

```js
const arr = [2,4];

const result = arr.map(num => num + 5);

console.log(result);
```

---

### Exercise 5

Explain why the original array doesn't change after using `map()`.

---

# 15. Summary

- `map()` transforms every element of an array.
- It always returns a **new array**.
- The original array remains unchanged.
- It is one of the most frequently used array methods in JavaScript.
- It is widely used in React, Node.js, and coding interviews.

---

# Next Part

➡️ **Part 2 – Callback Function, Internal Working & Execution Flow**

You'll learn:

- Callback Functions
- Step-by-Step Execution
- How JavaScript Executes `map()`
- Memory Diagram
- Callback Parameters in Detail
- Dry Runs
- Visualizations


# map()

# Part 2 – Callback Function, Internal Working & Execution Flow

> **"The real power of `map()` comes from its callback function. JavaScript calls this callback once for every element in the array, collects the returned values, and builds a completely new array."**

---

# Table of Contents

1. Callback Function
2. Why Callback Functions?
3. Callback Parameters
4. Step-by-Step Execution
5. Dry Run
6. Memory Visualization
7. Execution Flow
8. Return Value
9. Different Callback Styles
10. Best Practices
11. Common Mistakes
12. Interview Questions
13. Coding Exercises
14. Summary

---

# 1. Callback Function

The function passed inside `map()` is called a **Callback Function**.

Example

```js
const numbers = [1, 2, 3];

const result = numbers.map(num => num * 2);

console.log(result);
```

Here,

```js
num => num * 2
```

is the callback.

---

# 2. Why Callback Functions?

Instead of JavaScript deciding how to transform each element,

**you tell JavaScript what to do.**

Think of `map()` like this:

```
map()

↓

"I will visit every element."

↓

"You tell me what to do."

↓

Return New Array
```

Example

```js
const numbers = [10,20,30];

const result = numbers.map(

    num => num + 5

);

console.log(result);
```

Output

```js
[15,25,35]
```

---

# 3. Callback Parameters

The callback receives three parameters.

```js
array.map(

    (element, index, array) => {

    }

);
```

---

## First Parameter

Current Element

```js
const numbers = [10,20,30];

numbers.map(

    element => {

        console.log(element);

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

numbers.map(

    (element,index) => {

        console.log(index);

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

numbers.map(

    (element,index,array)=>{

        console.log(array);

    }

);
```

Output

```
[10,20,30]

[10,20,30]

[10,20,30]
```

Notice

The third parameter always refers to the original array.

---

# 4. Step-by-Step Execution

Example

```js
const numbers = [2,4,6];

const result = numbers.map(

    num => num * 3

);

console.log(result);
```

---

### Step 1

Original Array

```
[2,4,6]
```

---

### Step 2

Take first element

```
2
```

Callback

```js
2 * 3
```

Returns

```
6
```

Store

```
[6]
```

---

### Step 3

Take second element

```
4
```

Callback

```js
4 * 3
```

Returns

```
12
```

Store

```
[6,12]
```

---

### Step 4

Take third element

```
6
```

Callback

```js
6 * 3
```

Returns

```
18
```

Store

```
[6,12,18]
```

---

### Step 5

Return final array

```js
[6,12,18]
```

---

# 5. Dry Run

Example

```js
const numbers = [1,2,3];

const doubled = numbers.map(

    num => num * 2

);
```

Iteration 1

```
num = 1

↓

1 × 2

↓

2
```

---

Iteration 2

```
num = 2

↓

2 × 2

↓

4
```

---

Iteration 3

```
num = 3

↓

3 × 2

↓

6
```

---

Final Result

```js
[2,4,6]
```

---

# 6. Memory Visualization

Original

```
numbers

↓

Memory A

↓

[1,2,3]
```

---

During map()

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
Memory B

↓

[2]
```

---

Iteration 2

```
Memory B

↓

[2,4]
```

---

Iteration 3

```
Memory B

↓

[2,4,6]
```

---

Return

```
result

↓

Memory B

↓

[2,4,6]
```

Original array

```
Memory A

↓

Still Same
```

---

# 7. Execution Flow

```
Array

↓

map()

↓

First Element

↓

Callback

↓

Return Value

↓

Store

↓

Second Element

↓

Callback

↓

Store

↓

Third Element

↓

Callback

↓

Store

↓

Return New Array
```

---

# 8. Return Value

The callback **must return a value**.

Correct

```js
const numbers = [1,2,3];

const result = numbers.map(

    num => num * 2

);

console.log(result);
```

Output

```js
[2,4,6]
```

---

Wrong

```js
const numbers = [1,2,3];

const result = numbers.map(

    num => {

        num * 2;

    }

);

console.log(result);
```

Output

```js
[undefined,undefined,undefined]
```

Because nothing was returned.

---

# 9. Different Callback Styles

## Arrow Function

```js
numbers.map(

    num => num * 2

);
```

---

## Arrow Function with Braces

```js
numbers.map(

    num => {

        return num * 2;

    }

);
```

---

## Normal Function

```js
numbers.map(

    function(num){

        return num * 2;

    }

);
```

All three produce the same output.

---

# 10. Best Practices

✅ Use arrow functions for simple transformations.

✅ Always return a value.

✅ Keep callback functions small.

✅ Give meaningful parameter names.

Example

```js
price

student

product

user
```

instead of

```js
x

y

z
```

---

# 11. Common Mistakes

### Forgetting `return`

Wrong

```js
numbers.map(

    num => {

        num + 1;

    }

);
```

Output

```js
[undefined,undefined,...]
```

---

Correct

```js
numbers.map(

    num => {

        return num + 1;

    }

);
```

---

### Modifying Original Array

Avoid

```js
numbers.map(

    num => {

        numbers[0] = 100;

        return num;

    }

);
```

Keep callbacks pure whenever possible.

---

# 12. Interview Questions

### What is a callback function?

---

### How many times does `map()` execute the callback?

---

### What happens if the callback doesn't return anything?

---

### What are the three callback parameters?

---

### Does `map()` modify the original array?

---

### Why is `map()` considered a Higher-Order Function?

---

# 13. Coding Exercises

### Exercise 1

Print every element and its index.

---

### Exercise 2

Convert

```js
[10,20,30]
```

into

```js
[15,25,35]
```

---

### Exercise 3

Return the square of every number.

---

### Exercise 4

Predict the output.

```js
const arr = [2,4];

const result = arr.map(

    num => {

        return num + 1;

    }

);

console.log(result);
```

---

### Exercise 5

Explain why this returns

```js
[undefined,undefined]
```

```js
const arr = [1,2];

const result = arr.map(

    num => {

        num * 5;

    }

);
```

---

# 14. Summary

- `map()` executes its callback once for every element.
- The callback receives `element`, `index`, and the original `array`.
- The callback **must return a value**.
- Every returned value is placed into a **new array**.
- The original array remains unchanged.
- Understanding the callback is the key to mastering `map()`.

---

# Next Part

➡️ **Part 3 – map() with Objects, Strings, Arrays & Real-World Examples**

You'll learn:

- Mapping Objects
- Mapping Arrays
- Mapping Strings
- Creating New Objects
- Data Transformation
- API Response Processing
- React Examples
- Node.js Examples
- Practical Use Cases


# map()

# Part 3 – map() with Objects, Strings, Arrays & Real-World Examples

> **"`map()` is not limited to numbers. It can transform objects, strings, nested arrays, and API data. This makes it one of the most powerful and frequently used methods in modern JavaScript."**

---

# Table of Contents

1. Mapping Objects
2. Creating New Objects
3. Transforming Object Properties
4. Mapping Strings
5. Mapping Nested Arrays
6. Chaining with `map()`
7. Real-world Examples
8. React Examples
9. Node.js Examples
10. Best Practices
11. Common Mistakes
12. Interview Questions
13. Coding Exercises
14. Summary

---

# 1. Mapping Objects

Suppose we have an array of users.

```js
const users = [

    { name: "Om", age: 22 },

    { name: "Raj", age: 25 },

    { name: "Amit", age: 20 }

];
```

We only need the names.

```js
const names = users.map(

    user => user.name

);

console.log(names);
```

Output

```js
["Om","Raj","Amit"]
```

---

Another Example

```js
const students = [

    { name: "Ankit", marks: 90 },

    { name: "Rahul", marks: 80 }

];

const marks = students.map(

    student => student.marks

);

console.log(marks);
```

Output

```js
[90,80]
```

---

# 2. Creating New Objects

`map()` can return completely new objects.

Example

```js
const users = [

    { name: "Om", age: 22 },

    { name: "Raj", age: 25 }

];

const updatedUsers = users.map(

    user => ({

        ...user,

        country: "India"

    })

);

console.log(updatedUsers);
```

Output

```js
[
    {
        name:"Om",
        age:22,
        country:"India"
    },
    {
        name:"Raj",
        age:25,
        country:"India"
    }
]
```

Original array remains unchanged.

---

# 3. Transforming Object Properties

Example

```js
const products = [

    {

        name:"Laptop",

        price:50000

    },

    {

        name:"Phone",

        price:20000

    }

];

const discounted = products.map(

    product => ({

        ...product,

        price: product.price * 0.9

    })

);

console.log(discounted);
```

Output

```js
[
    {
        name:"Laptop",
        price:45000
    },
    {
        name:"Phone",
        price:18000
    }
]
```

---

# 4. Mapping Strings

Strings are iterable.

Example

```js
const word = "JavaScript";

const characters = [...word].map(

    char => char.toUpperCase()

);

console.log(characters);
```

Output

```js
[
'J','A','V','A',
'S','C','R','I',
'P','T'
]
```

---

Convert every word to uppercase.

```js
const fruits = [

    "apple",

    "banana",

    "mango"

];

const upper = fruits.map(

    fruit => fruit.toUpperCase()

);

console.log(upper);
```

Output

```js
[
"APPLE",
"BANANA",
"MANGO"
]
```

---

# 5. Mapping Nested Arrays

Example

```js
const matrix = [

    [1,2],

    [3,4],

    [5,6]

];

const doubled = matrix.map(

    row =>

        row.map(

            value => value * 2

        )

);

console.log(doubled);
```

Output

```js
[
 [2,4],

 [6,8],

 [10,12]
]
```

---

Visualization

```
Matrix

↓

Row

↓

map()

↓

Element

↓

map()

↓

New Matrix
```

---

# 6. Chaining with `map()`

Example

```js
const numbers = [

    1,2,3,4,5

];

const result = numbers

    .filter(

        num => num % 2 === 0

    )

    .map(

        num => num * 10

    );

console.log(result);
```

Output

```js
[20,40]
```

Execution

```
Array

↓

filter()

↓

map()

↓

Result
```

---

# 7. Real-world Examples

## Example 1

Student Report

```js
const students = [

    {

        name:"Om",

        marks:90

    },

    {

        name:"Raj",

        marks:85

    }

];

const report = students.map(

    student =>

        `${student.name} scored ${student.marks}`

);

console.log(report);
```

Output

```js
[
"Om scored 90",

"Raj scored 85"
]
```

---

## Example 2

Shopping Cart

```js
const cart = [

    {

        product:"Laptop",

        price:50000

    },

    {

        product:"Mouse",

        price:1000

    }

];

const prices = cart.map(

    item => item.price

);

console.log(prices);
```

Output

```js
[50000,1000]
```

---

## Example 3

API Response

```js
const users = [

    {

        id:1,

        username:"Om"

    },

    {

        id:2,

        username:"Raj"

    }

];

const usernames = users.map(

    user => user.username

);

console.log(usernames);
```

Output

```js
["Om","Raj"]
```

---

# 8. React Examples

Rendering Lists

```jsx
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

function App(){

    return(

        <ul>

            {

                users.map(

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

This is one of the most common uses of `map()` in React.

---

Creating Cards

```jsx
products.map(

    product => (

        <Card

            key={product.id}

            product={product}

        />

    )

);
```

---

# 9. Node.js Examples

Formatting API Data

```js
const users = databaseResult.map(

    user => ({

        id:user.id,

        name:user.name

    })

);
```

---

Generating Logs

```js
const logs = users.map(

    user =>

        `User ${user.name} logged in.`

);
```

---

# 10. Best Practices

✅ Return new objects instead of modifying existing ones.

---

✅ Use object spread.

```js
{

    ...user,

    age:23

}
```

---

✅ Keep callback functions simple.

---

✅ Combine `filter()` and `map()` when appropriate.

---

# 11. Common Mistakes

### Modifying Existing Objects

Wrong

```js
users.map(

    user => {

        user.age++;

        return user;

    }

);
```

This changes the original objects.

---

Correct

```js
users.map(

    user => ({

        ...user,

        age:user.age + 1

    })

);
```

---

### Forgetting Parentheses Around Objects

Wrong

```js
users.map(

    user => {

        name:user.name

    }

);
```

Output

```js
undefined
```

---

Correct

```js
users.map(

    user => ({

        name:user.name

    })

);
```

---

# 12. Interview Questions

### Can `map()` return objects?

---

### Can `map()` return arrays?

---

### Can `map()` transform strings?

---

### Does `map()` modify original objects?

---

### Why use object spread inside `map()`?

---

### Why is `map()` heavily used in React?

---

# 13. Coding Exercises

### Exercise 1

Return only product names.

```js
const products = [

    {

        name:"Laptop",

        price:50000

    },

    {

        name:"Phone",

        price:30000

    }

];
```

---

### Exercise 2

Increase every student's marks by 5.

---

### Exercise 3

Convert

```js
["apple","banana"]
```

into uppercase.

---

### Exercise 4

Create a new property

```js
country:"India"
```

for every user.

---

### Exercise 5

Chain

```js
filter()

↓

map()
```

to return the names of students who scored above 80.

---

# 14. Summary

- `map()` works with numbers, strings, arrays, and objects.
- It can transform existing values or create completely new objects.
- It is widely used with API responses and data formatting.
- React uses `map()` extensively for rendering UI lists.
- Using object spread inside `map()` helps avoid modifying original objects.

---

# Next Part

➡️ **Part 4 – Advanced map(), Performance, Memory, Interview Mastery & Debugging**

You'll learn:

- Advanced Transformations
- Performance Considerations
- Memory Diagrams
- map() vs forEach()
- map() vs filter()
- Debugging
- Interview Traps
- Predict the Output
- Advanced Coding Exercises
- Quick Revision Sheet

# map()

# Part 4 – Advanced `map()`, Performance, Memory, Interview Mastery & Debugging

> **"Mastering `map()` is not just about syntax. It's about understanding how it behaves internally, when to use it, when not to use it, how it affects memory, and how interviewers test your understanding."**

---

# Table of Contents

1. Advanced Transformations
2. Performance Considerations
3. Memory Behavior
4. `map()` vs Other Array Methods
5. Debugging `map()`
6. Predict the Output
7. Interview Traps
8. Best Practices
9. Common Mistakes
10. Interview Questions
11. Coding Exercises
12. Quick Revision Sheet
13. Summary

---

# 1. Advanced Transformations

## Mapping Nested Objects

```js
const users = [

    {
        id: 1,
        profile: {
            name: "Om"
        }
    },

    {
        id: 2,
        profile: {
            name: "Raj"
        }
    }

];

const names = users.map(

    user => user.profile.name

);

console.log(names);
```

Output

```js
["Om","Raj"]
```

---

## Creating New Structures

```js
const users = [

    {

        name: "Om",

        age: 22

    },

    {

        name: "Raj",

        age: 25

    }

];

const result = users.map(

    user => ({

        fullName: user.name,

        isAdult: user.age >= 18

    })

);

console.log(result);
```

Output

```js
[
    {
        fullName:"Om",
        isAdult:true
    },
    {
        fullName:"Raj",
        isAdult:true
    }
]
```

---

# 2. Performance Considerations

Every call to `map()`:

- visits every element
- executes the callback
- creates a brand new array

Example

```js
const result = numbers.map(

    num => num * 2

);
```

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

Large Arrays

```
1 Million Elements

↓

map()

↓

1 Million Callback Calls

↓

New Array Created
```

Always remember:

`map()` is efficient, but it is **not free**.

---

# 3. Memory Behavior

Original

```
numbers

↓

Memory A

↓

[1,2,3]
```

After `map()`

```
result

↓

Memory B

↓

[2,4,6]
```

Original array

```
Still Exists
```

New array

```
Completely Different Memory
```

Visualization

```
Memory A

↓

[1,2,3]

------------

Memory B

↓

[2,4,6]
```

Changing

```js
result[0] = 100;
```

does **not** affect

```js
numbers
```

because both arrays are different.

---

Objects

```js
const users = [

    {

        name:"Om"

    }

];

const result = users.map(

    user => user

);
```

Both arrays contain the **same object reference**.

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

Changing

```js
result[0].name = "Raj";
```

also changes

```js
users[0].name
```

To avoid this

```js
users.map(

    user => ({

        ...user

    })

);
```

---

# 4. `map()` vs Other Array Methods

| Method | Returns | Purpose |
|---------|----------|----------|
| `map()` | New Array | Transform |
| `filter()` | New Array | Select |
| `find()` | One Element | Search |
| `findIndex()` | Number | Search Index |
| `some()` | Boolean | Any Match |
| `every()` | Boolean | All Match |
| `reduce()` | Single Value | Aggregate |
| `forEach()` | `undefined` | Side Effects |

---

## `map()` vs `forEach()`

`map()`

```js
const result = numbers.map(

    num => num * 2

);
```

Returns

```
New Array
```

---

`forEach()`

```js
numbers.forEach(

    num => console.log(num)

);
```

Returns

```
undefined
```

Use

```
map()

↓

Need New Array
```

Use

```
forEach()

↓

Need Side Effects
```

---

## `map()` vs `filter()`

`map()`

Transforms

```js
[1,2,3]

↓

[2,4,6]
```

---

`filter()`

Keeps matching elements

```js
[1,2,3,4]

↓

[2,4]
```

---

# 5. Debugging `map()`

Problem

```js
const result = [1,2,3].map(

    num => {

        num * 2;

    }

);

console.log(result);
```

Output

```js
[
undefined,
undefined,
undefined
]
```

Reason

```
No return statement
```

Correct

```js
const result = [1,2,3].map(

    num => {

        return num * 2;

    }

);
```

---

Debug Callback

```js
numbers.map(

    num => {

        console.log(num);

        return num * 2;

    }

);
```

Useful during interviews.

---

# 6. Predict the Output

## Example 1

```js
const numbers = [1,2,3];

const result = numbers.map(

    num => num + 5

);

console.log(result);
```

Output

```js
[6,7,8]
```

---

## Example 2

```js
const result = [1,2].map(

    num => {

        return;

    }

);

console.log(result);
```

Output

```js
[
undefined,
undefined
]
```

---

## Example 3

```js
const users = [

    {

        name:"Om"

    }

];

const result = users.map(

    user => ({

        ...user,

        age:22

    })

);

console.log(result);
```

Output

```js
[
{
name:"Om",
age:22
}
]
```

---

# 7. Interview Traps

## Trap 1

Does `map()` modify the original array?

Answer

```
No
```

---

## Trap 2

Can `map()` return objects?

```
Yes
```

---

## Trap 3

Can `map()` skip elements?

No.

It visits every existing element.

---

## Trap 4

Can `map()` be chained?

```
Yes

filter()

↓

map()

↓

reduce()
```

---

## Trap 5

Should `map()` be used for printing?

No.

Prefer

```js
forEach()
```

---

# 8. Best Practices

✅ Use `map()` only when a new array is required.

---

✅ Keep callback functions pure.

---

✅ Return new objects using spread.

---

✅ Use chaining carefully.

---

✅ Use meaningful variable names.

Example

```js
student

product

user

price
```

---

# 9. Common Mistakes

### Forgetting `return`

---

### Mutating existing objects

Wrong

```js
user.age++;
```

Correct

```js
{

...user,

age:user.age+1

}
```

---

### Using `map()` for side effects

Wrong

```js
numbers.map(

    num => console.log(num)

);
```

Better

```js
numbers.forEach(

    num => console.log(num)

);
```

---

# 10. Interview Questions

### Why does `map()` return a new array?

---

### What is the time complexity?

---

### What is the space complexity?

---

### Why is `map()` immutable?

---

### Difference between `map()` and `forEach()`?

---

### Difference between `map()` and `filter()`?

---

### Can `map()` return objects?

---

### Does `map()` deep copy objects?

---

# 11. Coding Exercises

### Exercise 1

Double every number.

---

### Exercise 2

Return only usernames.

---

### Exercise 3

Add

```js
country:"India"
```

to every user.

---

### Exercise 4

Chain

```js
filter()

↓

map()
```

---

### Exercise 5

Explain why

```js
users.map(

user=>user

)
```

shares object references.

---

# 12. Quick Revision Sheet

```
map()

↓

Visits Every Element

↓

Runs Callback

↓

Stores Returned Value

↓

Returns New Array

↓

Original Array Unchanged
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

- `map()` always creates a new array.
- It executes the callback once for every element.
- Time Complexity is **O(n)**.
- Space Complexity is **O(n)**.
- Primitive values are copied into the new array.
- Objects keep the same reference unless copied with the spread operator.
- `map()` is one of the most important array methods for React, Node.js, and coding interviews.
- Use `map()` for transformations, not for side effects.

---

# Chapter Complete ✅

You now understand:

- ✔ What `map()` is
- ✔ Internal Working
- ✔ Callback Function
- ✔ Execution Flow
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

➡️ **03-filter.md**

You'll master:

- How `filter()` works internally
- Callback execution
- Truthy & Falsy values
- Filtering objects
- Multiple conditions
- Memory behavior
- React & Node.js examples
- Interview questions
- Coding exercises
- Performance analysis