# 11 — Promises Hands-On Lab — Completed

**Folder:** `03-Asynchronous-JavaScript`

> **Purpose:** Completed reference for revision. First try each lab yourself, then use the solution to compare.

Your existing practice already covers Promise creation, `resolve/reject`, `then/catch/finally`, executor timing, returned values, returned Promises, and basic error propagation. fileciteturn5file0L301-L321 fileciteturn5file0L325-L344

---

# 1. Master Promise Mental Model

```text
new Promise(...)
      ↓
Pending
      ↓
resolve() / reject()
      ↓
Fulfilled / Rejected
      ↓
then() / catch() / finally()
```

Remember:

```text
Promise executor
→ runs immediately

then/catch/finally callbacks
→ run later through Promise microtask processing
```

---

# 2. Lab 1 — Create a Promise

## Requirement

Create a Promise that fulfills with:

```text
"Success"
```

## Solution

```js
const promise = new Promise((resolve, reject) => {
    resolve("Success");
});

promise.then(value => {
    console.log(value);
});
```

Output:

```text
Success
```

### What to learn

```text
resolve("Success")
→ Promise becomes fulfilled

.then()
→ receives "Success"
```

---

# 3. Lab 2 — Reject a Promise

## Requirement

Reject with:

```text
"Network Error"
```

## Solution

```js
const promise = new Promise((resolve, reject) => {
    reject(new Error("Network Error"));
});

promise.catch(error => {
    console.log(error.message);
});
```

Output:

```text
Network Error
```

---

# 4. Lab 3 — Success or Failure

## Requirement

Use:

```js
const success = true;
```

## Solution

```js
const success = true;

const promise = new Promise((resolve, reject) => {
    if (success) {
        resolve("Login successful");
    } else {
        reject(new Error("Login failed"));
    }
});

promise
    .then(value => {
        console.log(value);
    })
    .catch(error => {
        console.log(error.message);
    });
```

Change:

```js
const success = false;
```

and the output becomes:

```text
Login failed
```

---

# 5. Lab 4 — Promise + Timer

## Requirement

Resolve after 2 seconds.

## Solution

```js
const promise = new Promise((resolve, reject) => {
    setTimeout(() => {
        resolve("Done");
    }, 2000);
});

console.log("Start");

promise.then(value => {
    console.log(value);
});
```

Output:

```text
Start
Done
```

with approximately a 2-second delay before `Done`.

Mental model:

```text
new Promise
   ↓
timer
   ↓
resolve("Done")
   ↓
Promise fulfilled
   ↓
then()
```

---

# 6. Lab 5 — Executor Timing

## Code

```js
console.log("Executor start");

const promise = new Promise((resolve) => {
    console.log("Executor");
    resolve("Done");
});

promise.then(value => {
    console.log(value);
});

console.log("After Promise");
```

## Output

```text
Executor start
Executor
After Promise
Done
```

Important:

```text
new Promise executor
→ immediate

.then()
→ later
```

Your own notes explicitly identify this distinction. fileciteturn5file0L312-L321

---

# 7. Lab 6 — Return Values Through `.then()`

## Requirement

```text
5
↓
+5
↓
×2
↓
20
```

## Solution

```js
Promise.resolve(5)
    .then(value => {
        return value + 5;
    })
    .then(value => {
        return value * 2;
    })
    .then(value => {
        console.log(value);
    });
```

Output:

```text
20
```

Mental model:

```text
5
↓
10
↓
20
```

---

# 8. Lab 7 — Return a Promise

## Requirement

```text
5
↓
return Promise
↓
×2
↓
10
```

## Solution

```js
Promise.resolve(5)
    .then(value => {
        return Promise.resolve(value * 2);
    })
    .then(value => {
        console.log(value);
    });
```

Output:

```text
10
```

Key:

```text
return Promise
→ next then adopts its result
```

You have already practiced this same structure. fileciteturn5file0L331-L342

---

# 9. Lab 8 — Error Propagation

## Code

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

## Output

```text
Something failed
```

`Second then` does not run.

Flow:

```text
then
 ↓
throw
 ↓
rejected Promise
 ↓
skip fulfillment handler
 ↓
catch
```

Your notes already capture this pattern. fileciteturn5file0L337-L344

---

# 10. Lab 9 — `finally()`

## Fulfilled Promise

```js
Promise.resolve("Success")
    .then(value => {
        console.log(value);
    })
    .finally(() => {
        console.log("Finished");
    });
```

Output:

```text
Success
Finished
```

## Rejected Promise

```js
Promise.reject(new Error("Failed"))
    .catch(error => {
        console.log(error.message);
    })
    .finally(() => {
        console.log("Finished");
    });
```

Output:

```text
Failed
Finished
```

Key:

```text
finally()
→ cleanup code
→ runs after settlement
```

---

# 11. Lab 10 — Promise + `setTimeout()`

## Code

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

## Output

```text
Start
End
Promise
Timer
```

Flow:

```text
Start
 ↓
Promise reaction scheduled
 ↓
Timer scheduled
 ↓
End
 ↓
current task finishes
 ↓
microtask
 ↓
Promise
 ↓
next task
 ↓
Timer
```

This uses the microtask knowledge from the previous chapters.

---

# 12. Lab 11 — Promise.all()

## Create the Promises

```js
const p1 = new Promise(resolve => {
    setTimeout(() => resolve("P1"), 1000);
});

const p2 = new Promise(resolve => {
    setTimeout(() => resolve("P2"), 2000);
});

const p3 = new Promise(resolve => {
    setTimeout(() => resolve("P3"), 1500);
});
```

Run:

```js
Promise.all([p1, p2, p3])
    .then(values => {
        console.log(values);
    });
```

Output:

```js
["P1", "P2", "P3"]
```

The result arrives when all inputs fulfill.

Important:

```text
Execution timing
→ depends on completion

Result order
→ follows input order
```

## One rejection

```js
const p1 = Promise.resolve("P1");

const p2 = Promise.reject(new Error("P2 failed"));

const p3 = Promise.resolve("P3");

Promise.all([p1, p2, p3])
    .then(values => {
        console.log(values);
    })
    .catch(error => {
        console.log(error.message);
    });
```

Output:

```text
P2 failed
```

---

# 13. Lab 12 — Promise.allSettled()

Use mixed results:

```js
const p1 = Promise.resolve("P1");

const p2 = Promise.reject(new Error("P2 failed"));

const p3 = Promise.resolve("P3");

Promise.allSettled([p1, p2, p3])
    .then(results => {
        console.log(results);
    });
```

The returned Promise fulfills with an array describing every outcome.

Conceptually:

```text
[
  fulfilled,
  rejected,
  fulfilled
]
```

Key:

```text
allSettled()
→ waits for all inputs
→ reports all outcomes
```

---

# 14. Lab 13 — Promise.race()

## Setup

```js
const p1 = new Promise(resolve => {
    setTimeout(() => resolve("P1"), 2000);
});

const p2 = new Promise(resolve => {
    setTimeout(() => resolve("P2"), 1000);
});
```

Run:

```js
Promise.race([p1, p2])
    .then(value => {
        console.log(value);
    });
```

Output:

```text
P2
```

because `P2` settles first.

## Important test

Make the faster Promise reject:

```js
const p1 = new Promise(resolve => {
    setTimeout(() => resolve("P1"), 2000);
});

const p2 = new Promise((resolve, reject) => {
    setTimeout(() => reject(new Error("P2 failed")), 1000);
});

Promise.race([p1, p2])
    .then(value => console.log(value))
    .catch(error => console.log(error.message));
```

Output:

```text
P2 failed
```

Key:

```text
race()
→ first settled wins
```

---

# 15. Lab 14 — Promise.any()

## Setup

```js
const p1 = new Promise((resolve, reject) => {
    setTimeout(() => reject(new Error("P1 failed")), 1000);
});

const p2 = new Promise(resolve => {
    setTimeout(() => resolve("P2"), 2000);
});

const p3 = new Promise(resolve => {
    setTimeout(() => resolve("P3"), 3000);
});
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

Output:

```text
P2
```

The first rejection does not win.

Key:

```text
any()
→ first fulfilled wins
→ rejects only if all inputs reject
```

---

# 16. Lab 15 — Compare Combinators

| Method | Main rule |
|---|---|
| `Promise.all()` | Need all inputs to fulfill |
| `Promise.race()` | First input to settle wins |
| `Promise.any()` | First input to fulfill wins |
| `Promise.allSettled()` | Wait for all outcomes |

Decision rule:

```text
Need every successful result?
→ all()

Need whichever settles first?
→ race()

Need whichever succeeds first?
→ any()

Need every outcome?
→ allSettled()
```

---

# 17. Lab 16 — Missing Return

## Bug

```js
Promise.resolve(5)
    .then(value => {
        Promise.resolve(value * 2);
    })
    .then(value => {
        console.log(value);
    });
```

## What goes wrong?

The first callback does not return the Promise.

So:

```text
first then
→ returns undefined
```

The second `.then()` receives:

```text
undefined
```

## Fix

```js
Promise.resolve(5)
    .then(value => {
        return Promise.resolve(value * 2);
    })
    .then(value => {
        console.log(value);
    });
```

Output:

```text
10
```

---

# 18. Lab 17 — Fetch + Promise Chain

## Requirement

```text
fetch
↓
Response
↓
JSON
↓
users
```

## Solution

```js
fetch("https://jsonplaceholder.typicode.com/users")
    .then(response => {
        return response.json();
    })
    .then(users => {
        console.log(users);
    })
    .catch(error => {
        console.log(error.message);
    });
```

Important:

```text
return response.json()
→ next then receives parsed users
```

Your Fetch practice already uses the same Fetch → JSON shape. fileciteturn5file0L124-L135

---

# 19. Lab 18 — DevAPI Success Simulation

```js
function getRequest() {
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            resolve({
                id: 101,
                status: 200,
                resTime: 1000
            });
        }, 1000);
    });
}

console.log("Request started");

getRequest()
    .then(request => {
        console.log("Response received");
        console.log(request);
    })
    .finally(() => {
        console.log("Request finished");
    });
```

Flow:

```text
Request started
 ↓
1 second
 ↓
resolve request
 ↓
then()
 ↓
finally()
```

---

# 20. Lab 19 — DevAPI Failure Simulation

```js
function getRequest() {
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            reject(new Error("Request failed"));
        }, 1000);
    });
}

getRequest()
    .then(request => {
        console.log(request);
    })
    .catch(error => {
        console.log(error.message);
    })
    .finally(() => {
        console.log("Request finished");
    });
```

Output:

```text
Request failed
Request finished
```

Important:

```text
Promise rejection
≠
HTTP status automatically
```

Your program explicitly decides when to call `reject()`.

---

# 21. Lab 20 — Promise + Functional JavaScript

```js
const requests = [
    { id: 1, status: 200, resTime: 100 },
    { id: 2, status: 500, resTime: 300 },
    { id: 3, status: 404, resTime: 200 }
];

Promise.resolve(requests)
    .then(requests => {
        return requests.filter(request => request.status >= 400);
    })
    .then(failedRequests => {
        return failedRequests.map(request => request.id);
    })
    .then(ids => {
        console.log(ids);
    });
```

Output:

```text
[2, 3]
```

Flow:

```text
requests
 ↓
filter()
 ↓
failed requests
 ↓
map()
 ↓
IDs
```

---

# 22. Lab 21 — Promise + reduce()

```js
const requests = [
    { id: 1, status: 200, resTime: 100 },
    { id: 2, status: 500, resTime: 300 },
    { id: 3, status: 404, resTime: 200 }
];

Promise.resolve(requests)
    .then(requests => {
        return requests.filter(request => request.status >= 400);
    })
    .then(failedRequests => {
        return failedRequests.reduce(
            (total, request) => total + request.resTime,
            0
        );
    })
    .then(total => {
        console.log(total);
    });
```

Output:

```text
500
```

This is the direct connection:

```text
Promise
+
filter
+
reduce
```

---

# 23. Lab 22 — Final DevAPI Challenge

Build this independently first:

```text
Async request simulation
↓
wait 1 second
↓
resolve request array
↓
filter status >= 400
↓
map IDs
↓
reduce response time
↓
create analytics object
↓
catch error
↓
finally "Request Finished"
```

## Completed Reference

```js
function getRequests() {
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            resolve([
                { id: 1, status: 200, resTime: 100 },
                { id: 2, status: 500, resTime: 300 },
                { id: 3, status: 404, resTime: 200 }
            ]);
        }, 1000);
    });
}

getRequests()
    .then(requests => {
        const failedRequests = requests.filter(
            request => request.status >= 400
        );

        const failedIds = failedRequests.map(
            request => request.id
        );

        const totalFailedResponseTime = failedRequests.reduce(
            (total, request) => total + request.resTime,
            0
        );

        return {
            failedIds,
            failedCount: failedRequests.length,
            totalFailedResponseTime
        };
    })
    .then(analytics => {
        console.log(analytics);
    })
    .catch(error => {
        console.log(error.message);
    })
    .finally(() => {
        console.log("Request Finished");
    });
```

Output:

```js
{
    failedIds: [2, 3],
    failedCount: 2,
    totalFailedResponseTime: 500
}
```

---

# 24. Final Mastery Test

You should now be able to write, without copying:

```text
Create Promise
    ↓
resolve after delay
    ↓
receive request array
    ↓
filter failures
    ↓
map IDs
    ↓
reduce total response time
    ↓
return analytics
    ↓
catch
    ↓
finally
```

Required:

```text
Promise
setTimeout
resolve/reject
then
return
filter
map
reduce
catch
finally
```

---

# 25. Logic-Building Framework

When working inside `.then()`:

```text
What do I receive?
        ↓
What type is it?
        ↓
What do I need next?
        ↓
Which operation produces it?
        ↓
What should I return?
```

Examples:

```text
requests
 ↓
failed requests
 ↓
filter()
```

```text
failed requests
 ↓
IDs
 ↓
map()
```

```text
failed requests
 ↓
total response time
 ↓
reduce()
```

---

# 26. Debugging Framework

If a chain is broken:

```text
1. Log what enters the then().
2. Log what you return.
3. Check value vs Promise.
4. Check fulfilled vs rejected.
5. Find the handler receiving it.
```

Useful temporary pattern:

```js
.then(value => {
    console.log("Received:", value);

    const nextValue = ...;

    console.log("Returning:", nextValue);

    return nextValue;
});
```

---

# 27. Quick Revision Card

```text
Promise
→ future result

Pending
→ Fulfilled / Rejected

resolve()
→ fulfillment

reject()
→ rejection

then()
→ fulfillment handling

catch()
→ rejection handling

finally()
→ cleanup after settlement

return value
→ next then receives value

return Promise
→ next then adopts its result

all()
→ all fulfill

race()
→ first settled

any()
→ first fulfilled

allSettled()
→ all settle
```

---

# 28. Completion Status

### Already practiced

- [x] Create Promise
- [x] resolve / reject
- [x] then / catch / finally
- [x] executor timing
- [x] Promise.resolve()
- [x] return values
- [x] return Promise
- [x] basic error propagation

### Completed in this lab

- [x] Promise.all()
- [x] Promise.race()
- [x] Promise.any()
- [x] Promise.allSettled()
- [x] Promise + filter
- [x] Promise + map
- [x] Promise + reduce
- [x] DevAPI success simulation
- [x] DevAPI failure simulation
- [x] DevAPI analytics
- [x] Final mastery test

---

# Final Mental Model

```text
Async Operation
      ↓
Promise
      ↓
Pending
      ↓
Fulfilled / Rejected
      ↓
then / catch / finally
      ↓
Functional processing
      ↓
DevAPI result
```

**Promise foundation: COMPLETE ✅**

**Next learning:** `12-Promise-Chaining.md`
