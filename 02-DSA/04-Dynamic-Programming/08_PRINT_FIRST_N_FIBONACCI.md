# DB_FIB_08_PRINT_FIRST_N_FIBONACCI

## Recognition Keywords

- Print Fibonacci
- First N Numbers
- Fibonacci Series
- Sequence
- 0 1 1 2 3 5

👉 Think: Fibonacci Iteration

---

## Short Problem Statement

Given an integer `n`.

Print the first `n` Fibonacci numbers.

---

## Function Signature

```java
public void printFibonacci(int n)
```

---

## Optimal Java Solution

```java
class Solution {

    public void printFibonacci(int n) {

        if (n <= 0) {
            return;
        }

        int first = 0;
        int second = 1;

        for (int i = 1; i <= n; i++) {

            System.out.print(first + " ");

            int current = first + second;
            first = second;
            second = current;
        }
    }
}
```

---

## Complexity

Time : O(n)

Space : O(1)

---

## Memory Trick

Print
  ↓
Current
  ↓
Update Previous Two
  ↓
Repeat