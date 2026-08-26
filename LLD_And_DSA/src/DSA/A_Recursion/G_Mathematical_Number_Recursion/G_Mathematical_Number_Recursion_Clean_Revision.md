# G --- Mathematical / Number Recursion

> **Goal:** Understand the recursion pattern first.\
> For revision, ask: **What gets smaller? → What is the base case? →
> What happens on return?**

------------------------------------------------------------------------

# 1. Pattern Map

  Pattern                               Problems        Priority
  ------------------------------------- --------------- ------------
  1\. Linear Reduction                  G63, G69        ⭐⭐⭐⭐
  2\. Divide by 2                       G61, G62        ⭐⭐⭐⭐⭐
  3\. One Recursive Branch              G65, G68        ⭐⭐⭐⭐⭐
  4\. Two Recursive Branches            G64, G66        ⭐⭐⭐⭐⭐
  5\. Multiple Recursive Calls          G67             ⭐⭐⭐⭐⭐
  6\. Divisor / Prime Traversal         G70, G71, G72   ⭐⭐⭐
  7\. Binary / Representation           G75, G76        ⭐⭐⭐⭐
  8\. Level / Constructive Generation   G73, G74        ⭐⭐⭐⭐
  9\. Current Contribution              G77, G78        ⭐⭐⭐
  10\. Step-2 / Alternating             G79, G80        ⭐⭐⭐

------------------------------------------------------------------------

# 2. The One Rule for Every Recursion Problem

Before writing Java, write these 3 things:

``` text
1. What becomes smaller?
2. When do I STOP?
3. What happens when the call RETURNS?
```

### Recursion has two parts

``` text
GO DOWN
↓
make the problem smaller
↓
BASE CASE
↓
COME BACK UP
↓
build the answer
```

------------------------------------------------------------------------

# 3. Pattern 1 --- Linear Reduction

## G63 --- Division Recursively ⭐⭐⭐⭐

### Main idea

Keep reducing the number until the divisor no longer fits.

``` text
divide(13, 3)
    ↓
divide(10, 3)
    ↓
divide(7, 3)
    ↓
divide(4, 3)
    ↓
divide(1, 3)
    ↓
STOP
```

### Remember

``` text
REDUCE → RECURSE → COUNT
```

### Paper rule

``` text
13 → 10 → 7 → 4 → 1 → STOP
```

------------------------------------------------------------------------

## G69 --- Euclidean GCD ⭐⭐⭐⭐

### Main idea

The only rule you need:

``` text
gcd(a, b)
    ↓
gcd(b, a % b)
```

### The easiest way to do it on paper

Use a **pair**.

``` text
(a, b)
  ↓
(b, a % b)
```

Example:

``` text
gcd(24, 10)
```

First:

``` text
24 % 10 = 4

(24,10)
   ↓
(10,4)
```

Next:

``` text
10 % 4 = 2

(10,4)
   ↓
(4,2)
```

Next:

``` text
4 % 2 = 0

(4,2)
   ↓
(2,0)
```

Now `b = 0`, so STOP.

``` text
answer = 2
```

### Full paper format

``` text
gcd(24,10)
    ↓
gcd(10,24%10)
    ↓
gcd(10,4)
    ↓
gcd(4,10%4)
    ↓
gcd(4,2)
    ↓
gcd(2,4%2)
    ↓
gcd(2,0)
    ↓
BASE CASE
    ↓
return 2
    ↑
return 2
    ↑
return 2
```

### Remember

``` text
OLD b → NEW a
a % b → NEW b
```

So:

``` text
(a,b) → (b,a%b)
```

### Code memory

``` java
gcd(a, b):
    if (b == 0)
        return a;

    return gcd(b, a % b);
```

### Complexity

``` text
Time  : O(log min(a,b))
Space : O(log min(a,b))
```

------------------------------------------------------------------------

# 4. Pattern 2 --- Divide by 2

## G61 --- Fast Exponentiation ⭐⭐⭐⭐⭐

### Main idea

Cut `n` in half.

``` text
power(x,n)
    ↓
power(x,n/2)
```

Then rebuild the answer.

### Remember

``` text
HALVE → RECURSE → SQUARE → ODD? × x
```

### Example

``` text
power(2,5)
    ↓
power(2,2)
    ↓
power(2,1)
    ↓
power(2,0)
    ↓
1
```

Return upward:

``` text
1
↑
2 × 1 × 1 = 2
↑
2 × 2 = 4
↑
2 × 4 × 4 = 32
```

### Code memory

``` java
power(x, n):
    if (n == 0)
        return 1;

    half = power(x, n / 2);

    if (n % 2 == 0)
        return half * half;

    return x * half * half;
```

------------------------------------------------------------------------

## G62 --- Multiply Two Numbers Recursively ⭐⭐⭐⭐⭐

### Main idea

Halve `b`, solve the smaller problem, then rebuild.

``` text
multiply(a,b)
    ↓
multiply(a,b/2)
```

### Remember

``` text
HALVE b → DOUBLE → ODD? +a
```

### Example

``` text
multiply(5,5)
    ↓
multiply(5,2)
    ↓
multiply(5,1)
    ↓
multiply(5,0)
    ↓
0
```

Return:

``` text
0
↑
0 + 5 = 5
↑
5 + 5 = 10
↑
10 + 10 + 5 = 25
```

------------------------------------------------------------------------

# 5. Pattern 3 --- One Recursive Branch

## G65 --- nPr ⭐⭐⭐⭐⭐

### Main idea

There is **one recursive call**.

``` text
nPr(n,r)
    ↓
n × nPr(n-1,r-1)
```

### Remember

``` text
ONE BRANCH → MULTIPLY
```

### Example

``` text
5P2
 ↓
5 × 4P1
       ↓
     4 × 3P0
             ↓
             1
```

Return:

``` text
4 × 1 = 4
5 × 4 = 20
```

Answer:

``` text
5P2 = 20
```

### Base cases

``` text
r == 0 → return 1
n < r  → return 0
```

------------------------------------------------------------------------

## G68 --- Josephus ⭐⭐⭐⭐⭐

### Main idea

First solve the smaller problem.

``` text
n
↓
n-1
↓
n-2
↓
...
↓
BASE CASE
```

Then map the smaller answer back.

### Remember

``` text
SOLVE SMALLER → MAP BACK
```

### Important

Be careful about:

``` text
0-based indexing
vs
1-based indexing
```

------------------------------------------------------------------------

# 6. Pattern 4 --- Two Recursive Branches

## G64 --- nCr ⭐⭐⭐⭐⭐

### Main idea

Every call splits into **two choices**:

``` text
              nCr
             /   \
         CHOOSE  DON'T CHOOSE
            ↓         ↓
       (n-1)C(r-1)  (n-1)Cr
```

### Formula

``` text
nCr = (n-1)C(r-1) + (n-1)Cr
```

### Remember

``` text
CHOOSE + DON'T CHOOSE
```

### Example

``` text
5C2
├── 4C1
└── 4C2
```

Each branch continues until a base case.

### Base cases

``` text
r == 0 → 1
n == r → 1
n < r  → 0
```

------------------------------------------------------------------------

## G66 --- Pascal Triangle ⭐⭐⭐⭐

### Main idea

Same recursion shape as nCr.

``` text
pascal(row,col)
    ↓
pascal(row-1,col-1)
+
pascal(row-1,col)
```

### Remember

``` text
TOP-LEFT + TOP
```

### Connection

``` text
G64 nCr
   ↓
same recurrence
   ↓
G66 Pascal
```

------------------------------------------------------------------------

# 7. Pattern 5 --- Multiple Recursive Calls

## G67 --- Tower of Hanoi ⭐⭐⭐⭐⭐

### Main idea

For `n` disks:

``` text
move n-1
    ↓
move BIG disk
    ↓
move n-1
```

### Remember

``` text
n-1 → BIG DISK → n-1
```

### Example: n = 3

``` text
hanoi(3)
├── hanoi(2)
│   ├── hanoi(1)
│   ├── BIG DISK
│   └── hanoi(1)
├── BIG DISK
└── hanoi(2)
    ├── hanoi(1)
    ├── BIG DISK
    └── hanoi(1)
```

### Key idea

There are **two recursive calls** with work between them.

------------------------------------------------------------------------

# 8. Pattern 6 --- Divisor / Prime Traversal

## G70 --- Print All Divisors ⭐⭐⭐

### Main idea

Check one possible divisor at a time.

Optimized version:

``` text
idx² <= n
```

If `idx` divides `n`, divisors come in pairs:

``` text
idx ↔ n / idx
```

### Remember

``` text
DIVISOR PAIRS
```

### Example: n = 10

``` text
idx = 1 → add 1,10
idx = 2 → add 2,5
idx = 3 → no
idx = 4 → 4² > 10 → STOP
```

Before sorting:

``` text
[1,10,2,5]
```

After sorting:

``` text
[1,2,5,10]
```

------------------------------------------------------------------------

## G71 --- Prime Checking ⭐⭐⭐⭐

### Main idea

Only check possible divisors up to `√n`.

``` text
check divisor
    ↓
found → FALSE
    ↓
not found → next
    ↓
cross √n → TRUE
```

### Remember

``` text
DIVISOR FOUND → FALSE
CROSS √n      → TRUE
```

### Example: 25

``` text
25 % 2 ≠ 0
25 % 3 ≠ 0
25 % 4 ≠ 0
25 % 5 = 0
      ↓
    FALSE
```

------------------------------------------------------------------------

## G72 --- Sieve-Style Recursion ⭐⭐⭐

### Main idea

For each surviving prime, cross out its multiples.

``` text
2 → mark 4,6,8,10
3 → mark 9
4² > 10 → STOP
```

### Remember

``` text
PRIME → CROSS OUT MULTIPLES → NEXT
```

------------------------------------------------------------------------

# 9. Pattern 7 --- Binary / Representation

## G75 --- Binary Representation ⭐⭐⭐⭐

> Keep the exact implementation from the existing G75 file when
> available.

### Main idea

Divide by 2 while going down. Use `% 2` while returning.

``` text
binary(n)
    ↓
binary(n/2)
    ↓
return
    ↓
use n % 2
```

### Remember

``` text
DIVIDE BY 2 → RETURN → REMAINDER
```

### Example: 13

``` text
13 → 6 → 3 → 1 → 0
```

Remainders:

``` text
13 % 2 = 1
 6 % 2 = 0
 3 % 2 = 1
 1 % 2 = 1
```

Print on return:

``` text
1101
```

------------------------------------------------------------------------

## G76 --- Decimal from Binary ⭐⭐⭐

### Main idea

Remove the last bit, solve the prefix, then rebuild.

``` text
prefix answer
    ↓
× 2
    ↓
+ current bit
```

### Remember

``` text
PREFIX → ×2 → + BIT
```

------------------------------------------------------------------------

# 10. Pattern 8 --- Level / Constructive Generation

## G73 --- Generate Binary Numbers ⭐⭐⭐⭐

### Main idea

Each current value creates two children:

``` text
current
├── + "0"
└── + "1"
```

Then move to the next level.

### Remember

``` text
LEVEL → 0/1 CHILDREN → NEXT LEVEL
```

### Example

``` text
        1
      /   \
    10     11
   /  \   /  \
100 101 110 111
```

Read level by level:

``` text
[1]
[10,11]
[100,101,110,111]
```

------------------------------------------------------------------------

## G74 --- Gray Code ⭐⭐⭐⭐

### Main idea

Get the smaller Gray code first.

Then:

``` text
KEEP previous
+
REVERSE previous
+
add new leading bit
```

### Remember

``` text
PREVIOUS → KEEP + REVERSE → NEW BIT
```

### Example

``` text
gray(0)
→ [0]

gray(1)
→ [0,1]

gray(2)
→ [0,1,3,2]

gray(3)
→ [0,1,3,2,6,7,5,4]
```

> Your backtracking/bit-flipping implementation is still useful for
> recursion practice. This is the compact construction to remember.

------------------------------------------------------------------------

# 11. Pattern 9 --- Current Contribution

## G77 --- Sum of Squares ⭐⭐⭐

### Main idea

``` text
sum(n) = sum(n-1) + n²
```

### Remember

``` text
SMALLER ANSWER + CURRENT n²
```

### Example

``` text
sum(3)
 ↓
sum(2)
 ↓
sum(1)
 ↓
sum(0)
 ↓
0
```

Return:

``` text
0 + 1² = 1
1 + 2² = 5
5 + 3² = 14
```

------------------------------------------------------------------------

## G78 --- Sum of Cubes ⭐⭐⭐

### Main idea

``` text
sum(n) = sum(n-1) + n³
```

### Remember

``` text
SMALLER ANSWER + CURRENT n³
```

### Example

``` text
sum(2)
 ↓
sum(1)
 ↓
sum(0)
 ↓
0
```

Return:

``` text
0 + 1³ = 1
1 + 2³ = 9
```

------------------------------------------------------------------------

# 12. Pattern 10 --- Step-2 / Alternating

## G79 --- Alternating Sum ⭐⭐⭐

### Main idea

``` text
n - alternatingSum(n-1)
```

### Remember

``` text
CURRENT − REST
```

### Example

``` text
4 - f(3)
    ↓
3 - f(2)
    ↓
2 - f(1)
    ↓
1 - f(0)
    ↓
0
```

Return:

``` text
1 - 0 = 1
2 - 1 = 1
3 - 1 = 2
4 - 2 = 2
```

Answer:

``` text
2
```

------------------------------------------------------------------------

## G80 --- Alternating Product ⭐⭐⭐

### Main idea

Decrease by `2`.

``` text
n → n-2 → n-4 → ...
```

### Remember

``` text
CURRENT × SAME-PARITY REST
```

### Example

``` text
5
↓
3
↓
1
↓
-1
↓
BASE → 1
```

Return:

``` text
1 × 1 = 1
3 × 1 = 3
5 × 3 = 15
```

Answer:

``` text
15
```

------------------------------------------------------------------------

# 13. Final Cheat Sheet

``` text
G61 → HALVE → SQUARE → ODD? × x
G62 → HALVE b → DOUBLE → ODD? + a

G63 → REDUCE → RECURSE → COUNT
G64 → CHOOSE + DON'T CHOOSE
G65 → ONE BRANCH → MULTIPLY
G66 → TOP-LEFT + TOP
G67 → n-1 → BIG DISK → n-1
G68 → SOLVE SMALLER → MAP BACK
G69 → (a,b) → (b,a%b)

G70 → DIVISOR PAIRS
G71 → CHECK TO √n
G72 → PRIME → CROSS OUT MULTIPLES

G73 → 0/1 CHILDREN BY LEVEL
G74 → KEEP + REVERSE
G75 → DIVIDE BY 2 → RETURN → REMAINDER
G76 → PREFIX × 2 + BIT

G77 → SMALLER + n²
G78 → SMALLER + n³
G79 → n − REST
G80 → n × (n−2)
```

------------------------------------------------------------------------

# 14. What To Do on Paper

When you get a new recursion question, **do not start with Java**.

Write:

``` text
1. What becomes smaller?
        ↓
2. What is the base case?
        ↓
3. How many recursive calls?
        ↓
4. What happens while going DOWN?
        ↓
5. What happens while coming UP?
```

### Example: G69

``` text
What gets smaller?
→ remainder

Base case?
→ b == 0

How many calls?
→ ONE

Going down?
→ (a,b) → (b,a%b)

Coming up?
→ return the same answer
```

### Most important revision rule

``` text
DON'T MEMORIZE THE WHOLE PROGRAM.

MEMORIZE THE SHAPE.
```

Once you know the shape, write the recurrence first, then write Java.
