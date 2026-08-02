# Template Literals

> **"Template Literals make string creation cleaner, more readable, and more powerful by allowing variable interpolation, multi-line strings, embedded expressions, and tagged templates."**

---

# Table of Contents

1. Introduction
2. Why Template Literals Were Introduced
3. Problems Before ES6
4. Syntax
5. Backticks vs Single Quotes vs Double Quotes
6. String Interpolation
7. Expression Interpolation
8. Multi-line Strings
9. Summary (Part 1)

---

# 1. Introduction

Before ES6, JavaScript developers created strings using

- Single Quotes (`' '`)
- Double Quotes (`" "`)

Example

```js
const language = "JavaScript";

console.log(language);
```

Output

```
JavaScript
```

This worked well for simple strings.

However,

as applications became larger,

creating dynamic strings became difficult.

Example

```js
const name = "Om";

const city = "Pune";

console.log("Hello " + name + ", Welcome to " + city);
```

Output

```
Hello Om, Welcome to Pune
```

Imagine doing this with

- 10 variables
- HTML
- SQL
- URLs
- Emails

The code quickly becomes difficult to read.

To solve this,

ES6 introduced

```
Template Literals
```

---

## What are Template Literals?

Template Literals are strings enclosed inside

```
Backticks

`

NOT

"

NOT

'
```

Example

```js
const name = "Om";

console.log(`Hello ${name}`);
```

Output

```
Hello Om
```

---

## Why are Template Literals Important?

Modern JavaScript uses Template Literals everywhere.

Examples

- React JSX
- Node.js
- Express
- API URLs
- Logging
- HTML Generation
- Email Templates
- SQL Queries
- GraphQL
- Styled Components

If you work on a modern JavaScript project,

you will use Template Literals every day.

---

# 2. Why Template Literals Were Introduced

Before ES6,

JavaScript developers had four major problems.

```
String Concatenation

↓

Poor Readability

↓

Multi-line Strings

↓

Dynamic HTML
```

Let's understand each one.

---

## Problem 1 — Too Much Concatenation

Example

```js
const firstName = "Om";

const lastName = "Rajput";

console.log("Hello " + firstName + " " + lastName);
```

Output

```
Hello Om Rajput
```

This looks acceptable.

Now imagine

```js
const name = "Om";

const city = "Pune";

const age = 22;

const company = "Google";

console.log(
"Name : " + name +
", City : " + city +
", Age : " + age +
", Company : " + company
);
```

Reading this becomes difficult.

---

Template Literals solve this.

```js
console.log(

`Name : ${name},
City : ${city},
Age : ${age},
Company : ${company}`

);
```

Much cleaner.

---

## Problem 2 — Difficult Multi-line Strings

Before ES6

```js
const message =

"Hello\n" +

"Welcome\n" +

"JavaScript";
```

Output

```
Hello

Welcome

JavaScript
```

Developers constantly had to write

```
\n

+

+
```

Template Literals eliminate this completely.

---

## Problem 3 — HTML Generation

Suppose you want

```html
<div>

<h1>Om</h1>

</div>
```

Before ES6

```js
const html =

"<div>" +

"<h1>" +

name +

"</h1>" +

"</div>";
```

Hard to read.

Template Literals

```js
const html =

`

<div>

<h1>${name}</h1>

</div>

`;
```

Almost identical to actual HTML.

---

## Problem 4 — Dynamic Strings

Old JavaScript

```js
const id = 25;

const url = "/users/" + id;
```

Modern JavaScript

```js
const url = `/users/${id}`;
```

Cleaner.

---

# 3. Problems Before ES6

Let's summarize.

Before ES6

❌ Too many +

❌ Difficult HTML

❌ Difficult SQL

❌ Difficult Emails

❌ Difficult Multi-line Strings

❌ Poor Readability

---

After ES6

✅ Cleaner

✅ Easier

✅ More Readable

✅ Dynamic

✅ Less Error-Prone

---

# 4. Syntax

Template Literals use

```
Backticks

`
```

instead of

```
"

'

```

Example

```js
const language = `JavaScript`;

console.log(language);
```

Output

```
JavaScript
```

---

General Syntax

```js
const message = `Text`;
```

---

Dynamic Syntax

```js
const message = `Hello ${name}`;
```

---

General Form

```js
`

Text

${Expression}

Text

`
```

---

# 5. Backticks vs Single Quotes vs Double Quotes

JavaScript supports three ways to write strings.

---

## Single Quotes

```js
const language = 'JavaScript';
```

---

## Double Quotes

```js
const language = "JavaScript";
```

---

## Backticks

```js
const language = `JavaScript`;
```

---

All three create strings.

However,

only Backticks support

- Interpolation
- Multi-line Strings
- Tagged Templates

---

Comparison

| Feature | ' ' | " " | ` ` |
|----------|:---:|:---:|:---:|
| Normal Strings | ✅ | ✅ | ✅ |
| Variable Interpolation | ❌ | ❌ | ✅ |
| Multi-line Strings | ❌ | ❌ | ✅ |
| Tagged Templates | ❌ | ❌ | ✅ |

---

Interview Question

Can Template Literals replace normal strings?

Yes.

Template Literals can do everything normal strings can,

plus much more.

---

# 6. String Interpolation

Interpolation means

> **Inserting a variable into a string.**

---

Before ES6

```js
const name = "Om";

console.log("Hello " + name);
```

Output

```
Hello Om
```

---

Using Template Literals

```js
const name = "Om";

console.log(`Hello ${name}`);
```

Output

```
Hello Om
```

---

How It Works

```
Template Literal

↓

Find

${}

↓

Evaluate

↓

Convert to String

↓

Insert Result
```

---

Multiple Variables

```js
const firstName = "Om";

const lastName = "Rajput";

console.log(

`Hello ${firstName} ${lastName}`

);
```

Output

```
Hello Om Rajput
```

---

Different Data Types

```js
const age = 22;

const isStudent = true;

console.log(

`Age : ${age}

Student : ${isStudent}`

);
```

Output

```
Age : 22

Student : true
```

Everything inside

```
${}
```

is automatically converted into a string.

---

# 7. Expression Interpolation

The most powerful feature is that

`${}` accepts **any JavaScript expression**.

It is **not limited to variables**.

---

Arithmetic

```js
console.log(`${10 + 20}`);
```

Output

```
30
```

---

Multiplication

```js
console.log(`${5 * 8}`);
```

Output

```
40
```

---

Division

```js
console.log(`${100 / 5}`);
```

Output

```
20
```

---

Boolean Expression

```js
const age = 22;

console.log(`${age >= 18}`);
```

Output

```
true
```

---

Comparison

```js
console.log(`${10 > 20}`);
```

Output

```
false
```

---

Ternary Operator

```js
const age = 20;

console.log(

`${age >= 18 ? "Adult" : "Minor"}`

);
```

Output

```
Adult
```

---

Method Calls

```js
const language = "javascript";

console.log(

`${language.toUpperCase()}`

);
```

Output

```
JAVASCRIPT
```

---

Property Access

```js
const user = {

name:"Om"

};

console.log(

`${user.name}`

);
```

Output

```
Om
```

---

Array Access

```js
const numbers = [10,20,30];

console.log(

`${numbers[1]}`

);
```

Output

```
20
```

---

# 8. Multi-line Strings

Before ES6,

multi-line strings were frustrating.

```js
const text =

"Hello\n" +

"Welcome\n" +

"JavaScript";
```

Output

```
Hello

Welcome

JavaScript
```

---

Template Literals

```js
const text = `

Hello

Welcome

JavaScript

`;

console.log(text);
```

Output

```
Hello

Welcome

JavaScript
```

---

Why is this useful?

Because

- HTML
- Emails
- SQL
- Markdown
- JSON

are naturally multi-line.

Template Literals preserve formatting,

making your code much easier to read.

---

# 9. Summary (Part 1)

You learned

- What Template Literals are
- Why ES6 introduced them
- Problems before ES6
- Syntax
- Backticks vs Quotes
- String Interpolation
- Expression Interpolation
- Multi-line Strings

---

# Next Part

In **Part 2**, you'll learn:

- Function Calls inside `${}`
- Objects & Arrays
- Nested Template Literals
- Tagged Template Literals
- HTML Generation
- Email Templates
- URL Generation
- SQL Queries
- JSON Formatting
- Real-world Examples


# 10. Function Calls inside `${}`

One of the most powerful features of Template Literals is that you can execute **JavaScript code** inside `${}`.

You are not limited to variables.

You can call

- Functions
- Methods
- Expressions
- Calculations
- Ternary Operators
- Logical Operators

---

## Function Calls

Example

```js
function greet(name) {

    return `Hello ${name}`;

}

console.log(

`${greet("Om")}`

);
```

Output

```
Hello Om
```

---

## Dry Run

```
Template Literal

↓

${greet("Om")}

↓

Call greet()

↓

Return "Hello Om"

↓

Insert into String

↓

Output
```

---

## Arrow Function

```js
const add = (a,b)=>a+b;

console.log(

`Sum = ${add(10,20)}`

);
```

Output

```
Sum = 30
```

---

## Multiple Function Calls

```js
const square = n=>n*n;

console.log(

`${square(2)}

${square(3)}

${square(4)}`

);
```

Output

```
4

9

16
```

---

## Method Calls

Objects

```js
const user={

    name:"Om"

};

console.log(

`${user.name.toUpperCase()}`

);
```

Output

```
OM
```

---

## String Methods

```js
const language="javascript";

console.log(

`${language.toUpperCase()}`

);
```

Output

```
JAVASCRIPT
```

---

## Array Methods

```js
const numbers=[10,20,30];

console.log(

`${numbers.join(", ")}`

);
```

Output

```
10, 20, 30
```

---

# 11. Objects and Arrays

Objects work perfectly inside Template Literals.

---

## Object Property

```js
const person={

    name:"Om",

    age:22

};

console.log(

`Name : ${person.name}`

);
```

Output

```
Name : Om
```

---

## Multiple Properties

```js
console.log(

`Name : ${person.name}

Age : ${person.age}`

);
```

Output

```
Name : Om

Age : 22
```

---

## Array Access

```js
const colors=[

"Red",

"Green",

"Blue"

];

console.log(

`${colors[0]}`

);
```

Output

```
Red
```

---

## Array Length

```js
const fruits=[

"Apple",

"Banana",

"Orange"

];

console.log(

`Total Fruits : ${fruits.length}`

);
```

Output

```
Total Fruits : 3
```

---

## Loop Output

```js
const numbers=[1,2,3];

console.log(

`${numbers.map(

num=>num*2

)}`

);
```

Output

```
2,4,6
```

Notice

```
Array

↓

Automatically Converted

↓

String
```

---

# 12. Expressions inside `${}`

Anything that produces a value is allowed.

---

## Arithmetic

```js
console.log(

`${20+10}`

);
```

Output

```
30
```

---

## Comparison

```js
console.log(

`${20>10}`

);
```

Output

```
true
```

---

## Logical AND

```js
const isLoggedIn=true;

console.log(

`${isLoggedIn && "Welcome"}`

);
```

Output

```
Welcome
```

---

## Logical OR

```js
const username="";

console.log(

`${username || "Guest"}`

);
```

Output

```
Guest
```

---

## Nullish Coalescing

```js
const city=null;

console.log(

`${city ?? "Pune"}`

);
```

Output

```
Pune
```

---

## Optional Chaining

```js
const user={

name:"Om"

};

console.log(

`${user.address?.city}`

);
```

Output

```
undefined
```

No error occurs.

---

## Ternary Operator

```js
const age=22;

console.log(

`${age>=18?"Adult":"Minor"}`

);
```

Output

```
Adult
```

---

# 13. Nested Template Literals

Template Literals can exist inside another Template Literal.

---

Example

```js
const first="Om";

const last="Rajput";

console.log(

`Welcome ${`${first} ${last}`}`

);
```

Output

```
Welcome Om Rajput
```

---

## Visualization

```
Outer Template

↓

Inner Template

↓

Evaluate

↓

Insert

↓

Output
```

---

## Another Example

```js
const product="Laptop";

const price=50000;

console.log(

`${`${product}`} costs ₹${price}`

);
```

Output

```
Laptop costs ₹50000
```

---

## Should We Use Nested Templates?

Technically

✅ Yes

Practically

❌ Rarely

Deeply nested Template Literals become difficult to read.

---

# 14. Tagged Template Literals

One of the most advanced ES6 features.

A Tagged Template allows a function to process a Template Literal before JavaScript creates the final string.

---

General Syntax

```js
tagFunction`Hello ${name}`
```

Notice

```
No ()

No Comma

No Quotes
```

---

## Example

```js
function tag(strings,value){

    console.log(strings);

    console.log(value);

}

const name="Om";

tag`Hello ${name}`;
```

Output

```js
["Hello ",""]

Om
```

---

## What Happens Internally?

JavaScript converts

```js
tag`Hello ${name}`
```

into

```
strings

↓

["Hello ",""]

values

↓

["Om"]

↓

Call Function
```

---

## Visualization

```
Template Literal

↓

Split Static Text

↓

Extract Variables

↓

Call Tag Function

↓

Return Final String
```

---

## Multiple Variables

```js
function tag(strings,...values){

    console.log(strings);

    console.log(values);

}

const first="Om";

const last="Rajput";

tag`Hello ${first} ${last}`;
```

Output

```js
["Hello "," ",""]

["Om","Rajput"]
```

---

## Return Value

Tagged Functions may return anything.

Example

```js
function upper(strings,value){

    return strings[0]+value.toUpperCase();

}

const name="om";

console.log(

upper`Hello ${name}`

);
```

Output

```
Hello OM
```

---

# 15. Real-world Uses of Tagged Templates

Tagged Templates are used by many popular libraries.

---

## Styled Components

```jsx
const Button = styled.button`

background:red;

color:white;

`;
```

---

## GraphQL

```js
const query = gql`

query{

users{

id

name

}

}

`;
```

---

## SQL Builders

```js
sql`

SELECT *

FROM users

`;
```

---

## Internationalization (i18n)

```js
translate`

Hello ${name}

`;
```

---

# Summary (Part 2)

You learned

- Function Calls
- Method Calls
- Objects
- Arrays
- Expressions
- Optional Chaining
- Nullish Coalescing
- Nested Templates
- Tagged Templates
- Tagged Template Internals
- Real-world Uses

---

# Next Part

In **Part 3**, you'll learn:

- HTML Generation
- Email Templates
- Dynamic URLs
- SQL Queries
- JSON Formatting
- React Examples
- Node.js Examples
- Performance
- Best Practices
- Common Mistakes
- Interview Questions
- Coding Exercises
- Quick Revision Sheet
- Chapter Summary


# 16. Real-World Examples

Template Literals are used extensively in modern JavaScript applications.

You'll see them in

- React
- Node.js
- Express
- APIs
- HTML
- Emails
- Logging
- SQL
- GraphQL
- Markdown
- JSON

Let's study the most common examples.

---

# 16.1 Generating HTML

Suppose you want to create HTML dynamically.

Without Template Literals

```js
const name = "Om";

const html =
"<div>" +
"<h1>" + name + "</h1>" +
"</div>";

console.log(html);
```

Output

```html
<div>
<h1>Om</h1>
</div>
```

---

Using Template Literals

```js
const name = "Om";

const html = `

<div>

    <h1>${name}</h1>

</div>

`;

console.log(html);
```

Much cleaner.

Almost identical to HTML.

---

## Larger Example

```js
const product = {

    name: "MacBook Air",

    price: 95000,

    stock: true

};

const card = `

<div class="card">

    <h2>${product.name}</h2>

    <p>₹${product.price}</p>

    <p>${product.stock ? "Available" : "Out of Stock"}</p>

</div>

`;

console.log(card);
```

Output

```html
<div class="card">

<h2>MacBook Air</h2>

<p>₹95000</p>

<p>Available</p>

</div>
```

---

# 16.2 Email Templates

Companies generate millions of emails every day.

Template Literals make this easy.

```js
const customer = "Om";

const orderId = 1045;

const email = `

Dear ${customer},

Your order #${orderId} has been shipped.

Thank you for shopping with us.

`;

console.log(email);
```

Output

```
Dear Om,

Your order #1045 has been shipped.

Thank you for shopping with us.
```

---

# 16.3 Dynamic URLs

Suppose your backend exposes

```
GET

/users/:id
```

Instead of

```js
const url = "/users/" + id;
```

Write

```js
const id = 25;

const url = `/users/${id}`;

console.log(url);
```

Output

```
/users/25
```

---

Nested URL

```js
const userId = 20;

const postId = 15;

const url = `/users/${userId}/posts/${postId}`;

console.log(url);
```

Output

```
/users/20/posts/15
```

---

Query Parameters

```js
const search = "Laptop";

const page = 2;

const url = `/products?q=${search}&page=${page}`;

console.log(url);
```

Output

```
/products?q=Laptop&page=2
```

---

# 16.4 Logging

Node.js applications constantly log messages.

Without Template Literals

```js
console.log(

"Server started on port " + port

);
```

Modern way

```js
const port = 5000;

console.log(

`Server started on port ${port}`

);
```

Output

```
Server started on port 5000
```

---

Logging User Login

```js
const username = "Om";

const time = "10:30 AM";

console.log(

`${username} logged in at ${time}`

);
```

Output

```
Om logged in at 10:30 AM
```

---

# 16.5 SQL Queries

Example

```js
const id = 10;

const query =

`SELECT *

FROM users

WHERE id = ${id}`;
```

Output

```sql
SELECT *

FROM users

WHERE id = 10
```

---

## ⚠ Important

Never build SQL queries like this in production.

Example

```js
const id = userInput;

const query =

`SELECT *

FROM users

WHERE id = ${id}`;
```

This may cause

```
SQL Injection
```

Instead,

use

```
Prepared Statements

Parameterized Queries
```

Example

```js
SELECT *

FROM users

WHERE id = ?
```

Always let your database library safely insert user values.

---

# 16.6 JSON Formatting

Example

```js
const user = {

    name: "Om",

    age: 22

};

console.log(

`User

${JSON.stringify(user,null,2)}`

);
```

Output

```json
User

{

"name":"Om",

"age":22

}
```

---

# 16.7 Markdown Generation

GitHub READMEs

```js
const project = "JavaScript Handbook";

const markdown =

`

# ${project}

Created by Om

`;

console.log(markdown);
```

---

# 16.8 Report Generation

```js
const employee = {

    name:"Rahul",

    salary:50000,

    department:"IT"

};

const report =

`

Employee Report

---------------

Name : ${employee.name}

Department : ${employee.department}

Salary : ₹${employee.salary}

`;

console.log(report);
```

---

# 17. React Examples

React uses Template Literals almost everywhere.

---

## JSX

```jsx
const name="Om";

function App(){

    return(

        <h1>{`Welcome ${name}`}</h1>

    );

}
```

---

## Dynamic className

```jsx
const theme="dark";

<div

className={`card ${theme}`}

>

</div>
```

Output

```html
<div class="card dark">

</div>
```

---

## Dynamic Styles

```jsx
const color="red";

const style={

color:`${color}`

};
```

---

## Dynamic Image Path

```jsx
const image="profile.png";

<img

src={`/images/${image}`}

/>
```

---

## Rendering Lists

```jsx
users.map(user=>

<li>

{`${user.firstName} ${user.lastName}`}

</li>

)
```

---

# 18. Node.js Examples

---

## Express

```js
app.get(

"/users/:id",

(req,res)=>{

res.send(

`User ${req.params.id}`

);

});
```

---

## Console Logs

```js
console.log(

`Server running on port ${PORT}`

);
```

---

## Error Messages

```js
throw new Error(

`User ${id} not found`

);
```

---

## API Response

```js
res.json({

message:`Welcome ${username}`

});
```

---

## File Path

```js
const filename="data.json";

const path=

`./files/${filename}`;
```

---

# 19. Performance Considerations

Interview Question

Are Template Literals faster than string concatenation?

Answer

For most applications,

the performance difference is **negligible**.

Choose the version that is

- easier to read
- easier to maintain

Modern JavaScript engines optimize both approaches very well.

---

## When to Prefer Template Literals

✅ Dynamic strings

✅ HTML

✅ URLs

✅ Emails

✅ Logging

✅ React

✅ Node.js

---

## When Quotes are Fine

Simple strings

```js
const language="JavaScript";
```

There is no need to use Template Literals when interpolation is not required.

---

# 20. Best Practices

---

## Rule 1

Prefer Template Literals over string concatenation.

---

## Rule 2

Keep long templates properly indented.

---

## Rule 3

Avoid deeply nested Template Literals.

---

## Rule 4

Use meaningful variable names.

---

## Rule 5

Never build SQL queries using user input.

Use parameterized queries.

---

## Rule 6

Use Template Literals for

- HTML
- JSX
- Emails
- Logs
- URLs

---

# Summary (Part 3)

You learned

- HTML Generation
- Email Templates
- Dynamic URLs
- Query Parameters
- Logging
- SQL Queries
- SQL Injection Warning
- JSON Formatting
- Markdown Generation
- Report Generation
- React Examples
- Node.js Examples
- Performance
- Best Practices

---

# Next Part

**Part 4 (Final)**

You'll learn:

- Common Mistakes
- Interview Questions (25+)
- Coding Exercises
- Cheat Sheet
- Quick Revision Sheet
- Chapter Summary
- Professional Notes


# 21. Common Mistakes

Even experienced JavaScript developers sometimes misuse Template Literals.

Understanding these mistakes will help you write cleaner and more maintainable code.

---

## Mistake 1 — Using Quotes Instead of Backticks

❌ Wrong

```js
const name = "Om";

console.log("Hello ${name}");
```

Output

```
Hello ${name}
```

Why?

Because interpolation only works with **backticks (` `)**.

---

✅ Correct

```js
const name = "Om";

console.log(`Hello ${name}`);
```

Output

```
Hello Om
```

---

# Mistake 2 — Forgetting `${}`

❌ Wrong

```js
const name = "Om";

console.log(`Hello name`);
```

Output

```
Hello name
```

JavaScript treats

```
name
```

as plain text.

---

✅ Correct

```js
const name = "Om";

console.log(`Hello ${name}`);
```

Output

```
Hello Om
```

---

# Mistake 3 — Trying to Execute Statements

Only **expressions** are allowed inside `${}`.

---

❌ Wrong

```js
`${if(true){}}`
```

Output

```
SyntaxError
```

---

Why?

Because

```
if

for

while

switch
```

are **statements**,

not expressions.

---

## Allowed

```js
`${10 + 20}`
```

```js
`${age > 18}`
```

```js
`${age > 18 ? "Adult" : "Minor"}`
```

These are expressions.

---

# Mistake 4 — Forgetting Parentheses When Returning Objects

Wrong

```js
const user = () => {
    name: "Om";
};

console.log(user());
```

Output

```
undefined
```

---

Correct

```js
const user = () => ({
    name: "Om"
});

console.log(user());
```

Output

```js
{
    name: "Om"
}
```

---

# Mistake 5 — Deeply Nested Template Literals

❌ Difficult to Read

```js
`${`${`${name}`}`}`
```

Avoid this.

---

Better

```js
`${name}`
```

---

# Mistake 6 — Using Template Literals for Every String

Not every string needs Template Literals.

---

Simple String

```js
const language = "JavaScript";
```

is perfectly fine.

No need for

```js
const language = `JavaScript`;
```

unless interpolation or multiline strings are required.

---

# Mistake 7 — Building SQL Queries Directly

Wrong

```js
const id = userInput;

const query =

`SELECT *

FROM users

WHERE id = ${id}`;
```

Danger

```
SQL Injection
```

---

Correct

```sql
SELECT *

FROM users

WHERE id = ?
```

Always use parameterized queries.

---

# Mistake 8 — Forgetting Method Parentheses

Wrong

```js
const name = "Om";

console.log(`${name.toUpperCase}`);
```

Output

```
function toUpperCase() { ... }
```

---

Correct

```js
console.log(`${name.toUpperCase()}`);
```

Output

```
OM
```

---

# 22. Interview Questions

These are some of the most frequently asked interview questions on Template Literals.

---

## Q1. What are Template Literals?

Template Literals are strings enclosed in **backticks (` `)** that support:

- String interpolation
- Multi-line strings
- Embedded expressions
- Tagged templates

---

## Q2. Why were Template Literals introduced?

To solve problems with:

- String concatenation
- Readability
- Multi-line strings
- Dynamic HTML generation

---

## Q3. Which symbol is used?

Backticks

```
`
```

---

## Q4. What is `${}`?

It is an interpolation placeholder.

Everything inside it is evaluated as a JavaScript expression.

---

## Q5. Can expressions be used inside `${}`?

Yes.

Example

```js
`${10 + 20}`
```

---

## Q6. Can functions be called inside `${}`?

Yes.

```js
`${add(2,3)}`
```

---

## Q7. Can methods be called?

Yes.

```js
`${name.toUpperCase()}`
```

---

## Q8. Can objects be accessed?

Yes.

```js
`${user.name}`
```

---

## Q9. Can arrays be accessed?

Yes.

```js
`${numbers[0]}`
```

---

## Q10. Can loops be written inside `${}`?

No.

Loops are statements.

Only expressions are allowed.

---

## Q11. What are Tagged Templates?

Tagged Templates allow a function to process a Template Literal before JavaScript creates the final string.

---

## Q12. Name some libraries using Tagged Templates.

- styled-components
- GraphQL (`gql`)
- lit-html
- SQL builders
- i18n libraries

---

## Q13. Difference between String Concatenation and Template Literals?

| Concatenation | Template Literals |
|--------------|-------------------|
| Uses `+` | Uses `${}` |
| Difficult to read | Easier to read |
| Poor for multiline | Excellent |
| Less maintainable | More maintainable |

---

## Q14. Are Template Literals faster?

For normal applications,

performance differences are negligible.

Choose readability.

---

## Q15. When should you use Template Literals?

Whenever you need:

- Dynamic strings
- HTML
- URLs
- Logging
- Emails
- SQL (only for static parts)
- React JSX

---

# 23. Coding Exercises

## Exercise 1

Convert

```js
const name = "Om";

console.log("Hello " + name);
```

to Template Literals.

---

## Exercise 2

Predict the output.

```js
const a = 10;
const b = 20;

console.log(`${a + b}`);
```

---

## Exercise 3

Predict the output.

```js
const language = "javascript";

console.log(`${language.toUpperCase()}`);
```

---

## Exercise 4

Create

```
Name : Om

Age : 22
```

using Template Literals.

---

## Exercise 5

Generate

```
/users/50
```

using

```js
const id = 50;
```

---

## Exercise 6

Create an email.

Expected Output

```
Dear Om,

Your order has been delivered.

Thank you.
```

---

## Exercise 7

Generate HTML

```html
<h1>JavaScript</h1>
```

using Template Literals.

---

## Exercise 8

Use a ternary operator inside `${}`.

Expected Output

```
Adult
```

---

## Exercise 9

Create

```
Laptop costs ₹75000
```

using an object.

---

## Exercise 10

Write a Tagged Template that converts every interpolated value to uppercase.

---

# 24. Quick Revision Sheet

## Syntax

```js
`Hello ${name}`
```

---

## Supports

✅ Variables

✅ Expressions

✅ Function Calls

✅ Method Calls

✅ Multi-line Strings

✅ Tagged Templates

---

## Common Uses

- HTML
- JSX
- URLs
- Logging
- Emails
- Markdown
- SQL Templates
- JSON Formatting

---

## Allowed Inside `${}`

```js
${10 + 20}

${user.name}

${numbers[0]}

${name.toUpperCase()}

${age >= 18}

${isAdmin ? "Yes" : "No"}

${city ?? "Pune"}

${user.address?.city}
```

---

## Not Allowed

```js
${if (...) {}}

${for (...) {}}

${while (...) {}}

${switch (...) {}}
```

Because these are statements.

---

# 25. Professional Best Practices

✅ Prefer Template Literals over string concatenation.

✅ Use meaningful variable names.

✅ Keep multi-line templates properly indented.

✅ Avoid deeply nested Template Literals.

✅ Use parameterized SQL queries instead of directly interpolating user input.

✅ Use Template Literals whenever readability improves.

---

# 26. One-Page Cheat Sheet

```
Template Literal

↓

Uses Backticks (` `)

↓

Supports

↓

Variables

↓

${name}

↓

Expressions

↓

${10+20}

↓

Methods

↓

${name.toUpperCase()}

↓

Functions

↓

${greet(name)}

↓

Objects

↓

${user.name}

↓

Arrays

↓

${arr[0]}

↓

Multi-line Strings

↓

Tagged Templates
```

---

# 27. Summary

Congratulations! 🎉

You have mastered one of the most widely used ES6 features.

You learned:

- ✅ Why Template Literals were introduced
- ✅ Backticks vs Quotes
- ✅ String Interpolation
- ✅ Expression Interpolation
- ✅ Multi-line Strings
- ✅ Function Calls
- ✅ Method Calls
- ✅ Objects & Arrays
- ✅ Nested Template Literals
- ✅ Tagged Template Literals
- ✅ HTML Generation
- ✅ Email Templates
- ✅ Dynamic URLs
- ✅ SQL Queries & SQL Injection Awareness
- ✅ React Examples
- ✅ Node.js Examples
- ✅ Performance Considerations
- ✅ Best Practices
- ✅ Common Mistakes
- ✅ Interview Questions
- ✅ Coding Exercises
- ✅ Quick Revision Sheet
- ✅ Cheat Sheet

---

# What's Next?

➡️ **05-Default-Parameters.md**

You'll learn:

- Why Default Parameters were introduced
- How they work internally
- `undefined` vs `null`
- Default expressions
- Function evaluation order
- Rest Parameters interaction
- React & Node.js examples
- Common mistakes
- Interview questions
- Coding exercises
- Cheat sheet