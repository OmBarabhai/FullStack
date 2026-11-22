# E00 – Conditional Counting

---

# Pattern 05 : Conditional Counting

> **Category : Recursion**
>
> **Folder : E_Conditional_Counting**
>
> **Difficulty : Beginner → Intermediate**
>
> **Interview Importance : ⭐⭐⭐⭐⭐**

---

# Definition

Conditional Counting is a recursion pattern where the recursive call returns the **count from the remaining array**, and the current function decides whether to increase that count based on a condition.

Unlike **Searching**, we **never stop early**.

Unlike **Recursive Faith**, we are **not comparing values**.

We simply:

1. Ask recursion for the count.
2. Check the current element.
3. Add **1** if the condition is true.
4. Return the final count.

---

# Core Idea

```text
Current Element

        ↓

Ask Recursion

        ↓

Receive Count

        ↓

Condition True ?

      /     \

    YES      NO
     |        |
Count + 1   Count
```

---

# Mental Model

```text
I don't count the whole array.

I trust recursion to count
everything after me.

I only decide whether
the current element
contributes

0

or

1

to the final answer.
```

---

# Recursive Faith

```text
Faith

count(arr, idx + 1)

already knows

how many matching elements

exist in the remaining array.
```

---

# Current Work

```text
Check Current Element

↓

Does it satisfy
the condition?

↓

YES

↓

Count + 1

↓

NO

↓

Count
```

---

# Generic Formula (Recommended)

```java
int count = recursion(smallerProblem);

if(condition){

    return count + 1;

}

return count;
```

---

# Direct Recursive Formula

```java
if(condition){

    return 1 + recursion(smallerProblem);

}

return recursion(smallerProblem);
```

---

# General Algorithm

```text
Step 1

Reach the end of the array.

        ↓

Step 2

Trust recursion
to count the remaining elements.

        ↓

Step 3

Check the current element.

        ↓

Step 4

If the condition is true,
add 1.

        ↓

Otherwise

return the recursive answer.
```

---

# Recursion Flow

```text
count(0)

↓

count(1)

↓

count(2)

↓

count(3)

↓

count(4)

↓

Base Case

↓

0

↑

Current Work

↑

Current Work

↑

Current Work

↑

Current Work

↑

Final Count
```

---

# Pattern Recognition

Whenever the question contains

- Count
- Frequency
- Number Of
- Occurrences
- Total Matches
- Filter
- Matching Elements

Immediately think

```text
Conditional Counting
```

---

# Problems Covered

| No | Problem | Status |
|---:|---------|:------:|
| 41 | Count Occurrences | ⬜ |
| 42 | Count Equal To X | ⬜ |
| 43 | Count Greater Than X | ⬜ |
| 44 | Count Less Than X | ⬜ |
| 45 | Count Even Numbers | ⬜ |
| 46 | Count Odd Numbers | ⬜ |
| 47 | Count Positive Numbers | ⬜ |
| 48 | Count Negative Numbers | ⬜ |
| 49 | Count Zeroes | ⬜ |
| 50 | Count Multiples Of K | ⬜ |

---

# Pattern Evolution

```text
Searching

↓

Searching returns

Index / Boolean

────────────────────

Conditional Counting

↓

Returns

Integer Count

────────────────────

Recursive Faith

↓

Compare Answers

────────────────────

Backtracking

↓

Generate Answers
```

---

# Dry Run

Array

```text
{5,2,7,2,9}
```

Target

```text
2
```

```text
count(0)

↓

count(1)

↓

count(2)

↓

count(3)

↓

count(4)

↓

count(5)

↓

0

↑

9

↓

0

↑

2

↓

1

↑

7

↓

1

↑

2

↓

2

↑

5

↓

2
```

Answer

```text
2
```

---

# Recursion Tree

```text
count(0)
│
└──count(1)
    │
    └──count(2)
        │
        └──count(3)
            │
            └──count(4)
                │
                └──count(5)
```

---

# Returning Phase

```text
count(5)

↓

0

↑

count(4)

↓

0

↑

count(3)

↓

1

↑

count(2)

↓

1

↑

count(1)

↓

2

↑

count(0)

↓

2
```

---

# Complexity

## Time Complexity

```text
O(n)
```

Every element is visited exactly once.

---

## Space Complexity

```text
O(n)
```

Recursion Call Stack

---

# Common Mistakes

- Returning `1` immediately instead of adding to the recursive answer.
- Forgetting the recursive call.
- Wrong base case.
- Returning the current count instead of the accumulated count.
- Mixing searching and counting logic.
- Stopping recursion after finding the first match.

---

# Difference Between Searching and Counting

| Searching | Conditional Counting |
|-----------|----------------------|
| Returns index | Returns count |
| May stop early | Must visit every element |
| Returns boolean/index | Returns integer |
| Finds one answer | Counts all answers |

---

# Difference Between Recursive Faith and Conditional Counting

| Recursive Faith | Conditional Counting |
|-----------------|----------------------|
| Compare answers | Add to answer |
| Maximum / Minimum | Frequency / Count |
| Returns best answer | Returns total count |
| Compare current with recursive answer | Add current contribution |

---

# Applications

- Frequency Counting
- Statistics
- Data Filtering
- Validation
- Counting Occurrences
- Interview Problems
- Dynamic Programming State Counting
- Tree Node Counting
- Graph Node Counting

---

# Interview Questions

Typical interview questions include:

- Count occurrences of X
- Count equal to X
- Count greater than X
- Count less than X
- Count even numbers
- Count odd numbers
- Count positive numbers
- Count negative numbers
- Count zeroes
- Count multiples of K

---

# Interview Tips

- Always write the base case first.
- Think:

```text
"What count will recursion return?"
```

- The current element contributes only:

```text
0

or

1
```

- Never stop recursion early.
- Keep the recursive pattern identical.
- Only the condition changes.

---

# Pattern Summary

```text
Base Case

↓

Ask Recursion

↓

Receive Count

↓

Check Condition

↓

Condition True ?

↓

YES

↓

Count + 1

↓

NO

↓

Count

↓

Return Answer
```

---

# Master Formula

```java
int count = recursion(smallerProblem);

if(condition){

    return count + 1;

}

return count;
```

---

# Complete Pattern

```text
Condition

↓

Boolean Result

↓

YES

↓

+1

↓

NO

↓

+0

↓

Recursive Answer

↓

Final Count
```

---

# Skills Learned

- Recursive Counting
- Conditional Logic
- Recursive Faith
- Frequency Counting
- Boolean Conditions
- Filtering
- Recursive Accumulation
- Pattern Recognition

---

# Master Checklist

| Skill | Status |
|--------|:------:|
| Base Case | ⬜ |
| Recursive Call | ⬜ |
| Recursive Faith | ⬜ |
| Current Work | ⬜ |
| Condition Checking | ⬜ |
| Counting Logic | ⬜ |
| Dry Run | ⬜ |
| Recursion Tree | ⬜ |
| Complexity | ⬜ |
| Pattern Recognition | ⬜ |
| Interview Ready | ⬜ |

---

# Next Pattern

```text
Pattern A

↓

Pattern B

↓

Pattern C

↓

Pattern D

↓

Pattern E
Conditional Counting

↓

Pattern F
Index Jump

↓

Pattern G
Branching Recursion

↓

Backtracking
```

---

# Final Takeaway

Conditional Counting is one of the simplest and most reusable recursion patterns.

The recursive structure **never changes**—only the **condition** changes.

Once you understand this pattern, you can solve almost every recursive counting problem by replacing a single condition while keeping the rest of the algorithm identical.

Master this pattern before moving to **Branching Recursion** and **Backtracking**, where recursion begins exploring multiple choices instead of simply accumulating a count.