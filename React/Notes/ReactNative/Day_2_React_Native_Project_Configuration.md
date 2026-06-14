# 📦 Day 2 - React Native Project Configuration

> Goal: Understand package.json, package-lock.json, app.json and dependency management.

---

# 📚 Topics Covered

1. package.json
2. package-lock.json
3. app.json
4. Dependencies vs DevDependencies
5. Semantic Versioning
6. Quick Revision
7. Interview Questions

---

# 1️⃣ package.json

The heart of every React Native project.

Stores:

* Project Information
* Scripts
* Dependencies
* Dev Dependencies

---

## Example

```json
{
  "name": "MyApp",
  "version": "1.0.0",
  "private": true
}
```

---

## Important Fields

| Field           | Purpose              |
| --------------- | -------------------- |
| name            | Project Name         |
| version         | Project Version      |
| private         | Prevent npm publish  |
| scripts         | Commands             |
| dependencies    | Production Packages  |
| devDependencies | Development Packages |

---

# 2️⃣ Scripts

Scripts are shortcuts for commands.

Example:

```json
"scripts": {
  "android": "react-native run-android",
  "ios": "react-native run-ios",
  "start": "react-native start"
}
```

---

## Common Commands

```bash
npm start
```

Start Metro

```bash
npm run android
```

Run Android App

```bash
npm run ios
```

Run iOS App

---

# 3️⃣ Dependencies vs DevDependencies

## Dependencies

Required in production.

Examples:

* react
* react-native
* axios
* react-navigation

```json
"dependencies": {
  "react": "18.2.0"
}
```

---

## DevDependencies

Required only during development.

Examples:

* babel
* eslint
* typescript
* jest

```json
"devDependencies": {
  "typescript": "^5.0.0"
}
```

---

# 4️⃣ Semantic Versioning

Format:

```text
MAJOR.MINOR.PATCH
```

Example:

```text
5.5.2
```

---

## Version Meaning

| Part  | Meaning          |
| ----- | ---------------- |
| Major | Breaking Changes |
| Minor | New Features     |
| Patch | Bug Fixes        |

---

# 5️⃣ Caret (^)

Example:

```json
"react": "^18.2.0"
```

Allows:

✅ Minor Updates

✅ Patch Updates

Blocks:

❌ Major Updates

---

## Example

Allowed:

```text
18.2.1
18.3.0
18.9.5
```

Not Allowed:

```text
19.0.0
```

---

# 6️⃣ Tilde (~)

Example:

```json
"react": "~18.2.0"
```

Allows:

✅ Patch Updates

Blocks:

❌ Minor Updates

❌ Major Updates

---

## Example

Allowed:

```text
18.2.1
18.2.5
```

Not Allowed:

```text
18.3.0
19.0.0
```

---

# 7️⃣ package-lock.json

Locks exact dependency versions.

Purpose:

* Consistent Builds
* Same Environment
* Stable Deployments

---

## Simple Understanding

```text
package.json
↓
What we want

package-lock.json
↓
What we actually installed
```

---

# 8️⃣ app.json

Stores app-level configuration.

Example:

```json
{
  "name": "MyApp",
  "displayName": "My Application"
}
```

---

## Common Uses

* App Name
* Display Name
* Basic Configuration

---

# 9️⃣ Project Dependency Flow

```text
package.json
      ↓
npm install
      ↓
package-lock.json
      ↓
node_modules
      ↓
Application Runs
```

---

# 🎙️ Interview Questions

## What is package.json?

Stores project metadata, scripts, and dependencies.

---

## What is package-lock.json?

Locks exact dependency versions.

---

## Difference between dependencies and devDependencies?

Dependencies are required in production.

DevDependencies are required only during development.

---

## Difference between ^ and ~ ?

^ allows Minor + Patch updates.

~ allows only Patch updates.

---

## What is app.json?

Stores application-level configuration.

---

# ⚡ Quick Revision

```text
package.json
↓
Project Configuration

package-lock.json
↓
Exact Versions

dependencies
↓
Production Packages

devDependencies
↓
Development Packages

^
↓
Minor + Patch

~
↓
Patch Only

app.json
↓
App Configuration
```

---

# 📌 Important Keywords

* package.json
* package-lock.json
* app.json
* dependencies
* devDependencies
* SemVer
* Caret (^)
* Tilde (~)
* npm install

---

# 🎯 30-Second Interview Answer

package.json defines project metadata, scripts, and dependencies. package-lock.json locks exact dependency versions to ensure consistent builds across environments. app.json stores application-level configuration. Together, these files help manage dependencies, project setup, and build stability in React Native applications.

---

# ✅ End of Day 2 Notes
