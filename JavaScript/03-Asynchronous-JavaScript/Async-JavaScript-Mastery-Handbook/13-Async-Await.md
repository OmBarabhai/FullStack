# Chapter 13 — Async & Await (Complete Handbook)

> **"async/await is just syntactic sugar over Promises. It makes asynchronous code look like normal synchronous code."**

This is one of the most important JavaScript interview topics. React, Node.js, Express, Next.js, APIs, MongoDB, AWS SDK, Firebase, and almost every modern JavaScript framework uses `async/await`.

---

# Table of Contents

1. Why Async/Await Was Introduced
2. What is async?
3. What is await?
4. How async Works Internally
5. How await Works Internally
6. Execution Flow
7. Event Loop Interaction
8. Promise vs Async/Await
9. Error Handling
10. Multiple Awaits
11. Parallel Execution
12. Common Mistakes
13. Dry Runs
14. Internal Diagrams
15. Real World Examples
16. Interview Questions
17. Coding Exercises
18. Summary

---

# 1. Why Async/Await Was Introduced

Earlier we had

## Callback Hell

```javascript
login(() => {
    profile(() => {
        posts(() => {
            comments(() => {

            });
        });
    });
});
```

Very difficult to read.

---

Then Promises came

```javascript
login()
.then(profile)
.then(posts)
.then(comments);
```

Much cleaner.

---

Then Async/Await came

```javascript
async function loadData() {

    const user = await login();

    const profile = await getProfile();

    const posts = await getPosts();

}
```

Looks like synchronous code.

---

# Evolution

```
Callbacks

↓

Promises

↓

Async/Await
```

---

# 2. What is async?

An **async function always returns a Promise.**

Example

```javascript
async function hello() {

    return "Hello";

}

console.log(hello());
```

Output

```
Promise { "Hello" }
```

Even though we returned a string,

JavaScript converts it into

```
Promise.resolve("Hello")
```

---

# Visual Diagram

```
async function

↓

return value

↓

Promise.resolve(value)
```

---

# Example

```javascript
async function add(){

    return 10;

}

add().then(console.log);
```

Output

```
10
```

Internally

```
return 10

↓

Promise.resolve(10)
```

---

# 3. What is await?

`await` waits for a Promise to complete.

Example

```javascript
async function test(){

    const result = await Promise.resolve(50);

    console.log(result);

}

test();
```

Output

```
50
```

---

Without await

```javascript
const value = Promise.resolve(50);

console.log(value);
```

Output

```
Promise {50}
```

---

With await

```
Promise

↓

Resolved

↓

Actual Value
```

---

# 4. How async Works Internally

Example

```javascript
async function hello(){

    return "Hi";

}
```

JavaScript converts it into

```javascript
function hello(){

    return Promise.resolve("Hi");

}
```

Exactly the same.

---

# Internal Flow

```
async

↓

return value

↓

Promise.resolve()

↓

Promise
```

---

# 5. How await Works Internally

Example

```javascript
const data = await fetch(url);
```

Internally

```
Start Promise

↓

Pause async function

↓

Continue Event Loop

↓

Promise Finished

↓

Resume Function
```

Notice

The JavaScript engine **does NOT block.**

Only the async function pauses.

---

# Visual Diagram

```
await

↓

Pause current async function

↓

Event Loop continues

↓

Promise finishes

↓

Resume function
```

---

# 6. Execution Flow

Example

```javascript
console.log("Start");

async function demo(){

    console.log("Inside");

    await Promise.resolve();

    console.log("Done");

}

demo();

console.log("End");
```

---

Execution

```
Start

↓

Inside

↓

await

↓

End

↓

Microtask Queue

↓

Done
```

Output

```
Start

Inside

End

Done
```

---

# Call Stack Diagram

```
Main()

↓

demo()

↓

await

↓

Function Suspended

↓

Call Stack Empty

↓

Microtask Queue

↓

Resume demo()

↓

Done
```

---

# 7. Event Loop Interaction

Suppose

```javascript
async function test(){

    await Promise.resolve();

    console.log("A");

}

test();

console.log("B");
```

Output

```
B

A
```

Why?

Because

```
await

↓

Microtask Queue

↓

Call Stack Empty

↓

Resume
```

---

# Diagram

```
Call Stack

↓

await

↓

Microtask Queue

↓

Event Loop

↓

Continue Function
```

---

# 8. Promise vs Async/Await

Promise

```javascript
fetch(url)

.then(res=>res.json())

.then(console.log)

.catch(console.log);
```

---

Async Await

```javascript
async function getData(){

try{

const res = await fetch(url);

const data = await res.json();

console.log(data);

}

catch(err){

console.log(err);

}

}
```

Both are equivalent.

---

# Comparison

Promise

```
then()

↓

then()

↓

catch()
```

Async

```
await

↓

await

↓

try/catch
```

---

# 9. Error Handling

Example

```javascript
async function test(){

try{

await Promise.reject("Error");

}

catch(err){

console.log(err);

}

}
```

Output

```
Error
```

---

Flow

```
Promise Reject

↓

await

↓

catch()
```

---

Without try/catch

```javascript
await Promise.reject();
```

Produces

```
Unhandled Promise Rejection
```

---

# 10. Multiple Awaits

Example

```javascript
async function load(){

const a = await getUser();

const b = await getPosts();

const c = await getComments();

}
```

Execution

```
User

↓

Posts

↓

Comments
```

Sequential.

---

# 11. Parallel Execution

Sequential

```javascript
await fetch1();

await fetch2();

await fetch3();
```

Time

```
1 sec

+

1 sec

+

1 sec

=

3 sec
```

---

Better

```javascript
const [a,b,c] = await Promise.all([

fetch1(),

fetch2(),

fetch3()

]);
```

Time

```
1 sec
```

All execute together.

---

Diagram

Sequential

```
A

↓

B

↓

C
```

Parallel

```
A

B

C

↓

Together
```

---

# 12. Common Mistakes

---

## Mistake 1

Using await outside async

Wrong

```javascript
const data = await fetch(url);
```

Produces

```
SyntaxError
```

---

Correct

```javascript
async function get(){

const data = await fetch(url);

}
```

---

## Mistake 2

Forgetting await

```javascript
const data = fetch(url);

console.log(data);
```

Output

```
Promise
```

Not actual data.

---

## Mistake 3

Too many sequential awaits

Wrong

```javascript
await A();

await B();

await C();
```

Use

```javascript
Promise.all()
```

---

## Mistake 4

No try/catch

Always

```javascript
try{

await something();

}

catch(err){

}
```

---

# 13. Dry Runs

---

Example 1

```javascript
async function demo(){

console.log(1);

await Promise.resolve();

console.log(2);

}

demo();

console.log(3);
```

Execution

```
1

↓

await

↓

3

↓

2
```

Output

```
1

3

2
```

---

Example 2

```javascript
async function test(){

return 100;

}

test().then(console.log);
```

Output

```
100
```

---

Example 3

```javascript
async function test(){

const x = await Promise.resolve(20);

return x*2;

}

test().then(console.log);
```

Output

```
40
```

---

# 14. Internal Diagrams

Async Function

```
async

↓

Promise
```

---

Await

```
Promise

↓

Pause Function

↓

Microtask Queue

↓

Resume
```

---

Full Flow

```
async function

↓

await fetch()

↓

Web API

↓

Promise

↓

Microtask Queue

↓

Resume Function

↓

Return Value
```

---

# 15. Real World Examples

API Call

```javascript
const users = await fetch("/users");
```

---

MongoDB

```javascript
const users = await User.find();
```

---

AWS SDK

```javascript
const data = await s3.send(command);
```

---

Firebase

```javascript
const user = await getDoc(docRef);
```

---

Express

```javascript
app.get("/", async(req,res)=>{

const users = await User.find();

res.json(users);

});
```

---

# 16. Interview Questions

### What does async return?

Always a Promise.

---

### Can async return a normal value?

Yes.

JavaScript converts it into

```
Promise.resolve(value)
```

---

### Can await be used outside async?

No.

---

### Does await block JavaScript?

No.

It only pauses the current async function.

---

### What queue resumes await?

Microtask Queue.

---

### Difference between Promise and async/await?

Async/await is syntax built on top of Promises.

---

### Why use Promise.all()?

Runs multiple async operations in parallel.

---

### What happens if await receives a non-Promise?

JavaScript wraps it in

```
Promise.resolve(value)
```

Example

```javascript
await 5;
```

Behaves like

```javascript
await Promise.resolve(5);
```

---

# 17. Coding Exercises

## Exercise 1

Create an async function returning

```
Hello
```

---

## Exercise 2

Await

```
Promise.resolve(50)
```

---

## Exercise 3

Fetch data from an API using async/await.

---

## Exercise 4

Handle errors using try/catch.

---

## Exercise 5

Compare

```
Sequential await
```

vs

```
Promise.all()
```

---

## Exercise 6

Predict Output

```javascript
console.log(1);

async function demo(){

console.log(2);

await Promise.resolve();

console.log(3);

}

demo();

console.log(4);
```

Answer

```
1

2

4

3
```

---

# 18. Summary

- `async` always returns a Promise.
- `await` waits only inside async functions.
- `await` pauses the async function, **not** the JavaScript engine.
- The Event Loop continues running while waiting.
- After resolution, execution resumes from the Microtask Queue.
- Use `try/catch` for error handling.
- Use `Promise.all()` for parallel async operations.
- Async/await makes Promise-based code much easier to read and maintain.

---

# Visual Memory Trick

```
async

↓

Promise

↓

await

↓

Pause Function

↓

Promise Completes

↓

Microtask Queue

↓

Resume Function

↓

Return Result
```

---

# Next Chapter

➡️ **14-Error-Handling.md**

Topics covered:

- Synchronous vs Asynchronous Errors
- try/catch/finally
- throw keyword
- Promise rejection handling
- async/await error handling
- Global error handlers
- Browser vs Node.js differences
- Custom Error classes
- 35+ interview questions
- Real-world debugging examples