# DB_FIB_06_FIBONACCI_MOD_M

## Recognition Keywords

- Fibonacci Mod
- Modulo
- Large Number
- F(n) % M
- Overflow

👉 Think: Fibonacci + Modulo

---

## Short Problem Statement

Given two integers `n` and `m`.

Return the value of:

F(n) % m

where F(n) is the nth Fibonacci number.

---

## Function Signature

```java
public int fibMod(int n, int m)
```

---

## Optimal Java Solution

```java
class Solution {

    public int fibMod(int n, int m) {

        if (n <= 1) {
            return n;
        }

        int first = 0;
        int second = 1;

        for (int i = 2; i <= n; i++) {

            int current = (first + second) % m;

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

Fibonacci
     ↓
Take Mod
     ↓
Prevent Overflow
     ↓
Answer