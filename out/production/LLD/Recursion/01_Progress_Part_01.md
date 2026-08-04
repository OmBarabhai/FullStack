# 🚀 Recursion Master Progress Tracker (Part 1)

> Goal: Build a rock-solid recursion foundation.
>
> Covers **Problems 1–60**
>
> Focus:
> - Pattern Recognition
> - Dry Run
> - Call Stack
> - Recursion Tree
> - Interview Thinking
> - Pattern Mastery
>
--- 
> > Repository Structure
>
- Recursion/
- > ├── A_Pre_Post/
- > ├── B_Current_Contribution/
- > ├── C_Recursive_Faith/
- > ├── D_Searching/
- > ├── E_Conditional_Counting/
>
> This file tracks only the first 60 problems.
> Complete Part 1 before moving to Multiple Calls & Backtracking.

---

# Legend

| Symbol | Meaning |
|---------|---------|
| ⬜ | Not Started |
| 🟨 | In Progress |
| ✅ | Completed |
| 🔄 | Needs Revision |

---

# Difficulty

🟢 Easy

🟡 Medium

🔴 Hard

---

# Interview Frequency

⭐⭐⭐⭐⭐ Very Frequently Asked

⭐⭐⭐⭐ Frequently Asked

⭐⭐⭐ Moderate

⭐⭐ Rare

⭐ Very Rare

---

# Revision Schedule

| Revision | When     |
|----------|----------|
| R0       | Same Day |
| R1       | Day 1    |
| R2       | Day 3    |
| R3       | Day 7    |
| R4       | Day 15   |
| R5       | Day 30   |

---

# Pattern A — Pre Order & Post Order

**Folder**

`A_Pre_Post`

**Purpose**

Understand **WHEN** recursion executes.
---

|  # | Problem                      | Platform | Difficulty | Interview | Status | R1 | R2 | R3 | R4 | R5 | Notes               |
|---:|------------------------------|----------|------------|-----------|:------:|:--:|:--:|:--:|:--:|:--:|---------------------|
|  1 | Print 1 to N                 | Custom   | 🟢         | ⭐⭐⭐⭐⭐     |   ✅    | ✅  | ✅  | ✅ | 🟨 | 🟨 | DONE                |
|  2 | Print N to 1                 | Custom   | 🟢         | ⭐⭐⭐⭐⭐     |   ✅    | ✅  | ✅  | ✅ | 🟨 | 🟨 | DONE                |
|  3 | Print Even Numbers           | Custom   | 🟢         | ⭐⭐⭐⭐      |   ✅    | ✅  | ✅  | ✅ | 🟨 | 🟨 | DONE ((n & 1) != 1) |
|  4 | Print Odd Numbers            | Custom   | 🟢         | ⭐⭐⭐⭐      |   ✅    | ✅  | ✅  | ✅ | 🟨 | 🟨 | DONE ((n & 1) == 1) |
|  5 | Print Even Numbers (Reverse) | Custom   | 🟢         | ⭐⭐⭐       |   ✅    | ✅  | ✅  | ✅ | 🟨 | 🟨 | DONE ((n & 1) != 1) |
|  6 | Print Odd Numbers (Reverse)  | Custom   | 🟢         | ⭐⭐⭐       |   ✅    | ✅  | ✅  | ✅ | 🟨 | 🟨 | DONE ((n & 1) == 1) |
|  7 | Print Alphabet A → Z         | Custom   | 🟢         | ⭐⭐⭐       |   ✅    | ✅  | ✅  | ✅ | 🟨 | 🟨 | DONE                |
|  8 | Print Alphabet Z → A         | Custom   | 🟢         | ⭐⭐⭐       |   ✅    | ✅  | ✅  | ✅ | 🟨 | 🟨 | DONE                |
|  9 | Print Multiples of K         | Custom   | 🟢         | ⭐⭐        |   ✅    | ✅  | ✅  | ✅ | 🟨 | 🟨 | DONE                |
| 10 | Print Powers of 2            | Custom   | 🟢         | ⭐⭐        |   ✅    | ✅  | ✅  | ✅ | 🟨 | 🟨 | DONE                |

---

# Pattern B — Current Contribution

**Folder**

`B_Current_Contribution`

**Purpose**

Current Contribution + Smaller Problem
---
|  # | Problem           | Platform | Difficulty | Interview | Status | R1 | R2 | R3 | R4 | R5 | Notes |
|---:|-------------------|----------|------------|-----------|:------:|:--:|:--:|:--:|:--:|:--:|-------|
| 11 | Sum of N          | Custom   | 🟢         | ⭐⭐⭐⭐⭐     |   ✅    | ✅  | ⬜  | ⬜  | ⬜  | ⬜  |       |
| 12 | Factorial         | Custom   | 🟢         | ⭐⭐⭐⭐⭐     |   ✅    | ✅  | ⬜  | ⬜  | ⬜  | ⬜  |       |
| 13 | Power             | Custom   | 🟢         | ⭐⭐⭐⭐⭐     |   ✅    | ✅  | ⬜  | ⬜  | ⬜  | ⬜  |       |
| 14 | Sum of Digits     | Custom   | 🟢         | ⭐⭐⭐⭐⭐     |   ✅    | ✅  | ⬜  | ⬜  | ⬜  | ⬜  |       |
| 15 | Count Digits      | Custom   | 🟢         | ⭐⭐⭐⭐⭐     |   ✅    | ✅  | ⬜  | ⬜  | ⬜  | ⬜  |       |
| 16 | Reverse String    | Custom   | 🟢         | ⭐⭐⭐⭐⭐     |   ✅    | ✅  | ⬜  | ⬜  | ⬜  | ⬜  |       |
| 17 | Product of Array  | Custom   | 🟢         | ⭐⭐⭐⭐      |   ✅    | ✅  | ⬜  | ⬜  | ⬜  | ⬜  |       |
| 18 | Sum of Array      | Custom   | 🟢         | ⭐⭐⭐⭐      |   ✅    | ✅  | ⬜  | ⬜  | ⬜  | ⬜  |       |
| 19 | Product of Digits | Custom   | 🟢         | ⭐⭐⭐       |   ✅    | ✅  | ⬜  | ⬜  | ⬜  | ⬜  |       |
| 20 | Reverse Number    | Custom   | 🟡         | ⭐⭐⭐       |   ✅    | ✅  | ⬜  | ⬜  | ⬜  | ⬜  |       |

---

# Pattern C — Recursive Faith

**Folder**

`C_Recursive_Faith`

**Purpose**

Trust recursion. > Compare current answer with recursive answer.
---
|  # | Problem                 | Platform | Difficulty | Interview | Status | R1 | R2 | R3 | R4 | R5 | Notes |
|---:|-------------------------|----------|------------|-----------|:------:|:--:|:--:|:--:|:--:|:--:|-------|
| 21 | Check Sorted Array      | Custom   | 🟢         | ⭐⭐⭐⭐⭐     |   ✅    | ⬜  | ⬜  | ⬜  | ⬜  | ⬜  |       |
| 22 | Maximum Element         | Custom   | 🟢         | ⭐⭐⭐⭐⭐     |   ✅    | ⬜  | ⬜  | ⬜  | ⬜  | ⬜  |       |
| 23 | Minimum Element         | Custom   | 🟢         | ⭐⭐⭐⭐⭐     |   ✅    | ⬜  | ⬜  | ⬜  | ⬜  | ⬜  |       |
| 24 | Maximum Index           | Custom   | 🟢         | ⭐⭐⭐⭐⭐     |   ✅    | ⬜  | ⬜  | ⬜  | ⬜  | ⬜  |       |
| 25 | Minimum Index           | Custom   | 🟢         | ⭐⭐⭐⭐⭐     |   ✅    | ⬜  | ⬜  | ⬜  | ⬜  | ⬜  |       |
| 26 | Largest Even Index      | Custom   | 🟡         | ⭐⭐⭐       |   ✅    | ⬜  | ⬜  | ⬜  | ⬜  | ⬜  |       |
| 27 | Largest Odd Index       | Custom   | 🟡         | ⭐⭐⭐       |   ✅    | ⬜  | ⬜  | ⬜  | ⬜  | ⬜  |       |
| 28 | Smallest Positive Index | Custom   | 🟡         | ⭐⭐⭐       |   ✅    | ⬜  | ⬜  | ⬜  | ⬜  | ⬜  |       |
| 29 | Largest Positive Index  | Custom   | 🟡         | ⭐⭐⭐       |   ✅    | ⬜  | ⬜  | ⬜  | ⬜  | ⬜  |       |
| 30 | Smallest Negative Index | Custom   | 🟡         | ⭐⭐⭐       |   ✅    | ⬜  | ⬜  | ⬜  | ⬜  | ⬜  |       |


# Pattern D — Searching

**Folder**

`D_Searching`

**Thinking**

Search recursively. > Return immediately once the answer is found.
---

|  # | Problem              | Platform | Difficulty | Interview | Status |  R1 |  R2 |  R3 |  R4 |  R5 | Notes |
| -: | -------------------- | -------- | ---------- | --------- | :----: | :-: | :-: | :-: | :-: | :-: | ----- |
| 31 | Contains Element     | Custom   | 🟢         | ⭐⭐⭐⭐⭐     |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
| 32 | First Occurrence     | Custom   | 🟢         | ⭐⭐⭐⭐⭐     |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
| 33 | Last Occurrence      | Custom   | 🟢         | ⭐⭐⭐⭐⭐     |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
| 34 | First Even Index     | Custom   | 🟢         | ⭐⭐⭐       |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
| 35 | Last Even Index      | Custom   | 🟢         | ⭐⭐⭐       |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
| 36 | First Odd Index      | Custom   | 🟢         | ⭐⭐⭐       |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
| 37 | Last Odd Index       | Custom   | 🟢         | ⭐⭐⭐       |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
| 38 | First Positive Index | Custom   | 🟢         | ⭐⭐⭐       |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
| 39 | Last Positive Index  | Custom   | 🟢         | ⭐⭐⭐       |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
| 40 | First Negative Index | Custom   | 🟢         | ⭐⭐⭐       |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
---
## Skills

* Recursive Search
* Early Return
* Search Pattern
* Return Index
* Return Boolean
---

# Pattern E — Conditional Counting

**Folder**

`E_Conditional_Counting`

**Purpose**

Condition + Count
---
|  # | Problem                | Platform | Difficulty | Interview | Status | R1 | R2 | R3 | R4 | R5 | Notes |
|---:|------------------------|----------|------------|-----------|:------:|:--:|:--:|:--:|:--:|:--:|-------|
| 41 | Count Occurrences      | Custom   | 🟢         | ⭐⭐⭐⭐⭐     |   ⬜    | ⬜  | ⬜  | ⬜  | ⬜  | ⬜  |       |
| 42 | Count Equal To X       | Custom   | 🟢         | ⭐⭐⭐⭐      |   ⬜    | ⬜  | ⬜  | ⬜  | ⬜  | ⬜  |       |
| 43 | Count Greater Than X   | Custom   | 🟢         | ⭐⭐⭐⭐      |   ⬜    | ⬜  | ⬜  | ⬜  | ⬜  | ⬜  |       |
| 44 | Count Less Than X      | Custom   | 🟢         | ⭐⭐⭐⭐      |   ⬜    | ⬜  | ⬜  | ⬜  | ⬜  | ⬜  |       |
| 45 | Count Even Numbers     | Custom   | 🟢         | ⭐⭐⭐       |   ⬜    | ⬜  | ⬜  | ⬜  | ⬜  | ⬜  |       |
| 46 | Count Odd Numbers      | Custom   | 🟢         | ⭐⭐⭐       |   ⬜    | ⬜  | ⬜  | ⬜  | ⬜  | ⬜  |       |
| 47 | Count Positive Numbers | Custom   | 🟢         | ⭐⭐⭐       |   ⬜    | ⬜  | ⬜  | ⬜  | ⬜  | ⬜  |       |
| 48 | Count Negative Numbers | Custom   | 🟢         | ⭐⭐⭐       |   ⬜    | ⬜  | ⬜  | ⬜  | ⬜  | ⬜  |       |
| 49 | Count Zeroes           | Custom   | 🟢         | ⭐⭐⭐       |   ⬜    | ⬜  | ⬜  | ⬜  | ⬜  | ⬜  |       |
| 50 | Count Multiples Of K   | Custom   | 🟢         | ⭐⭐⭐       |   ⬜    | ⬜  | ⬜  | ⬜  | ⬜  | ⬜  |       |

---
## Skills
* Conditional Recursion
* Counting Pattern
* Boolean Conditions
* Frequency Counting
* Filtering
---

# Pattern F — Index Jump

**Folder**

`F_Index_Jump`

**Thinking**

Skip indices using a fixed jump.
---
Instead of > idx + 1 > Jump to using > idx + K
---

|  # | Problem                  | Platform | Difficulty | Interview | Status |  R1 |  R2 |  R3 |  R4 |  R5 | Notes                    |
| -: | ------------------------ | -------- | ---------- | --------- | :----: | :-: | :-: | :-: | :-: | :-: | ------------------------ |
| 51 | Print Even Index         | Custom   | 🟢         | ⭐⭐⭐       |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |                          |
| 52 | Print Odd Index          | Custom   | 🟢         | ⭐⭐⭐       |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |                          |
| 53 | Print Even Index Reverse | Custom   | 🟢         | ⭐⭐⭐       |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |                          |
| 54 | Print Odd Index Reverse  | Custom   | 🟢         | ⭐⭐⭐       |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |                          |
| 55 | Sum Even Index           | Custom   | 🟢         | ⭐⭐⭐       |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |                          |
| 56 | Sum Odd Index            | Custom   | 🟢         | ⭐⭐⭐       |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |                          |
| 57 | Print Every Kth Element  | Custom   | 🟡         | ⭐⭐⭐⭐      |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  | Generalized Jump Pattern |
| 58 | Sum Every Kth Element    | Custom   | 🟡         | ⭐⭐⭐⭐      |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  | Generalized Jump Pattern |
| 59 | Print Alternate Elements | Custom   | 🟢         | ⭐⭐⭐       |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  | K = 2                    |
| 60 | Sum Alternate Elements   | Custom   | 🟢         | ⭐⭐⭐       |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  | K = 2                    |


---
## Skills
* Jump Recursion
* Variable Step Size
* Index Traversal
* Alternate Traversal
* Generalized `idx + K` Pattern
---

# 🎯 Part 1 Completion Checklist

## Pattern Completion

- ⬜ Pattern A
- ⬜ Pattern B
- ⬜ Pattern C
- ⬜ Pattern D
- ⬜ Pattern E
- ⬜ Pattern F

---

## Interview Skills

- ⬜ Identify the recursion pattern in under 10 seconds
- ⬜ Write the base case without hesitation
- ⬜ Dry run any problem
- ⬜ Draw the recursion tree
- ⬜ Explain the call stack
- ⬜ Explain time complexity
- ⬜ Explain space complexity
- ⬜ Explain the solution like an interviewer

---

# Final Goal

Complete **Part 1** only when you can solve all **60 problems without looking at notes**, explain the logic confidently, and recognize the recursion pattern immediately. Only then move to **Part 2 (Multiple Recursive Calls & Backtracking)**.