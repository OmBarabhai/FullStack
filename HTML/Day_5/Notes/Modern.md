# 🌐 HTML Day 5 Notes

> Covers: Accessibility (a11y), HTML Entities, Modern HTML5 Best Practices

---

# ♿ Accessibility (a11y)

![Accessibility Structure](./images/HowSeoWorks.png)

### 📌 Definition

Accessibility means making websites usable for **everyone**, including people with disabilities.

---

## 🎯 Why Accessibility?

* Helps visually impaired users
* Improves SEO
* Required in real-world projects
* Improves user experience

---

## 🔹 Important Accessibility Features

### 1️⃣ Alt Attribute (Very Important)

```html
<img src="image.png" alt="Profile Image">
```

👉 Helps screen readers
👉 Improves SEO

---

### 2️⃣ Label for Inputs

```html
<label for="email">Email</label>
<input id="email" type="email">
```

👉 Better usability + accessibility

---

### 3️⃣ Semantic HTML
![Semantic Layout](./images/SemanticVsNon.png)

![Semantic Layout](./images/Semantic.png)

```html
<header></header>
<nav></nav>
<main></main>
<footer></footer>
```

👉 Screen readers understand structure

---

### 4️⃣ ARIA Attributes

```html
<button aria-label="Close Menu">X</button>
```

👉 Helps assistive technologies

---

### 5️⃣ Keyboard Navigation

```html
<button tabindex="0">Click Me</button>
```

👉 Supports keyboard users

---

# 🧾 HTML Entities

![Structure](./images/OverNestEleVsPropStr.png)

### 📌 Definition

Entities are used to display **reserved or special characters**

---

## 🔹 Common Entities

| Symbol | Code      |
| ------ | --------- |
| `<`    | `&lt;`    |
| `>`    | `&gt;`    |
| `&`    | `&amp;`   |
| `"`    | `&quot;`  |
| ©      | `&copy;`  |
| ₹      | `&#8377;` |

---

### ✅ Example

```html
<p>5 &lt; 10</p>
<p>&copy; 2026 Om</p>
```

---

# 🧠 Modern HTML5 Best Practices

---

## 🔹 Use Semantic Tags

❌ Bad:

```html
<div></div>
```

✅ Good:

```html
<section></section>
```

---

## 🔹 Add alt in Images

```html
<img src="img.png" alt="Description">
```

---

## 🔹 Proper Heading Order

```html
<h1>Main</h1>
<h2>Sub</h2>
<h3>Child</h3>
```

---

## 🔹 Clean Code

* Proper indentation
* Avoid deep nesting
* Meaningful names

---

## 🔹 Responsive Design

```html
<meta name="viewport" content="width=device-width, initial-scale=1.0">
```

---

# 🧠 Interview Tips

* Accessibility = usability + SEO
* `alt` is mandatory
* Semantic HTML improves accessibility
* Entities are used for special symbols

---

# 🚀 Summary

* Accessibility → usable for all users
* Entities → special characters
* Modern HTML → clean + semantic

---

## 👨‍💻 Author

**OmBarabhai**
