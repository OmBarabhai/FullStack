# Pattern 4 — Monotonic Stack
# Part 2: Advanced Applications

> **Purpose:** Revise advanced applications built on the monotonic-stack foundations from Part 1.

## Revision navigation

| # | Problem | Main idea |
|---:|---|---|
| Bridge | [Next Greater Element I](https://leetcode.com/problems/next-greater-element-i/) | Build next-greater answers for nums2, then retrieve requested values with a HashMap. |
| 1 | [Next Greater Element II](https://leetcode.com/problems/next-greater-element-ii/) | Circular array; reuse NGE with wraparound. |
| 2 | [Daily Temperatures](https://leetcode.com/problems/daily-temperatures/) | Next-greater index and distance between days. |
| 3 | [Trapping Rain Water](https://leetcode.com/problems/trapping-rain-water/) | Find bounded basins and accumulate trapped water. |
| 4 | [Sum of Subarray Minimums](https://leetcode.com/problems/sum-of-subarray-minimums/) | Count each value's contribution using smaller boundaries. |
| 5 | [Sum of Subarray Ranges](https://leetcode.com/problems/sum-of-subarray-ranges/) | Count contributions as both minima and maxima. |
| 6 | [132 Pattern](https://leetcode.com/problems/132-pattern/) | Reverse traversal and candidate tracking. |
| 7 | [Maximum Width Ramp](https://leetcode.com/problems/maximum-width-ramp/) | Preserve useful candidate indices, then scan again. |
| 8 | [Sliding Window Maximum](https://leetcode.com/problems/sliding-window-maximum/) | Maintain a monotonic deque and remove expired indices. |

---

## Starting point from Part 1

The following foundations are already covered and should **not** be assigned again as new problems:

- Next Smaller Element (NSE)
- Next Greater Element (NGE)
- Previous Smaller Element (PSE)
- Previous Greater Element (PGE)
- Stock Span
- Largest Rectangle in Histogram
- Maximal Rectangle (matrix-to-histogram application)

Part 2 assumes that you can use an index-based monotonic stack, explain the pop condition, and distinguish element values from indices.

---

# Bridge Problem — [Next Greater Element I](https://leetcode.com/problems/next-greater-element-i/) (Two Arrays + HashMap)

This problem combines the core NGE pattern with a HashMap lookup.

## What the problem asks

`nums2` is the full array where the next greater element is found. `nums1` contains values taken from `nums2`. Return each requested value's next-greater answer in the same order as `nums1`.

```text
nums1 = [4, 1, 2]
nums2 = [1, 3, 4, 2]
Output = [-1, 3, -1]
```

The arrays have different jobs:

- `nums2`: calculate next-greater answers for its values.
- `nums1`: tells us which values' answers we need to return.
- `keyValOfNum2`: stores `value -> next greater value`.
- `ansNgeForNum1inNum2`: stores the requested results in `nums1` order.

## Java code

```java
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Deque<Integer> ngeStNum2 = new ArrayDeque<>();
        HashMap<Integer, Integer> keyValOfNum2 = new HashMap<>();
        int n = nums2.length;

        for (int idx = n - 1; idx >= 0; idx--) {
            while (!ngeStNum2.isEmpty()
                    && nums2[ngeStNum2.peek()] <= nums2[idx]) {
                ngeStNum2.pop();
            }

            if (ngeStNum2.isEmpty()) {
                keyValOfNum2.put(nums2[idx], -1);
            } else {
                keyValOfNum2.put(
                    nums2[idx],
                    nums2[ngeStNum2.peek()]
                );
            }

            ngeStNum2.push(idx);
        }

        int[] ansNgeForNum1inNum2 = new int[nums1.length];

        for (int ansIdx = 0; ansIdx < nums1.length; ansIdx++) {
            ansNgeForNum1inNum2[ansIdx] =
                keyValOfNum2.get(nums1[ansIdx]);
        }

        return ansNgeForNum1inNum2;
    }
}
```

## First loop: build the map from `nums2`

The stack stores **indices**, while the map uses **array values as keys**.

- `ngeStNum2.peek()` returns an index.
- `nums2[ngeStNum2.peek()]` returns the value at that index.
- `keyValOfNum2.put(nums2[idx], answer)` records that the current value's next-greater value is `answer`.

The pop condition is:

```java
nums2[ngeStNum2.peek()] <= nums2[idx]
```

Pop candidates whose values are smaller than or equal to the current value, because we need a **strictly greater** answer.

### Dry run of map construction

```text
nums2  = [1, 3, 4, 2]
indices  0  1  2  3
```

Stack is displayed **top → bottom** as `index(value)`.

| Current index/value | What happens | Map entry | Stack after push |
|---|---|---|---|
| `3 / 2` | Stack empty; no greater value to the right | `2 → -1` | `[3(2)]` |
| `2 / 4` | Pop index 3 because `4 >= 2`; stack becomes empty | `4 → -1` | `[2(4)]` |
| `1 / 3` | Top has value 4, which is greater | `3 → 4` | `[1(3), 2(4)]` |
| `0 / 1` | Top has value 3, which is greater | `1 → 3` | `[0(1), 1(3), 2(4)]` |

The completed map is:

| Key | Value retrieved by this key |
|---:|---:|
| `1` | `3` |
| `3` | `4` |
| `4` | `-1` |
| `2` | `-1` |

For example, `1 → 3` means: *the next greater value for element value `1` is `3`*. Here `1` is a **value used as the map key**, not an array index.

## Second loop: use `nums1` as a list of queries

```java
ansNgeForNum1inNum2[ansIdx] =
    keyValOfNum2.get(nums1[ansIdx]);
```

There are three different roles here:

- `nums1[ansIdx]` is the **key** looked up in the map.
- `keyValOfNum2.get(nums1[ansIdx])` is the **answer value retrieved** from the map.
- `ansNgeForNum1inNum2[ansIdx]` is the **output position** where that answer is stored.

| `ansIdx` | Key: `nums1[ansIdx]` | Lookup | Retrieved answer | Stored at |
|---:|---:|---|---:|---|
| 0 | 4 | `keyValOfNum2.get(4)` | -1 | `ans[0]` |
| 1 | 1 | `keyValOfNum2.get(1)` | 3 | `ans[1]` |
| 2 | 2 | `keyValOfNum2.get(2)` | -1 | `ans[2]` |

Final output: `[-1, 3, -1]`.

**Why not calculate again in `nums1`?** The first loop calculates the answer for every value in `nums2` once. The map stores those answers. The second loop only retrieves the ones requested by `nums1`.

### Revision checkpoints

- [ ] Explain why the stack processes `nums2`, not `nums1`.
- [ ] Explain why the stack stores indices but the map key is a value.
- [ ] Distinguish `ngeStNum2.peek()` from `nums2[ngeStNum2.peek()]`.
- [ ] Identify the map key, retrieved answer, and result-array index in the second loop.
- [ ] Dry-run the two loops and produce `[-1, 3, -1]`.

**Complexity:** Expected `O(nums1.length + nums2.length)` time and `O(nums2.length)` auxiliary space. The standard problem uses distinct values in `nums2`, so a value can serve as a unique map key.

---

# Problem 1 — [Next Greater Element II](https://leetcode.com/problems/next-greater-element-ii/) (Circular Array)

## What the problem asks

For each element, find the first **strictly greater value** to its right, continuing from the start after reaching the end. Return `-1` if there is no greater element.

```text
nums   = [1, 2, 3, 4, 3]
Output = [2, 3, 4, -1, 4]
```

Unlike ordinary NGE, the search wraps around the circular array. A value cannot be its own next greater element, and equal values do not count as greater.

## Java code

The algorithm preloads indices in reverse order, then scans the array from right to left.

```java
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Deque<Integer> ngeIdxCir = new ArrayDeque<>();
        int n = nums.length;

        // Preload indices: index 0 ends up at the top.
        for (int idx = n - 1; idx >= 0; idx--) {
            ngeIdxCir.push(idx);
        }

        int[] ansOfCirNge = new int[n];

        for (int idx = n - 1; idx >= 0; idx--) {
            while (!ngeIdxCir.isEmpty()
                    && nums[ngeIdxCir.peek()] <= nums[idx]) {
                ngeIdxCir.pop();
            }

            if (ngeIdxCir.isEmpty()) {
                ansOfCirNge[idx] = -1;
            } else {
                ansOfCirNge[idx] = nums[ngeIdxCir.peek()];
            }

            ngeIdxCir.push(idx);
        }

        return ansOfCirNge;
    }
}
```

## Understand the two phases

### Phase 1: preload candidates

```java
for (int idx = n - 1; idx >= 0; idx--) {
    ngeIdxCir.push(idx);
}
```

For `nums = [1, 2, 3, 4, 3]`, the indices are pushed in order `4, 3, 2, 1, 0`. A stack is last-in, first-out, so after preloading:

```text
Stack top → bottom (index(value)):
0(1), 1(2), 2(3), 3(4), 4(3)
```

Index `0` is at the top, ready to act as a wraparound candidate when processing the last index. The stack stores **indices** throughout, not values.

### Phase 2: process each original index

```java
while (!ngeIdxCir.isEmpty()
        && nums[ngeIdxCir.peek()] <= nums[idx]) {
    ngeIdxCir.pop();
}
```

- `ngeIdxCir.peek()` gives an index.
- `nums[ngeIdxCir.peek()]` gives the value at that index.
- Pop candidates whose values are less than or equal to the current value.
- If the stack becomes empty, write `-1`.
- Otherwise, write the value at the top index.
- Push the current index so that it can be a candidate for earlier indices.

### Full dry run for `[1, 2, 3, 4, 3]`

Preloaded stack, **top → bottom**:

```text
0(1), 1(2), 2(3), 3(4), 4(3)
```

| Current index/value | Candidate check | Answer | What this demonstrates |
|---:|---|---:|---|
| `4 / 3` | Pop values `1`, `2`, and `3`. The next candidate is index 3 with value `4`, which is greater. | 4 | Wraparound candidates help find 4 for the last element. |
| `3 / 4` | Pop value `3`, then equal value `4`, then the remaining value `3`. The stack empties. | -1 | Equal is not strictly greater. |
| `2 / 3` | The remaining top candidate has value `4`. | 4 | Next greater value is 4. |
| `1 / 2` | The top candidate has value `3`. | 3 | Next greater value is 3. |
| `0 / 1` | The top candidate has value `2`. | 2 | Next greater value is 2. |

Answers are written to `ansOfCirNge[idx]`, not appended. So the final result is in original array order:

```text
[2, 3, 4, -1, 4]
```

### Edge cases

| Input | Expected output | Reason |
|---|---|---|
| `[5, 5, 5]` | `[-1, -1, -1]` | Equal values are not greater. |
| `[7]` | `[-1]` | The element cannot be its own answer. |
| `[1, 2, 3, 4]` | `[2, 3, 4, -1]` | The last, largest value has no greater candidate. |
| `[4, 3, 2, 1]` | `[-1, 4, 4, 4]` | Smaller values find 4 after wrapping around. |
| `[]` | `[]` | Both loops run zero times. |

### Revision checkpoints

- [ ] Explain why preloading from `n - 1` down to `0` leaves index `0` at the top.
- [ ] Explain how the preloaded stack provides wraparound candidates.
- [ ] Explain why the stack holds indices and why the answer line uses `nums[ngeIdxCir.peek()]`.
- [ ] Explain why the condition uses `nums[ngeIdxCir.peek()] <= nums[idx]`.
- [ ] Dry-run each pop for `[1, 2, 3, 4, 3]`.
- [ ] Explain why equal values are popped.
- [ ] Test all-equal, single-element, increasing, decreasing, and empty input.

**Complexity:** `O(n)` time and `O(n)` space.

## How the two problems differ

| Feature | Next Greater Element I | Next Greater Element II |
|---|---|---|
| Input | `nums1` and `nums2` | One circular array |
| New idea | HashMap lookup | Wraparound candidates |
| Stack stores | Indices in `nums2` | Indices in `nums` |
| Output | Only answers requested by `nums1` | One answer for every index |
| Missing answer | `-1` | `-1` |

# Problem 2 — [Daily Temperatures](https://leetcode.com/problems/daily-temperatures/)

## What the problem asks

For each day's temperature, find how many days you must wait until a **strictly warmer** temperature occurs. If no warmer day exists in the future, return `0`.

Example:

```text
temperatures = [73, 74, 75, 71, 69, 72, 76, 73]
answer       = [ 1,  1,  4,  2,  1,  1,  0,  0]
```

The answer is not the warmer temperature and not its index. It is the **distance in days** between the current index and the next warmer day's index.

## Java code

```java
import java.util.*;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Deque<Integer> warmerDayIndices = new ArrayDeque<>();
        int[] daysToWait = new int[n];

        for (int currentDay = n - 1; currentDay >= 0; currentDay--) {
            while (!warmerDayIndices.isEmpty()
                    && temperatures[warmerDayIndices.peek()]
                       <= temperatures[currentDay]) {
                warmerDayIndices.pop();
            }

            if (warmerDayIndices.isEmpty()) {
                daysToWait[currentDay] = 0;
            } else {
                int nextWarmerDay = warmerDayIndices.peek();
                daysToWait[currentDay] = nextWarmerDay - currentDay;
            }

            warmerDayIndices.push(currentDay);
        }

        return daysToWait;
    }
}
```

### Variable meaning

| Variable | Meaning |
|---|---|
| `currentDay` | Index of the day currently being processed |
| `warmerDayIndices` | Stack of candidate day indices, not temperatures |
| `warmerDayIndices.peek()` | Index of the next warmer candidate |
| `temperatures[warmerDayIndices.peek()]` | Temperature at that candidate index |
| `nextWarmerDay - currentDay` | Number of days to wait |
| `daysToWait[currentDay]` | Answer stored for the current day |

## Intuition

Process days from **right to left**, because the answer for a day depends on future days.

At each day:

1. Check the stack's top candidate.
2. Pop it if its temperature is **less than or equal to** today's temperature. Such a day cannot be the next strictly warmer day for the current day.
3. If the stack becomes empty, there is no warmer future day, so store `0`.
4. Otherwise, the top index is the next warmer day. Subtract the current index to get the waiting time.
5. Push today's index for days further to the left to consider.

### Why store indices instead of temperatures?

The answer requires a **number of days**, so we need positions.

For example, if the current day is index `2` and the next warmer day is index `6`:

```text
wait = 6 - 2 = 4 days
```

If the stack stored only temperatures, we could learn that a warmer temperature exists but would lose the position needed to calculate the number of days.

### Why pop when temperatures are equal?

The problem asks for a **strictly warmer** day. If today's temperature is `75`, a future day with temperature `75` is not a valid answer. Therefore, the condition uses `>=`:

```java
temperatures[warmerDayIndices.peek()] <= temperatures[currentDay]
```

It pops candidates whose temperature is colder than or equal to the current day's temperature.

## Step-by-step dry run

Input:

```text
temperatures = [73, 74, 75, 71, 69, 72, 76, 73]
index          0   1   2   3   4   5   6   7
```

We traverse from index `7` down to index `0`. Stack is shown **top → bottom**, as `index(temperature)`.

| Day index | Temperature | Stack action | Answer calculation | Stack after push |
|---:|---:|---|---|---|
| 7 | 73 | Stack empty | No warmer day → `0` | `[7(73)]` |
| 6 | 76 | Pop `7(73)` because `73 <= 76` | Stack empty → `0` | `[6(76)]` |
| 5 | 72 | `6(76)` is warmer; keep it | `6 - 5 = 1` | `[5(72), 6(76)]` |
| 4 | 69 | `5(72)` is warmer; keep it | `5 - 4 = 1` | `[4(69), 5(72), 6(76)]` |
| 3 | 71 | Pop `4(69)`; `5(72)` is warmer | `5 - 3 = 2` | `[3(71), 5(72), 6(76)]` |
| 2 | 75 | Pop `3(71)` and `5(72)`; `6(76)` is warmer | `6 - 2 = 4` | `[2(75), 6(76)]` |
| 1 | 74 | `2(75)` is warmer; keep it | `2 - 1 = 1` | `[1(74), 2(75), 6(76)]` |
| 0 | 73 | `1(74)` is warmer; keep it | `1 - 0 = 1` | `[0(73), 1(74), 2(75), 6(76)]` |

Although the computation happens right to left, the answers are written to `daysToWait[currentDay]`, so the final array stays in original order:

```text
[1, 1, 4, 2, 1, 1, 0, 0]
```

## Edge cases

| Input | Expected output | Reason |
|---|---|---|
| `[80]` | `[0]` | There is no future day. |
| `[90, 80, 70]` | `[0, 0, 0]` | Temperatures keep decreasing; no warmer future day exists. |
| `[70, 71, 72]` | `[1, 1, 0]` | Each day waits one day, except the last. |
| `[70, 70, 71]` | `[2, 1, 0]` | Equal `70` is not warmer; both wait for `71`. |
| `[75, 74, 75]` | `[2, 1, 0]` | The first `75` waits until index 2; equal is not strictly warmer. |
| `[]` | `[]` | The loop runs zero times. |

## Complexity

- **Time:** `O(n)`. Each day index is pushed once and popped at most once.
- **Auxiliary space:** `O(n)` for the stack and answer array.

## Revision checkpoints

- [ ] Explain why the scan goes right to left.
- [ ] Explain why the stack stores indices rather than temperatures.
- [ ] Explain why candidates with temperatures `<= current temperature` are popped.
- [ ] Distinguish the next warmer day's **index**, temperature, and waiting distance.
- [ ] Explain why an empty stack gives `0`, not `-1`.
- [ ] Dry-run the example without looking at the table.
- [ ] Explain the equal-temperature case `[70, 70, 71]`.

---

# Problem 3 — [Trapping Rain Water](https://leetcode.com/problems/trapping-rain-water/)

## 1. What the problem asks

Each array value is the height of a bar. Calculate the total amount of rainwater that can remain between the bars.

```text
height = [4, 2, 0, 3, 2, 5]
answer = 9
```

There are several valid ways to solve this. The important thing is to understand the shared water formula first, then understand how each approach finds the information needed by that formula.

---

## 2. Four approaches

Do not place all four versions as commented code inside one submission. Keep one chosen implementation active when submitting. The sections below are separate reference implementations for learning and comparison.

### Approach A — Brute force

For each position:
1. Scan from the beginning through the current position to find the tallest left bar.
2. Scan from the current position through the end to find the tallest right bar.
3. The water level is the shorter of those two maximums.
4. Subtract the current bar's height and add that water to the total.

#### Clean version with descriptive variable names

```java
public class Solution {
    public static long getTrappedWater(long[] height, int n) {
        long totalTrappedWater = 0;

        for (int currentIndex = 0; currentIndex < n; currentIndex++) {
            long leftMaxHeight = 0;
            long rightMaxHeight = 0;

            for (int leftIndex = 0; leftIndex <= currentIndex; leftIndex++) {
                leftMaxHeight = Math.max(leftMaxHeight, height[leftIndex]);
            }

            for (int rightIndex = currentIndex; rightIndex < n; rightIndex++) {
                rightMaxHeight = Math.max(rightMaxHeight, height[rightIndex]);
            }

            long waterLevel = Math.min(leftMaxHeight, rightMaxHeight);
            long waterAtCurrentIndex = waterLevel - height[currentIndex];

            totalTrappedWater += waterAtCurrentIndex;
        }

        return totalTrappedWater;
    }
}
```

**Formula for one position:**

```text
waterLevel = min(leftMaxHeight, rightMaxHeight)
waterAtCurrentIndex = waterLevel - height[currentIndex]
totalTrappedWater += waterAtCurrentIndex
```

**Why subtract the current height?** The water level measures how high water could reach, including the space already occupied by the bar. The bar itself is not water, so its height must be subtracted.

For example, at index `2` in `[4, 2, 0, 3, 2, 5]`:

```text
leftMaxHeight = 4
rightMaxHeight = 5
waterLevel = min(4, 5) = 4
current bar height = 0
water at index 2 = 4 - 0 = 4
```

Complexity: `O(n²)` time and `O(1)` auxiliary space.

### Approach B — Prefix and suffix maximum arrays

Avoid re-scanning the sides for every position by precomputing the maximum to the left and right.

```java
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if (n == 0) return 0;

        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int totalWater = 0;
        for (int i = 0; i < n; i++) {
            int waterLevel = Math.min(leftMax[i], rightMax[i]);
            totalWater += waterLevel - height[i];
        }

        return totalWater;
    }
}
```

Complexity: `O(n)` time and `O(n)` auxiliary space.

### Approach C — Two pointers

Keep a left pointer, a right pointer, and the maximum height seen from each side. This avoids the two maximum arrays.

```java
class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int totalWater = 0;

        while (left < right) {
            if (height[left] <= height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    totalWater += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    totalWater += rightMax - height[right];
                }
                right--;
            }
        }

        return totalWater;
    }
}
```

Complexity: `O(n)` time and `O(1)` auxiliary space.

### Approach D — Monotonic stack

This approach calculates water when a taller bar on the right closes a basin. The stack stores **indices** in an order where the candidate heights are decreasing from bottom to top.

```java
import java.util.*;

class Solution {
    public int trap(int[] height) {
        Deque<Integer> basinStack = new ArrayDeque<>();
        int totalWaterTrapped = 0;
        int n = height.length;

        for (int current = 0; current < n; current++) {
            while (!basinStack.isEmpty()
                    && height[current] > height[basinStack.peek()]) {

                int bottomIndex = basinStack.pop();

                if (basinStack.isEmpty()) {
                    break; // The popped bottom has no left boundary.
                }

                int leftBoundary = basinStack.peek();
                int width = current - leftBoundary - 1;

                int boundedHeight =
                    Math.min(height[current], height[leftBoundary])
                    - height[bottomIndex];

                totalWaterTrapped += width * boundedHeight;
            }

            basinStack.push(current);
        }

        return totalWaterTrapped;
    }
}
```

The stack stores bar indices. After processing any basins closed by the current bar, push the current index so it can serve as a boundary for later bars.

Complexity: `O(n)` time and `O(n)` auxiliary space. Each index is pushed once and popped at most once.

---

## 3. The stack formula — what every variable means

When the current bar is taller than the stack's top bar, this loop begins:

```java
while (!basinStack.isEmpty()
        && height[current] > height[basinStack.peek()])
```

The popped index is a potential **basin bottom**:

```java
int bottomIndex = basinStack.pop();
```

After popping:

- `current` is the **right boundary**.
- If the stack is not empty, `basinStack.peek()` is the **left boundary**.
- `bottomIndex` is the **bottom between them**.

The next three calculations are:

```java
int leftBoundary = basinStack.peek();
int width = current - leftBoundary - 1;

int boundedHeight =
    Math.min(height[current], height[leftBoundary])
    - height[bottomIndex];

totalWaterTrapped += width * boundedHeight;
```

### Why is width `current - leftBoundary - 1`?

The two boundary bars are walls. The width counts only the positions **strictly between** them.

For `[3, 0, 2]`:

```text
index:   0       1       2
height: [3]     [0]     [2]
         LEFT   BOTTOM  CURRENT/RIGHT
```

Here `leftBoundary = 0` and `current = 2`.

```text
width = 2 - 0 - 1
      = 1
```

Only index `1` is between the walls. The `-1` removes the boundary position from the distance, so the width counts interior bars, not the walls themselves.

### Why is bounded height `min(left height, right height) - bottom height`?

The shorter wall controls the water level. Water spills over that wall if it rises any higher.

For `[3, 0, 2]`:

```text
left wall height  = 3
right wall height = 2
bottom height     = 0

water level = min(3, 2) = 2
bounded height = 2 - 0 = 2
```

Water added:

```text
width × bounded height = 1 × 2 = 2
```

### What if the stack becomes empty after popping?

```java
if (basinStack.isEmpty()) {
    break;
}
```

There is no remaining bar on the left to serve as a wall. Without both boundaries, that popped bottom cannot hold a basin, so skip that calculation. The current index is still pushed after the `while` loop.

---

## 4. Easy stack dry run: `[3, 0, 2]`

Stack is shown **bottom → top**, as `index(height)`.

| Current index/height | Action | Water added | Stack after processing |
|---|---|---:|---|
| `0 / 3` | Stack empty; push index 0 | 0 | `[0(3)]` |
| `1 / 0` | `0` is not taller than `3`; push index 1 | 0 | `[0(3), 1(0)]` |
| `2 / 2` | `2 > 0`, so pop index 1 (the bottom). New top is index 0. | See calculation below | `[0(3), 2(2)]` |

For the pop at index `2`:

```text
bottomIndex = 1, height = 0
leftBoundary = 0, height = 3
current = 2, height = 2

width = 2 - 0 - 1 = 1
boundedHeight = min(2, 3) - 0 = 2
water added = 1 × 2 = 2
```

Final answer: `2`.

---

## 5. Full stack dry run: `[4, 2, 0, 3, 2, 5]`

Stack is shown **bottom → top** as `index(height)`. Every row describes a pop calculation; an iteration can pop more than one bottom.

| Current index/height | Popped bottom | Left boundary | Width | Bounded height | Water added | Running total |
|---|---|---|---:|---:|---:|---:|
| `0 / 4` | — | — | — | — | 0 | 0 |
| `1 / 2` | — | — | — | — | 0 | 0 |
| `2 / 0` | — | — | — | — | 0 | 0 |
| `3 / 3` | index 2, height 0 | index 1, height 2 | `3-1-1 = 1` | `min(3,2)-0 = 2` | 2 | 2 |
| `3 / 3` | index 1, height 2 | index 0, height 4 | `3-0-1 = 2` | `min(3,4)-2 = 1` | 2 | 4 |
| `4 / 2` | — | — | — | — | 0 | 4 |
| `5 / 5` | index 4, height 2 | index 3, height 3 | `5-3-1 = 1` | `min(5,3)-2 = 1` | 1 | 5 |
| `5 / 5` | index 3, height 3 | index 0, height 4 | `5-0-1 = 4` | `min(5,4)-3 = 1` | 4 | 9 |
| `5 / 5` | index 0, height 4 | None: stack becomes empty | — | — | 0 | 9 |

At index `3`, the bar of height `3` closes two layers, adding `2 + 2 = 4`.

At index `5`, the bar of height `5` closes two more layers, adding `1 + 4 = 5`. Then index `0` is popped, but no left boundary remains, so no water is counted for that pop.

Final answer: **`9`**.

### Running total by position

```text
After index 0: 0
After index 1: 0
After index 2: 0
After index 3: 4
After index 4: 4
After index 5: 9
```

Water is not necessarily added when visiting a low bar. It is added when a right boundary arrives and closes a basin.

---

## 6. Edge cases for revision

| Input | Expected water | What it teaches |
|---|---:|---|
| `[3, 0, 2]` | 2 | Smallest easy basin |
| `[4, 2, 0, 3, 2, 5]` | 9 | Multiple pops and layers |
| `[3, 0, 2, 0, 4]` | 7 | Multiple low points in a wide basin |
| `[1, 2, 3, 4]` | 0 | Increasing bars; no basin |
| `[4, 3, 2, 1]` | 0 | Decreasing bars; no basin |
| `[3, 3, 3]` | 0 | Equal heights |
| `[5]` | 0 | One bar |
| `[]` | 0 | Empty input |

---

## 7. Compare the four approaches

| Approach | Time | Auxiliary space | Main trade-off |
|---|---:|---:|---|
| Brute force | `O(n²)` | `O(1)` | Easy concept, repeats scans |
| Prefix/suffix maxima | `O(n)` | `O(n)` | Very direct formula, stores two arrays |
| Two pointers | `O(n)` | `O(1)` | Best practical space efficiency |
| Monotonic stack | `O(n)` | `O(n)` | Practices basin/boundary reasoning |

For solving the problem in an interview, the two-pointer approach is often the most space-efficient. For Pattern 4 revision, make sure you understand the stack's three roles: popped bottom, new left boundary, and current right boundary.
