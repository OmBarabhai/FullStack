# ES6 Patterns

> **"ES6 Patterns are reusable coding techniques and best practices that make JavaScript code cleaner, more maintainable, scalable, and interview-ready. They are heavily used in React, Node.js, Express, and modern JavaScript applications."**

---

# Table of Contents

1. What are ES6 Patterns?
2. Why Learn Patterns?
3. Object Destructuring Pattern
4. Array Destructuring Pattern
5. Default Parameters Pattern
6. Rest Parameters Pattern
7. Spread Operator Pattern
8. Object Merge Pattern
9. Array Merge Pattern
10. Immutable Update Pattern
11. Method Chaining Pattern
12. Factory Function Pattern
13. Module Pattern
14. Revealing Module Pattern
15. Composition Pattern
16. Configuration Object Pattern
17. Real-world Examples
18. React Examples
19. Node.js Examples
20. Best Practices
21. Common Mistakes
22. Interview Questions
23. Coding Exercises
24. Summary

---

# 1. What are ES6 Patterns?

Patterns are reusable solutions to common programming problems.

Instead of writing everything from scratch,

we follow proven structures.

Example

Without Pattern

```js
const name = user.name;
const age = user.age;
```

With Pattern

```js
const { name, age } = user;
```

Cleaner.

Readable.

Professional.

---

# 2. Why Learn Patterns?

Benefits

- Less Code
- Better Readability
- Easier Maintenance
- Better Reusability
- Used in React
- Used in Node.js
- Frequently Asked in Interviews

---

# 3. Object Destructuring Pattern

Instead of

```js
const name = user.name;
const age = user.age;
```

Use

```js
const { name, age } = user;
```

Rename Variable

```js
const {
    name: userName
} = user;
```

Default Value

```js
const {
    city = "Pune"
} = user;
```

Nested Destructuring

```js
const user = {
    address:{
        city:"Mumbai"
    }
};

const {
    address:{
        city
    }
} = user;
```

---

# 4. Array Destructuring Pattern

Instead of

```js
const first = arr[0];
const second = arr[1];
```

Use

```js
const [first, second] = arr;
```

Skip Elements

```js
const [a, , c] = arr;
```

Swap Variables

```js
let a = 10;
let b = 20;

[a, b] = [b, a];
```

---

# 5. Default Parameters Pattern

Old JavaScript

```js
function greet(name){

    name = name || "Guest";

}
```

Modern

```js
function greet(name = "Guest"){

}
```

Multiple Defaults

```js
function add(
a = 0,
b = 0
){

}
```

---

# 6. Rest Parameters Pattern

Collect remaining arguments.

```js
function sum(...numbers){

}
```

Example

```js
function sum(...numbers){

    return numbers.reduce(
        (a,b)=>a+b,
        0
    );

}
```

Output

```
sum(1,2,3,4)

↓

10
```

---

# 7. Spread Operator Pattern

Copy Array

```js
const copy = [...arr];
```

Merge Arrays

```js
const result = [
...arr1,
...arr2
];
```

Copy Object

```js
const userCopy = {
...user
};
```

---

# 8. Object Merge Pattern

```js
const user = {
    name:"Om"
};

const details = {
    age:22
};

const person = {
    ...user,
    ...details
};
```

Output

```js
{
name:"Om",
age:22
}
```

---

# 9. Array Merge Pattern

```js
const nums1 = [1,2];

const nums2 = [3,4];

const result = [
...nums1,
...nums2
];
```

Output

```
[1,2,3,4]
```

---

# 10. Immutable Update Pattern

Wrong

```js
user.age = 23;
```

Correct

```js
const updated = {
...user,
age:23
};
```

Array

```js
const updated = [
...numbers,
10
];
```

Remove Item

```js
const filtered =
numbers.filter(
n=>n!==5
);
```

---

# 11. Method Chaining Pattern

Example

```js
const result =
users
.filter(
u=>u.active
)
.map(
u=>u.name
)
.sort();
```

Visualization

```
Users

↓

Filter

↓

Map

↓

Sort

↓

Result
```

---

# 12. Factory Function Pattern

Instead of classes,

return objects.

```js
function createUser(name){

    return {

        name,

        greet(){

            console.log(
                `Hello ${name}`
            );

        }

    };

}

const user =
createUser("Om");

user.greet();
```

Output

```
Hello Om
```

---

# 13. Module Pattern

Hide private data.

```js
function Counter(){

    let count = 0;

    return {

        increment(){

            count++;

        },

        getCount(){

            return count;

        }

    };

}

const counter =
Counter();

counter.increment();

console.log(
counter.getCount()
);
```

Output

```
1
```

Private

```
count
```

Cannot be accessed directly.

---

# 14. Revealing Module Pattern

Expose only selected methods.

```js
const User = (function(){

    function login(){

        console.log("Login");

    }

    function logout(){

        console.log("Logout");

    }

    return {

        login,

        logout

    };

})();

User.login();
```

---

# 15. Composition Pattern

Instead of inheritance,

combine functions.

```js
const canWalk = state => ({

    walk(){

        console.log(
            `${state.name} walks`
        );

    }

});

const canEat = state => ({

    eat(){

        console.log(
            `${state.name} eats`
        );

    }

});

function createPerson(name){

    const state = { name };

    return {

        ...state,

        ...canWalk(state),

        ...canEat(state)

    };

}

const person =
createPerson("Om");

person.walk();
person.eat();
```

Output

```
Om walks

Om eats
```

---

# 16. Configuration Object Pattern

Instead of many parameters,

use one object.

Wrong

```js
createUser(
"Om",
22,
true,
"Pune"
);
```

Better

```js
createUser({

name:"Om",

age:22,

isAdmin:true,

city:"Pune"

});
```

Benefits

- Flexible
- Readable
- Easy to extend

---

# 17. Real-world Examples

API

```js
fetch(url,{
method:"GET",
headers:{}
});
```

Express

```js
app.listen(
3000,
()=>{
}
);
```

MongoDB

```js
User.find({
age:22
});
```

Configuration Object Pattern is everywhere.

---

# 18. React Examples

Props Destructuring

```jsx
function Card({
title,
price
}){

}
```

State Update

```jsx
setUser({

...user,

age:23

});
```

Rendering

```jsx
users
.filter(...)
.map(...)
```

---

# 19. Node.js Examples

Express

```js
app.get(
"/",
(req,res)=>{

}
);
```

Middleware

```js
app.use(
middleware
);
```

Configuration

```js
const config = {

...defaults,

...env

};
```

---

# 20. Best Practices

✅ Prefer destructuring.

✅ Prefer immutable updates.

✅ Prefer configuration objects.

✅ Prefer composition over inheritance.

✅ Use method chaining carefully.

---

# 21. Common Mistakes

### Mutating Objects

Wrong

```js
user.age = 50;
```

---

Correct

```js
{
...user,
age:50
}
```

---

### Overusing Method Chaining

Wrong

```js
users
.filter(...)
.map(...)
.sort(...)
.reverse()
.flat()
.slice();
```

Too difficult to read.

---

### Using Too Many Parameters

Wrong

```js
createUser(
a,b,c,d,e,f
);
```

Prefer configuration objects.

---

# 22. Interview Questions

## What is a Pattern?

A reusable solution to a common programming problem.

---

## Why use Factory Functions?

To create reusable objects without classes.

---

## What is the Module Pattern?

A pattern that hides private data and exposes only public methods.

---

## Difference between Module Pattern and ES Modules?

| Module Pattern | ES Modules |
|----------------|------------|
| Closure-based | File-based |
| Private variables | Export/Import |
| Older Pattern | Modern Standard |

---

## Why use Composition?

Composition provides greater flexibility than inheritance and avoids deep inheritance hierarchies.

---

## What is the Configuration Object Pattern?

Passing a single object instead of many function arguments.

---

# 23. Coding Exercises

### Exercise 1

Swap two variables using destructuring.

---

### Exercise 2

Merge two arrays using spread.

---

### Exercise 3

Create a Factory Function for a Student.

---

### Exercise 4

Implement the Module Pattern.

---

### Exercise 5

Update an object immutably.

---

### Exercise 6

Chain `filter()`, `map()`, and `sort()`.

---

### Exercise 7

Convert a function with five parameters into one using a configuration object.

---

# 24. Summary

- ES6 Patterns are reusable coding techniques.
- Destructuring simplifies object and array access.
- Spread and Rest operators reduce boilerplate code.
- Immutable updates are essential in React.
- Factory Functions create reusable objects.
- Module Pattern encapsulates private data.
- Composition is preferred over inheritance in modern JavaScript.
- Configuration Objects improve function readability.
- These patterns are widely used in React, Node.js, Express, Next.js, and modern JavaScript development.

---

# What's Next?

➡️ **18-Interview-Questions.md**

You'll learn:

- 50+ Most Asked ES6 Interview Questions
- Beginner to Advanced
- Scenario-Based Questions
- Output-Based Questions
- Coding Questions
- HR-Friendly Explanations
- FAANG & Product Company Patterns