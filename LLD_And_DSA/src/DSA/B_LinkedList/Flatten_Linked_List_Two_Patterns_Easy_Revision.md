# Flatten Linked List — Two Patterns
## Easy → Advanced Revision Notes

This file covers the two flattening patterns from the problems you shared.

1. **Flatten A Linked List** — append child lists at the end.
2. **Flatten a Sorted/Multi-Level Linked List** — recursively flatten the remaining lists, then merge two sorted lists.

The goal is to learn the pattern, not memorize the whole code.

---

# PART 1 — Flatten A Linked List
## Pattern: Tail Append

Each node has:

```text
next  → next node
child → another linked list
```

The provided solution keeps two important pointers:

```text
p
↓
current node being scanned

tail
↓
last node of the currently connected chain
```

### Code

```java
public static Node flattenMultiLinkedList(Node head) {
    Node p = head;
    Node tail = head;

    while (tail != null && tail.next != null) {
        tail = tail.next;
    }

    while (p != null) {
        if (p.child == null) {
            p = p.next;
        } else {
            tail.next = p.child;

            Node temp = p.child;
            while (temp.next != null) {
                temp = temp.next;
            }

            tail = temp;
            p.child = null;
        }
    }

    return head;
}
```

## 1. Find the first tail

```java
Node tail = head;

while (tail != null && tail.next != null) {
    tail = tail.next;
}
```

For:

```text
1 → 2 → 3 → 4 → null
```

after the loop:

```text
tail = 4
```

### Memory

> `tail` = last node.

---

## 2. Scan with `p`

```java
while (p != null)
```

Two cases.

### No child

```java
if (p.child == null) {
    p = p.next;
}
```

Just move forward.

### Child exists

Suppose:

```text
1 → 2 → 3 → 4
    |
    child
    ↓
    7 → 8
```

Current state:

```text
p = 2
tail = 4
```

Attach:

```java
tail.next = p.child;
```

Now:

```text
1 → 2 → 3 → 4 → 7 → 8
```

---

## 3. Find the new tail

```java
Node temp = p.child;

while (temp.next != null) {
    temp = temp.next;
}

tail = temp;
```

For:

```text
7 → 8
```

we get:

```text
tail = 8
```

So:

```text
1 → 2 → 3 → 4 → 7 → 8
                    ↑
                   tail
```

---

## 4. Remove the child pointer

```java
p.child = null;
```

The child list has already been attached through `next`.

---

## 5. Part 1 mental model

```text
p scans
   ↓
child?
   ↓ yes
attach child to tail
   ↓
find child tail
   ↓
update tail
   ↓
remove child pointer
```

### Permanent memory

> **p scans, tail appends, temp finds end.**

---

## 6. Dry Run

Input:

```text
1 → 2 → 3
        |
        child → 7 → 8
```

Initial:

```text
p = 1
tail = 3
```

`p = 1` → no child → `p = 2`

`p = 2` → no child → `p = 3`

`p = 3` → child exists.

Attach:

```text
3.next = 7
```

Now:

```text
1 → 2 → 3 → 7 → 8
```

Find child tail:

```text
tail = 8
```

Remove:

```text
3.child = null
```

---

## 7. Edge Cases

### Empty list

```text
head = null
```

Return `null`.

### One node

```text
1
```

Nothing to attach.

### One-node child

```text
1 → 2
    |
    9
```

becomes:

```text
1 → 2 → 9
```

### Child on the last main node

```text
1 → 2 → 3
        |
        9 → 10
```

The child is appended after the current tail.

### Multiple child lists

Keep updating:

```text
tail = end of newly attached list
```

---

## Important note

The first problem statement you pasted says the final result should be sorted, but the first code you pasted is a **tail-append flattening implementation**. It does not perform a sorted merge by itself.

Do not mix:

```text
tail append
```

with:

```text
sorted merge
```

They are different patterns.

---

# PART 2 — Flatten Sorted Linked List
## Pattern: Recursion + Merge

The second code looks harder because two ideas are mixed together:

```text
1. Flatten the remaining head-level lists.
2. Merge the current list with the flattened result.
```

Learn `merge()` first.

---

# 8. Understand `merge(a, b)` first

Suppose:

```text
A: 1 → 5 → 9
B: 2 → 4 → 10
```

Both are sorted.

Desired result:

```text
1 → 2 → 4 → 5 → 9 → 10
```

The rule is:

```text
compare first nodes
       ↓
take smaller
       ↓
solve the remaining problem
       ↓
attach result
```

### Memory

> **Pick → Recurse → Attach**

---

# 9. Merge base cases

```java
if (a == null) {
    return b;
}

if (b == null) {
    return a;
}
```

Meaning:

```text
empty + list = list
list + empty = list
```

---

# 10. The `res` variable

```java
Node res = null;
```

`res` means:

> the node chosen RIGHT NOW.

It is not the whole answer.

Example:

```text
a = 1...
b = 2...
```

Choose `1`:

```java
res = a;
```

Then solve the remaining nodes:

```java
res.child = merge(a.child, b);
```

So the structure becomes:

```text
1 → [answer to the smaller problem]
```

---

# 11. First branch

```java
if (a.data <= b.data) {
    res = a;
    res.child = merge(a.child, b);
}
```

Translate to English:

> `a` is smaller, so put `a` first. Then merge the rest of `a` with all of `b`.

---

# 12. Second branch

```java
else {
    res = b;
    res.child = merge(a, b.child);
}
```

Translate:

> `b` is smaller, so put `b` first. Then merge all of `a` with the rest of `b`.

---

# 13. Why `child`?

In this sorted flattening problem, the final flattened chain is built through:

```text
child
```

So:

```java
res.child = ...
```

connects the final answer.

The old head-level links are removed:

```java
res.next = null;
```

Think:

```text
next  = old head-level connection
child = final flattened connection
```

---

# 14. Complete merge code

```java
public static Node merge(Node a, Node b) {

    if (a == null) {
        return b;
    }

    if (b == null) {
        return a;
    }

    Node res = null;

    if (a.data <= b.data) {
        res = a;
        res.child = merge(a.child, b);
    } else {
        res = b;
        res.child = merge(a, b.child);
    }

    res.next = null;
    return res;
}
```

---

# 15. Dry Run of `merge()`

Input:

```text
A = 1 → 5 → 9
B = 2 → 4 → 10
```

### Step 1

Compare:

```text
1 and 2
```

Pick `1`.

Remaining:

```text
5 → 9
```

and:

```text
2 → 4 → 10
```

---

### Step 2

Compare:

```text
5 and 2
```

Pick `2`.

---

### Step 3

Compare:

```text
5 and 4
```

Pick `4`.

---

### Step 4

Compare:

```text
5 and 10
```

Pick `5`.

---

### Step 5

Compare:

```text
9 and 10
```

Pick `9`.

---

### Step 6

Only `10` remains.

Final:

```text
1 → 2 → 4 → 5 → 9 → 10
```

---

# PART 3 — Understand Flatten Recursion

Now look only at:

```java
public static Node flattenLinkedList(Node head) {

    if (head == null || head.next == null) {
        return head;
    }

    head.next = flattenLinkedList(head.next);

    return merge(head, head.next);
}
```

Do NOT try to understand everything simultaneously.

Read these two lines separately:

```java
head.next = flattenLinkedList(head.next);
```

> First flatten the REST.

Then:

```java
return merge(head, head.next);
```

> Then merge the CURRENT list with the flattened REST.

---

# 16. Recursion direction

For:

```text
1 → 2 → 3
```

the calls are:

```text
flatten(1)
    ↓
flatten(2)
    ↓
flatten(3)
```

At `3`:

```text
3.next == null
```

So:

```java
return 3;
```

Then recursion comes BACK.

This is the difficult part.

---

# 17. Returning from recursion

At node `2`:

```java
head.next = flattenLinkedList(head.next);
```

means:

```text
2.next = flattened(3)
```

Then:

```java
merge(2, flattened(3))
```

happens.

That result returns to node `1`.

Then node `1` is merged with that result.

---

# 18. Recursion picture

```text
flatten(1)
    |
    +---- flatten(2)
              |
              +---- flatten(3)
                       |
                       +---- return 3
              |
              +---- merge(2, 3)
    |
    +---- merge(1, result-of-2)
```

### Permanent memory

> **Go right first, merge on the way back.**

---

# 19. Why it feels like merge sort

The shape is similar:

```text
solve smaller part
       ↓
combine
```

Merge sort:

```text
split
sort smaller pieces
merge
```

This flattening pattern:

```text
flatten next
merge current + flattened next
```

So don't try to memorize it as "merge sort".

Think:

> **Recursive flatten + two-list merge**

---

# 20. Full example

Head-level lists:

```text
1 → 5 → 9

2 → 4

3 → 8
```

### First

Flatten the last list:

```text
3 → 8
```

### Next

Merge:

```text
2 → 4
```

with:

```text
3 → 8
```

Result:

```text
2 → 3 → 4 → 8
```

### Finally

Merge:

```text
1 → 5 → 9
```

with:

```text
2 → 3 → 4 → 8
```

Result:

```text
1 → 2 → 3 → 4 → 5 → 8 → 9
```

---

# 21. Edge Cases — Sorted Flatten

### Empty

```text
head = null
```

Return `null`.

### One head node

No second head-level list to merge.

### `a == null`

Return `b`.

### `b == null`

Return `a`.

### Duplicate values

The code uses:

```java
a.data <= b.data
```

So if equal:

```text
a.data == b.data
```

`a` is selected first.

### One-node child list

Works normally.

### Deep child levels

The merge logic continues through `child`.

---

# 22. Common Mistakes

## Mistake 1

Confusing:

```java
head.next
```

with:

```java
head.child
```

They have different jobs.

```text
next  → head-level lists
child → final flattened sorted chain
```

---

## Mistake 2

Thinking merge happens first.

Correct order:

```text
flatten next
     ↓
merge current + flattened next
```

---

## Mistake 3

Thinking `res` is the full answer.

It is only the current first selected node.

The rest is attached by:

```java
res.child = merge(...)
```

---

## Mistake 4

Forgetting:

```java
res.next = null;
```

The final flattened sorted structure uses `child`.

---

# 23. Learning Order

Do these in exactly this order.

## Step 1

Master Part 1:

```text
p
tail
temp
```

and:

```java
tail.next = p.child;
```

## Step 2

Forget flattening.

Practice only:

```java
merge(a, b)
```

with two sorted lists.

## Step 3

Practice recursion only:

```text
flatten(1)
flatten(2)
flatten(3)
return
```

## Step 4

Combine:

```java
head.next = flattenLinkedList(head.next);
return merge(head, head.next);
```

---

# 24. Interview Explanation

For the recursive sorted version:

> Each head-level list is already sorted. I recursively flatten the remaining lists first. Then I merge the current sorted list with the already flattened result. During merge, I select the smaller node and recursively merge the remaining nodes using the child pointer. The next pointer is cleared because the final flattened chain is represented using child pointers.

---

# 25. Permanent Cheat Sheet

### Pattern 1 — Tail Append

```text
p      = scanner
tail   = current overall end
temp   = finds child end
```

Memory:

> **p scans, tail appends, temp finds end.**

### Pattern 2 — Recursive Flatten

```text
flatten next
    ↓
merge current + flattened next
```

Memory:

> **Go right first, merge on the way back.**

### Pattern 3 — Merge

```text
compare
  ↓
pick smaller
  ↓
recurse on remaining
  ↓
attach with child
```

Memory:

> **Pick → Recurse → Attach**

---

# 26. Practice Dry Runs

### Example A — Tail Append

```text
1 → 2 → 3
    |
    6 → 9
```

Find:

```text
p
tail
child
new tail
```

### Example B — Multiple children

```text
1 → 2 → 3 → 4
    |       |
    6       7 → 8
    |
    9
```

Trace every pointer change.

### Example C — Merge

```text
A = 1 → 5 → 9
B = 2 → 4 → 10
```

Write the selected sequence:

```text
1
2
4
5
9
10
```

### Example D — Recursive flatten

```text
1 → 2 → 3
```

Write:

```text
flatten(1)
flatten(2)
flatten(3)
return
merge
merge
```

### Example E — Full pattern

```text
1 → 5 → 9
2 → 4
3 → 8
```

Process:

```text
flatten last
↓
merge second + last
↓
merge first + result
```

---

# 27. One-line Final Memory

```text
TAIL APPEND:
scan → attach → find tail

SORTED FLATTEN:
flatten right → merge back

MERGE:
compare → pick → recurse → attach
```
