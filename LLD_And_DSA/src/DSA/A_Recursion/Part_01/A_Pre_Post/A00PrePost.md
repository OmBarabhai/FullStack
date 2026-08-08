# Pattern 01 - Pre Order & Post Order Recursion

> **"The only difference is where the work is done."**

---

# Goal

Understand **when** recursion executes.

Every linear recursion problem follows one of **two execution orders**.

```
Current Work

↓

Recursive Call
```

OR

```
Recursive Call

↓

Current Work
```

If you master these two patterns, learning

- Trees
- BST
- DFS
- Graph Traversal
- Backtracking

becomes much easier.

---

# Core Idea

Every recursive function has **two phases**.

```
Going Down

↓

Base Case

↓

Coming Back
```

The only question is:

> **When should the current work happen?**

---

# Pattern 1 — Pre Order

## Definition

Current Work

↓

Recursive Call

---

## Universal Template

```java
if (baseCase) {
    return;
}

currentWork();

recursiveCall(smallerProblem);
```

---

## Flow

```
Current Work

↓

Go Deeper

↓

Current Work

↓

Go Deeper

↓

...

↓

Base Case
```

---

## Dry Run

Example

```
print(5)

↓

Print 5

↓

print(4)

↓

Print 4

↓

print(3)

↓

Print 3

↓

print(2)

↓

Print 2

↓

print(1)

↓

Print 1

↓

Stop
```

Output

```
5 4 3 2 1
```

---

## Used In

- Print N → 1
- Print Even Numbers
- Print Odd Numbers
- Print Alphabet A → Z
- Print Multiples of K
- Print Powers of 2
- DFS
- Tree Preorder Traversal

---

# Pattern 2 — Post Order

## Definition

Recursive Call

↓

Current Work

---

## Universal Template

```java
if (baseCase) {
    return;
}

recursiveCall(smallerProblem);

currentWork();
```

---

## Flow

```
Go Deeper

↓

Go Deeper

↓

Go Deeper

↓

Base Case

↓

Current Work

↓

Current Work

↓

Current Work
```

---

## Dry Run

Example

```
print(5)

↓

print(4)

↓

print(3)

↓

print(2)

↓

print(1)

↓

Stop

↑

Print 1

↑

Print 2

↑

Print 3

↑

Print 4

↑

Print 5
```

Output

```
1 2 3 4 5
```

---

## Used In

- Print 1 → N
- Print Even Numbers Reverse
- Print Odd Numbers Reverse
- Print Alphabet Z → A
- Reverse Printing
- Tree Postorder Traversal

---

# Call Stack Visualization

```
print(3)

↓

print(2)

↓

print(1)

↓

print(0)

↓

Base Case

↑

Return to print(1)

↑

Return to print(2)

↑

Return to print(3)
```

Remember

- Going Down → Recursive Calls
- Coming Up → Returning Phase

---

# How to Identify the Pattern

Ask yourself

```
Should I perform the work first?
```

YES

↓

```
Pre Order
```

---

Or

```
Should I perform the work after recursion finishes?
```

YES

↓

```
Post Order
```

---

# Problems Covered

| No | Problem | Pattern | Status |
|----|---------|---------|--------|
| 1 | Print N to 1 | Pre Order | ✅ |
| 2 | Print 1 to N | Post Order | ✅ |
| 3 | Print Even Numbers | Pre Order | ✅ |
| 4 | Print Odd Numbers | Pre Order | ✅ |
| 5 | Print Even Numbers Reverse | Post Order | ✅ |
| 6 | Print Odd Numbers Reverse | Post Order | ✅ |
| 7 | Print Alphabet A to Z | Pre Order | ✅ |
| 8 | Print Alphabet Z to A | Post Order | ✅ |
| 9 | Print Multiples of K | Pre Order | ✅ |
| 10 | Print Powers of 2 | Pre Order | ✅ |

---

# Pattern Recognition

If the question contains

```
Print

Display

Traverse

Visit

Output
```

Think

```
Pre Order

OR

Post Order
```

---

# Common Mistakes

## Mistake 1

Printing before recursion instead of after.

Example

```java
System.out.print(n);

recursion(...);
```

instead of

```java
recursion(...);

System.out.print(n);
```

---

## Mistake 2

Wrong Base Case

```java
if(n == 0)
    return;
```

Always verify the stopping condition.

---

## Mistake 3

Missing Recursive Call

```java
System.out.print(n);
```

instead of

```java
System.out.print(n);

recursion(...);
```

---

## Mistake 4

Forgetting `return`

```java
if(baseCase){
    return;
}
```

---

## Mistake 5

Thinking recursion executes immediately.

Actually,

```
Go Down

↓

Reach Base Case

↓

Come Back

↓

Finish Remaining Work
```

---

# Time Complexity

All Pattern 01 problems

```
Time : O(n)
```

---

# Space Complexity

```
Space : O(n)
```

(Call Stack)

---

# Interview Questions

- Print 1 to N
- Print N to 1
- Print Even Numbers
- Print Odd Numbers
- Print Multiples of K
- Print Powers of 2
- Print Alphabet
- Reverse Printing
- Tree Preorder Traversal
- Tree Postorder Traversal
- DFS Traversal

---

# Revision Checklist

- [ ] Understand Base Case
- [ ] Understand Current Work
- [ ] Understand Recursive Call
- [ ] Can identify Pre Order
- [ ] Can identify Post Order
- [ ] Can draw Call Stack
- [ ] Can perform Dry Run
- [ ] Know Time Complexity
- [ ] Know Space Complexity
- [ ] Can identify the pattern within 5 seconds

---

# Key Formula

## Pre Order

```
Current Work

↓

Recursive Call
```

---

## Post Order

```
Recursive Call

↓

Current Work
```

---

# Summary

```
Pre Order

Current Work

↓

Recursive Call

------------------------

Post Order

Recursive Call

↓

Current Work

------------------------

Remember

Going Down  → Recursive Calls

Coming Up   → Returning Phase

Pre Order   → Work while Going Down

Post Order  → Work while Coming Up
```