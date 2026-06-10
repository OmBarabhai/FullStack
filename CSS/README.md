# CSS - Cascading Style Sheets

## 📚 Overview

CSS (Cascading Style Sheets) is the language for **styling and positioning** HTML elements. This 4-day learning path covers everything from basic selectors to modern layout techniques like FlexBox and CSS Grid.

---

## 🗂️ **4-Day Learning Path**

### [**Day 1: Selectors & Specificity**](./Day_1/README.md)

- CSS syntax and how it works
- Element, class, and ID selectors
- Selector specificity
- External, internal, and inline CSS
- CSS methods comparison

---

### [**Day 2: FlexBox, Grid & Positioning**](./Day_2/README.md)

- Flexbox layout system
- CSS Grid layout
- Positioning (static, relative, absolute, fixed)
- Display vs Visibility vs Opacity
- Float and clear

---

### [**Day 3: Media Queries & Responsive Design**](./Day_3/README.md)

- Mobile-first approach
- Media queries
- Responsive design principles
- Creating responsive navigation
- Photo gallery project

---

### [**Day 4: Advanced Selectors & Methodologies**](./Day_4/README.md)

- Advanced pseudo-selectors
- OOCSS (Object-Oriented CSS)
- SMACSS (Scalable and Modular Architecture)
- BEM (Block Element Modifier) naming
- CSS best practices

---

## 🎯 **Learning Objectives**

By the end of this 4-day course, you will:

✅ Master CSS selectors and specificity  
✅ Create layouts with FlexBox and Grid  
✅ Design responsive websites  
✅ Understand positioning and display  
✅ Use modern CSS methodologies  
✅ Build professional-looking websites  
✅ Optimize CSS for performance

---

## 🏗️ **Folder Structure**

```
CSS/
├── README.md
├── Day_1/
│   ├── README.md
│   ├── Notes/
│   │   └── images/
│   ├── externalCSS.html
│   ├── externalCSS.css
│   ├── inlineCSS.html
│   ├── internalCSS.html
│   └── Selector/
│
├── Day_2/
│   ├── README.md
│   ├── FlexBox/
│   │   ├── index.html
│   │   └── InterviewFlex.html
│   ├── grid/
│   │   └── holygrail.html
│   ├── CSS_position_1/
│   │   ├── index.html
│   │   ├── float.html
│   │   └── DisplayVsVisibilityVsOpacity.html
│
├── Day_3/
│   ├── README.md
│   ├── Photo_Gallery/
│   │   └── index.html
│   └── Media_Query/
│       ├── Nav.html
│       └── index.html
│
├── Day_4/
│   ├── README.md
│   ├── 404_foundPg/
│   │   └── index.html
│   └── Selector/
│       └── [Various selector examples]
│
└── [Additional projects and examples]
```

---

## 📊 **Key Concepts Overview**

| Day | Focus               | Why Important                |
| --- | ------------------- | ---------------------------- |
| 1   | Selectors & Styling | Foundation for all CSS       |
| 2   | Layout Systems      | Modern layout without floats |
| 3   | Responsive Design   | Works on all devices         |
| 4   | Best Practices      | Scalable, maintainable code  |

---

## 💡 **Quick Reference**

### **CSS Syntax**

```css
selector {
  property: value;
  property: value;
}
```

### **Common Selectors**

```css
p {
} /* Element selector */
.class {
} /* Class selector */
#id {
} /* ID selector */
p.class {
} /* Element with class */
p > span {
} /* Child combinator */
p span {
} /* Descendant combinator */
p + span {
} /* Adjacent sibling */
```

### **FlexBox Quick Start**

```css
.container {
  display: flex;
  justify-content: center; /* Horizontal alignment */
  align-items: center; /* Vertical alignment */
  gap: 10px; /* Space between items */
}
```

### **Grid Quick Start**

```css
.container {
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  gap: 20px;
}
```

---

## 🎨 **Projects in This Module**

1. **Flexbox Layouts** - Navigation, card layouts
2. **CSS Grid Layouts** - Holy Grail pattern
3. **Responsive Gallery** - Photo gallery with responsive images
4. **Responsive Navigation** - Mobile-first navbar
5. **404 Page** - Creative error page design

---

## 🚀 **Getting Started**

1. Start with [Day 1 README](./Day_1/README.md)
2. Follow the 4-day learning path
3. Complete all practice exercises
4. Build the projects
5. Move to [JavaScript](../JavaScript/README.md)

---

## 📚 **Resources**

- [MDN CSS Reference](https://developer.mozilla.org/en-US/docs/Web/CSS)
- [CSS Tricks](https://css-tricks.com)
- [Can I Use](https://caniuse.com)
- [Flexbox Playground](https://developer.mozilla.org/en-US/docs/Web/CSS/CSS_Flexible_Box_Layout)

---

**Ready to style the web? Let's start with [Day 1](./Day_1/README.md)! 🎨**
