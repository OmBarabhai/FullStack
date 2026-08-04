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
```

---

# Recognition

Whenever the question says

- Maximum
- Minimum
- Largest
- Smallest
- Best
- Sorted
- Maximum Index
- Minimum Index

Immediately think

```
Recursive Faith
```

---

# Problems Covered

| No | Problem | Status |
|----|---------|--------|
| 1 | Sorted Array | ✅ |
| 2 | Maximum Element | ✅ |
| 3 | Minimum Element | ✅ |
| 4 | Maximum Index | ✅ |
| 5 | Minimum Index | ✅ |

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

# Common Mistakes

❌ Returning current value immediately

❌ Forgetting to compare

❌ Returning index instead of value

❌ Returning value instead of index

❌ Comparing wrong elements

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

- Maximum Element
- Minimum Element
- Maximum Index
- Minimum Index
- Tree Maximum
- Tree Height
- Divide & Conquer

---

# Revision Checklist

- [ ] Base Case
- [ ] Ask Recursion
- [ ] Receive Answer
- [ ] Compare
- [ ] Return Better Answer