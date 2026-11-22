# Linked List — Pattern 6

## Intersection, Palindrome & Duplicate Removal

These notes follow your submitted Java solutions, with pointer dry runs and important edge cases.

---

## 1. Intersection of Two Linked Lists — LC 160

### Your code

```java
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null && headB == null) {
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;
        while (a != null && b != null) {
            a = a.next;
            b = b.next;
        }
        if (a != null) {
            int extraLenA = 0;
            while (a != null) {
                extraLenA++;
                a = a.next;
            }
            while (extraLenA != 0) {
                extraLenA--;
                headA = headA.next;
            }
        } else {
            int extraLenB = 0;
            while (b != null) {
                extraLenB++;
                b = b.next;
            }
            while (extraLenB != 0) {
                extraLenB--;
                headB = headB.next;
            }
        }

        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            } else {
                headA = headA.next;
                headB = headB.next;
            }
        }
        return null;
    }
}
```

### How your logic works

Intersection means both lists reach the **same node object**, not just nodes with the same value.

Your algorithm:

1. Move `a` and `b` together until one reaches `null`.
2. Count how many nodes remain in the longer list.
3. Move that list's original head forward by the extra count.
4. Compare `headA` and `headB` simultaneously.

### Dry run

Suppose the lists share the exact node chain starting at `8`:

```text
A: 4A -> 1A ----------------> 8 -> 4 -> 5 -> null
B: 5B -> 6B -> 1B ---------/
```

A has 5 nodes and B has 6.

After advancing `a` and `b` together until A ends:

```text
a = null
b = last node (5)
extraLenB = 1
```

Move `headB` forward one node to align the remaining lengths.

| Step | `headA` | `headB` | Same node object?                |
| ---- | ------- | ------- | -------------------------------- |
| 1    | `4A`    | `6B`    | No                               |
| 2    | `1A`    | `1B`    | No — same value, different nodes |
| 3    | `8`     | `8`     | Yes — return this node           |

### Remember

- `headA == headB` compares node identity. Comparing only `.val` would be incorrect.
- Your code handles a single `null` head and returns `null`, but it needlessly traverses the other list. An early check using `headA == null || headB == null` would make that case clearer.
- **Time:** O(m + n). **Extra space:** O(1).

---

## 2. Palindrome Linked List — LC 234

### Your code

```java
class Solution {
    public ListNode mid(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null){
            fast = fast.next;
            if(fast != null){
                fast = fast.next;
                slow = slow.next;
            }
        }
        return slow;
    }
    public ListNode revLL(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        while(curr != null){
            ListNode fwd = curr.next;
            curr.next = prev;
            prev = curr;
            curr = fwd;
        }
        return prev;
    }
    public boolean isPalindrome(ListNode head) {
        if(head == null){
            return false;
        }
        if(head.next == null){
            return true;
        }
        ListNode midNode = mid(head);
        ListNode temp = head;
        while(temp.next != midNode){
            temp = temp.next;
        }
        temp.next = null;
        ListNode head2 = revLL(midNode);
        ListNode l1 = head;
        ListNode l2 = head2;
        while(l1 != null && l2 != null){
            if(l1.val != l2.val){
                return false;
            }else{
                l1 = l1.next;
                l2 = l2.next;
            }
        }
        return true;
    }
}
```

### How your logic works

1. `mid()` finds the middle node.
2. `temp` finds the node just before the middle.
3. `temp.next = null` separates the list.
4. `revLL(midNode)` reverses the right section.
5. Compare `l1` and `l2`. A mismatch means `false`; otherwise, return `true`.

### Dry run — odd-length list

Input:

```text
1 -> 2 -> 3 -> 2 -> 1 -> null
```

Your `mid()` returns the centre node `3`. After cutting the link before it:

```text
Left half:   1 -> 2 -> null
Right half:  3 -> 2 -> 1 -> null
```

After reversing the right half:

```text
l1: 1 -> 2 -> null
l2: 1 -> 2 -> 3 -> null
```

| Comparison | `l1.val` | `l2.val` | Result                           |
| ---------- | -------: | -------: | -------------------------------- |
| 1          |        1 |        1 | Match                            |
| 2          |        2 |        2 | Match                            |
| End        |   `null` |        3 | Stop; all mirrored pairs matched |

The extra centre node is not compared. That's okay because it has no mirrored partner.

### Important observations

- Your code returns `false` for `head == null`. Standard LC 234 constraints use a non-empty list; logically, an empty list is usually considered a palindrome too.
- **Your implementation modifies the original list:** it cuts a link and reverses the right half without restoring it. A mismatch also returns while the list remains modified.
- **Time:** O(n). **Extra space:** O(1).

---

## 3. Remove Duplicates from Sorted List — LC 83

### Your code

```java
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode i = head;
        ListNode j = head;
        while (j != null) {
            if (i.val == j.val)
                j = j.next;
            else {
                i.next = j;
                i = j;
            }

        }
        if(i == null) return null;
        i.next = j;
        return head;
    }
}
```

### How your logic works

Because the list is sorted, duplicate values are adjacent.

- `i` marks the last node kept in the result.
- `j` scans forward.
- If their values match, move `j` forward.
- If their values differ, link `i.next = j` and move `i = j`.
- At the end, `i.next = j` disconnects the trailing duplicates by setting the last kept node's next link to `null`.

### Dry run

Input:

```text
1 -> 1 -> 2 -> 3 -> 3 -> null
```

| Situation | `i.val` | `j.val` | Action                                      |
| --------- | ------: | ------: | ------------------------------------------- |
| Start     |       1 |       1 | Equal; advance `j`                          |
| Next      |       1 |       2 | Link `1.next` to `2`; move `i` to `2`       |
| Next      |       2 |       2 | Equal; advance `j`                          |
| Next      |       2 |       3 | Link `2.next` to `3`; move `i` to first `3` |
| Next      |       3 |       3 | Advance `j` past the duplicate              |
| End       |       3 |  `null` | Set `i.next = null`                         |

Result:

```text
1 -> 2 -> 3 -> null
```

### Remember

- LC 83 **keeps one copy** of every value.
- `1 -> 1 -> 2` becomes `1 -> 2`.
- The list must be sorted.
- The `if (i == null)` check is harmless but unnecessary for your implementation; an empty input is already handled.
- **Time:** O(n). **Extra space:** O(1).

---

## 4. Remove Duplicates from Sorted List II — LC 82

### Your code

```java
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode t = dummy;
        ListNode i = head;
        while(i != null){
            if(i.next == null || i.val != i.next.val){
                t.next = i;
                t = i;
                i = i.next;
            }else{//i.val == i.next.val
                    ListNode j = i.next;
                    while(j!=null && j.val == i.val){
                        j = j.next;
                    }
                    i=j;
            }

        }
          t.next = i;
            return dummy.next;
    }
}
```

### How your logic works

Here the requirement is different: **remove every value that occurs more than once**.

- `dummy` handles cases where the first group must be removed.
- `t` is the tail of the result built so far.
- `i` checks the current value.
- If `i` is unique, attach it with `t.next = i`, then advance `t` and `i`.
- If the value repeats, `j` skips the entire group of equal values, and `i = j` continues after that group.
- `t.next = i` finalizes the output link.

### Dry run

Input:

```text
1 -> 2 -> 3 -> 3 -> 4 -> 4 -> 5 -> null
```

```text
Start:       dummy -> null; i = 1
Keep 1:      dummy -> 1;    t = 1, i = 2
Keep 2:      dummy -> 1 -> 2; t = 2, i = 3
Skip 3, 3:   j skips both 3 nodes; i moves to 4
Skip 4, 4:   j skips both 4 nodes; i moves to 5
Keep 5:      dummy -> 1 -> 2 -> 5; t = 5, i = null
Finish:      t.next = null
```

Result:

```text
1 -> 2 -> 5 -> null
```

Another important case:

```text
Input:  1 -> 1 -> 2 -> null
```

Both `1` nodes are skipped, and `2` is kept.

```text
Output: 2 -> null
```

### Remember

- LC 82 removes the **whole duplicate group**.
- `1 -> 1 -> 2` becomes `2`, not `1 -> 2`.
- `dummy` is essential when duplicates start at the head.
- The list must be sorted.
- **Time:** O(n). **Extra space:** O(1).

---

## Quick revision table

| Problem                      | Pattern                                | What remains?                   |
| ---------------------------- | -------------------------------------- | ------------------------------- |
| LC 160 — Intersection        | Align lengths; compare node references | First shared node, or `null`    |
| LC 234 — Palindrome          | Find middle; reverse half; compare     | Boolean result                  |
| LC 83 — Duplicate removal I  | Keep one node per value                | One copy of each distinct value |
| LC 82 — Duplicate removal II | Skip repeated-value groups             | Only values occurring once      |

## Interview checklist

- **Intersection:** equal values do not prove intersection; both pointers must reference the same node.
- **Palindrome:** split, reverse one half, compare mirrored values. Know that your code changes the input list.
- **LC 83:** keep one copy from each sorted duplicate group.
- **LC 82:** remove the whole group whenever a value repeats.
