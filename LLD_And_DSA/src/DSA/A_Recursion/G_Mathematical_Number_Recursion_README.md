# G — Mathematical / Number Recursion

> **Goal:** Learn the recursion pattern behind each problem.  
> Keep the README short enough for revision.

---

# 1. Pattern Order

The problems are ordered by the **algorithm / recursion pattern**, not by the original problem number.

| Pattern | Problems | Priority |
|---|---|---|
| 1. Linear Reduction | G63, G69 | ⭐⭐⭐⭐ |
| 2. Divide by 2 | G61, G62 | ⭐⭐⭐⭐⭐ |
| 3. Mathematical Recurrence — One Branch | G65, G68 | ⭐⭐⭐⭐⭐ |
| 4. Mathematical Recurrence — Two Branches | G64, G66 | ⭐⭐⭐⭐⭐ |
| 5. Multiple Recursive Calls | G67 | ⭐⭐⭐⭐⭐ |
| 6. Divisor / Prime Traversal | G70, G71, G72 | ⭐⭐⭐ |
| 7. Binary / Representation | G75, G76 | ⭐⭐⭐⭐ |
| 8. Level / Constructive Generation | G73, G74 | ⭐⭐⭐⭐ |
| 9. Current Contribution | G77, G78 | ⭐⭐⭐ |
| 10. Step-2 / Alternating Recursion | G79, G80 | ⭐⭐⭐ |

> **G75:** Keep the exact implementation/notes from the existing G75 file when available. The supplied material did not include its actual code, so no invented implementation is added here.

---

# 2. Pattern 1 — Linear Reduction

## G63 — Division Recursively ⭐⭐⭐⭐

### Algorithm

```text
divide(a, b)
    ↓
reduce a using b
    ↓
recurse on smaller remainder
    ↓
count quotient contribution
```

### Code Memory

```text
BASE CASE
    cannot subtract another divisor → stop

STEP
    find useful multiple of divisor
    subtract it
    recurse on remainder
    add quotient contribution
```

### Remember

```text
REDUCE → RECURSE → COUNT
```


### 🔹 Dry Run / Recursion Flow

```text
divide(13, 3)
    ↓
remove 3
    ↓
divide(10, 3)
    ↓
remove 3
    ↓
divide(7, 3)
    ↓
remove 3
    ↓
divide(4, 3)
    ↓
remove 3
    ↓
divide(1, 3)
    ↓
BASE CASE
    ↓
return
```

**Paper rule:** write the current remainder beside every call.

```text
13 → 10 → 7 → 4 → 1 → STOP
```


---

## G69 — Euclidean GCD ⭐⭐⭐⭐

### Algorithm

```text
gcd(a, b)
    ↓
gcd(b, a % b)
    ↓
repeat
    ↓
b == 0
```

### Code Memory

```java
gcd(a, b):
    if (b == 0)
        return a;

    return gcd(b, a % b);
```

### Remember

```text
(a, b) → (b, a % b)
```


### 🔹 Dry Run / Recursion Tree

```text
gcd(48,18)
    ↓
gcd(18, 48 % 18)
    ↓
gcd(18,12)
    ↓
gcd(12, 18 % 12)
    ↓
gcd(12,6)
    ↓
gcd(6, 12 % 6)
    ↓
gcd(6,0)
    ↓
BASE CASE
    ↓
return 6
    ↑
return 6
    ↑
return 6
```

**Paper rule:**

```text
(a,b)
 ↓
(b,a%b)
```

Keep writing the new pair until `b = 0`.


### Complexity

```text
Time  : O(log min(a,b))
Space : O(log min(a,b))
```

---

# 3. Pattern 2 — Divide by 2

## G61 — Fast Exponentiation ⭐⭐⭐⭐⭐

### Algorithm

```text
power(x, n)
    ↓
n / 2
    ↓
solve half
    ↓
square half
    ↓
if n is odd → × x
```

### Code Memory

```java
power(x, n):
    if (n == 0)
        return 1;

    half = power(x, n / 2);

    if (n % 2 == 0)
        return half * half;

    return x * half * half;
```

### Remember

```text
HALVE → RECURSE → SQUARE → ODD? × x
```


### 🔹 Dry Run / Recursion Tree

Example: `power(2,5)`

```text
power(2,5)
    ↓
power(2,2)
    ↓
power(2,1)
    ↓
power(2,0)
    ↓
   1
    ↑
2 × 1 × 1 = 2
    ↑
2 × 2 = 4
    ↑
2 × 4 × 4 = 32
```

**Important:** the real work happens while the calls **return upward**.

```text
GO DOWN  → n / 2
COME UP  → combine
```


### Complexity

```text
Time  : O(log n)
Space : O(log n)
```

---

## G62 — Multiply Two Numbers Recursively ⭐⭐⭐⭐⭐

### Algorithm

```text
multiply(a, b)
    ↓
halve b
    ↓
solve half
    ↓
double result
    ↓
if b is odd → +a
```

### Code Memory

```java
multiply(a, b):
    if (b == 0)
        return 0;

    half = multiply(a, b / 2);
    ans = half + half;

    if (b % 2 != 0)
        ans += a;

    return ans;
```

### Remember

```text
HALVE b → DOUBLE → ODD? +a
```


### 🔹 Dry Run / Recursion Tree

Example: `multiply(5,5)`

```text
multiply(5,5)
    ↓
multiply(5,2)
    ↓
multiply(5,1)
    ↓
multiply(5,0)
    ↓
   0
    ↑
0 + 5 = 5
    ↑
5 + 5 = 10
    ↑
10 + 10 + 5 = 25
```

**Paper rule:**

```text
b → b/2 → b/4 → ...
```

Then rebuild the answer while returning.


---

# 4. Pattern 3 — Mathematical Recurrence / One Branch

## G65 — nPr ⭐⭐⭐⭐⭐

### Formula

```text
nPr = n × (n-1)P(r-1)
```

### Algorithm

```text
take current choice
    ↓
reduce n and r
    ↓
multiply current n
```

### Code Memory

```java
nPr(n, r):
    if (n < r)
        return 0;

    if (r == 0)
        return 1;

    return n * nPr(n - 1, r - 1);
```

### Remember

```text
ONE BRANCH → MULTIPLY
```


### 🔹 Dry Run / Recursion Tree

Example: `5P2`

```text
nPr(5,2)
    ↓
5 × nPr(4,1)
          ↓
        4 × nPr(3,0)
                  ↓
                  1
                  ↑
                4 × 1 = 4
    ↑
5 × 4 = 20
```

**Paper rule:** one recursive branch; multiplication happens on the way back.


---

## G68 — Josephus ⭐⭐⭐⭐⭐

### Algorithm

```text
n people
   ↓
remove one
   ↓
solve n - 1
   ↓
map smaller answer back
```

### Code Memory

```text
josephus(n):
    BASE CASE
        one person remains

    survivor = josephus(n - 1)

    transform survivor
    to the original indexing
```

### Remember

```text
SOLVE SMALLER → MAP BACK
```


### 🔹 Dry Run / Recursion Flow

For a Josephus problem, first shrink the problem:

```text
n
↓
n - 1
↓
n - 2
↓
...
↓
BASE CASE
```

Then the answer returns upward:

```text
survivor(n-1)
      ↓
transform index
      ↓
survivor(n)
```

**Paper rule:** write the smaller survivor first; only then map it back to the larger problem.


> Be careful with **0-based vs 1-based indexing**.

---

# 5. Pattern 4 — Mathematical Recurrence / Two Branches

## G64 — nCr ⭐⭐⭐⭐⭐

### Formula

```text
nCr
=
(n-1)C(r-1)
+
(n-1)Cr
```

### Algorithm

```text
                 nCr
                /   \
            CHOOSE  DON'T CHOOSE
               ↓        ↓
          n-1,r-1     n-1,r
```

### Code Memory

```java
nCr(n, r):
    if (n < r)
        return 0;

    if (r == 0 || n == r)
        return 1;

    return nCr(n - 1, r - 1)
         + nCr(n - 1, r);
```

### Remember

```text
CHOOSE + DON'T CHOOSE
```


### 🔹 Dry Run / Recursion Tree

Example: `5C2`

```text
                         5C2
                       /     \
                    4C1       4C2
                   /   \     /   \
                3C0   3C1  3C1   3C2
                 |    / \   |    / \
                 1   2   1   1   3C1 3C2
```

The important shape is:

```text
                  nCr
                 /   \
        choose       don't choose
        ↓                 ↓
   (n-1)C(r-1)        (n-1)Cr
```

**Paper rule:** follow one branch to a base case, return its value, then calculate the other branch.


### Complexity

```text
Time  : O(2^n) approximately
Space : O(n)
```

---

## G66 — Pascal Triangle ⭐⭐⭐⭐

### Formula

```text
pascal(row, col)
=
pascal(row-1, col-1)
+
pascal(row-1, col)
```

### Code Memory

```java
pascal(row, col):
    if (col == 0 || col == row)
        return 1;

    return pascal(row - 1, col - 1)
         + pascal(row - 1, col);
```

### Remember

```text
TOP-LEFT + TOP
```

### Connection

```text
G64 nCr
    ↓
same recurrence
    ↓
G66 Pascal
```

---

# 6. Pattern 5 — Multiple Recursive Calls

## G67 — Tower of Hanoi ⭐⭐⭐⭐⭐

### Algorithm

```text
move n-1 disks
        ↓
move largest disk
        ↓
move n-1 disks
```

### Code Memory

```text
hanoi(n, source, helper, target):

    if n == 1
        move source → target

    hanoi(n-1, source, target, helper)

    move source → target

    hanoi(n-1, helper, source, target)
```

### Remember

```text
n-1 → BIG DISK → n-1
```


### 🔹 Dry Run / Recursion Tree

For `n = 3`:

```text
hanoi(3)
├── hanoi(2)
│   ├── hanoi(1)
│   ├── move disk 2
│   └── hanoi(1)
├── move disk 3
└── hanoi(2)
    ├── hanoi(1)
    ├── move disk 2
    └── hanoi(1)
```

Think:

```text
          hanoi(n)
          /      \
     hanoi(n-1)  hanoi(n-1)
          \      /
          BIG DISK
```

**Paper rule:** `n-1 → move biggest → n-1`.


### Complexity

```text
Time  : O(2^n)
Space : O(n)
```

---

# 7. Pattern 6 — Divisor / Prime Traversal

## G70 — Print All Divisors ⭐⭐⭐

### Basic Algorithm

```text
idx = 1
    ↓
check n % idx
    ↓
add if divisor
    ↓
idx + 1
    ↓
stop after n
```

### Optimized Algorithm

```text
check idx only while idx² <= n

if n % idx == 0:
    add idx
    add n / idx
```

### Code Memory

```java
findDiv(n, idx):
    if (idx * idx > n)
        return;

    if (n % idx == 0) {
        add idx;

        if (idx != n / idx)
            add n / idx;
    }

    findDiv(n, idx + 1);
```

### Remember

```text
DIVISORS COME IN PAIRS
idx ↔ n / idx
```


### 🔹 Dry Run / Recursion Flow

Example: `n = 10`

```text
findDiv(10,1)
    ↓ 1 divides 10 → add 1,10
findDiv(10,2)
    ↓ 2 divides 10 → add 2,5
findDiv(10,3)
    ↓ 3 does not divide
findDiv(10,4)
    ↓ 4×4 > 10
BASE CASE
```

Before sorting:

```text
[1,10,2,5]
```

After sorting:

```text
[1,2,5,10]
```

**Paper rule:** check `idx`, then its pair `n/idx`.


---

## G71 — Prime Checking ⭐⭐⭐⭐

### Algorithm

```text
start idx = 2
    ↓
check divisor
    ↓
found → false
    ↓
not found → next idx
    ↓
cross √n → true
```

### Code Memory

```java
prime(n, idx):
    if (idx * idx > n)
        return true;

    if (n % idx == 0)
        return false;

    return prime(n, idx + 1);
```

### Remember

```text
DIVISOR FOUND → FALSE
CROSS √n      → TRUE
```


### 🔹 Dry Run / Recursion Flow

Example: `25`

```text
prime(25,2)
    ↓
25 % 2 != 0
    ↓
prime(25,3)
    ↓
25 % 3 != 0
    ↓
prime(25,4)
    ↓
25 % 4 != 0
    ↓
prime(25,5)
    ↓
25 % 5 == 0
    ↓
return false
```

For a prime number:

```text
keep checking
    ↓
idx² > n
    ↓
return true
```


---

## G72 — Sieve-Style Recursion ⭐⭐⭐

### Algorithm

```text
idx
 ↓
if idx is still prime
 ↓
mark idx², idx²+idx, ...
 ↓
idx + 1
 ↓
stop after √n
```

### Code Memory

```text
solve(idx):
    if idx * idx > n
        stop

    if isPrime[idx]
        mark multiples from idx * idx

    solve(idx + 1)
```

### Remember

```text
SURVIVING PRIME → CROSS OUT MULTIPLES
```


### 🔹 Dry Run / Recursion Flow

Example: `n = 10`

```text
idx = 2
  ↓
mark 4,6,8,10
  ↓
idx = 3
  ↓
mark 9
  ↓
idx = 4
  ↓
4² > 10
  ↓
STOP
```

Remaining `true` values:

```text
2, 3, 5, 7
```

**Paper rule:** `prime candidate → mark multiples → next candidate`.


---

# 8. Pattern 7 — Binary / Representation

## G75 — Binary Representation ⭐⭐⭐⭐

### Algorithm

```text
number
   ↓
divide by 2
   ↓
recurse
   ↓
use remainder n % 2
```

### Code Memory

```text
binary(n):
    if n == 0
        stop

    binary(n / 2)
    output n % 2
```

### Remember

```text
DIVIDE → RETURN → REMAINDER
```


### 🔹 Dry Run / Recursion Flow

Example: `13`

```text
binary(13)
    ↓
binary(6)
    ↓
binary(3)
    ↓
binary(1)
    ↓
binary(0)
    ↓
STOP
```

Remainders:

```text
13 % 2 = 1
 6 % 2 = 0
 3 % 2 = 1
 1 % 2 = 1
```

Print on return:

```text
1 → 1 → 0 → 1
```

Result:

```text
1101
```


> Use the exact G75 Java implementation from your G75 file when revising.

---

## G76 — Decimal from Binary ⭐⭐⭐

### Algorithm

```text
remove last binary bit
    ↓
solve prefix
    ↓
previous × 2 + current bit
```

### Code Memory

```java
binaryToDecimal(bin):
    if (one digit remains)
        return digit;

    prev = binaryToDecimal(prefix);
    bit = last digit;

    return prev * 2 + bit;
```

### Remember

```text
PREFIX → ×2 → + BIT
```

---

# 9. Pattern 8 — Level / Constructive Generation

## G73 — Generate Binary Numbers ⭐⭐⭐⭐

### Algorithm

```text
CURRENT LEVEL
      ↓
each value creates:
      ├── + "0"
      └── + "1"
      ↓
NEXT LEVEL
      ↓
recurse
```

### Code Memory

```text
solve(currentLevel):

    for each current value:
        nextLevel.add(value + "0")
        nextLevel.add(value + "1")

    solve(nextLevel)
```

### Remember

```text
LEVEL → 0/1 CHILDREN → NEXT LEVEL
```


### 🔹 Dry Run / Recursion Tree

Example: first 5 numbers.

```text
                 1
              /     \
            10       11
           /  \      /  \
        100   101  110  111
```

Read level by level:

```text
Level 1 → [1]
Level 2 → [10,11]
Level 3 → [100,101,110,111]
```

Stop as soon as the required count is reached.

**Paper rule:** process current level completely, then recurse into the next level.


---

## G74 — Gray Code ⭐⭐⭐⭐

### Standard Recursive Construction

```text
gray(n)
    ↓
gray(n - 1)
    ↓
keep previous
    +
reverse previous
    ↓
add new leading bit
```

### Code Memory

```text
gray(n):
    if n == 0
        return [0]

    prev = gray(n - 1)

    answer = 0 + prev
    answer += 1 + reverse(prev)

    return answer
```

### Remember

```text
PREVIOUS → KEEP + REVERSE → NEW BIT
```


### 🔹 Dry Run / Recursion Tree

Using the standard recursive construction:

```text
gray(3)
  ↓
gray(2)
  ↓
gray(1)
  ↓
gray(0)
  ↓
[0]
  ↑
[0,1]
  ↑
[0,1,3,2]
  ↑
[0,1,3,2,6,7,5,4]
```

At each return:

```text
previous
   ↓
keep previous
   +
reverse previous + new leading bit
```

**Paper rule:** smaller answer first; larger answer is built while returning.


> Your current practice code uses backtracking and bit flipping. Keep that file for recursion/backtracking practice; use the above construction as the compact Gray Code revision algorithm.

---

# 10. Pattern 9 — Current Contribution

## G77 — Sum of Squares ⭐⭐⭐

### Algorithm

```text
sum(n)
=
sum(n-1) + n²
```

### Code Memory

```java
sum(n):
    if (n == 0)
        return 0;

    return sum(n - 1) + n * n;
```

### Remember

```text
SMALLER ANSWER + CURRENT n²
```


### 🔹 Dry Run / Recursion Chain

Example: `sum(3)`

```text
sum(3)
 ↓
sum(2)
 ↓
sum(1)
 ↓
sum(0)
 ↓
 0
 ↑
0 + 1² = 1
 ↑
1 + 2² = 5
 ↑
5 + 3² = 14
```

**Paper rule:** base first, contribution on return.


---

## G78 — Sum of Cubes ⭐⭐⭐

### Algorithm

```text
sum(n)
=
sum(n-1) + n³
```

### Code Memory

```java
sum(n):
    if (n == 0)
        return 0;

    return sum(n - 1) + n * n * n;
```

### Remember

```text
SMALLER ANSWER + CURRENT n³
```


### 🔹 Dry Run / Recursion Chain

Example: `sum(2)`

```text
sum(2)
 ↓
sum(1)
 ↓
sum(0)
 ↓
 0
 ↑
0 + 1³ = 1
 ↑
1 + 2³ = 9
```

**Paper rule:** `smaller answer + current cube`.


---

# 11. Pattern 10 — Step-2 / Alternating Recursion

## G79 — Alternating Sum ⭐⭐⭐

### Algorithm

```text
n - (n-1 - (n-2 - ...))
```

### Code Memory

```java
alternatingSum(n):
    if (n <= 0)
        return 0;

    return n - alternatingSum(n - 1);
```

### Remember

```text
CURRENT − REST
```


### 🔹 Dry Run / Recursion Chain

Example: `alternatingSum(4)`

```text
4 - alternatingSum(3)
          ↓
      3 - alternatingSum(2)
                ↓
            2 - alternatingSum(1)
                      ↓
                  1 - alternatingSum(0)
                            ↓
                            0
```

Return:

```text
1
↑
2 - 1 = 1
↑
3 - 1 = 2
↑
4 - 2 = 2
```

**Paper rule:** the recursive subtraction automatically creates the alternating effect.


---

## G80 — Alternating Product ⭐⭐⭐

### Algorithm

```text
n × (n-2) × (n-4) × ...
```

### Code Memory

```java
alternatingProduct(n):
    if (n <= 0)
        return 1;

    return n * alternatingProduct(n - 2);
```

### Remember

```text
CURRENT × SAME-PARITY REST
```


### 🔹 Dry Run / Recursion Chain

Example: `alternatingProduct(5)`

```text
product(5)
   ↓
product(3)
   ↓
product(1)
   ↓
product(-1)
   ↓
BASE → 1
   ↑
1 × 1 = 1
   ↑
3 × 1 = 3
   ↑
5 × 3 = 15
```

**Paper rule:** decrease by `2`, so only the same parity is visited.


---

# 12. Final Pattern Map

```text
LINEAR REDUCTION
    ├── G63 Division
    └── G69 GCD

DIVIDE BY 2
    ├── G61 Fast Power
    └── G62 Multiplication

ONE-BRANCH RECURRENCE
    ├── G65 nPr
    └── G68 Josephus

TWO-BRANCH RECURRENCE
    ├── G64 nCr
    └── G66 Pascal

MULTIPLE RECURSIVE CALLS
    └── G67 Tower of Hanoi

DIVISOR TRAVERSAL
    ├── G70 Divisors
    ├── G71 Prime
    └── G72 Sieve

BINARY / REPRESENTATION
    ├── G75 Binary
    └── G76 Decimal from Binary

CONSTRUCTIVE / LEVEL RECURSION
    ├── G73 Binary Numbers
    └── G74 Gray Code

CURRENT CONTRIBUTION
    ├── G77 Squares
    └── G78 Cubes

STEP-2 / ALTERNATING
    ├── G79 Alternating Sum
    └── G80 Alternating Product
```

---

# 13. Revision Priority

## ⭐⭐⭐⭐⭐ Master

```text
G61  Fast Exponentiation
G62  Multiplication
G64  nCr
G65  nPr
G67  Tower of Hanoi
G68  Josephus
G69  GCD
```

## ⭐⭐⭐⭐ Understand Well

```text
G66  Pascal
G71  Prime
G73  Binary Generation
G74  Gray Code
G75  Binary Representation
```

## ⭐⭐⭐ Practice / Quick Revision

```text
G63  Division
G70  Divisors
G72  Sieve
G76  Decimal from Binary
G77  Squares
G78  Cubes
G79  Alternating Sum
G80  Alternating Product
```

---

# 14. What To Memorize

Do NOT memorize 20 full programs.

Memorize these algorithms:

```text
G61 → HALVE + SQUARE
G62 → HALVE + DOUBLE
G63 → REDUCE + COUNT
G64 → CHOOSE + DON'T CHOOSE
G65 → ONE CHOICE + MULTIPLY
G66 → TOP-LEFT + TOP
G67 → n-1 + BIG + n-1
G68 → SOLVE SMALLER + MAP BACK
G69 → (a,b) → (b,a%b)
G70 → DIVISOR PAIRS
G71 → CHECK TO √n
G72 → CROSS OUT MULTIPLES
G73 → 0/1 CHILDREN BY LEVEL
G74 → KEEP + REVERSE
G75 → DIVIDE BY 2 + REMAINDER
G76 → ×2 + BIT
G77 → + n²
G78 → + n³
G79 → n − REST
G80 → n × (n−2)
```

---

# 15. Definition of Done

You are done with G when you can see a new mathematical recursion problem and identify:

```text
What is getting smaller?
        ↓
What is the base case?
        ↓
One branch or two?
        ↓
Divide by 2 or reduce by 1/2?
        ↓
What happens to the answer on return?
```

Then write the recurrence before writing Java code.
