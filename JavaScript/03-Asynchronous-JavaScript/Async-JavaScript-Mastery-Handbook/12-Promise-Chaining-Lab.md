# 12 — Promise Chaining Hands-On Lab

**Folder:** `03-Asynchronous-JavaScript`

> **Rule:** Predict → Write → Run → Observe → Explain.

The main skill:

```text
What enters this then?
        ↓
What do I need next?
        ↓
What should I return?
```

---

## Lab 1 — Three-Step Chain

Build:

```text
2
↓
+2
↓
×3
↓
print
```

Scaffold:

```js
Promise.resolve(2)
    .then(value => {
        // return value + 2
    })
    .then(value => {
        // return value * 3
    })
    .then(value => {
        console.log(value);
    });
```

---

## Lab 2 — Track Every Step

Run:

```js
Promise.resolve(5)
    .then(value => {
        console.log("Step 1:", value);
        return value + 5;
    })
    .then(value => {
        console.log("Step 2:", value);
        return value * 2;
    })
    .then(value => {
        console.log("Step 3:", value);
    });
```

Predict every value before running.

---

## Lab 3 — Missing Return

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

Questions:

```text
What does the first then return?
What reaches the second then?
```

Fix it.

---

## Lab 4 — Return a Promise With Timer

Build:

```text
5
 ↓
then
 ↓
wait 1 second
 ↓
multiply by 2
 ↓
next then
 ↓
print
```

Try it yourself using:

```js
return new Promise(...)
```

---

## Lab 5 — Nested to Flat

Convert this:

```js
Promise.resolve("Login")
    .then(loginResult => {
        return Promise.resolve("Profile")
            .then(profileResult => {
                return Promise.resolve("Orders");
            });
    })
    .then(result => {
        console.log(result);
    });
```

into a flat chain:

```text
Login
 ↓
Profile
 ↓
Orders
```

---

## Lab 6 — Error Propagation

Predict:

```js
Promise.resolve("A")
    .then(value => {
        console.log(value);
        throw new Error("Failed");
    })
    .then(() => {
        console.log("B");
    })
    .catch(error => {
        console.log(error.message);
    });
```

Questions:

```text
Does B print?
Why?
Which handler receives the error?
```

Then run it.

---

## Lab 7 — Recover From Error

Build:

```text
Promise
 ↓
throw error
 ↓
catch
 ↓
return fallback value
 ↓
next then
```

Target:

```text
Recovered
```

Important idea:

```text
catch()
→ can recover by returning a value
```

---

## Lab 8 — Fetch Chaining

Build:

```text
GET /users
    ↓
parse JSON
    ↓
take first user's id
    ↓
GET /users/{id}
    ↓
parse JSON
    ↓
print user
```

Start:

```js
fetch("https://jsonplaceholder.typicode.com/users")
    .then(response => {
        // return response.json()
    })
    .then(users => {
        // return second fetch
    })
    .then(response => {
        // return response.json()
    })
    .then(user => {
        // print
    })
    .catch(error => {
        console.log(error);
    });
```

Build each stage independently.

---

## Lab 9 — Promise + Functional JavaScript

Create a Promise resolving to request objects.

Then:

```text
filter failed requests
 ↓
map request IDs
 ↓
print IDs
```

Use your Folder 02 knowledge:

```text
filter()
map()
```

---

## Lab 10 — Promise + Reduce

Build:

```text
Promise
 ↓
filter status >= 400
 ↓
reduce response times
 ↓
print total
```

Think:

```text
Promise result
 ↓
array
 ↓
filter
 ↓
array
 ↓
reduce
 ↓
number
```

---

## Lab 11 — DevAPI Sequential Flow

Simulate:

```text
Request received
 ↓
Validate request
 ↓
Process request
 ↓
Generate analytics
 ↓
Finish
```

Make each stage return a Promise.

Target pattern:

```js
validateRequest()
    .then(processRequest)
    .then(generateAnalytics)
    .then(result => {
        console.log(result);
    })
    .catch(error => {
        console.log(error.message);
    });
```

Create the functions yourself.

---

## Lab 12 — Debug the Chain

Find the problem:

```js
Promise.resolve([1, 2, 3, 4])
    .then(numbers => {
        numbers.filter(num => num > 2);
    })
    .then(numbers => {
        console.log(numbers);
    });
```

Ask:

```text
What does filter return?
Was it returned?
What reaches the next then?
```

Fix it.

---

## Lab 13 — Error in the Middle

Build:

```text
Step 1 → success
Step 2 → throws
Step 3 → should skip
catch → handles error
```

Verify that Step 3 does not execute.

---

## Lab 14 — Independent Challenge

Create:

```text
Promise resolves with:
[
  { id: 1, status: 200, resTime: 100 },
  { id: 2, status: 500, resTime: 300 },
  { id: 3, status: 404, resTime: 200 }
]
```

Then:

```text
Promise
 ↓
filter failures
 ↓
map IDs
 ↓
print
```

Expected:

```text
[2, 3]
```

---

## Lab 15 — Independent DevAPI Analytics

Without copying:

```text
Promise
 ↓
resolve request array
 ↓
filter status >= 400
 ↓
reduce total response time
 ↓
print total
```

You should independently choose:

```text
filter()
reduce()
```

---

## Lab 16 — Final Mastery Test

Build this without notes:

```text
1. Simulate an async request with Promise.
2. Wait 1 second.
3. Resolve an array of request objects.
4. Filter failed requests.
5. Map their IDs.
6. Print IDs.
7. Throw an error when a condition fails.
8. Catch the error.
9. Finally print "Finished".
```

Required:

```text
Promise
setTimeout
then
return
filter
map
throw
catch
finally
```

---

# Logic-Building Framework

For every `.then()`:

```text
What do I receive?
        ↓
What do I need next?
        ↓
What should I return?
```

Examples:

```text
Receive users
 ↓
Need user IDs
 ↓
map()
 ↓
return IDs
```

```text
Receive requests
 ↓
Need failures
 ↓
filter()
 ↓
return failed requests
```

```text
Receive failures
 ↓
Need total time
 ↓
reduce()
 ↓
return total
```

---

# Debugging Framework

When a chain fails:

```text
1. What enters this then?
2. What does this then return?
3. Is the return value correct?
4. Is it a Promise?
5. Which then receives it?
6. Where would an error go?
```

During debugging, expand the chain and log intermediate values.

---

# Completion Checklist

- [ ] Three-step value chain
- [ ] Value propagation
- [ ] Missing return
- [ ] Return a Promise
- [ ] Promise with timer
- [ ] Nested → flat chain
- [ ] Error propagation
- [ ] Error recovery
- [ ] Fetch chaining
- [ ] Promise + filter/map
- [ ] Promise + filter/reduce
- [ ] DevAPI sequential flow
- [ ] Debug missing return
- [ ] Independent final challenge
- [ ] Final mastery test

**Next:** `13-Async-Await.md`
