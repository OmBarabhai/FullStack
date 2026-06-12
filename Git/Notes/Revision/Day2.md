---
<!-- ````md -->
# 🚀 Day 2 - Git Remote, Branching, Upstream & PR
---

## 📌 What I Practiced

- Cloned repository from GitHub
- Created multiple branches (Om, Rajput)
- Added and committed files
- Pushed branches to remote
- Set upstream tracking
- Created Pull Requests and merged

---

## 🔗 Clone Repository

```bash
git clone <repo-url>
cd repo-name
```

---

## 🌿 Create Branch

```bash
git checkout -b Om
git checkout -b Rajput
```

👉 Each branch is used for separate work

---

## 📄 Create File

```bash
touch file.txt
```

---

## ➕ Add & Commit

```bash
git add .
git commit -m "add file"
```

---

## 🚀 Push Branch

```bash
git push origin Om
```

👉 If upstream not set:

```bash
git push -u origin Om
```

---

## 🔁 Upstream

- Connects local branch with remote branch

After setting upstream:

```bash
git push
git pull
```

---

## ⚠️ Mistake I Learned

❌ Wrong:

```bash
git push origin main
```

👉 When working on another branch

✅ Correct:

```bash
git push origin <branch-name>
```

---

## 🔀 Pull Request (PR)

Steps:

1. Push branch
2. Go to GitHub
3. Click "Compare & Pull Request"
4. Merge into main

---

## 🔥 Real Workflow

```bash
git clone <url>
git checkout -b branch-name
touch file.txt
git add .
git commit -m "message"
git push -u origin branch-name
```

---

## ⚠️ Key Learnings

- Always push current branch
- Upstream simplifies commands
- Use branches for features
- PR is used to merge code safely

---

## 🎯 Interview Line

I cloned a repository, created branches, added and committed changes, pushed them using upstream, and created pull requests to merge into the main branch.

---

## 🖼️ Diagrams

![Git Diagram 1](images/image1.png)

![Git Diagram 2](images/image2.png)

````

---

# 🚀 FINAL STEP

```bash
git add .
git commit -m "Final Day 2 Notes"
git push
````

---

# 🧠 WHAT YOU ACHIEVED

Om listen carefully:

👉 You used:

- Multiple branches ✅
- Upstream correctly ✅
- PR flow multiple times ✅
- Real errors + fix ✅

🔥 This is **exact real developer workflow**

---
