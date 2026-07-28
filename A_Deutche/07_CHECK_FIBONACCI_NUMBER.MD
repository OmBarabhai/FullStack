# DB_FIB_07_CHECK_FIBONACCI_NUMBER

## Recognition Keywords

- Check Fibonacci
- Is Fibonacci
- Given Number
- True or False
- Perfect Square

👉 Think: Math + Fibonacci

---

## Short Problem Statement

Given an integer `n`.

Return `true` if `n` is a Fibonacci number, otherwise return `false`.

---

## Function Signature

```java
public boolean isFibonacci(int n)
```

---

## Optimal Java Solution

```java
class Solution {

    public boolean isFibonacci(int n) {

        long value1 = 5L * n * n + 4;
        long value2 = 5L * n * n - 4;

        return isPerfectSquare(value1) || isPerfectSquare(value2);
    }

    private boolean isPerfectSquare(long num) {

        long root = (long) Math.sqrt(num);

        return root * root == num;
    }
}
```

---

## Complexity

Time : O(1)

Space : O(1)

---

## Memory Trick

```
5 × n² ± 4
       ↓
Perfect Square?
       ↓
Yes → Fibonacci
No  → Not Fibonacci
```