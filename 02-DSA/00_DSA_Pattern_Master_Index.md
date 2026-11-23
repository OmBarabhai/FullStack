> **Active problem list:** [Three-Year DSA Interview Master Bank — Final 375 v4](00_DSA_Three_Year_Pattern_Wise_Final_Problem_Bank_v4.md) is the canonical problem schedule. Use this index for pattern navigation; do not maintain a competing problem list here.

# DSA Pattern Master Index — Interview Track

> **Language:** Java. **Scope:** Software engineering coding interviews, especially entry-level and SDE-1. This file is navigation; detailed explanations and your submitted code stay in the existing topic folders.

| Order | Pattern family | Recognition cue | Priority | Existing folder |
|---:|---|---|---|---|
| 01 | Arrays and Hashing | Lookup, duplicates, counts, grouping, index/value relationships | Core | `01-Arrays-Strings-and-Hashing` |
| 02 | Two Pointers and Partitioning | Pairs/triplets, sorted input, inward/outward movement, in-place rearrangement | Core | `01-Arrays-Strings-and-Hashing` |
| 03 | Sliding Window | Contiguous range/substring with moving boundaries | Core | `01-Arrays-Strings-and-Hashing` |
| 04 | Prefix Sum and Difference | Range sum, cumulative contribution, count subarrays with a target | Core | `01-Arrays-Strings-and-Hashing` |
| 05 | Binary Search | Ordered search, first/last valid boundary, answer-space search | Core | `02-Searching-and-Sorting` |
| 06 | Sorting and Intervals | Ordering, merging, scheduling, overlap | Core | `02-Searching-and-Sorting` |
| 07 | Linked List Pointers | Dummy node, fast/slow, fixed gap, reverse, merge, cycle | Core | `05-Linked-Lists` |
| 08 | Stack and Monotonic Stack | Nested state, unresolved item, next/previous greater/smaller, boundaries | Core | `06-Stacks` |
| 09 | Queue and Deque | FIFO simulation, stream/recent elements, moving-window candidates | Core | `07-Queues` |
| 10 | Recursion Fundamentals | Smaller instance, base case, call stack, contribution/faith | Core | `03-Recursion-and-Backtracking` |
| 11 | Backtracking | Choices, constraints, choose/recurse/undo/prune | Core | `03-Recursion-and-Backtracking` |
| 12 | Binary Tree DFS and Subtree State | Traversal order, child returns, paths and subtree values | Core | `08-Trees` |
| 13 | Tree BFS and BST | Level order, queue by level, BST ordering invariant | Core | `08-Trees` |
| 14 | Heap / Priority Queue | Top K, repeated min/max, K-way merge, running median | Core | `10-Heaps-and-Priority-Queues` |
| 15 | Greedy | Local choice with correctness argument, scheduling, reachability | Important | `11-Greedy` |
| 16 | Graph DFS/BFS and Grid Traversal | Components, reachability, flood fill, multi-source BFS | Core | `09-Graphs` |
| 17 | Graph Cycles, Topological Sort, Union-Find | Dependency order, cycle detection, connectivity | Important | `09-Graphs` |
| 18 | Shortest Path and MST | Weighted routes, Dijkstra, Kruskal/Prim | Important | `09-Graphs` |
| 19 | Trie | Prefix lookup, dictionary and prefix search | Important | Keep within Arrays/Strings until volume warrants subfolder |
| 20 | 1D / Take-Skip DP | Repeated states, take/not-take, min/max/count | Core | `04-Dynamic-Programming` |
| 21 | Grid / 2D DP and Knapsack | Two-dimensional state, capacity, subset/partition/coin choices | Core | `04-Dynamic-Programming` |
| 22 | Subsequence and String DP | LIS, LCS, edit distance, palindrome, word break | Important | `04-Dynamic-Programming` |
| 23 | Bit Manipulation | XOR, bit masks, set/clear/test bits, powers of two | Important | Add focused notes only when studying |
| 24 | Basic Math for Interviews | GCD/LCM, primes, modular arithmetic basics, overflow | Selective | Keep a small interview subset; do not mix with CP practice |

## Cross-pattern links — do not duplicate problems

| Problem type | Primary pattern | Related concept |
|---|---|---|
| Two Sum | Arrays/Hashing | Two Pointers if sorted |
| 3Sum | Two Pointers | Sorting and duplicate handling |
| Longest Substring Without Repeating Characters | Sliding Window | Set/frequency map |
| Subarray Sum Equals K | Prefix Sum | HashMap frequency |
| Trapping Rain Water | Two Pointers | Monotonic Stack alternative |
| Top K Frequent Elements | Heap | Frequency map / bucket alternative |
| Level Order Traversal | Tree BFS | Queue |
| Number of Islands | Graph DFS/BFS | Grid traversal |
| Word Break | String DP | Trie alternative |
| LRU Cache | Data Structure Design | HashMap + Doubly Linked List |

## Optional advanced shelf — only when justified

Fenwick/Segment Trees; KMP/Z/rolling hash; SCC, bridges and articulation points; advanced shortest paths; bitmask/digit/probability/game DP; DP optimisation tricks; and advanced competitive-programming mathematics/geometry. Do not make these prerequisites for the core interview track.

## Pattern revision file standard

Create a revision file only when beginning a pattern. Each file should contain: core idea, recognition cues/lookalikes, invariant/state, brute-force-to-optimised derivation, selected problem order, Java implementation, dry run, complexity, edge cases, common mistakes, R1/R2/R3 and a mastery test. Do not create one file per problem.

## Active 36-pattern sequence and problem counts

The final schedule is pattern-first and contains **375 unique questions across 36 problem-solving patterns**. This is the single active three-year DSA list.

[Open the Three-Year DSA Interview Master Bank — Final 375 v4](00_DSA_Three_Year_Pattern_Wise_Final_Problem_Bank_v4.md)

| Order | Pattern | Problems |
|---:|---|---:|
| 1 | HashMap / HashSet / Frequency Counting | 21 |
| 2 | Two Pointers / In-place Partitioning | 18 |
| 3 | Sliding Window | 15 |
| 4 | Prefix Sum / Difference Array | 12 |
| 5 | Binary Search / Search on Answer | 18 |
| 6 | Sorting / Merge Intervals / Sweep Line | 14 |
| 7 | Cyclic Sort / Index Placement | 3 |
| 8 | Fast & Slow Pointers / Linked List Cycles | 7 |
| 9 | Linked List Reversal / Dummy Node / Merge | 13 |
| 10 | Monotonic Stack / Next Greater / Histogram | 10 |
| 11 | Stack Parsing / Simulation | 12 |
| 12 | Queue / Deque / Monotonic Queue | 10 |
| 13 | Backtracking / Subsets / Combinations / Permutations | 17 |
| 14 | Backtracking / Grid Search and Partitioning | 6 |
| 15 | Tree DFS / Recursion / Path State | 26 |
| 16 | Tree BFS / Level Order | 8 |
| 17 | Binary Search Tree | 9 |
| 18 | Heap / Top K / Two Heaps | 13 |
| 19 | K-Way Merge | 2 |
| 20 | Greedy / Reachability / Scheduling | 15 |
| 21 | Graph DFS / BFS / Grid Components | 14 |
| 22 | Topological Sort / Union-Find | 11 |
| 23 | Shortest Path / Minimum Spanning Tree | 11 |
| 24 | DP 1D / Take-Skip | 15 |
| 25 | DP Knapsack / Subset Sum | 7 |
| 26 | DP Grid / Matrix Paths | 8 |
| 27 | DP Subsequences / Strings / Palindromes | 14 |
| 28 | DP State Machine / Scheduling | 5 |
| 29 | Trie / Prefix Search | 6 |
| 30 | Bit Manipulation | 9 |
| 31 | Basic Math / Number Patterns | 5 |
| 32 | Matrix Traversal / In-place Matrix Transform | 6 |
| 33 | Data Structure Design | 8 |
| 34 | Divide and Conquer | 4 |
| 35 | String Matching / Rolling Hash | 2 |
| 36 | DP Interval / Partition | 1 |
| **Total** | **36 patterns** | **375** |
