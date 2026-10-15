# 05 — Node.js Modules, CommonJS, ES Modules and npm

## 1. Why modules?

A **module** is a reusable unit of code with an interface for exposing selected values. Modules keep code organized and reduce duplication.

Node.js supports two main module systems: **CommonJS (CJS)** and **ECMAScript Modules (ESM)**.

## 2. CommonJS

**Export one value:**

```js
// greet.cjs
function greet(name) {
  return `Hello, ${name}`;
}
module.exports = greet;
```

```js
// app.cjs
const greet = require("./greet.cjs");
console.log(greet("Om"));
```

**Export multiple values:**

```js
// math.cjs
const add = (a, b) => a + b;
const subtract = (a, b) => a - b;
module.exports = { add, subtract };
```

```js
const { add, subtract } = require("./math.cjs");
```

### `module.exports` vs. `exports`

`exports` initially references `module.exports`.

```js
exports.add = (a, b) => a + b; // Works
exports = someFunction;        // Does not replace module.exports
module.exports = someFunction; // Replaces exported value
```

## 3. ES modules

```js
// math.js
export function add(a, b) {
  return a + b;
}
export default function subtract(a, b) {
  return a - b;
}
```

```js
import subtract, { add } from "./math.js";
```

| Named export | Default export |
|---|---|
| A module can have multiple | At most one per module |
| Import by exported name or alias | Import can choose a local name |
| `import { add } from "./math.js"` | `import subtract from "./math.js"` |

## 4. CJS vs. ESM configuration

| File/configuration | Meaning |
|---|---|
| `.cjs` | CommonJS |
| `.mjs` | ES module |
| `"type": "module"` in `package.json` | Treat `.js` files in that package scope as ESM |
| `require()` / `module.exports` | CommonJS syntax |
| `import` / `export` | ESM syntax |

In ESM, `__dirname` is not directly available. Use `import.meta.url` and URL/path utilities for module-relative paths.

## 5. Built-in, local and third-party modules

| Kind | Example |
|---|---|
| Built-in | `node:fs`, `node:path`, `node:http` |
| Local | `./math.js` |
| Third-party | `express` installed with npm |

## 6. `package.json` and npm

`package.json` contains project metadata and configuration, including scripts, dependency declarations, version and module type.

```bash
npm init -y
npm install express
npm install --save-dev nodemon
```

- `dependencies`: packages needed in normal application use.
- `devDependencies`: packages mainly used for development/testing.
- `scripts`: named commands run through npm.
- npm installs and manages packages and their dependency tree.

## Interview checks

**What does `require()` return?** The value exposed by a CommonJS module.

**Why does assigning to `exports` not replace the export?** `exports` is only an initial reference to `module.exports`; reassigning it does not update `module.exports`.

**What does `"type": "module"` do?** It makes `.js` files in the relevant package scope be treated as ESM.

**What is the difference between dependencies and devDependencies?** Runtime/application requirements vs. development/testing tools.

## Remember

CJS uses `require()` and `module.exports`; ESM uses `import` and `export`. Match syntax to the file's module format.
