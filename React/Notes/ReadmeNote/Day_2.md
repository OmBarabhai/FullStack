# Day 2 - Understanding `package.json`, `package-lock.json`, and `app.json` in React Native

## 📚 Overview

In today’s session, we explored the most important configuration and dependency management files used in React Native projects:

* `package.json`
* `package-lock.json`
* `app.json`

We also learned about **Semantic Versioning (SemVer)** and how dependency versions are controlled in modern JavaScript applications.

---

# 1️⃣ Understanding `package.json`

The `package.json` file is the heart of every React Native and Node.js project.

It stores:

* Project metadata
* Scripts
* Dependencies
* Development tools
* Version information

---

## 📌 Example Structure

```json
{
  "name": "MyApp",
  "version": "1.0.0",
  "private": true,
  "scripts": {
    "android": "react-native run-android",
    "ios": "react-native run-ios",
    "start": "react-native start"
  },
  "dependencies": {
    "react": "18.2.0",
    "react-native": "0.72.0"
  },
  "devDependencies": {
    "@babel/core": "^7.20.0",
    "typescript": "^5.0.0"
  }
}
```

---

# 🔹 Important Properties in `package.json`

---

## 1. `name`

Defines the project name.

```json
"name": "MyApp"
```

---

## 2. `version`

Represents the current version of the app.

```json
"version": "1.0.0"
```

Version format follows:

```txt
Major.Minor.Patch
```

Example:

```txt
2.5.1
```

Where:

| Type  | Meaning          |
| ----- | ---------------- |
| Major | Breaking changes |
| Minor | New features     |
| Patch | Bug fixes        |

---

## 3. `private`

```json
"private": true
```

### Purpose:

Prevents accidental publishing of the app to the npm registry.

If set to:

```json
true
```

npm will block publishing.

---

# 2️⃣ Scripts in `package.json`

Scripts are shortcuts for command-line operations.

---

## 📌 Example

```json
"scripts": {
  "android": "react-native run-android",
  "ios": "react-native run-ios",
  "start": "react-native start"
}
```

---

## 🚀 Running Scripts

### Run Android App

```bash
npm run android
```

### Run iOS App

```bash
npm run ios
```

### Start Metro Bundler

```bash
npm start
```

---

# 3️⃣ Dependencies vs DevDependencies

---

## 🔹 Dependencies

Packages required for the app to run in production.

Example:

```json
"dependencies": {
  "react": "18.2.0",
  "react-native": "0.72.0"
}
```

### Common Production Dependencies

* React
* React Native
* Redux
* Axios
* React Navigation

---

## 🔹 devDependencies

Packages only needed during development.

Example:

```json
"devDependencies": {
  "@babel/core": "^7.20.0",
  "typescript": "^5.0.0"
}
```

### Common Development Tools

| Tool       | Purpose            |
| ---------- | ------------------ |
| Babel      | Converts modern JS |
| Metro      | Bundler            |
| TypeScript | Static typing      |
| ESLint     | Code quality       |
| Jest       | Testing            |

---

# 4️⃣ Semantic Versioning (SemVer)

Semantic Versioning helps manage dependency updates safely.

Format:

```txt
MAJOR.MINOR.PATCH
```

Example:

```txt
1.4.2
```

---

## 🔹 MAJOR Updates

```txt
2.0.0
```

* Breaking changes
* Existing code may stop working

---

## 🔹 MINOR Updates

```txt
1.5.0
```

* Adds new features
* Backward compatible

---

## 🔹 PATCH Updates

```txt
1.4.3
```

* Bug fixes only
* Safe updates

---

# 5️⃣ Understanding `^` (Caret)

Example:

```json
"react": "^18.2.0"
```

Allows:

✅ Minor updates
✅ Patch updates

Blocks:

❌ Major updates

---

## Allowed Versions

```txt
18.2.1
18.3.0
18.9.5
```

## Not Allowed

```txt
19.0.0
```

---

# 6️⃣ Understanding `~` (Tilde)

Example:

```json
"react": "~18.2.0"
```

Allows only:

✅ Patch updates

Blocks:

❌ Minor updates
❌ Major updates

---

## Allowed Versions

```txt
18.2.1
18.2.5
```

## Not Allowed

```txt
18.3.0
19.0.0
```

---

# 7️⃣ Understanding `package-lock.json`

This file locks the exact versions of all installed packages.

It ensures:

✅ Same dependencies for every developer
✅ Consistent builds
✅ Stable production deployment

---

# 📌 Why It Is Important

Without `package-lock.json`:

Different developers may install different dependency versions.

This can cause:

* Bugs
* Build failures
* Inconsistent behavior

---

# 📌 Example

```json
"react": {
  "version": "18.2.0",
  "resolved": "https://registry.npmjs.org/react/-/react-18.2.0.tgz",
  "integrity": "sha512-xxxxx"
}
```

---

# 🔹 Important Fields

| Field     | Purpose                 |
| --------- | ----------------------- |
| version   | Exact installed version |
| resolved  | Download URL            |
| integrity | Security hash           |
| license   | Package license         |

---

# 8️⃣ Transitive Dependencies

Dependencies of dependencies are called:

```txt
Transitive Dependencies
```

Example:

```txt
React Native → Babel → Many internal packages
```

`package-lock.json` records all of them.

---

# 9️⃣ Understanding `app.json`

This file stores application-level configuration.

---

## 📌 Example

```json
{
  "name": "MyApp",
  "displayName": "My Application"
}
```

---

# 🔹 In Bare React Native CLI

Used mostly for:

* App name
* Display name
* Basic configuration

---

# 🔹 In Expo Projects

`app.json` becomes very important.

It manages:

* Android Manifest
* iOS Info.plist
* Splash screens
* Icons
* Permissions
* Build settings

---

# 🔟 Bare CLI vs Expo

| Feature             | Bare CLI | Expo      |
| ------------------- | -------- | --------- |
| Native Code Access  | Full     | Limited   |
| app.json Importance | Basic    | Very High |
| Setup Complexity    | More     | Easier    |
| Flexibility         | Maximum  | Moderate  |

---

# 🧠 Key Learnings

✅ `package.json` manages project metadata and dependencies

✅ `scripts` simplify command execution

✅ `dependencies` are required in production

✅ `devDependencies` are only for development

✅ SemVer prevents unsafe updates

✅ `package-lock.json` ensures consistency

✅ `app.json` controls app-level configuration

---

# 🚀 Important Commands

## Install Packages

```bash
npm install
```

---

## Install Dependency

```bash
npm install axios
```

---

## Install Dev Dependency

```bash
npm install typescript --save-dev
```

---

## Start Metro

```bash
npm start
```

---

## Run Android

```bash
npm run android
```

---

## Run iOS

```bash
npm run ios
```

---

# 🎯 Final Conclusion

Understanding these files is essential for becoming a professional React Native developer.

These configurations help in:

* Dependency management
* Project stability
* Team collaboration
* Production deployment
* Version control
* Build consistency

Mastering them makes debugging and maintaining React Native projects much easier.

---

# 📖 End of Day 2 Notes
