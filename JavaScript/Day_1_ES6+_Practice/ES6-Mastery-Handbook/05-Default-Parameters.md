# Default Parameters

> **"Default Parameters allow functions to use predefined values when arguments are missing or `undefined`. They make functions safer, cleaner, and eliminate unnecessary conditional checks."**

---

# Table of Contents

1. Introduction
2. Why Default Parameters Were Introduced
3. Problems Before ES6
4. Syntax
5. How Default Parameters Work
6. Internal Working
7. Parameter Environment
8. Evaluation Order
9. Previous Parameter Dependency
10. Why Later Parameters Cannot Be Used
11. Summary (Part 1)

---

# 1. Introduction

Functions receive data through **parameters**.

Example

```js
function greet(name) {
    console.log(name);
}

greet("Om");
```

Output

```
Om
```

---

But what happens if we don't provide an argument?

```js
function greet(name) {
    console.log(name);
}

greet();
```

Output

```
undefined
```

Why?

Because JavaScript did not receive any value for the parameter.

Internally

```
Call Function

↓

name

↓

undefined
```

---

This behavior is sometimes useful,

but in many situations,

we want JavaScript to automatically use a predefined value.

For example

Instead of

```
undefined
```

we want

```
Guest
```

---

ES6 introduced

```
Default Parameters
```

which solve this problem elegantly.

---

Example

```js
function greet(name = "Guest") {
    console.log(name);
}

greet();
```

Output

```
Guest
```

---

If a value is supplied,

the supplied value is used.

```js
greet("Om");
```

Output

```
Om
```

---

So,

Default Parameters allow a function to have **fallback values**.

---

# 2. Why Default Parameters Were Introduced

Before ES6,

JavaScript developers had to manually check every optional parameter.

Imagine building a login function.

```js
function login(username) {
    console.log(username);
}
```

Calling

```js
login();
```

prints

```
undefined
```

which usually isn't desirable.

---

Developers solved this using

```js
||
```

Example

```js
function login(username) {

    username = username || "Guest";

    console.log(username);

}
```

Output

```
Guest
```

---

Looks fine...

until this happens.

```js
function print(number){

    number = number || 100;

    console.log(number);

}

print(0);
```

Output

```
100
```

---

Expected

```
0
```

Actual

```
100
```

Why?

Because

```
0

false

""

NaN

null

undefined
```

are all **Falsy Values**.

The logical OR operator treats all of them as "missing".

Sometimes,

this is not what we want.

---

Another example

```js
function print(isAdmin){

    isAdmin = isAdmin || true;

    console.log(isAdmin);

}

print(false);
```

Output

```
true
```

Expected

```
false
```

---

Again,

the OR operator replaced a perfectly valid value.

---

ES6 solved this problem using Default Parameters.

```js
function print(number = 100){

    console.log(number);

}

print(0);
```

Output

```
0
```

---

Another example

```js
function print(isAdmin = true){

    console.log(isAdmin);

}

print(false);
```

Output

```
false
```

---

Default Parameters activate **only** when the argument is

```
Missing

or

undefined
```

Not when it is

```
0

false

""

null
```

This makes them much safer than the old ES5 pattern.

---

# 3. Problems Before ES6

Let's summarize the problems.

---

## Problem 1

Too many manual checks.

```js
function login(username){

    if(username===undefined){

        username="Guest";

    }

}
```

---

## Problem 2

Using `||`

```js
username = username || "Guest";
```

Fails for

```
0

false

""
```

---

## Problem 3

Poor Readability

Imagine

```js
function connect(host,port,timeout){

    host = host || "localhost";

    port = port || 5000;

    timeout = timeout || 1000;

}
```

Lots of repetitive code.

---

Modern JavaScript

```js
function connect(

host="localhost",

port=5000,

timeout=1000

){

}
```

Much cleaner.

---

## Problem 4

Maintenance

Old code becomes difficult to understand because every function repeats the same pattern.

Default Parameters remove that boilerplate.

---

# 4. Syntax

General Syntax

```js
function functionName(

parameter = defaultValue

){

}
```

---

Example

```js
function greet(name = "Guest"){

    console.log(name);

}
```

---

Calling without arguments

```js
greet();
```

Output

```
Guest
```

---

Calling with an argument

```js
greet("Om");
```

Output

```
Om
```

---

Multiple Parameters

```js
function createUser(

name="Guest",

age=18

){

    console.log(name,age);

}
```

Output

```
Guest 18
```

---

Mixed Parameters

```js
function register(

username,

country="India"

){

    console.log(username,country);

}

register("Om");
```

Output

```
Om India
```

---

# 5. How Default Parameters Work

JavaScript follows a simple rule.

When a function is called,

every parameter receives a value.

For each parameter,

JavaScript checks:

```
Was an argument provided?

↓

YES

↓

Use that value

------------------

NO

↓

Use Default Value
```

---

Example

```js
function add(a,b=10){

    console.log(a,b);

}

add(5);
```

Dry Run

```
Call

↓

a

↓

5

↓

b

↓

Missing

↓

Default Value

↓

10
```

Output

```
5 10
```

---

Another example

```js
function multiply(

a=2,

b=3

){

    console.log(a*b);

}

multiply();
```

Dry Run

```
a

↓

Missing

↓

2

------------

b

↓

Missing

↓

3

↓

2*3

↓

6
```

Output

```
6
```

---

If values are supplied,

defaults are ignored.

```js
multiply(5,10);
```

Output

```
50
```

---

Visualization

```
Function Call

↓

Parameter 1

↓

Argument Exists?

↓

Yes → Use Argument

↓

No → Use Default

↓

Parameter 2

↓

Repeat

↓

Execute Function
```

---

# 6. Internal Working

Default Parameters are evaluated **before the function body starts executing**.

That means JavaScript prepares every parameter first.

Example

```js
function greet(name="Guest"){

    console.log("Inside Function");

    console.log(name);

}

greet();
```

Internally

```
Call greet()

↓

Create Function Execution Context

↓

Create Parameters

↓

name

↓

Missing

↓

Assign "Guest"

↓

Execute Function Body

↓

console.log()

↓

Return
```

Notice

The default value is assigned **before**

```js
console.log(name);
```

runs.

---

# 7. Parameter Environment

When a function is called,

JavaScript first creates a special area for parameters.

Think of it as

```
Parameter Environment
```

Example

```js
function greet(

name="Guest",

age=18

){

}
```

Memory

```
Function Call

↓

Parameter Environment

--------------------

name

↓

Guest

--------------------

age

↓

18
```

Only after creating this parameter environment does JavaScript start executing the function body.

---

# 8. Evaluation Order

Parameters are evaluated from **left to right**.

Example

```js
function display(

a=10,

b=20,

c=30

){

    console.log(a,b,c);

}

display();
```

Internally

```
a

↓

10

↓

b

↓

20

↓

c

↓

30
```

Output

```
10 20 30
```

---

JavaScript never evaluates parameters randomly.

It always goes

```
Left

↓

Right
```

This becomes important when parameters depend on earlier parameters.

We'll see that next.

---

# 9. Previous Parameter Dependency

One parameter can use a **previous parameter** as its default value.

Example

```js
function rectangle(

length=10,

width=length

){

    console.log(length,width);

}

rectangle();
```

Output

```
10 10
```

---

Dry Run

```
length

↓

Missing

↓

10

↓

width

↓

Missing

↓

length

↓

10
```

Output

```
10 10
```

---

Another Example

```js
function area(

length=10,

width=length,

height=2

){

    console.log(length,width,height);

}

area();
```

Output

```
10 10 2
```

Everything works because

```
length

↓

Already Evaluated

↓

Available

↓

width uses it
```

---

# 10. Why Later Parameters Cannot Be Used

Now consider this.

```js
function test(

a=b,

b=10

){

    console.log(a,b);

}

test();
```

Output

```
ReferenceError
```

Why?

Because JavaScript evaluates parameters **from left to right**.

When JavaScript tries to evaluate

```
a = b
```

the variable

```
b
```

does not exist yet.

Visualization

```
Evaluate a

↓

Need b

↓

b Not Created Yet

↓

ReferenceError
```

---

Correct Version

```js
function test(

b=10,

a=b

){

    console.log(a,b);

}

test();
```

Output

```
10 10
```

Because

```
b

↓

Created First

↓

10

↓

a

↓

Uses b

↓

10
```

---

# 11. Summary (Part 1)

In this chapter you learned:

- What Default Parameters are
- Why ES6 introduced them
- Problems with ES5 (`||`)
- Syntax
- How Default Parameters work
- Internal Working
- Parameter Environment
- Evaluation Order
- Previous Parameter Dependency
- Why later parameters cannot be used

---

# Next Part

In **Part 2**, you'll learn:

- Lazy Evaluation
- Default Parameters vs ES5
- Default Parameters vs `||`
- Default Parameters vs `??`
- `undefined` vs `null`
- Multiple Default Parameters
- Expressions as Default Values
- Function Calls as Default Values
- Objects & Arrays as Default Values

# 12. Lazy Evaluation

One of the most important concepts about Default Parameters is **Lazy Evaluation**.

Interviewers frequently ask this topic.

---

## What is Lazy Evaluation?

A default value is **not calculated when the function is created**.

Instead,

it is calculated **only when the function is called and the argument is missing or `undefined`**.

Think of it like this:

```
Function Created

↓

No Default Value Evaluated

↓

Function Called

↓

Argument Missing?

↓

Yes

↓

Evaluate Default Value

↓

Execute Function
```

---

## Example 1

```js
function getNumber() {
    console.log("getNumber() called");
    return 100;
}

function test(x = getNumber()) {
    console.log(x);
}

test();
```

Output

```
getNumber() called
100
```

---

### Dry Run

```
Call test()

↓

x Missing

↓

Evaluate getNumber()

↓

Returns 100

↓

Assign x = 100

↓

console.log(100)
```

---

## Example 2

```js
function getNumber() {
    console.log("Called");
    return 100;
}

function test(x = getNumber()) {
    console.log(x);
}

test(50);
```

Output

```
50
```

Notice

```
Called
```

was **never printed**.

Why?

Because

```
x already has a value

↓

No need to evaluate

getNumber()
```

---

## Important Rule

Default expressions execute **only when needed**.

```
Argument Provided

↓

Ignore Default Value

---------------------

Argument Missing

↓

Evaluate Default Value
```

---

# 13. Default Parameters vs ES5

Before ES6,

developers manually assigned default values.

---

## ES5 Style

```js
function greet(name) {

    name = name || "Guest";

    console.log(name);

}

greet();
```

Output

```
Guest
```

---

Although this works,

it has problems.

---

## Problem

```js
function print(num){

    num = num || 100;

    console.log(num);

}

print(0);
```

Expected

```
0
```

Actual

```
100
```

Why?

Because

```
0

↓

Falsy

↓

OR uses default
```

---

## ES6 Style

```js
function print(num = 100){

    console.log(num);

}

print(0);
```

Output

```
0
```

Now,

JavaScript understands

```
0

↓

Valid Value

↓

Do NOT replace
```

---

### Comparison

| ES5 | ES6 |
|------|-----|
| Manual assignment | Automatic |
| Uses `||` | Uses `=` |
| More code | Less code |
| Fails for `0`, `false`, `""` | Works correctly |
| Harder to read | Cleaner |

---

# 14. Default Parameters vs `||`

This is one of the most common interview questions.

---

## Using `||`

```js
function login(user){

    user = user || "Guest";

    console.log(user);

}
```

---

### Example

```js
login("");
```

Output

```
Guest
```

But

```
""

```

is a valid value.

The OR operator incorrectly replaces it.

---

## Using Default Parameters

```js
function login(user = "Guest"){

    console.log(user);

}

login("");
```

Output

```

```

(An empty string is printed.)

Because

```
Argument Exists

↓

Default Parameter NOT Used
```

---

### Another Example

```js
function print(value = 50){

    console.log(value);

}

print(false);
```

Output

```
false
```

The default value is ignored because

```
false

↓

Actual Argument
```

---

### Comparison Table

| Feature        | 'OR'  | `??`               |
|----------------|-------|--------------------|
| `undefined`    | Default | Default            |
| Missing        | Default | Default            |
| `null`         | Default | `null`             |
| `0`            | Default | `0`                |
| `false`        | Default | `false`            |
| `""`           | Default | `""`               |

---

# 15. Default Parameters vs `??`

ES2020 introduced the **Nullish Coalescing Operator (`??`)**.

Many developers confuse it with Default Parameters.

---

## Nullish Coalescing

```js
const value = null;

console.log(value ?? "Guest");
```

Output

```
Guest
```

---

Another example

```js
const value = 0;

console.log(value ?? 100);
```

Output

```
0
```

Unlike `||`,

`??` only checks

```
null

or

undefined
```

---

### Comparison

| Feature | Default Parameter | `??` |
|----------|-------------------|-------|
| Used in Function Parameters | ✅ | ❌ |
| Used Anywhere | ❌ | ✅ |
| Checks Missing Argument | ✅ | ❌ |
| Checks `undefined` | ✅ | ✅ |
| Checks `null` | ❌ | ✅ |

---

## Example

```js
function greet(name = "Guest") {

    console.log(name);

}

greet(null);
```

Output

```
null
```

Default Parameters ignore `null`.

---

Using `??`

```js
const name = null;

console.log(name ?? "Guest");
```

Output

```
Guest
```

---

# 16. Undefined vs Null

This topic is extremely important.

---

## Undefined

Means

```
No Value Provided
```

---

Example

```js
function greet(name = "Guest") {

    console.log(name);

}

greet(undefined);
```

Output

```
Guest
```

Because

```
undefined

↓

Use Default
```

---

## Null

Means

```
Intentional Empty Value
```

---

Example

```js
greet(null);
```

Output

```
null
```

Because

```
null

↓

Actual Argument

↓

Do NOT replace
```

---

### Visualization

```
Missing

↓

undefined

↓

Default Used

-----------------

Argument

↓

null

↓

Default Ignored
```

---

### Dry Run

```js
function test(x = 10){

    console.log(x);

}

test(undefined);

test(null);
```

Execution

```
test(undefined)

↓

Use Default

↓

10

----------------

test(null)

↓

Argument Exists

↓

null
```

Output

```
10

null
```

---

# 17. Multiple Default Parameters

Functions may contain multiple default values.

---

Example

```js
function createUser(

name = "Guest",

age = 18,

country = "India"

){

    console.log(name, age, country);

}

createUser();
```

Output

```
Guest 18 India
```

---

Passing some arguments

```js
createUser("Om");
```

Output

```
Om 18 India
```

---

Passing all arguments

```js
createUser("Om",22,"Japan");
```

Output

```
Om 22 Japan
```

---

Visualization

```
Parameter 1

↓

Argument?

↓

Yes

↓

Use It

----------------

Parameter 2

↓

Missing

↓

Default

----------------

Parameter 3

↓

Missing

↓

Default
```

---

# 18. Expressions as Default Values

A default value does not have to be a constant.

It can be **any JavaScript expression**.

---

Arithmetic

```js
function area(

length = 10,

width = 20

){

    return length * width;

}

console.log(area());
```

Output

```
200
```

---

Expression

```js
function test(

x = 5 * 10

){

    console.log(x);

}

test();
```

Output

```
50
```

---

Another Example

```js
function random(

value = Math.random()

){

    console.log(value);

}

random();
```

Every call generates a different value because the expression is evaluated **when the function is called**, not when it is defined.

---

# Summary (Part 2)

You learned:

- Lazy Evaluation
- Default Parameters vs ES5
- Default Parameters vs `||`
- Default Parameters vs `??`
- `undefined` vs `null`
- Multiple Default Parameters
- Expressions as Default Values

---

# Next Part

In **Part 3**, you'll learn:

- Function Calls as Default Values
- Objects as Default Values
- Arrays as Default Values
- Destructuring + Default Parameters
- Nested Destructuring
- Arrow Functions + Default Parameters
- Rest Parameters + Default Parameters
- `arguments` Object
- Scope of Default Parameters
- TDZ with Default Parameters
---

# 19. Function Calls as Default Values

A default value does not have to be

- A number
- A string
- A boolean

It can also be the **return value of another function**.

This is one of the most useful features of Default Parameters.

---

## Basic Example

```js
function getUsername() {
    return "Guest";
}

function login(username = getUsername()) {
    console.log(username);
}

login();
```

Output

```
Guest
```

---

## Dry Run

```
Call login()

↓

username Missing

↓

Call getUsername()

↓

Returns "Guest"

↓

Assign username

↓

Execute Function Body

↓

console.log(username)
```

---

## Passing an Argument

```js
login("Om");
```

Output

```
Om
```

Notice

```
getUsername()

↓

Never Called
```

Because

```
Argument Already Exists
```

---

## Another Example

```js
function randomNumber() {
    return Math.floor(Math.random() * 100);
}

function generate(number = randomNumber()) {
    console.log(number);
}

generate();
```

Possible Output

```
47
```

Every call can generate a different number.

---

## Important Rule

Default functions execute **only when needed**.

```js
function getValue() {
    console.log("Function Called");
    return 100;
}

function test(x = getValue()) {
    console.log(x);
}

test(10);
```

Output

```
10
```

Notice

```
Function Called
```

was never printed.

---

# 20. Objects as Default Values

Objects are commonly used as default values.

Example

```js
function printUser(user = {
    name: "Guest",
    age: 18
}) {
    console.log(user);
}

printUser();
```

Output

```js
{
    name: "Guest",
    age: 18
}
```

---

## Passing an Object

```js
printUser({
    name: "Om",
    age: 22
});
```

Output

```js
{
    name: "Om",
    age: 22
}
```

---

## Why is this useful?

Many APIs accept an **options object**.

Example

```js
function connect(options = {
    host: "localhost",
    port: 5000
}) {
    console.log(options);
}
```

Now

```js
connect();
```

works without errors.

---

# 21. Arrays as Default Values

Arrays can also be default values.

---

Example

```js
function printNumbers(numbers = [1, 2, 3]) {
    console.log(numbers);
}

printNumbers();
```

Output

```
[1, 2, 3]
```

---

Passing another array

```js
printNumbers([10,20,30]);
```

Output

```
[10,20,30]
```

---

Another Example

```js
function sum(numbers = []) {

    let total = 0;

    for (const num of numbers) {
        total += num;
    }

    console.log(total);

}

sum();
```

Output

```
0
```

Without a default value,

calling

```js
sum();
```

would cause an error.

---

# 22. Destructuring + Default Parameters

This is one of the most common React interview topics.

---

Basic Example

```js
function display({

    name = "Guest",

    age = 18

} = {}) {

    console.log(name, age);

}

display();
```

Output

```
Guest 18
```

---

## Why `= {}`?

Suppose we remove it.

```js
function display({

    name = "Guest"

}) {

    console.log(name);

}

display();
```

Output

```
TypeError
```

Because

```
display()

↓

undefined

↓

Cannot destructure undefined
```

---

Correct Version

```js
function display({

    name = "Guest"

} = {}) {

    console.log(name);

}
```

Now JavaScript uses

```
{}
```

when no object is supplied.

---

## Passing Values

```js
display({

    name:"Om",

    age:22

});
```

Output

```
Om 22
```

---

# 23. Nested Destructuring

Default Parameters also work with nested objects.

---

Example

```js
function show({

    address: {

        city = "Pune"

    } = {}

} = {}) {

    console.log(city);

}

show();
```

Output

```
Pune
```

---

Passing an object

```js
show({

    address: {

        city: "Mumbai"

    }

});
```

Output

```
Mumbai
```

---

Real-world Example

```js
function connect({

    database = "MongoDB",

    server = {

        host: "localhost",

        port: 27017

    }

} = {}) {

    console.log(database);

    console.log(server);

}
```

---

# 24. Arrow Functions + Default Parameters

Arrow Functions support Default Parameters exactly like regular functions.

---

Example

```js
const greet = (name = "Guest") => {

    console.log(name);

};

greet();
```

Output

```
Guest
```

---

Returning Values

```js
const add = (

a = 10,

b = 20

) => a + b;

console.log(add());
```

Output

```
30
```

---

Mixed Example

```js
const area = (

length = 10,

width = 20

) => length * width;

console.log(area());
```

Output

```
200
```

---

# 25. Rest Parameters + Default Parameters

Default Parameters and Rest Parameters can be used together.

---

Example

```js
function print(

title = "Numbers",

...values

) {

    console.log(title);

    console.log(values);

}

print();
```

Output

```
Numbers

[]
```

---

Passing Values

```js
print(

"Scores",

10,

20,

30

);
```

Output

```
Scores

[10,20,30]
```

---

## Important Rule

Rest Parameters **must always be the last parameter**.

Wrong

```js
function test(

...numbers,

name

){}
```

Output

```
SyntaxError
```

---

Correct

```js
function test(

name,

...numbers

){}
```

---

# 26. `arguments` Object

Before Rest Parameters,

JavaScript provided

```
arguments
```

---

Example

```js
function test(a = 10) {

    console.log(arguments);

}

test();
```

Output

```js
Arguments(0)
```

---

Passing Values

```js
test(50);
```

Output

```js
Arguments(1)

0 : 50
```

Notice

```
arguments

↓

Only Contains

Passed Arguments
```

It does **not** contain default values automatically.

---

Example

```js
function test(a = 10) {

    console.log(a);

    console.log(arguments[0]);

}

test();
```

Output

```
10

undefined
```

Why?

Because

```
a

↓

Parameter

↓

Uses Default Value

------------------

arguments

↓

Actual Arguments Only
```

---

# 27. Scope of Default Parameters

Default Parameters follow JavaScript's lexical scope rules.

---

Example

```js
let country = "India";

function show(

value = country

) {

    console.log(value);

}

show();
```

Output

```
India
```

---

Updating Variable

```js
country = "Japan";

show();
```

Output

```
Japan
```

Because

```
Default Parameter

↓

Looks Up Variable

↓

Current Value
```

---

# 28. TDZ with Default Parameters

One of the most important interview questions.

---

Wrong

```js
function test(

a = b,

b = 10

){

    console.log(a,b);

}

test();
```

Output

```
ReferenceError
```

---

Why?

Evaluation Order

```
Evaluate a

↓

Needs b

↓

b Not Initialized Yet

↓

TDZ

↓

ReferenceError
```

---

Correct

```js
function test(

b = 10,

a = b

){

    console.log(a,b);

}

test();
```

Output

```
10 10
```

---

# Summary (Part 3)

You learned:

- Function Calls as Default Values
- Objects as Default Values
- Arrays as Default Values
- Destructuring + Default Parameters
- Nested Destructuring
- Arrow Functions + Default Parameters
- Rest Parameters + Default Parameters
- `arguments` Object
- Scope of Default Parameters
- TDZ with Default Parameters

---

# Next Part (Final)

In **Part 4**, you'll learn:

- Memory Visualization
- Complete Dry Runs
- React Examples
- Node.js Examples
- Express Examples
- Best Practices
- Common Mistakes
- Interview Questions (25+)
- Coding Exercises
- Quick Revision Sheet
- Cheat Sheet
- Summary


# 29. Memory Visualization

Understanding how JavaScript handles Default Parameters internally makes interview questions much easier.

When a function is called,

JavaScript creates a **Function Execution Context**.

Inside it,

JavaScript first creates a **Parameter Environment**.

Only after all parameters are initialized does the function body execute.

---

## Visualization

```text
Function Call

↓

Create Function Execution Context

↓

Create Parameter Environment

↓

Assign Arguments

↓

Missing Argument?

↓

Yes

↓

Evaluate Default Value

↓

Assign Parameter

↓

Execute Function Body

↓

Return

↓

Destroy Function Context
```

---

## Example

```js
function greet(name = "Guest") {
    console.log(name);
}

greet();
```

Memory

```text
Call greet()

↓

Function Context

------------------------

Parameter Environment

name

↓

"Guest"

------------------------

Execute Function

↓

console.log(name)

↓

Guest
```

---

## Example 2

```js
function add(a, b = 10) {
    return a + b;
}

add(5);
```

Memory

```text
Call add(5)

↓

Parameter Environment

a

↓

5

----------------

b

↓

Missing

↓

10

----------------

Execute

↓

5 + 10

↓

15
```

---

## Example 3

```js
function test(a = 10, b = a + 5) {
    console.log(a, b);
}

test();
```

Memory

```text
Parameter Environment

a

↓

10

↓

b

↓

a + 5

↓

15
```

Output

```
10 15
```

---

# 30. Complete Dry Runs

---

## Dry Run 1

```js
function greet(name = "Guest") {
    console.log(name);
}

greet();
```

Execution

```text
Call greet()

↓

name Missing

↓

Assign "Guest"

↓

console.log(name)

↓

Guest
```

---

## Dry Run 2

```js
function greet(name = "Guest") {
    console.log(name);
}

greet("Om");
```

Execution

```text
Call greet()

↓

Argument Exists

↓

Use "Om"

↓

Ignore Default

↓

Print Om
```

---

## Dry Run 3

```js
function multiply(a = 5, b = a * 2) {
    console.log(a, b);
}

multiply();
```

Execution

```text
a Missing

↓

5

↓

b Missing

↓

a * 2

↓

10

↓

Print

5 10
```

---

## Dry Run 4

```js
function test(a = b, b = 10) {}

test();
```

Execution

```text
Evaluate a

↓

Need b

↓

b Not Initialized

↓

TDZ

↓

ReferenceError
```

---

## Dry Run 5

```js
function getValue() {
    console.log("Called");
    return 20;
}

function test(x = getValue()) {
    console.log(x);
}

test(50);
```

Execution

```text
x Already Exists

↓

Skip getValue()

↓

Print

50
```

Notice

```
Called
```

is never printed.

---

# 31. Real-world Examples

---

## Pagination

```js
function fetchUsers(page = 1) {
    console.log(`Fetching Page ${page}`);
}

fetchUsers();
```

Output

```
Fetching Page 1
```

---

## Shopping Cart

```js
function calculatePrice(price, tax = 18) {
    return price + tax;
}

console.log(calculatePrice(100));
```

Output

```
118
```

---

## Discount

```js
function applyDiscount(price, discount = 0) {
    return price - discount;
}

console.log(applyDiscount(500));
```

Output

```
500
```

---

## Configuration Object

```js
function connect({
    host = "localhost",
    port = 5000
} = {}) {
    console.log(host, port);
}

connect();
```

Output

```
localhost 5000
```

---

# 32. React Examples

Default Parameters are used frequently in React.

---

## Component Props

```jsx
function Button({
    text = "Submit"
}) {
    return <button>{text}</button>;
}
```

---

## Multiple Props

```jsx
function Card({

    title = "Untitled",

    color = "blue"

}) {

    return (

        <div>

            {title}

        </div>

    );

}
```

---

## Optional Callback

```jsx
function Button({

    onClick = () => {}

}) {

}
```

Useful when a callback is optional.

---

# 33. Node.js Examples

---

## Logger

```js
function logger(level = "INFO") {

    console.log(level);

}
```

---

## Server Configuration

```js
function createServer({

    host = "localhost",

    port = 5000

} = {}) {

    console.log(host, port);

}
```

---

## Database Connection

```js
function connect({

    database = "MongoDB",

    timeout = 5000

} = {}) {

    console.log(database);

}
```

---

# 34. Express Examples

---

## Pagination

```js
function getUsers(page = 1) {

    console.log(page);

}
```

---

## Middleware

```js
function logger(level = "INFO") {

    return (req, res, next) => {

        console.log(level);

        next();

    };

}
```

---

## API Options

```js
function fetchPosts({

    limit = 10,

    sort = "desc"

} = {}) {

}
```

---

# 35. Best Practices

✅ Use Default Parameters for optional arguments.

---

✅ Prefer Default Parameters over manual `if` statements.

---

✅ Prefer Default Parameters over `||`.

---

✅ Keep default values simple.

---

✅ Use object defaults for configuration.

---

✅ Place required parameters before optional parameters.

Example

```js
function login(username, remember = false) {}
```

Better than

```js
function login(remember = false, username) {}
```

---

# 36. Common Mistakes

---

## Mistake 1

Using `||` instead of Default Parameters.

Wrong

```js
age = age || 18;
```

---

Correct

```js
function test(age = 18) {}
```

---

## Mistake 2

Confusing `null` and `undefined`.

```js
function test(x = 10) {

    console.log(x);

}

test(null);
```

Output

```
null
```

---

## Mistake 3

Using later parameters.

Wrong

```js
function test(a = b, b = 10) {}
```

---

## Mistake 4

Forgetting `= {}`

Wrong

```js
function show({

    name

}) {}
```

Calling

```js
show();
```

causes

```
TypeError
```

---

Correct

```js
function show({

    name

} = {}) {}
```

---

# 37. Interview Questions

### What are Default Parameters?

Default values assigned to function parameters when arguments are missing or `undefined`.

---

### When are they evaluated?

When the function is called.

---

### Are they evaluated when the function is declared?

No.

They are evaluated during function invocation.

---

### Do they work for `null`?

No.

Only for missing arguments or `undefined`.

---

### Can they call functions?

Yes.

```js
function test(x = getValue()) {}
```

---

### Can they use previous parameters?

Yes.

```js
function test(a = 10, b = a) {}
```

---

### Can they use later parameters?

No.

It throws a `ReferenceError`.

---

### Why are they better than `||`?

Because they don't replace valid values like

- `0`
- `false`
- `""`

---

### Can objects be default values?

Yes.

---

### Can arrays be default values?

Yes.

---

### Can they be used with destructuring?

Yes.

Very common in React.

---

# 38. Coding Exercises

### Exercise 1

Convert

```js
function greet(name) {
    name = name || "Guest";
}
```

to ES6.

---

### Exercise 2

Predict the output.

```js
function test(x = 10) {
    console.log(x);
}

test();
```

---

### Exercise 3

Predict the output.

```js
test(undefined);

test(null);
```

---

### Exercise 4

Write

```js
calculatePrice(price, tax = 18)
```

---

### Exercise 5

Create

```js
login(username = "Guest")
```

---

### Exercise 6

Create a React component

```jsx
<Button text="Save" />
```

with a default prop.

---

### Exercise 7

Create

```js
connect({
    host = "localhost",
    port = 5000
} = {})
```

---

# 39. Quick Revision Sheet

```text
Default Parameters

↓

Used For

↓

Missing Arguments

↓

undefined

↓

Assign Default

------------------------

null

↓

Do NOT Replace

------------------------

Evaluated

↓

During Function Call

------------------------

Supports

↓

Expressions

↓

Functions

↓

Objects

↓

Arrays

↓

Destructuring

↓

Arrow Functions
```

---

# 40. One-Page Cheat Sheet

```js
function greet(name = "Guest") {}

function add(a = 10, b = a + 5) {}

function show({
    name = "Guest"
} = {}) {}

const sum = (a = 10, b = 20) => a + b;
```

---

## Remember

✅ Only used for

- Missing arguments
- `undefined`

❌ Not used for

- `null`
- `0`
- `false`
- `""`

---

## Evaluation Order

```text
Left

↓

Right
```

---

## Internal Flow

```text
Call Function

↓

Parameter Environment

↓

Assign Arguments

↓

Evaluate Defaults

↓

Execute Function

↓

Return
```

---

# 41. Summary

Congratulations! 🎉

You now understand Default Parameters from beginner to interview level.

You learned:

- ✅ Why Default Parameters were introduced
- ✅ ES5 vs ES6 approaches
- ✅ Internal Working
- ✅ Parameter Environment
- ✅ Evaluation Order
- ✅ Lazy Evaluation
- ✅ `undefined` vs `null`
- ✅ `||` vs `??` vs Default Parameters
- ✅ Expressions as defaults
- ✅ Function calls as defaults
- ✅ Objects & Arrays as defaults
- ✅ Destructuring with defaults
- ✅ Arrow Functions
- ✅ Rest Parameters
- ✅ `arguments` object
- ✅ Scope and TDZ
- ✅ Memory visualization
- ✅ Dry runs
- ✅ React, Node.js, and Express examples
- ✅ Best Practices
- ✅ Common Mistakes
- ✅ Interview Questions
- ✅ Coding Exercises
- ✅ Quick Revision Sheet
- ✅ Cheat Sheet

---

# What's Next?

➡️ **06-Rest-Parameters.md**

You'll learn:

- Why Rest Parameters were introduced
- `...` syntax
- Rest vs Spread
- Rest vs `arguments`
- Internal Working
- Memory Visualization
- React & Node.js examples
- Interview Questions
- Coding Exercises
- Cheat Sheet