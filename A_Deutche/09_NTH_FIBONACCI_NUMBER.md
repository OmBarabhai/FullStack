# DB_FIB_09_NTH_FIBONACCI_NUMBER

## Recognition Keywords

- Nth Fibonacci
- Find F(n)
- Fibonacci Number
- Return nth Term
- F(n)

👉 Think: Classic Fibonacci

---

## Short Problem Statement

Given an integer `n`.

Return the `nᵗʰ` Fibonacci number.

The Fibonacci sequence is:

0, 1, 1, 2, 3, 5, 8, ...

---

## Function Signature

```java
public int fib(int n)
```

---

## Optimal Java Solution

```java
class Solution {

    public int fib(int n) {

        if (n <= 1) {
            return n;
        }

        int first = 0;
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

Previous Two
      ↓
Add
      ↓
Shift
      ↓
Return nth