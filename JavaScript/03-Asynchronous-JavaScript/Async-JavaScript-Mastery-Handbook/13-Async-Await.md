# 13 — Async / Await

**Folder:** `03-Asynchronous-JavaScript`

> **Core idea:** `async`/`await` is Promise-based syntax that makes asynchronous control flow easier to read.

---

## 1. Why Async/Await?

The progression is:

```text
Callbacks
   ↓
Promises
   ↓
async / await
```

Promise chain:

```js
login()
    .then(profile)
    .then(posts);
```

Async/await:

```js
async function loadData() {
    const user = await login();
    const profile = await getProfile();
    const posts = await getPosts();

    return posts;
}
```

The async/await version is often easier to read for sequential operations.

---

## 2. What Does `async` Do?

An `async` function always returns a Promise.

```js
async function hello() {
    return "Hello";
}
```

Calling:

```js
console.log(hello());
```

produces a Promise.

Conceptually:

```text
return "Hello"
       ↓
fulfilled Promise
```

Therefore:

```js
hello().then(value => {
    console.log(value);
});
```

prints:

```text
Hello
```

---

## 3. `async` With a Rejected Promise

An error thrown inside an async function causes the returned Promise to reject.

```js
async function test() {
    throw new Error("Failed");
}

test().catch(error => {
    console.log(error.message);
});
```

Think:

```text
async function
      ↓
throw
      ↓
returned Promise rejects
```

---

## 4. What Does `await` Do?

`await` waits for a value/Promise before continuing the current async function.

Example:

```js
async function test() {
    const result = await Promise.resolve(50);

    console.log(result);
}

test();
```

Output:

```text
50
```

Without `await`:

```js
const value = Promise.resolve(50);

console.log(value);
```

you have the Promise itself.

---

## 5. `await` Does Not Block JavaScript

This is critical.

Consider:

```js
async function demo() {
    console.log("Inside");

    await Promise.resolve();

    console.log("Done");
}

console.log("Start");

demo();

console.log("End");
```

Output:

```text
Start
Inside
End
Done
```

Why?

```text
demo starts
   ↓
Inside
   ↓
await
   ↓
demo pauses
   ↓
current JavaScript continues
   ↓
End
   ↓
microtask
   ↓
demo resumes
   ↓
Done
```

Only the current async function's progress is suspended.

The JavaScript runtime does not freeze.

---

## 6. Awaiting a Non-Promise

You can write:

```js
const value = await 5;
```

Conceptually, the value is treated like an already-fulfilled Promise.

Think:

```text
await 5
≈
await Promise.resolve(5)
```

---

## 7. Async Function Execution

Example:

```js
async function demo() {
    console.log("A");

    await Promise.resolve();

    console.log("B");
}

console.log("Start");

demo();

console.log("End");
```

Flow:

```text
Start
↓
A
↓
await
↓
demo pauses
↓
End
↓
microtask checkpoint
↓
demo resumes
↓
B
```

Output:

```text
Start
A
End
B
```

---

## 8. Promise vs Async/Await

Promise chain:

```js
fetch(url)
    .then(response => response.json())
    .then(data => {
        console.log(data);
    })
    .catch(error => {
        console.log(error);
    });
```

Async/await:

```js
async function getData() {
    try {
        const response = await fetch(url);
        const data = await response.json();

        console.log(data);
    } catch (error) {
        console.log(error);
    }
}
```

They use the same Promise model.

Async/await changes how the control flow is written; it does not remove Promises from the underlying model.

---

## 9. Error Handling

Use:

```js
try {
    const response = await fetch(url);

    if (!response.ok) {
        throw new Error(`HTTP ${response.status}`);
    }

    const data = await response.json();

    console.log(data);
} catch (error) {
    console.log(error.message);
}
```

Flow:

```text
await
 ↓
Promise rejects / code throws
 ↓
catch
```

An async function without handling the error will return a rejected Promise.

---

## 10. Multiple Awaits

This:

```js
const a = await getUser();
const b = await getPosts();
const c = await getComments();
```

is sequential.

Conceptually:

```text
getUser
   ↓
finish
   ↓
getPosts
   ↓
finish
   ↓
getComments
```

Use this when later work depends on earlier work.

---

## 11. Parallel Async Work

If operations are independent, do not unnecessarily wait for them one by one.

Instead:

```js
const [users, posts, comments] = await Promise.all([
    getUsers(),
    getPosts(),
    getComments()
]);
```

Conceptually:

```text
users   ─┐
posts   ─┼─→ Promise.all() → results
comments─┘
```

The operations are started without waiting for each previous one to finish.

This is usually faster for independent work.

---

## 12. Sequential vs Parallel

### Sequential

```js
const a = await taskA();
const b = await taskB();
const c = await taskC();
```

Useful when:

```text
B depends on A
C depends on B
```

### Parallel

```js
const [a, b, c] = await Promise.all([
    taskA(),
    taskB(),
    taskC()
]);
```

Useful when:

```text
A, B, C are independent
```

Important:

> Do not use `Promise.all()` blindly. Choose based on dependencies.

---

## 13. Fetch + Async/Await

```js
async function getUsers() {
    const response = await fetch(
        "https://jsonplaceholder.typicode.com/users"
    );

    if (!response.ok) {
        throw new Error(`HTTP ${response.status}`);
    }

    const users = await response.json();

    return users;
}
```

Then:

```js
getUsers()
    .then(users => {
        console.log(users);
    })
    .catch(error => {
        console.log(error.message);
    });
```

Remember:

```text
async function
→ still returns a Promise
```

---

## 14. Async/Await + Functional JavaScript

Your Folder 02 skills remain useful.

```js
async function getNames() {
    const response = await fetch(
        "https://jsonplaceholder.typicode.com/users"
    );

    const users = await response.json();

    return users
        .filter(user => user.id > 5)
        .map(user => user.name);
}
```

Progression:

```text
Fetch
 ↓
await response
 ↓
await JSON
 ↓
filter
 ↓
map
 ↓
result
```

This is exactly the kind of code you will use in React and Node.js.

---

## 15. Async/Await + DevAPI

Your DevAPI can now move from:

```text
setTimeout simulation
      ↓
Promise simulation
      ↓
Promise chaining
```

to:

```text
async function
      ↓
await request
      ↓
process response
      ↓
functional analytics
```

Example structure:

```js
async function analyzeRequests() {
    const requests = await getRequests();

    const failed = requests.filter(
        request => request.status >= 400
    );

    const totalTime = failed.reduce(
        (total, request) => total + request.resTime,
        0
    );

    return totalTime;
}
```

---

## 16. Common Mistakes

### Using `await` outside a valid context

Normal script/module code has rules around where `await` can appear.

For this stage, use it inside:

```js
async function ...
```

or a supported top-level-await module environment.

### Forgetting `await`

```js
const data = fetch(url);
```

`data` is still a Promise.

### Unnecessary sequential awaits

```js
const a = await taskA();
const b = await taskB();
const c = await taskC();
```

If independent, consider `Promise.all()`.

### Assuming `await` blocks the whole application

It only suspends continuation of the current async function.

### Forgetting error handling

Use:

```js
try/catch
```

when the function should handle failures itself, or let the returned Promise reject for a caller to handle.

---

## 17. Dry Runs

### Example 1

```js
async function demo() {
    console.log(1);

    await Promise.resolve();

    console.log(2);
}

demo();

console.log(3);
```

Output:

```text
1
3
2
```

---

### Example 2

```js
async function test() {
    return 100;
}

test().then(console.log);
```

Output:

```text
100
```

---

### Example 3

```js
async function test() {
    const x = await Promise.resolve(20);
    return x * 2;
}

test().then(console.log);
```

Output:

```text
40
```

---

### Example 4

```js
console.log("A");

async function demo() {
    console.log("B");

    await Promise.resolve();

    console.log("C");
}

demo();

console.log("D");
```

Output:

```text
A
B
D
C
```

---

## 18. Interview Questions

### What does `async` return?

Always a Promise.

### Can an async function return a normal value?

Yes. The value becomes the fulfillment value of the returned Promise.

### What does `await` do?

It suspends the current async function's continuation until the awaited value/Promise is settled.

### Does `await` block JavaScript?

No. It does not freeze the entire runtime.

### What happens after an awaited Promise settles?

The async function's continuation is scheduled according to Promise/microtask semantics.

### Difference between Promise chaining and async/await?

Async/await is Promise-based syntax that expresses the same asynchronous model with a more sequential-looking control flow.

### Why use `Promise.all()`?

For independent asynchronous operations that can be started without waiting for each other.

### What happens if an async function throws?

Its returned Promise rejects.

### What happens if `await` receives a non-Promise?

The value is treated as an already-settled value for awaiting purposes.

---

## 19. Completion Checklist

- [ ] I know what `async` does.
- [ ] I know an async function returns a Promise.
- [ ] I understand `await`.
- [ ] I know `await` does not block the whole runtime.
- [ ] I understand the execution pause/resume model.
- [ ] I can use try/catch with async/await.
- [ ] I understand sequential awaits.
- [ ] I understand parallel independent operations.
- [ ] I can use Promise.all().
- [ ] I can connect async/await to Fetch.
- [ ] I can combine async/await with map/filter/reduce.
- [ ] I can apply async/await to DevAPI.
- [ ] I can dry-run async/await examples.

---

## Quick Revision

```text
async function
      ↓
returns Promise

await Promise
      ↓
pause current async function
      ↓
runtime continues
      ↓
Promise settles
      ↓
async function resumes
```

For multiple operations:

```text
Dependent
→ sequential await

Independent
→ Promise.all()
```

Error:

```text
await
 ↓
reject / throw
 ↓
try/catch
```

**Next:** `14-Error-Handling.md`
