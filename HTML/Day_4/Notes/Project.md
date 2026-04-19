# 📄 Registration Form (HTML)

<p align="center">
  <img src="./Images/form.png" width="700"/>
</p>

---

## 🧠 Explanation

This form collects user data like:

* Email
* Username
* Password
* Preferences (language, hobbies, etc.)

👉 Uses **POST method** for secure submission
👉 Each input has a **name attribute (important for backend)**

---

## 💻 Registration Form 

```html
<!DOCTYPE html>
<html lang="en">
<head>
  <!-- Sets character encoding to UTF-8 (supports all languages) -->
  <meta charset="UTF-8">

  <!-- Makes website responsive on mobile devices -->
  <meta name="viewport" content="width=device-width, initial-scale=1.0">

  <title>Registration Form</title>
</head>

<body>

  <!-- Main heading of the page -->
  <h1>Registration Form</h1>

  <!-- Form starts here -->
  <form
    action="/submit_form"        <!-- Backend URL where data is sent -->
    method="post"               <!-- POST method (secure, data not visible in URL) -->
    enctype="application/x-www-form-urlencoded" <!-- Default encoding type -->
    name="contactform"          <!-- Name of the form -->
    novalidate                  <!-- Disables browser default validation -->
    target="_top"               <!-- Opens response in full window -->
  >

    <!-- Fieldset groups related inputs -->
    <fieldset>
      <legend>SignUp</legend> <!-- Title of the group -->

      <!-- Email Input -->
      <label for="email">Email:</label>
      <input
        type="email"            <!-- Ensures valid email format -->
        id="email"              <!-- Connects with label -->
        name="email"            <!-- Key sent to backend -->
        placeholder="Enter Your Email"
        required                <!-- Field must be filled -->
      />
      <br><br>

      <!-- Username Input -->
      <label for="Username">Username:</label>
      <input
        type="text"
        id="Username"
        name="Username"
        placeholder="Enter Your Username"
      />
      <br><br>

      <!-- Password Input -->
      <label for="password">Password:</label>
      <input
        type="password"         <!-- Hides typed text -->
        id="password"
        name="password"
        placeholder="Enter Your Password"
      />
      <br><br>

      <!-- Datalist (Autocomplete Input) -->
      <label for="language">Select a programming language:</label>
      <input list="languages" id="language" name="languages" />

      <datalist id="languages">
        <option value="Java">
        <option value="Python">
        <option value="JavaScript">
        <option value="C++">
      </datalist>
      <br><br>

      <!-- Textarea for multi-line input -->
      <textarea name="hobbies" placeholder="Enter hobbies"></textarea>
      <br><br>

      <!-- Dropdown Selection -->
      <label for="selectNum">Select your favorite number:</label>
      <select id="selectNum" name="selectNum">
        <option value="1">One</option>
        <option value="2">Two</option>
        <option value="3">Three</option>
        <option value="4">Four</option>
      </select>
      <br><br>

      <!-- Number Input -->
      <label for="quantity">Select quantity:</label>
      <input type="number" id="quantity" name="quantity" step="5" />
      <!-- step="5" means value increases/decreases by 5 -->
      <br><br>

      <!-- Range Slider -->
      <label for="volumeCtrl">Volume Control:</label>
      <input type="range" id="volumeCtrl" name="volumeCtrl" step="1" />
      <br><br>

      <!-- Date Inputs -->
      <label for="monthP">Select month and year:</label>
      <input type="month" id="monthP" name="monthP" />
      <br><br>

      <label for="dateP">Select date:</label>
      <input type="date" id="dateP" name="dateP" />
      <br><br>

      <label for="dateT">Select date and time:</label>
      <input type="datetime-local" id="dateT" name="dateT" />
      <br><br>

      <!-- File Upload -->
      <label for="fileU">Upload a file:</label>
      <input type="file" id="fileU" name="fileU" />
      <br><br>

      <!-- Hidden Field (not visible to user) -->
      <input
        type="hidden"
        name="hidden"
        value="this is hidden"
      />
      <!-- Used to send extra data to backend -->
      <br><br>

      <!-- Color Picker -->
      <label for="colorP">Choose your color:</label>
      <input type="color" id="colorP" name="colorP" />
      <br><br>

      <!-- Form Buttons -->
      <button type="submit">Submit</button>
      <button type="reset">Reset</button>

    </fieldset>
  </form>

</body>
</html>
```

```

---

## 🎯 Key Points (Revision)

* `form` → collects data
* `input` → user fields
* `label` → improves usability
* `name` → sent to backend
* `POST` → secure
* `required` → validation

---

## 🧠 Interview Tip

👉 “Form is used to collect user data and send it to backend using GET or POST.
Each input must have a name attribute, and validation can be done using HTML or JavaScript.”

---

## 👨‍💻 Author

**OmBarabhai**
