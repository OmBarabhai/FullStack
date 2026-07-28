# DB_FIB_05_COUNT_WAYS_TO_REACH_NTH_STAIR

## Recognition Keywords

- Count Ways
- Nth Stair
- 1 Step
- 2 Steps
- Total Ways
- Reach Top

👉 Think: Fibonacci + DP

---

## Short Problem Statement

There are `n` stairs.

- You can climb either **1 step** or **2 steps** at a time.
- Return the total number of distinct ways to reach the `nᵗʰ` stair.

---

## Function Signature

```java
public int countWays(int n)
```

---

## Optimal Java Solution

```java
class Solution {

    public int countWays(int n) {

        if (n <= 1) {
            return 1;
        }

        int first = 1;
        int second = 1;

        for (int i = 2; i <= n; i++) {

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

1 Step
2 Steps
     ↓
Count Ways
     ↓
Fibonacci
     ↓
Answer