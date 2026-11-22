# Linked List — Pattern 3: Two Pointers & Fixed Gap

Your submitted code and short dry runs only. No duplicate alternative solutions are added.

## 1. Middle of Linked List — Recursive (LeetCode 876)

```java
class Solution {
    public ListNode solve(ListNode slow, ListNode fast) {
        if (fast == null || fast.next == null) {
            return slow;
        }

        slow = slow.next;
        fast = fast.next.next;
        return solve(slow, fast);
    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = slow;
        return solve(slow, fast);
    }
}
```

### Dry run: `1 → 2 → 3 → 4 → 5`

| Call | `slow` | `fast` | What happens |
|---|---:|---:|---|
| Start | 1 | 1 | Move slow to 2, fast to 3 |
| Next | 2 | 3 | Move slow to 3, fast to 5 |
| Next | 3 | 5 | `fast.next == null`, so return `slow` |

Returns node `3`.

**Remember:** the base case is checked before moving. `fast == null || fast.next == null` means `slow` is at the middle. For even-length lists, this returns the **second middle**. Empty input returns `null`.

## 2. Find Middle — Iterative (GFG-style)

```java
public static Node findMiddle(Node head) {
    Node slow = head;
    Node fast = head;

    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }
    return slow;
}
```

### Dry run: `10 → 20 → 30 → 40`

| Iteration | `slow` after move | `fast` after move |
|---|---:|---:|
| Start | 10 | 10 |
| 1 | 20 | 30 |
| 2 | 30 | `null` |

Returns node `30`, the **second middle** for an even number of nodes.

## 3. Split List into Parts (LeetCode 725)

```java
class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] ans = new ListNode[k];
        ListNode temp = head;
        int len = 0;

        while (temp != null) {
            len++;
            temp = temp.next;
        }

        int size = len / k;
        int extraLen = len % k;
        ListNode curr = head;
        ListNode prev = null;

        for (int part = 0; part < k; part++) {
            if (curr == null) {
                ans[part] = null;
                continue;
            }

            ans[part] = curr;
            int sizeOfEachPart = size + (extraLen > 0 ? 1 : 0);
            extraLen--;

            for (int i = 1; i <= sizeOfEachPart; i++) {
                prev = curr;
                curr = curr.next;
            }

            prev.next = null;
            prev = curr;
        }
        return ans;
    }
}
```

### Dry run: `1 → 2 → 3 → 4 → 5`, `k = 3`

- `len = 5`, `size = 5 / 3 = 1`, `extraLen = 5 % 3 = 2`.
- First part gets `size + 1 = 2` nodes: `1 → 2`; set `2.next = null`.
- Second part gets `2` nodes: `3 → 4`; set `4.next = null`.
- Third part gets `1` node: `5`; set `5.next = null`.

Result: `[1 → 2, 3 → 4, 5]`.

## 4. Remove Nth Node from End (LeetCode 19)

```java
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode curr = head;
        for (int i = 1; i <= n; i++) {
            curr = curr.next;
        }

        if (curr == null) {
            return head.next;
        }

        curr = curr.next;
        ListNode prev = head;

        while (curr != null) {
            curr = curr.next;
            prev = prev.next;
        }

        prev.next = prev.next.next;
        return head;
    }
}
```

### Dry run: `1 → 2 → 3 → 4 → 5`, `n = 2`

- Move `curr` forward 2 steps: it reaches node `3`.
- `curr = curr.next`: now `curr` is node `4`; `prev` is still node `1`.
- Move both one step until `curr == null`: `prev` reaches node `3`.
- `prev.next = prev.next.next` skips node `4`.

Result: `1 → 2 → 3 → 5`.

**Boundary note:** this code assumes `n` is valid. The early return for a one-node list also assumes that the valid request is to remove that only node.

## 5. Kth Node from Last — Code360-style (`findKthFromLast`)

```java
public static Node findKthFromLast(Node head, int K) {
    Node slow = head;
    Node fast = head;

    for (int i = 1; i <= K; i++) {
        // if (fast == null) return -1;
        fast = fast.next;
    }

    while (fast != null) {
        slow = slow.next;
        fast = fast.next;
    }
    return slow;
}
```

### Dry run: `10 → 20 → 30 → 40 → 50`, `K = 2`

- Advance `fast` 2 steps: it points to `30`; `slow` stays at `10`.
- Move both together until `fast == null`.
- `slow` moves `10 → 20 → 30 → 40`.

Returns node `40`, the second node from the end.

**Boundary note:** the guard in your code is commented out. It assumes `K` does not exceed the list length.

## 6. Kth Node from Last — GFG-style (`getKthFromLast`)

```java
int getKthFromLast(Node head, int k) {
    Node slow = head;
    Node fast = head;

    for (int i = 1; i <= k; i++) {
        if (fast == null) return -1;
        fast = fast.next;
    }

    while (fast != null) {
        slow = slow.next;
        fast = fast.next;
    }
    return slow.data;
}
```

### Dry run: `10 → 20 → 30 → 40 → 50`, `k = 2`

- `fast` advances to node `30` while `slow` stays at `10`.
- Both move together until `fast` reaches `null`.
- `slow` points to node `40`, so the method returns `40`.

Difference from the previous method: this one checks whether `fast` is `null` before each initial step and returns `-1` when `k` is too large.

## 7. Remove Kth Node from End — Code360-style (`removeKthNode`)

```java
public static Node removeKthNode(Node head, int K) {
    if (head == null) {
        return null;
    }

    Node curr = head;
    for (int i = 1; i <= K; i++) {
        curr = curr.next;
    }

    if (curr == null) {
        return head.next;
    }

    Node prev = head;
    while (curr.next != null) {
        curr = curr.next;
        prev = prev.next;
    }

    prev.next = prev.next.next;
    return head;
}
```

### Dry run: `10 → 20 → 30 → 40 → 50`, `K = 2`

- Move `curr` 2 steps: it reaches `30`; `prev` stays at `10`.
- Move both pointers until `curr` reaches the tail (`50`). At that point, `prev` is `30`.
- `prev.next = prev.next.next` makes `30` point to `50`, bypassing `40`.

Result: `10 → 20 → 30 → 50`.

**Boundary note:** the initial loop assumes `K` is within the list length. If `K` is larger, `curr.next` can be accessed when `curr` is `null`.

## 8. Critical Points (LeetCode 2058)

```java
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if (head == null || head.next == null) {
            return new int[] {-1, -1};
        }

        ListNode curr = head.next;
        ListNode prev = head;
        int i = 1;
        List<Integer> criticalPoint = new ArrayList<>();

        while (curr != null && curr.next != null) {
            if (prev.val > curr.val && curr.val < curr.next.val) {
                criticalPoint.add(i);
            }
            if (prev.val < curr.val && curr.val > curr.next.val) {
                criticalPoint.add(i);
            }

            curr = curr.next;
            prev = prev.next;
            i = i + 1;
        }

        if (criticalPoint.size() < 2) {
            return new int[] {-1, -1};
        }

        int minDist = Integer.MAX_VALUE;
        for (int j = 1; j < criticalPoint.size(); j++) {
            minDist = Math.min(
                minDist,
                criticalPoint.get(j) - criticalPoint.get(j - 1)
            );
        }

        int maxDist = criticalPoint.get(criticalPoint.size() - 1)
                    - criticalPoint.get(0);
        return new int[] {minDist, maxDist};
    }
}
```

### Dry run: values `5 → 3 → 1 → 2 → 5 → 1`

- The `1` at position `3` is a local minimum: `3 > 1 < 2`.
- The `5` at position `5` is a local maximum: `2 < 5 > 1`.
- There are exactly two critical points, and their distance is `5 - 3 = 2`.

Result: `[2, 2]`.

Your counter starts at `1` for the second node, so the stored positions are each shifted by one. The distances still come out correctly because the same shift cancels when positions are subtracted.

## Quick recall

- **Middle:** `slow` moves 1 step; `fast` moves 2 steps.
- **Kth from end:** create a gap of `K` steps first, then move both pointers together.
- **Remove Nth/Kth from end:** after positioning the pointers, bypass the target with `prev.next = prev.next.next`.
- **Split into parts:** `size = len / k`; the first `len % k` parts get one extra node.
- **Critical points:** only internal nodes can be critical; compare `prev`, `curr`, and `curr.next`.

**Not included:** Kth node from the beginning, because its code was not in the submissions you sent.
