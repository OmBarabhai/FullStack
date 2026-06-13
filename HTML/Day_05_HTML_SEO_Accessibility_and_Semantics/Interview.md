# 🌐 HTML Final Revision 

---

# 🧩 1. What is HTML?

👉 HTML (HyperText Markup Language) is used to create **structure of a webpage**

---

# 🧱 2. Basic Structure

```html
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Page</title>
</head>
<body>
  <h1>Hello</h1>
</body>
</html>
```

---

# 🧩 3. Elements & Attributes

👉 Element = tag + content
👉 Attribute = extra info

```html
<a href="https://google.com">Visit</a>
```

---

# 🔗 4. Important Tags

| Tag      | Use              |
| -------- | ---------------- |
| `<h1>`   | Heading          |
| `<p>`    | Paragraph        |
| `<a>`    | Link             |
| `<img>`  | Image            |
| `<div>`  | Block container  |
| `<span>` | Inline container |

---

# 🔗 5. Anchor Tag

```html
<a href="https://google.com" target="_blank">Open</a>
```

👉 Important:

* `href` → link
* `target="_blank"` → new tab
* `rel="noopener noreferrer"` → security

---

# 🖼️ 6. Image Tag

```html
<img src="img.png" alt="image">
```

👉 `alt` is **mandatory (SEO + accessibility)**

---

# 🎨 7. CSS Types

* Inline
* Internal
* External

```html
<p style="color:red">Text</p>
```

---

# 🧱 8. Inline vs Block

| Inline | Block |
| ------ | ----- |
| span   | div   |
| a      | p     |

👉 Block → full width
👉 Inline → only required space

---

# 🧾 9. Lists

```html
<ul><li>Item</li></ul>
<ol><li>Item</li></ol>
```

---

# 📊 10. Tables

```html
<table>
  <tr><th>Name</th></tr>
  <tr><td>Om</td></tr>
</table>
```

---

# 🧾 11. Forms (Important)

```html
<form>
  <input type="text" required>
  <button>Submit</button>
</form>
```

👉 Common types:

* text, email, password
* number, date, file

---

# 🎥 12. Media

```html
<img>
<audio>
<video>
<iframe>
```

---

# 🌐 13. Semantic HTML

```html
<header>
<nav>
<main>
<footer>
```

👉 Improves SEO + readability

---

# ♿ 14. Accessibility

```html
<img alt="profile">
<label for="email">Email</label>
```

👉 Helps screen readers

---

# 🔍 15. SEO Basics

```html
<meta name="description" content="...">
<meta name="viewport" content="width=device-width">
```

👉 Use proper headings + semantic tags

---

# 🧾 16. HTML Entities

```html
&lt;  &gt;  &amp;  &copy;
```

---

# 🔒 17. iFrame Security

```html
<iframe sandbox></iframe>
```

👉 Prevents attacks

---

# 💾 18. Storage (Basic)

```javascript
localStorage.setItem("name","Om");
```

---

# 🧠 Interview Must-Know

* HTML is structure, not programming
* Semantic tags improve SEO
* `alt` is important
* Forms send data to backend
* Block vs Inline → very common

---

# 🚀 Final Tip

👉 Don’t try to remember everything
👉 Understand **why we use it**

---

## 👨‍💻 Author

**OmBarabhai**
