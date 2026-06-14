# 🚀 Day 3 - React Native Tooling

> Goal: Understand how React Native code is transformed and executed using NPM, Metro, Babel, Hermes, and node_modules.

---

# 📚 Topics Covered

1. NPM
2. node_modules
3. Metro Bundler
4. Babel
5. Hermes Engine
6. Build Flow
7. Interview Questions
8. Quick Revision

---

# 1️⃣ NPM (Node Package Manager)

NPM is used to install and manage packages.

Example:

```bash
npm install axios
```

This downloads the package and adds it to the project.

---

## Real Life Analogy

Think of NPM as:

```text
App Developer
      ↓
NPM Store
      ↓
Download Library
```

Like downloading apps from Play Store.

---

# 2️⃣ node_modules

Location:

```text
node_modules/
```

Stores all installed packages.

Example:

```text
node_modules/
├── react
├── react-native
├── axios
└── many more...
```

---

## Important

Never manually edit:

```text
node_modules
```

Always use:

```bash
npm install
npm uninstall
```

---

# 3️⃣ Metro Bundler

Metro is React Native's bundler.

Responsibilities:

- Find files
- Resolve imports
- Bundle code
- Hot Reload

---

## Metro Flow

```text
App.js
   ↓
Metro
   ↓
Bundle
   ↓
Android / iOS
```

---

## Start Metro

```bash
npm start
```

or

```bash
npx react-native start
```

---

# 4️⃣ Babel

Babel converts modern JavaScript into compatible JavaScript.

---

## Example

Modern JS:

```js
const sum = (a, b) => a + b;
```

Babel converts it into code older engines can understand.

---

## Why Babel?

Allows us to use:

- Arrow Functions
- Async/Await
- JSX
- Modern JavaScript Features

---

# 5️⃣ Hermes Engine

Hermes is React Native's JavaScript Engine.

---

## Purpose

Runs JavaScript faster.

Benefits:

✅ Faster App Startup

✅ Better Performance

✅ Lower Memory Usage

---

## Enable Hermes

Android:

```properties
hermesEnabled=true
```

---

# 6️⃣ Complete React Native Flow

```text
Developer Code
        ↓
React Native
        ↓
Babel
        ↓
Metro Bundler
        ↓
Hermes Engine
        ↓
Android / iOS
```

---

# 7️⃣ Tool Responsibilities

| Tool         | Responsibility    |
| ------------ | ----------------- |
| NPM          | Install Packages  |
| node_modules | Store Packages    |
| Babel        | Convert Modern JS |
| Metro        | Bundle Code       |
| Hermes       | Execute JS        |

---

# 🎙️ Interview Questions

## What is NPM?

Package manager used to install libraries.

---

## What is node_modules?

Folder containing installed packages.

---

## What is Metro?

React Native's JavaScript bundler.

---

## What is Babel?

JavaScript transpiler that converts modern JS into compatible JS.

---

## What is Hermes?

Optimized JavaScript engine for React Native.

---

## Why do we need Metro?

To combine project files into a bundle that can run on mobile devices.

---

# ⚡ Quick Revision

```text
NPM
↓
Install Packages

node_modules
↓
Store Packages

Babel
↓
Convert Modern JS

Metro
↓
Bundle Code

Hermes
↓
Run JS Faster
```

---

# 📌 Important Keywords

- NPM
- node_modules
- Metro
- Babel
- Hermes
- Bundler
- Transpiler
- JavaScript Engine

---

# 🎯 30-Second Interview Answer

React Native uses several tools internally. NPM manages dependencies, node_modules stores installed packages, Babel converts modern JavaScript into compatible JavaScript, Metro bundles all project files, and Hermes executes JavaScript efficiently on mobile devices. Together they form the React Native build and execution pipeline.

---

# ✅ End of Day 3 Notes
