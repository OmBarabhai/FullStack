# B — Singly Linked List — Pattern A Revision
## Node References • Traversal • Construction • Search • Count • Min/Max • Reverse • Circular • Delete • Dummy Node

> **Goal:** This is a mistake-focused revision document for Pattern A.
>
> It is not generic Linked List theory. Revise it to strengthen:
>
> ```text
> references
> → positions
> → boundaries
> → current vs next
> → recursion return values
> → pointer preservation
> → deletion
> → dummy nodes
> → circular stopping
> ```

---

# 1. How To Use This File

Every revision follows:

```text
READ PATTERN
    ↓
HIDE CODE
    ↓
EXPLAIN IN HINGLISH
    ↓
DRAW POINTERS
    ↓
DRY RUN
    ↓
CODE FROM MEMORY
    ↓
CHECK BOUNDARIES
    ↓
CHECK COMPLEXITY
```

Revision cycle:

```text
R0 → same day
R1 → 2–3 days
R2 → ~7 days
R3 → ~30 days
```

---

# 2. Pattern A Scope

```text
References
→ Node Design
→ List State
→ Construction
→ Traversal
→ Search
→ Length / Count
→ Min / Max
→ Reverse
→ Recursive Reverse
→ Reverse Printing
→ Circular Traversal
→ Count Occurrences
→ Remove Linked List Elements
→ Dummy Node
```

---

# 3. Weakness Map

| Area | What to strengthen | Priority |
|---|---|:---:|
| Position vs Index | 0-based array vs 1-based LL | ⭐⭐⭐⭐⭐ |
| References | object vs reference vs link | ⭐⭐⭐⭐⭐ |
| Head / Tail | last Node vs `tail.next` | ⭐⭐⭐⭐⭐ |
| State | empty / one / multiple | ⭐⭐⭐⭐⭐ |
| Traversal | check current → move next | ⭐⭐⭐⭐⭐ |
| Recursive Return | current contribution + rest answer | ⭐⭐⭐⭐⭐ |
| Search Base Case | process current Node before moving | ⭐⭐⭐⭐⭐ |
| Reverse | save `next` before changing link | ⭐⭐⭐⭐⭐ |
| Reverse Printing | recursion order vs link mutation | ⭐⭐⭐⭐⭐ |
| Circular Traversal | stop at original head | ⭐⭐⭐⭐⭐ |
| Deletion | preserve links + consecutive matches | ⭐⭐⭐⭐⭐ |
| Dummy Node | check/delete `curr.next` | ⭐⭐⭐⭐⭐ |

---

# 4. Position vs Array Index

## Array

```text
index
 0   1   2   3
 ↓   ↓   ↓   ↓
10  20  30  40
```

## Linked List

```text
position
 1   2   3   4
 ↓   ↓   ↓   ↓
10  20  30  40
```

### Permanent rule

```text
ARRAY
→ index starts at 0

LINKED LIST
→ position starts at 1
```

### Position boundaries

```text
INSERT
→ 1 ... size + 1

UPDATE
→ 1 ... size

DELETE
→ 1 ... size
```

### Why insertion allows `size + 1`

Example:

```text
10 → 20 → 30
size = 3
```

Valid insertion positions:

```text
1 → before 10
2 → before 20
3 → before 30
4 → after 30
```

So:

```text
size + 1
```

is a valid **new position**.

But update/delete target existing Nodes:

```text
position 4
→ Node does not exist yet
```

### Self-check

```text
Creating a Node?
→ size + 1 can be valid

Changing/removing a Node?
→ target must already exist
```

---

# 5. Reference / Pointer Mental Model

## Create object

```java
Node newNode = new Node(10);
```

Means:

```text
CREATE OBJECT
      ↓
newNode points to it
```

## Copy reference

```java
Node a = b;
```

Means:

```text
a ──┐
    ↓
   SAME OBJECT
    ↑
b ──┘
```

No new Node is created.

## Move reference

```java
a = a.next;
```

Means:

```text
a moves to the next Node
```

The existing list is not automatically changed.

## Connect

```java
tail.next = newNode;
```

Means:

```text
OLD TAIL
   ↓
next points to NEW NODE
```

## Move tail

```java
tail = newNode;
```

Means:

```text
tail now identifies the new last Node
```

### Permanent mental model

```text
Node object
→ actual Node

reference variable
→ points to a Node

next
→ reference to another Node

head
→ reference to first Node

tail
→ reference to last Node

temp/current
→ working reference while traversing
```

---

# 6. Head / Tail Clarification

For:

```text
10 → 20 → 30 → null
```

```text
head → 10
tail → 30
```

and:

```text
tail.next → null
```

### Important distinction

```text
tail = last Node
```

NOT:

```text
tail = null
```

unless the list is empty.

Therefore:

```text
NON-EMPTY
→ tail != null
→ tail.next == null

EMPTY
→ tail == null
```

---

# 7. Empty / One / Multiple Node States

## EMPTY

```text
head = null
tail = null
size = 0
```

## ONE NODE

```text
head == tail
head.next == null
size = 1
```

## MULTIPLE

```text
head != tail
tail.next == null
size > 1
```

### Before structural operations ask

```text
EMPTY?
ONE?
HEAD?
TAIL?
MIDDLE?
```

---

# 8. Construction from Array — Iterative

Core pattern:

```text
head = null
tail = null

for each element
    create Node

    if first Node
        head = tail = newNode

    else
        tail.next = newNode
        tail = newNode
```

### Exact code pattern

```java
Node newNode = new Node(arr[i]);

if (head == null) {
    head = newNode;
    tail = newNode;
} else {
    tail.next = newNode;
    tail = newNode;
}
```

### Why head is assigned only once

```text
head
→ first Node
```

### Why tail changes every iteration

Each new Node is appended after the current tail:

```text
old tail → newNode
tail → newNode
```

### Dry run

For:

```text
arr = [10, 20, 30, 40]
```

Step 1:

```text
head → 10
tail → 10
```

Step 2:

```text
10 → 20
     ↑
    tail
```

Step 3:

```text
10 → 20 → 30
          ↑
         tail
```

Step 4:

```text
10 → 20 → 30 → 40 → null
                   ↑
                  tail
```

### Complexity

```text
Time  : O(n)
Extra : O(1)
```

---

# 9. Construction — Direct Node Linking vs API Calls

Using API:

```java
list.addAtTail(arr[i]);
```

Direct linking:

```java
Node newNode = new Node(arr[i]);

tail.next = newNode;
tail = newNode;
```

### Real pattern

```text
CREATE
→ CONNECT
→ MOVE TAIL
```

---

# 10. Recursive Construction

```java
if (idx == arr.length) {
    return null;
}

Node newNode = new Node(arr[idx]);

newNode.next = convertRec(arr, idx + 1);

return newNode;
```

### Each call does

```text
1. Create current Node
2. Solve smaller problem
3. Connect current to result
4. Return current
```

### Example

```text
10 → 20 → 30 → 40
```

Going down:

```text
create 10
 ↓
create 20
 ↓
create 30
 ↓
create 40
 ↓
return null
```

Coming back:

```text
40.next = null
30.next = 40
20.next = 30
10.next = 20
```

### Memory phrase

```text
CURRENT NODE
+
ANSWER FROM REST
→ LINK
```

---

# 11. Traversal

Exact mental model:

```text
temp = head

while temp != null
    use current Node
    temp = temp.next
```

### Permanent phrase

```text
CURRENT USE KARO
→ NEXT PAR JAO
→ NULL PAR STOP
```

### Why use `temp`?

Because:

```java
head = head.next;
```

would change the stored head reference.

Using:

```java
Node temp = head;
```

preserves:

```text
head → first Node
```

while `temp` walks.

### Complexity

```text
Time  : O(n)
Space : O(1)
```

---

# 12. Count / Length

## Iterative

```java
int count = 0;
Node temp = head;

while (temp != null) {
    count++;
    temp = temp.next;
}

return count;
```

Memory:

```text
VISIT NODE
→ count++
→ MOVE NEXT
```

## Recursive

```java
if (head == null) {
    return 0;
}

return 1 + countRec(head.next);
```

### Core mental model

```text
CURRENT CONTRIBUTION
+
ANSWER FROM REST
```

For:

```text
10 → 20 → 30 → 40
```

return flow:

```text
count(40)
→ 1 + 0 = 1

count(30)
→ 1 + 1 = 2

count(20)
→ 1 + 2 = 3

count(10)
→ 1 + 3 = 4
```

### Important

A local:

```java
int count = 1;
```

does not automatically collect deeper recursive answers.

Use:

```text
1 + count(rest)
```

### Complexity

```text
Iterative
Time  : O(n)
Space : O(1)

Recursive
Time  : O(n)
Space : O(n) call stack
```

---

# 13. Min / Max

Shared template:

```text
BASE CASE
→ identity value

CURRENT VALUE
+
ANSWER FROM REST

COMBINE
```

## Maximum

```java
if (head == null) {
    return Integer.MIN_VALUE;
}

int rest = findMaxRec(head.next);

return Math.max(head.data, rest);
```

## Minimum

```java
if (head == null) {
    return Integer.MAX_VALUE;
}

int rest = findMinRec(head.next);

return Math.min(head.data, rest);
```

### Memory rule

```text
MAX
→ max(current, MAX(rest))

MIN
→ min(current, MIN(rest))

COUNT
→ 1 + COUNT(rest)
```

### Copy/paste safety check

```text
Function name
+
recursive call
+
combine operation
```

So:

```text
findMaxRec
→ findMaxRec(rest)

findMinRec
→ findMinRec(rest)
```

---

# 14. Search

## Iterative

```java
Node temp = head;

while (temp != null) {
    if (temp.data == target) {
        return true;
    }

    temp = temp.next;
}

return false;
```

### Correct order

```text
CHECK CURRENT
→ MOVE NEXT
```

## Recursive

```java
if (head == null) {
    return false;
}

if (head.data == target) {
    return true;
}

return searchRec(head.next, target);
```

### Search mental order

```text
1. Node exists?
2. Current matches?
3. Move to next
```

### Important base case

Do not rely only on:

```java
head.next == null
```

because the final Node still needs to be checked.

---

# 15. Search Position

Because the API is 1-based:

```java
int pos = 1;
```

### Iterative

```java
int pos = 1;
Node temp = head;

while (temp != null) {
    if (temp.data == target) {
        return pos;
    }

    temp = temp.next;
    pos++;
}

return -1;
```

### Recursive idea

```text
current position
+
search next position
```

The recursive call must receive:

```text
pos + 1
```

### Permanent rule

```text
NODE MOVEMENT
+
POSITION MOVEMENT
→ stay synchronized
```

---

# 16. Reverse Linked List — Iterative

Three references:

```text
prev
curr
next
```

Start:

```java
Node prev = null;
Node curr = head;
```

Loop:

```java
while (curr != null) {

    Node next = curr.next;

    curr.next = prev;

    prev = curr;
    curr = next;
}
```

Return:

```java
return prev;
```

### Memory phrase

```text
SAVE
→ REVERSE
→ MOVE PREV
→ MOVE CURR
```

### Full dry run

Initial:

```text
10 → 20 → 30 → 40 → null
```

```text
prev = null
curr = 10
```

After first:

```text
10 → null

prev = 10
curr = 20
```

After second:

```text
20 → 10 → null

prev = 20
curr = 30
```

After third:

```text
30 → 20 → 10 → null

prev = 30
curr = 40
```

After fourth:

```text
40 → 30 → 20 → 10 → null

prev = 40
curr = null
```

Return:

```text
prev
```

### Why save `next` first?

Because:

```text
curr.next
```

contains the path to the remaining list.

If you overwrite it first without saving:

```text
curr.next = prev
```

that path can be lost.

### Correct order

```text
SAVE NEXT
→ CHANGE LINK
→ MOVE PREV
→ MOVE CURR
```

---

# 17. Recursive Reverse — Style A

```java
if (curr == null) {
    return prev;
}

Node next = curr.next;
curr.next = prev;

return reverseRec(next, curr);
```

Initial:

```java
reverseRec(head, null);
```

### Meaning

```text
curr
→ Node being processed

prev
→ already reversed portion
```

Each recursive call carries:

```text
remaining list
+
reversed list
```

---

# 18. Recursive Reverse — Style B

```java
if (head == null || head.next == null) {
    return head;
}

Node newHead = reverseRec(head.next);

head.next.next = head;
head.next = null;

return newHead;
```

### Mental model

```text
GO TO LAST NODE
→ RETURN BACKWARD
→ REWIRE
→ RETURN NEW HEAD
```

### Important

The final Node must be processed.

Correct base case:

```java
head == null || head.next == null
```

---

# 19. Reverse Printing vs Reversing

## Reverse the list

```text
LINKS CHANGE
```

```text
10 → 20 → 30

becomes

30 → 20 → 10
```

## Reverse print

```text
LINKS DO NOT CHANGE
```

```java
void reversePrint(Node head) {
    if (head == null) {
        return;
    }

    reversePrint(head.next);
    System.out.println(head.data);
}
```

### Mental model

```text
GO FORWARD
→ RETURN BACKWARD
→ PRINT
```

For:

```text
10 → 20 → 30 → 40
```

output:

```text
40
30
20
10
```

### Important distinction

```text
reverse print
→ recursion order changes output

reverse list
→ next references change
```

---

# 20. Circular Traversal

Normal list:

```text
10 → 20 → 30 → null
```

Stop:

```text
temp == null
```

Circular list:

```text
10 → 20 → 30 → 40
↑              ↓
└──────────────┘
```

Stop:

```text
temp == head
```

### Recommended pattern

```java
if (head == null) {
    return;
}

Node temp = head;

do {
    System.out.println(temp.data);
    temp = temp.next;
} while (temp != head);
```

### Why `do-while`?

The starting Node must be processed once before checking whether traversal has returned to it.

### Common mistake

```java
temp = temp.next;
print(temp.data);
```

This skips the original head.

### Permanent phrase

```text
NORMAL
→ STOP AT NULL

CIRCULAR
→ STOP AT ORIGINAL HEAD
```

---

# 21. Count Occurrences

## Iterative

```java
int count = 0;

Node temp = head;

while (temp != null) {
    if (temp.data == target) {
        count++;
    }

    temp = temp.next;
}

return count;
```

## Recursive

```java
if (head == null) {
    return 0;
}

if (head.data == target) {
    return 1 + countRec(head.next, target);
}

return countRec(head.next, target);
```

### Memory phrase

```text
MATCH
→ +1

NO MATCH
→ +0

THEN MOVE
```

---

# 22. Remove Linked List Elements

This is a major pointer pattern.

Example:

```text
10 → 20 → 20 → 30
```

target:

```text
20
```

## Approach A — `prev + curr`

```text
prev
curr
```

### Critical rule

```text
DELETE
→ prev stays

KEEP
→ prev moves
```

After:

```text
prev → curr → next
```

deletion:

```text
prev → next
```

`prev` is still in the correct position.

### Consecutive matches

```text
10 → 20 → 20 → 30
```

Delete first `20`:

```text
10 → 20 → 30
```

`prev` must remain at:

```text
10
```

so the next `20` can be checked.

---

# 23. Dummy Node Deletion

Permanent mental model:

```text
dummy → actual head
```

Then:

```java
Node dummy = new Node(0);
dummy.next = head;

Node curr = dummy;

while (curr.next != null) {

    if (curr.next.data == target) {
        curr.next = curr.next.next;
    } else {
        curr = curr.next;
    }
}

return dummy.next;
```

### Why `curr.next`?

Because:

```text
curr
→ Node BEFORE candidate
```

So:

```text
curr.next
→ candidate to check/delete
```

### Delete

Before:

```text
curr → target → next
```

After:

```text
curr → next
```

### Why curr stays after deletion?

After deletion:

```text
curr.next
```

is already the next candidate.

Moving immediately can skip consecutive matches.

### Permanent rule

```text
CHECK NEXT
→ DELETE NEXT
```

```text
DELETE
→ curr stays

KEEP
→ curr moves
```

### Return value

```java
return dummy.next;
```

because `dummy` is only helper state.

---

# 24. Boundary Case Checklist

Before coding:

```text
□ empty
□ one Node
□ two Nodes
□ head
□ tail
□ middle
□ target absent
□ duplicate target
□ consecutive target
```

For insertion:

```text
□ position 1
□ position size + 1
□ middle
□ invalid position
```

For deletion:

```text
□ position 1
□ position size
□ middle
□ invalid position
```

For circular:

```text
□ empty
□ one Node points to itself
□ return to original head
```

---

# 25. Mistake-to-Rule Conversion

Do not memorize mistakes as isolated incidents.

Convert them into reusable checks.

### Index / Position

```text
ARRAY → 0-based
LL    → 1-based
```

### Boundary

```text
INSERT → size + 1 possible
UPDATE / DELETE → existing size only
```

### Null

```text
CHECK NULL
→ THEN DEREFERENCE
```

### Search

```text
CHECK CURRENT
→ THEN MOVE
```

### Reverse

```text
SAVE NEXT
→ THEN CHANGE LINK
```

### Reverse Print

```text
PRINTING ≠ REVERSING
```

### Circular

```text
STOP AT START
→ not null
```

### Deletion

```text
BYPASS TARGET
→ preserve remaining chain
```

### Dummy

```text
CURR IS BEFORE CANDIDATE
→ CHECK curr.next
```

### Recursion

```text
CURRENT CONTRIBUTION
+
ANSWER FROM REST
```

---

# 26. Pattern Recognition

For an unseen Pattern A problem:

```text
What is being asked?
        ↓
Traversal?
Search?
Count?
Build?
Min / Max?
Reverse?
Delete?
Circular?
Recursive?
Dummy?
```

Then:

```text
Which references are needed?

head?
tail?
temp?
prev?
curr?
next?
dummy?
```

Then:

```text
What changes?
What stays?
Where do pointers stop?
What reference must be saved?
```

### Recognition flow

```text
PROBLEM
→ OPERATION
→ POINTERS
→ BOUNDARY
→ STATE CHANGE
→ CODE
```

---

# 27. Complexity Cheat Sheet

| Operation | Time | Extra Space |
|---|---:|---:|
| Build from array | O(n) | O(1) |
| Traverse | O(n) | O(1) |
| Count | O(n) | O(1) |
| Count recursive | O(n) | O(n) stack |
| Search | O(n) | O(1) |
| Search recursive | O(n) | O(n) stack |
| Min / Max | O(n) | O(1) |
| Min / Max recursive | O(n) | O(n) stack |
| Reverse iterative | O(n) | O(1) |
| Reverse recursive | O(n) | O(n) stack |
| Reverse print | O(n) | O(n) stack |
| Circular traversal | O(n) | O(1) |
| Remove elements | O(n) | O(1) |
| Dummy deletion | O(n) | O(1) |

> Recursive space means **call-stack space**, not extra Linked List Nodes.

---

# 28. Memory Lines

```text
Node
→ data + next
```

```text
Reference
→ points to object
```

```text
Traversal
→ use current → move next
```

```text
Build
→ create → connect tail → move tail
```

```text
Count
→ current contribution + rest answer
```

```text
Search
→ check current → search rest
```

```text
Max
→ max(current, rest)
```

```text
Min
→ min(current, rest)
```

```text
Reverse
→ save → reverse → move
```

```text
Reverse Print
→ recurse first → print later
```

```text
Delete
→ bypass target
```

```text
Dummy
→ dummy before head
```

```text
Circular
→ stop when back at original head
```

---

# 29. Self-Test — Answer Before Looking Below

```text
1. Why is insertion allowed at size + 1?

2. Why is update not allowed at size + 1?

3. What exactly does tail point to?

4. What exactly does tail.next contain?

5. Why must next be saved during reversal?

6. Why does recursive count use 1 + count(rest)?

7. Why is head == null the search base case?

8. Why is head.next == null not enough for search?

9. Why does reverse printing not modify next?

10. Why does circular traversal stop at head?

11. Why does dummy.next get returned?

12. Why do we check curr.next in dummy deletion?

13. Why does curr stay after deletion?

14. Why does prev stay after deleting a matching Node?

15. Why is recursive space O(n)?
```

---

# 30. Answer Key

### 1

```text
Insertion can create a new final position.
```

### 2

```text
Update/delete require an existing Node.
```

### 3

```text
tail points to the last Node.
```

### 4

```text
tail.next is null in a normal list.
```

### 5

```text
Changing curr.next can destroy
the path to the remaining Nodes.
```

### 6

```text
Current contributes 1.
Rest contributes count(rest).
```

### 7

```text
Null means no current Node exists.
```

### 8

```text
The final Node still needs checking.
```

### 9

```text
Only recursion order changes output.
Links stay unchanged.
```

### 10

```text
Circular lists do not end at null.
They end when traversal returns to start.
```

### 11

```text
dummy is helper state.
dummy.next is the real head.
```

### 12

```text
curr is one Node before the candidate.
```

### 13

```text
After deletion curr.next is the new candidate.
```

### 14

```text
The next Node may also match.
```

### 15

```text
Recursive calls remain on the call stack.
```

---

# 31. Mini Coding Drills

| # | Drill | Main thing to watch |
|---:|---|---|
| 1 | Build `[1,2,3]` manually | head / tail |
| 2 | Convert array recursively | base + return |
| 3 | Traverse from arbitrary Node | reference |
| 4 | Count Nodes recursively | `1 + rest` |
| 5 | Find max recursively | max + rest |
| 6 | Find min recursively | min + rest |
| 7 | Search final Node recursively | base case |
| 8 | Reverse iteratively | save next |
| 9 | Reverse with `prev/curr` recursion | state passing |
| 10 | Reverse print | no link changes |
| 11 | Delete head with dummy | `curr.next` |
| 12 | Delete consecutive target values | prev/curr stay |
| 13 | Traverse one-node circular list | stop at head |
| 14 | Count occurrences recursively | `+1 / +0` |
| 15 | Remove all target values | head + consecutive matches |

For each:

```text
Goal:
Pointers:
Boundary:
Expected result:
Time:
Space:
```

---

# 32. Final Revision Workflow

```text
STEP 1
→ Read one memory line

STEP 2
→ Hide implementation

STEP 3
→ Explain algorithm in Hinglish

STEP 4
→ Draw references

STEP 5
→ Dry run a small example

STEP 6
→ Code from memory

STEP 7
→ Check boundaries

STEP 8
→ State Time + Space

STEP 9
→ Record the mistake if any

STEP 10
→ Repeat after 2–7 days
```

---

# 33. Final Master Goal

For an unseen Singly Linked List Pattern A problem:

```text
PROBLEM
 ↓
IDENTIFY OPERATION
 ↓
CHOOSE POINTERS
 ↓
CHECK BOUNDARY
 ↓
PRESERVE REFERENCES
 ↓
CHANGE / READ
 ↓
VERIFY STATE
 ↓
CODE
 ↓
DRY RUN
 ↓
COMPLEXITY
```

The questions should become automatic:

```text
Which Node am I standing on?

What does this reference point to?

What happens if this is null?

What happens if there is one Node?

What happens at the last Node?

What link am I changing?

What reference must I save first?

What does the recursive call return?

Where does traversal stop?

Does the final list remain connected?
```

---

> **Pattern A is mastered when the algorithm can be reconstructed from pointer relationships instead of remembered line-by-line.**

---

# 34. New Revision Pattern — Platform 0-Based Position Deletion

> This pattern comes from a coding-platform problem where the statement explicitly uses **0-based indexing** and says that `pos >= length` leaves the list unchanged.

## Core distinction

Your custom Linked List implementation uses:

```text
1-based position
```

This platform problem uses:

```text
0-based index
```

### Compare

```text
CUSTOM LIST

position 1 → first Node
position 2 → second Node
position 3 → third Node
```

```text
PLATFORM PROBLEM

index 0 → first Node
index 1 → second Node
index 2 → third Node
```

### Permanent check

```text
BEFORE POSITION LOGIC
→ ask: indexing starts at 0 or 1?
```

---

## 34.1 Valid Deletion Boundary

For a list of length `n` using 0-based indexing:

```text
valid:
0 ... n - 1
```

Therefore:

```java
if (pos < 0 || pos >= n) {
    return head;
}
```

### Important correction

For this platform problem:

```text
pos >= size
→ invalid
```

Do NOT use your custom 1-based insertion rule:

```text
size + 1
```

That rule belongs to insertion in your own 1-based API.

---

## 34.2 Delete Head in 0-Based Problem

If:

```text
pos == 0
```

then:

```text
target = head
```

Example:

```text
3 → 4 → 5 → 6
```

Delete:

```text
pos = 0
```

Result:

```text
4 → 5 → 6
```

Code:

```java
if (pos == 0) {
    return head.next;
}
```

### Mental rule

```text
0-based
→ index 0 = head
```

---

## 34.3 Find Previous Node

For:

```text
pos = 3
```

the target is index `3`.

The previous Node is:

```text
index 2
```

Starting from head at index `0`, move:

```text
2 times
```

Therefore:

```java
Node prev = head;

for (int i = 0; i < pos - 1; i++) {
    prev = prev.next;
}
```

Then:

```java
Node curr = prev.next;
```

gives the target.

### Pattern memory

```text
0-BASED TARGET
→ previous index = pos - 1
→ moves = pos - 1
```

---

## 34.4 Why Your Earlier Loop Overshot

You used:

```java
for (int i = 0; i <= pos - 1; i++) {
    temp = temp.next;
}
```

For:

```text
pos = 3
```

this performs:

```text
3 moves
```

but you need:

```text
2 moves
```

because `temp` must stop at:

```text
index 2
```

### Do not memorize the loop

Ask:

```text
WHERE MUST prev STAND?
```

Then:

```text
HOW MANY MOVES FROM HEAD?
```

---

## 34.5 Core Delete Rewiring

For:

```text
prev → curr → next
```

delete `curr`.

The required change is:

```java
prev.next = curr.next;
```

Result:

```text
prev → next
```

Equivalent compact form:

```java
prev.next = prev.next.next;
```

### Mental translation

```text
prev.next
→ target

prev.next.next
→ Node after target

prev.next = prev.next.next
→ skip target
```

### What NOT to do

```java
prev.next = prev.next;
```

This changes nothing.

---

## 34.6 Why `curr` Is Optional

Readable version:

```java
Node curr = prev.next;
prev.next = curr.next;
```

Compact version:

```java
prev.next = prev.next.next;
```

Both mean:

```text
previous skips target
```

For learning and debugging:

```text
prev → curr → next
```

is usually easier to trace.

---

## 34.7 Tail Deletion in This Problem

Suppose:

```text
3 → 4 → 5 → 6
```

and:

```text
pos = 3
```

Target:

```text
6
```

Previous:

```text
5
```

Then:

```java
prev.next = prev.next.next;
```

becomes:

```text
5 → null
```

Final:

```text
3 → 4 → 5
```

No separate `tail` update is necessary because this platform function only returns `head` and does not maintain a `tail` field.

### Important comparison

```text
YOUR CUSTOM CLASS
→ maintain head + tail + size

PLATFORM FUNCTION
→ return correct head
```

---

## 34.8 One-Pass vs Two-Pass

An earlier approach was:

```text
PASS 1
→ calculate size

PASS 2
→ find target
→ delete
```

That is still:

```text
O(N)
```

but uses two traversals.

A clean one-pass approach:

```text
move toward previous
→ delete
→ return
```

### Complexity

```text
Time  : O(N)
Space : O(1)
```

---

## 34.9 Complete Pattern

```java
public static Node<Integer> deleteNode(Node<Integer> head, int pos) {

    if (head == null) {
        return head;
    }

    if (pos < 0) {
        return head;
    }

    if (pos == 0) {
        return head.next;
    }

    Node<Integer> prev = head;

    for (int i = 0; i < pos - 1 && prev.next != null; i++) {
        prev = prev.next;
    }

    if (prev.next == null) {
        return head;
    }

    prev.next = prev.next.next;

    return head;
}
```

---

## 34.10 0-Based vs 1-Based Position Card

### Your Custom List

```text
TARGET = position p

previous position = p - 1
moves from head = p - 2

head case:
p == 1

valid delete:
1 ... size
```

### Coding Platform Example

```text
TARGET = index pos

previous index = pos - 1
moves from head = pos - 1

head case:
pos == 0

valid delete:
0 ... size - 1
```

### Deep rule

```text
DO NOT MEMORIZE FORMULA
        ↓
FIND WHERE PREV MUST STAND
        ↓
COUNT MOVES FROM START
```

---

# 35. New Boundary Drill

For:

```text
3 → 4 → 5 → 2 → 6 → 1 → 9
```

length:

```text
7
```

Answer mentally:

| pos | Target | Valid? |
|---:|---:|:---:|
| -1 | — | ❌ |
| 0 | 3 | ✅ |
| 1 | 4 | ✅ |
| 2 | 5 | ✅ |
| 3 | 2 | ✅ |
| 4 | 6 | ✅ |
| 5 | 1 | ✅ |
| 6 | 9 | ✅ |
| 7 | — | ❌ |

Permanent rule:

```text
0 <= pos < size
→ valid
```

---

# 36. Self-Test — New Position Pattern

Answer before checking your code.

```text
Q1.
List:
10 → 20 → 30 → 40 → 50

pos = 2

target =
previous =
moves =
final list =
```

```text
Q2.
List:
10 → 20 → 30 → 40 → 50

pos = 4

target =
previous =
moves =
final list =
```

```text
Q3.
List:
10 → 20 → 30

pos = 0

new head =
final list =
```

```text
Q4.
List length = 5

pos = 5

valid or invalid?
```

```text
Q5.
What does this do?

prev.next = prev.next.next;
```

Expected mental picture:

```text
prev → target → next

becomes

prev → next
```

---

# 37. Final Revision Rule for Position Problems

Whenever a new platform problem gives a position/index:

```text
STEP 1
→ Check 0-based or 1-based

STEP 2
→ Identify target Node

STEP 3
→ Decide where prev must stand

STEP 4
→ Count moves from head

STEP 5
→ Check head boundary

STEP 6
→ Check out-of-range boundary

STEP 7
→ Reconnect around target

STEP 8
→ Verify final list
```

The core pattern remains:

```text
FIND PREVIOUS
→ BYPASS TARGET
→ VERIFY BOUNDARY
```
