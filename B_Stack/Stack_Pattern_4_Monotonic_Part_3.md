# Pattern 4 — Monotonic Stack | Part 3
## Greedy Stack Applications

## Revision navigation

| # | Problem | Main idea |
|---:|---|---|
| 1 | [Remove K Digits — LeetCode 402](https://leetcode.com/problems/remove-k-digits/) | Greedy removals to build the smallest number |
| 2 | [Create Maximum Number — LeetCode 321](https://leetcode.com/problems/create-maximum-number/) | Maximum subsequences, suffix-aware merge, and candidate comparison |

---

# Problem 1 — [Remove K Digits (LC 402)](https://leetcode.com/problems/remove-k-digits/)

## Problem statement

Remove exactly `k` digits from the number so that the remaining number is as small as possible. The relative order of the remaining digits must stay the same.

Example:

```text
num = "1432219"
k = 3
answer = "1219"
```

We are not sorting the digits. We are only deleting digits while preserving their original order.

## Greedy intuition

Read the number from left to right. The stack represents the digits we have decided to keep so far.

When a new digit arrives, compare it with the most recently kept digit (the stack top).

```text
TOP > CURRENT and k > 0
        ↓
Removing TOP allows the smaller CURRENT digit to move earlier
        ↓
Remove TOP and spend one deletion
        ↓
Check the new TOP again
```

Why does a smaller digit earlier help? For numbers with the same number of digits, the first position where two numbers differ decides which number is smaller. Therefore, reducing an earlier digit is more valuable than reducing a later digit.

### Why is it a `while`, not an `if`?

One current digit can make several previous digits look bad.

```text
kept digits: [1, 4, 3]
current:     2
```

- `3 > 2` → remove `3`.
- New top is `4`; `4 > 2` → remove `4`.
- New top is `1`; `1 > 2` is false → stop.
- Add `2`.

The new top must be checked after every pop. That is why the algorithm uses `while`.

## Code

```java
import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Character> st = new ArrayDeque<>();

        for (char curr : num.toCharArray()) {
            // Keep a smaller digit earlier when a deletion is available.
            while (!st.isEmpty() && k > 0 && st.peek() > curr) {
                st.pop();
                k--;
            }
            st.push(curr);
        }

        // If deletions are still left, remove digits from the end.
        while (!st.isEmpty() && k > 0) {
            st.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.removeLast());
        }

        // Remove leading zeroes.
        int idx = 0;
        while (idx < sb.length() && sb.charAt(idx) == '0') {
            idx++;
        }

        String ans = sb.substring(idx);
        if (ans.isEmpty()) {
            return "0";
        } else {
            return ans;
        }
    }
}
```

## Deque operations

In this implementation, `st.push(curr)` inserts at the **front** of the deque.

For example, after reading `1`, then `4`:

```text
Original reading order: 1, 4
Deque front → back:     [4, 1]
                         ↑  ↑
                       top older
```

| Operation | What it means here |
|---|---|
| `st.push(curr)` | Put the current digit at the front; it becomes the newest kept digit. |
| `st.peek()` | Inspect the newest kept digit, which is the previous digit we may remove. |
| `st.pop()` | Remove that newest kept digit from the front. |
| `st.removeLast()` | Take the oldest remaining digit from the back to rebuild the original order. |

**Important:** The deque is shown front-to-back as newest-to-oldest. That is why reconstruction uses `removeLast()`, not `pop()`.

## Why the comparison is strict

The condition means:

```text
previous kept digit > current digit
```

Do not use equality as a reason to remove. Equal digits do not make the earlier digit worse.

Example:

```text
num = "112"
k = 1
```

The two `1`s are equal. If we remove one early, the remaining number becomes `12`. But keeping both `1`s and using the deletion on `2` gives `11`, which is smaller.

So:

```text
TOP > CURRENT  → may pop
TOP = CURRENT  → do not pop for this comparison
TOP < CURRENT  → do not pop
```

The deletion budget is limited. Spend it where it improves the most significant possible position.

## Dry run — `num = "1432219"`, `k = 3`

Deque is displayed **front → back** (newest → oldest), matching `ArrayDeque.push()`.

| Current digit | Decision | Deque after processing | `k` remaining |
|---:|---|---|---:|
| `1` | Empty; push `1` | `[1]` | 3 |
| `4` | `1 > 4` is false; push `4` | `[4, 1]` | 3 |
| `3` | `4 > 3`; pop `4`, then push `3` | `[3, 1]` | 2 |
| `2` | `3 > 2`; pop `3`, then push `2` | `[2, 1]` | 1 |
| `2` | `2 > 2` is false; keep both equal digits | `[2, 2, 1]` | 1 |
| `1` | `2 > 1`; pop one `2`, then push `1` | `[1, 2, 1]` | 0 |
| `9` | No deletions left; push `9` | `[9, 1, 2, 1]` | 0 |

Now rebuild from the back:

```text
removeLast(): 1, then 2, then 1, then 9
result before zero cleanup = "1219"
```

No leading zeroes exist, so the answer is:

```text
"1219"
```

Exactly three digits were removed: `4`, `3`, and one `2`.

## Remaining deletions

Sometimes the digits are already increasing, so the greedy comparison never finds a previous digit that is greater than the current digit.

Example:

```text
num = "12345"
k = 2
```

No digit is popped during the scan. But we still must remove exactly two digits.

The smallest result comes from removing the last two digits:

```text
"12345" → "123"
```

Why the end? Earlier digits are more significant. If no earlier decreasing pair gave us a better choice, preserve the earlier prefix and remove from the right.

## Leading zeroes

After choosing the digits, the resulting string may begin with zeroes. These are not meaningful in the final number.

Example:

```text
num = "10200"
k = 1
```

Remove `1` because `1 > 0`:

```text
remaining digits = "0200"
```

Remove leading zeroes:

```text
"0200" → "200"
```

Another example:

```text
num = "10"
k = 1
```

After deletion, the kept string is `"0"`. Removing its leading zero gives an empty string, so the special result must be `"0"`.

### Why `'0'` and `"0"` are different

| Expression | Type | Why it appears |
|---|---|---|
| `'0'` | `char` | `sb.charAt(idx)` returns one character, so compare it with a character. |
| `"0"` | `String` | The method returns a string, so the all-zero/empty fallback is a string. |

This is why both of these are correct in their respective places:

```java
sb.charAt(idx) == '0'
return "0";
```

## Edge cases

| Input | `k` | Result | Main lesson |
|---|---:|---|---|
| `"112"` | 1 | `"11"` | Equal digits should not be popped just because they are equal. |
| `"1432219"` | 3 | `"1219"` | A current digit may pop multiple previous digits. |
| `"12345"` | 2 | `"123"` | If no useful pop happened, remove leftover digits from the end. |
| `"10200"` | 1 | `"200"` | Remove leading zeroes after constructing the kept digits. |
| `"10"` | 1 | `"0"` | An empty cleaned result must return `"0"`. |
| `"123"` | 3 | `"0"` | Removing all digits returns `"0"`. |
| `"12345"` | 0 | `"12345"` | With no deletion budget, keep every digit. |

## Recall checklist

- [ ] The stack stores the digits kept so far, not the digits to remove.
- [ ] Pop when `TOP > CURRENT` and `k > 0`.
- [ ] After popping, inspect the new top again.
- [ ] Decrease `k` for every popped digit.
- [ ] After reading all digits, use any remaining deletion budget at the end.
- [ ] Rebuild in the original order (`removeLast()` for this deque layout).
- [ ] Remove leading zeroes only after rebuilding.
- [ ] Return `"0"` if nothing remains.

---

# Problem 2 — [Create Maximum Number (LC 321)](https://leetcode.com/problems/create-maximum-number/)

## Problem statement

Given two arrays, create the largest possible number containing exactly `k` digits.

Rules:

1. You may select digits from either array.
2. The relative order inside each original array must be preserved.
3. You may choose how many digits to take from each array.
4. After selecting the subsequences, merge them into the largest possible result.

Example:

```text
nums1 = [3, 4, 6, 5]
nums2 = [9, 1, 2, 5, 8, 3]
k = 5

answer = [9, 8, 6, 5, 3]
```

This problem has four stages:

```text
1. Choose a valid split of k between the arrays.
2. Build the maximum subsequence of the required length from each array.
3. Merge the two subsequences by comparing their remaining suffixes.
4. Compare this complete candidate with the best candidate found so far.
```

The two confusing parts we are focusing on are **suffix comparison during merge** and **lexicographical comparison of candidate versus best**.

## Stage 1 — Choose the split

Let:

```text
take1 = number of digits selected from nums1
take2 = number of digits selected from nums2
```

We need exactly `k` digits:

```text
take1 + take2 = k
take2 = k - take1
```

We cannot choose a negative count or take more digits than an array contains.

### Why is `start` the minimum valid `take1`?

```java
int start = Math.max(0, k - nums2.length);
```

Ask: **What is the minimum number we must take from nums1 because nums2 may not have enough digits?**

Example:

```text
nums1.length = 4
nums2.length = 3
k = 5
```

Array 2 can supply at most 3 digits, so Array 1 must supply at least:

```text
5 - 3 = 2
```

But if Array 2 has 8 digits and `k = 5`, we do not need to take anything from Array 1. A count cannot be negative, so the lower bound is zero.

Therefore:

```java
start = Math.max(0, k - nums2.length);
```

**Meaning:** the minimum number of digits we must take from `nums1`.

### Why is `end` the maximum valid `take1`?

```java
int end = Math.min(k, nums1.length);
```

We cannot take more than:

- `k`, because the final answer has only `k` digits;
- `nums1.length`, because that is all Array 1 contains.

Therefore:

```java
end = Math.min(k, nums1.length);
```

**Meaning:** the maximum number of digits we can take from `nums1`.

### Count is not an index

For an array of length 4:

```text
Indices: 0, 1, 2, 3
Counts:  0, 1, 2, 3, 4
```

`take1 = 4` means **take all four digits**. It does not mean access index 4.

### Valid split example

```text
nums1.length = 4
nums2.length = 6
k = 5
```

```text
start = max(0, 5 - 6) = 0
end   = min(5, 4)    = 4
```

All valid distributions are:

| `take1` | `take2 = k - take1` | Total |
|---:|---:|---:|
| 0 | 5 | 5 |
| 1 | 4 | 5 |
| 2 | 3 | 5 |
| 3 | 2 | 5 |
| 4 | 1 | 5 |

Both endpoints are valid. This is why the loop must use `take1 <= end`, not `take1 < end`.

## Stage 2 — Build maximum subsequences

The helper uses the same greedy idea as Remove K Digits, but the goal is reversed.

- Remove K Digits: remove a larger previous digit when a smaller current digit arrives, because we want the smallest number.
- Maximum subsequence helper: remove a smaller previous digit when a larger current digit arrives, because we want the largest subsequence.

The helper must preserve the original order.

### Helper intuition

```text
TOP < CURRENT
AND
I am allowed to delete some selected digits
        ↓
TOP is a worse earlier choice
        ↓
POP TOP and use one deletion
        ↓
Check the new TOP again
```

The helper calculates:

```java
int remove = nums.length - len;
```

This is the deletion budget: the original array has `nums.length` digits, but we only want `len` digits.

After the scan, if the budget is still positive, remove the remaining extra digits from the top. With this deque arrangement, the top/front is the newest selected digit, which is the rightmost digit in the kept order.

### Example: choose 2 digits from `[3, 4, 6, 5]`

```text
len = 2
remove = 4 - 2 = 2
```

| Current | Decision | Deque front → back | `remove` left |
|---:|---|---|---:|
| 3 | Push | `[3]` | 2 |
| 4 | `4 > 3`, pop 3; push 4 | `[4]` | 1 |
| 6 | `6 > 4`, pop 4; push 6 | `[6]` | 0 |
| 5 | No deletion budget; push 5 | `[5, 6]` | 0 |

Reconstruct from the back:

```text
removeLast() → 6
removeLast() → 5
```

Maximum subsequence of length 2:

```text
[6, 5]
```

## Stage 3 — Merge the subsequences

After selecting the two subsequences, we need to build the largest possible combined sequence.

We must preserve the order inside each subsequence. At every step, we choose which array supplies the next digit.

**Do not compare only the two current digits when they are equal.** Compare the complete remaining suffixes.

### What does “suffix” mean here?

A suffix means the remaining part of an array starting at the current pointer.

```text
sub1 = [6, 7, 9]
         ↑
         i

remaining suffix of sub1 = [6, 7, 9]
```

If `i` moves to 1, the remaining suffix becomes `[7, 9]`.

### Why do we need four pointers/variables?

```java
int i = 0;
int j = 0;
```

These are the **real merge pointers**:

- `i` points to the next unconsumed digit in `sub1`.
- `j` points to the next unconsumed digit in `sub2`.

```java
int p = i;
int q = j;
```

These are **temporary lookahead pointers**:

- `p` investigates the suffix of `sub1`.
- `q` investigates the suffix of `sub2`.

The distinction is crucial:

| Pointer | Job | Does it consume a digit? |
|---|---|---|
| `i` | Actual next position in `sub1` | Yes, when sub1 is selected |
| `j` | Actual next position in `sub2` | Yes, when sub2 is selected |
| `p` | Look ahead through equal digits in sub1 | No |
| `q` | Look ahead through equal digits in sub2 | No |

**Mental sentence:** `p` and `q` investigate; `i` and `j` execute the decision.

### Why do `p` and `q` move while digits are equal?

Consider:

```text
sub1 = [6, 7, 9]
sub2 = [6, 8, 5]
```

At the current positions:

```text
sub1[i] = 6
sub2[j] = 6
```

The current digits tie. Taking either 6 without looking ahead may choose the worse remaining sequence.

Look ahead:

| Comparison | sub1 | sub2 | What to do |
|---:|---:|---:|---|
| First | 6 | 6 | Equal; advance both temporary pointers |
| Second | 7 | 8 | First difference; sub2 suffix is larger |

So the remaining suffixes compare as:

```text
[6, 7, 9] < [6, 8, 5]
```

Choose the current digit from sub2. That digit is still `sub2[j]`, the first 6. We did **not** advance `j` when moving `q`.

### The equal-prefix rule: what if one suffix finishes first?

Example 1:

```text
sub1 = [6]
sub2 = [6, 5]
```

The common prefix is `6`. Then sub1 finishes, while sub2 still has `5`.

```text
[6] < [6, 5]
```

The longer suffix wins, so choose sub2.

Example 2:

```text
sub1 = [6, 5]
sub2 = [6]
```

Now sub2 finishes first, so sub1 wins.

Example 3:

```text
sub1 = [6, 7]
sub2 = [6, 7]
```

Both suffixes finish together and are identical. Either array can supply the next digit without changing the resulting sequence. The code below chooses sub2 in this tie because it checks `p == m` first.

### The three suffix-comparison outcomes

| After skipping equal digits... | Winner |
|---|---|
| `p == m` | sub2 (sub1 finished first, or both finished) |
| `q == n` | sub1 (sub2 finished first) |
| Both still have digits | Whichever next digit is larger |

If both have digits and `sub1[p] > sub2[q]`, sub1 wins. Otherwise sub2 wins.

## Merge code

The inner equality loop is only for looking ahead. After the winner is known, select directly from that winner.

```java
public int[] merge(int[] sub1, int[] sub2) {
    int m = sub1.length;
    int n = sub2.length;

    int[] merge = new int[m + n];
    int i = 0;
    int j = 0;
    int mergeIdx = 0;

    while (i < m && j < n) {
        int p = i;
        int q = j;

        // Skip equal prefixes without consuming merge digits.
        while (p < m && q < n && sub1[p] == sub2[q]) {
            p++;
            q++;
        }

        boolean chooseSub1 = false;

        if (p == m) { // sub1 ended first; choose sub2.
            chooseSub1 = false;
        } else if (q == n) { // sub2 ended first; choose sub1.
            chooseSub1 = true;
        } else if (sub1[p] > sub2[q]) { // First differing digit decides.
            chooseSub1 = true;
        }

        if (chooseSub1) {
            merge[mergeIdx] = sub1[i];
            i++;
        } else {
            merge[mergeIdx] = sub2[j];
            j++;
        }

        mergeIdx++;
    }

    while (i < m) {
        merge[mergeIdx] = sub1[i];
        i++;
        mergeIdx++;
    }

    while (j < n) {
        merge[mergeIdx] = sub2[j];
        j++;
        mergeIdx++;
    }

    return merge;
}
```

### Why don't we compare `sub1[i]` and `sub2[j]` again after setting `chooseSub1`?

Because the suffix comparison has already decided which remaining sequence is better.

Example:

```text
sub1 = [6, 9]
sub2 = [6, 8]
```

The current digits are equal, but looking ahead finds `9 > 8`. Therefore sub1 wins and we must take `sub1[i]` (the 6).

If we compare the current digits again (`6 > 6`), we lose the suffix decision. The decision variable must control the selection directly.

Also, both branches must advance one real pointer. Otherwise, the merge loop makes no progress.

## Merge dry run — `[6, 7]` with `[6, 8]`

Start:

```text
sub1 = [6, 7]      sub2 = [6, 8]
i = 0              j = 0
merge = [_, _, _, _]
```

### Merge iteration 1

Temporary pointers start at `p = 0`, `q = 0`.

```text
sub1[p] = 6
sub2[q] = 6
```

Equal, so move only the temporary pointers:

```text
p = 1
q = 1
```

Now:

```text
sub1[p] = 7
sub2[q] = 8
```

`7 < 8`, so sub2 suffix wins. But the actual pointer `j` is still 0. Take `sub2[j]`, which is 6.

```text
merge = [6, _, _, _]
i = 0
j = 1
mergeIdx = 1
```

### Merge iteration 2

Reset temporary pointers from the actual positions:

```text
p = i = 0
q = j = 1
```

Compare current suffixes:

```text
sub1 suffix = [6, 7]
sub2 suffix = [8]
```

`6 < 8`, so choose sub2 again. Take `sub2[j] = 8`.

```text
merge = [6, 8, _, _]
i = 0
j = 2
mergeIdx = 2
```

Now sub2 is exhausted. The main loop stops, and the leftover loop copies `[6, 7]` from sub1.

Final merge:

```text
[6, 8, 6, 7]
```

**Notice:** every time one digit is consumed, the suffix comparison starts again from the updated actual pointers.

## Stage 4 — Compare complete candidates

Each valid split creates one complete `candidate` array.

- `candidate`: result from the current split.
- `best`: largest complete result found among earlier splits.

We compare them from left to right. This is lexicographical comparison.

### Why does the first differing digit decide?

Example:

```text
candidate = [9, 6, 4, 1, 2]
best      = [9, 6, 3, 2, 1]
```

| Index | Candidate | Best | Decision |
|---:|---:|---:|---|
| 0 | 9 | 9 | Equal; continue |
| 1 | 6 | 6 | Equal; continue |
| 2 | 4 | 3 | Candidate is larger; replace best |

Once the first difference is found, later digits cannot change the winner.

Another example:

```text
candidate = [9, 8, 5, 2]
best      = [9, 8, 6, 1]
```

The first two digits are equal. At index 2, `5 < 6`, so candidate loses. Keep best.

### The three candidate-comparison outcomes

```text
candidate[i] > best[i]  → candidate wins; replace best and stop
candidate[i] < best[i]  → candidate loses; keep best and stop
candidate[i] == best[i] → no decision yet; continue to next position
```

If every position is equal, keeping the existing `best` is fine.

## Complete Java solution

This implementation combines maximum-subsequence selection, suffix-aware merging, and candidate comparison.

```java
import java.util.ArrayDeque;
import java.util.Deque;

class Solution {

    public int[] maxNumberHelper(int[] nums, int len) {
        Deque<Integer> st = new ArrayDeque<>();
        int remove = nums.length - len;

        for (int curr : nums) {
            // A larger current digit improves the earlier position.
            while (!st.isEmpty() && remove > 0 && st.peek() < curr) {
                st.pop();
                remove--;
            }
            st.push(curr);
        }

        // Any remaining deletions remove the rightmost kept digits.
        while (!st.isEmpty() && remove > 0) {
            st.pop();
            remove--;
        }

        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            ans[i] = st.removeLast();
        }

        return ans;
    }

    public int[] merge(int[] sub1, int[] sub2) {
        int m = sub1.length;
        int n = sub2.length;
        int[] merge = new int[m + n];

        int i = 0;
        int j = 0;
        int mergeIdx = 0;

        while (i < m && j < n) {
            int p = i;
            int q = j;

            // Skip equal prefixes before comparing the remaining suffixes.
            while (p < m && q < n && sub1[p] == sub2[q]) {
                p++;
                q++;
            }

            boolean chooseSub1 = false;

            if (p == m) { // sub1 ended first; choose sub2.
                chooseSub1 = false;
            } else if (q == n) { // sub2 ended first; choose sub1.
                chooseSub1 = true;
            } else if (sub1[p] > sub2[q]) { // First differing digit decides.
                chooseSub1 = true;
            }

            if (chooseSub1) {
                merge[mergeIdx] = sub1[i];
                i++;
            } else {
                merge[mergeIdx] = sub2[j];
                j++;
            }
            mergeIdx++;
        }

        while (i < m) {
            merge[mergeIdx] = sub1[i];
            i++;
            mergeIdx++;
        }

        while (j < n) {
            merge[mergeIdx] = sub2[j];
            j++;
            mergeIdx++;
        }

        return merge;
    }

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int start = Math.max(0, k - nums2.length);
        int end = Math.min(k, nums1.length);

        int[] best = null;

        // Try every valid split, including both endpoints.
        for (int take1 = start; take1 <= end; take1++) {
            int take2 = k - take1;

            int[] sub1 = maxNumberHelper(nums1, take1);
            int[] sub2 = maxNumberHelper(nums2, take2);

            int[] candidate = merge(sub1, sub2);

            if (best == null) {
                best = candidate;
            } else {
                // The first differing digit decides which candidate is larger.
                for (int i = 0; i < k; i++) {
                    if (candidate[i] > best[i]) {
                        best = candidate;
                        break;
                    } else if (candidate[i] < best[i]) {
                        break;
                    }
                }
            }
        }

        return best;
    }
}
```

## Dry run — every valid split

Input:

```text
nums1 = [3, 4, 6, 5]
nums2 = [9, 1, 2, 5, 8, 3]
k = 5
```

Array lengths:

```text
nums1.length = 4
nums2.length = 6
```

Valid split range:

```text
start = max(0, 5 - 6) = 0
end   = min(5, 4)    = 4
```

Try every `take1` from 0 through 4:

| `take1` | `take2` | Best subsequence from nums1 | Best subsequence from nums2 | Merged candidate |
|---:|---:|---|---|---|
| 0 | 5 | `[]` | `[9, 2, 5, 8, 3]` | `[9, 2, 5, 8, 3]` |
| 1 | 4 | `[6]` | `[9, 5, 8, 3]` | `[9, 6, 5, 8, 3]` |
| 2 | 3 | `[6, 5]` | `[9, 8, 3]` | `[9, 8, 6, 5, 3]` |
| 3 | 2 | `[4, 6, 5]` | `[9, 8]` | `[9, 8, 4, 6, 5]` |
| 4 | 1 | `[3, 4, 6, 5]` | `[9]` | `[9, 3, 4, 6, 5]` |

Now compare candidates in order:

1. `[9, 2, 5, 8, 3]` becomes the first `best` because no best exists yet.
2. `[9, 6, 5, 8, 3]` beats it at index 1 (`6 > 2`).
3. `[9, 8, 6, 5, 3]` beats it at index 1 (`8 > 6`).
4. `[9, 8, 4, 6, 5]` loses at index 2 (`4 < 6`). Keep the previous best.
5. `[9, 3, 4, 6, 5]` loses at index 1 (`3 < 8`). Keep the previous best.

Final answer:

```text
[9, 8, 6, 5, 3]
```

This demonstrates why we must try every valid split. The best subsequence from each array alone does not automatically tell us the best split; the merged candidate must be evaluated too.

## Merge cases

| Case | `sub1` | `sub2` | Decision | Why |
|---|---|---|---|---|
| First digit differs | `[8, 1]` | `[7, 9]` | sub1 | `8 > 7` immediately |
| Equal first digit, later difference | `[6, 7]` | `[6, 8]` | sub2 | First digits tie; `8 > 7` |
| Several equal digits | `[6, 7, 9]` | `[6, 7, 8]` | sub1 | Skip `6,7`; then `9 > 8` |
| sub1 is a prefix | `[6]` | `[6, 5]` | sub2 | Longer suffix wins |
| sub2 is a prefix | `[6, 5]` | `[6]` | sub1 | Longer suffix wins |
| Identical suffixes | `[6, 7]` | `[6, 7]` | Either | Both choices produce the same sequence |
| One array exhausted after a choice | `[6, 8]` | `[9]` | Copy remainder | No comparison is needed once one array ends |

## Common mistakes

| Mistake | Why it is wrong | Better question |
|---|---|---|
| Treating `take1` as an index | It is a count of selected digits; a length-4 array can contribute 4 digits. | Am I counting selected elements or addressing an array position? |
| Using `< end` in the split loop | It skips the maximum valid count. | Did I include both valid range endpoints? |
| Comparing only `sub1[i]` and `sub2[j]` | Equal current digits require looking at the remaining suffixes. | Which complete remaining suffix is larger? |
| Advancing `i` or `j` during lookahead | That would consume digits before making the decision. | Are these temporary pointers or actual merge pointers? |
| Using `p`/`q` to write the output digit | They only find the winner; the chosen current digit is at `i` or `j`. | Which actual pointer should advance now? |
| Comparing current digits again after `chooseSub1` is known | It can contradict the suffix decision. | Have I already decided which suffix wins? |
| Doing nothing when `chooseSub1` is false | The merge loop would not advance. | Does every iteration consume exactly one digit? |
| Choosing the shorter suffix when one is a prefix | The longer suffix is lexicographically greater. | Did one suffix finish while the other still has digits? |
| Replacing `best` whenever candidate differs | A different candidate may be smaller. | At the first differing position, which digit is larger? |
| Stopping candidate comparison on equality | Equal digits do not decide the winner. | Should I continue to the next position? |

## Complexity

- `maxNumberHelper`: `O(n)` for one source array because each digit is pushed once and popped at most once.
- `merge`: the suffix comparison can look ahead repeatedly, so a straightforward worst-case bound is `O(k²)` per split.
- The split loop tries every valid allocation. The total cost depends on the number of valid splits and the lengths of the arrays.

For this revision, prioritize correctness and suffix intuition before optimizing the merge comparison.

## Recall checklist

### Split
- [ ] Explain why `take1 + take2 = k`.
- [ ] Derive `start = max(0, k - nums2.length)` in words.
- [ ] Derive `end = min(k, nums1.length)` in words.
- [ ] Explain why `take1` is a count, not an index.
- [ ] Explain why the loop includes `end`.

### Maximum subsequence
- [ ] Explain why the helper pops when `TOP < CURRENT`.
- [ ] Explain what `remove = nums.length - len` means.
- [ ] Explain why leftover removals happen at the end.
- [ ] Explain why `removeLast()` restores the original order for this deque layout.

### Merge
- [ ] Explain why current equal digits require looking ahead.
- [ ] Explain the separate roles of `i/j` and `p/q`.
- [ ] Explain why moving `p/q` does not consume a digit.
- [ ] Explain why the longer suffix wins when one suffix is a prefix.
- [ ] Explain what happens when both suffixes are identical.
- [ ] Explain why the selected digit is read from `sub1[i]` or `sub2[j]`, not from `p` or `q`.
- [ ] Explain why one actual pointer must advance on every merge iteration.

### Candidate comparison
- [ ] Explain why the first differing digit decides.
- [ ] Explain why equality means continue.
- [ ] Explain why a smaller candidate must not replace `best`.
- [ ] Dry-run all five splits of the worked example.

---

# Quick revision

## Compare the greedy decisions

| Problem | Goal | When does current beat top? | Safety constraint |
|---|---|---|---|
| Remove K Digits (402) | Smallest number | `TOP > CURRENT` | `k > 0` deletion budget |
| Maximum subsequence helper (inside 321) | Largest subsequence | `TOP < CURRENT` | `remove > 0` deletion budget |

## Key decisions

```text
REMOVE K DIGITS
Smaller current digit can improve the earlier position.
Pop a larger TOP while deletion budget remains.

CREATE MAXIMUM NUMBER
Try every valid split.
Build the best subsequence from each array.
Compare remaining suffixes to decide which array supplies the next digit.
Compare complete candidates and keep the largest.
```

## Five revision questions

1. **What am I building?** A smallest number, a maximum subsequence, or a maximum merged number?
2. **What does the stack represent?** The digits currently kept in original order?
3. **Why is the top worse?** Is the current digit smaller or larger, depending on the goal?
4. **Can I safely remove it?** Do I still have a deletion budget and enough digits?
5. **What comparison am I doing?** Current digit, remaining suffix, or complete candidate?

**Revision rule:** When stuck, stop looking at the syntax. State the decision in plain English first. Then identify which variable represents that decision.
