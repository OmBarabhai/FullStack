# 🔒 PART 2.1 — Problems 061–085

| Section                                 |       Range | Focus  |
| --------------------------------------- | ----------: | ------ |
| **G — Mathematical / Number Recursion** | **061–080** | 20     |
| **H — Take / Not-Take Foundation**      | **081–085** | 5      |
| **TOTAL**                               | **061–085** | **25** |

The actual source lists 61–80 as fast exponentiation, recursive multiplication/division, nCr/nPr, Pascal row, Tower of Hanoi, Josephus, Euclidean algorithm, divisors, prime checking, binary/Gray-code representations, and recursive sums/products.

And 81–85 begin the Take/Not-Take family with subsequences and sum-K problems.

---

# 📖 PART 2.1 — MATHEMATICAL / NUMBER RECURSION

### Problems 061–080

|   # | Problem                                        | Platform            | Difficulty | OA Value | Status | R1 | R2 | R3 | R4 | R5 |
|----:|------------------------------------------------|---------------------|:----------:|:--------:|:------:|:--:|:--:|:--:|:--:|:--:|
| 061 | Fast Exponentiation                            | LeetCode 50 / GFG   |     🟡     |  ⭐⭐⭐⭐⭐   |   ☑️   | ☑️  | ⬜  | ⬜  | ⬜  | ⬜  |
| 062 | Multiply Two Numbers Recursively               | GFG                 |     🟢     |   ⭐⭐⭐⭐   |   ☑️   | ☑️  | ⬜  | ⬜  | ⬜  | ⬜  |
| 063 | Divide Two Numbers Recursively                 | GFG                 |     🟡     |   ⭐⭐⭐⭐   |  ️ ☑️  | ☑️  | ⬜  | ⬜  | ⬜  | ⬜  |
| 064 | Calculate nCr Recursively                      | GFG                 |     🟡     |  ⭐⭐⭐⭐⭐   |   ☑️   | ☑️  | ⬜  | ⬜  | ⬜  | ⬜  |
| 065 | Calculate nPr Recursively                      | GFG                 |     🟡     |   ⭐⭐⭐⭐   |   ☑️   | ☑️  | ⬜  | ⬜  | ⬜  | ⬜  |
| 066 | Pascal Triangle Row Recursively                | LeetCode 119 style  |     🟡     |   ⭐⭐⭐⭐   |   ☑️    | ☑️  | ⬜  | ⬜  | ⬜  | ⬜  |
| 067 | Tower of Hanoi                                 | GFG                 |     🔴     |  ⭐⭐⭐⭐⭐   |   ☑️    | ☑️  | ⬜  | ⬜  | ⬜  | ⬜  |
| 068 | Josephus Problem                               | GFG / LeetCode 1823 |     🟡     |  ⭐⭐⭐⭐⭐   |   ☑️    | ☑️  | ⬜  | ⬜  | ⬜  | ⬜  |
| 069 | Recursive Euclidean Algorithm                  | GFG                 |     🟢     |   ⭐⭐⭐⭐   |   ☑️    | ☑️  | ⬜  | ⬜  | ⬜  | ⬜  |
| 070 | Print All Divisors Recursively                 | GFG                 |     🟢     |   ⭐⭐⭐    |   ☑️    | ☑️  | ⬜  | ⬜  | ⬜  | ⬜  |
| 071 | Prime Checking Recursively                     | GFG                 |     🟢     |   ⭐⭐⭐⭐   |   ☑️    | ⬜  | ⬜  | ⬜  | ⬜  | ⬜  |
| 072 | Sieve-Style Recursion Practice                 | Interview           |     🟡     |   ⭐⭐⭐    |   ⬜    | ⬜  | ⬜  | ⬜  | ⬜  | ⬜  |
| 073 | Generate Binary Numbers Recursively            | GFG                 |     🟢     |   ⭐⭐⭐⭐   |   ⬜    | ⬜  | ⬜  | ⬜  | ⬜  | ⬜  |
| 074 | Generate Gray Code Recursively                 | LeetCode 89         |     🟡     |   ⭐⭐⭐⭐   |   ⬜    | ⬜  | ⬜  | ⬜  | ⬜  | ⬜  |
| 075 | Binary Representation Recursively              | GFG                 |     🟢     |   ⭐⭐⭐⭐   |   ⬜    | ⬜  | ⬜  | ⬜  | ⬜  | ⬜  |
| 076 | Decimal Representation from Binary Recursively | GFG                 |     🟢     |   ⭐⭐⭐    |   ⬜    | ⬜  | ⬜  | ⬜  | ⬜  | ⬜  |
| 077 | Sum of Squares Recursively                     | GFG                 |     🟢     |   ⭐⭐⭐    |   ⬜    | ⬜  | ⬜  | ⬜  | ⬜  | ⬜  |
| 078 | Sum of Cubes Recursively                       | GFG                 |     🟢     |   ⭐⭐⭐    |   ⬜    | ⬜  | ⬜  | ⬜  | ⬜  | ⬜  |
| 079 | Alternating Sum Recursively                    | GFG                 |     🟢     |   ⭐⭐⭐    |   ⬜    | ⬜  | ⬜  | ⬜  | ⬜  | ⬜  |
| 080 | Alternating Product Recursively                | Interview           |     🟡     |   ⭐⭐⭐    |   ⬜    | ⬜  | ⬜  | ⬜  | ⬜  | ⬜  |

These are the exact 61–80 problem identities from the master source.

---

# 🧠 G — Pattern Recognition

When you see:

```text
power
multiply
divide
nCr
nPr
Pascal
Hanoi
Josephus
GCD
divisors
prime
binary
Gray code
mathematical recurrence
```

think:

> **Mathematical / Number Recursion**

---

# ⭐ Critical Problems

If your goal is OA mastery, pay special attention to:

```text
061 Fast Exponentiation
064 nCr
065 nPr
067 Tower of Hanoi
068 Josephus
069 Euclidean Algorithm
074 Gray Code
```

These aren't just seven random problems. They expose different recursive structures.

---

# 🧠 Then H Begins

## Problems 081–085

|       # | Problem                            | Platform | Pattern       | Status |
| ------: | ---------------------------------- | -------- | ------------- | :----: |
| **081** | Print All Subsequences of an Array | GFG      | Take/Not-Take |    ⬜   |
| **082** | Count Subsequences                 | GFG      | Take/Not-Take |    ⬜   |
| **083** | Print Subsequence With Sum K       | GFG      | Take/Not-Take |    ⬜   |
| **084** | Count Subsequences With Sum K      | GFG      | Take/Not-Take |    ⬜   |
| **085** | Print One Subsequence With Sum K   | GFG      | Take/Not-Take |    ⬜   |

The master file confirms this exact sequence.

---

# 🔥 The Real Transition

```text
PART 1
001–060
Basic Recursion
      ↓
PART 2.1
061–080
Mathematical Recursion
      ↓
081–085
Take / Not-Take
      ↓
PART 2.2
086–110
Take / Not-Take
+
Permutation / Combination
      ↓
PART 2.3
111–135
Advanced Choice
+
Parentheses / Expressions / Partition
      ↓
PART 2.4
136–160
Expression Completion
+
Grid / Maze / Chessboard
      ↓
PART 2.5
161–180
Constraint / Advanced Backtracking
      ↓
PART 2.6
181–200
Advanced OA / Final Mastery
```

# 📖 Part 2.2 — Take / Not-Take → Permutation / Combination

I rechecked the master file before creating this. The source puts **81–100 under Take / Not-Take recursion** and **101–120 under Permutations / Combinations / Basic Backtracking**.

Because **Part 2.1 is locked at 061–085**, Part 2.2 takes the next **25 problems: 086–110**.

---

# 🔒 PART 2.2 MASTER TRACKER

| Pattern                           |       Range | Problems | Status |
| --------------------------------- | ----------: | -------: | :----: |
| **H — Take / Not-Take**           | **086–095** |       10 |    ⬜   |
| **I — Choice / Generation**       | **096–100** |        5 |    ⬜   |
| **J — Permutation / Combination** | **101–110** |       10 |    ⬜   |
| **TOTAL**                         | **086–110** |   **25** |    ⬜   |

### Revision

| Round | When     |
| ----- | -------- |
| R0    | Same day |
| R1    | Day 1    |
| R2    | Day 3    |
| R3    | Day 7    |
| R4    | Day 15   |
| R5    | Day 30   |

---

# 🟦 PATTERN H — TAKE / NOT-TAKE

You already saw the first five problems in Part 2.1:

```text
081 Print all subsequences
082 Count subsequences
083 Subsequence sum K
084 Count subsequences sum K
085 Print one subsequence sum K
```

Now we continue from **086**.

## 🧠 Core Mental Model

For every element:

```text
                 element
                /       \
             TAKE       NOT TAKE
               ↓           ↓
             recurse     recurse
```

This is the foundation for:

```text
Subsequence
Subset
Subset Sum
Partition
Choice Problems
Backtracking
```

---

# 📊 Problems 086–095

|       # | Problem                                  | Platform             | Difficulty | OA Value | Status |  R1 |  R2 |  R3 |  R4 |  R5 |   |
| ------: | ---------------------------------------- | -------------------- | :--------: | :------: | :----: | :-: | :-: | :-: | :-: | :-: | - |
| **086** | Check if a Subsequence With Sum K Exists | GFG                  |     🟡     |   ⭐⭐⭐⭐⭐  |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |   |
| **087** | Print All Subsets                        | LeetCode 78          |     🟡     |   ⭐⭐⭐⭐⭐  |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  | ⬜ |
| **088** | Count Subsets                            | GFG                  |     🟡     |   ⭐⭐⭐⭐⭐  |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  | ⬜ |
| **089** | Subset Sum                               | GFG / LC 416 variant |     🟡     |   ⭐⭐⭐⭐⭐  |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  | ⬜ |
| **090** | Partition Into Two Equal Subsets         | LeetCode 416         |     🟡     |   ⭐⭐⭐⭐⭐  |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  | ⬜ |
| **091** | Partition With Minimum Difference        | GFG                  |     🟡     |   ⭐⭐⭐⭐⭐  |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  | ⬜ |
| **092** | Generate All Binary Strings of Length N  | GFG                  |     🟢     |   ⭐⭐⭐⭐⭐  |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  | ⬜ |
| **093** | Binary Strings Without Consecutive 1s    | Interview            |     🟡     |   ⭐⭐⭐⭐⭐  |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  | ⬜ |
| **094** | Binary Strings Without Consecutive 0s    | Interview            |     🟡     |   ⭐⭐⭐⭐   |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  | ⬜ |
| **095** | Binary Strings With Exactly K Ones       | Interview            |     🟡     |   ⭐⭐⭐⭐⭐  |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  | ⬜ |

These are exactly the source's 86–95 problems.

---

# 🧠 H — Three Types of Answers

### Boolean

```java
return include || exclude;
```

### Count

```java
return include + exclude;
```

### Print

```java
include branch
exclude branch
```

This distinction is **extremely important**.

---

# ⭐ 086 — Check Subsequence Sum K

Mental model:

```text
Current element
      ↓
     TAKE
      OR
     SKIP
```

Base case:

```java
if (idx == arr.length) {
    return sum == k;
}
```

---

# ⭐ 087 — Print All Subsets

For:

```text
[1,2]
```

output:

```text
[]
[1]
[2]
[1,2]
```

The empty subset is important.

---

# ⭐ 089 — Subset Sum

Think:

```text
idx
sum
```

or:

```text
idx
remaining
```

The key is not memorizing code.

Understand:

```text
remaining target
        ↓
TAKE
OR
SKIP
```

---

# ⭐ 090 — Equal Partition

First:

```text
total = sum(arr)
```

If:

```text
total % 2 != 0
```

then impossible.

Otherwise:

```text
target = total / 2
```

and the problem becomes:

> Can I find a subset with sum `target`?

That is the connection between problems 089 and 090.

---

# ⭐ 091 — Minimum Difference

Now instead of:

```text
Does target exist?
```

we ask:

```text
Which subset sum gives
the smallest difference?
```

This is an important bridge toward **optimization recursion → DP**.

---

# ⭐ 092–095 — Binary Choice

At every position:

```text
0
OR
1
```

So:

```text
                position
                /      \
               0        1
              /          \
           recurse      recurse
```

Then constraints are introduced.

For example:

```text
093
No consecutive 1s
```

Now the choice depends on previous state.

---

# 🟨 PATTERN I — CHOICE GENERATION

### Problems 096–100

The source continues the Take/Not-Take family with increasingly general choice-generation problems.

|       # | Problem                                     | Platform  | Difficulty | OA Value | Status |  R1 |  R2 |  R3 |  R4 |  R5 |   |   |
| ------: | ------------------------------------------- | --------- | :--------: | :------: | :----: | :-: | :-: | :-: | :-: | :-: | - | - |
| **096** | All Strings From Character Set `{a,b}`      | Interview |     🟢     |   ⭐⭐⭐⭐   |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  | ⬜ |   |
| **097** | All Strings From Digits `0–2`               | Interview |     🟢     |   ⭐⭐⭐⭐   |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  | ⬜ | ⬜ |
| **098** | Print All Choices From an Array Recursively | Interview |     🟢     |   ⭐⭐⭐⭐   |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  | ⬜ | ⬜ |
| **099** | Count Ways to Choose K Items                | GFG       |     🟡     |   ⭐⭐⭐⭐⭐  |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  | ⬜ |   |
| **100** | Include/Exclude Subset Framework Practice   | Interview |     🟡     |   ⭐⭐⭐⭐⭐  |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  | ⬜ | ⬜ |

---

# 🧠 I — What Changes Here?

Earlier:

```text
TAKE
SKIP
```

Now:

```text
choice 1
choice 2
choice 3
...
```

Example:

```text
{a,b}
```

For length 3:

```text
aaa
aab
aba
abb
baa
bab
bba
bbb
```

This is the bridge toward **permutations and combinations**.

---

# 🔥 099 — Choose K Items

This introduces:

```text
n choose k
```

and prepares you for:

```text
Combinations
```

The important difference:

```text
Permutation:
order matters

Combination:
order doesn't matter
```

---

# 🟥 PATTERN J — PERMUTATION / COMBINATION

Now we enter **true backtracking**.

The master source starts this family at 101.

---

# Problems 101–110

| # | Problem | Platform | Difficulty | OA Value | Status | R1 | R2 | R3 | R4 | R5 |
|---:|---|---|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|---|
| **101** | Generate Permutations | LeetCode 46 | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | ⬜ | ⬜ |
| **102** | Generate Unique Permutations | LeetCode 47 | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | ⬜ | ⬜ | ⬜ |
| **103** | Permutations of a String | GFG | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | ⬜ | ⬜ | ⬜ | ⬜ |
| **104** | Unique Permutations of a String | GFG | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | ⬜ | ⬜ | ⬜ | ⬜ |
| **105** | Generate Combinations | LeetCode 77 | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | ⬜ | ⬜ | ⬜ | ⬜ |
| **106** | Combinations of Size K | LeetCode 77 | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | ⬜ | ⬜ | ⬜ | ⬜ |
| **107** | Combination Sum | LeetCode 39 | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | ⬜ | ⬜ | ⬜ | ⬜ |
| **108** | Combination Sum II | LeetCode 40 | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | ⬜ | ⬜ | ⬜ | ⬜ |
| **109** | Combination Sum III | LeetCode 216 | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | ⬜ | ⬜ | ⬜ | ⬜ |
| **110** | Generate Subsets With Duplicates | LeetCode 90 | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | ⬜ | ⬜ | ⬜ | ⬜ |

These are exactly the source's 101–110 problems.

---

# 🧠 J — Permutation

For:

```text
[1,2,3]
```

we generate:

```text
123
132
213
231
312
321
```

### Core question:

> Which unused element should I put here?

---

# 🧠 Permutation Template

```java
for (int i = 0; i < arr.length; i++) {

    if (!used[i]) {

        used[i] = true;

        path.add(arr[i]);

        solve(arr, used, path);

        path.remove(path.size() - 1);

        used[i] = false;
    }
}
```

The key sequence:

```text
CHOOSE
 ↓
RECURSE
 ↓
UNDO
```

---

# 🧠 Combination

For:

```text
[1,2,3]
```

choose 2:

```text
12
13
23
```

Not:

```text
21
31
32
```

because order doesn't matter.

So combination uses:

```java
solve(arr, i + 1, path);
```

rather than revisiting previous elements.

---

# 🔥 Combination Sum Differences

These four must be crystal clear:

| Problem    | Reuse? | Duplicates?         | Main Constraint         |
| ---------- | ------ | ------------------- | ----------------------- |
| **LC 39**  | ✅ Yes  | candidates unique   | Target                  |
| **LC 40**  | ❌ No   | input may duplicate | Target + duplicate skip |
| **LC 216** | ❌ No   | No                  | Exactly K + target      |
| **LC 90**  | ❌ No   | Input duplicates    | Unique subsets          |

If you master this table, many OA variations become much easier.

---

# 🧠 Part 2.2 Pattern Evolution

```text
086
Subsequence Sum
       ↓
087
Subsets
       ↓
088
Count
       ↓
089
Target
       ↓
090
Partition
       ↓
091
Optimization
       ↓
092–098
Multiple Choices
       ↓
099
Combination Count
       ↓
100
Include / Exclude Master
       ↓
101
Permutation
       ↓
102
Duplicate Permutation
       ↓
105
Combination
       ↓
107
Combination Sum
       ↓
108
Duplicate + No Reuse
       ↓
109
K + Target
       ↓
110
Duplicate Subsets
```

---

# ⚠️ MOST IMPORTANT MISTAKES

### Take / Not-Take

```text
❌ Missing one branch
❌ Wrong index
❌ Wrong target update
❌ Forgetting current sum
```

### Permutation

```text
❌ Forgetting used[]
❌ Forgetting undo
❌ Duplicate permutations
❌ Wrong base case
```

### Combination

```text
❌ Using permutation logic
❌ Going backwards
❌ Wrong start index
```

### Combination Sum

```text
❌ Reusing when forbidden
❌ Not reusing when allowed
❌ Duplicate answers
❌ Wrong target update
```

---

# ⏱️ Complexity

### Subsets

```text
O(2^n)
```

### Permutations

```text
O(n!)
```

### Outputting each permutation

```text
O(n × n!)
```

### Combinations

```text
O(C(n,k))
```

The actual complexity depends on the number of generated states and the cost of constructing each result.

---

# 🏆 PART 2.2 MASTER CHECKLIST

## H — Take / Not-Take

* [ ] I understand Take / Not-Take.
* [ ] I can generate all subsets.
* [ ] I can count subsets.
* [ ] I can solve subsequence sum K.
* [ ] I can check existence.
* [ ] I understand equal partition.
* [ ] I understand minimum partition difference.
* [ ] I can generate constrained binary strings.

## I — Choice

* [ ] I understand multiple choices.
* [ ] I can generate strings recursively.
* [ ] I can count choices.
* [ ] I understand choose-K.
* [ ] I can recognize the transition to backtracking.

## J — Permutation / Combination

* [ ] I understand permutation.
* [ ] I understand combination.
* [ ] I know when order matters.
* [ ] I can use `visited[]`.
* [ ] I understand `start`.
* [ ] I understand Choose → Recurse → Undo.
* [ ] I understand reuse vs no reuse.
* [ ] I can handle duplicates.
* [ ] I can solve Combination Sum I/II/III.
* [ ] I can solve Subsets II.

---

# 🧪 PART 2.2 MASTER TEST

Before Part 2.3, solve these **without looking at code**:

```text
086  Check Subsequence Sum K
087  Generate Subsets
088  Count Subsets
089  Subset Sum
090  Equal Partition

092  Generate Binary Strings
093  No Consecutive 1s
095  Exactly K Ones

099  Choose K Items

101  Permutations
102  Unique Permutations
105  Combinations
107  Combination Sum
108  Combination Sum II
109  Combination Sum III
110  Subsets II
```

For each one, identify:

```text
STATE
  ↓
CHOICES
  ↓
BASE CASE
  ↓
TAKE / SKIP?
  OR
CHOOSE / RECURSE / UNDO?
  ↓
DUPLICATES?
  ↓
REUSE?
  ↓
COMPLEXITY
```

---

# 🔒 MASTER ROADMAP STATUS

| Part         |       Range | Focus                                                        |
| ------------ | ----------: | ------------------------------------------------------------ |
| **Part 1**   | **001–060** | Basic/String/Array Recursion                                 |
| **Part 2.1** | **061–085** | Mathematical Recursion → Take/Not-Take Foundation            |
| **Part 2.2** | **086–110** | **Take/Not-Take → Choice → Permutation/Combination**         |
| **Part 2.3** | **111–135** | Advanced Subsets/Choices → Parentheses/Expressions/Partition |
| **Part 2.4** | **136–160** | Expression Completion → Grid/Maze/Chessboard                 |
| **Part 2.5** | **161–180** | Constraint + Advanced Backtracking                           |
| **Part 2.6** | **181–200** | Advanced OA + Final Mastery                                  |

# 📖 PART 2.3 — ADVANCED PERMUTATION / COMBINATION → PARENTHESES / EXPRESSIONS / PARTITIONING

I rechecked the **actual 200-problem master file** before locking this section.

The source places:

* **111–120** → remaining **Permutations / Combinations / Basic Backtracking**
* **121–140** → **Parentheses / Expressions / Partitioning**

Therefore **Part 2.3 = 111–135**, with the exact source problems preserved.

---

# 🔒 PART 2.3 MASTER TRACKER

| Pattern                                      |       Range | Problems | Status |
| -------------------------------------------- | ----------: | -------: | :----: |
| **J — Advanced Permutation / Combination**   | **111–120** |       10 |    ⬜   |
| **K — Parentheses / Expression / Partition** | **121–130** |       10 |    ⬜   |
| **L — Advanced Expression / Partition**      | **131–135** |        5 |    ⬜   |
| **TOTAL**                                    | **111–135** |   **25** |    ⬜   |

### Revision System

| Revision | When     |
| -------- | -------- |
| **R0**   | Same day |
| **R1**   | Day 1    |
| **R2**   | Day 3    |
| **R3**   | Day 7    |
| **R4**   | Day 15   |
| **R5**   | Day 30   |

---

# 🟥 J — ADVANCED PERMUTATION / COMBINATION

## Problems 111–120

These are the **exact problems from the master source**.

|       # | Problem                              | Platform          | Status |  R1 |  R2 |  R3 |  R4 |  R5 |
| ------: | ------------------------------------ | ----------------- | :----: | :-: | :-: | :-: | :-: | :-: |
| **111** | Generate All Subsets                 | LeetCode 78       |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |
| **112** | Generate All K-Subsets               | Interview-style   |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |
| **113** | Subsets of a String                  | Interview-style   |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |
| **114** | Letter Case Permutation              | LeetCode 784      |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |
| **115** | Phone Keypad Combinations            | GFG / LeetCode 17 |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |
| **116** | Generate All Abbreviations           | LeetCode 320      |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |
| **117** | Permutation Sequence                 | LeetCode 60       |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |
| **118** | K-th Permutation Using Recursion     | LeetCode 60       |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |
| **119** | Print All Arrangements of Characters | Interview-style   |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |
| **120** | Generate All Possible Passwords      | Interview-style   |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |

---

# 🧠 J — What You Must Master

Part 2.2 taught:

```text
TAKE / NOT-TAKE
        ↓
SUBSETS
        ↓
PERMUTATION
        ↓
COMBINATION
```

Part 2.3 now expands the **choice space**:

```text
SUBSETS
   ↓
K-SUBSETS
   ↓
STRING SUBSETS
   ↓
CHARACTER CHOICES
   ↓
PHONE DIGIT CHOICES
   ↓
ABBREVIATION CHOICES
   ↓
K-TH RESULT
   ↓
CHARACTER ARRANGEMENTS
   ↓
PASSWORD GENERATION
```

---

## ⭐ 111 — Generate All Subsets

Core pattern:

```text
                element
               /       \
            TAKE       SKIP
```

You should be able to generate:

```text
[]
[1]
[2]
[1,2]
...
```

---

## ⭐ 112 — Generate All K-Subsets

Now add a constraint:

```text
size == K
```

Mental model:

```text
choose
 ↓
choose
 ↓
choose
 ↓
size == K
```

This is the bridge:

```text
Subset
   ↓
Subset + Size Constraint
   ↓
Combination
```

---

## ⭐ 113 — Subsets of a String

Same recursive idea, different data:

```text
Array
 ↓
String
```

For:

```text
abc
```

you explore:

```text
take a / skip a
take b / skip b
take c / skip c
```

The important lesson:

> **Pattern stays the same even when the data type changes.**

---

# ⭐ 114 — Letter Case Permutation

For:

```text
a1b
```

choices become:

```text
a → a / A
1 → 1
b → b / B
```

So:

```text
a1b
a1B
A1b
A1B
```

This teaches **variable branching**.

Not every position has exactly two choices.

---

# ⭐ 115 — Phone Keypad

For:

```text
23
```

you have:

```text
2 → abc
3 → def
```

Then recursively:

```text
a + d/e/f
b + d/e/f
c + d/e/f
```

The important pattern:

```text
current input position
        ↓
multiple choices
        ↓
recurse to next position
```

---

# ⭐ 116 — Generate Abbreviations

This introduces a more advanced recursive state.

At each character you can choose:

```text
KEEP CHARACTER
OR
ABBREVIATE
```

The important lesson is:

> **The recursive state can contain more than just `idx` and `path`.**

You may need:

```text
idx
path
count
```

---

# ⭐ 117–118 — K-th Permutation

These are important because they introduce:

```text
Generate everything
        ↓
Question asks only for K-th answer
        ↓
Can we avoid unnecessary generation?
```

This is an early introduction to **search-space reduction**.

---

# ⭐ 119–120 — Arrangements / Passwords

These are general interview-style problems designed to make you recognize:

```text
"Generate every possible arrangement"
```

as:

```text
RECURSION
+
CHOICES
+
BACKTRACKING
```

---

# 🟧 K — PARENTHESES / EXPRESSIONS / PARTITIONING

The master source begins this family at **121**.

## Problems 121–130

|       # | Problem                                   | Platform             | Status |  R1 |  R2 |  R3 |  R4 |  R5 |
| ------: | ----------------------------------------- | -------------------- | :----: | :-: | :-: | :-: | :-: | :-: |
| **121** | Generate Parentheses                      | LeetCode 22          |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |
| **122** | Balanced Parentheses Generation           | GeeksforGeeks        |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |
| **123** | Valid Parentheses Generation With K Pairs | LeetCode 22          |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |
| **124** | Brace Expansion                           | LeetCode 1087 style  |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |
| **125** | Expression Add Operators                  | LeetCode 282         |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |
| **126** | Restore Valid IP Addresses                | LeetCode 93          |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |
| **127** | Palindrome Partitioning                   | LeetCode 131         |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |
| **128** | All Possible Palindrome Partitions        | LeetCode 131         |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |
| **129** | Split String Into Dictionary Words        | Word Break recursion |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |
| **130** | Insert Operators to Reach Target          | LeetCode 282         |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |



---

# 🔥 NEW PATTERN — VALID STATE BACKTRACKING

Part 2.2:

```text
CHOOSE
 ↓
RECURSE
 ↓
UNDO
```

Part 2.3:

```text
CHOOSE
 ↓
CHECK VALIDITY
 ↓
RECURSE
 ↓
UNDO
```

This is a major step toward advanced backtracking.

---

# ⭐ 121 — Generate Parentheses

For:

```text
n = 3
```

you need only valid sequences.

The key state:

```text
open
close
```

Rules:

```text
open < n
```

and:

```text
close < open
```

Therefore we **never intentionally generate an invalid prefix**.

Mental model:

```text
             ""
             |
            "("
          /     \
        "(("    "()"
         |
       "(()"
         |
       "(())"
```

---

# ⭐ 125 — Expression Add Operators

Now every position can involve:

```text
number
+
-
*
```

The state becomes much richer:

```text
index
+
current expression
+
current calculated value
+
previous operand
+
target
```

This is one of the important **advanced recursion/OA patterns** in this section.

---

# ⭐ 126 — Restore IP Addresses

The string must be divided into exactly:

```text
4 parts
```

Each part must be valid.

So:

```text
choose split
     ↓
validate part
     ↓
valid?
 ┌───┴───┐
NO      YES
 ↓        ↓
skip    recurse
```

This is:

```text
PARTITION
+
CONSTRAINT
+
BACKTRACKING
```

---

# ⭐ 127–128 — Palindrome Partitioning

For:

```text
aab
```

valid partitions include:

```text
a | a | b
aa | b
```

The recursive question becomes:

> Where should I cut the current string?

Then:

```text
Is current part palindrome?
        ↓
       YES
        ↓
recurse on remaining part
```

This introduces **partition-point recursion**.

---

# ⭐ 129 — Word Break Recursion

Think:

```text
string
 ↓
choose prefix
 ↓
is prefix a dictionary word?
 ↓
YES
 ↓
recurse on remaining string
```

This is extremely useful because many OA questions hide the same pattern under different wording.

---

# 🟥 L — ADVANCED EXPRESSION / PARTITION

Problems **131–135** are the final five problems of our Part 2.3 range. The source lists them as follows.

|       # | Problem                                     | Platform        | Status |  R1 |  R2 |  R3 |  R4 |  R5 |
| ------: | ------------------------------------------- | --------------- | :----: | :-: | :-: | :-: | :-: | :-: |
| **131** | Generate All Valid Arithmetic Expressions   | Interview-style |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |
| **132** | Split String Into All Possible Parts        | Interview-style |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |
| **133** | Partition Labels Via Recursion Idea         | Interview-style |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |
| **134** | Generate All Valid Bracket Sequences        | GFG             |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |
| **135** | Generate All Valid Expressions With + and - | Interview-style |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |

---

# 🧠 PART 2.3 PATTERN EVOLUTION

```text
111
SUBSETS
   ↓
112
K-SUBSETS
   ↓
113
STRING SUBSETS
   ↓
114
LETTER CASE
   ↓
115
PHONE KEYPAD
   ↓
116
ABBREVIATIONS
   ↓
117–118
K-TH PERMUTATION
   ↓
119–120
ARRANGEMENTS
   ↓
====================
121
PARENTHESES
   ↓
124
BRACE EXPANSION
   ↓
125
EXPRESSIONS
   ↓
126
IP PARTITION
   ↓
127–128
PALINDROME PARTITION
   ↓
129
WORD BREAK
   ↓
130
TARGET EXPRESSION
   ↓
131–135
ADVANCED EXPRESSION /
PARTITION
```

---

# 🎯 PATTERN RECOGNITION TABLE

| If question says...     | Think...                    |
| ----------------------- | --------------------------- |
| Generate all subsets    | **Subset recursion**        |
| Choose K items          | **Combination**             |
| Rearrange all elements  | **Permutation**             |
| Upper/lowercase choices | **Branching choice**        |
| Phone digits            | **Choice tree**             |
| Generate abbreviations  | **State + branching**       |
| Balanced parentheses    | **Constraint backtracking** |
| Insert operators        | **Expression recursion**    |
| Split into valid pieces | **Partition recursion**     |
| Palindromic pieces      | **Partition + validation**  |
| Dictionary words        | **Prefix partition**        |

---

# 🧠 UNIVERSAL BACKTRACKING TEMPLATE

By Problem 135, you should be comfortable with this structure:

```java
void backtrack(State state) {

    if (baseCase(state)) {
        processAnswer();
        return;
    }

    for (Choice choice : choices) {

        if (!isValid(choice, state)) {
            continue;
        }

        choose(choice);

        backtrack(state);

        undo(choice);
    }
}
```

But remember:

**Do not memorize this template blindly.**

You should be able to derive it from:

```text
What is my state?
       ↓
What choices exist?
       ↓
What makes a choice valid?
       ↓
What changes after choosing?
       ↓
What must be restored?
```

---

# ⚠️ PART 2.3 COMMON MISTAKES

```text
❌ Confusing subset with permutation

❌ Using visited[] when start-index recursion is needed

❌ Forgetting undo

❌ Allowing duplicate results

❌ Generating invalid parentheses

❌ Wrong open/close condition

❌ Wrong partition boundary

❌ Accepting invalid IP segments

❌ Forgetting leading-zero rules

❌ Losing expression state

❌ Forgetting remaining string
```

---

# 🏆 PART 2.3 MUST-MASTER SET

If you later do a revision-only round, prioritize:

```text
111  Generate All Subsets
112  K-Subsets
114  Letter Case Permutation
115  Phone Keypad
116  Abbreviations
117  Permutation Sequence

121  Generate Parentheses
124  Brace Expansion
125  Expression Add Operators
126  Restore IP Addresses
127  Palindrome Partitioning
129  Word Break
```

Then:

```text
131
132
133
134
135
```

as your **variation/mastery problems**.

---

# 🧪 FINAL PART 2.3 TEST

Before moving to Part 2.4, you should be able to solve these without looking at your previous code:

```text
111 → subsets
112 → K-subsets
114 → letter case
115 → keypad
116 → abbreviations
117 → K-th permutation

121 → parentheses
124 → brace expansion
125 → expression operators
126 → valid IP
127 → palindrome partition
129 → word break

131 → arithmetic expressions
134 → valid brackets
135 → + / - expressions
```

For each problem:

```text
STATE
 ↓
CHOICES
 ↓
CONSTRAINT
 ↓
BASE CASE
 ↓
RECURSE
 ↓
UNDO
 ↓
COMPLEXITY
```

---

# 🔒 MASTER ROADMAP

| Part            |          Range | Focus                                                           |
| --------------- | -------------: | --------------------------------------------------------------- |
| **Part 1**      |    **001–060** | Foundation Recursion                                            |
| **Part 2.1**    |    **061–085** | Mathematical → Take/Not-Take                                    |
| **Part 2.2**    |    **086–110** | Take/Not-Take → Permutation/Combination                         |
| **👉 Part 2.3** | **👉 111–135** | **Advanced Choices → Parentheses → Expressions → Partitioning** |
| **Part 2.4**    |    **136–160** | Expression Completion → Grid/Maze/Chessboard                    |
| **Part 2.5**    |    **161–180** | Constraint / Advanced Backtracking                              |
| **Part 2.6**    |    **181–200** | Advanced OA / Final Mastery                                     |

The next section **must start at 136**, because the source has 136–140 as the continuation of the Parentheses/Expressions/Partitioning family and begins Grid/Maze/Chessboard at 141.

# 📖 PART 2.4 — EXPRESSION MASTER → GRID / MAZE / CHESSBOARD BACKTRACKING

We continue **exactly from Part 2.3**.

```text
Part 1    → 001–060
Part 2.1  → 061–085
Part 2.2  → 086–110
Part 2.3  → 111–135
👉 Part 2.4 → 136–160
Part 2.5  → 161–180
Part 2.6  → 181–200
```

The source places **136–140** as the continuation of Expression/Partitioning, then **141–160** as Grid/Maze/Chessboard backtracking.

---

# 📊 PART 2.4 OVERVIEW

| Pattern                                      |       Range | Problems | Status |
| -------------------------------------------- | ----------: | -------: | :----: |
| **L — Expression / Partition Mastery**       |     136–140 |        5 |    ⬜   |
| **M — Grid / Maze Backtracking**             |     141–146 |        6 |    ⬜   |
| **N — Chessboard / Constraint Backtracking** |     147–154 |        8 |    ⬜   |
| **O — Recursive Grid Traversal**             |     155–160 |        6 |    ⬜   |
| **TOTAL**                                    | **136–160** |   **25** |    ⬜   |

### Revision

| Revision | When     |
| -------- | -------- |
| R0       | Same day |
| R1       | Day 1    |
| R2       | Day 3    |
| R3       | Day 7    |
| R4       | Day 15   |
| R5       | Day 30   |

---

# 🟥 L — EXPRESSION / PARTITION MASTERY

These directly continue the source's expression/partition section.

|       # | Problem                             | Platform     | Difficulty | Interview | Status |  R1 |  R2 |  R3 |  R4 |  R5 |
| ------: | ----------------------------------- | ------------ | :--------: | :-------: | :----: | :-: | :-: | :-: | :-: | :-: |
| **136** | Expression Evaluation by Recursion  | Interview    |     🟡     |    ⭐⭐⭐⭐   |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |
| **137** | Different Ways to Add Parentheses   | LeetCode 241 |     🟡     |   ⭐⭐⭐⭐⭐   |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |
| **138** | Boolean Expression Parenthesization | GFG          |     🔴     |   ⭐⭐⭐⭐⭐   |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |
| **139** | Count Valid Parenthesizations       | GFG          |     🔴     |    ⭐⭐⭐⭐   |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |
| **140** | Generate All Sentence Splits        | Interview    |     🟡     |    ⭐⭐⭐⭐   |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |

### What this section teaches

```text
Expression
    ↓
Choose operator / split
    ↓
Solve left
    ↓
Solve right
    ↓
Combine
```

The important transition:

```text
Simple recursion
      ↓
Backtracking
      ↓
Partition recursion
      ↓
Expression decomposition
      ↓
Divide-and-combine recursion
```

---

# 🟧 M — GRID / MAZE BACKTRACKING

Problems **141–146** are explicitly listed in the source as the beginning of Grid/Maze/Chessboard backtracking.

|       # | Problem                   | Platform     | Difficulty | Interview | Status |  R1 |  R2 |  R3 |  R4 |  R5 |
| ------: | ------------------------- | ------------ | :--------: | :-------: | :----: | :-: | :-: | :-: | :-: | :-: |
| **141** | Rat in a Maze             | GFG          |     🟡     |   ⭐⭐⭐⭐⭐   |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |
| **142** | Maze Paths                | GFG          |     🟢     |    ⭐⭐⭐⭐   |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |
| **143** | Maze Paths with Obstacles | GFG          |     🟡     |   ⭐⭐⭐⭐⭐   |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |
| **144** | Count Maze Paths          | GFG          |     🟢     |    ⭐⭐⭐⭐   |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |
| **145** | Word Search               | LeetCode 79  |     🟡     |   ⭐⭐⭐⭐⭐   |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |
| **146** | Word Search II            | LeetCode 212 |     🔴     |   ⭐⭐⭐⭐⭐   |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |

---

# 🧠 NEW MENTAL MODEL — GRID RECURSION

Before:

```text
idx
 ↓
idx + 1
```

Now:

```text
             UP
              ↑
LEFT ←     CELL     → RIGHT
              ↓
             DOWN
```

So the recursive state becomes:

```java
(row, col)
```

instead of:

```java
(idx)
```

---

# ⭐ 141 — RAT IN A MAZE

Think:

```text
START
  ↓
choose direction
  ↓
valid?
  ↓
move
  ↓
recurse
  ↓
dead end?
  ↓
BACKTRACK
```

This is one of the most important transitions into real backtracking.

---

# ⭐ 142 — MAZE PATHS

For a simple grid:

```text
S → → →
      ↓
      ↓
      E
```

Choices might be:

```text
RIGHT
DOWN
```

Therefore:

```text
                 START
                /     \
             RIGHT     DOWN
              /         \
          RIGHT          ...
```

You are now explicitly building a **recursion tree of paths**.

---

# ⭐ 143 — MAZE WITH OBSTACLES

Now add:

```text
if obstacle
    return;
```

So the recursion becomes:

```text
Is cell valid?
      ↓
 ┌────┴────┐
 NO        YES
 ↓          ↓
return    recurse
```

This is the beginning of **pruning**.

---

# ⭐ 144 — COUNT MAZE PATHS

Instead of printing every path:

```text
return
    pathsFromDirection1
  + pathsFromDirection2;
```

This is important because it connects:

```text
Backtracking
     ↓
Counting recursion
     ↓
Dynamic Programming
```

---

# ⭐ 145 — WORD SEARCH

This is a major interview problem.

You must track:

```text
row
col
wordIndex
visited
```

Typical structure:

```text
choose cell
   ↓
match?
   ↓
mark visited
   ↓
search neighbors
   ↓
unmark
```

That final step:

```text
unmark
```

is the **backtracking operation**.

---

# ⭐ 146 — WORD SEARCH II

Now:

```text
ONE WORD
   ↓
MANY WORDS
```

This increases the search space substantially.

The important lesson is not just solving Word Search II.

It is recognizing:

> **Same recursive search + larger state space + stronger pruning.**

---

# 🟨 N — CHESSBOARD / CONSTRAINT BACKTRACKING

The source explicitly includes N-Queens, N-Queens II, Sudoku, Knight's Tour, Crossword, Graph Coloring, Hamiltonian Path and Hamiltonian Cycle.

|       # | Problem                     | Platform    | Difficulty | Interview | Status |  R1 |  R2 |  R3 |  R4 |  R5 |
| ------: | --------------------------- | ----------- | :--------: | :-------: | :----: | :-: | :-: | :-: | :-: | :-: |
| **147** | N-Queens                    | LeetCode 51 |     🔴     |   ⭐⭐⭐⭐⭐   |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |
| **148** | N-Queens II                 | LeetCode 52 |     🔴     |   ⭐⭐⭐⭐⭐   |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |
| **149** | Sudoku Solver               | LeetCode 37 |     🔴     |   ⭐⭐⭐⭐⭐   |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |
| **150** | Knight's Tour               | GFG         |     🔴     |    ⭐⭐⭐⭐   |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |
| **151** | Crossword Puzzle Solver     | GFG         |     🔴     |    ⭐⭐⭐⭐   |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |
| **152** | Graph Coloring Backtracking | GFG         |     🔴     |   ⭐⭐⭐⭐⭐   |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |
| **153** | Hamiltonian Path            | Interview   |     🔴     |    ⭐⭐⭐⭐   |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |
| **154** | Hamiltonian Cycle           | Interview   |     🔴     |   ⭐⭐⭐⭐⭐   |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |

---

# 🔥 147 — N-QUEENS

This is a **must-master recursion problem**.

The thinking:

```text
Place Queen
    ↓
Is position safe?
    ↓
YES
    ↓
Place next queen
    ↓
Failure?
    ↓
REMOVE QUEEN
    ↓
Try next position
```

The core pattern:

```text
CHOOSE
  ↓
VALIDATE
  ↓
RECURSE
  ↓
UNDO
```

---

# 🔥 148 — N-QUEENS II

Same search space.

But instead of:

```text
return all boards
```

you return:

```text
number of valid boards
```

This teaches:

```text
same recursion
+
different return requirement
```

---

# 🔥 149 — SUDOKU SOLVER

Now constraints become much stronger.

At every empty cell:

```text
try 1
try 2
try 3
...
try 9
```

For each:

```text
valid?
 ↓
YES → recurse
NO  → skip
```

If later failure occurs:

```text
remove number
```

and try the next candidate.

This is **constraint satisfaction recursion**.

---

# 🔥 150 — KNIGHT'S TOUR

The knight can make multiple moves:

```text
      1   2
    8       3

    7       4
      6   5
```

So each cell creates several possible recursive branches.

You need:

```text
visited
+
move count
+
backtracking
```

---

# 🔥 152 — GRAPH COLORING

This is important because it proves that backtracking isn't limited to arrays and grids.

State:

```text
vertex
color assignment
```

Choices:

```text
color 1
color 2
...
color K
```

Constraint:

```text
neighbor cannot have same color
```

---

# 🔥 153–154 — HAMILTONIAN PATH / CYCLE

Now the search is:

```text
Choose next vertex
       ↓
Is it safe?
       ↓
Visit
       ↓
Recurse
       ↓
Backtrack
```

This is advanced **graph backtracking**.

---

# 🟩 O — RECURSIVE GRID TRAVERSAL

The source lists **155–160** as Flood Fill, All Paths, Unique Paths with Obstacles, Maximum Score Path, Count Islands, and Maximum Area of Island.

|       # | Problem                           | Platform       | Difficulty | Interview | Status |  R1 |  R2 |  R3 |  R4 |  R5 |
| ------: | --------------------------------- | -------------- | :--------: | :-------: | :----: | :-: | :-: | :-: | :-: | :-: |
| **155** | Flood Fill Recursive Backtracking | LeetCode 733   |     🟢     |   ⭐⭐⭐⭐⭐   |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |
| **156** | All Paths From Source to Target   | LeetCode 797   |     🟡     |   ⭐⭐⭐⭐⭐   |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |
| **157** | Unique Paths With Obstacles       | LeetCode 63    |     🟡     |    ⭐⭐⭐⭐   |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |
| **158** | Path With Maximum Score           | Grid Recursion |     🔴     |    ⭐⭐⭐⭐   |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |
| **159** | Count Islands Using Recursion     | LeetCode 200   |     🟡     |   ⭐⭐⭐⭐⭐   |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |
| **160** | Maximum Area of Island            | LeetCode 695   |     🟡     |   ⭐⭐⭐⭐⭐   |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |

---

# 🧠 PART 2.4 EVOLUTION

```text
136
Expression Evaluation
        ↓
137
Divide Expression
        ↓
138–140
Expression / Partition
        ↓
========================
141
Maze
        ↓
142–144
Grid Path Recursion
        ↓
145
Word Search
        ↓
146
Multiple Word Search
        ↓
========================
147
N-Queens
        ↓
148
N-Queens Count
        ↓
149
Sudoku
        ↓
150
Knight's Tour
        ↓
151
Crossword
        ↓
152
Graph Coloring
        ↓
153–154
Hamiltonian Search
        ↓
========================
155–160
Grid Traversal / Path / Island
```

---

# 🎯 PATTERN RECOGNITION

| Question wording           | Pattern                      |
| -------------------------- | ---------------------------- |
| Move through maze          | **Grid recursion**           |
| Find all paths             | **Branching grid recursion** |
| Avoid obstacles            | **Grid + pruning**           |
| Find word in grid          | **Backtracking**             |
| Place queens               | **Constraint backtracking**  |
| Fill Sudoku                | **Constraint satisfaction**  |
| Color graph                | **Graph backtracking**       |
| Visit every vertex once    | **Hamiltonian backtracking** |
| Flood connected cells      | **Recursive grid traversal** |
| Count connected components | **Grid DFS recursion**       |
| Find largest island        | **Grid DFS + return value**  |

---

# 🧠 UNIVERSAL GRID TEMPLATE

You should start seeing almost every grid recursion problem as:

```java
void solve(int row, int col) {

    if (outOfBounds(row, col)) {
        return;
    }

    if (invalid(row, col)) {
        return;
    }

    mark(row, col);

    solve(row - 1, col);
    solve(row + 1, col);
    solve(row, col - 1);
    solve(row, col + 1);

    unmark(row, col);
}
```

Then modify it according to the question.

---

# 🧠 UNIVERSAL BACKTRACKING TEMPLATE

By the end of **160**, this should become natural:

```text
                 STATE
                   ↓
               BASE CASE
                   ↓
              GENERATE CHOICES
                   ↓
              CHECK CONSTRAINT
                   ↓
                 CHOOSE
                   ↓
                RECURSE
                   ↓
                 UNDO
                   ↓
             TRY NEXT CHOICE
```

---

# 🏆 PART 2.4 MUST-MASTER

If you want the highest-value revision set:

### ⭐⭐⭐⭐⭐

```text
141 Rat in a Maze
145 Word Search
147 N-Queens
149 Sudoku Solver
152 Graph Coloring
154 Hamiltonian Cycle
155 Flood Fill
156 All Paths
159 Number of Islands
160 Maximum Area of Island
```

But **do not skip the other 15**. Your goal is not merely to recognize LeetCode questions; it is to become comfortable when an OA changes the wording or combines two recursion patterns.

---

# ✅ PART 2.4 COMPLETION CRITERIA

Do **not** mark Part 2.4 complete until you can independently explain:

```text
☐ Why grid recursion needs (row, col)

☐ Why visited is required

☐ When visited must be undone

☐ Difference between DFS traversal and backtracking

☐ How maze recursion branches

☐ How obstacles prune branches

☐ How Word Search tracks word index

☐ How N-Queens validates a position

☐ How Sudoku chooses candidates

☐ How graph coloring validates colors

☐ How Hamiltonian search prevents repeated vertices

☐ How recursive grid traversal can return a value

☐ How to calculate recursion complexity
```

---

# 🔒 MASTER STATUS

```text
PART 1       001–060   ✅ COMPLETED
PART 2.1     061–085   🔲
PART 2.2     086–110   🔲
PART 2.3     111–135   🔲
PART 2.4     136–160   🔲  ← CURRENT
PART 2.5     161–180   🔲
PART 2.6     181–200   🔲
```
# 📖 PART 2.5 — CONSTRAINT + ADVANCED BACKTRACKING

We continue directly from Part 2.4.

```text
Part 1    → 001–060
Part 2.1  → 061–085
Part 2.2  → 086–110
Part 2.3  → 111–135
Part 2.4  → 136–160
👉 Part 2.5 → 161–180
Part 2.6  → 181–200
```

The master source places **161–180** under **Constraint / Advanced Backtracking**.

---

# 🔒 PART 2.5 MASTER TRACKER

| Pattern                               |       Range | Problems | Status |
| ------------------------------------- | ----------: | -------: | :----: |
| **P — Constraint Selection**          |     161–170 |       10 |    ⬜   |
| **Q — Advanced Constraint / Pruning** |     171–180 |       10 |    ⬜   |
| **TOTAL**                             | **161–180** |   **20** |    ⬜   |

### Revision

| Round | When     |
| ----- | -------- |
| R0    | Same day |
| R1    | Day 1    |
| R2    | Day 3    |
| R3    | Day 7    |
| R4    | Day 15   |
| R5    | Day 30   |

---

# 🟥 P — CONSTRAINT SELECTION

These are the source's **161–170** problems.

|       # | Problem                               | Platform           | Difficulty | OA Value | Status |  R1 |  R2 |  R3 |  R4 |  R5 |   |   |   |
| ------: | ------------------------------------- | ------------------ | :--------: | :------: | :----: | :-: | :-: | :-: | :-: | :-: | - | - | - |
| **161** | Partition to K Equal Sum Subsets      | LeetCode 698       |     🔴     |   ⭐⭐⭐⭐⭐  |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |   |   |   |
| **162** | Matchsticks to Square                 | LeetCode 473       |     🔴     |   ⭐⭐⭐⭐⭐  |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  | ⬜ |   |   |
| **163** | Word Break II                         | LeetCode 140       |     🔴     |   ⭐⭐⭐⭐⭐  |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  | ⬜ | ⬜ |   |
| **164** | Scramble String                       | LeetCode 87        |     🔴     |   ⭐⭐⭐⭐   |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  | ⬜ | ⬜ |   |
| **165** | Wildcard Matching                     | LeetCode 44        |     🔴     |   ⭐⭐⭐⭐⭐  |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  | ⬜ | ⬜ |   |
| **166** | Regular Expression Matching           | LeetCode 10        |     🔴     |   ⭐⭐⭐⭐⭐  |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  | ⬜ | ⬜ |   |
| **167** | Cryptarithmetic Puzzle                | GFG / Interview    |     🔴     |   ⭐⭐⭐⭐   |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  | ⬜ | ⬜ |   |
| **168** | Boggle Word Search                    | GFG                |     🔴     |   ⭐⭐⭐⭐⭐  |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  | ⬜ | ⬜ |   |
| **169** | Sentence Generation                   | Interview          |     🔴     |   ⭐⭐⭐⭐   |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  | ⬜ | ⬜ | ⬜ |
| **170** | Minimum Cuts for Palindrome Partition | LeetCode 132 / GFG |     🔴     |   ⭐⭐⭐⭐⭐  |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  | ⬜ | ⬜ |   |

---

# 🧠 NEW LEVEL — CONSTRAINT REASONING

Earlier backtracking:

```text id="s0q4bf"
choose
↓
recurse
↓
undo
```

Now:

```text id="k5cz1v"
choose
↓
CHECK CONSTRAINT
↓
   ├── invalid → reject
   │
   └── valid
        ↓
      recurse
        ↓
       undo
```

The key question becomes:

> **"Can I reject this branch immediately?"**

That is the beginning of **pruning**.

---

# ⭐ 161 — Partition to K Equal Sum Subsets

Given an array, divide it into exactly `k` subsets having equal sums.

Mental model:

```text id="1ypw9v"
element
   ↓
which bucket?
 /  |  \
B1  B2  B3
```

Each placement has a constraint:

```text id="2q0k4a"
bucketSum <= target
```

This is fundamentally:

```text id="9j3h6u"
CHOOSE BUCKET
      ↓
CHECK CAPACITY
      ↓
RECURSE
      ↓
UNDO
```

---

# ⭐ 162 — Matchsticks to Square

Same underlying idea:

```text id="yq8j3o"
matchstick
    ↓
which side?
```

But now:

```text id="y7p2wo"
all 4 sides
must equal
```

This is an excellent example of recognizing that two different-looking problems share the same **bucket-assignment backtracking pattern**.

---

# ⭐ 163 — Word Break II

Part 2.3 introduced:

```text id="kkl7n9"
Word Break
```

Now:

```text id="6f2c3n"
ONE valid segmentation
        ↓
ALL valid segmentations
```

So the recursion must explore **every valid prefix**.

Mental model:

```text id="q84n4q"
string
 ↓
choose prefix
 ↓
dictionary?
 ↓
YES
 ↓
recurse
 ↓
collect sentence
```

---

# ⭐ 164 — Scramble String

Now the recursion is based on **splitting a string at every possible position**:

```text id="p5z6g6"
string
 ↓
split at i
 ↓
left/right
 ↓
recurse
```

This teaches a powerful general pattern:

> **Try every partition point.**

---

# ⭐ 165 — Wildcard Matching

Choices depend on the current pattern character.

For `*`:

```text id="wub2op"
match zero characters
OR
match one/more characters
```

So:

```text id="y0a6jz"
'*'
 / \
zero  consume
```

This creates branching recursion with state:

```text id="7a1xv6"
string index
pattern index
```

---

# ⭐ 166 — Regular Expression Matching

Now the recursive state is:

```text id="f8jv6b"
string index
pattern index
```

and special characters create choices.

This is a major transition toward **state-based recursion**, which later naturally becomes DP.

---

# ⭐ 167 — Cryptarithmetic

Example style:

```text id="w4g2hj"
  SEND
+ MORE
------
 MONEY
```

Each character gets a digit.

The choices:

```text id="3x5d5k"
character
 ↓
try digit 0–9
 ↓
valid assignment?
 ↓
recurse
```

Constraints can include:

```text id="c1b1mz"
unique digits
leading digit ≠ 0
column arithmetic
```

This is **pure constraint satisfaction**.

---

# ⭐ 168 — Boggle

You already learned Word Search.

Now increase the search space:

```text id="d3xj2n"
8 possible neighbors
```

instead of only four directions.

The same principle applies:

```text id="crz9wp"
choose neighbor
↓
validate
↓
mark
↓
recurse
↓
unmark
```

This teaches:

> **Change the movement rules without changing the backtracking mental model.**

---

# ⭐ 169 — Sentence Generation

This is another:

```text id="8w6jkl"
choose valid word
↓
append
↓
recurse
```

problem.

The important skill is recognizing that **generation problems are backtracking when multiple valid continuations must be explored**.

---

# ⭐ 170 — Minimum Cuts for Palindrome Partition

Earlier:

```text id="e8v5sj"
Generate palindrome partitions
```

Now:

```text id="7w4h5r"
Find minimum cuts
```

So we move from:

```text id="e4wzlo"
generation
```

to:

```text id="3w1w0m"
optimization
```

This is extremely important before DP.

---

# 🟧 Q — ADVANCED CONSTRAINT + PRUNING

Problems **171–180** from the source are explicitly the next advanced set.

|       # | Problem                           | Platform          | Difficulty | OA Value | Status |  R1 |  R2 |  R3 |  R4 |  R5 |   |   |   |
| ------: | --------------------------------- | ----------------- | :--------: | :------: | :----: | :-: | :-: | :-: | :-: | :-: | - | - | - |
| **171** | K-th Subset                       | Interview         |     🔴     |   ⭐⭐⭐⭐   |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |   |   |   |
| **172** | K-th Permutation                  | LeetCode 60       |     🔴     |   ⭐⭐⭐⭐⭐  |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |   |   |   |
| **173** | Pattern → String Mapping          | Interview         |     🔴     |   ⭐⭐⭐⭐   |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  | ⬜ | ⬜ |   |
| **174** | Word Pattern Matching             | Interview         |     🔴     |   ⭐⭐⭐⭐⭐  |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  | ⬜ | ⬜ |   |
| **175** | Remove Invalid Parentheses        | LeetCode 301      |     🔴     |   ⭐⭐⭐⭐⭐  |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  | ⬜ | ⬜ |   |
| **176** | Generate Valid IP Variants        | LeetCode 93 style |     🟡     |   ⭐⭐⭐⭐   |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  | ⬜ | ⬜ |   |
| **177** | Constraint Placement Problem      | Interview         |     🔴     |   ⭐⭐⭐⭐   |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  | ⬜ | ⬜ | ⬜ |
| **178** | Partition Array Under Constraints | Interview         |     🔴     |   ⭐⭐⭐⭐⭐  |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  | ⬜ | ⬜ | ⬜ |
| **179** | Constraint Puzzle                 | Interview         |     🔴     |   ⭐⭐⭐⭐   |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  | ⬜ | ⬜ | ⬜ |
| **180** | Recursive Search With Pruning     | Interview         |     🔴     |   ⭐⭐⭐⭐⭐  |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  | ⬜ | ⬜ | ⬜ |

---

# 🔥 171 — K-th Subset

You already know:

```text id="1vibm7"
generate all subsets
```

Now:

```text id="d0u7fa"
only need K-th
```

The important concept:

```text id="nq5t7c"
Can I skip entire branches?
```

That is **search-space reduction**.

---

# 🔥 173 — Pattern → String Mapping

Example concept:

```text id="4k7v6b"
pattern:
abba

string:
redbluebluered
```

Need:

```text id="x3m8j4"
a → red
b → blue
```

Constraints:

```text id="2m3i4h"
mapping must be consistent
```

This is excellent interview-style backtracking.

---

# 🔥 174 — Word Pattern Matching

Similar idea, but now the mapping itself becomes the recursive state.

You must track:

```text id="7v72nq"
patternIndex
stringIndex
mapping
usedWords
```

This teaches **multiple pieces of state simultaneously**.

---

# 🔥 175 — Remove Invalid Parentheses

Instead of:

```text id="qg5p5r"
Generate valid parentheses
```

we start with an invalid string and search for:

> What should I remove?

At each position:

```text id="u7a9zo"
REMOVE
OR
KEEP
```

Then prune duplicates and invalid states.

This is a very important OA pattern:

```text id="y50v7n"
KEEP / REMOVE
+
VALIDITY
+
DEDUPLICATION
+
PRUNING
```

---

# 🔥 177–180 — Pure OA Thinking

These are deliberately generic constraint/backtracking patterns from the master source.

The goal is no longer:

> "Can I solve this exact LeetCode problem?"

It becomes:

> **"Can I construct the state, choices, constraint and pruning logic for a new problem?"**

---

# 🧠 PART 2.5 — PATTERN EVOLUTION

```text id="6d1q3x"
161
Bucket Assignment
      ↓
162
Bucket Assignment + Equality
      ↓
163
All Valid Segmentations
      ↓
164
Partition at Every Position
      ↓
165
Wildcard Branching
      ↓
166
Pattern/State Matching
      ↓
167
Digit Constraint Satisfaction
      ↓
168
Multi-Direction Search
      ↓
169
Sentence Generation
      ↓
170
Optimization
      ↓
========================
171
K-th Search
      ↓
172
K-th Permutation
      ↓
173
Pattern Mapping
      ↓
174
String Mapping
      ↓
175
Remove / Keep
      ↓
176
Valid Partitioning
      ↓
177–180
Constraint + Pruning
```

---

# 🎯 THE BIGGEST SKILL OF PART 2.5

You should now stop thinking:

```text id="0y8av8"
"What code template is this?"
```

and start thinking:

```text id="6sgw5c"
STATE
 ↓
CHOICES
 ↓
CONSTRAINT
 ↓
PRUNING
 ↓
RECURSE
 ↓
UNDO
```

---

# 🧠 PRUNING

Suppose you have:

```text
target = 10
current = 17
```

There is no reason to continue.

```java
if (current > target) {
    return;
}
```

That's pruning.

Another example:

```java
if (!isSafe(choice)) {
    continue;
}
```

Again:

```text
INVALID BRANCH
      ↓
STOP EARLY
```

---

# 🔥 THREE LEVELS OF BACKTRACKING

| Level          | Structure                                      |
| -------------- | ---------------------------------------------- |
| **Basic**      | Choose → Recurse → Undo                        |
| **Constraint** | Choose → Validate → Recurse → Undo             |
| **Advanced**   | Choose → Validate → **Prune** → Recurse → Undo |

Part 2.5 is where you should become comfortable with **Level 3**.

---

# ⚠️ COMMON MISTAKES

```text id="v5x4b0"
❌ No pruning

❌ Pruning too late

❌ Wrong constraint

❌ Forgetting undo

❌ Shared mutable state

❌ Duplicate answers

❌ Incorrect bucket state

❌ Wrong mapping restoration

❌ Not tracking visited state

❌ Confusing generation with optimization
```

---

# 🏆 MUST-MASTER PROBLEMS

If you need a high-priority revision set:

```text id="0qklp1"
161  Partition to K Equal Sum Subsets
162  Matchsticks to Square
163  Word Break II
165  Wildcard Matching
166  Regex Matching
167  Cryptarithmetic
168  Boggle
170  Minimum Palindrome Cuts

173  Pattern → String
174  Word Pattern
175  Remove Invalid Parentheses
178  Partition Under Constraints
180  Recursive Search + Pruning
```

But because your goal is **mastery once**, complete all 20.

---

# 🧪 PART 2.5 FINAL TEST

Before Part 2.6, you should be able to solve these without looking at code:

```text
161 → K equal subsets
162 → Matchsticks square
163 → Word Break II
165 → Wildcard matching
167 → Cryptarithmetic
168 → Boggle
170 → Minimum cuts

171 → K-th subset
173 → Pattern mapping
174 → Word pattern
175 → Remove invalid parentheses
178 → Constraint partition
180 → Pruning
```

For every problem, answer:

```text
1. What is my STATE?
2. What are my CHOICES?
3. What is my CONSTRAINT?
4. What can I PRUNE?
5. What changes after choosing?
6. What must I UNDO?
7. What is my BASE CASE?
8. Is this generation, counting, decision, or optimization?
9. What is the branching factor?
10. What is the worst-case complexity?
```

---

# 🔒 MASTER ROADMAP

| Part            |       Range | Focus                                   | Problems |
| --------------- | ----------: | --------------------------------------- | -------: |
| Part 1          |     001–060 | Foundation Recursion                    |       60 |
| Part 2.1        |     061–085 | Mathematical → Take/Not-Take            |       25 |
| Part 2.2        |     086–110 | Take/Not-Take → Permutation/Combination |       25 |
| Part 2.3        |     111–135 | Advanced Choice → Expression/Partition  |       25 |
| Part 2.4        |     136–160 | Grid/Maze/Chessboard                    |       25 |
| **👉 Part 2.5** | **161–180** | **Constraint + Advanced Backtracking**  |   **20** |
| Part 2.6        |     181–200 | Advanced OA + Final Mastery             |       20 |

**Part 2.5 is locked: `161–180`.**
# 📖 PART 2.5 — CONSTRAINT + ADVANCED BACKTRACKING

We continue directly from Part 2.4.

```text
Part 1    → 001–060
Part 2.1  → 061–085
Part 2.2  → 086–110
Part 2.3  → 111–135
Part 2.4  → 136–160
👉 Part 2.5 → 161–180
Part 2.6  → 181–200
```

The master source places **161–180** under **Constraint / Advanced Backtracking**.

---

# 🔒 PART 2.5 MASTER TRACKER

| Pattern                               |       Range | Problems | Status |
| ------------------------------------- | ----------: | -------: | :----: |
| **P — Constraint Selection**          |     161–170 |       10 |    ⬜   |
| **Q — Advanced Constraint / Pruning** |     171–180 |       10 |    ⬜   |
| **TOTAL**                             | **161–180** |   **20** |    ⬜   |

### Revision

| Round | When     |
| ----- | -------- |
| R0    | Same day |
| R1    | Day 1    |
| R2    | Day 3    |
| R3    | Day 7    |
| R4    | Day 15   |
| R5    | Day 30   |

---

# 🟥 P — CONSTRAINT SELECTION

These are the source's **161–170** problems.

|       # | Problem                               | Platform           | Difficulty | OA Value | Status |  R1 |  R2 |  R3 |  R4 |  R5 |   |   |   |
| ------: | ------------------------------------- | ------------------ | :--------: | :------: | :----: | :-: | :-: | :-: | :-: | :-: | - | - | - |
| **161** | Partition to K Equal Sum Subsets      | LeetCode 698       |     🔴     |   ⭐⭐⭐⭐⭐  |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |   |   |   |
| **162** | Matchsticks to Square                 | LeetCode 473       |     🔴     |   ⭐⭐⭐⭐⭐  |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  | ⬜ |   |   |
| **163** | Word Break II                         | LeetCode 140       |     🔴     |   ⭐⭐⭐⭐⭐  |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  | ⬜ | ⬜ |   |
| **164** | Scramble String                       | LeetCode 87        |     🔴     |   ⭐⭐⭐⭐   |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  | ⬜ | ⬜ |   |
| **165** | Wildcard Matching                     | LeetCode 44        |     🔴     |   ⭐⭐⭐⭐⭐  |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  | ⬜ | ⬜ |   |
| **166** | Regular Expression Matching           | LeetCode 10        |     🔴     |   ⭐⭐⭐⭐⭐  |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  | ⬜ | ⬜ |   |
| **167** | Cryptarithmetic Puzzle                | GFG / Interview    |     🔴     |   ⭐⭐⭐⭐   |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  | ⬜ | ⬜ |   |
| **168** | Boggle Word Search                    | GFG                |     🔴     |   ⭐⭐⭐⭐⭐  |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  | ⬜ | ⬜ |   |
| **169** | Sentence Generation                   | Interview          |     🔴     |   ⭐⭐⭐⭐   |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  | ⬜ | ⬜ | ⬜ |
| **170** | Minimum Cuts for Palindrome Partition | LeetCode 132 / GFG |     🔴     |   ⭐⭐⭐⭐⭐  |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  | ⬜ | ⬜ |   |

---

# 🧠 NEW LEVEL — CONSTRAINT REASONING

Earlier backtracking:

```text id="s0q4bf"
choose
↓
recurse
↓
undo
```

Now:

```text id="k5cz1v"
choose
↓
CHECK CONSTRAINT
↓
   ├── invalid → reject
   │
   └── valid
        ↓
      recurse
        ↓
       undo
```

The key question becomes:

> **"Can I reject this branch immediately?"**

That is the beginning of **pruning**.

---

# ⭐ 161 — Partition to K Equal Sum Subsets

Given an array, divide it into exactly `k` subsets having equal sums.

Mental model:

```text id="1ypw9v"
element
   ↓
which bucket?
 /  |  \
B1  B2  B3
```

Each placement has a constraint:

```text id="2q0k4a"
bucketSum <= target
```

This is fundamentally:

```text id="9j3h6u"
CHOOSE BUCKET
      ↓
CHECK CAPACITY
      ↓
RECURSE
      ↓
UNDO
```

---

# ⭐ 162 — Matchsticks to Square

Same underlying idea:

```text id="yq8j3o"
matchstick
    ↓
which side?
```

But now:

```text id="y7p2wo"
all 4 sides
must equal
```

This is an excellent example of recognizing that two different-looking problems share the same **bucket-assignment backtracking pattern**.

---

# ⭐ 163 — Word Break II

Part 2.3 introduced:

```text id="kkl7n9"
Word Break
```

Now:

```text id="6f2c3n"
ONE valid segmentation
        ↓
ALL valid segmentations
```

So the recursion must explore **every valid prefix**.

Mental model:

```text id="q84n4q"
string
 ↓
choose prefix
 ↓
dictionary?
 ↓
YES
 ↓
recurse
 ↓
collect sentence
```

---

# ⭐ 164 — Scramble String

Now the recursion is based on **splitting a string at every possible position**:

```text id="p5z6g6"
string
 ↓
split at i
 ↓
left/right
 ↓
recurse
```

This teaches a powerful general pattern:

> **Try every partition point.**

---

# ⭐ 165 — Wildcard Matching

Choices depend on the current pattern character.

For `*`:

```text id="wub2op"
match zero characters
OR
match one/more characters
```

So:

```text id="y0a6jz"
'*'
 / \
zero  consume
```

This creates branching recursion with state:

```text id="7a1xv6"
string index
pattern index
```

---

# ⭐ 166 — Regular Expression Matching

Now the recursive state is:

```text id="f8jv6b"
string index
pattern index
```

and special characters create choices.

This is a major transition toward **state-based recursion**, which later naturally becomes DP.

---

# ⭐ 167 — Cryptarithmetic

Example style:

```text id="w4g2hj"
  SEND
+ MORE
------
 MONEY
```

Each character gets a digit.

The choices:

```text id="3x5d5k"
character
 ↓
try digit 0–9
 ↓
valid assignment?
 ↓
recurse
```

Constraints can include:

```text id="c1b1mz"
unique digits
leading digit ≠ 0
column arithmetic
```

This is **pure constraint satisfaction**.

---

# ⭐ 168 — Boggle

You already learned Word Search.

Now increase the search space:

```text id="d3xj2n"
8 possible neighbors
```

instead of only four directions.

The same principle applies:

```text id="crz9wp"
choose neighbor
↓
validate
↓
mark
↓
recurse
↓
unmark
```

This teaches:

> **Change the movement rules without changing the backtracking mental model.**

---

# ⭐ 169 — Sentence Generation

This is another:

```text id="8w6jkl"
choose valid word
↓
append
↓
recurse
```

problem.

The important skill is recognizing that **generation problems are backtracking when multiple valid continuations must be explored**.

---

# ⭐ 170 — Minimum Cuts for Palindrome Partition

Earlier:

```text id="e8v5sj"
Generate palindrome partitions
```

Now:

```text id="7w4h5r"
Find minimum cuts
```

So we move from:

```text id="e4wzlo"
generation
```

to:

```text id="3w1w0m"
optimization
```

This is extremely important before DP.

---

# 🟧 Q — ADVANCED CONSTRAINT + PRUNING

Problems **171–180** from the source are explicitly the next advanced set.

|       # | Problem                           | Platform          | Difficulty | OA Value | Status |  R1 |  R2 |  R3 |  R4 |  R5 |   |   |   |
| ------: | --------------------------------- | ----------------- | :--------: | :------: | :----: | :-: | :-: | :-: | :-: | :-: | - | - | - |
| **171** | K-th Subset                       | Interview         |     🔴     |   ⭐⭐⭐⭐   |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |   |   |   |
| **172** | K-th Permutation                  | LeetCode 60       |     🔴     |   ⭐⭐⭐⭐⭐  |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |   |   |   |
| **173** | Pattern → String Mapping          | Interview         |     🔴     |   ⭐⭐⭐⭐   |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  | ⬜ | ⬜ |   |
| **174** | Word Pattern Matching             | Interview         |     🔴     |   ⭐⭐⭐⭐⭐  |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  | ⬜ | ⬜ |   |
| **175** | Remove Invalid Parentheses        | LeetCode 301      |     🔴     |   ⭐⭐⭐⭐⭐  |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  | ⬜ | ⬜ |   |
| **176** | Generate Valid IP Variants        | LeetCode 93 style |     🟡     |   ⭐⭐⭐⭐   |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  | ⬜ | ⬜ |   |
| **177** | Constraint Placement Problem      | Interview         |     🔴     |   ⭐⭐⭐⭐   |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  | ⬜ | ⬜ | ⬜ |
| **178** | Partition Array Under Constraints | Interview         |     🔴     |   ⭐⭐⭐⭐⭐  |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  | ⬜ | ⬜ | ⬜ |
| **179** | Constraint Puzzle                 | Interview         |     🔴     |   ⭐⭐⭐⭐   |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  | ⬜ | ⬜ | ⬜ |
| **180** | Recursive Search With Pruning     | Interview         |     🔴     |   ⭐⭐⭐⭐⭐  |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  | ⬜ | ⬜ | ⬜ |

---

# 🔥 171 — K-th Subset

You already know:

```text id="1vibm7"
generate all subsets
```

Now:

```text id="d0u7fa"
only need K-th
```

The important concept:

```text id="nq5t7c"
Can I skip entire branches?
```

That is **search-space reduction**.

---

# 🔥 173 — Pattern → String Mapping

Example concept:

```text id="4k7v6b"
pattern:
abba

string:
redbluebluered
```

Need:

```text id="x3m8j4"
a → red
b → blue
```

Constraints:

```text id="2m3i4h"
mapping must be consistent
```

This is excellent interview-style backtracking.

---

# 🔥 174 — Word Pattern Matching

Similar idea, but now the mapping itself becomes the recursive state.

You must track:

```text id="7v72nq"
patternIndex
stringIndex
mapping
usedWords
```

This teaches **multiple pieces of state simultaneously**.

---

# 🔥 175 — Remove Invalid Parentheses

Instead of:

```text id="qg5p5r"
Generate valid parentheses
```

we start with an invalid string and search for:

> What should I remove?

At each position:

```text id="u7a9zo"
REMOVE
OR
KEEP
```

Then prune duplicates and invalid states.

This is a very important OA pattern:

```text id="y50v7n"
KEEP / REMOVE
+
VALIDITY
+
DEDUPLICATION
+
PRUNING
```

---

# 🔥 177–180 — Pure OA Thinking

These are deliberately generic constraint/backtracking patterns from the master source.

The goal is no longer:

> "Can I solve this exact LeetCode problem?"

It becomes:

> **"Can I construct the state, choices, constraint and pruning logic for a new problem?"**

---

# 🧠 PART 2.5 — PATTERN EVOLUTION

```text id="6d1q3x"
161
Bucket Assignment
      ↓
162
Bucket Assignment + Equality
      ↓
163
All Valid Segmentations
      ↓
164
Partition at Every Position
      ↓
165
Wildcard Branching
      ↓
166
Pattern/State Matching
      ↓
167
Digit Constraint Satisfaction
      ↓
168
Multi-Direction Search
      ↓
169
Sentence Generation
      ↓
170
Optimization
      ↓
========================
171
K-th Search
      ↓
172
K-th Permutation
      ↓
173
Pattern Mapping
      ↓
174
String Mapping
      ↓
175
Remove / Keep
      ↓
176
Valid Partitioning
      ↓
177–180
Constraint + Pruning
```

---

# 🎯 THE BIGGEST SKILL OF PART 2.5

You should now stop thinking:

```text id="0y8av8"
"What code template is this?"
```

and start thinking:

```text id="6sgw5c"
STATE
 ↓
CHOICES
 ↓
CONSTRAINT
 ↓
PRUNING
 ↓
RECURSE
 ↓
UNDO
```

---

# 🧠 PRUNING

Suppose you have:

```text
target = 10
current = 17
```

There is no reason to continue.

```java
if (current > target) {
    return;
}
```

That's pruning.

Another example:

```java
if (!isSafe(choice)) {
    continue;
}
```

Again:

```text
INVALID BRANCH
      ↓
STOP EARLY
```

---

# 🔥 THREE LEVELS OF BACKTRACKING

| Level          | Structure                                      |
| -------------- | ---------------------------------------------- |
| **Basic**      | Choose → Recurse → Undo                        |
| **Constraint** | Choose → Validate → Recurse → Undo             |
| **Advanced**   | Choose → Validate → **Prune** → Recurse → Undo |

Part 2.5 is where you should become comfortable with **Level 3**.

---

# ⚠️ COMMON MISTAKES

```text id="v5x4b0"
❌ No pruning

❌ Pruning too late

❌ Wrong constraint

❌ Forgetting undo

❌ Shared mutable state

❌ Duplicate answers

❌ Incorrect bucket state

❌ Wrong mapping restoration

❌ Not tracking visited state

❌ Confusing generation with optimization
```

---

# 🏆 MUST-MASTER PROBLEMS

If you need a high-priority revision set:

```text id="0qklp1"
161  Partition to K Equal Sum Subsets
162  Matchsticks to Square
163  Word Break II
165  Wildcard Matching
166  Regex Matching
167  Cryptarithmetic
168  Boggle
170  Minimum Palindrome Cuts

173  Pattern → String
174  Word Pattern
175  Remove Invalid Parentheses
178  Partition Under Constraints
180  Recursive Search + Pruning
```

But because your goal is **mastery once**, complete all 20.

---

# 🧪 PART 2.5 FINAL TEST

Before Part 2.6, you should be able to solve these without looking at code:

```text
161 → K equal subsets
162 → Matchsticks square
163 → Word Break II
165 → Wildcard matching
167 → Cryptarithmetic
168 → Boggle
170 → Minimum cuts

171 → K-th subset
173 → Pattern mapping
174 → Word pattern
175 → Remove invalid parentheses
178 → Constraint partition
180 → Pruning
```

For every problem, answer:

```text
1. What is my STATE?
2. What are my CHOICES?
3. What is my CONSTRAINT?
4. What can I PRUNE?
5. What changes after choosing?
6. What must I UNDO?
7. What is my BASE CASE?
8. Is this generation, counting, decision, or optimization?
9. What is the branching factor?
10. What is the worst-case complexity?
```

---

# 🔒 MASTER ROADMAP

| Part            |       Range | Focus                                   | Problems |
| --------------- | ----------: | --------------------------------------- | -------: |
| Part 1          |     001–060 | Foundation Recursion                    |       60 |
| Part 2.1        |     061–085 | Mathematical → Take/Not-Take            |       25 |
| Part 2.2        |     086–110 | Take/Not-Take → Permutation/Combination |       25 |
| Part 2.3        |     111–135 | Advanced Choice → Expression/Partition  |       25 |
| Part 2.4        |     136–160 | Grid/Maze/Chessboard                    |       25 |
| **👉 Part 2.5** | **161–180** | **Constraint + Advanced Backtracking**  |   **20** |
| Part 2.6        |     181–200 | Advanced OA + Final Mastery             |       20 |

**Part 2.5 is locked: `161–180`.**
# 📖 PART 2.6 — FINAL ADVANCED RECURSION + BACKTRACKING

I rechecked the master list before giving this. **Part 2.6 must remain exactly `181–200`**; it should not introduce a new numbering range or overlap Part 2.5. The source confirms the advanced section starts at 181 and ends at 200.

---

# 🎯 PART 2.6 GOAL

This is **not about learning another basic recursion pattern**.

You now combine:

```text
Recursion
   ↓
State
   ↓
Choices
   ↓
Constraint
   ↓
Backtracking
   ↓
Pruning
   ↓
Optimization
   ↓
Advanced OA
```

The goal is:

> **Given an unfamiliar recursion/backtracking OA problem, independently construct the solution instead of recognizing only a memorized problem.**

---

# 📊 PART 2.6 MASTER TRACKER

| Pattern                           | Problems |       Range | Status |
| --------------------------------- | -------: | ----------: | :----: |
| **R — Advanced Recursive Search** |       10 |     181–190 |    ⬜   |
| **S — Advanced OA Backtracking**  |        9 |     191–199 |    ⬜   |
| **T — Final Master Revision**     |        1 |         200 |    ⬜   |
| **TOTAL**                         |   **20** | **181–200** |    ⬜   |

### Revision

| Revision | Timing   |
| -------- | -------- |
| R0       | Same day |
| R1       | Day 1    |
| R2       | Day 3    |
| R3       | Day 7    |
| R4       | Day 15   |
| R5       | Day 30   |

---

# 🟥 PATTERN R — ADVANCED RECURSIVE SEARCH

## Problems 181–190

These are the exact advanced variants in the master source.

|       # | Problem                                             | Platform / Source     | Difficulty | OA Value | Status |  R1 |  R2 |  R3 |  R4 |  R5 |   |   |
| ------: | --------------------------------------------------- | --------------------- | :--------: | :------: | :----: | :-: | :-: | :-: | :-: | :-: | - | - |
| **181** | Longest Path in a Matrix Using Recursion            | Interview             |     🔴     |   ⭐⭐⭐⭐⭐  |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |   |   |
| **182** | Maximum Score Path via Recursive Search             | Interview             |     🔴     |   ⭐⭐⭐⭐⭐  |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  | ⬜ |   |
| **183** | Enumerate All Topological Orders Recursively        | Advanced OA           |     🔴     |   ⭐⭐⭐⭐⭐  |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  | ⬜ | ⬜ |
| **184** | Generate All Subsets With Constrained Sum           | Advanced Backtracking |     🔴     |   ⭐⭐⭐⭐⭐  |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  | ⬜ | ⬜ |
| **185** | Generate All Permutations With Adjacency Constraint | Advanced Backtracking |     🔴     |   ⭐⭐⭐⭐⭐  |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  | ⬜ | ⬜ |
| **186** | Find All Hamiltonian Tours                          | Advanced Backtracking |     🔴     |   ⭐⭐⭐⭐⭐  |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  | ⬜ | ⬜ |
| **187** | Solve Maze With Multiple Exits                      | Advanced Backtracking |     🔴     |   ⭐⭐⭐⭐   |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  | ⬜ | ⬜ |
| **188** | Recursive String Decoding                           | LeetCode 394 style    |     🟡     |   ⭐⭐⭐⭐⭐  |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  | ⬜ | ⬜ |
| **189** | Recursive Path Enumeration in a Tree-Like Grid      | Advanced OA           |     🔴     |   ⭐⭐⭐⭐   |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  | ⬜ | ⬜ |
| **190** | Minimum Edit-Like Recursive Search                  | Advanced OA           |     🔴     |   ⭐⭐⭐⭐⭐  |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  | ⬜ | ⬜ |

---

# 🧠 Pattern R — What You Must Learn

### 181–182

```text
RECURSION
+
GRID
+
MAXIMUM
```

You should recognize:

```text
best =
max(all possible recursive choices)
```

---

### 183

```text
GRAPH
+
AVAILABLE CHOICES
+
ORDER
+
BACKTRACKING
```

Mental model:

```text
Find currently valid nodes
        ↓
choose one
        ↓
update dependency state
        ↓
recurse
        ↓
restore
```

---

### 184

```text
SUBSET
+
SUM CONSTRAINT
+
PRUNING
```

---

### 185

```text
PERMUTATION
+
ADJACENCY CONSTRAINT
+
PRUNING
```

---

### 186

```text
GRAPH
+
VISITED
+
PATH
+
BACKTRACKING
```

---

### 187

```text
GRID
+
MULTIPLE DESTINATIONS
+
PATH ENUMERATION
```

---

### 188

```text
STRING
+
NESTED STATE
+
RECURSION
```

Example:

```text
3[a2[c]]
```

---

### 189

```text
TREE / GRID
+
PATH CONSTRUCTION
+
RECURSIVE ENUMERATION
```

---

### 190

```text
STATE
+
MULTIPLE OPERATIONS
+
COST
+
MINIMUM
```

This is an important bridge toward **DP-style thinking**.

---

# 🟧 PATTERN S — ADVANCED OA BACKTRACKING

## Problems 191–199

The source explicitly lists these as advanced backtracking/OA variants.

|       # | Problem                                      | Platform / Source     | Difficulty | OA Value | Status |  R1 |  R2 |  R3 |  R4 |  R5 |   |   |
| ------: | -------------------------------------------- | --------------------- | :--------: | :------: | :----: | :-: | :-: | :-: | :-: | :-: | - | - |
| **191** | All Valid Schedule Arrangements              | Advanced Backtracking |     🔴     |   ⭐⭐⭐⭐⭐  |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |   |   |
| **192** | Recursive Packing / Bin Selection            | Advanced OA           |     🔴     |   ⭐⭐⭐⭐⭐  |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  | ⬜ |   |
| **193** | Recursive Board Filling Problems             | Advanced Backtracking |     🔴     |   ⭐⭐⭐⭐   |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  | ⬜ | ⬜ |
| **194** | Recursively Count All Valid Arrangements     | Advanced OA           |     🔴     |   ⭐⭐⭐⭐⭐  |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  | ⬜ | ⬜ |
| **195** | Recursively Generate Constrained Passwords   | Advanced OA           |     🔴     |   ⭐⭐⭐⭐   |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  | ⬜ | ⬜ |
| **196** | Recursive Subset Partition Under Cost Limit  | Advanced OA           |     🔴     |   ⭐⭐⭐⭐⭐  |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  | ⬜ | ⬜ |
| **197** | Recursive Combination With Forbidden Pairs   | Advanced OA           |     🔴     |   ⭐⭐⭐⭐⭐  |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  | ⬜ | ⬜ |
| **198** | Recursive Placement Problem With Rules       | Advanced OA           |     🔴     |   ⭐⭐⭐⭐   |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  | ⬜ | ⬜ |
| **199** | Recursive Optimization With Choice + Pruning | Advanced OA           |     🔴     |   ⭐⭐⭐⭐⭐  |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  | ⬜ | ⬜ |

---

# 🔥 THE IMPORTANT PART — 191–199

These problems are deliberately **generic OA patterns**.

You should not memorize:

```java
solve191()
solve192()
solve193()
```

Instead, for every one you should identify:

```text
1. STATE
2. CHOICES
3. BASE CASE
4. CONSTRAINT
5. PRUNING
6. RECURSIVE CALL
7. UNDO
8. ANSWER TYPE
9. COMPLEXITY
```

---

# 🧠 MASTER BACKTRACKING TEMPLATE

By this point you should naturally think:

```text
             STATE
               ↓
          BASE CASE?
               ↓
        GENERATE CHOICES
               ↓
        CHECK CONSTRAINT
               ↓
           PRUNE?
          /      \
        YES       NO
        ↓          ↓
      STOP       CHOOSE
                   ↓
                RECURSE
                   ↓
                  UNDO
                   ↓
             NEXT CHOICE
```

For optimization:

```text
candidate
   ↓
compare with best
   ↓
update best
```

---

# 🟨 T — PROBLEM 200

## 🏆 FULL BACKTRACKING MASTER REVISION

Problem 200 is specifically the **Full Backtracking Master Revision Set** in the source.

This should **NOT** be another normal problem.

It is your **final exam**.

---

# 🧪 PROBLEM 200 — FINAL EXAM STRUCTURE

You must take unseen problems and classify them into:

| Pattern               | Recognition                |
| --------------------- | -------------------------- |
| Linear recursion      | One recursive continuation |
| Two-pointer recursion | Left + right               |
| Branching             | Multiple recursive calls   |
| Take / Not-Take       | Include / exclude          |
| Subsequence           | Keep / skip                |
| Subset                | Selection                  |
| Combination           | Selection without ordering |
| Permutation           | Ordering                   |
| Partition             | Split at positions         |
| Expression            | Operator choices           |
| Grid                  | Direction choices          |
| Maze                  | Path + visited             |
| Constraint            | Validity check             |
| Backtracking          | Choose → recurse → undo    |
| Pruning               | Reject impossible branch   |
| Optimization          | Min / max                  |
| Advanced OA           | Multiple patterns combined |

---

# 🎯 YOUR FINAL 10-SECOND CHECK

When you see an unfamiliar OA:

```text
WHAT IS MY STATE?
        ↓
WHAT CAN I CHOOSE?
        ↓
WHAT MAKES A CHOICE INVALID?
        ↓
CAN I PRUNE?
        ↓
WHAT DO I UNDO?
        ↓
WHAT DO I RETURN?
```

If you can answer those six questions, **you can construct the recursion**.

---

# 📊 COMPLETE 200-PROBLEM MASTER TRACK

| Part         |       Range | Focus                             |   Count |
| ------------ | ----------: | --------------------------------- | ------: |
| Part 1       | **001–060** | Recursion Foundation              |      60 |
| Part 2.1     | **061–085** | Advanced Traversal / Choices      |      25 |
| Part 2.2     | **086–110** | Branching / Selection             |      25 |
| Part 2.3     | **111–135** | Partition / Expression            |      25 |
| Part 2.4     | **136–160** | Grid / Maze / Chessboard          |      25 |
| Part 2.5     | **161–180** | Constraint / Pruning              |      20 |
| **Part 2.6** | **181–200** | **Advanced OA + Master Revision** |  **20** |
| **TOTAL**    | **001–200** | **Recursion + Backtracking**      | **200** |

The master source explicitly says these problems span patterns used in LeetCode, GeeksforGeeks, HackerRank, CodeStudio, Codility-style OAs, and company OA variants.

---

# 🔒 FINAL RULE FOR THIS TRACK

After **Problem 200**, we **do not keep adding random recursion questions**.

We switch to:

```text
200 Problems
      ↓
Solve from memory
      ↓
R0 → R1 → R2 → R3 → R4 → R5
      ↓
Unseen OA
      ↓
Pattern Recognition
      ↓
Recursion / Backtracking
      ↓
DP
```
# 🧠 RECURSION + BACKTRACKING — FINAL REVISION SHEET

> **Use this only AFTER completing all 200 problems.**
>
> Goal: You should be able to look at an unfamiliar OA/interview problem and **derive the recursion yourself**, not memorize solutions.

---

# 1. 🧠 THE CORE RECURSION MODEL

Every recursive problem starts with:

```text
STATE
  ↓
BASE CASE
  ↓
CURRENT WORK
  ↓
RECURSIVE CALL
```

Ask:

```text
1. What is changing?
2. What should the recursive function remember?
3. When should recursion stop?
4. What work happens at the current state?
5. What smaller state should I call?
```

### Universal structure

```java
returnType solve(State state) {

    if (baseCase) {
        return answer;
    }

    // Current Work

    return solve(smallerState);
}
```

---

# 2. 🔥 RECURSION FAITH

The most important rule:

> **Trust the recursive call to solve the smaller problem.**

Think:

```text
solve(n)
    ↓
"solve(n - 1) will correctly solve the rest"
    ↓
I only handle current work
```

Never mentally execute the entire recursion at once.

---

# 3. 🛑 BASE CASE

### Common base cases

| Problem type      | Base case               |
| ----------------- | ----------------------- |
| Array traversal   | `idx >= arr.length`     |
| String traversal  | `idx >= str.length()`   |
| Number recursion  | `n == 0` / `n == 1`     |
| Reverse traversal | `idx < 0`               |
| Two pointers      | `left >= right`         |
| Tree              | `node == null`          |
| Grid              | out of bounds / invalid |
| Subset            | `idx == n`              |
| Permutation       | `path.size() == n`      |
| Parentheses       | required length reached |
| Backtracking      | complete valid state    |

### Golden rule

```text
If current state cannot continue
→ STOP.
```

---

# 4. 📈 RECURSION DIRECTION

## Forward

```text
0 → 1 → 2 → 3 → ...
```

```java
solve(arr, idx + 1);
```

## Backward

```text
n → n-1 → n-2 → ...
```

```java
solve(arr, idx - 1);
```

## Jump

```text
0 → k → 2k → 3k
```

```java
solve(arr, idx + k, k);
```

## Two pointers

```text
left →        ← right
```

```java
solve(arr, left + 1, right - 1);
```

---

# 5. 🧩 RETURN-VALUE RECURSION

When the question asks:

```text
sum
count
minimum
maximum
boolean
```

think:

```text
current contribution
+
recursive answer
```

### Sum

```java
return arr[idx] + sum(arr, idx + 1);
```

### Count

```java
return 1 + count(arr, idx + 1);
```

### Maximum

```java
return Math.max(arr[idx], max(arr, idx + 1));
```

### Boolean

```java
return currentCondition || solve(...);
```

---

# 6. 🔄 TWO-POINTER RECURSION

Recognition:

```text
Palindrome
Reverse
Mirror
Symmetry
Compare ends
```

Mental model:

```text
L →        ← R
```

Template:

```java
boolean solve(String s, int left, int right) {

    if (left >= right) {
        return true;
    }

    if (s.charAt(left) != s.charAt(right)) {
        return false;
    }

    return solve(s, left + 1, right - 1);
}
```

---

# 7. 🌳 BRANCHING RECURSION

One call:

```text
        solve
          |
        solve
```

Branching:

```text
          solve
         /     \
     solve     solve
```

Recognition:

```text
Fibonacci
Choices
Ways
Paths
Take / Skip
```

---

# 8. 🟦 TAKE / NOT-TAKE

One of the most important patterns.

```text
             element
            /       \
         TAKE       SKIP
```

Typical problems:

```text
Subsets
Subsequences
Subset sum
Combination choices
```

Template:

```java
solve(idx + 1, path + current);
solve(idx + 1, path);
```

---

# 9. 🟩 SUBSET VS SUBSEQUENCE VS SUBSTRING

| Concept         | Meaning                  |
| --------------- | ------------------------ |
| **Subset**      | Choose elements          |
| **Subsequence** | Preserve original order  |
| **Substring**   | Continuous portion       |
| **Subarray**    | Continuous array portion |
| **Permutation** | Ordering matters         |

### Recognition

```text
Choose / don't choose
        ↓
Subset / Subsequence
```

```text
Rearrange
        ↓
Permutation
```

```text
Continuous
        ↓
Substring / Subarray
```

---

# 10. 🔀 PERMUTATION

Recognition:

> **Use every element, but order matters.**

Example:

```text
ABC
```

```text
ABC
ACB
BAC
BCA
CAB
CBA
```

Mental model:

```text
Choose ANY unused element
        ↓
Recurse
        ↓
Undo
```

Usually:

```java
boolean[] used;
```

---

# 11. 🟨 COMBINATION

Recognition:

> Choose elements without caring about their ordering.

Typical state:

```java
start
```

Mental model:

```text
start
 ↓
choose i
 ↓
recurse from i + 1
```

Difference:

```text
Permutation → used[]
Combination → start
```

---

# 12. 🔁 DUPLICATES

When duplicate results are possible:

```text
sort first
```

Then often:

```java
if (i > start && arr[i] == arr[i - 1]) {
    continue;
}
```

Mental rule:

> **Same level + same value → usually skip duplicate choice.**

---

# 13. 🔥 BACKTRACKING

The fundamental pattern:

```text
CHOOSE
  ↓
RECURSE
  ↓
UNDO
```

Example:

```java
path.add(x);

backtrack(...);

path.remove(path.size() - 1);
```

### The undo step is essential.

---

# 14. 🧠 ADVANCED BACKTRACKING

Part 2.3 onward adds:

```text
CHOOSE
 ↓
VALIDATE
 ↓
RECURSE
 ↓
UNDO
```

Then:

```text
CHOOSE
 ↓
VALIDATE
 ↓
PRUNE
 ↓
RECURSE
 ↓
UNDO
```

This is the key difference between basic recursion and advanced backtracking.

---

# 15. ✂️ PRUNING

Pruning means:

> **Stop exploring a branch that cannot produce a valid answer.**

Examples:

```java
if (sum > target) {
    return;
}
```

```java
if (!isSafe(row, col)) {
    return;
}
```

```java
if (currentCost >= best) {
    return;
}
```

Mental model:

```text
Impossible branch
       ↓
STOP EARLY
```

---

# 16. 🧩 PARTITION RECURSION

Recognition:

```text
Split
Partition
Divide
Break string
Choose cut
```

Mental model:

```text
start
 ↓
try every ending position
 ↓
validate current part
 ↓
recurse on remaining part
```

Examples:

```text
Palindrome Partitioning
Restore IP
Word Break
Expression problems
```

---

# 17. 🧮 EXPRESSION RECURSION

Recognition:

```text
Insert operators
Evaluate expressions
Parenthesize expression
Reach target
```

State may contain:

```text
index
current value
previous operand
expression
target
```

Mental model:

```text
Choose next number
        ↓
Choose operator
        ↓
Recurse
```

---

# 18. 🟣 PARENTHESES

For valid parentheses:

```text
open < n
```

and:

```text
close < open
```

Mental model:

```text
Can I add '(' ?
Can I add ')' ?
```

But:

```text
Never allow close > open
```

---

# 19. 🟫 GRID RECURSION

State:

```text
(row, col)
```

Directions commonly:

```text
       UP
        ↑
LEFT ← CELL → RIGHT
        ↓
      DOWN
```

Template:

```java
solve(row - 1, col);
solve(row + 1, col);
solve(row, col - 1);
solve(row, col + 1);
```

---

# 20. 🧭 GRID BACKTRACKING

Typical structure:

```text
Check boundary
      ↓
Check obstacle
      ↓
Check visited
      ↓
Mark
      ↓
Explore
      ↓
Unmark
```

Important:

```java
visited[row][col] = true;

solve(...);

visited[row][col] = false;
```

---

# 21. 🔎 WORD SEARCH

State:

```text
row
col
wordIndex
visited
```

Recognition:

```text
Find word in matrix
Adjacent cells
Cannot reuse same cell
```

Pattern:

```text
MATCH
 ↓
MARK
 ↓
SEARCH NEIGHBORS
 ↓
UNMARK
```

---

# 22. 👑 N-QUEENS

Recognition:

```text
Place objects
No two can conflict
```

Pattern:

```text
Choose position
 ↓
Is safe?
 ↓
Place
 ↓
Recurse
 ↓
Remove
```

Constraints:

```text
column
diagonal
row
```

---

# 23. 🧩 SUDOKU

At every empty cell:

```text
try 1
try 2
try 3
...
try 9
```

For every candidate:

```text
valid?
 ↓
YES
 ↓
place
 ↓
recurse
 ↓
failure?
 ↓
remove
```

This is:

```text
Constraint Satisfaction
+
Backtracking
```

---

# 24. 🎨 GRAPH COLORING

State:

```text
current vertex
color assignments
```

Choices:

```text
Color 1
Color 2
...
Color K
```

Constraint:

```text
Adjacent vertices
cannot have same color.
```

Pattern:

```text
TRY
 ↓
VALIDATE
 ↓
RECURSE
 ↓
UNDO
```

---

# 25. 🛣️ HAMILTONIAN PATH / CYCLE

Recognition:

> Visit every vertex exactly once.

State:

```text
current vertex
visited[]
path
```

Pattern:

```text
choose unvisited neighbor
        ↓
safe?
        ↓
recurse
        ↓
undo
```

---

# 26. 🪣 BUCKET / PARTITION PROBLEMS

Examples:

```text
Partition to K Equal Sum Subsets
Matchsticks to Square
```

Mental model:

```text
element
   ↓
which bucket?
 /  |  \
B1  B2  B3
```

Constraint:

```text
bucketSum <= target
```

Advanced pruning:

```text
if current bucket is already impossible:
    return;
```

---

# 27. 🗺️ STRING MAPPING

Examples:

```text
Pattern → String
Word Pattern Matching
```

State:

```text
patternIndex
stringIndex
mapping
used strings
```

Core rule:

> Once a mapping is created, future occurrences must respect the same mapping.

---

# 28. 🔐 CONSTRAINT SATISFACTION

General pattern:

```text
STATE
 ↓
TRY CHOICE
 ↓
CONSTRAINT CHECK
 ↓
INVALID → PRUNE
 ↓
VALID
 ↓
RECURSE
 ↓
UNDO
```

Examples:

```text
Sudoku
N-Queens
Cryptarithmetic
Graph Coloring
Scheduling
Packing
Pattern Mapping
```

---

# 29. ⚡ GENERATION VS COUNTING VS DECISION VS OPTIMIZATION

Always identify what the question asks.

| Type           | Return            |
| -------------- | ----------------- |
| **Generation** | All answers       |
| **Decision**   | `true / false`    |
| **Counting**   | Number of answers |
| **Minimum**    | Smallest          |
| **Maximum**    | Largest           |
| **K-th**       | Specific answer   |

Same recursion can often be modified to answer different question types.

---

# 30. 🧠 RECURSION TREE

For:

```text
F(n) = F(n-1) + F(n-2)
```

think:

```text
             F(n)
            /    \
        F(n-1)   F(n-2)
        /   \
   F(n-2) F(n-3)
```

Ask:

```text
How many children?
How deep?
Are subproblems repeated?
```

---

# 31. ⏱️ COMPLEXITY CHEAT SHEET

### Linear recursion

```text
T(n) = T(n-1) + O(1)

Time  → O(n)
Space → O(n)
```

### Two-pointer

```text
n / 2 calls

Time  → O(n)
Space → O(n)
```

### Binary branching

Often:

```text
Time → O(2^n)
Space → O(n)
```

### Permutations

```text
n!
```

Approximately:

```text
Time → O(n!)
```

with additional work depending on output construction.

### Grid backtracking

Often exponential in path length.

### Important

> **Do not blindly memorize complexity. Analyze the recursion tree and work per node.**

---

# 32. 🔥 RECURSION → BACKTRACKING → DP

This progression is extremely important.

```text
Recursion
   ↓
Repeated subproblems?
   ↓
YES
   ↓
Memoization
   ↓
DP
```

Whereas:

```text
Recursion
   ↓
Multiple choices
   ↓
Need explore choices
   ↓
Backtracking
```

And:

```text
Backtracking
+
Repeated states
        ↓
Potential DP / memoization
```

---

# 33. 🧠 WHEN TO USE `idx`

Use:

```java
idx
```

when you are moving through a linear structure.

Examples:

```text
Array
String
Subsequence
Subset
```

---

# 34. 🧠 WHEN TO USE `start`

Use:

```java
start
```

when choices must move forward without reusing earlier positions.

Typical:

```text
Combination
Combination Sum
Subset selection
Partition choices
```

---

# 35. 🧠 WHEN TO USE `used[]`

Use:

```java
boolean[] used
```

when an element can be selected in different positions.

Typical:

```text
Permutation
Arrangement
Hamiltonian-style search
```

---

# 36. 🧠 WHEN TO USE `visited[][]`

Use when exploring a grid/path where a cell cannot be reused during the current path.

Typical:

```text
Maze
Word Search
Boggle
Path Enumeration
```

---

# 37. 🧠 WHEN TO USE `path`

Use `path` when the actual sequence must be constructed.

Examples:

```text
Subsets
Permutations
Combinations
Maze paths
Parentheses
Expressions
```

---

# 38. 🧠 WHEN TO USE ACCUMULATOR

Examples:

```java
sum
count
score
currentValue
```

Mental model:

```text
current state
+
accumulated information
```

---

# 39. 🚨 MOST COMMON MISTAKES

```text
❌ Wrong base case
❌ Wrong recursive direction
❌ Infinite recursion
❌ Forgetting return
❌ Using idx incorrectly
❌ Confusing index with value
❌ Wrong start index
❌ Forgetting k jump
❌ Missing undo
❌ Wrong visited restoration
❌ Duplicate answers
❌ Missing pruning
❌ Wrong state
❌ Wrong constraint
❌ Wrong complexity
```

---

# 40. 🧠 THE 10-SECOND OA METHOD

When you see an unfamiliar problem:

```text
STEP 1
What is changing?

        ↓

STEP 2
What is my STATE?

        ↓

STEP 3
What are my CHOICES?

        ↓

STEP 4
What is my BASE CASE?

        ↓

STEP 5
What makes a choice INVALID?

        ↓

STEP 6
Can I PRUNE?

        ↓

STEP 7
What do I CHOOSE?

        ↓

STEP 8
What do I UNDO?

        ↓

STEP 9
What do I RETURN?

        ↓

STEP 10
What is the COMPLEXITY?
```

---

# 🏆 200-PROBLEM MASTER MAP

|       Range | Pattern Family                         |
| ----------: | -------------------------------------- |
| **001–010** | Basic recursion                        |
| **011–020** | Current contribution                   |
| **021–030** | Recursive faith                        |
| **031–040** | Searching                              |
| **041–050** | Conditional recursion                  |
| **051–060** | Index Jump                             |
| **061–072** | Two Pointer                            |
| **073–085** | Branching                              |
| **086–100** | Take / Not-Take                        |
| **101–110** | Permutation / Combination              |
| **111–120** | Advanced permutation / combination     |
| **121–135** | Parentheses / Expression / Partition   |
| **136–140** | Expression / Partition mastery         |
| **141–146** | Maze / Grid / Word Search              |
| **147–154** | N-Queens / Sudoku / Graph Backtracking |
| **155–160** | Grid traversal                         |
| **161–170** | Constraint Backtracking                |
| **171–180** | Advanced Constraint + Pruning          |
| **181–190** | Advanced Recursive Search              |
| **191–199** | Advanced OA Backtracking               |
|     **200** | **Final Master Revision**              |

---

# 🔥 FINAL PATTERN RECOGNITION TABLE

| If you see...           | Immediately think...    |
| ----------------------- | ----------------------- |
| First/last              | Index / two pointer     |
| Every K                 | Index jump              |
| Palindrome              | Two pointer             |
| Reverse                 | Two pointer / recursion |
| All possibilities       | Branching               |
| Choose or skip          | Take / Not-Take         |
| Subset                  | Take / Not-Take         |
| Subsequence             | Take / Not-Take         |
| Rearrange               | Permutation             |
| Choose K                | Combination             |
| Duplicate combinations  | Sort + skip             |
| Generate parentheses    | Constraint branching    |
| Split string            | Partition               |
| Palindrome pieces       | Partition + validation  |
| Insert operators        | Expression recursion    |
| Find path in grid       | Grid DFS                |
| Find word in grid       | Backtracking            |
| Place queens            | Constraint backtracking |
| Fill Sudoku             | Constraint satisfaction |
| Color graph             | Graph backtracking      |
| Visit every vertex      | Hamiltonian             |
| Equal buckets           | Bucket backtracking     |
| Mapping pattern         | State + constraint      |
| "All valid..."          | Backtracking            |
| "Count all..."          | Branching + count       |
| "Minimum/maximum..."    | Optimization            |
| "K-th..."               | Search-space reduction  |
| "Cannot..." / "must..." | Constraint              |
| "Avoid impossible..."   | Pruning                 |

---

# 🧠 FINAL BACKTRACKING FORMULA

Memorize **this**, not 200 solutions:

```text
                 STATE
                   ↓
              BASE CASE?
                   ↓
             GENERATE CHOICES
                   ↓
             CHECK CONSTRAINT
                   ↓
                PRUNE?
              /        \
            YES         NO
            ↓            ↓
          STOP         CHOOSE
                         ↓
                      RECURSE
                         ↓
                        UNDO
                         ↓
                   NEXT CHOICE
```

---

# 🏁 FINAL MASTERY TEST

After completing all 200, take **10 completely unseen OA problems**.

For each problem, without searching for the solution, write:

```text
Problem:
__________

Pattern:
__________

State:
__________

Choices:
__________

Base Case:
__________

Constraint:
__________

Pruning:
__________

Recursive Call:
__________

Undo:
__________

Return:
__________

Time:
__________

Space:
__________
```

### Mastery target

```text
10/10 → Pattern recognized
10/10 → State identified
10/10 → Base case correct
10/10 → Recursive logic correct
10/10 → Complexity explained
```

If you can consistently do that, **you have achieved the actual goal of this 200-problem recursion + backtracking track**: solving unfamiliar recursion OAs by pattern and reasoning rather than memorization.
