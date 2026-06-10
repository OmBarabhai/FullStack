# React - A JavaScript Library for Building User Interfaces

## 📚 Overview

React is a **component-based JavaScript library** for building interactive, dynamic user interfaces. This module covers React fundamentals and modern practices with hooks.

---

## 🎯 **Key Concepts**

- ✅ Components (Functional & Class)
- ✅ JSX (JavaScript XML)
- ✅ Props and State
- ✅ Hooks (useState, useEffect, useContext)
- ✅ Component Lifecycle
- ✅ Event Handling
- ✅ Forms and Validation
- ✅ List Rendering

---

## 📂 **Module Structure**

```
React/
├── README.md
├── Notes/
│   ├── ReadmeNote/
│   │   ├── 0.Introduction.md
│   │   ├── Day_1.md
│   │   └── Day_2.md
│   └── Day_1/
│       └── Images/
├── Basics/
│   ├── README.md
│   ├── src/
│   │   ├── App.jsx
│   │   ├── components/
│   │   └── assets/
│   ├── package.json
│   └── vite.config.js
└── Projects/
    └── [React projects]
```

---

## 🚀 **Core Topics**

### **1. Components**

```javascript
// Functional Component
function Welcome(props) {
  return <h1>Hello, {props.name}</h1>;
}

// ES6 Arrow Function
const Welcome = (props) => <h1>Hello, {props.name}</h1>;
```

### **2. JSX**

```javascript
const element = (
  <div>
    <h1>Title</h1>
    <p>Description</p>
  </div>
);
```

### **3. State & Props**

```javascript
// Props (read-only)
function Greeting({ name }) {
  return <h1>Hello, {name}!</h1>;
}

// State
function Counter() {
  const [count, setCount] = useState(0);
  return (
    <div>
      <p>Count: {count}</p>
      <button onClick={() => setCount(count + 1)}>Increment</button>
    </div>
  );
}
```

### **4. Hooks**

```javascript
// useState
const [state, setState] = useState(initialValue);

// useEffect
useEffect(() => {
  // Side effects here
  return () => {
    // Cleanup
  };
}, [dependencies]);

// useContext
const value = useContext(MyContext);
```

---

## 📊 **Learning Path**

1. **Understand Components** - Building blocks of React
2. **Learn JSX** - JavaScript + XML syntax
3. **Master State & Props** - Data management
4. **Explore Hooks** - Modern React patterns
5. **Build Projects** - Apply knowledge

---

## 🎨 **Projects Included**

- Counter Component
- Todo List
- Component Lifecycle Demo
- Hook Examples

---

## 🔗 **Setup**

```bash
# Create new React app with Vite
npm create vite@latest my-app -- --template react
cd my-app
npm install
npm run dev
```

---

## 📚 **Resources**

- [React Official Docs](https://react.dev)
- [React Hooks Documentation](https://react.dev/reference/react)

---

**Ready to build dynamic interfaces with React? Let's start! 🚀**

_React is the industry-standard framework for modern web development!_
