This should actually be **Day 4**, because:

* Day 1 → Environment Setup
* Day 2 → package.json, package-lock.json, app.json
* Day 3 → npm, Metro, Babel, Hermes, node_modules
* Day 4 → Android & iOS Folder Structure (Native Side)

---

# Day 4 - React Native Native Folder Structure Deep Dive

## Android & iOS Architecture

> Goal: Understand what happens behind the UI layer and learn the native structure used by Android and iOS applications.

---

# 📚 Topics Covered

1. Why Learn Native Folders?
2. Android Folder Structure
3. Gradle
4. MainActivity.kt
5. Android Resources Folder
6. AndroidManifest.xml
7. build.gradle
8. gradle.properties
9. iOS Folder Structure
10. AppDelegate.swift
11. Images.xcassets
12. Info.plist
13. CocoaPods
14. Xcode Project
15. Root Configuration Files
16. Interview Questions
17. Quick Revision

---

# 1️⃣ Why Learn Native Folders?

Many React Native developers only learn:

* Components
* Navigation
* APIs
* State Management

But real-world development requires understanding:

* Android Native Layer
* iOS Native Layer
* Build Systems
* Permissions
* App Configuration

---

# React Native Architecture

```text
React Native JS Code
          ↓
Metro Bundle
          ↓
Native Bridge
          ↓
Android / iOS Native Code
          ↓
APK / IPA
```

---

# 2️⃣ Android Folder Structure

```text
android
│
├── app
│   └── src
│       └── main
│
├── build.gradle
├── gradle.properties
│
└── settings.gradle
```

---

# 3️⃣ What is Gradle?

Gradle is Android's Build Automation Tool.

Think of Gradle as:

```text
Metro → Bundles JS

Gradle → Builds Android App
```

Responsibilities:

* Dependency Management
* APK Generation
* Build Configuration
* SDK Management

---

# Gradle Flow

```text
React Native Code
         ↓
Metro Bundle
         ↓
Gradle Build
         ↓
APK / AAB Generated
```

---

# 4️⃣ MainActivity.kt

Location:

```text
android/app/src/main/java/
```

---

## What is MainActivity?

MainActivity is the entry point of the Android application.

Similar to:

```js
index.js
```

for React Native.

---

## Responsibility

* Launch Application
* Load React Native Root View
* Connect Android to JS Bundle

---

# 5️⃣ Android Resources Folder

Location:

```text
android/app/src/main/res
```

---

## Drawable

Stores:

* Images
* Shapes
* Backgrounds

Example:

```text
drawable/
```

---

## Mipmap

Stores App Icons.

Example:

```text
mipmap-mdpi
mipmap-hdpi
mipmap-xhdpi
mipmap-xxhdpi
```

Different folders support different screen densities.

---

## Values Folder

Contains:

```text
values/
```

Files:

```text
strings.xml
styles.xml
```

---

### strings.xml

Stores:

```text
Application Name
```

Example:

```xml
<string name="app_name">
MyApp
</string>
```

---

### styles.xml

Stores:

```text
App Themes
Colors
Styling Configuration
```

---

# 6️⃣ AndroidManifest.xml

One of the most important Android files.

Location:

```text
android/app/src/main/
```

---

## Purpose

Stores:

* Permissions
* Activities
* Application Metadata

---

## Common Permissions

Camera:

```xml
<uses-permission
android:name="android.permission.CAMERA"/>
```

Location:

```xml
<uses-permission
android:name="android.permission.ACCESS_FINE_LOCATION"/>
```

Internet:

```xml
<uses-permission
android:name="android.permission.INTERNET"/>
```

---

# 7️⃣ build.gradle

Controls Android Build Configuration.

---

## Responsibilities

* SDK Version
* Dependencies
* Build Types
* Gradle Plugins

---

## Example

```gradle
compileSdkVersion 35
minSdkVersion 24
targetSdkVersion 35
```

---

# Understanding SDK Versions

## compileSdk

Version used during compilation.

## minSdk

Minimum supported Android version.

## targetSdk

Android version optimized for.

---

# 8️⃣ gradle.properties

Global Android build configuration file.

---

## Common Features

### Enable Hermes

```properties
hermesEnabled=true
```

---

### Enable New Architecture

```properties
newArchEnabled=true
```

---

### ABI Optimization

```properties
reactNativeArchitectures=arm64-v8a
```

---

# What is ABI?

ABI = Application Binary Interface

Defines CPU architectures supported by the app.

Examples:

```text
arm64-v8a
armeabi-v7a
x86
x86_64
```

---

# 9️⃣ iOS Folder Structure

```text
ios
│
├── AppDelegate.swift
├── Info.plist
├── Images.xcassets
│
├── Pods
├── Podfile.lock
│
└── Project.xcodeproj
```

---

# 🔟 AppDelegate.swift

iOS Entry Point.

Equivalent to:

```text
MainActivity.kt
```

on Android.

---

## Responsibilities

* Launch App
* Configure Native Services
* Initialize React Native

---

# 1️⃣1️⃣ Images.xcassets

Stores:

* App Icons
* Splash Images
* Visual Assets

---

## Purpose

iOS automatically selects appropriate image sizes.

---

# 1️⃣2️⃣ Info.plist

Most important iOS configuration file.

---

## Stores

* Permissions
* App Name
* Bundle Identifier
* Orientation Support
* Configuration Keys

---

## Example Permissions

Camera:

```xml
NSCameraUsageDescription
```

Location:

```xml
NSLocationWhenInUseUsageDescription
```

---

# 1️⃣3️⃣ CocoaPods

iOS Dependency Manager.

Equivalent to:

```text
npm → JavaScript

CocoaPods → iOS
```

---

## Pods Folder

Contains:

```text
Native iOS Libraries
```

---

## Podfile.lock

Equivalent to:

```text
package-lock.json
```

Locks exact dependency versions.

---

# 1️⃣4️⃣ Xcode Project

File:

```text
Project.xcodeproj
```

---

## Purpose

Main iOS project workspace.

Used for:

* Build Settings
* Signing
* Capabilities
* Deployment

---

# 1️⃣5️⃣ Root Configuration Files

---

## .gitignore

Prevents committing:

```text
node_modules
Pods
build
```

---

## tsconfig.json

TypeScript Configuration.

Controls:

* Type Checking
* Compiler Rules
* File Inclusion
* Exclusions

---

## README.md

Stores:

* Setup Instructions
* Project Rules
* Team Documentation

---

# 🎙️ Interview Questions

## What is Gradle?

Android build automation tool responsible for dependency management and APK generation.

---

## What is MainActivity.kt?

Entry point of Android application.

---

## What is AndroidManifest.xml?

Configuration file that stores permissions and application metadata.

---

## What is build.gradle?

Android build configuration file.

---

## What is gradle.properties?

Global Android build settings file.

---

## What is AppDelegate.swift?

Entry point of iOS application.

---

## What is Info.plist?

iOS configuration file storing permissions and app settings.

---

## What is CocoaPods?

Dependency manager for iOS native libraries.

---

## What is Podfile.lock?

Locks exact iOS dependency versions.

---

## What is Xcode Project?

Main iOS workspace used to manage build settings and deployment.

---

# 🧠 Mental Models

| Concept         | Analogy                   |
| --------------- | ------------------------- |
| Gradle          | Android Factory Manager   |
| MainActivity    | Android Main Gate         |
| AndroidManifest | Android Rule Book         |
| build.gradle    | Android Settings Panel    |
| AppDelegate     | iOS Main Gate             |
| Info.plist      | iOS Rule Book             |
| CocoaPods       | npm for iOS               |
| Podfile.lock    | package-lock.json for iOS |
| Xcode           | Android Studio for iOS    |

---

# ⚡ Quick Revision

```text
Gradle
↓
Build Android App

MainActivity
↓
Android Entry Point

AndroidManifest
↓
Permissions

build.gradle
↓
Build Configuration

gradle.properties
↓
Global Android Settings

AppDelegate
↓
iOS Entry Point

Info.plist
↓
iOS Permissions

Pods
↓
iOS Dependencies

Podfile.lock
↓
Locks Versions

Xcode Project
↓
iOS Workspace
```

---

# 🎯 30-Second Interview Answer

React Native applications contain native Android and iOS folders. On Android, Gradle builds the application, MainActivity serves as the entry point, AndroidManifest manages permissions, and build.gradle controls SDK versions and dependencies. On iOS, AppDelegate acts as the entry point, Info.plist stores permissions and configuration, CocoaPods manages dependencies, and Xcode is used for project management. Understanding these files helps developers debug native issues and build production-ready mobile applications.

---

# 📖 End of Day 4 Notes

```
```
