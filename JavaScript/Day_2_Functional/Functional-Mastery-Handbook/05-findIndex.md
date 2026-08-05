# findIndex()

# Part 1 – Introduction & Fundamentals

> **"`findIndex()` is a JavaScript array method that returns the index of the first element that satisfies a given condition. If no element matches, it returns `-1`."**

---

# Table of Contents

1. Introduction
2. Why `findIndex()` Was Introduced
3. Syntax
4. Parameters
5. Return Value
6. Internal Working
7. Visualization
8. Memory Behavior
9. First Examples
10. `findIndex()` vs `for` Loop
11. Best Practices
12. Common Mistakes
13. Interview Questions
14. Coding Exercises
15. Summary

---

# 1. Introduction

Suppose we have an array.

```js
const numbers = [10, 25, 30, 15, 40];
```

We want to know the **position** of the first number greater than **20**.

Expected Output

```js
1
```

Because

```
Index

0 → 10

1 → 25

2 → 30

3 → 15

4 → 40
```

We can use `findIndex()`.

```js
const numbers = [10, 25, 30, 15, 40];

const index = numbers.findIndex(

    num => num > 20

);

console.log(index);
```

Output

```js
1
```

Notice

It returns

```js
1
```

NOT

```js
25
```

---

# 2. Why `findIndex()` Was Introduced

Before ES6,

developers manually searched for an element's position.

```js
const numbers = [10,25,30];

let index = -1;

for(let i=0;i<numbers.length;i++){

    if(numbers[i] > 20){

        index = i;

        break;

    }

}

console.log(index);
```

Problems

- Manual loop
- Manual index tracking
- Manual `break`
- More code

---

Using `findIndex()`

```js
const index = numbers.findIndex(

    num => num > 20

);

console.log(index);
```

Much cleaner.

---

# 3. Syntax

```js
array.findIndex(callback)
```

Example

```js
array.findIndex(

    element => {

    }

);
```

---

# 4. Parameters

The callback receives three parameters.

```js
array.findIndex(

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

numbers.findIndex(

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

If a match is found

↓

Return its index.

Example

```js
const numbers = [5,10,15];

const index = numbers.findIndex(

    num => num > 10

);

console.log(index);
```

Output

```js
2
```

---

If no match exists

↓

Return

```js
-1
```

Example

```js
const numbers = [5,10,15];

const index = numbers.findIndex(

    num => num > 100

);

console.log(index);
```

Output

```js
-1
```

---

# 6. Internal Working

Suppose

```js
const numbers = [5,10,15,20];
```

Execution

```
findIndex()

↓

Take First Element

↓

Condition?

↓

true

↓

Return Index

↓

Stop

----------------

false

↓

Next Element
```

Unlike `filter()`,

`findIndex()` stops after the first match.

---

Example

```js
const numbers = [5,10,15,20];

const index = numbers.findIndex(

    num => num > 10

);

console.log(index);
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

false

↓

Continue

------------

15

↓

true

↓

Return Index

↓

2

↓

Stop
```

Output

```js
2
```

---

# 7. Visualization

```
Array

↓

[5,10,15,20]

↓

findIndex()

↓

Index 0

↓

5

↓

false

↓

Continue

------------

Index 1

↓

10

↓

false

↓

Continue

------------

Index 2

↓

15

↓

true

↓

Return

↓

2

↓

Stop
```

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
index

↓

2
```

Unlike

```
map()

filter()
```

No new array is created.

Only a number is returned.

---

# 9. First Examples

## Example 1

Find First Even Number Index

```js
const numbers = [1,3,5,8,10];

const index = numbers.findIndex(

    num => num % 2 === 0

);

console.log(index);
```

Output

```js
3
```

---

## Example 2

Find First Negative Number

```js
const numbers = [5,10,-3,-8];

const index = numbers.findIndex(

    num => num < 0

);

console.log(index);
```

Output

```js
2
```

---

## Example 3

Find First Long String

```js
const fruits = [

    "Apple",

    "Banana",

    "Watermelon",

    "Kiwi"

];

const index = fruits.findIndex(

    fruit => fruit.length > 6

);

console.log(index);
```

Output

```js
2
```

---

# 10. `findIndex()` vs `for` Loop

Using `for`

```js
let index = -1;

for(let i=0;i<numbers.length;i++){

    if(numbers[i] > 20){

        index = i;

        break;

    }

}
```

---

Using `findIndex()`

```js
const index = numbers.findIndex(

    num => num > 20

);
```

Comparison

| `for` Loop | `findIndex()` |
|------------|---------------|
| Manual loop | Automatic |
| Manual index | Returns index |
| Manual break | Stops automatically |
| More code | Cleaner |

---

# 11. Best Practices

✅ Use `findIndex()` when you need the position of an element.

✅ Return boolean expressions.

✅ Use descriptive variable names.

✅ Use `find()` if you need the element instead.

---

# 12. Common Mistakes

### Confusing `find()` and `findIndex()`

Wrong Expectation

```js
const index = numbers.findIndex(

    num => num > 20

);

console.log(index);
```

Expecting

```js
25
```

Actual

```js
1
```

---

### Forgetting `return`

Wrong

```js
numbers.findIndex(

    num => {

        num > 20;

    }

);
```

Output

```js
-1
```

---

### Expecting an Array

Wrong

```js
const result = numbers.findIndex(

    num => num > 20

);

console.log(result.length);
```

`findIndex()` returns a number,

not an array.

---

# 13. Interview Questions

### What is `findIndex()`?

---

### What does `findIndex()` return?

---

### What happens if no match exists?

---

### Does `findIndex()` return an element?

---

### Does `findIndex()` stop after the first match?

---

# 14. Coding Exercises

### Exercise 1

Find the index of the first even number.

---

### Exercise 2

Find the index of the first student whose marks are above 90.

---

### Exercise 3

Predict the output.

```js
const arr = [5,10,15];

const index = arr.findIndex(

    num => num > 8

);

console.log(index);
```

---

### Exercise 4

Find the index of the first string longer than 5 characters.

---

### Exercise 5

Explain why this returns `-1`.

```js
numbers.findIndex(

    num => {

        num > 5;

    }

);
```

---

# 15. Summary

- `findIndex()` returns the **index** of the first matching element.
- It stops searching after the first match.
- It returns `-1` if no match exists.
- It does not return the element itself.
- It does not modify the original array.
- It does not create a new array.

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

# findIndex()

# Part 2 – Callback Function, Internal Working, Execution Flow & Truthy/Falsy

> **"`findIndex()` executes a callback function for every element in an array until the callback returns a truthy value. The moment a match is found, it returns that element's index and immediately stops searching."**

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

The function passed to `findIndex()` is called the **Callback Function**.

Example

```js
const numbers = [10,20,30];

const index = numbers.findIndex(

    num => num > 15

);

console.log(index);
```

Output

```js
1
```

The callback is

```js
num => num > 15
```

---

# 2. Why Callback Functions?

Instead of JavaScript deciding where the element is,

**you provide the search condition.**

Think of `findIndex()` like this

```
findIndex()

↓

Visit First Element

↓

Ask Callback

↓

Match?

↓

Yes

↓

Return Index

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
const numbers = [4,7,8,10];

const index = numbers.findIndex(

    num => num % 2 === 0

);

console.log(index);
```

Output

```js
0
```

Although

```
8

10
```

are also even,

`findIndex()` returns

```
0
```

because the first element already matches.

---

# 3. Callback Parameters

The callback receives three parameters.

```js
array.findIndex(

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

numbers.findIndex(

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

numbers.findIndex(

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

numbers.findIndex(

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

Like `find()`, `findIndex()` checks **truthy** and **falsy** values.

---

Truthy Values

```
true

1

100

"Hello"

[]

{}

-1
```

Example

```js
const numbers = [10,20];

const index = numbers.findIndex(

    num => 1

);

console.log(index);
```

Output

```js
0
```

Because

```
1

↓

Truthy
```

The first element matches immediately.

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

const index = numbers.findIndex(

    num => 0

);

console.log(index);
```

Output

```js
-1
```

---

Best Practice

Always return boolean expressions.

```js
num > 10

price <= 500

user.active

student.marks >= 40
```

---

# 5. Step-by-Step Execution

Example

```js
const numbers = [5,10,15,20];

const index = numbers.findIndex(

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
2
```

Stop immediately.

---

# 6. Dry Run

Example

```js
const numbers = [3,5,8,10];

const index = numbers.findIndex(

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

Return

↓

2

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
index

↓

2
```

Unlike `map()` or `filter()`,

`findIndex()` does **not create a new array**.

It returns only a number.

Visualization

```
Memory A

↓

[3,5,8,10]

↓

Return

↓

2
```

---

# 8. Execution Flow

```
Array

↓

findIndex()

↓

First Element

↓

Callback

↓

Truthy?

↓

Return Index

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
numbers.findIndex(

    num => num > 5

);
```

---

Wrong

```js
numbers.findIndex(

    num => {

        num > 5;

    }

);
```

Output

```js
-1
```

Reason

```
No Return

↓

undefined

↓

Falsy

↓

No Match
```

---

# 10. Different Callback Styles

## Arrow Function

```js
numbers.findIndex(

    num => num > 10

);
```

---

## Arrow Function with Braces

```js
numbers.findIndex(

    num => {

        return num > 10;

    }

);
```

---

## Normal Function

```js
numbers.findIndex(

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

✅ Use `findIndex()` only when you need the position.

---

✅ Keep callback functions short.

---

✅ Use `find()` if you need the element.

---

# 12. Common Mistakes

### Forgetting `return`

Wrong

```js
numbers.findIndex(

    num => {

        num > 10;

    }

);
```

Returns

```js
-1
```

---

### Confusing `find()` and `findIndex()`

Wrong Expectation

```js
const result = numbers.findIndex(

    num => num > 10

);

console.log(result);
```

Expecting

```js
20
```

Actual

```js
1
```

---

### Expecting an Array

Wrong

```js
const result = numbers.findIndex(

    num => num > 10

);

console.log(result.length);
```

`findIndex()` returns a number.

---

# 13. Interview Questions

### What is a callback function?

---

### How many times is the callback executed?

---

### Does `findIndex()` stop early?

---

### What happens if no match exists?

---

### Can `findIndex()` return `-1`?

---

### Why is `findIndex()` considered a Higher-Order Function?

---

# 14. Coding Exercises

### Exercise 1

Find the index of the first odd number.

---

### Exercise 2

Find the index of the first student whose marks are greater than 80.

---

### Exercise 3

Predict the output.

```js
const arr = [2,4,6];

const result = arr.findIndex(

    num => true

);

console.log(result);
```

---

### Exercise 4

Predict the output.

```js
const arr = [2,4,6];

const result = arr.findIndex(

    num => false

);

console.log(result);
```

---

### Exercise 5

Explain why this returns `-1`.

```js
const arr = [10,20];

const result = arr.findIndex(

    num => {

        num > 15;

    }

);
```

---

# 15. Summary

- `findIndex()` executes its callback once for each element until a match is found.
- The callback receives `element`, `index`, and the original `array`.
- Truthy values return the current element's index.
- Falsy values continue searching.
- `findIndex()` stops immediately after the first match.
- If no element matches, it returns `-1`.
- It does not create a new array.

---

# Next Part

➡️ **Part 3 – findIndex() with Objects, Strings, Arrays & Real-World Examples**

You'll learn:

- Finding Object Indexes
- Finding String Indexes
- Multiple Conditions
- Nested Arrays
- React Examples
- Node.js Examples
- Real-world Use Cases
- Chaining Methods
- Practical Interview Problems
- Updating Data Using Index

# findIndex()

# Part 3 – findIndex() with Objects, Strings, Arrays & Real-World Examples

> **"`findIndex()` is extremely useful when you need to know the position of an element instead of the element itself. It is widely used for updating, deleting, replacing, and managing data in arrays."**

---

# Table of Contents

1. Finding Object Indexes
2. Finding String Indexes
3. Multiple Conditions
4. Finding in Nested Arrays
5. Updating Data Using Index
6. Chaining with `findIndex()`
7. Real-world Examples
8. React Examples
9. Node.js Examples
10. Best Practices
11. Common Mistakes
12. Interview Questions
13. Coding Exercises
14. Summary

---

# 1. Finding Object Indexes

The most common use of `findIndex()` is searching arrays of objects.

Example

```js
const users = [

    {

        id:1,

        name:"Om"

    },

    {

        id:2,

        name:"Raj"

    },

    {

        id:3,

        name:"Amit"

    }

];

const index = users.findIndex(

    user => user.id === 2

);

console.log(index);
```

Output

```js
1
```

---

Another Example

```js
const students = [

    {

        name:"Om",

        marks:95

    },

    {

        name:"Raj",

        marks:80

    }

];

const index = students.findIndex(

    student => student.marks > 90

);

console.log(index);
```

Output

```js
0
```

---

# 2. Finding String Indexes

Example

```js
const fruits = [

    "Apple",

    "Banana",

    "Watermelon",

    "Kiwi"

];

const index = fruits.findIndex(

    fruit => fruit.length > 6

);

console.log(index);
```

Output

```js
2
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

const index = names.findIndex(

    name => name.startsWith("R")

);

console.log(index);
```

Output

```js
1
```

Notice

```
Raj
```

matches first.

```
Rohan
```

is never checked.

---

Ends With

```js
const files = [

    "style.css",

    "index.html",

    "app.js",

    "main.js"

];

const index = files.findIndex(

    file => file.endsWith(".js")

);

console.log(index);
```

Output

```js
2
```

---

# 3. Multiple Conditions

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

        age:30,

        salary:40000

    },

    {

        name:"Amit",

        age:28,

        salary:60000

    }

];

const index = employees.findIndex(

    emp =>

        emp.age > 25 &&

        emp.salary > 50000

);

console.log(index);
```

Output

```js
2
```

---

Using OR (`||`)

```js
const index = employees.findIndex(

    emp =>

        emp.salary > 55000 ||

        emp.age < 25

);

console.log(index);
```

Output

```js
0
```

Again,

`findIndex()` stops after the first match.

---

# 4. Finding in Nested Arrays

Example

```js
const matrix = [

    [1,2],

    [5,6],

    [8,9]

];

const index = matrix.findIndex(

    row => row[0] > 4

);

console.log(index);
```

Output

```js
1
```

---

# 5. Updating Data Using Index

This is the **biggest real-world use case** of `findIndex()`.

Example

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

const index = users.findIndex(

    user => user.id === 2

);

users[index].name = "Amit";

console.log(users);
```

Output

```js
[
{
id:1,
name:"Om"
},

{
id:2,
name:"Amit"
}
]
```

---

Deleting an Item

```js
const index = users.findIndex(

    user => user.id === 1

);

users.splice(index,1);

console.log(users);
```

Output

```js
[
{
id:2,
name:"Raj"
}
]
```

---

Replacing an Object

```js
const index = users.findIndex(

    user => user.id === 2

);

users[index] = {

    id:2,

    name:"Rahul"

};

console.log(users);
```

---

# 6. Chaining with `findIndex()`

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

    }

];

const index = users

.filter(

    user => user.id > 0

)

.findIndex(

    user => user.active

);

console.log(index);
```

Output

```js
1
```

Execution

```
Array

↓

filter()

↓

Filtered Array

↓

findIndex()

↓

Return Index
```

---

# 7. Real-world Examples

## Shopping Cart

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

const index = cart.findIndex(

    item => item.id === 2

);

console.log(index);
```

---

## Student Record

```js
const students = [

    {

        roll:101,

        name:"Om"

    },

    {

        roll:102,

        name:"Raj"

    }

];

const index = students.findIndex(

    student => student.roll === 102

);

console.log(index);
```

---

## Login System

```js
const users = [

    {

        username:"om"

    },

    {

        username:"raj"

    }

];

const index = users.findIndex(

    user => user.username === "raj"

);

console.log(index);
```

---

# 8. React Examples

Updating State

```jsx
const index = users.findIndex(

    user => user.id === selectedId

);
```

Updating Todo

```jsx
const index = todos.findIndex(

    todo => todo.id === id

);
```

---

# 9. Node.js Examples

Find customer index

```js
const index = customers.findIndex(

    customer => customer.id === id

);
```

---

Find order index

```js
const index = orders.findIndex(

    order => order.orderId === orderId

);
```

---

Find employee index

```js
const index = employees.findIndex(

    employee => employee.email === email

);
```

---

# 10. Best Practices

✅ Use `findIndex()` when you need the position.

---

✅ Use `find()` when you need the element.

---

✅ Check for `-1` before updating.

Example

```js
if(index !== -1){

    users[index].name = "New Name";

}
```

---

✅ Use descriptive variable names.

---

# 11. Common Mistakes

### Forgetting to Check `-1`

Wrong

```js
users[index].name = "Om";
```

If

```js
index === -1
```

↓

Runtime Error.

---

Correct

```js
if(index !== -1){

    users[index].name = "Om";

}
```

---

### Confusing `find()` and `findIndex()`

Wrong

```js
const user = users.findIndex(

    user => user.id === 1

);

console.log(user.name);
```

`findIndex()` returns a number,

not an object.

---

### Expecting Multiple Indexes

Wrong

```js
findIndex()
```

returns every matching index.

Correct

```
It returns only the first matching index.
```

---

# 12. Interview Questions

### Can `findIndex()` search objects?

---

### Can it search strings?

---

### Why is `findIndex()` useful for updates?

---

### Difference between `find()` and `findIndex()`?

---

### Difference between `findIndex()` and `indexOf()`?

---

### What happens when no match exists?

---

# 13. Coding Exercises

### Exercise 1

Find the index of the student with marks above 90.

---

### Exercise 2

Find the index of the first JavaScript file.

---

### Exercise 3

Find the index of the active user.

---

### Exercise 4

Update a product using `findIndex()`.

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

const index = users.findIndex(

    user => user.age > 25

);

console.log(index);
```

---

# 14. Summary

- `findIndex()` works with numbers, strings, objects, and nested arrays.
- It returns the **index** of the first matching element.
- It stops searching immediately after finding a match.
- It returns `-1` if no match exists.
- It is heavily used for updating, deleting, and replacing array elements.
- It is widely used in React state management, Node.js applications, and coding interviews.

---

# Next Part

➡️ **Part 4 – Advanced findIndex(), Performance, Memory, Interview Mastery & Debugging**

You'll learn:

- Performance Analysis
- Memory Behavior
- `findIndex()` vs `find()`
- `findIndex()` vs `indexOf()`
- `findIndex()` vs `filter()`
- Debugging
- Predict the Output
- Interview Traps
- Advanced Coding Exercises
- Quick Revision Sheet

# findIndex()

# Part 4 – Advanced `findIndex()`, Performance, Memory, Interview Mastery & Debugging

> **"Mastering `findIndex()` means understanding not only how to search for an element's position, but also how JavaScript processes arrays internally, how memory is managed, and when `findIndex()` is better than other array methods."**

---

# Table of Contents

1. Advanced Searching
2. Performance Considerations
3. Memory Behavior
4. `findIndex()` vs Other Array Methods
5. Debugging `findIndex()`
6. Predict the Output
7. Interview Traps
8. Best Practices
9. Common Mistakes
10. Interview Questions
11. Coding Exercises
12. Quick Revision Sheet
13. Summary

---

# 1. Advanced Searching

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

        salary:40000

    },

    {

        name:"Amit",

        age:28,

        salary:65000

    }

];

const index = employees.findIndex(

    employee =>

        employee.age >= 25 &&

        employee.salary >= 60000

);

console.log(index);
```

Output

```js
2
```

---

## Using OR

```js
const index = employees.findIndex(

    employee =>

        employee.salary >= 65000 ||

        employee.age < 25

);

console.log(index);
```

Output

```js
0
```

Although Amit also satisfies the condition,

`findIndex()` returns the **first** matching index.

---

# 2. Performance Considerations

Every call to `findIndex()`

- visits elements one by one
- executes the callback
- stops immediately after finding a match

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
const index = numbers.findIndex(

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

findIndex()

↓

Stops Immediately

(if match found)

↓

More Efficient Than filter()
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
index

↓

1
```

Unlike

```
map()

filter()
```

`findIndex()` does **not create another array**.

It only returns a number.

---

Objects

```js
const users = [

    {

        id:1,

        name:"Om"

    }

];

const index = users.findIndex(

    user => user.id === 1

);

console.log(index);
```

Memory

```
users

↓

Memory A

↓

Object

------------

index

↓

0
```

Only the index is returned.

No object copy is created.

---

# 4. `findIndex()` vs Other Array Methods

| Method | Returns | Stops Early | Purpose |
|---------|----------|------------|----------|
| `findIndex()` | Index | ✅ Yes | Find Position |
| `find()` | Element | ✅ Yes | Find Element |
| `filter()` | Array | ❌ No | Find All Matches |
| `indexOf()` | Index | ✅ Yes | Exact Value Search |
| `some()` | Boolean | ✅ Yes | Any Match? |
| `every()` | Boolean | ✅ Yes | All Match? |

---

## `findIndex()` vs `find()`

```js
users.find(

    user => user.id === 2

);
```

Returns

```js
{
id:2,
name:"Raj"
}
```

---

```js
users.findIndex(

    user => user.id === 2

);
```

Returns

```js
1
```

---

## `findIndex()` vs `indexOf()`

`indexOf()`

Searches by **exact value**.

```js
const numbers = [10,20,30];

console.log(

    numbers.indexOf(20)

);
```

Output

```js
1
```

---

`findIndex()`

Searches using a condition.

```js
const numbers = [10,20,30];

console.log(

    numbers.findIndex(

        num => num > 15

    )

);
```

Output

```js
1
```

---

## `findIndex()` vs `filter()`

`findIndex()`

```js
users.findIndex(

    user => user.age > 18

);
```

Returns

```
Index
```

---

`filter()`

```js
users.filter(

    user => user.age > 18

);
```

Returns

```
Array
```

---

# 5. Debugging `findIndex()`

Wrong

```js
const index = [1,2,3].findIndex(

    num => {

        num > 1;

    }

);

console.log(index);
```

Output

```js
-1
```

Reason

```
No Return Statement
```

---

Correct

```js
const index = [1,2,3].findIndex(

    num => {

        return num > 1;

    }

);

console.log(index);
```

Output

```js
1
```

---

Debug Callback

```js
numbers.findIndex(

    num => {

        console.log(num);

        return num > 5;

    }

);
```

Useful for understanding execution flow.

---

# 6. Predict the Output

## Example 1

```js
const arr = [2,4,6];

const result = arr.findIndex(

    num => true

);

console.log(result);
```

Output

```js
0
```

---

## Example 2

```js
const arr = [2,4,6];

const result = arr.findIndex(

    num => false

);

console.log(result);
```

Output

```js
-1
```

---

## Example 3

```js
const arr = [10,20,30];

const result = arr.findIndex(

    num => num > 15

);

console.log(result);
```

Output

```js
1
```

---

# 7. Interview Traps

## Trap 1

Does `findIndex()` return the element?

```
No
```

It returns the **index**.

---

## Trap 2

Can it return `-1`?

```
Yes
```

When no match exists.

---

## Trap 3

Does `findIndex()` stop after finding one match?

```
Yes
```

---

## Trap 4

Can `findIndex()` search objects?

```
Yes
```

---

## Trap 5

Can `indexOf()` replace `findIndex()`?

```
No
```

`indexOf()` only compares exact values.

`findIndex()` allows custom conditions.

---

# 8. Best Practices

✅ Use `findIndex()` when you need the position.

---

✅ Always check for `-1`.

```js
if(index !== -1){

    // Safe to update

}
```

---

✅ Use descriptive variable names.

---

✅ Return boolean expressions.

---

# 9. Common Mistakes

### Forgetting `return`

Wrong

```js
numbers.findIndex(

    num => {

        num > 10;

    }

);
```

Returns

```js
-1
```

---

### Updating Without Checking

Wrong

```js
users[index].name = "Om";
```

If

```js
index === -1
```

↓

Runtime Error

---

Correct

```js
if(index !== -1){

    users[index].name = "Om";

}
```

---

### Using `findIndex()` Instead of `find()`

Wrong

```js
const user = users.findIndex(

    user => user.id === 1

);

console.log(user.name);
```

`findIndex()` returns a number.

---

# 10. Interview Questions

### What is the time complexity of `findIndex()`?

---

### Best-case complexity?

---

### Worst-case complexity?

---

### Does `findIndex()` modify the original array?

---

### Difference between `find()` and `findIndex()`?

---

### Difference between `findIndex()` and `indexOf()`?

---

### Why does `findIndex()` return `-1`?

---

### When should you use `findIndex()`?

---

# 11. Coding Exercises

### Exercise 1

Find the index of the first student with marks above 90.

---

### Exercise 2

Find the index of the first JavaScript file.

---

### Exercise 3

Find the index of the first active user.

---

### Exercise 4

Update a product using `findIndex()`.

---

### Exercise 5

Explain why this returns `-1`.

```js
const arr = [10,20];

const result = arr.findIndex(

    num => {

        num > 10;

    }

);

console.log(result);
```

---

# 12. Quick Revision Sheet

```
findIndex()

↓

Visit Element

↓

Run Callback

↓

Truthy?

↓

Return Index

↓

Stop

↓

Falsy?

↓

Next Element
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

Aggregate

↓

reduce()
```

---

# 13. Summary

- `findIndex()` returns the **index** of the first matching element.
- It stops searching immediately after finding a match.
- Best Case Time Complexity is **O(1)**.
- Worst Case Time Complexity is **O(n)**.
- It does not create a new array.
- It is commonly used for updating, deleting, and replacing items in arrays.
- It is one of the most frequently asked JavaScript interview methods.

---

# Chapter Complete ✅

You now understand:

- ✔ What `findIndex()` is
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

➡️ **06-some.md**

You'll master:

- What `some()` is
- Internal Working
- Callback Function
- Short-Circuit Evaluation
- `some()` vs `every()`
- `some()` vs `find()`
- React Examples
- Node.js Examples
- Memory Behavior
- Performance Analysis
- Interview Questions
- Coding Exercises