# CSS Day 1: Selectors & Specificity

## 📖 Overview

Today you'll learn the **foundation of CSS**-how to select elements and apply styles to them. Mastering selectors is critical for effective styling.

---

## 🎯 Learning Objectives

✅ Understand CSS syntax  
✅ Use element, class, and ID selectors  
✅ Master selector specificity  
✅ Apply CSS in three ways (external, internal, inline)  
✅ Understand the cascade  
✅ Use advanced selectors

---

## 📚 Key Concepts

### **1. CSS Syntax**

```css
selector {
  property: value;
}
```

### **2. Basic Selectors**

```css
/* Element Selector */
p {
  color: blue;
}

/* Class Selector */
.intro {
  font-size: 18px;
}

/* ID Selector */
#header {
  background: navy;
}

/* Universal Selector */
* {
  margin: 0;
}
```

### **3. Specificity (The Cascade)**

Specificity determines which rule applies when multiple rules target the same element.

**Specificity Order (Most → Least):**

1. **Inline styles** (highest)
2. **ID selectors** (#id)
3. **Class selectors** (.class), attributes, pseudo-classes
4. **Element selectors** (lowest)

**Example:**

```css
p { color: blue; }              /* Specificity: 1 */
.intro { color: red; }          /* Specificity: 10 */
#header { color: green; }       /* Specificity: 100 */
<p style="color: yellow;">      <!-- Specificity: 1000 (inline) -->
```

### **4. Three Ways to Apply CSS**

#### **External CSS (Best Practice)**

```html
<link rel="stylesheet" href="styles.css" />
```

#### **Internal CSS**

```html
<style>
  p {
    color: blue;
  }
</style>
```

#### **Inline CSS (Avoid)**

```html
<p style="color: blue;">Text</p>
```

---

## 💻 Practice Examples

### **Selector Combinations**

```css
/* Descendant */
div p {
  color: blue;
}

/* Child */
div > p {
  color: red;
}

/* Adjacent Sibling */
h1 + p {
  font-weight: bold;
}

/* Attribute Selector */
input[type="text"] {
  border: 1px solid blue;
}

/* Pseudo-classes */
a:hover {
  color: red;
}
li:first-child {
  font-weight: bold;
}
```

---

## 📋 Checklist

- [ ] Understand CSS syntax
- [ ] Use different selector types
- [ ] Understand specificity
- [ ] Know when to use inline/internal/external
- [ ] Practice selector combinations

---

## 🔗 Next: [Day 2 - FlexBox & Grid](../Day_2/README.md)

_Selectors are the foundation-master them!_
