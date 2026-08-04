# 🚀 Recursion Master Progress Tracker (Part 2.1)

> Goal: Master Advanced Recursion & Backtracking
>
> Covers **Problems 61–85**
>
> Focus:
>
> * Index Jump
> * Two Pointer Recursion
> * Beginning of Multiple Recursive Calls
> * Pattern Recognition
> * Dry Run
> * Interview Thinking

---

> **Repository Structure**

```text
Recursion/
├── F_Index_Jump/
├── G_Two_Pointer/
├── H_Multiple_Calls/
├── I_Include_Exclude/
├── J_Choose_Dont_Choose/
├── K_Permutation/
├── L_Grid_Backtracking/
├── M_Constraint_Backtracking/
├── N_Pruning/
└── O_Mixed_Interview/
```

> Complete Part 2.1 before moving to Part 2.2.

---

# Legend

| Symbol | Meaning        |
| ------ | -------------- |
| ⬜      | Not Started    |
| 🟨     | In Progress    |
| ✅      | Completed      |
| 🔄     | Needs Revision |

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
| -------- | -------- |
| R0       | Same Day |
| R1       | Day 1    |
| R2       | Day 3    |
| R3       | Day 7    |
| R4       | Day 15   |
| R5       | Day 30   |

---

# Pattern F — Index Jump

**Folder**

`F_Index_Jump`

**Purpose**

Move recursively using a fixed jump.

```
idx

↓

idx + 2

↓

idx + k
```

|  # | Problem                   | Platform | Difficulty | Interview | Status |  R1 |  R2 |  R3 |  R4 |  R5 | Notes |
| -: | ------------------------- | -------- | ---------- | --------- | :----: | :-: | :-: | :-: | :-: | :-: | ----- |
| 61 | Print Even Index          | Custom   | 🟢         | ⭐⭐⭐⭐⭐     |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
| 62 | Print Odd Index           | Custom   | 🟢         | ⭐⭐⭐⭐⭐     |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
| 63 | Print Even Index Reverse  | Custom   | 🟢         | ⭐⭐⭐⭐⭐     |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
| 64 | Print Odd Index Reverse   | Custom   | 🟢         | ⭐⭐⭐⭐⭐     |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
| 65 | Sum of Even Index         | Custom   | 🟢         | ⭐⭐⭐⭐⭐     |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
| 66 | Sum of Odd Index          | Custom   | 🟢         | ⭐⭐⭐⭐⭐     |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
| 67 | Jump by K                 | Custom   | 🟡         | ⭐⭐⭐⭐      |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
| 68 | Print Every Third Element | Custom   | 🟢         | ⭐⭐⭐       |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
| 69 | Sum Every Third Element   | Custom   | 🟢         | ⭐⭐⭐       |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
| 70 | Alternate Elements        | Custom   | 🟡         | ⭐⭐⭐       |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |

---

## Pattern Checklist

* ⬜ I understand Index Jump recursion.
* ⬜ I know why `idx + 2` works.
* ⬜ I can modify the jump to `k`.
* ⬜ I can solve a new jump problem.
* ⬜ I can explain time & space complexity.

---

# Pattern G — Two Pointer Recursion

**Folder**

`G_Two_Pointer`

**Purpose**

Shrink the problem from both ends.

```
left++

↓

right--

↓

left >= right
```

|  # | Problem                    | Platform | Difficulty | Interview | Status |  R1 |  R2 |  R3 |  R4 |  R5 | Notes |
| -: | -------------------------- | -------- | ---------- | --------- | :----: | :-: | :-: | :-: | :-: | :-: | ----- |
| 71 | Array Palindrome           | Custom   | 🟢         | ⭐⭐⭐⭐⭐     |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
| 72 | String Palindrome          | Custom   | 🟢         | ⭐⭐⭐⭐⭐     |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
| 73 | Ignore Case Palindrome     | Custom   | 🟢         | ⭐⭐⭐⭐      |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
| 74 | Ignore Spaces Palindrome   | Custom   | 🟡         | ⭐⭐⭐⭐      |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
| 75 | Compare Mirror Elements    | Custom   | 🟢         | ⭐⭐⭐       |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
| 76 | Reverse Check              | Custom   | 🟢         | ⭐⭐⭐       |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
| 77 | Compare Two Arrays         | Custom   | 🟢         | ⭐⭐⭐       |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
| 78 | Symmetric Array            | Custom   | 🟡         | ⭐⭐⭐       |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
| 79 | Count Matching Pairs       | Custom   | 🟡         | ⭐⭐        |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
| 80 | Valid Palindrome Variation | Custom   | 🟡         | ⭐⭐⭐⭐      |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |

---

## Pattern Checklist

* ⬜ I know when to use two pointers.
* ⬜ I know the base case.
* ⬜ I can dry run left/right movement.
* ⬜ I can explain recursion tree.
* ⬜ I can solve one unseen variation.

---

# Pattern H — Multiple Recursive Calls (Foundation)

**Folder**

`H_Multiple_Calls`

**Purpose**

One function creates multiple recursive branches.

```
f()

├── f()

└── f()
```

|  # | Problem              | Platform    | Difficulty | Interview | Status |  R1 |  R2 |  R3 |  R4 |  R5 | Notes |
| -: | -------------------- | ----------- | ---------- | --------- | :----: | :-: | :-: | :-: | :-: | :-: | ----- |
| 81 | Fibonacci            | Custom      | 🟢         | ⭐⭐⭐⭐⭐     |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
| 82 | Tribonacci           | Custom      | 🟡         | ⭐⭐⭐       |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
| 83 | Climbing Stairs      | LeetCode 70 | 🟢         | ⭐⭐⭐⭐⭐     |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
| 84 | Count Binary Strings | Custom      | 🟡         | ⭐⭐⭐       |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
| 85 | Count Ways           | Custom      | 🟡         | ⭐⭐⭐⭐      |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |

---

## Pattern Checklist

* ⬜ I understand branching recursion.
* ⬜ I can draw the recursion tree.
* ⬜ I know why Fibonacci is exponential.
* ⬜ I can explain overlapping subproblems.
* ⬜ I know when DP is needed.

---

# 🎯 Part 2.1 Completion Checklist

## Pattern Completion

* ⬜ Pattern F — Index Jump
* ⬜ Pattern G — Two Pointer
* ⬜ Pattern H (Foundation)

---

## Interview Skills

* ⬜ Can identify the recursion pattern in under 10 seconds.
* ⬜ Can write the base case without hesitation.
* ⬜ Can dry run any problem.
* ⬜ Can draw the recursion tree.
* ⬜ Can explain the call stack.
* ⬜ Can explain time complexity.
* ⬜ Can explain space complexity.
* ⬜ Can explain the solution like an interviewer.

---

# Final Goal

Complete **Part 2.1** only when you can solve all **25 problems** without looking at notes, confidently explain the recursion pattern, and identify the correct approach immediately. Then move to **Part 2.2 (Problems 86–110)**.


# 🚀 Recursion Master Progress Tracker (Part 2.2)

> Goal: Master Multiple Recursive Calls
>
> Covers **Problems 86–110**
>
> Focus:
>
> * Branching Recursion
> * Divide & Conquer Thinking
> * Recursive Mathematics
> * Interview Problems
> * Foundation before Backtracking

---

> **Repository Structure**

```text
Recursion/
├── F_Index_Jump/
├── G_Two_Pointer/
├── H_Multiple_Calls/
├── I_Include_Exclude/
├── J_Choose_Dont_Choose/
├── K_Permutation/
├── L_Grid_Backtracking/
├── M_Constraint_Backtracking/
└── N_Pruning/
```

---

# Legend

| Symbol | Meaning        |
| ------ | -------------- |
| ⬜      | Not Started    |
| 🟨     | In Progress    |
| ✅      | Completed      |
| 🔄     | Needs Revision |

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
| -------- | -------- |
| R0       | Same Day |
| R1       | Day 1    |
| R2       | Day 3    |
| R3       | Day 7    |
| R4       | Day 15   |
| R5       | Day 30   |

---

# Pattern H — Multiple Recursive Calls (Advanced)

**Folder**

`H_Multiple_Calls`

**Purpose**

One recursive call becomes multiple recursive branches.

```text
Current Problem

        │
        ▼

   Recursive Calls

   ├── Left
   ├── Right
   └── More Branches
```

---

|   # | Problem                             | Platform      | Difficulty | Interview | Status |  R1 |  R2 |  R3 |  R4 |  R5 | Notes |
| --: | ----------------------------------- | ------------- | ---------- | --------- | :----: | :-: | :-: | :-: | :-: | :-: | ----- |
|  86 | Tiling Problem                      | GFG           | 🟡         | ⭐⭐⭐⭐      |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
|  87 | Friends Pairing Problem             | GFG           | 🟡         | ⭐⭐⭐⭐      |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
|  88 | Tower of Hanoi                      | Classic       | 🟡         | ⭐⭐⭐⭐⭐     |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
|  89 | Josephus Problem                    | LeetCode 1823 | 🟡         | ⭐⭐⭐⭐      |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
|  90 | K-th Symbol in Grammar              | LeetCode 779  | 🟡         | ⭐⭐⭐⭐⭐     |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
|  91 | Pow(x,n)                            | LeetCode 50   | 🟡         | ⭐⭐⭐⭐⭐     |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
|  92 | Recursive Binary Search             | LeetCode 704  | 🟢         | ⭐⭐⭐⭐⭐     |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
|  93 | Search Insert Position              | LeetCode 35   | 🟢         | ⭐⭐⭐⭐      |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
|  94 | First Bad Version                   | LeetCode 278  | 🟢         | ⭐⭐⭐       |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
|  95 | Recursive Quick Power               | Custom        | 🟡         | ⭐⭐⭐⭐      |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
|  96 | Catalan Number                      | Custom        | 🔴         | ⭐⭐⭐       |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
|  97 | Count BSTs                          | Custom        | 🔴         | ⭐⭐⭐       |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
|  98 | Matrix Paths                        | Custom        | 🟡         | ⭐⭐⭐⭐      |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
|  99 | Dice Throw Ways                     | Custom        | 🟡         | ⭐⭐⭐⭐      |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
| 100 | Recursive Maze Count                | Custom        | 🟡         | ⭐⭐⭐⭐      |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
| 101 | Count Maze Paths With Obstacles     | Custom        | 🟡         | ⭐⭐⭐       |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
| 102 | Minimum Steps Recursively           | Custom        | 🟡         | ⭐⭐⭐       |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
| 103 | Count Ways to Reach End             | Custom        | 🟡         | ⭐⭐⭐⭐      |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
| 104 | Recursive Coin Change (Brute Force) | Custom        | 🔴         | ⭐⭐⭐⭐      |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
| 105 | Minimum Coin Change (Recursive)     | Custom        | 🔴         | ⭐⭐⭐       |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
| 106 | Target Sum (Recursive)              | LeetCode 494  | 🔴         | ⭐⭐⭐⭐      |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
| 107 | Can Sum                             | Custom        | 🟡         | ⭐⭐⭐⭐      |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
| 108 | How Sum                             | Custom        | 🔴         | ⭐⭐⭐       |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
| 109 | Best Sum                            | Custom        | 🔴         | ⭐⭐⭐       |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
| 110 | Recursive Branching Mixed Problem   | Custom        | 🔴         | ⭐⭐⭐       |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |

---

# Pattern Checklist

* ⬜ I understand branching recursion.
* ⬜ I know why multiple recursive calls increase complexity.
* ⬜ I can draw a recursion tree.
* ⬜ I know overlapping subproblems.
* ⬜ I know when Dynamic Programming is a better choice.
* ⬜ I can optimize brute force recursion.
* ⬜ I can explain every recursive branch.
* ⬜ I can solve unseen interview variations.

---

# 🎯 Part 2.2 Completion Checklist

## Pattern Completion

* ⬜ Pattern H — Multiple Recursive Calls

---

## Interview Skills

* ⬜ Can identify branching recursion immediately.
* ⬜ Can explain recursive trees clearly.
* ⬜ Can calculate time complexity.
* ⬜ Can calculate recursion depth.
* ⬜ Can recognize overlapping subproblems.
* ⬜ Knows when recursion becomes DP.
* ⬜ Can explain optimization opportunities.

---

# Final Goal

Complete **Part 2.2** only when you can solve all **25 problems** without looking at notes, explain every recursive branch confidently, and recognize when a recursive solution should be optimized using memoization or dynamic programming.

**Next:** **Part 2.3 (Problems 111–135)** — Include / Exclude, Choose / Don't Choose, and Permutation Backtracking.


# 🚀 Recursion Master Progress Tracker (Part 2.3)

> Goal: Master **Backtracking Fundamentals**
>
> Covers **Problems 111–135**
>
> Focus:
>
> * Include / Exclude
> * Choose / Don't Choose
> * Permutations
> * Decision Tree
> * Undo (Backtracking)
> * Interview Thinking

---

> **Repository Structure**

```text
Recursion/
├── I_Include_Exclude/
├── J_Choose_Dont_Choose/
└── K_Permutation/
```

---

# Legend

| Symbol | Meaning        |
| ------ | -------------- |
| ⬜      | Not Started    |
| 🟨     | In Progress    |
| ✅      | Completed      |
| 🔄     | Needs Revision |

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
| -------- | -------- |
| R0       | Same Day |
| R1       | Day 1    |
| R2       | Day 3    |
| R3       | Day 7    |
| R4       | Day 15   |
| R5       | Day 30   |

---

# Pattern I — Include / Exclude

**Folder**

`I_Include_Exclude`

**Purpose**

Every element has **two choices**.

```
Take

OR

Skip
```

Decision Tree

```
Current

├── Include

└── Exclude
```

---

|   # | Problem                  | Platform    | Difficulty | Interview | Status |  R1 |  R2 |  R3 |  R4 |  R5 | Notes |
| --: | ------------------------ | ----------- | ---------- | --------- | :----: | :-: | :-: | :-: | :-: | :-: | ----- |
| 111 | Print Subsequences       | Custom      | 🟢         | ⭐⭐⭐⭐⭐     |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
| 112 | Generate Subsequences    | Custom      | 🟢         | ⭐⭐⭐⭐⭐     |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
| 113 | Count Subsequences       | Custom      | 🟢         | ⭐⭐⭐⭐      |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
| 114 | Subsequence Sum          | Custom      | 🟡         | ⭐⭐⭐⭐      |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
| 115 | Subset Sum               | Custom      | 🟡         | ⭐⭐⭐⭐⭐     |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
| 116 | Generate Subsets         | LeetCode 78 | 🟡         | ⭐⭐⭐⭐⭐     |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
| 117 | Count Subsets With Sum K | Custom      | 🟡         | ⭐⭐⭐⭐      |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
| 118 | Subsequence Sum Equals K | Custom      | 🟡         | ⭐⭐⭐⭐      |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |

---

## Pattern Checklist

* ⬜ I know Include / Exclude.
* ⬜ I can draw decision tree.
* ⬜ I know base case.
* ⬜ I know recursive case.
* ⬜ I can solve unseen variations.

---

# Pattern J — Choose / Don't Choose

**Folder**

`J_Choose_Dont_Choose`

**Purpose**

Choose one option.

↓

Recursive Call.

↓

Undo choice.

↓

Choose another.

```
Choose

↓

Explore

↓

Undo

↓

Choose Again
```

---

|   # | Problem                             | Platform     | Difficulty | Interview | Status |  R1 |  R2 |  R3 |  R4 |  R5 | Notes |
| --: | ----------------------------------- | ------------ | ---------- | --------- | :----: | :-: | :-: | :-: | :-: | :-: | ----- |
| 119 | Combination Sum                     | LeetCode 39  | 🟡         | ⭐⭐⭐⭐⭐     |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
| 120 | Combination Sum II                  | LeetCode 40  | 🔴         | ⭐⭐⭐⭐      |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
| 121 | Combination Sum III                 | LeetCode 216 | 🟡         | ⭐⭐⭐⭐      |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
| 122 | Letter Combinations of Phone Number | LeetCode 17  | 🟡         | ⭐⭐⭐⭐⭐     |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
| 123 | Generate Parentheses                | LeetCode 22  | 🟡         | ⭐⭐⭐⭐⭐     |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
| 124 | Palindrome Partitioning             | LeetCode 131 | 🔴         | ⭐⭐⭐⭐      |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
| 125 | Restore IP Addresses                | LeetCode 93  | 🔴         | ⭐⭐⭐       |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |

---

## Pattern Checklist

* ⬜ I know Choose / Don't Choose.
* ⬜ I know when to backtrack.
* ⬜ I can undo choices correctly.
* ⬜ I can explain recursion tree.
* ⬜ I can solve interview variations.

---

# Pattern K — Permutation Backtracking

**Folder**

`K_Permutation`

**Purpose**

Swap.

↓

Recursive Call.

↓

Swap Back.

```
Swap

↓

Explore

↓

Swap Back
```

---

|   # | Problem                               | Platform      | Difficulty | Interview | Status |  R1 |  R2 |  R3 |  R4 |  R5 | Notes |
| --: | ------------------------------------- | ------------- | ---------- | --------- | :----: | :-: | :-: | :-: | :-: | :-: | ----- |
| 126 | Permutations                          | LeetCode 46   | 🟡         | ⭐⭐⭐⭐⭐     |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
| 127 | Permutations II                       | LeetCode 47   | 🔴         | ⭐⭐⭐⭐      |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
| 128 | K-th Permutation Sequence             | LeetCode 60   | 🔴         | ⭐⭐⭐⭐      |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
| 129 | Letter Tile Possibilities             | LeetCode 1079 | 🔴         | ⭐⭐⭐       |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
| 130 | Beautiful Arrangement                 | LeetCode 526  | 🔴         | ⭐⭐⭐⭐      |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
| 131 | Print All Permutations (String)       | Custom        | 🟢         | ⭐⭐⭐⭐      |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
| 132 | Print All Permutations (Array)        | Custom        | 🟢         | ⭐⭐⭐⭐      |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
| 133 | Unique String Permutations            | Custom        | 🟡         | ⭐⭐⭐       |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
| 134 | Next Permutation (Recursive Thinking) | Custom        | 🟡         | ⭐⭐        |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
| 135 | Permutation Pattern Mixed Problem     | Custom        | 🔴         | ⭐⭐⭐       |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |

---

# Pattern Checklist

* ⬜ I know swap recursion.
* ⬜ I know swap back.
* ⬜ I understand permutation tree.
* ⬜ I can avoid duplicates.
* ⬜ I can solve unseen permutation problems.

---

# 🎯 Part 2.3 Completion Checklist

## Pattern Completion

* ⬜ Pattern I — Include / Exclude
* ⬜ Pattern J — Choose / Don't Choose
* ⬜ Pattern K — Permutation

---

## Interview Skills

* ⬜ Can identify Include / Exclude problems instantly.
* ⬜ Can identify Combination problems instantly.
* ⬜ Can identify Permutation problems instantly.
* ⬜ Can draw decision trees.
* ⬜ Can explain backtracking.
* ⬜ Can explain undo (backtrack).
* ⬜ Can explain time complexity.
* ⬜ Can solve one unseen variation confidently.

---

# Final Goal

Complete **Part 2.3** only when you can solve all **25 problems** without looking at notes, identify the correct backtracking pattern immediately, and explain every decision, recursive call, and backtrack step like an interviewer expects.

➡️ **Next:** **Part 2.4 (Problems 136–160)** — Grid/Board Backtracking, Constraint Satisfaction, Pruning, and Advanced Interview Problems.


# 🚀 Recursion Master Progress Tracker (Part 2.4)

> Goal: Master Grid, Board, Constraint, and Pruning Backtracking.
>
> Covers **Problems 136–160**
>
> Focus:
> - Grid DFS
> - Board Problems
> - Constraint Satisfaction
> - Pruning
> - State Restoration
> - Advanced Interview Backtracking

---

> Repository Structure

```text
Recursion/
├── L_Grid_Backtracking/
├── M_Constraint_Backtracking/
└── N_Pruning/
```

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

| Revision | When |
|----------|------|
| R0 | Same Day |
| R1 | Day 1 |
| R2 | Day 3 |
| R3 | Day 7 |
| R4 | Day 15 |
| R5 | Day 30 |

---

# Pattern L — Grid / Board Backtracking

**Folder**

`L_Grid_Backtracking`

**Purpose**

Move in multiple directions.

↓

Mark visited.

↓

Explore.

↓

Unmark.

Grid Pattern

```
Up

Left  Cell  Right

Down
```

---

|#|Problem|Platform|Difficulty|Interview|Status|R1|R2|R3|R4|R5|Notes|
|--:|--------|--------|----------|----------|:----:|:--:|:--:|:--:|:--:|:--:|------|
|136|Rat in a Maze|GFG|🟡|⭐⭐⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|137|Word Search|LeetCode 79|🟡|⭐⭐⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|138|Word Search II|LeetCode 212|🔴|⭐⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|139|All Paths From Source to Target|LeetCode 797|🟡|⭐⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|140|Unique Paths III|LeetCode 980|🔴|⭐⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|141|Flood Fill (Recursive)|LeetCode 733|🟢|⭐⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|142|Number of Islands (Recursive DFS)|LeetCode 200|🟡|⭐⭐⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|143|Surrounded Regions|LeetCode 130|🔴|⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||

---

## Pattern Checklist

- ⬜ Can move in four directions.
- ⬜ Can maintain visited array.
- ⬜ Can backtrack correctly.
- ⬜ Can avoid revisiting cells.
- ⬜ Can explain recursion tree.

---

# Pattern M — Constraint Backtracking

**Folder**

`M_Constraint_Backtracking`

**Purpose**

Choose.

↓

Check validity.

↓

Continue only if valid.

↓

Undo.

Constraint Pattern

```
Choose

↓

Is Valid ?

↓

YES → Explore

NO → Skip
```

---

|#|Problem|Platform|Difficulty|Interview|Status|R1|R2|R3|R4|R5|Notes|
|--:|--------|--------|----------|----------|:----:|:--:|:--:|:--:|:--:|:--:|------|
|144|N Queens|LeetCode 51|🔴|⭐⭐⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|145|Sudoku Solver|LeetCode 37|🔴|⭐⭐⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|146|M Coloring Problem|GFG|🔴|⭐⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|147|Knight's Tour|Classic|🔴|⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|148|Cryptarithmetic Puzzle|Classic|🔴|⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|149|Tug of War|Classic|🔴|⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|150|Partition to K Equal Sum Subsets|LeetCode 698|🔴|⭐⭐⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||

---

## Pattern Checklist

- ⬜ Can validate choices.
- ⬜ Can prune invalid states.
- ⬜ Can restore state.
- ⬜ Can optimize search.
- ⬜ Can explain constraint recursion.

---

# Pattern N — Advanced Backtracking & Pruning

**Folder**

`N_Pruning`

**Purpose**

Reduce search space.

Skip impossible branches.

Advanced Decision Tree

```
Choice

↓

Impossible ?

↓

YES → Return

NO → Continue
```

---

|#|Problem|Platform|Difficulty|Interview|Status|R1|R2|R3|R4|R5|Notes|
|--:|--------|--------|----------|----------|:----:|:--:|:--:|:--:|:--:|:--:|------|
|151|Maximum Score Words Formed by Letters|LeetCode 1255|🔴|⭐⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|152|Fair Distribution of Cookies|LeetCode 2305|🔴|⭐⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|153|Matchsticks to Square|LeetCode 473|🔴|⭐⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|154|Maximum Length of Concatenated String With Unique Characters|LeetCode 1239|🔴|⭐⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|155|Split String Into Descending Consecutive Values|LeetCode 1849|🔴|⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|156|Expression Add Operators|LeetCode 282|🔴|⭐⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|157|Remove Invalid Parentheses|LeetCode 301|🔴|⭐⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|158|Increasing Subsequences|LeetCode 491|🟡|⭐⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|159|Combination Sum IV (Recursive View)|LeetCode 377|🟡|⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|160|Mixed Backtracking Interview Challenge|Custom|🔴|⭐⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||

---

# 🎯 Part 2.4 Completion Checklist

## Pattern Completion

- ⬜ Pattern L — Grid / Board
- ⬜ Pattern M — Constraint Problems
- ⬜ Pattern N — Advanced Pruning

---

## Interview Skills

- ⬜ Can identify Grid DFS instantly.
- ⬜ Can solve board problems confidently.
- ⬜ Can implement visited array correctly.
- ⬜ Can implement state restoration.
- ⬜ Can prune unnecessary recursion.
- ⬜ Can optimize brute-force search.
- ⬜ Can explain recursion tree.
- ⬜ Can solve unseen hard backtracking problems.

---

# Final Goal

Complete **Part 2.4** only when you can solve all **25 problems** without looking at notes, recognize whether a problem is **Grid**, **Constraint**, or **Pruning** based, and confidently explain your approach in an interview.

🏁 **After completing Parts 2.1 → 2.4 (Problems 61–160), you will have covered virtually every major recursion and backtracking pattern expected in coding interviews and will be well prepared to move on to Trees and Dynamic Programming.**