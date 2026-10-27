# Linked List — Pattern 5: Cycle Detection, Entry, Length & Removal

## 1. Linked List Cycle — LeetCode 141

### Your code

```java
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null) {
            fast = fast.next;

            if (fast != null) {
                fast = fast.next;
                slow = slow.next;
            }

            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
```

### Why does slow and fast work?

Imagine two people moving around a circular track. One moves one step per turn; the other moves two steps.

The faster one gains **one node per turn** on the slower one. If the list contains a cycle, the faster pointer eventually catches the slower pointer inside that cycle.

If there is no cycle, `fast` eventually reaches `null`.

### Dry run — cycle exists

Suppose the list is:

```text
1 → 2 → 3 → 4 → 5
        ↑       |
        └───────┘

5.next = 3
```

Your code moves `fast` twice and `slow` once in each successful iteration.

| Round | `slow` | `fast` | What happens?        |
| ----- | -----: | -----: | -------------------- |
| Start |      1 |      1 | Both start at head   |
| 1     |      2 |      3 | Not equal            |
| 2     |      3 |      5 | Not equal            |
| 3     |      4 |      4 | Equal, return `true` |

The pointers meet at node `4`. Notice that this is **not necessarily the node where the cycle begins**.

### Dry run — no cycle

```text
1 → 2 → 3 → null
```

- First round: `slow = 2`, `fast = 3`.
- Next round: `fast` reaches `null`.
- The loop ends and the method returns `false`.

### Interview explanation

“I use two pointers moving at different speeds. If there is a cycle, the faster pointer eventually catches the slower pointer. If the faster pointer reaches `null`, no cycle exists.”

**Complexity:** Time `O(n)`, extra space `O(1)`.

---

## 2. Find the Cycle Entry — LeetCode 142

### Your code

```java
public ListNode detectCycle(ListNode head) {
    Map<ListNode, Boolean> map = new HashMap<>();
    ListNode curr = head;

    while (curr != null) {
        if (map.containsKey(curr)) {
            return curr;
        }

        map.put(curr, true);
        curr = curr.next;
    }

    return null;
}
```

### How it works

You store each node reference when you visit it.

- First visit: store the node.
- Reaching a previously stored node: return it.
- Reaching `null`: no cycle exists, so return `null`.

Because the method stores the **node reference**, not just its value, two different nodes with the same value are still treated as different nodes.

### Dry run

Use this list:

```text
1 → 2 → 3 → 4 → 5
        ↑       |
        └───────┘
```

| Step | `curr` | Action                                  |
| ---- | -----: | --------------------------------------- |
| 1    |      1 | Store node 1                            |
| 2    |      2 | Store node 2                            |
| 3    |      3 | Store node 3                            |
| 4    |      4 | Store node 4                            |
| 5    |      5 | Store node 5                            |
| 6    |      3 | Node 3 is already stored; return node 3 |

The returned node is the cycle entry.

**Complexity:** Time `O(n)`, extra space `O(n)`.

### Interview explanation

“I store visited node references in a map. The first node I encounter again is the cycle entry. This is easy to understand but requires extra memory.”

---

## 3. Detect Loop — GFG

### Your code

```java
class Solution {
    public boolean detectLoop(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
```

This is the same Floyd slow/fast technique as Problem 1, written using GFG's `Node` class and the usual loop condition.

### Dry run

```text
1 → 2 → 3 → 4 → 5
        ↑       |
        └───────┘
```

| Round | `slow` moves to | `fast` moves to | Result               |
| ----- | --------------: | --------------: | -------------------- |
| 1     |               2 |               3 | Different            |
| 2     |               3 |               5 | Different            |
| 3     |               4 |               4 | Same — return `true` |

**Complexity:** Time `O(n)`, extra space `O(1)`.

---

## 4. Count Nodes in a Loop — GFG / Custom

You haven't solved this one yet. This uses the same slow/fast method you already know, then counts one complete trip around the cycle.

### Code

```java
public static int length(Node head) {
    Node slow = head;
    Node fast = head;

    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;

        if (slow == fast) {
            int count = 1;
            Node temp = slow.next;

            while (temp != slow) {
                count++;
                temp = temp.next;
            }

            return count;
        }
    }

    return 0;
}
```

This version returns `0` when there is no loop. Check the required return convention if your platform specifies a different one.

### Dry run

```text
1 → 2 → 3 → 4 → 5
        ↑       |
        └───────┘
```

The cycle consists of `3 → 4 → 5 → 3`.

Suppose `slow` and `fast` meet at node `4`.

| Step  |                 `temp` |  `count` |
| ----- | ---------------------: | -------: |
| Start |                      5 |        1 |
| Move  |                      3 |        2 |
| Move  |                      4 |        3 |
| Stop  | Back at meeting node 4 | Return 3 |

Why does this count the cycle? We start with one node counted, then keep moving until we return to the exact same node where counting began.

**Complexity:** Time `O(n)` overall, extra space `O(1)`.

---

## 5. Detect and Remove Loop — GFG / Code360-style

### Your code

```java
public static Node removeLoop(Node head) {
    Node slow = head;
    Node fast = head;
    boolean isLoopExist = false;

    while (fast != null) {
        fast = fast.next;

        if (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        if (slow == fast) {
            isLoopExist = true;
            break;
        }
    }

    if (!isLoopExist) {
        return head;
    }

    slow = head;

    if (slow == fast) {
        while (fast.next != slow) {
            fast = fast.next;
        }
    } else {
        while (fast.next != slow.next) {
            slow = slow.next;
            fast = fast.next;
        }
    }

    fast.next = null;
    return head;
}
```

### Practical idea

Removing a loop means finding the **last node inside the cycle** and changing its `next` to `null`.

Your code first detects the meeting point. Then it finds the link that closes the cycle and breaks that link.

### Dry run

Input:

```text
1 → 2 → 3 → 4 → 5
        ↑       |
        └───────┘

5.next = 3
```

**Step 1 — Detect the loop**

Your pointers meet at node `4` in this example.

**Step 2 — Reset `slow` to the head**

```text
slow = 1
fast = 4
```

Because they are different, your code advances both pointers until their `next` references point to the same node.

| Round | `slow` | `fast` | `slow.next` | `fast.next` |
| ----- | -----: | -----: | ----------: | ----------: |
| Start |      1 |      4 |           2 |           5 |
| 1     |      2 |      5 |           3 |           3 |

Now `slow.next == fast.next`, so node `2` and node `5` are both immediately before the cycle entry, node `3`.

**Step 3 — Break the loop**

```java
fast.next = null;
```

Before:

```text
5.next = 3
```

After:

```text
5.next = null
```

Final list:

```text
1 → 2 → 3 → 4 → 5 → null
```

### Why is there a special case?

When the cycle begins at the head, `slow` and `fast` can meet at the head itself. In this case, your first branch walks `fast` to the last node in the cycle:

```java
while (fast.next != slow) {
    fast = fast.next;
}
```

That last node is the one whose `next` must become `null`.

**Complexity:** Time `O(n)`, extra space `O(1)`.

### Interview explanation

“I use Floyd's algorithm to detect the cycle. Then I locate the link that points back into the cycle and set that link to `null`. I handle a cycle beginning at the head separately.”

---

## Quick revision

| Problem                             | Main idea                                        | Extra space |
| ----------------------------------- | ------------------------------------------------ | ----------: |
| Detect cycle — LC 141               | Slow and fast meet                               |      `O(1)` |
| Find cycle entry — your LC 142 code | Store visited node references                    |      `O(n)` |
| Detect loop — GFG                   | Same Floyd technique                             |      `O(1)` |
| Count loop nodes                    | Meet first, then make one complete lap           |      `O(1)` |
| Remove loop                         | Find the cycle-closing link and set it to `null` |      `O(1)` |

## The one mathematical idea worth remembering

You don't need a complicated proof for an interview.

- Inside a cycle, `fast` gains one node on `slow` each round.
- The cycle has a finite number of nodes, so the gap eventually closes and both pointers meet.
- Once they meet, that proves a cycle exists.
- To count its length, walk around once until you return to the same node.
- To remove it, disconnect the link that points back into the cycle.

The important part is that you can explain **what each pointer is doing and why the loop stops**, rather than memorising a formula.
