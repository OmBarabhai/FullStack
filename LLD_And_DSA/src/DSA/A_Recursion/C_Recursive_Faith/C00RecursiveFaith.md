
# Pattern 03 - Recursive Faith

> "Don't solve the smaller problem yourself.
> Trust recursion to solve it."

---

# Goal

Learn how to solve problems by trusting recursion.

Instead of solving the remaining array yourself,

ask recursion,

receive the answer,

compare with your current element,

return the better answer.

---

# Core Idea

Current Problem

↓

Ask recursion

↓

Recursion solves smaller problem

↓

Receive Answer

↓

Compare

↓

Return Better Answer

---

# Universal Formula

```java
answer = recursion(smallerProblem);

return combine(current, answer);
````

---

# Mental Model

Never solve the remaining array yourself.

Instead think

```
Recursion already knows the answer.

I only compare my answer
with recursion's answer.
```

---

# Recognition

Whenever the question says

* Maximum
* Minimum
* Largest
* Smallest
* Best
* Sorted
* Index
* Valid

Immediately think

```
Recursive Faith
```

---

# Problems Covered

| No | Problem                 | Status |
| -- | ----------------------- | ------ |
| 1  | Check Sorted Array      | ✅      |
| 2  | Maximum Element         | ✅      |
| 3  | Minimum Element         | ✅      |
| 4  | Maximum Index           | ✅      |
| 5  | Minimum Index           | ✅      |
| 6  | Largest Even Index      | ✅      |
| 7  | Largest Odd Index       | ✅      |
| 8  | Smallest Positive Index | ✅      |
| 9  | Largest Positive Index  | ✅      |
| 10 | Smallest Negative Index | ✅      |

---

# Common Pattern

```java
int answerFromRemaining = recursion(smallerProblem);

if (current is better)
    return current;

return answerFromRemaining;
```

---

# Common Mistakes

❌ Returning current value immediately

❌ Forgetting to compare

❌ Returning index instead of value

❌ Returning value instead of index

❌ Comparing wrong elements

❌ Solving the smaller problem yourself

---

# Time Complexity

Most problems

```
O(n)
```

---

# Space Complexity

```
O(n)
```

(Call Stack)

---

# Interview Uses

* Check Sorted Array
* Maximum Element
* Minimum Element
* Maximum Index
* Minimum Index
* Largest Even Index
* Largest Odd Index
* Smallest Positive Index
* Largest Positive Index
* Smallest Negative Index
* Tree Maximum
* Tree Minimum
* Tree Height
* Divide & Conquer
* Recursive Searching

---

# Revision Checklist

* [ ] Base Case
* [ ] Ask Recursion
* [ ] Receive Answer
* [ ] Compare
* [ ] Return Better Answer

---

# Final Rule

```
Trust recursion for the smaller problem.

You only compare.
```
