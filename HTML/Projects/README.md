# HTML - HyperText Markup Language

## 📚 Overview

HTML (HyperText Markup Language) is the foundation of web development. It provides the **structure and semantic meaning** to web content. This 5-day learning path covers everything from basic elements to advanced semantic HTML and SEO.

---

## 🗂️ **5-Day Learning Path**

### [**Day 1: Elements, Attributes & Boilerplate**](./Day_1/README.md)

- What is HTML and why it matters
- Elements vs Tags
- HTML5 Boilerplate structure
- Attributes and their uses
- Emmet shortcuts for faster coding

**Key Learning**: Build a solid foundation in HTML structure

---

### [**Day 2: Lists & Tables**](./Day_2/README.md)

- Unordered lists (bullet points)
- Ordered lists (numbered)
- Description lists
- Table structure (rows, columns, headers)
- Advanced table features (colspan, rowspan)

**Key Learning**: Master complex data structures in HTML

---

### [**Day 3: Media**](./Day_3/README.md)

- Images and image formats
- Audio elements
- Video elements
- iframes and embedding
- Responsive media attributes

**Key Learning**: Embed multimedia content effectively

---

### [**Day 4: Forms**](./Day_4/README.md)

- Form structure and semantics
- Input types (text, email, password, etc.)
- Text areas and select dropdowns
- Form validation
- Accessibility in forms

**Key Learning**: Create accessible, user-friendly forms

---

### [**Day 5: Semantics, Accessibility & SEO**](./Day_5/README.md)

- Semantic HTML tags (article, section, nav, etc.)
- Web Accessibility (WCAG guidelines)
- SEO fundamentals
- Meta tags
- Proper heading hierarchy

**Key Learning**: Write clean, discoverable, accessible HTML

---

## 🏗️ **Folder Structure**

```
HTML/
├── README.md                          # This file
├── Day_1/
│   ├── README.md                      # Day 1 learning guide
│   ├── Notes/
│   │   ├── EleVsTags.md              # Elements vs Tags explanation
│   │   ├── BoilerPlate.md            # HTML5 Boilerplate
│   │   ├── Attributes.md             # HTML Attributes guide
│   │   ├── Emmets.md                 # Emmet shortcuts
│   │   └── images/                   # Day 1 visual diagrams
│   ├── helloworld.html               # First HTML file
│   ├── list.html                     # List examples
│   └── index1.html                   # Index examples
│
├── Day_2/
│   ├── README.md
│   ├── Notes/
│   │   ├── List&Tables.md
│   │   └── Images/
│   ├── tables.html
│   └── exercises/
│
├── Day_3/
│   ├── README.md
│   ├── Notes/
│   │   ├── Media.md
│   │   └── Images/
│   ├── media.html
│   ├── audio.html
│   ├── iframe.html
│   └── exercises/
│
├── Day_4/
│   ├── README.md
│   ├── Notes/
│   │   ├── form.md
│   │   └── images/
│   ├── forms.html
│   └── exercises/
│
├── Day_5/
│   ├── README.md
│   ├── Notes/
│   │   ├── Modern.md
│   │   ├── Interview.md
│   │   └── Images/
│   ├── Accessibilty.html
│   ├── entities.html
│   └── exercises/
│
├── Security_and_BasicDeploy_and_Semantics/
│   ├── Security.md
│   ├── deployment.md
│   └── semantic.md
│
├── Projects/
│   ├── PersonalPortfolioPage/
│   │   ├── index.html
│   │   ├── contact.html
│   │   └── assets/
│   ├── Forms/
│   │   └── index.html
│   ├── Questionnaire/
│   │   └── index.html
│   └── TimeTable/
│       └── index.html
│
├── Notes/
│   ├── Day_1.md
│   └── images/                       # Root-level reference images
│
└── index.html                        # Main index

```

---

## 🎯 **Learning Objectives**

By the end of this 5-day course, you will:

✅ Understand HTML document structure  
✅ Use semantic HTML elements correctly  
✅ Create forms with proper validation  
✅ Embed media (images, audio, video)  
✅ Build accessible web pages  
✅ Optimize for SEO  
✅ Write clean, maintainable HTML  
✅ Use Emmet for rapid development

---

## 📊 **Key Concepts Overview**

| Day | Concept               | Why It Matters                            |
| --- | --------------------- | ----------------------------------------- |
| 1   | Structure & Semantics | Forms foundation for all web content      |
| 2   | Data Organization     | Tables and lists display structured data  |
| 3   | Multimedia            | Images and videos enhance user engagement |
| 4   | User Input            | Forms enable user interaction             |
| 5   | Accessibility         | Ensures everyone can access your content  |

---

## 💡 **Important Takeaways**

### **Semantic HTML is Key**

Instead of:

```html
<div>Title</div>
<div>Content</div>
```

Use:

```html
<h1>Title</h1>
<article>Content</article>
```

### **Always Include Meta Tags**

```html
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta name="description" content="Page description for SEO" />
```

### **Accessibility First**

```html
<img src="logo.png" alt="Company Logo" />
<button aria-label="Close menu">✕</button>
```

---

## 🔧 **Tools You'll Need**

- **Code Editor**: VS Code (recommended)
- **Browser**: Chrome or Firefox (with developer tools)
- **Extensions**:
  - VS Code Live Server
  - Emmet (built-in to VS Code)
  - HTML Validator

---

## 📖 **Study Tips**

1. **Write code by hand** - Don't just copy-paste; type it out
2. **Use semantic elements** - Build the habit early
3. **Test in multiple browsers** - Ensure compatibility
4. **Use developer tools** - Inspect elements and debug
5. **Make small projects** - Apply what you learn immediately

---

## 🎨 **Projects in This Module**

### **Project 1: Personal Portfolio Page**

- Create your own portfolio website
- Includes HTML structure, CSS styling, contact form
- Files: `Projects/PersonalPortfolioPage/`

### **Project 2: Forms Project**

- Build various form types
- Input validation examples
- Files: `Projects/Forms/`

### **Project 3: Questionnaire**

- Interactive question-answer form
- Files: `Projects/Questionnaire/`

### **Project 4: Timetable**

- Create a class/schedule timetable using tables
- Files: `Projects/TimeTable/`

---

## 🔗 **Related Topics**

- **Next Step**: [CSS - Styling Your HTML](../CSS/README.md)
- **Later**: [JavaScript - Adding Interactivity](../JavaScript/README.md)
- **Reference**: [Web Accessibility Guidelines](https://www.w3.org/WAI/)

---

## ✨ **Pro Tips**

1. **Use Emmet shortcuts** - `!` + Tab creates full boilerplate
2. **Validate your HTML** - Use W3C Validator
3. **Check accessibility** - Use WAVE browser extension
4. **Optimize images** - Compress before upload
5. **Write comments** - Help your future self and others

---

## 📚 **Additional Resources**

- [MDN HTML Reference](https://developer.mozilla.org/en-US/docs/Web/HTML)
- [HTML Standard](https://html.spec.whatwg.org/)
- [Accessible HTML](https://www.a11y-101.com/design)

---

## 🚀 **Getting Started**

1. Start with [Day 1 README](./Day_1/README.md)
2. Follow the learning path sequentially
3. Complete the code-alongs
4. Build the projects
5. Move to [CSS](../CSS/README.md) when ready

---

**Ready? Let's start with [Day 1: Elements & Attributes](./Day_1/README.md)! 🎯**

---

_Progress through this course at your own pace. The journey of mastering web development starts here!_
