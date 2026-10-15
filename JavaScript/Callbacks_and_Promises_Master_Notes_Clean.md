# JavaScript Callbacks & Promises — Clean Master Notes

> **Study goal:** Understand the code, predict the console output, debug your own mistakes, and explain callbacks, Promises, the call stack, Web APIs, queues, the event loop, inversion of control, and callback hell in an interview.
>
> **The running example:** `download → writeFile → uploadFile`
>
> **Important:** These examples simulate slow work with `setTimeout()`. They do not really download network data, write a file to your disk, or upload a file to a server.

---

## 1. The big picture: what are we trying to do?

Suppose three operations must happen in order:

1. Download content from a URL.
2. Write that content to a file and get the filename.
3. Upload the file and receive a response.

The data changes at each step:

```text
URL
 │
 ▼
download(url)
 │ resolves / passes content: "JsDryRun"
 ▼
writeFile(content)
 │ resolves / passes fileName: "file.txt"
 ▼
uploadFile(url, fileName)
 │ resolves / passes response: "SUCCESS"
 ▼
Final result
```

Keep these values distinct:

| Name | Example value | Meaning |
|---|---|---|
| `url` | `"www.comsy.com"` | The download location in this simulation |
| `content` | `"JsDryRun"` | The data returned from the download step |
| `data` | `"JsDryRun"` | The content given to `writeFile()` |
| `fileName` | `"file.txt"` | The filename returned by the writing step |
| `file` | `"file.txt"` | The file argument given to upload |
| `response` | `"SUCCESS"` | The result returned by the upload step |
| `cb` / `callback` | a function | A function to invoke later |
| `resolve` | a function | Fulfills a Promise with a value or adopts another Promise/thenable's state |
| `reject` | a function | Rejects a Promise with a reason |

Names such as `content`, `fileName`, and `response` are not special JavaScript keywords. They are chosen parameter names. What matters is which value is passed into each function.

---

# Part A — JavaScript runtime foundations

## 2. Synchronous vs asynchronous code

### Synchronous code

Synchronous statements run one after another. The current statement must finish before the next statement starts.

```javascript
console.log("A");
console.log("B");
console.log("C");
```

Output:

```text
A
B
C
```

### Asynchronous scheduling

An asynchronous operation lets JavaScript arrange for some work or a callback to happen later without stopping the current JavaScript execution while it waits.

```javascript
console.log("A");

setTimeout(function () {
    console.log("B");
}, 1000);

console.log("C");
```

Output:

```text
A
C
B
```

`setTimeout()` asks the host environment to schedule the callback after the requested delay. The delay is a **minimum scheduling delay**, not a guarantee that the callback runs at that exact millisecond. The callback cannot run until JavaScript gets an opportunity to execute it.

---

## 3. The call stack

The **call stack** tracks JavaScript functions that are currently executing. When a function is called, a stack frame is added. When the function returns, its frame is removed.

Example:

```javascript
function first() {
    console.log("first start");
    second();
    console.log("first end");
}

function second() {
    console.log("second");
}

first();
```

Output:

```text
first start
second
first end
```

Simplified stack while `second()` is running:

```text
TOP OF STACK
┌──────────────────────┐
│ second()              │  ← currently executing
├──────────────────────┤
│ first()               │  ← called second()
├──────────────────────┤
│ global script         │  ← called first()
└──────────────────────┘
BOTTOM OF STACK
```

The stack is not a queue. It is the place for currently executing JavaScript calls.

---

## 4. The host environment, timers, and Web APIs

JavaScript runs inside a host environment such as a browser or Node.js. The host provides facilities that are not simply ordinary JavaScript function calls. In a browser, these include timers, DOM events, and networking APIs. People often use **Web APIs** as a beginner-friendly name for browser-provided features.

When JavaScript encounters:

```javascript
setTimeout(function timerCallback() {
    console.log("Timer finished");
}, 1000);
```

A simplified view is:

1. JavaScript calls `setTimeout()` on the current call stack.
2. The browser's timer facility tracks the delay.
3. `setTimeout()` returns; JavaScript continues running other statements.
4. Once the timer delay has elapsed, the host makes the callback eligible to run as a **task**.
5. The event loop can run that task when the JavaScript thread is ready.

```text
JavaScript call stack          Browser / host environment
┌──────────────────────┐       ┌─────────────────────────┐
│ script calls          │──────►│ timer starts / waits    │
│ setTimeout(callback)  │       └────────────┬────────────┘
└──────────┬───────────┘                    │ delay elapsed
           │ returns                        ▼
           ▼                       ┌───────────────────────┐
   script continues                │ task queue / task      │
                                   │ becomes eligible       │
                                   └───────────┬───────────┘
                                               │ event loop, when able
                                               ▼
                                   callback executes on the
                                   JavaScript call stack
```

**Precise idea:** the callback does not execute in parallel on the JavaScript call stack while the original script is still running. The host schedules it, then JavaScript executes it when the event loop allows.

---

## 5. Task queue (often called callback queue or macrotask queue)

A **task queue** holds tasks that are ready to run. Timer callbacks such as those scheduled by `setTimeout()` are commonly discussed as task-queue callbacks in the browser model. Other sources can schedule tasks too, such as user events.

A beginner-friendly sequence is:

```text
Call stack is busy
      │
      ├── timer becomes ready ──► task waits in task queue
      │
      ▼
Call stack becomes empty
      │
      ▼
Event loop can select a task
      │
      ▼
Task's callback runs on the call stack
```

A callback isn't automatically queued just because it is called a callback. For example, in `cb(content)`, if that line runs inside a timer callback, `cb` is invoked immediately as part of that currently running task. It does not need a separate queue entry of its own.

---

## 6. Promise jobs and the microtask queue

Promise handlers registered with `.then()`, `.catch()`, and `.finally()` run as **microtasks** (Promise reaction jobs), not as timer tasks.

A useful simplified model:

- **Call stack:** JavaScript currently executing.
- **Task queue:** for example, a ready `setTimeout()` callback.
- **Microtask queue:** Promise reaction handlers and other microtasks (such as `queueMicrotask()`).
- **Host APIs:** facilities such as timers that schedule future work.

In browsers, after the current JavaScript stack finishes, the host performs a microtask checkpoint: queued microtasks are drained before the event loop moves on to another task. Newly queued microtasks are also normally processed during that checkpoint until the queue is empty.

```text
                    ┌───────────────────────┐
                    │ JavaScript call stack │
                    └───────────┬───────────┘
                                │ becomes empty
                                ▼
                    ┌───────────────────────┐
                    │ Drain microtask queue │◄──── Promise .then/.catch/.finally
                    └───────────┬───────────┘
                                │ queue becomes empty
                                ▼
                    ┌───────────────────────┐
                    │ Event loop selects a  │◄──── ready tasks, e.g. timer callback
                    │ task when appropriate │
                    └───────────┬───────────┘
                                │ task callback executes
                                ▼
                    ┌───────────────────────┐
                    │ Drain microtasks after│
                    │ that task's JS work   │
                    └───────────┬───────────┘
                                │ repeat
                                └───────────────►
```

This is a learning diagram, not every detail of the browser event-loop specification. The key ordering rule for this lesson is: **after the current JavaScript work ends, Promise microtasks run before the event loop takes the next timer task.**

### Mini dry run: Promise microtask vs timer task

```javascript
console.log("A");

setTimeout(function () {
    console.log("B - timer task");
}, 0);

Promise.resolve().then(function () {
    console.log("C - Promise microtask");
});

console.log("D");
```

Output in the usual browser script environment:

```text
A
D
C - Promise microtask
B - timer task
```

Dry run:

1. Print `A`.
2. Schedule timer callback as a task; do not run it immediately.
3. Register a Promise handler; its reaction will run as a microtask.
4. Print `D`.
5. The current script finishes and the stack becomes empty.
6. Run the Promise microtask, printing `C - Promise microtask`.
7. When the timer task is eligible and the event loop selects it, print `B - timer task`.

A `0` ms timer does not mean “run now.” It means “schedule with no requested delay, subject to host scheduling rules.”

---

## 7. How the call stack, host timers, task queue, and microtask queue relate

Keep this complete picture in mind:

```text
                         YOUR JAVASCRIPT
┌────────────────────────────────────────────────────────────────┐
│ 1. Main script runs on the CALL STACK                          │
│                                                                │
│ console.log(...)                                               │
│ setTimeout(timerCallback, 1000) ────────────────┐               │
│ Promise.resolve(value).then(onFulfilled) ───┐   │               │
│ console.log(...)                            │   │               │
└─────────────────────────────────────────────│───│───────────────┘
                                              │   │
                           Promise reaction  │   │ timer facility
                           becomes microtask │   │ waits for delay
                                              ▼   ▼
                                      ┌──────────┐ ┌─────────────┐
                                      │MICROTASK │ │ HOST TIMER  │
                                      │  QUEUE   │ │ / WEB API   │
                                      └────┬─────┘ └──────┬──────┘
                                           │              │ becomes ready
                                           │              ▼
                                           │        ┌─────────────┐
                                           │        │ TASK QUEUE  │
                                           │        └──────┬──────┘
                                           └──────┬────────┘
                                                  ▼
                                      ┌────────────────────────┐
                                      │ EVENT LOOP / HOST      │
                                      │ - stack must be ready  │
                                      │ - drain microtasks at  │
                                      │   the required checkpoint│
                                      │ - then process tasks   │
                                      └────────────┬───────────┘
                                                   ▼
                                      CALLBACKS EXECUTE ON STACK
```

Promise executor functions are different from `.then()` callbacks: **the Promise executor runs immediately during `new Promise(...)`**, synchronously on the call stack. The `.then()` handler is the part scheduled as a microtask when its Promise reaction is ready.

---

# Part B — Callbacks

## 8. What is a callback?

A **callback is a function passed as an argument to another function so that the receiving function can invoke it**.

```javascript
function greet(name, callback) {
    console.log("Hello", name);
    callback();
}

greet("Om", function () {
    console.log("Callback executed");
});
```

Output:

```text
Hello Om
Callback executed
```

- The caller passes a function as the second argument.
- Inside `greet`, the parameter `callback` refers to that function.
- `callback()` calls it.

A callback can be called synchronously or later. In your download simulation, it is called later from inside a timer callback.

### Function vs function call

```javascript
function show() {
    console.log("Hello");
}

show;   // refers to the function; does not invoke it
show(); // invokes the function
```

Similarly, passing `show` passes the function; passing `show()` calls it immediately and passes its return value instead.

---

## 9. Correct callback implementation of your workflow

```javascript
function download(url, cb) {
    console.log("Starting download from", url);

    setTimeout(function down() {
        const content = "JsDryRun";
        console.log("Download completed");
        cb(content);
    }, 1000);
}

function writeFile(data, cb) {
    console.log("Started writing file with", data);

    setTimeout(function write() {
        console.log("Completed writing the data in a file");
        const fileName = "file.txt";
        cb(fileName);
    }, 1000);
}

function uploadFile(url, file, cb) {
    console.log("Started uploading", file, "to", url);

    setTimeout(function upload() {
        console.log("Uploading completed");
        const response = "SUCCESS";
        cb(response);
    }, 1000);
}

download("www.comsy.com", function (content) {
    console.log("Now processing downloaded data");

    writeFile(content, function (fileName) {
        console.log("File written with name", fileName);

        uploadFile("www.nexus.com", fileName, function (response) {
            console.log("We have uploaded with", response);
        });
    });
});
```

### Callback function signatures

```javascript
download(url, cb)
writeFile(data, cb)
uploadFile(url, file, cb)
```

`uploadFile` expects **three arguments in this order**:

1. `url`
2. `file`
3. `cb`

Correct:

```javascript
uploadFile("www.nexus.com", fileName, function (response) {
    console.log(response);
});
```

Incorrect:

```javascript
uploadFile("www.nexus.com", function (response) {
    console.log(response);
});
```

In the incorrect call, JavaScript assigns the callback function to `file`; `cb` is `undefined`. When the timer later executes `cb(response)`, it throws `TypeError: cb is not a function`.

---

## 10. Callback dry run: call stack and values

Use these simplified timings: 1 second for each operation. The real values don't matter; the dependencies do.

### Phase 1 — run the main script

The main script calls:

```javascript
download("www.comsy.com", function (content) {
    // write, then upload
});
```

Inside `download`:

1. `url` receives `"www.comsy.com"`.
2. The starting message prints immediately on the call stack.
3. `setTimeout` asks the host timer facility to schedule `down` for later.
4. `download` reaches its end and returns `undefined`.
5. The main script can finish. The browser console may display `undefined` as the immediate return value of the expression.

The timer callback does not interrupt the main script. Later, the host makes the timer callback eligible to run as a task.

### Phase 2 — the timer callback executes

The callback runs on the stack:

```javascript
function down() {
    const content = "JsDryRun";
    console.log("Download completed");
    cb(content);
}
```

When it calls `cb(content)`, it invokes the outer callback with `"JsDryRun"`. That callback then runs synchronously inside the current call stack and calls `writeFile(content, ...)`.

### Phase 3 — writing is scheduled

Inside `writeFile`:

1. `data` receives `"JsDryRun"`.
2. The writing-started message prints immediately.
3. `setTimeout` schedules the writing callback for later.
4. `writeFile` returns `undefined` to its caller.
5. The download timer callback and its nested callback finish; later the writing timer runs as a separate task.

When the writing callback runs, it creates `fileName = "file.txt"` and calls `cb(fileName)`. This synchronously runs the callback that then calls `uploadFile`.

### Phase 4 — upload is scheduled

The call is:

```javascript
uploadFile("www.nexus.com", fileName, function (response) {
    console.log("We have uploaded with", response);
});
```

The arguments map by position:

```text
url  = "www.nexus.com"
file = "file.txt"
cb   = callback function
```

When the upload timer callback runs, it calls `cb("SUCCESS")`. The last callback receives `response = "SUCCESS"`.

### Value flow table

| Callback is called with | The next callback's parameter | Value |
|---|---|---|
| `cb(content)` in `download` | `content` | `"JsDryRun"` |
| `cb(fileName)` in `writeFile` | `fileName` | `"file.txt"` |
| `cb(response)` in `uploadFile` | `response` | `"SUCCESS"` |

### Expected log sequence

```text
Starting download from www.comsy.com
Download completed
Now processing downloaded data
Started writing file with JsDryRun
Completed writing the data in a file
File written with name file.txt
Started uploading file.txt to www.nexus.com
Uploading completed
We have uploaded with SUCCESS
```

The exact timer durations can vary. This order follows from starting each next operation only after the previous operation calls its callback.

---

## 11. Why did `name` print the whole function?

You wrote something like:

```javascript
download("www.comsy.com", function name(content) {
    writeFile(content, function process(fileName) {
        console.log("File written with name", name);
    });
});
```

Here, `name` is the name of the outer callback function, not the filename. Logging `name` asks the console to show that function.

Use:

```javascript
console.log("File written with name", fileName);
```

And for the upload result:

```javascript
function (response) {
    console.log("We have uploaded with", response);
}
```

**Rule:** A function's name identifies the function; a callback parameter holds the value passed into that invocation.

---

## 12. Why did the callback version display `undefined`?

Your callback-based `download` did not return anything:

```javascript
function download(url, cb) {
    setTimeout(function () {
        cb("JsDryRun");
    }, 1000);
}
```

When you call `download(...)`, it schedules a timer and reaches the end of the function. Since there is no `return` statement, the immediate return value is `undefined`.

The callback receives its value later. These are two different mechanisms:

```text
Function's immediate return value: undefined
Value passed later to the callback: "JsDryRun"
```

That is expected in this callback design.

---

## 13. Inversion of control (IoC)

**Inversion of control means giving another function, library, or system control over part of when your code runs.**

When you pass a callback to another API, you hand it a function and rely on that API to call it according to its contract:

```javascript
someLibrary.doWork(function (result) {
    // This code runs when the library calls the callback.
});
```

You do not directly control from this call site exactly when the library calls the function. A poorly designed API might fail to call it, call it more than once, or call it with an unexpected result. Well-designed callback APIs specify the contract and avoid these problems.

Inversion of control is **not the same thing as callback hell**:

- **IoC** is about handing control over callback invocation to another piece of code.
- **Callback hell** is the readability and maintenance problem caused by deeply nested callbacks.

### Why can Promises help?

A Promise represents one eventual result or failure. The caller attaches handlers to the Promise rather than passing the next callback directly into each operation. Promise settlement is one-way, and a Promise can settle only once. This gives code a more consistent contract for chaining and error propagation.

Promises do not eliminate all forms of inversion of control: you still rely on the Promise-producing API to behave correctly. But Promises make composition and error propagation more standardized.

---

## 14. Callback hell (pyramid of doom)

A sequence of dependent callbacks can nest deeply:

```javascript
download(url, function (content) {
    writeFile(content, function (fileName) {
        uploadFile(server, fileName, function (response) {
            notifyUser(response, function (notificationResult) {
                // More nested work...
            });
        });
    });
});
```

Why it becomes hard to maintain:

- The code grows to the right.
- It can be harder to see the full sequence.
- Error handling may be repeated at several levels.
- The correct data must be passed through each nesting level.
- Refactoring and testing can become more difficult.

Callbacks themselves are not bad. One simple event listener or one short callback is perfectly normal. The problem is often **many dependent asynchronous operations nested inside each other**.

### Error-first callback convention

Many Node.js APIs use a callback convention like `callback(error, result)`:

```javascript
function exampleOperation(callback) {
    // On success:
    callback(null, "data");
}

exampleOperation(function (error, result) {
    if (error) {
        console.error(error);
        return;
    }

    console.log(result);
});
```

This is a convention, not a rule for every callback.

---

# Part C — Promises

## 15. What is a Promise?

A **Promise is a JavaScript object representing the eventual completion (or failure) of an operation and its resulting value**.

A Promise has three states:

```text
                 resolve(value)
       ┌────────────────────────────────┐
       │                                ▼
   PENDING ─────────────────────────► FULFILLED
       │                              (success)
       │
       │ reject(reason)
       ▼
   REJECTED
   (failure)
```

More precisely:

- **Pending:** neither fulfilled nor rejected yet.
- **Fulfilled:** the operation succeeded, and the Promise has a fulfillment value.
- **Rejected:** the operation failed, and the Promise has a rejection reason.

Fulfilled and rejected are both **settled** states. A settled Promise does not change to another state later. Calling `resolve()` or `reject()` again after settlement does not change the original result. If `resolve()` is passed another Promise or thenable, the Promise adopts its eventual state rather than necessarily fulfilling immediately with that object.

### Minimal example

```javascript
const p = new Promise(function (resolve, reject) {
    resolve("SUCCESS");
});

p.then(function (value) {
    console.log(value);
});
```

Output:

```text
SUCCESS
```

Important: the Promise executor function runs **immediately and synchronously** when `new Promise(...)` is evaluated. The `.then()` handler runs later as a microtask after its reaction is ready and JavaScript reaches the appropriate microtask checkpoint.

---

## 16. `resolve` and `reject`: who supplies them?

```javascript
new Promise(function executor(resolve, reject) {
    // The Promise constructor calls this function and passes these functions.
});
```

The Promise constructor supplies the `resolve` and `reject` functions to the executor.

The parameter names are up to you:

```javascript
new Promise(function exec(res, rej) {
    res("SUCCESS");
});
```

This is valid. `exec`, `res`, and `rej` are ordinary names. `resolve` and `reject` are recommended because their purpose is clearer.

### Why the earlier `setTimeout(function exec(res, rej) {...})` failed

```javascript
setTimeout(function exec(res, rej) {
    res("SUCCESS");
}, 1000);
```

Here, `exec` is the timer callback. `setTimeout()` does not provide Promise `resolve` and `reject` arguments to that callback. `res` will be `undefined`, and calling `res(...)` throws `TypeError: res is not a function`.

Correct structure:

```javascript
return new Promise(function exec(resolve, reject) {
    setTimeout(function timerCallback() {
        resolve("SUCCESS");
    }, 1000);
});
```

The timer callback closes over `resolve` from the outer executor. This is a **closure**: an inner function can access variables from its surrounding lexical scope.

---

## 17. What does `return new Promise(...)` do?

The `return` makes the function return the Promise object to its caller:

```javascript
function uploadFile(url, file) {
    return new Promise(function (resolve, reject) {
        setTimeout(function () {
            resolve("SUCCESS");
        }, 1000);
    });
}
```

Now the caller can attach `.then()` and `.catch()` handlers:

```javascript
uploadFile("www.nexus.com", "file.txt")
    .then(function (response) {
        console.log(response);
    });
```

If `uploadFile()` doesn't return a Promise, the caller cannot chain from its asynchronous result in this way.

---

## 18. Correct Promise version of the full workflow

```javascript
function download(url) {
    return new Promise(function (resolve, reject) {
        console.log("Starting download from", url);

        setTimeout(function () {
            const content = "JsDryRun";
            console.log("Download completed");
            resolve(content);
        }, 1000);
    });
}

function writeFile(data) {
    return new Promise(function (resolve, reject) {
        console.log("Started writing file with", data);

        setTimeout(function () {
            console.log("Completed writing the data in a file");
            const fileName = "file.txt";
            resolve(fileName);
        }, 1000);
    });
}

function uploadFile(url, file) {
    return new Promise(function (resolve, reject) {
        console.log("Started uploading", file, "to", url);

        setTimeout(function () {
            console.log("Uploading completed");
            const response = "SUCCESS";
            resolve(response);
        }, 1000);
    });
}

download("www.comsy.com")
    .then(function (content) {
        console.log("Now processing downloaded data");
        return writeFile(content);
    })
    .then(function (fileName) {
        console.log("File written with name", fileName);
        return uploadFile("www.nexus.com", fileName);
    })
    .then(function (response) {
        console.log("We have uploaded with", response);
    })
    .catch(function (error) {
        console.error("Workflow failed:", error);
    });
```

The timer durations are shortened for study. Each operation is still a simulation.

---

## 19. Promise chaining: what does each `.then()` receive?

Look at this chain:

```javascript
download("www.comsy.com")
    .then(function (content) {
        return writeFile(content);
    })
    .then(function (fileName) {
        return uploadFile("www.nexus.com", fileName);
    })
    .then(function (response) {
        console.log(response);
    });
```

### Rule 1 — a fulfilled value is passed to the next handler

`download()` resolves with `"JsDryRun"`, so the first handler receives:

```javascript
content === "JsDryRun"
```

### Rule 2 — return a value or Promise from the handler

This line:

```javascript
return writeFile(content);
```

returns a Promise from the current `.then()` handler. The Promise returned by `.then()` adopts the state of that returned Promise, so the next handler waits for it and receives its fulfillment value, `"file.txt"`.

Then:

```javascript
return uploadFile("www.nexus.com", fileName);
```

returns another Promise. The next handler waits for it and receives `"SUCCESS"`.

### Rule 3 — each `.then()` returns a new Promise

Conceptually:

```text
download() returns Promise A
        │
        ▼
A.then(handler 1) returns Promise B
        │ handler 1 returns writeFile()'s Promise
        ▼
Promise B adopts writeFile Promise's result: "file.txt"
        │
        ▼
B.then(handler 2) returns Promise C
        │ handler 2 returns uploadFile()'s Promise
        ▼
Promise C adopts upload Promise's result: "SUCCESS"
        │
        ▼
C.then(handler 3) returns the next Promise
```

You don't write `.writeFile` or `.uploadFile` on a Promise. You link the steps by **returning the next Promise from a `.then()` handler**.

### What if you forget `return`?

Wrong:

```javascript
.then(function (content) {
    writeFile(content); // Promise is started but not returned from this handler
})
.then(function (fileName) {
    console.log(fileName); // normally undefined here
});
```

The first handler returns `undefined` because it has no explicit return. The next `.then()` does not wait for the `writeFile()` Promise, and its parameter receives `undefined`. The writing operation still runs, but it is disconnected from this chain.

Correct:

```javascript
.then(function (content) {
    return writeFile(content);
})
.then(function (fileName) {
    console.log(fileName); // "file.txt"
});
```

**Memory rule:** If the next step depends on an asynchronous operation, return that operation's Promise from the current `.then()` handler.

---

## 20. Promise dry run with the call stack and queues

This section explains the important difference between your callback version and Promise version.

In the Promise version, the top-level call begins:

```javascript
download("www.comsy.com")
    .then(function (content) {
        console.log("Now processing downloaded data");
        return writeFile(content);
    })
    .then(function (fileName) {
        console.log("File written with name", fileName);
        return uploadFile("www.nexus.com", fileName);
    })
    .then(function (response) {
        console.log("We have uploaded with", response);
    });
```

### Stage 1 — call `download()`

1. `download("www.comsy.com")` is called on the call stack.
2. `new Promise(executor)` runs the Promise executor immediately, on that same stack.
3. The starting message prints immediately.
4. The executor calls `setTimeout(...)`, which schedules the timer callback with the host.
5. The executor ends. The Promise remains pending.
6. `download()` returns the Promise.
7. `.then(...)` registers a handler on that Promise.
8. The main script finishes this synchronous work.

At this point, the timer may still be waiting. Nothing has been downloaded yet in the simulation.

### Stage 2 — the download timer task runs

When the timer becomes eligible, the host schedules its callback as a task. When it runs:

```javascript
const content = "JsDryRun";
console.log("Download completed");
resolve(content);
```

The timer callback is running on the call stack. `resolve(content)` fulfills the download Promise. The registered `.then()` reaction is scheduled as a **microtask**; the `.then()` handler does not interrupt the current timer callback in the middle of its execution.

When the timer callback finishes and the stack becomes empty, the Promise microtask runs:

```javascript
function (content) {
    console.log("Now processing downloaded data");
    return writeFile(content);
}
```

It receives `content = "JsDryRun"`, prints its message, and calls `writeFile(content)`. That function immediately creates and returns its Promise; its executor runs synchronously and schedules the writing timer. The handler returns the writing Promise, so the chain waits for its result.

### Stage 3 — the write timer task runs

The writing timer callback later runs as a task:

```javascript
console.log("Completed writing the data in a file");
resolve("file.txt");
```

Resolving the write Promise queues the next `.then()` reaction as a microtask. After the timer callback ends, that microtask runs, receives `fileName = "file.txt"`, prints the filename, and starts `uploadFile(...)`. The upload Promise executor runs immediately and schedules its timer.

### Stage 4 — the upload timer task runs

Later, the upload timer callback runs and calls `resolve("SUCCESS")`. That queues the final `.then()` handler as a microtask. After the upload callback finishes, the final handler runs and prints:

```text
We have uploaded with SUCCESS
```

### Promise timeline diagram

```text
MAIN SCRIPT / CALL STACK
  │
  ├─ call download(url)
  │    ├─ Promise executor runs NOW
  │    └─ timer is scheduled with host
  │
  ├─ attach .then handlers
  └─ current script finishes
       │
       ▼
HOST TIMER waits ──► download timer becomes a TASK
                         │
                         ▼
                   timer callback runs on stack
                   resolve("JsDryRun")
                         │
                         ▼
                   Promise reaction becomes MICROTASK
                         │ current timer callback ends
                         ▼
                   microtask handler runs
                   calls writeFile(content)
                         │
                         ▼
                   write Promise executor runs NOW
                   schedules write timer
                         │
                         ▼
                   write timer TASK runs later
                   resolve("file.txt")
                         │
                         ▼
                   next .then MICROTASK runs
                   calls uploadFile(url, fileName)
                         │
                         ▼
                   upload Promise executor runs NOW
                   schedules upload timer
                         │
                         ▼
                   upload timer TASK runs later
                   resolve("SUCCESS")
                         │
                         ▼
                   final .then MICROTASK runs
                   logs "SUCCESS"
```

### Crucial distinction

- **Promise executor:** synchronous; runs immediately inside `new Promise(...)`.
- **Timer callback:** scheduled by a host timer; later runs as a task.
- **`.then()` callback:** runs as a microtask once its reaction can run.
- **`resolve(value)`:** settles or resolves the Promise; it does not synchronously run the `.then()` handler in the middle of the current stack.

---

## 21. Why did `resolve(file)` appear before `console.log("Download completed")` but the `.then()` message appeared after it?

Consider this exact order inside a timer:

```javascript
resolve(file);
console.log("Download completed");
```

Even though `resolve(file)` appears first, the output is:

```text
Download completed
Now processing downloaded data
```

Why?

1. The timer callback starts executing as a task.
2. `resolve(file)` fulfills the Promise and schedules the registered `.then()` reaction as a microtask.
3. JavaScript continues the current timer callback; it prints `Download completed`.
4. The timer callback returns, and the current stack becomes empty.
5. The event loop's microtask checkpoint runs the `.then()` handler, which prints `Now processing downloaded data`.

So **resolving a Promise and executing its `.then()` callback are not the same moment**.

---

## 22. Promise rejection and `.catch()`

Use `resolve(value)` for a successful outcome, and `reject(reason)` for a failed outcome.

```javascript
function download(url) {
    return new Promise(function (resolve, reject) {
        setTimeout(function () {
            const failed = true;

            if (failed) {
                reject(new Error("Download failed"));
                return;
            }

            resolve("JsDryRun");
        }, 500);
    });
}

download("www.comsy.com")
    .then(function (content) {
        console.log("Downloaded", content);
        return writeFile(content);
    })
    .then(function (fileName) {
        return uploadFile("www.nexus.com", fileName);
    })
    .then(function (response) {
        console.log(response);
    })
    .catch(function (error) {
        console.error("Workflow failed:", error.message);
    });
```

If the download Promise rejects, the success handler waiting for downloaded content is skipped, and the rejection travels down the chain to the nearest rejection handler (`.catch()` here). In this example, the write and upload steps won't start.

### Important error propagation rules

A Promise chain can become rejected if:

- the Promise being awaited/reused rejects;
- a `.then()` handler throws an error;
- a handler returns a rejected Promise.

A `.catch(handler)` is roughly equivalent to `.then(undefined, handler)`. If a `.catch()` handler handles the error and returns an ordinary value, the chain after it can become fulfilled with that value. If it throws or returns a rejected Promise, the chain remains rejected.

### `reject()` vs throwing inside the executor

Both of these reject the Promise:

```javascript
return new Promise(function (resolve, reject) {
    reject(new Error("Something failed"));
});
```

```javascript
return new Promise(function (resolve, reject) {
    throw new Error("Something failed"); // executor throws → Promise rejects
});
```

For callback-based APIs, errors must be handled by their callback contract. For Promises, rejections can propagate along a chain to `.catch()`.

---

## 23. `then`, `catch`, and `finally`

### `.then(onFulfilled, onRejected)`

```javascript
promise.then(
    function (value) {
        // success
    },
    function (error) {
        // failure for this Promise
    }
);
```

Usually, beginners use `.then()` for the success path and a final `.catch()` for errors.

### `.catch(onRejected)`

```javascript
promise.catch(function (error) {
    console.error(error);
});
```

Handles a rejection that reaches this point in the chain.

### `.finally(onFinally)`

```javascript
promise.finally(function () {
    console.log("Cleanup / finish step");
});
```

`finally` runs when the Promise settles, whether fulfilled or rejected. It is useful for cleanup. It normally preserves the previous result/reason unless the `finally` handler itself throws or returns a rejected Promise.

---

## 24. Common errors from your practice and what they mean

### Error 1 — `TypeError: cb is not a function`

Likely cause: passed the wrong number/order of arguments:

```javascript
uploadFile("www.nexus.com", function (response) {});
```

But the signature is:

```javascript
uploadFile(url, file, cb)
```

Correct:

```javascript
uploadFile("www.nexus.com", fileName, function (response) {});
```

### Error 2 — `TypeError: res is not a function`

Likely cause: declared `res` as a parameter of a `setTimeout` callback and expected the timer to supply Promise functions.

Incorrect:

```javascript
setTimeout(function (res) {
    res("SUCCESS");
}, 1000);
```

Correct:

```javascript
return new Promise(function (resolve, reject) {
    setTimeout(function () {
        resolve("SUCCESS");
    }, 1000);
});
```

### Error 3 — the console prints a function instead of a filename/result

Likely cause: logged `name`, the function identifier, rather than the parameter carrying the value.

Incorrect:

```javascript
console.log(name);
```

Correct in the file-writing handler:

```javascript
console.log(fileName);
```

Correct in the final upload handler:

```javascript
console.log(response);
```

### Error 4 — `undefined` appears

Possible reasons:

- a function has no explicit return, so its result is `undefined`;
- a `.then()` handler doesn't return a value or Promise;
- a parameter doesn't receive a corresponding argument;
- a callback-based operation provides its result to a callback rather than as the outer function's return value.

### Error 5 — `Promise {<pending>}` appears in the console

That is the Promise object printed while its asynchronous outcome is not settled yet. It is not automatically an error. Later, the Promise may fulfill or reject. The console may display live or updated details differently depending on the environment.

### Error 6 — `Identifier 'download' has already been declared`

In a browser DevTools console, rerunning a top-level `let` or `const` declaration can trigger this error because the console may keep the same lexical environment between submissions.

For example:

```javascript
function download(url) {}
let download = download("www.comsy.com");
```

This also uses the same identifier for a function and a variable, which makes the code confusing. Better names:

```javascript
function downloadFile(url) {}
const downloadPromise = downloadFile("www.comsy.com");
```

For repeated experiments, run the complete code as a fresh script, reload the page, or use fresh variable names. Do not rename everything at random—understand which identifier already exists.

---

# Part D — Callbacks vs Promises

## 25. Comparison table

| Topic | Callbacks | Promises |
|---|---|---|
| How you provide the next step | Pass a function argument | Attach `.then()` / `.catch()` handlers |
| How result is communicated | Call `cb(value)` | Call `resolve(value)` and receive it in `.then()` |
| Represent eventual result as an object | Not inherently | Yes, the Promise object represents eventual settlement |
| Error handling | Often error-first callback convention or custom design | Rejection propagation through `.catch()` / rejection handler |
| Chaining many steps | Can become deeply nested | Flat chains with `.then()` and returned Promises |
| Invocation contract | Caller relies on the API to call the callback correctly | Promise settles at most once and reactions follow standardized Promise semantics |
| Can it be misused? | Yes | Yes; forgetting `return`, ignoring rejection, or mishandling errors is common |
| Are both used in JavaScript? | Yes | Yes; many APIs still use callbacks, and many others return Promises |

## 26. Callback advantages

- Simple for one small operation or a short event handler.
- Flexible: pass behaviour to another function.
- Common for event listeners and many existing APIs.
- Direct way to receive data once a task completes.

## 27. Callback disadvantages

- Nested dependent callbacks can create callback hell.
- Error-handling patterns vary from API to API.
- The caller relies on the API to follow the callback contract.
- It may be harder to combine independent tasks, centralize error handling, or return a single composable representation of the eventual result.

## 28. Promise advantages

- Represents eventual success or failure with an object.
- `.then()` chains dependent steps in a readable sequence.
- A Promise settles only once.
- Rejections propagate through a chain until handled.
- Returning a Promise from a `.then()` handler composes asynchronous operations.
- Works with `async`/`await`, which can make sequential flows easier to read.

## 29. Promise disadvantages / pitfalls

- The syntax may feel unfamiliar at first.
- Forgetting `return` inside `.then()` can break the chain's dependency.
- Rejections can be missed if there is no appropriate error handler.
- A Promise does not make CPU-heavy synchronous work non-blocking by itself.
- Creating a Promise does not automatically start every kind of operation; the executor runs immediately, but whether work begins depends on the code inside it.
- Promises do not automatically cancel the underlying operation.
- They don't turn simulated work into real network, disk, or upload operations.

## 30. Are Promises free from inversion of control?

Not entirely. Promises standardize how eventual success/failure is represented and how handlers are scheduled, and this makes composition safer and easier. But you still rely on the API that creates/returns the Promise to do what it promises to do. If an API never settles its Promise, a chain waiting on it remains pending.

The balanced statement is: **Promises reduce several callback-composition problems and provide standard settlement/error propagation, but they do not eliminate every control-flow or API-contract problem.**

---

# Part E — `async` / `await` preview

## 31. The same Promise chain with `async` / `await`

`async`/`await` is syntax built on Promises. It does not make the simulated timers execute faster, nor does it block the JavaScript thread while awaiting a Promise.

```javascript
async function runWorkflow() {
    try {
        const content = await download("www.comsy.com");
        console.log("Now processing downloaded data");

        const fileName = await writeFile(content);
        console.log("File written with name", fileName);

        const response = await uploadFile("www.nexus.com", fileName);
        console.log("We have uploaded with", response);
    } catch (error) {
        console.error("Workflow failed:", error);
    }
}

runWorkflow();
```

Read it like this:

1. Start download; wait for its Promise to fulfill.
2. Store its result in `content`.
3. Start writing; wait for its Promise to fulfill.
4. Store its result in `fileName`.
5. Start upload; wait for its Promise to fulfill.
6. Store its result in `response`.
7. Catch a rejection/exception in `catch`.

The awaited operations must return Promises (or thenables) for this sequential workflow. If you simply remove `return` from `writeFile()` or `uploadFile()`, the chain and the `await` logic will not get the expected asynchronous result.

---

# Part F — Diagrams for revision

## 32. Callback workflow diagram

```text
CALL download(url, callback)
        │
        ├─ log start (now)
        └─ schedule timer
                │ delay elapses; timer callback runs as a task
                ▼
        callback(content)
                │ content = "JsDryRun"
                ▼
        CALL writeFile(content, callback)
                │
                └─ schedule timer
                        │ delay elapses; timer callback runs as a task
                        ▼
                callback(fileName)
                        │ fileName = "file.txt"
                        ▼
                CALL uploadFile(url, fileName, callback)
                        │
                        └─ schedule timer
                                │ delay elapses
                                ▼
                        callback(response)
                                │ response = "SUCCESS"
                                ▼
                            DONE
```

Callbacks are invoked directly by the code that calls `cb(...)`. If the call happens inside a timer callback, that nested callback runs synchronously on the current stack until it returns or schedules more work.

## 33. Promise workflow diagram

```text
download(url) → Promise D
        │ D fulfills with content
        ▼
.then(content => return writeFile(content))
        │ returned Promise W is adopted/awaited by the chain
        ▼
.then(fileName => return uploadFile(url, fileName))
        │ returned Promise U is adopted/awaited by the chain
        ▼
.then(response => log response)
        │
        ▼
.catch(error => handle any rejection that reaches here)
```

## 34. Stack / task / microtask dry run card

```text
1. Synchronous JavaScript runs on the CALL STACK.
2. Promise executor runs immediately on that stack.
3. setTimeout asks the HOST TIMER to schedule a callback.
4. Timer callback becomes eligible as a TASK after the delay.
5. resolve(value) settles a Promise; ready .then handlers are queued as MICROTASKS.
6. The current task's stack work finishes.
7. The event loop performs the microtask checkpoint; Promise handlers execute.
8. If a handler returns another Promise, the chain waits for/adopts its settlement.
9. A rejection travels to a later rejection handler / .catch() if not handled earlier.
```

## 35. Promise state + chain diagram

```text
new Promise(executor)
        │ executor runs now
        ▼
     PENDING
      /   \
resolve   reject
   │        │
   ▼        ▼
FULFILLED REJECTED
   │        │
   ├─ .then(success)    ├─ .catch(error) / .then(undefined, error)
   │        │
   └────────┴─ handlers run as microtasks when their reactions are ready
```

Remember: the arrows are a conceptual map. The exact Promise-resolution procedure includes adoption of Promises/thenables, and handlers can transform the state of the new Promise returned by `.then()`.

---

# Part G — Interview and revision sheet

## 36. Ten key definitions

1. **Callback:** a function passed to another function and invoked by it.
2. **Asynchronous operation:** work whose completion is handled later instead of blocking the current JavaScript execution while waiting.
3. **Call stack:** tracks currently executing JavaScript function calls.
4. **Host environment / Web APIs:** browser- or runtime-provided facilities such as timers and networking.
5. **Task queue:** holds eligible tasks such as timer callbacks waiting for execution.
6. **Microtask queue:** holds Promise reaction jobs and other microtasks.
7. **Promise:** an object representing an eventual fulfillment value or rejection reason.
8. **Fulfilled:** Promise completed successfully with a value.
9. **Rejected:** Promise completed unsuccessfully with a rejection reason.
10. **Callback hell:** difficult-to-maintain deep nesting of dependent callbacks.

## 37. Seven rules worth memorizing

1. **A callback is a function; `cb(value)` calls it and passes the value.**
2. **Arguments map to parameters by position.** Check the function signature before calling it.
3. **A function with no `return` returns `undefined` by default.**
4. **The Promise executor runs immediately; `.then()` handlers run as microtasks.**
5. **`setTimeout` does not pass Promise `resolve`/`reject` functions to its callback.**
6. **Return the next Promise from a `.then()` handler when the chain depends on it.**
7. **Use `response`, `fileName`, or `content` for the data you want—not the name of a callback function.**

## 38. Interview-style explanations

### What is callback hell?

“Callback hell is deeply nested callback-based asynchronous code. It can be hard to read, maintain, pass results between steps, and handle errors consistently. Promises allow dependent operations to be composed with a flatter `.then()` chain.”

### What is inversion of control with callbacks?

“When I pass a callback to another function or library, I rely on that API to decide when and how often the callback will be called. That's a form of inversion of control. A well-designed API documents the contract; Promises standardize the eventual result and rejection path.”

### What does the event loop do?

“JavaScript executes current work on the call stack. The host schedules asynchronous callbacks, such as timer callbacks, as tasks. Promise handlers run as microtasks. When the stack is clear, the host drains microtasks at the appropriate checkpoint before moving on to another task.”

### Why do Promise handlers run after the current synchronous code?

“Promise reactions are scheduled as microtasks rather than being called inline by `resolve()`. The current JavaScript work finishes first; then the microtask checkpoint runs the handler.”

### Why must I return a Promise inside `.then()`?

“Returning the Promise makes the Promise created by `.then()` adopt that operation's eventual outcome, so the next handler waits and receives its resolved value, or the rejection propagates down the chain.”

---

# Part H — Practice questions

Try these before looking at the answers.

### Q1. What value reaches the first `.then()` after `download()` fulfills?

```javascript
function download() {
    return Promise.resolve("JsDryRun");
}

download().then(function (content) {
    console.log(content);
});
```

### Q2. What is the output order?

```javascript
console.log("A");
setTimeout(() => console.log("B"), 0);
Promise.resolve().then(() => console.log("C"));
console.log("D");
```

### Q3. Why does this next handler receive `undefined`?

```javascript
Promise.resolve("content")
    .then(function (content) {
        writeFile(content); // no return
    })
    .then(function (fileName) {
        console.log(fileName);
    });
```

### Q4. Why is `res` undefined here?

```javascript
setTimeout(function (res) {
    res("SUCCESS");
}, 1000);
```

### Q5. What is wrong with this call if the signature is `uploadFile(url, file, cb)`?

```javascript
uploadFile("www.nexus.com", function (response) {
    console.log(response);
});
```

### Q6. Does `resolve("SUCCESS")` synchronously execute a registered `.then()` handler in the middle of the current timer callback?

### Q7. Is callback hell the same concept as inversion of control?

### Q8. Does `new Promise(function (resolve, reject) { ... })` wait to execute the executor until after the timer?

### Q9. What is the difference between `fileName` and `name` in this code?

```javascript
download(url, function name(content) {
    writeFile(content, function (fileName) {
        console.log(name);
    });
});
```

### Q10. What does the final `.catch()` handle in a Promise chain?

---

## Answer key

1. `"JsDryRun"`.
2. `A`, `D`, `C`, `B` in the usual browser script environment. The Promise handler is a microtask; the timer callback is a task.
3. The handler has no `return`, so it returns `undefined`. The next `.then()` is not connected to the result of `writeFile()`.
4. `setTimeout` doesn't supply a `res` argument. Promise `resolve` must be captured from an enclosing Promise executor.
5. It omits the `file` argument, so the callback is assigned to `file` and `cb` is `undefined`.
6. No. The reaction is scheduled as a microtask; it runs after the current stack/task callback finishes at the microtask checkpoint.
7. No. IoC is about giving another API control over callback invocation; callback hell is deep nesting and its maintenance difficulty.
8. No. The Promise executor runs synchronously and immediately. Timers scheduled inside it run later.
9. `name` is the named outer callback function. `fileName` is the parameter receiving the filename string, such as `"file.txt"`.
10. It handles a rejection or error that propagates to that point in the chain, unless an earlier handler has already recovered from it.

---

## Final mental model

```text
CALLBACK STYLE
operation completes → operation invokes cb(value) → next callback begins

PROMISE STYLE
operation settles Promise → Promise reaction becomes microtask → .then receives value

EVENT LOOP
stack executes current JavaScript → host schedules ready tasks → microtask checkpoint drains Promise handlers → event loop continues

DATA FLOW
"JsDryRun" → "file.txt" → "SUCCESS"
```

Study the file in this order:

1. Sections 2–7: call stack, host APIs, task queue, microtask queue, and event loop.
2. Sections 8–14: callbacks, data flow, callback hell, and inversion of control.
3. Sections 15–24: Promise states, `resolve`/`reject`, chaining, dry run, and error handling.
4. Sections 25–38: comparisons, `async`/`await`, diagrams, and practice questions.

**Mastery check:** You should be able to explain why a timer callback is a task, why a `.then()` handler is a microtask, why the Promise executor runs immediately, why a missing `return` breaks chaining, and how each value moves from download to write to upload.
