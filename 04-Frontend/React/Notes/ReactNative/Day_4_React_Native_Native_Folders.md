# 📱 Day 4 - React Native Native Folders

> Goal: Understand Android and iOS folders without becoming a native developer.

---

# 📚 Topics Covered

1. Why Native Folders Exist
2. Android Folder
3. iOS Folder
4. Important Files
5. Quick Revision
6. Interview Questions

---

# 1️⃣ Why Native Folders Exist?

React Native uses JavaScript for UI.

But mobile phones run:

- Android Native Code (Kotlin/Java)
- iOS Native Code (Swift/Objective-C)

Therefore every React Native project contains:

```text
android/
ios/
```

folders.

---

# Big Picture

```text
React Native JS
       ↓
Metro Bundle
       ↓
Android / iOS Native Layer
       ↓
APK / IPA
```

---

# 2️⃣ Android Folder

```text
android/
│
├── app/
├── build.gradle
├── gradle.properties
└── settings.gradle
```

---

## MainActivity.kt

Android Entry Point.

Think:

```text
Android App Starts Here
```

Responsibilities:

- Launch App
- Connect Native ↔ React Native

---

## AndroidManifest.xml

Stores:

- Permissions
- Activities
- App Metadata

Examples:

```xml
<uses-permission android:name="android.permission.CAMERA"/>
```

```xml
<uses-permission android:name="android.permission.INTERNET"/>
```

---

## build.gradle

Android Build Configuration.

Controls:

- SDK Versions
- Dependencies
- Build Types

Example:

```gradle
compileSdkVersion 35
minSdkVersion 24
targetSdkVersion 35
```

---

## gradle.properties

Global Android Settings.

Examples:

```properties
hermesEnabled=true
```

```properties
newArchEnabled=true
```

---

## res Folder

Stores:

```text
Images
Icons
Strings
Themes
```

Important folders:

```text
drawable/
mipmap/
values/
```

---

# 3️⃣ iOS Folder

```text
ios/
│
├── AppDelegate.swift
├── Info.plist
├── Images.xcassets
├── Pods/
└── Project.xcodeproj
```

---

## AppDelegate.swift

iOS Entry Point.

Equivalent to:

```text
MainActivity.kt
```

on Android.

---

## Info.plist

Most important iOS config file.

Stores:

- App Name
- Permissions
- Bundle Identifier

Examples:

```xml
NSCameraUsageDescription
```

```xml
NSLocationWhenInUseUsageDescription
```

---

## Images.xcassets

Stores:

- App Icons
- Splash Images
- Assets

---

## Pods

iOS Dependencies.

Think:

```text
node_modules
     ↓
Pods
```

for iOS.

---

## Podfile.lock

Equivalent to:

```text
package-lock.json
```

Locks dependency versions.

---

## Project.xcodeproj

Main iOS project file.

Opened inside:

```text
Xcode
```

---

# 4️⃣ Important Root Files

## .gitignore

Ignore:

```text
node_modules
Pods
build
```

---

## tsconfig.json

TypeScript Rules.

Controls:

- Type Checking
- Compiler Rules

---

## README.md

Project Documentation.

Contains:

- Setup
- Commands
- Project Rules

---

# 5️⃣ Android vs iOS Mapping

| Android             | iOS               |
| ------------------- | ----------------- |
| MainActivity.kt     | AppDelegate.swift |
| AndroidManifest.xml | Info.plist        |
| Gradle              | CocoaPods         |
| build.gradle        | Podfile           |
| Android Studio      | Xcode             |

---

# 🎙️ Interview Questions

## What is MainActivity.kt?

Android app entry point.

---

## What is AndroidManifest.xml?

Stores Android permissions and metadata.

---

## What is build.gradle?

Android build configuration file.

---

## What is AppDelegate.swift?

iOS application entry point.

---

## What is Info.plist?

iOS configuration and permission file.

---

## What are Pods?

iOS native dependencies.

---

## What is CocoaPods?

Dependency manager for iOS.

---

# ⚡ Quick Revision

```text
Android
↓
MainActivity
↓
Manifest
↓
Gradle

iOS
↓
AppDelegate
↓
Info.plist
↓
Pods
↓
Xcode
```

---

# 🎯 30-Second Interview Answer

React Native projects contain Android and iOS folders because the final application runs on native platforms. Android uses MainActivity, AndroidManifest, and Gradle for configuration and builds. iOS uses AppDelegate, Info.plist, CocoaPods, and Xcode. Understanding these files helps developers configure permissions, manage dependencies, and debug native build issues.

---

# ✅ End of Day 4 Notes
