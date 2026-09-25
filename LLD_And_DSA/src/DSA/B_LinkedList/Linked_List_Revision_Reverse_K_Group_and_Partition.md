# Linked List Revision Notes — Reverse K-Group & Partition List

## Problem 1 — Reverse Nodes in K-Group

### Goal

Reverse nodes in groups of `k`. If fewer than `k` nodes remain, leave them unchanged.

Example:

```text
1 → 2 → 3 → 4 → 5
k = 2

2 → 1 → 4 → 3 → 5
```

### Core picture

```text
beforeGroup → [ groupStart → ... → groupEnd ] → afterGroup
```

Pointers:

- `beforeGroup` = node immediately before current group
- `groupStart` = first node before reversal
- `groupEnd` = kth node
- `afterGroup` = node immediately after group
- `previous` = reversed part / new group head
- `current` = node being reversed
- `next` = saved next node

### Algorithm

```text
1. Find groupEnd.
2. If groupEnd becomes null, fewer than k nodes remain → return.
3. Save groupStart and afterGroup.
4. Reverse the group.
5. Connect previous part to the new group head.
6. Move beforeGroup to the old groupStart.
7. Repeat.
```

### Dummy node

```java
ListNode dummy = new ListNode(-1);
dummy.next = head;
ListNode beforeGroup = dummy;
```

The dummy makes the first group behave like every other group.

### Find kth node

```java
ListNode groupEnd = beforeGroup;

for (int i = 0; i < k; i++) {
    groupEnd = groupEnd.next;

    if (groupEnd == null) {
        return dummy.next;
    }
}
```

Mental rule:

> Move exactly `k` times. If you hit `null`, there are not enough nodes for another complete group.

### Save boundaries

```java
ListNode groupStart = beforeGroup.next;
ListNode afterGroup = groupEnd.next;
```

Now:

```text
beforeGroup → [groupStart ... groupEnd] → afterGroup
```

### Prepare reversal

```java
ListNode current = groupStart;
ListNode previous = afterGroup;
```

Unlike whole-list reversal, `previous` is not `null`. It is `afterGroup`, so the reversed segment reconnects to the remaining list.

### Reversal pattern

```java
while (current != afterGroup) {
    ListNode next = current.next;

    current.next = previous;

    previous = current;
    current = next;
}
```

Roles:

```text
previous = already reversed
current  = not-yet-reversed
next     = saved future
```

Permanent pattern:

```text
SAVE → CHANGE → MOVE → MOVE
```

### Complete dry run — `1 → 2 → 3 → 4 → 5`, `k = 2`

Initial:

```text
dummy → 1 → 2 → 3 → 4 → 5
  ↑
beforeGroup
```

First group:

```text
[1 → 2]
```

Boundary pointers:

```text
groupStart = 1
groupEnd   = 2
afterGroup = 3
```

Prepare:

```text
current = 1
previous = 3
```

#### Reversal iteration 1

```java
next = current.next;     // 2
current.next = previous; // 1 → 3
previous = current;      // previous = 1
current = next;          // current = 2
```

State:

```text
previous → 1 → 3 → 4 → 5
current  → 2
```

#### Reversal iteration 2

```java
next = current.next;     // 3
current.next = previous; // 2 → 1
previous = current;      // previous = 2
current = next;          // current = 3
```

Now:

```text
2 → 1 → 3 → 4 → 5
```

Since `current == afterGroup`, stop.

Critical point:

```text
previous   = 2  → new group head
groupStart = 1  → new group tail
```

Reconnect:

```java
beforeGroup.next = previous;
```

Result:

```text
dummy → 2 → 1 → 3 → 4 → 5
```

Move:

```java
beforeGroup = groupStart;
```

So:

```text
dummy → 2 → 1 → 3 → 4 → 5
              ↑
         beforeGroup
```

Second group is `[3 → 4]`. Reverse it to `[4 → 3]` and reconnect:

```text
dummy → 2 → 1 → 4 → 3 → 5
```

The remaining node is `5`, fewer than `k = 2`, so leave it unchanged.

Final:

```text
2 → 1 → 4 → 3 → 5
```

### Most important relationship

Before reversal:

```text
groupStart → ... → groupEnd
```

After reversal:

```text
groupEnd → ... → groupStart
```

Therefore:

```text
old head = new tail
old tail = new head
```

So:

```text
previous   = new group head
groupStart = new group tail
```

### Why save `next`?

Suppose:

```text
1 → 2 → 3
```

Changing:

```java
current.next = previous;
```

destroys the old `1 → 2` connection. Saving:

```java
next = current.next;
```

keeps the rest of the list reachable.

### Invariant

At the start of every outer loop:

```text
dummy → processed groups → beforeGroup → unprocessed nodes
```

Everything before `beforeGroup` is already correct.

### Edge cases

```text
head = null       → null
k = 1             → unchanged
exactly k nodes   → reverse all
fewer than k      → leave remaining nodes unchanged
k > length       → original list unchanged
```

### Final code

```java
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode beforeGroup = dummy;

        while (beforeGroup.next != null) {

            ListNode groupEnd = beforeGroup;

            for (int i = 0; i < k; i++) {
                groupEnd = groupEnd.next;

                if (groupEnd == null) {
                    return dummy.next;
                }
            }

            ListNode groupStart = beforeGroup.next;
            ListNode afterGroup = groupEnd.next;

            ListNode current = groupStart;
            ListNode previous = afterGroup;

            while (current != afterGroup) {
                ListNode next = current.next;

                current.next = previous;

                previous = current;
                current = next;
            }

            beforeGroup.next = previous;
            beforeGroup = groupStart;
        }

        return dummy.next;
    }
}
```

### Complexity

```text
Time:  O(n)
Space: O(1) extra
```

### Memory line

```text
beforeGroup → [groupStart ... groupEnd] → afterGroup

FIND → SAVE → REVERSE → CONNECT → MOVE
```

---

# Problem 2 — Partition List

## Goal

Rearrange the list so that:

```text
all nodes < x
then all nodes == x
then all nodes > x
```

The relative order inside each group remains the same.

Example:

```text
1 → 4 → 3 → 2 → 5
x = 3

1 → 2 → 3 → 4 → 5
```

## Core idea

Build three chains:

```text
< x       == x       > x
less      equal      greater
```

Each chain has a head and a tail.

```text
lessHead  → lessTail
equalHead → equalTail
greatHead → greatTail
```

Then join:

```text
less → equal → greater
```

## Dummy nodes

```java
Node lessHead = new Node(-1);
Node lessTail = lessHead;

Node equalHead = new Node(-1);
Node equalTail = equalHead;

Node greatHead = new Node(-1);
Node greatTail = greatHead;
```

Dummy nodes make the first insertion into every chain simple.

## Processing pattern

For every original node:

```text
SAVE → DETACH → CLASSIFY → ATTACH → MOVE
```

Code pattern:

```java
Node next = temp.next;
temp.next = null;

if (...) {
    tail.next = temp;
    tail = temp;
}

temp = next;
```

## Why save `next`?

Suppose:

```text
1 → 4 → 3
```

For `temp = 1`:

```java
Node next = temp.next;
```

gives `next = 4`.

Then:

```java
temp.next = null;
```

safely detaches `1`. The saved `next` still tells us where the original traversal continues.

## Complete dry run — `1 → 4 → 3 → 2 → 5`, `x = 3`

Initially all three partitions are empty.

### Node 1

```text
next = 4
1 detached
1 < 3
```

Less:

```text
1
```

Move to `4`.

### Node 4

```text
next = 3
4 detached
4 > 3
```

Greater:

```text
4
```

Move to `3`.

### Node 3

```text
next = 2
3 detached
3 == 3
```

Equal:

```text
3
```

Move to `2`.

### Node 2

```text
next = 5
2 detached
2 < 3
```

Less:

```text
1 → 2
```

Move to `5`.

### Node 5

```text
next = null
5 detached
5 > 3
```

Greater:

```text
4 → 5
```

Move to `null` and stop.

Final partitions:

```text
less:    1 → 2
equal:   3
greater: 4 → 5
```

Join:

```java
lessTail.next = equalHead.next;
equalTail.next = greatHead.next;
```

Result:

```text
1 → 2 → 3 → 4 → 5
```

## What if equal is empty?

Example:

```text
1 → 4 → 2 → 5
x = 3
```

Partitions:

```text
less:    1 → 2
equal:   empty
greater: 4 → 5
```

Connect directly:

```java
lessTail.next = greatHead.next;
```

Result:

```text
1 → 2 → 4 → 5
```

## What if less is empty?

Example:

```text
4 → 3 → 5
x = 3
```

Result:

```text
3 → 4 → 5
```

The answer does not necessarily start at the original `head`.

Therefore:

```java
return head;
```

is unsafe.

Return the first non-empty partition:

```java
if (lessHead.next != null) {
    return lessHead.next;
}

if (equalHead.next != null) {
    return equalHead.next;
}

return greatHead.next;
```

## Tail rule

When attaching a node:

```java
tail.next = temp;
tail = temp;
```

First line attaches the node. Second line moves the tail to the new last node.

### Mental model

```text
tail = where the next node should be attached
```

## Stable ordering

Example:

```text
5 → 1 → 4 → 2 → 3 → 0
x = 3
```

Partitions:

```text
less:    1 → 2 → 0
equal:   3
greater: 5 → 4
```

Final:

```text
1 → 2 → 0 → 3 → 5 → 4
```

The relative order inside each partition is preserved.

## Common mistakes

### 1. Forgetting to move `temp`

Wrong:

```java
while (temp != null) {
    ...
}
```

without:

```java
temp = next;
```

This causes an infinite loop / TLE.

### 2. Not saving `next` before detaching

Safe:

```java
Node next = temp.next;
temp.next = null;
```

### 3. Returning the original `head`

Wrong:

```java
return head;
```

The final head can change.

### 4. Connecting only less → equal

You must also connect equal → greater when equal exists:

```java
equalTail.next = greatHead.next;
```

### 5. Forgetting the no-equal case

When equal is empty:

```text
less → greater
```

## Final code

```java
class Solution {
    public Node partition(Node head, int x) {

        Node lessHead = new Node(-1);
        Node lessTail = lessHead;

        Node equalHead = new Node(-1);
        Node equalTail = equalHead;

        Node greatHead = new Node(-1);
        Node greatTail = greatHead;

        Node temp = head;

        while (temp != null) {

            Node next = temp.next;
            temp.next = null;

            if (temp.data < x) {
                lessTail.next = temp;
                lessTail = temp;
            }
            else if (temp.data == x) {
                equalTail.next = temp;
                equalTail = temp;
            }
            else {
                greatTail.next = temp;
                greatTail = temp;
            }

            temp = next;
        }

        // less → equal
        lessTail.next = equalHead.next;

        // equal → greater
        if (equalHead.next != null) {
            equalTail.next = greatHead.next;
        }
        else {
            // no equal nodes
            lessTail.next = greatHead.next;
        }

        // Return first non-empty partition
        if (lessHead.next != null) {
            return lessHead.next;
        }

        if (equalHead.next != null) {
            return equalHead.next;
        }

        return greatHead.next;
    }
}
```

## Complexity

```text
Time:  O(n)
Space: O(1) extra
```

---

# Both Problems — Comparison

| Concept | Reverse K-Group | Partition List |
|---|---|---|
| Main task | Reverse fixed-size segments | Separate nodes by value |
| Main structure | One group at a time | Three chains |
| Important boundary | `beforeGroup`, `afterGroup` | Head/tail of each chain |
| Important save | `next` | `next` |
| Main pointer pattern | Reverse links | Append to tails |
| Dummy useful? | Yes | Yes |
| Final reconnection | Previous part → reversed group | less → equal → greater |
| Main danger | Old head vs new head | Broken links / wrong result head |
| Time | O(n) | O(n) |
| Extra space | O(1) | O(1) extra |

---

# Universal Linked-List Rules

1. Before changing `current.next`, ask whether the old `next` must be saved.
2. Always know exactly what each pointer represents.
3. Identify segment boundaries before modifying links.
4. After reversal, remember: old head becomes new tail.
5. Return the actual new head, not automatically the original `head`.
6. Test empty lists, one node, exact boundaries, and skipped/empty groups.
7. Draw the pointers when the code becomes confusing.

## One-line memory

```text
SAVE THE FUTURE → CHANGE THE LINK → MOVE THE POINTER
```
