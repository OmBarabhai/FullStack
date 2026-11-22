# Linked List --- Memory Model

## 1. Big Picture

A Linked List is made from separate **Node objects**.

Each Node contains:

-   `data` → actual value
-   `next` → reference to the next Node

Basic structure:

``` text
[10 | next] → [20 | next] → [30 | null]
```

------------------------------------------------------------------------

## 2. What Does `next` Store?

`next` does **not** store the next value directly.

It stores a **reference to another Node object**.

``` java
Node n1 = new Node(10);
Node n2 = new Node(20);

n1.next = n2;
```

Memory idea:

``` text
n1
 ↓
[10 | reference] ─────→ [20 | null]
                          ↑
                         n2
```

So:

``` java
n1.next
```

means:

> Go from `n1` to the Node referenced by `next`.

------------------------------------------------------------------------

## 3. Creating Three Nodes

``` java
Node n1 = new Node(10);
Node n2 = new Node(20);
Node n3 = new Node(30);
```

Initially they are separate objects:

``` text
n1 → [10 | null]

n2 → [20 | null]

n3 → [30 | null]
```

There is **no connection yet**.

------------------------------------------------------------------------

## 4. Connecting the Nodes

``` java
n1.next = n2;
n2.next = n3;
```

Now:

``` text
n1
 ↓
[10 | •] ───→ [20 | •] ───→ [30 | null]
                ↑              ↑
               n2             n3
```

The linked list is:

``` text
10 → 20 → 30 → null
```

------------------------------------------------------------------------

## 5. Important Point: `null`

The last Node points to:

``` java
null
```

because there is no next Node.

``` text
[30 | null]
```

So `null` means:

> There is no Node after this Node.

------------------------------------------------------------------------

## 6. Your Code

``` java
Node n1 = new Node(10);

n1.next = new Node(20);

n1.next.next = new Node(30);
```

After the first line:

``` text
n1
 ↓
[10 | null]
```

After:

``` java
n1.next = new Node(20);
```

``` text
n1
 ↓
[10 | •] → [20 | null]
```

After:

``` java
n1.next.next = new Node(30);
```

``` text
n1
 ↓
[10 | •] → [20 | •] → [30 | null]
```

------------------------------------------------------------------------

## 7. Understanding `n1.next`

Suppose:

``` text
n1
 ↓
10 → 20 → 30 → null
```

Then:

``` java
n1.data
```

gives:

``` text
10
```

``` java
n1.next.data
```

gives:

``` text
20
```

``` java
n1.next.next.data
```

gives:

``` text
30
```

``` java
n1.next.next.next
```

gives:

``` text
null
```

------------------------------------------------------------------------

## 8. Reference Chain

Think of the list as a chain of references:

``` text
n1
 ↓
Node(10)
   |
   | next
   ↓
Node(20)
   |
   | next
   ↓
Node(30)
   |
   | next
   ↓
 null
```

The important thing is:

``` text
data → value
next → reference
```

------------------------------------------------------------------------

## 9. Head Concept

A Linked List needs a starting reference called `head`.

Example:

``` java
Node head = n1;
```

Memory:

``` text
head
 ↓
[10] → [20] → [30] → null
```

`head` points to the **first Node**.

We normally do not need a separate reference to every Node.

If we know `head`, we can reach the complete list:

``` text
head
 ↓
10 → 20 → 30 → null
```

------------------------------------------------------------------------

## 10. Tail Concept

`tail` points to the last Node.

``` text
head                    tail
 ↓                        ↓
[10] → [20] → [30] → null
```

So:

``` text
head → first Node
tail → last Node
```

------------------------------------------------------------------------

## 11. Empty Linked List

Initially:

``` java
Node head = null;
Node tail = null;
```

Memory:

``` text
head → null

tail → null
```

There are no Nodes.

``` text
size = 0
```

------------------------------------------------------------------------

## 12. One-Node Linked List

After adding `10`:

``` text
head
 ↓
[10 | null]
 ↑
tail
```

Both `head` and `tail` reference the **same Node**.

``` text
head == tail
```

and:

``` text
size = 1
```

------------------------------------------------------------------------

## 13. Three-Node Linked List

``` text
head                         tail
 ↓                            ↓
[10 | •] → [20 | •] → [30 | null]
```

References:

``` text
head → Node(10)
Node(10).next → Node(20)
Node(20).next → Node(30)
Node(30).next → null
tail → Node(30)
```

------------------------------------------------------------------------

## 14. The Most Important Mental Model

Whenever you see:

``` java
a.next = b;
```

read it as:

> `a` now points to `b`.

Example:

``` java
n1.next = n2;
```

means:

``` text
n1 → n2
```

And:

``` java
n2.next = n3;
```

means:

``` text
n1 → n2 → n3
```

------------------------------------------------------------------------

## 15. Don't Confuse These

### Wrong mental model

``` text
next = next value
```

### Correct mental model

``` text
next = reference to next Node
```

Example:

``` java
n1.next = n2;
```

does not copy `20` into `n1`.

It connects the Node objects.

------------------------------------------------------------------------

## 16. Java Reference Idea

When you write:

``` java
Node n1 = new Node(10);
```

`n1` is a reference variable pointing to a Node object.

Conceptually:

``` text
n1 ─────→ [data: 10 | next: null]
```

When:

``` java
n1.next = new Node(20);
```

the `next` field of the first Node gets a reference to the second Node:

``` text
n1 ─────→ [10 | •] ─────→ [20 | null]
```

------------------------------------------------------------------------

## 17. Traversal Starts From Head

To visit every Node:

``` java
Node temp = head;

while (temp != null) {
    System.out.println(temp.data);
    temp = temp.next;
}
```

Mental model:

``` text
temp
 ↓
10 → 20 → 30 → null
```

First:

``` text
temp → 10
```

Then:

``` java
temp = temp.next;
```

Now:

``` text
temp → 20
```

Again:

``` text
temp = temp.next;
```

Now:

``` text
temp → 30
```

Again:

``` text
temp = temp.next;
```

Now:

``` text
temp → null
```

Loop stops.

------------------------------------------------------------------------

## 18. Golden Rules

Remember these:

``` text
Node = data + next reference

head = first Node

tail = last Node

last Node.next = null

next stores a Node reference

null means no next Node

head lets us reach the complete list

temp is commonly used for traversal
```

------------------------------------------------------------------------

## 19. Visual Summary

``` text
                 Linked List

head
 ↓
┌───────────┐      ┌───────────┐      ┌───────────┐
│ data: 10  │      │ data: 20  │      │ data: 30  │
│ next: ─────────→ │ next: ─────────→│ next:null │
└───────────┘      └───────────┘      └───────────┘
                                           ↑
                                          tail
```

### Core idea

``` text
Node
 ↓
[data | next]

next
 ↓
reference to another Node

Node → Node → Node → null
```

------------------------------------------------------------------------

## Mastery Check

Before moving forward, you should be able to answer these without
memorizing:

1.  What does `data` store?
2.  What does `next` store?
3.  Why does the last Node contain `null`?
4.  What does `head` point to?
5.  What does `tail` point to?
6.  What does `n1.next` mean?
7.  What does `n1.next.next` mean?
8.  Why can we traverse the complete list using only `head`?
9.  What happens when `head == null`?
10. Why does `head == tail` for a one-node list?
