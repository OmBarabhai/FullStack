# Chapter 20 — JavaScript Asynchronous Coding Problems (Beginner → Advanced)

> **Goal:** After completing these problems, you'll be able to solve almost every JavaScript asynchronous coding question asked in interviews.

---

# Table of Contents

1. Why Practice Coding?
2. Beginner Problems
3. setTimeout Problems
4. Promise Problems
5. async/await Problems
6. fetch() Problems
7. Event Loop Problems
8. Output Prediction Problems
9. Real Interview Problems
10. Mini Projects
11. Summary

---

# 1. Why Practice Coding?

Understanding theory is important.

Writing code is even more important.

Interviewers usually ask:

- Predict Output
- Write Promise
- Convert callback to Promise
- Use async/await
- Multiple API requests
- Error handling

---

# 2. Beginner Problems

---

## Problem 1

Print

```
Hello
World
```

after 2 seconds.

```javascript
// Expected Output
Hello
(wait 2 sec)
World
```

---

### Solution

```javascript
console.log("Hello");

setTimeout(() => {
    console.log("World");
}, 2000);
```

---

## Problem 2

Print

```
1

2

3
```

every second.

---

Solution

```javascript
let i = 1;

const id = setInterval(() => {

    console.log(i);

    i++;

    if(i > 3){
        clearInterval(id);
    }

},1000);
```

---

## Problem 3

Write your own delay function.

Usage

```javascript
delay(3000);
```

---

Solution

```javascript
function delay(ms){

    return new Promise(resolve=>{

        setTimeout(resolve,ms);

    });

}
```

---

# 3. setTimeout Problems

---

## Problem 4

Nested timers

```javascript
setTimeout(()=>{

console.log("A");

setTimeout(()=>{

console.log("B");

},1000);

},1000);
```

Output

```
(after 1 sec)

A

(after another 1 sec)

B
```

---

## Problem 5

Cancel a timer.

```javascript
const id = setTimeout(()=>{

console.log("Hello");

},5000);

clearTimeout(id);
```

Output

```
Nothing
```

---

## Problem 6

Create a countdown.

```
5

4

3

2

1

Done
```

---

Solution

```javascript
let count = 5;

const id = setInterval(()=>{

console.log(count);

count--;

if(count===0){

console.log("Done");

clearInterval(id);

}

},1000);
```

---

# 4. Promise Problems

---

## Problem 7

Create your own Promise.

```javascript
const promise = new Promise((resolve,reject)=>{

resolve("Success");

});

promise.then(console.log);
```

Output

```
Success
```

---

## Problem 8

Reject a Promise.

```javascript
const promise = new Promise((resolve,reject)=>{

reject("Failed");

});

promise.catch(console.log);
```

---

## Problem 9

Chain Promises.

```javascript
Promise.resolve(5)

.then(num=>num*2)

.then(num=>num+10)

.then(console.log);
```

Output

```
20
```

---

## Problem 10

Promise.all()

```javascript
const p1 = Promise.resolve(10);

const p2 = Promise.resolve(20);

Promise.all([p1,p2])

.then(console.log);
```

Output

```
[10,20]
```

---

## Problem 11

Promise.race()

```javascript
const p1 = new Promise(r=>setTimeout(()=>r("A"),3000));

const p2 = new Promise(r=>setTimeout(()=>r("B"),1000));

Promise.race([p1,p2])

.then(console.log);
```

Output

```
B
```

---

# 5. async/await Problems

---

## Problem 12

Convert Promise into async/await.

Before

```javascript
fetch("/users")

.then(res=>res.json())

.then(console.log);
```

After

```javascript
async function getUsers(){

const res = await fetch("/users");

const data = await res.json();

console.log(data);

}
```

---

## Problem 13

Wait for 3 seconds.

```javascript
async function demo(){

console.log("Start");

await delay(3000);

console.log("End");

}
```

---

## Problem 14

Handle Errors.

```javascript
async function test(){

try{

const res = await fetch("/users");

}catch(err){

console.log(err);

}

}
```

---

# 6. fetch() Problems

---

## Problem 15

Fetch users.

```javascript
fetch("https://jsonplaceholder.typicode.com/users")

.then(res=>res.json())

.then(console.log);
```

---

## Problem 16

Fetch posts using async/await.

---

## Problem 17

Display loading...

```
Loading...

↓

API

↓

Hide Loading

↓

Display Data
```

---

## Problem 18

Handle API failure.

```
Try

↓

Catch

↓

Display Error
```

---

# 7. Event Loop Problems

---

## Problem 19

Predict output.

```javascript
console.log(1);

setTimeout(()=>{

console.log(2);

},0);

console.log(3);
```

Answer

```
1

3

2
```

---

## Problem 20

```javascript
console.log("A");

Promise.resolve().then(()=>{

console.log("B");

});

console.log("C");
```

Answer

```
A

C

B
```

---

## Problem 21

```javascript
console.log(1);

setTimeout(()=>{

console.log(2);

},0);

Promise.resolve().then(()=>{

console.log(3);

});

console.log(4);
```

Answer

```
1

4

3

2
```

---

# 8. Output Prediction Problems

---

## Problem 22

```javascript
async function demo(){

console.log(1);

await Promise.resolve();

console.log(2);

}

demo();

console.log(3);
```

Answer

```
1

3

2
```

---

## Problem 23

```javascript
setTimeout(()=>{

console.log("A");

Promise.resolve().then(()=>{

console.log("B");

});

},0);
```

Answer

```
A

B
```

---

## Problem 24

```javascript
Promise.resolve()

.then(()=>{

console.log(1);

})

.then(()=>{

console.log(2);

});
```

Output

```
1

2
```

---

## Problem 25

```javascript
console.log("Start");

fetch("/users")

.then(()=>{

console.log("Users");

});

console.log("End");
```

Output

```
Start

End

Users
```

---

# 9. Real Interview Problems

---

## Problem 26

Implement

```
sleep(3000)
```

---

Solution

```javascript
function sleep(ms){

return new Promise(resolve=>{

setTimeout(resolve,ms);

});

}
```

---

## Problem 27

Retry failed API three times.

---

## Problem 28

Run three APIs in parallel.

Hint

```
Promise.all()
```

---

## Problem 29

Run APIs one after another.

Hint

```
await
```

---

## Problem 30

Limit concurrent requests.

(Hard)

---

## Problem 31

Create debounce function.

(Hard)

---

## Problem 32

Create throttle function.

(Hard)

---

## Problem 33

Implement Promise.all()

(Hard)

---

## Problem 34

Implement Promise.race()

(Hard)

---

## Problem 35

Implement custom Event Loop simulator.

(Very Hard)

---

# 10. Mini Projects

---

## Project 1

Digital Clock

Use

```
setInterval()
```

---

## Project 2

Countdown Timer

---

## Project 3

Stopwatch

---

## Project 4

Weather App

Use

```
fetch()

Promise

async/await
```

---

## Project 5

Todo App with API

---

## Project 6

GitHub User Search

```
fetch()

async

await
```

---

## Project 7

Infinite Scroll

---

## Project 8

Live Search Suggestions

Use

```
Debouncing
```

---

## Project 9

Chat App

Use

```
WebSocket
```

---

## Project 10

Movie Search App

```
fetch()

Promise

async/await
```

---

# Practice Challenge (Interview Round)

Without running the code, predict the output.

```javascript
console.log("Start");

setTimeout(() => {
  console.log("Timer 1");
}, 0);

Promise.resolve().then(() => {
  console.log("Promise 1");
});

setTimeout(() => {
  console.log("Timer 2");
}, 0);

Promise.resolve().then(() => {
  console.log("Promise 2");
});

console.log("End");
```

### Answer

```
Start
End
Promise 1
Promise 2
Timer 1
Timer 2
```

---

# Final Revision Flow

Master these topics in this exact order:

```
JavaScript Runtime
        ↓
Execution Context
        ↓
Call Stack
        ↓
Web APIs
        ↓
Event Loop
        ↓
Task Queue
        ↓
Microtask Queue
        ↓
setTimeout
        ↓
setInterval
        ↓
fetch()
        ↓
Promises
        ↓
Promise Chaining
        ↓
async/await
        ↓
Error Handling
        ↓
Browser vs Node.js
        ↓
libuv
        ↓
Real-Life Examples
        ↓
Dry Runs
        ↓
Interview Questions
        ↓
Coding Problems
```

---

# 🎉 Congratulations!

You have now completed the **JavaScript Asynchronous Programming Handbook**.

By mastering these 20 chapters, you should be able to:

- ✅ Explain JavaScript Runtime from scratch
- ✅ Draw the Call Stack, Event Loop, and Queues
- ✅ Predict tricky asynchronous outputs
- ✅ Write clean Promise and async/await code
- ✅ Handle API requests and errors
- ✅ Build real-world asynchronous applications
- ✅ Confidently answer JavaScript asynchronous interview questions from beginner to advanced level
```