# 🚀 00 - Recursion Handbook

> "Don't memorize recursion.
> Recognize the pattern."

---

# 📚 What is Recursion?

Recursion is a technique where a function solves a problem by calling itself on a **smaller version of the same problem** until it reaches a **base case**.

Every recursive problem has **only three things**.

```
Current Problem

↓

Smaller Problem

↓

Base Case
```

If you understand these three,
you can solve almost every recursion problem.

---

# 🧠 The Five Questions

Before writing ANY recursive function, answer these.

## 1️⃣ What is my Base Case?

Where should recursion stop?

Example

```java
if(idx == arr.length)
    return 0;
```

---

## 2️⃣ What is the Smaller Problem?

What should recursion solve for me?

Example

```
Current Problem

Find maximum from index 0

↓

Smaller Problem

Find maximum from index 1
```

---

## 3️⃣ What is my Current Work?

What should **I** do?

Example

```
Current Element

↓

Compare

↓

Add

↓

Multiply

↓

Print

↓

Nothing
```

---

## 4️⃣ What should I return?

Always identify return type first.

```
void

int

boolean

String

index

ArrayList

Node

TreeNode
```

---

## 5️⃣ Which Pattern is this?

Everything belongs to one pattern.

---

# 🌟 Recursion Patterns

---

## Pattern 1

# Pre-order

Current Work

↓

Recursive Call

Example

```
Print N to 1

DFS

Tree Traversal
```

Template

```java
currentWork();

recursion(smallerProblem);
```

---

## Pattern 2

# Post-order

Recursive Call

↓

Current Work

Example

```
Print 1 to N

Reverse Printing
```

Template

```java
recursion(smallerProblem);

currentWork();
```

---

## Pattern 3

# Current Contribution

Current Answer

+

Smaller Answer

Examples

```
Sum

Factorial

Power

Product

Sum of Array
```

Template

```java
return currentContribution
       + recursion(smallerProblem);
```

Sometimes

```java
return currentContribution
       * recursion(smallerProblem);
```

---

## Pattern 4

# Recursive Faith

Ask recursion to solve the smaller problem.

Use its answer.

Examples

```
Maximum

Minimum

Maximum Index

Minimum Index

Sorted Array
```

Template

```java
answer =
recursion(smallerProblem);

return combine(current, answer);
```

---

## Pattern 5

# Conditional Counting

Count only if condition is true.

Examples

```
Even Count

Odd Count

Positive Count

Negative Count

Target Count

Greater Than X
```

Template

```java
if(condition)

return 1 + recursion();

return recursion();
```

---

## Pattern 6

# Searching

Examples

```
Contains

First Occurrence

Last Occurrence
```

Template

```java
if(found)

return answer;

return recursion();
```

---

## Pattern 7

# Index Selection

Examples

```
Maximum Index

Minimum Index
```

Template

```java
best =
recursion();

compare current

return best;
```

---

## Pattern 8

# Custom Jump

Examples

```
Even Index

Odd Index

Jump By K
```

Template

```java
return recursion(idx+k);
```

---

## Pattern 9

# Two Pointer

Examples

```
Palindrome

Reverse Compare
```

Template

```java
compare

↓

left++

↓

right--
```

---

## Pattern 10

# Multiple Recursive Calls

Examples

```
Fibonacci

Binary Tree

Merge Sort

Quick Sort
```

Template

```java
left =
recursion();

right =
recursion();

combine();
```

---

## Pattern 11

# Choose / Don't Choose

Examples

```
Subsets

Backtracking

Combinations
```

---

## Pattern 12

# Decision Tree

Examples

```
N Queens

Sudoku

Maze

Word Search
```

---

# ⭐ Universal Recursion Template

```java
ReturnType function(parameters){

    // Base Case

    if(baseCase){

        return baseValue;

    }

    // Current Work

    ...

    // Smaller Problem

    answer =
    function(smallerProblem);

    // Combine

    return answer;

}
```

---

# 🚨 Biggest Mistakes

## Wrong Base Case

```
==

>=

>

<
```

Always check carefully.

---

## Wrong Recursive Call

```
idx+1

idx-1

idx+2

n-1

n/10

substring()
```

One wrong move breaks recursion.

---

## Returning Wrong Thing

```
return value

return index

return boolean

return String
```

Don't confuse them.

---

## Returning Too Early

Wrong

```java
return true;
```

before recursion.

---

## Using Wrong Current Value

Wrong

```java
arr[0]
```

Correct

```java
arr[idx]
```

---

## Forgetting Recursive Faith

Don't solve the smaller problem yourself.

Let recursion do it.

---

# 🧩 How to Recognize a Pattern

| If question says... | Pattern |
|---------------------|---------|
| Print | Pre/Post |
| Sum | Current Contribution |
| Product | Current Contribution |
| Count | Conditional Counting |
| Maximum | Recursive Faith |
| Minimum | Recursive Faith |
| Index | Index Selection |
| Search | Searching |
| Palindrome | Two Pointer |
| Jump | Custom Jump |
| Fibonacci | Multiple Calls |
| Subset | Choose / Don't Choose |
| Maze | Decision Tree |

---

# 🔥 Interview Checklist

Before coding ask:

- [ ] Base Case?
- [ ] Smaller Problem?
- [ ] Current Work?
- [ ] Return Type?
- [ ] Pattern?
- [ ] Dry Run?
- [ ] Time Complexity?
- [ ] Space Complexity?
- [ ] Edge Cases?

---

# 🎯 Progress Tracker

| Pattern               | Status |
|-----------------------|--------|
| Pre-order             | ✅      |
| Post-order            | ✅      |
| Current Contribution  | ✅      |
| Recursive Faith       | ✅      |
| Conditional Counting  | ✅      |
| Searching             | ✅      |
| Index Selection       | ✅      |
| Custom Jump           | ✅      |
| Two Pointer           | ✅      |
| Multiple Calls        | ⏳      |
| Choose / Don't Choose | ⏳      |
| Decision Tree         | ⏳      |

---

# 💡 Golden Rule

> Every recursion problem can be solved by answering only five questions.

1. Base Case?

2. Smaller Problem?

3. Current Work?

4. Return Type?

5. Pattern?

If you know these five answers, the code becomes a consequence—not something to memorize.