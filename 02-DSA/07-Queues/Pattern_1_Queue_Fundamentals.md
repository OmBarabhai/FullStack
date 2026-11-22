# Pattern 1 - Queue Fundamentals

**Focus:** Understand the FIFO data structure and implement its fundamental operations.

## Pattern overview

A Queue follows **FIFO (First In, First Out)** order.

| Term | Meaning |
|---|---|
| Front | The element that will be removed next |
| Rear | The position where a new element is inserted |
| Enqueue | Insert an element at the rear |
| Dequeue | Remove an element from the front |
| Peek | Read the front element without removing it |

## Revision navigation

1. Queue implementation using a singly linked list (custom implementation)
2. Implement Queue Using Linked List — Code360
3. Implement Queue Using Arrays — Code360
4. Implement Queue Using Stacks — LeetCode
5. Implement Stack Using Queues — LeetCode and Code360

---

## 1. Queue Implementation Using a Singly Linked List

**Implementation:** Queue using a singly linked list with `head`, `tail`, and `size`.

### Your Java Code — Corrected

Your submitted structure and method names are kept. Two small fixes are included:

1. `size++` must run after both branches of `enqueue()`. In your submitted code, the empty-Queue branch returned before increasing `size`.
2. After removing the last node, set `tail = null` too. This keeps both pointers correct when the Queue becomes empty.

```java
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Queue {
    Node head;
    Node tail;
    int size;

    Queue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /*----------------- Public Functions of Queue -----------------*/

    boolean isEmpty() {
        if (head == null) {
            return true;
        } else {
            return false;
        }
    }

    void enqueue(int data) {
        Node newNode = new Node(data);

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = tail.next;
        }

        size++;
    }

    int dequeue() {
        if (isEmpty()) {
            return -1;
        }

        int removeEle = head.data;
        head = head.next;
        size--;

        if (head == null) {
            tail = null;
        }

        return removeEle;
    }

    int front() {
        if (isEmpty()) {
            return -1;
        }

        return head.data;
    }
}
```

### Where You Were Getting Stuck

| Your submitted code | What happens | Correction |
|---|---|---|
| `return;` inside the empty branch of `enqueue()` | The first node is added, but `size++` is skipped | Move `size++` after the `if-else` |
| No tail update after `dequeue()` removes the last node | `head` becomes `null`, but `tail` still points to the removed node | When `head == null`, set `tail = null` |
| `tail.next = newNode; tail = tail.next;` | This is correct | Keep it; `tail` moves to the new last node |

**What you already did correctly:**
- Created a new node for each insertion.
- Used `head` for removal and `tail` for insertion.
- Added directly after `tail` without traversing the list.
- Returned `-1` when `dequeue()` or `front()` is called on an empty Queue.

### Practical Dry Run

Perform these operations in order:

```text
enqueue(10)
enqueue(20)
enqueue(30)
front()
dequeue()
dequeue()
dequeue()
front()
enqueue(40)
```

| Operation | Linked List (`head` → `tail`) | `head` | `tail` | `size` | Result |
|---|---|---:|---:|---:|---:|
| Start | Empty | `null` | `null` | 0 | — |
| `enqueue(10)` | `10` | 10 | 10 | 1 | — |
| `enqueue(20)` | `10 → 20` | 10 | 20 | 2 | — |
| `enqueue(30)` | `10 → 20 → 30` | 10 | 30 | 3 | — |
| `front()` | `10 → 20 → 30` | 10 | 30 | 3 | 10 |
| `dequeue()` | `20 → 30` | 20 | 30 | 2 | 10 |
| `dequeue()` | `30` | 30 | 30 | 1 | 20 |
| `dequeue()` | Empty | `null` | `null` | 0 | 30 |
| `front()` | Empty | `null` | `null` | 0 | -1 |
| `enqueue(40)` | `40` | 40 | 40 | 1 | — |

### Follow the Pointer Changes

**First insertion — `enqueue(10)`**

```java
head = newNode;
tail = newNode;
size++;
```

Both pointers refer to the same node because the Queue has only one element.

```text
head, tail
   |
  [10 | null]
```

**Second insertion — `enqueue(20)`**

```java
tail.next = newNode;
tail = tail.next;
size++;
```

First connect node `10` to node `20`. Then move `tail` to node `20`.

```text
head                 tail
 |                    |
[10 | next] ------> [20 | null]
```

**First removal — `dequeue()`**

```java
int removeEle = head.data;
head = head.next;
size--;
```

The old head value (`10`) is returned. Then `head` moves to node `20`.

```text
head, tail
   |
  [20 | null]
```

**Removing the last node**

After removing node `30`:

```java
head = head.next;  // head becomes null
size--;

if (head == null) {
    tail = null;
}
```

Both pointers must now indicate an empty Queue.

```text
head = null
tail = null
size = 0
```

This makes the next `enqueue(40)` a fresh first insertion.

### Complexity

| Operation | Time |
|---|---:|
| `enqueue()` | `O(1)` |
| `dequeue()` | `O(1)` |
| `front()` | `O(1)` |
| `isEmpty()` | `O(1)` |

**Space:** `O(n)` for `n` linked-list nodes.

### Quick Revision

```text
ENQUEUE:
Create new node
If empty -> head = tail = newNode
Else -> tail.next = newNode; tail = newNode
size++

DEQUEUE:
If empty -> return -1
Save head.data
head = head.next
size--
If head == null -> tail = null
Return saved value

FRONT:
Return head.data (if not empty)
```

**Remember:** Insert at `tail`, remove from `head`. When the last node is removed, reset both `head` and `tail`.

---

## 2. Implement Queue Using Linked List — Code360

**Problem:** [Code360 — Implement Queue Using Linked List](https://www.naukri.com/code360/problems/implement-queue-using-linked-list_8161235?leftPanelTabValue=PROBLEM&count=25&search=&sort_entity=order&sort_order=ASC)

**Pattern:** Queue Fundamentals → Linked List Implementation

**Core idea:** Use a singly linked list with two pointers:
- `front` points to the first node, which is removed by `pop()`.
- `rear` points to the last node, where `push()` inserts a new node.

### Java implementation

```java
public class Solution extends Queue {
    public void push(int x) {
        Node newNode = new Node(x);

        if (front == null) {
            front = newNode;
            rear = newNode;
            return;
        }

        rear.next = newNode;
        rear = newNode;
    }

    public int pop() {
        if (front == null) {
            return -1;
        }

        int frontData = front.data;
        front = front.next;
        return frontData;
    }
}
```

### Core logic

**`push(x)` — Insert at the rear**
1. Create a new node.
2. If the Queue is empty, set both `front` and `rear` to the new node.
3. Otherwise, connect `rear.next` to the new node.
4. Move `rear` to the newly inserted node.

**`pop()` — Remove from the front**
1. If `front` is `null`, return `-1`.
2. Store the front node's data.
3. Move `front` to `front.next`.
4. Return the stored value.

### Important pointer states

| Queue state | `front` | `rear` |
|---|---|---|
| Empty | `null` | `null` |
| One node | Points to the only node | Points to the same node |
| Multiple nodes | Points to the first node | Points to the last node |

### Code observation

When `pop()` removes the last remaining node, `front` becomes `null`, but `rear` still points to the removed node. The empty-Queue state should have both pointers set to `null`. Resetting `rear` when `front` becomes `null` is necessary before a later `push()`.

### Complexity

| Operation | Time complexity |
|---|---:|
| `push()` | `O(1)` |
| `pop()` | `O(1)` |

**Space complexity:** `O(n)` for storing `n` linked-list nodes.

---

## 3. Implement Queue Using Arrays — Code360

**Problem:** [Code360 — Implement Queue Using Arrays](https://www.naukri.com/code360/problems/implement-queue-using-arrays_17942095?leftPanelTabValue=SUBMISSION)

**Type:** Linear Queue using an Array  
**Your pointer convention:** `rear = -1`, then increment before insertion.

### Your Java Implementation

Preserved exactly as you submitted it:

```java
public class Solution {

    class Queue {
        int[] arr;
        int front;
        int rear;
        int size;
        int capacity;

        Queue() {
            front = 0;
            rear = -1;
            size = 0;
            arr = new int[100001];
            capacity = arr.length;
        }

        public void enqueue(int e) {
            if (isFull()) {
                return;
            }else{
                rear++;
                arr[rear] = e;
                size++;
            }
        }

        public int dequeue() {
            if (isEmpty()) {
                return -1;
            }else{
                int removeEle = arr[front];
                arr[front] = -1;
                front++;
                size--;
                return removeEle;
            }
        }

        public int Front() {
            if (isEmpty()) {
                return -1;
            }else{
                return arr[front];
            }   
        }

        public int Rear() {
            if (isEmpty()) {
                return -1;
            }else{
                return arr[rear];
            }
        }

        public boolean isEmpty() {
            if (size == 0) {
                return true;
            }else{
                return false;
            }
        }

        public boolean isFull() {
            if (rear == capacity - 1) {
                return true;
            }else{
                return false;
            }
        }
    }
}
```

### What to remember

| Variable | In your code |
|---|---|
| `front` | Index of the first element to remove |
| `rear` | Index of the last inserted element |
| `size` | Current number of elements |
| `capacity` | Array length |

Your code uses these rules:

```java
// Enqueue
rear++;
arr[rear] = e;

// Dequeue
int removeEle = arr[front];
arr[front] = -1;
front++;

// Front and Rear
arr[front]
arr[rear]
```

Conditions:

```java
// Empty
size == 0

// Full
rear == capacity - 1
```

### Practical Dry Run

Assume a small array with `capacity = 4`. This makes the pointer movement easy to see.

Initial state:

```text
Array:  [-,  -,  -,  -]
Index:   0   1   2   3

front = 0
rear  = -1
size  = 0
```

| Operation | Returned value | Array after operation | `front` | `rear` | `size` |
|---|---:|---|---:|---:|---:|
| `enqueue(10)` | — | `[10, -, -, -]` | 0 | 0 | 1 |
| `enqueue(20)` | — | `[10, 20, -, -]` | 0 | 1 | 2 |
| `enqueue(30)` | — | `[10, 20, 30, -]` | 0 | 2 | 3 |
| `Front()` | `10` | `[10, 20, 30, -]` | 0 | 2 | 3 |
| `Rear()` | `30` | `[10, 20, 30, -]` | 0 | 2 | 3 |
| `dequeue()` | `10` | `[-1, 20, 30, -]` | 1 | 2 | 2 |
| `enqueue(40)` | — | `[-1, 20, 30, 40]` | 1 | 3 | 3 |
| `isFull()` | `true` | `[-1, 20, 30, 40]` | 1 | 3 | 3 |
| `enqueue(50)` | No insertion | `[-1, 20, 30, 40]` | 1 | 3 | 3 |
| `dequeue()` | `20` | `[-1, -1, 30, 40]` | 2 | 3 | 2 |
| `Front()` | `30` | `[-1, -1, 30, 40]` | 2 | 3 | 2 |
| `Rear()` | `40` | `[-1, -1, 30, 40]` | 2 | 3 | 2 |

### What happened here?

After `dequeue()` removes `10`, index `0` becomes free.

But when we later insert `40`, the `rear` moves forward to index `3`. It does not go back to index `0`.

Now `rear = 3` and `capacity = 4`:

```java
rear == capacity - 1
3 == 4 - 1
true
```

So `enqueue(50)` is rejected, even though index `0` is empty.

**This is the limitation of this Linear Queue:** it does not reuse array positions that were freed at the front.

### Small pointer trace

```text
Start:
front = 0, rear = -1

After enqueue(10):
front = 0, rear = 0

After enqueue(20):
front = 0, rear = 1

After dequeue():
front = 1, rear = 1

After enqueue(30):
front = 1, rear = 2
```

- `rear` moves forward during enqueue.
- `front` moves forward during dequeue.
- `size` increases after enqueue and decreases after dequeue.

### Complexity

| Operation | Time |
|---|---:|
| `enqueue()` | `O(1)` |
| `dequeue()` | `O(1)` |
| `Front()` | `O(1)` |
| `Rear()` | `O(1)` |
| `isEmpty()` | `O(1)` |
| `isFull()` | `O(1)` |

**Space:** `O(capacity)` for the array.

### Quick Revision

```text
Initial: front = 0, rear = -1

Enqueue: rear++, then arr[rear] = e, size++
Dequeue: read arr[front], then front++, size--
Front:   arr[front]
Rear:    arr[rear]
Empty:   size == 0
Full:    rear == capacity - 1
```

**Do not confuse this with Circular Queue.** This is the basic Linear Queue implementation you are learning first.

---

## 4. Implement Queue Using Stacks

Queue can be implemented using two stacks in two ways. The difference is which operation performs the element transfers.

### Approach 1 — Costly `deQueue()` / `pop()`

**Problems:**
- [Code360 — Queue Using Stack](https://www.naukri.com/code360/problems/queue-using-stack_799482?leftPanelTabValue=SUBMISSION)
- [LeetCode 232 — Implement Queue using Stacks](https://leetcode.com/problems/implement-queue-using-stacks/)

**Core idea:** Insert each new element directly into `st`. To remove or read the Queue front, move all elements except the bottom one into `help`. The remaining bottom element is the oldest element.

#### Java implementation — Code360

```java
import java.util.*;

public class Solution {
    static class Queue {
        Deque<Integer> st;
        Deque<Integer> help;

        Queue() {
            st = new ArrayDeque<>();
            help = new ArrayDeque<>();
        }

        void enQueue(int val) {
            st.push(val);
        }

        int deQueue() {
            if (st.isEmpty()) {
                return -1;
            }
            while (st.size() != 1) {
                help.push(st.pop());
            }
            int frontDataPop = st.pop();
            while (!help.isEmpty()) {
                st.push(help.pop());
            }
            return frontDataPop;
        }

        int peek() {
            if (st.isEmpty()) {
                return -1;
            }
            while (st.size() != 1) {
                help.push(st.pop());
            }
            int frontDataPeek = st.peek();
            while (!help.isEmpty()) {
                st.push(help.pop());
            }
            return frontDataPeek;
        }

        boolean isEmpty() {
            return st.isEmpty();
        }
    }
}
```

#### How it works

- `enQueue(val)`: Push the new value onto `st`.
- `deQueue()`: Move all elements except the bottom one into `help`. Remove the bottom element, then restore the remaining elements.
- `peek()`: Move all elements except the bottom one into `help`. Read the bottom element without removing it, then restore the elements.
- `isEmpty()`: Check whether `st` is empty.

**Remember:** The bottom of `st` represents the Queue front because the earliest inserted element is the last one reached when popping from the stack.

#### Complexity

Let `n` be the number of elements in the Queue.

| Operation | Time complexity |
|---|---:|
| `enQueue()` | `O(1)` |
| `deQueue()` | `O(n)` |
| `peek()` | `O(n)` |
| `isEmpty()` | `O(1)` |

**Space complexity:** `O(n)` for the two stacks.

### Approach 2 — Costly `push()`

**Problem:** [LeetCode 232 — Implement Queue using Stacks](https://leetcode.com/problems/implement-queue-using-stacks/)

**Core idea:** Keep the Queue front element at the top of `st`. During every `push()`, move all existing elements to `help`, push the new value into the empty `st`, and then restore the old elements.

#### Java implementation — LeetCode

```java
class MyQueue {
    Deque<Integer> st;
    Deque<Integer> help;

    public MyQueue() {
        st = new ArrayDeque<>();
        help = new ArrayDeque<>();
    }

    public void push(int x) {
        while (!st.isEmpty()) {
            help.push(st.pop());
        }
        //st ka bottom push karo
        st.push(x);
        while (!help.isEmpty()) {
            st.push(help.pop());
        }
    }

    public int pop() {
        if (st.isEmpty()) {
            return -1;
        }
        return st.pop();
    }

    public int peek() {
        if (st.isEmpty()) {
            return -1;
        }
        return st.peek();
    }

    public boolean empty() {
        return st.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
```

#### How it works

- `push(x)`: Move every existing element from `st` to `help`. Push `x` into the empty `st`, then move all old elements back. This keeps the oldest element at the top.
- `pop()`: Remove the top element of `st`, which is the Queue front.
- `peek()`: Read the top element without removing it.
- `empty()`: Check whether `st` is empty.

#### Complexity

| Operation | Time complexity |
|---|---:|
| `push()` | `O(n)` |
| `pop()` | `O(1)` |
| `peek()` | `O(1)` |
| `empty()` | `O(1)` |

**Space complexity:** `O(n)` for the two stacks.

### Comparison

| Operation | Approach 1: Costly removal | Approach 2: Costly insertion |
|---|---:|---:|
| Insert (`enQueue` / `push`) | `O(1)` | `O(n)` |
| Remove (`deQueue` / `pop`) | `O(n)` | `O(1)` |
| Front (`peek`) | `O(n)` | `O(1)` |
| Empty check | `O(1)` | `O(1)` |

**Key takeaway:** Both approaches use two stacks to implement FIFO. Choose the approach based on which operation should be more efficient.

---

## 5. Implement Stack Using Queues

**Problem:** [LeetCode 225 — Implement Stack using Queues](https://leetcode.com/problems/implement-stack-using-queues/)

This problem can be solved using either **two Queues** or **one Queue**. Both approaches keep the newest pushed element at the front so that `pop()` removes the Stack's top.

---

### Approach 1 — Using Two Queues

**Main idea:** Keep the newest pushed element at the front of `q1`. Use `q2` temporarily to build the new order, then swap the Queue references.

#### Your Java implementation

Your submitted code is correct and is preserved as provided:

```java
class MyStack {
    Deque<Integer> q1;
    Deque<Integer> q2;

    public MyStack() {
        q1 = new ArrayDeque<>();
        q2 = new ArrayDeque<>();
    }

    public void push(int x) {
        q2.offer(x);
        while (!q1.isEmpty()) {
            q2.offer(q1.poll());
        }
        Deque<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    public int pop() {
        return q1.poll();
    }

    public int top() {
        return q1.peek();
    }

    public boolean empty() {
        return q1.isEmpty();
    }
}
```

#### How `push()` works

Whenever a new value is pushed:

1. `q2.offer(x)` inserts the new value into `q2` first.
2. The `while` loop transfers every old element from `q1` to the rear of `q2`.
3. The references of `q1` and `q2` are swapped.

After the swap, `q1` contains the new value at its front, followed by the older values. This is why `pop()` and `top()` can directly use the front of `q1`.

#### Detailed dry run

Operations: `push(10)`, `push(20)`, `push(30)`, `top()`, `pop()`.

Queue order is always **front → rear**.

**Start**

```text
q1 = []
q2 = []
```

**Step 1 — `push(10)`**

- `q2.offer(10)` adds `10` to `q2`.
- `q1` is empty, so the `while` loop does not run.
- Swap the references of `q1` and `q2`.

```text
Before swap:
q1 = []
q2 = [10]

After swap:
q1 = [10]
q2 = []
```

**Step 2 — `push(20)`**

- `q2.offer(20)` adds `20` to `q2`.
- The loop removes `10` from the front of `q1` and appends it to `q2`.
- Swap the references.

```text
After adding 20:
q1 = [10]
q2 = [20]

After transferring 10:
q1 = []
q2 = [20, 10]

After swap:
q1 = [20, 10]
q2 = []
```

**Step 3 — `push(30)`**

- `q2.offer(30)` adds `30` to `q2`.
- The loop transfers `20` and then `10` from `q1` to `q2`.
- Swap the references.

```text
After adding 30:
q1 = [20, 10]
q2 = [30]

After transferring 20:
q1 = [10]
q2 = [30, 20]

After transferring 10:
q1 = []
q2 = [30, 20, 10]

After swap:
q1 = [30, 20, 10]
q2 = []
```

Now the Stack order is:

```text
TOP -> 30
       20
       10
BOTTOM
```

**Step 4 — `top()`**

```java
return q1.peek();
```

Returns `30`. The Queue does not change.

```text
q1 = [30, 20, 10]
q2 = []
```

**Step 5 — `pop()`**

```java
return q1.poll();
```

Removes and returns `30`.

```text
q1 = [20, 10]
q2 = []
```

#### Practical dry run summary

The table below gives the complete operation trace at a glance. Keep this for quick revision after studying the detailed steps above.

| Operation / step | `q1` | `q2` | Result |
|---|---|---|---|
| Start | `[]` | `[]` | — |
| `push(10)` then swap | `[10]` | `[]` | — |
| `push(20)`, transfer `10`, swap | `[20, 10]` | `[]` | — |
| `push(30)`, transfer `20, 10`, swap | `[30, 20, 10]` | `[]` | — |
| `top()` | `[30, 20, 10]` | `[]` | `30` |
| `pop()` | `[20, 10]` | `[]` | `30` |

After every `push()`, the newest value is at the front of `q1`.

#### What each important line does

```java
q2.offer(x);
```

Adds the new value first to `q2`.

```java
q2.offer(q1.poll());
```

Removes the front element from `q1` and appends it to `q2`. This places the older values behind the new value.

```java
Deque<Integer> temp = q1;
q1 = q2;
q2 = temp;
```

Swaps the Queue references. The elements are not copied during this swap; `q1` simply starts referring to the Queue that now contains the new Stack order.

#### Complexity

Let `n` be the number of elements already in the Stack.

| Operation | Time | Reason |
|---|---:|---|
| `push()` | `O(n)` | Transfers all existing elements to `q2` |
| `pop()` | `O(1)` | Removes the front of `q1` |
| `top()` | `O(1)` | Reads the front of `q1` |
| `empty()` | `O(1)` | Checks whether `q1` is empty |

**Space:** `O(n)` across the two Queues.

#### One important note

`pop()` and `top()` return `int`, while `poll()` and `peek()` return `Integer`. If the Queue is empty, `poll()` and `peek()` return `null`; converting that `null` to `int` causes a `NullPointerException`. LeetCode's valid-operation constraints ensure that `pop()` and `top()` are called only when the Stack is not empty, so this implementation follows the problem's requirement.

#### Quick revision

```text
PUSH(x):
1. q2.offer(x)
2. Transfer all q1 elements into q2
3. Swap q1 and q2

POP:
Remove and return the front of q1

TOP:
Read the front of q1 without removing it

EMPTY:
Check q1.isEmpty()
```

**Remember:** `q1` always keeps the Stack's top element at its front. `q2` is used temporarily during `push()`.

#### Self-revision

- [ ] Explain why the new value is inserted into `q2` first.
- [ ] Explain why the old `q1` elements are transferred after it.
- [ ] Trace the Queue states after `push(10)`, `push(20)`, and `push(30)`.
- [ ] Explain what swapping the references changes.
- [ ] Explain why `push()` is `O(n)` while `pop()` and `top()` are `O(1)`.

---

### Approach 2 — Using One Queue (Code360)

**Problem:** Code360 — Implement Stack Using Queues

**Main idea:** Use one Queue (`q1`). After inserting a new element at the rear, rotate all the older elements behind it. This keeps the newest element at the front, so the front always behaves as the Stack top.

#### Your Java implementation

Your latest Code360 implementation is preserved below, including the commented-out loop attempts:

```java
import java.util.*;

public class Solution {
    static class Stack {
        Deque<Integer> q1;

        public Stack() {
            q1 = new ArrayDeque<>();
        }

        /*----------------- Public Functions of Stack -----------------*/

        public int getSize() {
            return q1.size();
        }

        public boolean isEmpty() {
            return q1.isEmpty();
        }

        public void push(int element) {
            q1.offer(element);
            int n = getSize() - 1;
            for (int i = 0; i < n; i++) {
                q1.offer(q1.poll());
            }
            // int n = getSize() - 1;
            // for (int i = 0; i < n; i++) {
            //     int value = q1.poll();
            //     q1.offer(value);
            // }
            // int n = getSize();
            // for (int i = 0; i <= n; i++) {
            //     int value = q1.poll();
            //     q1.offer(value);
            // }
        }

        public int pop() {
            if (q1.isEmpty()) {
                return -1;
            }
            return q1.poll();
        }

        public int top() {
            if (q1.isEmpty()) {
                return -1;
            }
            return q1.peek();
        }
    }
}
```

#### Understand the important lines

```java
q1.offer(element);
```

Insert the new element at the rear of the Queue.

```java
int n = getSize() - 1;
```

After insertion, `getSize()` includes the new element. Subtracting `1` gives the number of older elements that must be moved behind it.

```java
for (int i = 0; i < n; i++) {
    q1.offer(q1.poll());
}
```

Each iteration removes the front element using `poll()` and inserts it at the rear using `offer()`. This rotates the older elements. After exactly `n` rotations, the newly inserted element reaches the front.

**Important:** The loop runs from `i = 0` while `i < n`. This performs exactly `n` rotations. It is equivalent to using `i = 1` while `i <= n` in your earlier implementation.

#### Practical dry run

Operations: `push(10)`, `push(20)`, `push(30)`, `top()`, `pop()`, `getSize()`, `isEmpty()`.

Queue order is **front → rear**.

**Step 1 — `push(10)`**

```text
Before: q1 = []
q1.offer(10): q1 = [10]
n = getSize() - 1 = 1 - 1 = 0
Loop runs 0 times.

After: q1 = [10]
```

There are no older elements to rotate, so `10` stays at the front.

**Step 2 — `push(20)`**

```text
Before: q1 = [10]
q1.offer(20): q1 = [10, 20]
n = getSize() - 1 = 2 - 1 = 1

Rotation 1:
q1.poll() returns 10
q1.offer(10)
q1 = [20, 10]

After: q1 = [20, 10]
```

The older element `10` moves behind the new element `20`.

**Step 3 — `push(30)`**

```text
Before: q1 = [20, 10]
q1.offer(30): q1 = [20, 10, 30]
n = getSize() - 1 = 3 - 1 = 2

Rotation 1:
q1.poll() returns 20
q1.offer(20)
q1 = [10, 30, 20]

Rotation 2:
q1.poll() returns 10
q1.offer(10)
q1 = [30, 20, 10]

After: q1 = [30, 20, 10]
```

Now `30` is at the front, so it is the Stack top.

```text
TOP -> 30
       20
       10
BOTTOM
```

**Step 4 — `top()`**

```java
return q1.peek();
```

Returns `30`. `peek()` reads the front element without removing it.

Queue remains:

```text
q1 = [30, 20, 10]
```

**Step 5 — `pop()`**

```java
return q1.poll();
```

Returns and removes `30`, the front element.

Queue becomes:

```text
q1 = [20, 10]
```

**Step 6 — `getSize()`**

Returns `2`, because `q1` contains `20` and `10`.

**Step 7 — `isEmpty()`**

Returns `false`, because `q1` still contains two elements.

#### Complete operation summary

| Operation | Queue (`q1`, front → rear) | Result |
|---|---|---:|
| Start | `[]` | — |
| `push(10)` | `[10]` | — |
| `push(20)` | `[20, 10]` | — |
| `push(30)` | `[30, 20, 10]` | — |
| `top()` | `[30, 20, 10]` | `30` |
| `pop()` | `[20, 10]` | `30` |
| `getSize()` | `[20, 10]` | `2` |
| `isEmpty()` | `[20, 10]` | `false` |

#### What each method does

| Method | What it does |
|---|---|
| `push(element)` | Inserts the new element, then rotates the older elements so the new element reaches the front |
| `pop()` | Removes and returns the front element; returns `-1` if empty |
| `top()` | Returns the front element without removing it; returns `-1` if empty |
| `getSize()` | Returns the number of elements in `q1` |
| `isEmpty()` | Checks whether `q1` is empty |

#### Complexity

Let `n` be the number of elements already in the Stack before `push()`.

| Operation | Time | Reason |
|---|---:|---|
| `push()` | `O(n)` | Rotates all `n` older elements |
| `pop()` | `O(1)` | Removes the front element |
| `top()` | `O(1)` | Reads the front element |
| `getSize()` | `O(1)` | Returns the Queue size |
| `isEmpty()` | `O(1)` | Checks whether the Queue is empty |

**Space:** `O(n)` for the single Queue storing the Stack elements.

#### Quick revision

```text
PUSH(element):
1. Insert element at the rear of q1.
2. n = getSize() - 1  // number of older elements
3. Repeat n times:
   - Remove the front element.
   - Insert it at the rear.

POP:
Remove and return q1 front (or -1 if empty).

TOP:
Read q1 front (or -1 if empty).

GET SIZE:
Return q1.size().

IS EMPTY:
Return q1.isEmpty().
```

**Remember:** After every `push()`, the newest element is at the front of `q1`. Therefore, `pop()` and `top()` can directly use the Queue front.

#### Self-revision

- [ ] Explain why `element` is inserted before the rotations.
- [ ] Explain why `getSize() - 1` gives the number of older elements.
- [ ] Trace the Queue states after `push(10)`, `push(20)`, and `push(30)`.
- [ ] Explain what `q1.offer(q1.poll())` does in one loop iteration.
- [ ] Explain why the loop runs exactly `n` times.
- [ ] Explain why `push()` is `O(n)` while `pop()` and `top()` are `O(1)`.

---

### Compare Both Approaches

| Detail | Two Queues | One Queue |
|---|---|---|
| Extra Queue | `q2` | Not needed |
| What happens during `push()` | Add new value to `q2`, transfer old values, swap | Add new value, rotate old values |
| Where Stack top stays | Front of `q1` | Front of `q` |
| `push()` | `O(n)` | `O(n)` |
| `pop()` | `O(1)` | `O(1)` |
| `top()` | `O(1)` | `O(1)` |

### What to Remember

- A Stack follows **LIFO**: last in, first out.
- A Queue follows **FIFO**: first in, first out.
- Both of your implementations rearrange the Queue during `push()` so the newest element is at the front.
- `pop()` removes the front; `top()` reads the front without removing it.
- In the one-Queue solution, rotate exactly `q.size() - 1` older elements.

### Self-Revision

- [ ] Dry-run the two-Queue approach with `push(10)`, `push(20)`, `push(30)`.
- [ ] Dry-run the one-Queue approach with the same values.
- [ ] Explain why the one-Queue loop uses `q.size() - 1`.
- [ ] Explain why `poll()` followed by `offer()` rotates the Queue.
- [ ] Explain why both approaches have `O(n)` `push()` and `O(1)` `pop()` / `top()`.

---
