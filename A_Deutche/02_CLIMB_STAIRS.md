# DB_FIB_02_CLIMB_STAIRS

## Recognition Keywords

- Climbing Stairs
- 1 or 2 Steps
- Count Ways
- Reach Top
- Total Number of Ways

👉 Think: Fibonacci + DP

---

## Short Problem Statement

You are climbing a staircase.

- There are `n` steps.
- You can climb either **1 step** or **2 steps** at a time.
- Return the total number of distinct ways to reach the top.

---

## Function Signature

```java
public int climbStairs(int n)
```

---

## Optimal Java Solution

```java
class Solution {

    public int climbStairs(int n) {

        if (n <= 2) {
            return n;
        }

        int first = 1;
        int second = 2;

        for (int i = 3; i <= n; i++) {
            int current = first + second;
            first = second;
            second = current;
        }

        return second;
    }
}
```

---

## Complexity

Time : O(n)

Space : O(1)

---

## Memory Trick

1 or 2 Steps
      ↓
Count Ways
      ↓
Fibonacci
      ↓
DP
      ↓
Answer