# 🌐 HTML Forms & Validation

---

# 📄 Registration Form

![Registration Form](./Images/registration-form.png)

## Definition

HTML Forms are used to collect user input and send data to a server.

Examples:

* Login Form
* Registration Form
* Contact Form
* Feedback Form

---

# Form Syntax

```html
<form action="/submit" method="post">

</form>
```

---

# Form Attributes

| Attribute  | Purpose                    |
| ---------- | -------------------------- |
| action     | URL where data is sent     |
| method     | GET or POST                |
| enctype    | Data encoding              |
| name       | Form identifier            |
| novalidate | Disable browser validation |
| target     | Response location          |

---

# GET vs POST

| GET                 | POST               |
| ------------------- | ------------------ |
| Data visible in URL | Data hidden        |
| Less secure         | More secure        |
| Used for search     | Used for forms     |
| Limited size        | Large data allowed |

---

# Fieldset & Legend

Used to group related inputs.

```html
<fieldset>
  <legend>Sign Up</legend>
</fieldset>
```

---

# Label

Associates text with an input.

```html
<label for="email">
  Email
</label>

<input
  id="email"
  type="email"
>
```

Benefits:

* Better Accessibility
* Better User Experience

---

# Text Input

```html
<input type="text">
```

Used for:

* Name
* Username
* City

---

# Email Input

```html
<input
  type="email"
  required
>
```

Validates email format automatically.

---

# Password Input

```html
<input
  type="password"
>
```

Hides entered text.

---

# Number Input

```html
<input
  type="number"
  step="5"
>
```

Used for numeric values.

---

# Range Input

```html
<input
  type="range"
>
```

Used for sliders.

---

# Date Inputs

```html
<input type="date">

<input type="month">

<input type="datetime-local">
```

---

# File Upload

```html
<input type="file">
```

Used for uploading files.

---

# Color Picker

```html
<input type="color">
```

Used to select colors.

---

# Hidden Input

```html
<input
  type="hidden"
  value="secret"
>
```

Not visible to users.

Used for sending extra data to backend.

---

# Datalist

Provides autocomplete suggestions.

```html
<input list="languages">

<datalist id="languages">
  <option value="Java">
  <option value="Python">
  <option value="JavaScript">
</datalist>
```

---

# Select Dropdown

```html
<select>

  <option>One</option>

  <option>Two</option>

</select>
```

Used to select one option.

---

# Textarea

```html
<textarea>

</textarea>
```

Used for multi-line text input.

---

# Radio Button

```html
<input
  type="radio"
  name="gender"
>
```

Only one option can be selected.

Same `name` is required.

---

# Checkbox

```html
<input
  type="checkbox"
>
```

Multiple selections allowed.

---

# Buttons

```html
<button type="submit">
  Submit
</button>

<button type="reset">
  Reset
</button>
```

---

# Validation

## Required

```html
<input
  required
>
```

Field must be filled.

---

## Pattern

```html
<input
  pattern="[A-Za-z]{3,}"
>
```

Custom validation rule.

---

## Min & Max

```html
<input
  type="number"
  min="1"
  max="10"
>
```

Restricts range.

---

# Important Attributes

| Attribute   | Purpose           |
| ----------- | ----------------- |
| name        | Sent to backend   |
| id          | Unique identifier |
| placeholder | Hint text         |
| required    | Mandatory field   |
| readonly    | Read only         |
| disabled    | Disable field     |

---

# Complete Registration Form

Concepts Used:

* Form
* Fieldset
* Legend
* Label
* Email
* Password
* Datalist
* Select
* Textarea
* Number
* Range
* Date
* File Upload
* Hidden Input
* Color Picker
* Submit Button
* Reset Button

---

# Quick Revision

## Form Tags

* `<form>`
* `<fieldset>`
* `<legend>`
* `<label>`

---

## Inputs

* text
* email
* password
* number
* range
* date
* month
* datetime-local
* file
* color
* hidden

---

## Controls

* select
* datalist
* textarea
* button

---

## Validation

* required
* pattern
* min
* max

---

# Practice File

## forms.html

Concepts Covered

* Registration Form
* Form Attributes
* Validation
* Datalist
* Dropdown
* Textarea
* Date Inputs
* File Upload
* Hidden Input
* Color Picker
