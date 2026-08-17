# Pattern 04 - Recursive Searching

> "Check the current element first.
> If it's not the answer, trust recursion."

---

# Goal

Learn how to search recursively.

Instead of searching the entire array yourself,

check the current element,

if the answer is not found,

trust recursion to search the remaining array.

---

# Core Idea

Current Element

↓

Check

↓

Found?

↓

Yes

↓

Return Answer

↓

No

↓

Ask Recursion

↓

Return Recursive Answer

---

# Universal Formula

```java
if(currentMatches){
    return currentAnswer;
}

return recursion(smallerProblem);
```

---

# Mental Model

Don't search the whole array.

Search only your current position.

If you don't find the answer,

trust recursion.

---

# Recognition

Whenever the question says

- Search
- Find
- Contains
- Exists
- Occurrence
- Index
- Position
- Locate

Immediately think

```
Recursive Searching
```

---

# Problems Covered

| No | Problem | Status |
|----|---------|--------|
| 1 | Contains Element | ✅ |
| 2 | First Occurrence | ✅ |
| 3 | Last Occurrence | ✅ |
| 4 | First Even Index | ✅ |
| 5 | Last Even Index | ✅ |
| 6 | First Odd Index | ✅ |
| 7 | Last Odd Index | ✅ |
| 8 | First Positive Index | ✅ |
| 9 | Last Positive Index | ✅ |
|10 | First Negative Index | ✅ |

---

# Visualization

Example

Search 9

```
{2,5,9,7}

↓

Check 2

↓

Not Found

↓

Search Remaining

↓

Check 5

↓

Not Found

↓

Search Remaining

↓

Check 9

↓

Found

↓

Return Index
```

---

# Common Formula

```java
if(currentIsAnswer){
    return current;
}

return recursion(smallerProblem);
```

Sometimes

```java
if(currentIsAnswer){
    return true;
}

return recursion(smallerProblem);
```

---

# Common Return Types

```text
boolean

index

value

-1

true

false
```

---

# Common Mistakes

❌ Forgetting the base case

❌ Returning the current index without checking

❌ Returning value instead of index

❌ Forgetting to return recursion

❌ Searching the remaining array manually

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

- Contains Element
- Search Element
- First Occurrence
- Last Occurrence
- Tree Search
- Graph DFS
- Recursive Search

---

# Revision Checklist

- [ ] Base Case
- [ ] Check Current Element
- [ ] Found?
- [ ] Ask Recursion
- [ ] Return Correct Answer
- [ ] Dry Run

---

# Final Rule

```
Check yourself first.

If not found,

trust recursion.
```