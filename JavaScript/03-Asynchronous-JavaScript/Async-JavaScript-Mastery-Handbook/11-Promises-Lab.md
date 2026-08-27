# 11 — Promises Hands-On Lab

**Folder:** `03-Asynchronous-JavaScript`

> **Rule:** Predict → Write → Run → Observe → Explain.

Do not copy the solution before attempting the task.

---

## Lab 1 — Create a Promise

Create a Promise that fulfills with:

```text
"Success"
```

Start:

```js
const promise = new Promise((resolve, reject) => {
    // your code
});

promise.then(value => {
    console.log(value);
});
```

---

## Lab 2 — Reject a Promise

Create a Promise that rejects with:

```text
"Network Error"
```

Handle it with:

```js
.catch(...)
```

---

## Lab 3 — Success or Failure

Create:

```js
const success = true;
```

If true:

```text
resolve("Login successful")
```

Otherwise:

```text
reject("Login failed")
```

Use `then()` and `catch()`.

---

## Lab 4 — Promise + Timer

Create a Promise that resolves after 2 seconds.

Target:

```text
Start
↓
2 seconds
↓
Done
```

Scaffold:

```js
const promise = new Promise((resolve, reject) => {
    setTimeout(() => {
        // resolve here
    }, 2000);
});

promise.then(value => {
    console.log(value);
});
```

---

## Lab 5 — Executor Timing

Run:

```js
const promise = new Promise((resolve, reject) => {
    console.log("Executor");
    resolve("Done");
});

promise.then(value => {
    console.log(value);
});
```

Predict first:

```text
What prints first?
Why?
```

Key lesson:

```text
executor → immediate
then callback → later
```

---

## Lab 6 — Return Values Through `.then()`

Build:

```text
5
↓
+5
↓
×2
↓
print
```

Expected:

```text
20
```

Scaffold:

```js
Promise.resolve(5)
    .then(value => {
        // return value + 5
    })
    .then(value => {
        // return value * 2
    })
    .then(value => {
        console.log(value);
    });
```

---

## Lab 7 — Return a Promise

Build:

```text
5
↓
return Promise
↓
×2
↓
print
```

Use:

```js
return Promise.resolve(...);
```

Ask:

> Why does the next `.then()` wait?

---

## Lab 8 — Error Propagation

Run:

```js
Promise.resolve()
    .then(() => {
        throw new Error("Something failed");
    })
    .then(() => {
        console.log("Second then");
    })
    .catch(error => {
        console.log(error.message);
    });
```

Predict:

```text
Does "Second then" print?
```

Then explain why.

---

## Lab 9 — finally()

Create one fulfilled Promise and one rejected Promise.

Add:

```js
.finally(() => {
    console.log("Finished");
});
```

Verify that `finally()` runs in both cases.

---

## Lab 10 — Promise + setTimeout

Predict before running:

```js
console.log("Start");

Promise.resolve().then(() => {
    console.log("Promise");
});

setTimeout(() => {
    console.log("Timer");
}, 0);

console.log("End");
```

Expected:

```text
Start
End
Promise
Timer
```

Explain using:

```text
current task
↓
microtask
↓
next task
```

---

## Lab 11 — Promise.all()

Create:

```text
p1
p2
p3
```

where all fulfill.

Run:

```js
Promise.all([p1, p2, p3])
    .then(values => {
        console.log(values);
    });
```

Then make one reject.

Observe what happens.

---

## Lab 12 — Promise.allSettled()

Use the same Promises.

Run:

```js
Promise.allSettled([p1, p2, p3])
    .then(results => {
        console.log(results);
    });
```

Make one succeed and one fail.

Question:

> Does the returned Promise reject?

---

## Lab 13 — Promise.race()

Create:

```text
P1 → 2 seconds
P2 → 1 second
```

Run:

```js
Promise.race([p1, p2])
    .then(value => {
        console.log(value);
    });
```

Predict the winner.

---

## Lab 14 — Promise.any()

Create:

```text
P1 → reject after 1 sec
P2 → resolve after 2 sec
P3 → resolve after 3 sec
```

Run:

```js
Promise.any([p1, p2, p3])
    .then(value => {
        console.log(value);
    })
    .catch(error => {
        console.log(error);
    });
```

Question:

> Does the first rejection win?

---

## Lab 15 — Compare Combinators

Use the same group of Promises and test:

```text
Promise.all()
Promise.race()
Promise.any()
Promise.allSettled()
```

Create your own table:

```text
Method
↓
What does it wait for?
↓
What happens on rejection?
↓
What result do I receive?
```

---

## Lab 16 — Missing Return

Find the bug:

```js
Promise.resolve(5)
    .then(value => {
        Promise.resolve(value * 2);
    })
    .then(value => {
        console.log(value);
    });
```

Question:

```text
Why is the second then not receiving 10?
```

Fix it.

---

## Lab 17 — Fetch + Promise Chain

Complete:

```js
fetch("https://jsonplaceholder.typicode.com/users")
    .then(response => {
        // return parsed JSON
    })
    .then(users => {
        // print users
    })
    .catch(error => {
        console.log(error);
    });
```

Think:

```text
fetch
↓
Response
↓
return response.json()
↓
users
```

---

## Lab 18 — DevAPI Success Simulation

Create a Promise that simulates:

```text
request starts
↓
wait 2 seconds
↓
resolve request object
```

Resolve with:

```js
{
    id: 101,
    status: 200,
    resTime: 2000
}
```

Then:

```text
Promise
↓
then
↓
print request
```

---

## Lab 19 — DevAPI Failure Simulation

Modify the simulation:

```text
status >= 400
→ reject
```

Handle:

```text
success → then()
failure → catch()
always → finally()
```

---

## Lab 20 — Promise + Functional JavaScript

Create a Promise that resolves with an array of request objects.

Then:

```text
filter failed requests
↓
map request IDs
↓
print IDs
```

You already know:

```text
filter()
map()
```

The new skill is:

```text
Promise
+
functional processing
```

---

## Lab 21 — Promise + reduce()

Create a Promise that resolves with request objects.

Then:

```text
filter status >= 400
↓
reduce response times
↓
print total
```

This combines:

```text
Promise
+
filter
+
reduce
```

---

## Lab 22 — Independent DevAPI Challenge

Without looking at previous solutions:

```text
Create asynchronous request simulation
↓
wait 1 second
↓
resolve request array
↓
filter failures
↓
map request IDs
↓
print IDs
↓
catch errors
↓
finally "Request finished"
```

Break it into steps before coding.

---

## Lab 23 — Final Mastery Test

Build this independently:

```text
Async Request
    ↓
Promise
    ↓
1 second delay
    ↓
resolve request array
    ↓
filter failures
    ↓
reduce response time
    ↓
print total
    ↓
catch error
    ↓
finally "Finished"
```

Required concepts:

```text
Promise
setTimeout
resolve/reject
then
catch
finally
filter
reduce
```

Do not copy a complete solution.

---

# Logic-Building Framework

When stuck:

```text
1. What does my Promise resolve with?
2. What type is that value?
3. What output do I need?
4. Do I need one item or many?
5. Which array method gives that output?
6. What should happen on failure?
```

Example:

```text
Promise resolves with requests
↓
Need failed requests
↓
filter()

Need IDs
↓
map()

Need total response time
↓
reduce()
```

---

# Debugging Framework

When a chain fails:

```text
1. What does this .then() receive?
2. What does it return?
3. Is it a normal value?
4. Is it a Promise?
5. Could it reject?
6. Which catch handles it?
```

Expand a chain when debugging:

```js
.then(value => {
    console.log("Step 1:", value);

    const next = ...;

    console.log("Step 2:", next);

    return next;
});
```

---

# Completion Checklist

- [ ] Create Promise
- [ ] resolve/reject
- [ ] then/catch/finally
- [ ] executor timing
- [ ] return values
- [ ] return Promises
- [ ] error propagation
- [ ] Promise.all
- [ ] Promise.race
- [ ] Promise.any
- [ ] Promise.allSettled
- [ ] Promise + setTimeout
- [ ] Promise + Fetch
- [ ] Promise + filter + map
- [ ] Promise + filter + reduce
- [ ] DevAPI success simulation
- [ ] DevAPI failure simulation
- [ ] Final independent challenge
