# JavaScript Modules (ES Modules)

> **"Modules allow you to split your JavaScript code into multiple reusable files. They improve maintainability, readability, scalability, and enable modern application development."**

---

# Table of Contents

1. What are Modules?
2. Why Were Modules Introduced?
3. Problems Before Modules
4. Module Basics
5. Export
6. Import
7. Named Exports
8. Default Exports
9. Importing Everything
10. Renaming Imports & Exports
11. Module Scope
12. ES Modules vs CommonJS
13. Dynamic Imports
14. Browser Modules
15. Node.js Modules
16. Real-world Examples
17. React Examples
18. Best Practices
19. Common Mistakes
20. Interview Questions
21. Coding Exercises
22. Summary

---

# 1. What are Modules?

A **module** is simply a JavaScript file.

Instead of writing everything inside one huge file,

```
app.js
```

we divide the project into multiple files.

Example

```
project/

├── app.js
├── math.js
├── user.js
├── auth.js
├── database.js
```

Each file has a specific responsibility.

---

# 2. Why Were Modules Introduced?

Imagine building Amazon.

Would all code exist inside one file?

```
amazon.js

↓

50,000 lines
```

Impossible to maintain.

Instead,

```
cart.js

product.js

payment.js

user.js

wishlist.js
```

Much easier.

Benefits

- Reusable code
- Easier debugging
- Better organization
- Team collaboration
- Faster development

---

# 3. Problems Before Modules

Before ES6,

developers used

- Global variables
- IIFE
- CommonJS
- AMD

Example

```js
var total = 100;
```

Any file could modify

```
total
```

Global namespace pollution.

Modules solve this.

---

# 4. Module Basics

A module exports something.

Another module imports it.

```
math.js

↓

exports add()

↓

app.js

↓

imports add()

↓

uses it
```

---

Example Structure

```
project/

math.js

app.js
```

---

math.js

```js
export function add(a, b) {
  return a + b;
}
```

app.js

```js
import { add } from "./math.js";

console.log(add(10, 20));
```

Output

```
30
```

---

# 5. Export

Export makes variables, functions, or classes available to other modules.

Example

```js
export const PI = 3.14;
```

---

Export Function

```js
export function greet() {
  console.log("Hello");
}
```

---

Export Class

```js
export class User {}
```

---

# 6. Import

Import brings exported values into another file.

```js
import { greet } from "./utils.js";

greet();
```

Output

```
Hello
```

---

# 7. Named Exports

Multiple exports.

math.js

```js
export const PI = 3.14;

export function add(a, b) {
  return a + b;
}

export function subtract(a, b) {
  return a - b;
}
```

Import

```js
import {
  PI,
  add,
  subtract,
} from "./math.js";
```

---

# 8. Default Exports

A module can have only **one default export**.

math.js

```js
export default function add(a, b) {
  return a + b;
}
```

Import

```js
import add from "./math.js";
```

Notice

No braces.

---

Default Export Class

```js
export default class User {}
```

Import

```js
import User from "./User.js";
```

---

# 9. Importing Everything

Instead of importing one by one,

```js
import * as MathUtils from "./math.js";

console.log(MathUtils.PI);

console.log(MathUtils.add(10, 20));
```

Output

```
3.14

30
```

---

# 10. Renaming Imports & Exports

Export

```js
export {
  add as sum,
};
```

Import

```js
import {
  sum,
} from "./math.js";
```

---

Rename During Import

```js
import {
  add as calculate,
} from "./math.js";

calculate(2, 3);
```

---

# 11. Module Scope

Variables inside modules are private.

math.js

```js
const secret = 100;
```

app.js

```js
console.log(secret);
```

Output

```
ReferenceError
```

Only exported values are visible.

Visualization

```
math.js

↓

secret

↓

Private

----------------

Export

↓

Public
```

---

# 12. ES Modules vs CommonJS

| ES Modules | CommonJS |
|------------|----------|
| import | require() |
| export | module.exports |
| Static | Dynamic |
| Browser + Node | Mainly Node.js |
| Modern | Older |

---

CommonJS Example

```js
const math =
require("./math");
```

ES Module

```js
import math from "./math.js";
```

---

# 13. Dynamic Imports

Modules can be loaded only when needed.

```js
const math =
await import("./math.js");

console.log(math.add(2, 3));
```

Useful for

- Lazy Loading
- Performance Optimization
- Code Splitting

---

# 14. Browser Modules

HTML

```html
<script
type="module"
src="app.js">
</script>
```

Without

```
type="module"
```

Imports won't work.

---

# 15. Node.js Modules

Modern Node.js supports ES Modules.

package.json

```json
{
  "type": "module"
}
```

Then

```js
import fs from "fs";
```

works.

---

Older Node.js

```js
const fs =
require("fs");
```

---

# 16. Real-world Examples

Project Structure

```
src/

components/

utils/

services/

hooks/

pages/

App.js
```

Each folder contains multiple modules.

---

Configuration

config.js

```js
export const PORT = 5000;
```

app.js

```js
import {
  PORT,
} from "./config.js";
```

---

# 17. React Examples

Component

```jsx
export default function Card() {
  return <h1>Card</h1>;
}
```

Import

```jsx
import Card from "./Card";
```

Named Export

```jsx
export function Button() {}
```

Import

```jsx
import {
  Button,
} from "./Button";
```

---

# 18. Best Practices

✅ One responsibility per module.

✅ Use Named Exports for utilities.

✅ Use Default Export for main components.

✅ Organize files logically.

✅ Avoid circular dependencies.

---

# 19. Common Mistakes

### Forgetting `./`

Wrong

```js
import add from "math.js";
```

Correct

```js
import add from "./math.js";
```

---

### Multiple Default Exports

Wrong

```js
export default A;

export default B;
```

Only one default export is allowed.

---

### Missing `type="module"`

Browser imports won't work.

---

### Forgetting `.js`

Modern browsers require

```js
"./math.js"
```

not

```js
"./math"
```

---

# 20. Interview Questions

## What is a JavaScript Module?

A JavaScript file with its own scope that can export and import code.

---

## Difference between Named and Default Export?

Named Export

```js
export function add(){}
```

Import

```js
import { add } from "./math.js";
```

Default Export

```js
export default add;
```

Import

```js
import add from "./math.js";
```

---

## Can one file have multiple named exports?

Yes.

---

## Can one file have multiple default exports?

No.

Only one.

---

## Why are Modules useful?

- Reusability
- Maintainability
- Scalability
- Encapsulation

---

## Difference between CommonJS and ES Modules?

CommonJS

```
require()

module.exports
```

ES Modules

```
import

export
```

---

# 21. Coding Exercises

### Exercise 1

Create

```
math.js
```

Export

```js
add()
```

Import it in

```
app.js
```

---

### Exercise 2

Create multiple named exports.

---

### Exercise 3

Create one default export.

---

### Exercise 4

Rename an imported function.

---

### Exercise 5

Import everything using

```js
*
```

---

# 22. Summary

- Modules split code into reusable files.
- Each module has its own scope.
- `export` shares values.
- `import` uses shared values.
- Named exports allow multiple exports.
- Default exports allow one primary export.
- ES Modules are the modern JavaScript standard.
- React, Node.js, Next.js, Express, Vue, Angular, and modern frameworks rely heavily on modules.

---

# What's Next?

➡️ **13-Array-Methods.md**

You'll learn:

- map()
- filter()
- reduce()
- find()
- findIndex()
- some()
- every()
- forEach()
- sort()
- flat()
- flatMap()
- Interview Questions
- Coding Exercises