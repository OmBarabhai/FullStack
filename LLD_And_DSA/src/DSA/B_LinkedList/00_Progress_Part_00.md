# **0.1 — Memory Model & Reference Thinking**

> **Goal**
>
> Before writing a single Linked List method, develop the mental model of **how Java objects, references, and memory work**. Every Linked List operation is nothing more than creating, storing, connecting, disconnecting, and traversing object references.

---

# 📖 Section Overview

|           Topic           | Status |
| :-----------------------: | :----: |
|   Primitive vs Reference  |    ⬜   |
|    Stack vs Heap Memory   |    ⬜   |
|  Object Creation (`new`)  |    ⬜   |
|    Reference Variables    |    ⬜   |
|    Reference Assignment   |    ⬜   |
|          Aliasing         |    ⬜   |
|      `null` Reference     |    ⬜   |
| Garbage Collection Basics |    ⬜   |
|      Object Identity      |    ⬜   |
|    Memory Visualization   |    ⬜   |

---

# 🎯 Learning Objectives

After completing **0.1**, you should be able to:

* [ ] Explain the difference between primitive variables and object references.
* [ ] Draw stack and heap memory for a Linked List.
* [ ] Explain what `new` actually does.
* [ ] Explain why `Node a = b;` does **not** copy a node.
* [ ] Trace references after every assignment.
* [ ] Predict the effect of changing one reference when multiple variables point to the same object.
* [ ] Explain why Linked Lists work using references instead of contiguous memory.

---

# 🧠 Why This Section Exists

Many beginners memorize Linked List code without understanding **what the pointers are actually pointing to**.

Every Linked List algorithm is built on one idea:

```text
Reference

↓

Object

↓

Reference

↓

Object

↓

Reference

↓

NULL
```

If this mental model is clear, the rest of Linked Lists becomes much easier.

---

# 📚 Topics

|  # | Topic                     | Importance | Status |
| -: | ------------------------- | :--------: | :----: |
|  1 | Primitive vs Object       |    ⭐⭐⭐⭐⭐   |    ⬜   |
|  2 | Stack vs Heap             |    ⭐⭐⭐⭐⭐   |    ⬜   |
|  3 | Reference Variables       |    ⭐⭐⭐⭐⭐   |    ⬜   |
|  4 | Object Creation (`new`)   |    ⭐⭐⭐⭐⭐   |    ⬜   |
|  5 | Reference Assignment      |    ⭐⭐⭐⭐⭐   |    ⬜   |
|  6 | Aliasing                  |    ⭐⭐⭐⭐⭐   |    ⬜   |
|  7 | `null` Reference          |    ⭐⭐⭐⭐⭐   |    ⬜   |
|  8 | Garbage Collection Basics |    ⭐⭐⭐⭐    |    ⬜   |
|  9 | Object Identity (`==`)    |    ⭐⭐⭐⭐    |    ⬜   |
| 10 | Memory Diagrams           |    ⭐⭐⭐⭐⭐   |    ⬜   |

---

# 💻 Hands-on Implementation Tasks

|  # | Task                                  | Status |  R1 |  R2 |  R3 |  R4 |  R5 | Notes                 |
| -: | ------------------------------------- | :----: | :-: | :-: | :-: | :-: | :-: | --------------------- |
|  1 | Create a simple `Student` object      |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  | Learn object creation |
|  2 | Create two references to one object   |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  | Understand aliasing   |
|  3 | Assign one reference to another       |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  | Reference copy        |
|  4 | Compare two references using `==`     |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  | Identity check        |
|  5 | Assign `null` to a reference          |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  | Object accessibility  |
|  6 | Draw memory diagrams for each example |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  | Pointer intuition     |

---

# 🧩 Skills Gained

* Memory visualization
* Reference thinking
* Object relationships
* Pointer intuition
* Heap vs Stack understanding
* Java object lifecycle basics

---

# ⚠️ Common Mistakes

* ❌ Thinking a reference variable stores the object itself.
* ❌ Believing `a = b` creates a new object.
* ❌ Forgetting that multiple references can point to the same object.
* ❌ Confusing `==` (reference identity) with object equality.
* ❌ Ignoring `null` checks.

---

# 📈 Difficulty

🟢 Beginner

---

# 🎯 Completion Checklist

* [ ] I can draw stack and heap memory.
* [ ] I understand how references behave after assignment.
* [ ] I can explain aliasing with confidence.
* [ ] I know why Linked Lists use object references.
* [ ] I can manually trace reference changes on paper.
* [ ] I am ready to design my first `Node` class.

---

# ➡️ Next Section

**0.2 — Node Design & Node Anatomy**

> Learn how a single `Node` is constructed, why it contains `data` and `next`, and how nodes become the building blocks of a Linked List.

---

# 📖 0.2 — Node Design & Node Anatomy

> **Goal**
>
> Learn how a **Node** is designed, why it exists, and why every Linked List is nothing more than a collection of interconnected nodes.
>
> After completing this section, you should fully understand the internal structure of a node before building the Linked List class.

---

# 📖 Section Overview

|         Topic        | Status |
| :------------------: | :----: |
|    What is a Node?   |    ⬜   |
|     Node Anatomy     |    ⬜   |
|      Data Field      |    ⬜   |
|    Next Reference    |    ⬜   |
|     Constructors     |    ⬜   |
|    Creating Nodes    |    ⬜   |
|   Connecting Nodes   |    ⬜   |
|   Traversing Nodes   |    ⬜   |
| Breaking Connections |    ⬜   |
|  Node Visualization  |    ⬜   |

---

# 🎯 Learning Objectives

After completing **0.2**, you should be able to:

* [ ] Explain why Linked Lists are built using nodes.
* [ ] Explain every member inside a node.
* [ ] Design a reusable Node class.
* [ ] Create individual nodes manually.
* [ ] Connect nodes together.
* [ ] Disconnect nodes safely.
* [ ] Draw node diagrams on paper.
* [ ] Explain why the last node stores `null`.

---

# 🧠 Why This Section Exists

Every Linked List operation works on **nodes**, not arrays.

Before building a Linked List, you must understand a single node completely.

Everything later—

* insertion
* deletion
* reverse
* merge
* cycle detection

is simply manipulating node connections.

---

# 🧩 Mental Model

```text
One Node

↓

Many Nodes

↓

Connected Nodes

↓

Linked List
```

---

# 📚 Topics

|  # | Topic                     | Importance | Status |
| -: | ------------------------- | :--------: | :----: |
|  1 | What is a Node?           |    ⭐⭐⭐⭐⭐   |    ⬜   |
|  2 | Node Fields               |    ⭐⭐⭐⭐⭐   |    ⬜   |
|  3 | Data vs Reference         |    ⭐⭐⭐⭐⭐   |    ⬜   |
|  4 | Node Constructors         |    ⭐⭐⭐⭐⭐   |    ⬜   |
|  5 | Creating Nodes            |    ⭐⭐⭐⭐⭐   |    ⬜   |
|  6 | Connecting Nodes          |    ⭐⭐⭐⭐⭐   |    ⬜   |
|  7 | Breaking Connections      |    ⭐⭐⭐⭐    |    ⬜   |
|  8 | Last Node (`next = null`) |    ⭐⭐⭐⭐⭐   |    ⬜   |
|  9 | Node Memory Diagram       |    ⭐⭐⭐⭐⭐   |    ⬜   |
| 10 | Node Lifecycle            |    ⭐⭐⭐⭐    |    ⬜   |

---

# 💻 Hands-on Implementation Tasks

|  # | Task                             | Status |  R1 |  R2 |  R3 |  R4 |  R5 | Notes |
| -: | -------------------------------- | :----: | :-: | :-: | :-: | :-: | :-: | ----- |
|  1 | Create `Node` class              |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
|  2 | Add `data` field                 |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
|  3 | Add `next` reference             |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
|  4 | Create default constructor       |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
|  5 | Create parameterized constructor |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
|  6 | Create one node manually         |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
|  7 | Create two connected nodes       |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
|  8 | Create three connected nodes     |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
|  9 | Print node values manually       |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
| 10 | Draw memory diagram              |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |

---

# 🎨 Visualization

## Single Node

```text
┌─────────────┐
│ data = 10   │
│ next = null │
└─────────────┘
```

---

## Two Connected Nodes

```text
head
 │
 ▼

┌──────────┐
│ data = 10│
│ next ────┼────────────┐
└──────────┘            │
                        ▼
                  ┌──────────┐
                  │ data =20 │
                  │ next=null│
                  └──────────┘
```

---

## Three Connected Nodes

```text
head
 │
 ▼

10 ───► 20 ───► 30 ───► NULL
```

---

# 🧩 Skills Gained

* Node design
* Object linking
* Reference chaining
* Pointer visualization
* Manual node construction
* Memory tracing

---

# ⚠️ Common Mistakes

* ❌ Forgetting to initialize `next`.
* ❌ Thinking `next` stores a node instead of a reference.
* ❌ Losing a node by overwriting `next`.
* ❌ Assuming nodes are stored continuously in memory.
* ❌ Forgetting that the last node points to `null`.

---

# 📈 Difficulty

🟢 Beginner

---

# 🏆 Completion Checklist

* [ ] I understand the purpose of a Node.
* [ ] I can design a reusable Node class.
* [ ] I can manually create and connect nodes.
* [ ] I can draw node memory diagrams.
* [ ] I understand why `next` is a reference.
* [ ] I understand why the last node stores `null`.
* [ ] I am ready to build the `MyLinkedList` class.

---

# ➡️ Next Section

**0.3 — Designing the MyLinkedList Class**

> Learn how to combine individual nodes into a complete Linked List by introducing `head`, `tail`, and `size`, and preparing the foundation for all Linked List operations.

---
After thinking about it carefully, **0.3 is where the real learning begins.**

This is the section that separates someone who **uses** a Linked List from someone who **understands** how a Linked List is built.

I would make this one of the biggest sections in Part 0.

---

# 📖 0.3 — Designing the MyLinkedList Class

> **Goal**
>
> Build your own `MyLinkedList` class from scratch.
>
> Learn how a Linked List manages nodes using `head`, `tail`, and `size`, and understand the role of each member before implementing any operations.
>
> After completing this section, you should have the complete skeleton of a Linked List ready for insertion, deletion, searching, and traversal.

---

# 📖 Section Overview

|          Topic          | Status |
| :---------------------: | :----: |
| Why MyLinkedList Class? |    ⬜   |
|      Head Reference     |    ⬜   |
|      Tail Reference     |    ⬜   |
|      Size Variable      |    ⬜   |
|    Empty Linked List    |    ⬜   |
|    Linked List States   |    ⬜   |
|       Constructor       |    ⬜   |
|        Invariants       |    ⬜   |
|   Memory Visualization  |    ⬜   |
|      Class Skeleton     |    ⬜   |

---

# 🎯 Learning Objectives

After completing **0.3**, you should be able to:

* [ ] Explain why we need a `LinkedList` class.
* [ ] Explain the purpose of `head`.
* [ ] Explain the purpose of `tail`.
* [ ] Explain why `size` exists.
* [ ] Identify all possible states of a Linked List.
* [ ] Design the class skeleton.
* [ ] Understand the invariants that must always remain true.

---

# 🧠 Why This Section Exists

A Linked List is **not just a chain of nodes**.

It also needs an object that manages the entire chain.

Without a manager object:

* there is no starting point
* there is no ending point
* there is no size information
* every operation becomes harder

That manager is **MyLinkedList**.

---

# 🧩 Mental Model

```text
Node

↓

Multiple Nodes

↓

Managed By

↓

MyLinkedList
```

---

# 📚 Topics

|  # | Topic               | Importance | Status |
| -: | ------------------- | :--------: | :----: |
|  1 | Why MyLinkedList?   |    ⭐⭐⭐⭐⭐   |    ⬜   |
|  2 | Head Reference      |    ⭐⭐⭐⭐⭐   |    ⬜   |
|  3 | Tail Reference      |    ⭐⭐⭐⭐⭐   |    ⬜   |
|  4 | Size Variable       |    ⭐⭐⭐⭐⭐   |    ⬜   |
|  5 | Empty List State    |    ⭐⭐⭐⭐⭐   |    ⬜   |
|  6 | Single Node State   |    ⭐⭐⭐⭐⭐   |    ⬜   |
|  7 | Multiple Node State |    ⭐⭐⭐⭐⭐   |    ⬜   |
|  8 | Constructor         |    ⭐⭐⭐⭐⭐   |    ⬜   |
|  9 | Class Invariants    |    ⭐⭐⭐⭐⭐   |    ⬜   |
| 10 | Memory Diagram      |    ⭐⭐⭐⭐⭐   |    ⬜   |

---

# 💻 Hands-on Implementation Tasks

|  # | Task                                 | Status |  R1 |  R2 |  R3 |  R4 |  R5 | Notes |
| -: | ------------------------------------ | :----: | :-: | :-: | :-: | :-: | :-: | ----- |
|  1 | Create `MyLinkedList` class          |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
|  2 | Add `head` reference                 |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
|  3 | Add `tail` reference                 |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
|  4 | Add `size` variable                  |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
|  5 | Create default constructor           |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
|  6 | Initialize an empty list             |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
|  7 | Visualize memory for empty list      |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
|  8 | Visualize memory for one-node list   |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
|  9 | Visualize memory for three-node list |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
| 10 | Verify class invariants manually     |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |

---

# 🧩 Linked List States

## Empty List

```text
head = null
tail = null
size = 0
```

---

## Single Node

```text
head
 │
 ▼

10

 ▲
 │

tail

size = 1
```

---

## Multiple Nodes

```text
head
 │
 ▼

10 → 20 → 30 → NULL
              ▲
              │
             tail

size = 3
```

---

# 📐 Linked List Invariants

These conditions must **always** remain true.

| Rule | Description                                     |
| ---- | ----------------------------------------------- |
| 1    | `head == null` if and only if the list is empty |
| 2    | `tail == null` if and only if the list is empty |
| 3    | `tail.next` is always `null`                    |
| 4    | `size` always equals the number of nodes        |
| 5    | `head` always points to the first node          |
| 6    | `tail` always points to the last node           |

---

# 🧩 Skills Gained

* Linked List design
* State management
* Head & tail management
* Invariant thinking
* Class architecture
* Data structure design

---

# ⚠️ Common Mistakes

* ❌ Forgetting to initialize `head` and `tail`.
* ❌ Updating `head` but not `tail`.
* ❌ Forgetting to update `size`.
* ❌ Breaking class invariants after operations.
* ❌ Not handling the empty list separately.

---

# 📈 Difficulty

🟢 Beginner

---

# 🏆 Completion Checklist

* [ ] I understand the role of `MyLinkedList`.
* [ ] I know why `head`, `tail`, and `size` exist.
* [ ] I can identify the three states of a Linked List.
* [ ] I understand all Linked List invariants.
* [ ] I can draw memory diagrams for different list states.
* [ ] I have built the complete class skeleton.
* [ ] I am ready to implement traversal operations.

---

# ➡️ Next Section

**0.4 — Traversal Engine**

> Learn how to move through a Linked List safely using references, visit every node exactly once, and build the foundation for searching, insertion, deletion, and almost every Linked List algorithm.

---

# 📖 0.4 — Traversal Engine

> **Goal**
>
> Master Linked List traversal by learning how to move safely from one node to the next using references.
>
> Traversal is the foundation of almost every Linked List operation.
>
> After completing this section, you should be able to visit every node confidently and understand how pointer movement works internally.

---

# 📖 Section Overview

|         Topic         | Status |
| :-------------------: | :----: |
|   What is Traversal?  |    ⬜   |
|    Current Pointer    |    ⬜   |
|   Starting from Head  |    ⬜   |
|  Moving to Next Node  |    ⬜   |
|     Traversal Loop    |    ⬜   |
|     End Condition     |    ⬜   |
|   Display Operation   |    ⬜   |
|     Node Counting     |    ⬜   |
|     Manual Dry Run    |    ⬜   |
| Pointer Visualization |    ⬜   |

---

# 🎯 Learning Objectives

After completing **0.4**, you should be able to:

* [ ] Explain what traversal means.
* [ ] Traverse every node exactly once.
* [ ] Understand why traversal starts from `head`.
* [ ] Explain why traversal ends at `null`.
* [ ] Visualize pointer movement.
* [ ] Implement display operations confidently.
* [ ] Count nodes using traversal.

---

# 🧠 Why This Section Exists

Every Linked List algorithm begins with:

```text
head

↓

current

↓

current.next

↓

current.next.next
```

Traversal is the engine that powers:

* Searching
* Insertion
* Deletion
* Reverse
* Middle Node
* Cycle Detection
* Merge
* Sort

Without mastering traversal, the rest of Linked Lists becomes much harder.

---

# 🧩 Mental Model

```text
Head

↓

Current

↓

Move

↓

Visit

↓

Repeat

↓

NULL
```

---

# 📚 Topics

|  # | Topic                   | Importance | Status |
| -: | ----------------------- | :--------: | :----: |
|  1 | What is Traversal?      |    ⭐⭐⭐⭐⭐   |    ⬜   |
|  2 | Starting from Head      |    ⭐⭐⭐⭐⭐   |    ⬜   |
|  3 | Current Pointer         |    ⭐⭐⭐⭐⭐   |    ⬜   |
|  4 | Moving to Next Node     |    ⭐⭐⭐⭐⭐   |    ⬜   |
|  5 | Traversal Termination   |    ⭐⭐⭐⭐⭐   |    ⬜   |
|  6 | Display List            |    ⭐⭐⭐⭐⭐   |    ⬜   |
|  7 | Count Nodes             |    ⭐⭐⭐⭐⭐   |    ⬜   |
|  8 | Traversal Dry Run       |    ⭐⭐⭐⭐⭐   |    ⬜   |
|  9 | Traversal Visualization |    ⭐⭐⭐⭐⭐   |    ⬜   |
| 10 | Traversal Edge Cases    |    ⭐⭐⭐⭐⭐   |    ⬜   |

---

# 💻 Hands-on Implementation Tasks

|  # | Task                            | Status |  R1 |  R2 |  R3 |  R4 |  R5 | Notes |
| -: | ------------------------------- | :----: | :-: | :-: | :-: | :-: | :-: | ----- |
|  1 | Implement `display()`           |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
|  2 | Implement `displayWithArrow()`  |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
|  3 | Implement `countNodes()`        |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
|  4 | Traverse Empty List             |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
|  5 | Traverse Single Node List       |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
|  6 | Traverse Multi Node List        |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
|  7 | Draw Traversal Pointer Movement |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
|  8 | Manually Trace Every Step       |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |

---

# 🎨 Pointer Visualization

## Before Traversal

```text
head
 │
 ▼

10 → 20 → 30 → 40 → NULL

current = head
```

---

## Step 1

```text
current

↓

10
```

---

## Step 2

```text
current

↓

20
```

---

## Step 3

```text
current

↓

30
```

---

## Step 4

```text
current

↓

40
```

---

## Finish

```text
current

↓

NULL

Traversal Complete
```

---

# 📐 Traversal Rules

| Rule | Description                                                                     |
| ---- | ------------------------------------------------------------------------------- |
| 1    | Always start from `head`.                                                       |
| 2    | Visit the current node before moving (unless the algorithm requires otherwise). |
| 3    | Move using `current = current.next`.                                            |
| 4    | Stop when `current == null`.                                                    |
| 5    | Never modify links while only traversing.                                       |

---

# 🧩 Skills Gained

* Pointer movement
* Sequential node access
* Display logic
* Counting nodes
* Safe traversal
* Visualization

---

# ⚠️ Common Mistakes

* ❌ Starting traversal from `head.next`.
* ❌ Forgetting to move `current`.
* ❌ Accessing `current.data` after `current` becomes `null`.
* ❌ Infinite loops caused by not updating the pointer.
* ❌ Modifying links while only traversing.

---

# 📈 Difficulty

🟢 Beginner

---

# 🏆 Completion Checklist

* [ ] I can traverse an empty Linked List.
* [ ] I can traverse a single-node Linked List.
* [ ] I can traverse a multi-node Linked List.
* [ ] I understand every pointer movement.
* [ ] I can manually dry-run traversal on paper.
* [ ] I can implement `display()` and `countNodes()`.
* [ ] I am ready to implement insertion operations.

---

# 📖 0.5 — Insertion Engine

> **Goal**
>
> Learn how to insert new nodes into a Linked List while maintaining the integrity of the data structure.
>
> Every insertion operation is about creating a new node and reconnecting pointers correctly.
>
> After completing this section, you should confidently insert nodes at the beginning, end, and any valid position without breaking the Linked List.

---

# 📖 Section Overview

|        Topic        | Status |
| :-----------------: | :----: |
|    Why Insertion?   |    ⬜   |
| Insert at Beginning |    ⬜   |
|    Insert at End    |    ⬜   |
|   Insert at Index   |    ⬜   |
|     Head Updates    |    ⬜   |
|     Tail Updates    |    ⬜   |
|     Size Updates    |    ⬜   |
|   Pointer Rewiring  |    ⬜   |
|      Edge Cases     |    ⬜   |
|       Dry Runs      |    ⬜   |

---

# 🎯 Learning Objectives

After completing **0.5**, you should be able to:

* [ ] Explain how insertion changes node connections.
* [ ] Insert at the beginning.
* [ ] Insert at the end.
* [ ] Insert at any valid index.
* [ ] Update `head` correctly.
* [ ] Update `tail` correctly.
* [ ] Maintain the correct `size`.
* [ ] Handle empty and single-node lists.

---

# 🧠 Why This Section Exists

Insertion is the first operation that teaches **pointer rewiring**.

Instead of only moving through nodes,

you now learn to **connect** new nodes safely.

Almost every advanced Linked List problem depends on this skill.

---

# 🧩 Mental Model

```text
Find Position

↓

Create New Node

↓

Reconnect Links

↓

Update Head / Tail

↓

Increase Size
```

---

# 📚 Topics

|  # | Topic                        | Importance | Status |
| -: | ---------------------------- | :--------: | :----: |
|  1 | Insert at Beginning          |    ⭐⭐⭐⭐⭐   |    ⬜   |
|  2 | Insert at End                |    ⭐⭐⭐⭐⭐   |    ⬜   |
|  3 | Insert at Index              |    ⭐⭐⭐⭐⭐   |    ⬜   |
|  4 | Insert into Empty List       |    ⭐⭐⭐⭐⭐   |    ⬜   |
|  5 | Insert into Single Node List |    ⭐⭐⭐⭐⭐   |    ⬜   |
|  6 | Insert into Multi Node List  |    ⭐⭐⭐⭐⭐   |    ⬜   |
|  7 | Head Update                  |    ⭐⭐⭐⭐⭐   |    ⬜   |
|  8 | Tail Update                  |    ⭐⭐⭐⭐⭐   |    ⬜   |
|  9 | Size Update                  |    ⭐⭐⭐⭐⭐   |    ⬜   |
| 10 | Pointer Rewiring             |    ⭐⭐⭐⭐⭐   |    ⬜   |

---

# 💻 Hands-on Implementation Tasks

|  # | Task                                | Status |  R1 |  R2 |  R3 |  R4 |  R5 | Notes |
| -: | ----------------------------------- | :----: | :-: | :-: | :-: | :-: | :-: | ----- |
|  1 | Implement `addFirst()`              |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
|  2 | Insert into Empty List              |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
|  3 | Insert into Single Node List        |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
|  4 | Implement `addLast()`               |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
|  5 | Update `tail` correctly             |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
|  6 | Implement `add(index)`              |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
|  7 | Insert at Index 0                   |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
|  8 | Insert at Last Index                |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
|  9 | Insert at Middle Index              |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
| 10 | Verify `size` after every insertion |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |

---

# 🎨 Pointer Visualization

## Insert at Beginning

### Before

```text
head
 │
 ▼

10 → 20 → 30 → NULL
```

### After

```text
head
 │
 ▼

5 → 10 → 20 → 30 → NULL
```

---

## Insert at End

### Before

```text
10 → 20 → 30 → NULL
               ▲
               │
             tail
```

### After

```text
10 → 20 → 30 → 40 → NULL
                    ▲
                    │
                  tail
```

---

## Insert in Middle

### Before

```text
10 → 20 → 40 → NULL
```

### After

```text
10 → 20 → 30 → 40 → NULL
```

---

# 📐 Insertion Rules

| Rule | Description                                                |
| ---- | ---------------------------------------------------------- |
| 1    | Always create the new node first.                          |
| 2    | Never lose the remaining list while reconnecting pointers. |
| 3    | Update `head` only when inserting at the beginning.        |
| 4    | Update `tail` only when inserting at the end.              |
| 5    | Increase `size` exactly once after a successful insertion. |

---

# 🧩 Skills Gained

* Pointer rewiring
* Head management
* Tail management
* Position-based insertion
* Safe node connection
* Linked List state management

---

# ⚠️ Common Mistakes

* ❌ Forgetting to reconnect the remaining list.
* ❌ Updating `head` or `tail` incorrectly.
* ❌ Forgetting to increment `size`.
* ❌ Losing nodes by overwriting `next`.
* ❌ Not handling an empty list separately.

---

# 📈 Difficulty

🟢 Beginner

---

# 🏆 Completion Checklist

* [ ] I can insert into an empty Linked List.
* [ ] I can insert at the beginning.
* [ ] I can insert at the end.
* [ ] I can insert at any valid index.
* [ ] I correctly maintain `head`, `tail`, and `size`.
* [ ] I understand every pointer change during insertion.
* [ ] I can dry-run insertion without looking at notes.

---

# 📖 0.6 — Deletion Engine

> **Goal**
>
> Learn how to safely remove nodes from a Linked List while maintaining a valid structure.
>
> Every deletion operation requires careful pointer updates to avoid losing nodes or corrupting the list.
>
> After completing this section, you should confidently delete nodes from any valid position while maintaining `head`, `tail`, and `size`.

---

# 📖 Section Overview

|       Topic       | Status |
| :---------------: | :----: |
|   Why Deletion?   |    ⬜   |
| Delete First Node |    ⬜   |
|  Delete Last Node |    ⬜   |
|  Delete at Index  |    ⬜   |
|  Delete by Value  |    ⬜   |
|    Head Updates   |    ⬜   |
|    Tail Updates   |    ⬜   |
|    Size Updates   |    ⬜   |
|     Edge Cases    |    ⬜   |
|      Dry Runs     |    ⬜   |

---

# 🎯 Learning Objectives

After completing **0.6**, you should be able to:

* [ ] Remove the first node.
* [ ] Remove the last node.
* [ ] Remove a node at any valid index.
* [ ] Remove a node by value.
* [ ] Update `head` correctly.
* [ ] Update `tail` correctly.
* [ ] Maintain the correct `size`.
* [ ] Handle empty and single-node lists safely.

---

# 🧠 Why This Section Exists

Deleting a node is **more dangerous than inserting one**.

One wrong pointer update can:

* lose the remaining list
* leave dangling references
* produce an incorrect `tail`
* make `size` incorrect

Deletion teaches careful pointer manipulation.

---

# 🧩 Mental Model

```text id="6i9mga"
Find Node

↓

Reconnect Previous Node

↓

Skip Current Node

↓

Update Head / Tail

↓

Decrease Size
```

---

# 📚 Topics

|  # | Topic              | Importance | Status |
| -: | ------------------ | :--------: | :----: |
|  1 | Delete First Node  |    ⭐⭐⭐⭐⭐   |    ⬜   |
|  2 | Delete Last Node   |    ⭐⭐⭐⭐⭐   |    ⬜   |
|  3 | Delete at Index    |    ⭐⭐⭐⭐⭐   |    ⬜   |
|  4 | Delete by Value    |    ⭐⭐⭐⭐    |    ⬜   |
|  5 | Delete Empty List  |    ⭐⭐⭐⭐⭐   |    ⬜   |
|  6 | Delete Single Node |    ⭐⭐⭐⭐⭐   |    ⬜   |
|  7 | Delete Middle Node |    ⭐⭐⭐⭐⭐   |    ⬜   |
|  8 | Head Update        |    ⭐⭐⭐⭐⭐   |    ⬜   |
|  9 | Tail Update        |    ⭐⭐⭐⭐⭐   |    ⬜   |
| 10 | Size Update        |    ⭐⭐⭐⭐⭐   |    ⬜   |

---

# 💻 Hands-on Implementation Tasks

|  # | Task                               | Status |  R1 |  R2 |  R3 |  R4 |  R5 | Notes |
| -: | ---------------------------------- | :----: | :-: | :-: | :-: | :-: | :-: | ----- |
|  1 | Implement `removeFirst()`          |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
|  2 | Delete from Empty List             |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
|  3 | Delete from Single Node List       |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
|  4 | Implement `removeLast()`           |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
|  5 | Implement `remove(index)`          |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
|  6 | Implement `remove(value)`          |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
|  7 | Delete Head Node                   |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
|  8 | Delete Tail Node                   |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
|  9 | Delete Middle Node                 |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
| 10 | Verify `size` after every deletion |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |

---

# 🎨 Pointer Visualization

## Delete First

### Before

```text
head
 │
 ▼

10 → 20 → 30 → NULL
```

### After

```text
head
 │
 ▼

20 → 30 → NULL
```

---

## Delete Last

### Before

```text
10 → 20 → 30 → NULL
               ▲
               │
             tail
```

### After

```text
10 → 20 → NULL
         ▲
         │
       tail
```

---

## Delete Middle

### Before

```text
10 → 20 → 30 → 40 → NULL
```

### After

```text
10 → 20 → 40 → NULL
```

---

# 📐 Deletion Rules

| Rule | Description                                             |
| ---- | ------------------------------------------------------- |
| 1    | Never lose the remaining list.                          |
| 2    | Update `head` when removing the first node.             |
| 3    | Update `tail` when removing the last node.              |
| 4    | Decrease `size` exactly once after successful deletion. |
| 5    | Handle empty and single-node lists separately.          |

---

# 🧩 Skills Gained

* Pointer disconnection
* Safe node removal
* Head management
* Tail management
* List integrity
* Edge case handling

---

# ⚠️ Common Mistakes

* ❌ Forgetting to reconnect the remaining list.
* ❌ Forgetting to update `tail`.
* ❌ Not decreasing `size`.
* ❌ Accessing `next` of a `null` node.
* ❌ Treating empty and single-node lists like normal cases.

---

# 📈 Difficulty

🟢 Beginner

---

# 🏆 Completion Checklist

* [ ] I can remove the first node.
* [ ] I can remove the last node.
* [ ] I can remove a node at any valid index.
* [ ] I can remove a node by value.
* [ ] I correctly maintain `head`, `tail`, and `size`.
* [ ] I understand every pointer change during deletion.
* [ ] I can dry-run every deletion operation without notes.

---

# 📖 0.7 — Access & Search Engine

> **Goal**
>
> Learn how to access, search, and update nodes in a Linked List without changing its overall structure.
>
> This section develops traversal-based thinking and prepares you for interview problems involving searching, indexing, and node retrieval.
>
> After completing this section, you should confidently locate, retrieve, and update nodes anywhere in the list.

---

# 📖 Section Overview

|          Topic         | Status |
| :--------------------: | :----: |
| Why Access Operations? |    ⬜   |
|     Get First Node     |    ⬜   |
|      Get Last Node     |    ⬜   |
|    Get Node by Index   |    ⬜   |
|     Search by Value    |    ⬜   |
|    Contains Element    |    ⬜   |
|       Find Index       |    ⬜   |
|       Update Node      |    ⬜   |
|     Traversal Reuse    |    ⬜   |
|       Edge Cases       |    ⬜   |

---

# 🎯 Learning Objectives

After completing **0.7**, you should be able to:

* [ ] Access the first node.
* [ ] Access the last node.
* [ ] Retrieve a node at any valid index.
* [ ] Search for a value.
* [ ] Check if an element exists.
* [ ] Find the index of a value.
* [ ] Update a node's value.
* [ ] Reuse traversal efficiently.

---

# 🧠 Why This Section Exists

Not every Linked List operation modifies the structure.

Many operations only need to

* locate a node
* inspect its value
* update its data

These operations are the foundation of searching and many interview questions.

---

# 🧩 Mental Model

```text
Start

↓

Traverse

↓

Find Target

↓

Access

↓

Return / Update
```

---

# 📚 Topics

|  # | Topic               | Importance | Status |
| -: | ------------------- | :--------: | :----: |
|  1 | getFirst()          |    ⭐⭐⭐⭐⭐   |    ⬜   |
|  2 | getLast()           |    ⭐⭐⭐⭐⭐   |    ⬜   |
|  3 | get(index)          |    ⭐⭐⭐⭐⭐   |    ⬜   |
|  4 | contains()          |    ⭐⭐⭐⭐⭐   |    ⬜   |
|  5 | indexOf()           |    ⭐⭐⭐⭐⭐   |    ⬜   |
|  6 | lastIndexOf()       |    ⭐⭐⭐⭐    |    ⬜   |
|  7 | set(index)          |    ⭐⭐⭐⭐⭐   |    ⬜   |
|  8 | findNode()          |    ⭐⭐⭐⭐    |    ⬜   |
|  9 | Traversal Reuse     |    ⭐⭐⭐⭐⭐   |    ⬜   |
| 10 | Boundary Validation |    ⭐⭐⭐⭐⭐   |    ⬜   |

---

# 💻 Hands-on Implementation Tasks

|  # | Task                      | Status |  R1 |  R2 |  R3 |  R4 |  R5 | Notes |
| -: | ------------------------- | :----: | :-: | :-: | :-: | :-: | :-: | ----- |
|  1 | Implement `getFirst()`    |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
|  2 | Implement `getLast()`     |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
|  3 | Implement `get(index)`    |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
|  4 | Implement `contains()`    |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
|  5 | Implement `indexOf()`     |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
|  6 | Implement `lastIndexOf()` |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
|  7 | Implement `set(index)`    |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
|  8 | Update node value         |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
|  9 | Handle invalid index      |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
| 10 | Verify boundary cases     |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |

---

# 🎨 Access Flow

## Get First

```text
head

↓

Return Node
```

---

## Get by Index

```text
head

↓

Traverse

↓

Target Index

↓

Return Node
```

---

## Search

```text
head

↓

Compare

↓

Found?

↓

YES → Return

NO

↓

Next Node
```

---

# 📐 Access Rules

| Rule | Description                                          |
| ---- | ---------------------------------------------------- |
| 1    | Validate index before traversal.                     |
| 2    | Never modify links while searching.                  |
| 3    | Stop traversal immediately after finding the target. |
| 4    | Return appropriate values when not found.            |
| 5    | Reuse traversal logic whenever possible.             |

---

# 🧩 Skills Gained

* Sequential access
* Searching
* Updating values
* Boundary validation
* Traversal reuse
* Read-only operations

---

# ⚠️ Common Mistakes

* ❌ Traversing past the end of the list.
* ❌ Forgetting index validation.
* ❌ Modifying pointers during search.
* ❌ Returning the wrong node for index-based access.
* ❌ Ignoring empty-list cases.

---

# 📈 Difficulty

🟢 Beginner

---

# 🏆 Completion Checklist

* [ ] I can access any node by index.
* [ ] I can retrieve the first and last node.
* [ ] I can search for a value.
* [ ] I can update a node's data.
* [ ] I understand how traversal supports searching.
* [ ] I can handle all boundary cases.
* [ ] I am ready for utility operations.

---

# 📖 0.8 — Utility & Collection Engine

> **Goal**
>
> Learn how to build the utility operations that transform a basic Linked List into a complete, reusable collection.
>
> These methods don't introduce new pointer patterns, but they reinforce traversal, class design, and API consistency.
>
> After completing this section, your `MyLinkedList` should feel like a real collection rather than just a chain of nodes.

---

# 📖 Section Overview

|         Topic         | Status |
| :-------------------: | :----: |
|    Utility Methods    |    ⬜   |
|      Empty Check      |    ⬜   |
|    Size Management    |    ⬜   |
|       Clear List      |    ⬜   |
| String Representation |    ⬜   |
|    Array Conversion   |    ⬜   |
|       Clone List      |    ⬜   |
|     Equality Check    |    ⬜   |
|  Collection Behaviour |    ⬜   |
|       API Polish      |    ⬜   |

---

# 🎯 Learning Objectives

After completing **0.8**, you should be able to:

* [ ] Check whether the list is empty.
* [ ] Return the current size.
* [ ] Remove every node safely.
* [ ] Display the list professionally.
* [ ] Convert the list into an array.
* [ ] Clone the list.
* [ ] Compare two linked lists.
* [ ] Build collection-style helper methods.

---

# 🧠 Why This Section Exists

Real data structures are more than

* insert
* delete
* search

They also provide

* utility
* debugging
* conversion
* comparison
* collection support

These methods make your Linked List complete.

---

# 🧩 Mental Model

```text
Linked List

↓

Core Operations

↓

Utility Operations

↓

Reusable Collection
```

---

# 📚 Topics

|  # | Topic                | Importance | Status |
| -: | -------------------- | :--------: | :----: |
|  1 | isEmpty()            |    ⭐⭐⭐⭐⭐   |    ⬜   |
|  2 | size()               |    ⭐⭐⭐⭐⭐   |    ⬜   |
|  3 | clear()              |    ⭐⭐⭐⭐⭐   |    ⬜   |
|  4 | toString()           |    ⭐⭐⭐⭐⭐   |    ⬜   |
|  5 | toArray()            |    ⭐⭐⭐⭐    |    ⬜   |
|  6 | clone()              |    ⭐⭐⭐⭐    |    ⬜   |
|  7 | equals()             |    ⭐⭐⭐⭐    |    ⬜   |
|  8 | hashCode() (Concept) |     ⭐⭐⭐    |    ⬜   |
|  9 | Collection Behaviour |    ⭐⭐⭐⭐    |    ⬜   |
| 10 | API Consistency      |    ⭐⭐⭐⭐⭐   |    ⬜   |

---

# 💻 Hands-on Implementation Tasks

|  # | Task                        | Status |  R1 |  R2 |  R3 |  R4 |  R5 | Notes     |
| -: | --------------------------- | :----: | :-: | :-: | :-: | :-: | :-: | --------- |
|  1 | Implement `isEmpty()`       |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |           |
|  2 | Implement `size()`          |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |           |
|  3 | Implement `clear()`         |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |           |
|  4 | Implement `toString()`      |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |           |
|  5 | Implement `toArray()`       |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |           |
|  6 | Implement `clone()`         |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  | Deep Copy |
|  7 | Implement `equals()`        |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |           |
|  8 | Test all utility methods    |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |           |
|  9 | Verify collection behaviour |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |           |
| 10 | Complete API review         |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |           |

---

# 🎨 Utility Flow

## Empty Check

```text
Linked List

↓

head == null ?

↓

YES

↓

Empty
```

---

## Clear

```text
Before

↓

10 → 20 → 30

↓

Clear

↓

head = null

tail = null

size = 0
```

---

## Clone

```text
Original

↓

10 → 20 → 30

↓

Clone

↓

10 → 20 → 30

(New Nodes)
```

---

# 📐 Utility Rules

| Rule | Description                                                   |
| ---- | ------------------------------------------------------------- |
| 1    | Never modify the original list unless the method requires it. |
| 2    | `size()` should always be O(1).                               |
| 3    | `isEmpty()` should depend on list state, not traversal.       |
| 4    | `clear()` must reset `head`, `tail`, and `size`.              |
| 5    | `clone()` should create independent nodes.                    |

---

# 🧩 Skills Gained

* Collection design
* Helper methods
* API consistency
* Object comparison
* Data conversion
* Deep copy vs shallow copy

---

# ⚠️ Common Mistakes

* ❌ Traversing the list to calculate `size()` when a size field already exists.
* ❌ Forgetting to reset `tail` in `clear()`.
* ❌ Returning a shallow copy from `clone()`.
* ❌ Comparing references instead of contents in `equals()`.
* ❌ Leaving the list in an inconsistent state after utility operations.

---

# 📈 Difficulty

🟢 Beginner

---

# 🏆 Completion Checklist

* [ ] I can determine whether the list is empty.
* [ ] I can return the size in O(1).
* [ ] I can clear the list safely.
* [ ] I can convert the list into a readable string.
* [ ] I can clone a Linked List correctly.
* [ ] I can compare two Linked Lists.
* [ ] My `MyLinkedList` behaves like a reusable Java collection.

---

# 📖 0.9 — Pointer Manipulation & Internal Working

> **Goal**
>
> Develop deep intuition for how pointers change during Linked List operations.
>
> Instead of learning new APIs, you'll focus on understanding and visualizing pointer rewiring, node movement, and maintaining Linked List invariants.
>
> After completing this section, pointer manipulation should become second nature.

---

# 📖 Section Overview

|         Topic         | Status |
| :-------------------: | :----: |
|    Pointer Thinking   |    ⬜   |
|    Pointer Rewiring   |    ⬜   |
|     Reverse Links     |    ⬜   |
|       Swap Nodes      |    ⬜   |
|    Pointer Tracing    |    ⬜   |
|        Dry Runs       |    ⬜   |
|  Memory Visualization |    ⬜   |
|       Invariants      |    ⬜   |
|       Edge Cases      |    ⬜   |
| Interview Preparation |    ⬜   |

---

# 🎯 Learning Objectives

After completing **0.9**, you should be able to:

* [ ] Explain every pointer change.
* [ ] Reverse pointer directions mentally.
* [ ] Swap nodes without losing references.
* [ ] Trace pointer movement on paper.
* [ ] Maintain list invariants after modifications.
* [ ] Explain every operation during an interview.

---

# 🧠 Why This Section Exists

Most students memorize code like:

```java
prev = current;
current = next;
```

without understanding **why** those assignments are needed.

This section teaches you to think in terms of **connections**, not code.

---

# 🧩 Mental Model

```text
Current Structure

↓

Protect Remaining List

↓

Reconnect Pointers

↓

Verify Head / Tail

↓

List Remains Valid
```

---

# 📚 Topics

|  # | Topic                          | Importance | Status |
| -: | ------------------------------ | :--------: | :----: |
|  1 | Pointer Rewiring               |    ⭐⭐⭐⭐⭐   |    ⬜   |
|  2 | Protect Remaining List         |    ⭐⭐⭐⭐⭐   |    ⬜   |
|  3 | Reverse Pointer Direction      |    ⭐⭐⭐⭐⭐   |    ⬜   |
|  4 | Swap Adjacent Nodes            |    ⭐⭐⭐⭐    |    ⬜   |
|  5 | Swap Non-Adjacent Nodes        |    ⭐⭐⭐⭐    |    ⬜   |
|  6 | Head & Tail Updates            |    ⭐⭐⭐⭐⭐   |    ⬜   |
|  7 | Pointer Dry Runs               |    ⭐⭐⭐⭐⭐   |    ⬜   |
|  8 | Memory Visualization           |    ⭐⭐⭐⭐⭐   |    ⬜   |
|  9 | Linked List Invariants         |    ⭐⭐⭐⭐⭐   |    ⬜   |
| 10 | Interview Explanation Practice |    ⭐⭐⭐⭐⭐   |    ⬜   |

---

# 💻 Hands-on Implementation Tasks

|  # | Task                                                   | Status |  R1 |  R2 |  R3 |  R4 |  R5 | Notes |
| -: | ------------------------------------------------------ | :----: | :-: | :-: | :-: | :-: | :-: | ----- |
|  1 | Trace pointer movement manually                        |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
|  2 | Draw insertion pointer changes                         |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
|  3 | Draw deletion pointer changes                          |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
|  4 | Draw reverse pointer changes                           |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
|  5 | Reverse a 5-node list on paper                         |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
|  6 | Swap two nodes manually                                |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
|  7 | Verify `head`, `tail`, and `size` after each operation |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
|  8 | Explain every pointer update aloud                     |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
|  9 | Identify broken links in incorrect diagrams            |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
| 10 | Complete a full dry run without code                   |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |

---

# 🎨 Pointer Visualization

## Before Reverse

```text
head
 │
 ▼

10 → 20 → 30 → 40 → NULL
```

---

## During Reverse

```text
Processed

NULL ← 10 ← 20

Remaining

30 → 40 → NULL
```

---

## After Reverse

```text
head
 │
 ▼

40 → 30 → 20 → 10 → NULL
```

---

# 📐 Pointer Rules

| Rule | Description                                                           |
| ---- | --------------------------------------------------------------------- |
| 1    | Never overwrite a reference before saving the next node.              |
| 2    | Keep the remaining list connected until you're ready to reconnect it. |
| 3    | Update `head` and `tail` only after pointer rewiring is complete.     |
| 4    | Verify list invariants after every operation.                         |
| 5    | Draw the operation if you're unsure.                                  |

---

# 🧩 Skills Gained

* Pointer intuition
* Link rewiring
* Reverse thinking
* Dry-run confidence
* Memory visualization
* Interview explanation skills

---

# ⚠️ Common Mistakes

* ❌ Losing the remaining list by overwriting `next`.
* ❌ Updating `head` too early.
* ❌ Forgetting to update `tail` after reversal.
* ❌ Breaking list invariants.
* ❌ Trying to memorize code instead of understanding pointer movement.

---

# 📈 Difficulty

🟡 Intermediate

---

# 🏆 Completion Checklist

* [ ] I understand every pointer update.
* [ ] I can reverse a Linked List on paper.
* [ ] I can trace insertion and deletion without code.
* [ ] I can identify incorrect pointer connections.
* [ ] I can explain pointer rewiring confidently.
* [ ] I am ready to move from implementation to optimization.

---

# 📖 0.10 — Complexity Analysis & Performance Thinking

> **Goal**
>
> Understand **why** each Linked List operation has its time and space complexity.
>
> Learn to analyze performance, compare Linked Lists with Arrays, and make design decisions based on complexity instead of memorization.
>
> After completing this section, you should be able to justify every complexity during interviews.

---

# 📖 Section Overview

|         Topic        | Status |
| :------------------: | :----: |
|    Time Complexity   |    ⬜   |
|   Space Complexity   |    ⬜   |
|    Traversal Cost    |    ⬜   |
|   Insert Complexity  |    ⬜   |
|   Delete Complexity  |    ⬜   |
|   Search Complexity  |    ⬜   |
|     Head vs Tail     |    ⬜   |
| Linked List vs Array |    ⬜   |
|  Complexity Analysis |    ⬜   |
| Interview Discussion |    ⬜   |

---

# 🎯 Learning Objectives

After completing **0.10**, you should be able to:

* [ ] Explain time complexity of every operation.
* [ ] Explain auxiliary space complexity.
* [ ] Compare Linked Lists with Arrays.
* [ ] Explain why some operations are O(1) while others are O(n).
* [ ] Choose the correct data structure based on requirements.
* [ ] Justify complexity during interviews.

---

# 🧠 Why This Section Exists

Many students memorize:

```text
Insertion = O(1)

Deletion = O(n)
```

But interviews ask

> **Why?**

Understanding complexity helps you write better algorithms and choose the right data structure.

---

# 🧩 Mental Model

```text
Operation

↓

Traversal Needed?

↓

YES

↓

O(n)

NO

↓

O(1)
```

---

# 📚 Topics

|  # | Topic                          | Importance | Status |
| -: | ------------------------------ | :--------: | :----: |
|  1 | Traversal Complexity           |    ⭐⭐⭐⭐⭐   |    ⬜   |
|  2 | Insertion Complexity           |    ⭐⭐⭐⭐⭐   |    ⬜   |
|  3 | Deletion Complexity            |    ⭐⭐⭐⭐⭐   |    ⬜   |
|  4 | Access Complexity              |    ⭐⭐⭐⭐⭐   |    ⬜   |
|  5 | Search Complexity              |    ⭐⭐⭐⭐⭐   |    ⬜   |
|  6 | Space Complexity               |    ⭐⭐⭐⭐⭐   |    ⬜   |
|  7 | Linked List vs Array           |    ⭐⭐⭐⭐⭐   |    ⬜   |
|  8 | Head vs Tail Optimization      |    ⭐⭐⭐⭐⭐   |    ⬜   |
|  9 | Trade-offs                     |    ⭐⭐⭐⭐⭐   |    ⬜   |
| 10 | Interview Complexity Questions |    ⭐⭐⭐⭐⭐   |    ⬜   |

---

# 💻 Hands-on Analysis Tasks

|  # | Task                        | Status |  R1 |  R2 |  R3 |  R4 |  R5 | Notes |
| -: | --------------------------- | :----: | :-: | :-: | :-: | :-: | :-: | ----- |
|  1 | Analyze `addFirst()`        |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
|  2 | Analyze `addLast()`         |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
|  3 | Analyze `removeFirst()`     |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
|  4 | Analyze `removeLast()`      |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
|  5 | Analyze `get(index)`        |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
|  6 | Compare with Array          |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
|  7 | Explain complexity verbally |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
|  8 | Complete complexity table   |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |

---

# 📊 Complexity Summary

| Operation              | Time | Space |
| ---------------------- | ---- | ----- |
| Add First              | O(1) | O(1)  |
| Add Last *(with tail)* | O(1) | O(1)  |
| Add at Index           | O(n) | O(1)  |
| Remove First           | O(1) | O(1)  |
| Remove Last            | O(n) | O(1)  |
| Get by Index           | O(n) | O(1)  |
| Search                 | O(n) | O(1)  |
| Reverse                | O(n) | O(1)  |

---

# 🧩 Skills Gained

* Complexity analysis
* Performance thinking
* Data structure comparison
* Interview explanation
* Optimization mindset

---

# ⚠️ Common Mistakes

* ❌ Memorizing complexity without understanding traversal.
* ❌ Ignoring the effect of `tail`.
* ❌ Forgetting auxiliary space.
* ❌ Comparing Linked Lists and Arrays incorrectly.

---

# 📈 Difficulty

🟢 Beginner

---

# 🏆 Completion Checklist

* [ ] I can explain every time complexity.
* [ ] I can compare Linked Lists with Arrays.
* [ ] I understand the effect of `head` and `tail`.
* [ ] I can justify my answers in interviews.
* [ ] I am ready to build the complete Linked List implementation.

---

# ➡️ Next Section

# **0.11 — Final Project: Build Your Own MyLinkedList**

> This is the capstone of Part 0. You will combine everything learned in Sections **0.1–0.10** to build a complete `MyLinkedList` implementation from scratch. By the end of this project, you'll have your own reusable Linked List library with all core operations, proper testing, and the confidence to move into Part 1 interview patterns without relying on memorized solutions.

---
After reviewing the entire curriculum, I would **definitely add one final section**.

Without it, Part 0 teaches implementation but doesn't verify mastery.

So I would end with a **graduation section**.

---

# 📖 0.12 — Testing, Validation & Interview Readiness

> **Goal**
>
> Validate every Linked List operation through systematic testing, dry runs, edge cases, and interview-style self-assessment.
>
> This is the graduation section of Part 0.
>
> After completing this section, you should have complete confidence in your Linked List implementation and be ready for Part 1 interview patterns.

---

# 📖 Section Overview

|          Topic         | Status |
| :--------------------: | :----: |
|      Unit Testing      |    ⬜   |
|       Edge Cases       |    ⬜   |
|        Dry Runs        |    ⬜   |
|     Pointer Tracing    |    ⬜   |
| Invariant Verification |    ⬜   |
|     API Validation     |    ⬜   |
|    Complexity Review   |    ⬜   |
|   Interview Questions  |    ⬜   |
|    Final Assessment    |    ⬜   |
|  Graduation Checklist  |    ⬜   |

---

# 🎯 Learning Objectives

After completing **0.12**, you should be able to:

* [ ] Verify every Linked List operation.
* [ ] Handle every edge case.
* [ ] Dry-run any Linked List algorithm.
* [ ] Explain every pointer update.
* [ ] Verify all Linked List invariants.
* [ ] Answer common Linked List interview questions.
* [ ] Move to Part 1 with confidence.

---

# 🧠 Why This Section Exists

Writing code is only half the journey.

A good engineer also knows how to

* verify
* debug
* explain
* test

their implementation.

This section ensures your Linked List is **correct**, **robust**, and **interview-ready**.

---

# 🧩 Mental Model

```text
Implement

↓

Test

↓

Break

↓

Fix

↓

Validate

↓

Master
```

---

# 📚 Topics

|  # | Topic                          | Importance | Status |
| -: | ------------------------------ | :--------: | :----: |
|  1 | Unit Testing                   |    ⭐⭐⭐⭐⭐   |    ⬜   |
|  2 | Edge Case Testing              |    ⭐⭐⭐⭐⭐   |    ⬜   |
|  3 | Pointer Dry Runs               |    ⭐⭐⭐⭐⭐   |    ⬜   |
|  4 | Invariant Verification         |    ⭐⭐⭐⭐⭐   |    ⬜   |
|  5 | API Validation                 |    ⭐⭐⭐⭐⭐   |    ⬜   |
|  6 | Complexity Revision            |    ⭐⭐⭐⭐⭐   |    ⬜   |
|  7 | Interview Explanation Practice |    ⭐⭐⭐⭐⭐   |    ⬜   |
|  8 | Debugging Exercises            |    ⭐⭐⭐⭐    |    ⬜   |
|  9 | Final Self Assessment          |    ⭐⭐⭐⭐⭐   |    ⬜   |
| 10 | Graduation Review              |    ⭐⭐⭐⭐⭐   |    ⬜   |

---

# 💻 Hands-on Validation Tasks

|  # | Task                                                    | Status |  R1 |  R2 |  R3 |  R4 |  R5 | Notes |
| -: | ------------------------------------------------------- | :----: | :-: | :-: | :-: | :-: | :-: | ----- |
|  1 | Test every insertion method                             |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
|  2 | Test every deletion method                              |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
|  3 | Test every access method                                |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
|  4 | Test utility methods                                    |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
|  5 | Verify all edge cases                                   |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
|  6 | Draw complete pointer traces                            |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
|  7 | Verify `head`, `tail`, and `size` after every operation |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
|  8 | Review complexity of every method                       |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
|  9 | Answer interview-style conceptual questions             |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |
| 10 | Complete final implementation review                    |    ⬜   |  ⬜  |  ⬜  |  ⬜  |  ⬜  |  ⬜  |       |

---

# 🧪 Edge Case Checklist

| Case                   | Status |
| ---------------------- | :----: |
| Empty List             |    ⬜   |
| Single Node List       |    ⬜   |
| Two Node List          |    ⬜   |
| Multiple Node List     |    ⬜   |
| Insert at Beginning    |    ⬜   |
| Insert at End          |    ⬜   |
| Delete Beginning       |    ⬜   |
| Delete End             |    ⬜   |
| Invalid Index          |    ⬜   |
| Search Missing Element |    ⬜   |

---

# 📋 Final API Checklist

Your `MyLinkedList` should support:

## Construction

* [ ] Constructor
* [ ] Node
* [ ] Head
* [ ] Tail
* [ ] Size

---

## Traversal

* [ ] display()
* [ ] countNodes()

---

## Insertion

* [ ] addFirst()
* [ ] addLast()
* [ ] add(index)

---

## Deletion

* [ ] removeFirst()
* [ ] removeLast()
* [ ] remove(index)
* [ ] remove(value)

---

## Access

* [ ] getFirst()
* [ ] getLast()
* [ ] get(index)
* [ ] set(index)

---

## Search

* [ ] contains()
* [ ] indexOf()
* [ ] lastIndexOf()

---

## Utility

* [ ] isEmpty()
* [ ] size()
* [ ] clear()
* [ ] toString()
* [ ] toArray()
* [ ] clone()
* [ ] equals()

---

# 🏆 Graduation Checklist

* [ ] I understand Java references.
* [ ] I understand Node anatomy.
* [ ] I can build a Linked List from scratch.
* [ ] I understand every pointer update.
* [ ] I can explain every operation without memorizing code.
* [ ] I know the complexity of every method.
* [ ] I can debug pointer-related bugs.
* [ ] I have tested every method thoroughly.
* [ ] My `MyLinkedList` implementation is complete.
* [ ] I am ready to begin **Part 1 – Fundamental Linked List Interview Patterns**.

---

# 🎓 Part 0 Completion

After completing **Part 0**, you will have:

✅ Built your own `MyLinkedList`

✅ Mastered Java references and pointer manipulation

✅ Implemented all core Linked List operations

✅ Understood time and space complexity

✅ Developed debugging and testing skills

✅ Built the intuition required for interview problems

---

# 🚀 Next Stage

## **PART 1 – Fundamental Linked List Interview Patterns**

You will now stop learning **how to build** a Linked List and start learning **how to solve interview problems** using the strong implementation foundation you've created.

---

## Final review of Part 0

After designing all twelve sections, I think **Part 0 is complete and well-balanced**. It progresses naturally:

```text
0.1 Memory & References
        ↓
0.2 Node Design
        ↓
0.3 MyLinkedList Design
        ↓
0.4 Traversal
        ↓
0.5 Insertion
        ↓
0.6 Deletion
        ↓
0.7 Access & Search
        ↓
0.8 Utility & Collection
        ↓
0.9 Pointer Manipulation
        ↓
0.10 Complexity
        ↓
0.11 Build Complete MyLinkedList
        ↓
0.12 Testing & Interview Readiness
        ↓
PART 1
```

I would keep this sequence unchanged because each section introduces exactly one new idea while building on everything before it. This gives you a solid implementation foundation before you begin the interview-focused Linked List patterns.
