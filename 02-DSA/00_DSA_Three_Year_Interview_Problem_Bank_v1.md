# Three-Year DSA Interview Problem Bank — v1

> **Purpose:** A bounded, pattern-wise list for software engineering coding interviews (SDE-1 / fresher through stronger product-company interviews). This is not a competitive-programming syllabus.
>
> **Language:** Java. **Total:** 240 unique LeetCode problems. The numbering is a canonical ID for this bank. Solve a problem once and add company tags; do not create duplicate copies for each employer.

## How to use this for three years

- **Year 1 — Foundations:** Work through the Y1 rows, while auditing your existing Arrays, Linked List, Stack, Queue, Recursion and Tree notes before re-solving anything. Build confidence with Easy and Medium questions, invariants, dry runs and Java implementation.
- **Year 2 — Pattern depth:** Work through Y2 rows, especially Heap, Greedy, Graphs and core DP. Mix patterns instead of always knowing the topic in advance.
- **Year 3 — Interview execution:** Work through Y3 selectively, re-solve weak problems, use company tags for target employers and run timed mock interviews. Some advanced items are optional; they are not prerequisites for every SDE-1 interview.

A year label is an order suggestion, not a deadline. At one focused problem session per day, use spare days for revisions, old tracker completion, mixed unseen problems and mock interviews. There is no benefit in racing through every row.

## Status and company tag legend

- **New:** No earlier completion was recorded in the audit. Confirm by checking your notes before starting.
- **Review:** The problem was already mentioned as practised in your history; test it independently instead of counting it as new.
- **Check existing tracker first:** You have a substantial subject roadmap/notes already. Search that file and update its status before solving again.
- **Selective / Optional advanced:** Choose these only after the core patterns are interview-ready or when a target employer/role calls for them.

Company abbreviations: **AMZ** Amazon; **MSFT** Microsoft; **GOO** Google; **ADB** Adobe; **ATL** Atlassian; **UBER** Uber; **FLIP** Flipkart; **PHONEPE** PhonePe; **GS** Goldman Sachs; **MORGAN** Morgan Stanley; **ACC** Accenture.

A company tag without an asterisk means the problem appears in that company's all-time CSV. An asterisk means it also appears in the source's “Thirty Days” CSV. These are historical platform-tag datasets, not verified interview questions or a hiring guarantee. A blank tag means no tag was recorded from the selected CSVs, not that a company has never asked the problem.

## A. Arrays and Hashing — 16

| # | Problem | Level | Suggested phase | Company dataset tags | Your status |
|---:|---|---|---|---|---|
| 1 | [Contains Duplicate — LC 217](https://leetcode.com/problems/contains-duplicate/) | Easy | Y1 | — | New |
| 2 | [Two Sum — LC 1](https://leetcode.com/problems/two-sum/) | Easy | Y1 | AMZ*, MSFT*, GOO*, ADB, ATL, UBER, FLIP, PHONEPE, GS, MORGAN, ACC | New |
| 3 | [Valid Anagram — LC 242](https://leetcode.com/problems/valid-anagram/) | Easy | Y1 | AMZ*, ACC, GS | New |
| 4 | [Group Anagrams — LC 49](https://leetcode.com/problems/group-anagrams/) | Medium | Y1 | AMZ*, MSFT*, GOO*, ADB, ATL, UBER, PHONEPE, GS, MORGAN, ACC | Review — previously practised |
| 5 | [Top K Frequent Elements — LC 347](https://leetcode.com/problems/top-k-frequent-elements/) | Medium | Y1 | AMZ*, GOO*, MSFT, ADB, ATL, UBER, GS | Review — previously practised |
| 6 | [Product of Array Except Self — LC 238](https://leetcode.com/problems/product-of-array-except-self/) | Medium | Y1 | AMZ*, MSFT, GOO, ADB, UBER | New / verify |
| 7 | [Longest Consecutive Sequence — LC 128](https://leetcode.com/problems/longest-consecutive-sequence/) | Medium | Y1 | AMZ*, GOO*, MSFT, ADB, ATL, UBER, PHONEPE | New |
| 8 | [Majority Element — LC 169](https://leetcode.com/problems/majority-element/) | Easy | Y1 | AMZ, MSFT, GOO, ADB, UBER, GS, MORGAN, ACC | New |
| 9 | [Valid Sudoku — LC 36](https://leetcode.com/problems/valid-sudoku/) | Medium | Y1 | AMZ* | New |
| 10 | [First Unique Character in a String — LC 387](https://leetcode.com/problems/first-unique-character-in-a-string/) | Easy | Y1 | GS, MORGAN | New |
| 11 | [Ransom Note — LC 383](https://leetcode.com/problems/ransom-note/) | Easy | Y1 | — | New |
| 12 | [Isomorphic Strings — LC 205](https://leetcode.com/problems/isomorphic-strings/) | Easy | Y1 | — | New |
| 13 | [Contains Duplicate II — LC 219](https://leetcode.com/problems/contains-duplicate-ii/) | Easy | Y1 | — | New |
| 14 | [Intersection of Two Arrays II — LC 350](https://leetcode.com/problems/intersection-of-two-arrays-ii/) | Easy | Y1 | — | New |
| 15 | [Find All Numbers Disappeared in an Array — LC 448](https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/) | Easy | Y1 | — | New |
| 16 | [Set Matrix Zeroes — LC 73](https://leetcode.com/problems/set-matrix-zeroes/) | Medium | Y1 | — | New |

## B. Two Pointers and Partitioning — 12

| # | Problem | Level | Suggested phase | Company dataset tags | Your status |
|---:|---|---|---|---|---|
| 17 | [Valid Palindrome — LC 125](https://leetcode.com/problems/valid-palindrome/) | Easy | Y1 | AMZ, MSFT, GOO, ADB, UBER, ACC | Review — previously practised |
| 18 | [Two Sum II — Input Array Is Sorted — LC 167](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/) | Medium | Y1 | — | Review — previously practised |
| 19 | [3Sum — LC 15](https://leetcode.com/problems/3sum/) | Medium | Y1 | AMZ*, MSFT*, GOO*, ADB, FLIP, PHONEPE, GS, MORGAN, ACC | New |
| 20 | [4Sum — LC 18](https://leetcode.com/problems/4sum/) | Medium | Y1 | — | New |
| 21 | [Container With Most Water — LC 11](https://leetcode.com/problems/container-with-most-water/) | Medium | Y1 | AMZ*, GOO*, FLIP*, MSFT, ADB, UBER, GS, MORGAN, ACC | New |
| 22 | [Trapping Rain Water — LC 42](https://leetcode.com/problems/trapping-rain-water/) | Hard | Y1 | AMZ*, MSFT*, GOO*, GS*, ADB, UBER, FLIP, PHONEPE, ACC | Review — previously practised; compare stack approach |
| 23 | [Remove Duplicates from Sorted Array — LC 26](https://leetcode.com/problems/remove-duplicates-from-sorted-array/) | Easy | Y1 | MSFT*, AMZ, GOO, ADB, UBER, ACC | New |
| 24 | [Move Zeroes — LC 283](https://leetcode.com/problems/move-zeroes/) | Easy | Y1 | AMZ*, MSFT*, GOO*, ADB, UBER, ACC | New |
| 25 | [Sort Colors — LC 75](https://leetcode.com/problems/sort-colors/) | Medium | Y1 | MSFT*, AMZ, MSFT, GOO, ADB, UBER, FLIP, GS, MORGAN | Previously next in your sorting tracker — verify |
| 26 | [Squares of a Sorted Array — LC 977](https://leetcode.com/problems/squares-of-a-sorted-array/) | Easy | Y1 | AMZ, MSFT, GOO, ADB, UBER | New |
| 27 | [Backspace String Compare — LC 844](https://leetcode.com/problems/backspace-string-compare/) | Easy | Y1 | — | New |
| 28 | [Boats to Save People — LC 881](https://leetcode.com/problems/boats-to-save-people/) | Medium | Y1 | — | New |

## C. Sliding Window — 10

| # | Problem | Level | Suggested phase | Company dataset tags | Your status |
|---:|---|---|---|---|---|
| 29 | [Longest Substring Without Repeating Characters — LC 3](https://leetcode.com/problems/longest-substring-without-repeating-characters/) | Medium | Y1 | AMZ*, MSFT*, GOO*, ADB, ATL, UBER, GS, MORGAN, ACC | Review — previously practised |
| 30 | [Longest Repeating Character Replacement — LC 424](https://leetcode.com/problems/longest-repeating-character-replacement/) | Medium | Y1 | — | New |
| 31 | [Permutation in String — LC 567](https://leetcode.com/problems/permutation-in-string/) | Medium | Y1 | — | New |
| 32 | [Find All Anagrams in a String — LC 438](https://leetcode.com/problems/find-all-anagrams-in-a-string/) | Medium | Y1 | — | New |
| 33 | [Minimum Window Substring — LC 76](https://leetcode.com/problems/minimum-window-substring/) | Hard | Y1 | AMZ, MSFT, GOO, ADB, UBER | New |
| 34 | [Max Consecutive Ones III — LC 1004](https://leetcode.com/problems/max-consecutive-ones-iii/) | Medium | Y1 | AMZ*, MSFT*, GOO* | New |
| 35 | [Sliding Window Maximum — LC 239](https://leetcode.com/problems/sliding-window-maximum/) | Hard | Y1 | GOO*, AMZ, MSFT, ADB, UBER, PHONEPE | New |
| 36 | [Minimum Size Subarray Sum — LC 209](https://leetcode.com/problems/minimum-size-subarray-sum/) | Medium | Y1 | — | New |
| 37 | [Maximum Points You Can Obtain from Cards — LC 1423](https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/) | Medium | Y1 | MSFT*, FLIP, AMZ, GOO, UBER, PHONEPE | New |
| 38 | [Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit — LC 1438](https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/) | Medium | Y1 | PHONEPE, AMZ, MSFT, GOO, UBER | New |

## D. Prefix Sum and Difference — 8

| # | Problem | Level | Suggested phase | Company dataset tags | Your status |
|---:|---|---|---|---|---|
| 39 | [Subarray Sum Equals K — LC 560](https://leetcode.com/problems/subarray-sum-equals-k/) | Medium | Y1 | AMZ*, MSFT*, GOO*, ADB, UBER, FLIP, GS, ACC | New |
| 40 | [Range Sum Query — Immutable — LC 303](https://leetcode.com/problems/range-sum-query-immutable/) | Easy | Y1 | — | New |
| 41 | [Continuous Subarray Sum — LC 523](https://leetcode.com/problems/continuous-subarray-sum/) | Medium | Y1 | — | New |
| 42 | [Contiguous Array — LC 525](https://leetcode.com/problems/contiguous-array/) | Medium | Y1 | MORGAN, ACC | New |
| 43 | [Find Pivot Index — LC 724](https://leetcode.com/problems/find-pivot-index/) | Easy | Y1 | GS, ACC | New |
| 44 | [Corporate Flight Bookings — LC 1109](https://leetcode.com/problems/corporate-flight-bookings/) | Medium | Y1 | GS | New |
| 45 | [Car Pooling — LC 1094](https://leetcode.com/problems/car-pooling/) | Medium | Y1 | GS | New |
| 46 | [Subarray Sums Divisible by K — LC 974](https://leetcode.com/problems/subarray-sums-divisible-by-k/) | Medium | Y1 | — | New |

## E. Binary Search — 12

| # | Problem | Level | Suggested phase | Company dataset tags | Your status |
|---:|---|---|---|---|---|
| 47 | [Binary Search — LC 704](https://leetcode.com/problems/binary-search/) | Easy | Y1 | AMZ*, MSFT, GOO | Review — binary search previously practised; verify exact problem |
| 48 | [Search Insert Position — LC 35](https://leetcode.com/problems/search-insert-position/) | Easy | Y1 | — | New |
| 49 | [Find First and Last Position of Element in Sorted Array — LC 34](https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/) | Medium | Y1 | AMZ*, GOO*, ACC | New |
| 50 | [Search a 2D Matrix — LC 74](https://leetcode.com/problems/search-a-2d-matrix/) | Medium | Y1 | MSFT*, AMZ, MSFT, GOO, ADB, UBER | New |
| 51 | [Search in Rotated Sorted Array — LC 33](https://leetcode.com/problems/search-in-rotated-sorted-array/) | Medium | Y1 | AMZ*, GOO*, MSFT, ADB, UBER, FLIP, GS | New |
| 52 | [Find Minimum in Rotated Sorted Array — LC 153](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/) | Medium | Y1 | AMZ, MSFT, GOO, ADB, UBER, GS | New |
| 53 | [Find Peak Element — LC 162](https://leetcode.com/problems/find-peak-element/) | Medium | Y1 | GOO*, ADB*, AMZ, MSFT, ACC | New |
| 54 | [Koko Eating Bananas — LC 875](https://leetcode.com/problems/koko-eating-bananas/) | Medium | Y1 | AMZ*, GOO*, MSFT, ADB, ATL, UBER, FLIP, ACC | New |
| 55 | [Capacity To Ship Packages Within D Days — LC 1011](https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/) | Medium | Y1 | AMZ*, MSFT, GOO, UBER, FLIP | New |
| 56 | [Split Array Largest Sum — LC 410](https://leetcode.com/problems/split-array-largest-sum/) | Hard | Y1 | AMZ*, MSFT*, GOO*, UBER, FLIP, PHONEPE | Selective |
| 57 | [Median of Two Sorted Arrays — LC 4](https://leetcode.com/problems/median-of-two-sorted-arrays/) | Hard | Y1 | AMZ*, MSFT*, GOO*, ADB, UBER, FLIP, GS, ACC | Selective — do after binary-search boundaries |
| 58 | [Find K Closest Elements — LC 658](https://leetcode.com/problems/find-k-closest-elements/) | Medium | Y1 | AMZ, MSFT, GOO, UBER, FLIP | New |

## F. Sorting and Intervals — 10

| # | Problem | Level | Suggested phase | Company dataset tags | Your status |
|---:|---|---|---|---|---|
| 59 | [Merge Intervals — LC 56](https://leetcode.com/problems/merge-intervals/) | Medium | Y1 | AMZ*, GOO*, MSFT, ADB, ATL, UBER, FLIP, GS, MORGAN, ACC | New |
| 60 | [Insert Interval — LC 57](https://leetcode.com/problems/insert-interval/) | Medium | Y1 | AMZ, MSFT, GOO, UBER, PHONEPE | New |
| 61 | [Non-overlapping Intervals — LC 435](https://leetcode.com/problems/non-overlapping-intervals/) | Medium | Y1 | — | New |
| 62 | [Minimum Number of Arrows to Burst Balloons — LC 452](https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/) | Medium | Y1 | — | New |
| 63 | [Interval List Intersections — LC 986](https://leetcode.com/problems/interval-list-intersections/) | Medium | Y1 | — | New |
| 64 | [Merge Sorted Array — LC 88](https://leetcode.com/problems/merge-sorted-array/) | Easy | Y1 | MSFT, GOO, GS, ACC | New |
| 65 | [Largest Number — LC 179](https://leetcode.com/problems/largest-number/) | Medium | Y1 | GS, ACC | New |
| 66 | [Hand of Straights — LC 846](https://leetcode.com/problems/hand-of-straights/) | Medium | Y1 | — | New |
| 67 | [Queue Reconstruction by Height — LC 406](https://leetcode.com/problems/queue-reconstruction-by-height/) | Medium | Y1 | — | New |
| 68 | [Task Scheduler — LC 621](https://leetcode.com/problems/task-scheduler/) | Medium | Y1 | AMZ*, UBER | New |

## G. Strings and Trie — 8

| # | Problem | Level | Suggested phase | Company dataset tags | Your status |
|---:|---|---|---|---|---|
| 69 | [Longest Common Prefix — LC 14](https://leetcode.com/problems/longest-common-prefix/) | Easy | Y1 | AMZ*, MSFT*, GOO*, ADB, UBER, PHONEPE | New |
| 70 | [Reverse String — LC 344](https://leetcode.com/problems/reverse-string/) | Easy | Y1 | GS, ACC | Review — previously practised |
| 71 | [Reverse Words in a String — LC 151](https://leetcode.com/problems/reverse-words-in-a-string/) | Medium | Y1 | GS, ACC | New |
| 72 | [String to Integer (atoi) — LC 8](https://leetcode.com/problems/string-to-integer-atoi/) | Medium | Y1 | AMZ*, GOO*, MSFT, ADB, UBER | New |
| 73 | [Implement Trie (Prefix Tree) — LC 208](https://leetcode.com/problems/implement-trie-prefix-tree/) | Medium | Y1 | — | New |
| 74 | [Design Add and Search Words Data Structure — LC 211](https://leetcode.com/problems/design-add-and-search-words-data-structure/) | Medium | Y1 | — | New |
| 75 | [Word Search II — LC 212](https://leetcode.com/problems/word-search-ii/) | Hard | Y2 | AMZ*, MSFT, GOO, ATL, UBER, GS, ACC | Selective |
| 76 | [String Compression — LC 443](https://leetcode.com/problems/string-compression/) | Medium | Y1 | GS, ACC | New |

## H. Linked Lists — 14

| # | Problem | Level | Suggested phase | Company dataset tags | Your status |
|---:|---|---|---|---|---|
| 77 | [Reverse Linked List — LC 206](https://leetcode.com/problems/reverse-linked-list/) | Easy | Y1 | AMZ, MSFT, GOO*, ADB, UBER, ACC | Check existing Linked List tracker first |
| 78 | [Merge Two Sorted Lists — LC 21](https://leetcode.com/problems/merge-two-sorted-lists/) | Easy | Y1 | GS, ACC | Check existing Linked List tracker first |
| 79 | [Linked List Cycle — LC 141](https://leetcode.com/problems/linked-list-cycle/) | Easy | Y1 | AMZ*, MSFT, GOO, ADB, UBER | Check existing Linked List tracker first |
| 80 | [Linked List Cycle II — LC 142](https://leetcode.com/problems/linked-list-cycle-ii/) | Medium | Y1 | — | Check existing Linked List tracker first |
| 81 | [Remove Nth Node From End of List — LC 19](https://leetcode.com/problems/remove-nth-node-from-end-of-list/) | Medium | Y1 | MORGAN, ACC | Check existing Linked List tracker first |
| 82 | [Middle of the Linked List — LC 876](https://leetcode.com/problems/middle-of-the-linked-list/) | Easy | Y1 | — | Check existing Linked List tracker first |
| 83 | [Palindrome Linked List — LC 234](https://leetcode.com/problems/palindrome-linked-list/) | Easy | Y1 | MSFT | Check existing Linked List tracker first |
| 84 | [Reorder List — LC 143](https://leetcode.com/problems/reorder-list/) | Medium | Y1 | — | Check existing Linked List tracker first |
| 85 | [Add Two Numbers — LC 2](https://leetcode.com/problems/add-two-numbers/) | Medium | Y1 | AMZ*, GOO*, MSFT, ADB, UBER | Check existing Linked List tracker first |
| 86 | [Copy List with Random Pointer — LC 138](https://leetcode.com/problems/copy-list-with-random-pointer/) | Medium | Y2 | AMZ*, MSFT, GOO, ADB, UBER, FLIP | Check existing Linked List tracker first |
| 87 | [Intersection of Two Linked Lists — LC 160](https://leetcode.com/problems/intersection-of-two-linked-lists/) | Easy | Y1 | — | Check existing Linked List tracker first |
| 88 | [Reverse Nodes in k-Group — LC 25](https://leetcode.com/problems/reverse-nodes-in-k-group/) | Hard | Y2 | MSFT* | Check existing Linked List tracker first |
| 89 | [Rotate List — LC 61](https://leetcode.com/problems/rotate-list/) | Medium | Y2 | — | Check existing Linked List tracker first |
| 90 | [Partition List — LC 86](https://leetcode.com/problems/partition-list/) | Medium | Y2 | — | Check existing Linked List tracker first |

## I. Stack and Monotonic Stack — 14

| # | Problem | Level | Suggested phase | Company dataset tags | Your status |
|---:|---|---|---|---|---|
| 91 | [Valid Parentheses — LC 20](https://leetcode.com/problems/valid-parentheses/) | Easy | Y1 | AMZ*, MSFT*, GOO*, ADB, UBER, FLIP, PHONEPE | Check existing Stack tracker first |
| 92 | [Min Stack — LC 155](https://leetcode.com/problems/min-stack/) | Medium | Y1 | GOO*, AMZ, MSFT, ADB, UBER, FLIP | Check existing Stack tracker first |
| 93 | [Daily Temperatures — LC 739](https://leetcode.com/problems/daily-temperatures/) | Medium | Y1 | GOO, MORGAN | Check existing Stack tracker first |
| 94 | [Next Greater Element I — LC 496](https://leetcode.com/problems/next-greater-element-i/) | Easy | Y1 | GOO*, FLIP | Check existing Stack tracker first |
| 95 | [Next Greater Element II — LC 503](https://leetcode.com/problems/next-greater-element-ii/) | Medium | Y1 | MORGAN | Check existing Stack tracker first |
| 96 | [Largest Rectangle in Histogram — LC 84](https://leetcode.com/problems/largest-rectangle-in-histogram/) | Hard | Y2 | AMZ, GOO, ADB, UBER, FLIP, PHONEPE, ACC | Check existing Stack tracker first |
| 97 | [Car Fleet — LC 853](https://leetcode.com/problems/car-fleet/) | Medium | Y2 | — | Check existing Stack tracker first |
| 98 | [Asteroid Collision — LC 735](https://leetcode.com/problems/asteroid-collision/) | Medium | Y1 | AMZ, MSFT, GOO, UBER, FLIP, PHONEPE | Check existing Stack tracker first |
| 99 | [Remove K Digits — LC 402](https://leetcode.com/problems/remove-k-digits/) | Medium | Y2 | AMZ*, GOO*, MSFT, GOO, ADB, PHONEPE | Check existing Stack tracker first |
| 100 | [Simplify Path — LC 71](https://leetcode.com/problems/simplify-path/) | Medium | Y2 | — | Check existing Stack tracker first |
| 101 | [Decode String — LC 394](https://leetcode.com/problems/decode-string/) | Medium | Y2 | — | Check existing Stack tracker first |
| 102 | [Basic Calculator II — LC 227](https://leetcode.com/problems/basic-calculator-ii/) | Medium | Y2 | AMZ*, MSFT, GOO, ADB, UBER | Check existing Stack tracker first |
| 103 | [Longest Valid Parentheses — LC 32](https://leetcode.com/problems/longest-valid-parentheses/) | Hard | Y2 | AMZ*, MSFT, GOO, ADB, MORGAN | Check existing Stack tracker first |
| 104 | [Sum of Subarray Minimums — LC 907](https://leetcode.com/problems/sum-of-subarray-minimums/) | Medium | Y2 | MORGAN | Check existing Stack tracker first |

## J. Queue and Deque — 8

| # | Problem | Level | Suggested phase | Company dataset tags | Your status |
|---:|---|---|---|---|---|
| 105 | [Number of Recent Calls — LC 933](https://leetcode.com/problems/number-of-recent-calls/) | Easy | Y1 | — | Check existing Queue tracker first |
| 106 | [Design Circular Queue — LC 622](https://leetcode.com/problems/design-circular-queue/) | Medium | Y1 | — | Check existing Queue tracker first |
| 107 | [Design Circular Deque — LC 641](https://leetcode.com/problems/design-circular-deque/) | Medium | Y1 | — | Check existing Queue tracker first |
| 108 | [Implement Stack using Queues — LC 225](https://leetcode.com/problems/implement-stack-using-queues/) | Easy | Y1 | — | Check existing Queue/Stack tracker first |
| 109 | [Implement Queue using Stacks — LC 232](https://leetcode.com/problems/implement-queue-using-stacks/) | Easy | Y1 | — | Check existing Queue/Stack tracker first |
| 110 | [Dota2 Senate — LC 649](https://leetcode.com/problems/dota2-senate/) | Medium | Y2 | — | Check existing Queue tracker first |
| 111 | [Reveal Cards In Increasing Order — LC 950](https://leetcode.com/problems/reveal-cards-in-increasing-order/) | Medium | Y2 | — | Check existing Queue tracker first |
| 112 | [Shortest Subarray with Sum at Least K — LC 862](https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/) | Hard | Y3 | — | Selective — monotonic deque |

## K. Recursion and Backtracking — 14

| # | Problem | Level | Suggested phase | Company dataset tags | Your status |
|---:|---|---|---|---|---|
| 113 | [Subsets — LC 78](https://leetcode.com/problems/subsets/) | Medium | Y1 | AMZ, MSFT, GOO, UBER, FLIP | Check existing Recursion tracker first |
| 114 | [Subsets II — LC 90](https://leetcode.com/problems/subsets-ii/) | Medium | Y1 | — | Check existing Recursion tracker first |
| 115 | [Combinations — LC 77](https://leetcode.com/problems/combinations/) | Medium | Y1 | — | Check existing Recursion tracker first |
| 116 | [Combination Sum — LC 39](https://leetcode.com/problems/combination-sum/) | Medium | Y1 | — | Check existing Recursion tracker first |
| 117 | [Combination Sum II — LC 40](https://leetcode.com/problems/combination-sum-ii/) | Medium | Y1 | — | Check existing Recursion tracker first |
| 118 | [Permutations — LC 46](https://leetcode.com/problems/permutations/) | Medium | Y1 | — | Check existing Recursion tracker first |
| 119 | [Permutations II — LC 47](https://leetcode.com/problems/permutations-ii/) | Medium | Y1 | — | Check existing Recursion tracker first |
| 120 | [Letter Combinations of a Phone Number — LC 17](https://leetcode.com/problems/letter-combinations-of-a-phone-number/) | Medium | Y1 | GOO*, AMZ, MSFT, UBER, PHONEPE, ACC | Check existing Recursion tracker first |
| 121 | [Generate Parentheses — LC 22](https://leetcode.com/problems/generate-parentheses/) | Medium | Y1 | AMZ*, GOO*, MSFT, ADB, UBER, FLIP, MORGAN | Check existing Recursion tracker first |
| 122 | [Word Search — LC 79](https://leetcode.com/problems/word-search/) | Medium | Y1 | AMZ*, MSFT, GOO, ATL, UBER, GS, ACC | Check existing Recursion tracker first |
| 123 | [Palindrome Partitioning — LC 131](https://leetcode.com/problems/palindrome-partitioning/) | Medium | Y2 | — | Check existing Recursion tracker first |
| 124 | [N-Queens — LC 51](https://leetcode.com/problems/n-queens/) | Hard | Y2 | GS, ACC | Selective |
| 125 | [Sudoku Solver — LC 37](https://leetcode.com/problems/sudoku-solver/) | Hard | Y2 | — | Selective |
| 126 | [Restore IP Addresses — LC 93](https://leetcode.com/problems/restore-ip-addresses/) | Medium | Y2 | — | Selective |

## L. Trees and BST — 20

| # | Problem | Level | Suggested phase | Company dataset tags | Your status |
|---:|---|---|---|---|---|
| 127 | [Maximum Depth of Binary Tree — LC 104](https://leetcode.com/problems/maximum-depth-of-binary-tree/) | Easy | Y1 | — | Check existing Tree tracker first |
| 128 | [Diameter of Binary Tree — LC 543](https://leetcode.com/problems/diameter-of-binary-tree/) | Easy | Y1 | — | Check existing Tree tracker first |
| 129 | [Same Tree — LC 100](https://leetcode.com/problems/same-tree/) | Easy | Y1 | — | Check existing Tree tracker first |
| 130 | [Invert Binary Tree — LC 226](https://leetcode.com/problems/invert-binary-tree/) | Easy | Y1 | — | Check existing Tree tracker first |
| 131 | [Balanced Binary Tree — LC 110](https://leetcode.com/problems/balanced-binary-tree/) | Easy | Y1 | — | Check existing Tree tracker first |
| 132 | [Binary Tree Level Order Traversal — LC 102](https://leetcode.com/problems/binary-tree-level-order-traversal/) | Medium | Y1 | — | Check existing Tree/Queue tracker first |
| 133 | [Binary Tree Zigzag Level Order Traversal — LC 103](https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/) | Medium | Y1 | — | Check existing Tree tracker first |
| 134 | [Binary Tree Right Side View — LC 199](https://leetcode.com/problems/binary-tree-right-side-view/) | Medium | Y1 | — | Check existing Tree tracker first |
| 135 | [Path Sum — LC 112](https://leetcode.com/problems/path-sum/) | Easy | Y1 | — | Check existing Tree tracker first |
| 136 | [Path Sum II — LC 113](https://leetcode.com/problems/path-sum-ii/) | Medium | Y1 | — | Check existing Tree tracker first |
| 137 | [Path Sum III — LC 437](https://leetcode.com/problems/path-sum-iii/) | Medium | Y2 | — | Check existing Tree tracker first |
| 138 | [Lowest Common Ancestor of a Binary Tree — LC 236](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/) | Medium | Y1 | AMZ*, MSFT, GOO, ADB, ATL | Check existing Tree tracker first |
| 139 | [Subtree of Another Tree — LC 572](https://leetcode.com/problems/subtree-of-another-tree/) | Easy | Y1 | — | Check existing Tree tracker first |
| 140 | [Construct Binary Tree from Preorder and Inorder Traversal — LC 105](https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/) | Medium | Y2 | — | Check existing Tree tracker first |
| 141 | [Construct Binary Tree from Inorder and Postorder Traversal — LC 106](https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/) | Medium | Y2 | — | Check existing Tree tracker first |
| 142 | [Flatten Binary Tree to Linked List — LC 114](https://leetcode.com/problems/flatten-binary-tree-to-linked-list/) | Medium | Y2 | — | Check existing Tree tracker first |
| 143 | [Binary Tree Maximum Path Sum — LC 124](https://leetcode.com/problems/binary-tree-maximum-path-sum/) | Hard | Y2 | AMZ, MSFT, GOO, ADB, UBER, FLIP | Check existing Tree tracker first |
| 144 | [Serialize and Deserialize Binary Tree — LC 297](https://leetcode.com/problems/serialize-and-deserialize-binary-tree/) | Hard | Y2 | AMZ, MSFT, GOO, ATL, UBER, FLIP, PHONEPE | Check existing Tree tracker first |
| 145 | [Validate Binary Search Tree — LC 98](https://leetcode.com/problems/validate-binary-search-tree/) | Medium | Y1 | — | Check existing Tree tracker first |
| 146 | [Kth Smallest Element in a BST — LC 230](https://leetcode.com/problems/kth-smallest-element-in-a-bst/) | Medium | Y2 | — | Check existing Tree tracker first |

## M. Heap and Priority Queue — 10

| # | Problem | Level | Suggested phase | Company dataset tags | Your status |
|---:|---|---|---|---|---|
| 147 | [Kth Largest Element in an Array — LC 215](https://leetcode.com/problems/kth-largest-element-in-an-array/) | Medium | Y2 | AMZ, MSFT, GOO, ADB, UBER, FLIP, GS, MORGAN | New |
| 148 | [Find Median from Data Stream — LC 295](https://leetcode.com/problems/find-median-from-data-stream/) | Hard | Y2 | AMZ*, MSFT, GOO, ADB, UBER, FLIP | New |
| 149 | [K Closest Points to Origin — LC 973](https://leetcode.com/problems/k-closest-points-to-origin/) | Medium | Y2 | AMZ, MSFT, GOO, ADB, UBER | New |
| 150 | [Last Stone Weight — LC 1046](https://leetcode.com/problems/last-stone-weight/) | Easy | Y2 | — | New |
| 151 | [Reorganize String — LC 767](https://leetcode.com/problems/reorganize-string/) | Medium | Y2 | AMZ, GOO, MSFT | New |
| 152 | [Merge k Sorted Lists — LC 23](https://leetcode.com/problems/merge-k-sorted-lists/) | Hard | Y2 | AMZ*, MSFT, GOO, UBER, FLIP | Cross-link: Linked List |
| 153 | [Smallest Range Covering Elements from K Lists — LC 632](https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists/) | Hard | Y3 | AMZ*, MSFT, GOO, FLIP, PHONEPE | Selective |
| 154 | [Kth Largest Element in a Stream — LC 703](https://leetcode.com/problems/kth-largest-element-in-a-stream/) | Easy | Y2 | — | New |
| 155 | [Top K Frequent Words — LC 692](https://leetcode.com/problems/top-k-frequent-words/) | Medium | Y2 | AMZ, MSFT, GOO, ADB, UBER | New |
| 156 | [Design Twitter — LC 355](https://leetcode.com/problems/design-twitter/) | Medium | Y3 | — | Selective — design + heap |

## N. Greedy — 8

| # | Problem | Level | Suggested phase | Company dataset tags | Your status |
|---:|---|---|---|---|---|
| 157 | [Jump Game — LC 55](https://leetcode.com/problems/jump-game/) | Medium | Y2 | AMZ, MSFT*, GOO*, ADB, FLIP, PHONEPE, GS, MORGAN | New |
| 158 | [Jump Game II — LC 45](https://leetcode.com/problems/jump-game-ii/) | Medium | Y2 | AMZ, MSFT, GOO, ADB, FLIP, PHONEPE | New |
| 159 | [Gas Station — LC 134](https://leetcode.com/problems/gas-station/) | Medium | Y2 | AMZ, MSFT, GOO, ADB, FLIP, PHONEPE, GS | New |
| 160 | [Candy — LC 135](https://leetcode.com/problems/candy/) | Hard | Y2 | GS, MORGAN, ACC | Selective |
| 161 | [Partition Labels — LC 763](https://leetcode.com/problems/partition-labels/) | Medium | Y2 | — | New |
| 162 | [Assign Cookies — LC 455](https://leetcode.com/problems/assign-cookies/) | Easy | Y2 | — | New |
| 163 | [Maximum Length of Pair Chain — LC 646](https://leetcode.com/problems/maximum-length-of-pair-chain/) | Medium | Y2 | — | New |
| 164 | [Two City Scheduling — LC 1029](https://leetcode.com/problems/two-city-scheduling/) | Medium | Y2 | — | New |

## O. Graphs, BFS/DFS, Union-Find — 18

| # | Problem | Level | Suggested phase | Company dataset tags | Your status |
|---:|---|---|---|---|---|
| 165 | [Number of Islands — LC 200](https://leetcode.com/problems/number-of-islands/) | Medium | Y2 | AMZ*, GOO*, MSFT, ADB, UBER, FLIP, PHONEPE, GS, ACC | New |
| 166 | [Max Area of Island — LC 695](https://leetcode.com/problems/max-area-of-island/) | Medium | Y2 | — | New |
| 167 | [Clone Graph — LC 133](https://leetcode.com/problems/clone-graph/) | Medium | Y2 | — | New |
| 168 | [Course Schedule — LC 207](https://leetcode.com/problems/course-schedule/) | Medium | Y2 | GOO*, AMZ, MSFT, ADB, UBER, FLIP | New |
| 169 | [Course Schedule II — LC 210](https://leetcode.com/problems/course-schedule-ii/) | Medium | Y2 | AMZ*, GOO*, MSFT, UBER, FLIP | New |
| 170 | [Number of Provinces — LC 547](https://leetcode.com/problems/number-of-provinces/) | Medium | Y2 | AMZ, MSFT, GOO, ADB, UBER | New |
| 171 | [Rotting Oranges — LC 994](https://leetcode.com/problems/rotting-oranges/) | Medium | Y2 | AMZ*, GOO*, MSFT, ADB, UBER, FLIP | New |
| 172 | [Pacific Atlantic Water Flow — LC 417](https://leetcode.com/problems/pacific-atlantic-water-flow/) | Medium | Y2 | AMZ, MSFT, GOO, ADB, FLIP | New |
| 173 | [Word Ladder — LC 127](https://leetcode.com/problems/word-ladder/) | Hard | Y2 | AMZ, MSFT, GOO, ADB, UBER, FLIP, PHONEPE | Selective |
| 174 | [Accounts Merge — LC 721](https://leetcode.com/problems/accounts-merge/) | Medium | Y2 | — | New |
| 175 | [Redundant Connection — LC 684](https://leetcode.com/problems/redundant-connection/) | Medium | Y2 | — | New |
| 176 | [Network Delay Time — LC 743](https://leetcode.com/problems/network-delay-time/) | Medium | Y2 | AMZ, MSFT, GOO, UBER | New |
| 177 | [Cheapest Flights Within K Stops — LC 787](https://leetcode.com/problems/cheapest-flights-within-k-stops/) | Medium | Y2 | AMZ, MSFT, GOO, UBER, FLIP | New |
| 178 | [Min Cost to Connect All Points — LC 1584](https://leetcode.com/problems/min-cost-to-connect-all-points/) | Medium | Y2 | — | New |
| 179 | [Evaluate Division — LC 399](https://leetcode.com/problems/evaluate-division/) | Medium | Y2 | AMZ*, MSFT, GOO, UBER, FLIP, PHONEPE | New |
| 180 | [Find Eventual Safe States — LC 802](https://leetcode.com/problems/find-eventual-safe-states/) | Medium | Y2 | — | New |
| 181 | [Number of Operations to Make Network Connected — LC 1319](https://leetcode.com/problems/number-of-operations-to-make-network-connected/) | Medium | Y2 | — | New |
| 182 | [Find if Path Exists in Graph — LC 1971](https://leetcode.com/problems/find-if-path-exists-in-graph/) | Easy | Y2 | — | New |

## P. Dynamic Programming — Core — 24

| # | Problem | Level | Suggested phase | Company dataset tags | Your status |
|---:|---|---|---|---|---|
| 183 | [Climbing Stairs — LC 70](https://leetcode.com/problems/climbing-stairs/) | Easy | Y2 | MSFT*, ACC, GS | Check existing DP notes first |
| 184 | [Min Cost Climbing Stairs — LC 746](https://leetcode.com/problems/min-cost-climbing-stairs/) | Easy | Y2 | — | Check existing DP notes first |
| 185 | [House Robber — LC 198](https://leetcode.com/problems/house-robber/) | Medium | Y2 | AMZ*, GOO*, MSFT, ADB, UBER, PHONEPE | Check existing DP notes first |
| 186 | [House Robber II — LC 213](https://leetcode.com/problems/house-robber-ii/) | Medium | Y2 | — | Check existing DP notes first |
| 187 | [Delete and Earn — LC 740](https://leetcode.com/problems/delete-and-earn/) | Medium | Y2 | MORGAN | Check existing DP notes first |
| 188 | [Coin Change — LC 322](https://leetcode.com/problems/coin-change/) | Medium | Y2 | AMZ*, MSFT, GOO, ADB, UBER, PHONEPE, GS, MORGAN | Check existing DP notes first |
| 189 | [Coin Change II — LC 518](https://leetcode.com/problems/coin-change-2/) | Medium | Y2 | — | Check existing DP notes first |
| 190 | [Unique Paths — LC 62](https://leetcode.com/problems/unique-paths/) | Medium | Y2 | — | Check existing DP notes first |
| 191 | [Unique Paths II — LC 63](https://leetcode.com/problems/unique-paths-ii/) | Medium | Y2 | — | Check existing DP notes first |
| 192 | [Minimum Path Sum — LC 64](https://leetcode.com/problems/minimum-path-sum/) | Medium | Y2 | GS | Check existing DP notes first |
| 193 | [Triangle — LC 120](https://leetcode.com/problems/triangle/) | Medium | Y2 | — | Check existing DP notes first |
| 194 | [Partition Equal Subset Sum — LC 416](https://leetcode.com/problems/partition-equal-subset-sum/) | Medium | Y2 | MSFT | Check existing DP notes first |
| 195 | [Target Sum — LC 494](https://leetcode.com/problems/target-sum/) | Medium | Y2 | — | Check existing DP notes first |
| 196 | [Longest Increasing Subsequence — LC 300](https://leetcode.com/problems/longest-increasing-subsequence/) | Medium | Y2 | AMZ, MSFT, GOO, UBER, FLIP, GS, MORGAN | Check existing DP notes first |
| 197 | [Number of Longest Increasing Subsequence — LC 673](https://leetcode.com/problems/number-of-longest-increasing-subsequence/) | Medium | Y2 | — | Check existing DP notes first |
| 198 | [Longest Common Subsequence — LC 1143](https://leetcode.com/problems/longest-common-subsequence/) | Medium | Y2 | MORGAN | Check existing DP notes first |
| 199 | [Edit Distance — LC 72](https://leetcode.com/problems/edit-distance/) | Medium | Y2 | — | Check existing DP notes first |
| 200 | [Distinct Subsequences — LC 115](https://leetcode.com/problems/distinct-subsequences/) | Hard | Y2 | — | Check existing DP notes first |
| 201 | [Word Break — LC 139](https://leetcode.com/problems/word-break/) | Medium | Y2 | — | Check existing DP notes first |
| 202 | [Maximum Product Subarray — LC 152](https://leetcode.com/problems/maximum-product-subarray/) | Medium | Y2 | MORGAN | Check existing DP notes first |
| 203 | [Maximum Subarray — LC 53](https://leetcode.com/problems/maximum-subarray/) | Medium | Y2 | AMZ*, GOO*, MSFT, ADB, ATL, UBER, PHONEPE, GS, MORGAN, ACC | Review — Kadane's previously practised |
| 204 | [Best Time to Buy and Sell Stock — LC 121](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/) | Easy | Y2 | AMZ*, MSFT*, GOO*, ADB, ATL, UBER, FLIP, PHONEPE, GS, MORGAN, ACC | New / verify |
| 205 | [Best Time to Buy and Sell Stock II — LC 122](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/) | Medium | Y2 | GS, ACC | Check existing DP notes first |
| 206 | [House Robber III — LC 337](https://leetcode.com/problems/house-robber-iii/) | Medium | Y2 | — | Check existing Tree/DP notes first |

## Q. Dynamic Programming — Advanced and Selective — 14

| # | Problem | Level | Suggested phase | Company dataset tags | Your status |
|---:|---|---|---|---|---|
| 207 | [Best Time to Buy and Sell Stock III — LC 123](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/) | Hard | Y3 | — | Selective |
| 208 | [Best Time to Buy and Sell Stock IV — LC 188](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/) | Hard | Y3 | — | Optional advanced |
| 209 | [Best Time to Buy and Sell Stock with Cooldown — LC 309](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/) | Medium | Y3 | — | Selective |
| 210 | [Best Time to Buy and Sell Stock with Transaction Fee — LC 714](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/) | Medium | Y3 | — | Selective |
| 211 | [Longest Palindromic Substring — LC 5](https://leetcode.com/problems/longest-palindromic-substring/) | Medium | Y2 | AMZ, MSFT, GOO, ADB, UBER, FLIP, PHONEPE, GS, ACC | New |
| 212 | [Longest Palindromic Subsequence — LC 516](https://leetcode.com/problems/longest-palindromic-subsequence/) | Medium | Y3 | GS | Selective |
| 213 | [Palindromic Substrings — LC 647](https://leetcode.com/problems/palindromic-substrings/) | Medium | Y2 | GS* | New |
| 214 | [Burst Balloons — LC 312](https://leetcode.com/problems/burst-balloons/) | Hard | Y3 | AMZ, MSFT, GOO, UBER, PHONEPE | Optional advanced |
| 215 | [Regular Expression Matching — LC 10](https://leetcode.com/problems/regular-expression-matching/) | Hard | Y3 | AMZ, MSFT, GOO, UBER, PHONEPE | Optional advanced |
| 216 | [Wildcard Matching — LC 44](https://leetcode.com/problems/wildcard-matching/) | Hard | Y3 | — | Optional advanced |
| 217 | [Dungeon Game — LC 174](https://leetcode.com/problems/dungeon-game/) | Hard | Y3 | AMZ, MSFT, GOO, UBER, FLIP | Selective |
| 218 | [Maximal Square — LC 221](https://leetcode.com/problems/maximal-square/) | Medium | Y2 | GOO*, AMZ, MSFT, GOO, FLIP, PHONEPE | New |
| 219 | [Decode Ways — LC 91](https://leetcode.com/problems/decode-ways/) | Medium | Y2 | AMZ, MSFT, GOO, ADB, UBER, GS | New |
| 220 | [Interleaving String — LC 97](https://leetcode.com/problems/interleaving-string/) | Medium | Y3 | — | Selective |

## R. Bit Manipulation and Basic Math — 8

| # | Problem | Level | Suggested phase | Company dataset tags | Your status |
|---:|---|---|---|---|---|
| 221 | [Single Number — LC 136](https://leetcode.com/problems/single-number/) | Easy | Y2 | GS, ACC | New |
| 222 | [Counting Bits — LC 338](https://leetcode.com/problems/counting-bits/) | Easy | Y2 | — | New |
| 223 | [Number of 1 Bits — LC 191](https://leetcode.com/problems/number-of-1-bits/) | Easy | Y2 | — | New |
| 224 | [Reverse Bits — LC 190](https://leetcode.com/problems/reverse-bits/) | Easy | Y2 | — | New |
| 225 | [Missing Number — LC 268](https://leetcode.com/problems/missing-number/) | Easy | Y2 | — | New |
| 226 | [Power of Two — LC 231](https://leetcode.com/problems/power-of-two/) | Easy | Y2 | — | New |
| 227 | [Happy Number — LC 202](https://leetcode.com/problems/happy-number/) | Easy | Y2 | — | New |
| 228 | [Count Primes — LC 204](https://leetcode.com/problems/count-primes/) | Medium | Y3 | GS, ACC | Selective |

## S. Data Structure Design — 8

| # | Problem | Level | Suggested phase | Company dataset tags | Your status |
|---:|---|---|---|---|---|
| 229 | [Insert Delete GetRandom O(1) — LC 380](https://leetcode.com/problems/insert-delete-getrandom-o1/) | Medium | Y3 | — | Selective |
| 230 | [LFU Cache — LC 460](https://leetcode.com/problems/lfu-cache/) | Hard | Y3 | — | Optional advanced |
| 231 | [Time Based Key-Value Store — LC 981](https://leetcode.com/problems/time-based-key-value-store/) | Medium | Y3 | — | Selective — HashMap + Binary Search |
| 232 | [Design HashSet — LC 705](https://leetcode.com/problems/design-hashset/) | Easy | Y2 | — | Optional implementation exercise |
| 233 | [Design HashMap — LC 706](https://leetcode.com/problems/design-hashmap/) | Easy | Y2 | — | Optional implementation exercise |
| 234 | [Logger Rate Limiter — LC 359](https://leetcode.com/problems/logger-rate-limiter/) | Easy | Y3 | — | Selective |
| 235 | [Snapshot Array — LC 1146](https://leetcode.com/problems/snapshot-array/) | Medium | Y3 | — | Optional advanced |
| 236 | [Design Skiplist — LC 1206](https://leetcode.com/problems/design-skiplist/) | Hard | Y3 | — | Optional advanced |

## T. Advanced Mixed Interview Problems — 4

| # | Problem | Level | Suggested phase | Company dataset tags | Your status |
|---:|---|---|---|---|---|
| 237 | [Maximum Profit in Job Scheduling — LC 1235](https://leetcode.com/problems/maximum-profit-in-job-scheduling/) | Hard | Y3 | GOO*, AMZ, MSFT, UBER, PHONEPE | Selective — DP + Binary Search |
| 238 | [Minimum Number of Taps to Open to Water a Garden — LC 1326](https://leetcode.com/problems/minimum-number-of-taps-to-open-to-water-a-garden/) | Hard | Y3 | — | Selective — Greedy + Intervals |
| 239 | [Swim in Rising Water — LC 778](https://leetcode.com/problems/swim-in-rising-water/) | Hard | Y3 | — | Selective — Graph + Heap / Binary Search |
| 240 | [Shortest Path in Binary Matrix — LC 1091](https://leetcode.com/problems/shortest-path-in-binary-matrix/) | Medium | Y3 | — | Selective — BFS + shortest path |

## Important existing work — do not duplicate

Before assigning a new problem, use:
- `00_DSA_Progress_Inventory.md`
- Your existing Tree 58-problem roadmap and current Tree revision files.
- Your Queue v6 roadmap and revision notes.
- Your Stack master tracker / audited remaining roadmap.
- Your Linked List 115-problem roadmap.
- Your Recursion & Backtracking roadmap (first 60 exercises are recorded as complete).
- Your DP Master pattern file.

The following problems were already reported as practised and are marked Review above: Group Anagrams, Top K Frequent Elements, Reverse String, Two Sum II, Valid Palindrome, Longest Substring Without Repeating Characters, Binary Search (verify exact LC problem), Trapping Rain Water and Maximum Subarray/Kadane's.

## Weekly execution model

- 4–5 sessions: one new core problem or one scheduled re-solve.
- 1 session: one mixed, unlabeled problem or a timed mock interview.
- 1 session: rest, backlog recovery or revision.
- For every solved problem, record the brute-force approach, optimisation, invariant/state, Java code, edge cases and complexity.
- Re-solve at R1 (2–3 days), R2 (about 7 days) and R3 (about 30 days).
- Mark **Interview-ready** only when you can reconstruct and explain the solution without notes.

## Company dataset source and snapshot

Company tags above were checked against the public CSV collections in [liquidslr/leetcode-company-wise-problems](https://github.com/liquidslr/leetcode-company-wise-problems). The latest repository commit checked for this v1 list was [“Update Problem [Oct 20]” (21 Oct 2026 UTC)](https://github.com/liquidslr/leetcode-company-wise-problems/commit/2b71796266751b4736a7ef180efb6847879166ee). The repository contains company-specific “Thirty Days” and “All” CSV files. Frequency values are platform tag data; use them for prioritisation, not as predictions. Some target-company CSVs have very small or empty 30-day lists, so their all-time tags are not evidence of recent interview activity.

Secondary learning references:
- [LeetCode 75](https://leetcode.com/studyplan/leetcode-75/) — smaller baseline, not the whole plan.
- [NeetCode Roadmap](https://neetcode.io/roadmap) — pattern learning sequence.
- [Company-Wise problem dataset](https://github.com/liquidslr/leetcode-company-wise-problems) — tags and CSV lists.

## Version history

- **v1 — 22 Nov 2026:** Initial 240-problem interview bank. It is deliberately curated; advanced CP topics are excluded.
