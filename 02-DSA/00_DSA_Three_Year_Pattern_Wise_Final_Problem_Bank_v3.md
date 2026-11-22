# Three-Year DSA Interview Master Bank — Final 350 v3

> **Canonical schedule:** 350 unique LeetCode problems across 35 problem-solving patterns. Pattern-first, not data-structure-first. Java only. Designed for fresher / SDE-1 and product-company coding interviews; not competitive programming.

## 1. Three-year calendar

**Planning window:** 23 November 2026 – 22 November 2029 inclusive.

| Allocation | Days |
|---|---:|
| Calendar days | 1,096 |
| Saturdays and Sundays (no new problems) | −312 |
| Weekdays available | 784 |
| Extra buffer for holidays, travel, illness and unexpected breaks | −100 |
| **Planned weekday sessions** | **684** |

The 100-day buffer is additional to weekends: 33 days in Year 1, 34 in Year 2 and 33 in Year 3.

## 2. How 350 problems fit into 684 weekday sessions

| Activity | Weekday sessions |
|---|---:|
| First solve of all 350 problems | 350 |
| Third blank-editor attempt for 250 CORE problems | 250 |
| Company-focused mixed sets, variations and timed mocks | 84 |
| **Total** | **684** |

**Every one of the 350 problems gets at least two meaningful attempts:** first solve on a weekday, then a weekend re-solve from memory. The 250 CORE questions get a third independent blank-editor attempt. The remaining 100 COMPANY / STRETCH questions get two full passes and can receive a third attempt when company-target research or your weak areas justify it.

### Year allocation — 228 weekday sessions each year

| Year | New first solves | Third attempts (CORE) | Company sets / variations / mocks | Total |
|---|---:|---:|---:|---:|
| Year 1 — Foundations | 150 | 40 | 38 | 228 |
| Year 2 — Pattern depth | 125 | 90 | 13 | 228 |
| Year 3 — Interview execution | 75 | 120 | 33 | 228 |
| **Total** | **350** | **250** | **84** | **684** |

The year label in each problem row indicates its first attempt. Third attempts and company sessions are scheduled separately. The 100 buffer weekdays are not study targets.

## 3. Weekly routine — no new problems on weekends

- **Monday–Friday:** one new problem or scheduled weekday re-solve each day, usually 30–60 minutes.
- **Saturday:** re-solve two or three problems from the five weekday sessions without looking at notes first.
- **Sunday:** re-solve the remaining two or three, record mistakes and rest.
- Each weekend revisits that week's five problems. Use weekday repeat sessions for older R1/R2/R3 weak problems.
- Do not turn weekends into catch-up days or add new problems.

## 4. Priority tiers

- **CORE (250):** broad reusable interview patterns and representative questions; scheduled for a third blank-editor attempt.
- **COMPANY / STRETCH (100):** company-tagged, deeper or specialised variations; complete the first attempt and weekend re-solve. Third attempt is targeted, not compulsory.

The tier is a prioritisation guide, not a prediction of interview questions. If an existing problem in your repo is already Interview-ready, log it as mastered and use the freed session for a variation or mock—not duplicate practice.

## 5. Company tag legend

AMZ Amazon; MSFT Microsoft; GOO Google; META Meta; ADB Adobe; ATL Atlassian; UBER Uber; FLIP Flipkart; PHONEPE PhonePe; GS Goldman Sachs; MORGAN Morgan Stanley; ACC Accenture.

Tags indicate the problem title appeared in the company's All-time CSV. They are useful search filters, not guarantees of interview questions, hiring rounds or role-level frequency. A dash means no tag was found in the selected company files, not that the company never asks that problem.

## 01. HashMap / HashSet / Frequency Counting — 21 problems

| # | Problem | Difficulty | First-pass year | Tier | Company tags | Existing-work note |
|---:|---|---|---|---|---|---|
| 1 | [Contains Duplicate — LC 217](https://leetcode.com/problems/contains-duplicate/) | Easy | Y1 | COMPANY / STRETCH | — | New |
| 2 | [Two Sum — LC 1](https://leetcode.com/problems/two-sum/) | Easy | Y1 | CORE | AMZ*, MSFT*, GOO*, ADB, ATL, UBER, FLIP, PHONEPE, GS, MORGAN, ACC | New |
| 3 | [Valid Anagram — LC 242](https://leetcode.com/problems/valid-anagram/) | Easy | Y1 | CORE | AMZ*, ACC, GS | New |
| 4 | [Group Anagrams — LC 49](https://leetcode.com/problems/group-anagrams/) | Medium | Y1 | CORE | AMZ*, MSFT*, GOO*, ADB, ATL, UBER, PHONEPE, GS, MORGAN, ACC | Review — previously practised |
| 5 | [Top K Frequent Elements — LC 347](https://leetcode.com/problems/top-k-frequent-elements/) | Medium | Y1 | CORE | AMZ*, GOO*, MSFT, ADB, ATL, UBER, GS | Review — previously practised |
| 6 | [Product of Array Except Self — LC 238](https://leetcode.com/problems/product-of-array-except-self/) | Medium | Y1 | CORE | AMZ*, MSFT, GOO, ADB, UBER | New / verify |
| 7 | [Longest Consecutive Sequence — LC 128](https://leetcode.com/problems/longest-consecutive-sequence/) | Medium | Y1 | CORE | AMZ*, GOO*, MSFT, ADB, ATL, UBER, PHONEPE | New |
| 8 | [Majority Element — LC 169](https://leetcode.com/problems/majority-element/) | Easy | Y1 | CORE | AMZ, MSFT, GOO, ADB, UBER, GS, MORGAN, ACC | New |
| 9 | [Valid Sudoku — LC 36](https://leetcode.com/problems/valid-sudoku/) | Medium | Y1 | CORE | AMZ* | New |
| 10 | [First Unique Character in a String — LC 387](https://leetcode.com/problems/first-unique-character-in-a-string/) | Easy | Y1 | CORE | GS, MORGAN | New |
| 11 | [Ransom Note — LC 383](https://leetcode.com/problems/ransom-note/) | Easy | Y1 | COMPANY / STRETCH | — | New |
| 12 | [Isomorphic Strings — LC 205](https://leetcode.com/problems/isomorphic-strings/) | Easy | Y1 | COMPANY / STRETCH | — | New |
| 13 | [Contains Duplicate II — LC 219](https://leetcode.com/problems/contains-duplicate-ii/) | Easy | Y1 | COMPANY / STRETCH | — | New |
| 14 | [Intersection of Two Arrays II — LC 350](https://leetcode.com/problems/intersection-of-two-arrays-ii/) | Easy | Y1 | COMPANY / STRETCH | — | New |
| 15 | [Find All Numbers Disappeared in an Array — LC 448](https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/) | Easy | Y1 | COMPANY / STRETCH | — | New |
| 16 | [4Sum II — LC 454](https://leetcode.com/problems/4sum-ii/) | Medium | Y1 | CORE | AMZ, MSFT, GOO, META | New candidate — check existing notes |
| 17 | [Word Pattern — LC 290](https://leetcode.com/problems/word-pattern/) | Easy | Y1 | CORE | AMZ, MSFT, GOO, META, UBER | New candidate — check existing notes |
| 18 | [Custom Sort String — LC 791](https://leetcode.com/problems/custom-sort-string/) | Medium | Y1 | CORE | AMZ, MSFT, GOO, META | New candidate — check existing notes |
| 19 | [Least Number of Unique Integers after K Removals — LC 1481](https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals/) | Medium | Y1 | CORE | AMZ, GOO, MORGAN | New candidate — check existing notes |
| 20 | [Find the Difference — LC 389](https://leetcode.com/problems/find-the-difference/) | Easy | Y1 | CORE | AMZ, MSFT, GOO, META, ACC | New candidate — check existing notes |
| 21 | [Unique Number of Occurrences — LC 1207](https://leetcode.com/problems/unique-number-of-occurrences/) | Easy | Y1 | CORE | AMZ, MSFT, GOO, META | New candidate — check existing notes |

## 02. Two Pointers / In-place Partitioning — 17 problems

| # | Problem | Difficulty | First-pass year | Tier | Company tags | Existing-work note |
|---:|---|---|---|---|---|---|
| 22 | [Valid Palindrome — LC 125](https://leetcode.com/problems/valid-palindrome/) | Easy | Y1 | CORE | AMZ, MSFT, GOO, ADB, UBER, ACC | Review — previously practised |
| 23 | [Two Sum II — Input Array Is Sorted — LC 167](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/) | Medium | Y1 | CORE | — | Review — previously practised |
| 24 | [3Sum — LC 15](https://leetcode.com/problems/3sum/) | Medium | Y1 | CORE | AMZ*, MSFT*, GOO*, ADB, FLIP, PHONEPE, GS, MORGAN, ACC | New |
| 25 | [4Sum — LC 18](https://leetcode.com/problems/4sum/) | Medium | Y1 | COMPANY / STRETCH | — | New |
| 26 | [Container With Most Water — LC 11](https://leetcode.com/problems/container-with-most-water/) | Medium | Y1 | CORE | AMZ*, GOO*, FLIP*, MSFT, ADB, UBER, GS, MORGAN, ACC | New |
| 27 | [Trapping Rain Water — LC 42](https://leetcode.com/problems/trapping-rain-water/) | Hard | Y1 | CORE | AMZ*, MSFT*, GOO*, GS*, ADB, UBER, FLIP, PHONEPE, ACC | Review — previously practised; compare stack approach |
| 28 | [Remove Duplicates from Sorted Array — LC 26](https://leetcode.com/problems/remove-duplicates-from-sorted-array/) | Easy | Y1 | CORE | MSFT*, AMZ, GOO, ADB, UBER, ACC | New |
| 29 | [Move Zeroes — LC 283](https://leetcode.com/problems/move-zeroes/) | Easy | Y1 | CORE | AMZ*, MSFT*, GOO*, ADB, UBER, ACC | New |
| 30 | [Squares of a Sorted Array — LC 977](https://leetcode.com/problems/squares-of-a-sorted-array/) | Easy | Y1 | CORE | AMZ, MSFT, GOO, ADB, UBER | New |
| 31 | [Backspace String Compare — LC 844](https://leetcode.com/problems/backspace-string-compare/) | Easy | Y1 | COMPANY / STRETCH | — | New |
| 32 | [Boats to Save People — LC 881](https://leetcode.com/problems/boats-to-save-people/) | Medium | Y1 | COMPANY / STRETCH | — | New |
| 33 | [Sort Colors — LC 75](https://leetcode.com/problems/sort-colors/) | Medium | Y1 | CORE | MSFT*, AMZ, MSFT, GOO, ADB, UBER, FLIP, GS, MORGAN | Previously next in your sorting tracker — verify |
| 34 | [3Sum Closest — LC 16](https://leetcode.com/problems/3sum-closest/) | Medium | Y1 | CORE | AMZ, MSFT, GOO, META, FLIP | New candidate — check existing notes |
| 35 | [Remove Duplicates from Sorted Array II — LC 80](https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/) | Medium | Y1 | CORE | AMZ, MSFT, GOO, META | New candidate — check existing notes |
| 36 | [Reverse Vowels of a String — LC 345](https://leetcode.com/problems/reverse-vowels-of-a-string/) | Easy | Y1 | CORE | AMZ, MSFT, GOO, META | New candidate — check existing notes |
| 37 | [Is Subsequence — LC 392](https://leetcode.com/problems/is-subsequence/) | Easy | Y1 | CORE | AMZ, MSFT, GOO, META, ADB | New candidate — check existing notes |
| 38 | [Valid Triangle Number — LC 611](https://leetcode.com/problems/valid-triangle-number/) | Medium | Y1 | CORE | AMZ, MSFT, GOO, META, GS | New candidate — check existing notes |

## 03. Sliding Window — 15 problems

| # | Problem | Difficulty | First-pass year | Tier | Company tags | Existing-work note |
|---:|---|---|---|---|---|---|
| 39 | [Longest Substring Without Repeating Characters — LC 3](https://leetcode.com/problems/longest-substring-without-repeating-characters/) | Medium | Y1 | CORE | AMZ*, MSFT*, GOO*, ADB, ATL, UBER, GS, MORGAN, ACC | Review — previously practised |
| 40 | [Longest Repeating Character Replacement — LC 424](https://leetcode.com/problems/longest-repeating-character-replacement/) | Medium | Y1 | COMPANY / STRETCH | — | New |
| 41 | [Permutation in String — LC 567](https://leetcode.com/problems/permutation-in-string/) | Medium | Y1 | COMPANY / STRETCH | — | New |
| 42 | [Find All Anagrams in a String — LC 438](https://leetcode.com/problems/find-all-anagrams-in-a-string/) | Medium | Y1 | COMPANY / STRETCH | — | New |
| 43 | [Minimum Window Substring — LC 76](https://leetcode.com/problems/minimum-window-substring/) | Hard | Y1 | CORE | AMZ, MSFT, GOO, ADB, UBER | New |
| 44 | [Max Consecutive Ones III — LC 1004](https://leetcode.com/problems/max-consecutive-ones-iii/) | Medium | Y1 | CORE | AMZ*, MSFT*, GOO* | New |
| 45 | [Sliding Window Maximum — LC 239](https://leetcode.com/problems/sliding-window-maximum/) | Hard | Y1 | CORE | GOO*, AMZ, MSFT, ADB, UBER, PHONEPE | New |
| 46 | [Minimum Size Subarray Sum — LC 209](https://leetcode.com/problems/minimum-size-subarray-sum/) | Medium | Y1 | CORE | — | New |
| 47 | [Maximum Points You Can Obtain from Cards — LC 1423](https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/) | Medium | Y1 | CORE | MSFT*, FLIP, AMZ, GOO, UBER, PHONEPE | New |
| 48 | [Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit — LC 1438](https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/) | Medium | Y1 | CORE | PHONEPE, AMZ, MSFT, GOO, UBER | New |
| 49 | [Fruit Into Baskets — LC 904](https://leetcode.com/problems/fruit-into-baskets/) | Medium | Y1 | CORE | AMZ, MSFT, GOO, META, ADB | New candidate — check existing notes |
| 50 | [Grumpy Bookstore Owner — LC 1052](https://leetcode.com/problems/grumpy-bookstore-owner/) | Medium | Y1 | CORE | AMZ, MSFT, GOO, META | New candidate — check existing notes |
| 51 | [Number of Sub-arrays of Size K and Average Greater than or Equal to Threshold — LC 1343](https://leetcode.com/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/) | Medium | Y1 | CORE | AMZ, MSFT, GOO, META, GS | New candidate — check existing notes |
| 52 | [Minimum Operations to Reduce X to Zero — LC 1658](https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/) | Medium | Y1 | CORE | AMZ, GOO, MORGAN | New candidate — check existing notes |
| 53 | [Replace the Substring for Balanced String — LC 1234](https://leetcode.com/problems/replace-the-substring-for-balanced-string/) | Medium | Y1 | COMPANY / STRETCH | — | New candidate — check existing notes |

## 04. Prefix Sum / Difference Array — 12 problems

| # | Problem | Difficulty | First-pass year | Tier | Company tags | Existing-work note |
|---:|---|---|---|---|---|---|
| 54 | [Subarray Sum Equals K — LC 560](https://leetcode.com/problems/subarray-sum-equals-k/) | Medium | Y1 | CORE | AMZ*, MSFT*, GOO*, ADB, UBER, FLIP, GS, ACC | New |
| 55 | [Range Sum Query — Immutable — LC 303](https://leetcode.com/problems/range-sum-query-immutable/) | Easy | Y1 | CORE | — | New |
| 56 | [Continuous Subarray Sum — LC 523](https://leetcode.com/problems/continuous-subarray-sum/) | Medium | Y1 | COMPANY / STRETCH | — | New |
| 57 | [Contiguous Array — LC 525](https://leetcode.com/problems/contiguous-array/) | Medium | Y1 | CORE | MORGAN, ACC | New |
| 58 | [Find Pivot Index — LC 724](https://leetcode.com/problems/find-pivot-index/) | Easy | Y1 | CORE | GS, ACC | New |
| 59 | [Corporate Flight Bookings — LC 1109](https://leetcode.com/problems/corporate-flight-bookings/) | Medium | Y1 | CORE | GS | New |
| 60 | [Car Pooling — LC 1094](https://leetcode.com/problems/car-pooling/) | Medium | Y1 | CORE | GS | New |
| 61 | [Subarray Sums Divisible by K — LC 974](https://leetcode.com/problems/subarray-sums-divisible-by-k/) | Medium | Y1 | COMPANY / STRETCH | — | New |
| 62 | [Range Sum Query 2D — Immutable — LC 304](https://leetcode.com/problems/range-sum-query-2d-immutable/) | Medium | Y1 | CORE | AMZ, MSFT, GOO, META | New candidate — check existing notes |
| 63 | [Longest Well-Performing Interval — LC 1124](https://leetcode.com/problems/longest-well-performing-interval/) | Medium | Y1 | CORE | GOO | New candidate — check existing notes |
| 64 | [Make Sum Divisible by P — LC 1590](https://leetcode.com/problems/make-sum-divisible-by-p/) | Medium | Y1 | CORE | AMZ, MSFT, GOO, META, PHONEPE | New candidate — check existing notes |
| 65 | [Product of the Last K Numbers — LC 1352](https://leetcode.com/problems/product-of-the-last-k-numbers/) | Medium | Y1 | CORE | AMZ, MSFT, GOO, META | New candidate — check existing notes |

## 05. Binary Search / Search on Answer — 16 problems

| # | Problem | Difficulty | First-pass year | Tier | Company tags | Existing-work note |
|---:|---|---|---|---|---|---|
| 66 | [Binary Search — LC 704](https://leetcode.com/problems/binary-search/) | Easy | Y1 | CORE | AMZ*, MSFT, GOO | Review — binary search previously practised; verify exact problem |
| 67 | [Search Insert Position — LC 35](https://leetcode.com/problems/search-insert-position/) | Easy | Y1 | COMPANY / STRETCH | — | New |
| 68 | [Find First and Last Position of Element in Sorted Array — LC 34](https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/) | Medium | Y1 | COMPANY / STRETCH | AMZ*, GOO*, ACC | New |
| 69 | [Search a 2D Matrix — LC 74](https://leetcode.com/problems/search-a-2d-matrix/) | Medium | Y1 | CORE | MSFT*, AMZ, MSFT, GOO, ADB, UBER | New |
| 70 | [Search in Rotated Sorted Array — LC 33](https://leetcode.com/problems/search-in-rotated-sorted-array/) | Medium | Y1 | CORE | AMZ*, GOO*, MSFT, ADB, UBER, FLIP, GS | New |
| 71 | [Find Minimum in Rotated Sorted Array — LC 153](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/) | Medium | Y1 | CORE | AMZ, MSFT, GOO, ADB, UBER, GS | New |
| 72 | [Find Peak Element — LC 162](https://leetcode.com/problems/find-peak-element/) | Medium | Y1 | CORE | GOO*, ADB*, AMZ, MSFT, ACC | New |
| 73 | [Koko Eating Bananas — LC 875](https://leetcode.com/problems/koko-eating-bananas/) | Medium | Y1 | CORE | AMZ*, GOO*, MSFT, ADB, ATL, UBER, FLIP, ACC | New |
| 74 | [Capacity To Ship Packages Within D Days — LC 1011](https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/) | Medium | Y1 | CORE | AMZ*, MSFT, GOO, UBER, FLIP | New |
| 75 | [Find K Closest Elements — LC 658](https://leetcode.com/problems/find-k-closest-elements/) | Medium | Y1 | CORE | AMZ, MSFT, GOO, UBER, FLIP | New |
| 76 | [Median of Two Sorted Arrays — LC 4](https://leetcode.com/problems/median-of-two-sorted-arrays/) | Hard | Y1 | CORE | AMZ*, MSFT*, GOO*, ADB, UBER, FLIP, GS, ACC | Selective — do after binary-search boundaries |
| 77 | [Sqrt(x) — LC 69](https://leetcode.com/problems/sqrtx/) | Easy | Y1 | CORE | AMZ, MSFT, GOO, META, ADB, UBER, GS | New candidate — check existing notes |
| 78 | [First Bad Version — LC 278](https://leetcode.com/problems/first-bad-version/) | Easy | Y1 | CORE | AMZ, MSFT, GOO, META | New candidate — check existing notes |
| 79 | [Find Smallest Letter Greater Than Target — LC 744](https://leetcode.com/problems/find-smallest-letter-greater-than-target/) | Easy | Y1 | COMPANY / STRETCH | AMZ, GOO, META | New candidate — check existing notes |
| 80 | [Single Element in a Sorted Array — LC 540](https://leetcode.com/problems/single-element-in-a-sorted-array/) | Medium | Y1 | CORE | AMZ, MSFT, GOO, META, GS | New candidate — check existing notes |
| 81 | [Kth Missing Positive Number — LC 1539](https://leetcode.com/problems/kth-missing-positive-number/) | Easy | Y1 | CORE | AMZ, MSFT, GOO, META | New candidate — check existing notes |

## 06. Sorting / Merge Intervals / Sweep Line — 13 problems

| # | Problem | Difficulty | First-pass year | Tier | Company tags | Existing-work note |
|---:|---|---|---|---|---|---|
| 82 | [Merge Intervals — LC 56](https://leetcode.com/problems/merge-intervals/) | Medium | Y1 | CORE | AMZ*, GOO*, MSFT, ADB, ATL, UBER, FLIP, GS, MORGAN, ACC | New |
| 83 | [Insert Interval — LC 57](https://leetcode.com/problems/insert-interval/) | Medium | Y1 | CORE | AMZ, MSFT, GOO, UBER, PHONEPE | New |
| 84 | [Non-overlapping Intervals — LC 435](https://leetcode.com/problems/non-overlapping-intervals/) | Medium | Y1 | CORE | — | New |
| 85 | [Minimum Number of Arrows to Burst Balloons — LC 452](https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/) | Medium | Y1 | COMPANY / STRETCH | — | New |
| 86 | [Interval List Intersections — LC 986](https://leetcode.com/problems/interval-list-intersections/) | Medium | Y1 | COMPANY / STRETCH | — | New |
| 87 | [Merge Sorted Array — LC 88](https://leetcode.com/problems/merge-sorted-array/) | Easy | Y1 | CORE | MSFT, GOO, GS, ACC | New |
| 88 | [Largest Number — LC 179](https://leetcode.com/problems/largest-number/) | Medium | Y1 | CORE | GS, ACC | New |
| 89 | [Hand of Straights — LC 846](https://leetcode.com/problems/hand-of-straights/) | Medium | Y1 | COMPANY / STRETCH | — | New |
| 90 | [Task Scheduler — LC 621](https://leetcode.com/problems/task-scheduler/) | Medium | Y1 | CORE | AMZ*, UBER | New |
| 91 | [Meeting Rooms — LC 252](https://leetcode.com/problems/meeting-rooms/) | Easy | Y1 | CORE | AMZ, MSFT, GOO, META, UBER | New candidate — check existing notes |
| 92 | [Meeting Rooms II — LC 253](https://leetcode.com/problems/meeting-rooms-ii/) | Medium | Y1 | CORE | AMZ, MSFT, GOO, META, ATL, UBER, GS | New candidate — check existing notes |
| 93 | [Remove Covered Intervals — LC 1288](https://leetcode.com/problems/remove-covered-intervals/) | Medium | Y1 | CORE | AMZ, MSFT, GOO, META | New candidate — check existing notes |
| 94 | [My Calendar I — LC 729](https://leetcode.com/problems/my-calendar-i/) | Medium | Y1 | CORE | AMZ, MSFT, GOO, META, UBER | New candidate — check existing notes |

## 07. Cyclic Sort / Index Placement — 3 problems

| # | Problem | Difficulty | First-pass year | Tier | Company tags | Existing-work note |
|---:|---|---|---|---|---|---|
| 95 | [First Missing Positive — LC 41](https://leetcode.com/problems/first-missing-positive/) | Hard | Y1 | CORE | — | New — cyclic index placement |
| 96 | [Find the Duplicate Number — LC 287](https://leetcode.com/problems/find-the-duplicate-number/) | Medium | Y1 | CORE | — | New — cyclic/value-domain reasoning |
| 97 | [Find All Duplicates in an Array — LC 442](https://leetcode.com/problems/find-all-duplicates-in-an-array/) | Medium | Y1 | CORE | AMZ, MSFT, GOO, META | New candidate — check existing notes |

## 08. Fast & Slow Pointers / Linked List Cycles — 7 problems

| # | Problem | Difficulty | First-pass year | Tier | Company tags | Existing-work note |
|---:|---|---|---|---|---|---|
| 98 | [Linked List Cycle — LC 141](https://leetcode.com/problems/linked-list-cycle/) | Easy | Y1 | CORE | AMZ*, MSFT, GOO, ADB, UBER | Check existing Linked List tracker first |
| 99 | [Linked List Cycle II — LC 142](https://leetcode.com/problems/linked-list-cycle-ii/) | Medium | Y1 | COMPANY / STRETCH | — | Check existing Linked List tracker first |
| 100 | [Remove Nth Node From End of List — LC 19](https://leetcode.com/problems/remove-nth-node-from-end-of-list/) | Medium | Y1 | CORE | MORGAN, ACC | Check existing Linked List tracker first |
| 101 | [Middle of the Linked List — LC 876](https://leetcode.com/problems/middle-of-the-linked-list/) | Easy | Y1 | COMPANY / STRETCH | — | Check existing Linked List tracker first |
| 102 | [Palindrome Linked List — LC 234](https://leetcode.com/problems/palindrome-linked-list/) | Easy | Y1 | CORE | MSFT | Check existing Linked List tracker first |
| 103 | [Intersection of Two Linked Lists — LC 160](https://leetcode.com/problems/intersection-of-two-linked-lists/) | Easy | Y1 | CORE | — | Check existing Linked List tracker first |
| 104 | [Circular Array Loop — LC 457](https://leetcode.com/problems/circular-array-loop/) | Medium | Y1 | CORE | AMZ, MSFT, GOO, GS | New candidate — check existing notes |

## 09. Linked List Reversal / Dummy Node / Merge — 13 problems

| # | Problem | Difficulty | First-pass year | Tier | Company tags | Existing-work note |
|---:|---|---|---|---|---|---|
| 105 | [Reverse Linked List — LC 206](https://leetcode.com/problems/reverse-linked-list/) | Easy | Y1 | CORE | AMZ, MSFT, GOO*, ADB, UBER, ACC | Check existing Linked List tracker first |
| 106 | [Merge Two Sorted Lists — LC 21](https://leetcode.com/problems/merge-two-sorted-lists/) | Easy | Y1 | CORE | GS, ACC | Check existing Linked List tracker first |
| 107 | [Reorder List — LC 143](https://leetcode.com/problems/reorder-list/) | Medium | Y1 | COMPANY / STRETCH | — | Check existing Linked List tracker first |
| 108 | [Add Two Numbers — LC 2](https://leetcode.com/problems/add-two-numbers/) | Medium | Y1 | CORE | AMZ*, GOO*, MSFT, ADB, UBER | Check existing Linked List tracker first |
| 109 | [Copy List with Random Pointer — LC 138](https://leetcode.com/problems/copy-list-with-random-pointer/) | Medium | Y1 | CORE | AMZ*, MSFT, GOO, ADB, UBER, FLIP | Check existing Linked List tracker first |
| 110 | [Reverse Nodes in k-Group — LC 25](https://leetcode.com/problems/reverse-nodes-in-k-group/) | Hard | Y1 | CORE | MSFT* | Check existing Linked List tracker first |
| 111 | [Rotate List — LC 61](https://leetcode.com/problems/rotate-list/) | Medium | Y1 | COMPANY / STRETCH | — | Check existing Linked List tracker first |
| 112 | [Partition List — LC 86](https://leetcode.com/problems/partition-list/) | Medium | Y1 | COMPANY / STRETCH | — | Check existing Linked List tracker first |
| 113 | [Swap Nodes in Pairs — LC 24](https://leetcode.com/problems/swap-nodes-in-pairs/) | Medium | Y1 | CORE | AMZ, MSFT, GOO, META, UBER, GS | New candidate — check existing notes |
| 114 | [Reverse Linked List II — LC 92](https://leetcode.com/problems/reverse-linked-list-ii/) | Medium | Y1 | CORE | AMZ, MSFT, GOO, META | New candidate — check existing notes |
| 115 | [Odd Even Linked List — LC 328](https://leetcode.com/problems/odd-even-linked-list/) | Medium | Y1 | CORE | AMZ, MSFT, GOO, META | New candidate — check existing notes |
| 116 | [Design Linked List — LC 707](https://leetcode.com/problems/design-linked-list/) | Medium | Y1 | CORE | AMZ, MSFT, GOO, META | New candidate — check existing notes |
| 117 | [Flatten a Multilevel Doubly Linked List — LC 430](https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/) | Medium | Y1 | CORE | AMZ, MSFT, GOO, META, ADB | New candidate — check existing notes |

## 10. Monotonic Stack / Next Greater / Histogram — 9 problems

| # | Problem | Difficulty | First-pass year | Tier | Company tags | Existing-work note |
|---:|---|---|---|---|---|---|
| 118 | [Daily Temperatures — LC 739](https://leetcode.com/problems/daily-temperatures/) | Medium | Y1 | CORE | GOO, MORGAN | Check existing Stack tracker first |
| 119 | [Next Greater Element I — LC 496](https://leetcode.com/problems/next-greater-element-i/) | Easy | Y1 | CORE | GOO*, FLIP | Check existing Stack tracker first |
| 120 | [Next Greater Element II — LC 503](https://leetcode.com/problems/next-greater-element-ii/) | Medium | Y1 | CORE | MORGAN | Check existing Stack tracker first |
| 121 | [Largest Rectangle in Histogram — LC 84](https://leetcode.com/problems/largest-rectangle-in-histogram/) | Hard | Y1 | CORE | AMZ, GOO, ADB, UBER, FLIP, PHONEPE, ACC | Check existing Stack tracker first |
| 122 | [Car Fleet — LC 853](https://leetcode.com/problems/car-fleet/) | Medium | Y1 | COMPANY / STRETCH | — | Check existing Stack tracker first |
| 123 | [Sum of Subarray Minimums — LC 907](https://leetcode.com/problems/sum-of-subarray-minimums/) | Medium | Y1 | COMPANY / STRETCH | MORGAN | Check existing Stack tracker first |
| 124 | [Online Stock Span — LC 901](https://leetcode.com/problems/online-stock-span/) | Medium | Y1 | CORE | AMZ, MSFT, GOO, META, ADB | New candidate — check existing notes |
| 125 | [Final Prices With a Special Discount in a Shop — LC 1475](https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/) | Easy | Y1 | CORE | AMZ, MSFT, GOO, META, UBER | New candidate — check existing notes |
| 126 | [Maximum Width Ramp — LC 962](https://leetcode.com/problems/maximum-width-ramp/) | Medium | Y1 | CORE | AMZ, MSFT, GOO | New candidate — check existing notes |

## 11. Stack Parsing / Simulation — 11 problems

| # | Problem | Difficulty | First-pass year | Tier | Company tags | Existing-work note |
|---:|---|---|---|---|---|---|
| 127 | [Valid Parentheses — LC 20](https://leetcode.com/problems/valid-parentheses/) | Easy | Y1 | CORE | AMZ*, MSFT*, GOO*, ADB, UBER, FLIP, PHONEPE | Check existing Stack tracker first |
| 128 | [Min Stack — LC 155](https://leetcode.com/problems/min-stack/) | Medium | Y1 | CORE | GOO*, AMZ, MSFT, ADB, UBER, FLIP | Check existing Stack tracker first |
| 129 | [Asteroid Collision — LC 735](https://leetcode.com/problems/asteroid-collision/) | Medium | Y1 | CORE | AMZ, MSFT, GOO, UBER, FLIP, PHONEPE | Check existing Stack tracker first |
| 130 | [Remove K Digits — LC 402](https://leetcode.com/problems/remove-k-digits/) | Medium | Y1 | CORE | AMZ*, GOO*, MSFT, GOO, ADB, PHONEPE | Check existing Stack tracker first |
| 131 | [Simplify Path — LC 71](https://leetcode.com/problems/simplify-path/) | Medium | Y1 | COMPANY / STRETCH | — | Check existing Stack tracker first |
| 132 | [Decode String — LC 394](https://leetcode.com/problems/decode-string/) | Medium | Y1 | COMPANY / STRETCH | — | Check existing Stack tracker first |
| 133 | [Basic Calculator II — LC 227](https://leetcode.com/problems/basic-calculator-ii/) | Medium | Y1 | CORE | AMZ*, MSFT, GOO, ADB, UBER | Check existing Stack tracker first |
| 134 | [Longest Valid Parentheses — LC 32](https://leetcode.com/problems/longest-valid-parentheses/) | Hard | Y1 | CORE | AMZ*, MSFT, GOO, ADB, MORGAN | Check existing Stack tracker first |
| 135 | [Evaluate Reverse Polish Notation — LC 150](https://leetcode.com/problems/evaluate-reverse-polish-notation/) | Medium | Y1 | CORE | AMZ, MSFT, GOO, META, GS | New candidate — check existing notes |
| 136 | [Basic Calculator — LC 224](https://leetcode.com/problems/basic-calculator/) | Hard | Y1 | CORE | AMZ, MSFT, GOO, META, ADB, UBER | New candidate — check existing notes |
| 137 | [Validate Stack Sequences — LC 946](https://leetcode.com/problems/validate-stack-sequences/) | Medium | Y1 | COMPANY / STRETCH | AMZ, MSFT, GOO, META | New candidate — check existing notes |

## 12. Queue / Deque / Monotonic Queue — 10 problems

| # | Problem | Difficulty | First-pass year | Tier | Company tags | Existing-work note |
|---:|---|---|---|---|---|---|
| 138 | [Number of Recent Calls — LC 933](https://leetcode.com/problems/number-of-recent-calls/) | Easy | Y1 | CORE | — | Check existing Queue tracker first |
| 139 | [Design Circular Queue — LC 622](https://leetcode.com/problems/design-circular-queue/) | Medium | Y1 | CORE | — | Check existing Queue tracker first |
| 140 | [Design Circular Deque — LC 641](https://leetcode.com/problems/design-circular-deque/) | Medium | Y1 | CORE | — | Check existing Queue tracker first |
| 141 | [Implement Stack using Queues — LC 225](https://leetcode.com/problems/implement-stack-using-queues/) | Easy | Y1 | CORE | — | Check existing Queue/Stack tracker first |
| 142 | [Implement Queue using Stacks — LC 232](https://leetcode.com/problems/implement-queue-using-stacks/) | Easy | Y1 | CORE | — | Check existing Queue/Stack tracker first |
| 143 | [Dota2 Senate — LC 649](https://leetcode.com/problems/dota2-senate/) | Medium | Y1 | CORE | — | Check existing Queue tracker first |
| 144 | [Reveal Cards In Increasing Order — LC 950](https://leetcode.com/problems/reveal-cards-in-increasing-order/) | Medium | Y1 | COMPANY / STRETCH | — | Check existing Queue tracker first |
| 145 | [Shortest Subarray with Sum at Least K — LC 862](https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/) | Hard | Y1 | COMPANY / STRETCH | — | Selective — monotonic deque |
| 146 | [Moving Average from Data Stream — LC 346](https://leetcode.com/problems/moving-average-from-data-stream/) | Easy | Y1 | CORE | AMZ, MSFT, GOO, META | New candidate — check existing notes |
| 147 | [Design Front Middle Back Queue — LC 1670](https://leetcode.com/problems/design-front-middle-back-queue/) | Medium | Y1 | CORE | AMZ, GOO | New candidate — check existing notes |

## 13. Backtracking / Subsets / Combinations / Permutations — 16 problems

| # | Problem | Difficulty | First-pass year | Tier | Company tags | Existing-work note |
|---:|---|---|---|---|---|---|
| 148 | [Subsets — LC 78](https://leetcode.com/problems/subsets/) | Medium | Y1 | CORE | AMZ, MSFT, GOO, UBER, FLIP | Check existing Recursion tracker first |
| 149 | [Subsets II — LC 90](https://leetcode.com/problems/subsets-ii/) | Medium | Y1 | COMPANY / STRETCH | — | Check existing Recursion tracker first |
| 150 | [Combinations — LC 77](https://leetcode.com/problems/combinations/) | Medium | Y1 | COMPANY / STRETCH | — | Check existing Recursion tracker first |
| 151 | [Combination Sum — LC 39](https://leetcode.com/problems/combination-sum/) | Medium | Y2 | COMPANY / STRETCH | — | Check existing Recursion tracker first |
| 152 | [Combination Sum II — LC 40](https://leetcode.com/problems/combination-sum-ii/) | Medium | Y2 | COMPANY / STRETCH | — | Check existing Recursion tracker first |
| 153 | [Permutations — LC 46](https://leetcode.com/problems/permutations/) | Medium | Y2 | COMPANY / STRETCH | — | Check existing Recursion tracker first |
| 154 | [Permutations II — LC 47](https://leetcode.com/problems/permutations-ii/) | Medium | Y2 | COMPANY / STRETCH | — | Check existing Recursion tracker first |
| 155 | [Letter Combinations of a Phone Number — LC 17](https://leetcode.com/problems/letter-combinations-of-a-phone-number/) | Medium | Y2 | CORE | GOO*, AMZ, MSFT, UBER, PHONEPE, ACC | Check existing Recursion tracker first |
| 156 | [Generate Parentheses — LC 22](https://leetcode.com/problems/generate-parentheses/) | Medium | Y2 | CORE | AMZ*, GOO*, MSFT, ADB, UBER, FLIP, MORGAN | Check existing Recursion tracker first |
| 157 | [Combination Sum III — LC 216](https://leetcode.com/problems/combination-sum-iii/) | Medium | Y2 | CORE | AMZ, MSFT, GOO | New candidate — check existing notes |
| 158 | [Word Break II — LC 140](https://leetcode.com/problems/word-break-ii/) | Hard | Y2 | CORE | AMZ, MSFT, GOO, META, UBER | New candidate — check existing notes |
| 159 | [Non-decreasing Subsequences — LC 491](https://leetcode.com/problems/non-decreasing-subsequences/) | Medium | Y2 | CORE | AMZ, MSFT, GOO | New candidate — check existing notes |
| 160 | [N-Queens II — LC 52](https://leetcode.com/problems/n-queens-ii/) | Hard | Y2 | CORE | AMZ, MSFT, GOO, META | New candidate — check existing notes |
| 161 | [Partition to K Equal Sum Subsets — LC 698](https://leetcode.com/problems/partition-to-k-equal-sum-subsets/) | Medium | Y2 | CORE | AMZ, MSFT, GOO, META | New candidate — check existing notes |
| 162 | [Matchsticks to Square — LC 473](https://leetcode.com/problems/matchsticks-to-square/) | Medium | Y2 | CORE | AMZ, GOO, META, PHONEPE | New candidate — check existing notes |
| 163 | [Expression Add Operators — LC 282](https://leetcode.com/problems/expression-add-operators/) | Hard | Y2 | CORE | AMZ, GOO, META | New candidate — check existing notes |

## 14. Backtracking / Grid Search and Partitioning — 3 problems

| # | Problem | Difficulty | First-pass year | Tier | Company tags | Existing-work note |
|---:|---|---|---|---|---|---|
| 164 | [Word Search — LC 79](https://leetcode.com/problems/word-search/) | Medium | Y2 | CORE | AMZ*, MSFT, GOO, ATL, UBER, GS, ACC | Check existing Recursion tracker first |
| 165 | [Palindrome Partitioning — LC 131](https://leetcode.com/problems/palindrome-partitioning/) | Medium | Y2 | COMPANY / STRETCH | — | Check existing Recursion tracker first |
| 166 | [Word Search II — LC 212](https://leetcode.com/problems/word-search-ii/) | Hard | Y2 | CORE | AMZ*, MSFT, GOO, ATL, UBER, GS, ACC | Selective |

## 15. Tree DFS / Recursion / Path State — 26 problems

| # | Problem | Difficulty | First-pass year | Tier | Company tags | Existing-work note |
|---:|---|---|---|---|---|---|
| 167 | [Maximum Depth of Binary Tree — LC 104](https://leetcode.com/problems/maximum-depth-of-binary-tree/) | Easy | Y2 | CORE | — | Check existing Tree tracker first |
| 168 | [Diameter of Binary Tree — LC 543](https://leetcode.com/problems/diameter-of-binary-tree/) | Easy | Y2 | COMPANY / STRETCH | — | Check existing Tree tracker first |
| 169 | [Same Tree — LC 100](https://leetcode.com/problems/same-tree/) | Easy | Y2 | CORE | — | Check existing Tree tracker first |
| 170 | [Invert Binary Tree — LC 226](https://leetcode.com/problems/invert-binary-tree/) | Easy | Y2 | CORE | — | Check existing Tree tracker first |
| 171 | [Balanced Binary Tree — LC 110](https://leetcode.com/problems/balanced-binary-tree/) | Easy | Y2 | CORE | — | Check existing Tree tracker first |
| 172 | [Path Sum — LC 112](https://leetcode.com/problems/path-sum/) | Easy | Y2 | CORE | — | Check existing Tree tracker first |
| 173 | [Path Sum II — LC 113](https://leetcode.com/problems/path-sum-ii/) | Medium | Y2 | COMPANY / STRETCH | — | Check existing Tree tracker first |
| 174 | [Path Sum III — LC 437](https://leetcode.com/problems/path-sum-iii/) | Medium | Y2 | COMPANY / STRETCH | — | Check existing Tree tracker first |
| 175 | [Lowest Common Ancestor of a Binary Tree — LC 236](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/) | Medium | Y2 | CORE | AMZ*, MSFT, GOO, ADB, ATL | Check existing Tree tracker first |
| 176 | [Binary Tree Maximum Path Sum — LC 124](https://leetcode.com/problems/binary-tree-maximum-path-sum/) | Hard | Y2 | CORE | AMZ, MSFT, GOO, ADB, UBER, FLIP | Check existing Tree tracker first |
| 177 | [Subtree of Another Tree — LC 572](https://leetcode.com/problems/subtree-of-another-tree/) | Easy | Y2 | COMPANY / STRETCH | — | Check existing Tree tracker first |
| 178 | [Construct Binary Tree from Preorder and Inorder Traversal — LC 105](https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/) | Medium | Y2 | COMPANY / STRETCH | — | Check existing Tree tracker first |
| 179 | [Construct Binary Tree from Inorder and Postorder Traversal — LC 106](https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/) | Medium | Y2 | COMPANY / STRETCH | — | Check existing Tree tracker first |
| 180 | [Flatten Binary Tree to Linked List — LC 114](https://leetcode.com/problems/flatten-binary-tree-to-linked-list/) | Medium | Y2 | COMPANY / STRETCH | — | Check existing Tree tracker first |
| 181 | [Serialize and Deserialize Binary Tree — LC 297](https://leetcode.com/problems/serialize-and-deserialize-binary-tree/) | Hard | Y2 | CORE | AMZ, MSFT, GOO, ATL, UBER, FLIP, PHONEPE | Check existing Tree tracker first |
| 182 | [Binary Tree Inorder Traversal — LC 94](https://leetcode.com/problems/binary-tree-inorder-traversal/) | Easy | Y2 | CORE | — | Check existing Tree tracker first |
| 183 | [Binary Tree Preorder Traversal — LC 144](https://leetcode.com/problems/binary-tree-preorder-traversal/) | Easy | Y2 | CORE | — | Next study item in saved Tree roadmap |
| 184 | [Binary Tree Postorder Traversal — LC 145](https://leetcode.com/problems/binary-tree-postorder-traversal/) | Easy | Y2 | CORE | — | Check existing Tree tracker first |
| 185 | [Binary Tree Paths — LC 257](https://leetcode.com/problems/binary-tree-paths/) | Easy | Y2 | COMPANY / STRETCH | — | Check existing Tree tracker first |
| 186 | [Sum Root to Leaf Numbers — LC 129](https://leetcode.com/problems/sum-root-to-leaf-numbers/) | Medium | Y2 | COMPANY / STRETCH | — | Check existing Tree tracker first |
| 187 | [Symmetric Tree — LC 101](https://leetcode.com/problems/symmetric-tree/) | Easy | Y2 | CORE | AMZ, MSFT, GOO, META | New candidate — check existing notes |
| 188 | [Minimum Depth of Binary Tree — LC 111](https://leetcode.com/problems/minimum-depth-of-binary-tree/) | Easy | Y2 | CORE | AMZ, MSFT, GOO, META | New candidate — check existing notes |
| 189 | [Find Bottom Left Tree Value — LC 513](https://leetcode.com/problems/find-bottom-left-tree-value/) | Medium | Y2 | CORE | AMZ, MSFT, GOO, META | New candidate — check existing notes |
| 190 | [All Nodes Distance K in Binary Tree — LC 863](https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/) | Medium | Y2 | CORE | AMZ, MSFT, GOO, META | New candidate — check existing notes |
| 191 | [Binary Tree Cameras — LC 968](https://leetcode.com/problems/binary-tree-cameras/) | Hard | Y2 | CORE | AMZ, MSFT, GOO, META, UBER, GS | New candidate — check existing notes |
| 192 | [Longest ZigZag Path in a Binary Tree — LC 1372](https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/) | Medium | Y2 | CORE | AMZ, MSFT | New candidate — check existing notes |

## 16. Tree BFS / Level Order — 7 problems

| # | Problem | Difficulty | First-pass year | Tier | Company tags | Existing-work note |
|---:|---|---|---|---|---|---|
| 193 | [Binary Tree Level Order Traversal — LC 102](https://leetcode.com/problems/binary-tree-level-order-traversal/) | Medium | Y2 | CORE | — | Check existing Tree/Queue tracker first |
| 194 | [Binary Tree Zigzag Level Order Traversal — LC 103](https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/) | Medium | Y2 | CORE | — | Check existing Tree tracker first |
| 195 | [Binary Tree Right Side View — LC 199](https://leetcode.com/problems/binary-tree-right-side-view/) | Medium | Y2 | COMPANY / STRETCH | — | Check existing Tree tracker first |
| 196 | [Average of Levels in Binary Tree — LC 637](https://leetcode.com/problems/average-of-levels-in-binary-tree/) | Easy | Y2 | CORE | — | Check existing Tree tracker first |
| 197 | [Populating Next Right Pointers in Each Node — LC 116](https://leetcode.com/problems/populating-next-right-pointers-in-each-node/) | Medium | Y2 | CORE | — | Check existing Tree tracker first |
| 198 | [Find Largest Value in Each Tree Row — LC 515](https://leetcode.com/problems/find-largest-value-in-each-tree-row/) | Medium | Y2 | CORE | AMZ, MSFT, GOO, META | New candidate — check existing notes |
| 199 | [Maximum Width of Binary Tree — LC 662](https://leetcode.com/problems/maximum-width-of-binary-tree/) | Medium | Y2 | CORE | AMZ, MSFT, GOO, META, FLIP | New candidate — check existing notes |

## 17. Binary Search Tree — 8 problems

| # | Problem | Difficulty | First-pass year | Tier | Company tags | Existing-work note |
|---:|---|---|---|---|---|---|
| 200 | [Validate Binary Search Tree — LC 98](https://leetcode.com/problems/validate-binary-search-tree/) | Medium | Y2 | CORE | — | Check existing Tree tracker first |
| 201 | [Kth Smallest Element in a BST — LC 230](https://leetcode.com/problems/kth-smallest-element-in-a-bst/) | Medium | Y2 | CORE | — | Check existing Tree tracker first |
| 202 | [Search in a Binary Search Tree — LC 700](https://leetcode.com/problems/search-in-a-binary-search-tree/) | Easy | Y2 | CORE | — | Check existing Tree tracker first |
| 203 | [Insert into a Binary Search Tree — LC 701](https://leetcode.com/problems/insert-into-a-binary-search-tree/) | Medium | Y2 | COMPANY / STRETCH | — | Check existing Tree tracker first |
| 204 | [Lowest Common Ancestor of a Binary Search Tree — LC 235](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/) | Medium | Y2 | COMPANY / STRETCH | — | Check existing Tree tracker first |
| 205 | [Binary Search Tree Iterator — LC 173](https://leetcode.com/problems/binary-search-tree-iterator/) | Medium | Y2 | CORE | AMZ, MSFT, GOO, META | New candidate — check existing notes |
| 206 | [Delete Node in a BST — LC 450](https://leetcode.com/problems/delete-node-in-a-bst/) | Medium | Y2 | CORE | AMZ, MSFT, GOO, META, UBER, FLIP | New candidate — check existing notes |
| 207 | [Trim a Binary Search Tree — LC 669](https://leetcode.com/problems/trim-a-binary-search-tree/) | Medium | Y2 | CORE | AMZ, GOO, ADB | New candidate — check existing notes |

## 18. Heap / Top K / Two Heaps — 13 problems

| # | Problem | Difficulty | First-pass year | Tier | Company tags | Existing-work note |
|---:|---|---|---|---|---|---|
| 208 | [Kth Largest Element in an Array — LC 215](https://leetcode.com/problems/kth-largest-element-in-an-array/) | Medium | Y2 | CORE | AMZ, MSFT, GOO, ADB, UBER, FLIP, GS, MORGAN | New |
| 209 | [Find Median from Data Stream — LC 295](https://leetcode.com/problems/find-median-from-data-stream/) | Hard | Y2 | CORE | AMZ*, MSFT, GOO, ADB, UBER, FLIP | New |
| 210 | [K Closest Points to Origin — LC 973](https://leetcode.com/problems/k-closest-points-to-origin/) | Medium | Y2 | CORE | AMZ, MSFT, GOO, ADB, UBER | New |
| 211 | [Last Stone Weight — LC 1046](https://leetcode.com/problems/last-stone-weight/) | Easy | Y2 | COMPANY / STRETCH | — | New |
| 212 | [Reorganize String — LC 767](https://leetcode.com/problems/reorganize-string/) | Medium | Y2 | COMPANY / STRETCH | AMZ, GOO, MSFT | New |
| 213 | [Kth Largest Element in a Stream — LC 703](https://leetcode.com/problems/kth-largest-element-in-a-stream/) | Easy | Y2 | COMPANY / STRETCH | — | New |
| 214 | [Top K Frequent Words — LC 692](https://leetcode.com/problems/top-k-frequent-words/) | Medium | Y2 | CORE | AMZ, MSFT, GOO, ADB, UBER | New |
| 215 | [Kth Smallest Element in a Sorted Matrix — LC 378](https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/) | Medium | Y2 | CORE | AMZ, MSFT, GOO, META, PHONEPE, GS | New candidate — check existing notes |
| 216 | [K-th Smallest Prime Fraction — LC 786](https://leetcode.com/problems/k-th-smallest-prime-fraction/) | Hard | Y2 | COMPANY / STRETCH | — | New candidate — check existing notes |
| 217 | [Single-Threaded CPU — LC 1834](https://leetcode.com/problems/single-threaded-cpu/) | Medium | Y2 | COMPANY / STRETCH | AMZ, MSFT, GOO, META | New candidate — check existing notes |
| 218 | [IPO — LC 502](https://leetcode.com/problems/ipo/) | Hard | Y2 | CORE | AMZ, MSFT, GOO, META, UBER | New candidate — check existing notes |
| 219 | [Furthest Building You Can Reach — LC 1642](https://leetcode.com/problems/furthest-building-you-can-reach/) | Medium | Y2 | CORE | AMZ, GOO, META, UBER, PHONEPE | New candidate — check existing notes |
| 220 | [Find K Pairs with Smallest Sums — LC 373](https://leetcode.com/problems/find-k-pairs-with-smallest-sums/) | Medium | Y2 | CORE | AMZ, MSFT, GOO, META, UBER | New candidate — check existing notes |

## 19. K-Way Merge — 2 problems

| # | Problem | Difficulty | First-pass year | Tier | Company tags | Existing-work note |
|---:|---|---|---|---|---|---|
| 221 | [Merge k Sorted Lists — LC 23](https://leetcode.com/problems/merge-k-sorted-lists/) | Hard | Y2 | CORE | AMZ*, MSFT, GOO, UBER, FLIP | Cross-link: Linked List |
| 222 | [Smallest Range Covering Elements from K Lists — LC 632](https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists/) | Hard | Y2 | COMPANY / STRETCH | AMZ*, MSFT, GOO, FLIP, PHONEPE | Selective |

## 20. Greedy / Reachability / Scheduling — 14 problems

| # | Problem | Difficulty | First-pass year | Tier | Company tags | Existing-work note |
|---:|---|---|---|---|---|---|
| 223 | [Jump Game — LC 55](https://leetcode.com/problems/jump-game/) | Medium | Y2 | CORE | AMZ, MSFT*, GOO*, ADB, FLIP, PHONEPE, GS, MORGAN | New |
| 224 | [Jump Game II — LC 45](https://leetcode.com/problems/jump-game-ii/) | Medium | Y2 | CORE | AMZ, MSFT, GOO, ADB, FLIP, PHONEPE | New |
| 225 | [Gas Station — LC 134](https://leetcode.com/problems/gas-station/) | Medium | Y2 | CORE | AMZ, MSFT, GOO, ADB, FLIP, PHONEPE, GS | New |
| 226 | [Candy — LC 135](https://leetcode.com/problems/candy/) | Hard | Y2 | COMPANY / STRETCH | GS, MORGAN, ACC | Selective |
| 227 | [Partition Labels — LC 763](https://leetcode.com/problems/partition-labels/) | Medium | Y2 | COMPANY / STRETCH | — | New |
| 228 | [Assign Cookies — LC 455](https://leetcode.com/problems/assign-cookies/) | Easy | Y2 | CORE | — | New |
| 229 | [Maximum Length of Pair Chain — LC 646](https://leetcode.com/problems/maximum-length-of-pair-chain/) | Medium | Y2 | COMPANY / STRETCH | — | New |
| 230 | [Two City Scheduling — LC 1029](https://leetcode.com/problems/two-city-scheduling/) | Medium | Y2 | COMPANY / STRETCH | — | New |
| 231 | [Queue Reconstruction by Height — LC 406](https://leetcode.com/problems/queue-reconstruction-by-height/) | Medium | Y2 | COMPANY / STRETCH | — | New |
| 232 | [Advantage Shuffle — LC 870](https://leetcode.com/problems/advantage-shuffle/) | Medium | Y2 | CORE | GOO | New candidate — check existing notes |
| 233 | [Course Schedule III — LC 630](https://leetcode.com/problems/course-schedule-iii/) | Hard | Y2 | CORE | AMZ, MSFT, GOO, META | New candidate — check existing notes |
| 234 | [Maximum Number of Events That Can Be Attended — LC 1353](https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended/) | Medium | Y2 | CORE | AMZ, MSFT, GOO, META, UBER, GS | New candidate — check existing notes |
| 235 | [Merge Triplets to Form Target Triplet — LC 1899](https://leetcode.com/problems/merge-triplets-to-form-target-triplet/) | Medium | Y2 | CORE | GOO | New candidate — check existing notes |
| 236 | [Video Stitching — LC 1024](https://leetcode.com/problems/video-stitching/) | Medium | Y2 | CORE | AMZ, GOO | New candidate — check existing notes |

## 21. Graph DFS / BFS / Grid Components — 12 problems

| # | Problem | Difficulty | First-pass year | Tier | Company tags | Existing-work note |
|---:|---|---|---|---|---|---|
| 237 | [Number of Islands — LC 200](https://leetcode.com/problems/number-of-islands/) | Medium | Y2 | CORE | AMZ*, GOO*, MSFT, ADB, UBER, FLIP, PHONEPE, GS, ACC | New |
| 238 | [Max Area of Island — LC 695](https://leetcode.com/problems/max-area-of-island/) | Medium | Y2 | COMPANY / STRETCH | — | New |
| 239 | [Clone Graph — LC 133](https://leetcode.com/problems/clone-graph/) | Medium | Y2 | COMPANY / STRETCH | — | New |
| 240 | [Rotting Oranges — LC 994](https://leetcode.com/problems/rotting-oranges/) | Medium | Y2 | CORE | AMZ*, GOO*, MSFT, ADB, UBER, FLIP | New |
| 241 | [Pacific Atlantic Water Flow — LC 417](https://leetcode.com/problems/pacific-atlantic-water-flow/) | Medium | Y2 | CORE | AMZ, MSFT, GOO, ADB, FLIP | New |
| 242 | [Word Ladder — LC 127](https://leetcode.com/problems/word-ladder/) | Hard | Y2 | CORE | AMZ, MSFT, GOO, ADB, UBER, FLIP, PHONEPE | Selective |
| 243 | [Find if Path Exists in Graph — LC 1971](https://leetcode.com/problems/find-if-path-exists-in-graph/) | Easy | Y2 | COMPANY / STRETCH | — | New |
| 244 | [Keys and Rooms — LC 841](https://leetcode.com/problems/keys-and-rooms/) | Medium | Y2 | CORE | AMZ, MSFT, GOO, META | New candidate — check existing notes |
| 245 | [All Paths From Source to Target — LC 797](https://leetcode.com/problems/all-paths-from-source-to-target/) | Medium | Y2 | CORE | AMZ, GOO, META | New candidate — check existing notes |
| 246 | [Snakes and Ladders — LC 909](https://leetcode.com/problems/snakes-and-ladders/) | Medium | Y2 | CORE | AMZ, MSFT, GOO, META, GS | New candidate — check existing notes |
| 247 | [Shortest Path with Alternating Colors — LC 1129](https://leetcode.com/problems/shortest-path-with-alternating-colors/) | Medium | Y2 | COMPANY / STRETCH | AMZ, MSFT, GOO | New candidate — check existing notes |
| 248 | [Critical Connections in a Network — LC 1192](https://leetcode.com/problems/critical-connections-in-a-network/) | Hard | Y2 | CORE | AMZ, MSFT, GOO, META, FLIP | New candidate — check existing notes |

## 22. Topological Sort / Union-Find — 10 problems

| # | Problem | Difficulty | First-pass year | Tier | Company tags | Existing-work note |
|---:|---|---|---|---|---|---|
| 249 | [Course Schedule — LC 207](https://leetcode.com/problems/course-schedule/) | Medium | Y2 | CORE | GOO*, AMZ, MSFT, ADB, UBER, FLIP | New |
| 250 | [Course Schedule II — LC 210](https://leetcode.com/problems/course-schedule-ii/) | Medium | Y2 | CORE | AMZ*, GOO*, MSFT, UBER, FLIP | New |
| 251 | [Number of Provinces — LC 547](https://leetcode.com/problems/number-of-provinces/) | Medium | Y2 | CORE | AMZ, MSFT, GOO, ADB, UBER | New |
| 252 | [Accounts Merge — LC 721](https://leetcode.com/problems/accounts-merge/) | Medium | Y2 | COMPANY / STRETCH | — | New |
| 253 | [Redundant Connection — LC 684](https://leetcode.com/problems/redundant-connection/) | Medium | Y2 | CORE | — | New |
| 254 | [Find Eventual Safe States — LC 802](https://leetcode.com/problems/find-eventual-safe-states/) | Medium | Y2 | COMPANY / STRETCH | — | New |
| 255 | [Number of Operations to Make Network Connected — LC 1319](https://leetcode.com/problems/number-of-operations-to-make-network-connected/) | Medium | Y2 | COMPANY / STRETCH | — | New |
| 256 | [Evaluate Division — LC 399](https://leetcode.com/problems/evaluate-division/) | Medium | Y2 | CORE | AMZ*, MSFT, GOO, UBER, FLIP, PHONEPE | New |
| 257 | [Smallest String With Swaps — LC 1202](https://leetcode.com/problems/smallest-string-with-swaps/) | Medium | Y2 | CORE | AMZ, MSFT, GOO, PHONEPE, GS | New candidate — check existing notes |
| 258 | [Redundant Connection II — LC 685](https://leetcode.com/problems/redundant-connection-ii/) | Hard | Y2 | CORE | GOO | New candidate — check existing notes |

## 23. Shortest Path / Minimum Spanning Tree — 8 problems

| # | Problem | Difficulty | First-pass year | Tier | Company tags | Existing-work note |
|---:|---|---|---|---|---|---|
| 259 | [Network Delay Time — LC 743](https://leetcode.com/problems/network-delay-time/) | Medium | Y2 | CORE | AMZ, MSFT, GOO, UBER | New |
| 260 | [Cheapest Flights Within K Stops — LC 787](https://leetcode.com/problems/cheapest-flights-within-k-stops/) | Medium | Y2 | CORE | AMZ, MSFT, GOO, UBER, FLIP | New |
| 261 | [Min Cost to Connect All Points — LC 1584](https://leetcode.com/problems/min-cost-to-connect-all-points/) | Medium | Y2 | CORE | — | New |
| 262 | [Shortest Path in Binary Matrix — LC 1091](https://leetcode.com/problems/shortest-path-in-binary-matrix/) | Medium | Y2 | COMPANY / STRETCH | — | Selective — BFS + shortest path |
| 263 | [Swim in Rising Water — LC 778](https://leetcode.com/problems/swim-in-rising-water/) | Hard | Y2 | COMPANY / STRETCH | — | Selective — Graph + Heap / Binary Search |
| 264 | [Path With Minimum Effort — LC 1631](https://leetcode.com/problems/path-with-minimum-effort/) | Medium | Y2 | CORE | AMZ, MSFT, GOO, META | New candidate — check existing notes |
| 265 | [Path with Maximum Probability — LC 1514](https://leetcode.com/problems/path-with-maximum-probability/) | Medium | Y2 | CORE | AMZ, GOO | New candidate — check existing notes |
| 266 | [Shortest Path in a Grid with Obstacles Elimination — LC 1293](https://leetcode.com/problems/shortest-path-in-a-grid-with-obstacles-elimination/) | Hard | Y2 | CORE | AMZ, GOO, META, ADB, UBER | New candidate — check existing notes |

## 24. DP 1D / Take-Skip — 14 problems

| # | Problem | Difficulty | First-pass year | Tier | Company tags | Existing-work note |
|---:|---|---|---|---|---|---|
| 267 | [Climbing Stairs — LC 70](https://leetcode.com/problems/climbing-stairs/) | Easy | Y2 | CORE | MSFT*, ACC, GS | Check existing DP notes first |
| 268 | [Min Cost Climbing Stairs — LC 746](https://leetcode.com/problems/min-cost-climbing-stairs/) | Easy | Y2 | COMPANY / STRETCH | — | Check existing DP notes first |
| 269 | [House Robber — LC 198](https://leetcode.com/problems/house-robber/) | Medium | Y2 | CORE | AMZ*, GOO*, MSFT, ADB, UBER, PHONEPE | Check existing DP notes first |
| 270 | [House Robber II — LC 213](https://leetcode.com/problems/house-robber-ii/) | Medium | Y2 | COMPANY / STRETCH | — | Check existing DP notes first |
| 271 | [Delete and Earn — LC 740](https://leetcode.com/problems/delete-and-earn/) | Medium | Y2 | COMPANY / STRETCH | MORGAN | Check existing DP notes first |
| 272 | [Maximum Subarray — LC 53](https://leetcode.com/problems/maximum-subarray/) | Medium | Y2 | CORE | AMZ*, GOO*, MSFT, ADB, ATL, UBER, PHONEPE, GS, MORGAN, ACC | Review — Kadane's previously practised |
| 273 | [Best Time to Buy and Sell Stock — LC 121](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/) | Easy | Y2 | CORE | AMZ*, MSFT*, GOO*, ADB, ATL, UBER, FLIP, PHONEPE, GS, MORGAN, ACC | New / verify |
| 274 | [Best Time to Buy and Sell Stock II — LC 122](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/) | Medium | Y2 | CORE | GS, ACC | Check existing DP notes first |
| 275 | [House Robber III — LC 337](https://leetcode.com/problems/house-robber-iii/) | Medium | Y2 | COMPANY / STRETCH | — | Check existing Tree/DP notes first |
| 276 | [Maximum Product Subarray — LC 152](https://leetcode.com/problems/maximum-product-subarray/) | Medium | Y3 | COMPANY / STRETCH | MORGAN | Check existing DP notes first |
| 277 | [N-th Tribonacci Number — LC 1137](https://leetcode.com/problems/n-th-tribonacci-number/) | Easy | Y3 | CORE | AMZ, MSFT, GOO, META | New candidate — check existing notes |
| 278 | [Domino and Tromino Tiling — LC 790](https://leetcode.com/problems/domino-and-tromino-tiling/) | Medium | Y3 | CORE | AMZ, MSFT, GOO, META, GS | New candidate — check existing notes |
| 279 | [Minimum Cost For Tickets — LC 983](https://leetcode.com/problems/minimum-cost-for-tickets/) | Medium | Y3 | CORE | AMZ, MSFT, GOO, META, ADB, UBER | New candidate — check existing notes |
| 280 | [Combination Sum IV — LC 377](https://leetcode.com/problems/combination-sum-iv/) | Medium | Y3 | CORE | AMZ, GOO, META | New candidate — check existing notes |

## 25. DP Knapsack / Subset Sum — 6 problems

| # | Problem | Difficulty | First-pass year | Tier | Company tags | Existing-work note |
|---:|---|---|---|---|---|---|
| 281 | [Coin Change — LC 322](https://leetcode.com/problems/coin-change/) | Medium | Y3 | CORE | AMZ*, MSFT, GOO, ADB, UBER, PHONEPE, GS, MORGAN | Check existing DP notes first |
| 282 | [Coin Change II — LC 518](https://leetcode.com/problems/coin-change-2/) | Medium | Y3 | COMPANY / STRETCH | — | Check existing DP notes first |
| 283 | [Partition Equal Subset Sum — LC 416](https://leetcode.com/problems/partition-equal-subset-sum/) | Medium | Y3 | CORE | MSFT | Check existing DP notes first |
| 284 | [Target Sum — LC 494](https://leetcode.com/problems/target-sum/) | Medium | Y3 | CORE | — | Check existing DP notes first |
| 285 | [Ones and Zeroes — LC 474](https://leetcode.com/problems/ones-and-zeroes/) | Medium | Y3 | CORE | AMZ, GOO, META, UBER | New candidate — check existing notes |
| 286 | [Last Stone Weight II — LC 1049](https://leetcode.com/problems/last-stone-weight-ii/) | Medium | Y3 | CORE | AMZ, GOO, META | New candidate — check existing notes |

## 26. DP Grid / Matrix Paths — 8 problems

| # | Problem | Difficulty | First-pass year | Tier | Company tags | Existing-work note |
|---:|---|---|---|---|---|---|
| 287 | [Unique Paths — LC 62](https://leetcode.com/problems/unique-paths/) | Medium | Y3 | CORE | — | Check existing DP notes first |
| 288 | [Unique Paths II — LC 63](https://leetcode.com/problems/unique-paths-ii/) | Medium | Y3 | COMPANY / STRETCH | — | Check existing DP notes first |
| 289 | [Minimum Path Sum — LC 64](https://leetcode.com/problems/minimum-path-sum/) | Medium | Y3 | CORE | GS | Check existing DP notes first |
| 290 | [Triangle — LC 120](https://leetcode.com/problems/triangle/) | Medium | Y3 | COMPANY / STRETCH | — | Check existing DP notes first |
| 291 | [Maximal Square — LC 221](https://leetcode.com/problems/maximal-square/) | Medium | Y3 | CORE | GOO*, AMZ, MSFT, GOO, FLIP, PHONEPE | New |
| 292 | [Dungeon Game — LC 174](https://leetcode.com/problems/dungeon-game/) | Hard | Y3 | CORE | AMZ, MSFT, GOO, UBER, FLIP | Selective |
| 293 | [Minimum Falling Path Sum — LC 931](https://leetcode.com/problems/minimum-falling-path-sum/) | Medium | Y3 | CORE | AMZ, MSFT, GOO, META, GS | New candidate — check existing notes |
| 294 | [Count Square Submatrices with All Ones — LC 1277](https://leetcode.com/problems/count-square-submatrices-with-all-ones/) | Medium | Y3 | CORE | AMZ, MSFT, GOO, META, GS | New candidate — check existing notes |

## 27. DP Subsequences / Strings / Palindromes — 13 problems

| # | Problem | Difficulty | First-pass year | Tier | Company tags | Existing-work note |
|---:|---|---|---|---|---|---|
| 295 | [Longest Increasing Subsequence — LC 300](https://leetcode.com/problems/longest-increasing-subsequence/) | Medium | Y3 | CORE | AMZ, MSFT, GOO, UBER, FLIP, GS, MORGAN | Check existing DP notes first |
| 296 | [Number of Longest Increasing Subsequence — LC 673](https://leetcode.com/problems/number-of-longest-increasing-subsequence/) | Medium | Y3 | COMPANY / STRETCH | — | Check existing DP notes first |
| 297 | [Longest Common Subsequence — LC 1143](https://leetcode.com/problems/longest-common-subsequence/) | Medium | Y3 | CORE | MORGAN | Check existing DP notes first |
| 298 | [Edit Distance — LC 72](https://leetcode.com/problems/edit-distance/) | Medium | Y3 | COMPANY / STRETCH | — | Check existing DP notes first |
| 299 | [Distinct Subsequences — LC 115](https://leetcode.com/problems/distinct-subsequences/) | Hard | Y3 | COMPANY / STRETCH | — | Check existing DP notes first |
| 300 | [Word Break — LC 139](https://leetcode.com/problems/word-break/) | Medium | Y3 | COMPANY / STRETCH | — | Check existing DP notes first |
| 301 | [Longest Palindromic Substring — LC 5](https://leetcode.com/problems/longest-palindromic-substring/) | Medium | Y3 | CORE | AMZ, MSFT, GOO, ADB, UBER, FLIP, PHONEPE, GS, ACC | New |
| 302 | [Longest Palindromic Subsequence — LC 516](https://leetcode.com/problems/longest-palindromic-subsequence/) | Medium | Y3 | COMPANY / STRETCH | GS | Selective |
| 303 | [Palindromic Substrings — LC 647](https://leetcode.com/problems/palindromic-substrings/) | Medium | Y3 | CORE | GS* | New |
| 304 | [Decode Ways — LC 91](https://leetcode.com/problems/decode-ways/) | Medium | Y3 | CORE | AMZ, MSFT, GOO, ADB, UBER, GS | New |
| 305 | [Delete Operation for Two Strings — LC 583](https://leetcode.com/problems/delete-operation-for-two-strings/) | Medium | Y3 | CORE | AMZ, MSFT, GOO, META | New candidate — check existing notes |
| 306 | [Maximum Length of Repeated Subarray — LC 718](https://leetcode.com/problems/maximum-length-of-repeated-subarray/) | Medium | Y3 | CORE | AMZ, MSFT, GOO | New candidate — check existing notes |
| 307 | [Minimum Insertion Steps to Make a String Palindrome — LC 1312](https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/) | Hard | Y3 | CORE | AMZ, MSFT, GOO, ACC | New candidate — check existing notes |

## 28. DP State Machine / Scheduling — 5 problems

| # | Problem | Difficulty | First-pass year | Tier | Company tags | Existing-work note |
|---:|---|---|---|---|---|---|
| 308 | [Best Time to Buy and Sell Stock III — LC 123](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/) | Hard | Y3 | COMPANY / STRETCH | — | Selective |
| 309 | [Best Time to Buy and Sell Stock with Cooldown — LC 309](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/) | Medium | Y3 | CORE | — | Selective |
| 310 | [Best Time to Buy and Sell Stock with Transaction Fee — LC 714](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/) | Medium | Y3 | CORE | — | Selective |
| 311 | [Maximum Profit in Job Scheduling — LC 1235](https://leetcode.com/problems/maximum-profit-in-job-scheduling/) | Hard | Y3 | CORE | GOO*, AMZ, MSFT, UBER, PHONEPE | Selective — DP + Binary Search |
| 312 | [Minimum Swaps To Make Sequences Increasing — LC 801](https://leetcode.com/problems/minimum-swaps-to-make-sequences-increasing/) | Hard | Y3 | CORE | AMZ, GOO, META | New candidate — check existing notes |

## 29. Trie / Prefix Search — 6 problems

| # | Problem | Difficulty | First-pass year | Tier | Company tags | Existing-work note |
|---:|---|---|---|---|---|---|
| 313 | [Longest Common Prefix — LC 14](https://leetcode.com/problems/longest-common-prefix/) | Easy | Y3 | CORE | AMZ*, MSFT*, GOO*, ADB, UBER, PHONEPE | New |
| 314 | [Implement Trie (Prefix Tree) — LC 208](https://leetcode.com/problems/implement-trie-prefix-tree/) | Medium | Y3 | COMPANY / STRETCH | — | New |
| 315 | [Design Add and Search Words Data Structure — LC 211](https://leetcode.com/problems/design-add-and-search-words-data-structure/) | Medium | Y3 | COMPANY / STRETCH | — | New |
| 316 | [Replace Words — LC 648](https://leetcode.com/problems/replace-words/) | Medium | Y3 | CORE | GOO, UBER | New candidate — check existing notes |
| 317 | [Search Suggestions System — LC 1268](https://leetcode.com/problems/search-suggestions-system/) | Medium | Y3 | CORE | AMZ, MSFT, GOO, META, UBER | New candidate — check existing notes |
| 318 | [Map Sum Pairs — LC 677](https://leetcode.com/problems/map-sum-pairs/) | Medium | Y3 | CORE | FLIP | New candidate — check existing notes |

## 30. Bit Manipulation — 9 problems

| # | Problem | Difficulty | First-pass year | Tier | Company tags | Existing-work note |
|---:|---|---|---|---|---|---|
| 319 | [Single Number — LC 136](https://leetcode.com/problems/single-number/) | Easy | Y3 | CORE | GS, ACC | New |
| 320 | [Counting Bits — LC 338](https://leetcode.com/problems/counting-bits/) | Easy | Y3 | COMPANY / STRETCH | — | New |
| 321 | [Number of 1 Bits — LC 191](https://leetcode.com/problems/number-of-1-bits/) | Easy | Y3 | CORE | — | New |
| 322 | [Reverse Bits — LC 190](https://leetcode.com/problems/reverse-bits/) | Easy | Y3 | CORE | — | New |
| 323 | [Missing Number — LC 268](https://leetcode.com/problems/missing-number/) | Easy | Y3 | COMPANY / STRETCH | — | New |
| 324 | [Power of Two — LC 231](https://leetcode.com/problems/power-of-two/) | Easy | Y3 | COMPANY / STRETCH | — | New |
| 325 | [Single Number III — LC 260](https://leetcode.com/problems/single-number-iii/) | Medium | Y3 | CORE | AMZ, MSFT, GOO | New candidate — check existing notes |
| 326 | [Sum of Two Integers — LC 371](https://leetcode.com/problems/sum-of-two-integers/) | Medium | Y3 | CORE | AMZ, MSFT, GOO, META | New candidate — check existing notes |
| 327 | [Bitwise AND of Numbers Range — LC 201](https://leetcode.com/problems/bitwise-and-of-numbers-range/) | Medium | Y3 | CORE | AMZ, MSFT, GOO, META | New candidate — check existing notes |

## 31. Basic Math / Number Patterns — 5 problems

| # | Problem | Difficulty | First-pass year | Tier | Company tags | Existing-work note |
|---:|---|---|---|---|---|---|
| 328 | [Happy Number — LC 202](https://leetcode.com/problems/happy-number/) | Easy | Y3 | COMPANY / STRETCH | — | New |
| 329 | [Count Primes — LC 204](https://leetcode.com/problems/count-primes/) | Medium | Y3 | COMPANY / STRETCH | GS, ACC | Selective |
| 330 | [Multiply Strings — LC 43](https://leetcode.com/problems/multiply-strings/) | Medium | Y3 | CORE | AMZ, MSFT, GOO, META | New candidate — check existing notes |
| 331 | [Pow(x, n) — LC 50](https://leetcode.com/problems/powx-n/) | Medium | Y3 | CORE | AMZ, MSFT, GOO, META, ADB, GS | New candidate — check existing notes |
| 332 | [Divide Two Integers — LC 29](https://leetcode.com/problems/divide-two-integers/) | Medium | Y3 | CORE | AMZ, MSFT, GOO, META | New candidate — check existing notes |

## 32. Matrix Traversal / In-place Matrix Transform — 6 problems

| # | Problem | Difficulty | First-pass year | Tier | Company tags | Existing-work note |
|---:|---|---|---|---|---|---|
| 333 | [Set Matrix Zeroes — LC 73](https://leetcode.com/problems/set-matrix-zeroes/) | Medium | Y3 | COMPANY / STRETCH | — | New |
| 334 | [Spiral Matrix — LC 54](https://leetcode.com/problems/spiral-matrix/) | Medium | Y3 | CORE | — | New — matrix boundary traversal |
| 335 | [Rotate Image — LC 48](https://leetcode.com/problems/rotate-image/) | Medium | Y3 | CORE | — | New — in-place matrix transformation |
| 336 | [Search a 2D Matrix II — LC 240](https://leetcode.com/problems/search-a-2d-matrix-ii/) | Medium | Y3 | COMPANY / STRETCH | — | New — matrix search / staircase |
| 337 | [Spiral Matrix II — LC 59](https://leetcode.com/problems/spiral-matrix-ii/) | Medium | Y3 | CORE | AMZ, MSFT, GOO, META, ADB, GS | New candidate — check existing notes |
| 338 | [Game of Life — LC 289](https://leetcode.com/problems/game-of-life/) | Medium | Y3 | CORE | AMZ, MSFT, GOO, META, ADB | New candidate — check existing notes |

## 33. Data Structure Design — 8 problems

| # | Problem | Difficulty | First-pass year | Tier | Company tags | Existing-work note |
|---:|---|---|---|---|---|---|
| 339 | [LRU Cache — LC 146](https://leetcode.com/problems/lru-cache/) | Medium | Y3 | CORE | AMZ, MSFT, GOO, ADB, ATL, UBER, FLIP, PHONEPE, GS, MORGAN, ACC | New — HashMap + doubly linked list |
| 340 | [Time Based Key-Value Store — LC 981](https://leetcode.com/problems/time-based-key-value-store/) | Medium | Y3 | COMPANY / STRETCH | — | New — HashMap + binary search |
| 341 | [Insert Delete GetRandom O(1) — LC 380](https://leetcode.com/problems/insert-delete-getrandom-o1/) | Medium | Y3 | COMPANY / STRETCH | — | Selective — data structure design |
| 342 | [Logger Rate Limiter — LC 359](https://leetcode.com/problems/logger-rate-limiter/) | Easy | Y3 | COMPANY / STRETCH | — | Selective — map + queue/time window |
| 343 | [LFU Cache — LC 460](https://leetcode.com/problems/lfu-cache/) | Hard | Y3 | CORE | AMZ, MSFT, GOO, META, UBER, GS | New candidate — check existing notes |
| 344 | [Design Browser History — LC 1472](https://leetcode.com/problems/design-browser-history/) | Medium | Y3 | CORE | AMZ, MSFT, GOO, UBER, GS | New candidate — check existing notes |
| 345 | [Design HashSet — LC 705](https://leetcode.com/problems/design-hashset/) | Easy | Y3 | CORE | AMZ, GOO, META | New candidate — check existing notes |
| 346 | [Design HashMap — LC 706](https://leetcode.com/problems/design-hashmap/) | Easy | Y3 | CORE | AMZ, MSFT, GOO, META, GS | New candidate — check existing notes |

## 34. Divide and Conquer — 2 problems

| # | Problem | Difficulty | First-pass year | Tier | Company tags | Existing-work note |
|---:|---|---|---|---|---|---|
| 347 | [Sort List — LC 148](https://leetcode.com/problems/sort-list/) | Medium | Y3 | CORE | AMZ, MSFT, GOO, META | New candidate — check existing notes |
| 348 | [Different Ways to Add Parentheses — LC 241](https://leetcode.com/problems/different-ways-to-add-parentheses/) | Medium | Y3 | COMPANY / STRETCH | AMZ, MSFT, GOO | New candidate — check existing notes |

## 35. String Matching / Rolling Hash — 2 problems

| # | Problem | Difficulty | First-pass year | Tier | Company tags | Existing-work note |
|---:|---|---|---|---|---|---|
| 349 | [Find the Index of the First Occurrence in a String — LC 28](https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/) | Easy | Y3 | CORE | AMZ, MSFT, GOO, META | New candidate — check existing notes |
| 350 | [Repeated DNA Sequences — LC 187](https://leetcode.com/problems/repeated-dna-sequences/) | Medium | Y3 | COMPANY / STRETCH | AMZ, MSFT, GOO, META | New candidate — check existing notes |

## 6. Existing repo work comes first

Before solving again, search your current Queue, Stack, Tree, Linked List, Recursion and DP trackers. The older source notes are preserved; new questions are marked as candidates to check against your files. A saved code draft or accepted submission alone is not “Interview-ready”. For trees, dry runs should show node visit order, current node and values returned or updated.

## 7. Company source and limits

Tags were checked against All-time company CSVs in [liquidslr/leetcode-company-wise-problems](https://github.com/liquidslr/leetcode-company-wise-problems), for Amazon, Microsoft, Google, Meta, Adobe, Atlassian, Uber, Flipkart, PhonePe, Goldman Sachs, Morgan Stanley and Accenture. The source repository has an update commit dated [21 October 2026 UTC](https://github.com/liquidslr/leetcode-company-wise-problems/commit/2b71796266751b4736a7ef180efb6847879166ee). Tags indicate the title appears in the dataset; they do not guarantee the company will ask it. For pattern learning, see the [NeetCode Roadmap](https://neetcode.io/roadmap).

## 8. Final version policy

**Final v3 — 350 unique questions, 35 patterns, 250 CORE + 100 COMPANY / STRETCH, 684 weekday sessions, 100 extra buffer weekdays, weekends reserved for the five weekday problems.** This supersedes the old data-structure-wise v1 and 236-problem pattern-wise v2.
