# Destructuring

# Part 1 – Introduction & Fundamentals

> **"Destructuring is one of the most useful ES6 features. It allows you to extract values from arrays or properties from objects into separate variables. It makes JavaScript code shorter, cleaner, and easier to understand. Today, destructuring is used extensively in React, Node.js, Express, MongoDB, APIs, and modern JavaScript development."**

---

# Table of Contents

1. What is Destructuring?
2. Why Destructuring Was Introduced
3. Syntax
4. How Destructuring Works
5. Array Destructuring
6. Object Destructuring
7. Renaming Variables
8. Default Values
9. Skipping Elements
10. Swapping Variables
11. Nested Destructuring
12. Function Parameter Destructuring
13. Rest Operator with Destructuring
14. Advantages
15. Limitations
16. Summary

---

# 1. What is Destructuring?

Destructuring is an ES6 feature that extracts values from arrays or objects and stores them into separate variables.

Instead of accessing each value manually, JavaScript can unpack them automatically.

Without Destructuring

```js
const person = {
    name: "Om",
    age: 22
};

const name = person.name;
const age = person.age;

console.log(name);
console.log(age);
```

With Destructuring

```js
const person = {
    name: "Om",
    age: 22
};

const { name, age } = person;

console.log(name);
console.log(age);
```

Output

```text
Om
22
```

---

# 2. Why Destructuring Was Introduced

Before ES6

```js
const user = {
    name: "Om",
    age: 22,
    city: "Pune"
};

const name = user.name;
const age = user.age;
const city = user.city;
```

After ES6

```js
const { name, age, city } = user;
```

Benefits

- Less code
- Better readability
- Cleaner syntax
- Easy variable extraction
- Easier function parameters
- Widely used in modern JavaScript

---

# 3. Syntax

## Array Destructuring

```js
const [a, b] = array;
```

---

## Object Destructuring

```js
const { name, age } = object;
```

---

## Rename Variable

```js
const { name: fullName } = object;
```

---

## Default Value

```js
const { age = 18 } = object;
```

---

## Rest Operator

```js
const { name, ...details } = object;
```

---

# 4. How Destructuring Works

Destructuring **unpacks** values.

Array

```
[10,20,30]

↓

Destructuring

↓

a = 10

b = 20

c = 30
```

Object

```
{
name:"Om",
age:22
}

↓

Destructuring

↓

name = "Om"

age = 22
```

---

# 5. Array Destructuring

Array destructuring works by **position**.

```js
const colors = [

    "Red",

    "Green",

    "Blue"

];

const [

    first,

    second,

    third

] = colors;

console.log(first);
console.log(second);
console.log(third);
```

Output

```text
Red
Green
Blue
```

Visualization

```
Index

0 → Red

↓

first

----------------

1 → Green

↓

second

----------------

2 → Blue

↓

third
```

---

# 6. Object Destructuring

Object destructuring works by **property names**.

```js
const student = {

    name:"Om",

    age:22

};

const {

    name,

    age

} = student;

console.log(name);
console.log(age);
```

Output

```text
Om
22
```

Visualization

```
Object

↓

Property

↓

Variable

↓

name

↓

Om

----------------

age

↓

22
```

---

# 7. Renaming Variables

Sometimes the variable name should be different.

```js
const person = {

    name:"Om"

};

const {

    name:fullName

} = person;

console.log(fullName);
```

Output

```text
Om
```

Syntax

```js
propertyName : variableName
```

---

# 8. Default Values

If a property is missing,

JavaScript uses the default value.

```js
const person = {

    name:"Om"

};

const {

    name,

    age = 18

} = person;

console.log(age);
```

Output

```text
18
```

Without default value

```js
const {

    age

} = person;

console.log(age);
```

Output

```text
undefined
```

---

# 9. Skipping Elements

Skip unwanted array values.

```js
const numbers = [

    10,

    20,

    30,

    40

];

const [

    first,

    ,

    third

] = numbers;

console.log(first);
console.log(third);
```

Output

```text
10
30
```

Visualization

```
10

↓

first

----------------

20

↓

Skipped

----------------

30

↓

third
```

---

# 10. Swapping Variables

Before ES6

```js
let a = 10;

let b = 20;

let temp = a;

a = b;

b = temp;
```

Using Destructuring

```js
let a = 10;

let b = 20;

[a,b] = [b,a];

console.log(a);
console.log(b);
```

Output

```text
20
10
```

---

# 11. Nested Destructuring

Array

```js
const numbers = [

    1,

    [2,3]

];

const [

    a,

    [

        b,

        c

    ]

] = numbers;

console.log(a,b,c);
```

Output

```text
1
2
3
```

---

Object

```js
const person = {

    name:"Om",

    address:{

        city:"Pune"

    }

};

const {

    address:{

        city

    }

} = person;

console.log(city);
```

Output

```text
Pune
```

---

# 12. Function Parameter Destructuring

Without Destructuring

```js
function greet(person){

    console.log(person.name);

}
```

With Destructuring

```js
function greet({

    name

}){

    console.log(name);

}

greet({

    name:"Om"

});
```

Output

```text
Om
```

---

# 13. Rest Operator with Destructuring

Array

```js
const numbers = [

    1,

    2,

    3,

    4

];

const [

    first,

    ...rest

] = numbers;

console.log(first);
console.log(rest);
```

Output

```text
1

[2,3,4]
```

---

Object

```js
const user = {

    name:"Om",

    age:22,

    city:"Pune"

};

const {

    name,

    ...details

} = user;

console.log(details);
```

Output

```js
{

age:22,

city:"Pune"

}
```

---

# 14. Advantages

- Cleaner code
- Less repetitive code
- Easy variable extraction
- Better readability
- Cleaner function parameters
- Easier object manipulation
- Used heavily in React and Node.js

---

# 15. Limitations

- Variable names must match property names (unless renamed).
- Missing properties return `undefined`.
- Incorrect nested structure causes errors.
- Array destructuring depends on position.
- Can reduce readability if overused with deeply nested objects.

---

# 16. Summary

Destructuring is a modern JavaScript feature used to unpack values from arrays and objects into variables.

Key points

- Array destructuring uses **position**.
- Object destructuring uses **property names**.
- Supports renaming variables.
- Supports default values.
- Supports nested destructuring.
- Works with the Rest Operator.
- Makes JavaScript code shorter and more readable.
- Widely used in React, Node.js, Express, MongoDB, and API handling.

---

# Key Revision

```
Array

↓

Position

----------------

Object

↓

Property Name

----------------

Rename

↓

name : fullName

----------------

Default

↓

age = 18

----------------

Rest

↓

...rest

----------------

Swap

↓

[a,b]=[b,a]

----------------

Nested

↓

{address:{city}}
```

---
# Destructuring

# Part 2 – Internal Working, Memory Behavior, Evaluation Order & Advanced Concepts

> **"Knowing the syntax of destructuring is only the first step. To confidently use it in real-world projects and interviews, you should understand how JavaScript extracts values, how memory works, evaluation order, nested destructuring, default values, and the relationship between Destructuring, Rest, and Spread."**

---

# Table of Contents

1. Internal Working of Destructuring
2. Memory Representation
3. Primitive vs Reference Types
4. Evaluation Order
5. Array Destructuring Internals
6. Object Destructuring Internals
7. Nested Destructuring
8. Default Values Internals
9. Destructuring + Rest Operator
10. Destructuring + Spread Operator
11. Performance Considerations
12. Common Mistakes
13. Best Practices
14. Summary

---

# 1. Internal Working of Destructuring

Destructuring **does not modify** the original array or object.

It simply extracts values into new variables.

Example

```js
const numbers = [10, 20, 30];

const [a, b] = numbers;

console.log(a);
console.log(b);
```

Internally

```
numbers

↓

Read Index 0

↓

Assign to a

↓

Read Index 1

↓

Assign to b
```

Original array remains unchanged.

---

# 2. Memory Representation

## Primitive Values

```js
let a = 10;

let b = a;
```

Memory

```
Stack

a → 10

b → 10
```

Changing one does not affect the other.

---

## Reference Values

```js
const user = {
    name: "Om"
};

const copy = user;
```

Memory

```
Stack

user

↓

0x101

copy

↓

0x101

↓

Heap

{
name:"Om"
}
```

Both variables reference the same object.

Destructuring only extracts values.

---

# 3. Primitive vs Reference Types

## Primitive Example

```js
const person = {
    age: 22
};

const { age } = person;

console.log(age);
```

Output

```text
22
```

Changing `age` does not affect `person.age`.

```js
let { age } = person;

age = 30;

console.log(person.age);
```

Output

```text
22
```

---

## Reference Example

```js
const person = {
    address: {
        city: "Pune"
    }
};

const {
    address
} = person;

address.city = "Mumbai";

console.log(person.address.city);
```

Output

```text
Mumbai
```

Reason

```
address

↓

Same Object

↓

Reference
```

---

# 4. Evaluation Order

Destructuring happens from left to right.

Example

```js
const numbers = [10,20,30];

const [a,b,c] = numbers;
```

Execution

```
Read Index 0

↓

Assign a

↓

Read Index 1

↓

Assign b

↓

Read Index 2

↓

Assign c
```

---

Objects

```js
const user = {
    name:"Om",
    age:22
};

const {
    name,
    age
} = user;
```

Execution

```
Read Property

↓

Assign Variable

↓

Repeat
```

---

# 5. Array Destructuring Internals

Array destructuring depends on **position**.

```js
const colors = [

    "Red",

    "Green",

    "Blue"

];

const [

    first,

    second

] = colors;
```

Visualization

```
Index

0

↓

first

----------------

1

↓

second
```

Changing the array order changes the extracted values.

---

# 6. Object Destructuring Internals

Object destructuring depends on **property names**, not order.

```js
const person = {

    age:22,

    city:"Pune",

    name:"Om"

};

const {

    name,

    age

} = person;
```

Output

```text
Om

22
```

Even if object properties change order,

destructuring still works correctly.

---

# 7. Nested Destructuring

Nested Arrays

```js
const numbers = [

    1,

    [2,3]

];

const [

    a,

    [

        b,

        c

    ]

] = numbers;
```

Output

```text
1

2

3
```

---

Nested Objects

```js
const employee = {

    name:"Om",

    address:{

        city:"Pune",

        pin:411001

    }

};

const {

    address:{

        city

    }

} = employee;

console.log(city);
```

Output

```text
Pune
```

---

# 8. Default Values Internals

Default values are used **only when the value is `undefined`**.

```js
const user = {

    name:"Om"

};

const {

    age = 18

} = user;

console.log(age);
```

Output

```text
18
```

If value exists,

default value is ignored.

```js
const user = {

    age:25

};

const {

    age = 18

} = user;

console.log(age);
```

Output

```text
25
```

---

# 9. Destructuring + Rest Operator

Arrays

```js
const numbers = [

    1,

    2,

    3,

    4

];

const [

    first,

    ...rest

] = numbers;

console.log(rest);
```

Output

```js
[2,3,4]
```

---

Objects

```js
const person = {

    name:"Om",

    age:22,

    city:"Pune"

};

const {

    name,

    ...details

} = person;

console.log(details);
```

Output

```js
{

age:22,

city:"Pune"

}
```

---

# 10. Destructuring + Spread Operator

These features work very well together.

```js
const user = {

    name:"Om",

    age:22,

    city:"Pune"

};

const {

    city,

    ...profile

} = user;

const updated = {

    ...profile,

    role:"Developer"

};

console.log(updated);
```

Output

```js
{

name:"Om",

age:22,

role:"Developer"

}
```

---

# 11. Performance Considerations

Destructuring is

- Fast
- Readable
- Optimized by modern JavaScript engines

Avoid

- Extremely deep nested destructuring
- Unnecessary destructuring inside large loops
- Extracting unused properties

---

# 12. Common Mistakes

❌ Wrong property name

```js
const {

    age

} = {

    name:"Om"

};
```

Result

```text
undefined
```

---

❌ Forgetting nested structure

Wrong

```js
const {

    city

} = person;
```

Correct

```js
const {

    address:{

        city

    }

} = person;
```

---

❌ Forgetting default values

```js
const {

    salary = 0

} = employee;
```

---

❌ Confusing Rest and Spread

```
Rest

↓

Collect

----------------

Spread

↓

Expand
```

---

# 13. Best Practices

✅ Destructure only required values.

---

✅ Use default values when data may be missing.

---

✅ Rename variables when necessary.

---

✅ Use parameter destructuring in functions.

---

✅ Avoid deeply nested destructuring unless necessary.

---

# 14. Summary

In this chapter you learned

- Internal Working
- Memory Representation
- Primitive vs Reference Types
- Evaluation Order
- Array Internals
- Object Internals
- Nested Destructuring
- Default Values
- Rest Operator
- Spread + Destructuring
- Performance
- Common Mistakes
- Best Practices

---

# Key Revision

```
Destructuring

↓

Extract Values

----------------

Array

↓

Position

----------------

Object

↓

Property Name

----------------

Default Value

↓

Only if Undefined

----------------

Rest

↓

Collect Remaining

----------------

Spread

↓

Expand Values

----------------

Nested

↓

Match Structure
```

---
# Destructuring

# Part 3 – Practical Examples, Coding Patterns & Advanced Use Cases

> **"Destructuring is used daily in JavaScript development. From extracting API responses to handling function parameters and React props, it makes code shorter, cleaner, and easier to maintain. This chapter focuses on practical coding patterns that you'll use in real projects and interviews."**

---

# Table of Contents

1. Working with Arrays
2. Working with Objects
3. Working with Strings
4. Function Parameters
5. Multiple Return Values
6. API Response Handling
7. Configuration Objects
8. Nested Data Extraction
9. Real Coding Patterns
10. Interview Coding Questions
11. Best Practices
12. Summary

---

# 1. Working with Arrays

## Extract First Three Values

```js
const colors = ["Red", "Green", "Blue"];

const [first, second, third] = colors;

console.log(first);
console.log(second);
console.log(third);
```

Output

```text
Red
Green
Blue
```

---

## Skip Values

```js
const numbers = [10, 20, 30, 40];

const [first, , third] = numbers;

console.log(first);
console.log(third);
```

Output

```text
10
30
```

---

## Get First and Remaining Values

```js
const fruits = [
    "Apple",
    "Banana",
    "Orange",
    "Mango"
];

const [first, ...others] = fruits;

console.log(first);
console.log(others);
```

Output

```js
Apple

["Banana","Orange","Mango"]
```

---

# 2. Working with Objects

## Extract Properties

```js
const user = {

    name: "Om",

    age: 22,

    city: "Pune"

};

const {

    name,

    city

} = user;

console.log(name);
console.log(city);
```

Output

```text
Om
Pune
```

---

## Rename Variables

```js
const {

    name: fullName

} = user;

console.log(fullName);
```

Output

```text
Om
```

---

## Extract Remaining Properties

```js
const {

    name,

    ...details

} = user;

console.log(details);
```

Output

```js
{

age:22,

city:"Pune"

}
```

---

# 3. Working with Strings

Convert String into Array

```js
const language = "JavaScript";

const [...letters] = language;

console.log(letters);
```

Output

```js
[
'J',
'a',
'v',
'a',
'S',
'c',
'r',
'i',
'p',
't'
]
```

---

Extract First Character

```js
const [firstLetter] = "JavaScript";

console.log(firstLetter);
```

Output

```text
J
```

---

Extract First Character and Remaining

```js
const [first, ...rest] = "JavaScript";

console.log(first);
console.log(rest.join(""));
```

Output

```text
J

avaScript
```

---

# 4. Function Parameters

Without Destructuring

```js
function printUser(user){

    console.log(user.name);

    console.log(user.age);

}
```

---

With Destructuring

```js
function printUser({

    name,

    age

}){

    console.log(name);

    console.log(age);

}

printUser({

    name:"Om",

    age:22

});
```

Output

```text
Om
22
```

---

Default Values in Parameters

```js
function createUser({

    name,

    city = "Pune"

}){

    console.log(name);

    console.log(city);

}

createUser({

    name:"Om"

});
```

Output

```text
Om
Pune
```

---

# 5. Multiple Return Values

Functions can return arrays.

```js
function getCoordinates(){

    return [

        100,

        200

    ];

}

const [

    x,

    y

] = getCoordinates();

console.log(x);
console.log(y);
```

Output

```text
100
200
```

---

Return Object

```js
function getUser(){

    return {

        name:"Om",

        age:22

    };

}

const {

    name,

    age

} = getUser();

console.log(name);
console.log(age);
```

Output

```text
Om
22
```

---

# 6. API Response Handling

Example API Response

```js
const response = {

    success:true,

    data:{

        id:1,

        name:"Laptop",

        price:70000

    }

};
```

Extract Required Data

```js
const {

    data:{

        name,

        price

    }

} = response;

console.log(name);
console.log(price);
```

Output

```text
Laptop
70000
```

---

# 7. Configuration Objects

```js
const config = {

    host:"localhost",

    port:3000,

    debug:true

};

const {

    host,

    port

} = config;

console.log(host);
console.log(port);
```

Output

```text
localhost
3000
```

---

# 8. Nested Data Extraction

```js
const employee = {

    id:101,

    profile:{

        name:"Om",

        address:{

            city:"Pune"

        }

    }

};
```

Extract Nested Data

```js
const {

    profile:{

        name,

        address:{

            city

        }

    }

} = employee;

console.log(name);
console.log(city);
```

Output

```text
Om
Pune
```

---

# 9. Real Coding Patterns

## Swap Variables

```js
let a = 10;

let b = 20;

[a,b] = [b,a];

console.log(a,b);
```

---

## Extract Object Properties

```js
const student = {

    rollNo:1,

    name:"Om",

    marks:90

};

const {

    name,

    marks

} = student;
```

---

## Ignore Unwanted Values

```js
const numbers = [

    10,

    20,

    30,

    40

];

const [

    first,

    ,

    third

] = numbers;

console.log(first);
console.log(third);
```

---

## Collect Remaining Properties

```js
const person = {

    name:"Om",

    age:22,

    city:"Pune",

    country:"India"

};

const {

    name,

    ...otherDetails

} = person;

console.log(otherDetails);
```

---

# 10. Interview Coding Questions

### Question 1

Extract name and age.

```js
const user = {

    name:"Om",

    age:22

};
```

Pattern

```
Object Destructuring
```

---

### Question 2

Swap two variables.

Pattern

```
Array Destructuring
```

---

### Question 3

Extract nested city.

Pattern

```
Nested Destructuring
```

---

### Question 4

Assign default value.

Pattern

```
Default Value
```

---

### Question 5

Collect remaining properties.

Pattern

```
Rest Operator
```

---

### Question 6

Extract first element and remaining elements.

Pattern

```
Array + Rest
```

---

### Question 7

Use parameter destructuring.

Pattern

```
Function Parameters
```

---

### Question 8

Extract API response.

Pattern

```
Nested Object Destructuring
```

---

### Question 9

Rename a property while destructuring.

Pattern

```
name : fullName
```

---

### Question 10

Return multiple values from a function.

Pattern

```
Array/Object Destructuring
```

---

# 11. Best Practices

✅ Destructure only the values you need.

---

✅ Use default values for optional properties.

---

✅ Rename variables for better readability.

---

✅ Use parameter destructuring in functions.

---

✅ Avoid deeply nested destructuring when it hurts readability.

---

# 12. Summary

In this chapter you learned practical applications of destructuring.

You can now:

- Extract array values
- Extract object properties
- Rename variables
- Assign default values
- Swap variables
- Handle API responses
- Work with nested objects
- Return multiple values from functions
- Use destructuring in coding interviews

---

# Key Revision

```
Array

↓

[first, second]

----------------

Object

↓

{name, age}

----------------

Rename

↓

{name: fullName}

----------------

Default

↓

{age = 18}

----------------

Rest

↓

...rest

----------------

Nested

↓

{address:{city}}

----------------

Function

↓

function({name})

----------------

Swap

↓

[a,b]=[b,a]
```

---
# Destructuring

# Part 4 – Real-World Usage (React, Node.js, Express.js & Production Examples)

> **"Destructuring is used in almost every modern JavaScript project. React developers use it for props and hooks, Node.js developers use it for configuration and API handling, and backend developers use it to extract data from requests, responses, and database objects."**

---

# Table of Contents

1. React Props
2. React useState()
3. React useReducer()
4. React Custom Hooks
5. Node.js Configuration
6. Express.js Request Objects
7. API Response Handling
8. MongoDB Documents
9. Utility Functions
10. Real Project Examples
11. Best Practices
12. Common Mistakes
13. Summary

---

# 1. React Props

React components commonly destructure props.

Without Destructuring

```jsx
function UserCard(props) {

    return (

        <h2>{props.name}</h2>

    );

}
```

With Destructuring

```jsx
function UserCard({

    name,

    age

}) {

    return (

        <>

            <h2>{name}</h2>

            <p>{age}</p>

        </>

    );

}
```

Why?

- Cleaner code
- Better readability
- Less repetition

---

# 2. React useState()

`useState()` returns an array.

Destructuring extracts both values.

```jsx
const [

    count,

    setCount

] = useState(0);
```

Equivalent

```jsx
const state = useState(0);

const count = state[0];

const setCount = state[1];
```

Using destructuring is much cleaner.

---

# 3. React useReducer()

`useReducer()` also returns an array.

```jsx
const [

    state,

    dispatch

] = useReducer(

    reducer,

    initialState

);
```

Output

```
state

dispatch
```

---

# 4. React Custom Hooks

Custom hooks usually return arrays or objects.

Array Example

```jsx
function useCounter(){

    return [

        0,

        () => {}

    ];

}

const [

    count,

    increment

] = useCounter();
```

Object Example

```jsx
function useUser(){

    return {

        name:"Om",

        age:22

    };

}

const {

    name,

    age

} = useUser();
```

---

# 5. Node.js Configuration

Configuration objects are often destructured.

```js
const config = {

    host:"localhost",

    port:5000,

    database:"MongoDB"

};

const {

    host,

    port

} = config;

console.log(host);
console.log(port);
```

Output

```text
localhost

5000
```

---

# 6. Express.js Request Objects

Express applications frequently destructure request data.

Request Body

```js
app.post("/login",(req,res)=>{

    const {

        username,

        password

    } = req.body;

});
```

---

Route Parameters

```js
const {

    id

} = req.params;
```

---

Query Parameters

```js
const {

    page,

    limit

} = req.query;
```

---

# 7. API Response Handling

Suppose an API returns

```js
const response = {

    success:true,

    data:{

        id:1,

        name:"Laptop",

        price:70000

    }

};
```

Extract required values

```js
const {

    data:{

        name,

        price

    }

} = response;

console.log(name);
console.log(price);
```

Output

```text
Laptop

70000
```

---

# 8. MongoDB Documents

MongoDB documents are plain JavaScript objects.

```js
const user = {

    _id:101,

    name:"Om",

    email:"om@gmail.com"

};

const {

    name,

    email

} = user;

console.log(name);
console.log(email);
```

Output

```text
Om

om@gmail.com
```

---

# 9. Utility Functions

Destructuring makes utility functions cleaner.

```js
function printUser({

    name,

    city

}){

    console.log(name);

    console.log(city);

}

printUser({

    name:"Om",

    city:"Pune"

});
```

Default Values

```js
function createUser({

    name,

    role = "User"

}){

    console.log(name);

    console.log(role);

}

createUser({

    name:"Om"

});
```

Output

```text
Om

User
```

---

# 10. Real Project Examples

## User Login

```js
const {

    username,

    password

} = req.body;
```

---

## User Profile

```js
const {

    name,

    age,

    city

} = user;
```

---

## Product Details

```js
const {

    title,

    price

} = product;
```

---

## Configuration File

```js
const {

    PORT,

    DATABASE_URL

} = process.env;
```

---

## API Response

```js
const {

    data

} = response;
```

---

## Function Parameters

```js
function display({

    title,

    author

}){

    console.log(title);

}
```

---

# 11. Best Practices

✅ Destructure only required properties.

---

✅ Use default values for optional data.

---

✅ Rename variables when necessary.

---

✅ Use parameter destructuring for cleaner functions.

---

✅ Keep nested destructuring readable.

---

# 12. Common Mistakes

❌ Wrong property name.

```js
const {

    salary

} = employee;
```

Result

```text
undefined
```

---

❌ Forgetting nested structure.

Wrong

```js
const {

    city

} = person;
```

Correct

```js
const {

    address:{

        city

    }

} = person;
```

---

❌ Using array destructuring with the wrong position.

```js
const [

    second,

    first

] = [

    10,

    20

];
```

Result

```
10

20
```

Array destructuring depends on **position**.

---

❌ Overusing deeply nested destructuring.

It can make code difficult to read.

---

# 13. Summary

Destructuring is used extensively in production JavaScript.

Common real-world use cases include:

- React Props
- React Hooks (`useState`, `useReducer`)
- Custom Hooks
- Node.js Configuration
- Express Request Objects
- API Responses
- MongoDB Documents
- Utility Functions
- Function Parameters

---

# Key Revision

```
React

↓

Props

----------------

React

↓

useState()

----------------

React

↓

useReducer()

----------------

Node.js

↓

Configuration

----------------

Express

↓

req.body

req.params

req.query

----------------

API

↓

Response

----------------

MongoDB

↓

Documents

----------------

Functions

↓

Parameter Destructuring
```

---
# Destructuring

# Part 5 – Interview Mastery (Company-Wise Questions, Coding Patterns & Mock Interviews)

> **"Destructuring is one of the most frequently used ES6 features in modern JavaScript. Almost every React, Node.js, Express.js, and backend interview expects you to understand destructuring, not just its syntax but also when and why to use it."**

---

# Table of Contents

1. Most Asked Interview Questions
2. Company-Wise Interview Questions
3. Coding Patterns
4. Mock Interview Round
5. Common Interview Traps
6. Best Practices
7. Quick Cheat Sheet
8. Summary

---

# 1. Most Asked Interview Questions

## Question 1

### What is Destructuring?

Answer

Destructuring is an ES6 feature that extracts values from arrays or properties from objects into separate variables.

Example

```js
const user = {
    name: "Om",
    age: 22
};

const { name, age } = user;
```

---

## Question 2

### Difference between Array and Object Destructuring?

| Array Destructuring | Object Destructuring |
|---------------------|----------------------|
| Uses Position | Uses Property Name |
| Order Matters | Order Doesn't Matter |
| Uses `[]` | Uses `{}` |

---

## Question 3

### Can variables be renamed?

Yes.

```js
const user = {
    name: "Om"
};

const {
    name: fullName
} = user;

console.log(fullName);
```

---

## Question 4

### Can destructuring have default values?

Yes.

```js
const user = {
    name: "Om"
};

const {
    age = 18
} = user;

console.log(age);
```

Output

```text
18
```

---

## Question 5

### What happens if a property doesn't exist?

Output

```text
undefined
```

Example

```js
const user = {
    name: "Om"
};

const {
    age
} = user;

console.log(age);
```

---

## Question 6

### Can nested objects be destructured?

Yes.

```js
const person = {
    address: {
        city: "Pune"
    }
};

const {
    address: {
        city
    }
} = person;

console.log(city);
```

---

## Question 7

### How do you swap two variables?

```js
let a = 10;
let b = 20;

[a, b] = [b, a];

console.log(a, b);
```

---

## Question 8

### What is Rest Operator in Destructuring?

```js
const user = {
    name: "Om",
    age: 22,
    city: "Pune"
};

const {
    name,
    ...details
} = user;

console.log(details);
```

---

## Question 9

### Where is Destructuring used?

- React Props
- React Hooks
- Express.js
- API Responses
- MongoDB
- Configuration Objects
- Function Parameters

---

## Question 10

### Does destructuring modify the original object?

No.

It only extracts values into variables.

---

# 2. Company-Wise Interview Questions

## Google

Question

Extract required values from a nested API response.

Pattern

```
Nested Object Destructuring
```

---

## Amazon

Question

Extract product information from an API response.

Pattern

```
Object Destructuring
```

---

## Microsoft

Question

Swap two variables without using a temporary variable.

Pattern

```
Array Destructuring
```

---

## Meta

Question

Destructure React component props.

Pattern

```
Function Parameter Destructuring
```

---

## Adobe

Question

Extract configuration values.

Pattern

```
Object Destructuring
```

---

## Atlassian

Question

Extract issue details from nested objects.

Pattern

```
Nested Destructuring
```

---

## Flipkart

Question

Extract order details from API response.

Pattern

```
Nested Object Destructuring
```

---

## Uber

Question

Extract driver information and remaining properties.

Pattern

```
Rest Operator
```

---

# 3. Coding Patterns

## Pattern 1

Array Destructuring

```js
const [

    first,

    second

] = array;
```

---

## Pattern 2

Object Destructuring

```js
const {

    name,

    age

} = object;
```

---

## Pattern 3

Rename Variable

```js
const {

    name: fullName

} = object;
```

---

## Pattern 4

Default Value

```js
const {

    age = 18

} = object;
```

---

## Pattern 5

Rest Operator

```js
const {

    name,

    ...rest

} = object;
```

---

## Pattern 6

Nested Object

```js
const {

    address: {

        city

    }

} = person;
```

---

## Pattern 7

Nested Array

```js
const [

    first,

    [

        second,

        third

    ]

] = numbers;
```

---

## Pattern 8

Function Parameters

```js
function greet({

    name

}){

    console.log(name);

}
```

---

## Pattern 9

Swap Variables

```js
[a,b] = [b,a];
```

---

## Pattern 10

Extract API Response

```js
const {

    data: {

        id,

        name

    }

} = response;
```

---

# 4. Mock Interview Round

## Interviewer

Extract the `name` and `email` from a user object.

Candidate

```js
const user = {

    name: "Om",

    email: "om@gmail.com",

    age: 22

};

const {

    name,

    email

} = user;
```

---

## Follow-up

Rename `name` to `fullName`.

Expected Answer

```js
const {

    name: fullName

} = user;
```

---

## Follow-up

Provide a default value for `role`.

Expected Answer

```js
const {

    role = "User"

} = user;
```

---

## Follow-up

Extract remaining properties.

Expected Answer

```js
const {

    name,

    ...details

} = user;
```

---

## Follow-up

Extract nested city.

Expected Answer

```js
const {

    address: {

        city

    }

} = user;
```

---

# 5. Common Interview Traps

## Trap 1

Confusing Array and Object Destructuring.

Wrong

```js
const {

    first

} = [1,2,3];
```

Correct

```js
const [

    first

] = [1,2,3];
```

---

## Trap 2

Wrong Property Name

```js
const {

    salary

} = employee;
```

Result

```text
undefined
```

---

## Trap 3

Forgetting Default Values

```js
const {

    age = 18

} = person;
```

---

## Trap 4

Wrong Nested Structure

Wrong

```js
const {

    city

} = person;
```

Correct

```js
const {

    address: {

        city

    }

} = person;
```

---

## Trap 5

Assuming Array Order Doesn't Matter

```js
const [

    a,

    b

] = [10,20];
```

Arrays depend on **position**.

Objects depend on **property names**.

---

# 6. Best Practices

✅ Destructure only required values.

---

✅ Use meaningful variable names.

---

✅ Rename variables when needed.

---

✅ Use default values for optional properties.

---

✅ Keep nested destructuring readable.

---

✅ Use parameter destructuring in functions.

---

# 7. Quick Cheat Sheet

```
Array

↓

[first, second]

--------------------

Object

↓

{name, age}

--------------------

Rename

↓

{name: fullName}

--------------------

Default

↓

{age = 18}

--------------------

Rest

↓

...rest

--------------------

Nested Object

↓

{address:{city}}

--------------------

Nested Array

↓

[a,[b,c]]

--------------------

Function

↓

function({name})

--------------------

Swap

↓

[a,b]=[b,a]
```

---

# 8. Summary

After completing the Destructuring handbook, you should be able to:

- ✅ Explain destructuring confidently.
- ✅ Destructure arrays and objects.
- ✅ Rename variables.
- ✅ Use default values.
- ✅ Work with nested arrays and objects.
- ✅ Use the Rest Operator with destructuring.
- ✅ Destructure function parameters.
- ✅ Handle API responses efficiently.
- ✅ Use destructuring in React, Node.js, Express.js, and MongoDB.
- ✅ Solve common interview questions and coding problems.

---

# 🎉 Destructuring Mastery Complete

You have mastered:

- ✅ Fundamentals
- ✅ Internal Working
- ✅ Memory Behavior
- ✅ Arrays
- ✅ Objects
- ✅ Nested Destructuring
- ✅ Default Values
- ✅ Rest Operator
- ✅ Function Parameters
- ✅ Practical Coding Patterns
- ✅ React
- ✅ Node.js
- ✅ Express.js
- ✅ MongoDB
- ✅ API Handling
- ✅ Interview Questions
- ✅ Company-Wise Patterns
- ✅ Mock Interviews
- ✅ Best Practices
- ✅ Quick Revision Cheat Sheet

This completes the **Destructuring** handbook from beginner level to interview-ready level.