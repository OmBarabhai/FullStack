# L — Parentheses / Expression / Partition
## Part 3 — Problems 127–128
### Palindrome Partitioning — One Clean Revision Sheet

> **Important:** Problems 127 and 128 are both listed as **LeetCode 131 — Palindrome Partitioning**. They should be learned as **one recursion pattern**, not as two separate algorithms. fileciteturn42file0L12-L18 fileciteturn42file4L596-L598
>
> ```text
> CHOOSE NEXT SUBSTRING
> → CHECK PALINDROME
> → CHOOSE
> → RECURSE ON REMAINING STRING
> → UNDO
> → TRY NEXT CUT
> ```

---

# 1. Problem

Example:

```text
s = "aab"
```

Valid partitions:

```text
["a","a","b"]
["aa","b"]
```

Invalid:

```text
["a","ab"]   ← "ab" is not palindrome
["aab"]      ← "aab" is not palindrome
```

The recursive question is:

```text
"Where should I put my NEXT CUT?"
```

At each index, try every possible ending position.

---

# 2. Pattern Recognition

Think of this problem when you see:

```text
STRING
+
SPLIT / PARTITION
+
GENERATE ALL VALID PARTITIONS
+
EACH PIECE MUST SATISFY A RULE
```

For this problem:

```text
RULE = piece must be palindrome
```

Generic pattern:

```text
for every possible next piece:

    create candidate

    check candidate

    if valid:
        choose
        recurse
        undo
```

This is:

```text
STRING PARTITION BACKTRACKING
```

---

# 3. State — Most Important

```text
idx
→ START of the next partition

choices
→ END of the current candidate

candidate
→ one substring being tested

op
→ ALL chosen pieces so far

ans
→ all complete partitions
```

### State invariant

When:

```text
solve(idx)
```

is called:

```text
everything before idx
→ is already partitioned
→ every chosen piece is valid
```

Only:

```text
s[idx ... end]
```

remains.

This is the main recursive contract.

---

# 4. Why the Loop Exists

For:

```text
s = "aab"
idx = 0
```

the loop tries:

```text
choices = 0 → "a"
choices = 1 → "aa"
choices = 2 → "aab"
```

So the loop means:

```text
TRY EVERY POSSIBLE NEXT CUT
```

This is the key pattern.

---

# 5. Candidate Construction

If:

```text
idx = start
choices = end
```

then:

```java
String candidate =
    s.substring(idx, choices + 1);
```

Why `choices + 1`?

Java's second substring index is exclusive.

Therefore:

```text
candidate
= characters idx ... choices
```

but Java needs:

```text
substring(idx, choices + 1)
```

Memory:

```text
idx       → first included position
choices   → last included position
choices+1 → exclusive substring boundary
```

---

# 6. Why `choices + 1` Is the Next Recursive Index

Suppose:

```text
a a | b
0 1   2
```

and we chose:

```text
"aa"
```

The last consumed position is:

```text
choices = 1
```

The first unused position is:

```text
2
```

Therefore:

```java
solve(..., choices + 1);
```

means:

```text
CONTINUE FROM THE FIRST UNPROCESSED CHARACTER
```

### General rule

```text
current piece = idx ... choices

next piece starts = choices + 1
```

Do not memorize `+1` blindly.

Ask:

```text
"What was the LAST character consumed?"
```

Then move to:

```text
last consumed + 1
```

---

# 7. `op` — What It Really Stores

`op` is the current partition path.

It does NOT store only the current candidate.

Example:

```text
[]
↓ choose "a"

["a"]
↓ choose "a"

["a","a"]
↓ choose "b"

["a","a","b"]
```

So:

```text
candidate
→ ONE piece

op
→ ALL pieces selected so far
```

---

# 8. Base Case

```java
if (idx >= s.length()) {
    ans.add(new ArrayList<>(op));
    return;
}
```

Meaning:

```text
all characters have been consumed
→ current path is one complete partition
→ save it
→ return
```

---

# 9. Why We Save `new ArrayList<>(op)`

Do:

```java
ans.add(new ArrayList<>(op));
```

not:

```java
ans.add(op);
```

because:

```text
op
→ mutable working path
```

After saving, backtracking will change `op`.

So:

```text
new ArrayList<>(op)
→ snapshot / copy
```

Memory:

```text
op
→ working path

copy
→ frozen answer
```

---

# 10. Palindrome Validation

The current candidate must read the same from both ends.

Example:

```text
"abba"
```

Compare:

```text
a == a
b == b
```

So palindrome.

For:

```text
"abca"
```

first:

```text
a == a
```

but then:

```text
b != c
```

So not palindrome.

Therefore checking only first and last characters is NOT enough.

---

# 11. Two-Pointer Check

For candidate:

```text
"abca"
```

think:

```text
a b c a
↑     ↑
left  right
```

Compare:

```text
a == a
```

Move inward:

```text
  b c
  ↑ ↑
left right
```

Compare:

```text
b != c
```

Stop.

Generic pattern:

```java
int left = idx;
int right = choices;

while (left < right) {

    if (s.charAt(left) != s.charAt(right)) {
        return false;
    }

    left++;
    right--;
}

return true;
```

Memory:

```text
MATCH
→ MOVE INWARD

MISMATCH
→ INVALID
```

---

# 12. Why `left/right` Are Different From `idx/choices`

These variables have different jobs.

```text
idx
→ where the candidate STARTS

choices
→ where the candidate ENDS

left/right
→ temporary pointers used INSIDE that candidate
```

So:

```text
idx/choices
→ define WHICH substring

left/right
→ CHECK that substring
```

Do not mix the responsibilities.

---

# 13. `isPalindrome` Is Local

The palindrome property belongs to:

```text
THE CURRENT CANDIDATE
```

For example:

```text
"aa" → true
"ab" → false
"aba" → true
```

So the check must be performed again for every new candidate.

It is not the entire recursive state's permanent value.

Memory:

```text
candidate property
→ LOCAL

recursive state
→ PASSED BETWEEN CALLS
```

---

# 14. Recursion Tree — `"aab"`

```text
                              []
                           idx = 0
                    /          |           \
                   /           |            \
                "a"           "aa"         "aab"
                 |              |             X
              idx = 1         idx = 2       not palindrome
              /      \           |
             /        \          |
           "a"        "ab"       "b"
            |           X         |
         idx = 2     not pal.  idx = 3
            |                     |
           "b"                  SAVE
            |
         idx = 3
            |
          SAVE


Valid leaves:

["a","a","b"]
["aa","b"]
```

Important:

```text
"a" branch
→ try "a"
→ then "b"

"aa" branch
→ then "b"

"aab"
→ rejected immediately
```

---

# 15. Full Dry Run — First Valid Answer

Start:

```text
s   = "aab"
idx = 0
op  = []
```

### Choose `"a"`

```text
choices = 0
candidate = "a"
```

Palindrome:

```text
YES
```

Choose:

```text
op = ["a"]
```

Recurse:

```text
idx = choices + 1
    = 1
```

---

### At `idx = 1`

Remaining:

```text
"ab"
```

Try:

```text
choices = 1
candidate = "a"
```

Palindrome:

```text
YES
```

Choose:

```text
op = ["a","a"]
```

Recurse:

```text
idx = 2
```

---

### At `idx = 2`

Candidate:

```text
"b"
```

Palindrome:

```text
YES
```

Choose:

```text
op = ["a","a","b"]
```

Recurse:

```text
idx = 3
```

---

### Base Case

```text
idx == s.length()
```

Save:

```text
["a","a","b"]
```

Return.

---

# 16. Backtracking After the First Answer

After returning from:

```text
["a","a","b"]
```

we undo only the last choice:

```text
["a","a","b"]
        ↓ remove "b"
["a","a"]
```

Return to the previous recursion level.

Then undo:

```text
["a","a"]
       ↓ remove "a"
["a"]
```

Now the parent can try its next candidate.

### Important

```text
RETURN
→ control goes back to parent

REMOVE
→ changes op back to parent state

NEXT CHOICE
→ parent continues the loop
```

This is the same backtracking idea you learned earlier.

---

# 17. Why Invalid Candidates Are Never Added

At:

```text
idx = 1
```

candidate:

```text
"ab"
```

Check:

```text
a != b
```

So:

```text
invalid
→ do NOT op.add("ab")
→ do NOT recurse
```

This is:

```text
CHECK BEFORE CHOOSE
```

---

# 18. The Clean Algorithm

```text
solve(idx)

if all characters consumed:
    save op
    return

for every ending position choices:

    candidate = s[idx...choices]

    if candidate is NOT palindrome:
        skip

    add candidate to op

    solve(choices + 1)

    remove candidate from op
```

One-line memory:

```text
CUT → CHECK → CHOOSE → RECURSE → UNDO
```

---

# 19. Clean Java Template

```java
public static void solve(
        String s,
        List<List<String>> ans,
        List<String> op,
        int idx) {

    // Base: all characters have been partitioned.
    if (idx >= s.length()) {
        ans.add(new ArrayList<>(op));
        return;
    }

    // Try every possible next substring.
    for (int choices = idx;
         choices < s.length();
         choices++) {

        // Check whether s[idx..choices] is a palindrome.
        boolean isPalindrome = true;

        int left = idx;
        int right = choices;

        while (left < right) {

            if (s.charAt(left) != s.charAt(right)) {
                isPalindrome = false;
                break;
            }

            left++;
            right--;
        }

        // Invalid candidate cannot continue.
        if (!isPalindrome) {
            continue;
        }

        // Choose.
        String candidate =
                s.substring(idx, choices + 1);

        op.add(candidate);

        // Explore the remaining suffix.
        solve(
                s,
                ans,
                op,
                choices + 1
        );

        // Undo.
        op.remove(op.size() - 1);
    }
}
```

---

# 20. Rebuild the Solution Without Memorizing

Start from the problem statement:

```text
1. I need ALL partitions.
2. At idx, choose the next substring.
3. A loop tries every possible end.
4. Candidate must be palindrome.
5. Add valid candidate to path.
6. Recurse from choices + 1.
7. Remove it after recursion.
8. At end of string, save the path.
```

That is the complete solution logic.

---

# 21. Pattern Recognition in Other Problems

This pattern appears whenever:

```text
STRING
+
SPLIT INTO PIECES
+
GENERATE ALL VALID PARTITIONS
```

Generic form:

```java
for (end = idx; end < n; end++) {

    candidate = s[idx..end];

    if (candidate invalid) {
        continue;
    }

    choose candidate;

    solve(end + 1);

    undo candidate;
}
```

Only the validity rule changes.

Examples:

```text
Palindrome Partitioning
→ candidate must be palindrome

Restore IP
→ candidate must be valid IP segment

Word Break
→ candidate must be a dictionary word
```

The recursion skeleton is almost the same.

---

# 22. Connection With Problem 126 — Restore IP

This comparison is important.

### IP

```text
CHOOSE PIECE
→ CHECK:
   no leading zero
   <= 255
   max 3 digits
→ RECURSE
→ UNDO
```

### Palindrome Partitioning

```text
CHOOSE PIECE
→ CHECK:
   palindrome?
→ RECURSE
→ UNDO
```

Same pattern:

```text
STRING PARTITION BACKTRACKING
```

Different validation.

---

# 23. Connection With Word Break

### Palindrome Partitioning

```text
candidate = s[idx...choices]
valid if palindrome
next = choices + 1
```

### Word Break

```text
candidate = s[idx...choices]
valid if dictionary contains it
next = choices + 1
```

But the output question changes.

```text
Palindrome Partitioning
→ GENERATE ALL valid partitions

Word Break
→ CHECK whether a valid segmentation exists
```

So:

```text
same choice tree
+
different answer type
```

This is an important pattern evolution.

---

# 24. Generate vs Check

### Generate all

```text
valid
→ add
→ recurse
→ remove
```

### Check one exists

```text
valid
→ recurse
→ if child succeeds:
      return true
```

Same recursive decision tree.

Different use of the recursive result.

---

# 25. Do Not Add Extra Parameters Without a Reason

Before adding a parameter, ask:

```text
"What exact information does the child need?"
```

For this problem:

```text
idx
→ child needs to know where remaining work begins

op
→ child needs the current chosen partition

left/right
→ only temporary palindrome-check pointers

isPalindrome
→ local property of current candidate
```

This keeps the recursive signature small and understandable.

---

# 26. How to Modify the Pattern

### Count partitions

Instead of:

```text
save every answer
```

return:

```text
number of valid partitions
```

The choice tree stays the same.

### Find only one partition

Stop when the first complete valid partition is found.

### Add another validity rule

Keep:

```text
candidate
→ validate
→ choose
→ recurse
→ undo
```

Only validation changes.

### Optimize palindrome checks

The recursion tree can stay the same while palindrome information is precomputed/memoized.

So:

```text
same search
+
faster validation
```

---

# 27. Complexity

There can be:

```text
2^(N-1)
```

possible ways to place cuts in a string of length `N`.

So generating all partitions is exponential.

There is also work for:

```text
palindrome checking
+
copying/storing answers
```

For revision:

```text
Time
→ exponential/output-sensitive

Auxiliary space
→ O(N) recursion + current path

Output space
→ depends on number and size of returned partitions
```

---

# 28. Final Revision Checklist

```text
[ ] What does solve(idx) mean?

[ ] What does idx represent?

[ ] What does choices represent?

[ ] Why is the loop generating possible cuts?

[ ] Why is substring end choices + 1?

[ ] Why does recursion start at choices + 1?

[ ] What does candidate represent?

[ ] What does op represent?

[ ] Why is new ArrayList<>(op) needed?

[ ] Why is palindrome checking candidate-local?

[ ] Why are left/right separate from idx/choices?

[ ] What happens after the recursive call returns?

[ ] Why do we remove the last candidate?

[ ] What is the base case?

[ ] How is this the same pattern as Restore IP?

[ ] What changes for Word Break?

[ ] Can I reconstruct the generic string-partition template?
```

---

# 29. Final Mental Model

```text
                         solve(idx)
                             |
                   TRY EVERY NEXT PIECE
                             |
                       candidate
                             |
                    IS IT VALID?
                      /         \
                    NO           YES
                    |             |
                  SKIP          CHOOSE
                                  |
                              op.add(...)
                                  |
                           solve(choices+1)
                                  |
                               RETURN
                                  |
                          op.remove(last)
                                  |
                             NEXT CUT
```

### One-line memory

```text
CUT → CHECK → CHOOSE → RECURSE → UNDO
```

### Core state memory

```text
idx
→ next piece START

choices
→ current piece END

op
→ chosen pieces

candidate
→ current piece

choices + 1
→ next unprocessed index
```
