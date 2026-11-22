# 11 — JavaScript Promises

**Folder:** `03-Asynchronous-JavaScript`

> **Core idea:** A Promise represents the eventual completion or failure of an asynchronous operation.

## 1. Promise

A Promise represents a future result:

```text
Pending
   ↓
Fulfilled
```

or:

```text
Pending
   ↓
Rejected
```

A Promise settles only once.

---

## 2. Why Promises?

Nested callbacks can become difficult to read:

```js
login(() => {
    getProfile(() => {
        getPosts(() => {
            getComments(() => {});
        });
    });
});
```

Promises provide a flatter flow:

```js
login()
    .then(getProfile)
    .then(getPosts)
    .then(getComments);
```

---

## 3. Creating a Promise

```js
const promise = new Promise((resolve, reject) => {
    const success = true;

    if (success) {
        resolve("Done");
    } else {
        reject(new Error("Failed"));
    }
});
```

Important:

```text
Promise executor
→ runs immediately
```

The `.then()` reaction runs later through microtask processing.

---

## 4. resolve() and reject()

```js
resolve("Success");
```

means successful completion.

```js
reject(new Error("Failed"));
```

means failure.

```text
resolve → fulfilled
reject  → rejected
```

---

## 5. Consuming a Promise

```js
promise
    .then(value => {
        console.log(value);
    })
    .catch(error => {
        console.log(error.message);
    })
    .finally(() => {
        console.log("Finished");
    });
```

### then()

Handles fulfillment.

### catch()

Handles rejection.

### finally()

Runs after settlement regardless of outcome.

---

## 6. Promise Chaining

```js
Promise.resolve(2)
    .then(num => num * 2)
    .then(num => num + 5)
    .then(console.log);
```

Flow:

```text
2
↓
4
↓
9
```

A returned value becomes the next `.then()` input.

---

## 7. Returning a Promise

```js
Promise.resolve(5)
    .then(num => {
        return Promise.resolve(num * 2);
    })
    .then(console.log);
```

The next `.then()` waits for the returned Promise to settle.

---

## 8. Error Propagation

```js
Promise.resolve()
    .then(() => {
        throw new Error("Oops");
    })
    .catch(error => {
        console.log(error.message);
    });
```

Flow:

```text
then
↓
throw
↓
rejected Promise
↓
catch
```

---

## 9. Promise Combinators

### Promise.all()

```js
Promise.all([p1, p2, p3]);
```

Fulfills when all fulfill; rejects when an input rejects.

### Promise.race()

```js
Promise.race([p1, p2]);
```

Settles with the first input to settle.

### Promise.any()

```js
Promise.any([p1, p2, p3]);
```

Fulfills with the first fulfilled input. If all reject, it rejects.

### Promise.allSettled()

```js
Promise.allSettled([p1, p2, p3]);
```

Waits for every input to settle and reports all outcomes.

| Method | Main behavior |
|---|---|
| `all()` | All fulfill or returned Promise rejects |
| `race()` | First settled wins |
| `any()` | First fulfilled wins |
| `allSettled()` | Wait for all outcomes |

---

## 10. Promise + Microtask Queue

```js
console.log("Start");

Promise.resolve().then(() => {
    console.log("Promise");
});

console.log("End");
```

Output:

```text
Start
End
Promise
```

Mental model:

```text
current task
↓
current code finishes
↓
microtask
↓
Promise callback
```

---

## 11. Promise vs setTimeout()

```js
setTimeout(() => {
    console.log("Timer");
}, 0);

Promise.resolve().then(() => {
    console.log("Promise");
});
```

Typical ordering:

```text
Promise
Timer
```

Promise reactions are processed as microtasks before the next timer task.

---

## 12. Promise + Fetch

Fetch returns a Promise:

```text
fetch()
↓
Promise<Response>
↓
then() / await
↓
Response
```

This is why Promises are essential for understanding Fetch and async/await.

---

## 13. Common Mistakes

### Forgetting to return

Wrong:

```js
.then(data => {
    fetch(url);
})
```

When the next step must wait for Fetch:

```js
.then(data => {
    return fetch(url);
})
```

### Ignoring rejection

Use:

```js
.catch(...)
```

or:

```js
try/catch
```

with `await`.

### Thinking Promise executor is asynchronous

It is not automatically asynchronous.

### Thinking .then() runs immediately

Promise reactions run asynchronously.

### Thinking one rejection cancels the underlying operations in Promise.all()

`Promise.all()` rejects its returned Promise, but other input operations may continue independently.
