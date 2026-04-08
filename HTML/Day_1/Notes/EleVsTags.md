# 🧩 HTML Element & Attributes 

## 📸 Diagram

![HTML Element Structure](./images/image1.png)

---

## 🧠 What is an HTML Element?

An HTML element is made of:

```html
<start-tag attribute="value">Content</end-tag>
```

---

## 🔍 Example

```html
<p id="myId">This is a paragraph</p>
```

---

## 🧩 Breakdown

### 🔹 Start Tag

```html
<p id="myId">
```

* Begins the element
* Can contain attributes

---

### 🔹 Attribute

```html
id="myId"
```

* `id` → attribute name
* `"myId"` → attribute value

📌 Rules:

* Must have **space before attribute**
* No space inside `=`

---

### 🔹 Content

```html
This is a paragraph
```

* Visible data inside element

---

### 🔹 End Tag

```html
</p>
```

* Closes the element

---

## ⚠️ Spacing Rules (IMPORTANT)

❌ Wrong:

```html
<pid="myId"></p>
<p id = "myId"></p>
```

✅ Correct:

```html
<p id="myId"></p>
```

---

## 🧠 Second Diagram

![HTML Syntax Overview](./images/image2.png)

---

## 🧩 Summary

* Element = Start Tag + Content + End Tag
* Attributes add extra information
* Proper spacing is important
* Everything in HTML is built using elements

👉 **Elements = building blocks of web pages**
