# DB_FIB_01_LADDER

## Recognition Keywords

- Ladder
- 1 or 2 Steps
- Modulo 2^P
- Arrays A and B
- Return Array

👉 Think: Fibonacci + DP + Precomputation

---

## Short Problem Statement

There are multiple ladders.

- A[i] = Number of rungs
- You can climb 1 or 2 steps at a time.
- Return the number of ways modulo 2^B[i].

---

## Function Signature

```java
public int[] solution(int[] A, int[] B)
```

---

## Optimal Java Solution

```java
class Solution {

    public int[] solution(int[] A, int[] B) {

        int n = A.length;
        int[] answer = new int[n];

        int maxRung = 0;

        for (int rung : A) {
            maxRung = Math.max(maxRung, rung);
        }

        int[] ways = new int[maxRung + 2];

        ways[0] = 1;
        ways[1] = 1;

        int mod = 1 << 30;

        for (int i = 2; i <= maxRung + 1; i++) {
            ways[i] = (ways[i - 1] + ways[i - 2]) % mod;
        }

        for (int i = 0; i < n; i++) {
            answer[i] = ways[A[i] + 1] & ((1 << B[i]) - 1);
        }

        return answer;
    }
}
```

---

## Complexity

Time : O(N + Max(A))

Space : O(Max(A))

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
Modulo
      ↓
Return Array