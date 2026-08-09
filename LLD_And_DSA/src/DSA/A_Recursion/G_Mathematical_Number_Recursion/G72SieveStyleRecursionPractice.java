package DSA.A_Recursion.G_Mathematical_Number_Recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * G72 - Sieve of Eratosthenes using Recursion
 * <p>
 * Goal:
 * Return all prime numbers <= n.
 * <p>
 * Example:
 * n = 10
 * Answer = [2, 3, 5, 7]
 * <p>
 * This file is written as a recursion-learning exercise.
 */
public class G72SieveStyleRecursionPractice {

    // ============================================================
    // 1. MARK MULTIPLES
    // ============================================================

    /*
     * PURPOSE:
     * Mark all multiples of idx as NOT prime.
     *
     * Example:
     * n = 30, idx = 5, mul = 25
     *
     * 25 -> false
     * 30 -> false
     * 35 -> STOP
     *
     * Why start from idx * idx?
     *
     * 5 * 2 = 10 -> already handled by 2
     * 5 * 3 = 15 -> already handled by 3
     * 5 * 4 = 20 -> already handled by smaller factors
     * 5 * 5 = 25 -> first potentially new multiple
     */
    public static void markMultiple(int n, boolean[] isPrime, int idx, int mul) {

        // BASE CASE:
        // We have gone beyond n.
        if (mul > n) {
            return;
        }

        // CURRENT WORK:
        // Cross out this multiple.
        isPrime[mul] = false;

        // RECURSIVE CASE:
        // Move to the next multiple of idx.
        //
        // Example:
        // idx = 5
        // 25 + 5 = 30
        // 30 + 5 = 35 -> stop
        markMultiple(n, isPrime, idx, mul + idx);
    }


    // ============================================================
    // 2. PROCESS CANDIDATE NUMBERS
    // ============================================================

    /*
     * PURPOSE:
     * Move through possible prime numbers.
     *
     * Flow:
     *
     * idx = 2
     *    |
     *    |-- if prime -> mark multiples
     *    |
     * idx = 3
     *    |
     *    |-- if prime -> mark multiples
     *    |
     * idx = 4
     *    |
     *    |-- if already false -> skip
     *
     * Stop when idx * idx > n.
     *
     * IMPORTANT:
     * Stopping does NOT mean numbers after idx are not prime.
     * It only means no more marking work is necessary.
     */
    public static void solve(int n, boolean[] isPrime, int idx) {

        // BASE CASE:
        // Stop after sqrt(n).
        if (idx * idx > n) {
            return;
        }

        // CURRENT WORK:
        // If idx survived previous marking, it is prime.
        if (isPrime[idx] == true) {

            // Start marking from idx * idx.
            markMultiple(n, isPrime, idx, idx * idx);
        }

        // RECURSIVE CASE:
        // Move to the next candidate.
        solve(n, isPrime, idx + 1);
    }


    // ============================================================
    // 3. MAIN SIEVE METHOD
    // ============================================================

    /*
     * STEPS:
     *
     * 1. Create boolean array.
     * 2. Initially assume 2...n are prime.
     * 3. Recursively cross out composite numbers.
     * 4. Collect values that remain true.
     */
    public static List<Integer> sieveStyleRecursion(int n) {

        List<Integer> ans = new ArrayList<>();

        // n + 1 because we want index n to exist.
        //
        // Example:
        // n = 10
        // indexes = 0 1 2 3 4 5 6 7 8 9 10
        boolean[] isPrime = new boolean[n + 1];

        // Initially assume every number from 2 to n is prime.
        // 0 and 1 remain false because they are not prime.
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }

        // Start recursive Sieve from 2.
        solve(n, isPrime, 2);

        // Collect numbers that were never crossed out.
        for (int i = 2; i <= n; i++) {
            if (isPrime[i] == true) {
                ans.add(i);
            }
        }

        return ans;
    }


    // ============================================================
    // 4. MAIN
    // ============================================================

    public static void main(String[] args) {

        int n = 30;

        List<Integer> result = sieveStyleRecursion(n);

        System.out.println("Prime numbers <= " + n + ": " + result);
    }
}


/*
====================================================================
G72 - PERMANENT UNDERSTANDING / REVISION
====================================================================

CORE IDEA:

Initially:

2  3  4  5  6  7  8  9  10 ... 30
T  T  T  T  T  T  T  T  T  ... T

Then:

2 is prime
    |
    |-- cross out multiples of 2

4, 6, 8, 10, 12, 14, ...

Then:

3 is prime
    |
    |-- cross out multiples of 3

6, 9, 12, 15, 18, ...

Then:

4 is already false
    |
    |-- skip

Then:

5 is prime
    |
    |-- start from 5 * 5 = 25

25, 30, ...

Then:

6 * 6 > 30
    |
    |-- STOP


====================================================================
WHY idx * idx?
====================================================================

For idx = 5:

5 * 2 = 10 -> already handled by 2
5 * 3 = 15 -> already handled by 3
5 * 4 = 20 -> already handled by smaller factors
5 * 5 = 25 -> FIRST potentially new multiple
5 * 6 = 30 -> next multiple

Therefore:

mul starts at idx * idx.


====================================================================
WHY mul + idx?
====================================================================

If:

idx = 5
mul = 25

Then:

25 + 5 = 30
30 + 5 = 35

So:

mul + idx

moves to the next multiple.


====================================================================
WHY idx * idx > n IS THE BASE CASE?
====================================================================

Example:

n = 30

idx = 2
2 * 2 = 4 <= 30 -> continue

idx = 3
3 * 3 = 9 <= 30 -> continue

idx = 4
4 * 4 = 16 <= 30
but 4 is already false -> skip

idx = 5
5 * 5 = 25 <= 30 -> continue

idx = 6
6 * 6 = 36 > 30 -> STOP

IMPORTANT:

Stopping does NOT mean numbers after idx are not prime.

It only means no more composite numbers need to be marked.

The remaining true values are collected afterward.


====================================================================
RECURSION RESPONSIBILITIES
====================================================================

solve()
    |
    |-- choose current idx
    |
    |-- check whether idx is still prime
    |
    |-- if prime:
    |      markMultiple()
    |
    |-- move to idx + 1


markMultiple()
    |
    |-- check mul > n
    |
    |-- mark current mul false
    |
    |-- move to mul + idx


====================================================================
DRY RUN - n = 10
====================================================================

Initial:

2  3  4  5  6  7  8  9  10
T  T  T  T  T  T  T  T  T


idx = 2

2 * 2 = 4

markMultiple:

4  -> false
6  -> false
8  -> false
10 -> false
12 -> STOP


idx = 3

3 * 3 = 9

markMultiple:

9  -> false
12 -> STOP


idx = 4

4 * 4 = 16 > 10

STOP.


Remaining true:

2  3  5  7

Answer:

[2, 3, 5, 7]


====================================================================
TIME / SPACE
====================================================================

Sieve idea:
Time: approximately O(n log log n)
Space: O(n) for the boolean array

This recursive practice version also uses recursion stack,
so it has additional call-stack usage.

For production/interview coding, the standard iterative Sieve
is usually preferred because it avoids recursive stack overhead.


====================================================================
ONE-LINE MEMORY RULE
====================================================================

Sieve:

"Assume prime -> find surviving prime -> cross out multiples
starting from its square -> move forward -> collect survivors."


====================================================================
GFG NOTE
====================================================================

The original GFG submission uses:

public ArrayList<Integer> sieve(int n)

This personal practice file uses:

public static List<Integer> sieveStyleRecursion(int n)

because it is a learning/revision file.

When submitting to GFG, adapt the method signature to GFG's
required signature.


====================================================================
*/
