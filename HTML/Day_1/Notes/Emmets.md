# ⚡ Emmet Cheat Sheet 

> Emmet helps you write HTML & CSS **faster using shortcuts**

---

## 🚀 What is Emmet?

Emmet is a built-in tool in VS Code that allows you to write **short expressions** and expand them into full HTML/CSS code.

👉 Saves time + increases productivity

---

## 🧩 Basic Example

```html
!
```

⬇️ Press `Tab`

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>

</body>
</html>
```

---

## 🔹 Common Emmet Shortcuts

### 1. Create Element

```html
div
```

⬇️

```html
<div></div>
```

---

### 2. Child (`>`)

```html
ul>li
```

⬇️

```html
<ul>
    <li></li>
</ul>
```

---

### 3. Multiple Elements (`*`)

```html
ul>li*3
```

⬇️

```html
<ul>
    <li></li>
    <li></li>
    <li></li>
</ul>
```

---

### 4. Sibling (`+`)

```html
h1+p
```

⬇️

```html
<h1></h1>
<p></p>
```

---

### 5. Class (`.`)

```html
div.container
```

⬇️

```html
<div class="container"></div>
```

---

### 6. ID (`#`)

```html
div#main
```

⬇️

```html
<div id="main"></div>
```

---

### 7. Text (`{}`)

```html
h1{Hello World}
```

⬇️

```html
<h1>Hello World</h1>
```

---

### 8. Attributes (`[]`)

```html
input[type="text"]
```

⬇️

```html
<input type="text">
```

---

### 9. Numbering (`$`)

```html
ul>li.item$*3
```

⬇️

```html
<ul>
    <li class="item1"></li>
    <li class="item2"></li>
    <li class="item3"></li>
</ul>
```

---

## ⚡ Combo Example

```html
div#app>ul.list>li.item$*3{Item $}
```

⬇️

```html
<div id="app">
    <ul class="list">
        <li class="item1">Item 1</li>
        <li class="item2">Item 2</li>
        <li class="item3">Item 3</li>
    </ul>
</div>
```

---

## 💡 Tips

* Press `Tab` to expand
* Works in HTML, CSS, JSX
* Practice small → combine big

---

## 🎯 Summary

* Emmet = speed 🚀
* Write less, generate more
* Essential for every developer

---