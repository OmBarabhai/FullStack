# 10 — Fetch API

**Folder:** `03-Asynchronous-JavaScript`

> **Core idea:** `fetch()` lets JavaScript make HTTP requests and returns a Promise for the eventual `Response`.

---

## 1. What Is Fetch?

```js
fetch(url);
```

Fetch lets browser JavaScript communicate with servers.

Typical operations:

```text
GET
POST
PUT
PATCH
DELETE
```

Mental model:

```text
JavaScript
   ↓
fetch()
   ↓
HTTP Request
   ↓
Server
   ↓
HTTP Response
```

---

## 2. Client–Server Model

```text
Browser
   ↓
Request
   ↓
Server
   ↓
Database
   ↓
Server
   ↓
Response
   ↓
Browser
```

Frontend applications use this pattern for users, products, posts, authentication, and other server data.

---

## 3. What Does `fetch()` Return?

This is critical:

```text
fetch()
→ Promise<Response>
```

Not:

```text
fetch()
→ final JSON object
```

Example:

```js
const result = fetch("https://jsonplaceholder.typicode.com/users");

console.log(result);
```

`result` is a Promise.

---

## 4. Basic GET

```js
fetch("https://jsonplaceholder.typicode.com/users")
    .then(response => response.json())
    .then(data => {
        console.log(data);
    });
```

Flow:

```text
fetch()
   ↓
Promise<Response>
   ↓
response
   ↓
response.json()
   ↓
Promise<parsed data>
   ↓
data
```

---

## 5. Response Object

The first `.then()` receives a `Response`:

```js
fetch(url)
    .then(response => {
        console.log(response.status);
        console.log(response.ok);
    });
```

Useful properties:

```text
status
ok
headers
url
body
```

---

## 6. Why `response.json()`?

The response body needs to be consumed and parsed.

```js
const response = await fetch(url);

const data = await response.json();
```

Important:

```text
fetch()
→ Promise<Response>

response.json()
→ Promise<parsed value>
```

---

## 7. Async/Await

```js
async function getUsers() {
    const response = await fetch(
        "https://jsonplaceholder.typicode.com/users"
    );

    const data = await response.json();

    console.log(data);
}
```

`await` pauses the progress of this async function; it does not freeze the whole JavaScript runtime.

---

## 8. HTTP Errors vs Network Failures

This is an important interview point.

A server can return:

```text
404
500
```

and Fetch can still resolve with a `Response`.

Check:

```js
if (!response.ok) {
    throw new Error(`HTTP ${response.status}`);
}
```

Then handle failures with:

```js
try {
    // request
} catch (error) {
    console.log(error);
}
```

Mental model:

```text
Network/request failure
→ Promise may reject

HTTP 404/500
→ Response can still resolve
→ check response.ok/status
```

---

## 9. POST Request

```js
fetch("https://jsonplaceholder.typicode.com/posts", {
    method: "POST",
    headers: {
        "Content-Type": "application/json"
    },
    body: JSON.stringify({
        title: "Hello",
        body: "Learning Fetch",
        userId: 1
    })
});
```

Important pieces:

```text
method
headers
body
```

---

## 10. Common Methods

| Method | Typical use |
|---|---|
| GET | Read |
| POST | Create/send |
| PUT | Replace |
| PATCH | Partial update |
| DELETE | Delete |

---

## 11. JSON.stringify()

Sending:

```js
JSON.stringify({
    name: "Om"
});
```

converts a JavaScript value into JSON text.

Think:

```text
Object
 ↓
JSON.stringify()
 ↓
Request body
```

Receiving:

```text
Response body
 ↓
response.json()
 ↓
JavaScript value
```

---

## 12. Headers

Example:

```js
headers: {
    "Content-Type": "application/json"
}
```

Authentication may use:

```js
headers: {
    Authorization: "Bearer TOKEN"
}
```

Headers carry metadata about requests/responses.

---

## 13. Fetch + Functional JavaScript

This connects directly to Folder 02.

```js
const users = await response.json();

const names = users.map(user => user.name);

const selected = users.filter(user => user.id > 5);

const user = users.find(user => user.id === 5);

const total = users.reduce((sum, user) => {
    return sum + user.id;
}, 0);
```

Your progression is:

```text
Fetch
 ↓
JSON data
 ↓
map/filter/find/reduce/sort
 ↓
Feature
```

---

# 14. DevAPI Connection

Earlier:

```text
Static request objects
        ↓
Functional processing
```

Now:

```text
Fetch
   ↓
HTTP response
   ↓
JSON
   ↓
Functional processing
   ↓
Analytics
```

This is the next step toward a real DevAPI.

---

# 15. HANDS-ON LAB

Create:

```text
03-Asynchronous-JavaScript/Code/fetch.js
```

For each lab:

```text
Predict
↓
Run
↓
Observe
↓
Explain
```

Do not only copy the solution.

### Lab 1 — Basic GET

Fetch:

```text
https://jsonplaceholder.typicode.com/users
```

Print the raw `Response`.

Question:

> What properties do you see?

### Lab 2 — Parse JSON

Fetch the same URL and print:

```js
await response.json();
```

Explain why this is another asynchronous step.

### Lab 3 — User Names

Fetch users and use:

```text
map()
```

to print only names.

### Lab 4 — Find One User

Fetch users and use:

```text
find()
```

to find:

```text
id = 5
```

### Lab 5 — Filter Users

Fetch users and use:

```text
filter()
```

for:

```text
id > 5
```

### Lab 6 — Error Handling

Test an invalid URL.

Then test an HTTP error and inspect:

```js
response.ok
response.status
```

Explain the difference.

### Lab 7 — Async/Await

Write:

```text
GET
↓
check response
↓
parse JSON
↓
print data
```

using only:

```text
async/await
try/catch
```

### Lab 8 — POST

Create a POST request containing:

```text
name
email
```

Use:

```text
method
headers
body
JSON.stringify()
```

Print the returned data.

### Lab 9 — Fetch + Functional Methods

Build:

```text
GET users
 ↓
JSON
 ↓
map
 ↓
names
```

Then independently build:

```text
GET users
 ↓
JSON
 ↓
find
 ↓
one user
```

and:

```text
GET users
 ↓
JSON
 ↓
filter
 ↓
selected users
```

---

# 16. DevAPI Hands-On

Start replacing hard-coded data with fetched data.

Goal:

```text
GET request
   ↓
Response
   ↓
JSON
   ↓
map/filter/find/reduce
   ↓
Analytics
```

Build it one step at a time.

Do not build the whole feature at once.

---

# 17. Debugging Practice

Find the problem:

```js
async function getUsers() {
    const response = fetch(url);

    const data = await response.json();

    console.log(data);
}
```

Ask:

```text
What is response?

Why does response.json() fail?
```

Key:

```text
fetch()
→ Promise

await fetch()
→ Response
```

---

# 18. Common Mistakes

### `fetch()` returns JSON

Wrong.

It returns a Promise.

### Forgetting `response.json()`

Then you still have a `Response`.

### Forgetting `await`

```js
const data = response.json();
```

`data` is a Promise.

### Assuming 404 rejects Fetch

Wrong.

Check:

```js
response.ok
response.status
```

### Sending a plain object as JSON body

Use:

```js
body: JSON.stringify(data)
```

### Ignoring errors

Use:

```text
response.ok
+
try/catch
```

---

# 19. Dry Runs

### Example 1

```js
console.log("Start");

fetch(url)
    .then(() => {
        console.log("Fetched");
    });

console.log("End");
```

High-level order:

```text
Start
End
Fetched
```

### Example 2

```js
async function load() {
    console.log("A");

    const response = await fetch(url);

    console.log("B");
}

console.log("Start");

load();

console.log("End");
```

High-level order:

```text
Start
A
End
...
B
```

The `load()` function continues after the awaited Promise settles.

---

# 20. Interview Questions

### What does `fetch()` return?

A Promise that resolves to a Response.

### What does `response.json()` return?

A Promise for the parsed JSON value.

### Does Fetch reject on HTTP 404?

Not normally. Check `response.ok` and `response.status`.

### Can Fetch use async/await?

Yes.

### Is Fetch synchronous?

No.

### Why is Fetch Promise-based?

Network work finishes later, so the Promise represents its eventual result.

### Why use `JSON.stringify()`?

To serialize a JavaScript value into JSON text for the request body.

### GET vs POST?

```text
GET  → retrieve
POST → send/create
```

---

# 21. Completion Checklist

- [ ] I understand Fetch.
- [ ] I know `fetch()` returns a Promise.
- [ ] I know that Promise resolves to a Response.
- [ ] I understand `response.json()`.
- [ ] I know `response.json()` returns a Promise.
- [ ] I can make a GET request.
- [ ] I can make a POST request.
- [ ] I understand headers.
- [ ] I understand `response.ok` and `response.status`.
- [ ] I know HTTP errors and network failures differ.
- [ ] I can use async/await.
- [ ] I can use try/catch.
- [ ] I can combine Fetch with map/filter/find/reduce.
- [ ] I completed the hands-on labs.
- [ ] I applied Fetch to DevAPI.

---

# 22. Quick Revision

```text
fetch()
    ↓
Promise<Response>
    ↓
Response
    ↓
response.json()
    ↓
Promise<parsed data>
    ↓
JavaScript data
```

Errors:

```text
Network failure
→ Promise may reject

HTTP 404/500
→ Response can still resolve
→ check ok/status
```

Sending JSON:

```text
JavaScript object
    ↓
JSON.stringify()
    ↓
HTTP body
```

Processing:

```text
Fetch
 ↓
JSON
 ↓
map/filter/find/reduce/sort
 ↓
Feature
```

---

# Final Mental Model

```text
                   JavaScript
                       │
                       ▼
                     fetch()
                       │
                       ▼
                Network Request
                       │
                       ▼
                     Server
                       │
                       ▼
                  HTTP Response
                       │
                       ▼
                Promise<Response>
                       │
                       ▼
                response.json()
                       │
                       ▼
               Promise<Parsed Data>
                       │
                       ▼
                 JavaScript Data
                       │
                       ▼
          map / filter / find / reduce
                       │
                       ▼
                   Application
```

**Next:** `11-Promises.md`
