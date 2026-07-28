# DB_FIB_04_TRIBONACCI_NUMBER

## Recognition Keywords

- Tribonacci
- Third Previous
- T(n-1) + T(n-2) + T(n-3)
- Nth Number

👉 Think: Fibonacci Extension

---

## Short Problem Statement

The Tribonacci sequence is defined as:

- T0 = 0
- T1 = 1
- T2 = 1

For n >= 3,

T(n) = T(n-1) + T(n-2) + T(n-3)

Return T(n).

---

## Function Signature

```java
public int tribonacci(int n)
```

---

## Optimal Java Solution

```java
class Solution {

    public int tribonacci(int n) {

        if (n == 0) {
            return 0;
        }

        if (n <= 2) {
            return 1;
        }

        int first = 0;
        int second = 1;
        int third = 1;

        for (int i = 3; i <= n; i++) {

            int current = first + second + third;

            first = second;
            second = third;
            third = current;
        }

        return third;
    }
}
```

---

## Complexity

Time : O(n)

Space : O(1)

---

## Memory Trick

Previous 3
      ↓
Add
      ↓
Shift
      ↓
Answer