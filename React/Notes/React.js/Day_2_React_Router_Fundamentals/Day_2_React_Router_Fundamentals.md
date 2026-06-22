# Day 2 - React Router Fundamentals

> Goal: Understand routing visually, code it confidently, and explain it in interviews.

---

# Topics Covered

1. Why Router?
2. BrowserRouter
3. Routes
4. Route
5. Link
6. Dynamic Routing
7. useParams()
8. What to remember for interview

---

# 1. Why Router?

Without Router:

- Full page reload
- Slow navigation
- State gets reset

With Router:

- Fast navigation
- No reload
- SPA behavior

Think:

```text
Router = Traffic Controller of Pages
```

---

# Routing Flow

![React Router Flow](./Images/RoutesProject_1.png)

Understand this:

```text
BrowserRouter
   ↓
Routes
   ↓
Route
   ↓
Link
   ↓
Component Render
```

This is the complete routing system.

---

# 2. BrowserRouter

Main wrapper for routing.

```jsx
<BrowserRouter>...</BrowserRouter>
```

Job:

- Watches URL
- Manages browser history

Interview line:

> BrowserRouter wraps the app and enables routing in React.

---

# 3. Routes

Container for all routes.

```jsx
<Routes>
  <Route path="/" element={<Home />} />
  <Route path="/products" element={<Products />} />
</Routes>
```

Interview line:

> Routes decides which Route should render.

---

# 4. Route

Maps URL to component.

```jsx
<Route path="/" element={<Home />} />
<Route path="/products" element={<Products />} />
<Route path="/products/:category" element={<Products />} />
```

Examples:

```text
/ → Home
/products → Products
/products/laptop → Products
```

Interview line:

> Route connects a path with a React component.

---

# 5. Link

Used for navigation without page reload.

```jsx
<Link to="/products">Go To Products</Link>
<Link to="/">Go To Home</Link>
```

Why?

Normal anchor tag reloads the page.
`Link` keeps React SPA behavior.

Interview line:

> Link changes route without refreshing the page.

---

# Home Page Code

```jsx
import { Link } from "react-router-dom";

function Home() {
  return (
    <>
      <h1>Hello, Welcome Home</h1>

      <Link to="/products">Go To Products</Link>
    </>
  );
}

export default Home;
```

What to know from this code:

- `Link` comes from `react-router-dom`
- `to="/products"` means go to products page
- Home page should not reload when clicked

---

# Products Page Code

```jsx
import { Link, useParams } from "react-router-dom";

function Products() {
  const params = useParams();

  return (
    <>
      <h1>
        Hello, Welcome To Products
        {params.category && ` - ${params.category}`}
      </h1>

      <Link to="/">Go To Home</Link>

      <br />

      <Link to="/products/mobile">Mobile</Link>
      <br />

      <Link to="/products/laptop">Laptop</Link>
      <br />

      <Link to="/products/tvs">TVs</Link>
    </>
  );
}

export default Products;
```

What to know from this code:

- `useParams()` reads dynamic value from URL
- `params.category` gives route value
- `Link to="/products/mobile"` opens the same page with different category
- One component can handle many URLs

---

# Main Routing Setup

```jsx
import React from "react";
import ReactDOM from "react-dom/client";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Home from "./pages/Home";
import Products from "./pages/Products";

ReactDOM.createRoot(document.getElementById("root")).render(
  <React.StrictMode>
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/products" element={<Products />} />
        <Route path="/products/:category" element={<Products />} />
      </Routes>
    </BrowserRouter>
  </React.StrictMode>,
);
```

What to know from this code:

- `main.jsx` is the routing entry setup
- `BrowserRouter` must wrap the app
- `Routes` contains all route paths
- `Route` maps URL to component
- `:category` is a dynamic param

---

# 6. Dynamic Routing

Dynamic route:

```text
/products/:category
```

Examples:

```text
/products/mobile
/products/laptop
/products/tvs
```

All use the same component.

Think:

```text
Same page
Different data
```

Interview line:

> Dynamic routing allows the same component to handle multiple URL values.

---

# 7. useParams()

Used to read dynamic values from URL.

Example:

```jsx
const params = useParams();
console.log(params);
```

If URL is:

```text
/products/laptop
```

Output:

```js
{
  category: "laptop";
}
```

Interview line:

> useParams extracts values from dynamic route paths.

---

# What You Must Know for Interview

You do not need to memorize every line.

You must know these points:

## BrowserRouter

- Wraps the app
- Enables routing
- Tracks browser history

## Routes

- Holds route definitions
- Decides which page to render

## Route

- Connects path and component
- Can be static or dynamic

## Link

- Used for navigation
- No page refresh

## Dynamic Route

- Uses `:param`
- One component can handle many URLs

## useParams

- Reads values from URL
- Used with dynamic routes

---

# What Happened in Your Project

Your project covered:

- Home page routing
- Products page routing
- Link-based navigation
- Dynamic route `/products/:category`
- URL parameter reading with `useParams()`

That is enough for Day 2.

---

# Quick Revision

```text
BrowserRouter → wraps app

Routes → route container

Route → path to component

Link → navigation without reload

:category → dynamic value in URL

useParams → read URL parameter
```

---

# Final Interview Answer

> React Router is used to handle client-side navigation in React without full page reload. BrowserRouter wraps the app, Routes contains route definitions, Route maps URL paths to components, Link is used for navigation, and useParams reads dynamic values from the URL. This allows React apps to behave like a single page application.

---

# End of Day 2

```

If you want, I can make the next file in the same style for **useNavigate, nested routes, and protected routes**.
```
