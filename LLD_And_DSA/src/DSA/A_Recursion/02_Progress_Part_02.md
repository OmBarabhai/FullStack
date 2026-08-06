# 📖 Part 2.1 — Advanced Recursive Traversal

> Goal
>
> Build advanced recursive traversal techniques before entering
> true backtracking.
>
> These patterns strengthen recursive thinking and appear
> frequently in coding interviews.

---

# 🧠 Pattern Evolution

```text
Basic Recursion

↓

Way Up

↓

Recursive Faith

↓

Recursive Searching

────────────────────────────

PART 2

↓

Index Jump

↓

Two Pointer

↓

Branching

↓

Backtracking
```

---

# 📊 Part 2.1 Overview

| Pattern | Problems | Range |
|---------|---------:|------:|
| E — Index Jump | 10 | 61–70 |
| F — Two Pointer | 10 | 71–80 |
| G — Branching | 5 | 81–85 |

**Total : 25 Problems**

---

# 📖 Pattern E — Index Jump Recursion

### Core Idea

Instead of moving one step

```text
idx + 1
```

jump multiple positions

```text
idx + k
```

---

### Recognition

✅ Even Index

✅ Odd Index

✅ Every Second

✅ Every Third

✅ Every Kth

✅ Alternate Elements

---

### Formula

```java
solve(idx + jump);
```

or

```java
solve(idx - jump);
```

---

### Problems

| # | Problem | Platform | Difficulty | Interview | Status | R1 | R2 | R3 | R4 | R5 | Notes |
|---:|---------------------------|:-------:|:---------:|:---------:|:-----:|:--:|:--:|:--:|:--:|:--:|------|
|61|Print Even Index|⭐|🟢|⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|62|Print Odd Index|⭐|🟢|⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|63|First Even Index|⭐|🟢|⭐⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|64|Last Even Index|⭐|🟢|⭐⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|65|First Odd Index|⭐|🟢|⭐⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|66|Last Odd Index|⭐|🟢|⭐⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|67|Jump By K|🟦 Code360|🟡|⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|68|Alternate Traversal|🟦 Code360|🟢|⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|69|Every Third Element|⭐|🟢|⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|70|Generic K-Step Traversal|⭐|🟡|⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||

---

# 📖 Pattern F — Two Pointer Recursion

### Core Idea

Move two recursive pointers simultaneously.

```text
Left →

← Right
```

---

### Recognition

✅ Palindrome

✅ Reverse

✅ Mirror

✅ Symmetric

✅ Compare Ends

---

### Formula

```java
if(arr[left] != arr[right])
    return false;

return solve(left+1,right-1);
```

---

### Problems

| # | Problem | Platform | Difficulty | Interview | Status | R1 | R2 | R3 | R4 | R5 | Notes |
|---:|-----------------------------|:-------:|:---------:|:---------:|:-----:|:--:|:--:|:--:|:--:|:--:|------|
|71|Array Palindrome|⭐|🟢|⭐⭐⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|72|String Palindrome|🟦 Code360|🟢|⭐⭐⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|73|Valid Palindrome|🟨 LC 125|🟡|⭐⭐⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|74|Palindrome Ignore Symbols|🟨 LC 125|🟡|⭐⭐⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|75|Compare Two Arrays|⭐|🟢|⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|76|Mirror Elements|⭐|🟢|⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|77|Reverse Check|⭐|🟢|⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|78|Valid Palindrome II|🟨 LC 680|🟡|⭐⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|79|Reverse String|🟨 LC 344|🟢|⭐⭐⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|80|Recursive Reverse Array|⭐|🟡|⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||

---

# 📖 Pattern G — Branching Recursion

### Core Idea

One recursive call

↓

creates

↓

multiple recursive calls.

---

### Recognition

✅ Fibonacci

✅ Count Ways

✅ Number of Paths

✅ Choices

---

### Formula

```java
return f(x1)
     + f(x2);
```

---

### Problems

| # | Problem | Platform | Pattern | Difficulty | Interview | Status | R1 | R2 | R3 | R4 | R5 | Notes |
|---:|-----------------------------|:--------:|:---------:|:---------:|:---------:|:-----:|:--:|:--:|:--:|:--:|:--:|------|
|81|Fibonacci|⭐|Branching|🟢|⭐⭐⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|82|Climbing Stairs|🟨 LC 70|Branching|🟢|⭐⭐⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|83|Tower of Hanoi|🟩 GFG|Branching|🟡|⭐⭐⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|84|Josephus Problem|🟩 GFG|Branching|🟡|⭐⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|85|K-th Symbol in Grammar|🟨 LC 779|Branching|🟡|⭐⭐⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||

---

# 📊 Part 2.1 Progress

| Pattern | Problems | Completed |
|---------|---------:|:---------:|
| Index Jump | 10 | ⬜ |
| Two Pointer | 10 | ⬜ |
| Branching | 5 | ⬜ |

---

# 🏆 Part 2.1 Completion Checklist

- [ ] I completed all 25 problems.
- [ ] I understand Index Jump Recursion.
- [ ] I understand Two Pointer Recursion.
- [ ] I understand Branching Recursion.
- [ ] I can identify the correct pattern within 10 seconds.
- [ ] I can draw recursion trees.
- [ ] I can derive time complexity.
- [ ] I am ready for Backtracking.

---

# 📖 Part 2.2 — Include / Exclude & Choice Backtracking

> **Goal**
>
> Learn the foundation of Backtracking.
>
> Every advanced backtracking problem
> (Combination Sum, N Queens, Sudoku, Permutation)
> starts from these two patterns.
>
> Master this section before moving to
> Permutation and Grid Backtracking.

---

# 🧠 Pattern Evolution

```text
Linear Recursion

↓

Recursive Faith

↓

Recursive Searching

↓

Branching

────────────────────────────

NOW

↓

Include / Exclude

↓

Choice Backtracking

↓

Permutation

↓

Constraint

↓

Pruning
```

---

# 📊 Part 2.2 Overview

| Pattern | Problems | Range |
|---------|---------:|------:|
| H — Include / Exclude | 15 | 86–100 |
| I — Choice Backtracking | 10 | 101–110 |

**Total : 25 Problems**

---

# 📖 Pattern H — Include / Exclude

> **Core Idea**
>
> Every element has exactly **two decisions**.
>
> Include it
>
> or
>
> Exclude it.

---

# 🧠 Mental Model

Array

```text
1 2 3
```

Decision Tree

```text
                []

            /          \

          1             -

       /      \      /      \

     1,2      1      2       []

```

Every recursive call creates

two recursive branches.

---

# 🎯 Pattern Recognition

If the problem contains

✅ Subsequence

✅ Subset

✅ Pick / Not Pick

✅ Include

✅ Exclude

✅ Count Ways

✅ Target Sum

Think

> **Include / Exclude**

---

# 📌 Formula

```java
// Include

take(arr[idx]);

solve(idx + 1);

undo();

// Exclude

solve(idx + 1);
```

---

# 💡 Common Mistakes

- [ ] Forgetting Exclude branch
- [ ] Wrong base case
- [ ] Forgetting Undo
- [ ] Printing too early
- [ ] Reusing mutable list incorrectly

---

# 📊 Complexity

Decision Tree

```text
2

↓

4

↓

8

↓

16

↓

...

↓

2ⁿ
```

Time

```text
O(2ⁿ)
```

Space

```text
O(n)
```

---

# 🎯 Pattern Checklist

| Concept | Status |
|---------|:------:|
| Recognition | ⬜ |
| Decision Tree | ⬜ |
| Formula | ⬜ |
| Dry Run | ⬜ |
| Complexity | ⬜ |
| Interview Ready | ⬜ |

---

# 📝 Problems

| # | Problem | Platform | Pattern | Difficulty | Interview | Status | R1 | R2 | R3 | R4 | R5 | Notes |
|---:|------------------------------------------|:--------:|:---------:|:---------:|:---------:|:-----:|:--:|:--:|:--:|:--:|:--:|------|
|86|Print Subsequences|🟦 Code360|Include/Exclude|🟢|⭐⭐⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|87|Print One Subsequence|🟦 Code360|Include/Exclude|🟢|⭐⭐⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|88|Count Subsequences|🟦 Code360|Include/Exclude|🟢|⭐⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|89|Subsequence Sum K|🟦 Code360|Include/Exclude|🟡|⭐⭐⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|90|Count Subsequences Sum K|🟦 Code360|Include/Exclude|🟡|⭐⭐⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|91|Subset Sum|🟦 Code360|Include/Exclude|🟡|⭐⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|92|Subsets|🟨 LC 78|Include/Exclude|🟡|⭐⭐⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|93|Subsets II|🟨 LC 90|Include/Exclude|🟡|⭐⭐⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|94|Target Sum|🟨 LC 494|Include/Exclude|🟡|⭐⭐⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|95|Partition Equal Subset Sum*|🟨 LC 416|Include/Exclude|🟡|⭐⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|96|Perfect Sum Problem|🟩 GFG|Include/Exclude|🟡|⭐⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|97|Subset Sum Problem|🟩 GFG|Include/Exclude|🟡|⭐⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|98|Generate Binary Strings|🟦 Code360|Include/Exclude|🟢|⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|99|Power Set|🟩 GFG|Include/Exclude|🟢|⭐⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|100|Generate All Subsequences|⭐ Classic|Include/Exclude|🟢|⭐⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||

> *LC 416 is typically optimized with DP, but solving it recursively first helps understand the decision tree before memoization.

---

# 🌟 Pattern Summary

| Decision | Action |
|----------|--------|
| Include | Take current element |
| Exclude | Skip current element |
| Recursive Calls | 2 |
| Time Complexity | O(2ⁿ) |
| Space Complexity | O(n) |

---

# 📖 Pattern I — Choice Backtracking

> **Core Idea**
>
> Instead of making **two decisions**,
>
> choose **one option from many**.

---

# 🧠 Mental Model

Include / Exclude

```text
YES

NO
```

Choice Backtracking

```text
1

2

3

4

5

...
```

---

# 🎯 Pattern Recognition

If the question contains

✅ Combination

✅ Generate

✅ Choose

✅ Phone Keypad

✅ Parentheses

Think

> **Choice Backtracking**

---

# 📌 Formula

```java
for(each choice){

    choose();

    recurse();

    undo();

}
```

---

# 💡 Common Mistakes

- [ ] Forgetting Undo
- [ ] Wrong loop index
- [ ] Duplicate answers
- [ ] Infinite recursion
- [ ] Wrong stopping condition

---

# 🎯 Pattern Checklist

| Concept | Status |
|---------|:------:|
| Recognition | ⬜ |
| Choose | ⬜ |
| Explore | ⬜ |
| Undo | ⬜ |
| Complexity | ⬜ |
| Interview Ready | ⬜ |

---

# 📝 Problems

| # | Problem | Platform | Pattern | Difficulty | Interview | Status | R1 | R2 | R3 | R4 | R5 | Notes |
|---:|------------------------------------------|:--------:|:---------:|:---------:|:---------:|:-----:|:--:|:--:|:--:|:--:|:--:|------|
|101|Combination Sum|🟨 LC 39|Choice|🟡|⭐⭐⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|102|Combination Sum II|🟨 LC 40|Choice|🟡|⭐⭐⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|103|Combination Sum III|🟨 LC 216|Choice|🟡|⭐⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|104|Letter Combinations of Phone Number|🟨 LC 17|Choice|🟡|⭐⭐⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|105|Generate Parentheses|🟨 LC 22|Choice|🟡|⭐⭐⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|106|Palindrome Partitioning|🟨 LC 131|Choice|🟡|⭐⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|107|Restore IP Addresses|🟨 LC 93|Choice|🔴|⭐⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|108|Letter Tile Possibilities|🟨 LC 1079|Choice|🔴|⭐⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|109|Factor Combinations|🟨 LC 254|Choice|🔴|⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|110|Expression Add Operators|🟨 LC 282|Choice|🔴|⭐⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||

---

# 📊 Part 2.2 Progress

| Pattern | Problems | Completed |
|---------|---------:|:---------:|
| Include / Exclude | 15 | ⬜ |
| Choice Backtracking | 10 | ⬜ |

---

# 🏆 Part 2.2 Completion Checklist

- [ ] I completed all 25 problems.
- [ ] I understand Include / Exclude.
- [ ] I understand Choice Backtracking.
- [ ] I know when to Undo.
- [ ] I can identify the correct recursion tree.
- [ ] I am ready for Permutation Backtracking.

---

# 📖 Part 2.3 — Permutation & Grid Backtracking

> **Goal**
>
> Learn how to generate every possible arrangement and explore
> every possible path using recursion and backtracking.
>
> These are among the most frequently asked interview patterns.

---

# 🧠 Pattern Evolution

```text
Basic Recursion

↓

Recursive Faith

↓

Searching

↓

Branching

↓

Include / Exclude

↓

Choice Backtracking

────────────────────────────

NOW

↓

Permutation

↓

Grid Backtracking

↓

Constraint

↓

Pruning
```

---

# 📊 Part 2.3 Overview

| Pattern | Problems | Range |
|---------|---------:|------:|
| J — Permutation Backtracking | 15 | 111–125 |
| K — Grid Backtracking | 10 | 126–135 |

**Total : 25 Problems**

---

# 📖 Pattern J — Permutation Backtracking

> **Core Idea**
>
> Every element should appear
> in every possible position.
>
> Unlike Include / Exclude,
> order matters.

---

# 🧠 Mental Model

Array

```text
1 2 3
```

Possible Answers

```text
123

132

213

231

312

321
```

Every recursive level

fixes

ONE position.

---

# 🎯 Pattern Recognition

Questions containing

✅ Permutation

✅ Arrangement

✅ Reorder

✅ Seating

✅ Lexicographical Order

✅ Unique Ordering

Think

> **Permutation Backtracking**

---

# 🔄 Difference From Previous Pattern

| Include / Exclude | Permutation |
|-------------------|------------|
| Take / Don't Take | Choose One |
| Binary Decision | Multiple Choices |
| Order Doesn't Matter | Order Matters |
| Decision Tree | Permutation Tree |

---

# 📌 Two Common Approaches

| Method | Used For |
|---------|----------|
| Swap Method | Arrays |
| Visited Array | Strings / Lists |

---

# 📌 Swap Formula

```java
swap(i,current);

solve(current+1);

swap(i,current);
```

---

# 📌 Visited Formula

```java
for(each element){

    if(!visited){

        choose();

        recurse();

        undo();

    }

}
```

---

# 💡 Common Mistakes

- [ ] Forgetting swap back
- [ ] Forgetting visited=false
- [ ] Duplicate permutations
- [ ] Wrong recursion index
- [ ] Wrong base case
- [ ] Missing undo step

---

# 📊 Complexity

Time

```text
O(n × n!)
```

Space

```text
O(n)
```

(Call Stack + Visited Array)

---

# 🎯 Pattern Checklist

| Concept | Status |
|---------|:------:|
| Recognition | ⬜ |
| Swap Method | ⬜ |
| Visited Method | ⬜ |
| Duplicate Handling | ⬜ |
| Dry Run | ⬜ |
| Interview Ready | ⬜ |

---

# 📝 Problems

| # | Problem | Platform | Pattern | Difficulty | Interview | Status | R1 | R2 | R3 | R4 | R5 | Notes |
|---:|--------------------------------------|:--------:|:---------:|:---------:|:---------:|:-----:|:--:|:--:|:--:|:--:|:--:|------|
|111|Permutations|🟨 LC 46|Permutation|🟡|⭐⭐⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|112|Permutations II|🟨 LC 47|Permutation|🟡|⭐⭐⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|113|String Permutations|🟦 Code360|Permutation|🟡|⭐⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|114|Letter Case Permutation|🟨 LC 784|Permutation|🟡|⭐⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|115|K-th Permutation Sequence|🟨 LC 60|Permutation|🔴|⭐⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|116|Letter Tile Possibilities|🟨 LC 1079|Permutation|🔴|⭐⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|117|Beautiful Arrangement|🟨 LC 526|Permutation|🔴|⭐⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|118|Generate All Permutations|⭐ Classic|Permutation|🟢|⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|119|Permutation of String|🟩 GFG|Permutation|🟡|⭐⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|120|Next Permutation (Concept)|🟨 LC 31|Permutation|🟡|⭐⭐⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|121|Permutation Sequence Practice|⭐ Classic|Permutation|🟡|⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|122|Unique Permutations|🟩 GFG|Permutation|🟡|⭐⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|123|Print All Arrangements|⭐ Classic|Permutation|🟢|⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|124|Lexicographic Permutation|🟩 GFG|Permutation|🔴|⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|125|Permutation Challenge|⭐ Classic|Permutation|🟡|⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||

---

# 🌟 Pattern Summary

| Feature | Value |
|---------|-------|
| Choices | Multiple |
| Undo Required | ✅ |
| Swap Method | ✅ |
| Visited Array | ✅ |
| Time | O(n×n!) |

---

# 📖 Pattern K — Grid Backtracking

> **Core Idea**
>
> Explore every valid path in a matrix.
>
> Visit
>
> Explore
>
> Undo
>
> Repeat.

---

# 🧠 Mental Model

```text
Start

↓

Move

↓

Mark

↓

Explore

↓

Undo

↓

Try Next Direction
```

---

# 🎯 Pattern Recognition

Questions containing

✅ Grid

✅ Maze

✅ Matrix

✅ Flood Fill

✅ Island

✅ Word Search

Immediately think

> **Grid Backtracking**

---

# 📌 Four Directions

```text
↑

←   →

↓

```

Sometimes

```text
8 Directions
```

---

# 📌 Formula

```java
markVisited();

explore();

unmarkVisited();
```

---

# 💡 Common Mistakes

- [ ] Forgetting boundary check
- [ ] Revisiting cells
- [ ] Forgetting unmark
- [ ] Infinite recursion
- [ ] Wrong direction array

---

# 📊 Complexity

Usually

```text
O(4^(m×n))
```

Depends on constraints.

---

# 🎯 Pattern Checklist

| Concept | Status |
|---------|:------:|
| Recognition | ⬜ |
| Boundary Check | ⬜ |
| Visited Array | ⬜ |
| Undo | ⬜ |
| Dry Run | ⬜ |
| Interview Ready | ⬜ |

---

# 📝 Problems

| # | Problem | Platform | Pattern | Difficulty | Interview | Status | R1 | R2 | R3 | R4 | R5 | Notes |
|---:|--------------------------------------|:--------:|:---------:|:---------:|:---------:|:-----:|:--:|:--:|:--:|:--:|:--:|------|
|126|Rat in a Maze|🟩 GFG|Grid|🟡|⭐⭐⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|127|Flood Fill|🟨 LC 733|Grid|🟢|⭐⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|128|Word Search|🟨 LC 79|Grid|🟡|⭐⭐⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|129|Unique Paths III|🟨 LC 980|Grid|🔴|⭐⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|130|Number of Islands (DFS)|🟨 LC 200|Grid|🟡|⭐⭐⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|131|Maze Obstacles|🟦 Code360|Grid|🟡|⭐⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|132|Path in Matrix|🟩 GFG|Grid|🟡|⭐⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|133|Find All Paths in Maze|🟩 GFG|Grid|🟡|⭐⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|134|Longest Path in Matrix|🟩 GFG|Grid|🔴|⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|135|Grid Path Challenge|⭐ Classic|Grid|🟡|⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||

---

# 📊 Part 2.3 Progress

| Pattern | Problems | Completed |
|---------|---------:|:---------:|
| Permutation | 15 | ⬜ |
| Grid Backtracking | 10 | ⬜ |

---

# 🏆 Part 2.3 Completion Checklist

- [ ] I completed all 25 problems.
- [ ] I understand Swap Backtracking.
- [ ] I understand Visited Array Backtracking.
- [ ] I understand Grid Backtracking.
- [ ] I know when to Undo.
- [ ] I am ready for Constraint Backtracking.

---

# 📖 Part 2.4 — Constraint Backtracking, Pruning & Interview Mastery

> **Goal**
>
> Master the hardest recursion and backtracking patterns used in
> coding interviews.
>
> This section combines everything learned so far and prepares you
> for advanced interview questions.

---

# 🧠 Pattern Evolution

```text
Basic Recursion

↓

Recursive Faith

↓

Recursive Searching

↓

Branching

↓

Include / Exclude

↓

Choice Backtracking

↓

Permutation

↓

Grid Backtracking

────────────────────────────

NOW

↓

Constraint Backtracking

↓

Pruning

↓

Mixed Interview Problems

↓

Dynamic Programming
```

---

# 📊 Part 2.4 Overview

| Pattern | Problems | Range |
|---------|---------:|------:|
| L — Constraint Backtracking | 8 | 136–143 |
| M — Pruning | 8 | 144–151 |
| N — Mixed Interview Problems | 9 | 152–160 |

**Total : 25 Problems**

---

# 📖 Pattern L — Constraint Backtracking

> **Core Idea**
>
> Every recursive choice must satisfy
> one or more rules before recursion
> continues.

Unlike previous patterns,

not every choice is valid.

Every move must pass

**Constraint Checking**

---

# 🧠 Mental Model

```text
Choose

↓

Is Safe ?

↓

YES

↓

Recurse

↓

Undo

↓

Next Choice
```

---

# 🎯 Pattern Recognition

Questions containing

✅ Sudoku

✅ N Queens

✅ Graph Coloring

✅ Crossword

✅ Knight Tour

✅ Safe Position

Think

> **Constraint Backtracking**

---

# 📌 Formula

```java
for(each choice){

    if(isSafe(choice)){

        choose();

        recurse();

        undo();

    }

}
```

---

# 🚫 Common Mistakes

- [ ] Forgetting isSafe()
- [ ] Wrong row check
- [ ] Wrong column check
- [ ] Wrong diagonal check
- [ ] Forgetting Undo
- [ ] Duplicate work

---

# 📊 Complexity

Usually

```text
Exponential

O(b^d)
```

where

```
b

=

Branching Factor

d

=

Recursion Depth
```

---

# 🎯 Pattern Checklist

| Concept | Status |
|---------|:------:|
| Recognition | ⬜ |
| isSafe() | ⬜ |
| Constraint Checking | ⬜ |
| Undo | ⬜ |
| Complexity | ⬜ |
| Interview Ready | ⬜ |

---

# 📝 Problems

| # | Problem | Platform | Pattern | Difficulty | Interview | Status | R1 | R2 | R3 | R4 | R5 | Notes |
|---:|------------------------------------|:--------:|:---------:|:---------:|:---------:|:-----:|:--:|:--:|:--:|:--:|:--:|------|
|136|N Queens|🟨 LC 51|Constraint|🔴|⭐⭐⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|137|N Queens II|🟨 LC 52|Constraint|🔴|⭐⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|138|Sudoku Solver|🟨 LC 37|Constraint|🔴|⭐⭐⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|139|M Coloring Problem|🟩 GFG|Constraint|🔴|⭐⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|140|Knight Tour|🟩 GFG|Constraint|🔴|⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|141|Crossword Puzzle|🟩 GFG|Constraint|🔴|⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|142|Word Squares|🟨 LC 425|Constraint|🔴|⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|143|Beautiful Arrangement|🟨 LC 526|Constraint|🔴|⭐⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||

---

# 🌟 Pattern Summary

| Feature | Value |
|----------|-------|
| Constraint Check | ✅ |
| Undo Required | ✅ |
| isSafe() Function | ✅ |
| Multiple Choices | ✅ |
| Usually Exponential | ✅ |

---

# 📖 Pattern M — Pruning

> **Core Idea**
>
> Stop recursion as early as possible.
>
> Never explore a branch that
> can never produce a valid answer.

---

# 🧠 Mental Model

```text
Start

↓

Choice

↓

Invalid ?

↓

YES

↓

Return

↓

NO

↓

Continue
```

---

# 🎯 Pattern Recognition

Questions containing

✅ Skip Duplicate

✅ Early Return

✅ Impossible State

✅ Invalid Branch

✅ Optimization

Think

> **Pruning**

---

# 📌 Formula

```java
if(invalid){

    return;

}

recurse();
```

---

# 💡 Common Mistakes

- [ ] Pruning too early
- [ ] Missing valid answer
- [ ] Wrong duplicate condition
- [ ] Forgetting sorting
- [ ] Wrong pruning order

---

# 📊 Complexity

Much better than

plain Backtracking

because

many branches

are skipped.

---

# 🎯 Pattern Checklist

| Concept | Status |
|---------|:------:|
| Recognition | ⬜ |
| Early Return | ⬜ |
| Duplicate Skip | ⬜ |
| Complexity | ⬜ |
| Interview Ready | ⬜ |

---

# 📝 Problems

| # | Problem | Platform | Pattern | Difficulty | Interview | Status | R1 | R2 | R3 | R4 | R5 | Notes |
|---:|----------------------------------------|:--------:|:---------:|:---------:|:---------:|:-----:|:--:|:--:|:--:|:--:|:--:|------|
|144|Combination Sum II|🟨 LC 40|Pruning|🔴|⭐⭐⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|145|Subsets II|🟨 LC 90|Pruning|🟡|⭐⭐⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|146|Palindrome Partitioning|🟨 LC 131|Pruning|🟡|⭐⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|147|Word Search II|🟨 LC 212|Pruning|🔴|⭐⭐⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|148|Split Into Fibonacci Sequence|🟨 LC 842|Pruning|🔴|⭐⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|149|Maximum Score Words|🟨 LC 1255|Pruning|🔴|⭐⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|150|Expression Add Operators|🟨 LC 282|Pruning|🔴|⭐⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|151|Remove Invalid Parentheses|🟨 LC 301|Pruning|🔴|⭐⭐⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||

---

# 🌟 Pattern Summary

| Feature | Value |
|----------|-------|
| Early Stop | ✅ |
| Duplicate Removal | ✅ |
| Branch Cutting | ✅ |
| Faster Than Plain Backtracking | ✅ |

---

# 📖 Pattern N — Mixed Interview Problems

> **Core Idea**
>
> Real interview questions often combine
> multiple recursion and backtracking patterns.
>
> The goal is no longer recognizing one pattern,
> but combining several patterns together.

---

# 🎯 Pattern Recognition

Questions containing

✅ Combination + Constraint

✅ Grid + Pruning

✅ Choice + Pruning

✅ Multiple Techniques

Think

> **Mixed Interview Problem**

---

# 📝 Problems

| # | Problem | Platform | Main Pattern | Difficulty | Interview | Status | R1 | R2 | R3 | R4 | R5 | Notes |
|---:|---------------------------------------------|:--------:|:----------------:|:---------:|:---------:|:-----:|:--:|:--:|:--:|:--:|:--:|------|
|152|Partition to K Equal Sum Subsets|🟨 LC 698|Choice + Pruning|🔴|⭐⭐⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|153|Matchsticks to Square|🟨 LC 473|Constraint + Pruning|🔴|⭐⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|154|Word Break II|🟨 LC 140|Choice|🔴|⭐⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|155|Restore IP Addresses|🟨 LC 93|Choice|🔴|⭐⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|156|Maximum Length Concatenated String|🟨 LC 1239|Constraint|🔴|⭐⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|157|Shopping Offers|🟨 LC 638|Branching + Pruning|🔴|⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|158|Split String Into Descending Consecutive Values|🟨 LC 1849|Choice|🔴|⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|159|Cherry Pickup (Concept)|🟨 LC 741|Advanced|🔴|⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||
|160|Maximum Path Quality of a Graph|🟨 LC 2065|Mixed|🔴|⭐⭐⭐|⬜|⬜|⬜|⬜|⬜|⬜||

---

# 📊 Part 2.4 Progress

| Pattern | Problems | Completed |
|---------|---------:|:---------:|
| Constraint Backtracking | 8 | ⬜ |
| Pruning | 8 | ⬜ |
| Mixed Interview | 9 | ⬜ |

---

# 🏆 Part 2 Completion Checklist

## Pattern Mastery

- [ ] Recursive Faith
- [ ] Recursive Searching
- [ ] Index Jump
- [ ] Two Pointer
- [ ] Branching
- [ ] Include / Exclude
- [ ] Choice Backtracking
- [ ] Permutation
- [ ] Grid Backtracking
- [ ] Constraint Backtracking
- [ ] Pruning
- [ ] Mixed Interview Problems

---

## Interview Readiness

- [ ] I can identify recursion patterns within 10 seconds.
- [ ] I can derive the recursive state.
- [ ] I can write the base case immediately.
- [ ] I can draw recursion trees.
- [ ] I can explain time complexity.
- [ ] I can explain space complexity.
- [ ] I can convert recursion to memoization.
- [ ] I can solve unseen recursion problems.
- [ ] I can solve unseen backtracking problems.
- [ ] I am ready to begin Dynamic Programming.

---

# 🎯 Final Statistics

| Section | Problems |
|---------|---------:|
| Part 2.1 | 25 |
| Part 2.2 | 25 |
| Part 2.3 | 25 |
| Part 2.4 | 25 |

**Grand Total : 100 Problems (61–160)**

---

# 🚀 Next Roadmap

```text
Part 1
Basic Recursion

        ↓

Part 2
Advanced Recursion
&
Backtracking

        ↓

Part 3
Dynamic Programming

        ↓

Trees

        ↓

BST

        ↓

Graphs

        ↓

Advanced Algorithms
```

---

# 🎉 Congratulations!

After completing **Part 2**, you will have studied **100 carefully curated recursion and backtracking problems** covering all major interview patterns. This provides a solid foundation for transitioning into **Dynamic Programming**, where many branching and backtracking problems are optimized using memoization and tabulation.