# Part 1 — Introduction & Fundamentals

## 1. What Are Modules?

A **module** is a JavaScript file that contains code for a specific purpose.

Instead of putting everything into one large file:

```text
app.js
```

we can split our application into multiple files:

```text
project/
│
├── app.js
├── math.js
├── user.js
├── auth.js
└── database.js
```

Each file can have a specific responsibility.

For example:

```text
math.js
   ↓
Math-related functions

user.js
   ↓
User-related functions

auth.js
   ↓
Authentication-related functions
```

### Simple definition

> **A module is a JavaScript file that can keep its own code organized and can share selected values with other files.**

---

# 2. Why Do We Need Modules?

Imagine putting an entire application into one file:

```text
app.js
│
├── User code
├── Authentication
├── Products
├── Cart
├── Payment
├── Database
├── API
└── 10,000+ lines
```

This becomes difficult to understand and maintain.

Instead:

```text
user.js
auth.js
product.js
cart.js
payment.js
database.js
```

Now each file has a smaller responsibility.

### Benefits

* **Organization** — code is separated into logical files.
* **Reusability** — functions can be reused in different files.
* **Maintainability** — smaller files are easier to modify.
* **Encapsulation** — not everything needs to be exposed.
* **Debugging** — easier to find where a problem exists.
* **Scalability** — useful as applications become larger.

---

# 3. The Basic Module Idea

There are two important actions:

```text
export
   ↓
Share something from a module

import
   ↓
Use something from another module
```

Example:

```text
math.js
   │
   │ export
   ↓
add()
   │
   │ import
   ↓
app.js
   │
   ↓
add(10, 20)
```

---

# 4. Your First Module

Create two files:

```text
project/
│
├── math.js
└── app.js
```

### `math.js`

```js
export function add(a, b) {
  return a + b;
}
```

Here:

```js
export
```

means:

> Make `add` available to another module.

---

### `app.js`

```js
import { add } from "./math.js";

console.log(add(10, 20));
```

Output:

```text
30
```

The flow is:

```text
math.js
   ↓
add()
   ↓
export
   ↓
app.js
   ↓
import
   ↓
add(10, 20)
   ↓
30
```

---

# 5. `export`

`export` makes a value available outside its module.

You can export:

### Variable

```js
export const PI = 3.14;
```

### Function

```js
export function greet() {
  console.log("Hello");
}
```

### Class

```js
export class User {
}
```

Think:

```text
Inside module
     ↓
export
     ↓
Available to other modules
```

---

# 6. `import`

`import` brings an exported value into another module.

Example:

### `utils.js`

```js
export function greet() {
  console.log("Hello");
}
```

### `app.js`

```js
import { greet } from "./utils.js";

greet();
```

Output:

```text
Hello
```

So:

```text
utils.js
   ↓
export greet
   ↓
app.js
   ↓
import greet
   ↓
greet()
```

---

# 7. Named Exports

A module can have **multiple named exports**.

Example:

```js
export const PI = 3.14;

export function add(a, b) {
  return a + b;
}

export function subtract(a, b) {
  return a - b;
}
```

Then:

```js
import {
  PI,
  add,
  subtract
} from "./math.js";
```

Use them:

```js
console.log(PI);

console.log(add(10, 5));

console.log(subtract(10, 5));
```

Output:

```text
3.14
15
5
```

### Remember

Named exports use:

```js
{ }
```

when importing.

```js
import { add } from "./math.js";
```

---

# 8. Default Export

A module can have **one default export**.

Example:

```js
export default function add(a, b) {
  return a + b;
}
```

Import it:

```js
import add from "./math.js";
```

Notice:

```text
Named Export
     ↓
{ add }

Default Export
     ↓
add
```

### Named

```js
export function add() {}
```

```js
import { add } from "./math.js";
```

### Default

```js
export default function add() {}
```

```js
import add from "./math.js";
```

---

# 9. Import Everything

You can import all named exports as one object.

```js
import * as MathUtils from "./math.js";
```

Now:

```js
console.log(MathUtils.PI);

console.log(MathUtils.add(10, 20));

console.log(MathUtils.subtract(20, 10));
```

Think:

```text
MathUtils
   │
   ├── PI
   ├── add()
   └── subtract()
```

---

# 10. Renaming an Import

You can give an imported value another local name.

Suppose:

```js
export function add(a, b) {
  return a + b;
}
```

Import:

```js
import { add as sum } from "./math.js";
```

Now use:

```js
console.log(sum(10, 20));
```

The original export is still:

```text
add
```

but inside this file we call it:

```text
sum
```

---

# 11. Module Scope

Modules have their own scope.

Example:

### `math.js`

```js
const secret = 100;

export const value = 20;
```

Another file cannot directly do:

```js
console.log(secret);
```

because `secret` was not exported.

But this can be imported:

```js
import { value } from "./math.js";
```

Think:

```text
math.js

┌─────────────────────┐
│ secret = 100        │
│                     │
│ value = 20          │
└─────────────────────┘
          │
          │ export
          ↓
        value
```

### Simple rule

```text
Not exported
     ↓
Available only inside module

Exported
     ↓
Can be imported by another module
```

---

# 12. What You Must Know From Part 1

Before moving to Part 2, you should understand these:

```text
Module
  ↓
JavaScript file

export
  ↓
Share code

import
  ↓
Use exported code

Named Export
  ↓
export function add()
  ↓
import { add }

Default Export
  ↓
export default add
  ↓
import add

Module Scope
  ↓
Module has its own scope
```

### Core syntax to remember

```js
// Export
export const name = "Om";

export function greet() {
  console.log("Hello");
}
```

```js
// Import
import { name, greet } from "./user.js";
```

And:

```js
// Default
export default function add(a, b) {
  return a + b;
}
```

```js
// Default import
import add from "./math.js";
```
# Part 2 — Internal Working & Understanding

## 1. How Modules Connect

Suppose we have two files:

```text
math.js
app.js
```

### `math.js`

```js
export function add(a, b) {
  return a + b;
}
```

### `app.js`

```js
import { add } from "./math.js";

console.log(add(10, 20));
```

The connection is:

```text
math.js
   │
   │ export add
   ↓
Module System
   │
   │ import add
   ↓
app.js
   │
   ↓
add(10, 20)
```

The important idea is:

> **`export` makes something available from a module, and `import` connects that exported value to another module.**

---

# 2. Module Scope

Each ES module has its **own scope**.

Example:

```js
// math.js

const secret = 100;

export const number = 20;
```

`secret` belongs to `math.js`.

Another file cannot directly access it:

```js
// app.js

console.log(secret);
```

This will fail because `secret` isn't available in `app.js`.

But this works:

```js
import { number } from "./math.js";

console.log(number);
```

Think:

```text
math.js
┌─────────────────────┐
│ secret = 100        │ ← private
│ number = 20         │ ← exported
└─────────────────────┘
           │
           ↓
        app.js
           │
           ↓
        number
```

### Rule

```text
Not exported
     ↓
Module-only

Exported
     ↓
Can be imported
```

---

# 3. Why `./` Is Important

When importing your own local file:

```js
import { add } from "./math.js";
```

The:

```text
./
```

means:

```text
current directory
```

So:

```text
./math.js
```

means:

```text
Current folder
      ↓
  math.js
```

For example:

```text
project/
│
├── app.js
└── math.js
```

Inside `app.js`:

```js
import { add } from "./math.js";
```

---

# 4. Local Module vs Package

This distinction becomes very important when you start React and Node.js.

### Local file

```js
import { add } from "./math.js";
```

### Package

```js
import express from "express";
```

Think:

```text
./math.js
    ↓
Your project file

express
    ↓
Installed package
```

---

# 5. Named Export Working

Suppose:

```js
// math.js

export const PI = 3.14;

export function add(a, b) {
  return a + b;
}

export function subtract(a, b) {
  return a - b;
}
```

The module has multiple named exports:

```text
math.js
│
├── PI
├── add
└── subtract
```

You can select exactly what you need:

```js
import { add } from "./math.js";
```

or:

```js
import { add, subtract } from "./math.js";
```

or:

```js
import { PI, add, subtract } from "./math.js";
```

---

# 6. Default Export Working

A default export represents the **main/default value** a module exposes.

Example:

```js
// math.js

export default function add(a, b) {
  return a + b;
}
```

Import:

```js
import add from "./math.js";
```

Notice:

```text
Named Export
    ↓
{ add }

Default Export
    ↓
add
```

The braces are the easiest way to distinguish them.

---

# 7. Named and Default Together

A module can have named exports and a default export together.

```js
// math.js

export const PI = 3.14;

export function subtract(a, b) {
  return a - b;
}

export default function add(a, b) {
  return a + b;
}
```

Then:

```js
import add, {
  PI,
  subtract
} from "./math.js";
```

Think:

```text
math.js
│
├── default → add
├── PI
└── subtract
```

---

# 8. Importing Everything

Suppose:

```js
// math.js

export const PI = 3.14;

export function add(a, b) {
  return a + b;
}

export function subtract(a, b) {
  return a - b;
}
```

You can write:

```js
import * as MathUtils from "./math.js";
```

Now:

```js
MathUtils.PI;

MathUtils.add(10, 5);

MathUtils.subtract(10, 5);
```

Think:

```text
MathUtils
│
├── PI
├── add()
└── subtract()
```

It gives you a namespace-like object for the module's named exports.

---

# 9. Renaming an Import

Suppose the module exports:

```js
export function add(a, b) {
  return a + b;
}
```

You can rename it locally:

```js
import { add as sum } from "./math.js";
```

Now:

```js
sum(10, 20);
```

The exported name remains:

```text
add
```

Your local name is:

```text
sum
```

Visual:

```text
math.js

add
 ↓
export
 ↓
import { add as sum }
 ↓
sum
```

---

# 10. Static Imports

Normal imports are written directly in the module:

```js
import { add } from "./math.js";
```

This is a **static import**.

The dependency is known from the module's code.

For your current learning level, remember:

```text
Normal import
      ↓
Static import
```

---

# 11. Dynamic Imports

JavaScript also allows importing a module when the code needs it.

```js
const math = await import("./math.js");
```

Then:

```js
console.log(math.add(10, 20));
```

Unlike normal `import`, dynamic import returns a **Promise**.

Conceptually:

```text
Code starts
    ↓
Need module?
    ↓
import("./math.js")
    ↓
Module loads
    ↓
Promise resolves
    ↓
Use module
```

Example:

```js
const math = await import("./math.js");

console.log(math.add(10, 20));
```

---

# 12. Why Dynamic Imports Are Useful

Dynamic imports are useful when something isn't needed immediately.

For example:

```text
Application starts
       ↓
Only main code loads
       ↓
User opens feature
       ↓
Feature module loads
```

This can help with:

* Lazy loading
* Code splitting
* Loading optional functionality

You will see this idea again in **React**.

---

# 13. Browser Modules

In the browser, an ES module is loaded using:

```html
<script
  type="module"
  src="app.js">
</script>
```

Then:

```js
// app.js

import { add } from "./math.js";

console.log(add(10, 20));
```

The important part is:

```html
type="module"
```

Without it, the browser doesn't treat the script as an ES module.

---

# 14. Node.js and ES Modules

Modern Node.js supports ES Modules.

A common configuration is:

```json
{
  "type": "module"
}
```

inside `package.json`.

Then you can write:

```js
import fs from "fs";
```

instead of only using CommonJS:

```js
const fs = require("fs");
```

---

# 15. ES Modules vs CommonJS

The basic difference:

```text
ES Modules
    ↓
import
export
```

CommonJS:

```text
CommonJS
    ↓
require()
module.exports
```

Example:

### ES Modules

```js
import { add } from "./math.js";
```

### CommonJS

```js
const { add } = require("./math");
```

For your modern JavaScript foundation, **focus mainly on ES Modules**.

You should understand CommonJS because you'll encounter it in Node.js projects and older codebases.

---

# 16. Module Scope vs Global Scope

Without modules, developers historically had problems with global variables.

For example:

```js
var total = 100;
```

Global variables could accidentally conflict with other code.

Modules help isolate code:

```text
math.js
   ↓
its own module scope

user.js
   ↓
its own module scope

auth.js
   ↓
its own module scope
```

This makes large applications easier to organize.

---

# 17. Mental Model

Remember modules using this simple model:

```text
┌─────────────────────┐
│      math.js        │
│                     │
│  add()              │
│  subtract()         │
│  secret             │
└─────────┬───────────┘
          │
          │ export
          ↓
    Module System
          │
          │ import
          ↓
┌─────────────────────┐
│       app.js        │
│                     │
│  add()              │
└─────────────────────┘
```

`secret` stays inside `math.js`.

Only exported values can be imported.

---

# Part 2 — What You Should Be Able to Explain

Before moving to **Part 3 — Hands-on Practice**, make sure you can explain:

```text
1. What is module scope?

2. How do export and import connect files?

3. Why do we use "./" for local files?

4. Difference between named and default exports?

5. What does "import * as" do?

6. How can an import be renamed?

7. What is a static import?

8. What is a dynamic import?

9. Why are browser modules loaded with type="module"?

10. Basic difference between ES Modules and CommonJS?
```

### The key mental model

```text
Module
   ↓
Own scope
   ↓
export
   ↓
Module System
   ↓
import
   ↓
Another module
```
# Part 2 — Internal Working & Understanding

## 1. How Modules Connect

Suppose we have two files:

```text
math.js
app.js
```

### `math.js`

```js
export function add(a, b) {
  return a + b;
}
```

### `app.js`

```js
import { add } from "./math.js";

console.log(add(10, 20));
```

The connection is:

```text
math.js
   │
   │ export add
   ↓
Module System
   │
   │ import add
   ↓
app.js
   │
   ↓
add(10, 20)
```

The important idea is:

> **`export` makes something available from a module, and `import` connects that exported value to another module.**

---

# 2. Module Scope

Each ES module has its **own scope**.

Example:

```js
// math.js

const secret = 100;

export const number = 20;
```

`secret` belongs to `math.js`.

Another file cannot directly access it:

```js
// app.js

console.log(secret);
```

This will fail because `secret` isn't available in `app.js`.

But this works:

```js
import { number } from "./math.js";

console.log(number);
```

Think:

```text
math.js
┌─────────────────────┐
│ secret = 100        │ ← private
│ number = 20         │ ← exported
└─────────────────────┘
           │
           ↓
        app.js
           │
           ↓
        number
```

### Rule

```text
Not exported
     ↓
Module-only

Exported
     ↓
Can be imported
```

---

# 3. Why `./` Is Important

When importing your own local file:

```js
import { add } from "./math.js";
```

The:

```text
./
```

means:

```text
current directory
```

So:

```text
./math.js
```

means:

```text
Current folder
      ↓
  math.js
```

For example:

```text
project/
│
├── app.js
└── math.js
```

Inside `app.js`:

```js
import { add } from "./math.js";
```

---

# 4. Local Module vs Package

This distinction becomes very important when you start React and Node.js.

### Local file

```js
import { add } from "./math.js";
```

### Package

```js
import express from "express";
```

Think:

```text
./math.js
    ↓
Your project file

express
    ↓
Installed package
```

---

# 5. Named Export Working

Suppose:

```js
// math.js

export const PI = 3.14;

export function add(a, b) {
  return a + b;
}

export function subtract(a, b) {
  return a - b;
}
```

The module has multiple named exports:

```text
math.js
│
├── PI
├── add
└── subtract
```

You can select exactly what you need:

```js
import { add } from "./math.js";
```

or:

```js
import { add, subtract } from "./math.js";
```

or:

```js
import { PI, add, subtract } from "./math.js";
```

---

# 6. Default Export Working

A default export represents the **main/default value** a module exposes.

Example:

```js
// math.js

export default function add(a, b) {
  return a + b;
}
```

Import:

```js
import add from "./math.js";
```

Notice:

```text
Named Export
    ↓
{ add }

Default Export
    ↓
add
```

The braces are the easiest way to distinguish them.

---

# 7. Named and Default Together

A module can have named exports and a default export together.

```js
// math.js

export const PI = 3.14;

export function subtract(a, b) {
  return a - b;
}

export default function add(a, b) {
  return a + b;
}
```

Then:

```js
import add, {
  PI,
  subtract
} from "./math.js";
```

Think:

```text
math.js
│
├── default → add
├── PI
└── subtract
```

---

# 8. Importing Everything

Suppose:

```js
// math.js

export const PI = 3.14;

export function add(a, b) {
  return a + b;
}

export function subtract(a, b) {
  return a - b;
}
```

You can write:

```js
import * as MathUtils from "./math.js";
```

Now:

```js
MathUtils.PI;

MathUtils.add(10, 5);

MathUtils.subtract(10, 5);
```

Think:

```text
MathUtils
│
├── PI
├── add()
└── subtract()
```

It gives you a namespace-like object for the module's named exports.

---

# 9. Renaming an Import

Suppose the module exports:

```js
export function add(a, b) {
  return a + b;
}
```

You can rename it locally:

```js
import { add as sum } from "./math.js";
```

Now:

```js
sum(10, 20);
```

The exported name remains:

```text
add
```

Your local name is:

```text
sum
```

Visual:

```text
math.js

add
 ↓
export
 ↓
import { add as sum }
 ↓
sum
```

---

# 10. Static Imports

Normal imports are written directly in the module:

```js
import { add } from "./math.js";
```

This is a **static import**.

The dependency is known from the module's code.

For your current learning level, remember:

```text
Normal import
      ↓
Static import
```

---

# 11. Dynamic Imports

JavaScript also allows importing a module when the code needs it.

```js
const math = await import("./math.js");
```

Then:

```js
console.log(math.add(10, 20));
```

Unlike normal `import`, dynamic import returns a **Promise**.

Conceptually:

```text
Code starts
    ↓
Need module?
    ↓
import("./math.js")
    ↓
Module loads
    ↓
Promise resolves
    ↓
Use module
```

Example:

```js
const math = await import("./math.js");

console.log(math.add(10, 20));
```

---

# 12. Why Dynamic Imports Are Useful

Dynamic imports are useful when something isn't needed immediately.

For example:

```text
Application starts
       ↓
Only main code loads
       ↓
User opens feature
       ↓
Feature module loads
```

This can help with:

* Lazy loading
* Code splitting
* Loading optional functionality

You will see this idea again in **React**.

---

# 13. Browser Modules

In the browser, an ES module is loaded using:

```html
<script
  type="module"
  src="app.js">
</script>
```

Then:

```js
// app.js

import { add } from "./math.js";

console.log(add(10, 20));
```

The important part is:

```html
type="module"
```

Without it, the browser doesn't treat the script as an ES module.

---

# 14. Node.js and ES Modules

Modern Node.js supports ES Modules.

A common configuration is:

```json
{
  "type": "module"
}
```

inside `package.json`.

Then you can write:

```js
import fs from "fs";
```

instead of only using CommonJS:

```js
const fs = require("fs");
```

---

# 15. ES Modules vs CommonJS

The basic difference:

```text
ES Modules
    ↓
import
export
```

CommonJS:

```text
CommonJS
    ↓
require()
module.exports
```

Example:

### ES Modules

```js
import { add } from "./math.js";
```

### CommonJS

```js
const { add } = require("./math");
```

For your modern JavaScript foundation, **focus mainly on ES Modules**.

You should understand CommonJS because you'll encounter it in Node.js projects and older codebases.

---

# 16. Module Scope vs Global Scope

Without modules, developers historically had problems with global variables.

For example:

```js
var total = 100;
```

Global variables could accidentally conflict with other code.

Modules help isolate code:

```text
math.js
   ↓
its own module scope

user.js
   ↓
its own module scope

auth.js
   ↓
its own module scope
```

This makes large applications easier to organize.

---

# 17. Mental Model

Remember modules using this simple model:

```text
┌─────────────────────┐
│      math.js        │
│                     │
│  add()              │
│  subtract()         │
│  secret             │
└─────────┬───────────┘
          │
          │ export
          ↓
    Module System
          │
          │ import
          ↓
┌─────────────────────┐
│       app.js        │
│                     │
│  add()              │
└─────────────────────┘
```

`secret` stays inside `math.js`.

Only exported values can be imported.

---

# Part 2 — What You Should Be Able to Explain

Before moving to **Part 3 — Hands-on Practice**, make sure you can explain:

```text
1. What is module scope?

2. How do export and import connect files?

3. Why do we use "./" for local files?

4. Difference between named and default exports?

5. What does "import * as" do?

6. How can an import be renamed?

7. What is a static import?

8. What is a dynamic import?

9. Why are browser modules loaded with type="module"?

10. Basic difference between ES Modules and CommonJS?
```

### The key mental model

```text
Module
   ↓
Own scope
   ↓
export
   ↓
Module System
   ↓
import
   ↓
Another module
```
# Part 4 — Interview, Revision & Real-World Usage

> **Goal:** You do **not** need deep internal engine theory here. This part should make Modules strong enough for **React, TypeScript, Node.js, Express, and interviews**.

---

# 1. Modules in Real Projects

A real project normally has many modules:

```text
src/
│
├── components/
│   ├── Navbar.js
│   └── Card.js
│
├── utils/
│   ├── formatDate.js
│   └── calculatePrice.js
│
├── services/
│   └── api.js
│
├── config/
│   └── config.js
│
└── App.js
```

Each file has a responsibility.

For example:

```js
// calculatePrice.js

export function calculatePrice(price, tax) {
  return price + tax;
}
```

Then:

```js
// App.js

import { calculatePrice } from "./utils/calculatePrice.js";
```

This is the same concept you practiced earlier.

---

# 2. React Usage

Modules are everywhere in React.

### Component Export

```jsx
export default function Card() {
  return <h1>Product Card</h1>;
}
```

Import:

```jsx
import Card from "./Card";
```

---

### Named Export

```jsx
export function Button() {
  return <button>Click</button>;
}
```

Import:

```jsx
import { Button } from "./Button";
```

---

### Multiple Components

```jsx
export function Header() {
  return <h1>Header</h1>;
}

export function Footer() {
  return <footer>Footer</footer>;
}
```

Import:

```jsx
import { Header, Footer } from "./Layout";
```

### React mental model

```text
Component
    ↓
export
    ↓
Another component
    ↓
import
    ↓
Use component
```

---

# 3. Node.js / Express Usage

Modules are also fundamental in backend applications.

Example:

```text
server/
│
├── server.js
├── routes/
│   └── userRoutes.js
├── controllers/
│   └── userController.js
└── utils/
    └── validation.js
```

### Controller

```js
export function getUsers(req, res) {
  res.json({
    message: "Users",
  });
}
```

### Route

```js
import { getUsers } from "../controllers/userController.js";
```

The same `export` / `import` concept is being used.

---

# 4. TypeScript Connection

When you move to TypeScript, modules will feel almost identical.

JavaScript:

```js
export function add(a, b) {
  return a + b;
}
```

TypeScript:

```ts
export function add(a: number, b: number): number {
  return a + b;
}
```

Import remains almost the same:

```ts
import { add } from "./math";
```

So learning JavaScript modules properly now makes TypeScript easier later.

---

# 5. Common Mistakes

## Mistake 1 — Named vs Default

This is wrong:

```js
// math.js

export function add(a, b) {
  return a + b;
}
```

```js
import add from "./math.js";
```

Because `add` is a **named export**.

Correct:

```js
import { add } from "./math.js";
```

---

## Mistake 2 — Adding Braces to Default Import

```js
export default function greet() {}
```

Wrong:

```js
import { greet } from "./greet.js";
```

Correct:

```js
import greet from "./greet.js";
```

---

## Mistake 3 — Forgetting `./`

Wrong:

```js
import { add } from "math.js";
```

For a local file:

```js
import { add } from "./math.js";
```

---

## Mistake 4 — Importing Something That Wasn't Exported

```js
// math.js

const secret = 100;
```

Then:

```js
import { secret } from "./math.js";
```

This doesn't work because `secret` wasn't exported.

---

## Mistake 5 — Wrong Export Name

```js
export function calculate() {}
```

Wrong:

```js
import { calculatePrice } from "./math.js";
```

The names don't match.

You can rename intentionally:

```js
import { calculate as calculatePrice } from "./math.js";
```

---

# 6. Named vs Default — Memorize This

| Named Export             | Default Export                  |
| ------------------------ | ------------------------------- |
| Can have multiple        | One default per module          |
| Uses `{}` when importing | No `{}`                         |
| Name normally matters    | Local import name can be chosen |
| `export function add()`  | `export default function add()` |
| `import { add }`         | `import add`                    |

### Quick memory trick

```text
Named
  ↓
{ }

Default
  ↓
No { }
```

---

# 7. Interview Questions

### Q1. What is a JavaScript module?

A JavaScript file with its own scope that can export and import code.

---

### Q2. Why do we use modules?

To:

* Organize code
* Reuse code
* Maintain large applications
* Avoid unnecessary global variables
* Separate responsibilities

---

### Q3. What is `export`?

`export` makes a value available to other modules.

```js
export const name = "Om";
```

---

### Q4. What is `import`?

`import` allows another module to use an exported value.

```js
import { name } from "./user.js";
```

---

### Q5. Named vs Default Export?

```js
// Named
export function add() {}

import { add } from "./math.js";
```

```js
// Default
export default function add() {}

import add from "./math.js";
```

---

### Q6. Can a module have multiple named exports?

Yes.

```js
export const a = 10;
export const b = 20;
export function test() {}
```

---

### Q7. Can a module have multiple default exports?

No.

A module can have only one default export.

---

### Q8. What does `import * as Utils` mean?

It imports the module's named exports under one namespace.

```js
import * as Utils from "./utils.js";

Utils.add();
Utils.subtract();
```

---

### Q9. What is module scope?

Variables declared inside a module belong to that module unless they are exported.

---

### Q10. What is dynamic import?

A module can be loaded when needed:

```js
const module = await import("./math.js");
```

It is useful for things such as lazy loading and code splitting.

---

### Q11. ES Modules vs CommonJS?

```text
ES Modules
import
export
```

```text
CommonJS
require()
module.exports
```

For modern frontend and full-stack JavaScript, **ES Modules are the important system to know well**.

---

# 8. Final Revision Map

You should now have this mental map:

```text
                    MODULES
                       │
        ┌──────────────┼──────────────┐
        ↓              ↓              ↓
      export         import        scope
        │              │
        │              │
   ┌────┴────┐    ┌────┴────┐
   ↓         ↓    ↓         ↓
 named    default named    default
   │         │      │         │
   ↓         ↓      ↓         ↓
 export    export  { }      no { }
```

---

# 9. The Most Important Syntax

### Named

```js
// math.js
export function add(a, b) {
  return a + b;
}
```

```js
// app.js
import { add } from "./math.js";
```

### Default

```js
// math.js
export default function add(a, b) {
  return a + b;
}
```

```js
// app.js
import add from "./math.js";
```

### Rename

```js
import { add as sum } from "./math.js";
```

### Everything

```js
import * as MathUtils from "./math.js";
```

### Dynamic

```js
const MathUtils = await import("./math.js");
```

---

# 10. Final Test — Do This Without Notes

Create:

```text
modules-practice/
│
├── math.js
├── user.js
├── app.js
└── index.html
```

Implement:

### `math.js`

Export:

```text
add()
subtract()
multiply()
```

as named exports.

### `user.js`

Create a default exported function:

```text
createUser(name, age)
```

### `app.js`

Import both modules and produce:

```js
const user = createUser("Om", 22);

console.log(user);
console.log(add(10, 20));
console.log(subtract(20, 5));
console.log(multiply(5, 4));
```

Expected:

```text
{
  name: "Om",
  age: 22
}

30
15
20
```

If you can build this **without looking at the notes**, Modules are sufficiently learned for your JavaScript foundation.

---

# ✅ Module Topic Complete

Your learning flow is now:

```text
Part 1
Introduction & Fundamentals
        ↓
Part 2
Internal Working & Understanding
        ↓
Part 3
Hands-on Practice
        ↓
Part 4
Real-world + Interview + Revision
        ↓
MODULES ✅
```

### Before React / TypeScript / Node.js

You should be comfortable with:

```text
export
import
named export
default export
renaming
import *
module scope
dynamic import
ES Modules vs CommonJS
```
