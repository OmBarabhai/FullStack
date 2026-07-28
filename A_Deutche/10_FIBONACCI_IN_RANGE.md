# DB_FIB_10_FIBONACCI_IN_RANGE

## Recognition Keywords

- Fibonacci in Range
- Print Fibonacci
- Between L and R
- Range
- Lower Bound
- Upper Bound

👉 Think: Generate Fibonacci Until Upper Limit

---

## Short Problem Statement

Given two integers `L` and `R`.

Print all Fibonacci numbers that lie between `L` and `R` (inclusive).

---

## Function Signature

```java
public void fibonacciInRange(int L, int R)
```

---

## Optimal Java Solution

```java
class Solution {

    public void fibonacciInRange(int L, int R) {

        int first = 0;
        int second = 1;

        while (first <= R) {

            if (first >= L) {
                System.out.print(first + " ");
            }

            int current = first + second;
            first = second;
            second = current;
        }
    }
}
```

---

## Complexity

Time : O(Number of Fibonacci Terms ≤ R)

Space : O(1)

---

## Memory Trick

Generate
      ↓
Check Range
      ↓
Print
      ↓
Repeat