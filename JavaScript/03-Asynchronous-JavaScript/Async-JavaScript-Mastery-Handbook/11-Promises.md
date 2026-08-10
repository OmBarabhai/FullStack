# Chapter 11 — JavaScript Promises (Complete Handbook)

> **"A Promise represents the eventual completion (or failure) of an asynchronous operation."**

Promises are the backbone of modern JavaScript. Understanding them deeply makes `fetch()`, `async/await`, React, Node.js, and modern frameworks much easier.

---

# Table of Contents

1. What is a Promise?
2. Why Promises Were Introduced
3. Callback Hell Problem
4. Promise States
5. Promise Lifecycle
6. Creating a Promise
7. resolve() vs reject()
8. Consuming a Promise
9. then()
10. catch()
11. finally()
12. Promise Chaining
13. Returning Values in then()
14. Returning Promises
15. Error Propagation
16. Promise Combinators
17. Internal Execution
18. Promise & Event Loop
19. Real World Examples
20. Common Mistakes
21. Dry Runs
22. Interview Questions
23. Coding Exercises
24. Summary

---

# 1. What is a Promise?

A Promise is an object representing the **future result** of an asynchronous operation.

Think of ordering food.

```
You order Pizza

↓

Restaurant cooks

↓

Later

↓

Pizza Delivered
```

Promise = "I promise you'll get your pizza later."

---

# 2. Why Promises Were Introduced

Before Promises

```javascript
login(function(){

    getProfile(function(){

        getPosts(function(){

            getComments(function(){

            });

        });

    });

});
```

This is called

```
Callback Hell
```

Promises solve this problem.

---

# 3. Callback Hell

```
login()

    ↓

getProfile()

      ↓

getPosts()

         ↓

getComments()

             ↓

getLikes()
```

Looks like

```
Pyramid of Doom
```

With Promises

```javascript
login()

.then(getProfile)

.then(getPosts)

.then(getComments)

.then(getLikes);
```

Much cleaner.

---

# 4. Promise States

A Promise has only **three states**.

```
Pending

↓

Fulfilled

OR

Rejected
```

Diagram

```
          Pending

         /      \

 Fulfilled    Rejected
```

---

### Pending

Work is still happening.

Example

```
Downloading File...
```

---

### Fulfilled

Operation completed successfully.

```
Download Complete
```

---

### Rejected

Something failed.

```
Network Error
```

---

# 5. Promise Lifecycle

```
Create Promise

↓

Pending

↓

resolve()

OR

reject()

↓

Finished Forever
```

Important:

A Promise changes state **only once**.

---

# 6. Creating a Promise

Syntax

```javascript
const promise = new Promise((resolve, reject) => {

});
```

Example

```javascript
const promise = new Promise((resolve, reject) => {

    resolve("Success");

});
```

---

# 7. resolve() vs reject()

### resolve()

Means

```
Success
```

Example

```javascript
resolve("Login Successful");
```

---

### reject()

Means

```
Failure
```

Example

```javascript
reject("Wrong Password");
```

---

# Example

```javascript
const promise = new Promise((resolve, reject)=>{

    const success = true;

    if(success){

        resolve("Done");

    }

    else{

        reject("Failed");

    }

});
```

---

# 8. Consuming a Promise

A Promise is consumed using

```
then()

catch()

finally()
```

Example

```javascript
promise

.then(data=>{

console.log(data);

});
```

---

# 9. then()

Runs when Promise is fulfilled.

Example

```javascript
Promise.resolve("Hello")

.then(data=>{

console.log(data);

});
```

Output

```
Hello
```

---

# 10. catch()

Runs only when Promise is rejected.

Example

```javascript
Promise.reject("Error")

.catch(error=>{

console.log(error);

});
```

Output

```
Error
```

---

# 11. finally()

Runs

```
Always
```

Whether Promise succeeds or fails.

Example

```javascript
promise

.finally(()=>{

console.log("Finished");

});
```

---

# 12. Promise Chaining

Example

```javascript
Promise.resolve(2)

.then(num=>num*2)

.then(num=>num+5)

.then(console.log);
```

Flow

```
2

↓

4

↓

9
```

Output

```
9
```

---

# 13. Returning Values

```javascript
Promise.resolve(5)

.then(num=>{

return num+5;

})

.then(console.log);
```

Output

```
10
```

The returned value becomes the input for the next `.then()`.

---

# 14. Returning Promises

```javascript
Promise.resolve(5)

.then(num=>{

return Promise.resolve(num*2);

})

.then(console.log);
```

Output

```
10
```

JavaScript automatically waits for the returned Promise.

---

# 15. Error Propagation

Example

```javascript
Promise.resolve()

.then(()=>{

throw Error("Oops");

})

.catch(error=>{

console.log(error.message);

});
```

Output

```
Oops
```

Errors automatically move to the nearest `.catch()`.

---

# 16. Promise Combinators

## Promise.all()

Waits for all Promises.

```javascript
Promise.all([p1,p2,p3]);
```

If one fails

↓

Whole Promise fails.

---

## Promise.race()

Returns first settled Promise.

```javascript
Promise.race([p1,p2]);
```

---

## Promise.allSettled()

Waits for all.

Returns

```
Success

Failure

Both
```

---

## Promise.any()

Returns first successful Promise.

Ignores failures until all fail.

---

Comparison

| Method | Waits For |
|----------|------------|
| all | All success |
| race | First settled |
| any | First success |
| allSettled | All finished |

---

# 17. Internal Execution

Example

```javascript
Promise.resolve()

.then(()=>{

console.log("Hello");

});
```

Flow

```
Promise

↓

Microtask Queue

↓

Event Loop

↓

Call Stack

↓

Hello
```

---

# 18. Promise & Event Loop

Example

```javascript
console.log("Start");

Promise.resolve()

.then(()=>{

console.log("Promise");

});

console.log("End");
```

Execution

```
Start

↓

Promise

↓

Microtask Queue

↓

End

↓

Event Loop

↓

Promise
```

Output

```
Start

End

Promise
```

---

# 19. Real World Examples

### Login

```javascript
login()

.then(loadProfile)

.then(loadPosts);
```

---

### Payment

```javascript
payment()

.then(generateInvoice)

.then(sendMail);
```

---

### File Upload

```javascript
upload()

.then(saveDatabase)

.then(showSuccess);
```

---

# 20. Common Mistakes

### Mistake 1

Not returning inside `.then()`.

Wrong

```javascript
.then(data=>{

fetch(url);

})
```

Correct

```javascript
.then(data=>{

return fetch(url);

})
```

---

### Mistake 2

Multiple `.catch()` unnecessarily.

---

### Mistake 3

Ignoring Promise rejection.

Unhandled Promise Rejection

```
Application crashes
```

---

### Mistake 4

Thinking Promise executes later.

Only callbacks execute later.

The Promise constructor executes immediately.

---

# 21. Dry Runs

Example

```javascript
console.log(1);

Promise.resolve()

.then(()=>{

console.log(2);

});

console.log(3);
```

Execution

```
1

↓

Promise

↓

Microtask Queue

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

Example

```javascript
Promise.resolve(2)

.then(x=>x+2)

.then(x=>x*5)

.then(console.log);
```

Output

```
20
```

---

# 22. Interview Questions

### What is a Promise?

An object representing the future result of an asynchronous operation.

---

### What are the Promise states?

- Pending
- Fulfilled
- Rejected

---

### Can a Promise change state twice?

No.

Only once.

---

### Difference between resolve() and reject()?

`resolve()` completes successfully.

`reject()` completes with an error.

---

### Does `.finally()` receive the Promise result?

No.

It runs regardless of success or failure.

---

### What happens if one Promise fails in `Promise.all()`?

The entire `Promise.all()` rejects immediately.

---

### Difference between `Promise.all()` and `Promise.allSettled()`?

`Promise.all()` fails fast.

`Promise.allSettled()` waits for every Promise to finish.

---

### Why are Promise callbacks faster than `setTimeout()`?

Because they are placed in the **Microtask Queue**, which has higher priority than the Task Queue.

---

# 23. Coding Exercises

## Exercise 1

Create a Promise that resolves after 2 seconds.

---

## Exercise 2

Create a Promise that rejects with `"Network Error"`.

---

## Exercise 3

Chain three `.then()` methods.

---

## Exercise 4

Handle errors using `.catch()`.

---

## Exercise 5

Run three Promises together using `Promise.all()`.

---

## Exercise 6

Compare

```javascript
Promise.resolve()

setTimeout()
```

Predict the output.

---

# 24. Summary

- A Promise represents the future result of an asynchronous operation.
- A Promise has three states: Pending, Fulfilled, and Rejected.
- Use `resolve()` for success and `reject()` for failure.
- Consume Promises using `.then()`, `.catch()`, and `.finally()`.
- Promise callbacks are executed through the Microtask Queue.
- Promise chaining avoids callback hell.
- `Promise.all()`, `Promise.race()`, `Promise.any()`, and `Promise.allSettled()` help manage multiple asynchronous operations.

---

# Visual Memory Trick

```
Create Promise

        │
        ▼

      Pending

   ┌───────────┐
   │           │
   ▼           ▼

resolve()   reject()

   │           │
   ▼           ▼

Fulfilled  Rejected

      │
      ▼

Microtask Queue

      │
      ▼

Event Loop

      │
      ▼

.then() / .catch() / .finally()
```

---

# Next Chapter

➡️ **12-Promise-Chaining.md**

You'll learn:

- Promise chaining in depth
- Returning values vs returning Promises
- Nested Promises
- Flattening asynchronous code
- Advanced chaining patterns
- Error bubbling
- 25+ interview questions
- Real-world API chaining examples