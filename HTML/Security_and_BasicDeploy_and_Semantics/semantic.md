# 🌐 HTML Essentials (Semantics + Optimization + Security)

> 📌 Quick Revision Guide for Interviews

---

# 🧠 1. Syntax vs Semantics

### 🔹 Syntax

👉 Rules of a language
❌ If wrong → Error

Example:

```html id="6l9q2g"
<p>Hello
```

---

### 🔹 Semantics

👉 Meaning of content
✔ No error, but improves structure

---

# 🧱 2. Semantics in HTML (HTML5)

### 📌 Definition

Semantic HTML = using tags that describe meaning of content

---

## 🔹 Non-Semantic Tags

```html id="3s5g2c"
<div></div>
<span></span>
```

👉 No meaning

---

## 🔹 Semantic Tags

```html id="qpxy2j"
<header></header>
<nav></nav>
<main></main>
<section></section>
<article></article>
<aside></aside>
<footer></footer>
```

---

## 🔹 Inline Semantic Tags

```html id="4y03k7"
<strong>Important</strong>
<em>Emphasis</em>
```

---

# 🎯 Uses of Semantic HTML

### 1. 👨‍💻 Developers

* Easy to read & maintain

### 2. 🔍 SEO

* Search engines understand structure

### 3. ♿ Accessibility

* Screen readers (like **JAWS**) understand content

---

# ♿ Accessibility (Quick)

👉 Tools like **JAWS (screen reader)** read semantic tags properly

✔ Helps visually impaired users

---

# ⚡ 3. Optimization

### 📌 Definition

Improving performance of website

---

## 🔹 1. Optimize Files

* Use smaller images (`.webp`, `.jpg`)
* Avoid large files

---

## 🔹 2. Remove Unused Code

❌ Extra files slow website

---

## 🔹 3. Lazy Loading

```html id="v2fp9h"
<img src="img.jpg" loading="lazy">
```

👉 Loads only when needed

---

## 🔹 4. Use Built-in Features

✔ HTML native features instead of heavy libraries

---

# 🔒 4. Security (Basics)

---

## ⚠️ 1. XSS (Cross-Site Scripting)

👉 Injecting malicious JS

```html id="8g2dtx"
<input value="<script>alert('hack')</script>">
```

---

## 🛡️ Prevention

* Validate input
* Escape special characters
* Never trust user data

---

## ⚠️ 2. Input Validation

```html id="zj0x6k"
<input type="email" required>
```

👉 Prevent invalid data

---

## ⚠️ 3. iframe Security

```html id="m3ybr6"
<iframe sandbox></iframe>
```

👉 Restricts scripts

---

## ⚠️ 4. HTTPS

👉 Always use HTTPS

✔ Secure communication

---

# 🧠 Interview Tips

* Semantic HTML improves SEO & accessibility
* `<div>` vs `<section>` → very common question
* Optimization improves performance
* XSS is most common attack

---

# 🚀 Summary

* Syntax → rules
* Semantics → meaning
* Optimization → speed
* Security → protection

---

## 👨‍💻 Author

**OmBarabhai**
