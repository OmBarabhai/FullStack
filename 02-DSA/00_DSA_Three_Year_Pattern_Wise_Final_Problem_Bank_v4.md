# Three-Year DSA Interview Master Bank — Final 375 v4

> **Canonical schedule:** 375 curated questions across 36 problem-solving patterns. Pattern-first, Java-oriented and targeted at fresher / SDE-1 and product-company coding interviews. This is not a competitive-programming syllabus.
>
> **Why 375 rather than stopping at 350:** the cross-sheet audit surfaced 25 additional high-value questions/patterns missing from the 350 draft. They were chosen selectively, not copied wholesale from the longer sheets.

## 1. Three-year calendar

**Planning window:** 23 November 2026 – 22 November 2029 inclusive.

| Allocation | Days |
|---|---:|
| Total calendar days | 1,096 |
| Saturdays and Sundays — no new problems | −312 |
| Weekdays available | 784 |
| Extra buffer for holidays, travel, illness and unexpected breaks | −100 |
| **Planned weekday sessions** | **684** |

The 100-day buffer is separate from weekends: 33 weekdays in Year 1, 34 in Year 2 and 33 in Year 3.

## 2. How all 375 questions fit into 684 sessions

| Activity | Weekday sessions |
|---|---:|
| First independent solve of all 375 questions | 375 |
| Third blank-editor attempt for 262 CORE questions | 262 |
| Company-focused sets, variations and mock interviews | 47 |
| **Total** | **684** |

Every question gets at least two meaningful passes: first solve on a weekday, then a weekend re-solve from memory. The 262 CORE questions get a third independent attempt. The 113 COMPANY / STRETCH questions receive two planned passes; give them a third when a target employer or weak area justifies it.

An attempt counts only when you derive the approach, implement it in Java, test edge cases and explain complexity. Watching an editorial does not count as a solve.

### Year-by-year weekday capacity

| Year | New first solves | Third attempts | Company sets / variations / mocks | Total |
|---|---:|---:|---:|---:|
| Year 1 — foundations | 155 | 53 | 20 | 228 |
| Year 2 — advanced core patterns | 135 | 79 | 14 | 228 |
| Year 3 — integration and interviews | 85 | 130 | 13 | 228 |
| **Total** | **375** | **262** | **47** | **684** |

The year in each row identifies the first attempt. Third attempts happen after first and second passes. The buffer is not a study target.

## 3. Weekly routine — weekends are revision-only

- **Monday–Friday:** one new question or scheduled third attempt, usually 30–60 minutes.
- **Saturday:** re-solve two or three questions from the five weekday sessions without opening notes.
- **Sunday:** re-solve the remaining two or three, record mistakes and rest.
- No new-problem target on weekends. Use the 100-day buffer rather than rushing when life interrupts.

## 4. Priority tiers

- **CORE (262):** broad, reusable patterns and representative interview questions; these receive a third blank-editor attempt.
- **COMPANY / STRETCH (113):** company-tagged, deeper or specialised variations; these receive two planned attempts and selective third attempts.

A company tag is evidence that a title appeared in a reported dataset, not a guarantee that the company will ask it. If an existing problem in your repository is already Interview-ready, mark it mastered and use its slot for a variation or mock instead of duplicating work.

## 5. Platform policy

- **LeetCode:** primary platform for the majority of the bank and company-tagged questions.
- **GeeksforGeeks:** used where classic sheet problems have a clean practice statement, including Bellman-Ford, Matrix Chain Multiplication, Fractional Knapsack and Aggressive Cows.
- **Code360:** acceptable as an alternate judge for equivalent questions; do not count the same problem twice.
- **Java:** implement every problem in Java even when a source editorial displays another language.

## 6. Company tag legend

AMZ Amazon; MSFT Microsoft; GOO Google; META Meta; ADB Adobe; ATL Atlassian; UBER Uber; FLIP Flipkart; PHONEPE PhonePe; GS Goldman Sachs; MORGAN Morgan Stanley; ACC Accenture.

Tags retain the checked company CSV values and older sheet annotations where available. A trailing `*` is retained from the prior snapshot to indicate a recent-tag flag. These are crowd-sourced/platform tags, not company-approved question banks.

## 7. Pattern-wise problem bank

## 01. HashMap / HashSet / Frequency Counting — 21 problems

| # | Platform | Problem | Level | First-pass year | Priority | Company tags | Popular-sheet overlap | Existing-work note |
|---:|---|---|---|---|---|---|---|---|
| 1 | LeetCode | [Contains Duplicate](https://leetcode.com/problems/contains-duplicate/) | Easy | Y1 | COMPANY / STRETCH | AMZ, MSFT, GOO, META, ACC | Shradha Khapra | New |
| 2 | LeetCode | [Two Sum](https://leetcode.com/problems/two-sum/) | Easy | Y1 | CORE | AMZ*, MSFT*, GOO*, META, ADB, ATL, UBER, FLIP, PHONEPE, GS, MORGAN, ACC | Striver A2Z, Fraz, Siddharth Singh, AlgoPrep 151 | New |
| 3 | LeetCode | [Valid Anagram](https://leetcode.com/problems/valid-anagram/) | Easy | Y1 | CORE | AMZ*, MSFT, GOO, META, UBER, GS, ACC, ADB, FLIP | Shradha Khapra | New |
| 4 | LeetCode | [Group Anagrams](https://leetcode.com/problems/group-anagrams/) | Medium | Y1 | CORE | AMZ*, MSFT*, GOO*, META, ADB, ATL, UBER, PHONEPE, GS, MORGAN, ACC | Shradha Khapra, Fraz | Review — previously practised |
| 5 | LeetCode | [Top K Frequent Elements](https://leetcode.com/problems/top-k-frequent-elements/) | Medium | Y1 | CORE | AMZ*, MSFT, GOO*, META, ADB, ATL, UBER, GS | Shradha Khapra, Fraz | Review — previously practised |
| 6 | LeetCode | [Product of Array Except Self](https://leetcode.com/problems/product-of-array-except-self/) | Medium | Y1 | CORE | AMZ*, MSFT, GOO, META, ADB, UBER, GS | Shradha Khapra, Fraz | New / verify |
| 7 | LeetCode | [Longest Consecutive Sequence](https://leetcode.com/problems/longest-consecutive-sequence/) | Medium | Y1 | CORE | AMZ*, MSFT, GOO*, META, ADB, ATL, UBER, PHONEPE, GS | Striver A2Z, Siddharth Singh, AlgoPrep 151 | New |
| 8 | LeetCode | [Majority Element](https://leetcode.com/problems/majority-element/) | Easy | Y1 | CORE | AMZ, MSFT, GOO, META, ADB, GS, MORGAN, ACC | Striver A2Z, Love Babbar 450, Shradha Khapra, Fraz, Siddharth Singh, AlgoPrep 151 | New |
| 9 | LeetCode | [Valid Sudoku](https://leetcode.com/problems/valid-sudoku/) | Medium | Y1 | CORE | AMZ*, MSFT, GOO, META, UBER, GS | Not mapped in six-sheet export | New |
| 10 | LeetCode | [First Unique Character in a String](https://leetcode.com/problems/first-unique-character-in-a-string/) | Easy | Y1 | CORE | AMZ, MSFT, GOO, META, GS, MORGAN | Not mapped in six-sheet export | New |
| 11 | LeetCode | [Ransom Note](https://leetcode.com/problems/ransom-note/) | Easy | Y1 | COMPANY / STRETCH | AMZ, MSFT, GOO, META | Not mapped in six-sheet export | New |
| 12 | LeetCode | [Isomorphic Strings](https://leetcode.com/problems/isomorphic-strings/) | Easy | Y1 | COMPANY / STRETCH | AMZ, MSFT, GOO, META, ACC | Not mapped in six-sheet export | New |
| 13 | LeetCode | [Contains Duplicate II](https://leetcode.com/problems/contains-duplicate-ii/) | Easy | Y1 | COMPANY / STRETCH | AMZ, MSFT, GOO, META, ADB, ACC | Not mapped in six-sheet export | New |
| 14 | LeetCode | [Intersection of Two Arrays II](https://leetcode.com/problems/intersection-of-two-arrays-ii/) | Easy | Y1 | COMPANY / STRETCH | AMZ, MSFT, GOO, META | Not mapped in six-sheet export | New |
| 15 | LeetCode | [Find All Numbers Disappeared in an Array](https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/) | Easy | Y1 | COMPANY / STRETCH | AMZ, MSFT, GOO, META | Not mapped in six-sheet export | New |
| 16 | LeetCode | [4Sum II](https://leetcode.com/problems/4sum-ii/) | Medium | Y1 | CORE | AMZ, MSFT, GOO, META | Not mapped in six-sheet export | New candidate — check existing notes |
| 17 | LeetCode | [Word Pattern](https://leetcode.com/problems/word-pattern/) | Easy | Y1 | CORE | AMZ, MSFT, GOO, META, UBER | Not mapped in six-sheet export | New candidate — check existing notes |
| 18 | LeetCode | [Custom Sort String](https://leetcode.com/problems/custom-sort-string/) | Medium | Y1 | CORE | AMZ, MSFT, GOO, META | Not mapped in six-sheet export | New candidate — check existing notes |
| 19 | LeetCode | [Least Number of Unique Integers after K Removals](https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals/) | Medium | Y1 | CORE | AMZ, GOO, MORGAN | Not mapped in six-sheet export | New candidate — check existing notes |
| 20 | LeetCode | [Find the Difference](https://leetcode.com/problems/find-the-difference/) | Easy | Y1 | CORE | AMZ, MSFT, GOO, META, ACC | Not mapped in six-sheet export | New candidate — check existing notes |
| 21 | LeetCode | [Unique Number of Occurrences](https://leetcode.com/problems/unique-number-of-occurrences/) | Easy | Y1 | CORE | AMZ, MSFT, GOO, META | Not mapped in six-sheet export | New candidate — check existing notes |

## 02. Two Pointers / In-place Partitioning — 18 problems

| # | Platform | Problem | Level | First-pass year | Priority | Company tags | Popular-sheet overlap | Existing-work note |
|---:|---|---|---|---|---|---|---|---|
| 22 | LeetCode | [Valid Palindrome](https://leetcode.com/problems/valid-palindrome/) | Easy | Y1 | CORE | AMZ, MSFT, GOO, META, ADB, UBER, GS, ACC | Shradha Khapra | Review — previously practised |
| 23 | LeetCode | [Two Sum II — Input Array Is Sorted](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/) | Medium | Y1 | CORE | AMZ, MSFT, GOO, META | Not mapped in six-sheet export | Review — previously practised |
| 24 | LeetCode | [3Sum](https://leetcode.com/problems/3sum/) | Medium | Y1 | CORE | AMZ*, MSFT*, GOO*, META, ADB, FLIP, PHONEPE, GS, MORGAN, ACC | Shradha Khapra, Fraz | New |
| 25 | LeetCode | [4Sum](https://leetcode.com/problems/4sum/) | Medium | Y1 | COMPANY / STRETCH | AMZ, MSFT, GOO, META, ACC | Fraz | New |
| 26 | LeetCode | [Container With Most Water](https://leetcode.com/problems/container-with-most-water/) | Medium | Y1 | CORE | AMZ*, MSFT, GOO*, META, ADB, UBER, FLIP*, GS, MORGAN, ACC | Shradha Khapra, Fraz, Siddharth Singh, AlgoPrep 151 | New |
| 27 | LeetCode | [Trapping Rain Water](https://leetcode.com/problems/trapping-rain-water/) | Hard | Y1 | CORE | AMZ*, MSFT*, GOO*, META, ADB, UBER, FLIP, PHONEPE, GS*, ACC | Love Babbar 450, Shradha Khapra, Fraz, Siddharth Singh, AlgoPrep 151 | Review — previously practised; compare stack approach |
| 28 | LeetCode | [Remove Duplicates from Sorted Array](https://leetcode.com/problems/remove-duplicates-from-sorted-array/) | Easy | Y1 | CORE | AMZ, MSFT*, GOO, META, GS, MORGAN, ACC | Striver A2Z, Fraz | New |
| 29 | LeetCode | [Move Zeroes](https://leetcode.com/problems/move-zeroes/) | Easy | Y1 | CORE | AMZ*, MSFT*, GOO*, META, ADB, UBER, GS, ACC | Fraz | New |
| 30 | LeetCode | [Squares of a Sorted Array](https://leetcode.com/problems/squares-of-a-sorted-array/) | Easy | Y1 | CORE | AMZ, MSFT, GOO, META, ADB, UBER, ACC | Fraz, Siddharth Singh, AlgoPrep 151 | New |
| 31 | LeetCode | [Backspace String Compare](https://leetcode.com/problems/backspace-string-compare/) | Easy | Y1 | COMPANY / STRETCH | AMZ, MSFT, GOO, META, GS | Fraz, Siddharth Singh | New |
| 32 | LeetCode | [Boats to Save People](https://leetcode.com/problems/boats-to-save-people/) | Medium | Y1 | COMPANY / STRETCH | AMZ, MSFT, GOO, META | Siddharth Singh | New |
| 33 | LeetCode | [Sort Colors](https://leetcode.com/problems/sort-colors/) | Medium | Y1 | CORE | AMZ, MSFT*, GOO, META, ADB, UBER, FLIP, GS, MORGAN | Striver A2Z, Fraz | Previously next in your sorting tracker — verify |
| 34 | LeetCode | [3Sum Closest](https://leetcode.com/problems/3sum-closest/) | Medium | Y1 | CORE | AMZ, MSFT, GOO, META, FLIP | Fraz | New candidate — check existing notes |
| 35 | LeetCode | [Remove Duplicates from Sorted Array II](https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/) | Medium | Y1 | CORE | AMZ, MSFT, GOO, META | Not mapped in six-sheet export | New candidate — check existing notes |
| 36 | LeetCode | [Reverse Vowels of a String](https://leetcode.com/problems/reverse-vowels-of-a-string/) | Easy | Y1 | CORE | AMZ, MSFT, GOO, META | Siddharth Singh | New candidate — check existing notes |
| 37 | LeetCode | [Is Subsequence](https://leetcode.com/problems/is-subsequence/) | Easy | Y1 | CORE | AMZ, MSFT, GOO, META, ADB | Not mapped in six-sheet export | New candidate — check existing notes |
| 38 | LeetCode | [Valid Triangle Number](https://leetcode.com/problems/valid-triangle-number/) | Medium | Y1 | CORE | AMZ, MSFT, GOO, META, GS | Not mapped in six-sheet export | New candidate — check existing notes |
| 39 | LeetCode | [Next Permutation](https://leetcode.com/problems/next-permutation/) | Medium | Y1 | CORE | ADB, UBER, GS | Love Babbar 450, Shradha Khapra, Fraz | Added after popular-sheet audit |

## 03. Sliding Window — 15 problems

| # | Platform | Problem | Level | First-pass year | Priority | Company tags | Popular-sheet overlap | Existing-work note |
|---:|---|---|---|---|---|---|---|---|
| 40 | LeetCode | [Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/) | Medium | Y1 | CORE | AMZ*, MSFT*, GOO*, META, ADB, ATL, UBER, GS, MORGAN, ACC | Striver A2Z, Shradha Khapra, Fraz | Review — previously practised |
| 41 | LeetCode | [Longest Repeating Character Replacement](https://leetcode.com/problems/longest-repeating-character-replacement/) | Medium | Y1 | COMPANY / STRETCH | AMZ, MSFT, GOO, META, ADB, GS | Shradha Khapra, Fraz | New |
| 42 | LeetCode | [Permutation in String](https://leetcode.com/problems/permutation-in-string/) | Medium | Y1 | COMPANY / STRETCH | AMZ, MSFT, GOO, META, ADB | Not mapped in six-sheet export | New |
| 43 | LeetCode | [Find All Anagrams in a String](https://leetcode.com/problems/find-all-anagrams-in-a-string/) | Medium | Y1 | COMPANY / STRETCH | AMZ, MSFT, GOO, META | Striver A2Z, Siddharth Singh, AlgoPrep 151 | New |
| 44 | LeetCode | [Minimum Window Substring](https://leetcode.com/problems/minimum-window-substring/) | Hard | Y1 | CORE | AMZ, MSFT, GOO, META, ADB, UBER, GS, ATL, FLIP | Striver A2Z, Shradha Khapra, Fraz | New |
| 45 | LeetCode | [Max Consecutive Ones III](https://leetcode.com/problems/max-consecutive-ones-iii/) | Medium | Y1 | CORE | AMZ*, MSFT*, GOO*, META, ADB, GS | Striver A2Z, Fraz | New |
| 46 | LeetCode | [Sliding Window Maximum](https://leetcode.com/problems/sliding-window-maximum/) | Hard | Y1 | CORE | AMZ, MSFT, GOO*, META, ADB, UBER, PHONEPE, GS, FLIP | Shradha Khapra, Fraz | New |
| 47 | LeetCode | [Minimum Size Subarray Sum](https://leetcode.com/problems/minimum-size-subarray-sum/) | Medium | Y1 | CORE | AMZ, MSFT, GOO, META, GS | Not mapped in six-sheet export | New |
| 48 | LeetCode | [Maximum Points You Can Obtain from Cards](https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/) | Medium | Y1 | CORE | AMZ, MSFT*, GOO, META, UBER, FLIP, PHONEPE | Fraz | New |
| 49 | LeetCode | [Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit](https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/) | Medium | Y1 | CORE | AMZ, MSFT, GOO, META, UBER, PHONEPE | Not mapped in six-sheet export | New |
| 50 | LeetCode | [Fruit Into Baskets](https://leetcode.com/problems/fruit-into-baskets/) | Medium | Y1 | CORE | AMZ, MSFT, GOO, META, ADB | Striver A2Z | New candidate — check existing notes |
| 51 | LeetCode | [Grumpy Bookstore Owner](https://leetcode.com/problems/grumpy-bookstore-owner/) | Medium | Y1 | CORE | AMZ, MSFT, GOO, META | Fraz | New candidate — check existing notes |
| 52 | LeetCode | [Number of Sub-arrays of Size K and Average Greater than or Equal to Threshold](https://leetcode.com/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/) | Medium | Y1 | CORE | AMZ, MSFT, GOO, META, GS | Not mapped in six-sheet export | New candidate — check existing notes |
| 53 | LeetCode | [Minimum Operations to Reduce X to Zero](https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/) | Medium | Y1 | CORE | AMZ, GOO, MORGAN | Not mapped in six-sheet export | New candidate — check existing notes |
| 54 | LeetCode | [Replace the Substring for Balanced String](https://leetcode.com/problems/replace-the-substring-for-balanced-string/) | Medium | Y1 | COMPANY / STRETCH | — | Not mapped in six-sheet export | New candidate — check existing notes |

## 04. Prefix Sum / Difference Array — 12 problems

| # | Platform | Problem | Level | First-pass year | Priority | Company tags | Popular-sheet overlap | Existing-work note |
|---:|---|---|---|---|---|---|---|---|
| 55 | LeetCode | [Subarray Sum Equals K](https://leetcode.com/problems/subarray-sum-equals-k/) | Medium | Y1 | CORE | AMZ*, MSFT*, GOO*, META, ADB, UBER, FLIP, GS, ACC | Striver A2Z, Fraz | New |
| 56 | LeetCode | [Range Sum Query — Immutable](https://leetcode.com/problems/range-sum-query-immutable/) | Easy | Y1 | CORE | AMZ, MSFT, GOO, META | Shradha Khapra | New |
| 57 | LeetCode | [Continuous Subarray Sum](https://leetcode.com/problems/continuous-subarray-sum/) | Medium | Y1 | COMPANY / STRETCH | AMZ, MSFT, GOO, META, PHONEPE | Fraz | New |
| 58 | LeetCode | [Contiguous Array](https://leetcode.com/problems/contiguous-array/) | Medium | Y1 | CORE | AMZ, MSFT, GOO, META, MORGAN, ACC | Not mapped in six-sheet export | New |
| 59 | LeetCode | [Find Pivot Index](https://leetcode.com/problems/find-pivot-index/) | Easy | Y1 | CORE | AMZ, MSFT, GOO, META, GS, ACC | Fraz | New |
| 60 | LeetCode | [Corporate Flight Bookings](https://leetcode.com/problems/corporate-flight-bookings/) | Medium | Y1 | CORE | MSFT, GOO, META, GS | Not mapped in six-sheet export | New |
| 61 | LeetCode | [Car Pooling](https://leetcode.com/problems/car-pooling/) | Medium | Y1 | CORE | AMZ, MSFT, GOO, META, FLIP, GS | Not mapped in six-sheet export | New |
| 62 | LeetCode | [Subarray Sums Divisible by K](https://leetcode.com/problems/subarray-sums-divisible-by-k/) | Medium | Y1 | COMPANY / STRETCH | AMZ, MSFT, GOO, META, UBER | Fraz | New |
| 63 | LeetCode | [Range Sum Query 2D — Immutable](https://leetcode.com/problems/range-sum-query-2d-immutable/) | Medium | Y1 | CORE | AMZ, MSFT, GOO, META | Fraz | New candidate — check existing notes |
| 64 | LeetCode | [Longest Well-Performing Interval](https://leetcode.com/problems/longest-well-performing-interval/) | Medium | Y1 | CORE | GOO | Not mapped in six-sheet export | New candidate — check existing notes |
| 65 | LeetCode | [Make Sum Divisible by P](https://leetcode.com/problems/make-sum-divisible-by-p/) | Medium | Y1 | CORE | AMZ, MSFT, GOO, META, PHONEPE | Not mapped in six-sheet export | New candidate — check existing notes |
| 66 | LeetCode | [Product of the Last K Numbers](https://leetcode.com/problems/product-of-the-last-k-numbers/) | Medium | Y1 | CORE | AMZ, MSFT, GOO, META | Not mapped in six-sheet export | New candidate — check existing notes |

## 05. Binary Search / Search on Answer — 18 problems

| # | Platform | Problem | Level | First-pass year | Priority | Company tags | Popular-sheet overlap | Existing-work note |
|---:|---|---|---|---|---|---|---|---|
| 67 | LeetCode | [Binary Search](https://leetcode.com/problems/binary-search/) | Easy | Y1 | CORE | AMZ*, MSFT, GOO, META | Striver A2Z, Fraz, Siddharth Singh | Review — binary search previously practised; verify exact problem |
| 68 | LeetCode | [Search Insert Position](https://leetcode.com/problems/search-insert-position/) | Easy | Y1 | COMPANY / STRETCH | AMZ, MSFT, GOO, META, ACC | Striver A2Z | New |
| 69 | LeetCode | [Find First and Last Position of Element in Sorted Array](https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/) | Medium | Y1 | COMPANY / STRETCH | AMZ*, MSFT, GOO*, META, ATL, UBER, GS, ACC | Fraz | New |
| 70 | LeetCode | [Search a 2D Matrix](https://leetcode.com/problems/search-a-2d-matrix/) | Medium | Y1 | CORE | AMZ, MSFT*, GOO, META, ADB, UBER, GS | Fraz | New |
| 71 | LeetCode | [Search in Rotated Sorted Array](https://leetcode.com/problems/search-in-rotated-sorted-array/) | Medium | Y1 | CORE | AMZ*, MSFT, GOO*, META, ADB, UBER, FLIP, GS | Striver A2Z, Shradha Khapra, Fraz, Siddharth Singh, AlgoPrep 151 | New |
| 72 | LeetCode | [Find Minimum in Rotated Sorted Array](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/) | Medium | Y1 | CORE | AMZ, MSFT, GOO, META, UBER, GS, ADB | Striver A2Z, Shradha Khapra, Siddharth Singh | New |
| 73 | LeetCode | [Find Peak Element](https://leetcode.com/problems/find-peak-element/) | Medium | Y1 | CORE | AMZ, MSFT, GOO*, META, ADB*, UBER, GS, ACC | Striver A2Z, Fraz | New |
| 74 | LeetCode | [Koko Eating Bananas](https://leetcode.com/problems/koko-eating-bananas/) | Medium | Y1 | CORE | AMZ*, MSFT, GOO*, META, ADB, ATL, UBER, FLIP, GS, ACC | Striver A2Z, Siddharth Singh | New |
| 75 | LeetCode | [Capacity To Ship Packages Within D Days](https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/) | Medium | Y1 | CORE | AMZ*, MSFT, GOO, META, UBER, FLIP, GS | Striver A2Z, Fraz | New |
| 76 | LeetCode | [Find K Closest Elements](https://leetcode.com/problems/find-k-closest-elements/) | Medium | Y1 | CORE | AMZ, MSFT, GOO, META, UBER, FLIP | Not mapped in six-sheet export | New |
| 77 | LeetCode | [Median of Two Sorted Arrays](https://leetcode.com/problems/median-of-two-sorted-arrays/) | Hard | Y1 | CORE | AMZ*, MSFT*, GOO*, META, ADB, UBER, FLIP, GS, ACC | Striver A2Z, Fraz, Siddharth Singh, AlgoPrep 151 | Selective — do after binary-search boundaries |
| 78 | LeetCode | [Sqrt(x)](https://leetcode.com/problems/sqrtx/) | Easy | Y1 | CORE | AMZ, MSFT, GOO, META, ADB, UBER, GS | Fraz | New candidate — check existing notes |
| 79 | LeetCode | [First Bad Version](https://leetcode.com/problems/first-bad-version/) | Easy | Y1 | CORE | AMZ, MSFT, GOO, META | Not mapped in six-sheet export | New candidate — check existing notes |
| 80 | LeetCode | [Find Smallest Letter Greater Than Target](https://leetcode.com/problems/find-smallest-letter-greater-than-target/) | Easy | Y1 | COMPANY / STRETCH | AMZ, GOO, META | Not mapped in six-sheet export | New candidate — check existing notes |
| 81 | LeetCode | [Single Element in a Sorted Array](https://leetcode.com/problems/single-element-in-a-sorted-array/) | Medium | Y1 | CORE | AMZ, MSFT, GOO, META, GS | Striver A2Z | New candidate — check existing notes |
| 82 | LeetCode | [Kth Missing Positive Number](https://leetcode.com/problems/kth-missing-positive-number/) | Easy | Y1 | CORE | AMZ, MSFT, GOO, META | Striver A2Z | New candidate — check existing notes |
| 83 | GeeksforGeeks | [Aggressive Cows](https://www.geeksforgeeks.org/problems/aggressive-cows/1) | Medium | Y1 | CORE | ADB | Striver A2Z, Love Babbar 450, Shradha Khapra | Added after popular-sheet audit |
| 84 | GeeksforGeeks | [K-th Element of Two Sorted Arrays](https://www.geeksforgeeks.org/problems/k-th-element-of-two-sorted-array1317/1) | Medium | Y1 | COMPANY / STRETCH | — | Love Babbar 450 | Added after popular-sheet audit |

## 06. Sorting / Merge Intervals / Sweep Line — 14 problems

| # | Platform | Problem | Level | First-pass year | Priority | Company tags | Popular-sheet overlap | Existing-work note |
|---:|---|---|---|---|---|---|---|---|
| 85 | LeetCode | [Merge Intervals](https://leetcode.com/problems/merge-intervals/) | Medium | Y1 | CORE | AMZ*, MSFT, GOO*, META, ADB, ATL, UBER, FLIP, GS, MORGAN, ACC | Striver A2Z, Love Babbar 450, Fraz | New |
| 86 | LeetCode | [Insert Interval](https://leetcode.com/problems/insert-interval/) | Medium | Y1 | CORE | AMZ, MSFT, GOO, META, UBER, PHONEPE | Not mapped in six-sheet export | New |
| 87 | LeetCode | [Non-overlapping Intervals](https://leetcode.com/problems/non-overlapping-intervals/) | Medium | Y1 | CORE | AMZ, MSFT, GOO, META, UBER, GS | Striver A2Z, Fraz | New |
| 88 | LeetCode | [Minimum Number of Arrows to Burst Balloons](https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/) | Medium | Y1 | COMPANY / STRETCH | AMZ, MSFT, GOO, GS | Not mapped in six-sheet export | New |
| 89 | LeetCode | [Interval List Intersections](https://leetcode.com/problems/interval-list-intersections/) | Medium | Y1 | COMPANY / STRETCH | AMZ, MSFT, GOO, META | Not mapped in six-sheet export | New |
| 90 | LeetCode | [Merge Sorted Array](https://leetcode.com/problems/merge-sorted-array/) | Easy | Y1 | CORE | AMZ, MSFT, GOO, META, GS, MORGAN, ACC | Not mapped in six-sheet export | New |
| 91 | LeetCode | [Largest Number](https://leetcode.com/problems/largest-number/) | Medium | Y1 | CORE | AMZ, MSFT, GOO, META, ADB, GS, ACC | Not mapped in six-sheet export | New |
| 92 | LeetCode | [Hand of Straights](https://leetcode.com/problems/hand-of-straights/) | Medium | Y1 | COMPANY / STRETCH | AMZ, MSFT, GOO, META | Not mapped in six-sheet export | New |
| 93 | LeetCode | [Task Scheduler](https://leetcode.com/problems/task-scheduler/) | Medium | Y1 | CORE | AMZ*, MSFT, GOO, META, UBER, GS | Striver A2Z, Fraz | New |
| 94 | LeetCode | [Meeting Rooms](https://leetcode.com/problems/meeting-rooms/) | Easy | Y1 | CORE | AMZ, MSFT, GOO, META, UBER | Not mapped in six-sheet export | New candidate — check existing notes |
| 95 | LeetCode | [Meeting Rooms II](https://leetcode.com/problems/meeting-rooms-ii/) | Medium | Y1 | CORE | AMZ, MSFT, GOO, META, ATL, UBER, GS | Not mapped in six-sheet export | New candidate — check existing notes |
| 96 | LeetCode | [Remove Covered Intervals](https://leetcode.com/problems/remove-covered-intervals/) | Medium | Y1 | CORE | AMZ, MSFT, GOO, META | Not mapped in six-sheet export | New candidate — check existing notes |
| 97 | LeetCode | [My Calendar I](https://leetcode.com/problems/my-calendar-i/) | Medium | Y1 | CORE | AMZ, MSFT, GOO, META, UBER | Not mapped in six-sheet export | New candidate — check existing notes |
| 98 | GeeksforGeeks | [Chocolate Distribution Problem](https://www.geeksforgeeks.org/dsa/chocolate-distribution-problem/) | Easy | Y1 | CORE | AMZ | Love Babbar 450, Shradha Khapra, Siddharth Singh | Added after popular-sheet audit |

## 07. Cyclic Sort / Index Placement — 3 problems

| # | Platform | Problem | Level | First-pass year | Priority | Company tags | Popular-sheet overlap | Existing-work note |
|---:|---|---|---|---|---|---|---|---|
| 99 | LeetCode | [First Missing Positive](https://leetcode.com/problems/first-missing-positive/) | Hard | Y1 | CORE | AMZ, MSFT, GOO, META, ADB, PHONEPE, GS | Fraz, Siddharth Singh, AlgoPrep 151 | New — cyclic index placement |
| 100 | LeetCode | [Find the Duplicate Number](https://leetcode.com/problems/find-the-duplicate-number/) | Medium | Y1 | CORE | AMZ, MSFT, GOO, META, FLIP, GS | Love Babbar 450, Fraz | New — cyclic/value-domain reasoning |
| 101 | LeetCode | [Find All Duplicates in an Array](https://leetcode.com/problems/find-all-duplicates-in-an-array/) | Medium | Y1 | CORE | AMZ, MSFT, GOO, META | Fraz | New candidate — check existing notes |

## 08. Fast & Slow Pointers / Linked List Cycles — 7 problems

| # | Platform | Problem | Level | First-pass year | Priority | Company tags | Popular-sheet overlap | Existing-work note |
|---:|---|---|---|---|---|---|---|---|
| 102 | LeetCode | [Linked List Cycle](https://leetcode.com/problems/linked-list-cycle/) | Easy | Y1 | CORE | AMZ*, MSFT, GOO, META, GS, ADB | Shradha Khapra | Check existing Linked List tracker first |
| 103 | LeetCode | [Linked List Cycle II](https://leetcode.com/problems/linked-list-cycle-ii/) | Medium | Y1 | COMPANY / STRETCH | AMZ, MSFT, GOO, META | Not mapped in six-sheet export | Check existing Linked List tracker first |
| 104 | LeetCode | [Remove Nth Node From End of List](https://leetcode.com/problems/remove-nth-node-from-end-of-list/) | Medium | Y1 | CORE | AMZ, MSFT, GOO, META, FLIP, MORGAN, ACC, ADB | Shradha Khapra | Check existing Linked List tracker first |
| 105 | LeetCode | [Middle of the Linked List](https://leetcode.com/problems/middle-of-the-linked-list/) | Easy | Y1 | COMPANY / STRETCH | AMZ, MSFT, GOO, META, ACC | Not mapped in six-sheet export | Check existing Linked List tracker first |
| 106 | LeetCode | [Palindrome Linked List](https://leetcode.com/problems/palindrome-linked-list/) | Easy | Y1 | CORE | AMZ, MSFT, GOO, META, MORGAN | Not mapped in six-sheet export | Check existing Linked List tracker first |
| 107 | LeetCode | [Intersection of Two Linked Lists](https://leetcode.com/problems/intersection-of-two-linked-lists/) | Easy | Y1 | CORE | AMZ, MSFT, GOO, META, GS | Striver A2Z | Check existing Linked List tracker first |
| 108 | LeetCode | [Circular Array Loop](https://leetcode.com/problems/circular-array-loop/) | Medium | Y1 | CORE | AMZ, MSFT, GOO, GS | Not mapped in six-sheet export | New candidate — check existing notes |

## 09. Linked List Reversal / Dummy Node / Merge — 13 problems

| # | Platform | Problem | Level | First-pass year | Priority | Company tags | Popular-sheet overlap | Existing-work note |
|---:|---|---|---|---|---|---|---|---|
| 109 | LeetCode | [Reverse Linked List](https://leetcode.com/problems/reverse-linked-list/) | Easy | Y1 | CORE | AMZ, MSFT, GOO*, META, ADB, UBER, GS | Shradha Khapra | Check existing Linked List tracker first |
| 110 | LeetCode | [Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists/) | Easy | Y1 | CORE | AMZ, MSFT, GOO, META, ADB, GS, ACC, FLIP | Shradha Khapra | Check existing Linked List tracker first |
| 111 | LeetCode | [Reorder List](https://leetcode.com/problems/reorder-list/) | Medium | Y1 | COMPANY / STRETCH | AMZ, MSFT, GOO, META, MORGAN | Shradha Khapra | Check existing Linked List tracker first |
| 112 | LeetCode | [Add Two Numbers](https://leetcode.com/problems/add-two-numbers/) | Medium | Y1 | CORE | AMZ*, MSFT, GOO*, META, ADB, UBER, GS | Not mapped in six-sheet export | Check existing Linked List tracker first |
| 113 | LeetCode | [Copy List with Random Pointer](https://leetcode.com/problems/copy-list-with-random-pointer/) | Medium | Y1 | CORE | AMZ*, MSFT, GOO, META, ADB, UBER, FLIP, MORGAN | Striver A2Z | Check existing Linked List tracker first |
| 114 | LeetCode | [Reverse Nodes in k-Group](https://leetcode.com/problems/reverse-nodes-in-k-group/) | Hard | Y1 | CORE | AMZ, MSFT*, GOO, META, UBER, GS | Not mapped in six-sheet export | Check existing Linked List tracker first |
| 115 | LeetCode | [Rotate List](https://leetcode.com/problems/rotate-list/) | Medium | Y1 | COMPANY / STRETCH | AMZ, MSFT, GOO, META | Not mapped in six-sheet export | Check existing Linked List tracker first |
| 116 | LeetCode | [Partition List](https://leetcode.com/problems/partition-list/) | Medium | Y1 | COMPANY / STRETCH | AMZ, MSFT, GOO, META | Not mapped in six-sheet export | Check existing Linked List tracker first |
| 117 | LeetCode | [Swap Nodes in Pairs](https://leetcode.com/problems/swap-nodes-in-pairs/) | Medium | Y1 | CORE | AMZ, MSFT, GOO, META, UBER, GS | Not mapped in six-sheet export | New candidate — check existing notes |
| 118 | LeetCode | [Reverse Linked List II](https://leetcode.com/problems/reverse-linked-list-ii/) | Medium | Y1 | CORE | AMZ, MSFT, GOO, META | Not mapped in six-sheet export | New candidate — check existing notes |
| 119 | LeetCode | [Odd Even Linked List](https://leetcode.com/problems/odd-even-linked-list/) | Medium | Y1 | CORE | AMZ, MSFT, GOO, META | Not mapped in six-sheet export | New candidate — check existing notes |
| 120 | LeetCode | [Design Linked List](https://leetcode.com/problems/design-linked-list/) | Medium | Y1 | CORE | AMZ, MSFT, GOO, META | Not mapped in six-sheet export | New candidate — check existing notes |
| 121 | LeetCode | [Flatten a Multilevel Doubly Linked List](https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/) | Medium | Y1 | CORE | AMZ, MSFT, GOO, META, ADB | Not mapped in six-sheet export | New candidate — check existing notes |

## 10. Monotonic Stack / Next Greater / Histogram — 10 problems

| # | Platform | Problem | Level | First-pass year | Priority | Company tags | Popular-sheet overlap | Existing-work note |
|---:|---|---|---|---|---|---|---|---|
| 122 | LeetCode | [Daily Temperatures](https://leetcode.com/problems/daily-temperatures/) | Medium | Y1 | CORE | AMZ, MSFT, GOO, META, FLIP, GS, MORGAN | Fraz, Siddharth Singh | Check existing Stack tracker first |
| 123 | LeetCode | [Next Greater Element I](https://leetcode.com/problems/next-greater-element-i/) | Easy | Y1 | CORE | AMZ, MSFT, GOO*, META, UBER, FLIP, ACC | Fraz | Check existing Stack tracker first |
| 124 | LeetCode | [Next Greater Element II](https://leetcode.com/problems/next-greater-element-ii/) | Medium | Y1 | CORE | AMZ, MSFT, GOO, META, FLIP, GS, MORGAN | Not mapped in six-sheet export | Check existing Stack tracker first |
| 125 | LeetCode | [Largest Rectangle in Histogram](https://leetcode.com/problems/largest-rectangle-in-histogram/) | Hard | Y1 | CORE | AMZ, MSFT, GOO, META, ADB, UBER, FLIP, GS, ACC | Fraz | Check existing Stack tracker first |
| 126 | LeetCode | [Car Fleet](https://leetcode.com/problems/car-fleet/) | Medium | Y1 | COMPANY / STRETCH | AMZ, MSFT, GOO, META, PHONEPE, GS | Siddharth Singh | Check existing Stack tracker first |
| 127 | LeetCode | [Sum of Subarray Minimums](https://leetcode.com/problems/sum-of-subarray-minimums/) | Medium | Y1 | COMPANY / STRETCH | AMZ, MSFT, GOO, META, FLIP, MORGAN, ACC | Fraz | Check existing Stack tracker first |
| 128 | LeetCode | [Online Stock Span](https://leetcode.com/problems/online-stock-span/) | Medium | Y1 | CORE | AMZ, MSFT, GOO, META, ADB | Fraz | New candidate — check existing notes |
| 129 | LeetCode | [Final Prices With a Special Discount in a Shop](https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/) | Easy | Y1 | CORE | AMZ, MSFT, GOO, META, UBER | Not mapped in six-sheet export | New candidate — check existing notes |
| 130 | LeetCode | [Maximum Width Ramp](https://leetcode.com/problems/maximum-width-ramp/) | Medium | Y1 | CORE | AMZ, MSFT, GOO | Not mapped in six-sheet export | New candidate — check existing notes |
| 131 | GeeksforGeeks | [Next Smaller Element](https://www.geeksforgeeks.org/problems/immediate-smaller-element1142/1) | Medium | Y1 | CORE | — | Striver A2Z, Love Babbar 450, Shradha Khapra | Added after popular-sheet audit |

## 11. Stack Parsing / Simulation — 12 problems

| # | Platform | Problem | Level | First-pass year | Priority | Company tags | Popular-sheet overlap | Existing-work note |
|---:|---|---|---|---|---|---|---|---|
| 132 | LeetCode | [Valid Parentheses](https://leetcode.com/problems/valid-parentheses/) | Easy | Y1 | CORE | AMZ*, MSFT*, GOO*, META, ADB, UBER, FLIP, PHONEPE, GS | Striver A2Z, Shradha Khapra, Siddharth Singh, AlgoPrep 151 | Check existing Stack tracker first |
| 133 | LeetCode | [Min Stack](https://leetcode.com/problems/min-stack/) | Medium | Y1 | CORE | AMZ, MSFT, GOO*, META, ADB, UBER, FLIP, GS | Fraz, AlgoPrep 151 | Check existing Stack tracker first |
| 134 | LeetCode | [Asteroid Collision](https://leetcode.com/problems/asteroid-collision/) | Medium | Y1 | CORE | AMZ, MSFT, GOO, META, UBER, FLIP, PHONEPE, GS | Striver A2Z, Siddharth Singh | Check existing Stack tracker first |
| 135 | LeetCode | [Remove K Digits](https://leetcode.com/problems/remove-k-digits/) | Medium | Y1 | CORE | AMZ*, MSFT, GOO*, META, ADB, PHONEPE, ACC | Striver A2Z, Fraz | Check existing Stack tracker first |
| 136 | LeetCode | [Simplify Path](https://leetcode.com/problems/simplify-path/) | Medium | Y1 | COMPANY / STRETCH | AMZ, MSFT, GOO, META, UBER | Fraz | Check existing Stack tracker first |
| 137 | LeetCode | [Decode String](https://leetcode.com/problems/decode-string/) | Medium | Y1 | COMPANY / STRETCH | AMZ, MSFT, GOO, META, PHONEPE, GS | Fraz | Check existing Stack tracker first |
| 138 | LeetCode | [Basic Calculator II](https://leetcode.com/problems/basic-calculator-ii/) | Medium | Y1 | CORE | AMZ*, MSFT, GOO, META, ADB, UBER | Fraz | Check existing Stack tracker first |
| 139 | LeetCode | [Longest Valid Parentheses](https://leetcode.com/problems/longest-valid-parentheses/) | Hard | Y1 | CORE | AMZ*, MSFT, GOO, META, UBER, MORGAN, ACC | Fraz | Check existing Stack tracker first |
| 140 | LeetCode | [Evaluate Reverse Polish Notation](https://leetcode.com/problems/evaluate-reverse-polish-notation/) | Medium | Y1 | CORE | AMZ, MSFT, GOO, META, GS | Fraz | New candidate — check existing notes |
| 141 | LeetCode | [Basic Calculator](https://leetcode.com/problems/basic-calculator/) | Hard | Y1 | CORE | AMZ, MSFT, GOO, META, ADB, UBER | Fraz | New candidate — check existing notes |
| 142 | LeetCode | [Validate Stack Sequences](https://leetcode.com/problems/validate-stack-sequences/) | Medium | Y1 | COMPANY / STRETCH | AMZ, MSFT, GOO, META | Not mapped in six-sheet export | New candidate — check existing notes |
| 143 | LeetCode | [Verify Preorder Serialization of a Binary Tree](https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/) | Medium | Y3 | COMPANY / STRETCH | — | Not mapped in six-sheet export | Added after popular-sheet audit |

## 12. Queue / Deque / Monotonic Queue — 10 problems

| # | Platform | Problem | Level | First-pass year | Priority | Company tags | Popular-sheet overlap | Existing-work note |
|---:|---|---|---|---|---|---|---|---|
| 144 | LeetCode | [Number of Recent Calls](https://leetcode.com/problems/number-of-recent-calls/) | Easy | Y1 | CORE | AMZ, MSFT, GOO, META | Not mapped in six-sheet export | Check existing Queue tracker first |
| 145 | LeetCode | [Design Circular Queue](https://leetcode.com/problems/design-circular-queue/) | Medium | Y1 | CORE | AMZ, MSFT, GOO, META, GS | Not mapped in six-sheet export | Check existing Queue tracker first |
| 146 | LeetCode | [Design Circular Deque](https://leetcode.com/problems/design-circular-deque/) | Medium | Y1 | CORE | GOO, META, GS | Not mapped in six-sheet export | Check existing Queue tracker first |
| 147 | LeetCode | [Implement Stack using Queues](https://leetcode.com/problems/implement-stack-using-queues/) | Easy | Y1 | CORE | AMZ, MSFT, GOO, META, GS | Shradha Khapra, Fraz | Check existing Queue/Stack tracker first |
| 148 | LeetCode | [Implement Queue using Stacks](https://leetcode.com/problems/implement-queue-using-stacks/) | Easy | Y1 | CORE | AMZ, MSFT, GOO, META | Fraz | Check existing Queue/Stack tracker first |
| 149 | LeetCode | [Dota2 Senate](https://leetcode.com/problems/dota2-senate/) | Medium | Y1 | CORE | AMZ, GOO, META | Not mapped in six-sheet export | Check existing Queue tracker first |
| 150 | LeetCode | [Reveal Cards In Increasing Order](https://leetcode.com/problems/reveal-cards-in-increasing-order/) | Medium | Y1 | COMPANY / STRETCH | AMZ, MSFT, GOO | Not mapped in six-sheet export | Check existing Queue tracker first |
| 151 | LeetCode | [Shortest Subarray with Sum at Least K](https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/) | Hard | Y1 | COMPANY / STRETCH | AMZ, MSFT, GOO, META, PHONEPE, GS | Fraz | Selective — monotonic deque |
| 152 | LeetCode | [Moving Average from Data Stream](https://leetcode.com/problems/moving-average-from-data-stream/) | Easy | Y1 | CORE | AMZ, MSFT, GOO, META | Not mapped in six-sheet export | New candidate — check existing notes |
| 153 | LeetCode | [Design Front Middle Back Queue](https://leetcode.com/problems/design-front-middle-back-queue/) | Medium | Y1 | CORE | AMZ, GOO | Not mapped in six-sheet export | New candidate — check existing notes |

## 13. Backtracking / Subsets / Combinations / Permutations — 17 problems

| # | Platform | Problem | Level | First-pass year | Priority | Company tags | Popular-sheet overlap | Existing-work note |
|---:|---|---|---|---|---|---|---|---|
| 154 | LeetCode | [Subsets](https://leetcode.com/problems/subsets/) | Medium | Y1 | CORE | AMZ, MSFT, GOO, META, UBER, FLIP, GS | Fraz | Check existing Recursion tracker first |
| 155 | LeetCode | [Subsets II](https://leetcode.com/problems/subsets-ii/) | Medium | Y1 | COMPANY / STRETCH | AMZ, MSFT, GOO, META | Not mapped in six-sheet export | Check existing Recursion tracker first |
| 156 | LeetCode | [Combinations](https://leetcode.com/problems/combinations/) | Medium | Y1 | COMPANY / STRETCH | AMZ, MSFT, GOO, META | Not mapped in six-sheet export | Check existing Recursion tracker first |
| 157 | LeetCode | [Combination Sum](https://leetcode.com/problems/combination-sum/) | Medium | Y2 | COMPANY / STRETCH | AMZ, MSFT, GOO, META, UBER | Striver A2Z, Fraz, AlgoPrep 151 | Check existing Recursion tracker first |
| 158 | LeetCode | [Combination Sum II](https://leetcode.com/problems/combination-sum-ii/) | Medium | Y2 | COMPANY / STRETCH | AMZ, MSFT, GOO, META, ADB, MORGAN | Striver A2Z | Check existing Recursion tracker first |
| 159 | LeetCode | [Permutations](https://leetcode.com/problems/permutations/) | Medium | Y2 | COMPANY / STRETCH | AMZ, MSFT, GOO, META, UBER, GS | AlgoPrep 151 | Check existing Recursion tracker first |
| 160 | LeetCode | [Permutations II](https://leetcode.com/problems/permutations-ii/) | Medium | Y2 | COMPANY / STRETCH | AMZ, MSFT, GOO, META | Not mapped in six-sheet export | Check existing Recursion tracker first |
| 161 | LeetCode | [Letter Combinations of a Phone Number](https://leetcode.com/problems/letter-combinations-of-a-phone-number/) | Medium | Y2 | CORE | AMZ, MSFT, GOO*, META, UBER, PHONEPE, GS, ACC | Striver A2Z, Fraz | Check existing Recursion tracker first |
| 162 | LeetCode | [Generate Parentheses](https://leetcode.com/problems/generate-parentheses/) | Medium | Y2 | CORE | AMZ*, MSFT, GOO*, META, ADB, UBER, FLIP, GS, MORGAN | Fraz | Check existing Recursion tracker first |
| 163 | LeetCode | [Combination Sum III](https://leetcode.com/problems/combination-sum-iii/) | Medium | Y2 | CORE | AMZ, MSFT, GOO | Striver A2Z | New candidate — check existing notes |
| 164 | LeetCode | [Word Break II](https://leetcode.com/problems/word-break-ii/) | Hard | Y2 | CORE | AMZ, MSFT, GOO, META, UBER | Fraz | New candidate — check existing notes |
| 165 | LeetCode | [Non-decreasing Subsequences](https://leetcode.com/problems/non-decreasing-subsequences/) | Medium | Y2 | CORE | AMZ, MSFT, GOO | Not mapped in six-sheet export | New candidate — check existing notes |
| 166 | LeetCode | [N-Queens II](https://leetcode.com/problems/n-queens-ii/) | Hard | Y2 | CORE | AMZ, MSFT, GOO, META | Not mapped in six-sheet export | New candidate — check existing notes |
| 167 | LeetCode | [Partition to K Equal Sum Subsets](https://leetcode.com/problems/partition-to-k-equal-sum-subsets/) | Medium | Y2 | CORE | AMZ, MSFT, GOO, META | Not mapped in six-sheet export | New candidate — check existing notes |
| 168 | LeetCode | [Matchsticks to Square](https://leetcode.com/problems/matchsticks-to-square/) | Medium | Y2 | CORE | AMZ, GOO, META, PHONEPE | Not mapped in six-sheet export | New candidate — check existing notes |
| 169 | LeetCode | [Expression Add Operators](https://leetcode.com/problems/expression-add-operators/) | Hard | Y2 | CORE | AMZ, GOO, META | Not mapped in six-sheet export | New candidate — check existing notes |
| 170 | LeetCode | [Remove Invalid Parentheses](https://leetcode.com/problems/remove-invalid-parentheses/) | Hard | Y2 | COMPANY / STRETCH | UBER | Love Babbar 450, Shradha Khapra, Fraz, Siddharth Singh | Added after popular-sheet audit |

## 14. Backtracking / Grid Search and Partitioning — 6 problems

| # | Platform | Problem | Level | First-pass year | Priority | Company tags | Popular-sheet overlap | Existing-work note |
|---:|---|---|---|---|---|---|---|---|
| 171 | LeetCode | [Word Search](https://leetcode.com/problems/word-search/) | Medium | Y2 | CORE | AMZ*, MSFT, GOO, META, ATL, UBER, GS, MORGAN, ACC | Striver A2Z, Shradha Khapra, Fraz | Check existing Recursion tracker first |
| 172 | LeetCode | [Palindrome Partitioning](https://leetcode.com/problems/palindrome-partitioning/) | Medium | Y2 | COMPANY / STRETCH | AMZ, MSFT, GOO, META | Striver A2Z, Siddharth Singh, AlgoPrep 151 | Check existing Recursion tracker first |
| 173 | LeetCode | [Word Search II](https://leetcode.com/problems/word-search-ii/) | Hard | Y2 | CORE | AMZ*, MSFT, GOO, META, UBER | Not mapped in six-sheet export | Selective |
| 174 | LeetCode | [Sudoku Solver](https://leetcode.com/problems/sudoku-solver/) | Hard | Y2 | COMPANY / STRETCH | — | Love Babbar 450, Siddharth Singh | Added after popular-sheet audit |
| 175 | GeeksforGeeks | [Rat in a Maze](https://www.geeksforgeeks.org/problems/rat-in-a-maze-problem/1) | Medium | Y3 | COMPANY / STRETCH | — | Striver A2Z | Added after popular-sheet audit |
| 176 | GeeksforGeeks | [M-Coloring Problem](https://www.geeksforgeeks.org/problems/m-coloring-problem-1587115620/1) | Medium | Y3 | COMPANY / STRETCH | AMZ, UBER | Love Babbar 450, Shradha Khapra, Siddharth Singh | Added after popular-sheet audit |

## 15. Tree DFS / Recursion / Path State — 26 problems

| # | Platform | Problem | Level | First-pass year | Priority | Company tags | Popular-sheet overlap | Existing-work note |
|---:|---|---|---|---|---|---|---|---|
| 177 | LeetCode | [Maximum Depth of Binary Tree](https://leetcode.com/problems/maximum-depth-of-binary-tree/) | Easy | Y2 | CORE | AMZ, MSFT, GOO, META, UBER, ACC | Shradha Khapra, Fraz | Check existing Tree tracker first |
| 178 | LeetCode | [Diameter of Binary Tree](https://leetcode.com/problems/diameter-of-binary-tree/) | Easy | Y2 | COMPANY / STRETCH | AMZ, MSFT, GOO, META, FLIP | Striver A2Z, Fraz | Check existing Tree tracker first |
| 179 | LeetCode | [Same Tree](https://leetcode.com/problems/same-tree/) | Easy | Y2 | CORE | AMZ, MSFT, GOO, META, FLIP | Shradha Khapra, Fraz | Check existing Tree tracker first |
| 180 | LeetCode | [Invert Binary Tree](https://leetcode.com/problems/invert-binary-tree/) | Easy | Y2 | CORE | AMZ, MSFT, GOO, META | Shradha Khapra, Fraz | Check existing Tree tracker first |
| 181 | LeetCode | [Balanced Binary Tree](https://leetcode.com/problems/balanced-binary-tree/) | Easy | Y2 | CORE | AMZ, MSFT, GOO, META | Fraz | Check existing Tree tracker first |
| 182 | LeetCode | [Path Sum](https://leetcode.com/problems/path-sum/) | Easy | Y2 | CORE | AMZ, MSFT, GOO, META, GS | Fraz | Check existing Tree tracker first |
| 183 | LeetCode | [Path Sum II](https://leetcode.com/problems/path-sum-ii/) | Medium | Y2 | COMPANY / STRETCH | AMZ, MSFT, GOO, META | Not mapped in six-sheet export | Check existing Tree tracker first |
| 184 | LeetCode | [Path Sum III](https://leetcode.com/problems/path-sum-iii/) | Medium | Y2 | COMPANY / STRETCH | AMZ, MSFT, GOO, META | Fraz | Check existing Tree tracker first |
| 185 | LeetCode | [Lowest Common Ancestor of a Binary Tree](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/) | Medium | Y2 | CORE | AMZ*, MSFT, GOO, META, ADB, ATL, GS | Striver A2Z, Fraz | Check existing Tree tracker first |
| 186 | LeetCode | [Binary Tree Maximum Path Sum](https://leetcode.com/problems/binary-tree-maximum-path-sum/) | Hard | Y2 | CORE | AMZ, MSFT, GOO, META, ADB, UBER, FLIP, GS | Shradha Khapra, Fraz | Check existing Tree tracker first |
| 187 | LeetCode | [Subtree of Another Tree](https://leetcode.com/problems/subtree-of-another-tree/) | Easy | Y2 | COMPANY / STRETCH | AMZ, MSFT, GOO, META | Shradha Khapra, Fraz | Check existing Tree tracker first |
| 188 | LeetCode | [Construct Binary Tree from Preorder and Inorder Traversal](https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/) | Medium | Y2 | COMPANY / STRETCH | AMZ, MSFT, GOO, META, ADB | Shradha Khapra | Check existing Tree tracker first |
| 189 | LeetCode | [Construct Binary Tree from Inorder and Postorder Traversal](https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/) | Medium | Y2 | COMPANY / STRETCH | AMZ, MSFT, GOO, META | Not mapped in six-sheet export | Check existing Tree tracker first |
| 190 | LeetCode | [Flatten Binary Tree to Linked List](https://leetcode.com/problems/flatten-binary-tree-to-linked-list/) | Medium | Y2 | COMPANY / STRETCH | AMZ, MSFT, GOO, META | Fraz, Siddharth Singh | Check existing Tree tracker first |
| 191 | LeetCode | [Serialize and Deserialize Binary Tree](https://leetcode.com/problems/serialize-and-deserialize-binary-tree/) | Hard | Y2 | CORE | AMZ, MSFT, GOO, META, ATL, UBER, FLIP, PHONEPE | Striver A2Z, Shradha Khapra, Fraz | Check existing Tree tracker first |
| 192 | LeetCode | [Binary Tree Inorder Traversal](https://leetcode.com/problems/binary-tree-inorder-traversal/) | Easy | Y2 | CORE | AMZ, MSFT, GOO, META | Not mapped in six-sheet export | Check existing Tree tracker first |
| 193 | LeetCode | [Binary Tree Preorder Traversal](https://leetcode.com/problems/binary-tree-preorder-traversal/) | Easy | Y2 | CORE | AMZ, MSFT, GOO, META | Not mapped in six-sheet export | Next study item in saved Tree roadmap |
| 194 | LeetCode | [Binary Tree Postorder Traversal](https://leetcode.com/problems/binary-tree-postorder-traversal/) | Easy | Y2 | CORE | AMZ, MSFT, GOO, META | Not mapped in six-sheet export | Check existing Tree tracker first |
| 195 | LeetCode | [Binary Tree Paths](https://leetcode.com/problems/binary-tree-paths/) | Easy | Y2 | COMPANY / STRETCH | AMZ, MSFT, GOO, META | Fraz | Check existing Tree tracker first |
| 196 | LeetCode | [Sum Root to Leaf Numbers](https://leetcode.com/problems/sum-root-to-leaf-numbers/) | Medium | Y2 | COMPANY / STRETCH | AMZ, MSFT, GOO, META | Not mapped in six-sheet export | Check existing Tree tracker first |
| 197 | LeetCode | [Symmetric Tree](https://leetcode.com/problems/symmetric-tree/) | Easy | Y2 | CORE | AMZ, MSFT, GOO, META | Fraz | New candidate — check existing notes |
| 198 | LeetCode | [Minimum Depth of Binary Tree](https://leetcode.com/problems/minimum-depth-of-binary-tree/) | Easy | Y2 | CORE | AMZ, MSFT, GOO, META | Not mapped in six-sheet export | New candidate — check existing notes |
| 199 | LeetCode | [Find Bottom Left Tree Value](https://leetcode.com/problems/find-bottom-left-tree-value/) | Medium | Y2 | CORE | AMZ, MSFT, GOO, META | Not mapped in six-sheet export | New candidate — check existing notes |
| 200 | LeetCode | [All Nodes Distance K in Binary Tree](https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/) | Medium | Y2 | CORE | AMZ, MSFT, GOO, META | Fraz | New candidate — check existing notes |
| 201 | LeetCode | [Binary Tree Cameras](https://leetcode.com/problems/binary-tree-cameras/) | Hard | Y2 | CORE | AMZ, MSFT, GOO, META, UBER, GS | Fraz, AlgoPrep 151 | New candidate — check existing notes |
| 202 | LeetCode | [Longest ZigZag Path in a Binary Tree](https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/) | Medium | Y2 | CORE | AMZ, MSFT | Not mapped in six-sheet export | New candidate — check existing notes |

## 16. Tree BFS / Level Order — 8 problems

| # | Platform | Problem | Level | First-pass year | Priority | Company tags | Popular-sheet overlap | Existing-work note |
|---:|---|---|---|---|---|---|---|---|
| 203 | LeetCode | [Binary Tree Level Order Traversal](https://leetcode.com/problems/binary-tree-level-order-traversal/) | Medium | Y2 | CORE | AMZ, MSFT, GOO, META, ADB, GS, FLIP | Shradha Khapra, Fraz | Check existing Tree/Queue tracker first |
| 204 | LeetCode | [Binary Tree Zigzag Level Order Traversal](https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/) | Medium | Y2 | CORE | AMZ, MSFT, GOO, META, ADB, GS | Fraz | Check existing Tree tracker first |
| 205 | LeetCode | [Binary Tree Right Side View](https://leetcode.com/problems/binary-tree-right-side-view/) | Medium | Y2 | COMPANY / STRETCH | AMZ, MSFT, GOO, META, UBER, ACC | Fraz | Check existing Tree tracker first |
| 206 | LeetCode | [Average of Levels in Binary Tree](https://leetcode.com/problems/average-of-levels-in-binary-tree/) | Easy | Y2 | CORE | AMZ, GOO, META | Not mapped in six-sheet export | Check existing Tree tracker first |
| 207 | LeetCode | [Populating Next Right Pointers in Each Node](https://leetcode.com/problems/populating-next-right-pointers-in-each-node/) | Medium | Y2 | CORE | AMZ, MSFT, GOO, META | Fraz | Check existing Tree tracker first |
| 208 | LeetCode | [Find Largest Value in Each Tree Row](https://leetcode.com/problems/find-largest-value-in-each-tree-row/) | Medium | Y2 | CORE | AMZ, MSFT, GOO, META | Not mapped in six-sheet export | New candidate — check existing notes |
| 209 | LeetCode | [Maximum Width of Binary Tree](https://leetcode.com/problems/maximum-width-of-binary-tree/) | Medium | Y2 | CORE | AMZ, MSFT, GOO, META, FLIP | Fraz | New candidate — check existing notes |
| 210 | LeetCode | [Populating Next Right Pointers in Each Node II](https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/) | Medium | Y2 | COMPANY / STRETCH | — | Not mapped in six-sheet export | Added after popular-sheet audit |

## 17. Binary Search Tree — 9 problems

| # | Platform | Problem | Level | First-pass year | Priority | Company tags | Popular-sheet overlap | Existing-work note |
|---:|---|---|---|---|---|---|---|---|
| 211 | LeetCode | [Validate Binary Search Tree](https://leetcode.com/problems/validate-binary-search-tree/) | Medium | Y2 | CORE | AMZ, MSFT, GOO, META | Shradha Khapra, Fraz | Check existing Tree tracker first |
| 212 | LeetCode | [Kth Smallest Element in a BST](https://leetcode.com/problems/kth-smallest-element-in-a-bst/) | Medium | Y2 | CORE | AMZ, MSFT, GOO, META, UBER | Shradha Khapra, Fraz | Check existing Tree tracker first |
| 213 | LeetCode | [Search in a Binary Search Tree](https://leetcode.com/problems/search-in-a-binary-search-tree/) | Easy | Y2 | CORE | AMZ, MSFT, GOO, META | Striver A2Z | Check existing Tree tracker first |
| 214 | LeetCode | [Insert into a Binary Search Tree](https://leetcode.com/problems/insert-into-a-binary-search-tree/) | Medium | Y2 | COMPANY / STRETCH | AMZ, MSFT, GOO, META | Not mapped in six-sheet export | Check existing Tree tracker first |
| 215 | LeetCode | [Lowest Common Ancestor of a Binary Search Tree](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/) | Medium | Y2 | COMPANY / STRETCH | AMZ, MSFT, GOO, META, ATL, FLIP | Shradha Khapra, Fraz | Check existing Tree tracker first |
| 216 | LeetCode | [Binary Search Tree Iterator](https://leetcode.com/problems/binary-search-tree-iterator/) | Medium | Y2 | CORE | AMZ, MSFT, GOO, META | Striver A2Z, Fraz | New candidate — check existing notes |
| 217 | LeetCode | [Delete Node in a BST](https://leetcode.com/problems/delete-node-in-a-bst/) | Medium | Y2 | CORE | AMZ, MSFT, GOO, META, UBER, FLIP, ADB | Shradha Khapra | New candidate — check existing notes |
| 218 | LeetCode | [Trim a Binary Search Tree](https://leetcode.com/problems/trim-a-binary-search-tree/) | Medium | Y2 | CORE | AMZ, GOO, ADB | Not mapped in six-sheet export | New candidate — check existing notes |
| 219 | LeetCode | [Recover Binary Search Tree](https://leetcode.com/problems/recover-binary-search-tree/) | Medium | Y2 | CORE | — | Striver A2Z, Fraz, Siddharth Singh | Added after popular-sheet audit |

## 18. Heap / Top K / Two Heaps — 13 problems

| # | Platform | Problem | Level | First-pass year | Priority | Company tags | Popular-sheet overlap | Existing-work note |
|---:|---|---|---|---|---|---|---|---|
| 220 | LeetCode | [Kth Largest Element in an Array](https://leetcode.com/problems/kth-largest-element-in-an-array/) | Medium | Y2 | CORE | AMZ, MSFT, GOO, META, ADB, UBER, FLIP, GS, MORGAN, ACC | Striver A2Z, Shradha Khapra, Fraz, AlgoPrep 151 | New |
| 221 | LeetCode | [Find Median from Data Stream](https://leetcode.com/problems/find-median-from-data-stream/) | Hard | Y2 | CORE | AMZ*, MSFT, GOO, META, ADB, UBER, FLIP, GS | Striver A2Z, Shradha Khapra, Fraz, AlgoPrep 151 | New |
| 222 | LeetCode | [K Closest Points to Origin](https://leetcode.com/problems/k-closest-points-to-origin/) | Medium | Y2 | CORE | AMZ, MSFT, GOO, META, GS | Fraz | New |
| 223 | LeetCode | [Last Stone Weight](https://leetcode.com/problems/last-stone-weight/) | Easy | Y2 | COMPANY / STRETCH | AMZ, MSFT, GOO, META, UBER | Not mapped in six-sheet export | New |
| 224 | LeetCode | [Reorganize String](https://leetcode.com/problems/reorganize-string/) | Medium | Y2 | COMPANY / STRETCH | AMZ, MSFT, GOO, META, GS | Fraz | New |
| 225 | LeetCode | [Kth Largest Element in a Stream](https://leetcode.com/problems/kth-largest-element-in-a-stream/) | Easy | Y2 | COMPANY / STRETCH | AMZ, MSFT, GOO, META, ADB, GS, FLIP | Shradha Khapra | New |
| 226 | LeetCode | [Top K Frequent Words](https://leetcode.com/problems/top-k-frequent-words/) | Medium | Y2 | CORE | AMZ, MSFT, GOO, META, ADB, UBER, GS | Not mapped in six-sheet export | New |
| 227 | LeetCode | [Kth Smallest Element in a Sorted Matrix](https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/) | Medium | Y2 | CORE | AMZ, MSFT, GOO, META, PHONEPE, GS | Fraz | New candidate — check existing notes |
| 228 | LeetCode | [K-th Smallest Prime Fraction](https://leetcode.com/problems/k-th-smallest-prime-fraction/) | Hard | Y2 | COMPANY / STRETCH | — | Fraz | New candidate — check existing notes |
| 229 | LeetCode | [Single-Threaded CPU](https://leetcode.com/problems/single-threaded-cpu/) | Medium | Y2 | COMPANY / STRETCH | AMZ, MSFT, GOO, META | Not mapped in six-sheet export | New candidate — check existing notes |
| 230 | LeetCode | [IPO](https://leetcode.com/problems/ipo/) | Hard | Y2 | CORE | AMZ, MSFT, GOO, META, UBER | Not mapped in six-sheet export | New candidate — check existing notes |
| 231 | LeetCode | [Furthest Building You Can Reach](https://leetcode.com/problems/furthest-building-you-can-reach/) | Medium | Y2 | CORE | AMZ, GOO, META, UBER, PHONEPE | Fraz | New candidate — check existing notes |
| 232 | LeetCode | [Find K Pairs with Smallest Sums](https://leetcode.com/problems/find-k-pairs-with-smallest-sums/) | Medium | Y2 | CORE | AMZ, MSFT, GOO, META, UBER | Not mapped in six-sheet export | New candidate — check existing notes |

## 19. K-Way Merge — 2 problems

| # | Platform | Problem | Level | First-pass year | Priority | Company tags | Popular-sheet overlap | Existing-work note |
|---:|---|---|---|---|---|---|---|---|
| 233 | LeetCode | [Merge k Sorted Lists](https://leetcode.com/problems/merge-k-sorted-lists/) | Hard | Y2 | CORE | AMZ*, MSFT, GOO, META, UBER, FLIP, GS | Shradha Khapra, Fraz | Cross-link: Linked List |
| 234 | LeetCode | [Smallest Range Covering Elements from K Lists](https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists/) | Hard | Y2 | COMPANY / STRETCH | AMZ*, MSFT, GOO, META, FLIP, PHONEPE | Fraz | Selective |

## 20. Greedy / Reachability / Scheduling — 15 problems

| # | Platform | Problem | Level | First-pass year | Priority | Company tags | Popular-sheet overlap | Existing-work note |
|---:|---|---|---|---|---|---|---|---|
| 235 | LeetCode | [Jump Game](https://leetcode.com/problems/jump-game/) | Medium | Y2 | CORE | AMZ, MSFT*, GOO*, META, ADB, FLIP, PHONEPE, GS, MORGAN | Striver A2Z, Fraz | New |
| 236 | LeetCode | [Jump Game II](https://leetcode.com/problems/jump-game-ii/) | Medium | Y2 | CORE | AMZ, MSFT, GOO, META, ADB, ATL, UBER, FLIP, PHONEPE, GS | Fraz | New |
| 237 | LeetCode | [Gas Station](https://leetcode.com/problems/gas-station/) | Medium | Y2 | CORE | AMZ, MSFT, GOO, META, ADB, FLIP, PHONEPE, GS | Fraz, Siddharth Singh | New |
| 238 | LeetCode | [Candy](https://leetcode.com/problems/candy/) | Hard | Y2 | COMPANY / STRETCH | AMZ, MSFT, GOO, META, UBER, GS, MORGAN, ACC | Striver A2Z, Fraz | Selective |
| 239 | LeetCode | [Partition Labels](https://leetcode.com/problems/partition-labels/) | Medium | Y2 | COMPANY / STRETCH | AMZ, MSFT, GOO, META | Fraz, Siddharth Singh | New |
| 240 | LeetCode | [Assign Cookies](https://leetcode.com/problems/assign-cookies/) | Easy | Y2 | CORE | AMZ, MSFT, GOO, META | Striver A2Z | New |
| 241 | LeetCode | [Maximum Length of Pair Chain](https://leetcode.com/problems/maximum-length-of-pair-chain/) | Medium | Y2 | COMPANY / STRETCH | AMZ, GOO, MSFT | Love Babbar 450, Shradha Khapra | New |
| 242 | LeetCode | [Two City Scheduling](https://leetcode.com/problems/two-city-scheduling/) | Medium | Y2 | COMPANY / STRETCH | AMZ, GOO, META | Not mapped in six-sheet export | New |
| 243 | LeetCode | [Queue Reconstruction by Height](https://leetcode.com/problems/queue-reconstruction-by-height/) | Medium | Y2 | COMPANY / STRETCH | AMZ, MSFT, GOO, META, PHONEPE | Not mapped in six-sheet export | New |
| 244 | LeetCode | [Advantage Shuffle](https://leetcode.com/problems/advantage-shuffle/) | Medium | Y2 | CORE | GOO | Not mapped in six-sheet export | New candidate — check existing notes |
| 245 | LeetCode | [Course Schedule III](https://leetcode.com/problems/course-schedule-iii/) | Hard | Y2 | CORE | AMZ, MSFT, GOO, META | Not mapped in six-sheet export | New candidate — check existing notes |
| 246 | LeetCode | [Maximum Number of Events That Can Be Attended](https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended/) | Medium | Y2 | CORE | AMZ, MSFT, GOO, META, UBER, GS | Fraz | New candidate — check existing notes |
| 247 | LeetCode | [Merge Triplets to Form Target Triplet](https://leetcode.com/problems/merge-triplets-to-form-target-triplet/) | Medium | Y2 | CORE | GOO | Not mapped in six-sheet export | New candidate — check existing notes |
| 248 | LeetCode | [Video Stitching](https://leetcode.com/problems/video-stitching/) | Medium | Y2 | CORE | AMZ, GOO | Not mapped in six-sheet export | New candidate — check existing notes |
| 249 | GeeksforGeeks | [Fractional Knapsack](https://www.geeksforgeeks.org/problems/fractional-knapsack-1587115620/1) | Easy | Y3 | COMPANY / STRETCH | — | AlgoPrep 151 | Added after popular-sheet audit |

## 21. Graph DFS / BFS / Grid Components — 14 problems

| # | Platform | Problem | Level | First-pass year | Priority | Company tags | Popular-sheet overlap | Existing-work note |
|---:|---|---|---|---|---|---|---|---|
| 250 | LeetCode | [Number of Islands](https://leetcode.com/problems/number-of-islands/) | Medium | Y2 | CORE | AMZ*, MSFT, GOO*, META, ADB, UBER, FLIP, PHONEPE, GS, ACC | Striver A2Z, Shradha Khapra, Fraz, Siddharth Singh, AlgoPrep 151 | New |
| 251 | LeetCode | [Max Area of Island](https://leetcode.com/problems/max-area-of-island/) | Medium | Y2 | COMPANY / STRETCH | AMZ, MSFT, GOO, META, ADB, GS | Fraz | New |
| 252 | LeetCode | [Clone Graph](https://leetcode.com/problems/clone-graph/) | Medium | Y2 | COMPANY / STRETCH | AMZ, MSFT, GOO, META, UBER | Shradha Khapra, Fraz | New |
| 253 | LeetCode | [Rotting Oranges](https://leetcode.com/problems/rotting-oranges/) | Medium | Y2 | CORE | AMZ*, MSFT, GOO*, META, ADB, UBER, FLIP, GS | Fraz, Siddharth Singh, AlgoPrep 151 | New |
| 254 | LeetCode | [Pacific Atlantic Water Flow](https://leetcode.com/problems/pacific-atlantic-water-flow/) | Medium | Y2 | CORE | AMZ, MSFT, GOO, META, ADB, FLIP | Not mapped in six-sheet export | New |
| 255 | LeetCode | [Word Ladder](https://leetcode.com/problems/word-ladder/) | Hard | Y2 | CORE | AMZ, MSFT, GOO, META, ADB, UBER, FLIP, PHONEPE | Love Babbar 450, Shradha Khapra, Fraz, Siddharth Singh | Selective |
| 256 | LeetCode | [Find if Path Exists in Graph](https://leetcode.com/problems/find-if-path-exists-in-graph/) | Easy | Y2 | COMPANY / STRETCH | AMZ, MSFT, GOO, META | Not mapped in six-sheet export | New |
| 257 | LeetCode | [Keys and Rooms](https://leetcode.com/problems/keys-and-rooms/) | Medium | Y2 | CORE | AMZ, MSFT, GOO, META | Fraz | New candidate — check existing notes |
| 258 | LeetCode | [All Paths From Source to Target](https://leetcode.com/problems/all-paths-from-source-to-target/) | Medium | Y2 | CORE | AMZ, GOO, META | Fraz | New candidate — check existing notes |
| 259 | LeetCode | [Snakes and Ladders](https://leetcode.com/problems/snakes-and-ladders/) | Medium | Y2 | CORE | AMZ, MSFT, GOO, META, GS | Shradha Khapra, Fraz | New candidate — check existing notes |
| 260 | LeetCode | [Shortest Path with Alternating Colors](https://leetcode.com/problems/shortest-path-with-alternating-colors/) | Medium | Y2 | COMPANY / STRETCH | AMZ, MSFT, GOO | Not mapped in six-sheet export | New candidate — check existing notes |
| 261 | LeetCode | [Critical Connections in a Network](https://leetcode.com/problems/critical-connections-in-a-network/) | Hard | Y2 | CORE | AMZ, MSFT, GOO, META, FLIP | Fraz | New candidate — check existing notes |
| 262 | GeeksforGeeks | [Number of Distinct Islands](https://www.geeksforgeeks.org/problems/number-of-distinct-islands/1) | Medium | Y2 | CORE | — | Striver A2Z, Siddharth Singh, AlgoPrep 151 | Added after popular-sheet audit |
| 263 | GeeksforGeeks | [Articulation Point](https://www.geeksforgeeks.org/problems/articulation-point-1/1) | Hard | Y3 | COMPANY / STRETCH | — | Striver A2Z, Siddharth Singh, AlgoPrep 151 | Added after popular-sheet audit |

## 22. Topological Sort / Union-Find — 11 problems

| # | Platform | Problem | Level | First-pass year | Priority | Company tags | Popular-sheet overlap | Existing-work note |
|---:|---|---|---|---|---|---|---|---|
| 264 | LeetCode | [Course Schedule](https://leetcode.com/problems/course-schedule/) | Medium | Y2 | CORE | AMZ, MSFT, GOO*, META, ADB, UBER, FLIP, GS | Not mapped in six-sheet export | New |
| 265 | LeetCode | [Course Schedule II](https://leetcode.com/problems/course-schedule-ii/) | Medium | Y2 | CORE | AMZ*, MSFT, GOO*, META, UBER, FLIP, GS | Striver A2Z, Fraz | New |
| 266 | LeetCode | [Number of Provinces](https://leetcode.com/problems/number-of-provinces/) | Medium | Y2 | CORE | AMZ, MSFT, GOO, META, ADB, UBER | Striver A2Z, Fraz | New |
| 267 | LeetCode | [Accounts Merge](https://leetcode.com/problems/accounts-merge/) | Medium | Y2 | COMPANY / STRETCH | AMZ, MSFT, GOO, META, UBER, GS | Striver A2Z, Fraz | New |
| 268 | LeetCode | [Redundant Connection](https://leetcode.com/problems/redundant-connection/) | Medium | Y2 | CORE | AMZ, MSFT, GOO, META | Fraz, Siddharth Singh, AlgoPrep 151 | New |
| 269 | LeetCode | [Find Eventual Safe States](https://leetcode.com/problems/find-eventual-safe-states/) | Medium | Y2 | COMPANY / STRETCH | AMZ, MSFT, GOO, META, UBER | Striver A2Z, Fraz | New |
| 270 | LeetCode | [Number of Operations to Make Network Connected](https://leetcode.com/problems/number-of-operations-to-make-network-connected/) | Medium | Y2 | COMPANY / STRETCH | AMZ, MSFT, GOO, META, PHONEPE | Striver A2Z, Shradha Khapra, Fraz | New |
| 271 | LeetCode | [Evaluate Division](https://leetcode.com/problems/evaluate-division/) | Medium | Y2 | CORE | AMZ*, MSFT, GOO, META, UBER, FLIP, PHONEPE, GS | Fraz, Siddharth Singh | New |
| 272 | LeetCode | [Smallest String With Swaps](https://leetcode.com/problems/smallest-string-with-swaps/) | Medium | Y2 | CORE | AMZ, MSFT, GOO, PHONEPE, GS | Not mapped in six-sheet export | New candidate — check existing notes |
| 273 | LeetCode | [Redundant Connection II](https://leetcode.com/problems/redundant-connection-ii/) | Hard | Y2 | CORE | GOO | Fraz | New candidate — check existing notes |
| 274 | GeeksforGeeks | [Alien Dictionary](https://www.geeksforgeeks.org/problems/alien-dictionary/1) | Hard | Y2 | CORE | — | Striver A2Z, Siddharth Singh, AlgoPrep 151 | Added after popular-sheet audit |

## 23. Shortest Path / Minimum Spanning Tree — 11 problems

| # | Platform | Problem | Level | First-pass year | Priority | Company tags | Popular-sheet overlap | Existing-work note |
|---:|---|---|---|---|---|---|---|---|
| 275 | LeetCode | [Network Delay Time](https://leetcode.com/problems/network-delay-time/) | Medium | Y2 | CORE | AMZ, MSFT, GOO, META | Striver A2Z, Fraz | New |
| 276 | LeetCode | [Cheapest Flights Within K Stops](https://leetcode.com/problems/cheapest-flights-within-k-stops/) | Medium | Y2 | CORE | AMZ, MSFT, GOO, META, UBER, FLIP | Striver A2Z, Love Babbar 450, Shradha Khapra, Fraz | New |
| 277 | LeetCode | [Min Cost to Connect All Points](https://leetcode.com/problems/min-cost-to-connect-all-points/) | Medium | Y2 | CORE | AMZ, MSFT, GOO, META, UBER | Not mapped in six-sheet export | New |
| 278 | LeetCode | [Shortest Path in Binary Matrix](https://leetcode.com/problems/shortest-path-in-binary-matrix/) | Medium | Y2 | COMPANY / STRETCH | AMZ, MSFT, GOO, META, UBER | Not mapped in six-sheet export | Selective — BFS + shortest path |
| 279 | LeetCode | [Swim in Rising Water](https://leetcode.com/problems/swim-in-rising-water/) | Hard | Y2 | COMPANY / STRETCH | AMZ, MSFT, GOO, META | Striver A2Z, Fraz, Siddharth Singh, AlgoPrep 151 | Selective — Graph + Heap / Binary Search |
| 280 | LeetCode | [Path With Minimum Effort](https://leetcode.com/problems/path-with-minimum-effort/) | Medium | Y2 | CORE | AMZ, MSFT, GOO, META | Striver A2Z | New candidate — check existing notes |
| 281 | LeetCode | [Path with Maximum Probability](https://leetcode.com/problems/path-with-maximum-probability/) | Medium | Y2 | CORE | AMZ, GOO | Not mapped in six-sheet export | New candidate — check existing notes |
| 282 | LeetCode | [Shortest Path in a Grid with Obstacles Elimination](https://leetcode.com/problems/shortest-path-in-a-grid-with-obstacles-elimination/) | Hard | Y2 | CORE | AMZ, GOO, META, ADB, UBER | Not mapped in six-sheet export | New candidate — check existing notes |
| 283 | GeeksforGeeks | [Bellman-Ford](https://www.geeksforgeeks.org/problems/distance-from-the-source-bellman-ford-algorithm/1) | Medium | Y3 | COMPANY / STRETCH | — | Shradha Khapra, Siddharth Singh, AlgoPrep 151 | Added after popular-sheet audit |
| 284 | GeeksforGeeks | [Floyd-Warshall](https://www.geeksforgeeks.org/problems/implementing-floyd-warshall2042/1) | Medium | Y3 | COMPANY / STRETCH | GOO, UBER | Shradha Khapra, Siddharth Singh, AlgoPrep 151 | Added after popular-sheet audit |
| 285 | GeeksforGeeks | [Minimum Spanning Tree (Prim's Algorithm)](https://www.geeksforgeeks.org/problems/minimum-spanning-tree/1) | Medium | Y3 | COMPANY / STRETCH | — | Not mapped in six-sheet export | Added after popular-sheet audit |

## 24. DP 1D / Take-Skip — 15 problems

| # | Platform | Problem | Level | First-pass year | Priority | Company tags | Popular-sheet overlap | Existing-work note |
|---:|---|---|---|---|---|---|---|---|
| 286 | LeetCode | [Climbing Stairs](https://leetcode.com/problems/climbing-stairs/) | Easy | Y2 | CORE | AMZ, MSFT*, GOO, META, ADB, GS, ACC | Shradha Khapra, Fraz | Check existing DP notes first |
| 287 | LeetCode | [Min Cost Climbing Stairs](https://leetcode.com/problems/min-cost-climbing-stairs/) | Easy | Y2 | COMPANY / STRETCH | AMZ, MSFT, GOO, META | Not mapped in six-sheet export | Check existing DP notes first |
| 288 | LeetCode | [House Robber](https://leetcode.com/problems/house-robber/) | Medium | Y2 | CORE | AMZ*, MSFT, GOO*, META, ADB, UBER, PHONEPE, GS | Shradha Khapra, Fraz | Check existing DP notes first |
| 289 | LeetCode | [House Robber II](https://leetcode.com/problems/house-robber-ii/) | Medium | Y2 | COMPANY / STRETCH | AMZ, MSFT, GOO, META | Not mapped in six-sheet export | Check existing DP notes first |
| 290 | LeetCode | [Delete and Earn](https://leetcode.com/problems/delete-and-earn/) | Medium | Y2 | COMPANY / STRETCH | AMZ, MSFT, GOO, META, MORGAN | Fraz | Check existing DP notes first |
| 291 | LeetCode | [Maximum Subarray](https://leetcode.com/problems/maximum-subarray/) | Medium | Y2 | CORE | AMZ*, MSFT, GOO*, META, ATL, UBER, PHONEPE, GS, MORGAN, ACC | Striver A2Z, Love Babbar 450, Shradha Khapra, Fraz, Siddharth Singh, AlgoPrep 151 | Review — Kadane's previously practised |
| 292 | LeetCode | [Best Time to Buy and Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/) | Easy | Y2 | CORE | AMZ*, MSFT*, GOO*, META, ADB, ATL, UBER, FLIP, GS, MORGAN, ACC | Striver A2Z, Love Babbar 450, Shradha Khapra, Fraz, Siddharth Singh, AlgoPrep 151 | New / verify |
| 293 | LeetCode | [Best Time to Buy and Sell Stock II](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/) | Medium | Y2 | CORE | AMZ, MSFT, GOO, META, ATL, GS, ACC | Striver A2Z, Fraz | Check existing DP notes first |
| 294 | LeetCode | [House Robber III](https://leetcode.com/problems/house-robber-iii/) | Medium | Y2 | COMPANY / STRETCH | AMZ, MSFT, GOO, META, UBER | Fraz | Check existing Tree/DP notes first |
| 295 | LeetCode | [Maximum Product Subarray](https://leetcode.com/problems/maximum-product-subarray/) | Medium | Y3 | COMPANY / STRETCH | AMZ, MSFT, GOO, META, ADB, GS, MORGAN | Striver A2Z, Shradha Khapra, Fraz, Siddharth Singh, AlgoPrep 151 | Check existing DP notes first |
| 296 | LeetCode | [N-th Tribonacci Number](https://leetcode.com/problems/n-th-tribonacci-number/) | Easy | Y3 | CORE | AMZ, MSFT, GOO, META | Not mapped in six-sheet export | New candidate — check existing notes |
| 297 | LeetCode | [Domino and Tromino Tiling](https://leetcode.com/problems/domino-and-tromino-tiling/) | Medium | Y3 | CORE | AMZ, MSFT, GOO, META, GS | Not mapped in six-sheet export | New candidate — check existing notes |
| 298 | LeetCode | [Minimum Cost For Tickets](https://leetcode.com/problems/minimum-cost-for-tickets/) | Medium | Y3 | CORE | AMZ, MSFT, GOO, META, ADB, UBER | Not mapped in six-sheet export | New candidate — check existing notes |
| 299 | LeetCode | [Combination Sum IV](https://leetcode.com/problems/combination-sum-iv/) | Medium | Y3 | CORE | AMZ, GOO, META, MSFT, ADB | Shradha Khapra | New candidate — check existing notes |
| 300 | LeetCode | [Frog Jump](https://leetcode.com/problems/frog-jump/) | Hard | Y2 | CORE | — | Fraz, Siddharth Singh, AlgoPrep 151 | Added after popular-sheet audit |

## 25. DP Knapsack / Subset Sum — 7 problems

| # | Platform | Problem | Level | First-pass year | Priority | Company tags | Popular-sheet overlap | Existing-work note |
|---:|---|---|---|---|---|---|---|---|
| 301 | LeetCode | [Coin Change](https://leetcode.com/problems/coin-change/) | Medium | Y3 | CORE | AMZ*, MSFT, GOO, META, ADB, UBER, PHONEPE, GS, MORGAN | Striver A2Z, Love Babbar 450, Shradha Khapra, Fraz, Siddharth Singh, AlgoPrep 151 | Check existing DP notes first |
| 302 | LeetCode | [Coin Change II](https://leetcode.com/problems/coin-change-2/) | Medium | Y3 | COMPANY / STRETCH | AMZ, MSFT, GOO, META | Not mapped in six-sheet export | Check existing DP notes first |
| 303 | LeetCode | [Partition Equal Subset Sum](https://leetcode.com/problems/partition-equal-subset-sum/) | Medium | Y3 | CORE | AMZ, MSFT, GOO, META, GS, ADB | Shradha Khapra | Check existing DP notes first |
| 304 | LeetCode | [Target Sum](https://leetcode.com/problems/target-sum/) | Medium | Y3 | CORE | AMZ, MSFT, GOO, META | Not mapped in six-sheet export | Check existing DP notes first |
| 305 | LeetCode | [Ones and Zeroes](https://leetcode.com/problems/ones-and-zeroes/) | Medium | Y3 | CORE | AMZ, GOO, META, UBER | Not mapped in six-sheet export | New candidate — check existing notes |
| 306 | LeetCode | [Last Stone Weight II](https://leetcode.com/problems/last-stone-weight-ii/) | Medium | Y3 | CORE | AMZ, GOO, META | Not mapped in six-sheet export | New candidate — check existing notes |
| 307 | GeeksforGeeks | [0/1 Knapsack](https://www.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1) | Medium | Y2 | CORE | — | Not mapped in six-sheet export | Added after popular-sheet audit |

## 26. DP Grid / Matrix Paths — 8 problems

| # | Platform | Problem | Level | First-pass year | Priority | Company tags | Popular-sheet overlap | Existing-work note |
|---:|---|---|---|---|---|---|---|---|
| 308 | LeetCode | [Unique Paths](https://leetcode.com/problems/unique-paths/) | Medium | Y3 | CORE | AMZ, MSFT, GOO, META, FLIP, GS | Shradha Khapra, Fraz | Check existing DP notes first |
| 309 | LeetCode | [Unique Paths II](https://leetcode.com/problems/unique-paths-ii/) | Medium | Y3 | COMPANY / STRETCH | AMZ, MSFT, GOO, META, FLIP, GS | Not mapped in six-sheet export | Check existing DP notes first |
| 310 | LeetCode | [Minimum Path Sum](https://leetcode.com/problems/minimum-path-sum/) | Medium | Y3 | CORE | AMZ, MSFT, GOO, META, UBER, GS | Not mapped in six-sheet export | Check existing DP notes first |
| 311 | LeetCode | [Triangle](https://leetcode.com/problems/triangle/) | Medium | Y3 | COMPANY / STRETCH | AMZ, MSFT, GOO, META | Not mapped in six-sheet export | Check existing DP notes first |
| 312 | LeetCode | [Maximal Square](https://leetcode.com/problems/maximal-square/) | Medium | Y3 | CORE | AMZ, MSFT, GOO*, META, FLIP, PHONEPE, GS | Fraz | New |
| 313 | LeetCode | [Dungeon Game](https://leetcode.com/problems/dungeon-game/) | Hard | Y3 | CORE | AMZ, MSFT, GOO, META, UBER, FLIP | Siddharth Singh | Selective |
| 314 | LeetCode | [Minimum Falling Path Sum](https://leetcode.com/problems/minimum-falling-path-sum/) | Medium | Y3 | CORE | AMZ, MSFT, GOO, META, GS | Not mapped in six-sheet export | New candidate — check existing notes |
| 315 | LeetCode | [Count Square Submatrices with All Ones](https://leetcode.com/problems/count-square-submatrices-with-all-ones/) | Medium | Y3 | CORE | AMZ, MSFT, GOO, META, GS | Fraz | New candidate — check existing notes |

## 27. DP Subsequences / Strings / Palindromes — 14 problems

| # | Platform | Problem | Level | First-pass year | Priority | Company tags | Popular-sheet overlap | Existing-work note |
|---:|---|---|---|---|---|---|---|---|
| 316 | LeetCode | [Longest Increasing Subsequence](https://leetcode.com/problems/longest-increasing-subsequence/) | Medium | Y3 | CORE | AMZ, MSFT, GOO, META, GS, MORGAN, ACC | Love Babbar 450, Fraz, Siddharth Singh, AlgoPrep 151 | Check existing DP notes first |
| 317 | LeetCode | [Number of Longest Increasing Subsequence](https://leetcode.com/problems/number-of-longest-increasing-subsequence/) | Medium | Y3 | COMPANY / STRETCH | AMZ, MSFT, GOO, META | Not mapped in six-sheet export | Check existing DP notes first |
| 318 | LeetCode | [Longest Common Subsequence](https://leetcode.com/problems/longest-common-subsequence/) | Medium | Y3 | CORE | AMZ, MSFT, GOO, META, MORGAN | Striver A2Z, Love Babbar 450, Shradha Khapra, Siddharth Singh, AlgoPrep 151 | Check existing DP notes first |
| 319 | LeetCode | [Edit Distance](https://leetcode.com/problems/edit-distance/) | Medium | Y3 | COMPANY / STRETCH | AMZ, MSFT, GOO, META, FLIP, GS | Striver A2Z, Love Babbar 450, Shradha Khapra, Fraz, Siddharth Singh, AlgoPrep 151 | Check existing DP notes first |
| 320 | LeetCode | [Distinct Subsequences](https://leetcode.com/problems/distinct-subsequences/) | Hard | Y3 | COMPANY / STRETCH | AMZ, MSFT, GOO, META | Fraz, Siddharth Singh | Check existing DP notes first |
| 321 | LeetCode | [Word Break](https://leetcode.com/problems/word-break/) | Medium | Y3 | COMPANY / STRETCH | AMZ, MSFT, GOO, META, UBER | Striver A2Z, Love Babbar 450, Shradha Khapra, Fraz, Siddharth Singh | Check existing DP notes first |
| 322 | LeetCode | [Longest Palindromic Substring](https://leetcode.com/problems/longest-palindromic-substring/) | Medium | Y3 | CORE | AMZ, MSFT, GOO, META, ADB, UBER, FLIP, PHONEPE, GS, MORGAN, ACC | Striver A2Z, Love Babbar 450, Shradha Khapra, Fraz | New |
| 323 | LeetCode | [Longest Palindromic Subsequence](https://leetcode.com/problems/longest-palindromic-subsequence/) | Medium | Y3 | COMPANY / STRETCH | AMZ, MSFT, GOO, META, UBER, GS | Striver A2Z, Love Babbar 450 | Selective |
| 324 | LeetCode | [Palindromic Substrings](https://leetcode.com/problems/palindromic-substrings/) | Medium | Y3 | CORE | AMZ, MSFT, GOO, META, GS* | Shradha Khapra, Fraz, Siddharth Singh | New |
| 325 | LeetCode | [Decode Ways](https://leetcode.com/problems/decode-ways/) | Medium | Y3 | CORE | AMZ, MSFT, GOO, META, ADB, UBER, FLIP, PHONEPE, GS | Shradha Khapra, Fraz | New |
| 326 | LeetCode | [Delete Operation for Two Strings](https://leetcode.com/problems/delete-operation-for-two-strings/) | Medium | Y3 | CORE | AMZ, MSFT, GOO, META | Not mapped in six-sheet export | New candidate — check existing notes |
| 327 | LeetCode | [Maximum Length of Repeated Subarray](https://leetcode.com/problems/maximum-length-of-repeated-subarray/) | Medium | Y3 | CORE | AMZ, MSFT, GOO | Fraz | New candidate — check existing notes |
| 328 | LeetCode | [Minimum Insertion Steps to Make a String Palindrome](https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/) | Hard | Y3 | CORE | AMZ, MSFT, GOO, ACC | Fraz | New candidate — check existing notes |
| 329 | GeeksforGeeks | [Longest Common Substring](https://www.geeksforgeeks.org/problems/longest-common-substring1452/1) | Medium | Y2 | CORE | — | Love Babbar 450, Shradha Khapra, Siddharth Singh | Added after popular-sheet audit |

## 28. DP State Machine / Scheduling — 5 problems

| # | Platform | Problem | Level | First-pass year | Priority | Company tags | Popular-sheet overlap | Existing-work note |
|---:|---|---|---|---|---|---|---|---|
| 330 | LeetCode | [Best Time to Buy and Sell Stock III](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/) | Hard | Y3 | COMPANY / STRETCH | AMZ, MSFT, GOO, META, GS | Fraz | Selective |
| 331 | LeetCode | [Best Time to Buy and Sell Stock with Cooldown](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/) | Medium | Y3 | CORE | AMZ, MSFT, GOO | Not mapped in six-sheet export | Selective |
| 332 | LeetCode | [Best Time to Buy and Sell Stock with Transaction Fee](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/) | Medium | Y3 | CORE | AMZ, MSFT, GOO, META | Not mapped in six-sheet export | Selective |
| 333 | LeetCode | [Maximum Profit in Job Scheduling](https://leetcode.com/problems/maximum-profit-in-job-scheduling/) | Hard | Y3 | CORE | AMZ, MSFT, GOO*, META, UBER, PHONEPE, GS | Not mapped in six-sheet export | Selective — DP + Binary Search |
| 334 | LeetCode | [Minimum Swaps To Make Sequences Increasing](https://leetcode.com/problems/minimum-swaps-to-make-sequences-increasing/) | Hard | Y3 | CORE | AMZ, GOO, META | Not mapped in six-sheet export | New candidate — check existing notes |

## 29. Trie / Prefix Search — 6 problems

| # | Platform | Problem | Level | First-pass year | Priority | Company tags | Popular-sheet overlap | Existing-work note |
|---:|---|---|---|---|---|---|---|---|
| 335 | LeetCode | [Longest Common Prefix](https://leetcode.com/problems/longest-common-prefix/) | Easy | Y3 | CORE | AMZ*, MSFT*, GOO*, META, ADB, UBER, PHONEPE, ACC | Striver A2Z, Love Babbar 450, Shradha Khapra, Fraz | New |
| 336 | LeetCode | [Implement Trie (Prefix Tree)](https://leetcode.com/problems/implement-trie-prefix-tree/) | Medium | Y3 | COMPANY / STRETCH | AMZ, MSFT, GOO, META, UBER, GS | Not mapped in six-sheet export | New |
| 337 | LeetCode | [Design Add and Search Words Data Structure](https://leetcode.com/problems/design-add-and-search-words-data-structure/) | Medium | Y3 | COMPANY / STRETCH | AMZ, MSFT, GOO, META, ATL | Not mapped in six-sheet export | New |
| 338 | LeetCode | [Replace Words](https://leetcode.com/problems/replace-words/) | Medium | Y3 | CORE | GOO, UBER | Not mapped in six-sheet export | New candidate — check existing notes |
| 339 | LeetCode | [Search Suggestions System](https://leetcode.com/problems/search-suggestions-system/) | Medium | Y3 | CORE | AMZ, MSFT, GOO, META, UBER | Siddharth Singh | New candidate — check existing notes |
| 340 | LeetCode | [Map Sum Pairs](https://leetcode.com/problems/map-sum-pairs/) | Medium | Y3 | CORE | FLIP | Not mapped in six-sheet export | New candidate — check existing notes |

## 30. Bit Manipulation — 9 problems

| # | Platform | Problem | Level | First-pass year | Priority | Company tags | Popular-sheet overlap | Existing-work note |
|---:|---|---|---|---|---|---|---|---|
| 341 | LeetCode | [Single Number](https://leetcode.com/problems/single-number/) | Easy | Y3 | CORE | AMZ, MSFT, GOO, META, ADB, GS, ACC | Not mapped in six-sheet export | New |
| 342 | LeetCode | [Counting Bits](https://leetcode.com/problems/counting-bits/) | Easy | Y3 | COMPANY / STRETCH | AMZ, MSFT, GOO, META | Fraz | New |
| 343 | LeetCode | [Number of 1 Bits](https://leetcode.com/problems/number-of-1-bits/) | Easy | Y3 | CORE | AMZ, MSFT, GOO, META | Not mapped in six-sheet export | New |
| 344 | LeetCode | [Reverse Bits](https://leetcode.com/problems/reverse-bits/) | Easy | Y3 | CORE | AMZ, MSFT, GOO, META | Not mapped in six-sheet export | New |
| 345 | LeetCode | [Missing Number](https://leetcode.com/problems/missing-number/) | Easy | Y3 | COMPANY / STRETCH | AMZ, MSFT, GOO, META, GS | Fraz | New |
| 346 | LeetCode | [Power of Two](https://leetcode.com/problems/power-of-two/) | Easy | Y3 | COMPANY / STRETCH | AMZ, MSFT, GOO, META, GS | Fraz | New |
| 347 | LeetCode | [Single Number III](https://leetcode.com/problems/single-number-iii/) | Medium | Y3 | CORE | AMZ, MSFT, GOO | Not mapped in six-sheet export | New candidate — check existing notes |
| 348 | LeetCode | [Sum of Two Integers](https://leetcode.com/problems/sum-of-two-integers/) | Medium | Y3 | CORE | AMZ, MSFT, GOO, META | Not mapped in six-sheet export | New candidate — check existing notes |
| 349 | LeetCode | [Bitwise AND of Numbers Range](https://leetcode.com/problems/bitwise-and-of-numbers-range/) | Medium | Y3 | CORE | AMZ, MSFT, GOO, META | Not mapped in six-sheet export | New candidate — check existing notes |

## 31. Basic Math / Number Patterns — 5 problems

| # | Platform | Problem | Level | First-pass year | Priority | Company tags | Popular-sheet overlap | Existing-work note |
|---:|---|---|---|---|---|---|---|---|
| 350 | LeetCode | [Happy Number](https://leetcode.com/problems/happy-number/) | Easy | Y3 | COMPANY / STRETCH | AMZ, MSFT, GOO, META, UBER, ACC | Fraz | New |
| 351 | LeetCode | [Count Primes](https://leetcode.com/problems/count-primes/) | Medium | Y3 | COMPANY / STRETCH | AMZ, MSFT, GOO, META, UBER, GS, ACC | Not mapped in six-sheet export | Selective |
| 352 | LeetCode | [Multiply Strings](https://leetcode.com/problems/multiply-strings/) | Medium | Y3 | CORE | AMZ, MSFT, GOO, META | Fraz, Siddharth Singh | New candidate — check existing notes |
| 353 | LeetCode | [Pow(x, n)](https://leetcode.com/problems/powx-n/) | Medium | Y3 | CORE | AMZ, MSFT, GOO, META, ADB, GS | Striver A2Z, Fraz | New candidate — check existing notes |
| 354 | LeetCode | [Divide Two Integers](https://leetcode.com/problems/divide-two-integers/) | Medium | Y3 | CORE | AMZ, MSFT, GOO, META | Fraz | New candidate — check existing notes |

## 32. Matrix Traversal / In-place Matrix Transform — 6 problems

| # | Platform | Problem | Level | First-pass year | Priority | Company tags | Popular-sheet overlap | Existing-work note |
|---:|---|---|---|---|---|---|---|---|
| 355 | LeetCode | [Set Matrix Zeroes](https://leetcode.com/problems/set-matrix-zeroes/) | Medium | Y3 | COMPANY / STRETCH | AMZ, MSFT, GOO, META, GS | Shradha Khapra | New |
| 356 | LeetCode | [Spiral Matrix](https://leetcode.com/problems/spiral-matrix/) | Medium | Y3 | CORE | AMZ, MSFT, GOO, META, ADB, UBER, FLIP, PHONEPE, GS, MORGAN | Shradha Khapra, Fraz | New — matrix boundary traversal |
| 357 | LeetCode | [Rotate Image](https://leetcode.com/problems/rotate-image/) | Medium | Y3 | CORE | AMZ, MSFT, GOO, META, ADB, UBER, FLIP, GS, ACC | Shradha Khapra, Fraz, Siddharth Singh | New — in-place matrix transformation |
| 358 | LeetCode | [Search a 2D Matrix II](https://leetcode.com/problems/search-a-2d-matrix-ii/) | Medium | Y3 | COMPANY / STRETCH | AMZ, MSFT, GOO, META, GS | Not mapped in six-sheet export | New — matrix search / staircase |
| 359 | LeetCode | [Spiral Matrix II](https://leetcode.com/problems/spiral-matrix-ii/) | Medium | Y3 | CORE | AMZ, MSFT, GOO, META, ADB, GS | Not mapped in six-sheet export | New candidate — check existing notes |
| 360 | LeetCode | [Game of Life](https://leetcode.com/problems/game-of-life/) | Medium | Y3 | CORE | AMZ, MSFT, GOO, META, ADB | Fraz | New candidate — check existing notes |

## 33. Data Structure Design — 8 problems

| # | Platform | Problem | Level | First-pass year | Priority | Company tags | Popular-sheet overlap | Existing-work note |
|---:|---|---|---|---|---|---|---|---|
| 361 | LeetCode | [LRU Cache](https://leetcode.com/problems/lru-cache/) | Medium | Y3 | CORE | AMZ, MSFT, GOO, META, ADB, ATL, UBER, FLIP, PHONEPE, GS, MORGAN, ACC | Striver A2Z, Fraz, Siddharth Singh, AlgoPrep 151 | New — HashMap + doubly linked list |
| 362 | LeetCode | [Time Based Key-Value Store](https://leetcode.com/problems/time-based-key-value-store/) | Medium | Y3 | COMPANY / STRETCH | AMZ, MSFT, GOO, META, UBER | Fraz | New — HashMap + binary search |
| 363 | LeetCode | [Insert Delete GetRandom O(1)](https://leetcode.com/problems/insert-delete-getrandom-o1/) | Medium | Y3 | COMPANY / STRETCH | AMZ, MSFT, GOO, META, UBER | Fraz, Siddharth Singh, AlgoPrep 151 | Selective — data structure design |
| 364 | LeetCode | [Logger Rate Limiter](https://leetcode.com/problems/logger-rate-limiter/) | Easy | Y3 | COMPANY / STRETCH | AMZ, MSFT, GOO, META, ATL | Not mapped in six-sheet export | Selective — map + queue/time window |
| 365 | LeetCode | [LFU Cache](https://leetcode.com/problems/lfu-cache/) | Hard | Y3 | CORE | AMZ, MSFT, GOO, META, UBER, GS | Fraz | New candidate — check existing notes |
| 366 | LeetCode | [Design Browser History](https://leetcode.com/problems/design-browser-history/) | Medium | Y3 | CORE | AMZ, MSFT, GOO, UBER, GS | Fraz | New candidate — check existing notes |
| 367 | LeetCode | [Design HashSet](https://leetcode.com/problems/design-hashset/) | Easy | Y3 | CORE | AMZ, GOO, META | Not mapped in six-sheet export | New candidate — check existing notes |
| 368 | LeetCode | [Design HashMap](https://leetcode.com/problems/design-hashmap/) | Easy | Y3 | CORE | AMZ, MSFT, GOO, META, GS | Fraz | New candidate — check existing notes |

## 34. Divide and Conquer — 4 problems

| # | Platform | Problem | Level | First-pass year | Priority | Company tags | Popular-sheet overlap | Existing-work note |
|---:|---|---|---|---|---|---|---|---|
| 369 | LeetCode | [Sort List](https://leetcode.com/problems/sort-list/) | Medium | Y3 | CORE | AMZ, MSFT, GOO, META | Not mapped in six-sheet export | New candidate — check existing notes |
| 370 | LeetCode | [Different Ways to Add Parentheses](https://leetcode.com/problems/different-ways-to-add-parentheses/) | Medium | Y3 | COMPANY / STRETCH | AMZ, MSFT, GOO | Not mapped in six-sheet export | New candidate — check existing notes |
| 371 | LeetCode | [Count of Smaller Numbers After Self](https://leetcode.com/problems/count-of-smaller-numbers-after-self/) | Hard | Y2 | CORE | GOO | Shradha Khapra, Fraz | Added after popular-sheet audit |
| 372 | GeeksforGeeks | [Count Inversions](https://www.geeksforgeeks.org/problems/inversion-of-array-1587115620/1) | Medium | Y3 | CORE | — | Siddharth Singh | Added after popular-sheet audit |

## 35. String Matching / Rolling Hash — 2 problems

| # | Platform | Problem | Level | First-pass year | Priority | Company tags | Popular-sheet overlap | Existing-work note |
|---:|---|---|---|---|---|---|---|---|
| 373 | LeetCode | [Find the Index of the First Occurrence in a String](https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/) | Easy | Y3 | CORE | AMZ, MSFT, GOO, META | Not mapped in six-sheet export | New candidate — check existing notes |
| 374 | LeetCode | [Repeated DNA Sequences](https://leetcode.com/problems/repeated-dna-sequences/) | Medium | Y3 | COMPANY / STRETCH | AMZ, MSFT, GOO, META | Not mapped in six-sheet export | New candidate — check existing notes |

## 36. DP Interval / Partition — 1 problems

| # | Platform | Problem | Level | First-pass year | Priority | Company tags | Popular-sheet overlap | Existing-work note |
|---:|---|---|---|---|---|---|---|---|
| 375 | GeeksforGeeks | [Matrix Chain Multiplication](https://www.geeksforgeeks.org/problems/matrix-chain-multiplication0303/1) | Hard | Y3 | COMPANY / STRETCH | FLIP | Love Babbar 450, Shradha Khapra, AlgoPrep 151 | Added after popular-sheet audit |

## 8. Resource audit — what was compared

### Striver / takeUforward
The current official Striver A2Z page lists **495** questions organised into 20 sections: beginner, sorting, arrays, hashing, binary search, strings, recursion, linked lists, bit manipulation, greedy, sliding-window/two-pointers, stacks/queues, trees/BST, heaps, graphs, DP, tries, advanced strings and maths. This is a full learning course, not a 495-question interview quota.

### Love Babbar 450
The classic GFG sheet covers 15 topics: arrays, matrix, strings, searching/sorting, linked list, bit manipulation, greedy, backtracking, DP, stacks/queues, binary trees, BST, graphs, heap and trie. Copies appear as 445, 448 or 450 depending on version and duplicates. It is a broad source bank, not a compulsory checklist.

### Shradha Khapra / Apna College
The current official Apna College DSA sheet displays **192 problems** and describes them as the major DSA types for placement preparation. Use that current sheet as the source of truth; older downloadable workbook snapshots and public mirrors have different counts. The live sheet is at [dsa.apnacollege.in](https://dsa.apnacollege.in/).

### Cross-sheet aggregation
The public [BooleanStack DSA Sheets repository](https://github.com/orkait-abhay/dsa-sheets) combines AlgoPrep 151, Shradha Khapra, Siddharth Singh, Love Babbar 450, Fraz and Striver A2Z. Its README reports 2,105 raw entries mapped to 1,552 canonical problems. These exported snapshots are older and have inconsistent row counts, so they were used as overlap evidence, not as the official current count of a creator's sheet. **225** questions in this bank map to that six-sheet export by canonical title or URL; no match means “not mapped in this export”, not “absent from the latest creator sheet”.

Source-export matches:
- Striver A2Z: 75
- Love Babbar 450: 27
- Shradha Khapra: 78
- Fraz: 167
- Siddharth Singh: 59
- AlgoPrep 151: 39

### Company-wise data and wider interview cross-checks
Company tags are drawn from selected all-time company-wise CSVs and older sheet annotations. The company index is a filter over the canonical bank, not a second problem list. These datasets are reported/crowd-sourced, not official syllabi.

- [GeeksforGeeks SDE Sheet](https://www.geeksforgeeks.org/explore?curated%5B%5D=1&curated_names%5B%5D=SDE+Sheet&page=1) provides another selected interview set.
- [LeetCode 75](https://leetcode.com/studyplan/leetcode-75/) is a compact baseline, not a three-year syllabus.
- [NeetCode Roadmap](https://neetcode.io/roadmap) is a pattern-order cross-check, not an additional must-solve list.

## 9. What was deliberately left out

Do not convert Striver A2Z 495 or Love Babbar 450 into a mandatory checklist. This bank omits many repeated elementary variants, implementation-only drills, stale platform-specific questions and competitive-programming topics such as advanced geometry, FFT, obscure number theory, digit/probability/game DP and optimisation tricks. Advanced graph and DP questions are included selectively because they teach reusable ideas, not because every SDE-1 role requires them.

## 10. Version policy

**Final v4 — 375 unique questions, 36 patterns, 262 CORE + 113 COMPANY / STRETCH, 684 weekday sessions, 100 extra buffer weekdays.** This supersedes v1, v2 and v3. Keep v4 as the only active problem bank.
