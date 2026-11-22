# 13 — Async / Await Hands-On Lab

**Folder:** `03-Asynchronous-JavaScript`

> **Rule:** Predict → Write → Run → Observe → Explain.

Focus on understanding:

```text
What is synchronous?
What pauses?
What continues?
What does async return?
What does await give me?
```

---

## Lab 1 — Async Return

Create:

```js
async function hello() {
    // return "Hello"
}
```

Then:

```js
console.log(hello());
```

Predict the type/value first.

Then handle it with:

```js
hello().then(value => {
    console.log(value);
});
```

---

## Lab 2 — `await` a Resolved Promise

Build:

```text
Promise.resolve(50)
 ↓
await
 ↓
50
```

Scaffold:

```js
async function test() {
    const result = await Promise.resolve(50);

    console.log(result);
}

test();
```

Then rewrite it yourself without looking.

---

## Lab 3 — Await Does Not Block Everything

Predict:

```js
console.log("Start");

async function demo() {
    console.log("Inside");

    await Promise.resolve();

    console.log("Done");
}

demo();

console.log("End");
```

Expected:

```text
Start
Inside
End
Done
```

Explain why `End` appears before `Done`.

---

## Lab 4 — Async Function Throws

Create:

```js
async function test() {
    // throw an Error
}
```

Handle it:

```js
test().catch(error => {
    console.log(error.message);
});
```

Question:

> What did `async` convert the thrown error into?

---

## Lab 5 — Try/Catch

Build:

```text
async function
 ↓
await rejected Promise
 ↓
catch
 ↓
print error
```

Scaffold:

```js
async function test() {
    try {

        // await rejected promise

    } catch (error) {

        // print error

    }
}

test();
```

---

## Lab 6 — Async + Fetch

Fetch:

```text
https://jsonplaceholder.typicode.com/users
```

Build:

```text
async function
 ↓
await fetch
 ↓
check response
 ↓
await response.json()
 ↓
print users
```

Do not copy the whole solution from the learning file.

Write it from the flow.

---

## Lab 7 — Async + Functional Methods

Fetch users.

Then:

```text
users
 ↓
filter id > 5
 ↓
map names
 ↓
return names
```

Start:

```js
async function getNames() {

    // fetch


    // parse


    // filter


    // map


    // return

}
```

---

## Lab 8 — Sequential Awaits

Create three functions:

```text
getUser()
getPosts()
getComments()
```

Make each return a Promise after a visible delay.

Then write:

```text
getUser
 ↓
getPosts
 ↓
getComments
```

using:

```js
await
```

Measure the approximate total time.

---

## Lab 9 — Parallel With `Promise.all()`

Use the same three functions.

Instead of:

```text
await A
await B
await C
```

build:

```js
const [a, b, c] = await Promise.all([
    getUser(),
    getPosts(),
    getComments()
]);
```

Compare:

```text
Sequential time
vs
Parallel time
```

Question:

> Why is the second version faster when the operations are independent?

---

## Lab 10 — Sequential vs Parallel Logic

Create this dependency:

```text
getUser()
   ↓
need user.id
   ↓
getPosts(user.id)
```

Here:

```text
getPosts()
```

depends on:

```text
getUser()
```

So `Promise.all()` is not the correct replacement.

Build:

```js
const user = await getUser();
const posts = await getPosts(user.id);
```

Then explain why.

---

## Lab 11 — Fetch Error Handling

Build:

```text
await fetch()
 ↓
response.ok?
 ↓
throw if false
 ↓
try/catch
```

Test:

```text
valid URL
```

then:

```text
invalid / HTTP error URL
```

Observe the difference between:

```text
network/request failure
vs
HTTP error response
```

---

## Lab 12 — Missing `await`

Debug:

```js
async function getUsers() {
    const response = fetch(url);

    const data = await response.json();

    return data;
}
```

Question:

```text
What is response?
Why does response.json() fail?
```

Fix it.

---

## Lab 13 — Missing Parallelization

Debug this design:

```js
async function loadPage() {
    const users = await getUsers();
    const posts = await getPosts();
    const products = await getProducts();

    return { users, posts, products };
}
```

Assume the three operations are independent.

Rewrite it using:

```text
Promise.all()
```

Then explain why.

---

## Lab 14 — Promise Chain → Async/Await

Convert:

```js
fetch(url)
    .then(response => response.json())
    .then(users => {
        return users.filter(user => user.id > 5);
    })
    .then(users => {
        return users.map(user => user.name);
    })
    .catch(error => {
        console.log(error);
    });
```

into:

```text
async function
try/catch
await
filter
map
```

Do it yourself.

---

## Lab 15 — DevAPI Request Function

Create:

```js
async function getRequests() {
    // simulate or fetch request data
}
```

It should produce:

```js
[
    { id: 1, status: 200, resTime: 100 },
    { id: 2, status: 500, resTime: 300 },
    { id: 3, status: 404, resTime: 200 }
]
```

---

## Lab 16 — DevAPI Analytics

Using the async function above:

```text
getRequests()
 ↓
await
 ↓
filter failures
 ↓
reduce total response time
 ↓
return total
```

Target:

```text
500
```

because:

```text
300 + 200
```

---

## Lab 17 — DevAPI Failed IDs

Build:

```text
getRequests()
 ↓
filter status >= 400
 ↓
map id
 ↓
return IDs
```

Expected:

```text
[2, 3]
```

---

## Lab 18 — DevAPI Full Flow

Build independently:

```text
getRequests()
 ↓
check success
 ↓
get request data
 ↓
filter failures
 ↓
map IDs
 ↓
reduce response time
 ↓
return analytics
```

Return:

```js
{
    failedIds: [2, 3],
    failedCount: 2,
    totalFailedResponseTime: 500
}
```

Do not copy the final object-building logic. Build each property from the intermediate data.

---

## Lab 19 — Dry Run

Predict:

```js
console.log(1);

async function demo() {
    console.log(2);

    await Promise.resolve();

    console.log(3);
}

demo();

console.log(4);
```

Expected:

```text
1
2
4
3
```

Explain every transition.

---

## Lab 20 — Final Mastery Test

Build without notes:

```text
1. Create async getRequests().
2. Return request data asynchronously.
3. Await the result.
4. Filter failed requests.
5. Map failed IDs.
6. Reduce failed response times.
7. Return an analytics object.
8. Handle errors with try/catch.
9. Run the function.
10. Print the final analytics.
```

Target:

```js
{
    failedIds: [2, 3],
    failedCount: 2,
    totalFailedResponseTime: 500
}
```

---

# Logic-Building Framework

When you see:

```text
await something()
```

ask:

```text
What does something() return?
↓
Promise?
↓
What does that Promise resolve with?
↓
What type is that value?
↓
What do I need to do with it?
```

For example:

```text
await getRequests()
      ↓
request array
      ↓
filter()
      ↓
failed array
      ↓
map()
      ↓
IDs
```

---

# Sequential vs Parallel Decision Rule

Use sequential:

```text
B needs A
C needs B
```

Use parallel:

```text
A, B, C are independent
```

Mental model:

```text
DEPENDENCY
→ await step-by-step

INDEPENDENT
→ Promise.all()
```

---

# Debugging Framework

When async code fails:

```text
1. What does this async function return?
2. Is this value a Promise?
3. Did I await it?
4. What does the awaited value contain?
5. Is the next operation acting on the correct type?
6. Could the Promise reject?
7. Is my try/catch covering the correct code?
```

When logic is confusing:

```text
Do not chain everything.
Store intermediate results.
Console.log each stage.
```

Example:

```js
const requests = await getRequests();
console.log("requests:", requests);

const failed = requests.filter(...);
console.log("failed:", failed);

const ids = failed.map(...);
console.log("ids:", ids);

const total = failed.reduce(...);
console.log("total:", total);
```

Then simplify after it works.

---

# Completion Checklist

- [ ] async returns Promise
- [ ] await resolved value
- [ ] await does not block whole runtime
- [ ] async error becomes rejection
- [ ] try/catch with await
- [ ] Fetch with async/await
- [ ] async + filter/map
- [ ] sequential awaits
- [ ] parallel Promise.all
- [ ] understand dependencies
- [ ] Promise chain → async/await
- [ ] DevAPI request function
- [ ] DevAPI failed IDs
- [ ] DevAPI analytics
- [ ] final independent challenge
