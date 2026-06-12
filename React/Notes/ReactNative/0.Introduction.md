# React Native CLI Setup Guide (2026)

## Day 1 - Development Environment Foundations

---

# Table of Contents

1. Introduction
2. Why React Native CLI?
3. Core Development Architecture
4. Required Tools Overview
5. Node.js
6. Watchman
7. Java Development Kit (JDK)
8. Android Studio
9. Android SDK
10. Environment Variables
11. Android Virtual Device (AVD)
12. Metro Bundler
13. VS Code Setup
14. macOS Setup Flow
15. Windows Setup Flow
16. iOS Development (macOS)
17. Common Build Errors
18. Important Interview Questions
19. Real-World Development Insights
20. Final Summary

---

# 1. Introduction

React Native CLI setup is the foundation of native mobile development.

Unlike Expo, React Native CLI provides:

- full native Android/iOS access
- better scalability
- custom native module support
- production-level architecture
- native debugging capabilities

Understanding the setup process is critical because most React Native issues involve environment configuration.

---

# 2. Why React Native CLI?

## React Native CLI vs Expo

| React Native CLI           | Expo                      |
| -------------------------- | ------------------------- |
| Full native access         | Limited native access     |
| Native modules supported   | Restricted native modules |
| Better for enterprise apps | Faster beginner setup     |
| Complex setup              | Simple setup              |
| More control               | Less control              |

---

## Why Professionals Use CLI

CLI enables:

- custom Android/iOS integrations
- advanced native development
- optimized builds
- enterprise architecture
- native SDK integrations

---

# 3. Core Development Architecture

## React Native CLI Stack

```text id="qg9d22"
Developer Code
      ↓
React Native
      ↓
Metro Bundler
      ↓
Android/iOS Native Bridge
      ↓
Android Emulator / iPhone Simulator
```

---

# 4. Required Tools Overview

To build React Native applications, developers need:

| Tool           | Purpose                |
| -------------- | ---------------------- |
| Node.js        | JavaScript runtime     |
| npm/npx        | Package management     |
| Watchman       | File watching          |
| JDK            | Android compilation    |
| Android Studio | Android SDK + Emulator |
| Metro          | JavaScript bundler     |
| VS Code        | Code editor            |

---

# 5. Node.js

## What is Node.js?

Node.js is a JavaScript runtime environment.

Official Site:

https://nodejs.org

---

## Why React Native Needs Node.js

Node.js powers:

- Metro bundler
- npm
- npx
- package installation
- development tooling

---

## Important Clarification

Node.js does NOT directly build Android apps.

It powers the JavaScript tooling ecosystem.

---

## Verify Installation

```bash id="f4itvk"
node -v
npm -v
```

---

# 6. Watchman

## What is Watchman?

A file monitoring service created by Meta.

Official Site:

https://facebook.github.io/watchman/

---

## Purpose

Watchman tracks file changes efficiently.

Example:

```text id="gsv84i"
App.js changed
      ↓
Metro instantly rebuilds app
```

---

## Why Important?

Without Watchman:

- hot reload becomes slower
- file detection may fail
- Metro performance decreases

---

## macOS Installation

```bash id="v4ktq2"
brew install watchman
```

---

# 7. Java Development Kit (JDK)

## What is JDK?

Java Development Kit is required for Android compilation.

---

## Recommended Version

Zulu OpenJDK 17

---

## Why JDK is Needed

Android builds internally use:

- Java
- Kotlin
- Gradle

React Native Android apps compile into native Android binaries.

---

## macOS Installation

```bash id="t7i1yh"
brew install --cask zulu@17
```

---

## Verify Installation

```bash id="xprv7o"
java -version
```

---

# 8. Android Studio

## What is Android Studio?

Official Android development IDE by Google.

Official Site:

https://developer.android.com/studio

---

## React Native Uses Android Studio For

- Android SDK
- Emulator
- Build tools
- Platform APIs
- Gradle integration

---

## Important Components

During installation install:

- Android SDK
- Android SDK Platform
- Android Virtual Device (AVD)
- Build Tools

---

# 9. Android SDK

## What is Android SDK?

Software Development Kit for Android development.

Contains:

- APIs
- platform tools
- adb
- build tools
- emulator support

---

## Important SDK Components

### SDK Platform

Example:

```text id="hghgj5"
Android 15 (API 35)
```

---

## Build Tools

Used during APK generation.

---

## Platform Tools

Contains:

```bash id="5ehpsv"
adb
```

Android Debug Bridge.

---

# 10. Environment Variables

## Why Environment Variables Matter

React Native tools must know where SDKs are installed.

---

# ANDROID_HOME

Points to Android SDK location.

Example:

```bash id="4ts7mf"
ANDROID_HOME=/Users/username/Library/Android/sdk
```

---

# Add Platform Tools to PATH

```bash id="7xz1kt"
platform-tools
emulator
tools
```

---

## Why PATH Matters

Allows terminal commands globally:

```bash id="8phs6y"
adb devices
emulator
```

---

# 11. Android Virtual Device (AVD)

## What is an Emulator?

A virtual Android phone running on your computer.

---

## Managed Through

Android Studio → Device Manager

---

## Example Devices

- Pixel 9A
- Pixel 8
- Pixel Fold

---

## Why Important?

Enables testing without physical devices.

---

# 12. Metro Bundler

## What is Metro?

React Native’s JavaScript bundler.

Responsibilities:

- dependency resolution
- transformation
- bundling
- hot reload

---

## Metro Flow

```text id="1ny4fi"
Code Change
     ↓
Watchman Detects Change
     ↓
Metro Rebuilds Bundle
     ↓
Emulator Updates App
```

---

# 13. VS Code Setup

## Recommended Editor

Visual Studio Code

Official Site:

https://code.visualstudio.com

---

## Recommended Extensions

| Extension          | Purpose       |
| ------------------ | ------------- |
| ES7 React Snippets | Faster coding |
| React Native Tools | Debugging     |
| Prettier           | Formatting    |
| ESLint             | Code quality  |

---

# 14. macOS Setup Flow

## Recommended Tools

| Tool     | Recommendation  |
| -------- | --------------- |
| Homebrew | Package manager |
| Watchman | Required        |
| Xcode    | iOS development |

---

## Homebrew

Official Site:

https://brew.sh

---

## Why Use Homebrew?

Simplifies installations:

```bash id="2p0s7g"
brew install node
brew install watchman
```

---

# 15. Windows Setup Flow

## Recommended Tool

Chocolatey

Official Site:

https://chocolatey.org

---

## Why Chocolatey?

Simplifies package installation.

Example:

```bash id="nm75g5"
choco install nodejs
```

---

# 16. iOS Development (macOS Only)

## Required Tool

Xcode

Official Site:

https://developer.apple.com/xcode/

---

## Xcode Provides

- iOS Simulator
- iOS SDK
- build tools
- signing support

---

## Simulator Example

```text id="n2ngm0"
iPhone 16 Simulator
```

---

# 17. Common Build Errors

## JAVA_HOME Not Found

Cause:

- incorrect JDK configuration

Fix:

```bash id="rmt1gs"
export JAVA_HOME=...
```

---

## SDK Location Not Found

Cause:

- ANDROID_HOME missing

---

## adb Not Recognized

Cause:

- platform-tools not added to PATH

---

## Metro Cache Problems

Fix:

```bash id="wb23u7"
npx react-native start --reset-cache
```

---

# 18. Important Interview Questions

---

## Q1. Why is Node.js required in React Native?

Node.js powers development tooling like Metro, npm, and bundling.

---

## Q2. What is Watchman?

A file watching service used for efficient hot reload and rebuild detection.

---

## Q3. Why is JDK needed?

Android apps compile using Java/Kotlin and Gradle.

---

## Q4. What is Android SDK?

A toolkit containing Android APIs, build tools, and debugging utilities.

---

## Q5. What is Metro Bundler?

React Native’s JavaScript bundler responsible for dependency resolution and code transformation.

---

## Q6. Why are environment variables important?

They allow tools to locate SDKs and build dependencies.

---

# 19. Real-World Development Insights

---

## Environment Setup Is a Skill

Many React Native developers struggle with:

- Gradle
- SDK paths
- build tools
- emulator issues

Understanding setup deeply improves debugging skills.

---

## Read Official Documentation

Official React Native docs are essential.

They contain:

- updated compatibility requirements
- version support
- migration guides

---

## Professional Developers Understand Tooling

Strong developers know:

- Metro internals
- Android build systems
- dependency resolution
- native debugging

not just UI coding.

---

Your Day 1 is good, but for **revision + interviews**, it is too long for daily review.

I would keep the detailed notes, but add a **"Quick Revision Section"** at the top and a **"Interview Cheat Sheet"** at the bottom.

Add this to your Day_1.md.

---

# 🚀 Day 1 Quick Revision (2-Minute Revision)

## React Native CLI

React Native CLI is used to build production-grade mobile applications with full access to Android and iOS native code.

### CLI vs Expo

| CLI                   | Expo                  |
| --------------------- | --------------------- |
| Full Native Access    | Limited Native Access |
| Enterprise Apps       | Beginner Friendly     |
| More Control          | Less Control          |
| Custom Native Modules | Restricted            |

---

## Development Flow

```text
Developer Code
      ↓
React Native
      ↓
Metro Bundler
      ↓
Native Bridge
      ↓
Android/iOS Device
```

---

## Essential Tools

| Tool           | Purpose               |
| -------------- | --------------------- |
| Node.js        | JavaScript Runtime    |
| npm            | Package Manager       |
| Watchman       | File Change Detection |
| JDK            | Android Compilation   |
| Android Studio | SDK + Emulator        |
| Android SDK    | Android APIs & Tools  |
| Metro          | Bundling              |
| VS Code        | Development           |

---

## Most Important Commands

### Check Node

```bash
node -v
npm -v
```

### Check Java

```bash
java -version
```

### Start Metro

```bash
npm start
```

### Reset Metro Cache

```bash
npx react-native start --reset-cache
```

### Run Android

```bash
npx react-native run-android
```

---

# 🧠 Mental Model

Think of React Native as:

```text
React Native = UI Layer

Metro = Bundler

JDK = Android Compiler

Android SDK = Android Tools

Emulator = Virtual Phone
```

---

# 🎯 Most Asked Interview Questions

## What is React Native CLI?

A framework that allows developers to build Android and iOS applications using JavaScript while providing access to native code.

---

## Why use CLI instead of Expo?

CLI provides:

- Native module support
- Native code access
- Better scalability
- Enterprise-level flexibility

---

## What is Node.js?

JavaScript runtime used for React Native tooling such as Metro, npm and bundling.

---

## What is Watchman?

Meta's file monitoring service that detects file changes and improves hot reload performance.

---

## Why is JDK required?

Android applications are compiled using Java/Kotlin and Gradle.

---

## What is Android SDK?

A collection of Android APIs, build tools and debugging utilities required to build Android applications.

---

## What is Metro Bundler?

Metro is React Native's JavaScript bundler that:

- Resolves Dependencies
- Transforms Code
- Creates Bundles
- Supports Hot Reloading

---

## What is ANDROID_HOME?

Environment variable that points to Android SDK installation directory.

---

## What is ADB?

Android Debug Bridge.

Used for:

- Connecting Devices
- Installing APKs
- Debugging Applications

Command:

```bash
adb devices
```

---

# ⚠️ Common Errors & Fixes

| Error               | Cause                | Fix                 |
| ------------------- | -------------------- | ------------------- |
| JAVA_HOME Not Found | JDK Missing          | Configure JAVA_HOME |
| SDK Not Found       | ANDROID_HOME Missing | Configure SDK Path  |
| adb Not Recognized  | PATH Issue           | Add platform-tools  |
| Metro Cache Issue   | Stale Cache          | Reset Metro Cache   |

---

# 🔥 One-Line Revision

```text
Node.js → Runs JS Tooling

npm → Installs Packages

Watchman → Detects File Changes

JDK → Compiles Android

Android Studio → Provides SDK & Emulator

Android SDK → Android Development Tools

Metro → Bundles React Native Code

ADB → Connects Device

AVD → Virtual Android Phone
```

---

# 📌 Fresher Interview Answer (30 Seconds)

> React Native CLI is a framework for building Android and iOS applications using JavaScript. It provides full native access unlike Expo. The development environment requires Node.js, JDK, Android Studio, Android SDK, Metro Bundler, and an Emulator. Metro bundles JavaScript code, JDK compiles Android code, and Android SDK provides platform tools required to run the application on Android devices.

This version will make your **Day 1 notes much more revision-friendly and interview-ready** while keeping your detailed explanations below for deep study.
