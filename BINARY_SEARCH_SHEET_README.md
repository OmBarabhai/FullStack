# Binary Search Problem Sheet (LeetCode)

A curated list of pure Binary Search problems for placements and interview preparation.

---

# EASY Binary Search

| LC No. | Problem |
|---|---|
| 704 | Binary Search |
| 35 | Search Insert Position |
| 69 | Sqrt(x) |
| 367 | Valid Perfect Square |
| 278 | First Bad Version |
| 374 | Guess Number Higher or Lower |
| 852 | Peak Index in Mountain Array |
| 744 | Find Smallest Letter Greater Than Target |
| 1539 | Kth Missing Positive Number |
| 1346 | Check If N and Its Double Exist |

---

# LOWER BOUND / UPPER BOUND

| LC No. | Problem |
|---|---|
| 34 | Find First and Last Position |
| 35 | Search Insert Position |
| 275 | H-Index II |
| 540 | Single Element in Sorted Array |
| 1064 | Fixed Point |
| 1150 | Check If Majority Element |
| 1287 | Element Appearing More Than 25% |
| 2089 | Find Target Indices After Sorting |

---

# ROTATED SORTED ARRAY

| LC No. | Problem |
|---|---|
| 33 | Search in Rotated Sorted Array |
| 81 | Search in Rotated Sorted Array II |
| 153 | Find Minimum in Rotated Sorted Array |
| 154 | Find Minimum in Rotated Sorted Array II |
| 1752 | Check if Array Is Sorted and Rotated |

---

# PEAK / MOUNTAIN ARRAY

| LC No. | Problem |
|---|---|
| 162 | Find Peak Element |
| 852 | Peak Index in Mountain Array |
| 1095 | Find in Mountain Array |
| 1901 | Find a Peak Element II |

---

# BINARY SEARCH ON ANSWER

| LC No. | Problem |
|---|---|
| 875 | Koko Eating Bananas |
| 1011 | Capacity To Ship Packages Within D Days |
| 410 | Split Array Largest Sum |
| 1482 | Minimum Number of Days to Make m Bouquets |
| 1283 | Smallest Divisor Given Threshold |
| 1552 | Magnetic Force Between Two Balls |
| 1760 | Minimum Limit of Balls in a Bag |
| 2064 | Minimized Maximum of Products |
| 2226 | Maximum Candies Allocated to K Children |
| 2187 | Minimum Time to Complete Trips |
| 1870 | Minimum Speed to Arrive on Time |
| 2594 | Minimum Time to Repair Cars |
| 2616 | Minimize the Maximum Difference |
| 2560 | House Robber IV |
| 2517 | Maximum Tastiness of Candy Basket |
| 2141 | Maximum Running Time of N Computers |
| 2861 | Maximum Number of Alloys |
| 2439 | Minimize Maximum of Array |
| 774 | Minimize Max Distance to Gas Station |
| 1231 | Divide Chocolate |

---

# MATRIX BINARY SEARCH

| LC No. | Problem |
|---|---|
| 74 | Search a 2D Matrix |
| 240 | Search a 2D Matrix II |
| 378 | Kth Smallest Element in Sorted Matrix |
| 668 | Kth Smallest Number in Multiplication Table |
| 786 | K-th Smallest Prime Fraction |

---

# ADVANCED PURE BINARY SEARCH

| LC No. | Problem |
|---|---|
| 4 | Median of Two Sorted Arrays |
| 719 | Find K-th Smallest Pair Distance |
| 878 | Nth Magical Number |
| 1201 | Ugly Number III |
| 644 | Maximum Average Subarray II |
| 302 | Smallest Rectangle Enclosing Black Pixels |
| 793 | Preimage Size of Factorial Zeroes Function |
| 483 | Smallest Good Base |

---

# Total Problems

60 Pure Binary Search Problems

---

# Golden Binary Search Template

```java
while(low <= high){

    int mid = low + (high-low)/2;

    if(check(mid)){
        ans = mid;
        high = mid - 1;
    }else{
        low = mid + 1;
    }
}
```

---

# Classic Binary Search Template

```java
while(low <= high){

    int mid = low + (high-low)/2;

    if(arr[mid] == target){
        return mid;
    }
    else if(arr[mid] < target){
        low = mid + 1;
    }else{
        high = mid - 1;
    }
}
```
Yes. Since this is a temporary chat, save the prompts below somewhere safe (Notion/GitHub/README/text file).

These prompts are designed specifically for:

* Binary Search
* Binary Search on Answer
* Placement-style DSA
* Java
* Pattern recognition
* Interview thinking

---

# MASTER PROMPT FOR BINARY SEARCH

Copy this entire prompt and reuse it for every problem.

```text
You are my DSA mentor.

I am solving Binary Search problems in Java.

For every problem, follow this exact structure:

1. First explain:
   - What type of binary search problem this is
   - Classic BS / Lower Bound / Upper Bound / Rotated Array / Peak / Binary Search on Answer / Matrix BS

2. Then explain:
   - What is the search space
   - Why binary search works
   - What is monotonic in this problem

3. Then derive intuition slowly.

4. Then explain brute force briefly.

5. Then optimize to binary search.

6. Then explain:
   - low initialization
   - high initialization
   - why mid works
   - why we move left/right

7. If Binary Search on Answer:
   explain the isPossible(mid) logic deeply.

8. Then provide clean Java code.

9. Then dry run on sample input.

10. Then explain time complexity.

11. Then give:
   - common mistakes
   - edge cases
   - interview tips

12. Never skip reasoning steps.

13. Do NOT directly give solution immediately.
Help me think first.

14. After solution, give:
   - similar LeetCode problems
   - pattern similarity

15. Use beginner-friendly language but teach interview-level thinking.
```

---

# PROMPT FOR WHEN YOU ARE STUCK

```text
Give me ONLY hints for this Binary Search problem.

Do NOT give full solution.

Help me discover:
- search space
- monotonic condition
- isPossible(mid)

One hint at a time.
```

---

# PROMPT FOR BINARY SEARCH ON ANSWER

This is the most important one.

```text
Teach me this Binary Search on Answer problem step by step.

Explain:
1. What is the answer range?
2. Why is answer monotonic?
3. How do we design isPossible(mid)?
4. Are we minimizing or maximizing?
5. When do we move left or right?

Then help me derive the final code myself.
```

---

# PROMPT FOR DEBUGGING

```text
I will give my Java Binary Search code.

Do NOT rewrite immediately.

First:
1. Find logical mistake
2. Explain WHY it breaks
3. Explain which binary search invariant failed
4. Explain edge case failing
5. Then minimally fix my code

Focus on teaching, not replacing my code.
```

---

# PROMPT FOR PATTERN RECOGNITION

Very useful for interviews.

```text
I want to master Binary Search pattern recognition.

For this problem explain:
- How to IDENTIFY this is binary search
- What clues in statement indicate BS
- Whether this is:
  - exact search
  - lower bound
  - upper bound
  - answer search
  - rotated array
  - peak finding

Then compare it with 3 similar LeetCode problems.
```

---

# PROMPT FOR REVISION

```text
Revise Binary Search patterns for interviews.

Create:
- pattern summary
- templates
- common tricks
- edge cases
- mistakes
- intuition rules

Use Java.
```

---

# GOLDEN RULES FOR BINARY SEARCH

Save these mentally.

## Exact Search

```java id="b8cr54"
while(low <= high)
```

## Lower Bound

Move left when answer found.

## Binary Search on Answer

Always ask:

> “Can this mid value work?”

If YES:

* store answer
* try smaller/bigger depending on minimize/maximize

---

# FAST INTERVIEW CHECKLIST

Before coding ask:

1. What is search space?
2. Is answer monotonic?
3. Can I write check(mid)?
4. Am I minimizing or maximizing?
5. What are low/high bounds?
6. Integer overflow?
7. Infinite loop possibility?

---

# BEST WAY TO LEARN IN 1 WEEK

## Daily Plan

### Day 1

Classic BS

* 704
* 35
* 34
* 69

### Day 2

Rotated + Peak

* 33
* 153
* 162
* 852

### Day 3

Binary Search on Answer

* 875
* 1283
* 1482

### Day 4

Harder Answer Search

* 1011
* 410
* 1552

### Day 5

Advanced

* 2187
* 2226
* 1760

### Day 6

Matrix + Hard

* 74
* 240
* 378

### Day 7

Revision + Re-solve without help

That final day is extremely important.
