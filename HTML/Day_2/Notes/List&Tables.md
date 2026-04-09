# 🌐 HTML Day 2 Notes

> Covers: Lists and Tables

---

# 📋 HTML Lists

---

## 🔹 Types of Lists

| Type             | Tag    | Description    |
| ---------------- | ------ | -------------- |
| Ordered List     | `<ol>` | Numbered list  |
| Unordered List   | `<ul>` | Bullet list    |
| Description List | `<dl>` | Key-value list |

---

## 🔢 Ordered List

![Ordered List](./images/list1.png)

```html
<ol>
  <li>Apple</li>
  <li>Banana</li>
</ol>
```

---

## 🔸 Unordered List

![Unordered List](./images/list2.png)

```html
<ul>
  <li>Apple</li>
  <li>Banana</li>
</ul>
```

---

## 🔹 Description List

![Description List](./images/list3.png)

```html
<dl>
  <dt>HTML</dt>
  <dd>Markup Language</dd>
</dl>
```

---

# 📊 HTML Tables

---

## 🔹 Table Structure

![Table Structure](./images/table1.png)
![Table Structure](./images/table2.png)
![Table Structure](./images/table3.png)


```html
<table>
  <tr>
    <th>Name</th>
    <th>Age</th>
  </tr>
  <tr>
    <td>Om</td>
    <td>22</td>
  </tr>
</table>
```

---

## 🔹 Important Table Tags

| Tag       | Use          |
| --------- | ------------ |
| `<table>` | Create table |
| `<tr>`    | Table row    |
| `<th>`    | Header cell  |
| `<td>`    | Data cell    |

---

## 🔹 Table Attributes

| Attribute | Use             |
| --------- | --------------- |
| border    | Border of table |
| colspan   | Merge columns   |
| rowspan   | Merge rows      |

---

## 🔹 Example with colspan & rowspan

```html
<table border="1">
  <tr>
    <th>Name</th>
    <th colspan="2">Marks</th>
  </tr>
  <tr>
    <td>Om</td>
    <td>Math</td>
    <td>90</td>
  </tr>
</table>
```

---

# 🚀 Summary

* Lists → organize items
* Tables → display structured data
* `<ol>`, `<ul>`, `<dl>` → list types
* `<table>`, `<tr>`, `<td>` → table structure

---

## 👨‍💻 Author

**OmBarabhai**
