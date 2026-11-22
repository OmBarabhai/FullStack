# CSS Day 2: FlexBox, Grid & Positioning

## 📖 Overview

Today you'll master modern **layout systems**. FlexBox and CSS Grid have revolutionized web layout design.

---

## 🎯 Learning Objectives

✅ Master Flexbox layout  
✅ Understand CSS Grid  
✅ Use positioning correctly  
✅ Understand display vs visibility  
✅ Work with floats and clears

---

## 📚 Key Concepts

### **Flexbox**

```css
.container {
  display: flex;
  justify-content: center; /* Horizontal alignment */
  align-items: center; /* Vertical alignment */
  flex-direction: row; /* row | column */
  flex-wrap: wrap; /* Single or multiple lines */
  gap: 10px; /* Space between items */
}

.item {
  flex: 1; /* Equal growth */
  flex-basis: 200px; /* Base size */
}
```

### **CSS Grid**

```css
.container {
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  grid-template-rows: auto 1fr auto;
  gap: 20px;
}

.item {
  grid-column: 1 / 3; /* Span columns */
  grid-row: 2; /* Row placement */
}
```

### **Positioning**

```css
.static {
  position: static;
} /* Default, ignore top/bottom/left/right */
.relative {
  position: relative;
} /* Relative to normal position */
.absolute {
  position: absolute;
} /* Relative to positioned parent */
.fixed {
  position: fixed;
} /* Relative to viewport */
.sticky {
  position: sticky;
} /* Hybrid of relative and fixed */
```

### **Display vs Visibility**

```css
.hidden-display {
  display: none;
} /* Removed from layout */
.hidden-visibility {
  visibility: hidden;
} /* Hidden but takes space */
.transparent {
  opacity: 0;
} /* Transparent but interactive */
```

---

## 💻 Practice Examples

### **Flexbox Centered Layout**

```css
.container {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
}
```

### **Responsive Grid**

```css
.container {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(300px, 1fr));
  gap: 20px;
}
```

---

## 📋 Checklist

- [ ] Create Flexbox layouts
- [ ] Build CSS Grid layouts
- [ ] Understand positioning
- [ ] Practice responsive design
- [ ] Know display vs visibility

---

## 🔗 Next: [Day 3 - Media Queries & Responsive Design](../Day_3/README.md)

_FlexBox and Grid are the modern way to layout!_
