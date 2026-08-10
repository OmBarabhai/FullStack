# Chapter 12 — Promise Chaining (Complete Handbook)

> **"Promise chaining lets you perform multiple asynchronous operations one after another without creating callback hell."**

This chapter is one of the most important JavaScript interview topics. If you understand Promise Chaining deeply, `fetch()`, `async/await`, APIs, React, and Node.js become much easier.

---

# Table of Contents

1. What is Promise Chaining?
2. Why Promise Chaining?
3. How Chaining Works
4. Returning Values
5. Returning Promises
6. Nested Promises vs Chaining
7. Error Propagation
8. Chain Breaking
9. Internal Execution
10. Real World Examples
11. Common Mistakes
12. Dry Runs
13. Visual Diagrams
14. Interview Questions
15. Coding Exercises
16. Summary

---

# 1. What is Promise Chaining?

Promise Chaining means

```
One Promise

↓

Second Promise

↓

Third Promise

↓

Fourth Promise
```

Every `.then()` receives the result of the previous one.

---

Example

```javascript
Promise.resolve(5)
  .then((num) => num + 5)
  .then((num) => num * 2)
  .then(console.log);
```

Output

```
20
```

---

# 2. Why Promise Chaining?

Without Chaining

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

Looks like

```
login

   profile

      posts

         comments
```

Very difficult to read.

---

With Chaining

```javascript
login()

.then(profile)

.then(posts)

.then(comments);
```

Much cleaner.

---

# 3. How Chaining Works

Example

```javascript
Promise.resolve(10)

.then(num => num + 5)

.then(num => num * 2)

.then(console.log);
```

Flow

```
10

↓

15

↓

30

↓

Console
```

Output

```
30
```

---

# Visual Diagram

```
Promise

↓

then()

↓

then()

↓

then()

↓

Result
```

---

# 4. Returning Values

Suppose

```javascript
Promise.resolve(10)

.then((num)=>{

return num+10;

})

.then(console.log);
```

Flow

```
10

↓

20

↓

Print
```

Output

```
20
```

---

Every value returned becomes the input for the next `.then()`.

```
return value

↓

next then()
```

---

# Example

```javascript
Promise.resolve(2)

.then(x=>x+2)

.then(x=>x+3)

.then(x=>x+4)

.then(console.log);
```

Flow

```
2

↓

4

↓

7

↓

11
```

Output

```
11
```

---

# 5. Returning Promises

Instead of returning a value

We can return another Promise.

Example

```javascript
Promise.resolve(5)

.then((num)=>{

return Promise.resolve(num*2);

})

.then(console.log);
```

Output

```
10
```

---

JavaScript automatically waits.

Diagram

```
Promise

↓

then()

↓

returns Promise

↓

Wait

↓

Next then()
```

---

# 6. Nested Promises vs Chaining

## Wrong

```javascript
login()

.then(()=>{

profile()

.then(()=>{

posts();

});

});
```

Looks like callback hell again.

---

Correct

```javascript
login()

.then(()=>{

return profile();

})

.then(()=>{

return posts();

});
```

Always

```
Return

↓

Next then()
```

---

# Visual Comparison

Wrong

```
then

   then

      then
```

Correct

```
then

↓

then

↓

then
```

---

# 7. Error Propagation

Suppose

```javascript
Promise.resolve()

.then(()=>{

throw Error("Network Error");

})

.catch(console.log);
```

Output

```
Network Error
```

---

Errors automatically travel downward.

Diagram

```
then

↓

then

↓

Error

↓

catch()
```

---

Example

```javascript
Promise.resolve()

.then(()=>{

throw Error("A");

})

.then(()=>{

console.log("B");

})

.catch(console.log);
```

Output

```
Error A
```

Second `.then()` never executes.

---

# 8. Chain Breaking

If one Promise rejects

Remaining `.then()` methods are skipped.

Example

```javascript
Promise.reject("Failed")

.then(()=>{

console.log("A");

})

.then(()=>{

console.log("B");

})

.catch(console.log);
```

Output

```
Failed
```

---

Flow

```
Reject

↓

Skip

↓

Skip

↓

Catch
```

---

# 9. Internal Execution

Example

```javascript
Promise.resolve(5)

.then(x=>x+5)

.then(console.log);
```

Internal Flow

```
Create Promise

↓

Pending

↓

Fulfilled

↓

Microtask Queue

↓

Event Loop

↓

Call Stack

↓

then()

↓

Result
```

---

# 10. Real World Example

Login

```javascript
login()

.then(getProfile)

.then(getOrders)

.then(getPayments)

.then(logout);
```

---

Food Delivery

```
Order

↓

Restaurant Accepts

↓

Cooking

↓

Delivery

↓

Delivered
```

Each step waits for the previous one.

---

Payment Gateway

```
Login

↓

OTP

↓

Payment

↓

Receipt

↓

Email
```

---

# 11. Common Mistakes

---

## Mistake 1

Not returning Promise.

Wrong

```javascript
.then(()=>{

fetch(url);

})
```

Correct

```javascript
.then(()=>{

return fetch(url);

})
```

---

## Mistake 2

Nested `.then()`

Wrong

```javascript
.then(()=>{

fetch()

.then();

});
```

---

Correct

```javascript
.then(()=>{

return fetch();

})

.then();
```

---

## Mistake 3

Ignoring Errors

Wrong

```javascript
Promise.resolve()

.then(()=>{
throw Error();
});
```

No catch()

Unhandled Promise Rejection

---

## Mistake 4

Using multiple catches unnecessarily.

Usually

```
One catch

↓

End
```

is enough.

---

# 12. Dry Runs

---

Example 1

```javascript
Promise.resolve(1)

.then(x=>x+1)

.then(x=>x+1)

.then(console.log);
```

Execution

```
1

↓

2

↓

3
```

Output

```
3
```

---

Example 2

```javascript
Promise.resolve(10)

.then(x=>x*2)

.then(x=>x-5)

.then(console.log);
```

Flow

```
10

↓

20

↓

15
```

Output

```
15
```

---

Example 3

```javascript
Promise.resolve(5)

.then(x=>{

return Promise.resolve(x*5);

})

.then(console.log);
```

Output

```
25
```

---

Example 4

```javascript
Promise.resolve()

.then(()=>{

throw Error("Oops");

})

.catch(err=>{

console.log(err.message);

});
```

Output

```
Oops
```

---

# 13. Visual Diagrams

Simple Chain

```
Promise

↓

then

↓

then

↓

then

↓

Result
```

---

Returning Promise

```
Promise

↓

then

↓

Promise

↓

then

↓

Result
```

---

Error Flow

```
then

↓

then

↓

Error

↓

catch
```

---

# 14. Interview Questions

### What is Promise Chaining?

Executing asynchronous operations sequentially by returning values or Promises from `.then()`.

---

### Why should we return inside `.then()`?

So the next `.then()` waits for the result.

---

### What happens if we don't return?

The next `.then()` executes immediately with `undefined`.

---

### Can `.then()` return another Promise?

Yes.

JavaScript automatically waits for it.

---

### Can `.then()` return a normal value?

Yes.

That value becomes the input of the next `.then()`.

---

### How do errors travel?

Errors automatically propagate to the nearest `.catch()`.

---

### Does every Promise need a `.catch()`?

Ideally yes, to avoid unhandled promise rejections.

---

### Can Promise Chaining replace Callback Hell?

Yes.

That was one of the primary reasons Promises were introduced.

---

# 15. Coding Exercises

## Exercise 1

Chain three `.then()` methods.

---

## Exercise 2

Return a number from one `.then()`.

---

## Exercise 3

Return another Promise.

---

## Exercise 4

Throw an Error and catch it.

---

## Exercise 5

Create

```
Login

↓

Profile

↓

Orders

↓

Logout
```

using Promise chaining.

---

## Exercise 6

Predict Output

```javascript
Promise.resolve(2)

.then(x=>x+2)

.then(x=>Promise.resolve(x*2))

.then(console.log);
```

Answer

```
8
```

---

# 16. Summary

- Promise Chaining replaces Callback Hell.
- Each `.then()` receives the previous result.
- Returning a value passes it to the next `.then()`.
- Returning a Promise makes JavaScript wait automatically.
- Errors skip remaining `.then()` methods and go directly to `.catch()`.
- Always `return` Promises inside `.then()` to maintain the chain.
- Chaining is the foundation of `fetch()` and `async/await`.

---

# Visual Memory Trick

```
Promise

↓

then()

↓

Return Value

↓

then()

↓

Return Promise

↓

then()

↓

Error?

↓

catch()

↓

finally()
```

---

# Next Chapter

➡️ **13-Async-Await.md**

You'll learn:

- Why async/await was introduced
- async function internals
- await keyword
- How await pauses execution
- Error handling with try/catch
- Async vs Promise Chaining
- Event Loop interaction
- Browser and Node examples
- 35+ interview questions
- Real-world API examples