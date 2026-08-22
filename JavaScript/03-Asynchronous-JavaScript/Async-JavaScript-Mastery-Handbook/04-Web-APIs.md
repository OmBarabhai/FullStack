# 04 — Web APIs

**Folder:** `03-Asynchronous-JavaScript`

> **Core idea:** Web APIs are browser/Web Platform interfaces that let JavaScript interact with the page, browser features, and external resources.

---

## 1. What Are Web APIs?

A Web API is an interface provided by the web platform that JavaScript can use for capabilities outside the core JavaScript language.

Common examples:

```text
DOM
Timers
Fetch
Storage
Events
Geolocation
WebSocket
Clipboard
Notifications
```

MDN maintains a large collection of Web APIs and interfaces for web development. [MDN Web APIs](https://developer.mozilla.org/en-US/docs/Web/API)

Think:

```text
JavaScript
    ↓
JavaScript Engine
    ↓
Browser / Web Platform
    ↓
Web APIs
```

---

## 2. Why Do We Need Web APIs?

JavaScript gives us language features such as:

```js
const
let
function
Array
Object
Promise
Map
Set
```

A browser application also needs to:

```text
change HTML
listen for clicks
start timers
make network requests
store browser data
access browser/device capabilities
communicate with servers
```

Those capabilities are exposed through APIs.

So:

```text
JavaScript
    +
Web Platform APIs
    =
Interactive Web Application
```

---

## 3. Are Web APIs Part of JavaScript?

Do not treat Web APIs as core ECMAScript language features.

Examples of browser/Web Platform APIs:

```js
document
window
setTimeout()
fetch()
localStorage
navigator
WebSocket
```

Examples of JavaScript language features:

```js
Array
Object
Promise
Map
Set
function
class
```

Important nuance:

> Some Web Platform APIs are also implemented by non-browser runtimes. For example, modern Node.js provides `fetch()` and timer APIs.

So use this mental model:

```text
Web Platform APIs
        ≠
Core JavaScript language
```

---

## 4. Browser Architecture — Simplified

For this course:

```text
                 Browser Environment
                        │
        ┌───────────────┼────────────────┐
        ↓               ↓                ↓
 JavaScript Engine   Web APIs       Rendering/UI
        │               │
        ↓               ↓
    Call Stack      Browser Services
        │               │
        └───────┬───────┘
                ↓
        Queues / Scheduling
                ↓
           Event Loop
                ↓
           Call Stack
```

This is a learning model, not a literal implementation diagram for every browser.

---

## 5. Web APIs and the Call Stack

You already learned the Call Stack.

Consider:

```js
console.log("Start");

setTimeout(() => {
    console.log("Timer");
}, 1000);

console.log("End");
```

High-level flow:

```text
JavaScript
    ↓
Call Stack
    ↓
setTimeout()
    ↓
Browser timer mechanism
    ↓
timer expires
    ↓
callback becomes eligible
    ↓
queue / scheduling
    ↓
Event Loop
    ↓
Call Stack
    ↓
callback executes
```

`setTimeout()` schedules the callback and returns without blocking the following statements. The delay is not a guarantee that the callback will execute at exactly that time. [MDN setTimeout](https://developer.mozilla.org/en-US/docs/Web/API/Window/setTimeout)

The exact queue and event-loop rules come later.

---

## 6. Common Web APIs

For your MERN-oriented learning, focus on:

| API | Main Purpose |
|---|---|
| DOM | Work with the document/page |
| Timers | Schedule callbacks |
| Fetch | Network requests |
| Storage | Browser-side storage |
| Events | React to user/browser events |
| Geolocation | Location information |
| WebSocket | Bidirectional real-time communication |
| Clipboard | Clipboard operations |
| Notification | Browser notifications |

Do not try to memorize every Web API.

---

## 7. DOM API

DOM = **Document Object Model**.

The browser exposes the HTML document through DOM objects and interfaces.

Example:

```js
const button = document.querySelector("#btn");
```

Then:

```js
button.textContent = "Click me";
```

`document` is provided by the browser/Web Platform, not by core JavaScript.

The DOM will be studied properly later in:

```text
09-Browser-DOM-Events
```

---

## 8. Timer APIs

Common timer APIs:

```js
setTimeout()
clearTimeout()

setInterval()
clearInterval()
```

Example:

```js
setTimeout(() => {
    console.log("Done");
}, 2000);
```

Important:

```text
setTimeout(fn, 2000)
```

does **not** mean:

> Pause JavaScript for two seconds.

It means:

> Register a timer so the callback can become eligible after the delay has elapsed.

The callback can execute later than the requested delay because JavaScript may still be busy or other scheduling constraints may apply. [MDN setTimeout](https://developer.mozilla.org/en-US/docs/Web/API/Window/setTimeout)

---

## 9. Fetch API

The Fetch API is used for network requests.

Example:

```js
fetch("/users");
```

It returns a Promise.

```js
fetch("/users")
    .then(response => {
        return response.json();
    })
    .then(data => {
        console.log(data);
    });
```

Fetch works with:

```text
Request
Response
Headers
HTTP
CORS
Promises
```

MDN states that `fetch()` returns a Promise that resolves to a `Response` once the response is available. [MDN Fetch API](https://developer.mozilla.org/en-US/docs/Web/API/Fetch_API)

### Important Fetch rule

This is a common interview trap:

```text
HTTP 404
HTTP 500
```

do **not** automatically make the fetch Promise reject.

Check:

```js
if (!response.ok) {
    throw new Error(`HTTP ${response.status}`);
}
```

`fetch()` rejects for request/network failures, while HTTP error status codes are still represented by a `Response`. [MDN fetch()](https://developer.mozilla.org/en-US/docs/Web/API/Window/fetch)

---

## 10. Storage APIs

Two common browser storage APIs:

```js
localStorage
sessionStorage
```

Example:

```js
localStorage.setItem("name", "Om");

const name = localStorage.getItem("name");

localStorage.removeItem("name");
```

These APIs provide browser-side storage.

We will study them properly in:

```text
09-Browser-DOM-Events
```

---

## 11. Event APIs

Browsers expose events so code can respond to user and browser activity.

Example:

```js
button.addEventListener("click", () => {
    console.log("Clicked");
});
```

Conceptually:

```text
Browser detects event
        ↓
callback becomes eligible
        ↓
scheduling / queue
        ↓
Event Loop
        ↓
Call Stack
        ↓
callback executes
```

Do not confuse:

```text
Browser Event
```

with:

```text
Event Loop
```

They are different concepts.

---

## 12. Console API

You commonly write:

```js
console.log("Hello");
```

The `console` object is provided by the host environment.

Browsers provide console functionality, and Node.js also provides console functionality.

Do not think:

```text
console.log()
=
core JavaScript syntax
```

It is an API exposed by the host environment.

---

## 13. Geolocation API

Browsers can expose location-related functionality.

Example:

```js
navigator.geolocation.getCurrentPosition(
    position => {
        console.log(position.coords.latitude);
        console.log(position.coords.longitude);
    },
    error => {
        console.log(error);
    }
);
```

The browser may require user permission before providing the result.

This is a good example of:

```text
JavaScript
    ↓
Browser API
    ↓
Browser/device capability
```

---

## 14. WebSocket API

WebSocket enables persistent, bidirectional communication.

Example:

```js
const socket = new WebSocket("wss://example.com/socket");
```

Conceptually:

```text
Browser
   ⇅
Persistent connection
   ⇅
Server
```

Typical uses:

```text
Chat
Live notifications
Real-time dashboards
Online games
Collaboration
```

Keep this at a high level for now.

---

## 15. Browser Runtime vs JavaScript Engine

### JavaScript Engine

```text
Parse
Compile
Execute JavaScript
Optimize execution
Manage execution/memory
```

### Browser / Web Platform

```text
DOM
Timers
Events
Fetch
Storage
Geolocation
WebSocket
```

Simplified:

```text
                 Browser
                    │
        ┌───────────┴───────────┐
        ↓                       ↓
 JavaScript Engine          Web APIs
        │                       │
        ↓                       ↓
   executes JS          browser capabilities
```

---

## 16. Browser vs Node.js APIs

Do not assume every browser API exists in every runtime.

Browser-specific examples:

```text
document
window
localStorage
navigator
```

Node.js examples:

```text
fs
process
path
streams
```

Modern Node.js also supports several Web Platform-compatible APIs, including `fetch()` and timers.

So:

```text
Browser and Node.js
        ↓
both can execute JavaScript
        ↓
their host capabilities differ
```

---

## 17. Complete Timer Example

```js
console.log("Start");

setTimeout(() => {
    console.log("Timer");
}, 2000);

console.log("End");
```

High-level model:

```text
"Start"
   ↓
Call Stack

setTimeout()
   ↓
timer registered with host

"End"
   ↓
Call Stack continues

timer expires
   ↓
callback becomes eligible
   ↓
queue / scheduling
   ↓
Event Loop
   ↓
Call Stack
   ↓
"Timer"
```

The exact task-queue rules come in the next chapter.

---

## 18. Complete Fetch Example

```js
fetch("/users")
    .then(response => response.json())
    .then(users => {
        console.log(users);
    });
```

High-level model:

```text
JavaScript
    ↓
fetch()
    ↓
network operation
    ↓
response available
    ↓
Promise reaction becomes eligible
    ↓
JavaScript execution
    ↓
response.json()
    ↓
Promise
    ↓
users
```

Important distinction:

```text
Fetch API
→ web-platform capability

Promise
→ JavaScript abstraction representing eventual completion
```

---

## 19. Connection to Folder 02

Your Functional JavaScript work was mostly:

```text
data
 ↓
map/filter/find/reduce/sort
 ↓
result
```

Now the architecture becomes:

```text
Web API
 ↓
asynchronous result
 ↓
Promise / callback
 ↓
JavaScript execution
 ↓
Functional processing
```

Later, DevAPI can evolve into:

```text
Fetch request
    ↓
Response
    ↓
JSON
    ↓
map/filter/reduce
    ↓
Request Analytics
```

Your Folder 02 knowledge is therefore still directly useful.

---

## 20. Common Misconceptions

### ❌ `setTimeout()` pauses JavaScript

Wrong.

It schedules a callback and returns.

### ❌ `setTimeout(fn, 0)` means "run immediately"

Wrong.

It schedules the callback for a later execution opportunity.

### ❌ `fetch()` returns the response directly

Wrong.

It returns a Promise for the Response.

### ❌ A 404 automatically rejects `fetch()`

Wrong.

The Promise normally resolves with a `Response`; inspect `response.ok` / `response.status`.

### ❌ Every Web API exists only in browsers

Wrong.

Some Web Platform APIs are also available in non-browser runtimes.

### ❌ Web APIs and Event Loop are the same thing

Wrong.

```text
Web APIs
→ provide capabilities

Queues / Event Loop
→ coordinate scheduling/execution
```

---

## 21. Practice

### Exercise 1 — Classification

Classify each:

```text
Promise
document
setTimeout
Array
fetch
Map
localStorage
fs
```

Categories:

```text
Core JavaScript
Web Platform API
Runtime-specific API
```

---

### Exercise 2 — Timer

Explain:

```js
setTimeout(() => {
    console.log("Done");
}, 1000);
```

Do not answer only:

> "It waits one second."

Explain what is scheduled and what JavaScript does immediately afterward.

---

### Exercise 3 — Fetch

What is the value represented by:

```js
const result = fetch("/users");
```

before the network response has arrived?

---

### Exercise 4 — HTTP Error

Why can:

```js
fetch("/missing");
```

still resolve even if the server returns:

```text
404
```

---

### Exercise 5 — Connect the Pieces

Explain the relationship between:

```text
Web API
Call Stack
Task Queue
Event Loop
Promise
```

Use either a timer or Fetch example.

---

## 22. Interview Questions

### What are Web APIs?

Interfaces provided by the Web Platform that JavaScript can use to interact with browser capabilities and external resources.

### Are Web APIs core ECMAScript?

No.

### Is `setTimeout()` core JavaScript syntax?

No.

### What does `setTimeout()` do?

It schedules a timer callback without blocking the following JavaScript statements.

### What does `fetch()` return?

A Promise that resolves to a Response.

### Does `fetch()` reject for HTTP 404?

No. The HTTP response still arrives; application code should check `response.ok` or `response.status`.

### What is the DOM?

A Web Platform model and set of interfaces representing the document so scripts can inspect and manipulate it.

### Can Node.js provide Web APIs?

Yes, some Web Platform-compatible APIs are implemented by Node.js, while browser-specific APIs such as the DOM are generally unavailable.

---

## 23. Completion Checklist

Before moving forward:

- [ ] I understand what a Web API is.
- [ ] I can distinguish Web APIs from core JavaScript.
- [ ] I understand the browser/engine/API relationship.
- [ ] I know what the DOM API does.
- [ ] I understand `setTimeout()` at a high level.
- [ ] I know timer delay is not an exact execution guarantee.
- [ ] I know `fetch()` returns a Promise.
- [ ] I know HTTP 404 does not automatically reject `fetch()`.
- [ ] I understand basic browser event handling.
- [ ] I understand localStorage at a high level.
- [ ] I understand what WebSocket is used for.
- [ ] I can distinguish Web API, queue, Call Stack, Event Loop, and Promise.
- [ ] I can connect Web APIs to my previous Functional JavaScript knowledge.

---

## 24. Quick Revision

```text
JavaScript
     +
Web Platform APIs
     ↓
Browser Applications
```

Remember:

```text
DOM
→ document/page interaction

setTimeout
→ schedule a timer callback

fetch
→ network request → Promise

localStorage
→ browser-side storage

addEventListener
→ event handling

Geolocation
→ location capability

WebSocket
→ bidirectional real-time communication
```

Most important:

```text
Web API
   ↓
provides capability

Call Stack
   ↓
executes current JavaScript

Queue
   ↓
holds work waiting for an execution turn

Event Loop
   ↓
coordinates when queued work gets a turn

Promise
   ↓
represents eventual completion/failure
```

---

# Next Chapter

➡️ **05-Task-Queue.md**

The next topic will focus on:

```text
Task / Callback Queue
    ↓
FIFO idea
    ↓
callbacks waiting for execution
    ↓
why setTimeout(0) is not immediate
    ↓
Call Stack + Queue
    ↓
first output dry-runs
```

Keep **Web APIs** and the **Task Queue** separate. They work together, but they are not the same concept.
