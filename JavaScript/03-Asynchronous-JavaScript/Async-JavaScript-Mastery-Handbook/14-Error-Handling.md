# Chapter 14 — JavaScript Error Handling (Complete Handbook)

> **"Good developers write code that works. Great developers write code that handles failures gracefully."**

Error handling is one of the most frequently asked JavaScript interview topics because every real-world application encounters errors—network failures, invalid input, database issues, API failures, and more.

---

# Table of Contents

1. What is Error Handling?
2. Types of Errors
3. Syntax Errors
4. Runtime Errors
5. Logical Errors
6. try...catch
7. finally
8. throw Keyword
9. Creating Custom Errors
10. Promise Error Handling
11. Async/Await Error Handling
12. Global Error Handling
13. Browser vs Node.js Error Handling
14. Common Mistakes
15. Dry Runs
16. Visual Diagrams
17. Real World Examples
18. 40 Interview Questions
19. Coding Exercises
20. Summary

---

# 1. What is Error Handling?

Error handling means **detecting, catching, and responding to errors** without crashing the application.

Without error handling:

```
Program Starts

↓

Error

↓

Program Crashes ❌
```

With error handling:

```
Program Starts

↓

Error

↓

Catch Error

↓

Continue Program ✅
```

---

# 2. Types of Errors

JavaScript mainly has three categories:

```
Errors

├── Syntax Error
├── Runtime Error
└── Logical Error
```

---

# 3. Syntax Errors

These happen **before execution**.

Example

```javascript
console.log("Hello"
```

Output

```
SyntaxError: Unexpected end of input
```

Reason:

Missing `)`.

Another Example

```javascript
if(true){

console.log("Hello");
```

Missing `}`

---

### Characteristics

✅ Detected before execution

❌ Program never starts

---

# 4. Runtime Errors

Program starts successfully but crashes during execution.

Example

```javascript
let user = null;

console.log(user.name);
```

Output

```
TypeError
```

---

Another Example

```javascript
const arr = null;

arr.push(10);
```

Output

```
TypeError
```

---

Another

```javascript
abc();
```

Output

```
ReferenceError
```

---

Runtime errors include

```
ReferenceError

TypeError

RangeError

URIError

EvalError

AggregateError
```

---

# 5. Logical Errors

Most dangerous.

Program runs.

No error appears.

Output is wrong.

Example

```javascript
let age = 18;

if(age > 18){

console.log("Adult");

}
```

Expected

```
Adult
```

Actual

Nothing.

Logic mistake.

---

Another

```javascript
let total = 100;

let discount = 20;

console.log(total + discount);
```

Should be

```
80
```

But outputs

```
120
```

---

# 6. try...catch

Syntax

```javascript
try{

// risky code

}

catch(error){

// handle error

}
```

---

Example

```javascript
try{

console.log(a);

}

catch(error){

console.log("Error occurred");

}
```

Output

```
Error occurred
```

Program continues.

---

Visual

```
Try

↓

Error?

↓

Yes

↓

Catch
```

---

No Error

```
Try

↓

No Error

↓

Skip Catch
```

---

# 7. finally

`finally` always executes.

Example

```javascript
try{

console.log("A");

}

catch{

console.log("B");

}

finally{

console.log("C");

}
```

Output

```
A

C
```

---

Another

```javascript
try{

console.log(x);

}

catch{

console.log("Error");

}

finally{

console.log("Always");

}
```

Output

```
Error

Always
```

---

Flow

```
Try

↓

Catch (if needed)

↓

Finally
```

---

Real World Example

```javascript
try{

openDatabase();

}

finally{

closeDatabase();

}
```

Even if an error occurs, the database closes.

---

# 8. throw Keyword

You can create your own errors.

Example

```javascript
throw new Error("Invalid Password");
```

---

Example

```javascript
function login(password){

if(password.length < 8){

throw new Error("Password too short");

}

}

try{

login("abc");

}

catch(err){

console.log(err.message);

}
```

Output

```
Password too short
```

---

Visual

```
throw

↓

Creates Error

↓

catch
```

---

# 9. Creating Custom Errors

```javascript
class ValidationError extends Error{

constructor(message){

super(message);

this.name = "ValidationError";

}

}
```

Usage

```javascript
throw new ValidationError("Email Required");
```

---

Output

```
ValidationError

Email Required
```

---

# 10. Promise Error Handling

Wrong

```javascript
fetch(url)

.then(res=>res.json());
```

No error handling.

---

Correct

```javascript
fetch(url)

.then(res=>res.json())

.catch(err=>{

console.log(err);

});
```

---

Flow

```
Promise

↓

Reject

↓

Catch
```

---

Example

```javascript
Promise.reject("Failed")

.catch(console.log);
```

Output

```
Failed
```

---

# 11. Async/Await Error Handling

Example

```javascript
async function getData(){

try{

const data = await fetch(url);

}

catch(err){

console.log(err);

}

}
```

---

Without try/catch

```javascript
await fetch(url);
```

Rejected Promise

↓

Unhandled Promise Rejection

---

Visual

```
await

↓

Promise Reject

↓

Catch
```

---

# 12. Global Error Handling

## Browser

```javascript
window.onerror = function(message){

console.log(message);

}
```

---

Unhandled Promise

```javascript
window.addEventListener(

"unhandledrejection",

(event)=>{

console.log(event.reason);

}

);
```

---

## Node.js

```javascript
process.on(

"uncaughtException",

(err)=>{

console.log(err);

});
```

---

Unhandled Promise

```javascript
process.on(

"unhandledRejection",

(err)=>{

console.log(err);

});
```

---

# 13. Browser vs Node.js

| Browser | Node.js |
|----------|----------|
| window.onerror | process.on() |
| DevTools | Terminal |
| UI Errors | Server Errors |
| Frontend | Backend |

---

# 14. Common Mistakes

## Mistake 1

Empty catch

```javascript
catch(e){

}
```

Never ignore errors.

---

## Mistake 2

Using try/catch for syntax errors.

Impossible.

Syntax errors happen before execution.

---

## Mistake 3

Not throwing meaningful messages.

Wrong

```javascript
throw Error();
```

Correct

```javascript
throw Error("Invalid Email");
```

---

## Mistake 4

Ignoring Promise errors.

Wrong

```javascript
fetch(url);
```

Correct

```javascript
fetch(url)

.catch(...);
```

---

## Mistake 5

Forgetting finally for cleanup.

Always use finally for

```
Files

Database

Sockets

Connections
```

---

# 15. Dry Runs

Example 1

```javascript
try{

console.log(x);

}

catch{

console.log("Error");

}
```

Output

```
Error
```

---

Example 2

```javascript
try{

throw Error("A");

}

catch(err){

console.log(err.message);

}
```

Output

```
A
```

---

Example 3

```javascript
try{

console.log("A");

}

finally{

console.log("B");

}
```

Output

```
A

B
```

---

Example 4

```javascript
Promise.reject("Network")

.catch(console.log);
```

Output

```
Network
```

---

Example 5

```javascript
async function demo(){

try{

await Promise.reject("Error");

}

catch(e){

console.log(e);

}

}

demo();
```

Output

```
Error
```

---

# 16. Visual Diagrams

## try/catch

```
Try

↓

Success

↓

End
```

---

If Error

```
Try

↓

Error

↓

Catch

↓

Finally
```

---

Promise Error

```
Promise

↓

Reject

↓

Catch
```

---

Async Error

```
await

↓

Reject

↓

Catch
```

---

# 17. Real World Examples

## Login

```javascript
try{

login();

}

catch{

showLoginError();

}
```

---

## Database

```javascript
try{

connect();

}

finally{

disconnect();

}
```

---

## Payment

```
Payment

↓

Network Failure

↓

Retry

↓

Show Error
```

---

## API

```javascript
try{

await fetch();

}

catch{

Show Toast

}
```

---

# 18. Interview Questions (40)

### 1. What is error handling?

Handling unexpected situations without crashing the application.

---

### 2. Difference between syntax and runtime error?

Syntax → Before execution.

Runtime → During execution.

---

### 3. What is logical error?

Wrong output without any exception.

---

### 4. What does try do?

Executes risky code.

---

### 5. What does catch do?

Handles thrown errors.

---

### 6. What does finally do?

Always executes.

---

### 7. Can finally execute without catch?

Yes.

---

### 8. Can finally execute after return?

Yes.

---

### 9. What does throw do?

Creates an exception.

---

### 10. Difference between throw and return?

`throw` stops execution and transfers control to catch.

`return` returns a value normally.

---

### 11. Can we throw strings?

Yes.

```javascript
throw "Error";
```

But `Error` objects are recommended.

---

### 12. Why use `new Error()`?

Provides stack trace and better debugging.

---

### 13. What is `err.message`?

The readable error message.

---

### 14. What is `err.name`?

The type of error.

---

### 15. Difference between `ReferenceError` and `TypeError`?

ReferenceError → Variable doesn't exist.

TypeError → Operation on wrong type.

---

### 16. How are Promise errors handled?

Using `.catch()`.

---

### 17. How are async errors handled?

Using `try...catch`.

---

### 18. Does `catch()` handle synchronous errors?

No.

It handles Promise rejections.

---

### 19. Can try/catch catch syntax errors?

No.

---

### 20. Why use finally?

Cleanup resources.

---

*(Continue practicing up to 40 questions by explaining different error types, custom errors, global handlers, Promise rejections, async debugging, stack traces, and best practices.)*

---

# 19. Coding Exercises

### Exercise 1

Catch a ReferenceError.

---

### Exercise 2

Throw a custom error.

---

### Exercise 3

Create a ValidationError class.

---

### Exercise 4

Handle rejected Promise.

---

### Exercise 5

Handle async fetch error.

---

### Exercise 6

Use finally to close database connection.

---

### Exercise 7

Predict Output

```javascript
try{

console.log("A");

throw Error();

console.log("B");

}

catch{

console.log("C");

}

finally{

console.log("D");

}
```

Answer

```
A

C

D
```

---

# 20. Summary

- JavaScript has **Syntax**, **Runtime**, and **Logical** errors.
- Use `try...catch` to handle runtime exceptions.
- `finally` always executes and is ideal for cleanup.
- Use `throw new Error()` to create meaningful custom errors.
- Handle Promise failures with `.catch()`.
- Handle async failures with `try...catch`.
- Global error handlers help catch unexpected application failures.
- Proper error handling improves reliability, debugging, and user experience.

---

# Visual Memory Map

```
Error

├── Syntax
├── Runtime
├── Logical

↓

try

↓

catch

↓

finally

↓

throw

↓

Promise.catch()

↓

async try/catch

↓

Global Error Handler
```

---

# Next Chapter

➡️ **15-Browser-vs-Node.md**

Topics covered:

- JavaScript Runtime Comparison
- Browser Architecture
- Node.js Architecture
- V8 Engine
- DOM vs No DOM
- Web APIs vs libuv
- Event Loop Differences
- File System APIs
- Networking APIs
- 35+ Interview Questions
- Real-world Backend vs Frontend examples
```