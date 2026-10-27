# Linked List Patterns 8–10 — Revision Notes

These notes follow your submitted Java code, with dry runs, pointer tracking, complexity, and important interview observations.

# Pattern 8 — Number Operations

## 1. Add Two Numbers — LeetCode 2

**Pattern:** Digit-by-digit addition, carry, and a dummy node.

### Your code

```java
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int sum = 0;
            if (l1 != null) {
                sum = l1.val + sum;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum = l2.val + sum;
                l2 = l2.next;
            }
            sum = sum + carry;
            curr.next = new ListNode(sum % 10);
            carry = sum / 10;
            curr = curr.next;
        }
        return dummy.next;
    }
}
```

### Core idea

In LC 2, the digits are stored in **reverse order**. The head contains the units digit, so you can add corresponding digits by traversing forward.

For every position:

- `sum % 10` gives the digit to store.
- `sum / 10` gives the carry.
- `curr` moves to the newly created result node.

### Dry run

Add `342 + 465`.

```text
l1: 2 -> 4 -> 3 -> null
l2: 5 -> 6 -> 4 -> null
```

| Step | Digit 1 | Digit 2 | Carry in | Sum | Output digit | Carry out |
| ---- | ------: | ------: | -------: | --: | -----------: | --------: |
| 1    |       2 |       5 |        0 |   7 |            7 |         0 |
| 2    |       4 |       6 |        0 |  10 |            0 |         1 |
| 3    |       3 |       4 |        1 |   8 |            8 |         0 |

The result is:

```text
7 -> 0 -> 8 -> null
```

This represents `807`, which is `342 + 465`.

### Why does the loop include `carry != 0`?

```java
while (l1 != null || l2 != null || carry != 0)
```

Even when both lists have ended, a remaining carry may need its own node. For example, `5 + 5 = 10`, so the result must contain the digits `0 -> 1`.

**Complexity:** O(max(m, n)) time; O(max(m, n)) output space.

---

## 2. Add Two Numbers II — LeetCode 445

**Pattern:** Reverse both lists → add digits → reverse the result.

### Your code

```java
class Solution {
    public static ListNode rev(ListNode head) {
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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = rev(l1);
        l2 = rev(l2);
        int carry = 0;
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while (l1 != null || l2 != null) {
            int sum = 0;
            if (l1 != null) {
                sum = l1.val + sum;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum = l2.val + sum;
                l2 = l2.next;
            }
            sum = sum + carry;
            int digit = sum % 10;
            carry = sum / 10;
            temp.next = new ListNode(digit);
            temp = temp.next;
        }
        if (carry > 0) {
            temp.next = new ListNode(carry);
            carry = 0;
        }
        ListNode res = rev(dummy.next);
        return res;
    }
}
```

### Core idea

In LC 445, digits are stored in **normal order**, with the most significant digit first. Direct forward traversal cannot add corresponding digits from the units position.

Your solution reverses both inputs so it can reuse the same digit-by-digit addition pattern as LC 2. Then it reverses the result back into normal order.

### Dry run

Add `7243 + 564`.

Original lists:

```text
l1: 7 -> 2 -> 4 -> 3 -> null
l2: 5 -> 6 -> 4 -> null
```

After reversing:

```text
l1: 3 -> 4 -> 2 -> 7 -> null
l2: 4 -> 6 -> 5 -> null
```

Add from the units digit:

| Step | Digit 1 | Digit 2 | Carry in | Sum | Output digit | Carry out |
| ---- | ------: | ------: | -------: | --: | -----------: | --------: |
| 1    |       3 |       4 |        0 |   7 |            7 |         0 |
| 2    |       4 |       6 |        0 |  10 |            0 |         1 |
| 3    |       2 |       5 |        1 |   8 |            8 |         0 |
| 4    |       7 |       — |        0 |   7 |            7 |         0 |

The temporary result is:

```text
7 -> 0 -> 8 -> 7 -> null
```

Reverse it:

```text
7 -> 8 -> 0 -> 7 -> null
```

This represents `7807`, the correct sum.

### Important observation

Your code **modifies both input lists** because `rev(l1)` and `rev(l2)` reverse the original links. If a follow-up requires preserving the inputs, use stacks or restore the lists after addition.

Your loop does not include `carry != 0`, but the separate `if (carry > 0)` handles the remaining carry. That is correct for this implementation.

**Complexity:** O(m + n) time; O(1) auxiliary space, excluding the result list.

### LC 2 versus LC 445

| Feature            | LC 2                | LC 445                       |
| ------------------ | ------------------- | ---------------------------- |
| Digit order        | Reverse order       | Normal order                 |
| Addition direction | Head to tail        | Head to tail after reversing |
| Final reversal     | Not needed          | Needed                       |
| Remaining carry    | Handled by the loop | Handled after the loop       |

---

# Pattern 9 — Sorting & Multiple Lists

## 3. Sort List — LeetCode 148

**Pattern:** Merge sort on a linked list.

### Your code

```java
class Solution {
    public ListNode sort(ListNode head1 , ListNode head2){
        ListNode dummy = new ListNode(-1);
        ListNode i = head1;
        ListNode j = head2;
        ListNode k = dummy;
        while(i != null && j != null){
            if(i.val <= j.val){
                k.next = i;
                i = i.next;
            }
            else{
                k.next = j;
                j = j.next;
            }
            k = k.next;
        }
        if(i == null) k.next = j;
        else k.next = i;
        return dummy.next;
    }

    public ListNode sortList(ListNode head) {
        if(head == null||head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;
        head = sortList(head);
        head2 = sortList(head2);
        return sort(head,head2);
    }
}
```

### Core idea

Merge sort repeatedly divides the list into smaller parts until each part contains one node. Then it merges the sorted parts.

Your `sortList()` performs three jobs:

1. Find a middle point using `slow` and `fast`.
2. Cut the list using `slow.next = null`.
3. Recursively sort both parts and merge them using `sort()`.

### Dry run

Input:

```text
4 -> 2 -> 1 -> 3 -> null
```

**Step 1 — Divide**

The first split gives:

```text
Left:  4 -> 2 -> null
Right: 1 -> 3 -> null
```

Each side is split again:

```text
Left:   [4] and [2]
Right:  [1] and [3]
```

**Step 2 — Merge sorted parts**

```text
[4] + [2]  ->  2 -> 4
[1] + [3]  ->  1 -> 3
```

**Step 3 — Final merge**

Compare the heads of `2 -> 4` and `1 -> 3`.

| Comparison   | Node chosen | Partial result     |
| ------------ | ----------: | ------------------ |
| 2 versus 1   |           1 | `1`                |
| 2 versus 3   |           2 | `1 -> 2`           |
| 4 versus 3   |           3 | `1 -> 2 -> 3`      |
| Left remains |           4 | `1 -> 2 -> 3 -> 4` |

Result:

```text
1 -> 2 -> 3 -> 4 -> null
```

### Why use `slow.next = null`?

It physically separates the two halves. Without cutting the link, recursive calls could keep receiving an overlapping list instead of progressively smaller lists.

### Complexity

- **Time:** O(n log n).
- **Recursion stack:** O(log n).
- The merge reuses existing nodes instead of creating a separate node for every value.

---

## 4. Merge K Sorted Lists — LeetCode 23

**Pattern:** Merge two sorted linked lists repeatedly.

### Your code

```java
class Solution {
    public ListNode merge(ListNode head1,ListNode head2) {
        ListNode d = new ListNode(-1);
        ListNode i = head1;
        ListNode j = head2;
        ListNode k = d;
        while(i!=null&&j!=null){
            if(i.val<=j.val){
                k.next = i;
                i = i.next;
            }else{
                k.next = j;
                j = j.next;
            }
            k = k.next;
        }
        if(i==null) k.next = j;
        else k.next = i;
        return d.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        ArrayList<ListNode> arr = new ArrayList<>();
        for (ListNode n : lists)
            arr.add(n);
        while (arr.size() > 1) {
            ListNode a = arr.get(arr.size() - 1);
            arr.remove(arr.size() - 1);
            ListNode b = arr.get(arr.size() - 1);
            arr.remove(arr.size() - 1);
            ListNode c = merge(a, b);
            arr.add(c);
        }
        return arr.get(0);
    }
}
```

### Core idea

`merge()` correctly merges two sorted lists. `mergeKLists()` stores the list heads in an `ArrayList`, removes the last two heads, merges them, and adds the merged head back.

It repeats until one list remains.

### Dry run

Suppose:

```text
L1: 1 -> 4
L2: 1 -> 3
L3: 2 -> 6
```

Your method starts from the end of the array.

**First merge — L3 and L2**

```text
2 -> 6
1 -> 3
```

Merged list:

```text
1 -> 2 -> 3 -> 6
```

The array now conceptually contains:

```text
[L1, merged(L2, L3)]
```

**Second merge — L1 and the merged list**

```text
1 -> 4
1 -> 2 -> 3 -> 6
```

Final result:

```text
1 -> 1 -> 2 -> 3 -> 4 -> 6 -> null
```

### Complexity observation

Your solution is logically correct, but the merging order is **unbalanced**: the growing merged list is repeatedly merged with one more list.

If there are `k` lists and `N` total nodes, the worst-case time complexity is **O(Nk)**. A balanced divide-and-conquer merge or a min-heap approach can achieve **O(N log k)**.

This is an optimization opportunity, not a correctness error in your code.

---

# Pattern 10 — Special Pointers & Design

## 5. Copy List with Random Pointer — LeetCode 138

**Pattern:** Interleave original and cloned nodes, set random links, then separate the lists.

### Your code

```java
class Solution {
    public Node copyRandomList(Node head) {
        if(head == null){
            return head;
        }
        Node temp = head;
        while (temp != null) {
            Node cloneNode = new Node(temp.val);
            cloneNode.next = temp.next;
            temp.next = cloneNode;
            temp = cloneNode.next;
        }
        temp = head;
        while (temp != null) {
            Node oldNode = temp;
            Node newNode = temp.next;
            if (oldNode.random != null) {
                newNode.random = oldNode.random.next;
            }
            temp = newNode.next;
        }
        temp = head;
        Node ansListNode = head.next;
        while(temp != null){
            Node oldNode = temp;
            Node newCloneNode = temp.next;
            oldNode.next = newCloneNode.next;
            if(oldNode.next != null){
                newCloneNode.next = newCloneNode.next.next;
            }
            temp = temp.next;
        }
        return ansListNode;
    }
}
```

### Core idea

Instead of using a `HashMap`, your code places every clone directly after its original node. This makes it possible to find the clone of any referenced node using `.next`.

### Pass 1 — Insert each clone

Original list:

```text
A -> B -> C -> null
```

After inserting clone nodes:

```text
A -> A' -> B -> B' -> C -> C' -> null
```

For each original node, you create a clone with the same value and insert it after the original.

### Pass 2 — Set random pointers

Your code:

```java
Node oldNode = temp;
Node newNode = temp.next;

if (oldNode.random != null) {
    newNode.random = oldNode.random.next;
}
temp = newNode.next;
```

Suppose `B.random = A`.

Because the clone of `A` is immediately after `A`:

```text
A -> A'
```

Therefore:

```java
newNode.random = oldNode.random.next;
```

sets `B'.random = A'`.

The clone points to the **clone of the target node**, not to the original target.

### Pass 3 — Separate the two lists

Your code restores the original `next` links and links clones together.

Before separation:

```text
A -> A' -> B -> B' -> C -> C'
```

After separation:

```text
Original: A -> B -> C -> null
Clone:    A' -> B' -> C' -> null
```

The random pointers in the cloned list remain connected to cloned nodes.

### Complexity

- **Time:** O(n).
- **Auxiliary space:** O(1), excluding the new clone nodes.

### Interview explanation

“I interleave each clone after its original node. Then I assign clone random pointers through the original target's `.next`. Finally, I restore the original list and extract the clone list.”

---

## 6. LRU Cache — LeetCode 146

**Pattern:** HashMap + doubly linked list.

Your code uses two structures for different purposes:

- `HashMap<Integer, Node> map`: finds a node by key quickly.
- Doubly linked list: keeps track of which key was used most recently.

### Your implementation

```java
class LRUCache {
    int capacity;
    HashMap<Integer, Node> map;
    Node head;
    Node tail;

    class Node {
        int key;
        int val;
        Node prev;
        Node next;

        Node(int k, int v) {
            key = k;
            val = v;
        }
    }

    void addNode(Node node) {
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }

    void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    void moveToFront(Node node) {
        removeNode(node);
        addNode(node);
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }

        Node node = map.get(key);
        moveToFront(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            moveToFront(node);
        } else {
            Node node = new Node(key, value);
            map.put(key, node);
            addNode(node);

            if (map.size() > capacity) {
                Node lru = tail.prev;
                removeNode(lru);
                map.remove(lru.key);
            }
        }
    }
}
```

### Core idea

LRU means **Least Recently Used**. When the cache exceeds capacity, remove the key that has gone the longest without being used.

The sentinel nodes `head` and `tail` simplify adding and removing nodes.

```text
head <-> Most Recent ... Least Recent <-> tail
```

- `addNode(node)` inserts immediately after `head`, making the node most recent.
- `removeNode(node)` reconnects its neighbors, unlinking it from the list.
- `moveToFront(node)` removes and reinserts it at the front.
- `get(key)` returns `-1` when missing; otherwise, it marks the node as recently used.
- `put(key, value)` updates an existing node or inserts a new node at the front. If the capacity is exceeded, it evicts `tail.prev`.

### Dry run — capacity 2

Operations:

```text
put(1, 1)
put(2, 2)
get(1)
put(3, 3)
get(2)
```

Track the order from most recently used to least recently used.

| Operation  | Result                                    | Cache order afterward |
| ---------- | ----------------------------------------- | --------------------- |
| `put(1,1)` | Insert key 1                              | `1`                   |
| `put(2,2)` | Insert key 2                              | `2 -> 1`              |
| `get(1)`   | Returns `1`; move key 1 to front          | `1 -> 2`              |
| `put(3,3)` | Insert 3; evict least-recently-used key 2 | `3 -> 1`              |
| `get(2)`   | Returns `-1`                              | `3 -> 1`              |

After `put(3,3)`, key `2` is removed from both the linked list and the map:

```java
Node lru = tail.prev;
removeNode(lru);
map.remove(lru.key);
```

Both removals matter: otherwise, the map could point to a node that is no longer in the cache.

### Complexity

- `get(key)`: average O(1).
- `put(key, value)`: average O(1).
- The HashMap finds a node quickly, while the doubly linked list updates recency in constant time.

---

# Final Revision Checklist — Patterns 8–10

| Problem                     | Key pattern             | Remember                                            |
| --------------------------- | ----------------------- | --------------------------------------------------- |
| LC 2 — Add Two Numbers      | Carry-based addition    | Digits are in reverse order                         |
| LC 445 — Add Two Numbers II | Reverse + add + reverse | Digits are in normal order                          |
| LC 148 — Sort List          | Merge sort              | Split, recursively sort, then merge                 |
| LC 23 — Merge K Lists       | Repeated sorted merge   | Your current merging order is unbalanced            |
| LC 138 — Copy Random List   | Interleaving clones     | `original.random.next` identifies the cloned target |
| LC 146 — LRU Cache          | HashMap + DLL           | Map for lookup; DLL for recency and eviction        |

## What to focus on next

Your core linked-list patterns now cover traversal, insert/delete, two pointers, reversal, cycles, intersection, duplicate removal, rearrangement, number operations, sorting, random pointers, and LRU cache.

Prioritize explaining these three ideas aloud: **why the LRU cache needs both a map and a doubly linked list, how interleaving makes random-pointer copying possible without a map, and why balanced merging improves `mergeKLists` performance.**
