# 12 — Promise Chaining Lab

**Folder:** `03-Asynchronous-JavaScript`

> Short revision + completed solutions. No repeated theory.

---

## Lab 1 — Value Chain

```text
2 → +2 → ×3 → print
```

```js
Promise.resolve(2)
    .then(value => value + 2)
    .then(value => value * 3)
    .then(console.log);
```

**Key:** Returned value → next `.then()`.

---

## Lab 2 — Return a Promise

```text
5 → Promise → ×2 → print
```

```js
Promise.resolve(5)
    .then(value => {
        return Promise.resolve(value * 2);
    })
    .then(console.log);
```

**Key:** Return the Promise when the next step must wait.

---

## Lab 3 — Missing `return`

### Problem

```js
Promise.resolve(5)
    .then(value => {
        Promise.resolve(value * 2);
    })
    .then(console.log);
```

### Fixed

```js
Promise.resolve(5)
    .then(value => {
        return Promise.resolve(value * 2);
    })
    .then(console.log);
```

**Key:** No `return` → next `.then()` gets `undefined`.

---

## Lab 4 — Error Propagation

```js
Promise.resolve()
    .then(() => {
        console.log("A");
        throw new Error("Failed");
    })
    .then(() => {
        console.log("B");
    })
    .catch(error => {
        console.log(error.message);
    });
```

Output:

```text
A
Failed
```

**Key:** Rejection skips fulfillment handlers until `catch()`.

---

## Lab 5 — Error Recovery

```js
Promise.reject(new Error("Failed"))
    .catch(error => {
        console.log(error.message);
        return "Recovered";
    })
    .then(console.log);
```

Output:

```text
Failed
Recovered
```

**Key:** `catch()` can return a value and continue the chain.

---

## Lab 6 — Fetch Chain

```text
GET users
→ JSON
→ first id
→ GET user
→ JSON
→ print
```

```js
fetch("https://jsonplaceholder.typicode.com/users")
    .then(response => response.json())
    .then(users => {
        return fetch(
            `https://jsonplaceholder.typicode.com/users/${users[0].id}`
        );
    })
    .then(response => response.json())
    .then(user => console.log(user))
    .catch(error => console.log(error.message));
```

**Key:** Return the second Fetch Promise because it depends on the first result.

---

## Lab 7 — Promise + `filter()` + `map()`

```js
const requests = [
    { id: 1, status: 200, resTime: 100 },
    { id: 2, status: 500, resTime: 300 },
    { id: 3, status: 404, resTime: 200 }
];

Promise.resolve(requests)
    .then(requests =>
        requests.filter(request => request.status >= 400)
    )
    .then(failed =>
        failed.map(request => request.id)
    )
    .then(console.log);
```

Output:

```text
[2, 3]
```

**Key:** Each `.then()` returns the data needed by the next stage.

---

## Lab 8 — Promise + `filter()` + `reduce()`

```js
Promise.resolve(requests)
    .then(requests =>
        requests.filter(request => request.status >= 400)
    )
    .then(failed =>
        failed.reduce(
            (total, request) => total + request.resTime,
            0
        )
    )
    .then(console.log);
```

Output:

```text
500
```

**Key:** Your Folder 02 methods work directly on Promise results.

---

## Lab 9 — DevAPI Sequential Flow

```text
validate → process → analytics
```

```js
function validate(request) {
    return Promise.resolve(request);
}

function process(request) {
    return Promise.resolve(request);
}

function analytics(request) {
    return Promise.resolve({
        id: request.id,
        status: request.status
    });
}

validate({ id: 101, status: 200 })
    .then(process)
    .then(analytics)
    .then(console.log)
    .catch(error => console.log(error.message));
```

**Key:** Each stage returns a Promise.

---

## Lab 10 — Promise + Timer

```js
Promise.resolve("Start")
    .then(value => {
        return new Promise(resolve => {
            setTimeout(() => {
                resolve(value + " → Done");
            }, 1000);
        });
    })
    .then(console.log);
```

Output after about 1 second:

```text
Start → Done
```

**Key:** Returning the delayed Promise keeps the chain sequential.

---

# Final Logic Pattern

```text
What do I receive?
        ↓
What do I need?
        ↓
What operation produces it?
        ↓
What should I return?
```

Examples:

```text
requests → failed → filter()

failed → IDs → map()

failed → total time → reduce()

async next step → return Promise
```

---

# Completion

- [x] Value chain
- [x] Return Promise
- [x] Missing return
- [x] Error propagation
- [x] Error recovery
- [x] Fetch chaining
- [x] Promise + filter/map
- [x] Promise + filter/reduce
- [x] DevAPI flow
- [x] Promise + timer

**Promise Chaining Lab — COMPLETE ✅**

**Next:** `13-Async-Await-Lab.md`
