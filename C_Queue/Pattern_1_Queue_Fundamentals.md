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

**Queue topic:** Queue Fundamentals → Linked List Implementation

**Core concept:** Implement FIFO (First In, First Out) using a singly linked list with two pointers:
- `head`: front of the Queue; the next node to be removed.
- `tail`: rear of the Queue; where new nodes are inserted.
- `size`: number of elements currently stored.

## Core intuition

A Queue follows FIFO order:
- **Enqueue (`add`)** inserts a new element at the rear.
- **Dequeue (`remove`)** removes the element from the front.
- **Peek (`peek`)** reads the front element without removing it.

Keeping both `head` and `tail` allows insertion and removal in constant time.

## Java implementation

The `Node` and `MyQueue` implementations below retain the submitted logic. Formatting has been cleaned up; the test `main` method demonstrates the important cases.

```java
class Node {
    Node next;
    int data;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class MyQueue {
    Node head;
    Node tail;
    int size;

    int peek() {
        if (size == 0) {
            return -1;
        }
        return head.data;
    }

    int remove() {
        if (size == 0) {
            return -1;
        }

        int front = head.data;
        head = head.next;
        size--;

        if (size == 0) {
            tail = null;
        }

        return front;
    }

    void add(int data) {
        Node temp = new Node(data);

        if (size == 0) {
            head = temp;
            tail = temp;
            size++;
            return;
        }

        tail.next = temp;
        tail = temp;
        size++;
    }

    void display() {
        if (size == 0) {
            return;
        }

        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        System.out.println();
    }

    int size() {
        return size;
    }
}
```

## Test all important cases

This `main` method demonstrates:
1. `peek()` and `remove()` on an empty Queue.
2. Adding multiple elements.
3. Reading the front element using `peek()`.
4. Removing elements in FIFO order.
5. Removing every element and checking the empty state.
6. Adding new elements after the Queue becomes empty.

```java
public class Main {
    public static void main(String[] args) {
        MyQueue Q = new MyQueue();

        // Case 1: Operations on an empty Queue
        System.out.println("Empty Queue");
        System.out.println("Peek: " + Q.peek());
        System.out.println("Remove: " + Q.remove());
        System.out.println("Size: " + Q.size());

        // Case 2: Add multiple elements
        System.out.println("\nAfter adding elements");
        Q.add(10);
        Q.add(20);
        Q.add(30);
        Q.add(40);
        Q.add(50);

        Q.display();
        System.out.println("Peek: " + Q.peek());
        System.out.println("Size: " + Q.size());

        // Case 3: Remove elements in FIFO order
        System.out.println("\nRemoving elements");
        while (Q.size() > 0) {
            System.out.println("Removed: " + Q.remove());
            System.out.print("Queue: ");
            Q.display();
            System.out.println("Size: " + Q.size());
        }

        // Case 4: Queue is empty after removing all elements
        System.out.println("\nAfter removing all elements");
        System.out.println("Peek: " + Q.peek());
        System.out.println("Remove: " + Q.remove());
        System.out.println("Size: " + Q.size());

        // Case 5: Add elements again after the Queue becomes empty
        System.out.println("\nAdding elements again");
        Q.add(100);
        Q.add(200);

        Q.display();
        System.out.println("Peek: " + Q.peek());
        System.out.println("Size: " + Q.size());
    }
}
```

## Important pointer states

| Queue state | `head` | `tail` | `size` |
|---|---|---|---:|
| Empty | `null` | `null` | `0` |
| One element | Points to the only node | Points to the same node | `1` |
| Multiple elements | Points to the front node | Points to the rear node | Greater than `1` |

**Important invariant:** When `size == 0`, both `head` and `tail` must be `null`. When the Queue has one element, `head == tail`.

## Dry run

Start with an empty Queue and perform these operations:

| Operation | Queue (front → rear) | Size |
|---|---|---:|
| `add(10)` | `10` | 1 |
| `add(20)` | `10 → 20` | 2 |
| `add(30)` | `10 → 20 → 30` | 3 |
| `remove()` returns `10` | `20 → 30` | 2 |
| `remove()` returns `20` | `30` | 1 |
| `remove()` returns `30` | Empty | 0 |
| `add(100)` | `100` | 1 |
| `add(200)` | `100 → 200` | 2 |

The final two insertions verify that the Queue works after becoming empty.

## Complexity analysis

| Operation | Time complexity | Auxiliary space |
|---|---:|---:|
| `add()` | `O(1)` | `O(1)` |
| `remove()` | `O(1)` | `O(1)` |
| `peek()` | `O(1)` | `O(1)` |
| `size()` | `O(1)` | `O(1)` |
| `display()` | `O(n)` | `O(1)` |

The Queue stores `n` nodes, so its total storage is `O(n)`.

## Edge cases

- Calling `peek()` on an empty Queue returns `-1`.
- Calling `remove()` on an empty Queue returns `-1`.
- Removing the only element makes both `head` and `tail` `null`.
- Adding to an empty Queue makes the new node both `head` and `tail`.
- Repeated removals must follow FIFO order.
- Adding new elements after removing all elements must work correctly.

## Quick revision

- **Enqueue:** insert at `tail`.
- **Dequeue:** remove from `head`.
- **Front:** `head`.
- **Rear:** `tail`.
- **Empty Queue:** `head == null`, `tail == null`, `size == 0`.
- **One element:** `head == tail`.
- **Why keep `tail`?** To insert at the rear in `O(1)` time without traversing the linked list.


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

**Pattern:** Queue Fundamentals → Array Implementation → Circular Queue

**Core idea:** Store Queue elements in an array and use two indices:
- `front`: index of the next element to be removed.
- `rear`: index where the next element is inserted.

When either pointer reaches the end of the array, it wraps around to index `0`.

### Java implementation

```java
public class Solution {
    class Queue {
        int front, rear;
        int []arr;

        Queue() {
            front = 0;
            rear = 0;
            arr = new int[100001];
        }

        // Enqueue (add) element 'e' at the end of the queue.

        public void enqueue(int e) {
            if(rear == arr.length){
                return;
            }
            arr[rear++] = e;
            if(rear == arr.length){
                rear = 0; 
            }
        }

        // Dequeue (retrieve) the element from the front of the queue.
        public int dequeue() {
            if(front == rear){
                return -1;
            }
            int frontData = arr[front];
            front++;
            if(front == arr.length){
                front = 0; 
            }
            return frontData;
        }
    }
}
```

### Pointer movement

**Enqueue**
1. Store the new element at `arr[rear]`.
2. Increment `rear`.
3. If `rear` reaches `arr.length`, reset it to `0`.

**Dequeue**
1. If `front == rear`, return `-1` because the Queue is empty.
2. Read the element at `arr[front]`.
3. Increment `front`.
4. If `front` reaches `arr.length`, reset it to `0`.
5. Return the removed element.

### Important observation

This implementation uses `front == rear` to identify an empty Queue. In a general circular array Queue, an additional mechanism is needed to distinguish a full Queue from an empty one. Here, the array has `100001` positions and the problem allows at most `100000` queries, so the extra position provides room for this implementation under the stated query limit.

The initial check `if(rear == arr.length)` in `enqueue()` is redundant when `rear` is always wrapped to `0` immediately after reaching `arr.length`. It is retained unchanged in the submitted code above.

### Complexity

| Operation | Time complexity |
|---|---:|
| `enqueue()` | `O(1)` |
| `dequeue()` | `O(1)` |

**Auxiliary space:** `O(1)` per operation. The array has a fixed capacity of `100001` elements.

### Edge cases

- `dequeue()` on an empty Queue returns `-1`.
- `front` wraps to `0` after reaching `arr.length`.
- `rear` wraps to `0` after reaching `arr.length`.
- The implementation relies on the problem's maximum query constraint and the extra array position.

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

**Pattern:** Queue Fundamentals → Queue Rotation

This problem uses Queue operations to implement Stack behaviour. A Stack is LIFO, but a Queue is FIFO. To remove or inspect the most recently pushed value, rotate the older Queue elements to the rear until the newest value reaches the front.

### Core idea

This implementation uses one `Deque<Integer>` with **Queue behaviour**:

| Operation | What it does here |
|---|---|
| `Q.add(x)` | Adds the new value at the rear of the Queue. |
| `Q.remove()` | Removes the front value. |
| `Q.peek()` | Reads the front value without removing it. |
| `Q.add(Q.remove())` | Moves the front value to the rear — one Queue rotation. |

After `push(1)`, `push(2)`, `push(3)`, the Queue is `[1, 2, 3]` from front to rear. The newest pushed value (`3`) is at the rear. Rotating the first `n - 1` values moves `3` to the front, where it can be popped or inspected.

### LeetCode 225 implementation

**Problem:** [LC 225 — Implement Stack using Queues](https://leetcode.com/problems/implement-stack-using-queues/)

```java
class MyStack {
    Deque<Integer> Q;

    public MyStack() {
        Q = new ArrayDeque<>();
    }

    public void push(int x) {
        Q.add(x);
    }

    public int pop() {
        if (Q.isEmpty()) {
            return -1;
        }
        int rear = Q.size();

        for (int i = 1; i <= rear - 1; i++) {
            Q.add(Q.remove());
        }

        int topRemove = Q.remove();
        return topRemove;

    }

    public int top() {
        if (Q.isEmpty()) {
            return -1;
        }
        int rear = Q.size();

        for (int i = 1; i <= rear - 1; i++) {
            Q.add(Q.remove());
        }

        int topPeek = Q.peek();

        //add after peek at rear as it is
        Q.add(Q.remove());
        return topPeek;

    }

    public boolean empty() {
        return Q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
```

### Code360 — Stack Using Queue

**Problem:** [Code360 — Stack Using Queue](https://www.naukri.com/code360/problems/stack-using-queue_795152?leftPanelTabValue=SUBMISSION)

```java
import java.util.*;

public class Solution {
    static class Stack {

        Deque<Integer> Q;
        public Stack() {
            Q = new ArrayDeque<>();
        }

        /*----------------- Public Functions of Stack -----------------*/

        public int getSize() {
            return Q.size();
        }

        public boolean isEmpty() {
            return Q.isEmpty();
        }

        public void push(int element) {

            Q.add(element);

            int rear = Q.size();
            for(int i = 1; i <= rear - 1; i++){
                Q.add(Q.remove());
            }  
        }

        public int pop() {
            if(Q.isEmpty()){
                return -1;
            }
            return Q.remove();
        }

        public int top() {
            if(Q.isEmpty()){
                return -1;
            }

            int topElement = Q.peek();
            return topElement;  
        }
    }
}
```

### LeetCode dry run — costly `pop()`

Operations: `push(1)`, `push(2)`, `push(3)`, `pop()`.

Queue is shown **front → rear**.

| Step | Operation | Queue after operation | Result |
|---:|---|---|---|
| 1 | `push(1)` | `[1]` | — |
| 2 | `push(2)` | `[1, 2]` | — |
| 3 | `push(3)` | `[1, 2, 3]` | — |
| 4 | First rotation: move `1` to the rear | `[2, 3, 1]` | — |
| 5 | Second rotation: move `2` to the rear | `[3, 1, 2]` | — |
| 6 | `Q.remove()` removes the front | `[1, 2]` | Returns `3` |

The newest pushed value reaches the front after `n - 1` rotations, so `pop()` returns the Stack's top.

### Code360 dry run — costly `push()`

In this version, rotation happens inside `push()`. The newest value is moved to the front immediately.

| Step | Operation | Queue (front → rear) |
|---:|---|---|
| 1 | `push(1)` | `[1]` |
| 2 | `push(2)`: add `2`, then rotate `1` | `[2, 1]` |
| 3 | `push(3)`: add `3`, then rotate `2, 1` | `[3, 2, 1]` |
| 4 | `top()` reads the front | `[3, 2, 1]` → returns `3` |
| 5 | `pop()` removes the front | `[2, 1]` → returns `3` |

### How `top()` is different from `pop()`

`top()` performs the same `n - 1` rotations, then:

1. Reads the front value using `Q.peek()`.
2. Moves that front value to the rear using `Q.add(Q.remove())`.
3. Returns the saved value, leaving the Queue in its original order.

For Queue `[1, 2, 3]`, the two rotations produce `[3, 1, 2]`. `peek()` reads `3`; the final rotation restores `[1, 2, 3]`. So `top()` returns `3` without removing it.

### What to understand in this problem

Both solutions use the same Queue rotation, but they choose a different time to rotate.

- **LeetCode approach — costly `pop()`:** `push()` simply adds at the rear. When `pop()` or `top()` is called, rotate `n - 1` older values to bring the newest value to the front.
- **Your updated Code360 approach — costly `push()`:** Add the new value, then rotate the `n - 1` older values immediately. This keeps the newest value at the front all the time. Therefore, `pop()` and `top()` only need to access the front.

#### Why the loop must run `n - 1` times

Suppose the Queue contains `[10, 20, 30]` from front to rear, and you are using the LeetCode costly-`pop()` approach:

| Action | Queue (front → rear) |
|---|---|
| Start | `[10, 20, 30]` |
| Rotate `10` | `[20, 30, 10]` |
| Rotate `20` | `[30, 10, 20]` |
| `peek()` reads the Stack top | `30` |
| Restore by moving `30` to rear for `top()` | `[10, 20, 30]` |

Your earlier wrong `top()` attempt used `n` rotations. After three rotations, the Queue returns to `[10, 20, 30]`, so `peek()` reads `10` instead of `30`. The loop needs exactly `n - 1` rotations to bring the newest value to the front.

In both approaches, `Q.add(Q.remove())` means **remove the front and add it to the rear**. The Queue size stays unchanged because one element is removed and one is added.

### Complexity comparison

| Method | LeetCode: costly `pop()` | Code360: costly `push()` |
|---|---:|---:|
| `push()` | `O(1)` | `O(n)` |
| `pop()` | `O(n)` | `O(1)` |
| `top()` | `O(n)` | `O(1)` |
| `empty()` | `O(1)` | `O(1)` |
| `getSize()` | Not in this implementation | `O(1)` |

**Auxiliary space:** `O(n)` for the Queue in both approaches.

### Edge cases to revise

- Empty Stack: `pop()` and `top()` return `-1` in these implementations.
- One element: `pop()` removes it; `top()` returns it and leaves it in the Queue.
- Multiple elements: exactly `n - 1` rotations bring the newest value to the front.
- Costly `pop()` approach: after `top()`, restore the Queue's original order.
- Costly `push()` approach: after every `push()`, the newest value is already at the front.

### Recall check

- [ ] Explain why `Q.add(x)` inserts at the rear.
- [ ] Explain why `Q.remove()` removes the front.
- [ ] Explain why `pop()` rotates `n - 1` elements before removing the front.
- [ ] Explain why the LeetCode approach rotates during `pop()` / `top()`.
- [ ] Explain why the Code360 approach rotates during `push()`.
- [ ] Explain why the loop runs `n - 1` times, not `n` times.
- [ ] Trace how `Q.add(Q.remove())` changes the Queue while keeping its size unchanged.
- [ ] Dry-run `push(1)`, `push(2)`, `push(3)`, `top()`, `pop()` for both approaches.

