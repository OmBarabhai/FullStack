# Linked List — Pattern 1: Foundations
**Purpose:** Revise the basics without rereading a long tutorial. This pattern covers node references, building a list, traversal, search, counting, and circular lists.

**Code labels**
- **Recovered original code** — code preserved from our earlier discussion.
- **Reference code** — original submission was not available, so this is a teaching version. It is written step by step, not shortened for the sake of fewer lines.

---

## 1. Node class and references

### Idea
Each node stores a value (`data`) and a reference to the next node (`next`).

```java
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
```

### What this means

```java
Node a = new Node(10);
Node b = new Node(20);
a.next = b;
```

After these lines:

```text
a
↓
[10 | next] ─────→ [20 | null]
                    ↑
                    b
```

- `a = a.next` moves the variable `a` to the next node.
- `a.next = b` changes the link stored inside the node currently referenced by `a`.
- `head` should remain the starting reference when you still need access to the whole list.

**Recall:** What is the difference between moving a reference and changing a node's link?

**Status:** Original custom Node-class submission not found in available history. The code above is reference code.

---

## 2. Build a list / convert an array to a linked list

### Idea
Keep `head` at the first node and `tail` at the last node. Attach each new node after `tail`, then move `tail` forward.

### Reference code — step-by-step

```java
static Node arrayToList(int[] arr) {
    Node head = null;
    Node tail = null;

    for (int value : arr) {
        Node newNode = new Node(value);

        if (head == null) {
            // First node: it is both head and tail.
            head = newNode;
            tail = newNode;
        } else {
            // Connect the new node after the old tail.
            tail.next = newNode;

            // The new node is now the last node.
            tail = newNode;
        }
    }

    return head;
}
```

### Dry run: `[4, 7, 9]`

| Value | What happens | List |
|---|---|---|
| `4` | First node becomes `head` and `tail` | `4 → null` |
| `7` | Connect `4.next = 7`, then move `tail` to `7` | `4 → 7 → null` |
| `9` | Connect `7.next = 9`, then move `tail` to `9` | `4 → 7 → 9 → null` |

`head` still points to `4`, so returning `head` gives the whole list.

**Quick check:** Why should `tail.next = newNode` happen before `tail = newNode`?

**Status:** Exact original custom build/array-to-list code not found in available history. This is reference code.

---

## 3. Print / traverse a normal linked list

### Idea
Use a temporary pointer. Process the current node, then move to the next node. A normal list ends at `null`.

### Reference code — iterative

```java
static void printList(Node head) {
    Node temp = head;

    while (temp != null) {
        System.out.println(temp.data);
        temp = temp.next;
    }
}
```

### Dry run: `10 → 20 → 30 → null`

| `temp` points to | Action | `temp` after moving |
|---|---|---|
| `10` | Print `10` | `20` |
| `20` | Print `20` | `30` |
| `30` | Print `30` | `null` |
| `null` | Stop | — |

Order to remember:

```text
CHECK temp exists → PROCESS temp → MOVE temp
```

Do not move `head` itself when you still need the original starting node.

**Status:** Exact iterative print submission not found in available history. This is reference code.

---

## 4. Search in a linked list

### 4A. Iterative search

**Idea:** Check each node. Return as soon as the target is found. If traversal reaches `null`, the target is absent.

### Reference code

```java
static boolean search(Node head, int target) {
    Node temp = head;

    while (temp != null) {
        if (temp.data == target) {
            return true;
        }

        temp = temp.next;
    }

    return false;
}
```

### Dry run: `10 → 20 → 30`, target `30`

| Current value | Compare with `30` | Action |
|---:|---|---|
| `10` | Not equal | Move to `20` |
| `20` | Not equal | Move to `30` |
| `30` | Equal | Return `true` |

**Important:** check the current node before moving forward. This ensures the last node is checked too.

**Status:** Exact iterative search submission not found in available history. This reference returns `boolean`; a platform that asks for a position or `1/0` may require a different return type.

### 4B. Recursive search — recovered original code

```java
public static boolean searchRec(Node head, int tar) {
    Node temp = head;
    if (temp == null) return false;
    if (temp.data == tar) return true;
    return searchRec(temp.next, tar);
}
```

### Dry run: `10 → 20 → 30`, target `30`

| Call's `temp.data` | Decision |
|---:|---|
| `10` | Not a match; search the rest |
| `20` | Not a match; search the rest |
| `30` | Match; return `true` |
| Returning to earlier calls | `true` is passed back |

The base case is `temp == null`. The method checks each real node before moving to the next recursive call.

**Recall:** Why can checking `head.next == null` and returning `false` too early skip the last node?

---

## 5. Count occurrences of a value

Searching and counting are different:
- **Search:** can stop at the first match.
- **Count occurrences:** must visit every node because the target may appear again.

### 5A. Iterative counting — recovered original method body

The exact enclosing method signature was not preserved, but this method body was recovered:

```java
if (head == null) return 0;

Node temp = head;
int count = 0;

while (temp != null) {
    if (temp.data == tar) count++;
    temp = temp.next;
}

return count;
```

### Dry run: `2 → 5 → 2 → 2`, target `2`

| `temp.data` | Match? | `count` |
|---:|---|---:|
| `2` | Yes | `1` |
| `5` | No | `1` |
| `2` | Yes | `2` |
| `2` | Yes | `3` |

Return `3`.

### 5B. Recursive counting — recovered original method body

```java
if (head == null) return 0;
if (head.data == tar) return 1 + CountOccurrencesRec(head.next, tar);
return CountOccurrencesRec(head.next, tar);
```

### How the return values add up

For `2 → 5 → 2`, target `2`:

```text
count at first 2 = 1 + answer(rest)
count at 5       = 0 + answer(rest)
count at last 2  = 1 + answer(null)
answer(null)     = 0

Total = 1 + 0 + 1 = 2
```

The recursive answer is not stored automatically in a local counter. Each call returns its contribution plus the answer for the rest of the list.

**Status:** The iterative and recursive method bodies were recovered; the exact enclosing signatures and acceptance status were not confirmed.

---

## 6. Length of a normal linked list

### Idea
Length counts **every node**, regardless of its value. Start at zero and add one for each node visited.

### Reference code — iterative

```java
static int length(Node head) {
    int count = 0;
    Node temp = head;

    while (temp != null) {
        count++;
        temp = temp.next;
    }

    return count;
}
```

### Dry run: `8 → 4 → 1 → null`

| `temp` | `count` after counting |
|---:|---:|
| `8` | `1` |
| `4` | `2` |
| `1` | `3` |
| `null` | Stop |

Return `3`.

### Recursive node count — reference code

```java
static int countNodes(Node head) {
    if (head == null) {
        return 0;
    }

    return 1 + countNodes(head.next);
}
```

Each call counts the current node as `1` and asks for the count of the rest. The empty list returns `0`.

**Status:** Exact original length and recursive node-count code not found in available history. These are reference versions.

---

## 7. Circular linked list: traversal and length

A circular list's last node points back to `head`, so it does not end at `null`. Stop when the pointer returns to the fixed starting node.

### 7A. Circular traversal — recovered original code

```java
public static void traverseCircular(Node head) {
    if (head == null) return;

    Node temp = head;
    do {
        System.out.println(temp.data);
        temp = temp.next;
    } while (temp != head);
}
```

### Dry run: `10 → 20 → 30 → back to 10`

| Printed node | `temp` after moving | Stop? |
|---:|---:|---|
| `10` | `20` | No |
| `20` | `30` | No |
| `30` | `10` (`head`) | Yes |

`do-while` is useful here because the head must be processed once before checking whether the pointer has returned to it.

### 7B. Circular length — reference code

```java
static int circularLength(Node head) {
    if (head == null) return 0;

    int count = 0;
    Node temp = head;

    do {
        count++;
        temp = temp.next;
    } while (temp != head);

    return count;
}
```

For `5 → 8 → 2 → back to 5`, the count becomes `3`, then `temp` returns to `head` and the loop stops.

**Status:** Circular traversal code was recovered. Exact original circular-length code was not found; the length method is reference code.

---

## Pattern 1 — Quick recognition

| If the problem asks for… | Think… | Stop condition |
|---|---|---|
| Visit or print every node | Temporary pointer + loop | `temp == null` |
| Find a value | Compare, then move | Match or `null` |
| Count matching values | Increment only on a match | `temp == null` |
| Find list length | Increment for every node | `temp == null` |
| Print in reverse order | Recursive call first, print on return | `head == null` |
| Traverse/count a circular list | Keep `head` fixed | `temp == head` after moving |

### Normal list vs circular list

```text
Normal:    10 → 20 → 30 → null
Circular:  10 → 20 → 30 ─┐
             ↑            │
             └────────────┘
```

### Complexity at a glance

| Operation | Time | Extra space |
|---|---:|---:|
| Build list from `n` values (with `tail`) | `O(n)` | `O(1)` auxiliary, `O(n)` nodes |
| Print / iterative search / iterative length | `O(n)` | `O(1)` |
| Recursive search / recursive count / reverse print | `O(n)` | `O(n)` call stack |
| Circular traversal / circular length | `O(n)` | `O(1)` |

---

## Pointer checklist

Before moving to the next pattern, check:

- [ ] Am I keeping `head` unchanged when I still need the list's start?
- [ ] Do I process the current node before advancing?
- [ ] Did I check for `null` before reading `.data` or `.next`?
- [ ] Is this a normal list (`null` ends it) or a circular list (return to `head`)?
- [ ] Does search stop at the first match, while counting continues through the whole list?
- [ ] Does every recursive method have a base case?

## Spaced revision

Mark a box only after trying to explain or reconstruct the code without reading the notes.

| Topic | R1: 2–3 days | R2: ~7 days | R3: ~30 days |
|---|:---:|:---:|:---:|
| Node references + build list | ⬜ | ⬜ | ⬜ |
| Iterative traversal + search | ⬜ | ⬜ | ⬜ |
| Recursive search + reverse print | ⬜ | ⬜ | ⬜ |
| Count occurrences + list length | ⬜ | ⬜ | ⬜ |
| Circular traversal + length | ⬜ | ⬜ | ⬜ |

**Next pattern:** Pattern 2 — Insert, Delete, Update, and Dummy Node.
