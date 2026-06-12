# JavaScript Synchronous vs Asynchronous Programming

---

# Synchronous vs Asynchronous Processing

## Synchronous Processing

![Synchronous Processing](./Images/Singlethreaded.png)

### Explanation

In synchronous programming:

- Tasks execute one after another
- JavaScript waits for the current task to finish
- Next task starts only after previous task completes

### Real-Life Example 🍽️

Imagine:

```text id="a8m2x5"
One waiter serving one customer at a time
```

Everyone else waits.

---

## Asynchronous Processing

![Asynchronous Processing](./Images/AsyncProcess.png)

### Explanation

In asynchronous programming:

- JavaScript does NOT wait for slow tasks
- Long operations run in background
- Other tasks continue executing

### Real-Life Example 🍽️😂

The waiter takes the order and sends it to the kitchen.

Meanwhile:

```text id="q5m8x1"
waiter serves other customers
```

No unnecessary waiting happens.

---

# JavaScript is Single Threaded

![Asynchronous Processing](./Images/SyncVSAsyncProces.png)

JavaScript uses:

```text id="r7m1x4"
Single Thread
```

Meaning:

```text id="v2m8x5"
One task executes at a time
```

JavaScript has:

- One Call Stack
- One Main Thread

---

# Synchronous JavaScript Example

## Code Image

![Synchronous Code](./Images/SyncCode.png)

---

## Code

```js id="p4m8x2"
console.log("Order Pizza");

console.log("Prepare Pizza");

console.log("Serve Pizza");
```

---

# Step-by-Step Explanation

## Step 1

```js id="m2x8q4"
console.log("Order Pizza");
```

Output:

```text id="w8m1x3"
Order Pizza
```

---

## Step 2

```js id="k5m2x8"
console.log("Prepare Pizza");
```

Output:

```text id="f7m4x1"
Prepare Pizza
```

---

## Step 3

```js id="u8m2x5"
console.log("Serve Pizza");
```

Output:

```text id="x4m7q2"
Serve Pizza
```

---

# Final Output

```text id="n5m2x8"
Order Pizza
Prepare Pizza
Serve Pizza
```

Each line waits for the previous line.

---

# Blocking Problem in Synchronous Programming

## Code

```js id="y7m2x4"
console.log("Start");

for (let i = 0; i < 1000000000; i++) {}

console.log("End");
```

---

# Explanation

The loop takes time to finish.

During this time:

- JavaScript cannot execute other code
- UI may freeze
- Application becomes slow

This is called:

```text id="d8m2x1"
Blocking Behavior
```

---

# Call Stack

JavaScript executes code using:

```text id="m7x2q4"
Call Stack
```

The stack follows:

```text id="x2m8q1"
LIFO → Last In First Out
```

---

# Execution Context Visualization

## Image

![Execution Context](./Images/ExecContext.png)

---

# Call Stack Example

## Code

```js id="z8m1x5"
function one() {
  two();
}

function two() {
  three();
}

function three() {
  console.log("Hello");
}

one();
```

---

# Call Stack Flow

```text id="p7m2x1"
one()
↓
two()
↓
three()
↓
console.log()
```

Functions are pushed into stack and removed after execution.

---

# What is Asynchronous Programming?

Asynchronous programming allows JavaScript to:

```text id="f5m8x2"
start another task without waiting
```

for slow operations.

---

# Async JavaScript Example

## Code Image

![Async JavaScript Example](./Images/AsyncCode.png)

---

## Code

```js id="v2m8x4"
console.log("Start");

setTimeout(() => {
  console.log("Pizza Ready");
}, 3000);

console.log("Serve Water");
```

---

# Step-by-Step Explanation

## Step 1

```js id="m8x1q5"
console.log("Start");
```

Output:

```text id="y4m7x2"
Start
```

---

## Step 2

```js id="q7m2x5"
setTimeout(() => {
  console.log("Pizza Ready");
}, 3000);
```

This task moves to:

```text id="t5m8x1"
Web APIs
```

The timer starts in the background.

JavaScript does NOT wait.

---

## Step 3

```js id="r8m2x4"
console.log("Serve Water");
```

Output:

```text id="h2m7x5"
Serve Water
```

---

## Step 4

After 3 seconds:

```text id="w8m2x1"
Callback enters Callback Queue
```

Then the Event Loop pushes the callback into the stack.

Finally:

```text id="b5m7x2"
Pizza Ready
```

gets printed.

---

# Final Output

```text id="s8m2x4"
Start
Serve Water
Pizza Ready
```

---

# Internal Async Flow

![Async JavaScript Example](./Images/AsyncCode.png)

JavaScript uses:

- Call Stack
- Web APIs
- Callback Queue
- Event Loop

---

# Async Flow Explanation

## Step 1 - Call Stack

Functions execute inside:

```text id="n4m8x2"
Call Stack
```

---

## Step 2 - Web APIs

Async operations like:

- `setTimeout`
- `fetch`
- DOM Events

move to:

```text id="j8m1x4"
Web APIs
```

---

## Step 3 - Callback Queue

After completion:

```text id="g5m2x8"
Callbacks move into Callback Queue
```

---

## Step 4 - Event Loop

The Event Loop continuously checks:

```text id="u7m2x5"
Is Call Stack empty?
```

If YES:

Callbacks move into the stack.

---

# Event Loop Example

## Code

```js id="m2x8q7"
console.log("A");

setTimeout(() => {
  console.log("B");
}, 0);

console.log("C");
```

---

# Output

```text id="r5m8x2"
A
C
B
```

---

# Why?

Even though timeout is `0`:

```text id="f8m2x4"
setTimeout is asynchronous
```

The callback still waits until the Call Stack becomes empty.

---

# Callback Function Example

## Code

```js id="w2m8x5"
function greet() {
  return function () {
    console.log("Welcome to Grandline");
  };
}

const result = greet();

result();
```

---

# Explanation

## Step 1

`greet()` executes.

---

## Step 2

It returns another function.

---

## Step 3

Returned function is stored in:

```js id="q5m8x1"
result;
```

---

## Step 4

```js id="x8m2q4"
result();
```

executes the inner function.

---

# Output

```text id="v5m7x1"
Welcome to Grandline
```

---

# Promise Example

## Code

```js id="p8m2x5"
const promise = new Promise((resolve, reject) => {
  let success = true;

  if (success) {
    resolve("Data Loaded");
  } else {
    reject("Error");
  }
});

promise.then((data) => console.log(data)).catch((err) => console.log(err));
```

---

# Promise States

| State     | Meaning              |
| --------- | -------------------- |
| Pending   | Initial state        |
| Fulfilled | Operation successful |
| Rejected  | Operation failed     |

---

# Fetch API Example

## Code

```js id="m4x8q1"
fetch("https://jsonplaceholder.typicode.com/users")
  .then((response) => response.json())
  .then((data) => console.log(data))
  .catch((error) => console.log(error));
```

---

# Async/Await

`async/await` makes asynchronous code look synchronous.

---

# Async/Await Example

## Code

```js id="k7m2x5"
async function getUsers() {
  const response = await fetch("https://jsonplaceholder.typicode.com/users");

  const data = await response.json();

  console.log(data);
}

getUsers();
```

---

# Explanation

## async

Makes a function asynchronous.

---

## await

Pauses execution until Promise resolves.

---

# Advantages of Asynchronous Programming

![Asynchronous Processing](./Images/SyncProcess.png)

| Advantage                | Meaning                           |
| ------------------------ | --------------------------------- |
| Better Performance       | No blocking                       |
| Better User Experience   | UI stays responsive               |
| Faster Execution         | Waiting tasks handled efficiently |
| Efficient Resource Usage | CPU not blocked                   |

---

# Synchronous vs Asynchronous

| Synchronous           | Asynchronous                        |
| --------------------- | ----------------------------------- |
| Blocking              | Non-blocking                        |
| Executes line by line | Does not wait                       |
| Slower for long tasks | Better for waiting tasks            |
| One task at a time    | Handles multiple waiting operations |

---

# Important Interview Point

JavaScript is:

```text id="y2m8x4"
Single-threaded
BUT asynchronous
```

because browsers provide:

- Web APIs
- Callback Queue
- Event Loop

---

# Golden Interview Line

> JavaScript is single-threaded and synchronous by default, but it supports asynchronous programming using Web APIs, callback queues, and the event loop to handle non-blocking operations efficiently.

---

# Conclusion

Understanding asynchronous JavaScript is essential for:

- Frontend Development
- Backend Development
- React
- Node.js
- APIs
- Real-time applications

Mastering:

- Call Stack
- Event Loop
- Promises
- Async/Await

will make you a much better JavaScript developer.
