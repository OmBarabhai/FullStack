# Chapter 10 — Fetch API

> **"The Fetch API is the modern way to communicate with servers in JavaScript."**

Every frontend developer uses `fetch()`. It is one of the most important APIs for interviews and real-world development.

---

# Table of Contents

1. What is Fetch API?
2. Why Do We Need Fetch?
3. Client-Server Architecture
4. How Fetch Works Internally
5. Syntax
6. GET Request
7. Response Object
8. Why response.json()?
9. Fetch Execution Flow
10. Promise Chain
11. Async/Await with Fetch
12. POST Request
13. Common HTTP Methods
14. Headers
15. Error Handling
16. Fetch vs XMLHttpRequest
17. Complete Execution Diagram
18. Real-Life Examples
19. Common Mistakes
20. Dry Runs
21. Interview Questions
22. Coding Exercises
23. Summary

---

# 1. What is Fetch API?

The Fetch API allows JavaScript to communicate with servers.

Using fetch, we can

- Get Data
- Send Data
- Update Data
- Delete Data

Example

```javascript
fetch("https://jsonplaceholder.typicode.com/users");
```

---

# 2. Why Do We Need Fetch?

Imagine Instagram.

When you open Instagram,

JavaScript needs

```
Posts

↓

Comments

↓

Likes

↓

Profile

↓

Stories
```

Where does this data come from?

A server.

JavaScript requests data using Fetch.

---

# 3. Client-Server Architecture

```
Browser

↓

fetch()

↓

Internet

↓

Server

↓

Database

↓

Server

↓

Browser
```

Example

```
Browser

↓

GET /users

↓

Server

↓

Database

↓

JSON Response

↓

Browser
```

---

# 4. How Fetch Works Internally

Suppose

```javascript
fetch("/users");
```

Flow

```
JavaScript

↓

fetch()

↓

Browser Network API

↓

Internet

↓

Server

↓

Server sends Response

↓

Promise Resolved

↓

Microtask Queue

↓

Event Loop

↓

Call Stack
```

Notice

Fetch uses **Promises**, not callbacks.

---

# 5. Syntax

Basic syntax

```javascript
fetch(url);
```

Example

```javascript
fetch("https://jsonplaceholder.typicode.com/posts");
```

Since fetch returns a Promise,

we use

```javascript
.then()

or

async/await
```

---

# 6. GET Request

Example

```javascript
fetch("https://jsonplaceholder.typicode.com/users")
.then(response => response.json())
.then(data => console.log(data));
```

Flow

```
Request

↓

Server

↓

JSON Response

↓

JavaScript Object
```

---

# 7. Response Object

Many beginners think

```javascript
fetch()

↓

Returns Data
```

Wrong.

It returns

```
Response Object
```

Example

```javascript
fetch(url)

.then(response => {

    console.log(response);

});
```

You'll see

```
status

headers

ok

url

body

...
```

---

# 8. Why response.json()?

Server sends

```
JSON String
```

JavaScript needs

```
JavaScript Object
```

Example

Server sends

```json
{
   "name":"John"
}
```

After

```javascript
response.json()
```

We get

```javascript
{

name:"John"

}
```

---

# 9. Fetch Execution Flow

```javascript
fetch(url)

↓

Browser sends request

↓

Server receives

↓

Server processes

↓

Server responds

↓

Promise resolves

↓

Microtask Queue

↓

Event Loop

↓

.then()
```

---

# 10. Promise Chain

```javascript
fetch(url)

.then(response => response.json())

.then(data => {

console.log(data);

});
```

Flow

```
Request

↓

Response

↓

JSON Conversion

↓

Actual Data
```

---

# 11. Async/Await

Same example

```javascript
async function getUsers(){

    const response = await fetch(url);

    const data = await response.json();

    console.log(data);

}
```

Much cleaner.

---

# 12. POST Request

GET

↓

Read Data

POST

↓

Send Data

Example

```javascript
fetch(url,{

method:"POST",

body:JSON.stringify({

name:"John"

}),

headers:{

"Content-Type":"application/json"

}

});
```

---

# 13. Common HTTP Methods

| Method | Purpose |
|---------|----------|
| GET | Read |
| POST | Create |
| PUT | Replace |
| PATCH | Update |
| DELETE | Delete |

---

# 14. Headers

Headers give extra information.

Example

```javascript
headers:{

"Content-Type":"application/json",

Authorization:"Bearer Token"

}
```

---

# 15. Error Handling

Wrong

```javascript
fetch(url)

.then(...)
```

Better

```javascript
fetch(url)

.then(response=>{

if(!response.ok){

throw Error("Network Error");

}

return response.json();

})

.catch(error=>{

console.log(error);

});
```

Async/Await

```javascript
try{

const response=await fetch(url);

}catch(error){

console.log(error);

}
```

---

# 16. Fetch vs XMLHttpRequest

| Fetch | XMLHttpRequest |
|--------|----------------|
| Modern | Old |
| Promise Based | Callback Based |
| Cleaner | Verbose |
| Async/Await Support | No |
| Easier Error Handling | Difficult |

---

# 17. Complete Diagram

```
JavaScript

↓

fetch()

↓

Browser

↓

HTTP Request

↓

Server

↓

Database

↓

Server Response

↓

Promise

↓

Microtask Queue

↓

Event Loop

↓

.then()

↓

response.json()

↓

Actual Data
```

---

# 18. Real-Life Examples

### Login

```
POST /login
```

---

### Register

```
POST /register
```

---

### Products

```
GET /products
```

---

### Delete User

```
DELETE /users/5
```

---

### Update Profile

```
PATCH /profile
```

---

# 19. Common Mistakes

### Mistake 1

Thinking

```javascript
fetch()

↓

Returns Data
```

Wrong.

Returns Promise.

---

### Mistake 2

Forgetting

```javascript
response.json()
```

Then

```
You only have Response Object.
```

---

### Mistake 3

Ignoring errors.

Always handle

```
.catch()

or

try...catch
```

---

### Mistake 4

Forgetting

```javascript
await
```

Then

```
You get Promise instead of Data.
```

---

# 20. Dry Runs

Example

```javascript
console.log("Start");

fetch(url)

.then(()=>{

console.log("Fetched");

});

console.log("End");
```

Execution

```
Start

↓

fetch starts

↓

End

↓

Server responds

↓

Promise

↓

Microtask Queue

↓

Fetched
```

Output

```
Start

End

Fetched
```

---

# 21. Interview Questions

### What does fetch return?

A Promise.

---

### Why use response.json()?

To convert JSON into a JavaScript object.

---

### Does fetch reject on HTTP 404?

No.

Only network failures reject the Promise.

You must check

```javascript
response.ok
```

---

### Difference between GET and POST?

GET

```
Retrieve Data
```

POST

```
Send Data
```

---

### Can fetch use async/await?

Yes.

---

### Is fetch synchronous?

No.

It is asynchronous.

---

### Why is fetch Promise-based?

Because network requests take time.

JavaScript shouldn't block.

---

# 22. Coding Exercises

## Exercise 1

Fetch users from

```
https://jsonplaceholder.typicode.com/users
```

---

## Exercise 2

Print only user names.

---

## Exercise 3

Create a POST request.

---

## Exercise 4

Handle network errors using

```javascript
try...catch
```

---

## Exercise 5

Rewrite

```javascript
.then()
```

using

```javascript
async/await
```

---

# 23. Summary

- Fetch is the modern API for making HTTP requests.
- Fetch returns a Promise, not actual data.
- Use `response.json()` to convert JSON into JavaScript objects.
- Use `.then()` or `async/await` to handle responses.
- Handle errors using `response.ok`, `.catch()`, or `try...catch`.
- Fetch is promise-based and integrates with the Event Loop through the Microtask Queue.

---

# Visual Memory Trick

```
JavaScript

      │
      ▼

 fetch()

      │
      ▼

 Browser

      │
      ▼

 HTTP Request

      │
      ▼

 Server

      │
      ▼

 HTTP Response

      │
      ▼

 Promise

      │
      ▼

 Microtask Queue

      │
      ▼

 Event Loop

      │
      ▼

 response.json()

      │
      ▼

 JavaScript Object
```

---

# Next Chapter

➡️ **11-Promises.md**

You'll master:

- What is a Promise?
- Promise States
- Promise Lifecycle
- resolve() vs reject()
- `.then()`, `.catch()`, `.finally()`
- Promise Chaining
- Promise Combinators (`all`, `race`, `any`, `allSettled`)
- Internal execution diagrams
- 40+ interview questions
- Real-world examples and coding exercises