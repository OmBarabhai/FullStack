# JavaScript Callbacks & Promises — Master Notes

> **Goal:** Understand, dry-run, debug, and revise the two versions of the same workflow you practiced:
>
> **Download data → Write a file → Upload the file**
>
> These examples use `setTimeout()` to simulate slow operations. They do **not** download a real file, write to disk, or upload to a real website.

---

## 0. The big picture

Imagine three jobs must happen in this order:

1. Download some content.
2. Write that content to a file and get the filename.
3. Upload that filename and receive a response.

Each operation takes time. We do not want to start writing before the download finishes, or upload before the file is ready.

JavaScript commonly handles this kind of delayed work using:

- **Callbacks:** pass a function to another function and call it when the work finishes.
- **Promises:** return an object representing a result that may be available now or later; use `.then()` to handle that result.
- **`async`/`await`:** syntax built on Promises that often makes sequential asynchronous code easier to read. (Covered briefly near the end.)

### Values moving through the workflow

| Stage | Input | Result passed to the next stage |
|---|---|---|
| `download(url, callback)` | URL | Content such as `"JsDryRun"` |
| `writeFile(content, callback)` | Downloaded content | Filename such as `"file.txt"` |
| `uploadFile(url, file, callback)` | Upload URL and filename | Response such as `"SUCCESS"` |

Keep these different values separate in your mind:

- `content` = the downloaded content.
- `fileName` = the name of the created file.
- `response` = the upload result.

Names such as `content`, `fileName`, `response`, `resolve`, and `reject` are parameter/variable names. You may choose other names, but you must use the right value in the right place.

---

# Part A — Callbacks

## 1. What is a callback?

A **callback is a function passed as an argument to another function**, with the expectation that the other function will call it at an appropriate time.

Small example:

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

Here:

- The anonymous function is passed as the second argument.
- Inside `greet`, the parameter `callback` refers to that function.
- `callback()` invokes the function.

A callback can be invoked immediately or later. In your download example, it is invoked later, after a timer.

## 2. Your callback-based functions — corrected version

```javascript
function download(url, cb) {
    console.log("Starting download from", url);

    setTimeout(function down() {
        const content = "JsDryRun";
        console.log("Download completed");
        cb(content);
    }, 4232);
}

function writeFile(data, cb) {
    console.log("Started writing file with", data);

    setTimeout(function write() {
        console.log("Completed writing the data in a file");
        const fileName = "file.txt";
        cb(fileName);
    }, 3729);
}

function uploadFile(url, file, cb) {
    console.log("Started uploading", file, "to", url);

    setTimeout(function upload() {
        console.log("Uploading completed");
        const response = "SUCCESS";
        cb(response);
    }, 3442);
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

### Important function signatures

```javascript
download(url, cb)
writeFile(data, cb)
uploadFile(url, file, cb)
```

`uploadFile` requires **three arguments**, in this order:

1. `url`
2. `file`
3. `cb` (the callback function)

Correct call:

```javascript
uploadFile("www.nexus.com", fileName, function (response) {
    console.log(response);
});
```

Incorrect call:

```javascript
uploadFile("www.nexus.com", function (response) {
    console.log(response);
});
```

In the incorrect call, the callback function is assigned to the `file` parameter, while `cb` becomes `undefined`. When the timer later tries `cb(response)`, JavaScript throws `TypeError: cb is not a function`.

## 3. Callback dry run — step by step

The timer durations in this example are 4.232 seconds, 3.729 seconds, and 3.442 seconds. Your earlier callback examples used other durations, but the logic is identical.

### Step 1: Start the download

```javascript
download("www.comsy.com", function (content) {
    // next steps
});
```

JavaScript enters `download`:

```javascript
console.log("Starting download from", url);
setTimeout(function down() {
    const content = "JsDryRun";
    console.log("Download completed");
    cb(content);
}, 4232);
```

- `url` is `"www.comsy.com"`.
- The starting message prints immediately.
- `setTimeout` schedules the `down` function to run after at least the requested delay; the exact timing can vary.
- `download` itself does not return a value, so its immediate return value is `undefined`.
- Later, `down` creates `content = "JsDryRun"` and calls `cb(content)`.

### Step 2: How does `cb(content)` pass the value?

The callback supplied by the caller is:

```javascript
function (content) {
    console.log("Now processing downloaded data");
    writeFile(content, function (fileName) {
        // next step
    });
}
```

The `cb` parameter inside `download` refers to this caller-supplied function. Calling `cb(content)` is effectively calling that function with the value `"JsDryRun"`.

Therefore, the callback's local parameter `content` becomes `"JsDryRun"`.

**Key distinction:** `cb` is a function; `content` is data. `cb(content)` means “invoke this function and pass this data to it.”

### Step 3: Write the file

The callback calls:

```javascript
writeFile(content, function (fileName) {
    // next step
});
```

At this point, `content` is `"JsDryRun"`, so `data` inside `writeFile` receives `"JsDryRun"`.

After the timer finishes, `writeFile` does:

```javascript
const fileName = "file.txt";
cb(fileName);
```

That calls the next callback with `"file.txt"`, so its parameter `fileName` receives that string.

### Step 4: Upload the file

The callback calls:

```javascript
uploadFile("www.nexus.com", fileName, function (response) {
    console.log("We have uploaded with", response);
});
```

Arguments are matched by position:

- `url` = `"www.nexus.com"`
- `file` = `"file.txt"`
- `cb` = the supplied callback function

When the timer finishes, `uploadFile` calls `cb("SUCCESS")`. The final callback's parameter `response` receives `"SUCCESS"`.

### Expected output order

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

The exact delays are simulated. The important fact is the **order**: writing starts after download completion, and uploading starts after writing completes.

## 4. Why did `name` print a function instead of a filename?

You wrote something like:

```javascript
download("www.comsy.com", function name(content) {
    writeFile(content, function process(fileName) {
        console.log("File written with name", name);
    });
});
```

Here, `name` is the name of the **outer callback function**. It does not mean “the filename.” When you log `name`, the console displays the function itself.

Use the variable that holds the value you want:

```javascript
console.log("File written with name", fileName);
```

Likewise, after uploading, use `response`, not `name`:

```javascript
function (response) {
    console.log("We have uploaded with", response);
}
```

**Rule:** A function's name identifies the function; a callback parameter receives the value passed when the callback is invoked.

## 5. Why did the console show `undefined`?

When you called a callback-based function such as:

```javascript
download("www.comsy.com", function (content) {
    // ...
});
```

The `download` function did not contain a `return` statement. JavaScript therefore returned `undefined` immediately.

The browser console can show that immediate return value while the timer's log messages appear later. This does **not** mean the callback failed. It means the function's immediate return value is `undefined`, while its later work is handled through the callback.

For callback code, the result is delivered to the callback rather than returned by `download` itself.

## 6. Callback advantages

- **Simple for one small asynchronous step:** a callback is a direct way to say what should happen after work completes.
- **Flexible:** a function can call a supplied callback when a task finishes or when an event happens.
- **Widely used:** event handlers and many APIs accept callbacks.
- **Can pass results:** `cb(content)` sends data to the next function.

## 7. Callback disadvantages

Callbacks are not inherently bad. The main difficulties appear when asynchronous tasks depend on one another and many callbacks become nested.

### Callback hell (the pyramid problem)

A longer workflow may look like this:

```javascript
download(url, function (content) {
    writeFile(content, function (fileName) {
        uploadFile(server, fileName, function (response) {
            notifyUser(response, function (notificationResult) {
                // more work...
            });
        });
    });
});
```

As more dependent operations are added:

- The code grows horizontally to the right.
- It becomes harder to scan and understand the sequence.
- Error handling can be repeated at multiple levels.
- Passing the right data through each level becomes harder.
- Testing and changing one step can become more awkward.

This deeply nested structure is commonly called **callback hell** or the **pyramid of doom**.

### Inversion of control (IoC) with callbacks

**Inversion of control means handing control over some part of your program to another function or system.**

When you pass a callback to an API, you trust that API to call it:

```javascript
someLibrary.doWork(function (result) {
    // assumes the library calls this at the right time
});
```

The calling code does not directly decide when or how often the callback runs. It relies on the other function/library to follow the expected contract.

Possible callback API problems—especially with poorly designed or untrusted APIs—include:

- The callback is never called.
- It is called more than once even though you expected one result.
- It is called with an unexpected value or error convention.
- It is called at an unexpected time.

These are risks, not a guarantee that every callback API behaves badly. A well-designed callback API can specify and enforce its behavior.

**Interview wording:** “Callbacks can create inversion of control because we hand a function to another API and rely on that API to decide when and how often to invoke it. Deeply nested callbacks can also cause callback hell.”

### Error handling with callbacks

One common convention is the **error-first callback**:

```javascript
function readSomething(callback) {
    // Example convention: callback(error, result)
    callback(null, "data");
}

readSomething(function (error, result) {
    if (error) {
        console.error(error);
        return;
    }

    console.log(result);
});
```

This is a convention used by many Node.js APIs, not a rule imposed on every JavaScript callback.

---

# Part B — Promises

## 8. What is a Promise?

A **Promise** is a JavaScript object representing the eventual success or failure of an asynchronous operation.

A Promise has three states:

1. **Pending:** the outcome has not been settled yet.
2. **Fulfilled:** the operation succeeded and has a fulfillment value.
3. **Rejected:** the operation failed and has a rejection reason.

A settled Promise is either fulfilled or rejected. It does not switch to another state afterward.

### `resolve` and `reject`

```javascript
new Promise(function (resolve, reject) {
    // resolve(value) = report success
    // reject(error) = report failure
});
```

The Promise constructor invokes its **executor function immediately** and supplies the two functions:

- `resolve(value)` fulfills the Promise with a value (or adopts the state of a Promise/thenable supplied to it).
- `reject(error)` rejects the Promise with a reason, commonly an `Error` object.

The names are not special keywords. These are parameter names chosen by the programmer. You wrote `res` and `rej`; that is valid too:

```javascript
new Promise(function exec(res, rej) {
    res("SUCCESS");
});
```

`exec` is simply the function's name. It could be called `executor`, `abc`, or be anonymous. Its **position as the argument to `new Promise`** is what makes it the executor. The Promise constructor supplies its arguments.

## 9. Why did `exec(res, rej)` fail inside `setTimeout`?

Your incorrect upload function was similar to this:

```javascript
function uploadFile(url, file) {
    console.log("Started uploading", file, "to", url);

    setTimeout(function exec(res, rej) {
        console.log("Uploading completed");
        const response = "SUCCESS";
        res(response);
    }, 3442);
}
```

The issue is **not the name `exec`**. The issue is where the function is passed.

- In `new Promise(function exec(res, rej) { ... })`, the Promise constructor passes the resolve and reject functions to the executor.
- In `setTimeout(function exec(res, rej) { ... }, 3442)`, `setTimeout` invokes the timer callback without passing Promise resolve/reject functions. Its callback parameters `res` and `rej` are therefore `undefined`.

Then `res(response)` attempts to call `undefined`, causing:

```text
TypeError: res is not a function
```

### Correct structure

```javascript
function uploadFile(url, file) {
    return new Promise(function exec(res, rej) {
        console.log("Started uploading", file, "to", url);

        setTimeout(function upload() {
            console.log("Uploading completed");
            res("SUCCESS");
        }, 3442);
    });
}
```

Here, the timer callback can access `res` from the enclosing Promise executor's scope. This is a JavaScript **closure**: the inner function can use variables from its outer lexical scope.

The same code is often easier to read using standard names:

```javascript
function uploadFile(url, file) {
    return new Promise(function (resolve, reject) {
        setTimeout(function () {
            resolve("SUCCESS");
        }, 3442);
    });
}
```

Both versions work. `resolve` and `reject` are more descriptive than `res` and `rej` for learning.

## 10. Your Promise-based functions — corrected version

```javascript
function download(url) {
    return new Promise(function (resolve, reject) {
        console.log("Starting download from", url);

        setTimeout(function () {
            const content = "JsDryRun";
            console.log("Download completed");
            resolve(content);
        }, 4232);
    });
}

function writeFile(data) {
    return new Promise(function (resolve, reject) {
        console.log("Started writing file with", data);

        setTimeout(function () {
            console.log("Completed writing the data in a file");
            const fileName = "file.txt";
            resolve(fileName);
        }, 3729);
    });
}

function uploadFile(url, file) {
    return new Promise(function (resolve, reject) {
        console.log("Started uploading", file, "to", url);

        setTimeout(function () {
            console.log("Uploading completed");
            resolve("SUCCESS");
        }, 3442);
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
        console.error("Something failed:", error);
    });
```

## 11. Promise dry run — step by step

### Step 1: Call `download`

```javascript
download("www.comsy.com")
```

The function immediately returns a Promise object. The Promise executor itself runs immediately, so the start message is printed right away and the timer is scheduled.

Initially, the Promise is pending. In browser DevTools, you may see something like:

```text
Promise {<pending>}
```

This is normal. The console is showing the Promise before all the delayed work has finished.

### Step 2: Download finishes and calls `resolve`

After the timer callback runs:

```javascript
const content = "JsDryRun";
console.log("Download completed");
resolve(content);
```

The Promise is fulfilled with `"JsDryRun"`. The first `.then()` will receive that value as its parameter, named `content`:

```javascript
.then(function (content) {
    console.log("Now processing downloaded data");
    return writeFile(content);
})
```

### Step 3: Why `return writeFile(content)` matters

`writeFile(content)` returns another Promise. By returning it from the first `.then()` callback, you tell the chain to wait for that Promise to settle before running the next `.then()`.

When `writeFile` calls `resolve("file.txt")`, the next `.then()` receives `"file.txt"` as `fileName`.

If you forget `return`:

```javascript
.then(function (content) {
    writeFile(content); // missing return
})
.then(function (fileName) {
    console.log(fileName); // likely undefined here
});
```

The outer chain does not wait for the `writeFile` Promise. The first handler returns `undefined` implicitly, so the next handler receives `undefined`. The writing operation still runs independently.

### Step 4: Return the upload Promise

```javascript
.then(function (fileName) {
    console.log("File written with name", fileName);
    return uploadFile("www.nexus.com", fileName);
})
```

Again, `return` makes the chain wait for the upload Promise. When it resolves with `"SUCCESS"`, the final `.then()` gets that value as `response`.

### Step 5: Handle errors with `.catch()`

```javascript
.catch(function (error) {
    console.error("Something failed:", error);
});
```

A rejection from an earlier Promise or an exception thrown by a `.then()` handler normally travels down the chain to `.catch()`. The exact behavior still depends on how the asynchronous operation reports errors. For example, an exception thrown later inside a `setTimeout` callback is **not automatically caught by the Promise constructor** unless the timer callback catches it and calls `reject`, or otherwise converts it into a rejection.

## 12. Why did `uploadFile()` need to return a Promise?

A Promise chain can only wait for a Promise (or thenable) that is returned from the current handler.

Incorrect:

```javascript
function uploadFile(url, file) {
    setTimeout(function () {
        // upload simulation
    }, 3442);
}
```

This function returns `undefined` immediately. A caller cannot wait for the simulated upload through its return value.

Correct:

```javascript
function uploadFile(url, file) {
    return new Promise(function (resolve, reject) {
        setTimeout(function () {
            resolve("SUCCESS");
        }, 3442);
    });
}
```

Now its return value represents the upload's future outcome.

## 13. Why `.then().then().then()` works

`.then()` returns a **new Promise**. It does not create a property named after the next operation.

Correct:

```javascript
download(url)
    .then(function (content) {
        return writeFile(content);
    })
    .then(function (fileName) {
        return uploadFile(server, fileName);
    })
    .then(function (response) {
        console.log(response);
    });
```

Incorrect:

```javascript
download(url)
    .then(function (content) {
        return writeFile(content);
    })
    .writeFile.then(...); // not how Promise chaining works
```

After `.then(...)`, you have a Promise, not an object with a `.writeFile` property. The next operation belongs in another `.then()` handler.

### The value flow

```text
download(url)
  └─ fulfills with "JsDryRun"
       ↓ first .then(content)
       return writeFile(content)
  └─ adopts the writeFile Promise
       └─ fulfills with "file.txt"
            ↓ second .then(fileName)
            return uploadFile(url, fileName)
       └─ adopts the uploadFile Promise
            └─ fulfills with "SUCCESS"
                 ↓ third .then(response)
                 logs SUCCESS
```

## 14. Promise timing: why does “Downloaded Done” sometimes print after `resolve`?

Your code used this order inside the timer:

```javascript
resolve(content);
console.log("Downloaded Done");
```

It might seem that resolving the Promise should run the next `.then()` immediately. It does not.

- `resolve(content)` settles the Promise.
- Promise `.then()` handlers run asynchronously as microtasks, after the current JavaScript call stack finishes.
- The current timer callback continues running, so `console.log("Downloaded Done")` executes before the first `.then()` handler.

For clearer logs, many learners prefer printing “Download completed” before calling `resolve(content)`, as in the corrected example. Either order is valid; the scheduling rule is what matters.

## 15. Why did `let download = download(...)` fail?

You had a function named `download` and then tried to declare a top-level variable with the same name:

```javascript
function download(url) {
    // ...
}

let download = download("www.comsy.com"); // don't do this
```

A `let` declaration cannot redeclare an existing identifier in the same scope, so the browser reported:

```text
SyntaxError: Identifier 'download' has already been declared
```

Call the function directly and chain its Promise:

```javascript
download("www.comsy.com").then(...);
```

Or use a different variable name if you want to store the Promise:

```javascript
const downloadPromise = download("www.comsy.com");
downloadPromise.then(...);
```

When repeatedly pasting code into the same browser DevTools console, top-level `let` and `const` declarations can remain in that console's lexical scope. Reloading the page or using fresh names can clear this particular testing problem. In a Node.js script started as a new process, each fresh process starts with a new scope.

## 16. Promise advantages

### 1. Flatter structure

Instead of nesting each operation inside the previous callback, dependent operations can be placed in a chain of `.then()` handlers.

### 2. More consistent error propagation

A rejection or a thrown error in a `.then()` handler can flow to a later `.catch()`. With callbacks, error handling often has to be repeated or explicitly passed around according to the callback API's conventions.

### 3. Standard result representation

A Promise represents success or failure. Consumers can attach `.then()`, `.catch()`, and `.finally()` handlers to it.

### 4. A more explicit sequence

Returning each next Promise expresses the dependency between tasks:

```javascript
return writeFile(content);
```

The next step waits for the write Promise to settle.

### 5. Composition utilities

Promise APIs include `Promise.all()`, `Promise.allSettled()`, `Promise.race()`, and `Promise.any()` for coordinating multiple asynchronous operations (each has different behavior).

### 6. The foundation of `async`/`await`

`async`/`await` provides a different syntax for working with Promises while preserving Promise-based behavior.

## 17. Promise disadvantages and limitations

- **Promises do not make work automatically faster.** They describe and coordinate asynchronous outcomes; the actual operation and its scheduling determine performance.
- **They do not automatically make an operation asynchronous.** The Promise executor runs immediately. Work inside it is asynchronous only if the code schedules asynchronous work or calls an asynchronous API.
- **They do not prevent all inversion of control.** A Promise gives consumers a standard way to observe the outcome and normally settles only once, reducing some callback coordination risks. However, the underlying API still controls the operation; a broken Promise implementation or a poorly designed wrapper can still cause trouble.
- **They do not cancel themselves by default.** Cancellation depends on the underlying API or a separate mechanism, such as an `AbortController` where supported.
- **They can still be misused.** Forgetting to return a Promise, logging the wrong variable, failing to handle rejections, or starting dependent tasks without chaining them can create bugs.
- **They can be less direct for repeated events.** A Promise normally represents one eventual outcome, while callbacks or event streams can handle repeated events (for example, many button clicks or messages).
- **They require understanding chaining and error propagation.** The new syntax is not automatically easy until you understand how values move between handlers.

## 18. Do Promises solve inversion of control?

A nuanced answer is best:

Promises **reduce some inversion-of-control problems** compared with directly handing a callback to an API.

For example:

```javascript
const promise = download(url);

promise.then(function (content) {
    console.log(content);
});
```

The producer returns a Promise, and the consumer registers handlers. A standard Promise settles once, and `.then()` handlers are scheduled consistently. You don't give the producer your final processing function as its callback parameter in the same way as in the callback API.

But Promises do **not eliminate every form of inversion of control**. The code that starts the task still controls its execution, and a Promise wrapper depends on its underlying operation to report completion or failure correctly.

A useful interview statement:

> “Promises reduce callback nesting and provide standard fulfillment/rejection handling. They also reduce some inversion-of-control risks because a Promise settles once and consumers attach their own handlers. They don't eliminate every inversion-of-control problem or make a poorly implemented asynchronous API reliable by themselves.”

---

# Part C — Callback vs Promise comparison

## 19. Comparison table

| Topic | Callback approach | Promise approach |
|---|---|---|
| How results are delivered | Call `cb(value)` | Call `resolve(value)` in the producer; receive it in `.then(value)` |
| How the next step is arranged | Often nested callback | Return the next Promise from `.then()` |
| Readability for several dependent tasks | Can become deeply nested | Usually flatter and easier to follow |
| Error handling | Depends on the callback convention; often error-first in Node.js APIs | Rejections can flow through the chain to `.catch()` |
| One operation's outcome | Depends on the API's callback contract | Promise can fulfill or reject only once |
| Repeated events | A natural fit | A single Promise is not a stream of repeated outcomes |
| Cancellation | API-specific | API-specific; not built into every Promise by default |
| Is it automatically faster? | No | No |
| Is it automatically real I/O? | No | No; your timers are only simulations |

## 20. Same workflow: callback version vs Promise version

### Callback version

```javascript
download(url, function (content) {
    writeFile(content, function (fileName) {
        uploadFile(server, fileName, function (response) {
            console.log(response);
        });
    });
});
```

The next step is placed inside the callback of the previous step.

### Promise version

```javascript
download(url)
    .then(function (content) {
        return writeFile(content);
    })
    .then(function (fileName) {
        return uploadFile(server, fileName);
    })
    .then(function (response) {
        console.log(response);
    })
    .catch(function (error) {
        console.error(error);
    });
```

The next step is placed in the next `.then()`, and each asynchronous operation's Promise is returned.

---

# Part D — `async`/`await` preview

## 21. Same Promise workflow using `async`/`await`

`async`/`await` does not replace Promises; it provides syntax for working with them.

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
        console.error("Something failed:", error);
    }
}

runWorkflow();
```

Important points:

- An `async` function always returns a Promise.
- `await` pauses that async function until the awaited Promise settles; it does not block the entire JavaScript thread.
- If the awaited Promise rejects, the rejection acts like an exception at the `await` expression and can be caught by `try/catch`.
- The `download`, `writeFile`, and `uploadFile` functions must return Promises for this example to coordinate the tasks as intended.

---

# Part E — Common errors from your practice

## 22. Error: `cb is not a function`

**Cause:** The callback was passed in the wrong argument position, or the function expected a callback but received `undefined` or a non-function.

**Check:** Compare the function signature with the call.

```javascript
function uploadFile(url, file, cb) { /* ... */ }

uploadFile("www.nexus.com", "file.txt", function (response) {
    console.log(response);
});
```

## 23. Error: `res is not a function`

**Cause:** You named the `setTimeout` callback parameters `res` and `rej`, thinking they would be Promise functions.

**Fix:** Put the timer inside the Promise executor and call the `resolve` function captured from the outer scope.

```javascript
return new Promise(function (resolve, reject) {
    setTimeout(function () {
        resolve("SUCCESS");
    }, 1000);
});
```

## 24. The console prints a function instead of `file.txt`

**Cause:** You logged the callback function's name, such as `name`, instead of the value parameter, such as `fileName`.

**Fix:**

```javascript
console.log(fileName);
```

## 25. The final output is blank or shows `undefined`

Possible causes in your exercises:

1. You logged `name` instead of `response`.
2. A function didn't return a Promise.
3. A `.then()` handler didn't return the next Promise.
4. You expected the immediate return value of a callback-based function to contain a later result.

Debug the exact variable and return path; do not assume all `undefined` output has the same cause.

## 26. `Identifier has already been declared`

**Cause:** You redeclared the same top-level name with `let` or `const`, such as `let download` when `download` was already declared as a function.

**Fix:** Keep the function name and Promise variable name different, or run a fresh script/scope.

## 27. `Promise {<pending>}`

**Meaning:** The Promise has not settled at the time the console displays it. It is usually a normal observation, not an error.

The later logs tell you what happened when your timers ran.

## 28. `load_time_data_deprecated.js` warning

You also saw a browser message like:

```text
crbug/1173575, non-JS module files deprecated.
```

That warning is associated with the browser/DevTools environment and is not the cause of your `res is not a function` error. Diagnose the application error using its own stack trace.

---

# Part F — Revision sheet

## 29. Key terms

- **Callback:** A function passed to another function to be invoked later or at a chosen point.
- **Asynchronous operation:** Work whose completion is handled later instead of requiring the current code to wait synchronously.
- **Promise:** An object representing a future fulfillment value or rejection reason.
- **Executor:** The function passed to `new Promise`; it runs immediately and receives `resolve` and `reject`.
- **`resolve(value)`:** Fulfills the Promise with a value, or adopts another Promise/thenable's state.
- **`reject(reason)`:** Rejects the Promise.
- **`.then(onFulfilled)`:** Registers a fulfillment handler and returns a new Promise.
- **`.catch(onRejected)`:** Registers a rejection handler; equivalent in purpose to `.then(undefined, onRejected)`.
- **Promise chaining:** Passing a value or returned Promise from one `.then()` to the next.
- **Callback hell:** Deeply nested callbacks that make dependent asynchronous workflows difficult to read and maintain.
- **Inversion of control:** Giving another function/system control over when a supplied callback is invoked or when an operation is carried out.
- **Closure:** An inner function's ability to access variables from its outer lexical scope.

## 30. Five rules to memorize

1. `cb(value)` calls a callback and passes `value` to it.
2. `new Promise((resolve, reject) => { ... })` supplies the Promise's `resolve` and `reject` functions to the executor.
3. A `setTimeout` callback does not automatically receive `resolve` and `reject`.
4. Return every dependent Promise inside `.then()` so the chain waits for it.
5. Log the value you actually want: `content`, `fileName`, or `response`—not the name of a callback function.

## 31. A quick mental dry run

For the Promise version, ask yourself at every step:

1. Which function is running now?
2. What value does it receive?
3. Does it return a Promise?
4. What value does it resolve with?
5. Which `.then()` receives that value next?

Answers for this example:

```text
download(url)           → resolves "JsDryRun"
first .then(content)    → content = "JsDryRun"
writeFile(content)      → resolves "file.txt"
second .then(fileName)  → fileName = "file.txt"
uploadFile(url, fileName) → resolves "SUCCESS"
third .then(response)   → response = "SUCCESS"
```

## 32. Interview questions for self-testing

Try answering these out loud before reading any external explanation:

1. What is a callback? Give an example from the download workflow.
2. What does `cb(content)` mean?
3. Why did logging `name` print a function instead of a filename?
4. What are the three Promise states?
5. What is the role of the Promise executor?
6. Why is `res` undefined in a `setTimeout(function (res) {})` callback?
7. Why must `uploadFile()` return a Promise?
8. Why should `return writeFile(content)` be used inside `.then()`?
9. What happens if you omit that `return`?
10. What is callback hell, and why can it be hard to maintain?
11. What is inversion of control? How can Promises reduce some of its risks?
12. Do Promises automatically make code faster, asynchronous, or cancellable?
13. Why might DevTools show `Promise {<pending>}`?
14. How does `.catch()` handle a rejection from an earlier part of a Promise chain?
15. How does `async`/`await` relate to Promises?

## 33. Final summary

**Callbacks:** The operation receives a function and calls it with the result. This is effective for simple tasks but nested dependencies can become difficult to maintain.

**Promises:** The operation returns a Promise. Calling `resolve(value)` supplies the successful result; `.then()` handlers consume the result. Returning the next Promise creates a sequential chain, and `.catch()` provides a central place to handle many failures.

**The most important idea from your exercise:** Understand the flow of values and return values. `content` travels from download to writing, `fileName` travels from writing to upload, and `response` travels from upload to the final handler.
