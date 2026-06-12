# CSS Day 3: Media Queries & Responsive Design

## 📖 Overview

Today you'll learn **responsive design principles** that make your website work perfectly on all devices-from mobile to desktop.

---

## 🎯 Learning Objectives

✅ Understand mobile-first approach  
✅ Write effective media queries  
✅ Create responsive layouts  
✅ Optimize for different screen sizes  
✅ Test responsive designs

---

## 📚 Key Concepts

### **Media Queries**

```css
/* Mobile First */
.container {
  display: grid;
  grid-template-columns: 1fr; /* Single column on mobile */
}

/* Tablet and up */
@media (min-width: 768px) {
  .container {
    grid-template-columns: 1fr 1fr; /* Two columns */
  }
}

/* Desktop and up */
@media (min-width: 1024px) {
  .container {
    grid-template-columns: 1fr 1fr 1fr; /* Three columns */
  }
}
```

### **Common Breakpoints**

```css
@media (max-width: 480px) {
} /* Mobile */
@media (max-width: 768px) {
} /* Tablet */
@media (max-width: 1024px) {
} /* Small desktop */
@media (min-width: 1440px) {
} /* Large desktop */
```

### **Responsive Images**

```css
img {
  max-width: 100%;
  height: auto;
  display: block;
}
```

### **Responsive Typography**

```css
/* Base font */
body {
  font-size: 16px;
}

/* Mobile */
h1 {
  font-size: 24px;
}

/* Tablet */
@media (min-width: 768px) {
  h1 {
    font-size: 32px;
  }
}

/* Desktop */
@media (min-width: 1024px) {
  h1 {
    font-size: 42px;
  }
}
```

---

## 💻 Practice Examples

### **Responsive Navigation**

```css
/* Mobile: Hamburger menu */
.nav {
  display: none;
}

.menu-toggle {
  display: block;
}

/* Desktop: Horizontal menu */
@media (min-width: 768px) {
  .nav {
    display: flex;
    gap: 20px;
  }

  .menu-toggle {
    display: none;
  }
}
```

### **Responsive Grid Gallery**

```css
.gallery {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
  gap: 20px;
  padding: 20px;
}

@media (max-width: 480px) {
  .gallery {
    grid-template-columns: 1fr;
    gap: 10px;
    padding: 10px;
  }
}
```

---

## 📋 Checklist

- [ ] Understand mobile-first approach
- [ ] Write media queries
- [ ] Make images responsive
- [ ] Test on different screen sizes
- [ ] Use responsive typography

---

## 🔗 Next: [Day 4 - Advanced Selectors & Best Practices](../Day_4/README.md)

_Responsive design is no longer optional-it's essential!_
