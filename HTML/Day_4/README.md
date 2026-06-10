# HTML Day 4: Forms

## 📖 Overview

Today you'll learn to create **interactive forms** that collect user input. Forms are the primary way websites gather information from visitors.

---

## 🎯 Learning Objectives

✅ Create form structure  
✅ Use various input types  
✅ Add labels and placeholders  
✅ Create select dropdowns  
✅ Build text areas  
✅ Implement form validation  
✅ Ensure accessibility in forms

---

## 📚 Key Concepts

### **1. Basic Form Structure**

```html
<form action="/submit" method="POST">
  <!-- Form elements here -->
  <button type="submit">Submit</button>
</form>
```

### **2. Input Types**

```html
<!-- Text Input -->
<input type="text" name="username" placeholder="Enter username" />

<!-- Email Input -->
<input type="email" name="email" placeholder="your@email.com" />

<!-- Password Input -->
<input type="password" name="password" placeholder="Enter password" />

<!-- Number Input -->
<input type="number" name="age" min="0" max="120" />

<!-- Date Input -->
<input type="date" name="birthday" />

<!-- Checkbox -->
<input type="checkbox" name="agree" id="agree" />
<label for="agree">I agree to terms</label>

<!-- Radio Button -->
<input type="radio" name="gender" value="male" /> Male
<input type="radio" name="gender" value="female" /> Female

<!-- File Input -->
<input type="file" name="profile_pic" />

<!-- Submit Button -->
<input type="submit" value="Submit" />
```

### **3. Form Elements**

```html
<!-- Text Area (Multi-line) -->
<textarea
  name="message"
  rows="4"
  cols="50"
  placeholder="Your message..."
></textarea>

<!-- Select Dropdown -->
<select name="country">
  <option value="">Select Country</option>
  <option value="us">United States</option>
  <option value="uk">United Kingdom</option>
</select>
```

---

### **4. Complete Form Example**

```html
<form action="/register" method="POST">
  <!-- Text Input -->
  <label for="name">Name:</label>
  <input type="text" id="name" name="name" required />

  <!-- Email Input -->
  <label for="email">Email:</label>
  <input type="email" id="email" name="email" required />

  <!-- Password Input -->
  <label for="password">Password:</label>
  <input type="password" id="password" name="password" required />

  <!-- Select -->
  <label for="country">Country:</label>
  <select id="country" name="country">
    <option>Select...</option>
    <option>USA</option>
    <option>UK</option>
  </select>

  <!-- Checkbox -->
  <input type="checkbox" id="agree" name="agree" required />
  <label for="agree">I agree to terms</label>

  <!-- Submit -->
  <button type="submit">Register</button>
  <button type="reset">Clear</button>
</form>
```

---

## 💻 Practice Examples

### **Login Form**

```html
<form>
  <label for="user">Username:</label>
  <input type="text" id="user" name="username" required />

  <label for="pass">Password:</label>
  <input type="password" id="pass" name="password" required />

  <button type="submit">Login</button>
</form>
```

### **Contact Form**

```html
<form>
  <label for="name">Name:</label>
  <input type="text" id="name" name="name" required />

  <label for="email">Email:</label>
  <input type="email" id="email" name="email" required />

  <label for="msg">Message:</label>
  <textarea id="msg" name="message" rows="5"></textarea>

  <button type="submit">Send</button>
</form>
```

---

## 📋 Checklist

- [ ] Create basic form structure
- [ ] Use appropriate input types
- [ ] Add labels to all inputs
- [ ] Use placeholders
- [ ] Add form validation (required, pattern)
- [ ] Understand form attributes (action, method)
- [ ] Make forms accessible

---

## 🔗 Next: [Day 5 - Semantics & Accessibility](../Day_5/README.md)

_Forms are the bridge between users and your application!_
