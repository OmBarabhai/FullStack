# Pattern 4 — Monotonic Stack
## Part 1: Core Patterns, Stock Span & Rectangle Applications

| # | Problem (open practice page) | Main focus |
|---:|---|---|
| 1 | [Next Smaller Element (NSE)](https://www.naukri.com/code360/problems/next-smaller-element_1112581) | Right-to-left scan; pop `>=`; nearest strictly smaller value |
| 2 | [Next Greater Element (NGE)](https://www.naukri.com/code360/problems/next-greater-element_799354) | Right-to-left scan; pop `<=`; nearest strictly greater value |
| 3 | [Previous Smaller Element (PSE)](https://www.geeksforgeeks.org/problems/previous-smaller-element/1) | Left-to-right scan; pop `>=`; nearest strictly smaller value |
| 4 | [Previous Greater Element (PGE)](https://www.geeksforgeeks.org/problems/previous-greater-element/1) | Left-to-right scan; pop `<=`; nearest strictly greater value |
| 5 | [Online Stock Span — `StockSpanner.next()`](https://leetcode.com/problems/online-stock-span/) | Store `(price, span)`; absorb equal prices with `<=` |
| 6 | [Array-based Stock Span — `findStockSpans(int[] prices)`](https://www.naukri.com/code360/problems/stock-span_5243295) | Store `(price, span)`; equal prices remain as blockers with `<` |
| 7 | [Largest Rectangle in Histogram](https://leetcode.com/problems/largest-rectangle-in-histogram/) | Reuse PSE/NSE boundary indices; calculate width and area |
| 8 | [Maximal Rectangle](https://leetcode.com/problems/maximal-rectangle/) | Convert each matrix row into histogram heights; reuse Largest Rectangle in Histogram |

---

## 1. The intuition: a stack is a shortlist of useful candidates

A monotonic stack keeps its candidates in a particular order: increasing or decreasing. In these problems, each element asks a question about a neighbour on its left or right.

Think of the stack as a **shortlist of candidates that may still answer that question**.

For each current element:

1. Look at the stack top.
2. Ask whether the top can still be a valid answer for the current element.
3. If it cannot, pop it. Check the new top because it may also be invalid.
4. When popping stops, the top (if one exists) is the nearest valid candidate in the required direction.
5. Record the answer, then push the current index so it can become a candidate for another element.

**Why can we pop permanently?** Because the current element is at least as good a candidate for the future question we are processing: it is closer, and it has the required smaller/greater relationship. The popped candidate will not become useful again for the remaining elements in this scan.

The main decisions are only:

```text
WHICH direction should I scan?
WHAT relationship do I need: smaller or greater?
WHICH top values fail that relationship?
```

### The four-pattern map

| Problem | Where is the answer? | Scan direction | Required answer | Pop when top value is... |
|---|---|---|---|---|
| Next Smaller (NSE) | Right | Right → left | Strictly smaller | `>= current` |
| Next Greater (NGE) | Right | Right → left | Strictly greater | `<= current` |
| Previous Smaller (PSE) | Left | Left → right | Strictly smaller | `>= current` |
| Previous Greater (PGE) | Left | Left → right | Strictly greater | `<= current` |

**Memory rule**

```text
NEXT     → scan RIGHT to LEFT
PREVIOUS → scan LEFT to RIGHT

SMALLER  → pop >= current
GREATER  → pop <= current
```

“Strictly” matters. An equal value is not a strictly smaller or strictly greater answer, so equality is included in the pop condition.

---

## 2. One important distinction: index versus value

In the four implementations below, the stack stores **indices**, not values.

```text
st.push(i)       → store the current index
st.peek()        → get the index at the top
arr[st.peek()]   → get the value at that index
```

For example:

```java
int[] arr = {1, 5, 0, 3};
```

If the stack top is index `2`, then `st.peek()` is `2`. The value at that position is `arr[2]`, which is `0`.

```java
st.peek()       // 2: the index
arr[st.peek()]  // 0: the element's value
```

So always check the problem's output requirement:

- Asked for a **value**? Return `arr[st.peek()]`.
- Asked for an **index** or a distance? Keep/use `st.peek()`.

This is why the same stack pattern can solve several problems while the answer line changes.

---

## 3. The four core neighbour problems

All four follow the same overall flow:

```text
Choose scan direction
        ↓
Look at current element
        ↓
Pop every top that cannot be the required neighbour
        ↓
Top exists? → record its value / index
Top absent? → record -1 (for these four value-output problems)
        ↓
Push current index
```

### 3.1 [Next Smaller Element (NSE)](https://www.naukri.com/code360/problems/next-smaller-element_1112581)

**Question:** For each element, find the first strictly smaller element to its right.

We scan right to left because the right side must already be processed. While the top value is greater than or equal to the current value, it cannot be the strictly smaller answer, so pop it. The remaining top, if present, is the nearest smaller value to the right.

**Java code:**

```java
import java.util.*;

class Solution {
    static ArrayList<Integer> nextSmallerEle(int[] arr) {
        int n = arr.length;
        Deque<Integer> st = new ArrayDeque<>();
        ArrayList<Integer> ans = new ArrayList<>(Collections.nCopies(n, -1));

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop(); // Remove values that cannot be the next smaller element.
            }

            if (!st.isEmpty()) {
                ans.set(i, arr[st.peek()]);
            }

            st.push(i); // Keep this index as a candidate for elements on its left.
        }
        return ans;
    }
}
```

**Read the key condition in English:**

```text
arr[st.peek()] >= arr[i]
```

“The candidate at the top is not smaller than the current value. Remove it and check the next candidate.”

#### Dry run: `arr = [4, 8, 5, 2]`

We scan indices `3 → 0`. The stack is shown **bottom → top** as `index(value)`.

| Current `i / arr[i]` | Stack before | Pop decision | Answer | Stack after pushing current index |
|---|---|---|---:|---|
| `3 / 2` | `[]` | No candidate | `-1` | `[3(2)]` |
| `2 / 5` | `[3(2)]` | `2 < 5`, so keep it | `2` | `[3(2), 2(5)]` |
| `1 / 8` | `[3(2), 2(5)]` | `5 < 8`, so keep it | `5` | `[3(2), 2(5), 1(8)]` |
| `0 / 4` | `[3(2), 2(5), 1(8)]` | Pop `1(8)` and `2(5)`; keep `3(2)` | `2` | `[3(2), 0(4)]` |

Answer by original index order:

```text
[2, 5, 2, -1]
```

**What to notice:** At index `0`, we do not stop after popping `8`. We check the new top (`5`), pop that too, and stop only when `2` is found.

### 3.2 [Next Greater Element (NGE)](https://www.naukri.com/code360/problems/next-greater-element_799354)

**Question:** For each element, find the first strictly greater element to its right.

Again, scan right to left. This time, a top value less than or equal to the current value cannot be the answer, so pop it. The remaining top is strictly greater.

**Java code:**

```java
import java.util.*;

class Solution {
    public static int[] nextGreaterElement(int[] arr, int n) {
        Deque<Integer> st = new ArrayDeque<>();
        int[] ans = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop(); // Remove values that cannot be the next greater element.
            }

            if (st.isEmpty()) {
                ans[i] = -1; // No greater value exists on the right.
            } else {
                ans[i] = arr[st.peek()];
            }

            st.push(i); // Keep this index for elements on its left.
        }
        return ans;
    }
}
```

**Read the key condition in English:**

```text
arr[st.peek()] <= arr[i]
```

“The candidate at the top is not greater than the current value. Remove it.”

#### Dry run: `arr = [4, 5, 2, 10, 8]`

We scan indices `4 → 0`. Stack is **bottom → top**, shown as `index(value)`.

| Current `i / arr[i]` | Stack before | Pop decision | Answer | Stack after push |
|---|---|---|---:|---|
| `4 / 8` | `[]` | No candidate | `-1` | `[4(8)]` |
| `3 / 10` | `[4(8)]` | Pop `4(8)`; stack empty | `-1` | `[3(10)]` |
| `2 / 2` | `[3(10)]` | `10 > 2`, keep it | `10` | `[3(10), 2(2)]` |
| `1 / 5` | `[3(10), 2(2)]` | Pop `2(2)`; keep `3(10)` | `10` | `[3(10), 1(5)]` |
| `0 / 4` | `[3(10), 1(5)]` | `5 > 4`, keep it | `5` | `[3(10), 1(5), 0(4)]` |

Answer:

```text
[5, 10, 10, -1, -1]
```

### 3.3 [Previous Smaller Element (PSE)](https://www.geeksforgeeks.org/problems/previous-smaller-element/1)

**Question:** For each element, find the first strictly smaller element to its left.

We scan left to right because the left side has already been processed. Pop values greater than or equal to the current value. The remaining top is the nearest strictly smaller value on the left.

**Java code:**

```java
import java.util.*;

class Solution {
    public static ArrayList<Integer> prevSmaller(int[] arr) {
        int n = arr.length;
        Deque<Integer> st = new ArrayDeque<>();
        ArrayList<Integer> ans = new ArrayList<>(Collections.nCopies(n, -1));

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop(); // Remove values that cannot be the previous smaller element.
            }

            if (!st.isEmpty()) {
                ans.set(i, arr[st.peek()]);
            }

            st.push(i); // Keep this index for elements on its right.
        }
        return ans;
    }
}
```

#### Dry run: `arr = [1, 5, 0, 3, 4, 5]`

We scan indices `0 → 5`. Stack is **bottom → top**, shown as `index(value)`.

| Current `i / arr[i]` | Stack before | Pop decision | Answer | Stack after push |
|---|---|---|---:|---|
| `0 / 1` | `[]` | No candidate | `-1` | `[0(1)]` |
| `1 / 5` | `[0(1)]` | `1 < 5`, keep it | `1` | `[0(1), 1(5)]` |
| `2 / 0` | `[0(1), 1(5)]` | Pop `1(5)` and `0(1)` | `-1` | `[2(0)]` |
| `3 / 3` | `[2(0)]` | `0 < 3`, keep it | `0` | `[2(0), 3(3)]` |
| `4 / 4` | `[2(0), 3(3)]` | `3 < 4`, keep it | `3` | `[2(0), 3(3), 4(4)]` |
| `5 / 5` | `[2(0), 3(3), 4(4)]` | `4 < 5`, keep it | `4` | `[2(0), 3(3), 4(4), 5(5)]` |

Answer:

```text
[-1, 1, -1, 0, 3, 4]
```

### 3.4 [Previous Greater Element (PGE)](https://www.geeksforgeeks.org/problems/previous-greater-element/1)

**Question:** For each element, find the first strictly greater element to its left.

Scan left to right. Pop values less than or equal to the current value. The remaining top, if any, is the nearest strictly greater value to the left.

**Java code:**

```java
import java.util.*;

class Solution {
    public ArrayList<Integer> preGreaterEle(int[] arr) {
        Deque<Integer> st = new ArrayDeque<>();
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<Integer> ();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop(); // Remove values that cannot be the previous greater element.
            }
            if (st.isEmpty()) {
                ans.add(-1); // No greater value exists on the left.
            } else {
                ans.add(arr[st.peek()]);
            }
            st.push(i); // Keep this index for upcoming elements.
        }
        return ans;
    }
}
```

#### Dry run: `arr = [4, 5, 2, 10, 8]`

We scan indices `0 → 4`. Stack is **bottom → top**, shown as `index(value)`.

| Current `i / arr[i]` | Stack before | Pop decision | Answer | Stack after push |
|---|---|---|---:|---|
| `0 / 4` | `[]` | No candidate | `-1` | `[0(4)]` |
| `1 / 5` | `[0(4)]` | Pop `0(4)`; stack empty | `-1` | `[1(5)]` |
| `2 / 2` | `[1(5)]` | `5 > 2`, keep it | `5` | `[1(5), 2(2)]` |
| `3 / 10` | `[1(5), 2(2)]` | Pop `2(2)` and `1(5)` | `-1` | `[3(10)]` |
| `4 / 8` | `[3(10)]` | `10 > 8`, keep it | `10` | `[3(10), 4(8)]` |

Answer:

```text
[-1, -1, 5, -1, 10]
```

### Compare the four without memorizing four algorithms

| Problem | Direction | Pop condition | What the remaining top gives |
|---|---|---|---|
| NSE | Right → left | `arr[st.peek()] >= arr[i]` | Next smaller value |
| NGE | Right → left | `arr[st.peek()] <= arr[i]` | Next greater value |
| PSE | Left → right | `arr[st.peek()] >= arr[i]` | Previous smaller value |
| PGE | Left → right | `arr[st.peek()] <= arr[i]` | Previous greater value |

For these value-output versions, an empty stack means no qualifying neighbour, so the answer is `-1`.

### Quick edge-case check for all four

| Input | NSE | NGE | PSE | PGE | What it checks |
|---|---|---|---|---|---|
| `[2, 2, 2]` | `[-1,-1,-1]` | `[-1,-1,-1]` | `[-1,-1,-1]` | `[-1,-1,-1]` | Equal is not strictly smaller/greater |
| `[1, 2, 3]` | `[-1,-1,-1]` | `[2,3,-1]` | `[-1,1,2]` | `[-1,-1,-1]` | Increasing order |
| `[3, 2, 1]` | `[2,1,-1]` | `[-1,-1,-1]` | `[-1,-1,-1]` | `[-1,3,2]` | Decreasing order |
| `[2,2,3,1,2]` | `[1,1,1,-1,-1]` | `[3,3,-1,2,-1]` | `[-1,-1,2,-1,1]` | `[-1,-1,-1,3,3]` | Mixed values and duplicates |
| `[7]` | `[-1]` | `[-1]` | `[-1]` | `[-1]` | Single element |
| `[]` | `[]` | `[]` | `[]` | `[]` | Empty input, where permitted by the method/platform |

**Complexity:** `O(n)` time and `O(n)` auxiliary space for each solution. Even though there is a `while` loop inside the `for` loop, each index is pushed once and popped at most once. Total stack operations are linear.

---

## 4. [Stock Span — `StockSpanner.next()`](https://leetcode.com/problems/online-stock-span/)

### What is the question?

For today's price, count how many **consecutive days ending today** had prices less than or equal to today's price. Today always counts, so the span starts at `1`.

Example:

```text
Prices: [100, 80, 60, 70, 60, 75, 85]
Spans:  [  1,  1,  1,  2,  1,  4,  6]
```

### What does the stack store?

Each entry is a pair:

```java
new int[]{price, span}
//             [0]    [1]
```

```text
entry[0] = price
entry[1] = span already summarized by that price
```

The stack is kept in **strictly decreasing price order from bottom to top**. If today's price is greater than or equal to the top price, that top entry is absorbed into today's span and popped.

**Why add the stored span instead of adding 1?** A popped entry already represents a consecutive group of earlier days. Adding its span counts that whole group in one operation.

**Why does the stack persist between calls?** Each call is the next day in the same price stream. The next call needs the earlier days' candidates, so the stack is a field of the object, not a new local stack inside `next()`.

### Java code

```java
class StockSpanner {
    Deque<int[]> st;

    public StockSpanner() {
        st = new ArrayDeque<>();
    }

    public int next(int price) {
        int span = 1;
        while (!st.isEmpty() && st.peek()[0] <= price) { // new int[]{price, span};
            span = span + st.peek()[1]; // Add the whole span represented by this entry.
            st.pop();
        }
        st.push(new int[]{price, span});// new int[]{ currPrice, currSpan};
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
```

### Read the main loop in plain English

```java
int span = 1;
while (!st.isEmpty() && st.peek()[0] <= price) {
    span = span + st.peek()[1];
    st.pop();
}
st.push(new int[]{price, span});
return span;
```

1. Start with `span = 1` for today.
2. While the top price is `<=` today's price, add the top entry's saved span.
3. Pop that entry because today's price has absorbed those days.
4. Stop at the first strictly greater price. It blocks the span from extending farther.
5. Push today's `(price, span)` pair and return the span.

### Full dry run

Calls arrive in this order:

```text
next(100), next(80), next(60), next(70), next(60), next(75), next(85)
```

Stack is shown **bottom → top**. Each entry is `(price, span)`.

| Call | Popped entries | Span calculation | Return | Stack after call |
|---|---|---|---:|---|
| `next(100)` | None | `1` | `1` | `[(100,1)]` |
| `next(80)` | None; `100 > 80` blocks | `1` | `1` | `[(100,1),(80,1)]` |
| `next(60)` | None; `80 > 60` blocks | `1` | `1` | `[(100,1),(80,1),(60,1)]` |
| `next(70)` | `(60,1)` | `1 + 1 = 2`; `80 > 70` blocks | `2` | `[(100,1),(80,1),(70,2)]` |
| `next(60)` | None; `70 > 60` blocks | `1` | `1` | `[(100,1),(80,1),(70,2),(60,1)]` |
| `next(75)` | `(60,1)`, then `(70,2)` | `1 + 1 + 2 = 4`; `80 > 75` blocks | `4` | `[(100,1),(80,1),(75,4)]` |
| `next(85)` | `(75,4)`, then `(80,1)` | `1 + 4 + 1 = 6`; `100 > 85` blocks | `6` | `[(100,1),(85,6)]` |

Returned spans:

```text
[1, 1, 1, 2, 1, 4, 6]
```

### Understand the two important calls

**When today's price is `75`:**

```text
Before: [(100,1), (80,1), (70,2), (60,1)]

Start span = 1
Pop (60,1) → span = 1 + 1 = 2
Pop (70,2) → span = 2 + 2 = 4
Stop at (80,1), because 80 > 75
Push (75,4)

After:  [(100,1), (80,1), (75,4)]
```

The `(70,2)` entry represents two days: `60, 70`. Adding `2` counts both of them. Together with the other `60` and today (`75`), the span is four days.

**When today's price is `85`:**

```text
Before: [(100,1), (80,1), (75,4)]

Start span = 1
Pop (75,4) → span = 1 + 4 = 5
Pop (80,1) → span = 5 + 1 = 6
Stop at (100,1), because 100 > 85
Push (85,6)

After:  [(100,1), (85,6)]
```

The span covers `80, 60, 70, 60, 75, 85`. The `100` blocks the span.

### Useful edge cases

| Price stream | Spans | Why |
|---|---|---|
| `[31]` | `[1]` | Today always counts |
| `[100,80,60,50]` | `[1,1,1,1]` | Every new price is lower; nothing is popped |
| `[10,20,30,40]` | `[1,2,3,4]` | Each new price absorbs all earlier entries |
| `[100,100,100]` | `[1,2,3]` | `<=` includes equal prices |
| `[100,80,80,90]` | `[1,1,2,3]` | The second `80` absorbs the equal first `80` |

### Complexity intuition

One call may pop several entries, but no entry can be pushed or popped more than once. Across `n` calls, total stack work is `O(n)`, so the amortized time per call is `O(1)`. Worst-case stack space is `O(n)`.

---

## 5. [Array-based Stock Span — `findStockSpans(int[] prices)`](https://www.naukri.com/code360/problems/stock-span_5243295)

### Java code

```java
import java.util.*;

public class Solution {
    public static int[] findStockSpans(int[] prices) {
        Deque<int[]> st = new ArrayDeque<>();
        int[] ans = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            int span = 1;
            while (!st.isEmpty() && st.peek()[0] < prices[i]) {
                span = span + st.peek()[1]; // Absorb the previous entry's span.
                st.pop();
            }
            ans[i] = span;
            st.push(new int[]{prices[i], span});
        }
        return ans;
    }
}
```

### The important difference: `<` versus `<=`

This version pops only when:

```text
previous price < current price
```

An equal previous price **stays on the stack and blocks the span**. That is why this implementation uses `<`, whereas the online `StockSpanner.next()` implementation uses `<=` and absorbs equal prices.

The example from your platform:

```text
prices   = [2, 1, 2, 4]
expected = [1, 1, 2, 4]
```

For the third price (`2`):

- Pop the previous `1`, because `1 < 2`.
- Stop at the earlier `2`, because it is equal and is not `< 2`.
- Span is `1 + 1 = 2`.

### Dry run: `[2, 1, 2, 4]`

Stack is **bottom → top**. Each entry is `(price, span)`.

| Day | Price | What happens | Span / answer | Stack after push |
|---:|---:|---|---:|---|
| 0 | 2 | No previous entry | 1 | `[(2,1)]` |
| 1 | 1 | `2 < 1` is false; equal/greater top blocks | 1 | `[(2,1),(1,1)]` |
| 2 | 2 | Pop `(1,1)`; stop at equal `2` | `1 + 1 = 2` | `[(2,1),(2,2)]` |
| 3 | 4 | Pop `(2,2)`, then `(2,1)`; both are `< 4` | `1 + 2 + 1 = 4` | `[(4,4)]` |

Output:

```text
[1, 1, 2, 4]
```

### Compare the two Stock Span rules

| Implementation | Pop condition | What happens to equal prices? |
|---|---|---|
| `StockSpanner.next()` | `topPrice <= currentPrice` | Equal prices are popped and included in the span |
| `findStockSpans()` | `topPrice < currentPrice` | Equal prices stay and block the span |

Do not copy a comparator from one implementation into the other without checking the exact problem statement and examples.

**Complexity:** `O(n)` time and `O(n)` auxiliary space. Each pair is pushed once and popped at most once.

---

## 6. [Largest Rectangle in Histogram](https://leetcode.com/problems/largest-rectangle-in-histogram/)

### Core idea

Treat each bar as the rectangle's limiting height. Find the nearest **strictly smaller** bar on the left and right. Those bars are boundaries and are not included.

- `pse[i]`: previous strictly smaller bar's index; use `-1` if none exists.
- `nse[i]`: next strictly smaller bar's index; use `n` if none exists.
- `width = nse[i] - pse[i] - 1`
- `area = heights[i] * width`

The stack stores **indices**, because the width depends on positions, not just bar values.

### Java code

```java
class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> st = new ArrayDeque<>();
        int n = heights.length;
        int[] nse = new int[n];
        
        for (int i = n - 1; i >= 0; i--) {

            while (!st.isEmpty() && heights[i] <= heights[st.peek()]) {
                st.pop(); // Remove bars that are not strictly smaller.
            }

            if (st.isEmpty()) {

                nse[i] = n; // No smaller bar on the right.

            } else {

                nse[i] = st.peek();
            }
            st.push(i); // Save this bar as a candidate for bars to its left.
        }
        st = new ArrayDeque<>();
        int[] pse = new int[n];
        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() && heights[i] <= heights[st.peek()]) {
                st.pop(); // Remove bars that are not strictly smaller.
            }

            if (st.isEmpty()) {

                pse[i] = -1; // No smaller bar on the left.

            } else {

                pse[i] = st.peek();
            }
            st.push(i); // Save this bar as a candidate for bars to its right.
        }
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            int pseIdx = pse[i];
            int nseIdx = nse[i];

            int width = nseIdx - pseIdx - 1; // Exclude both smaller boundary bars.

            int currHgt = heights[i];
            int area = currHgt * width;

            maxLen = Math.max(maxLen, area);
        }
        return maxLen;
    }
}
```

### Why the pop condition is `>=`

Both passes need the first **strictly smaller** bar. A stack-top bar that is greater than or equal to the current bar cannot be that boundary, so pop it and check the next candidate.

```java
while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
    st.pop();
}
```

### Boundary values

`-1` and `n` are virtual positions just outside the array, not bar values.

For `heights = [2, 1, 5, 6, 2, 3]`, `n = 6`:

- For the bar `1` at index `1`, no smaller bar exists on either side: `pse[1] = -1`, `nse[1] = 6`.
- Its width is `6 - (-1) - 1 = 6`, so its area is `1 * 6 = 6`.
- For the bar `2` at index `0`, the next smaller bar is `1` at index `1`, so `nse[0] = 1`.

### Full dry run

After calculating both boundary arrays:

```text
heights = [ 2,  1,  5,  6,  2,  3 ]
pse     = [-1, -1,  1,  2,  1,  4 ]
nse     = [ 1,  6,  4,  4,  6,  6 ]
```

| Index | Height | PSE | NSE | Width | Area | Maximum so far |
|---:|---:|---:|---:|---:|---:|---:|
| 0 | 2 | -1 | 1 | 1 | 2 | 2 |
| 1 | 1 | -1 | 6 | 6 | 6 | 6 |
| 2 | 5 | 1 | 4 | 2 | 10 | 10 |
| 3 | 6 | 2 | 4 | 1 | 6 | 10 |
| 4 | 2 | 1 | 6 | 4 | 8 | 10 |
| 5 | 3 | 4 | 6 | 1 | 3 | 10 |

The largest rectangle has height `5`, spans indices `2` and `3`, and has area `10`.

### Edge cases

| Heights | Reason | Largest area |
|---|---|---:|
| `[5]` | One bar; width is 1 | 5 |
| `[2,2,2]` | Equal bars can span the full histogram | 6 |
| `[1,2,3]` | Height `1` spans all bars | 3 |
| `[3,2,1]` | Each lower bar limits taller bars | 3 |
| `[]` | No bars to process | 0 |

**Complexity:** `O(n)` time and `O(n)` auxiliary space. Each index is pushed and popped at most once in each boundary pass; the final area pass is also `O(n)`.

---

## 7. [Maximal Rectangle](https://leetcode.com/problems/maximal-rectangle/)

**Pattern:** Matrix to histogram + Largest Rectangle in Histogram  
**Data structure:** Monotonic stack (inside `largestRectangleArea`)  
**Core idea:** Convert each matrix row into histogram heights, then use the Part 1 Largest Rectangle in Histogram solution.

### Core intuition

Treat each row as the **bottom** of a histogram.

- If `matrix[rowIdx][colIdx] == '1'`, extend the histogram bar at that column: `height[colIdx]++`.
- If the cell is `'0'`, the consecutive vertical run of ones ends, so reset that height to `0`.
- After updating all columns for a row, calculate the largest rectangle in that histogram.
- Keep the maximum area found across all rows.

Every rectangle made entirely of `1`s has a bottom row. When that row is processed, its consecutive vertical runs are represented by `height[]`, so the histogram method can calculate the rectangle.

### Java code

`largestRectangleArea(height)` reuses the **Largest Rectangle in Histogram** method from Problem 6. That method calculates the largest rectangle for one histogram. This problem adds the matrix-to-histogram step: update `height[]` for each row, then call the histogram method.

```java
public int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        int[] height = new int[col];

        int maxLen = -1;
        for (int rowIdx = 0; rowIdx < row; rowIdx++) {
            for (int colIdx = 0; colIdx < col; colIdx++) {
                if (matrix[rowIdx][colIdx] == '1') {
                    height[colIdx]++;
                } else {
                    height[colIdx] = 0; // A zero breaks the consecutive run of ones.
                }
            }
            int area = largestRectangleArea(height); // Treat this row as the histogram base.
            maxLen = Math.max(maxLen, area);
        }
        return maxLen;
    }
```

### How the matrix becomes histogram heights

Example matrix:

```text
1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
```

Update `height[]` from top to bottom:

| Matrix row processed | Histogram `height[]` | Largest rectangle in this histogram |
|---:|---|---:|
| 0 | `[1, 0, 1, 0, 0]` | 1 |
| 1 | `[2, 0, 2, 1, 1]` | 3 |
| 2 | `[3, 1, 3, 2, 2]` | 6 |
| 3 | `[4, 0, 0, 3, 0]` | 4 |

The answer is the largest area among these row-wise histogram results:

```text
max(1, 3, 6, 4) = 6
```

### What each part does

| Code | Meaning |
|---|---|
| `int[] height = new int[col];` | Stores the consecutive number of `1`s ending at the current row for each column. |
| `height[colIdx]++;` | Extends that column's vertical run when the current cell is `1`. |
| `height[colIdx] = 0;` | Breaks the vertical run when the current cell is `0`. |
| `largestRectangleArea(height)` | Finds the largest all-ones rectangle whose bottom edge is the current row. |
| `maxLen = Math.max(maxLen, area);` | Keeps the best rectangle found across all processed rows. |

### Why this reuses Largest Rectangle in Histogram

For each row, `height[]` is a histogram. The helper method finds, for every bar, its previous smaller and next smaller boundaries:

```text
width = NSE - PSE - 1
area  = height * width
```

The largest histogram rectangle is therefore the largest rectangle of `1`s whose bottom edge is that row. Processing every row considers every possible bottom edge, so the largest result is the maximal rectangle in the matrix.

### Complexity

Let `R` be the number of rows and `C` be the number of columns.

- **Time:** `O(R × C)`. Updating one histogram takes `O(C)`. The monotonic-stack histogram method also takes `O(C)`, and it is run once per row.
- **Auxiliary space:** `O(C)`. The `height[]` array, NSE/PSE arrays, and stack each use space proportional to the number of columns.

### Edge case

This implementation accesses `matrix[0]`, so it assumes the matrix has at least one row and one column, as guaranteed by the usual LeetCode 85 constraints. For a reusable method that may receive an empty matrix, add an empty-input guard before reading `matrix[0]`.

### Interview recall

1. Why does a `'1'` increment the histogram height?
2. Why does a `'0'` reset the height to zero?
3. Why do we call `largestRectangleArea()` after processing each row?
4. What does one `height[colIdx]` represent?
5. Why is the overall time complexity `O(R × C)`?

### Revision checklist

- [ ] Explain how each matrix row creates a histogram.
- [ ] Dry-run the `height[]` array for all rows of the example matrix.
- [ ] Explain how the histogram helper uses NSE and PSE indices.
- [ ] Re-code the two nested loops without looking.
- [ ] Explain why the maximum must be updated after every row.

---

## 8. Quick revision summary

```text
NEXT     → scan right to left
PREVIOUS → scan left to right
SMALLER  → pop >= current
GREATER  → pop <= current

st.peek()       → index
arr[st.peek()]  → value
```

For the four neighbour problems, an empty stack means there is no qualifying neighbour (`-1` in these implementations). For histogram, store boundary indices and use:

```text
PSE = -1 if no smaller bar exists on the left
NSE = n  if no smaller bar exists on the right
width = NSE - PSE - 1
area  = height * width
```

For Stock Span, start with span `1`, absorb qualifying earlier entries by adding their saved spans, then push `(price, totalSpan)`.

### Revision checkpoints

- [ ] Explain the scan direction and pop condition for NSE, NGE, PSE and PGE.
- [ ] Explain why the stack stores indices and when to read `arr[st.peek()]`.
- [ ] Dry-run all four neighbour problems, including duplicates.
- [ ] Explain why Stock Span stores `(price, span)` and why equal-price handling differs between the two versions.
- [ ] Derive the histogram boundaries and `width = NSE - PSE - 1` without looking.
- [ ] Re-code the main solutions and explain their `O(n)` time complexity.

