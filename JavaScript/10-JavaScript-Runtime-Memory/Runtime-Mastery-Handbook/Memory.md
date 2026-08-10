# JavaScript Stack vs Heap Memory

![Execution Context](./Images/Memory.png)

![Memory Example](./Images/Memory2.png)

---

# JavaScript Memory

JavaScript mainly uses:

1. Stack Memory
2. Heap Memory

---

# Stack Memory

Stack memory is:

* Organized
* Fast
* Sequential
* Uses LIFO order

---

# Girls Room Analogy 🎀

```text id="wspn0u"
Everything arranged properly
Easy to access
Fixed structure
```

Like Stack Memory:

* highly organized
* predictable
* fast access

---

# Primitive Values Stored in Stack

```js id="jg7v44"
let age = 25;
```

---

# Primitive Data Types

* Number
* String
* Boolean
* undefined
* null
* Symbol
* BigInt

---

# Heap Memory

Heap memory is:

* Dynamic
* Less organized
* Flexible
* Used for objects and arrays

---

# Boys Room Analogy 😂

```text id="cfwtjt"
Things scattered everywhere
Dynamic placement
No fixed order
```

Like Heap Memory:

* dynamically allocated
* non-sequential
* flexible memory handling

---

# Objects Stored in Heap

```js id="yzsyw0"
let person = {
   name: "Alice",
   age: 30
};
```

---

# Arrays Stored in Heap

```js id="j6p25x"
let hobbies = ["reading", "cycling"];
```

---

# Important Concept

Objects and arrays are stored in:

```text id="n4j0ah"
Heap Memory
```

But their references are stored in:

```text id="dz6vpi"
Stack Memory
```

---

# Memory Representation

## Stack

```text id="9vx4qq"
age     → 25
person  → 0x101
hobbies → 0x102
```

---

# Heap

```text id="y8f5k6"
0x101 → {
   name: "Alice",
   age: 30
}

0x102 → ["reading", "cycling"]
```

---

# Call Stack

Functions execute using the call stack.

```js id="krv0vz"
function one() {
   two();
}

function two() {
   console.log("Hello");
}

one();
```

---

# Call Stack Flow

```text id="p7w2l4"
| two |
| one |
| GEC |
```

Follows:

```text id="2d4f8m"
LIFO → Last In First Out
```

---

# Stack vs Heap

| Stack              | Heap             |
| ------------------ | ---------------- |
| Organized          | Less organized   |
| Fast               | Slower           |
| LIFO               | No fixed order   |
| Primitive values   | Objects & arrays |
| Execution contexts | Dynamic data     |

---

# Pass By Value

```js id="v6sdr9"
let a = 10;

let b = a;

b = 20;

console.log(a);
```

Output:

```text id="pj0u0f"
10
```

---

# Pass By Reference

```js id="2mb6hz"
let obj1 = {
   name: "Vishwa"
};

let obj2 = obj1;

obj2.name = "Rahul";

console.log(obj1.name);
```

Output:

```text id="8q07f0"
Rahul
```

---

# Golden Interview Line

> Stack memory stores primitive values and execution contexts in an organized LIFO structure, while heap memory stores dynamically allocated objects and arrays.

---
