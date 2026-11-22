# Stack Pattern 3 --- Complete Practical Revision

**Scope:** Problems shared and confirmed in this conversation. No
duplicate entries. **Acceptance:** Sort Stack showed 10/10 tests, 40/40
EXP. User confirmed the other submitted solutions accepted. **Revision
rounds:** R1/R2/R3 remain unchecked until completed independently.

## Revision navigation

### Learn the pattern first

- [Pattern idea](#pattern-idea)
- [Covered problems and progress](#covered-problems---deduplicated)

### Problem-by-problem revision

| # | Problem | Main idea |
|---:|---|---|
| 1 | [Insert an Element at the Bottom](https://www.naukri.com/code360/problems/insert-an-element-at-its-bottom-in-a-given-stack_1171166) | Pop all → push the new value → restore saved values |
| 2 | [Reverse a Stack using Recursion](https://www.naukri.com/code360/problems/reverse-stack-using-recursion_631875?leftPanelTabValue=PROBLEM) | Pop → reverse the rest → insert the saved value at the bottom |
| 3 | [Sort a Stack using Recursion](https://www.naukri.com/code360/problems/sort-a-stack_985275) | Pop → sort the remaining stack → insert in the correct position |

> Each problem title opens its corresponding **Naukri Code360** problem statement.

---

## Pattern idea

Recursion temporarily removes stack elements, processes the smaller
stack, then restores elements while calls return.

Typical flow: 1. Base case. 2. Pop one element. 3. Recursively process
the remaining stack. 4. Restore or insert the saved element.

**Core rule:** restore the exact value popped. `pop()` changes the
stack.

## Covered problems --- deduplicated

  -----------------------------------------------------------------------
  Problem                 Original code included  Progress
  ----------------------- ----------------------- -----------------------
  Insert an Element at    Yes                     User confirmed accepted
  the Bottom                                      

  Reverse a Stack using   Yes                     User confirmed accepted
  Recursion                                       

  Sort a Stack using      Yes                     Accepted; 10/10 tests,
  Recursion                                       40/40 EXP shown

  Check if Stack Is       Not in current chat     Previously practiced
  Sorted                                          per user

  Sorted Insert into      Not in current chat     Previously practiced
  Stack                                           per user

  Delete Middle Element   Not in current chat     Previously solved per
  of Stack                                        user
  -----------------------------------------------------------------------

The later recursive stack-sort snippet is another implementation of
**Sort a Stack using Recursion**, not a separate problem.

------------------------------------------------------------------------

# 1. [Insert an Element at the Bottom](https://www.naukri.com/code360/problems/insert-an-element-at-its-bottom-in-a-given-stack_1171166)

## Goal

Insert `x` below every existing stack element, preserving the existing
order.

## Your accepted code

``` java
import java.util.*;
import java.io.*;

public class Solution {
    public static Stack<Integer> pushAtBottom(Stack<Integer> myStack, int x) {
        if (myStack.isEmpty()) {
            myStack.push(x);
            return myStack;
        }

        int popVal = myStack.pop();
        pushAtBottom(myStack, x);
        myStack.push(popVal);
        return myStack;
    }
}
```

## Intuition

Pop until empty; push `x`; restore each saved value while recursion
returns.

## Dry run

Initial bottom → top: `[1, 2, 3]`; insert `0`.

  Action           Stack
  ---------------- ----------------
  Pop 3            `[1, 2]`
  Pop 2            `[1]`
  Pop 1            `[]`
  Push 0 at base   `[0]`
  Restore 1        `[0, 1]`
  Restore 2        `[0, 1, 2]`
  Restore 3        `[0, 1, 2, 3]`

## Edge cases

-   Empty → `[x]`.
-   One element → `x` becomes bottom, old value stays above it.
-   `x` smaller/larger/equal → same behavior; no comparison required.
-   Existing duplicates remain unchanged.

## Revision checkpoints

-   Base case pushes `x`.
-   Save popped value in `popVal`.
-   Recursive call before restoration.
-   Restore `popVal`, not `x`.
-   This is bottom insertion, not sorted insertion.

**Complexity:** Time `O(n)`; auxiliary recursion space `O(n)`.


------------------------------------------------------------------------

# 2. [Reverse a Stack using Recursion](https://www.naukri.com/code360/problems/reverse-stack-using-recursion_631875?leftPanelTabValue=PROBLEM)

## Goal

Reverse element order. This is not sorting: no value comparisons are
made.

## Your accepted code

``` java
import java.util.Stack;

public class Solution {
    public static Stack<Integer> pushAtBottom(Stack<Integer> myStack, int x) {
        if (myStack.isEmpty()) {
            myStack.push(x);
            return myStack;
        }

        int popVal = myStack.pop();
        pushAtBottom(myStack, x);
        myStack.push(popVal);
        return myStack;
    }

    public static void reverseStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }

        int preVal = stack.pop();
        reverseStack(stack);
        pushAtBottom(stack, preVal);
    }
}
```

## Intuition

Pop top → reverse remaining stack → insert saved value at bottom.

## Dry run

Initial bottom → top: `[1, 2, 3]` (top 3).

**Remove phase:** `3` → `2` → `1`; stack becomes empty.

**Return phase:** - Insert `1` at bottom → `[1]` - Insert `2` at bottom
→ `[2, 1]` - Insert `3` at bottom → `[3, 2, 1]`

Final bottom → top: **`[3, 2, 1]`**; top is `1`.

## Edge cases

-   Empty → empty.
-   One element → unchanged.
-   Two elements → swapped.
-   Duplicates → all retained.
-   Negative values → unaffected.

## Revision checkpoints

-   Base case is empty stack.
-   Save popped value in `preVal`.
-   Reverse the remaining stack before `pushAtBottom`.
-   Bottom insertion is what makes the order reverse.
-   Do not confuse reversing with sorting.

**Complexity:** Time `O(n²)` because each bottom insertion can traverse
the stack; auxiliary space `O(n)` recursion depth, with nested
bottom-insertion recursion.


------------------------------------------------------------------------

# 3. [Sort a Stack using Recursion](https://www.naukri.com/code360/problems/sort-a-stack_985275)

## Goal

Sort the stack using recursion. The accepted platform order in this
conversation has the **largest element at the top**. In dry runs below,
stack is shown **bottom → top**.

## Your accepted code

``` java
import java.util.*;
import java.io.*;

public class Solution {

    public static void sortHelper(Stack<Integer> stack, int prevEle) {
        if (stack.isEmpty() || prevEle >= stack.peek()) {
            stack.push(prevEle);
            return;
        }

        int top = stack.pop();
        sortHelper(stack, prevEle);
        stack.push(top);
    }

    public static void sortStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }

        int prevEle = stack.pop();
        sortStack(stack);

        if (isSorted(stack, prevEle)) {
            stack.push(prevEle);
            return;
        } else {
            sortHelper(stack, prevEle);
            return;
        }
    }

    public static boolean isSorted(Stack<Integer> stack, int prevEle) {
        if (stack.isEmpty()) {
            return true;
        }

        int top = stack.pop();
        boolean isLessbyTop = (prevEle >= top);
        boolean recAns = isSorted(stack, prevEle);

        stack.push(top);

        return (isLessbyTop && recAns);
    }
}
```

## Method understanding

### `sortStack`

-   Pop one value into `prevEle`.
-   Recursively sort the remaining stack.
-   Check whether `prevEle` can be pushed directly.
-   If not, use `sortHelper` to insert it.
-   The direct branch must push `prevEle`; returning without it loses
    the value.

### `isSorted`

-   Checks whether `prevEle` can be placed on top of all existing
    values.
-   Pops `top`, checks `prevEle >= top`, recursively checks the rest,
    then restores `top`.
-   Restore `top`, not `prevEle`; this method must not alter stack
    contents.

### `sortHelper`

-   Empty stack: push `prevEle`.
-   If `prevEle >= stack.peek()`, push it.
-   Otherwise pop `top`, recursively insert `prevEle`, then restore
    `top`.

## Dry run: `[3, 1, 2]`

Initial stack bottom → top: `[3, 1, 2]`. Target top is largest.

### Remove phase

  Call          Removed Remaining
  ----------- --------- -----------
  1                   2 `[3, 1]`
  2                   1 `[3]`
  3                   3 `[]`
  Base case         --- `[]`

### Return and insert phase

1.  Restore `3` → `[3]`.
2.  Insert `1`: `isSorted([3], 1)` checks `1 >= 3` → false. `sortHelper`
    inserts it below 3 → `[1, 3]`.
3.  Insert `2`: `isSorted([1, 3], 2)` returns false because `2 >= 3` is
    false.
4.  `sortHelper` temporarily pops `3`, inserts `2` above `1`, then
    restores `3`.

Final bottom → top: **`[1, 2, 3]`**. Top is `3`.

## Revision checkpoints

-   `sortStack` empty base case prevents unnecessary pop.
-   Direct insertion branch must `stack.push(prevEle)`.
-   `isSorted` must restore the popped `top`.
-   `sortHelper` must handle empty stack before `peek()`/`pop()`.
-   For largest-at-top order, both comparisons use `prevEle >= top` /
    `prevEle >= stack.peek()`.
-   Restore temporary elements after recursive insertion.
-   `>=` handles duplicates without losing values.
-   Negative values work through ordinary integer comparison.
-   Keep bottom→top vs top→bottom notation explicit.

## Edge cases

  Input situation                Expected
  ------------------------------ ------------------------------------
  Empty stack                    Remains empty
  One element                    Unchanged
  Already sorted                 Remains sorted
  Reverse order                  Sorted into required order
  Duplicate values               All values retained
  Negative and positive values   Numeric order
  All equal                      All retained; recursion terminates

**Complexity:** Time `O(n²)` worst case; auxiliary recursion space
`O(n)`.


------------------------------------------------------------------------

# Quick recall

  Problem asks       Recursion action
  ------------------ -----------------------------------------------------
  Insert at bottom   Pop all → push new value → restore
  Reverse stack      Pop → reverse rest → insert popped value at bottom
  Sort stack         Pop → sort rest → insert in correct sorted position

## Before submitting

-   [ ] Base case covers empty/smallest input.
-   [ ] I know which value was popped.
-   [ ] I restore the exact saved value.
-   [ ] Recursive call occurs before restoration.
-   [ ] Comparison direction matches requested order.
-   [ ] No `peek()` or `pop()` on empty stack.
-   [ ] All values remain unless task says otherwise.
-   [ ] Test empty, one element, duplicates, sorted, reverse order, and
    negative values.

## Revision rounds

-   [ ] R1 --- solve from memory.
-   [ ] R2 --- revisit after about 7 days.
-   [ ] R3 --- revisit after about 30 days.

Leave each unchecked until independently completed.
