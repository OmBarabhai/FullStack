# 🏗️ Day 5 - React Native Architecture

> Goal: Understand how React Native works internally.

---

# 📚 Topics Covered

1. Old Architecture
2. New Architecture
3. Bridge
4. JSI
5. Fabric
6. Turbo Modules
7. Yoga Engine
8. Threading Model
9. Render Pipeline
10. Interview Questions

---

````

---

# Diagram 1 - Old Architecture

```text
┌──────────────┐
│ JavaScript   │
│ React Native │
└──────┬───────┘
       │
       ▼
┌──────────────┐
│    Bridge    │
│ JSON Messages│
└──────┬───────┘
       │
       ▼
┌──────────────┐
│ Native Layer │
│ Android/iOS  │
└──────────────┘
````

---

# Problem With Old Architecture

```text
JS
 ↓
Convert to JSON
 ↓
Send through Bridge
 ↓
Native
 ↓
Convert Back
```

Problems:

❌ Slow

❌ Serialization Cost

❌ UI Lag

❌ Memory Overhead

---

# Diagram 2 - New Architecture

```text
┌──────────────┐
│ JavaScript   │
└──────┬───────┘
       │
       ▼
┌──────────────┐
│     JSI      │
│ Direct Access│
└──────┬───────┘
       │
       ▼
┌──────────────┐
│ C++ Layer    │
└──────┬───────┘
       │
       ▼
┌──────────────┐
│ Android/iOS  │
└──────────────┘
```

---

# Three Pillars

```text
New Architecture
        │
        │
 ┌──────┼──────┐
 │      │      │
 ▼      ▼      ▼
JSI   Fabric Turbo
             Modules
```

---

# 1️⃣ JSI

## Full Form

JavaScript Interface

---

## Purpose

Allows JavaScript to communicate directly with C++.

---

## Before

```text
JS
 ↓
Bridge
 ↓
Native
```

---

## After

```text
JS
 ↓
JSI
 ↓
Native
```

---

## Benefits

✅ Faster

✅ No JSON Serialization

✅ Direct Communication

---

# 2️⃣ Fabric

Fabric is the new UI Rendering System.

---

## Before

```text
JS
 ↓
Bridge
 ↓
UI Update
```

---

## After

```text
JS
 ↓
Fabric
 ↓
UI Update
```

---

## Benefits

✅ Faster Rendering

✅ Smooth UI

✅ Concurrent Rendering

---

# 3️⃣ Turbo Modules

Turbo Modules replace Native Modules.

---

## Old Way

```text
App Starts
 ↓
Load All Native Modules
```

---

## New Way

```text
App Starts
 ↓
Load Only Required Module
```

---

## Example

```text
Camera Module

Not Loaded
Until User Opens Camera
```

---

## Benefit

✅ Faster Startup

✅ Lower Memory Usage

---

# 4️⃣ Yoga Engine

Yoga calculates layout.

---

## Flow

```text
Flexbox
   ↓
Yoga
   ↓
Position Calculation
   ↓
Native Screen
```

---

## Example

```jsx
<View
 style={{
   flex:1,
   justifyContent:"center",
   alignItems:"center"
 }}
>
```

Yoga calculates:

```text
X Position
Y Position
Width
Height
```

---

# 5️⃣ Threading Model

React Native uses multiple threads.

---

## JS Thread

Runs:

```text
JavaScript
Business Logic
Hooks
API Calls
```

---

## UI Thread

Runs:

```text
Animations
Touch Events
Drawing
```

---

## Shadow Thread

Runs:

```text
Layout Calculations
Yoga Engine
```

---

# Thread Communication

```text
JS Thread
      │
      ▼
Shadow Thread
      │
      ▼
UI Thread
```

---

# 6️⃣ Render Pipeline

Most Important Interview Question

---

```text
JSX
 ↓
Fiber Tree
 ↓
JSI
 ↓
Shadow Tree
 ↓
Yoga
 ↓
Fabric
 ↓
UI Thread
 ↓
Screen
```

---

# Easy Real Life Analogy

```text
React Developer
      ↓
Architect

Fiber Tree
      ↓
Blueprint

Yoga
      ↓
Engineer

Fabric
      ↓
Construction Manager

UI Thread
      ↓
Workers Build House
```

---

# Old vs New Architecture

| Feature        | Old            | New           |
| -------------- | -------------- | ------------- |
| Communication  | Bridge         | JSI           |
| Rendering      | Legacy         | Fabric        |
| Native Modules | Native Modules | Turbo Modules |
| Performance    | Slower         | Faster        |
| Startup        | Slower         | Faster        |
| Memory Usage   | Higher         | Lower         |

---

# 🎙️ Interview Questions

## What is JSI?

JavaScript Interface allowing direct communication between JS and C++.

---

## Why was Bridge removed?

Bridge caused serialization overhead and performance bottlenecks.

---

## What is Fabric?

New React Native rendering engine.

---

## What are Turbo Modules?

Lazy-loaded native modules.

---

## What is Yoga?

Layout engine used to calculate Flexbox layouts.

---

## What are the main threads?

- JS Thread
- Shadow Thread
- UI Thread

---

# ⚡ Quick Revision

```text
JSI
 ↓
Direct Communication

Fabric
 ↓
Rendering

Turbo Modules
 ↓
Lazy Loading

Yoga
 ↓
Layout Engine

JS Thread
 ↓
Logic

UI Thread
 ↓
Drawing
```

---

# 🎯 30 Second Interview Answer

React Native's new architecture is built around JSI, Fabric, and Turbo Modules. JSI enables direct communication between JavaScript and native code without using the old bridge. Fabric improves rendering performance, Turbo Modules provide lazy loading of native modules, and Yoga calculates layouts using Flexbox. Together they make React Native applications faster, smoother, and more memory efficient.

---

# ✅ End of Day 5 Notes

This is probably the **most important React Native interview topic** in your entire playlist. If a fresher can explain the diagrams above confidently, they already know more React Native internals than most entry-level candidates.
