# 🌐 HTML Day 4 Notes

> Covers: Forms, Inputs, Validation, Attributes

---

# 📄 HTML Forms

<p align="center">
  <img src="./Images/form.png" width="700"/>
</p>

### 📌 Definition

HTML forms are used to **collect user input** and send it to a server.

---

## ✅ Basic Syntax

```html
<form action="/submit" method="post">
  <!-- inputs -->
</form>
```

---

## 🔹 Form Attributes

| Attribute  | Description            |
| ---------- | ---------------------- |
| action     | URL where data is sent |
| method     | `get` / `post`         |
| enctype    | Data encoding type     |
| name       | Form identifier        |
| novalidate | Disable validation     |
| target     | Where to open response |

---

# 🧩 Fieldset & Legend

```html
<fieldset>
  <legend>Sign Up</legend>
</fieldset>
```

👉 Groups related fields

---

# 🧾 Input Types

## 🔹 Text / Email / Password

```html
<input type="text">
<input type="email" required>
<input type="password">
```

---

## 🔹 Number & Range

```html
<input type="number" step="5">
<input type="range">
```

---

## 🔹 Date Inputs

```html
<input type="date">
<input type="month">
<input type="datetime-local">
```

---

## 🔹 File & Color

```html
<input type="file">
<input type="color">
```

---

# 🔘 Radio Buttons (IMPORTANT)

```html
<input type="radio" name="gender" value="male"> Male
<input type="radio" name="gender" value="female"> Female
```

👉 Same `name` = only one selectable

---

# ☑️ Checkboxes

```html
<input type="checkbox" name="hobby"> Coding
<input type="checkbox" name="hobby"> Music
```

👉 Multiple selections allowed

---

# 🔍 Datalist (Autocomplete)

```html
<input list="languages">
<datalist id="languages">
  <option value="Java">
  <option value="Python">
</datalist>
```

---

# 🔽 Select Dropdown

```html
<select>
  <option>One</option>
  <option>Two</option>
</select>
```

---

# 📝 Textarea

```html
<textarea rows="4" cols="30"></textarea>
```

---

# 🔗 Label (VERY IMPORTANT)

```html
<label for="email">Email</label>
<input id="email" type="email">
```

👉 Improves accessibility + UX

---

# 👻 Hidden Input

```html
<input type="hidden" value="secret">
```

---

# 🔘 Buttons

```html
<button type="submit">Submit</button>
<button type="reset">Reset</button>
```

---

# 🔐 Validation

## 🔹 Built-in

```html
<input type="email" required>
```

---

## 🔹 Pattern (ADVANCED)

```html
<input type="text" pattern="[A-Za-z]{3,}">
```

👉 Only letters allowed

---

## 🔹 Min / Max

```html
<input type="number" min="1" max="10">
```

---

# ⚠️ Important Concepts

👉 `GET` → data visible in URL
👉 `POST` → secure (used in forms)
👉 `name` attribute → **VERY IMPORTANT (sent to backend)**
👉 `required` → must fill

---

# 🧠 Interview Tips

* Form = data collection
* Always use `label`
* Use `POST` for passwords
* `name` is required for backend
* Know difference:

  * `select` vs `datalist`
  * `radio` vs `checkbox`

---

# 🚀 Summary

* `<form>` → container
* `<input>` → data entry
* `<select>` → dropdown
* `<textarea>` → text area
* `<button>` → actions

---

## 👨‍💻 Author

**OmBarabhai**
