# 140 — Generate All Valid Sentences
## String Partitioning — Revision Pattern

> Core pattern:
>
> `remaining string → choose prefix → validate → recurse on suffix → combine`

---

## Core recursion meaning

```text
solve(s)
=
all valid sentences that can be formed from this remaining string
```

For each possible prefix:

```text
choose prefix
    ↓
dictionary contains it?
    ↓
YES
    ↓
solve(remaining suffix)
    ↓
combine prefix + every suffix sentence
```

---

## State / Choice / Constraint / Base

```text
STATE      → remaining string (or current index)
CHOICE     → length of next prefix
CONSTRAINT → prefix exists in dictionary
BASE       → remaining string is empty
RECURSE    → remaining suffix
COMBINE    → prefix + suffix sentence
```

---

## Why the loop starts at 1

```java
for (int choices = 1; choices <= s.length(); choices++)
```

`choices` is the number of characters taken for the current prefix.

```text
1 → first character
2 → first two characters
...
s.length() → whole string
```

`0` would create an empty prefix, which is not a word choice.

---

## Prefix vs suffix

Example:

```text
s = "catsanddog"
choices = 4
```

Then:

```text
prefix = "cats"
suffix = "anddog"
```

So:

```java
String prefix = s.substring(0, choices);
List<String> suffixSol =
    getAllValidSentences(s.substring(choices), dict);
```

Mental rule:

```text
CHOOSE PREFIX
→ RECURSE ON WHAT IS LEFT
```

Do not recurse on the prefix you already consumed.

---

## Base case

```java
if (s.length() == 0) {
    List<String> base = new ArrayList<>();
    base.add("");
    return base;
}
```

Meaning:

```text
no characters remain
    ↓
all previous choices formed a complete sentence
    ↓
one valid completion exists
```

### Why return `[""]`?

Because the parent needs one suffix result to combine.

Example:

```text
prefix = "dog"
suffix result = [""]
```

Then:

```text
"dog"
```

is a complete sentence.

This is a useful recursive-combination idea:

```text
empty remainder
→ one empty continuation
```

---

## Base case vs loop

The base case belongs at the start:

```text
function
 ↓
complete?
 ↓
YES → return base result
NO  → try choices
```

The loop explores alternatives.

The base case terminates recursion.

---

## Dictionary lookup

```java
Set<String> setDict =
    new HashSet<>(Arrays.asList(dict));
```

Then:

```java
if (setDict.contains(prefix)) {
```

means:

```text
Is this prefix a legal dictionary word?
```

The `Set` is the constraint checker.

---

## Recursion tree

For a simplified string:

```text
"cats"
```

possible choices begin as:

```text
                         "cats"
                      /    |                          c    ca     cat    ...
                    /      X                        "ats"            "s"
                  ...
```

Each branch represents a different prefix length.

Only dictionary-valid prefixes continue.

Pattern:

```text
prefix
  ↓
valid?
  ↓
suffix
  ↓
recurse
```

---

## Combining results

Suppose:

```text
prefix = "cat"
```

and recursion gives:

```text
["sand dog", "s and dog"]
```

Then:

```text
"cat sand dog"
"cat s and dog"
```

Code:

```java
for (String sentence : suffixSol) {

    if (sentence.isEmpty()) {
        ans.add(prefix);
    } else {
        ans.add(prefix + " " + sentence);
    }
}
```

The `isEmpty()` check prevents an unwanted trailing space.

---

## Failure representation

This implementation uses:

```text
["-1"]
```

to mean:

```text
no valid sentence
```

If:

```java
suffixSol = ["-1"];
```

do not combine it with the current prefix.

Otherwise invalid results such as:

```text
cat -1
```

could be produced.

Check before the inner loop:

```java
if (suffixSol.size() == 1 &&
    suffixSol.get(0).equals("-1")) {
    continue;
}
```

The check belongs **before**:

```java
for (String sentence : suffixSol)
```

because failure describes the whole recursive result.

---

## Final return behavior

```java
if (ans.isEmpty()) {
    List<String> fail = new ArrayList<>();
    fail.add("-1");
    return fail;
}

return ans;
```

Meaning:

```text
valid sentences found
→ return them

none found
→ return ["-1"]
```

---

## Why recursion must use the suffix

Suppose:

```text
s = "catsanddog"
prefix = "cats"
```

The prefix is already consumed.

The remaining problem is:

```text
"anddog"
```

Therefore:

```java
solve(s.substring(choices))
```

is correct.

Calling:

```java
solve(prefix)
```

would repeatedly solve an already-consumed part instead of making progress through the input.

Reusable rule:

```text
consume piece
→ recurse on remaining input
```

---

## Connection to IP Restoration

### Sentence splitting

```text
choose word
→ dictionary check
→ recurse on suffix
→ combine sentence
```

### IP restoration

```text
choose numeric part
→ range / leading-zero check
→ recurse on suffix
→ combine parts
```

Same recursion family:

```text
current position / remaining input
        ↓
try next piece
        ↓
validate
        ↓
recurse on remainder
        ↓
combine
```

Only the constraint changes.

---

## Reusable partition template

```java
solve(input, idx) {

    if (complete) {
        return baseResult;
    }

    List<Result> ans = new ArrayList<>();

    for (int end = idx + 1;
         end <= input.length();
         end++) {

        String piece = input.substring(idx, end);

        if (valid(piece)) {

            List<Result> suffix =
                solve(input, end);

            for (Result result : suffix) {
                combine(piece, result);
            }
        }
    }

    return ans;
}
```

For this problem:

```text
piece  = prefix
valid  = dictionary contains prefix
suffix = remaining string
combine = prefix + sentence
```

---

## Recognition checklist

When a problem says:

```text
split string
partition string
generate sentences
valid words from dictionary
```

think:

```text
STRING PARTITION RECURSION
```

Then identify:

```text
STATE
CHOICE
CONSTRAINT
BASE
NEXT STATE
COMBINE
FAILURE
```

---

## Revision checklist

```text
[ ] What does solve(s) mean?
[ ] What is my remaining state?
[ ] What is one prefix choice?
[ ] Why does the loop start at 1?
[ ] What is the suffix?
[ ] Why recurse on the suffix?
[ ] What validates the prefix?
[ ] What exactly means completion?
[ ] Why does the base case return [""]?
[ ] How are prefix and suffix results combined?
[ ] Why must ["-1"] not be combined?
[ ] Why is the failure check before the inner loop?
```

---

## One-line memory

```text
REMAINING STRING
→ TRY EVERY PREFIX
→ VALIDATE
→ RECURSE ON SUFFIX
→ COMBINE
→ EMPTY REMAINDER = COMPLETE
```
