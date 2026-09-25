# Linked List Revision — Swap Nodes in Pairs

## Problem

Swap every two adjacent nodes in a singly linked list.

Example:

```text
1 → 2 → 3 → 4

↓

2 → 1 → 4 → 3
```

For an odd number of nodes:

```text
1 → 2 → 3

↓

2 → 1 → 3
```

The last unpaired node remains unchanged.

---

## 1. Core Idea

Always think about one pair:

```text
beforePair → first → second → remaining
```

Before swapping:

```text
beforePair → first → second → remaining
```

After swapping:

```text
beforePair → second → first → remaining
```

Then move to the next pair.

---

## 2. Use a Dummy Node

```java
ListNode dummy = new ListNode(-1);
dummy.next = head;
```

Why?

Because the first pair changes the head.

Example:

```text
1 → 2 → 3 → 4
```

becomes:

```text
2 → 1 → 4 → 3
```

The original `head` (`1`) is no longer the first node.

With dummy:

```text
dummy → 1 → 2 → 3 → 4
```

After the first swap:

```text
dummy → 2 → 1 → 3 → 4
```

So the final answer is:

```java
return dummy.next;
```

---

## 3. Pointer Names

Use names that describe their role.

| Pointer | Meaning |
|---|---|
| `temp` | node immediately before the pair |
| `first` | first node of current pair |
| `second` | second node of current pair |

At the beginning of every iteration:

```text
temp → first → second → remaining
```

Example:

```text
dummy → 1 → 2 → 3 → 4 → 5
  ↑      ↑    ↑
 temp   first second
```

This relationship is the most important thing to maintain.

---

## 4. Condition for a Valid Pair

You can swap only if two nodes exist.

Natural condition:

```java
temp.next != null && temp.next.next != null
```

This means:

```text
There is a first node
AND
there is a second node
```

For:

```text
1 → 2 → 3
```

the pairs are:

```text
[1 → 2]
[3]
```

The second part has only one node, so stop.

---

## 5. Identify `first` and `second`

At the start of each iteration:

```java
ListNode first = temp.next;
ListNode second = first.next;
```

So:

```text
temp → first → second → rest
```

Example:

```text
dummy → 1 → 2 → 3 → 4
  ↑      ↑    ↑
 temp   first second
```

---

## 6. The Three Pointer Changes

Before:

```text
temp → first → second → nextPair
```

We want:

```text
temp → second → first → nextPair
```

Perform:

```java
temp.next = second;
first.next = second.next;
second.next = first;
```

### Step 1

```java
temp.next = second;
```

Connect the previous part to the second node.

```text
temp → second
```

### Step 2

```java
first.next = second.next;
```

The original second node was connected to the rest.

So:

```text
first → rest
```

### Step 3

```java
second.next = first;
```

Now:

```text
second → first → rest
```

Complete:

```text
temp → second → first → rest
```

---

## 7. Complete Dry Run

Input:

```text
1 → 2 → 3 → 4 → 5
```

Initial:

```text
dummy → 1 → 2 → 3 → 4 → 5
  ↑      ↑    ↑
 temp   first second
```

So:

```text
temp = dummy
first = 1
second = 2
```

### First pair

Before:

```text
dummy → 1 → 2 → 3 → 4 → 5
         ↑    ↑
       first second
```

### Assignment 1

```java
temp.next = second;
```

Now:

```text
dummy → 2
```

### Assignment 2

```java
first.next = second.next;
```

`second.next` is `3`.

Now:

```text
1 → 3
```

### Assignment 3

```java
second.next = first;
```

Now:

```text
2 → 1 → 3 → 4 → 5
```

First pair is complete.

---

## 8. Move to the Next Pair

After swapping:

```text
dummy → 2 → 1 → 3 → 4 → 5
             ↑
            first
```

The old `first` (`1`) is now the tail of the processed pair.

Therefore:

```java
temp = first;
```

Now:

```text
dummy → 2 → 1 → 3 → 4 → 5
             ↑
            temp
```

Then:

```java
first = temp.next;
second = first.next;
```

Now:

```text
dummy → 2 → 1 → 3 → 4 → 5
                  ↑    ↑
                first second
```

So again:

```text
temp → first → second
```

---

## 9. Second Pair

Current:

```text
dummy → 2 → 1 → 3 → 4 → 5
             ↑    ↑    ↑
           temp  first second
```

Apply:

```java
temp.next = second;
first.next = second.next;
second.next = first;
```

Result:

```text
dummy → 2 → 1 → 4 → 3 → 5
```

Move:

```java
temp = first;
```

Here `first = 3`.

So:

```text
dummy → 2 → 1 → 4 → 3 → 5
                  ↑
                 temp
```

Now:

```text
first = temp.next;
```

gives:

```text
first = 5
```

But:

```text
first.next == null
```

There is no second node.

Stop.

Final:

```text
2 → 1 → 4 → 3 → 5
```

---

## 10. Why `temp = first`?

This is one of the most important points.

Before swap:

```text
temp → first → second
```

After swap:

```text
temp → second → first
```

The old `first` is now the tail of the processed pair.

Therefore:

```java
temp = first;
```

places `temp` exactly before the next pair.

Then:

```java
first = temp.next;
second = first.next;
```

rebuilds:

```text
temp → first → second
```

for the next iteration.

### Memory line

```text
Old first → New pair tail
Old second → New pair head
```

---

## 11. Why Your Earlier `temp = temp.next` Was Wrong

You had:

```java
temp = first;
temp = temp.next;
```

After the first swap:

```text
dummy → 2 → 1 → 3 → 4
             ↑
           first
```

First:

```java
temp = first;
```

gives:

```text
temp → 1
```

This is correct.

But then:

```java
temp = temp.next;
```

moves `temp` to:

```text
temp → 3
```

Now `temp` is no longer the node before the next pair.

The required relationship is:

```text
dummy → 2 → 1 → 3 → 4
             ↑
            temp
```

So stop at:

```java
temp = first;
```

---

## 12. Why `return head` Is Wrong

Input:

```text
1 → 2 → 3 → 4
```

After swapping:

```text
2 → 1 → 4 → 3
```

The original `head` points to:

```text
1
```

but the new head is:

```text
2
```

Therefore:

```java
return head;
```

returns the wrong node.

Because of the dummy node:

```java
return dummy.next;
```

always returns the real head of the final list.

---

## 13. Why `while (temp != null)` Is Not Enough

The question is not:

```text
"Does temp exist?"
```

The question is:

```text
"Are there two nodes after temp?"
```

Use:

```java
while (temp.next != null && temp.next.next != null)
```

For:

```text
1 → 2 → 3
```

eventually:

```text
temp → 1 → 3
```

Then:

```text
temp.next = 3
temp.next.next = null
```

So the condition becomes false.

The final node remains unchanged.

---

## 14. Final Clean Code

```java
class Solution {
    public ListNode swapPairs(ListNode head) {

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode temp = dummy;

        while (temp.next != null && temp.next.next != null) {

            ListNode first = temp.next;
            ListNode second = first.next;

            // Swap
            temp.next = second;
            first.next = second.next;
            second.next = first;

            // Move to next pair
            temp = first;
        }

        return dummy.next;
    }
}
```

---

## 15. Pointer State to Memorize

At the beginning:

```text
temp → first → second → rest
```

Swap:

```java
temp.next = second;
first.next = second.next;
second.next = first;
```

After:

```text
temp → second → first → rest
```

Move:

```java
temp = first;
```

Then create the next pair:

```java
first = temp.next;
second = first.next;
```

Again:

```text
temp → first → second
```

---

## 16. Edge Cases

### Empty list

```text
null
```

Result:

```text
null
```

### One node

```text
1
```

Result:

```text
1
```

### Two nodes

```text
1 → 2
```

Result:

```text
2 → 1
```

### Three nodes

```text
1 → 2 → 3
```

Result:

```text
2 → 1 → 3
```

### Four nodes

```text
1 → 2 → 3 → 4
```

Result:

```text
2 → 1 → 4 → 3
```

### Five nodes

```text
1 → 2 → 3 → 4 → 5
```

Result:

```text
2 → 1 → 4 → 3 → 5
```

---

## 17. Common Mistakes

### Mistake 1 — Returning original head

Wrong:

```java
return head;
```

Correct:

```java
return dummy.next;
```

### Mistake 2 — Wrong loop condition

Risky:

```java
while (temp != null)
```

Correct:

```java
while (temp.next != null && temp.next.next != null)
```

### Mistake 3 — Moving `temp` too far

Wrong:

```java
temp = first;
temp = temp.next;
```

Correct:

```java
temp = first;
```

### Mistake 4 — Using `second.next` when `second == null`

Make sure two nodes exist before doing:

```java
second.next
```

### Mistake 5 — Forgetting the pointer transformation

Always see:

```text
temp → first → second → rest

        ↓

temp → second → first → rest
```

---

# Problem Pattern Connection

## Swap Pairs

```text
beforePair → first → second → rest
```

becomes:

```text
beforePair → second → first → rest
```

## Reverse K-Group

```text
beforeGroup → [groupStart ... groupEnd] → afterGroup
```

becomes:

```text
beforeGroup → [groupEnd ... groupStart] → afterGroup
```

The common skill is:

```text
IDENTIFY
→ CHANGE LINKS
→ RECONNECT
→ MOVE
```

For both problems, draw the structure before touching `next`.

---

# Complexity

```text
Time:  O(n)
Space: O(1)
```

Every node is processed a constant number of times.

---

# Permanent Notes

```text
SWAP PAIRS

Before:
temp → first → second → rest

Swap:
temp.next = second
first.next = second.next
second.next = first

After:
temp → second → first → rest

Move:
temp = first

Condition:
temp.next != null && temp.next.next != null

Return:
dummy.next
```

### Most important memory line

```text
Previous → Second → First → Rest
```

### Pointer rule

```text
SAVE / IDENTIFY
→ CHANGE LINK
→ RECONNECT
→ MOVE
```

### Final mental model

Don't memorize the code first.

Memorize the picture:

```text
temp → first → second → rest
             ↓
temp → second → first → rest
```

Then derive the three assignments from that picture.
