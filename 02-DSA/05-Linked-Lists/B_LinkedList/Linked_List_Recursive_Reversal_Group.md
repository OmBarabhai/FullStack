# Linked List — Recursive Reversal: Two Problems Revision

## Problems Combined

1. **Reverse Nodes in K-Group**
2. **Reverse Nodes in Even Length Groups**

This revision combines the pointer ideas, recursive structure, mistakes, and final mental models learned while solving both problems.

---

# 1. Core Reversal Pattern

The universal linked-list reversal pattern is:

```java
fwd = curr.next;
curr.next = prev;
prev = curr;
curr = fwd;
```

### Memory

**SAVE → CHANGE → MOVE → MOVE**

- `fwd` saves the untouched next node.
- `curr.next = prev` reverses the current link.
- `prev = curr` moves the reversed-list front.
- `curr = fwd` moves to the next untouched node.

Never change `curr.next` before saving `curr.next` in `fwd`.

---

# 2. Reverse Nodes in K-Group

## Problem idea

Given a linked list and `k`, reverse every complete group of `k` nodes.

Example:

```text
1 → 2 → 3 → 4 → 5
k = 2

2 → 1 → 4 → 3 → 5
```

The last incomplete group is **not reversed**.

---

## Iterative Mental Model

Before reversing a group:

```text
prevTail → groupStart → ... → groupEnd → nextGroup
```

After reversing:

```text
prevTail → groupEnd → ... → groupStart → nextGroup
```

Important:

```text
groupStart = old first node
           ↓
           becomes new tail

groupEnd = old last node
         ↓
         becomes new head
```

---

## Important Variables

```text
prevTail   → end of already processed part
kthNode    → last node of current k-sized group
beforeGroup / groupStart → first node of current group
nextGroup  → first node after current group
curr       → node currently being reversed
prev       → start of reversed portion
fwd        → saved next node
```

### Most important distinction

```text
prevTail = processed boundary
prev     = reversed portion's front
```

Do not confuse them.

---

## Iterative Reversal Connection

```java
prevTail.next = prev;
prevTail = groupStart;
```

Why?

Because after reversal the old group start becomes the tail.

---

## Recursive K-Group Structure

The recursive function should solve the **remaining/unprocessed list**.

Conceptually:

```text
current group
     ↓
reverse current group
     ↓
recursively solve next group
     ↓
connect current group's tail to recursive result
     ↓
return current group's new head
```

### Critical rule

Recursion starts from:

```java
nextGroupHead
```

NOT:

```java
prevTail
```

because `prevTail` belongs to the already processed part.

---

## Recursive K-Group Connection

If:

```text
A → B → C → D → E → ...
```

and `A B C` is reversed:

```text
C → B → A
```

then `A` is now the tail.

So after recursion:

```java
oldGroupHead.next = recResult;
```

and return:

```java
return newGroupHeadOfCurrentReversedGroup;
```

---

## Typical Mistakes From Practice

### Mistake 1: Updating `prevTail` to the old group end

Wrong:

```java
prevTail = kthNode;
```

Correct idea:

```java
prevTail = groupStart;
```

because the old group start becomes the tail after reversal.

### Mistake 2: Recursing on the processed boundary

Wrong:

```java
reverseKGroup(prevTail, k)
```

Correct:

```java
reverseKGroup(nextGroupHead, k)
```

### Mistake 3: Connecting the wrong node

Wrong:

```java
prevTail.next = recResult;
```

inside the recursive version when `prevTail` refers to the previous boundary.

Correct concept:

```java
oldGroupHead.next = recResult;
```

because the old head is the current reversed group's tail.

---

# 3. Reverse Nodes in Even Length Groups

## Problem idea

The list is divided into groups of expected sizes:

```text
1, 2, 3, 4, 5, ...
```

The final group may be incomplete.

Reverse a group **only when its ACTUAL number of nodes is even**.

Example:

```text
[5] | [6,2] | [3,9,1] | [4,8,3,7]

1 odd   → keep
2 even  → reverse
3 odd   → keep
4 even  → reverse

Result:
[5,6?]
```

For:

```text
[5,2,6,3,9,1,7,3,8,4]
```

actual groups are:

```text
[5]
[2,6]
[3,9,1]
[7,3,8,4]
```

Result:

```text
[5,6,2,3,9,1,4,8,3,7]
```

---

# 4. Expected Group Size vs Actual Group Size

This was one of the most important concepts discovered during debugging.

```text
expectedGroupSize = how many nodes we TRY to take
actualGroupSize   = how many nodes actually exist in this group
```

Example:

```text
expected = 4
actual   = 2
```

The group length is **2**, so it is even and must be reversed.

Therefore the decision must use:

```java
(actualGroupSize & 1) == 0
```

NOT:

```java
(expectedGroupSize & 1) == 0
```

---

# 5. Why a Recursive Helper Is Needed

LeetCode requires:

```java
public ListNode reverseEvenLengthGroups(ListNode head)
```

You cannot change that signature.

But recursion needs `expectedGroupSize` to progress:

```text
1 → 2 → 3 → 4 → 5 → ...
```

So use a helper:

```java
public ListNode reverseEvenLengthGroups(ListNode head) {
    return reverseEvenLengthGroupsHelper(head, 1);
}
```

Then:

```java
private ListNode reverseEvenLengthGroupsHelper(
        ListNode head, int expectedGroupSize)
```

Recursive call:

```java
reverseEvenLengthGroupsHelper(
    newGroupHead,
    expectedGroupSize + 1
);
```

Do NOT do:

```java
expectedGroupSize++;
reverseEvenLengthGroups(newGroupHead);
```

because the public LeetCode method starts the state again.

---

# 6. Why No Dummy or PrevTail Is Needed in the Recursive Even-Group Solution

For this recursive solution, the whole-list `dummy` and iterative `prevTail` pattern is unnecessary.

The recursive model is:

```text
current group
     ↓
process current group
     ↓
recursive call on next group
     ↓
connect current group's tail to recursive answer
     ↓
return current group's head
```

Useful variables are:

```text
head            → current group start
expectedGroupSize → expected size of current group
actualGroupSize → actual nodes found
oldGroupHead    → original first node of current group
newGroupHead    → first node of next group
 groupHead      → final head of current group
 groupTail      → final tail of current group
```

---

# 7. Finding the Current Group

Start from the current group's head:

```java
ListNode currNode = head;
int actualGroupSize = 0;
```

Count nodes:

```java
ListNode groupTail = null;

for (int i = 1;
     i <= expectedGroupSize && currNode != null;
     i++) {

    groupTail = currNode;
    actualGroupSize++;
    currNode = currNode.next;
}
```

After this loop:

```text
groupTail    → last node actually inside current group
currNode     → first node after current group
```

Therefore:

```java
ListNode newGroupHead = currNode;
```

Do NOT use:

```java
currNode.next
```

because `currNode` is already the next group's first node.

Also, `currNode` can be `null`, so `currNode.next` may crash.

---

# 8. Recursive Even-Group Reversal

Suppose current group is:

```text
A → B → C → nextGroup
```

If actual length is even, reverse it:

```text
C → B → A → nextGroup
```

Important:

```text
oldGroupHead = A
               ↓
               becomes tail

new group head = C
```

So we need BOTH references.

```java
ListNode oldGroupHead = head;
ListNode groupHead = head;
```

During reversal:

```java
ListNode curr = oldGroupHead;
ListNode prev = newGroupHead;

while (curr != newGroupHead) {
    ListNode fwd = curr.next;
    curr.next = prev;
    prev = curr;
    curr = fwd;
}

groupHead = prev;
```

Now:

```text
groupHead     → C
oldGroupHead  → A (tail)
```

---

# 9. The Critical Tail Bug

This was the major bug found through the failing LeetCode test.

Example:

```text
[2,6] → [3,9,1] → [7,3,8,4]
```

Before reversal of group 2:

```text
2 → 6 → 3
```

After reversal:

```text
6 → 2 → 3
```

The old group tail `6` is now the **head**.

The old group head `2` is now the **tail**.

So if you keep an old `prevTail = 6` and do:

```java
prevTail.next = recAns;
```

you overwrite:

```text
6.next = 2
```

and lose node `2` from the returned chain.

### Correct rule

For the recursive even-group problem, save the original head and update the final tail correctly.

A robust variable is:

```java
groupTail
```

When the group is reversed:

```java
groupTail = oldGroupHead;
```

When the group is not reversed, `groupTail` stays the actual last node found.

Then one common connection works:

```java
groupTail.next = recAns;
```

---

# 10. Correct Recursive Solution — Even Length Groups

```java
class Solution {

    public ListNode reverseEvenLengthGroups(ListNode head) {
        return helper(head, 1);
    }

    private ListNode helper(ListNode head, int expectedGroupSize) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode currNode = head;
        ListNode groupTail = null;
        int actualGroupSize = 0;

        for (int i = 1;
             i <= expectedGroupSize && currNode != null;
             i++) {

            groupTail = currNode;
            actualGroupSize++;
            currNode = currNode.next;
        }

        ListNode newGroupHead = currNode;
        ListNode groupHead = head;
        ListNode oldGroupHead = head;

        if ((actualGroupSize & 1) == 0) {

            ListNode curr = oldGroupHead;
            ListNode prev = newGroupHead;

            while (curr != newGroupHead) {
                ListNode fwd = curr.next;
                curr.next = prev;
                prev = curr;
                curr = fwd;
            }

            groupHead = prev;
            groupTail = oldGroupHead;
        }

        ListNode recAns =
            helper(newGroupHead, expectedGroupSize + 1);

        groupTail.next = recAns;

        return groupHead;
    }
}
```

---

# 11. Important Base Case Note

Safe ordering:

```java
if (head == null || head.next == null) {
    return head;
}
```

NOT:

```java
if (head.next == null || head == null)
```

Java evaluates left to right. If `head` is null, `head.next` crashes.

---

# 12. Two Problems — Same Reversal Core, Different State

## Reverse K-Group

```text
Question:
Is there a COMPLETE group of k nodes?

State focus:
prevTail + groupStart + nextGroup
```

The incomplete final group is left unchanged.

## Even Length Groups

```text
Question:
What is the ACTUAL size of this group?

State focus:
expectedGroupSize + actualGroupSize + groupTail
```

The final incomplete group is still processed based on its **actual** length.

Example:

```text
expected = 4
actual = 2
```

Actual length is even → reverse.

---

# 13. Deep Pointer Comparison

## K-Group

```text
prevTail → current group → nextGroup
```

`prevTail` belongs to the processed boundary outside the current group.

## Even-Length Groups Recursive

```text
current group → nextGroup
```

No external processed boundary is needed.

The current group's own tail is enough to reconnect after recursion.

---

# 14. Most Important Pointer Rules Learned

### Rule 1 — Old first becomes tail after reversal

```text
A → B → C

C → B → A
         ↑
        tail
```

### Rule 2 — Old last becomes head after reversal

```text
A → B → C

C → B → A
↑
head
```

### Rule 3 — Recursion solves the unprocessed remainder

```text
current group
      ↓
nextGroupHead
      ↓
recursive call
```

### Rule 4 — Expected and actual are different

```text
expected = plan
actual   = reality
```

### Rule 5 — One variable should have one clear job

Avoid using one pointer to mean both:

```text
processed tail
```

and:

```text
current reversed tail
```

### Rule 6 — Always know what each pointer points to NOW

Before every link change, ask:

```text
curr → ?
prev → ?
fwd → ?
groupHead → ?
groupTail → ?
newGroupHead → ?
```

---

# 15. Dry Run Template

When debugging either problem, make a small table.

```text
Group | Expected | Actual | Reverse? | Group Head | Group Tail | Next Group
```

Example for:

```text
[5,2,6,3,9,1,7,3,8,4]
```

```text
Group 1 | 1 | 1 | No  | 5 | 5 | 2
Group 2 | 2 | 2 | Yes | 6 | 2 | 3
Group 3 | 3 | 3 | No  | 3 | 1 | 7
Group 4 | 4 | 4 | Yes | 4 | 7 | null
```

Final:

```text
5 → 6 → 2 → 3 → 9 → 1 → 4 → 8 → 3 → 7
```

---

# 16. Debugging Checklist

Before submitting a recursive linked-list reversal solution, check:

```text
[ ] Base case handles null safely
[ ] Recursive state actually progresses
[ ] Recursion starts at the next unprocessed group
[ ] Current group boundary is correct
[ ] next pointer is saved before changing links
[ ] Reversal uses the correct stopping condition
[ ] Actual group size is used when the problem asks for actual size
[ ] Old head/new head are not confused
[ ] Final tail is connected to recursive result
[ ] Returned node is the current group's final head
[ ] No node is accidentally disconnected
```

---

# 17. Your Major Mistakes Across Both Problems

### Mistake A — `prevTail` vs `prev`

You initially mixed:

```text
prevTail = processed boundary
prev     = reversed front
```

They are not the same role.

### Mistake B — Recursing on the wrong node

You initially tried recursion from the processed boundary.

Correct recursion starts on the unprocessed remainder.

### Mistake C — Updating local expected size without passing it

```java
expectedGroupSize++;
```

only changes the current call's local variable.

Recursive state should be passed:

```java
helper(nextGroupHead, expectedGroupSize + 1);
```

### Mistake D — Checking expected instead of actual

For even-length groups, this fails on incomplete groups.

### Mistake E — Using a pre-reversal tail after reversal

A pointer that referred to the old tail may become the new head.

Always recalculate the current tail role after reversal.

### Mistake F — Connecting the head instead of the tail

If you connect:

```java
oldGroupHead.next = recAns;
```

that is correct only when `oldGroupHead` is actually the current tail at that moment (for a reversed even group).

For a general group-processing solution, track `groupTail` explicitly.

---

# 18. Complexity

## Reverse K-Group

```text
Time:  O(n)
Space: O(1) auxiliary for iterative version
       O(n/k) recursion stack for recursive version
```

## Even Length Groups — Recursive

Every node is counted/processed a constant number of times.

```text
Time:  O(n)
Space: O(number of groups) recursion stack
```

---

# 19. Final Permanent Mental Model

When you see a recursive linked-list group-reversal problem, think:

```text
1. Where does the current group start?
2. How do I find where this group ends?
3. What is the actual size?
4. Should this group be reversed?
5. If reversed, which node becomes the new head?
6. Which node becomes the new tail?
7. Where does the next recursive call start?
8. Which current node connects to the recursive answer?
9. Which node do I return to my caller?
```

The universal structure is:

```text
                CURRENT GROUP
                     ↓
              find its boundary
                     ↓
              measure / decide
                     ↓
            reverse if required
                     ↓
         solve NEXT GROUP recursively
                     ↓
              reconnect tail
                     ↓
            return current HEAD
```

---

# 20. One-Line Memory

```text
K-Group:
COMPLETE GROUP → REVERSE → CONNECT → NEXT GROUP

Even Groups:
COUNT ACTUAL → EVEN? REVERSE : KEEP → CONNECT TAIL → NEXT GROUP
```

