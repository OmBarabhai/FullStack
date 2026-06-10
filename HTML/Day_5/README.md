# HTML Day 5: Semantics, Accessibility & SEO

## 📖 Overview

Today you'll learn to write **professional, accessible, and SEO-friendly HTML**. These concepts ensure your website is usable by everyone and discoverable by search engines.

---

## 🎯 Learning Objectives

✅ Use semantic HTML elements  
✅ Implement accessibility features  
✅ Optimize for search engines (SEO)  
✅ Understand heading hierarchy  
✅ Use ARIA attributes  
✅ Write accessible forms

---

## 📚 Key Concepts

### **1. Semantic HTML**

**Semantic HTML** uses meaningful tags that describe content purpose.

#### **Non-Semantic (❌)**

```html
<div id="header"></div>
<div id="navigation"></div>
<div id="main"></div>
<div id="footer"></div>
```

#### **Semantic (✅)**

```html
<header></header>
<nav></nav>
<main></main>
<footer></footer>
```

#### **Semantic Tags**

| Tag            | Purpose                     |
| -------------- | --------------------------- |
| `<header>`     | Page/section header         |
| `<nav>`        | Navigation links            |
| `<main>`       | Main content                |
| `<article>`    | Standalone article          |
| `<section>`    | Thematic content group      |
| `<aside>`      | Sidebar content             |
| `<footer>`     | Page/section footer         |
| `<figure>`     | Self-contained illustration |
| `<figcaption>` | Figure description          |

---

### **2. Accessibility (A11y)**

Accessibility ensures your site works for **everyone**, including people with disabilities.

#### **Alt Text for Images**

```html
<!-- ❌ Bad -->
<img src="dog.jpg" />

<!-- ✅ Good -->
<img src="dog.jpg" alt="Brown dog running in park" />
```

#### **Form Accessibility**

```html
<!-- ❌ Bad -->
<input type="text" />

<!-- ✅ Good -->
<label for="name">Name:</label>
<input type="text" id="name" name="name" />
```

#### **ARIA Attributes**

```html
<!-- ARIA Label -->
<button aria-label="Close menu">✕</button>

<!-- ARIA Described By -->
<input id="email" type="email" />
<span id="email-help">We'll never share your email</span>

<!-- ARIA Live Region -->
<div aria-live="polite" aria-atomic="true">Loading...</div>
```

---

### **3. SEO (Search Engine Optimization)**

SEO helps search engines understand and rank your content.

#### **Meta Tags**

```html
<head>
  <!-- Page Title (50-60 chars) -->
  <title>Best SEO Title | Company Name</title>

  <!-- Description (150-160 chars) -->
  <meta name="description" content="Brief description of page content" />

  <!-- Keywords -->
  <meta name="keywords" content="keyword1, keyword2, keyword3" />

  <!-- Open Graph (Social Media) -->
  <meta property="og:title" content="Title" />
  <meta property="og:description" content="Description" />
  <meta property="og:image" content="image.jpg" />
  <meta property="og:url" content="https://example.com" />
</head>
```

#### **Heading Hierarchy**

```html
<!-- ❌ Bad -->
<h1>Title</h1>
<h3>Subtitle</h3>
<!-- Skip h2! -->

<!-- ✅ Good -->
<h1>Title</h1>
<h2>Subtitle</h2>
<h3>Sub-subtitle</h3>
```

---

### **4. Complete Page Example**

```html
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta name="description" content="Learn web development basics" />
    <title>Web Development Tutorial</title>
  </head>
  <body>
    <header>
      <h1>Web Development Basics</h1>
      <nav>
        <a href="/">Home</a>
        <a href="/about">About</a>
        <a href="/contact">Contact</a>
      </nav>
    </header>

    <main>
      <article>
        <h2>Getting Started with HTML</h2>
        <figure>
          <img src="html-basics.jpg" alt="HTML structure diagram" />
          <figcaption>Basic HTML structure</figcaption>
        </figure>
        <p>HTML is the foundation of web development...</p>
      </article>

      <aside>
        <h3>Related Topics</h3>
        <ul>
          <li><a href="/css">CSS Basics</a></li>
          <li><a href="/js">JavaScript</a></li>
        </ul>
      </aside>
    </main>

    <footer>
      <p>&copy; 2024 Web Dev Tutorial. All rights reserved.</p>
    </footer>
  </body>
</html>
```

---

## 📋 Checklist

- [ ] Use semantic HTML elements
- [ ] Add alt text to all images
- [ ] Provide proper heading hierarchy
- [ ] Label all form inputs
- [ ] Add meta tags
- [ ] Use ARIA attributes when needed
- [ ] Test with screen reader
- [ ] Verify SEO elements

---

## 💡 Key Takeaways

1. **Semantic HTML** = Better for SEO & accessibility
2. **Accessibility = Legal requirement** in many places
3. **Meta tags** = Essential for SEO
4. **Labels** = Required for accessible forms
5. **Hierarchy** = H1, H2, H3... in order

---

## 🔗 Next: [CSS](../../CSS/README.md)

_Great job completing HTML! You're now ready to style your content with CSS!_
