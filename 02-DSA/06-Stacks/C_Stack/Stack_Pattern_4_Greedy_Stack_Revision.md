# STACK — PATTERN 4 MASTER REVISION
## Greedy Stack — Remove a Worse Previous Choice

> **Study goal:** understand the decision, not memorize code.
>
> ```text
> CURRENT
>    ↓
> compare with TOP
>    ↓
> is TOP worse?
>    ↓
> can I remove TOP safely?
>    ↓
> POP
>    ↓
> check NEW TOP again
>    ↓
> PUSH / keep CURRENT
> ```

---

# 0. WHAT IS PATTERN 4?

Pattern 4 uses a stack to **build the best possible final result**.

The stack is not mainly finding a nearest/next element.

### Pattern 1

```text
POP because TOP is no longer a useful candidate.
```

### Pattern 4

```text
POP because TOP makes the final result worse
AND
removing TOP is safe.
```

## One master sentence

> **Current is better than TOP, and I can safely remove TOP → POP.**

The only thing that changes from problem to problem is:

```text
WHY is current better?
WHY is TOP safe to remove?
WHAT extra constraint must remain valid?
```

---

# 1. FIRST QUESTIONS BEFORE CODING

For a new problem, ask:

```text
1. What final result am I building?

2. What does the stack represent?

3. Is CURRENT better than TOP?

4. If I remove TOP, can I still satisfy the problem?

5. What extra information do I need?
```

Typical extra constraints:

```text
removal budget
exact final length
future frequency
already-seen / distinctness
multiple sequences
future candidate
```

---

# 2. GLOBAL GREEDY STACK TEMPLATE

```text
for every CURRENT:

    while stack is not empty
          AND TOP is worse than CURRENT
          AND removing TOP is safe:

        POP TOP

    add CURRENT when allowed
```

### What changes?

Only these three pieces:

```text
TOP comparison
SAFE REMOVAL condition
STACK CONTENT
```

---

# 3. VERY IMPORTANT: NOT EVERY "REMOVE" PROBLEM IS PATTERN 4

Do not choose Pattern 4 just because the statement contains the word `remove`.

Ask:

```text
Does the current element make a previous choice worse?
```

### Example: Remove Duplicates From String

Goal:

```text
remove duplicate occurrences
preserve first-occurrence order
```

There is **no optimization** such as smallest lexicographic result.

So:

```text
seen?
YES → skip
NO  → add
```

No greedy POP is needed.

```java
StringBuilder st = new StringBuilder();
boolean[] seen = new boolean[26];

for (char ch : str.toCharArray()) {
    if (seen[ch - 'a']) {
        continue;
    }

    st.append(ch);
    seen[ch - 'a'] = true;
}

return st.toString();
```

### Recognition lesson

```text
duplicates only
→ seen / set

duplicates + smallest lexicographic result
→ Greedy Stack candidate
```

---

# 4. REMOVE K DIGITS
## LeetCode 402

### Goal

Remove exactly `k` digits so the resulting number is as small as possible.

### Stack

```text
StringBuilder
```

Operations:

```text
append()                     → PUSH
charAt(length - 1)           → PEEK
 deleteCharAt(length - 1)    → POP
```

### Core rule

```text
TOP > CURRENT
+
removal budget k > 0
→ POP TOP
```

### Why?

A bigger digit before a smaller digit hurts the number.

Example:

```text
14...
 ↓
13...
```

Removing `4` improves the number.

### Code

```java
class Solution {
    public String removeKdigits(String num, int k) {

        StringBuilder st = new StringBuilder();

        for (char digit : num.toCharArray()) {

            while (k > 0 &&
                   st.length() > 0 &&
                   st.charAt(st.length() - 1) > digit) {

                st.deleteCharAt(st.length() - 1);
                k--;
            }

            st.append(digit);
        }

        // Greedy scan may finish while some removals are unused.
        while (k > 0) {
            st.deleteCharAt(st.length() - 1);
            k--;
        }

        // Remove leading zeroes but keep one zero if needed.
        int start = 0;
        while (start < st.length() - 1 &&
               st.charAt(start) == '0') {
            start++;
        }

        // All digits removed.
        if (st.length() == 0) {
            return "0";
        }

        return st.substring(start);
    }
}
```

### IMPORTANT ORDER OF FINAL PART

```text
1. Main greedy POP
2. Use remaining k from the end
3. If empty → "0"
4. Remove leading zeroes
5. Return answer
```

### Simple dry run

```text
num = "1432219"
k = 3
```

```text
1 → 1
4 → 14
3 → 4 > 3 → pop 4 → 1 → push 3 → 13
2 → 3 > 2 → pop 3 → 1 → push 2 → 12
2 → 2 > 2? NO → 122
1 → 2 > 1 → pop 2 → 12, k = 0
9 → k = 0 → 129
```

Answer:

```text
129
```

### Important cases

#### Case 1 — `k` is fully used during greedy POP

```text
141, k=1
→ pop 4
→ k=0
```

#### Case 2 — `k` remains after scanning

```text
12345, k=2
```

No useful decreasing pair appears.

```text
st = 12345
k = 2
```

Remove from end:

```text
12345 → 1234 → 123
```

#### Case 3 — leading zeroes

```text
10200, k=1
→ 0200
→ 200
```

#### Case 4 — everything removed

```text
123, k=3
→ ""
→ return "0"
```

### New idea added by this problem

```text
REMOVAL BUDGET
```

---

# 5. MOST COMPETITIVE SUBSEQUENCE
## LeetCode 1673 / Coding Ninjas "Find the Most Competitive Subsequence"

### Goal

Choose exactly `k` elements, keeping their order, and make the resulting subsequence as small as possible from left to right.

### The key difference from Remove K Digits

```text
Remove K Digits:
k = how many I REMOVE

Most Competitive:
k = how many I KEEP
```

So here:

```text
remove = n - k
```

is possible, but it is not required when using the safe-availability formula.

---

## 5.1 WHAT DOES THE STACK STORE?

```text
selected values
```

For an easy array implementation, use:

```java
int[] ans = new int[k];
int top = 0;
```

Here:

```text
top = current STACK SIZE
```

Therefore:

```text
top = 0 → empty

top = 1 → one element

top = 2 → two elements
```

The top value is:

```java
ans[top - 1]
```

because `top` is a **size**, not the last index.

---

## 5.2 THE MOST IMPORTANT IDEA: "CAN I SAFELY REMOVE TOP?"

Suppose:

```text
stack = [3, 5]
current = 2
```

`5 > 2`, so `5` is a worse previous choice.

But we must ask:

> **If I remove 5, will I still have enough elements to build a subsequence of size `k`?**

That is the whole reason for the formula.

---

## 5.3 DERIVING THE FORMULA — DO NOT MEMORIZE IT

With `top = stack size`:

```text
top
↓
how many elements are already selected
```

And:

```text
n - i
↓
how many input elements are still available,
INCLUDING the current element
```

Therefore:

```text
top + (n - i)
```

means:

> **TOTAL ELEMENTS CURRENTLY AVAILABLE**

We only need `k` elements.

So:

```text
top + (n - i) > k
```

means:

> **I have more elements available than I need. There is at least one extra element.**

Therefore removing TOP can be safe.

---

## 5.4 TRUE VS FALSE

### TRUE

```text
top + (n-i) > k
```

Means:

```text
AVAILABLE > NEEDED
→ I have an extra element
→ safe to consider POP
```

### FALSE

Usually at the boundary:

```text
top + (n-i) == k
```

Means:

```text
AVAILABLE == NEEDED
→ I need every remaining element
→ DO NOT POP
```

### Example

```text
stack = [3]
current = 1
future = none
k = 2
```

```text
stack size = 1
remaining = 1
available = 1 + 1 = 2
```

```text
2 > 2 → false
```

Do not remove `3`.

Why?

```text
[3] + [1] = exactly 2 elements
```

If `3` is removed, only one element remains.

---

## 5.5 WHY `n - i` INCLUDES CURRENT

Example:

```text
nums = [3,5,2,1]
n = 4
i = 2
```

Current is `2`.

From `i` onward:

```text
[2,1]
```

Count = 2.

```text
n - i = 4 - 2 = 2
```

So `n-i` means:

```text
CURRENT + FUTURE
```

not just future.

---

## 5.6 WHY `ans[top - 1]`?

If:

```text
ans = [3,5]
top = 2
```

then:

```text
top = number of elements
```

Indexes are:

```text
0 1
```

So the last index is:

```text
top - 1 = 1
```

Therefore:

```java
ans[top - 1]
```

means:

> **TOP VALUE**

---

## 5.7 CLEAN IMPLEMENTATION YOU UNDERSTOOD

```java
class Solution {

    public int[] mostCompetitive(int[] nums, int k) {

        int n = nums.length;

        int[] ans = new int[k];
        int top = 0; // stack size

        for (int i = 0; i < n; i++) {

            while (top > 0 &&
                   nums[i] < ans[top - 1] &&
                   top + (n - i) > k) {

                top--;
            }

            if (top < k) {
                ans[top] = nums[i];
                top++;
            }
        }

        return ans;
    }
}
```

---

## 5.8 READ THE WHILE IN ENGLISH

```java
while (top > 0 &&
       nums[i] < ans[top - 1] &&
       top + (n - i) > k)
```

Means:

```text
1. Stack is not empty

AND

2. CURRENT is smaller than TOP
   → CURRENT is a better choice

AND

3. There is at least one extra element available
   → removing TOP will not make it impossible to reach K

THEN
→ POP TOP
→ check the new TOP again
```

---

## 5.9 DRY RUN — SIMPLE CASE

```text
nums = [3,5,2,6]
k = 2
```

### i = 0, current = 3

```text
stack = []
```

Push:

```text
[3]
```

### i = 1, current = 5

```text
TOP = 3
3 > 5? NO
```

Push:

```text
[3,5]
```

### i = 2, current = 2

```text
TOP = 5
5 > 2 → YES
```

Availability:

```text
stack size = 2
current + future = 2
available = 4
k = 2
4 > 2 → YES
```

POP 5:

```text
[3]
```

Check NEW TOP:

```text
3 > 2 → YES
stack size = 1
remaining = 2
1 + 2 = 3
3 > 2 → YES
```

POP 3:

```text
[]
```

Now:

```text
0 + 2 = 2
2 > 2 → FALSE
```

Stop.

Push 2:

```text
[2]
```

### i = 3, current = 6

Push because:

```text
stack size < k
```

Final:

```text
[2,6]
```

---

## 5.10 EXACT DIFFICULT CASE YOU DEBUGGED

```text
nums = [71,18,52,29,55,73,24,42,66,8,80,2]
k = 3
```

When `8` arrives:

```text
stack = [18,24,42]
current = 8
remaining = [8,80,2]
```

Therefore:

```text
stack size = 3
remaining = 3
available = 6
k = 3
```

```text
6 > 3 → TRUE
```

TOP:

```text
42 > 8 → TRUE
```

POP 42:

```text
[18,24]
```

Again:

```text
2 + 3 = 5
5 > 3 → TRUE
24 > 8 → TRUE
→ POP 24
```

Again:

```text
1 + 3 = 4
4 > 3 → TRUE
18 > 8 → TRUE
→ POP 18
```

Again:

```text
0 + 3 = 3
3 > 3 → FALSE
```

STOP.

Then:

```text
8 → [8]
80 → [8,80]
2 → [8,80,2]
```

Answer:

```text
[8,80,2]
```

---

## 5.11 IMPORTANT CASES

### A. Empty stack

```text
top = 0
```

Nothing can be popped.

`top > 0` is false.

### B. TOP <= CURRENT

Example:

```text
stack = [3]
current = 5
```

```text
3 > 5 → false
```

Keep `3`.

### C. TOP == CURRENT

```text
5 > 5 → false
```

Do not pop.

### D. TOP > CURRENT but no extra element

```text
available == k
→ do not pop
```

### E. `k == n`

Need to keep everything.

The safe-removal check prevents unnecessary POP.

### F. `k == 1`

We only need one element, so many previous elements may be removed when a smaller candidate arrives.

---

## 5.12 THE TRANSFERABLE IDEA

Never memorize only:

```java
top + (n - i) > k
```

Memorize the QUESTION:

> **“If I remove TOP now, will I still have enough elements to finish a valid answer?”**

Then derive:

```text
current stack size
+
current/future elements
>
required final size
```

This is the reusable idea.

---

## 5.13 ALTERNATIVE REMOVE-COUNT VERSION — UNDERSTAND THE DIFFERENCE

Another implementation can use:

```java
int remove = n - k;
```

But be careful:

```text
remove--
```

must account for **every element that is effectively discarded**, not only elements explicitly popped.

That is why your earlier version became incorrect on:

```text
[71,18,52,29,55,73,24,42,66,8,80,2], k=3
```

The safe-availability formula avoids that bookkeeping problem.

For your understanding, keep the version:

```java
top + (n - i) > k
```

---

# 6. REMOVE DUPLICATE LETTERS
## LeetCode 316

### Goal

Return the lexicographically smallest string containing every distinct character exactly once.

### Why Pattern 4?

```text
smallest lexicographic result
+
previous character may become a worse choice
```

### Stack

Use:

```java
StringBuilder st = new StringBuilder();
```

### Extra information

```text
freq → can TOP appear again later?
seen → is a character currently already in the stack?
```

---

## 6.1 THE CORE RULE

```text
TOP > CURRENT
+
TOP appears again later
→ POP TOP
```

Do NOT pop only because:

```text
TOP > CURRENT
```

You must also know that TOP can come back.

---

## 6.2 `freq` — ONE JOB

```text
freq[x]
↓
how many copies of x are still later in the string?
```

Before processing:

```java
for (char ch : s.toCharArray()) {
    freq[ch - 'a']++;
}
```

When processing current `ch`:

```java
freq[ch - 'a']--;
```

Now:

```java
freq[top - 'a'] > 0
```

means:

> Another TOP character still exists later.

---

## 6.3 `seen` — ONE JOB

```text
seen[x] = true
→ x is CURRENTLY in the stack

seen[x] = false
→ x is NOT currently in the stack
```

### PUSH

```java
st.append(ch);
seen[ch - 'a'] = true;
```

### POP

```java
seen[top - 'a'] = false;
st.deleteCharAt(st.length() - 1);
```

This is necessary because a character may be popped and then appear again later.

---

## 6.4 CLEAN IMPLEMENTATION

```java
class Solution {

    public String removeDuplicateLetters(String s) {

        StringBuilder st = new StringBuilder();

        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        boolean[] seen = new boolean[26];

        for (char ch : s.toCharArray()) {

            freq[ch - 'a']--;

            if (seen[ch - 'a']) {
                continue;
            }

            while (!st.isEmpty()) {

                char top = st.charAt(st.length() - 1);

                if (top > ch &&
                    freq[top - 'a'] > 0) {

                    st.deleteCharAt(st.length() - 1);
                    seen[top - 'a'] = false;

                } else {
                    break;
                }
            }

            st.append(ch);
            seen[ch - 'a'] = true;
        }

        return st.toString();
    }
}
```

---

## 6.5 DRY RUN — `bcabc`

```text
b → stack = b
c → stack = bc
```

Now `a`:

```text
TOP = c
c > a → YES
another c later → YES
→ POP c
```

New TOP:

```text
b > a → YES
another b later → YES
→ POP b
```

Then:

```text
a → stack = a
b → stack = ab
c → stack = abc
```

Answer:

```text
abc
```

---

## 6.6 DRY RUN — `cbacdcbc`

Important sequence:

```text
c → c
b → pop c → b
 a → pop b → a
c → ac
d → acd
c → already seen → skip
b → d cannot come again → keep d, add b → acdb
c → already seen → skip
```

Final:

```text
acdb
```

---

## 6.7 IMPORTANT CASES

### A. Character already in stack

```text
seen[ch] == true
→ skip
```

This prevents duplicates.

### B. TOP > CURRENT and TOP appears later

```text
→ POP
```

### C. TOP > CURRENT but TOP does NOT appear later

```text
→ DO NOT POP
```

Because you would lose that character permanently.

### D. TOP == CURRENT

```text
TOP > CURRENT → false
→ stop popping
```

### E. Multiple POPs

After one POP:

```text
new TOP
→ compare again
```

That is why `while`, not one `if`.

---

## 6.8 DEBUGGING LESSON FROM YOUR `acdbc` CASE

The correct state updates are:

```java
// POP TOP
seen[top - 'a'] = false;

// PUSH CURRENT
seen[ch - 'a'] = true;
```

Do NOT write:

```java
seen[ch - 'a'] = false;
```

when popping TOP, because `ch` is the current character, not the removed character.

Also:

```java
st.deleteCharAt(st.length() - 1);
```

needs an INDEX, not a character.

And:

```java
return st.toString();
```

because the method returns `String`.

---

# 7. SMALLEST SUBSEQUENCE OF DISTINCT CHARACTERS
## LeetCode 1081

### Important relationship

This is the **same core greedy-stack idea** as LeetCode 316.

```text
TOP > CURRENT
+
TOP appears later
→ POP
```

The same `freq + seen + StringBuilder` logic applies.

### Clean code

```java
class Solution {

    public String smallestSubsequence(String s) {

        StringBuilder st = new StringBuilder();

        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        boolean[] seen = new boolean[26];

        for (char ch : s.toCharArray()) {

            freq[ch - 'a']--;

            if (seen[ch - 'a']) {
                continue;
            }

            while (!st.isEmpty()) {

                int top = st.length() - 1;

                if (st.charAt(top) > ch &&
                    freq[st.charAt(top) - 'a'] > 0) {

                    seen[st.charAt(top) - 'a'] = false;
                    st.deleteCharAt(top);

                } else {
                    break;
                }
            }

            seen[ch - 'a'] = true;
            st.append(ch);
        }

        return st.toString();
    }
}
```

### Important implementation detail

Here:

```java
int top = st.length() - 1;
```

`top` is an **index**.

So:

```java
st.charAt(top)
```

gets the character stored there.

Do not confuse:

```text
top index
vs
TOP character
```

---

# 8. FINAL PRICES WITH A SPECIAL DISCOUNT
## LeetCode 1475

### Goal

For every price, find the **first later price that is less than or equal to it**.
That later price becomes the discount.

Example:

```text
prices = [8,4,6,2,3]

8 → first later <= 8 is 4 → 8 - 4 = 4
4 → first later <= 4 is 2 → 4 - 2 = 2
6 → first later <= 6 is 2 → 6 - 2 = 4
2 → no later <= 2 → 2
3 → no later <= 3 → 3

answer = [4,2,4,2,3]
```

---

## 8.1 WHAT IS NEW IN THIS PROBLEM?

The greedy idea is different from the previous Pattern 4 problems.

We are **not building the final answer by choosing better values**.

Instead:

```text
CURRENT PRICE
      ↓
can current price discount some PREVIOUS price?
      ↓
YES
      ↓
resolve that previous price
```

The stack stores:

```text
INDEXES of previous prices
that are still waiting for a valid discount
```

### Why indexes instead of values?

We need to know both:

```text
WHAT is the previous price?
→ prices[index]

WHERE is its answer stored?
→ ans[index]
```

So:

```java
st.push(i);
```

means:

```text
remember the POSITION of this unresolved price
```

---

## 8.2 YOUR INTERVIEW VERSION

This is the version you practiced:

```java
class Solution {
    public int[] finalPrices(int[] prices) {

        Stack<Integer> st = new Stack<>();
        int n = prices.length;

        int[] ans = new int[n];

        // Start with original prices
        for (int i = 0; i < n; i++) {
            ans[i] = prices[i];
        }

        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() &&
                   prices[st.peek()] >= prices[i]) {

                int idx = st.pop();

                ans[idx] = ans[idx] - prices[i];
            }

            st.push(i);
        }

        return ans;
    }
}
```

`prices.clone()` can replace the first copy loop, but your explicit loop is completely fine.

---

## 8.3 UNDERSTAND THE `while`

```java
while (!st.isEmpty() &&
       prices[st.peek()] >= prices[i])
```

Read it as:

```text
Is there a previous unresolved price?
        ↓
YES
        ↓
Is that previous price >= current price?
        ↓
YES
        ↓
CURRENT is its valid discount
        ↓
POP that previous index
        ↓
update its answer
```

### Why `>=` and not `>`?

The problem allows the discount to be **less than or equal to** the original price.

Example:

```text
prices = [8,8,3]

second 8 arrives:
8 >= 8 → true

first 8 gets discount 8
→ 0

answer = [0,8,3]
```

So equality must also resolve the previous price.

---

## 8.4 WHY `st.peek()` IS AN INDEX

Because we do:

```java
st.push(i);
```

Suppose:

```text
prices = [8,4,6,2]
stack = [0,2]
```

Then:

```java
st.peek()       → 2
prices[st.peek()] → 6
```

So:

```text
st.peek()
→ WHICH price?

prices[st.peek()]
→ WHAT is that price?
```

When we pop:

```java
int idx = st.pop();
ans[idx] -= prices[i];
```

means:

```text
find WHICH previous answer
        ↓
apply CURRENT price as its discount
```

---

## 8.5 DRY RUN — BASIC CASE

```text
prices = [8,4,6,2,3]
```

Initial:

```text
stack = []
ans   = [8,4,6,2,3]
```

### i = 0, current = 8

```text
stack empty
→ push index 0

stack = [0]
```

### i = 1, current = 4

Top index = 0

```text
prices[0] = 8
8 >= 4 → YES
```

Resolve index 0:

```text
pop 0
ans[0] = 8 - 4 = 4
```

Then push current:

```text
stack = [1]
```

### i = 2, current = 6

```text
prices[1] = 4
4 >= 6 → NO
```

So 4 is still waiting for a discount.

```text
push 2
stack = [1,2]
```

### i = 3, current = 2

Top:

```text
prices[2] = 6
6 >= 2 → YES
```

```text
pop 2
ans[2] = 6 - 2 = 4
```

Check new top:

```text
prices[1] = 4
4 >= 2 → YES
```

```text
pop 1
ans[1] = 4 - 2 = 2
```

Stack is now empty.

Push current:

```text
stack = [3]
```

### i = 4, current = 3

```text
prices[3] = 2
2 >= 3 → NO
```

Push 4:

```text
stack = [3,4]
```

End:

```text
ans = [4,2,4,2,3]
```

---

## 8.6 WHY DO WE `while`, NOT `if`?

One current price can be the discount for **several previous prices**.

Example:

```text
prices = [8,6,2]
```

When `2` arrives:

```text
6 >= 2 → resolve 6
8 >= 2 → resolve 8
```

So the same current value can trigger multiple pops:

```text
POP
↓
new TOP
↓
POP again
```

---

## 8.7 IMPORTANT EDGE CASES

### Case 1 — No later discount

```text
[1,2,3]
```

No later price is smaller/equal.

```text
answer = [1,2,3]
```

The unresolved indexes simply stay in the stack until the end.

### Case 2 — Equal price

```text
[8,8]
```

```text
8 >= 8 → YES
```

So:

```text
answer = [0,8]
```

### Case 3 — Strictly decreasing

```text
[5,4,3,2]
```

Each new price resolves the previous one:

```text
5 gets 4
4 gets 3
3 gets 2
2 gets no discount
```

Answer:

```text
[1,1,1,2]
```

### Case 4 — Strictly increasing

```text
[1,2,3,4]
```

Nothing is resolved early.
All indexes remain waiting until the end.

Answer:

```text
[1,2,3,4]
```

### Case 5 — Duplicate values

```text
[8,8,8]
```

The current 8 resolves the previous 8 because equality is allowed.

Result:

```text
[0,0,8]
```

### Case 6 — Several previous prices resolved by one current price

```text
[10,7,5,2]
```

At `2`:

```text
5 >= 2 → pop
7 >= 2 → pop
10 >= 2 → pop
```

One current price can resolve many waiting prices.

---

## 8.8 WHAT THE STACK ACTUALLY MEANS

Do not think:

```text
stack = random indexes
```

Think:

```text
STACK = prices that have NOT found their discount yet
```

Each entry is an index because we must later update:

```text
ans[index]
```

So the stack contains:

```text
INDEXES OF UNRESOLVED PRICES
```

---

## 8.9 PATTERN CONNECTION

Previous Pattern 4 problems:

```text
Remove K Digits
→ remove a worse previous digit

Most Competitive
→ remove a worse previous choice safely

Remove Duplicate Letters
→ remove a worse previous character if it can return
```

Final Prices is slightly different:

```text
Previous price is waiting
        ↓
Current price satisfies its condition
        ↓
resolve previous price
```

So the stack is still based on **previous unresolved candidates**, but the current value is used to **finish their answers**.

---

## 8.10 VALUE STACK VS INDEX STACK

You asked whether `st.push(prices[i])` can be used.

For the O(n) interview solution, use indexes:

```java
st.push(i);
```

Why?

```text
value tells WHAT
index tells WHERE
```

We need to update:

```java
ans[index]
```

A value-only stack does not tell us which earlier position to modify, especially when duplicate prices exist.

Therefore:

```text
Final Prices → INDEX STACK
```

---

## 8.11 ONE-LINE INTERVIEW EXPLANATION

> “I keep indexes of prices that are still waiting for a discount. When the current price is less than or equal to the price at the top index, the current price is the first valid discount for that previous price, so I pop the index and update its answer. I continue while multiple previous prices can use the same discount.”

---

## 8.12 THE ONLY THINGS TO REVISE

```text
1. Stack stores INDEXES.

2. prices[st.peek()] = previous price.

3. >= because equal discount is allowed.

4. Pop the previous INDEX, not the current index.

5. Update ans[idx], not ans[i].

6. Use while because one current price can resolve many previous prices.

7. Push current index after resolving previous prices.
```

---

# 9. CREATE MAXIMUM NUMBER
## LeetCode 321

### Goal

Create the largest possible number of length `k` from two arrays while preserving order within each array.

### Main idea

It has **two greedy layers**:

```text
1. Build the best subsequence from each array.
2. Try valid splits of k between the two arrays.
3. Merge the chosen subsequences.
4. Keep the best merged result.
```

### Unique addition

```text
MULTIPLE SOURCES + MERGE
```

This is substantially harder than Remove K Digits.

---

# 10. REMAINING / SOURCE-TRACKER PRACTICE

The current Pattern 4 tracker also contains these entries:

```text
Make Array Zero by Subtracting Equal Amounts
→ recognition-boundary item; stack is not core

Build Array With Stack Operations — LC 1441
→ stack simulation

Build an Array With Permitted Operations
→ custom operation constraint

Stack-Based Lexicographic Selection
→ generic greedy-stack variant
```

Do not treat all of these as equally important as the core greedy problems.

---

# 11. PATTERN 4 PROBLEM MAP

```text
1. Remove K Digits                         ✅ PRACTICED
       ↓
   removal budget

2. Most Competitive Subsequence           ✅ PRACTICED
       ↓
   exact final length + safe removal

3. Remove Duplicate Letters               ✅ PRACTICED
       ↓
   future frequency + seen

4. Smallest Subsequence of Distinct        ✅ PRACTICED
       ↓
   same core as 316

5. Final Prices                            ✅ PRACTICED
       ↓
   waiting candidates + apply discount

6. Create Maximum Number                   → NEXT
       ↓
   multiple sources + merge

7. Make Array Zero...                      → recognition check

8. Build Array With Stack Operations      → simulation

9. Build an Array With Permitted Ops      → custom simulation

10. Stack-Based Lexicographic Selection    → generic variant
```

---

# 12. PATTERN 4 VS OTHER STACK PATTERNS

| POP reason | Pattern |
|---|---|
| TOP is no longer a valid greater/smaller candidate | Pattern 1 |
| TOP is outside the usable boundary/range | Pattern 2 |
| TOP makes the final result worse and can be safely removed | **Pattern 4** |
| Nested state is being closed/resolved | Pattern 5 |
| Collision must be resolved | Pattern 5 |
| Special information must be maintained | Pattern 6 |

### Important

> **The reason for POP is more important than the fact that POP exists.**

---

# 13. HOW TO THINK ON A NEW PROBLEM

Write this before coding:

```text
FINAL RESULT = ?

STACK STORES = ?

CURRENT = ?

TOP = ?

IS CURRENT BETTER?

WHY?

CAN I REMOVE TOP?

WHY IS REMOVAL SAFE?

WHAT INFORMATION DO I NEED?
```

### Then classify the safety condition

```text
Remove K Digits
→ do I still have removals?

Most Competitive
→ can I still reach final length k?

Remove Duplicate Letters
→ will TOP appear again?

Create Maximum Number
→ can I still build the chosen subsequence / merge?

Final Prices
→ is CURRENT the required future candidate?
```

---

# 14. THE MOST IMPORTANT DRY-RUN FORMAT

For every new problem, write:

```text
CURRENT = ?

STACK BEFORE = ?

TOP = ?

TOP is worse?
→ YES / NO

WHY?

SAFE TO REMOVE?
→ YES / NO

WHY?

IF POP:
→ update state
→ get NEW TOP
→ check again

PUSH CURRENT

STACK AFTER = ?
```

Do not skip the **WHY**.

That is where the pattern becomes understandable.

---

# 15. COMMON CONFUSIONS TO REVISE

## Confusion 1 — `i` vs `top`

```text
i
→ position in input

top (array implementation)
→ stack size OR last-index depending on how you define it
```

For your preferred Most Competitive code:

```text
top = stack SIZE
```

Therefore:

```java
ans[top - 1]
```

is the top value.

---

## Confusion 2 — current vs top

```text
ch / nums[i]
→ CURRENT

st.charAt(st.length()-1)
→ TOP CHARACTER

ans[top-1]
→ TOP VALUE in your array stack version
```

---

## Confusion 3 — `seen` vs `freq`

```text
seen
→ is this character CURRENTLY inside my stack?

freq
→ does another copy still exist later?
```

---

## Confusion 4 — why `while`, not `if`?

Because after one POP:

```text
old TOP disappears
↓
NEW TOP appears
↓
NEW TOP may also be worse
↓
check again
```

---

## Confusion 5 — why `>`?

For Most Competitive:

```text
available > k
→ there is an extra element
→ safe to remove one
```

If:

```text
available == k
```

you need everything that remains.

---

# 16. INTERVIEW EXPLANATIONS

## Remove K Digits

> “I maintain a monotonic increasing result. If the current digit is smaller than the last chosen digit and removals remain, I remove that larger digit because it makes the number worse.”

## Most Competitive

> “I build a subsequence of exactly `k` elements. If the current value is smaller than the last selected value, I remove the last selected value only when enough elements remain to still complete a subsequence of size `k`.”

## Remove Duplicate Letters

> “I build the smallest lexicographic distinct string. I can remove a larger top character only if that character occurs again later; `seen` prevents duplicates and `freq` tells me whether the removed character can return.”

---

# 17. FINAL CHEAT SHEET

```text
PATTERN 4 = GREEDY STACK

CURRENT better than TOP?
        ↓
Can TOP be removed safely?
        ↓
YES → POP
        ↓
Check NEW TOP again
        ↓
PUSH / KEEP CURRENT
```

### Problem-specific safety

```text
402 Remove K Digits
→ removal budget

1673 Most Competitive
→ enough elements to reach K

316 Remove Duplicate Letters
→ TOP appears later

1081 Smallest Subsequence
→ TOP appears later

321 Create Maximum Number
→ subsequence size + source split + merge
```

### The most transferable question

> **“If I throw away this previous choice now, what guarantees that I can still finish a valid answer?”**

That question is the real Pattern 4 skill.

---

# 18. REVISION CHECKLIST

Before moving to the next problem, I should be able to explain without code:

```text
☐ What does my stack store?

☐ Why is CURRENT better than TOP?

☐ Why is POP safe?

☐ Why do I need a while loop?

☐ What special state does this problem add?

☐ What happens when the safety condition becomes false?

☐ Can I dry-run a normal case?

☐ Can I dry-run an edge case?

☐ Can I identify a similar problem that DOES NOT need Pattern 4?
```

---

# 19. FINAL MINDSET

Do not memorize:

```text
402 code
1673 code
316 code
1081 code
```

Instead remember:

```text
GREEDY STACK
     ↓
CURRENT is better
     ↓
TOP is worse
     ↓
Can TOP be removed safely?
     ↓
POP
     ↓
Check NEW TOP
     ↓
Continue
```

And always identify the **one new constraint**:

```text
budget
length
future occurrence
seen/distinctness
multiple sources
future candidate
```

## One-line rule

> **Pattern 4 = Keep the best possible prefix by removing a worse previous choice only when the removal is safe.**
