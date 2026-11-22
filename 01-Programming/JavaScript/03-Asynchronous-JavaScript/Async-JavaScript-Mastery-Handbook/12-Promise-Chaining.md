# 12 — Promise Chaining

**Folder:** `03-Asynchronous-JavaScript`

> **Core idea:** Promise chaining connects multiple asynchronous steps so each step can use the previous step's result.

## 1. What Is Promise Chaining?

```text
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

Example:

```js
Promise.resolve(5)
    .then(num => num + 5)
    .then(num => num * 2)
    .then(console.log);
```

Flow:

```text
5 → 10 → 20
```

---

## 2. Why Chaining?

Nested callbacks become hard to read:

```js
login(() => {
    getProfile(() => {
        getPosts(() => {
            getComments(() => {});
        });
    });
});
```

Promise chaining gives a flatter structure:

```js
login()
    .then(getProfile)
    .then(getPosts)
    .then(getComments);
```

---

## 3. How Chaining Works

Each `.then()` receives the fulfillment value produced by the previous step.

```js
Promise.resolve(10)
    .then(num => num + 5)
    .then(num => num * 2)
    .then(console.log);
```

```text
10
↓
15
↓
30
```

---

## 4. Returning Values

```js
Promise.resolve(10)
    .then(num => {
        return num + 10;
    })
    .then(console.log);
```

The returned value becomes the next `.then()` input.

```text
return value
     ↓
next then()
```

---

## 5. Returning Promises

A `.then()` can return another Promise:

```js
Promise.resolve(5)
    .then(num => {
        return Promise.resolve(num * 2);
    })
    .then(console.log);
```

Conceptually:

```text
then()
 ↓
returned Promise
 ↓
Promise settles
 ↓
next then()
```

This is how sequential asynchronous work is composed.

---

## 6. Nested Promises vs Chaining

Avoid unnecessary nesting:

```js
login()
    .then(() => {
        profile().then(() => {
            posts();
        });
    });
```

Prefer:

```js
login()
    .then(() => {
        return profile();
    })
    .then(() => {
        return posts();
    });
```

Or:

```js
login()
    .then(profile)
    .then(posts);
```

### Key rule

```text
Need the next step to wait?
        ↓
Return the Promise.
```

---

## 7. Why Returning Matters

Wrong:

```js
.then(() => {
    fetch(url);
})
.then(response => {
    console.log(response);
});
```

Correct:

```js
.then(() => {
    return fetch(url);
})
.then(response => {
    console.log(response);
});
```

Without `return`, the chain does not adopt that Fetch Promise.

---

## 8. Error Propagation

```js
Promise.resolve()
    .then(() => {
        throw new Error("Network Error");
    })
    .catch(error => {
        console.log(error.message);
    });
```

Flow:

```text
then()
 ↓
throw
 ↓
rejected Promise
 ↓
catch()
```

A thrown error causes the Promise returned by that `.then()` to reject.

---

## 9. Chain Breaking

```js
Promise.reject("Failed")
    .then(() => console.log("A"))
    .then(() => console.log("B"))
    .catch(error => console.log(error));
```

Output:

```text
Failed
```

The fulfilled handlers are skipped until a rejection handler is reached.

---

## 10. Internal Execution Model

```js
Promise.resolve(5)
    .then(x => x + 5)
    .then(console.log);
```

High-level:

```text
Promise
 ↓
Promise reaction / microtask
 ↓
first then
 ↓
returns 10
 ↓
next reaction
 ↓
second then
 ↓
console.log(10)
```

Connect this with:

```text
06-Event-Loop.md
07-Microtask-Queue.md
```

---

## 11. Real-World Sequential Flow

Login:

```js
login()
    .then(getProfile)
    .then(getOrders)
    .then(getPayments)
    .then(logout);
```

Fetch example:

```js
fetch("/users")
    .then(response => response.json())
    .then(users => {
        return fetch(`/users/${users[0].id}`);
    })
    .then(response => response.json())
    .then(user => {
        console.log(user);
    });
```

Each step can pass a value or Promise to the next step.

---

## 12. Common Mistakes

### Not returning the Promise

```js
.then(() => {
    fetch(url);
})
```

Use:

```js
.then(() => {
    return fetch(url);
})
```

### Nested `.then()`

Prefer returning the Promise and continuing the chain.

### Ignoring errors

Use:

```js
.catch(...)
```

when appropriate.

### Thinking every `.then()` callback runs immediately

Promise reactions are processed asynchronously through microtasks.

---

## 13. Dry Runs

### Example 1

```js
Promise.resolve(1)
    .then(x => x + 1)
    .then(x => x + 1)
    .then(console.log);
```

Output:

```text
3
```

### Example 2

```js
Promise.resolve(10)
    .then(x => x * 2)
    .then(x => x - 5)
    .then(console.log);
```

Output:

```text
15
```

### Example 3

```js
Promise.resolve(5)
    .then(x => Promise.resolve(x * 5))
    .then(console.log);
```

Output:

```text
25
```

### Example 4

```js
Promise.resolve()
    .then(() => {
        throw new Error("Oops");
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
Oops
```

---

## 14. Interview Questions

### What is Promise Chaining?

Connecting multiple Promise steps so each step can use the previous result.

### Why return inside `.then()`?

So the next `.then()` receives/adopts the returned value or Promise.

### What if `.then()` returns nothing?

The next `.then()` receives `undefined`.

### Can `.then()` return another Promise?

Yes.

The next step adopts that Promise's eventual result.

### What happens when an error is thrown inside `.then()`?

The returned Promise is rejected and the chain moves to the next rejection handler.

### Can Promise chaining replace callback hell?

Yes.

---

## 15. Completion Checklist

- [ ] I understand Promise chaining.
- [ ] I can pass values between `.then()` calls.
- [ ] I understand why returning matters.
- [ ] I can return another Promise.
- [ ] I can flatten nested Promise code.
- [ ] I understand rejection propagation.
- [ ] I can dry-run a chain.
- [ ] I can identify a missing `return`.
- [ ] I can connect chaining with Fetch.
- [ ] I can explain chaining without memorizing syntax.

**Next:** `13-Async-Await.md`
