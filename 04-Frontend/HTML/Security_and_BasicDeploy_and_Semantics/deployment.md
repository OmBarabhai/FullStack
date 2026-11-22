
# 🚀 HTML Deployment

> 📌 How to make your website live + basic optimization & safety

---

# 🌐 1. What is Deployment?

👉 Deployment = uploading your project to the internet so others can access it via URL.

Example:

```
http://your-site.netlify.app
```

---

# 🧱 2. Types of Hosting

| Type            | Example               |
| --------------- | --------------------- |
| Static Hosting  | GitHub Pages, Netlify |
| Dynamic Hosting | Node, PHP servers     |

👉 For HTML → use **Static Hosting**

---

# 🔹 3. GitHub Pages

### ✅ Steps

1. Push project to GitHub (public repo)
2. Go to **Settings → Pages**
3. Select branch (main)
4. Click Save
5. Get live link

👉 URL:

```
https://username.github.io/repo-name/
```

---

# 🔹 4. Netlify (Best for Beginners)

### ✅ Steps

1. Login to Netlify
2. Click **Add New Site**
3. Connect GitHub repo
4. Click Deploy

👉 Features:

* Auto deploy on push
* Fast CDN
* Free SSL (HTTPS)

---

# 🔹 5. Vercel

### ✅ Steps

1. Login to Vercel
2. Click **New Project**
3. Import GitHub repo
4. Click Deploy

👉 Best for React / modern apps

---

# ⚡ 6. Optimization (VERY IMPORTANT)

---

## 🔹 1. Optimize Images

* Use `.webp` / `.jpg`
* Avoid large images

```html
<img src="img.webp" loading="lazy">
```

---

## 🔹 2. Remove Unused Files

❌ Delete:

* extra images
* unused CSS/JS

---

## 🔹 3. Lazy Loading

```html
<img src="image.jpg" loading="lazy">
```

👉 Loads only when needed
👉 Improves speed

---

## 🔹 4. Minify Files (Basic Idea)

👉 Remove:

* extra spaces
* comments

---

# 🔒 7. Basic Deployment Security

---

## 🔹 1. Always Use HTTPS

👉 All platforms give HTTPS automatically

✔ Data encryption
✔ Safe communication

---

## 🔹 2. Avoid Exposing Sensitive Data

❌ Never push:

```javascript
API_KEY = "12345"
```

👉 Use environment variables (advanced)

---

## 🔹 3. Validate Forms

```html
<input type="email" required>
```

👉 Prevents invalid data

---

## 🔹 4. Secure iFrame

```html
<iframe sandbox></iframe>
```

👉 Prevents script attacks

---

## 🔹 5. Content Security (Basic Idea)

```http
Content-Security-Policy: default-src 'self';
```

👉 Restricts external scripts

---

# 🧠 Interview Tips

* Deployment = make site live
* GitHub Pages → static hosting
* Netlify → auto deploy
* Lazy loading improves performance
* HTTPS is mandatory

---

# 🚀 Summary

* Deploy → GitHub / Netlify / Vercel
* Optimize → images + lazy loading
* Secure → HTTPS + validation

---

## 👨‍💻 Author

**OmBarabhai**
