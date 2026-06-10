# CSS Day 4: Advanced Selectors & Best Practices

## 📖 Overview

Today you'll learn **advanced selectors** and **CSS methodologies** for writing scalable, maintainable code.

---

## 🎯 Learning Objectives

✅ Master advanced pseudo-selectors  
✅ Understand CSS methodologies (BEM, OOCSS, SMACSS)  
✅ Write maintainable CSS  
✅ Optimize CSS for performance

---

## 📚 Key Concepts

### **Advanced Selectors**

```css
/* Pseudo-classes */
a:hover {
} /* On hover */
input:focus {
} /* On focus */
li:first-child {
} /* First child */
li:last-child {
} /* Last child */
li:nth-child(2n) {
} /* Even children */
p:not(.intro) {
} /* All except .intro */

/* Pseudo-elements */
p::first-line {
} /* First line of text */
p::first-letter {
} /* First letter */
p::before {
} /* Before element */
p::after {
} /* After element */

/* Attribute selectors */
input[type="text"] {
}
a[href^="https"] {
} /* Starts with */
a[href$=".pdf"] {
} /* Ends with */
a[href*="example"] {
} /* Contains */
```

### **BEM Naming Convention**

BEM = Block, Element, Modifier

```css
/* Block: Standalone component */
.button {
}

/* Element: Part of block */
.button__icon {
}
.button__text {
}

/* Modifier: Variation */
.button--primary {
}
.button--secondary {
}
.button__icon--large {
}
```

**Example:**

```html
<button class="button button--primary">
  <span class="button__text">Submit</span>
</button>
```

### **OOCSS (Object-Oriented CSS)**

Create reusable components:

```css
/* Reusable module */
.media {
  display: flex;
  gap: 20px;
}

.media__image {
  flex-shrink: 0;
}

.media__content {
  flex-grow: 1;
}

/* Variation */
.media--reverse {
  flex-direction: row-reverse;
}
```

---

## 💻 Practice Examples

### **Styling Form Focus**

```css
input:focus {
  outline: none;
  border-color: #007bff;
  box-shadow: 0 0 5px rgba(0, 123, 255, 0.5);
}

input:invalid {
  border-color: #dc3545;
}

input:valid {
  border-color: #28a745;
}
```

### **BEM Card Component**

```html
<div class="card">
  <img class="card__image" src="image.jpg" alt="" />
  <div class="card__content">
    <h3 class="card__title">Title</h3>
    <p class="card__description">Description</p>
    <button class="card__button card__button--primary">Read More</button>
  </div>
</div>
```

```css
.card {
  border: 1px solid #ddd;
  border-radius: 8px;
  overflow: hidden;
}

.card__image {
  width: 100%;
  height: 200px;
  object-fit: cover;
}

.card__content {
  padding: 20px;
}

.card__title {
  margin-bottom: 10px;
  font-size: 20px;
  font-weight: bold;
}

.card__button {
  padding: 10px 20px;
  border: none;
  cursor: pointer;
}

.card__button--primary {
  background: #007bff;
  color: white;
}

.card__button--primary:hover {
  background: #0056b3;
}
```

---

## 📋 Checklist

- [ ] Master pseudo-selectors and pseudo-elements
- [ ] Understand BEM naming
- [ ] Write reusable components
- [ ] Apply OOCSS principles
- [ ] Organize CSS files logically

---

## 🎉 Congratulations!

You've completed the CSS module! Now you can:

- Style HTML effectively
- Create responsive designs
- Build maintainable code
- Work with modern CSS

---

## 🔗 Next: [JavaScript](../../JavaScript/README.md)

_CSS mastery is achieved through practice. Keep building beautiful websites!_
