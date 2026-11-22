> **ARCHIVED / SUPERSEDED:** This 236-problem pattern-wise draft is retained for history only. The active final schedule is [Three-Year DSA Interview Master Bank — Final 350 v3](00_DSA_Three_Year_Pattern_Wise_Final_Problem_Bank_v3.md). Do not use this v2 file as the current schedule.

# Three-Year Pattern-Wise DSA Interview Problem Bank — Final v2

> **Scope:** Interview-focused DSA for fresher / SDE-1 and product-company coding interviews. This is a deliberately curated bank, not a competitive-programming syllabus and not a list of every problem available online.
>
> **Language:** Java. **One canonical entry per problem.** Company tags are attached to the problem; they are not separate problem copies.

## 1. Your actual three-year study calendar

**Planning dates:** 23 November 2026 to 22 November 2029, inclusive.

| Time allocation | Days |
|---|---:|
| Total calendar days | 1,096 |
| Saturdays + Sundays (no new problem sessions) | 312 |
| Weekdays available | 784 |
| Additional weekday buffer for holidays, travel, illness, family commitments and recovery | −100 |
| **Planned weekday learning sessions** | **684** |

The 100-day buffer is intentionally twice the original 50-day allowance. It is a reserve across the three years, not an assumption that exactly 100 public holidays exist.

### Year-by-year capacity

| Phase | Date range | Weekdays | Extra buffer | Planned weekday sessions |
|---|---|---:|---:|---:|
| Year 1 | 23 Nov 2026 – 22 Nov 2027 | 261 | 33 | 228 |
| Year 2 | 23 Nov 2027 – 22 Nov 2028 | 262 | 34 | 228 |
| Year 3 | 23 Nov 2028 – 22 Nov 2029 | 261 | 33 | 228 |
| **Total** | **3 years** | **784** | **100** | **684** |

## 2. How the 684 weekday sessions will be used

The curated bank contains **236 distinct problems across 33 pattern groups**. Do not inflate it to 684 just to occupy every weekday. Re-solving and interview execution are more valuable than adding low-value questions.

| Year | First-time problems from this bank | Remaining weekday sessions for revision, variations, mixed practice and mocks |
|---|---:|---:|
| Year 1 — pattern foundations | 100 | 128 |
| Year 2 — trees, graphs, greedy, backtracking and core DP | 119 | 109 |
| Year 3 — selective advanced patterns, integration and interview execution | 17 | 211 |
| **Total** | **236** | **448** |

Every planned weekday remains one focused DSA session. On a “revision” weekday, the task is to solve or reconstruct one previously selected problem, not to add a random new problem.

## 3. Weekly routine

**Monday–Friday:** one focused problem session per day (30–60 minutes). Start with understanding and brute force, derive the pattern, code in Java, test edge cases, state complexity and explain the solution aloud.

**Saturday:** no new problem. Revisit the first part of the five weekday problems from memory; compare your approach with your saved notes only after attempting recall.

**Sunday:** no new problem. Finish revision of the remaining weekday problems, identify weak points and rest. Do not turn the weekend into a catch-up grind.

**Revision intervals:** same-day recap (R0), 2–3 days (R1), about 7 days (R2), about 30 days (R3). Weekend review covers the five problems from that week; weekday revision sessions are used for older weak problems and mixed practice.

## 4. Year-by-year learning gates

### Year 1 — Foundations and pattern recognition
Complete the Y1 rows in the order shown. Use your existing notes for Linked Lists, Stack and Queue rather than re-learning the same basics. The goal is to recognise HashMap, Two Pointers, Sliding Window, Prefix Sum, Binary Search, Intervals, Cyclic Sort, pointer patterns, stacks and queues without being told the pattern.

**Gate:** solve unseen Easy/Medium problems from these patterns, explain the invariant, and code Java reliably.

### Year 2 — Trees, graph patterns and core algorithmic reasoning
Complete the Y2 rows. Focus on recursive return values in trees, BFS levels, BST ordering, heaps, greedy proofs, backtracking choices, graph traversal, topological sorting, union-find and shortest paths. Complete core 1D DP examples and derive states.

**Gate:** solve mixed Medium problems with no topic label; derive recurrence/state or graph strategy and explain why it is correct.

### Year 3 — DP depth, integration and interview execution
Complete the Y3 rows selectively and spend more time on re-solving, company-filtered practice, timed rounds, variations and mock interviews. Do not pursue advanced topics merely to complete a checklist.

**Gate:** communicate clearly, test your own code, analyse complexity, handle follow-ups, and recover calmly when the first approach fails.

## 5. How to read the problem list

- **Y1 / Y2 / Y3** means the suggested phase, not a strict deadline.
- **Existing-work note** tells you whether this problem was previously mentioned or belongs to an existing topic tracker. Search your own notes before assigning it as a new problem.
- **Company tags** come from a company-tagged LeetCode CSV snapshot. A company tag is a selection clue, not proof of a live or guaranteed interview question.
- ***** after a company code means the problem appeared in that company's “Thirty Days” CSV in the checked snapshot; no asterisk means it appeared in the “All” CSV.
- A blank company tag means no tag was captured for this selected company set, not that the company never asks it.

Company codes: AMZ Amazon; MSFT Microsoft; GOO Google; ADB Adobe; ATL Atlassian; UBER Uber; FLIP Flipkart; PHONEPE PhonePe; GS Goldman Sachs; MORGAN Morgan Stanley; ACC Accenture.

## 01. HashMap / HashSet / Frequency Counting — 15 problems

| # | LeetCode problem | Difficulty | Phase | Company dataset tags | Existing-work note |
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

## 02. Two Pointers / In-place Partitioning — 12 problems

| # | LeetCode problem | Difficulty | Phase | Company dataset tags | Existing-work note |
|---:|---|---|---|---|---|
| 16 | [Valid Palindrome — LC 125](https://leetcode.com/problems/valid-palindrome/) | Easy | Y1 | AMZ, MSFT, GOO, ADB, UBER, ACC | Review — previously practised |
| 17 | [Two Sum II — Input Array Is Sorted — LC 167](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/) | Medium | Y1 | — | Review — previously practised |
| 18 | [3Sum — LC 15](https://leetcode.com/problems/3sum/) | Medium | Y1 | AMZ*, MSFT*, GOO*, ADB, FLIP, PHONEPE, GS, MORGAN, ACC | New |
| 19 | [4Sum — LC 18](https://leetcode.com/problems/4sum/) | Medium | Y1 | — | New |
| 20 | [Container With Most Water — LC 11](https://leetcode.com/problems/container-with-most-water/) | Medium | Y1 | AMZ*, GOO*, FLIP*, MSFT, ADB, UBER, GS, MORGAN, ACC | New |
| 21 | [Trapping Rain Water — LC 42](https://leetcode.com/problems/trapping-rain-water/) | Hard | Y1 | AMZ*, MSFT*, GOO*, GS*, ADB, UBER, FLIP, PHONEPE, ACC | Review — previously practised; compare stack approach |
| 22 | [Remove Duplicates from Sorted Array — LC 26](https://leetcode.com/problems/remove-duplicates-from-sorted-array/) | Easy | Y1 | MSFT*, AMZ, GOO, ADB, UBER, ACC | New |
| 23 | [Move Zeroes — LC 283](https://leetcode.com/problems/move-zeroes/) | Easy | Y1 | AMZ*, MSFT*, GOO*, ADB, UBER, ACC | New |
| 24 | [Squares of a Sorted Array — LC 977](https://leetcode.com/problems/squares-of-a-sorted-array/) | Easy | Y1 | AMZ, MSFT, GOO, ADB, UBER | New |
| 25 | [Backspace String Compare — LC 844](https://leetcode.com/problems/backspace-string-compare/) | Easy | Y1 | — | New |
| 26 | [Boats to Save People — LC 881](https://leetcode.com/problems/boats-to-save-people/) | Medium | Y1 | — | New |
| 27 | [Sort Colors — LC 75](https://leetcode.com/problems/sort-colors/) | Medium | Y1 | MSFT*, AMZ, MSFT, GOO, ADB, UBER, FLIP, GS, MORGAN | Previously next in your sorting tracker — verify |

## 03. Sliding Window — 10 problems

| # | LeetCode problem | Difficulty | Phase | Company dataset tags | Existing-work note |
|---:|---|---|---|---|---|
| 28 | [Longest Substring Without Repeating Characters — LC 3](https://leetcode.com/problems/longest-substring-without-repeating-characters/) | Medium | Y1 | AMZ*, MSFT*, GOO*, ADB, ATL, UBER, GS, MORGAN, ACC | Review — previously practised |
| 29 | [Longest Repeating Character Replacement — LC 424](https://leetcode.com/problems/longest-repeating-character-replacement/) | Medium | Y1 | — | New |
| 30 | [Permutation in String — LC 567](https://leetcode.com/problems/permutation-in-string/) | Medium | Y1 | — | New |
| 31 | [Find All Anagrams in a String — LC 438](https://leetcode.com/problems/find-all-anagrams-in-a-string/) | Medium | Y1 | — | New |
| 32 | [Minimum Window Substring — LC 76](https://leetcode.com/problems/minimum-window-substring/) | Hard | Y1 | AMZ, MSFT, GOO, ADB, UBER | New |
| 33 | [Max Consecutive Ones III — LC 1004](https://leetcode.com/problems/max-consecutive-ones-iii/) | Medium | Y1 | AMZ*, MSFT*, GOO* | New |
| 34 | [Sliding Window Maximum — LC 239](https://leetcode.com/problems/sliding-window-maximum/) | Hard | Y1 | GOO*, AMZ, MSFT, ADB, UBER, PHONEPE | New |
| 35 | [Minimum Size Subarray Sum — LC 209](https://leetcode.com/problems/minimum-size-subarray-sum/) | Medium | Y1 | — | New |
| 36 | [Maximum Points You Can Obtain from Cards — LC 1423](https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/) | Medium | Y1 | MSFT*, FLIP, AMZ, GOO, UBER, PHONEPE | New |
| 37 | [Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit — LC 1438](https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/) | Medium | Y1 | PHONEPE, AMZ, MSFT, GOO, UBER | New |

## 04. Prefix Sum / Difference Array — 8 problems

| # | LeetCode problem | Difficulty | Phase | Company dataset tags | Existing-work note |
|---:|---|---|---|---|---|
| 38 | [Subarray Sum Equals K — LC 560](https://leetcode.com/problems/subarray-sum-equals-k/) | Medium | Y1 | AMZ*, MSFT*, GOO*, ADB, UBER, FLIP, GS, ACC | New |
| 39 | [Range Sum Query — Immutable — LC 303](https://leetcode.com/problems/range-sum-query-immutable/) | Easy | Y1 | — | New |
| 40 | [Continuous Subarray Sum — LC 523](https://leetcode.com/problems/continuous-subarray-sum/) | Medium | Y1 | — | New |
| 41 | [Contiguous Array — LC 525](https://leetcode.com/problems/contiguous-array/) | Medium | Y1 | MORGAN, ACC | New |
| 42 | [Find Pivot Index — LC 724](https://leetcode.com/problems/find-pivot-index/) | Easy | Y1 | GS, ACC | New |
| 43 | [Corporate Flight Bookings — LC 1109](https://leetcode.com/problems/corporate-flight-bookings/) | Medium | Y1 | GS | New |
| 44 | [Car Pooling — LC 1094](https://leetcode.com/problems/car-pooling/) | Medium | Y1 | GS | New |
| 45 | [Subarray Sums Divisible by K — LC 974](https://leetcode.com/problems/subarray-sums-divisible-by-k/) | Medium | Y1 | — | New |

## 05. Binary Search / Search on Answer — 11 problems

| # | LeetCode problem | Difficulty | Phase | Company dataset tags | Existing-work note |
|---:|---|---|---|---|---|
| 46 | [Binary Search — LC 704](https://leetcode.com/problems/binary-search/) | Easy | Y1 | AMZ*, MSFT, GOO | Review — binary search previously practised; verify exact problem |
| 47 | [Search Insert Position — LC 35](https://leetcode.com/problems/search-insert-position/) | Easy | Y1 | — | New |
| 48 | [Find First and Last Position of Element in Sorted Array — LC 34](https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/) | Medium | Y1 | AMZ*, GOO*, ACC | New |
| 49 | [Search a 2D Matrix — LC 74](https://leetcode.com/problems/search-a-2d-matrix/) | Medium | Y1 | MSFT*, AMZ, MSFT, GOO, ADB, UBER | New |
| 50 | [Search in Rotated Sorted Array — LC 33](https://leetcode.com/problems/search-in-rotated-sorted-array/) | Medium | Y1 | AMZ*, GOO*, MSFT, ADB, UBER, FLIP, GS | New |
| 51 | [Find Minimum in Rotated Sorted Array — LC 153](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/) | Medium | Y1 | AMZ, MSFT, GOO, ADB, UBER, GS | New |
| 52 | [Find Peak Element — LC 162](https://leetcode.com/problems/find-peak-element/) | Medium | Y1 | GOO*, ADB*, AMZ, MSFT, ACC | New |
| 53 | [Koko Eating Bananas — LC 875](https://leetcode.com/problems/koko-eating-bananas/) | Medium | Y1 | AMZ*, GOO*, MSFT, ADB, ATL, UBER, FLIP, ACC | New |
| 54 | [Capacity To Ship Packages Within D Days — LC 1011](https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/) | Medium | Y1 | AMZ*, MSFT, GOO, UBER, FLIP | New |
| 55 | [Find K Closest Elements — LC 658](https://leetcode.com/problems/find-k-closest-elements/) | Medium | Y1 | AMZ, MSFT, GOO, UBER, FLIP | New |
| 56 | [Median of Two Sorted Arrays — LC 4](https://leetcode.com/problems/median-of-two-sorted-arrays/) | Hard | Y1 | AMZ*, MSFT*, GOO*, ADB, UBER, FLIP, GS, ACC | Selective — do after binary-search boundaries |

## 06. Sorting / Merge Intervals / Sweep Line — 9 problems

| # | LeetCode problem | Difficulty | Phase | Company dataset tags | Existing-work note |
|---:|---|---|---|---|---|
| 57 | [Merge Intervals — LC 56](https://leetcode.com/problems/merge-intervals/) | Medium | Y1 | AMZ*, GOO*, MSFT, ADB, ATL, UBER, FLIP, GS, MORGAN, ACC | New |
| 58 | [Insert Interval — LC 57](https://leetcode.com/problems/insert-interval/) | Medium | Y1 | AMZ, MSFT, GOO, UBER, PHONEPE | New |
| 59 | [Non-overlapping Intervals — LC 435](https://leetcode.com/problems/non-overlapping-intervals/) | Medium | Y1 | — | New |
| 60 | [Minimum Number of Arrows to Burst Balloons — LC 452](https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/) | Medium | Y1 | — | New |
| 61 | [Interval List Intersections — LC 986](https://leetcode.com/problems/interval-list-intersections/) | Medium | Y1 | — | New |
| 62 | [Merge Sorted Array — LC 88](https://leetcode.com/problems/merge-sorted-array/) | Easy | Y1 | MSFT, GOO, GS, ACC | New |
| 63 | [Largest Number — LC 179](https://leetcode.com/problems/largest-number/) | Medium | Y1 | GS, ACC | New |
| 64 | [Hand of Straights — LC 846](https://leetcode.com/problems/hand-of-straights/) | Medium | Y1 | — | New |
| 65 | [Task Scheduler — LC 621](https://leetcode.com/problems/task-scheduler/) | Medium | Y1 | AMZ*, UBER | New |

## 07. Cyclic Sort / Index Placement — 2 problems

| # | LeetCode problem | Difficulty | Phase | Company dataset tags | Existing-work note |
|---:|---|---|---|---|---|
| 66 | [First Missing Positive — LC 41](https://leetcode.com/problems/first-missing-positive/) | Hard | Y1 | — | New — cyclic index placement |
| 67 | [Find the Duplicate Number — LC 287](https://leetcode.com/problems/find-the-duplicate-number/) | Medium | Y1 | — | New — cyclic/value-domain reasoning |

## 08. Fast & Slow Pointers / Linked List Cycles — 6 problems

| # | LeetCode problem | Difficulty | Phase | Company dataset tags | Existing-work note |
|---:|---|---|---|---|---|
| 68 | [Linked List Cycle — LC 141](https://leetcode.com/problems/linked-list-cycle/) | Easy | Y1 | AMZ*, MSFT, GOO, ADB, UBER | Check existing Linked List tracker first |
| 69 | [Linked List Cycle II — LC 142](https://leetcode.com/problems/linked-list-cycle-ii/) | Medium | Y1 | — | Check existing Linked List tracker first |
| 70 | [Remove Nth Node From End of List — LC 19](https://leetcode.com/problems/remove-nth-node-from-end-of-list/) | Medium | Y1 | MORGAN, ACC | Check existing Linked List tracker first |
| 71 | [Middle of the Linked List — LC 876](https://leetcode.com/problems/middle-of-the-linked-list/) | Easy | Y1 | — | Check existing Linked List tracker first |
| 72 | [Palindrome Linked List — LC 234](https://leetcode.com/problems/palindrome-linked-list/) | Easy | Y1 | MSFT | Check existing Linked List tracker first |
| 73 | [Intersection of Two Linked Lists — LC 160](https://leetcode.com/problems/intersection-of-two-linked-lists/) | Easy | Y1 | — | Check existing Linked List tracker first |

## 09. Linked List Reversal / Dummy Node / Merge — 8 problems

| # | LeetCode problem | Difficulty | Phase | Company dataset tags | Existing-work note |
|---:|---|---|---|---|---|
| 74 | [Reverse Linked List — LC 206](https://leetcode.com/problems/reverse-linked-list/) | Easy | Y1 | AMZ, MSFT, GOO*, ADB, UBER, ACC | Check existing Linked List tracker first |
| 75 | [Merge Two Sorted Lists — LC 21](https://leetcode.com/problems/merge-two-sorted-lists/) | Easy | Y1 | GS, ACC | Check existing Linked List tracker first |
| 76 | [Reorder List — LC 143](https://leetcode.com/problems/reorder-list/) | Medium | Y1 | — | Check existing Linked List tracker first |
| 77 | [Add Two Numbers — LC 2](https://leetcode.com/problems/add-two-numbers/) | Medium | Y1 | AMZ*, GOO*, MSFT, ADB, UBER | Check existing Linked List tracker first |
| 78 | [Copy List with Random Pointer — LC 138](https://leetcode.com/problems/copy-list-with-random-pointer/) | Medium | Y1 | AMZ*, MSFT, GOO, ADB, UBER, FLIP | Check existing Linked List tracker first |
| 79 | [Reverse Nodes in k-Group — LC 25](https://leetcode.com/problems/reverse-nodes-in-k-group/) | Hard | Y1 | MSFT* | Check existing Linked List tracker first |
| 80 | [Rotate List — LC 61](https://leetcode.com/problems/rotate-list/) | Medium | Y1 | — | Check existing Linked List tracker first |
| 81 | [Partition List — LC 86](https://leetcode.com/problems/partition-list/) | Medium | Y1 | — | Check existing Linked List tracker first |

## 10. Monotonic Stack / Next Greater / Histogram — 6 problems

| # | LeetCode problem | Difficulty | Phase | Company dataset tags | Existing-work note |
|---:|---|---|---|---|---|
| 82 | [Daily Temperatures — LC 739](https://leetcode.com/problems/daily-temperatures/) | Medium | Y1 | GOO, MORGAN | Check existing Stack tracker first |
| 83 | [Next Greater Element I — LC 496](https://leetcode.com/problems/next-greater-element-i/) | Easy | Y1 | GOO*, FLIP | Check existing Stack tracker first |
| 84 | [Next Greater Element II — LC 503](https://leetcode.com/problems/next-greater-element-ii/) | Medium | Y1 | MORGAN | Check existing Stack tracker first |
| 85 | [Largest Rectangle in Histogram — LC 84](https://leetcode.com/problems/largest-rectangle-in-histogram/) | Hard | Y1 | AMZ, GOO, ADB, UBER, FLIP, PHONEPE, ACC | Check existing Stack tracker first |
| 86 | [Car Fleet — LC 853](https://leetcode.com/problems/car-fleet/) | Medium | Y1 | — | Check existing Stack tracker first |
| 87 | [Sum of Subarray Minimums — LC 907](https://leetcode.com/problems/sum-of-subarray-minimums/) | Medium | Y1 | MORGAN | Check existing Stack tracker first |

## 11. Stack Parsing / Simulation — 8 problems

| # | LeetCode problem | Difficulty | Phase | Company dataset tags | Existing-work note |
|---:|---|---|---|---|---|
| 88 | [Valid Parentheses — LC 20](https://leetcode.com/problems/valid-parentheses/) | Easy | Y1 | AMZ*, MSFT*, GOO*, ADB, UBER, FLIP, PHONEPE | Check existing Stack tracker first |
| 89 | [Min Stack — LC 155](https://leetcode.com/problems/min-stack/) | Medium | Y1 | GOO*, AMZ, MSFT, ADB, UBER, FLIP | Check existing Stack tracker first |
| 90 | [Asteroid Collision — LC 735](https://leetcode.com/problems/asteroid-collision/) | Medium | Y1 | AMZ, MSFT, GOO, UBER, FLIP, PHONEPE | Check existing Stack tracker first |
| 91 | [Remove K Digits — LC 402](https://leetcode.com/problems/remove-k-digits/) | Medium | Y1 | AMZ*, GOO*, MSFT, GOO, ADB, PHONEPE | Check existing Stack tracker first |
| 92 | [Simplify Path — LC 71](https://leetcode.com/problems/simplify-path/) | Medium | Y1 | — | Check existing Stack tracker first |
| 93 | [Decode String — LC 394](https://leetcode.com/problems/decode-string/) | Medium | Y1 | — | Check existing Stack tracker first |
| 94 | [Basic Calculator II — LC 227](https://leetcode.com/problems/basic-calculator-ii/) | Medium | Y1 | AMZ*, MSFT, GOO, ADB, UBER | Check existing Stack tracker first |
| 95 | [Longest Valid Parentheses — LC 32](https://leetcode.com/problems/longest-valid-parentheses/) | Hard | Y1 | AMZ*, MSFT, GOO, ADB, MORGAN | Check existing Stack tracker first |

## 12. Queue / Deque / Monotonic Queue — 8 problems

| # | LeetCode problem | Difficulty | Phase | Company dataset tags | Existing-work note |
|---:|---|---|---|---|---|
| 96 | [Number of Recent Calls — LC 933](https://leetcode.com/problems/number-of-recent-calls/) | Easy | Y1 | — | Check existing Queue tracker first |
| 97 | [Design Circular Queue — LC 622](https://leetcode.com/problems/design-circular-queue/) | Medium | Y1 | — | Check existing Queue tracker first |
| 98 | [Design Circular Deque — LC 641](https://leetcode.com/problems/design-circular-deque/) | Medium | Y1 | — | Check existing Queue tracker first |
| 99 | [Implement Stack using Queues — LC 225](https://leetcode.com/problems/implement-stack-using-queues/) | Easy | Y1 | — | Check existing Queue/Stack tracker first |
| 100 | [Implement Queue using Stacks — LC 232](https://leetcode.com/problems/implement-queue-using-stacks/) | Easy | Y1 | — | Check existing Queue/Stack tracker first |
| 101 | [Dota2 Senate — LC 649](https://leetcode.com/problems/dota2-senate/) | Medium | Y2 | — | Check existing Queue tracker first |
| 102 | [Reveal Cards In Increasing Order — LC 950](https://leetcode.com/problems/reveal-cards-in-increasing-order/) | Medium | Y2 | — | Check existing Queue tracker first |
| 103 | [Shortest Subarray with Sum at Least K — LC 862](https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/) | Hard | Y2 | — | Selective — monotonic deque |

## 13. Backtracking / Subsets / Combinations / Permutations — 9 problems

| # | LeetCode problem | Difficulty | Phase | Company dataset tags | Existing-work note |
|---:|---|---|---|---|---|
| 104 | [Subsets — LC 78](https://leetcode.com/problems/subsets/) | Medium | Y2 | AMZ, MSFT, GOO, UBER, FLIP | Check existing Recursion tracker first |
| 105 | [Subsets II — LC 90](https://leetcode.com/problems/subsets-ii/) | Medium | Y2 | — | Check existing Recursion tracker first |
| 106 | [Combinations — LC 77](https://leetcode.com/problems/combinations/) | Medium | Y2 | — | Check existing Recursion tracker first |
| 107 | [Combination Sum — LC 39](https://leetcode.com/problems/combination-sum/) | Medium | Y2 | — | Check existing Recursion tracker first |
| 108 | [Combination Sum II — LC 40](https://leetcode.com/problems/combination-sum-ii/) | Medium | Y2 | — | Check existing Recursion tracker first |
| 109 | [Permutations — LC 46](https://leetcode.com/problems/permutations/) | Medium | Y2 | — | Check existing Recursion tracker first |
| 110 | [Permutations II — LC 47](https://leetcode.com/problems/permutations-ii/) | Medium | Y2 | — | Check existing Recursion tracker first |
| 111 | [Letter Combinations of a Phone Number — LC 17](https://leetcode.com/problems/letter-combinations-of-a-phone-number/) | Medium | Y2 | GOO*, AMZ, MSFT, UBER, PHONEPE, ACC | Check existing Recursion tracker first |
| 112 | [Generate Parentheses — LC 22](https://leetcode.com/problems/generate-parentheses/) | Medium | Y2 | AMZ*, GOO*, MSFT, ADB, UBER, FLIP, MORGAN | Check existing Recursion tracker first |

## 14. Backtracking / Grid Search and Partitioning — 3 problems

| # | LeetCode problem | Difficulty | Phase | Company dataset tags | Existing-work note |
|---:|---|---|---|---|---|
| 113 | [Word Search — LC 79](https://leetcode.com/problems/word-search/) | Medium | Y2 | AMZ*, MSFT, GOO, ATL, UBER, GS, ACC | Check existing Recursion tracker first |
| 114 | [Palindrome Partitioning — LC 131](https://leetcode.com/problems/palindrome-partitioning/) | Medium | Y2 | — | Check existing Recursion tracker first |
| 115 | [Word Search II — LC 212](https://leetcode.com/problems/word-search-ii/) | Hard | Y2 | AMZ*, MSFT, GOO, ATL, UBER, GS, ACC | Selective |

## 15. Tree DFS / Recursion / Path State — 20 problems

| # | LeetCode problem | Difficulty | Phase | Company dataset tags | Existing-work note |
|---:|---|---|---|---|---|
| 116 | [Maximum Depth of Binary Tree — LC 104](https://leetcode.com/problems/maximum-depth-of-binary-tree/) | Easy | Y2 | — | Check existing Tree tracker first |
| 117 | [Diameter of Binary Tree — LC 543](https://leetcode.com/problems/diameter-of-binary-tree/) | Easy | Y2 | — | Check existing Tree tracker first |
| 118 | [Same Tree — LC 100](https://leetcode.com/problems/same-tree/) | Easy | Y2 | — | Check existing Tree tracker first |
| 119 | [Invert Binary Tree — LC 226](https://leetcode.com/problems/invert-binary-tree/) | Easy | Y2 | — | Check existing Tree tracker first |
| 120 | [Balanced Binary Tree — LC 110](https://leetcode.com/problems/balanced-binary-tree/) | Easy | Y2 | — | Check existing Tree tracker first |
| 121 | [Path Sum — LC 112](https://leetcode.com/problems/path-sum/) | Easy | Y2 | — | Check existing Tree tracker first |
| 122 | [Path Sum II — LC 113](https://leetcode.com/problems/path-sum-ii/) | Medium | Y2 | — | Check existing Tree tracker first |
| 123 | [Path Sum III — LC 437](https://leetcode.com/problems/path-sum-iii/) | Medium | Y2 | — | Check existing Tree tracker first |
| 124 | [Lowest Common Ancestor of a Binary Tree — LC 236](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/) | Medium | Y2 | AMZ*, MSFT, GOO, ADB, ATL | Check existing Tree tracker first |
| 125 | [Binary Tree Maximum Path Sum — LC 124](https://leetcode.com/problems/binary-tree-maximum-path-sum/) | Hard | Y2 | AMZ, MSFT, GOO, ADB, UBER, FLIP | Check existing Tree tracker first |
| 126 | [Subtree of Another Tree — LC 572](https://leetcode.com/problems/subtree-of-another-tree/) | Easy | Y2 | — | Check existing Tree tracker first |
| 127 | [Construct Binary Tree from Preorder and Inorder Traversal — LC 105](https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/) | Medium | Y2 | — | Check existing Tree tracker first |
| 128 | [Construct Binary Tree from Inorder and Postorder Traversal — LC 106](https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/) | Medium | Y2 | — | Check existing Tree tracker first |
| 129 | [Flatten Binary Tree to Linked List — LC 114](https://leetcode.com/problems/flatten-binary-tree-to-linked-list/) | Medium | Y2 | — | Check existing Tree tracker first |
| 130 | [Serialize and Deserialize Binary Tree — LC 297](https://leetcode.com/problems/serialize-and-deserialize-binary-tree/) | Hard | Y2 | AMZ, MSFT, GOO, ATL, UBER, FLIP, PHONEPE | Check existing Tree tracker first |
| 131 | [Binary Tree Inorder Traversal — LC 94](https://leetcode.com/problems/binary-tree-inorder-traversal/) | Easy | Y2 | — | Check existing Tree tracker first |
| 132 | [Binary Tree Preorder Traversal — LC 144](https://leetcode.com/problems/binary-tree-preorder-traversal/) | Easy | Y2 | — | Next study item in saved Tree roadmap |
| 133 | [Binary Tree Postorder Traversal — LC 145](https://leetcode.com/problems/binary-tree-postorder-traversal/) | Easy | Y2 | — | Check existing Tree tracker first |
| 134 | [Binary Tree Paths — LC 257](https://leetcode.com/problems/binary-tree-paths/) | Easy | Y2 | — | Check existing Tree tracker first |
| 135 | [Sum Root to Leaf Numbers — LC 129](https://leetcode.com/problems/sum-root-to-leaf-numbers/) | Medium | Y2 | — | Check existing Tree tracker first |

## 16. Tree BFS / Level Order — 5 problems

| # | LeetCode problem | Difficulty | Phase | Company dataset tags | Existing-work note |
|---:|---|---|---|---|---|
| 136 | [Binary Tree Level Order Traversal — LC 102](https://leetcode.com/problems/binary-tree-level-order-traversal/) | Medium | Y2 | — | Check existing Tree/Queue tracker first |
| 137 | [Binary Tree Zigzag Level Order Traversal — LC 103](https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/) | Medium | Y2 | — | Check existing Tree tracker first |
| 138 | [Binary Tree Right Side View — LC 199](https://leetcode.com/problems/binary-tree-right-side-view/) | Medium | Y2 | — | Check existing Tree tracker first |
| 139 | [Average of Levels in Binary Tree — LC 637](https://leetcode.com/problems/average-of-levels-in-binary-tree/) | Easy | Y2 | — | Check existing Tree tracker first |
| 140 | [Populating Next Right Pointers in Each Node — LC 116](https://leetcode.com/problems/populating-next-right-pointers-in-each-node/) | Medium | Y2 | — | Check existing Tree tracker first |

## 17. Binary Search Tree — 5 problems

| # | LeetCode problem | Difficulty | Phase | Company dataset tags | Existing-work note |
|---:|---|---|---|---|---|
| 141 | [Validate Binary Search Tree — LC 98](https://leetcode.com/problems/validate-binary-search-tree/) | Medium | Y2 | — | Check existing Tree tracker first |
| 142 | [Kth Smallest Element in a BST — LC 230](https://leetcode.com/problems/kth-smallest-element-in-a-bst/) | Medium | Y2 | — | Check existing Tree tracker first |
| 143 | [Search in a Binary Search Tree — LC 700](https://leetcode.com/problems/search-in-a-binary-search-tree/) | Easy | Y2 | — | Check existing Tree tracker first |
| 144 | [Insert into a Binary Search Tree — LC 701](https://leetcode.com/problems/insert-into-a-binary-search-tree/) | Medium | Y2 | — | Check existing Tree tracker first |
| 145 | [Lowest Common Ancestor of a Binary Search Tree — LC 235](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/) | Medium | Y2 | — | Check existing Tree tracker first |

## 18. Heap / Top K / Two Heaps — 7 problems

| # | LeetCode problem | Difficulty | Phase | Company dataset tags | Existing-work note |
|---:|---|---|---|---|---|
| 146 | [Kth Largest Element in an Array — LC 215](https://leetcode.com/problems/kth-largest-element-in-an-array/) | Medium | Y2 | AMZ, MSFT, GOO, ADB, UBER, FLIP, GS, MORGAN | New |
| 147 | [Find Median from Data Stream — LC 295](https://leetcode.com/problems/find-median-from-data-stream/) | Hard | Y2 | AMZ*, MSFT, GOO, ADB, UBER, FLIP | New |
| 148 | [K Closest Points to Origin — LC 973](https://leetcode.com/problems/k-closest-points-to-origin/) | Medium | Y2 | AMZ, MSFT, GOO, ADB, UBER | New |
| 149 | [Last Stone Weight — LC 1046](https://leetcode.com/problems/last-stone-weight/) | Easy | Y2 | — | New |
| 150 | [Reorganize String — LC 767](https://leetcode.com/problems/reorganize-string/) | Medium | Y2 | AMZ, GOO, MSFT | New |
| 151 | [Kth Largest Element in a Stream — LC 703](https://leetcode.com/problems/kth-largest-element-in-a-stream/) | Easy | Y2 | — | New |
| 152 | [Top K Frequent Words — LC 692](https://leetcode.com/problems/top-k-frequent-words/) | Medium | Y2 | AMZ, MSFT, GOO, ADB, UBER | New |

## 19. K-Way Merge — 2 problems

| # | LeetCode problem | Difficulty | Phase | Company dataset tags | Existing-work note |
|---:|---|---|---|---|---|
| 153 | [Merge k Sorted Lists — LC 23](https://leetcode.com/problems/merge-k-sorted-lists/) | Hard | Y2 | AMZ*, MSFT, GOO, UBER, FLIP | Cross-link: Linked List |
| 154 | [Smallest Range Covering Elements from K Lists — LC 632](https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists/) | Hard | Y2 | AMZ*, MSFT, GOO, FLIP, PHONEPE | Selective |

## 20. Greedy / Reachability / Scheduling — 9 problems

| # | LeetCode problem | Difficulty | Phase | Company dataset tags | Existing-work note |
|---:|---|---|---|---|---|
| 155 | [Jump Game — LC 55](https://leetcode.com/problems/jump-game/) | Medium | Y2 | AMZ, MSFT*, GOO*, ADB, FLIP, PHONEPE, GS, MORGAN | New |
| 156 | [Jump Game II — LC 45](https://leetcode.com/problems/jump-game-ii/) | Medium | Y2 | AMZ, MSFT, GOO, ADB, FLIP, PHONEPE | New |
| 157 | [Gas Station — LC 134](https://leetcode.com/problems/gas-station/) | Medium | Y2 | AMZ, MSFT, GOO, ADB, FLIP, PHONEPE, GS | New |
| 158 | [Candy — LC 135](https://leetcode.com/problems/candy/) | Hard | Y2 | GS, MORGAN, ACC | Selective |
| 159 | [Partition Labels — LC 763](https://leetcode.com/problems/partition-labels/) | Medium | Y2 | — | New |
| 160 | [Assign Cookies — LC 455](https://leetcode.com/problems/assign-cookies/) | Easy | Y2 | — | New |
| 161 | [Maximum Length of Pair Chain — LC 646](https://leetcode.com/problems/maximum-length-of-pair-chain/) | Medium | Y2 | — | New |
| 162 | [Two City Scheduling — LC 1029](https://leetcode.com/problems/two-city-scheduling/) | Medium | Y2 | — | New |
| 163 | [Queue Reconstruction by Height — LC 406](https://leetcode.com/problems/queue-reconstruction-by-height/) | Medium | Y2 | — | New |

## 21. Graph DFS / BFS / Grid Components — 7 problems

| # | LeetCode problem | Difficulty | Phase | Company dataset tags | Existing-work note |
|---:|---|---|---|---|---|
| 164 | [Number of Islands — LC 200](https://leetcode.com/problems/number-of-islands/) | Medium | Y2 | AMZ*, GOO*, MSFT, ADB, UBER, FLIP, PHONEPE, GS, ACC | New |
| 165 | [Max Area of Island — LC 695](https://leetcode.com/problems/max-area-of-island/) | Medium | Y2 | — | New |
| 166 | [Clone Graph — LC 133](https://leetcode.com/problems/clone-graph/) | Medium | Y2 | — | New |
| 167 | [Rotting Oranges — LC 994](https://leetcode.com/problems/rotting-oranges/) | Medium | Y2 | AMZ*, GOO*, MSFT, ADB, UBER, FLIP | New |
| 168 | [Pacific Atlantic Water Flow — LC 417](https://leetcode.com/problems/pacific-atlantic-water-flow/) | Medium | Y2 | AMZ, MSFT, GOO, ADB, FLIP | New |
| 169 | [Word Ladder — LC 127](https://leetcode.com/problems/word-ladder/) | Hard | Y2 | AMZ, MSFT, GOO, ADB, UBER, FLIP, PHONEPE | Selective |
| 170 | [Find if Path Exists in Graph — LC 1971](https://leetcode.com/problems/find-if-path-exists-in-graph/) | Easy | Y2 | — | New |

## 22. Topological Sort / Union-Find — 8 problems

| # | LeetCode problem | Difficulty | Phase | Company dataset tags | Existing-work note |
|---:|---|---|---|---|---|
| 171 | [Course Schedule — LC 207](https://leetcode.com/problems/course-schedule/) | Medium | Y2 | GOO*, AMZ, MSFT, ADB, UBER, FLIP | New |
| 172 | [Course Schedule II — LC 210](https://leetcode.com/problems/course-schedule-ii/) | Medium | Y2 | AMZ*, GOO*, MSFT, UBER, FLIP | New |
| 173 | [Number of Provinces — LC 547](https://leetcode.com/problems/number-of-provinces/) | Medium | Y2 | AMZ, MSFT, GOO, ADB, UBER | New |
| 174 | [Accounts Merge — LC 721](https://leetcode.com/problems/accounts-merge/) | Medium | Y2 | — | New |
| 175 | [Redundant Connection — LC 684](https://leetcode.com/problems/redundant-connection/) | Medium | Y2 | — | New |
| 176 | [Find Eventual Safe States — LC 802](https://leetcode.com/problems/find-eventual-safe-states/) | Medium | Y2 | — | New |
| 177 | [Number of Operations to Make Network Connected — LC 1319](https://leetcode.com/problems/number-of-operations-to-make-network-connected/) | Medium | Y2 | — | New |
| 178 | [Evaluate Division — LC 399](https://leetcode.com/problems/evaluate-division/) | Medium | Y2 | AMZ*, MSFT, GOO, UBER, FLIP, PHONEPE | New |

## 23. Shortest Path / Minimum Spanning Tree — 5 problems

| # | LeetCode problem | Difficulty | Phase | Company dataset tags | Existing-work note |
|---:|---|---|---|---|---|
| 179 | [Network Delay Time — LC 743](https://leetcode.com/problems/network-delay-time/) | Medium | Y2 | AMZ, MSFT, GOO, UBER | New |
| 180 | [Cheapest Flights Within K Stops — LC 787](https://leetcode.com/problems/cheapest-flights-within-k-stops/) | Medium | Y2 | AMZ, MSFT, GOO, UBER, FLIP | New |
| 181 | [Min Cost to Connect All Points — LC 1584](https://leetcode.com/problems/min-cost-to-connect-all-points/) | Medium | Y2 | — | New |
| 182 | [Shortest Path in Binary Matrix — LC 1091](https://leetcode.com/problems/shortest-path-in-binary-matrix/) | Medium | Y2 | — | Selective — BFS + shortest path |
| 183 | [Swim in Rising Water — LC 778](https://leetcode.com/problems/swim-in-rising-water/) | Hard | Y2 | — | Selective — Graph + Heap / Binary Search |

## 24. DP 1D / Take-Skip — 10 problems

| # | LeetCode problem | Difficulty | Phase | Company dataset tags | Existing-work note |
|---:|---|---|---|---|---|
| 184 | [Climbing Stairs — LC 70](https://leetcode.com/problems/climbing-stairs/) | Easy | Y2 | MSFT*, ACC, GS | Check existing DP notes first |
| 185 | [Min Cost Climbing Stairs — LC 746](https://leetcode.com/problems/min-cost-climbing-stairs/) | Easy | Y2 | — | Check existing DP notes first |
| 186 | [House Robber — LC 198](https://leetcode.com/problems/house-robber/) | Medium | Y2 | AMZ*, GOO*, MSFT, ADB, UBER, PHONEPE | Check existing DP notes first |
| 187 | [House Robber II — LC 213](https://leetcode.com/problems/house-robber-ii/) | Medium | Y2 | — | Check existing DP notes first |
| 188 | [Delete and Earn — LC 740](https://leetcode.com/problems/delete-and-earn/) | Medium | Y2 | MORGAN | Check existing DP notes first |
| 189 | [Maximum Subarray — LC 53](https://leetcode.com/problems/maximum-subarray/) | Medium | Y2 | AMZ*, GOO*, MSFT, ADB, ATL, UBER, PHONEPE, GS, MORGAN, ACC | Review — Kadane's previously practised |
| 190 | [Best Time to Buy and Sell Stock — LC 121](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/) | Easy | Y2 | AMZ*, MSFT*, GOO*, ADB, ATL, UBER, FLIP, PHONEPE, GS, MORGAN, ACC | New / verify |
| 191 | [Best Time to Buy and Sell Stock II — LC 122](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/) | Medium | Y2 | GS, ACC | Check existing DP notes first |
| 192 | [House Robber III — LC 337](https://leetcode.com/problems/house-robber-iii/) | Medium | Y2 | — | Check existing Tree/DP notes first |
| 193 | [Maximum Product Subarray — LC 152](https://leetcode.com/problems/maximum-product-subarray/) | Medium | Y2 | MORGAN | Check existing DP notes first |

## 25. DP Knapsack / Subset Sum — 4 problems

| # | LeetCode problem | Difficulty | Phase | Company dataset tags | Existing-work note |
|---:|---|---|---|---|---|
| 194 | [Coin Change — LC 322](https://leetcode.com/problems/coin-change/) | Medium | Y2 | AMZ*, MSFT, GOO, ADB, UBER, PHONEPE, GS, MORGAN | Check existing DP notes first |
| 195 | [Coin Change II — LC 518](https://leetcode.com/problems/coin-change-2/) | Medium | Y2 | — | Check existing DP notes first |
| 196 | [Partition Equal Subset Sum — LC 416](https://leetcode.com/problems/partition-equal-subset-sum/) | Medium | Y2 | MSFT | Check existing DP notes first |
| 197 | [Target Sum — LC 494](https://leetcode.com/problems/target-sum/) | Medium | Y2 | — | Check existing DP notes first |

## 26. DP Grid / Matrix Paths — 6 problems

| # | LeetCode problem | Difficulty | Phase | Company dataset tags | Existing-work note |
|---:|---|---|---|---|---|
| 198 | [Unique Paths — LC 62](https://leetcode.com/problems/unique-paths/) | Medium | Y2 | — | Check existing DP notes first |
| 199 | [Unique Paths II — LC 63](https://leetcode.com/problems/unique-paths-ii/) | Medium | Y2 | — | Check existing DP notes first |
| 200 | [Minimum Path Sum — LC 64](https://leetcode.com/problems/minimum-path-sum/) | Medium | Y2 | GS | Check existing DP notes first |
| 201 | [Triangle — LC 120](https://leetcode.com/problems/triangle/) | Medium | Y2 | — | Check existing DP notes first |
| 202 | [Maximal Square — LC 221](https://leetcode.com/problems/maximal-square/) | Medium | Y2 | GOO*, AMZ, MSFT, GOO, FLIP, PHONEPE | New |
| 203 | [Dungeon Game — LC 174](https://leetcode.com/problems/dungeon-game/) | Hard | Y3 | AMZ, MSFT, GOO, UBER, FLIP | Selective |

## 27. DP Subsequences / Strings / Palindromes — 10 problems

| # | LeetCode problem | Difficulty | Phase | Company dataset tags | Existing-work note |
|---:|---|---|---|---|---|
| 204 | [Longest Increasing Subsequence — LC 300](https://leetcode.com/problems/longest-increasing-subsequence/) | Medium | Y2 | AMZ, MSFT, GOO, UBER, FLIP, GS, MORGAN | Check existing DP notes first |
| 205 | [Number of Longest Increasing Subsequence — LC 673](https://leetcode.com/problems/number-of-longest-increasing-subsequence/) | Medium | Y2 | — | Check existing DP notes first |
| 206 | [Longest Common Subsequence — LC 1143](https://leetcode.com/problems/longest-common-subsequence/) | Medium | Y2 | MORGAN | Check existing DP notes first |
| 207 | [Edit Distance — LC 72](https://leetcode.com/problems/edit-distance/) | Medium | Y2 | — | Check existing DP notes first |
| 208 | [Distinct Subsequences — LC 115](https://leetcode.com/problems/distinct-subsequences/) | Hard | Y3 | — | Check existing DP notes first |
| 209 | [Word Break — LC 139](https://leetcode.com/problems/word-break/) | Medium | Y2 | — | Check existing DP notes first |
| 210 | [Longest Palindromic Substring — LC 5](https://leetcode.com/problems/longest-palindromic-substring/) | Medium | Y2 | AMZ, MSFT, GOO, ADB, UBER, FLIP, PHONEPE, GS, ACC | New |
| 211 | [Longest Palindromic Subsequence — LC 516](https://leetcode.com/problems/longest-palindromic-subsequence/) | Medium | Y3 | GS | Selective |
| 212 | [Palindromic Substrings — LC 647](https://leetcode.com/problems/palindromic-substrings/) | Medium | Y2 | GS* | New |
| 213 | [Decode Ways — LC 91](https://leetcode.com/problems/decode-ways/) | Medium | Y2 | AMZ, MSFT, GOO, ADB, UBER, GS | New |

## 28. DP State Machine / Scheduling — 4 problems

| # | LeetCode problem | Difficulty | Phase | Company dataset tags | Existing-work note |
|---:|---|---|---|---|---|
| 214 | [Best Time to Buy and Sell Stock III — LC 123](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/) | Hard | Y3 | — | Selective |
| 215 | [Best Time to Buy and Sell Stock with Cooldown — LC 309](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/) | Medium | Y3 | — | Selective |
| 216 | [Best Time to Buy and Sell Stock with Transaction Fee — LC 714](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/) | Medium | Y3 | — | Selective |
| 217 | [Maximum Profit in Job Scheduling — LC 1235](https://leetcode.com/problems/maximum-profit-in-job-scheduling/) | Hard | Y3 | GOO*, AMZ, MSFT, UBER, PHONEPE | Selective — DP + Binary Search |

## 29. Trie / Prefix Search — 3 problems

| # | LeetCode problem | Difficulty | Phase | Company dataset tags | Existing-work note |
|---:|---|---|---|---|---|
| 218 | [Longest Common Prefix — LC 14](https://leetcode.com/problems/longest-common-prefix/) | Easy | Y2 | AMZ*, MSFT*, GOO*, ADB, UBER, PHONEPE | New |
| 219 | [Implement Trie (Prefix Tree) — LC 208](https://leetcode.com/problems/implement-trie-prefix-tree/) | Medium | Y2 | — | New |
| 220 | [Design Add and Search Words Data Structure — LC 211](https://leetcode.com/problems/design-add-and-search-words-data-structure/) | Medium | Y2 | — | New |

## 30. Bit Manipulation — 6 problems

| # | LeetCode problem | Difficulty | Phase | Company dataset tags | Existing-work note |
|---:|---|---|---|---|---|
| 221 | [Single Number — LC 136](https://leetcode.com/problems/single-number/) | Easy | Y3 | GS, ACC | New |
| 222 | [Counting Bits — LC 338](https://leetcode.com/problems/counting-bits/) | Easy | Y3 | — | New |
| 223 | [Number of 1 Bits — LC 191](https://leetcode.com/problems/number-of-1-bits/) | Easy | Y3 | — | New |
| 224 | [Reverse Bits — LC 190](https://leetcode.com/problems/reverse-bits/) | Easy | Y3 | — | New |
| 225 | [Missing Number — LC 268](https://leetcode.com/problems/missing-number/) | Easy | Y3 | — | New |
| 226 | [Power of Two — LC 231](https://leetcode.com/problems/power-of-two/) | Easy | Y3 | — | New |

## 31. Basic Math / Number Patterns — 2 problems

| # | LeetCode problem | Difficulty | Phase | Company dataset tags | Existing-work note |
|---:|---|---|---|---|---|
| 227 | [Happy Number — LC 202](https://leetcode.com/problems/happy-number/) | Easy | Y3 | — | New |
| 228 | [Count Primes — LC 204](https://leetcode.com/problems/count-primes/) | Medium | Y3 | GS, ACC | Selective |

## 32. Matrix Traversal / In-place Matrix Transform — 4 problems

| # | LeetCode problem | Difficulty | Phase | Company dataset tags | Existing-work note |
|---:|---|---|---|---|---|
| 229 | [Set Matrix Zeroes — LC 73](https://leetcode.com/problems/set-matrix-zeroes/) | Medium | Y2 | — | New |
| 230 | [Spiral Matrix — LC 54](https://leetcode.com/problems/spiral-matrix/) | Medium | Y2 | — | New — matrix boundary traversal |
| 231 | [Rotate Image — LC 48](https://leetcode.com/problems/rotate-image/) | Medium | Y2 | — | New — in-place matrix transformation |
| 232 | [Search a 2D Matrix II — LC 240](https://leetcode.com/problems/search-a-2d-matrix-ii/) | Medium | Y2 | — | New — matrix search / staircase |

## 33. Data Structure Design — 4 problems

| # | LeetCode problem | Difficulty | Phase | Company dataset tags | Existing-work note |
|---:|---|---|---|---|---|
| 233 | [LRU Cache — LC 146](https://leetcode.com/problems/lru-cache/) | Medium | Y2 | AMZ, MSFT, GOO, ADB, ATL, UBER, FLIP, PHONEPE, GS, MORGAN, ACC | New — HashMap + doubly linked list |
| 234 | [Time Based Key-Value Store — LC 981](https://leetcode.com/problems/time-based-key-value-store/) | Medium | Y2 | — | New — HashMap + binary search |
| 235 | [Insert Delete GetRandom O(1) — LC 380](https://leetcode.com/problems/insert-delete-getrandom-o1/) | Medium | Y3 | — | Selective — data structure design |
| 236 | [Logger Rate Limiter — LC 359](https://leetcode.com/problems/logger-rate-limiter/) | Easy | Y3 | — | Selective — map + queue/time window |

## 6. Existing work that must be reused

Before marking anything new, inspect these existing sources in your repository:
- Tree: current 58-problem roadmap and the Pattern 1 revision file; next recorded study item is Binary Tree Preorder Traversal.
- Queue: Queue pattern-wise roadmap v6 and existing Pattern 1/2 revision files.
- Stack: master tracker and audited remaining roadmap; some old attempts need independent verification.
- Linked List: existing 115-problem roadmap; use this bank as a selected shortlist, not a replacement.
- Recursion & Backtracking: first 60 exercises are recorded as complete, but interview recognition and explanation still need revision.
- DP: preserve the derivation-first master format; verify state, transition, base case and complexity.

A prior accepted submission, watched explanation or stored code is not automatically “Interview-ready”. Use a no-notes diagnostic.

## 7. Source selection and research basis

Company tags were checked against [liquidslr/leetcode-company-wise-problems](https://github.com/liquidslr/leetcode-company-wise-problems). Its README still labels the dataset “Updated as of 20 Oct, 2025”, but a later source commit dated [21 October 2026 UTC](https://github.com/liquidslr/leetcode-company-wise-problems/commit/2b71796266751b4736a7ef180efb6847879166ee) modified company CSV files, including the selected companies. Therefore, the tags in this bank are a checked snapshot, not a live feed. Recheck the current company CSV before using it to prepare for a specific interview. Frequency tags are platform data and should not be interpreted as guarantees.

Pattern ordering was cross-checked with the [NeetCode roadmap](https://neetcode.io/roadmap), which organises interview preparation around Arrays & Hashing, Two Pointers, Stack, Linked List, Binary Search, Sliding Window, Trees, Tries, Heap, Backtracking, Graphs and Dynamic Programming.

A recent India-focused 2026 interview guide also recommends learning a limited set of patterns deeply and practising the ability to explain and test solutions, rather than grinding large undifferentiated lists: [InterviewPilot — Coding Interview Guide for India, 2 Nov 2026](https://www.interviewpilot.in/blog/coding-interview-guide-india/). Treat third-party guidance as context; individual company rounds vary by team, level and hiring cycle.

## 8. Finality and maintenance rule

This v2 file replaces the earlier data-structure-wise 240-question v1 list as the active three-year problem schedule. Do not maintain two competing master lists. Add or replace a problem only when your actual target-role research or interview feedback shows a meaningful gap. Preserve the old v1 file as history; use this v2 for scheduling.

**Version:** Final v2 — pattern-first, three-year schedule, 100 additional weekday buffer days.
