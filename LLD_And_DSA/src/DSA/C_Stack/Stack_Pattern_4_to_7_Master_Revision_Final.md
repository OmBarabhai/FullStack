# STACK PART 2 — PATTERNS 4–7 MASTER REVISION
## Greedy Stack • Advanced Expression / Simulation • Special Stack Design • Hard Integration

> **Study format**
>
> ```text
> GLOBAL TEMPLATE
>      ↓
> RECOGNITION
>      ↓
> DRY RUN
>      ↓
> SHORT CODE
>      ↓
> UNIQUE ADDITION
> ```
>
> The purpose is to understand **what changes from one problem to another**, not to memorize many full solutions.

---

# 0. GLOBAL STACK THINKING

Before coding any Stack problem:

```text
1. What must the stack remember?
2. What makes the top useful?
3. What makes the top useless?
4. When is it safe to pop?
5. What information must survive after the pop?
6. What does one stack entry represent?
7. What is the final answer supposed to contain?
```

Possible stack roles:

```text
LIFO state
Monotonic candidates
Greedy choices
Nested state
Expression state
Simulation state
Special min/max state
Contribution boundaries
Candidate indexes
```

---

# PATTERN 4 — GREEDY STACK
## Remove a worse previous choice

---

## 1. GLOBAL TEMPLATE

```text
CURRENT
   ↓
compare with stack top
   ↓
is top worse than current?
   ↓
can top be safely removed?
   ↓
YES → POP
   ↓
check again
   ↓
PUSH current
```

### Core rule

```text
current is better
+
previous choice is removable
+
constraints still remain valid
→ POP
```

The important question is:

> **Why is removing the old choice safe?**

---

## 2. RECOGNITION

Look for:

```text
remove K elements
smallest number
lexicographically smallest
most competitive
best subsequence
current element makes previous choice worse
```

Think:

```text
GREEDY + STACK
```

---

## 3. GLOBAL DRY RUN

For every current element:

```text
CURRENT:
STACK TOP:

Is TOP worse?

Can I remove TOP safely?

If yes:
    POP
    update removal budget/state
    check new TOP

Then:
    PUSH CURRENT
```

Pattern 1 asked:

```text
"Is this candidate valid?"
```

Pattern 4 asks:

```text
"Can I improve my result by removing this previous choice?"
```

That is the main conceptual difference.

---

# 4. REMOVE K DIGITS

## What is happening?

You build the smallest possible number while having only:

```text
k removals
```

available.

### Short code skeleton

```java
while (k > 0
       && !st.isEmpty()
       && st.peek() > digit) {

    st.pop();
    k--;
}

st.push(digit);
```

After scanning:

```java
while (k > 0 && !st.isEmpty()) {
    st.pop();
    k--;
}
```

### Dry-run thinking

```text
current digit arrives
        ↓
previous digit is larger?
        ↓
yes → previous digit hurts the number
        ↓
can remove it?
        ↓
yes → pop
        ↓
check again
```

### Unique addition ⭐

The new thing is:

```text
REMOVAL BUDGET
```

In other words:

```text
monotonic removal
+
"k" constraint
```

Unlike NGE/NSE, there is no "next answer" being stored for every element.

The stack is directly building the **final result**.

---

# 5. MOST COMPETITIVE SUBSEQUENCE

## What is happening?

Keep a required number of elements while making the result as strong/small as the problem requires.

### Short code skeleton

```java
while (!st.isEmpty()
       && st.peek() > current
       && canRemoveTop()) {

    st.pop();
}

st.push(current);
```

### Unique addition ⭐

You must protect:

```text
FINAL REQUIRED LENGTH
```

So:

```text
better current
+
top removable
+
enough elements can still be selected
→ POP
```

The extra condition is not just comparison.

It is:

```text
comparison
+
remaining-length constraint
```

---

# 6. CREATE MAXIMUM NUMBER

## What is happening?

The same greedy-stack idea is used to construct strong subsequences from multiple sources before combining them.

### Short code shape

```java
best = buildBestSubsequence(source, requiredSize);
```

Inside the builder:

```java
while (canRemove()
       && st.peek() < current) {
    st.pop();
}

st.push(current);
```

Then combine selected subsequences.

### Unique addition ⭐

There are:

```text
MULTIPLE SOURCE SEQUENCES
```

So the problem becomes:

```text
greedy stack
+
best subsequence from each source
+
combination
```

The new difficulty is not the basic pop rule.

It is deciding:

```text
how much to take from each source
```

and then combining those choices.

---

# 7. REMOVE DUPLICATE LETTERS

## Global idea

```text
greedy + stack
```

A character can be removed only when the result can still contain it later.

### Short code skeleton

```java
while (!st.isEmpty()
       && st.peek() > current
       && remainingCount(st.peek()) > 0) {

    seen.remove(st.pop());
}

if (!seen.contains(current)) {
    st.push(current);
    seen.add(current);
}
```

### Unique addition ⭐

The stack alone is not enough.

You need:

```text
CURRENT STACK ORDER
+
FUTURE FREQUENCY
+
SEEN / ALREADY CHOSEN STATE
```

Core question:

```text
Is the top worse than current?
AND
will the top appear again later?
```

Only then is removal safe.

---

# 8. SMALLEST SUBSEQUENCE OF DISTINCT CHARACTERS

Same family.

### Short code shape

```java
if (!seen.contains(ch)) {

    while (!st.isEmpty()
           && st.peek() > ch
           && countRemaining(st.peek()) > 0) {

        seen.remove(st.pop());
    }

    st.push(ch);
    seen.add(ch);
}
```

### Unique addition ⭐

The final answer has a:

```text
DISTINCTNESS CONSTRAINT
```

So the greedy decision must respect:

```text
Can this character be removed?
Will it appear later?
Have I already chosen the current character?
```

---

# 9. FINAL PRICES WITH SPECIAL DISCOUNT

## Global idea

A current price may receive a discount from a future qualifying price.

### Short code skeleton

```java
while (!st.isEmpty()
       && prices[st.peek()] >= prices[i]) {

    int idx = st.pop();
    ans[idx] -= prices[i];
}

st.push(i);
```

### Unique addition ⭐

The discovered monotonic candidate is not simply returned.

It is:

```text
USED TO MODIFY THE CURRENT/OTHER ANSWER
```

So this is a bridge:

```text
monotonic stack
+
application of discovered value
```

---

# 10. GREEDY STACK MASTER RULE

```text
CURRENT
   ↓
TOP IS WORSE?
   ↓
REMOVAL SAFE?
   ↓
POP
   ↓
RECHECK
   ↓
PUSH
```

Always identify the two things:

```text
WHY is top worse?
WHY is removing it safe?
```

---

# PATTERN 5 — ADVANCED EXPRESSION / SIMULATION
## Stack as unresolved state

---

# 11. GLOBAL TEMPLATE

```text
CURRENT TOKEN / EVENT
        ↓
does it create unresolved state?
        ↓
PUSH STATE

or

does it resolve previous state?
        ↓
PEEK
        ↓
RESOLVE
        ↓
POP
```

### Core idea

```text
The most recent unresolved state
must be handled first.
```

This is Stack thinking without monotonic values.

---

# 12. RECOGNITION

Signals:

```text
nested expression
nested state
matching indexes
operators
collision
elimination
most recent unresolved state
```

Think:

```text
STACK = STATE MEMORY
```

---

# 13. LONGEST VALID PARENTHESES

## What is happening?

Indexes are used to track:

```text
valid range
+
invalid boundary
```

### Short code shape

```java
Stack<Integer> st = new Stack<>();
st.push(-1);

for (int i = 0; i < s.length(); i++) {

    if (s.charAt(i) == '(') {
        st.push(i);
    } else {
        st.pop();

        if (st.isEmpty()) {
            st.push(i);
        } else {
            ans = Math.max(ans, i - st.peek());
        }
    }
}
```

### Unique addition ⭐

This is an:

```text
INDEX STACK
```

where the stack top acts as a boundary.

Important idea:

```text
remaining top
→ previous invalid boundary
```

rather than:

```text
next greater/smaller candidate
```

---

# 14. BASIC CALCULATOR

## What is happening?

When entering parentheses, the current expression state must be remembered.

### Short code shape

```java
if (ch == '(') {
    st.push(currentResult);
    st.push(currentSign);
    resetCurrentState();
}

if (ch == ')') {
    combineInnerResultWithSavedState();
}
```

### Unique addition ⭐

The stack stores:

```text
PREVIOUS EXPRESSION STATE
```

Think:

```text
outside expression
↓
save state
↓
solve inside
↓
restore state
↓
combine
```

---

# 15. BASIC CALCULATOR II

## What is happening?

Operators differ in precedence:

```text
* /
```

must be handled before:

```text
+ -
```

### Short code shape

```java
number = readNumber();

if (op == '+') st.push(number);
if (op == '-') st.push(-number);
if (op == '*') st.push(st.pop() * number);
if (op == '/') st.push(st.pop() / number);
```

Then:

```java
sum += st.pop();
```

### Unique addition ⭐

The stack stores:

```text
INTERMEDIATE NUMERIC VALUES
```

and operator precedence determines when multiplication/division are resolved.

---

# 16. BASIC CALCULATOR III

### Global idea

```text
calculator
+
nested parentheses
+
operator precedence
```

### Short code shape

```java
if (ch == '(') {
    saveCurrentState();
}
else if (ch == ')') {
    restoreAndCombine();
}
else {
    handleOperatorPrecedence();
}
```

### Unique addition ⭐

This combines two ideas:

```text
EXPRESSION PRECEDENCE
+
NESTED STATE
```

So learn Calculator II before Calculator III.

---

# 17. DECODE STRING

Example:

```text
3[a2[c]]
```

### Short code shape

Maintain:

```text
repeat count
+
previous string
```

Conceptually:

```java
if (digit) {
    buildNumber();
}

if (ch == '[') {
    saveCount();
    saveCurrentString();
}

if (ch == ']') {
    restore();
    repeatInnerString();
}
```

### Unique addition ⭐

The stack stores:

```text
STATE BEFORE ENTERING '['
```

Usually:

```text
count
+
previous string
```

So:

```text
nested state
→ push
→ build inner state
→ pop
→ restore
```

---

# 18. ASTEROID COLLISION

## Global idea

A new asteroid may collide with the most recent surviving asteroid.

### Short code shape

```java
while (!st.isEmpty()
       && collision(st.peek(), current)) {

    if (topDies()) {
        st.pop();
    } else if (currentDies()) {
        current = 0;
        break;
    } else {
        st.pop();
        current = 0;
        break;
    }
}

if (current != 0) {
    st.push(current);
}
```

### Unique addition ⭐

A current object can cause:

```text
multiple pops
```

because after one collision:

```text
new top
→ may also collide
```

So the real idea is:

```text
simulation
+
repeated resolution
```

---

# 19. VERIFY PREORDER SERIALIZATION

## Global idea

The stack/state represents available structural positions.

### Unique addition ⭐

The stack is not storing:

```text
greater/smaller
```

It stores:

```text
STRUCTURAL CAPACITY / STATE
```

The key question is:

```text
Does each token consume or create the required number of slots?
```

This reinforces:

```text
Stack can represent state,
not only values.
```

---

# 20. EXPRESSION / SIMULATION MASTER RULE

Ask:

```text
What is currently unresolved?
What must be remembered?
When will that state be resolved?
Which saved state is resolved first?
```

Then:

```text
save → push
resolve → peek
finished → pop
```

---

# PATTERN 6 — SPECIAL STACK DESIGN
## Maintain extra information

---

# 21. GLOBAL TEMPLATE

Normal stack:

```text
push
pop
peek
```

Special stack:

```text
push
pop
peek
+
SPECIAL OPERATION
```

Think:

```text
SPECIAL OPERATION
        ↓
what extra information makes it fast?
        ↓
maintain that information during push/pop
```

---

# 22. MIN STACK

Need:

```text
push
pop
top
getMin
```

### Short code shape — two-stack idea

```java
st.push(x);

if (minSt.isEmpty() || x <= minSt.peek()) {
    minSt.push(x);
}
```

On pop:

```java
int x = st.pop();

if (x == minSt.peek()) {
    minSt.pop();
}
```

### Unique addition ⭐

Maintain:

```text
CURRENT MINIMUM
```

alongside the normal stack.

Invariant:

```text
minSt.peek()
=
minimum of current stack
```

---

# 23. MIN STACK — ONE STACK / ENCODED STATE

### Global idea

Instead of keeping a visible second stack, extra minimum information can be encoded into stack state.

### Unique addition ⭐

The challenge becomes:

```text
How can I restore the previous minimum after pop?
```

So this is:

```text
stack
+
state encoding
```

---

# 24. MAX STACK

Same design family.

### Short code idea

```java
st.push(x);
maxSt.push(Math.max(x, maxSt.peek()));
```

### Unique addition ⭐

Replace:

```text
minimum
```

with:

```text
maximum
```

Invariant:

```text
maxSt.peek()
=
maximum of current stack
```

---

# 25. TWO STACKS IN ONE ARRAY

## Global idea

Two logical stacks share one physical array.

### Short code shape

```java
int top1 = -1;
int top2 = n;
```

Grow:

```text
stack 1 → left to right
stack 2 → right to left
```

Overflow condition:

```text
top1 + 1 == top2
```

### Unique addition ⭐

The challenge is:

```text
SHARED STORAGE
```

not stack LIFO itself.

---

# 26. N STACKS IN ONE ARRAY

### Global idea

Many logical stacks share one array.

### Unique addition ⭐

Now the design needs to track:

```text
which stack owns an entry
next free position
links between entries
```

This moves from:

```text
one stack design
```

to:

```text
shared-memory data structure design
```

---

# 27. STACK WITH O(1) MIN/MAX

### Global idea

Maintain the requested aggregate as elements enter/leave.

```text
push
→ update aggregate

pop
→ restore aggregate
```

### Unique addition ⭐

The important part is the invariant:

```text
extra state always represents
the special value for the CURRENT stack.
```

---

# 28. MIDDLE ELEMENT STACK

Normal stack:

```text
top = easy
middle = not easy
```

### Unique addition ⭐

Maintain:

```text
DIRECT MIDDLE REFERENCE
```

Then push/pop must also update the middle reference.

Concept:

```text
stack size changes
↓
middle position may change
↓
update middle pointer/state
```

The source groups this with:

```text
DLL / Stack
```

because linked structure can support this more naturally.

---

# 29. SPECIAL DESIGN MASTER RULE

```text
What special operation must be fast?
        ↓
What information answers it?
        ↓
Where do I store that information?
        ↓
How does PUSH update it?
        ↓
How does POP restore it?
```

That is the design pattern.

---

# PATTERN 7 — HARD INTEGRATION
## Boundaries + contribution + advanced state

---

# 30. GLOBAL TEMPLATE

```text
Find the useful stack relationship
        ↓
maintain candidates / boundaries
        ↓
convert stack information into:
    range
    count
    contribution
    aggregate
```

Pattern 7 often combines earlier patterns.

```text
Pattern 1
+
Pattern 2
+
new mathematical/output rule
```

---

# 31. SUM OF SUBARRAY MINIMUMS

For each element:

```text
How many subarrays have this element as minimum?
```

Use:

```text
previous smaller
+
next smaller
```

Then count:

```text
left choices
×
right choices
```

Contribution:

```text
arr[i] × leftChoices × rightChoices
```

### Unique addition ⭐

Pattern 2:

```text
smaller boundaries
→ width
```

Pattern 7:

```text
smaller boundaries
→ number of subarrays
→ contribution
```

---

# 32. SUM OF SUBARRAY RANGES

A range is:

```text
MAX - MIN
```

Therefore:

```text
sum of ranges
=
sum of maximum contributions
-
sum of minimum contributions
```

### Unique addition ⭐

Run the contribution idea twice:

```text
MIN
+
MAX
```

So one problem combines:

```text
two monotonic relationships
+
contribution
```

---

# 33. TRAPPING RAIN WATER

## Global idea

Water is created when boundaries surround a lower position.

Stack thinking:

```text
current bar
↓
does it close a basin?
↓
pop lower boundary
↓
new left boundary = remaining top
↓
calculate water
```

### Unique addition ⭐

The answer is:

```text
VOLUME
```

not a nearest-element value.

Therefore indexes matter because:

```text
width
```

is part of the calculation.

This is a stack/boundary application rather than a simple NGE/NSE answer.

---

# 34. NUMBER OF VISIBLE PEOPLE IN A QUEUE

### Global idea

Process people from the side where future blockers can be maintained.

### Unique addition ⭐

Output is:

```text
COUNT
```

For the current height:

```text
remove shorter/equal visible candidates
→ count removed

if taller blocker remains
→ count blocker as required
```

So:

```text
monotonic elimination
+
visibility count
```

---

# 35. CAR FLEET

### Global idea

Cars are grouped by their effective arrival behavior.

### Unique addition ⭐

A stack entry can represent:

```text
FLEET STATE
```

rather than an individual car.

Think:

```text
process cars in the required order
↓
calculate arrival time/state
↓
compare with previous fleet
↓
merge when they become one fleet
```

Important lesson:

```text
one stack entry can represent an aggregate,
not just one input element.
```

---

# 36. MAXIMUM WIDTH RAMP

### Global idea

Keep useful candidate starting indexes.

### Unique addition ⭐

The stack is not directly asking:

```text
nearest smaller
```

It is preserving:

```text
GOOD LEFT STARTING POSITIONS
```

Then right-side processing can maximize:

```text
j - i
```

The key lesson:

```text
monotonic stack
can filter candidate indexes
```

rather than only return nearest greater/smaller answers.

---

# 37. VALID SUBARRAY SIZE

### Global idea

Use an element as a minimum and determine how far it can extend.

### Unique addition ⭐

After finding:

```text
PSE
+
NSE
```

the question becomes:

```text
Is the available width large enough?
```

So:

```text
boundary
+
width threshold
```

---

# 38. MAXIMUM SUBARRAY MIN-PRODUCT

### Global idea

Treat one element as the minimum over a valid range.

Use:

```text
PSE
+
NSE
```

### Unique addition ⭐

Instead of:

```text
height × width
```

the calculation becomes:

```text
minimum value
×
sum of values in its valid range
```

So the new tool is:

```text
prefix/range sum information
```

combined with monotonic boundaries.

---

# 39. STEPS TO MAKE ARRAY NON-DECREASING

### Global idea

Maintain values together with the state of when they are removed.

### Unique addition ⭐

The answer is about:

```text
NUMBER OF STEPS / ROUNDS
```

So the stack may need:

```text
value
+
time/step information
```

This is an example where the monotonic structure carries an additional state field.

---

# 40. SUM OF TOTAL STRENGTH OF WIZARDS

### Global idea

Use minimum-element contribution.

Think:

```text
which element is the minimum?
↓
how many ranges use it?
↓
what aggregate value belongs to those ranges?
```

### Unique addition ⭐

This combines:

```text
monotonic boundaries
+
contribution counting
+
prefix aggregation
```

It should be learned after the simpler contribution problems.

---

# 41. PATTERN 7 — MASTER CONNECTION

```text
PSE / NSE
      ↓
boundaries
      ↓
how many ranges?
      ↓
contribution
      ↓
prefix / aggregate information
```

Pattern 7 is often:

```text
STACK FINDS STRUCTURE
+
MATH FINDS ANSWER
```

---

# 42. PATTERN 4–7 RECOGNITION MAP

```text
PATTERN 4 — GREEDY
current is better
+
old choice can be removed
→ POP

PATTERN 5 — STATE
something is unresolved
+
must be resolved later
→ PUSH STATE

PATTERN 6 — DESIGN
special operation must be fast
→ maintain extra state

PATTERN 7 — INTEGRATION
boundaries/candidates found by stack
+
count/contribution/aggregate
→ final answer
```

---

# 43. PROBLEM → UNIQUE ADDITION

| Problem | Pattern | Unique addition |
|---|---|---|
| Remove K Digits | Greedy | removal budget |
| Most Competitive Subsequence | Greedy | final length constraint |
| Create Maximum Number | Greedy | multiple source sequences |
| Remove Duplicate Letters | Greedy | future frequency + seen |
| Smallest Subsequence of Distinct Characters | Greedy | distinctness |
| Final Prices | Monotonic application | discovered value modifies result |
| Longest Valid Parentheses | State stack | index boundary |
| Basic Calculator | State stack | save/restore nested expression |
| Basic Calculator II | Expression | operator precedence |
| Basic Calculator III | Expression | precedence + nesting |
| Decode String | Nested state | repeat count + previous string |
| Asteroid Collision | Simulation | repeated collision |
| Verify Preorder Serialization | State | structural slots/state |
| Min Stack | Design | O(1) minimum |
| One-stack Min Stack | Design | encoded extra state |
| Max Stack | Design | O(1) maximum state |
| Two Stacks in Array | Design | shared storage |
| N Stacks in Array | Design | shared storage + links |
| Middle Stack | Design | maintained middle reference |
| Sum of Subarray Minimums | Contribution | left choices × right choices |
| Sum of Subarray Ranges | Contribution | max contribution − min contribution |
| Trapping Rain Water | Boundary | water volume |
| Visible People | Count | popped candidates + blocker |
| Car Fleet | Aggregate state | fleet state |
| Maximum Width Ramp | Candidate filtering | useful left indexes |
| Valid Subarray Size | Boundary | width threshold |
| Maximum Subarray Min-Product | Boundary + sum | minimum × range sum |
| Steps to Make Array Non-Decreasing | Monotonic state | step/time state |
| Sum of Total Strength | Contribution | prefix aggregation |

---

# 44. CODE SHAPE CHEAT SHEET

## Greedy

```java
while (removable
       && !st.isEmpty()
       && topIsWorse(st.peek(), current)) {
    st.pop();
}

st.push(current);
```

## Expression / nested state

```java
if (opensState) {
    st.push(currentState);
}

if (closesState) {
    state = st.pop();
    combine(state);
}
```

## Special design

```java
push(x);
updateExtraState(x);

pop();
restoreExtraState();
```

## Boundary / contribution

```java
left  = previousBoundary(i);
right = nextBoundary(i);

result = calculate(left, right, i);
```

---

# 45. DRY RUN TEMPLATE FOR PATTERNS 4–7

Before coding, write:

```text
CURRENT =
STACK ENTRY MEANS =

TOP =
WHY TOP MATTERS =

Can TOP be removed/resolved?
YES / NO

WHY?

After POP:
NEW TOP =

WHAT DO I CALCULATE?

WHAT STATE MUST BE SAVED?

WHAT MUST BE PUSHED?
```

For contribution problems add:

```text
LEFT CHOICES =
RIGHT CHOICES =
CONTRIBUTION =
```

For design problems add:

```text
SPECIAL OPERATION =
EXTRA STATE =
PUSH UPDATE =
POP RESTORE =
```

---

# 46. REVISION ORDER

```text
PATTERN 4
Remove K Digits
↓
Most Competitive Subsequence
↓
Remove Duplicate Letters
↓
other greedy variants

PATTERN 5
Longest Valid Parentheses
↓
Decode String
↓
Calculator family
↓
harder simulation/state

PATTERN 6
Min Stack
↓
One-stack Min/Max
↓
Two/N Stacks
↓
Middle operations

PATTERN 7
Sum of Subarray Minimums
↓
Sum of Subarray Ranges
↓
Trapping Rain Water
↓
Width / size / min-product
↓
advanced contribution
```

---

# 47. FINAL MASTER THINKING

For every new problem:

```text
What is the problem asking?
        ↓
What does one stack entry represent?
        ↓
What is the invariant?
        ↓
What makes the top useless / resolvable?
        ↓
What information must survive?
        ↓
What do I calculate after the pop?
        ↓
What changes from the global template?
```

The final skill is:

```text
GLOBAL TEMPLATE
      +
ONE UNIQUE ADDITION
      =
NEW PROBLEM
```

Do not memorize:

```text
30 different Stack programs
```

Learn:

```text
GREEDY
STATE
DESIGN
CONTRIBUTION
```

and identify the small new idea added to each problem.
