# Linked List — Pattern 4: Reversal & Reversing Groups

## 1. Reverse Linked List — Iterative

**Your code — LeetCode 206 / Code360 / GFG**

```java
public ListNode reverseList(ListNode head) {
    ListNode prev = null;
    ListNode curr = head;

    while (curr != null) {
        ListNode fwd = curr.next;
        curr.next = prev;
        prev = curr;
        curr = fwd;
    }
    return prev;
}
```

### Dry run

Input: `1 → 2 → 3 → null`

| Round | `curr` | `fwd` saved | Link changed | After moving |
|---|---|---|---|---|
| 1 | 1 | 2 | `1.next = null` | `prev=1`, `curr=2` |
| 2 | 2 | 3 | `2.next = 1` | `prev=2`, `curr=3` |
| 3 | 3 | null | `3.next = 2` | `prev=3`, `curr=null` |

Result:

```text
Before: 1 → 2 → 3 → null
After:  3 → 2 → 1 → null
```

Remember: **SAVE `fwd` → CHANGE `curr.next` → MOVE `prev` → MOVE `curr`.**

---

## 2. Reverse Linked List — Recursive

**Your code**

```java
public ListNode solve(ListNode curr, ListNode prev) {
    if (curr == null) {
        return prev;
    }

    ListNode fwd = curr.next;
    curr.next = prev;
    prev = curr;
    curr = fwd;

    return solve(curr, prev);
}

public ListNode reverseList(ListNode head) {
    ListNode prev = null;
    ListNode curr = head;
    return solve(curr, prev);
}
```

### Dry run

Input: `1 → 2 → 3 → null`

| Call | `curr` | Reversed part (`prev`) | Next call |
|---|---|---|---|
| 1 | 1 | `1 → null` | `solve(2, 1)` |
| 2 | 2 | `2 → 1 → null` | `solve(3, 2)` |
| 3 | 3 | `3 → 2 → 1 → null` | `solve(null, 3)` |
| 4 | null | Base case | Return node 3 |

The final returned head is node `3`.

Time: `O(n)`. Recursive call-stack space: `O(n)`.

---

## 3. Reverse Between Positions — LeetCode 92

**Your code**

```java
public ListNode reverse(ListNode head) {
    ListNode curr = head;
    ListNode prev = null;

    while (curr != null) {
        ListNode fwd = curr.next;
        curr.next = prev;
        prev = curr;
        curr = fwd;
    }
    return prev;
}

public ListNode reverseBetween(ListNode head, int left, int right) {
    ListNode temp = head;
    ListNode prevTemp = null;

    for (int i = 1; i < left; i++) {
        prevTemp = temp;
        temp = temp.next;
    }

    ListNode newHead = temp;
    ListNode newTail = temp;

    for (int i = left; i < right; i++) {
        newTail = newTail.next;
    }

    ListNode nextRight = newTail.next;
    newTail.next = null;

    ListNode revHead = reverse(newHead);

    if (prevTemp != null) {
        prevTemp.next = revHead;
    } else {
        head = revHead;
    }

    newHead.next = nextRight;
    return head;
}
```

### Dry run

Input: `1 → 2 → 3 → 4 → 5`, `left = 2`, `right = 4`.

**Step 1 — Find the section**

```text
prevTemp
   ↓
   1 → 2 → 3 → 4 → 5
       ↑       ↑
    newHead  newTail
```

`prevTemp` points to `1`, `newHead` to `2`, and `newTail` to `4`.

**Step 2 — Save the remaining list**

```java
ListNode nextRight = newTail.next;
newTail.next = null;
```

Now `nextRight` points to `5`, and the selected section is separated:

```text
1 → 2 → 3 → 4 → null

5 → null
```

**Step 3 — Reverse the selected section**

```text
2 → 3 → 4
      ↓ reverse
4 → 3 → 2
```

**Step 4 — Reconnect both ends**

```java
prevTemp.next = revHead;
newHead.next = nextRight;
```

Here, `newHead` still points to node `2`, which has become the tail of the reversed section.

Final result:

```text
1 → 4 → 3 → 2 → 5 → null
```

---

## 4. Reverse Nodes in K-Group — Recursive

**Your code — LeetCode 25**

```java
public ListNode reverseKGroup(ListNode head, int k) {
    ListNode dummy = new ListNode(-1);
    dummy.next = head;
    ListNode prevTail = dummy;

    if (prevTail.next == null || head.next == null || k <= 1) {
        return dummy.next;
    }

    ListNode kthNode = prevTail;
    for (int i = 1; i <= k; i++) {
        if (kthNode != null) {
            kthNode = kthNode.next;
        }
    }

    if (kthNode == null) {
        return dummy.next;
    }

    ListNode prevGroupHead = prevTail.next;
    ListNode nextGroupHead = kthNode.next;
    ListNode curr = prevGroupHead;
    ListNode prev = nextGroupHead;

    while (curr != nextGroupHead) {
        ListNode fwd = curr.next;
        curr.next = prev;
        prev = curr;
        curr = fwd;
    }

    ListNode recResult = reverseKGroup(nextGroupHead, k);
    prevGroupHead.next = recResult;
    return prev;
}
```

### Dry run

Input: `1 → 2 → 3 → 4 → 5`, `k = 2`.

**First group: `1, 2`**

```text
prevGroupHead = 1
nextGroupHead = 3
prev = 3

Before: 1 → 2 → 3 → 4 → 5
After:  2 → 1 → 3 → 4 → 5
```

Because `prev` starts at `nextGroupHead`, the reversed group connects to the remaining list automatically.

**Recursive call:** `reverseKGroup(3, 2)` reverses `3, 4`.

```text
2 → 1 → 4 → 3 → 5
```

The final group contains only `5`, fewer than `k`, so your base check returns it unchanged.

Final result:

```text
2 → 1 → 4 → 3 → 5
```

---

## 5. Reverse Groups According to Array `b`

**Your code — Code360**

```java
public static Node getListAfterReverseOperation(
        Node head, int n, int b[]) {

    Node curr = head;
    Node prevGrpTail = null;
    Node nHead = head;

    for (int k = 0; k < b.length; k++) {
        if (curr != null) {
            if (b[k] == 0) {
                continue;
            }

            Node groupHead = curr;
            Node prev = null;
            int count = 0;

            while (curr != null && b[k] > count) {
                Node fwd = curr.next;
                curr.next = prev;
                prev = curr;
                curr = fwd;
                count++;
            }

            if (prevGrpTail == null) {
                nHead = prev;
            } else {
                prevGrpTail.next = prev;
            }

            prevGrpTail = groupHead;
            prevGrpTail.next = curr;

            if (b[k] > count) {
                break;
            }
        }
    }
    return nHead;
}
```

### Dry run

Input: `1 → 2 → 3 → 4 → 5`, `b = [2, 3]`.

**First instruction: `b[0] = 2`**

Reverse the first two nodes:

```text
Before: 1 → 2 → 3 → 4 → 5
After:  2 → 1 → 3 → 4 → 5
              ↑
            curr
```

Node `1` was the old group head and is now the group tail.

**Second instruction: `b[1] = 3`**

Reverse the next three nodes:

```text
Before this group: 3 → 4 → 5
After reversal:    5 → 4 → 3
```

Connect the previous group tail (`1`) to the new group head (`5`).

Final result:

```text
2 → 1 → 5 → 4 → 3 → null
```

`b[k] == 0` skips that instruction without reversing any nodes.

---

## 6. Reverse Nodes in K-Group — Iterative

**Your code — Code360**

```java
public static Node kReverse(Node head, int k) {
    if (head == null || head.next == null || k <= 1) {
        return head;
    }

    Node dummy = new Node(-1);
    dummy.next = head;
    Node beforeGroup = dummy;

    while (beforeGroup.next != null) {
        Node kThNode = beforeGroup;

        for (int i = 1; i <= k; i++) {
            kThNode = kThNode.next;
            if (kThNode == null) {
                return dummy.next;
            }
        }

        Node startGroup = beforeGroup.next;
        Node afterGroup = kThNode.next;

        Node curr = startGroup;
        Node prev = afterGroup;

        while (curr != afterGroup) {
            Node fwd = curr.next;
            curr.next = prev;
            prev = curr;
            curr = fwd;
        }

        beforeGroup.next = prev;
        beforeGroup = startGroup;
    }

    return dummy.next;
}
```

### Dry run

Input: `1 → 2 → 3 → 4 → 5`, `k = 2`.

**Group 1**

`startGroup = 1`, `afterGroup = 3`.

Reverse nodes `1, 2`:

```text
2 → 1 → 3 → 4 → 5
```

Then `beforeGroup = startGroup`, so `beforeGroup` points to node `1`, the new tail.

**Group 2**

The next group is `3, 4`. Reverse them and connect node `1` to node `4`:

```text
2 → 1 → 4 → 3 → 5
```

Only one node (`5`) remains, so fewer than `k` nodes are available. Your method returns the list with this remainder unchanged.

Final result:

```text
2 → 1 → 4 → 3 → 5
```

Your recursive LeetCode version and this iterative Code360 version share the same grouping rule; the main difference is how the next group is processed.

---

## 7. Reverse Alternate K Nodes

**Your code**

```java
public static Node reverseAlternateKNodes(Node head, int k) {
    Node dummy = new Node(-1);
    dummy.next = head;
    Node prevGrpTail = dummy;
    boolean isReverse = true;

    while (prevGrpTail.next != null) {
        Node kthNode = prevGrpTail;
        boolean complete = true;

        for (int i = 1; i <= k; i++) {
            if (kthNode.next == null) {
                complete = false;
                break;
            }
            kthNode = kthNode.next;
        }

        Node groupStart = prevGrpTail.next;
        Node nextGroup = kthNode.next;

        if (isReverse) {
            Node prev = nextGroup;
            Node curr = groupStart;

            while (curr != nextGroup) {
                Node fwd = curr.next;
                curr.next = prev;
                prev = curr;
                curr = fwd;
            }

            prevGrpTail.next = prev;
            prevGrpTail = groupStart;
        } else {
            prevGrpTail = kthNode;
        }

        isReverse = !isReverse;
    }
    return dummy.next;
}
```

### Dry run

Input: `1 → 2 → 3 → 4 → 5 → 6`, `k = 2`.

| Group | `isReverse` | Action | List |
|---|---|---|---|
| `1, 2` | `true` | Reverse | `2 → 1 → 3 → 4 → 5 → 6` |
| `3, 4` | `false` | Keep order | `2 → 1 → 3 → 4 → 5 → 6` |
| `5, 6` | `true` | Reverse | `2 → 1 → 3 → 4 → 6 → 5` |

Final result:

```text
2 → 1 → 3 → 4 → 6 → 5
```

`prevGrpTail` always identifies where the next group begins relative to the already-processed part. `isReverse` decides whether the current group is reversed or skipped.

---

## 8. Reverse Even Length Groups

**Your code — LeetCode 2074**

```java
public ListNode reverseEvenLengthGroups(ListNode head) {
    int expectedGroupSize = 1;
    return reverseEvenLengthGroupsHelper(head, expectedGroupSize);
}

public ListNode reverseEvenLengthGroupsHelper(
        ListNode head, int expectedGroupSize) {

    if (head == null || head.next == null) {
        return head;
    }

    ListNode prevTail = null;
    ListNode currNode = head;
    int actualGroupSize = 0;

    for (int i = 1;
         i <= expectedGroupSize && currNode != null; i++) {
        prevTail = currNode;
        actualGroupSize++;
        currNode = currNode.next;
    }

    ListNode oldGroupHead = head;
    ListNode newGroupHead = currNode;
    ListNode groupHead = head;

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
        prevTail = oldGroupHead;
    }

    ListNode recAns = reverseEvenLengthGroupsHelper(
        newGroupHead, expectedGroupSize + 1);

    prevTail.next = recAns;
    return groupHead;
}
```

### Dry run

Input: `1 → 2 → 3 → 4 → 5 → 6`.

| Expected group size | Actual group | Actual size | Action |
|---:|---|---:|---|
| 1 | `1` | 1 | Keep |
| 2 | `2 → 3` | 2 | Reverse |
| 3 | `4 → 5 → 6` | 3 | Keep |

Result:

```text
1 → 3 → 2 → 4 → 5 → 6
```

The final group is decided by its **actual size**, not just its expected size.

---

## 9. Reverse Doubly Linked List in Groups

**Your supplied method stub, completed using your group-reversal approach**

```java
public class Solution {
    public static Node reverseDLLInGroups(Node head, int k) {
        if (head == null || k <= 1) {
            return head;
        }

        Node curr = head;
        Node newHead = null;
        Node prevGroupTail = null;

        while (curr != null) {
            Node groupHead = curr;
            Node prev = null;
            int count = 0;

            while (curr != null && count < k) {
                Node fwd = curr.next;

                curr.next = prev;
                curr.prev = fwd;

                prev = curr;
                curr = fwd;
                count++;
            }

            if (newHead == null) {
                newHead = prev;
            }

            if (prevGroupTail != null) {
                prevGroupTail.next = prev;
                prev.prev = prevGroupTail;
            } else {
                prev.prev = null;
            }

            groupHead.next = curr;

            if (curr != null) {
                curr.prev = groupHead;
            }

            prevGroupTail = groupHead;
        }

        return newHead;
    }
}
```

### Dry run

Input: `1 ⇄ 2 ⇄ 3 ⇄ 4 ⇄ 5`, `k = 2`.

**Group 1: nodes `1, 2`**

After reversing, node `2` becomes the head and node `1` becomes the tail.

```text
2 ⇄ 1 → 3 ⇄ 4 ⇄ 5
```

Both links matter:
- `2.next = 1`
- `1.prev = 2`

**Group 2: nodes `3, 4`**

Reverse the next two nodes, then connect node `1` to node `4`.

```text
2 ⇄ 1 ⇄ 4 ⇄ 3 → 5
```

The connecting links are:
- `1.next = 4`
- `4.prev = 1`
- `3.next = 5`
- `5.prev = 3`

**Final group: node `5`**

The one-node group remains unchanged.

Final result:

```text
2 ⇄ 1 ⇄ 4 ⇄ 3 ⇄ 5
```

This method reverses the final partial group too. The important difference from a singly linked list is that the `prev` links must also be repaired.

---

## Quick Recall

```text
Full reverse:
SAVE fwd → CHANGE curr.next → MOVE prev → MOVE curr

Reverse a section:
Save the node after the section.
Reverse the section.
Reconnect the previous node and the saved remainder.

K-group:
Find the group boundary.
Reverse only that group.
Reconnect the old group head as the new group tail.

Doubly linked group:
Reverse next links.
Repair prev links.
Reconnect both group boundaries.
```

**Next pattern:** Cycle detection, cycle entry, cycle length, and cycle removal.
