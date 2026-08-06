# Pattern 02 - Current Contribution

> "Solve the smaller problem first, then combine the current contribution."

---

# Goal

Learn how to solve recursion problems where the current element contributes to the final answer while the recursive call solves the remaining smaller problem.

The contribution may be:

```
Current Contribution

+

Smaller Answer
```

or

```
Current Contribution

×

Smaller Answer
```

or

```
Current Contribution

Place Value

+

Smaller Answer
```

---

# Core Idea

Every recursive call solves a smaller problem.

The current function contributes only its own value.

```
Current Problem

↓

Current Contribution

↓

Solve Smaller Problem

↓

Combine

↓

Return
```

---

# Universal Template

### Addition

```java
if(baseCase){
    return baseValue;
}

return currentContribution
        + recursion(smallerProblem);
```

---

### Multiplication

```java
if(baseCase){
    return baseValue;
}

return currentContribution
        * recursion(smallerProblem);
```

---

### Place Value Contribution

```java
if(baseCase){
    return baseValue;
}

return currentContributionAtCorrectPlace
        + recursion(smallerProblem);
```

---

# Current Contribution Patterns

## Pattern 1

Current Value + Smaller Answer

```
Current

+

Smaller Problem
```

Examples

- Sum of N
- Sum of Digits
- Sum of Array

---

## Pattern 2

Current Value × Smaller Answer

```
Current

×

Smaller Problem
```

Examples

- Factorial
- Power
- Product of Digits
- Product of Array

---

## Pattern 3

Current Value at Correct Position

```
(Current × Place Value)

+

Smaller Problem
```

Examples

- Reverse Number

---

## Pattern 4

Current Character After Smaller Answer

```
Smaller Problem

+

Current Character
```

Examples

- Reverse String

Notice that Reverse String builds the answer while returning from recursion.

---

# Visualization

Example

```
sum(5)

↓

5

+

sum(4)

↓

4

+

sum(3)

↓

3

+

sum(2)

↓

2

+

sum(1)

↓

1

+

sum(0)
```

Returning

```
0

↓

1

↓

3

↓

6

↓

10

↓

15
```

---

# Another Visualization

Factorial

```
factorial(5)

↓

5

×

factorial(4)

↓

4

×

factorial(3)

↓

3

×

factorial(2)

↓

2

×

factorial(1)
```

Returning

```
1

↓

2

↓

6

↓

24

↓

120
```

---

# Reverse Number Visualization

```
reverse(78327)

↓

7 × 10000

+

reverse(7832)

↓

2 × 1000

+

reverse(783)

↓

3 × 100

+

reverse(78)

↓

8 × 10

+

reverse(7)

↓

7
```

Returning

```
7

↓

87

↓

387

↓

2387

↓

72387
```

---

# Recognition

Whenever you see

```
Sum

Product

Factorial

Power

Reverse

Total

Count

Digits

Array

String
```

Ask yourself

```
What is the current contribution?

+

What is the smaller problem?
```

---

# Questions to Ask Yourself

1.

```
What is the smaller problem?
```

---

2.

```
What is the current contribution?
```

---

3.

```
How should I combine them?

+

×

Place Value

Append Character
```

---

4.

```
What is the base case?
```

---

# Problems Covered

| No | Problem | Contribution Type | Status |
|----|---------|-------------------|--------|
| 1 | Sum of N | Addition | ✅ |
| 2 | Factorial | Multiplication | ✅ |
| 3 | Power | Multiplication | ✅ |
| 4 | Sum of Digits | Addition | ✅ |
| 5 | Count Digits | Count | ✅ |
| 6 | Reverse String | Smaller + Current | ✅ |
| 7 | Product of Array | Multiplication | ✅ |
| 8 | Product of Digits | Multiplication | ✅ |
| 9 | Reverse Number | Place Value | ✅ |

---

# Common Mistakes

### Forgetting Current Contribution

❌

```java
return recursion(smallerProblem);
```

✔

```java
return currentContribution
        + recursion(smallerProblem);
```

---

### Wrong Base Case

Example

Sum

```java
return 1;
```

❌

Correct

```java
return 0;
```

---

Factorial

```java
return 0;
```

❌

Correct

```java
return 1;
```

---

### Wrong Operator

Using

```
+
```

instead of

```
×
```

or vice versa.

---

### Forgetting Place Value

Reverse Number

❌

```
lastDigit + reverse(...)
```

✔

```
lastDigit × placeValue
+
reverse(...)
```

---

### Combining Before Solving Smaller Problem

Current Contribution pattern always solves

```
Smaller Problem

↓

Combine

↓

Return
```

---

# Complexity

Most Current Contribution problems

```
Time  : O(n)

Space : O(n)
```

---

Special Case

Reverse Number (Place Value Method)

```
Time  : O(d²)

Space : O(d)
```

where

```
d = Number of Digits
```

Optimized Helper Solution

```
Time  : O(d)

Space : O(d)
```

---

# Interview Questions

- Sum of N
- Factorial
- Power
- Sum of Digits
- Count Digits
- Reverse String
- Product of Array
- Product of Digits
- Reverse Number
- Sum of Array
- Product of String Values (Variation)

---

# Revision Checklist

- [ ] Identify the smaller problem
- [ ] Find the current contribution
- [ ] Choose the correct operator (+ or ×)
- [ ] Check if place value is required
- [ ] Write the base case
- [ ] Dry run the recursion tree
- [ ] Analyze Time & Space Complexity
- [ ] Solve one variation without help

---

# Key Formula

```
Answer

=

Current Contribution

+

Smaller Answer
```

or

```
Answer

=

Current Contribution

×

Smaller Answer
```

or

```
Answer

=

(Current Contribution × Place Value)

+

Smaller Answer
```