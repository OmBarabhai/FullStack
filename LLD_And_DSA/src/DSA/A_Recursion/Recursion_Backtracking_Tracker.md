# Recursion + Backtracking — Clean Problem Tracker

> Pattern-wise tracker only. Keep the algorithm small; use the pattern to recall the solution.

## Revision

| Mark | When | What to do |
|---|---|---|
| R0 | Same day | Close notes → explain pattern + dry run |
| R1 | 2–3 days | Rebuild the recursion skeleton from memory |
| R2 | ~7 days | Solve/trace without notes |
| R3 | ~30 days | Quick recall; solve again only if weak |

**Revision rule:** strong problems rest; medium problems get another recall; weak problems repeat. Do not revise every problem the same number of times.

## Tracker Key

`☑️` completed  ·  `R1/R2/R3` = revision completed  ·  `🟢/🟡/🔴` = strong / medium / weak

## Roadmap

| Pattern |       Range | Focus                                |
|---------|------------:|--------------------------------------|
| **G**   | **061–080** | Mathematical / Number Recursion      |
| **H**   | **081–095** | Take / Not-Take                      |
| **I**   | **096–100** | Choice / Generation                  |
| **J**   | **101–110** | Permutation / Combination            |
| **K**   | **111–120** | Advanced Permutation / Combination   |
| **L**   | **121–140** | Parentheses / Expression / Partition |
| **M**   | **141–146** | Grid / Maze Backtracking             |
| **N**   | **147–154** | Chessboard / Constraint Backtracking |
| **O**   | **155–160** | Recursive Grid Traversal             |
| **P**   | **161–170** | Constraint Selection                 |
| **Q**   | **171–180** | Advanced Constraint + Pruning        |
| **R**   | **181–190** | Advanced Recursive Search            |
| **S**   | **191–199** | Advanced OA Backtracking             |
| **T**   |     **200** | Final mastery test                   |

---

# G — Mathematical / Number Recursion

**Problems 061–080**

### Small algorithm

```text
POWER / MATH / NUMBER → reduce the problem → recurse → combine/return
```

|   # | Problem                                        | Platform            | Status | R1 | R2 | R3 | Strength |
|----:|------------------------------------------------|---------------------|:------:|:--:|:--:|:--:|:--------:|
| 061 | Fast Exponentiation                            | LeetCode 50 / GFG   |   ☑️   | ⬜  | ⬜  | ⬜  |    —     |
| 062 | Multiply Two Numbers Recursively               | GFG                 |   ☑️   | ⬜  | ⬜  | ⬜  |    —     |
| 063 | Divide Two Numbers Recursively                 | GFG                 |   ☑️   | ⬜  | ⬜  | ⬜  |    —     |
| 064 | Calculate nCr Recursively                      | GFG                 |   ☑️   | ⬜  | ⬜  | ⬜  |    —     |
| 065 | Calculate nPr Recursively                      | GFG                 |   ☑️   | ⬜  | ⬜  | ⬜  |    —     |
| 066 | Pascal Triangle Row Recursively                | LeetCode 119 style  |   ☑️   | ⬜  | ⬜  | ⬜  |    —     |
| 067 | Tower of Hanoi                                 | GFG                 |   ☑️   | ⬜  | ⬜  | ⬜  |    —     |
| 068 | Josephus Problem                               | GFG / LeetCode 1823 |   ☑️   | ⬜  | ⬜  | ⬜  |    —     |
| 069 | Recursive Euclidean Algorithm                  | GFG                 |   ☑️   | ⬜  | ⬜  | ⬜  |    —     |
| 070 | Print All Divisors Recursively                 | GFG                 |   ☑️   | ⬜  | ⬜  | ⬜  |    —     |
| 071 | Prime Checking Recursively                     | GFG                 |   ☑️   | ⬜  | ⬜  | ⬜  |    —     |
| 072 | Sieve-Style Recursion Practice                 | Interview           |   ☑️   | ⬜  | ⬜  | ⬜  |    —     |
| 073 | Generate Binary Numbers Recursively            | GFG                 |   ☑️   | ⬜  | ⬜  | ⬜  |    —     |
| 074 | Generate Gray Code Recursively                 | LeetCode 89         |   ☑️   | ⬜  | ⬜  | ⬜  |    —     |
| 075 | Binary Representation Recursively              | GFG                 |   ☑️   | ⬜  | ⬜  | ⬜  |    —     |
| 076 | Decimal Representation from Binary Recursively | GFG                 |   ☑️   | ⬜  | ⬜  | ⬜  |    —     |
| 077 | Sum of Squares Recursively                     | GFG                 |   ☑️   | ⬜  | ⬜  | ⬜  |    —     |
| 078 | Sum of Cubes Recursively                       | GFG                 |   ☑️   | ⬜  | ⬜  | ⬜  |    —     |
| 079 | Alternating Sum Recursively                    | GFG                 |   ☑️   | ⬜  | ⬜  | ⬜  |    —     |
| 080 | Alternating Product Recursively                | Interview           |   ☑️   | ⬜  | ⬜  | ⬜  |    —     |

### Pattern memory
```text
Power / number / formula → reduce state → recurse → return
```

---

# H — Take / Not-Take

**Problems 081–095**

### Small algorithm

```text
For each element → TAKE → recurse OR SKIP → recurse
```

|   # | Problem                                  | Platform             | Status | R1 | R2 | R3 | Strength |
|----:|------------------------------------------|----------------------|:------:|:--:|:--:|:--:|:--------:|
| 081 | Print All Subsequences of an Array       | GFG                  |   ☑️   | ⬜  | ⬜  | ⬜  |    —     |
| 082 | Count Subsequences                       | GFG                  |   ☑️   | ⬜  | ⬜  | ⬜  |    —     |
| 083 | Print Subsequence With Sum K             | GFG                  |   ☑️   | ⬜  | ⬜  | ⬜  |    —     |
| 084 | Count Subsequences With Sum K            | GFG                  |   ☑️   | ⬜  | ⬜  | ⬜  |    —     |
| 085 | Print One Subsequence With Sum K         | GFG                  |   ☑️   | ⬜  | ⬜  | ⬜  |    —     |
| 086 | Check if a Subsequence With Sum K Exists | GFG                  |   ☑️   | ⬜  | ⬜  | ⬜  |    —     |
| 087 | Print All Subsets                        | LeetCode 78          |   ☑️   | ⬜  | ⬜  | ⬜  |    —     |
| 088 | Count Subsets                            | GFG                  |   ☑️   | ⬜  | ⬜  | ⬜  |    —     |
| 089 | Subset Sum                               | GFG / LC 416 variant |   ☑️   | ⬜  | ⬜  | ⬜  |    —     |
| 090 | Partition Into Two Equal Subsets         | LeetCode 416         |   ☑️   | ⬜  | ⬜  | ⬜  |    —     |
| 091 | Partition With Minimum Difference        | GFG                  |   ☑️   | ⬜  | ⬜  | ⬜  |    —     |
| 092 | Generate All Binary Strings of Length N  | GFG                  |   ☑️   | ⬜  | ⬜  | ⬜  |    —     |
| 093 | Binary Strings Without Consecutive 1s    | Interview            |   ☑️   | ⬜  | ⬜  | ⬜  |    —     |
| 094 | Binary Strings Without Consecutive 0s    | Interview            |   ☑️   | ⬜  | ⬜  | ⬜  |    —     |
| 095 | Binary Strings With Exactly K Ones       | Interview            |   ☑️   | ⬜  | ⬜  | ⬜  |    —     |

### Pattern memory
```text
TAKE + recurse
SKIP + recurse
```

---

# I — Choice / Generation

**Problems 096–100**

### Small algorithm

```text
At each position → try every valid choice → recurse
```

|   # | Problem                                     | Platform  | Status | R1 | R2 | R3 | Strength |
|----:|---------------------------------------------|-----------|:------:|:--:|:--:|:--:|:--------:|
| 096 | All Strings From Character Set `{a,b}`      | Interview |   ☑️   | ⬜  | ⬜  | ⬜  |    —     |
| 097 | All Strings From Digits `0–2`               | Interview |   ☑️   | ⬜  | ⬜  | ⬜  |    —     |
| 098 | Print All Choices From an Array Recursively | Interview |   ☑️   | ⬜  | ⬜  | ⬜  |    —     |
| 099 | Count Ways to Choose K Items                | GFG       |   ☑️   | ⬜  | ⬜  | ⬜  |    —     |
| 100 | Include/Exclude Subset Framework Practice   | Interview |   ☑️   | ⬜  | ⬜  | ⬜  |    —     |

### Pattern memory
```text
choice 1 → recurse
choice 2 → recurse
choice 3 → recurse
```

---

# J — Permutation / Combination

**Problems 101–110**

### Small algorithm

```text
Permutation: used[] → choose → recurse → undo | Combination: start → choose → recurse → undo
```

|   # | Problem                          | Platform     | Status | R1 | R2 | R3 | Strength |
|----:|----------------------------------|--------------|:------:|:--:|:--:|:--:|:--------:|
| 101 | Generate Permutations            | LeetCode 46  |   ☑️   | ⬜  | ⬜  | ⬜  |    —     |
| 102 | Generate Unique Permutations     | LeetCode 47  |   ☑️   | ⬜  | ⬜  | ⬜  |    —     |
| 103 | Permutations of a String         | GFG          |   ☑️   | ⬜  | ⬜  | ⬜  |    —     |
| 104 | Unique Permutations of a String  | GFG          |   ☑️   | ⬜  | ⬜  | ⬜  |    —     |
| 105 | Generate Combinations            | LeetCode 77  |   ☑️   | ⬜  | ⬜  | ⬜  |    —     |
| 106 | Combinations of Size K           | LeetCode 77  |   ☑️   | ⬜  | ⬜  | ⬜  |    —     |
| 107 | Combination Sum                  | LeetCode 39  |   ☑️   | ⬜  | ⬜  | ⬜  |    —     |
| 108 | Combination Sum II               | LeetCode 40  |   ☑️   | ⬜  | ⬜  | ⬜  |    —     |
| 109 | Combination Sum III              | LeetCode 216 |   ☑️   | ⬜  | ⬜  | ⬜  |    —     |
| 110 | Generate Subsets With Duplicates | LeetCode 90  |   ☑️   | ⬜  | ⬜  | ⬜  |    —     |

### Pattern memory
```text
Permutation → used[]
Combination → start index
Backtracking → CHOOSE → RECURSE → UNDO
```

---

# K — Advanced Permutation / Combination

**Problems 111–120**

### Small algorithm

```text
Expand the choice space → choose → recurse → undo
```

|   # | Problem                              | Platform          | Status | R1 | R2 | R3 | Strength |
|----:|--------------------------------------|-------------------|:------:|:--:|:--:|:--:|:--------:|
| 111 | Generate All Subsets                 | LeetCode 78       |   ☑️   | ⬜  | ⬜  | ⬜  |    —     |
| 112 | Generate All K-Subsets               | Interview-style   |   ☑️   | ⬜  | ⬜  | ⬜  |    —     |
| 113 | Subsets of a String                  | Interview-style   |   ☑️   | ⬜  | ⬜  | ⬜  |    —     |
| 114 | Letter Case Permutation              | LeetCode 784      |   ☑️   | ⬜  | ⬜  | ⬜  |    —     |
| 115 | Phone Keypad Combinations            | GFG / LeetCode 17 |   ☑️   | ⬜  | ⬜  | ⬜  |    —     |
| 116 | Generate All Abbreviations           | LeetCode 320      |   ☑️   | ⬜  | ⬜  | ⬜  |    —     |
| 117 | Permutation Sequence                 | LeetCode 60       |   ☑️   | ⬜  | ⬜  | ⬜  |    —     |
| 118 | K-th Permutation Using Recursion     | LeetCode 60       |   ☑️   | ⬜  | ⬜  | ⬜  |    —     |
| 119 | Print All Arrangements of Characters | Interview-style   |   ☑️   | ⬜  | ⬜  | ⬜  |    —     |
| 120 | Generate All Possible Passwords      | Interview-style   |   ☑️   | ⬜  | ⬜  | ⬜  |    —     |

### Pattern memory
```text
More choices, same backtracking core.
```

---

# L — Parentheses / Expression / Partition

**Problems 121–140**

### Small algorithm

```text
Choose a piece/operator → validate → recurse → undo
```

|                  # | Problem                                       | Platform             | Status | R1 | R2 | R3 | Strength |
|-------------------:|-----------------------------------------------|----------------------|:------:|:--:|:--:|:--:|:--------:|
|                121 | Generate Parentheses                          | LeetCode 22          |   ☑️   | ⬜  | ⬜  | ⬜  |    —     |
|                122 | Balanced Parentheses Generation               | GeeksforGeeks        |   ☑️   | ⬜  | ⬜  | ⬜  |    —     |
|            ~~123~~ | ~~Valid Parentheses Generation With K Pairs~~ | ~~LeetCode 22~~      |   ☑️   | ⬜  | ⬜  | ⬜  |    —     |
|                124 | Brace Expansion                               | LeetCode 1087 style  |   ☑️   | ⬜  | ⬜  | ⬜  |    —     |
|                125 | Expression Add Operators                      | LeetCode 282         |   ☑️   | ⬜  | ⬜  | ⬜  |    —     |
|                126 | Restore Valid IP Addresses                    | LeetCode 93          |   ☑️   | ⬜  | ⬜  | ⬜  |    —     |
|                127 | Palindrome Partitioning                       | LeetCode 131         |   ☑️   | ⬜  | ⬜  | ⬜  |    —     |
|                128 | All Possible Palindrome Partitions            | LeetCode 131         |   ☑️   | ⬜  | ⬜  | ⬜  |    —     |
|                129 | Split String Into Dictionary Words            | Word Break recursion |   ☑️   | ⬜  | ⬜  | ⬜  |    —     |
|            ~~130~~ | ~~Insert Operators to Reach Target~~          | ~~LeetCode 282~~     |   ☑️   | ⬜  | ⬜  | ⬜  |    —     |
|                131 | Generate All Valid Arithmetic Expressions     | Interview-style      |   ☑️   | ⬜  | ⬜  | ⬜  |    —     |
|                132 | Split String Into All Possible Parts          | Interview-style      |   ☑️   | ⬜  | ⬜  | ⬜  |    —     |
| **[133 ](GREEDY)** | **Partition Labels Via Recursion Idea**       | **Interview-style**  |   🔄   | ⬜  | ⬜  | ⬜  |    —     |
|                134 | Generate All Valid Bracket Sequences          | GFG                  |   ☑️   | ⬜  | ⬜  | ⬜  |    —     |
|                135 | Generate All Valid Expressions With + and -   | Interview-style      |   ☑️   | ⬜  | ⬜  | ⬜  |    —     |
|                136 | Expression Evaluation by Recursion            | Interview            |   ☑️   | ⬜  | ⬜  | ⬜  |    —     |
|                137 | Different Ways to Add Parentheses             | LeetCode 241         |   ☑️   | ⬜  | ⬜  | ⬜  |    —     |
|                138 | Boolean Expression Parenthesization           | GFG                  |   ☑️   | ⬜  | ⬜  | ⬜  |    —     |
|                139 | Count Valid Parenthesizations                 | GFG                  |   ⬜    | ⬜  | ⬜  | ⬜  |    —     |
|                140 | Generate All Sentence Splits                  | Interview            |   ⬜    | ⬜  | ⬜  | ⬜  |    —     |

### Pattern memory
```text
Choose split/operator → validate → recurse → undo
```

---

# M — Grid / Maze Backtracking

**Problems 141–146**

### Small algorithm

```text
row,col → try directions → validate → move → recurse → backtrack
```

|   # | Problem                   | Platform     | Status | R1 | R2 | R3 | Strength |
|----:|---------------------------|--------------|:------:|:--:|:--:|:--:|:--------:|
| 141 | Rat in a Maze             | GFG          |   ⬜    | ⬜  | ⬜  | ⬜  |    —     |
| 142 | Maze Paths                | GFG          |   ⬜    | ⬜  | ⬜  | ⬜  |    —     |
| 143 | Maze Paths with Obstacles | GFG          |   ⬜    | ⬜  | ⬜  | ⬜  |    —     |
| 144 | Count Maze Paths          | GFG          |   ⬜    | ⬜  | ⬜  | ⬜  |    —     |
| 145 | Word Search               | LeetCode 79  |   ⬜    | ⬜  | ⬜  | ⬜  |    —     |
| 146 | Word Search II            | LeetCode 212 |   ⬜    | ⬜  | ⬜  | ⬜  |    —     |

### Pattern memory
```text
(row,col) → direction → valid? → recurse → undo/mark
```

---

# N — Chessboard / Constraint Backtracking

**Problems 147–154**

### Small algorithm

```text
Place/choose → check constraint → recurse → undo
```

|   # | Problem                     | Platform    | Status | R1 | R2 | R3 | Strength |
|----:|-----------------------------|-------------|:------:|:--:|:--:|:--:|:--------:|
| 147 | N-Queens                    | LeetCode 51 |   ⬜    | ⬜  | ⬜  | ⬜  |    —     |
| 148 | N-Queens II                 | LeetCode 52 |   ⬜    | ⬜  | ⬜  | ⬜  |    —     |
| 149 | Sudoku Solver               | LeetCode 37 |   ⬜    | ⬜  | ⬜  | ⬜  |    —     |
| 150 | Knight's Tour               | GFG         |   ⬜    | ⬜  | ⬜  | ⬜  |    —     |
| 151 | Crossword Puzzle Solver     | GFG         |   ⬜    | ⬜  | ⬜  | ⬜  |    —     |
| 152 | Graph Coloring Backtracking | GFG         |   ⬜    | ⬜  | ⬜  | ⬜  |    —     |
| 153 | Hamiltonian Path            | Interview   |   ⬜    | ⬜  | ⬜  | ⬜  |    —     |
| 154 | Hamiltonian Cycle           | Interview   |   ⬜    | ⬜  | ⬜  | ⬜  |    —     |

### Pattern memory
```text
Place → safe? → recurse → remove
```

---

# O — Recursive Grid Traversal

**Problems 155–160**

### Small algorithm

```text
Visit cell → recurse to neighbours → combine/mark result
```

|   # | Problem                           | Platform       | Status | R1 | R2 | R3 | Strength |
|----:|-----------------------------------|----------------|:------:|:--:|:--:|:--:|:--------:|
| 155 | Flood Fill Recursive Backtracking | LeetCode 733   |   ⬜    | ⬜  | ⬜  | ⬜  |    —     |
| 156 | All Paths From Source to Target   | LeetCode 797   |   ⬜    | ⬜  | ⬜  | ⬜  |    —     |
| 157 | Unique Paths With Obstacles       | LeetCode 63    |   ⬜    | ⬜  | ⬜  | ⬜  |    —     |
| 158 | Path With Maximum Score           | Grid Recursion |   ⬜    | ⬜  | ⬜  | ⬜  |    —     |
| 159 | Count Islands Using Recursion     | LeetCode 200   |   ⬜    | ⬜  | ⬜  | ⬜  |    —     |
| 160 | Maximum Area of Island            | LeetCode 695   |   ⬜    | ⬜  | ⬜  | ⬜  |    —     |

### Pattern memory
```text
Visit → explore neighbours → combine result
```

---

# P — Constraint Selection

**Problems 161–170**

### Small algorithm

```text
Choose assignment → check constraint → recurse → undo; prune early
```

|   # | Problem                               | Platform           | Status | R1 | R2 | R3 | Strength |
|----:|---------------------------------------|--------------------|:------:|:--:|:--:|:--:|:--------:|
| 161 | Partition to K Equal Sum Subsets      | LeetCode 698       |   ⬜    | ⬜  | ⬜  | ⬜  |    —     |
| 162 | Matchsticks to Square                 | LeetCode 473       |   ⬜    | ⬜  | ⬜  | ⬜  |    —     |
| 163 | Word Break II                         | LeetCode 140       |   ⬜    | ⬜  | ⬜  | ⬜  |    —     |
| 164 | Scramble String                       | LeetCode 87        |   ⬜    | ⬜  | ⬜  | ⬜  |    —     |
| 165 | Wildcard Matching                     | LeetCode 44        |   ⬜    | ⬜  | ⬜  | ⬜  |    —     |
| 166 | Regular Expression Matching           | LeetCode 10        |   ⬜    | ⬜  | ⬜  | ⬜  |    —     |
| 167 | Cryptarithmetic Puzzle                | GFG / Interview    |   ⬜    | ⬜  | ⬜  | ⬜  |    —     |
| 168 | Boggle Word Search                    | GFG                |   ⬜    | ⬜  | ⬜  | ⬜  |    —     |
| 169 | Sentence Generation                   | Interview          |   ⬜    | ⬜  | ⬜  | ⬜  |    —     |
| 170 | Minimum Cuts for Palindrome Partition | LeetCode 132 / GFG |   ⬜    | ⬜  | ⬜  | ⬜  |    —     |

### Pattern memory
```text
Choose → constraint check → prune if impossible → recurse → undo
```

---

# Q — Advanced Constraint + Pruning

**Problems 171–180**

### Small algorithm

```text
Build state → choose → validate/prune → recurse → undo
```

|   # | Problem                           | Platform          | Status | R1 | R2 | R3 | Strength |
|----:|-----------------------------------|-------------------|:------:|:--:|:--:|:--:|:--------:|
| 171 | K-th Subset                       | Interview         |   ⬜    | ⬜  | ⬜  | ⬜  |    —     |
| 172 | K-th Permutation                  | LeetCode 60       |   ⬜    | ⬜  | ⬜  | ⬜  |    —     |
| 173 | Pattern → String Mapping          | Interview         |   ⬜    | ⬜  | ⬜  | ⬜  |    —     |
| 174 | Word Pattern Matching             | Interview         |   ⬜    | ⬜  | ⬜  | ⬜  |    —     |
| 175 | Remove Invalid Parentheses        | LeetCode 301      |   ⬜    | ⬜  | ⬜  | ⬜  |    —     |
| 176 | Generate Valid IP Variants        | LeetCode 93 style |   ⬜    | ⬜  | ⬜  | ⬜  |    —     |
| 177 | Constraint Placement Problem      | Interview         |   ⬜    | ⬜  | ⬜  | ⬜  |    —     |
| 178 | Partition Array Under Constraints | Interview         |   ⬜    | ⬜  | ⬜  | ⬜  |    —     |
| 179 | Constraint Puzzle                 | Interview         |   ⬜    | ⬜  | ⬜  | ⬜  |    —     |
| 180 | Recursive Search With Pruning     | Interview         |   ⬜    | ⬜  | ⬜  | ⬜  |    —     |

### Pattern memory
```text
Choose → constraint check → prune if impossible → recurse → undo
```

---

# R — Advanced Recursive Search

**Problems 181–190**

### Small algorithm

```text
Search state space → choose next state → recurse → reject/backtrack
```

|   # | Problem                                             | Platform              | Status | R1 | R2 | R3 | Strength |
|----:|-----------------------------------------------------|-----------------------|:------:|:--:|:--:|:--:|:--------:|
| 181 | Longest Path in a Matrix Using Recursion            | Interview             |   ⬜    | ⬜  | ⬜  | ⬜  |    —     |
| 182 | Maximum Score Path via Recursive Search             | Interview             |   ⬜    | ⬜  | ⬜  | ⬜  |    —     |
| 183 | Enumerate All Topological Orders Recursively        | Advanced OA           |   ⬜    | ⬜  | ⬜  | ⬜  |    —     |
| 184 | Generate All Subsets With Constrained Sum           | Advanced Backtracking |   ⬜    | ⬜  | ⬜  | ⬜  |    —     |
| 185 | Generate All Permutations With Adjacency Constraint | Advanced Backtracking |   ⬜    | ⬜  | ⬜  | ⬜  |    —     |
| 186 | Find All Hamiltonian Tours                          | Advanced Backtracking |   ⬜    | ⬜  | ⬜  | ⬜  |    —     |
| 187 | Solve Maze With Multiple Exits                      | Advanced Backtracking |   ⬜    | ⬜  | ⬜  | ⬜  |    —     |
| 188 | Recursive String Decoding                           | LeetCode 394 style    |   ⬜    | ⬜  | ⬜  | ⬜  |    —     |
| 189 | Recursive Path Enumeration in a Tree-Like Grid      | Advanced OA           |   ⬜    | ⬜  | ⬜  | ⬜  |    —     |
| 190 | Minimum Edit-Like Recursive Search                  | Advanced OA           |   ⬜    | ⬜  | ⬜  | ⬜  |    —     |

### Pattern memory
```text
State → choices → recursive search → backtrack
```

---

# S — Advanced OA Backtracking

**Problems 191–199**

### Small algorithm

```text
State → choices → constraints → prune → recurse → undo
```

|   # | Problem                                      | Platform              | Status | R1 | R2 | R3 | Strength |
|----:|----------------------------------------------|-----------------------|:------:|:--:|:--:|:--:|:--------:|
| 191 | All Valid Schedule Arrangements              | Advanced Backtracking |   ⬜    | ⬜  | ⬜  | ⬜  |    —     |
| 192 | Recursive Packing / Bin Selection            | Advanced OA           |   ⬜    | ⬜  | ⬜  | ⬜  |    —     |
| 193 | Recursive Board Filling Problems             | Advanced Backtracking |   ⬜    | ⬜  | ⬜  | ⬜  |    —     |
| 194 | Recursively Count All Valid Arrangements     | Advanced OA           |   ⬜    | ⬜  | ⬜  | ⬜  |    —     |
| 195 | Recursively Generate Constrained Passwords   | Advanced OA           |   ⬜    | ⬜  | ⬜  | ⬜  |    —     |
| 196 | Recursive Subset Partition Under Cost Limit  | Advanced OA           |   ⬜    | ⬜  | ⬜  | ⬜  |    —     |
| 197 | Recursive Combination With Forbidden Pairs   | Advanced OA           |   ⬜    | ⬜  | ⬜  | ⬜  |    —     |
| 198 | Recursive Placement Problem With Rules       | Advanced OA           |   ⬜    | ⬜  | ⬜  | ⬜  |    —     |
| 199 | Recursive Optimization With Choice + Pruning | Advanced OA           |   ⬜    | ⬜  | ⬜  | ⬜  |    —     |

### Pattern memory
```text
State → choices → constraints → prune → recurse → undo
```

---

# T — FINAL MASTERY TEST

**Problem 200 — Full Backtracking Master Revision**

Do not memorize a solution. Take an unseen problem and identify:

```text
STATE
  ↓
CHOICES
  ↓
VALIDITY / CONSTRAINT
  ↓
PRUNE?
  ↓
RECURSE
  ↓
UNDO
  ↓
RETURN
```

| Final check                                  | Done |
|----------------------------------------------|:----:|
| Recognize Take / Not-Take                    |  ⬜   |
| Recognize Subset / Combination / Permutation |  ⬜   |
| Recognize Partition / Expression             |  ⬜   |
| Handle Grid / Maze                           |  ⬜   |
| Handle Constraint Backtracking               |  ⬜   |
| Identify pruning opportunities               |  ⬜   |
| Explain recursion tree                       |  ⬜   |
| Estimate complexity                          |  ⬜   |

---

# Quick Pattern Recognition

| If you see...         | Think...                                |
|-----------------------|-----------------------------------------|
| Include / exclude     | **Take / Not-Take**                     |
| Generate subsets      | **Subset**                              |
| Order matters         | **Permutation + used[]**                |
| Order does not matter | **Combination + start**                 |
| Reuse allowed         | **Stay at same choice/index**           |
| No reuse              | **Move to next index**                  |
| Duplicate input       | **Sort + skip duplicates where needed** |
| Valid split           | **Partition recursion**                 |
| Valid parentheses     | **Constraint backtracking**             |
| Grid movement         | **row, col + directions**               |
| Place under rules     | **Constraint + pruning**                |
