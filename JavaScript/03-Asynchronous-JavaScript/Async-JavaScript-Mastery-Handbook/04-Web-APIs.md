# Chapter 4 — Web APIs

> **"JavaScript is only a language. Web APIs give JavaScript superpowers inside the browser."**

---

# Table of Contents

1. What are Web APIs?
2. Why Do We Need Web APIs?
3. Are Web APIs Part of JavaScript?
4. Browser Architecture
5. How Browser Executes JavaScript
6. Common Web APIs
7. DOM API
8. Timer APIs
9. Fetch API
10. Storage APIs
11. Event APIs
12. Console API
13. Geolocation API
14. WebSocket API
15. Drag & Drop API
16. Browser Runtime vs JavaScript Engine
17. Complete Execution Flow
18. Browser vs Node.js APIs
19. Common Misconceptions
20. Interview Questions
21. Exercises
22. Summary

---

# 1. What are Web APIs?

A Web API is a feature provided by the **browser**, not by JavaScript.

They allow JavaScript to interact with the outside world.

Examples

- Timers
- DOM
- HTTP Requests
- Local Storage
- Camera
- Microphone
- Clipboard
- Notifications

Without Web APIs,

JavaScript can only perform calculations.

---

Example

```js
let a = 10;
let b = 20;

console.log(a + b);
```

This is pure JavaScript.

But

```js
setTimeout(()=>{},1000)
```

needs a Web API.

---

# 2. Why Do We Need Web APIs?

Imagine JavaScript had no Web APIs.

Could it

❌ Change HTML?

❌ Make network requests?

❌ Wait 5 seconds?

❌ Read user location?

❌ Handle button clicks?

No.

JavaScript would only be a calculator.

---

# 3. Are Web APIs Part of JavaScript?

One of the most common interview questions.

Answer:

**No.**

JavaScript Specification (ECMAScript)

Provides

- Variables
- Functions
- Objects
- Arrays
- Classes
- Promise

Browser

Provides

- DOM
- fetch()
- setTimeout()
- localStorage
- alert()
- document
- window

---

Interview Trick

Question

Is Promise a Web API?

Answer

❌ No

Promise is JavaScript.

---

Question

Is fetch() JavaScript?

Answer

❌ No

Browser provides fetch.

---

# 4. Browser Architecture

A simplified browser looks like this.

```
+-------------------------------------+

Browser

|

|-- JavaScript Engine

|

|-- Rendering Engine

|

|-- Web APIs

|

|-- Event Loop

|

|-- Callback Queue

|

|-- Microtask Queue

+-------------------------------------+
```

---

# 5. How Browser Executes JavaScript

```
JavaScript Code

↓

JavaScript Engine

↓

Call Stack

↓

Web APIs

↓

Queues

↓

Event Loop

↓

Call Stack

↓

Output
```

---

# 6. Common Web APIs

The browser provides hundreds of APIs.

Popular ones

| API | Purpose |
|------|---------|
| DOM | Manipulate HTML |
| Fetch | HTTP Requests |
| Timer | Delay execution |
| Local Storage | Save Data |
| Session Storage | Temporary Data |
| Clipboard | Copy/Paste |
| Notification | Desktop Notifications |
| Geolocation | User Location |
| WebSocket | Real-time Communication |
| Audio | Play Sounds |
| Video | Play Videos |

---

# 7. DOM API

DOM = Document Object Model

Example

```js
document.getElementById("btn");
```

Who provides `document`?

Browser.

Not JavaScript.

---

Example

```js
document.querySelector("h1").style.color = "red";
```

JavaScript asks the browser to modify HTML.

---

# 8. Timer APIs

Examples

```js
setTimeout()

setInterval()

clearTimeout()

clearInterval()
```

Example

```js
setTimeout(() => {
    console.log("Hello");
},2000);
```

Flow

```
Call Stack

↓

Browser Timer

↓

Callback Queue

↓

Event Loop

↓

Call Stack
```

---

# 9. Fetch API

Example

```js
fetch("/users")
```

Flow

```
JavaScript

↓

Browser

↓

Network

↓

Response

↓

Promise

↓

Microtask Queue
```

Browser performs the network request.

JavaScript never talks directly to the internet.

---

# 10. Storage APIs

Local Storage

```js
localStorage.setItem("name","Om");
```

Read

```js
localStorage.getItem("name");
```

Delete

```js
localStorage.removeItem("name");
```

---

Session Storage

Similar to Local Storage,

but data disappears when the tab closes.

---

# 11. Event APIs

Example

```js
button.addEventListener("click",()=>{
    console.log("Clicked");
});
```

Browser watches for the click.

When clicked,

Browser sends callback to the Event Loop.

---

# 12. Console API

Example

```js
console.log("Hello");
```

Question

Who provides console?

Answer

Browser.

(Node.js also provides its own implementation.)

---

# 13. Geolocation API

Example

```js
navigator.geolocation.getCurrentPosition();
```

Browser asks

"Allow Location?"

Only after permission does JavaScript receive the result.

---

# 14. WebSocket API

Allows real-time communication.

Used in

- WhatsApp
- Discord
- Slack
- Online Games

Example

```js
const socket = new WebSocket(url);
```

---

# 15. Drag & Drop API

Example

```js
dragstart

drag

dragend

drop
```

Browser manages all drag operations.

---

# 16. Browser Runtime vs JavaScript Engine

JavaScript Engine

Responsible for

- Parsing
- Compiling
- Executing JavaScript

Browser Runtime

Responsible for

- DOM
- Fetch
- Timers
- Storage
- Event Loop

---

# 17. Complete Flow

Example

```js
setTimeout(()=>{
console.log("Hello");
},2000);
```

Flow

```
Call Stack

↓

Browser Timer

↓

Wait 2 seconds

↓

Callback Queue

↓

Event Loop

↓

Call Stack

↓

console.log()
```

---

# 18. Browser vs Node APIs

Browser

```
window

document

localStorage

fetch

navigator
```

Node

```
fs

http

path

process

Buffer
```

Different runtimes,

different APIs.

---

# 19. Common Misconceptions

❌ setTimeout is JavaScript

Wrong.

Browser provides it.

---

❌ document is JavaScript

Wrong.

Browser provides it.

---

❌ fetch is JavaScript

Wrong.

Browser provides it.

---

❌ Promise is Browser API

Wrong.

Promise belongs to JavaScript.

---

# 20. Interview Questions

### What are Web APIs?

Features provided by the browser that JavaScript uses to interact with the outside world.

---

### Is setTimeout part of JavaScript?

No.

---

### Is document part of JavaScript?

No.

---

### Who provides fetch?

Browser Runtime.

---

### What is the DOM?

A tree-like representation of an HTML document that JavaScript can manipulate.

---

# 21. Exercises

### Exercise 1

Which of these are Web APIs?

```js
setTimeout()

Promise

fetch()

document

Array

Map
```

---

### Exercise 2

Explain the flow of

```js
fetch("/users");
```

---

### Exercise 3

Explain the flow of

```js
setTimeout(()=>{},3000);
```

---

# 22. Summary

- JavaScript is only a language.
- Web APIs are provided by the browser.
- Common Web APIs include DOM, Fetch, Timers, Storage, Events, Geolocation, and WebSockets.
- The JavaScript engine executes code, while the browser runtime provides additional capabilities.
- Understanding Web APIs is essential before learning the Event Loop.

---

# Next Chapter

➡️ **05-Task-Queue.md**

You'll learn:

- What the Callback (Task) Queue is
- How asynchronous callbacks are stored
- FIFO behavior
- How callbacks move from the queue to the Call Stack
- Why `setTimeout(0)` doesn't execute immediately
- Real interview dry runs