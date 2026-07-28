# DB_FIB_03_MIN_COST_CLIMBING_STAIRS

## Recognition Keywords

- Min Cost
- Climbing Stairs
- 1 or 2 Steps
- Reach Top
- Minimum Cost
- Cost Array

👉 Think: DP + Fibonacci Pattern

---

## Short Problem Statement

You are given an integer array `cost`.

- `cost[i]` is the cost of stepping on the `iᵗʰ` stair.
- You can climb either **1 step** or **2 steps** at a time.
- You can start from step **0** or **1**.
- Return the minimum cost to reach the top.

---

## Function Signature

```java
public int minCostClimbingStairs(int[] cost)
```

---

## Optimal Java Solution

```java
class Solution {

    public int minCostClimbingStairs(int[] cost) {

        int first = 0;
        int second = 0;

        for (int i = 2; i <= cost.length; i++) {

            int current = Math.min(
                    first + cost[i - 2],
                    second + cost[i - 1]
            );

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
Pay Cost
      ↓
Choose Minimum
      ↓
DP
      ↓
Answer