# HTML Day 2: Lists & Tables

## 📖 Overview

Today you'll learn to organize and display **structured data** using lists and tables. These are essential for presenting information clearly and semantically.

---

## 🎯 Learning Objectives

✅ Create unordered lists  
✅ Create ordered lists  
✅ Use description lists  
✅ Build HTML tables with proper structure  
✅ Use advanced table features (colspan, rowspan)  
✅ Understand semantic table markup

---

## 📚 Key Concepts

### **1. Unordered Lists**

Use `<ul>` when order doesn't matter (bullets).

```html
<ul>
  <li>Item 1</li>
  <li>Item 2</li>
  <li>Item 3</li>
</ul>
```

**Output:**

- Item 1
- Item 2
- Item 3

---

### **2. Ordered Lists**

Use `<ol>` when order matters (numbers).

```html
<ol>
  <li>First step</li>
  <li>Second step</li>
  <li>Third step</li>
</ol>
```

**Output:**

1. First step
2. Second step
3. Third step

---

### **3. Description Lists**

Use `<dl>` for term-definition pairs.

```html
<dl>
  <dt>HTML</dt>
  <dd>HyperText Markup Language</dd>

  <dt>CSS</dt>
  <dd>Cascading Style Sheets</dd>
</dl>
```

---

### **4. HTML Tables**

#### **Basic Structure**

```html
<table>
  <thead>
    <tr>
      <th>Header 1</th>
      <th>Header 2</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>Data 1</td>
      <td>Data 2</td>
    </tr>
  </tbody>
  <tfoot>
    <tr>
      <td>Footer 1</td>
      <td>Footer 2</td>
    </tr>
  </tfoot>
</table>
```

#### **Key Elements**

| Tag       | Purpose                    |
| --------- | -------------------------- |
| `<table>` | Container for entire table |
| `<thead>` | Table header section       |
| `<tbody>` | Main table content         |
| `<tfoot>` | Table footer               |
| `<tr>`    | Table row                  |
| `<th>`    | Header cell                |
| `<td>`    | Data cell                  |

---

### **5. Advanced Table Features**

#### **colspan - Span Multiple Columns**

```html
<table>
  <tr>
    <th colspan="2">Wide Header</th>
  </tr>
  <tr>
    <td>Column 1</td>
    <td>Column 2</td>
  </tr>
</table>
```

#### **rowspan - Span Multiple Rows**

```html
<table>
  <tr>
    <th rowspan="2">Tall Header</th>
    <td>Row 1, Col 2</td>
  </tr>
  <tr>
    <td>Row 2, Col 2</td>
  </tr>
</table>
```

---

## 💻 Practice Examples

### **Example 1: Nested Lists**

```html
<ul>
  <li>
    Frontend
    <ul>
      <li>HTML</li>
      <li>CSS</li>
      <li>JavaScript</li>
    </ul>
  </li>
  <li>
    Backend
    <ul>
      <li>Python</li>
      <li>Node.js</li>
    </ul>
  </li>
</ul>
```

### **Example 2: Complex Table**

```html
<table>
  <thead>
    <tr>
      <th>Name</th>
      <th>Age</th>
      <th>City</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>John</td>
      <td>25</td>
      <td>New York</td>
    </tr>
    <tr>
      <td>Jane</td>
      <td>28</td>
      <td>London</td>
    </tr>
  </tbody>
</table>
```

### **Example 3: Table with colspan/rowspan**

```html
<table border="1">
  <tr>
    <th>Product</th>
    <th colspan="2">Quarter Sales</th>
  </tr>
  <tr>
    <td>Widget A</td>
    <td>$10,000</td>
    <td>$12,000</td>
  </tr>
</table>
```

---

## 📋 Checklist

- [ ] Understand when to use ul, ol, dl
- [ ] Create nested lists
- [ ] Build basic tables
- [ ] Use thead, tbody, tfoot
- [ ] Apply colspan and rowspan
- [ ] Understand semantic markup
- [ ] Practice with real data

---

## 🔗 Next: [Day 3 - Media](../Day_3/README.md)

---

_Tables are powerful for displaying structured data. Use them correctly!_
