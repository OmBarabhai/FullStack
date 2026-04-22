# 🔒 HTML Security 

> 📌 Essential security concepts for frontend (HTML level)

---

# 🧠 What is Web Security?

👉 Protecting your website and users from:

* Data theft
* Malicious scripts
* Unauthorized actions

---

# ⚠️ 1. XSS (Cross-Site Scripting)

### 📌 Definition

XSS is when an attacker injects **malicious JavaScript** into your website.

---

## ❌ Example (Attack)

```html
<input value="<script>alert('Hacked')</script>">
```

👉 If rendered → script runs in browser

---

## 💥 What Happens?

* User data can be stolen
* Cookies/session hijacked
* Fake UI can be shown

---

## 🛡️ Prevention

* Never trust user input
* Escape special characters (`<`, `>`, `&`)
* Use proper validation
* Avoid directly inserting user data in HTML

---

# ⚠️ 2. Input Validation

👉 Always validate user input before using it

---

## ✅ HTML Validation

```html
<input type="email" required>
<input type="number" min="1" max="10">
<input type="text" pattern="[A-Za-z]{3,}">
```

---

## 📌 Why Important?

* Prevents invalid data
* Reduces attack chances

---

# ⚠️ 3. iframe Security

### 📌 Problem

iframes can be used for **clickjacking attacks**

---

## ❌ Attack Example

👉 Fake button inside iframe → user clicks unknowingly

---

## 🛡️ Solution

```html
<iframe sandbox></iframe>
```

---

## 🔹 Strong Security

```http
Content-Security-Policy: frame-ancestors 'none';
```

👉 Prevents embedding your site

---

# ⚠️ 4. Clickjacking

### 📌 Definition

Tricking users into clicking hidden elements

---

## 🛡️ Prevention

* Use `frame-ancestors`
* Disable iframe embedding
* Use proper UI design

---

# ⚠️ 5. Form Security (Frontend Level)

---

## 🔹 Common Issues

* Injecting scripts in input
* Sending wrong data
* No validation

---

## 🛡️ Best Practices

* Use `required`
* Use `pattern`
* Use correct input types

---

# ⚠️ 6. Avoid Inline JavaScript

❌ Bad:

```html
<button onclick="runCode()">
```

👉 Risk: injection possible

---

## ✅ Better

```html
<script>
  document.querySelector("button").addEventListener("click", fn);
</script>
```

---

# ⚠️ 7. File Upload Risks

👉 Users can upload:

* Virus files
* Large files

---

## 🛡️ Prevention

```html
<input type="file" accept="image/*">
```

👉 Restrict file type

---

# ⚠️ 8. Data Exposure (Frontend Mistake)

❌ Never store sensitive data in:

```javascript
localStorage.setItem("password", "123");
```

👉 Anyone can see it

---

# ⚠️ 9. HTTPS (VERY IMPORTANT)

👉 Always use HTTPS

✔ Encrypts data
✔ Prevents MITM attacks

---

# 🧠 Interview Tips

* XSS = most common attack
* Always validate input
* Use sandbox for iframe
* Never trust user data
* HTTPS is mandatory

---

# 🚀 Summary

* XSS → script injection
* Validation → data safety
* iframe → clickjacking risk
* HTTPS → secure communication

---

## 👨‍💻 Author

**OmBarabhai**
