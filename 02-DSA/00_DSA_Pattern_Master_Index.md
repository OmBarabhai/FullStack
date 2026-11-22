> **Active problem list:** [Three-Year Pattern-Wise Final Problem Bank v2](00_DSA_Three_Year_Pattern_Wise_Final_Problem_Bank_v2.md) is the canonical problem schedule. Use this index for pattern navigation; do not maintain a competing problem list here.

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