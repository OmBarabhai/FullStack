# 🚀 ES6+ Practice Set 2 – Revision Notes

> **Goal:** Learn the **concept**, **why it exists**, **when to use it**, **common mistakes**, and **interview tips**.
>
> **Rule:** Don't memorize syntax. Understand the idea.

---

# 📚 Topics Covered

* Objects
* Object Property Update
* Arrow Functions
* Object Destructuring
* Array Destructuring
* Default Parameters
* Spread Operator
* Template Literals
* String Operations
* Array Access
* Function Return Values

---

# 1️⃣ Object Creation & Property Update

## What?

Objects store related data using **key-value pairs**.

```javascript
const person = {
    name: "Om",
    age: 30
};
```

---

## Update Property

```javascript
person.age = 35;
```

---

## Why?

Real-world data changes.

Examples

* User updates profile
* Product price changes
* Student marks updated

---

## Memory

```
person
│
├── name → Om
└── age → 30

↓

person.age = 35

↓

person
│
├── name → Om
└── age → 35
```

---

## Common Mistake

```javascript
const person = {
    age:30
};

person = {};
```

❌ Error

Because `const` prevents changing the reference.

But this is allowed:

```javascript
person.age = 40;
```

---

## Remember

```
const Object

↓

Reference cannot change

↓

Properties can change
```

---

# 2️⃣ Returning Boolean Expressions

Instead of

```javascript
const isSportsCar = ({ horsepower }) => {
    if (horsepower >= 300) {
        return true;
    }
    return false;
};
```

Write

```javascript
const isSportsCar = ({ horsepower }) =>
    horsepower >= 300;
```

---

## Why?

Comparison operators already return

```
true

or

false
```

---

## Common Mistake

Writing unnecessary `if`.

Bad

```javascript
if(age>=18){
   return true;
}
return false;
```

Good

```javascript
return age >= 18;
```

---

# 3️⃣ Object Destructuring

## What?

Extract properties from an object into variables.

Before ES6

```javascript
const name = person.name;
const age = person.age;
```

After ES6

```javascript
const { name, age } = person;
```

---

## Why?

Avoid repetitive code.

Instead of

```
person.name

person.age

person.city
```

Simply use

```
name

age

city
```

---

## Visual

```
person

│

├── name

├── age

└── city

↓

Open once

↓

name

age

city
```

---

## Nested Destructuring

Object

```javascript
const person = {
    name:"John",
    address:{
        city:"New York"
    }
};
```

Correct

```javascript
const {
    name,
    address:{city}
}=person;
```

---

## Common Mistake

Wrong

```javascript
const { city } = person;
```

Because

```
city

↓

inside

↓

address
```

---

## Interview Question

Why use destructuring?

Answer

* Cleaner code
* Less repetition
* Easier to read
* Common in React

---

# 4️⃣ Array Destructuring

Used to extract values from arrays.

Example

```javascript
const numbers=[10,20];

const [a,b]=numbers;
```

Now

```
a = 10

b = 20
```

---

## Swap Variables

Without ES6

```javascript
let temp=a;
a=b;
b=temp;
```

With ES6

```javascript
[a,b]=[b,a];
```

---

## Common Mistake

Missing semicolon before destructuring.

Wrong

```javascript
let b=2
[a,b]=[b,a]
```

Can produce unexpected parsing.

Safer

```javascript
let b=2;

[a,b]=[b,a];
```

---

# 5️⃣ Default Parameters

Old

```javascript
function add(a,b){
}
```

ES6

```javascript
const add=(a=30,b=0)=>a+b;
```

---

## Why?

If user doesn't pass arguments

```javascript
add();
```

Output

```
30
```

instead of

```
NaN
```

---

## Real Life

Default tax

Default language

Default theme

Default page size

---

# 6️⃣ Spread Operator (...)

## What?

Copies or merges objects.

```javascript
const combineObjects=(a,b)=>({
    ...a,
    ...b
});
```

---

## Visual

```
Object A

+

Object B

↓

One New Object
```

---

## Why?

Without spread

Need loops or manual copying.

---

## Real Life

React State

Redux

API Responses

Configuration Objects

---

# 7️⃣ Function Return vs console.log()

One of the biggest beginner mistakes.

## Wrong Thinking

```
console.log()

=

return
```

No.

---

## return

Returns value back.

```javascript
const add=(a,b)=>{
    return a+b;
};
```

---

## console.log()

Only displays value.

```javascript
console.log(add(2,3));
```

---

## Visual

```
Function

↓

return

↓

Program receives value
```

```
Function

↓

console.log()

↓

Human sees value
```

---

## Remember

```
return

↓

Computer uses it
```

```
console.log()

↓

Human sees it
```

---

# 8️⃣ Template Literals

Old

```javascript
name+" is "+age
```

ES6

```javascript
`${name} is ${age} years old`
```

---

## Why?

Cleaner

Readable

Supports multiline strings

Supports expressions

---

# 9️⃣ String Methods

Uppercase

```javascript
str.toUpperCase()
```

Concatenate

```javascript
str1+str2
```

or

```javascript
`${str1}${str2}`
```

---

# 🔟 Arrays

First Element

```javascript
arr[0]
```

Last Element

```javascript
arr[arr.length-1]
```

---

## Why use `.length - 1`?

Arrays start at index

```
0
```

If length is

```
5
```

Indexes are

```
0
1
2
3
4
```

Last index

```
length-1
```

---

# 1️⃣1️⃣ Sum Operations

First element

```javascript
arr[0]
```

Last element

```javascript
arr[arr.length-1]
```

Example

```javascript
arr[0]+num
```

or

```javascript
arr[0]+arr[arr.length-1]
```

---

# 1️⃣2️⃣ Naming Variables

Avoid

```javascript
(Array,Number)
```

Because

```
Array

Number
```

are built-in JavaScript constructors.

Use

```javascript
(arr,num)
```

---

# ⭐ Common Mistakes You Made

## ❌ Mistake 1

Using

```javascript
console.log()
```

instead of

```javascript
return
```

Remember

```
return

↓

program

console.log

↓

developer
```

---

## ❌ Mistake 2

Incorrect nested destructuring.

Wrong

```javascript
const {city}=person;
```

Correct

```javascript
const {
    address:{city}
}=person;
```

---

## ❌ Mistake 3

Using `if` unnecessarily.

Bad

```javascript
if(age>=18){
return true;
}
return false;
```

Good

```javascript
return age>=18;
```

---

## ❌ Mistake 4

Using built-in names as variables.

Avoid

```javascript
Array

Number

Object
```

---

## ❌ Mistake 5

Missing semicolon before array destructuring.

```javascript
let a=1;
let b=2;

[a,b]=[b,a];
```

---

# 📌 Interview Questions

### Objects

* What is an object?
* Difference between object and array?
* How do you update properties?
* Can `const` objects be modified?

---

### Destructuring

* What is destructuring?
* Why was it introduced?
* Difference between object and array destructuring?
* What is nested destructuring?

---

### Arrow Functions

* Difference between normal and arrow functions?
* When can you omit `return`?
* Implicit vs explicit return?

---

### Default Parameters

* Why use default values?
* What happens if arguments are missing?

---

### Spread Operator

* What does `...` do?
* Difference between spread and rest operator?

---

### Template Literals

* Why use template literals?
* Advantages over string concatenation?

---

# 🎯 ES6 Features Learned

| Feature              | Status |
| -------------------- | :----: |
| Object Creation      |    ✅   |
| Object Update        |    ✅   |
| Arrow Functions      |    ✅   |
| Object Destructuring |    ✅   |
| Nested Destructuring |    ✅   |
| Array Destructuring  |    ✅   |
| Variable Swapping    |    ✅   |
| Default Parameters   |    ✅   |
| Spread Operator      |    ✅   |
| Template Literals    |    ✅   |
| String Methods       |    ✅   |
| Array Access         |    ✅   |
| Function Return      |    ✅   |

---

# 🧠 Revision Checklist

Before moving to the next ES6 topic, make sure you can answer **YES** to all of these:

* [ ] I know the difference between `return` and `console.log()`.
* [ ] I can explain why destructuring was introduced.
* [ ] I can destructure nested objects.
* [ ] I know when to use object destructuring in function parameters.
* [ ] I can swap two variables using array destructuring.
* [ ] I understand why default parameters are useful.
* [ ] I know how the spread operator merges objects.
* [ ] I know when to use template literals instead of string concatenation.
* [ ] I can access the first and last element of an array.
* [ ] I understand why `.length - 1` gives the last index.
* [ ] I avoid using built-in names like `Array` and `Number` as variable names.
* [ ] I can explain every ES6 feature using **What? Why? How? When?** instead of only writing the syntax.

---

# 🚀 Final Learning Strategy

Whenever you learn a new JavaScript feature, don't stop after writing the code. Ask yourself these four questions:

1. **What is it?** (Definition)
2. **Why was it introduced?** (Problem it solves)
3. **How does it work?** (Syntax + internal idea)
4. **When should I use it?** (Real-world usage)

If you can answer those four questions for every ES6 feature, you'll understand JavaScript much more deeply than someone who has only memorized syntax.
