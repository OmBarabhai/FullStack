# I — Choice / Generation

> **Goal:** Recognize problems where recursion chooses one option from multiple available choices.

Core pattern:

```text
CHOICE → RECURSE → UNDO
```

---

# I96 — All Strings From `{a,b}` ⭐⭐⭐⭐⭐

**Pattern:** Every position has exactly two choices.

### State

```text
idx = current position
sb  = string built so far
```

### Algorithm

```text
if idx == n:
    store/print string
    return

choose 'a'
→ append
→ recurse(idx + 1)
→ undo

choose 'b'
→ append
→ recurse(idx + 1)
→ undo
```

### Memory

```text
POSITION → A / B → RECURSE → UNDO
```

For length `2`:

```text
aa
ab
ba
bb
```

Number of outputs:

```text
2^N
```

---

# I97 — All Strings From `{0,1,2}` ⭐⭐⭐⭐⭐

**Pattern:** Same as I96, but there are three choices at every position.

### Algorithm

```text
if idx == n:
    store/print string
    return

for each choice in {0,1,2}:
    append choice
    recurse(idx + 1)
    undo
```

### Memory

```text
POSITION
→ TRY EVERY CHOICE
→ RECURSE
→ UNDO
```

For length `2`:

```text
00 01 02
10 11 12
20 21 22
```

Number of outputs:

```text
3^N
```

---

# I98 — Print All Choices From an Array ⭐⭐⭐⭐⭐

**Pattern:** At every position, choose from the input array.

### State

```text
idx  = current output position
path = selected choices
```

### Algorithm

```text
if idx == requiredLength:
    process path
    return

for each candidate in arr:
    choose candidate
    recurse(idx + 1)
    undo
```

### Core Template

```java
for (int i = 0; i < arr.length; i++) {
    path.add(arr[i]);
    solve(...);
    path.remove(path.size() - 1);
}
```

### Critical Question

```text
Can I reuse the same candidate?
```

If YES:

```text
candidate remains available
```

If NO:

```text
used[] / remove / move past it
```

Do not blindly use `i + 1`; the problem decides the transition.

### Memory

```text
INPUT OPTIONS
→ TRY EACH OPTION
→ RECURSE
→ UNDO
```

---

# I99 — Count Ways to Choose K Items ⭐⭐⭐⭐⭐

**Pattern:** Choice decision + counting.

### State

```text
idx = current item
k   = items still needed
```

### Algorithm

```text
if k == 0:
    return 1

if idx == n:
    return 0

take =
    solve(idx + 1, k - 1)

notTake =
    solve(idx + 1, k)

return take + notTake
```

### Why the state changes

```text
TAKE
→ one item selected
→ k - 1

NOT-TAKE
→ item skipped
→ k unchanged

Both:
→ idx + 1
```

### Memory

```text
TAKE     → k - 1
NOT-TAKE → k
BOTH     → idx + 1
ANSWER   → TAKE + NOT-TAKE
```

### Base Cases

```text
k == 0
→ required number selected
→ return 1

idx == n
→ no items remain
→ return 0
```

---

# I100 — Include / Exclude Subset Framework ⭐⭐⭐⭐⭐

**Pattern:** Every element has exactly two decisions.

```text
INCLUDE
or
EXCLUDE
```

### State

```text
idx  = current element
path = current subset
```

### Algorithm

```text
if idx == n:
    process path
    return

INCLUDE:
    add arr[idx]
    recurse(idx + 1)
    remove

EXCLUDE:
    recurse(idx + 1)
```

### Core Template

```java
if (idx == arr.length) {
    process(path);
    return;
}

// INCLUDE
path.add(arr[idx]);
solve(arr, idx + 1, path);
path.remove(path.size() - 1);

// EXCLUDE
solve(arr, idx + 1, path);
```

### Why Undo?

```text
add 3
→ recurse
→ remove 3
```

The next branch must start from the state before `3` was added.

```text
CHANGE → RECURSE → UNDO
```

---

# I96–I100 Comparison

| Problem | Choice Structure | Output | Main State |
|---|---|---|---|
| I96 | `A / B` | All strings | `idx, sb` |
| I97 | `0 / 1 / 2` | All strings | `idx, sb` |
| I98 | Every `arr[i]` | Generated paths | `idx, path` |
| I99 | TAKE / NOT-TAKE | Count | `idx, k` |
| I100 | INCLUDE / EXCLUDE | Subsets | `idx, path` |

---

# H vs I — Important Separation

You should **not relearn H's foundation here**.

### H — Take / Not-Take Foundation

```text
ONE ELEMENT
→ TAKE
→ NOT-TAKE
```

Usually exactly two branches:

```text
        element
        /     \
     TAKE     SKIP
```

### I — Choice / Generation

```text
CURRENT STATE
→ CHOOSE ONE OF AVAILABLE OPTIONS
```

Example:

```text
             state
          /    |    \
        A      B      C
```

The main new skill is:

```text
How do I represent the available choice space?
```

---

# The Critical Recognition Rule

```text
Two decisions about one element
→ TAKE / NOT-TAKE

Several valid candidates at a position
→ LOOP THROUGH CHOICES
```

Example:

```text
Take 5 or skip 5
→ TAKE / NOT-TAKE
```

But:

```text
Build one character using A/B/C/D
→ for each choice
```

---

# Why a Loop Represents Multiple Recursive Choices

Conceptually:

```text
choose A → recurse
choose B → recurse
choose C → recurse
```

Instead of writing separate recursive calls:

```java
for (each choice) {
    choose;
    recurse;
    undo;
}
```

So:

```text
FOR LOOP
→ represents choices

RECURSION
→ explores the chosen option

UNDO
→ restores state for the next option
```

This becomes important in later permutation/combination problems.

---

# Reuse vs No Reuse

Before coding, ask:

```text
Can I choose the same option again?
```

### Reuse allowed

The candidate remains available after recursion.

### Reuse not allowed

The candidate must become unavailable.

Possible mechanisms:

```text
used[]
remove
move past
```

The problem determines the correct transition.

---

# Generate vs Count

Same decision idea, different answer.

### Generate

```text
visit valid leaves
→ store / print
```

### Count

```text
valid leaf → return 1
left + right
```

### Check

```text
left || right
```

### Optimize

```text
min(left, right)
or
max(left, right)
```

---

# Common Mistakes

```text
❌ Forgetting undo
❌ Wrong loop bounds
❌ Reusing a candidate when forbidden
❌ Preventing reuse when allowed
❌ Wrong base case
❌ Not moving toward the base case
❌ Blindly using i + 1
```

### Debugging Questions

```text
1. What is my STATE?
2. What choices are available?
3. How many choices exist here?
4. Can a choice be reused?
5. What changes when I choose it?
6. What must UNDO restore?
7. What exactly means COMPLETE?
8. Am I GENERATING or COUNTING?
```

---

# Pattern Evolution

```text
H
Take / Not-Take
        ↓
I96
2 fixed choices
        ↓
I97
3 fixed choices
        ↓
I98
choices from input
        ↓
I99
choice decision + COUNT
        ↓
I100
general INCLUDE / EXCLUDE
        ↓
J
Permutation / Combination
```

---

# One-Page Memory

```text
I96
POSITION → A / B → RECURSE → UNDO

I97
POSITION → 0 / 1 / 2 → RECURSE → UNDO

I98
POSITION → EACH INPUT CHOICE → RECURSE → UNDO

I99
TAKE → k - 1
NOT-TAKE → k
ANSWER → TAKE + NOT-TAKE

I100
INCLUDE → RECURSE → UNDO
EXCLUDE → RECURSE
```

---

# Final Recognition Formula

```text
1. What is my STATE?
2. What choices are available?
3. Can a choice be reused?
4. CHOOSE
5. RECURSE
6. UNDO
7. What am I returning?

GENERATE → store / print
COUNT    → +
CHECK    → ||
OPTIMIZE → min / max
```

> **Core memory**
>
> ```text
> H = TAKE / NOT-TAKE
>
> I = CHOOSE FROM AVAILABLE OPTIONS
>
> J = USE THESE CHOICES FOR PERMUTATIONS / COMBINATIONS
> ```
