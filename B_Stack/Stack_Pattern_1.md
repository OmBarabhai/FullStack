# Stack Pattern 1 — Complete Revision Sheet
**Scope:** The 15 problems in Pattern 1 only  
**Use:** Open this on revision Day 3–4. Try each dry run yourself before reading the trace.

---


## Revision navigation

### Learn the pattern first
- [0. Recognize the right stack pattern](#0-start-here--recognize-the-right-stack-pattern)

### Problem-by-problem revision
| # | Problem title (opens practice page) | Main stack idea |
|---:|---|---|
| 1 | [LC 1047 — Remove All Adjacent Duplicates in String](https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/) | Adjacent equal characters cancel |
| 2 | [LC 1544 — Make The String Great](https://leetcode.com/problems/make-the-string-great/) | Same letter, opposite case cancels |
| 3 | [LC 1209 — Remove All Adjacent Duplicates in String II](https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/) | Character + run count |
| 4 | [LC 2696 — Minimum String Length After Removing Substrings](https://leetcode.com/problems/minimum-string-length-after-removing-substrings/) | Exact removable pairs |
| 5 | [LC 71 — Simplify Path](https://leetcode.com/problems/simplify-path/) | Directory history and `..` |
| 6 | [LC 394 — Decode String](https://leetcode.com/problems/decode-string/) | Nested state: count + previous string |
| 7 | [LC 1441 — Build an Array With Stack Operations](https://leetcode.com/problems/build-an-array-with-stack-operations/) | Push wanted values; pop unwanted values |
| 8 | [LC 682 — Baseball Game](https://leetcode.com/problems/baseball-game/) | Maintain valid score history |
| 9 | [LC 344 — Reverse String](https://leetcode.com/problems/reverse-string/) | LIFO reverses order |
| 10 | [LC 844 — Backspace String Compare](https://leetcode.com/problems/backspace-string-compare/) | Backspace removes latest surviving character |
| 11 | [LC 2390 — Removing Stars From a String](https://leetcode.com/problems/removing-stars-from-a-string/) | Star removes latest surviving character |
| 12 | [LC 735 — Asteroid Collision](https://leetcode.com/problems/asteroid-collision/) | Resolve repeated directional collisions |
| 13 | [LeetCode 155 — Min Stack](https://leetcode.com/problems/min-stack/) / [Code360 — Min Stack](https://www.naukri.com/code360/problems/min-stack_3843991) | Maintain minimum history with two stacks |
| 14 | [Code360 — N Stacks In An Array](https://www.naukri.com/code360/problems/n-stacks-in-an-array_1164271) | Implement multiple stacks in one array using index links and a free list |
| 15 | [LC 225 — Implement Stack using Queues](https://leetcode.com/problems/implement-stack-using-queues/) / [Code360 — Stack Using Queue](https://www.naukri.com/code360/problems/stack-using-queue_795152?leftPanelTabValue=SUBMISSION) | Rotate a FIFO queue so its newest value moves to the front |


### Revision flow
1. Read the recognition clue and key idea.
2. Hide the dry-run table and trace the example yourself.
3. Explain what the stack stores and the exact condition that removes its top.
4. Revisit the edge cases and answer the recall check.
5. Use the [one-minute recall map](#pattern-1--one-minute-recall-map) and [revision checklist](#revision-checklist) at the end.

---

## 0. Start here — recognize the right stack pattern

Use this table before writing code. The question’s **action** tells you what to store.

| Problem clue | First thought | What the stack represents |
|---|---|---|
| Remove adjacent pairs / characters | Process left to right; compare current item with the current top | The already-processed string after simplification |
| Remove exactly `k` equal adjacent characters | Store **character + run count** | Runs that have not been deleted |
| Undo / backspace / star deletes previous | Push normal characters; special symbol removes the current top | The text that still exists after processing the prefix |
| Path contains `.` and `..` | Split into path parts; push folders, pop for `..` | Current directory path |
| Nested `k[section]` or repeated text | Save repeat count and previous partial string at `[` | Paused outer context while decoding an inner section |
| Operations refer to recent scores | Keep the current valid score history | Scores after applying all previous operations |
| Implement a stack using a queue | Rotate older values during `push()`, or during `pop()` / `top()` | The newest pushed value is available at the front when needed |
| Need `push`, `pop`, `top`, and `getMin` in O(1) | Maintain the actual values and a separate minimum history | Current stack values and the minimum that should be active |
| Reverse order | Push everything, then pop | Items in reverse order |
| Asteroids moving in opposite directions | While the top moves right and current moves left, resolve the collision | Asteroids that survive the processed prefix |

### A simple starting routine

1. **What can disappear or change?** A pair, a run of `k`, a previous character, a folder, a score, or an asteroid.
2. **What is the “most recent” thing needed?** Usually the top of a stack (or a list/string builder used as a stack).
3. **When do I pop?** Write one exact condition before coding.
4. **Can one change expose a new problem?** If yes, continue processing the updated top on the next character; do not compare against a removed item.
5. **Dry-run a case that triggers the condition.** Example: `abbaca`, `abBA`, `ABFCACDB`, `foo/..`, `3[a2[c]]`, or `[10, 2, -5]`.

### The recurring idea

```text
Read current item
→ inspect the most recent stored state
→ cancel / undo / update if the rule matches
→ otherwise save the current item
```

This is not one formula to memorize. It is one way of thinking; the **condition for removing or changing the top** is different in each problem.


---

## 1. [LC 1047 — Remove All Adjacent Duplicates in String](https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/)

**Recognize it:** only *adjacent equal* characters disappear. The final result depends on what remains after earlier deletions, so build the answer from left to right.

**How to start:** for each character, compare it with the last character in the built result. Same → remove the top; different or empty → append.

**Key idea to remember:** after deleting `bb` from `abbaca`, the `a` before it becomes the top; the next `a` must remove it. Do not compare against the original string’s previous character.

### Code
```java
class Solution {
    public String removeDuplicates(String s) {
        StringBuilder stack = new StringBuilder();

        for (char curr : s.toCharArray()) {
            int size = stack.length();

            if (size > 0 && stack.charAt(size - 1) == curr) {
                stack.deleteCharAt(size - 1);
            } else {
                stack.append(curr);
            }
        }

        return stack.toString();
    }
}
```

### Dry run: `s = "abbaca"`
| Current char | Action | Stack after action |
|---|---|---|
| `a` | add | `a` |
| `b` | add | `ab` |
| `b` | top is `b`; remove pair | `a` |
| `a` | top is `a`; remove pair | empty |
| `c` | add | `c` |
| `a` | add | `ca` |

**Result:** `"ca"`

### Edge cases to check
- Empty string → empty string.
- One character → unchanged.
- All characters equal, e.g. `"aaaa"` → empty string after repeated pair removal.
- A removal can expose a new pair: `"abbaca"` is the important example; each next character must be checked against the *current* top.

### Recall check
Why compare the current character only with the stack's last character, not with every earlier character?

---

## 2. [LC 1544 — Make The String Great](https://leetcode.com/problems/make-the-string-great/)

**Recognize it:** two adjacent characters cancel only when they are the *same letter in opposite cases* (`aA`, `Bb`). Same case does not cancel.

**How to start:** compare the current character with the built result’s top; compare letters case-insensitively, but also require the actual characters to be different.

**Key idea to remember:** `top == curr` is the wrong test: `aa` stays, while `aA` cancels.

### Code
```java
class Solution {
    public String makeGood(String s) {
        StringBuilder stack = new StringBuilder();

        for (char curr : s.toCharArray()) {
            int size = stack.length();

            if (size > 0) {
                char top = stack.charAt(size - 1);

                boolean sameLetterOppositeCase =
                    top != curr &&
                    Character.toLowerCase(top) == Character.toLowerCase(curr);

                if (sameLetterOppositeCase) {
                    stack.deleteCharAt(size - 1);
                    continue;
                }
            }

            stack.append(curr);
        }

        return stack.toString();
    }
}
```

### Dry run: `s = "leEeetcode"`
| Current char | Action | Stack after action |
|---|---|---|
| `l` | add | `l` |
| `e` | add | `le` |
| `E` | `e` and `E` are same letter, opposite case → remove | `l` |
| `e` | add | `le` |
| `e` | same case, so keep both | `lee` |
| `t` | add | `leet` |
| `c` | add | `leetc` |
| `o` | add | `leetco` |
| `d` | add | `leetcod` |
| `e` | add | `leetcode` |

**Result:** `"leetcode"`

### Edge cases to check
- `"aA"` → empty; `"abBA"` → empty after cascading removals.
- `"aa"` or `"Aa"`? `"aa"` remains unchanged; `"Aa"` is removed.
- Different letters, such as `a` and `B`, do not cancel.
- Same letter and same case do not cancel.

### Recall check
Why isn't `top == curr` enough for this problem?

---

## 3. [LC 1209 — Remove All Adjacent Duplicates in String II](https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/)

**Recognize it:** a whole run disappears when its length reaches `k`; storing just the character is not enough. Track **character and count together**.

**How to start:** if current character equals the top run’s character, increment its count; otherwise create a run with count `1`. When count becomes `k`, pop that run.

**Key idea to remember:** popping a run exposes an earlier run. The next input character may continue that exposed run, causing another deletion. Counts belong to the active run, not to the character globally.

### Code
Each stack entry represents a run: its character and current count.
```java
class Solution {
    public String removeDuplicates(String s, int k) {
        char[] chars = new char[s.length()];
        int[] counts = new int[s.length()];
        int top = -1;

        for (char curr : s.toCharArray()) {
            if (top >= 0 && chars[top] == curr) {
                counts[top]++;
            } else {
                top++;
                chars[top] = curr;
                counts[top] = 1;
            }

            if (counts[top] == k) {
                top--;
            }
        }

        StringBuilder answer = new StringBuilder();

        for (int i = 0; i <= top; i++) {
            for (int j = 0; j < counts[i]; j++) {
                answer.append(chars[i]);
            }
        }

        return answer.toString();
    }
}
```

### Dry run: `s = "deeedbbcccbdaa", k = 3`
The stack below shows grouped entries as `character × count`.

| Read | What changes | Stack after processing |
|---|---|---|
| `d` | start run | `d×1` |
| `e e e` | count reaches 3; remove the `eee` run | empty |
| `d` | merges with existing `d×1` | `d×2` |
| `b b` | add run | `d×2, b×2` |
| `c c c` | count reaches 3; remove `ccc` | `d×2, b×2` |
| `b` | merges with exposed `b×2`, reaches 3; remove run | `d×2` |
| `d` | merges with exposed `d×2`, reaches 3; remove run | empty |
| `a a` | add run | `a×2` |

**Result:** `"aa"`. After `eee` is removed, the two `d` characters combine; later, after `ccc` and then the resulting `bbb` are removed, the `d` run reaches 3 and is removed too. Only `aa` remains.

### Edge cases to check
- `k = 2`: every adjacent pair disappears as soon as its count reaches 2.
- Run length greater than `k`: groups are removed as they reach `k`, one at a time.
- Removing a group may expose two equal runs; the next character must merge with the newly exposed run.
- No run reaches `k` → the string remains unchanged.

### Recall check
Why must the algorithm compare a new character with the *current* top after a run was removed?

---

## 4. [LC 2696 — Minimum String Length After Removing Substrings](https://leetcode.com/problems/minimum-string-length-after-removing-substrings/)

**Recognize it:** only the exact pairs `AB` and `CD` are removable; this is not general duplicate removal.

**How to start:** while reading the string, check whether the current character completes `AB` or `CD` with the built result’s top. If yes, remove the top; otherwise append.

**Key idea to remember:** order matters: `AB` can disappear, but `BA` cannot. After a removal, always let the next character compare with the newly exposed top.

### Code
```java
class Solution {
    public int minLength(String s) {
        StringBuilder stack = new StringBuilder();

        for (char curr : s.toCharArray()) {
            int size = stack.length();

            if (size > 0) {
                char top = stack.charAt(size - 1);

                if ((top == 'A' && curr == 'B') ||
                    (top == 'C' && curr == 'D')) {
                    stack.deleteCharAt(size - 1);
                    continue;
                }
            }

            stack.append(curr);
        }

        return stack.length();
    }
}
```

### Dry run: `s = "ABFCACDB"`
| Current char | Action | Stack after action |
|---|---|---|
| `A` | add | `A` |
| `B` | matches `AB`; remove pair | empty |
| `F` | add | `F` |
| `C` | add | `FC` |
| `A` | add | `FCA` |
| `C` | add | `FCAC` |
| `D` | matches `CD`; remove the top `C` | `FCA` |
| `B` | matches `AB`; remove the top `A` | `FC` |

**Result length:** `2`

### Edge cases to check
- Pair must be exactly `AB` or `CD`; `BA` and `DC` do not remove.
- A pair can form across a previous deletion; always compare against the current top.
- No removable pairs → answer is the original string length.
- Whole string removable → answer `0`.

### Recall check
Why do we need only the top character to check whether a new `B` or `D` completes a removable pair?

---

## 5. [LC 71 — Simplify Path](https://leetcode.com/problems/simplify-path/)

**Recognize it:** a path is a sequence of directory components, and `..` means “undo the most recent directory.” This is stack-like history.

**How to start:** split on `/`. Ignore empty components and `.`; for `..`, pop one directory only if possible; otherwise push the component as a folder name.

**Key idea to remember:** exactly `.` and `..` have special meanings. `...` is an ordinary directory name. A path cannot go above root `/`.

### Code
```java
import java.util.*;

class Solution {
    public String simplifyPath(String path) {
        Deque<String> dirs = new ArrayDeque<>();

        for (String part : path.split("/")) {
            if (part.isEmpty() || part.equals(".")) {
                continue;
            }

            if (part.equals("..")) {
                if (!dirs.isEmpty()) {
                    dirs.removeLast();
                }
            } else {
                dirs.addLast(part);
            }
        }

        StringBuilder answer = new StringBuilder();

        for (String dir : dirs) {
            answer.append('/').append(dir);
        }

        return answer.length() == 0 ? "/" : answer.toString();
    }
}
```

### Dry run: `path = "/home//foo/../bar/./"`
| Part | Action | Directories |
|---|---|---|
| `home` | add directory | `home` |
| empty part | ignore repeated `/` | `home` |
| `foo` | add directory | `home, foo` |
| `..` | remove last directory | `home` |
| `bar` | add directory | `home, bar` |
| `.` | ignore current-directory marker | `home, bar` |
| trailing empty part, if present | ignore | `home, bar` |

**Result:** `"/home/bar"`

### Edge cases to check
- `"/"` or `"/../../"` → `"/"`; moving above root is ignored.
- Repeated slashes, e.g. `"//home///foo"` → `"/home/foo"`.
- `"."` means current directory; `".."` means parent directory.
- `"..."` is an ordinary directory name, not the same as `"."` or `".."`.
- Always return an absolute path beginning with `/`.

### Recall check
Why should `"..."` be treated as a directory name while `".."` removes a directory?

---

## 6. [LC 394 — Decode String](https://leetcode.com/problems/decode-string/)

**Recognize it:** brackets can be nested, so when you enter an inner section you must remember the outer work and resume it later.

**How to start:** build a possibly multi-digit number; at `[`, save the repeat count and current partial string, then start a fresh inner string. At `]`, repeat the inner string and append it to the saved outer string.

**Key idea to remember:** save **both** the count and the previous string. With nesting, the saved contexts are last-in, first-out. Reset the number after saving it.

### Code
```java
import java.util.*;

class Solution {
    public String decodeString(String s) {
        Deque<Integer> counts = new ArrayDeque<>();
        Deque<StringBuilder> previousStrings = new ArrayDeque<>();
        StringBuilder current = new StringBuilder();
        int number = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                number = number * 10 + (c - '0');
            } else if (c == '[') {
                counts.push(number);
                previousStrings.push(current);
                current = new StringBuilder();
                number = 0;
            } else if (c == ']') {
                int repeat = counts.pop();
                StringBuilder previous = previousStrings.pop();

                for (int i = 0; i < repeat; i++) {
                    previous.append(current);
                }

                current = previous;
            } else {
                current.append(c);
            }
        }

        return current.toString();
    }
}
```

### Dry run: `s = "3[a2[c]]"`
| Input event | Current decoded section | Saved outer state |
|---|---|---|
| read `3[` | start a new section | count `3`, previous string `""` |
| read `a` | `a` | outer count `3` remains saved |
| read `2[` | start nested section | count stack: `2, 3`; previous strings: `"a", ""` |
| read `c` | `c` | both outer contexts remain saved |
| first `]` | repeat `c` twice → `cc`; append to previous `"a"` | current becomes `acc` |
| final `]` | repeat `acc` three times | current becomes `accaccacc` |

**Result:** `"accaccacc"`

### Edge cases to check
- Multi-digit repeat count: `"10[a]"` → ten `a` characters; build the number digit by digit.
- Nested sections: the count and previous string must be saved at every `[` and restored at the matching `]`.
- Literal letters outside brackets must remain in the result.
- Reset `number = 0` after processing `[`, or digits can leak into the next repeat count.

### Recall check
Why do we need to save **both** the repeat count and the previous string?

---

## 7. [LC 1441 — Build an Array With Stack Operations](https://leetcode.com/problems/build-an-array-with-stack-operations/)

**Recognize it:** values arrive in order `1, 2, 3, ...`; you must keep only the values that match the next item in `target`.

**How to start:** for each stream value, emit `Push`. If it equals the next wanted target value, advance the target pointer; otherwise emit `Pop` immediately.

**Key idea to remember:** every input value causes a `Push`; an unwanted value needs a following `Pop`. Stop as soon as all target values are matched.

### Code
```java
import java.util.*;

class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> operations = new ArrayList<>();
        int i = 0;

        for (int value = 1; value <= n && i < target.length; value++) {
            operations.add("Push");

            if (value == target[i]) {
                i++;
            } else {
                operations.add("Pop");
            }
        }

        return operations;
    }
}
```

### Dry run: `target = [1, 3], n = 3`
| Stream value | Action | Operations so far | Target progress |
|---|---|---|---|
| `1` | push; it is wanted | `Push` | matched `1` |
| `2` | push; unwanted, so pop | `Push, Push, Pop` | still waiting for `3` |
| `3` | push; it is wanted | `Push, Push, Pop, Push` | target complete; stop |

**Result:** `["Push", "Push", "Pop", "Push"]`

### Edge cases to check
- Target starts above `1`, e.g. `[2]` → push then pop for `1`, then push for `2`.
- Target is `[1]` → only `"Push"`; stop once the target is complete.
- `target` ends before `n` → do not process unnecessary values after all target items are matched.
- Because `target` is increasing, a stream value below `target[i]` is unwanted and must be popped.

### Recall check
When does one stream value produce `Push` only, and when does it produce `Push` followed by `Pop`?

---

## 8. [LC 682 — Baseball Game](https://leetcode.com/problems/baseball-game/)

**Recognize it:** operations refer to earlier **valid scores**, including undoing the latest one. Keep a history of scores after each operation.

**How to start:** number → append it; `C` → remove last score; `D` → append double of last score; `+` → append the sum of the last two valid scores.

**Key idea to remember:** `C` changes the score history, not the input operations. Therefore `D` and `+` must use the updated history after cancellations.

### Code
```java
import java.util.*;

class Solution {
    public int calPoints(String[] operations) {
        List<Integer> scores = new ArrayList<>();

        for (String op : operations) {
            int size = scores.size();

            if (op.equals("C")) {
                scores.remove(size - 1);
            } else if (op.equals("D")) {
                scores.add(scores.get(size - 1) * 2);
            } else if (op.equals("+")) {
                scores.add(scores.get(size - 1) + scores.get(size - 2));
            } else {
                scores.add(Integer.parseInt(op));
            }
        }

        int total = 0;
        for (int score : scores) {
            total += score;
        }

        return total;
    }
}
```

### Dry run: `operations = ["5", "2", "C", "D", "+"]`
| Operation | Scores after operation |
|---|---|
| `"5"` | `[5]` |
| `"2"` | `[5, 2]` |
| `"C"` | `[5]` — remove last valid score |
| `"D"` | `[5, 10]` — double last score |
| `"+"` | `[5, 10, 15]` — sum last two scores |

**Total:** `5 + 10 + 15 = 30`

### Edge cases to check
- Negative numeric operation such as `"-2"` → parse as an integer, not a special command.
- `"C"` removes the last **valid score**, not the last operation token.
- `"D"` and `"+"` use scores remaining after previous cancellations.
- The problem guarantees valid operations (enough earlier scores for `C`, `D`, and `+`).

### Recall check
Why must `"+"` use the last two valid scores after all earlier operations have been applied?

---

## 9. [LC 344 — Reverse String (stack-practice version)](https://leetcode.com/problems/reverse-string/)

**Recognize it:** output order is the reverse of input order. A stack’s LIFO behavior naturally reverses the sequence.

**How to start:** push every character, then pop once for each array position from left to right.

**Key idea to remember:** pushing makes the last input character the first one popped. If you use the stack to fill a separate output array instead, make sure the returned order is correct.

> The LeetCode problem can be solved in-place with two pointers. This is the **stack practice** version, matching this pattern's goal.

### Code
```java
import java.util.*;

class StackReverse {
    public void reverseString(char[] s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s) {
            stack.push(c);
        }

        for (int i = 0; i < s.length; i++) {
            s[i] = stack.pop();
        }
    }
}
```

### Dry run: `s = ['h', 'e', 'l', 'l', 'o']`
Push all characters: top-to-bottom becomes `o, l, l, e, h`.

| Pop number | Character written | Array after write |
|---:|---|---|
| 1 | `o` | `[o, e, l, l, o]` |
| 2 | `l` | `[o, l, l, l, o]` |
| 3 | `l` | `[o, l, l, l, o]` |
| 4 | `e` | `[o, l, l, e, o]` |
| 5 | `h` | `[o, l, l, e, h]` |

**Result:** `['o', 'l', 'l', 'e', 'h']` (the final array is `olleh`).

### Edge cases to check
- Empty array → no pushes or pops; stays empty.
- One character → unchanged.
- Repeated characters → still valid; identical values may make some intermediate states look unchanged.
- Pop exactly as many characters as were pushed.

### Recall check
Why does popping from a stack reverse the input order?

---

## 10. [LC 844 — Backspace String Compare](https://leetcode.com/problems/backspace-string-compare/)

**Recognize it:** `#` means “delete the most recent character that still exists.” Build the effective string for each input; compare those final strings.

**How to start:** normal character → append; `#` → delete the last built character if the builder is not empty. Do the same for both strings.

**Key idea to remember:** comparing the original strings index by index is wrong because backspaces shift what survives. Compare the two built results.

### Code
```java
class Solution {
    private String build(String s) {
        StringBuilder stack = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == '#') {
                if (stack.length() > 0) {
                    stack.deleteCharAt(stack.length() - 1);
                }
            } else {
                stack.append(c);
            }
        }

        return stack.toString();
    }

    public boolean backspaceCompare(String s, String t) {
        return build(s).equals(build(t));
    }
}
```

### Dry run: `s = "ab#c"`, `t = "ad#c"`
| Input | Character actions | Final built string |
|---|---|---|
| `s = "ab#c"` | add `a`; add `b`; `#` removes `b`; add `c` | `"ac"` |
| `t = "ad#c"` | add `a`; add `d`; `#` removes `d`; add `c` | `"ac"` |

**Result:** `true`

### Edge cases to check
- Backspace on an empty built string → ignore it; do not remove anything.
- All characters erased, e.g. `"abc###"` → empty string.
- Different original inputs can still be equal after backspaces.
- Compare the **built strings**, not the original inputs.

### Recall check
Why can we not compare the characters at the same original indices?

---

## 11. [LC 2390 — Removing Stars From a String](https://leetcode.com/problems/removing-stars-from-a-string/)

**Recognize it:** each `*` deletes the closest character to its left that is still present. This is an undo operation.

**How to start:** normal character → append; `*` → remove the current top. Return the built string.

**Key idea to remember:** consecutive stars remove consecutive surviving characters. The second star acts on the result after the first deletion, not the original input position.

### Code
```java
class Solution {
    public String removeStars(String s) {
        StringBuilder stack = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == '*') {
                if (stack.length() > 0) {
                    stack.deleteCharAt(stack.length() - 1);
                }
            } else {
                stack.append(c);
            }
        }

        return stack.toString();
    }
}
```

### Dry run: `s = "leet**cod*e"`
| Current char | Action | Stack after action |
|---|---|---|
| `l e e t` | add each | `leet` |
| first `*` | remove `t` | `lee` |
| second `*` | remove `e` | `le` |
| `c o d` | add each | `lecod` |
| `*` | remove `d` | `leco` |
| `e` | add | `lecoe` |

**Result:** `"lecoe"`

### Edge cases to check
- Consecutive stars remove consecutive preceding characters.
- A star removes the most recent **remaining** character.
- Once a character has been removed, it cannot be removed again.
- The guard `stack.length() > 0` prevents removing from an empty builder; the problem's valid input rules normally ensure a preceding character exists for each star.

### Recall check
How is this similar to LC 844, and what is different about the special character?

---

## 12. [LC 735 — Asteroid Collision](https://leetcode.com/problems/asteroid-collision/)

**Recognize it:** most asteroids never collide. A collision is possible only when the previous survivor at the top moves right (`> 0`) and the current asteroid moves left (`< 0`). One current asteroid may destroy multiple smaller top asteroids, so use `while`, not just `if`.

**How to start:** assume the current asteroid survives. While a collision is possible, compare magnitudes: smaller top → pop and keep checking; equal → pop top and destroy current; larger top → destroy current. Push current only if it survives all collisions.

**Important details to remember:**
- **Why set `isDestroyed = true` in both the `else if` and final `else`?** Both mean the *current* asteroid is destroyed. Equal sizes additionally pop the top because both die; a larger top survives, so do not pop it.
- **Why `break` in these branches?** Once current is destroyed, it cannot collide with another asteroid, and must not be pushed.
- **Why `while`?** The current asteroid can pop one smaller top and then collide with the next top (example: `[10, 2, -5]`).
- **Why does output order need care?** Stack top is the newest survivor; pop into the result from the final index backward, or use `removeLast()` to emit left-to-right.
- **The zero-asteroid confusion:** your saved Coding Ninjas/Code360 practice statement mentioned `0`, while standard LeetCode 735 constraints do not. The earlier discussion mixed advice about retaining/skipping zero; do not copy that advice blindly across platforms. Check the exact platform’s rule and samples. For the standard LeetCode problem, there are no zero-valued asteroids.

**Key trace:** `[10, 2, -5]` → `10`, then `2` are stored; `-5` destroys `2` (`2 < 5`), then loses to `10` (`10 > 5`), so the result is `[10]`.

### Code
```java
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> st = new ArrayDeque<>();
        for (int curr : asteroids) {
            boolean isDestroyed = false;
            while (!st.isEmpty() && st.peek() > 0 && curr < 0) {
                if (Math.abs(st.peek()) < Math.abs(curr)) {
                    st.pop();
                } else if (Math.abs(st.peek()) == Math.abs(curr)) {
                    st.pop();
                    isDestroyed = true;
                    break;
                } else {
                    isDestroyed = true;
                    break;
                }
            }
            if (isDestroyed == false) {
                st.push(curr);
            }
        }
        int ans[] = new int[st.size()];
        int idx = st.size() - 1;
        while(!st.isEmpty()){
            ans[idx] = st.pop();
            idx--;
        }
        return ans;
    }
}
```

### Additional Java implementation — explicit sign handling

This is your second implementation. It keeps the explicit positive/negative cases and uses `destroyed` to record whether the current asteroid was eliminated. The collision rules and dry runs above apply to both implementations.

```java
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> st = new ArrayDeque<>();
        for (int ast : asteroids) {
            if (ast >= 0) {
                st.push(ast);
            } else {
                // ast < 0 
                // there may be 2 cases
                // directly insert karo in St me, additional check not needed, value compare, explode
                if (st.isEmpty()) {
                    st.push(ast);
                } else if (st.peek() < 0) {
                    st.push(ast);
                } else {
                    // 1st entity -> +_pos  --> st.peek()
                    // 2nd entity -> -_Neg  --> ast
                    // collison honga
                    // destroyed vala flag shows ast was alive or destroy by collision
                    boolean destroyed = false;
                    while (!st.isEmpty() && ast < 0 && st.peek() > 0) {
                        if (st.peek() < -ast) {
                            //st.peek() vala ast explode honga
                            st.pop();
                            continue;
                        } else if (st.peek() > -ast) {
                            // ast explode or destroyed honga
                            destroyed = true;
                            // no need to check other ele in stack
                            break;
                        } else {
                            // st.peek() == -ast
                            // dono explode honga 
                            st.pop();
                            destroyed = true;
                            // no need to check other ele in stack
                            break;
                        }
                    }
                    if(destroyed == false){
                        st.push(ast);
                    }
                }
            }
        }
        //mere st k ander ast pade hue h 
        int n = st.size();
        int[] ans = new int[n];
        for(int i = n-1;i>=0;i--){
            ans[i] = st.pop();
        }
        return ans;
    }
}
```

---

### Dry run A: `[5, 10, -5]`
Stack shown **top first**.
| Current asteroid | Collision/action | Stack top-first |
|---|---|---|
| `5` | stack empty, push | `[5]` |
| `10` | same direction as `5`, push | `[10, 5]` |
| `-5` | `10 > 0` and `-5 < 0`; compare magnitudes: `10 > 5`, so current `-5` is destroyed | `[10, 5]` |

**Returned array:** `[5, 10]`. The stack's top-first order must be reversed when filling the result array.

### Dry run B: `[10, 2, -5]` — why `while`, not `if`
| Step | Action | Stack top-first | Current `-5` |
|---|---|---|---|
| process `10`, then `2` | push both | `[2, 10]` | not read yet |
| read `-5` | `2` is smaller; pop it | `[10]` | still alive; check next top |
| compare with `10` | `10` is larger; current `-5` is destroyed | `[10]` | do not push |

**Returned array:** `[10]`. One negative asteroid can hit multiple positive asteroids; after popping a smaller one, the `while` loop must test the next one.

### Dry run C: `[8, -8]` — equal size
- Push `8`.
- Read `-8`; directions allow a collision.
- Magnitudes are equal, so pop `8`, mark `-8` destroyed, and stop.
- The stack is empty; returned array is `[]`.

### Edge cases to check
- **No collision:** `[-2, -1, 1, 2]` → all survive; directions are moving apart or the same way.
- **Small top gets popped:** `[10, 2, -5]` → `2` is destroyed; next compare `-5` with `10`.
- **Current asteroid is destroyed:** `[5, -3]` → `-3` is destroyed; don't push it.
- **Both destroyed:** `[8, -8]` → remove top and do not push current.
- **Current survives several collisions:** `[10, 2, 1, -20]` → successive smaller positive asteroids pop; `-20` survives if no stronger positive remains.
- `top > 0 && curr < 0` is the only collision direction: positive moves right, negative moves left.
- The problem's magnitude constraints are small, so `Math.abs` is safe here.
- When extracting results, `push` made the newest survivor the top; writing popped values from the last array index down to `0` restores left-to-right order.

### Quick reminders
- The collision condition `st.peek() > 0 && curr < 0` means the top moves right and the current asteroid moves left.
- Use `while` because one asteroid can collide with multiple asteroids.
- The sign gives direction; the absolute value gives size.
- If the current asteroid is destroyed, do not push it.
- The stack top is the newest survivor, so restore left-to-right order when building the result array.

### Recall check
Explain, without code, what happens to the current asteroid in each case: stack top smaller, equal, larger, or no possible collision.

---

## 13. Min Stack — [LeetCode 155](https://leetcode.com/problems/min-stack/) / [Code360](https://www.naukri.com/code360/problems/min-stack_3843991)

**Recognize it:** The stack must support normal operations (`push`, `pop`, and `top`) and return the current minimum in constant time. Scanning all values during `getMin()` would take O(n), so maintain a separate minimum-history stack.

### Implementation A — Minimum history with duplicate counts (LeetCode)

- **`valSt`** stores every value pushed into the Min Stack. It is the actual stack and handles `top()` and `pop()`.
- **`minSt`** stores minimum values encountered so far. Each `MinNode` contains the current minimum and its occurrence count.
- `count` tracks duplicate occurrences of the current minimum without storing a separate node for every equal value.

### Code

```java
class MinNode {
    int min;
    int count;

    MinNode(int min, int count) {
        this.min = min;
        this.count = count;
    }
}

class MinStack {
    Deque<MinNode> minSt;
    Deque<Integer> valSt;

    public MinStack() {
        minSt = new ArrayDeque<>();
        valSt = new ArrayDeque<>();
    }

    public void push(int value) {
        valSt.push(value);
        if (minSt.isEmpty()) {
            minSt.push(new MinNode(value, 1));
            return;
        }
        MinNode minTop = minSt.peek();
        if (minTop.min == value) {
            minTop.count += 1;
        } else if (value < minTop.min) {
            minSt.push(new MinNode(value, 1));
        }
    }

    public void pop() {
        if (valSt.isEmpty()) {
            return;
        }
        int popVal = valSt.pop();
        MinNode minTop = minSt.peek();
        if (minTop.min == popVal) {
            if (minTop.count == 1) {
                minSt.pop();
            } else {
                minTop.count -= 1;
            }
        }
    }

    public int top() {
        if (valSt.isEmpty()) {
            return -1;
        }
        return valSt.peek();
    }

    public int getMin() {
        if (minSt.isEmpty()) {
            return -1;
        }
        MinNode minTop = minSt.peek();

        return minTop.min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
```

### Why `push()` has three cases

| Situation | Action on `minSt` | Why |
|---|---|---|
| `minSt` is empty | Push `(value, 1)` | The first value becomes the minimum. |
| `value == minTop.min` | Increment `minTop.count` | Another copy of the active minimum was pushed. |
| `value < minTop.min` | Push a new `MinNode(value, 1)` | A new, smaller minimum becomes active. |
| `value > minTop.min` | Do nothing | The current minimum does not change. |

A value greater than the current minimum still goes into `valSt`; it simply does not need an entry in `minSt`.

### Why `pop()` checks the removed value

First, `pop()` removes the actual top value from `valSt`. Then it asks whether that removed value equals the current minimum:

- **Not equal:** the current minimum is still present, so `minSt` does not change.
- **Equal and count greater than 1:** one copy of the current minimum was removed, so decrease its count.
- **Equal and count is 1:** the last copy of this minimum was removed, so pop its node. The previous minimum becomes active again.

This is how `minSt` remembers the previous minimum without storing every value.

### Dry run: duplicate minimums and restoring the previous minimum

Operations:

```text
push(5)
push(3)
push(3)
push(2)
getMin()
pop()
getMin()
pop()
pop()
getMin()
```

Both stacks are shown **top → bottom**. `minSt` entries are `(min, count)`.

| Operation | `valSt` | `minSt` | Result of `getMin()` |
|---|---|---|---:|
| `push(5)` | `[5]` | `[(5,1)]` | — |
| `push(3)` | `[3,5]` | `[(3,1),(5,1)]` | — |
| `push(3)` | `[3,3,5]` | `[(3,2),(5,1)]` | — |
| `push(2)` | `[2,3,3,5]` | `[(2,1),(3,2),(5,1)]` | — |
| `getMin()` | `[2,3,3,5]` | `[(2,1),(3,2),(5,1)]` | `2` |
| `pop()` removes `2` | `[3,3,5]` | `[(3,2),(5,1)]` | — |
| `getMin()` | `[3,3,5]` | `[(3,2),(5,1)]` | `3` |
| `pop()` removes one `3` | `[3,5]` | `[(3,1),(5,1)]` | — |
| `pop()` removes the other `3` | `[5]` | `[(5,1)]` | — |
| `getMin()` | `[5]` | `[(5,1)]` | `5` |

**Important observation:** When the last `2` is popped, the previous minimum `3` becomes active again. When both `3`s are popped, the previous minimum `5` becomes active. The minimum history is restored by popping `minSt` nodes in last-in, first-out order.

### Edge cases to check

- Push the same minimum multiple times, then pop one copy: the minimum must remain unchanged.
- Push a value greater than the current minimum, then pop it: the minimum history must not change.
- Push a smaller value, then pop it: the previous minimum must become active again.
- Negative values work with the same comparisons.
- When the stack is empty, this implementation's `top()` and `getMin()` return `-1`, and `pop()` does nothing. The `-1` return value is a chosen empty-stack fallback; it can also be a legitimate stack value. LeetCode's standard operation constraints avoid calling `top()` or `getMin()` on an empty stack.

### Complexity

| Operation | Time |
|---|---:|
| `push()` | O(1) |
| `pop()` | O(1) |
| `top()` | O(1) |
| `getMin()` | O(1) |

Space complexity: **O(n)** in the worst case for the two stacks.

### Recall check

1. What does `valSt` store, and what does `minSt` store?
2. Why does pushing a value greater than the current minimum not change `minSt`?
3. Why do equal minimum values increase `count` rather than push another `MinNode`?
4. What happens to the previous minimum when the final copy of the current minimum is popped?
5. Why can `getMin()` return the answer in O(1)?

---

### Implementation B — Separate minimum-history stack (Code360)

- **`stVal`** stores every value in the actual stack.
- **`stMin`** stores a value whenever it is less than or equal to the current minimum.
- Duplicate minimums are stored separately. This means one matching minimum is removed from `stMin` for each matching value removed from `stVal`.

### Code

```java
import java.util.*;
import java.io.*;

public class Solution {

    static class MinStack {

        Stack<Integer> stVal;
        Stack<Integer> stMin;

        MinStack() {
            stVal = new Stack<>();
            stMin = new Stack<>();
        }

        // Function to add another element equal to num at the top of stack.
        void push(int num) {
            if(stVal.isEmpty()){
                stVal.push(num);
                stMin.push(num);
                return;
            }
            int val = stVal.push(num);
            if(val <= stMin.peek()){
                stMin.push(num);
            }
        }

        // Function to remove the top element of the stack.
        int pop() {
            if(stVal.isEmpty()){
                return -1;
            }
            int stValPop = stVal.pop();
            if(stValPop == stMin.peek()){
                return stMin.pop();
            }
            return stValPop;
        }

        // Function to return the top element of stack if it is present. Otherwise
        // return -1.
        int top() {
            if(stVal.isEmpty()){
                return -1;
            }
            return stVal.peek();
        }

        // Function to return minimum element of stack if it is present. Otherwise
        // return -1.
        int getMin() {
            if(stMin.isEmpty()){
                return -1;
            }
            return stMin.peek();
        }
    }
}
```

### Why `push()` uses `<=`

| Situation | Action on `stMin` |
|---|---|
| `stMin` is empty | Push the first value. |
| `num < stMin.peek()` | Push the new minimum. |
| `num == stMin.peek()` | Push the duplicate minimum too. |
| `num > stMin.peek()` | Do not change `stMin`. |

The equality case is important. If the same minimum is pushed twice, both copies must be recorded so that popping one copy does not remove the minimum while another copy is still present.

### Why `pop()` checks the removed value

- If the popped value is greater than the current minimum, only `stVal` changes.
- If it equals the current minimum, pop one matching value from `stMin` as well.
- When the last copy of a minimum is removed, the previous minimum is exposed at the top of `stMin`.

### Dry run: duplicate minimums

Operations:

```text
push(5)
push(3)
push(3)
push(7)
pop()
pop()
pop()
getMin()
```

Both stacks are shown **top → bottom**.

| Operation | `stVal` | `stMin` | Result |
|---|---|---|---:|
| `push(5)` | `[5]` | `[5]` | — |
| `push(3)` | `[3,5]` | `[3,5]` | — |
| `push(3)` | `[3,3,5]` | `[3,3,5]` | — |
| `push(7)` | `[7,3,3,5]` | `[3,3,5]` | — |
| `pop()` removes `7` | `[3,3,5]` | `[3,3,5]` | `7` |
| `pop()` removes one `3` | `[3,5]` | `[3,5]` | `3` |
| `pop()` removes the other `3` | `[5]` | `[5]` | `3` |
| `getMin()` | `[5]` | `[5]` | `5` |

### Edge cases to check

- Push the same minimum several times, then pop one copy: the minimum remains available.
- Push a value greater than the current minimum, then pop it: `stMin` does not change.
- Pop the final copy of the current minimum: the previous minimum becomes active.
- Negative values follow the same comparisons.
- On an empty stack, `pop()`, `top()`, and `getMin()` return `-1` in this implementation.

### Complexity

| Operation | Time |
|---|---:|
| `push()` | O(1) |
| `pop()` | O(1) |
| `top()` | O(1) |
| `getMin()` | O(1) |

Space complexity: **O(n)** in the worst case for the two stacks.

---

## 14. [Code360 — N Stacks In An Array](https://www.naukri.com/code360/problems/n-stacks-in-an-array_1164271)

**Recognize it:** Implement `N` independent stacks using one array of size `S`. Every stack must support `push` and `pop`, while all stacks share the available array space.

### What the four arrays/variables represent

| Name | What it stores | How to think about it |
|---|---|---|
| `arr[]` | Actual stack values | Shared storage for all stacks |
| `top[]` | Top array index for each stack | `top[m - 1]` tells where stack `m` currently ends |
| `next[]` | Next index in a stack chain or in the free-slot chain | One array serves two linking purposes |
| `freeSpot` | First available free index | Head of the linked list of unused array positions |

The key idea is that `next[]` has two roles:

- **When an index is occupied:** `next[index]` points to the next element below it in that particular stack.
- **When an index is free:** `next[index]` points to the next free position.

This lets all stacks share the array dynamically. No fixed partition is reserved for an individual stack.

### Your submitted Java code

```java
import java.util.* ;
import java.io.*; 
public class NStack {
    int N;
    int S;
    int[] arr;
    int[] top;
    int[] next;
    int freeSpot;

    public NStack(int N, int S) {
        this.N = N;
        this.S = S;
        freeSpot = 0;
        arr = new int[S]; 
        top = new int[N];
        for(int i = 0; i < N; i++){
            top[i] = -1;
        }
        next = new int[S];
        for(int i = 0; i < S - 1; i++){
            next[i] = i+1;
        }
        next[S-1] = -1;
    }

    public boolean push(int x, int m) {
        // overflow
        if(freeSpot == -1){
            return false;
        }

        // find free idx
        // jaha val insert krne vale hy, us cell ka idx
        int idx = freeSpot;
        // insert val at free
        arr[idx] = x;
        // update free spot
        freeSpot = next[idx];
        // update next 
        int stIdx = m - 1;
        next[idx] = top[stIdx];
        // update top
        top[stIdx] = idx;
        return true;
    }

    public int pop(int m) {
        // check underflow
        int stIdx = m - 1;
        if(top[stIdx] == -1){
            return -1;
        }

        // find index jisko pop krna hy
        int idx = top[stIdx];
        int popedEle = arr[idx];
        // top update
        top[stIdx] = next[idx];
        // next update
        next[idx] = freeSpot;
        // free spot update
        freeSpot = idx;
        return popedEle;
    }
}
```

### How initialization works

For example, let `N = 2` and `S = 5`.

- `top` starts as `[-1, -1]`, so both stacks are empty.
- `freeSpot = 0`, so index `0` is the first free slot.
- `next` starts as `[1, 2, 3, 4, -1]`, linking every free position to the next one.
- `next[4] = -1` marks the end of the free-slot chain.

Initial state:

| Structure | State |
|---|---|
| `arr` | `[_, _, _, _, _]` |
| `top` | `[-1, -1]` |
| `next` | `[1, 2, 3, 4, -1]` |
| `freeSpot` | `0` |

### Understand `push(x, m)`

A stack number `m` is converted to a zero-based position using `stIdx = m - 1`.

1. If `freeSpot == -1`, no array position is free, so the push fails and returns `false`.
2. Save the first free index in `idx`.
3. Move `freeSpot` to the next free index using `freeSpot = next[idx]`.
4. Store `x` in `arr[idx]`.
5. Link the new element to the previous top using `next[idx] = top[stIdx]`.
6. Make this index the new top using `top[stIdx] = idx`.

The order matters: first remove the slot from the free list, then connect it to the selected stack.

### Understand `pop(m)`

1. Convert stack number `m` to `stIdx = m - 1`.
2. If `top[stIdx] == -1`, that stack is empty, so return `-1`.
3. Save its top index in `idx` and its value in `popedEle`.
4. Move the stack top down using `top[stIdx] = next[idx]`.
5. Put the removed index at the front of the free list using `next[idx] = freeSpot`.
6. Update `freeSpot = idx`, making the popped position available again.

The popped index is now reused by the shared free list. It is not permanently lost.

### Dry run: two stacks sharing five array positions

Start with `N = 2`, `S = 5`, then perform:

```text
push(10, 1)
push(20, 1)
push(30, 2)
push(40, 1)
pop(1)
push(50, 2)
```

The stack contents below are shown **top → bottom**.

| Operation | `arr` | `top` | `next` | `freeSpot` | Result |
|---|---|---|---|---:|---|
| Initialize | `[_, _, _, _, _]` | `[-1, -1]` | `[1, 2, 3, 4, -1]` | 0 | — |
| `push(10, 1)` | `[10, _, _, _, _]` | `[0, -1]` | `[-1, 2, 3, 4, -1]` | 1 | `true` |
| `push(20, 1)` | `[10, 20, _, _, _]` | `[1, -1]` | `[-1, 0, 3, 4, -1]` | 2 | `true` |
| `push(30, 2)` | `[10, 20, 30, _, _]` | `[1, 2]` | `[-1, 0, -1, 4, -1]` | 3 | `true` |
| `push(40, 1)` | `[10, 20, 30, 40, _]` | `[3, 2]` | `[-1, 0, -1, 1, -1]` | 4 | `true` |
| `pop(1)` | `[10, 20, 30, 40, _]` | `[1, 2]` | `[-1, 0, -1, 4, -1]` | 3 | `40` |
| `push(50, 2)` | `[10, 20, 30, 50, _]` | `[1, 3]` | `[-1, 0, -1, 2, -1]` | 4 | `true` |

After these operations:

- Stack 1 (`top[0] = 1`): `20 → 10`.
- Stack 2 (`top[1] = 3`): `50 → 30`.
- Free positions: `4` (`freeSpot = 4`).

**Important observation:** `pop(1)` frees index `3`. The next `push(50, 2)` reuses that same index for a different stack. That is how the stacks share space dynamically.

### Overflow and underflow

- **Overflow:** when every array position is occupied, `freeSpot` becomes `-1`. A new push returns `false`.
- **Underflow:** when the selected stack has `top[stIdx] == -1`, it contains no elements and `pop()` returns `-1`.
- One stack can use most of the array while another uses very little; there is no fixed equal partition.

### Complexity

| Operation | Time |
|---|---:|
| Constructor initialization | O(N + S) |
| `push()` | O(1) |
| `pop()` | O(1) |

Auxiliary space: **O(N + S)** for `top`, `next`, and `arr`.

### Recall check

- [ ] Explain why `top[]` has length `N` while `arr[]` and `next[]` have length `S`.
- [ ] Explain why `freeSpot` starts at `0` and why `next[S - 1] = -1`.
- [ ] Explain the two different roles of `next[]`.
- [ ] Trace how a free index becomes part of a stack during `push()`.
- [ ] Trace how a popped index returns to the free list.
- [ ] Explain why `m - 1` is used to access `top[]`.
- [ ] Explain when overflow and underflow happen.

---

## 15. [LC 225 — Implement Stack using Queues](https://leetcode.com/problems/implement-stack-using-queues/)

**Recognize it:** A stack is LIFO, but a queue is FIFO. Keep the newest pushed value at the front either by rotating the older elements during `push()`, or by rotating them later during `pop()` / `top()`.

### Core idea

This implementation uses one `Deque<Integer>` with **queue behaviour**:

| Operation | What it does here |
|---|---|
| `Q.add(x)` | Adds the new value at the rear of the queue. |
| `Q.remove()` | Removes the front value (`Deque.pop()` is `removeFirst()`). |
| `Q.peek()` | Reads the front value without removing it. |
| `Q.add(Q.remove())` | Moves the front value to the rear — one queue rotation. |

After `push(1)`, `push(2)`, `push(3)`, the queue is `[1, 2, 3]` from front to rear. The newest pushed value (`3`) is at the rear. Rotating the first `n - 1` values moves `3` to the front, where it can be popped or inspected.

### LeetCode 225 implementation

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

[Practice problem](https://www.naukri.com/code360/problems/stack-using-queue_795152?leftPanelTabValue=SUBMISSION)

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

### LeetCode dry run: `push(1)`, `push(2)`, `push(3)`, `pop()`

This version rotates during `pop()`. Queue is shown **front → rear**.

| Step | Operation | Queue after operation | Result |
|---:|---|---|---|
| 1 | `push(1)` | `[1]` | — |
| 2 | `push(2)` | `[1, 2]` | — |
| 3 | `push(3)` | `[1, 2, 3]` | — |
| 4 | First rotation: move `1` to the rear | `[2, 3, 1]` | — |
| 5 | Second rotation: move `2` to the rear | `[3, 1, 2]` | — |
| 6 | `Q.remove()` removes the front | `[1, 2]` | Returns `3` |

The newest pushed value reaches the front after `n - 1` rotations, so `pop()` returns the stack's top.

### How `top()` works in the two implementations

- **LeetCode:** `top()` rotates `n - 1` values, reads the front with `Q.peek()`, then moves that front value to the rear. The final rotation restores the original queue order.
- **Code360:** `push()` has already moved the newest value to the front. Therefore, `top()` only needs `Q.peek()`; no rotation is required.

For the LeetCode queue `[1, 2, 3]`, two rotations produce `[3, 1, 2]`. `peek()` reads `3`; the final rotation restores `[1, 2, 3]`.

### What to understand in this problem

Think of the Queue from **front to rear**. Both implementations make the newest pushed value (`30`) available at the front, but they do it at different times.

- **LeetCode — rotation during `pop()` / `top()`:** `push()` simply adds at the rear. `pop()` or `top()` rotates the first `n - 1` values to bring the newest value to the front.
- **Code360 — rotation during `push()`:** after adding a value at the rear, `push()` rotates the first `n - 1` values. The newly pushed value becomes the front, so `pop()` can remove it directly and `top()` can read it directly.

#### LeetCode: why the loop runs `n - 1` times

Starting Queue: `[10, 20, 30]`

| Action | Queue (front → rear) |
|---|---|
| Start | `[10, 20, 30]` |
| Rotate `10` | `[20, 30, 10]` |
| Rotate `20` | `[30, 10, 20]` |
| `peek()` reads the Stack top | `30` |
| Restore by moving `30` to rear | `[10, 20, 30]` |

The LeetCode `top()` implementation uses `n - 1` rotations. Rotating `n` times would bring the original front back to the front, so `peek()` would read the wrong value.

#### Code360: dry run with rotation during `push()`

Queue is shown **front → rear**.

| Step | Operation | Queue after operation | Result |
|---:|---|---|---|
| 1 | `push(10)` | `[10]` | — |
| 2 | `push(20)`; rotate `10` | `[20, 10]` | — |
| 3 | `push(30)`; rotate `20`, then `10` | `[30, 20, 10]` | — |
| 4 | `top()` → `Q.peek()` | `[30, 20, 10]` | Returns `30` |
| 5 | `pop()` → `Q.remove()` | `[20, 10]` | Returns `30` |

The Code360 invariant is: **the front of `Q` is always the Stack top after every completed `push()`.**

In both implementations, `Q.add(Q.remove())` means **remove the front and add it to the rear**. `Q.size()` stays unchanged during a rotation because one element is removed and one is added.

### Complexity

| Method | LeetCode: rotate in `pop()` / `top()` | Code360: rotate in `push()` |
|---|---:|---:|
| `push()` | `O(1)` | `O(n)` |
| `pop()` | `O(n)` | `O(1)` |
| `top()` | `O(n)` | `O(1)` |
| `empty()` / `isEmpty()` | `O(1)` | `O(1)` |
| `getSize()` | Not required by LC 225 | `O(1)` |

**Auxiliary space:** `O(n)` for the queue holding the pushed values in either implementation.

### Edge cases to revise

- Empty stack: `pop()` and `top()` return `-1` in these implementations.
- One element: `pop()` removes it; `top()` returns it and leaves it in the queue.
- LeetCode: multiple elements are rotated when `pop()` or `top()` is called.
- Code360: after every `push()`, the newest value is at the front; `pop()` and `top()` need no rotation.
- After `top()`, the queue order must remain unchanged.

### Recall check

- [ ] Explain why `Q.add(x)` inserts at the rear.
- [ ] Explain why `Q.remove()` removes the front in this `Deque` implementation.
- [ ] Explain why LeetCode rotates `n - 1` elements inside `pop()` / `top()`.
- [ ] Explain why Code360 rotates `n - 1` elements inside `push()`.
- [ ] Explain why Code360 `pop()` can directly remove the front and `top()` can directly peek.
- [ ] Explain how `Q.add(Q.remove())` changes the Queue while keeping its size unchanged.
- [ ] Dry-run both implementations with `push(10)`, `push(20)`, `push(30)`, `top()`, and `pop()`.

---

# Quick reminders for revision

- **LC 1209:** After a group disappears, the next character may join the newly exposed run.
- **LC 71:** `"."` means current directory, `".."` means parent directory, and `"..."` is an ordinary name.
- **LC 394:** Save both the repeat count and the previous string when entering a nested section.
- **LC 1441:** Every stream value causes `Push`; if it is not needed, follow it with `Pop`.
- **LC 1047 / 1544 / 2696:** After removing a pair, compare the next character with the updated top.
- **LC 155 / Code360 Min Stack:** Keep actual values separately from minimum history; record duplicate minimums so popping one copy does not lose the minimum.
- **Code360 N Stacks In An Array:** `top[]` tracks each stack, `next[]` links stack/free positions, and `freeSpot` tracks the free-list head.
- **LC 225 / Code360 Stack Using Queue:** Queue rotation can happen during `pop()` / `top()` (LeetCode) or during `push()` (Code360).

## Pattern 1 — one-minute recall map

| If you see… | Ask yourself… | Action to remember |
|---|---|---|
| Adjacent removals | Does current match the active top under this problem’s exact rule? | Pop or append |
| Counted duplicate group | Did the top run reach `k`? | Pop the run and its count |
| `#` / `*` | What is the last character still alive? | Delete the current top |
| `..` | What is the latest directory? | Pop one directory if available |
| Nested repeats | What outer context must resume after `]`? | Save and restore count + string |
| History operations | What are the last valid scores *now*? | Update score history in order |
| Constant-time minimum | What is the current minimum, including after pops? | Maintain minimum history; preserve duplicate minimums |
| Multiple stacks in one array | Which stack owns this index, and where is the next free slot? | Link stack elements and free positions through `next[]` |
| Stack using a queue | When should I rotate the older queue values? | During `pop()` / `top()` or immediately during `push()` |
| Reverse | Which element should appear first in the output? | Push all, pop in order |
| Collision | Can top-right-moving and current-left-moving meet? | Resolve repeated collisions before pushing |

### Quick self-check

- [ ] I can say what the stack/builder stores in one sentence.
- [ ] I can name the exact condition that triggers `pop`/deletion.
- [ ] I can trace one example without reading the table.
- [ ] I can explain why a `while` is required (if collisions/cascades can continue).
- [ ] I can explain how Min Stack restores an earlier minimum and handles duplicate minimum values.
- [ ] I can explain how `NStack` shares one array among multiple stacks using `top[]`, `next[]`, and `freeSpot`.
- [ ] I can explain how queue rotation makes `pop()` and `top()` follow LIFO order.
- [ ] I have checked the platform’s special constraints rather than mixing two problem variants.

# Revision checklist

For each problem, mark it only after attempting without looking:
- [ ] I can state the condition that makes me pop, keep, or push.
- [ ] I can dry-run the provided example without reading the trace.
- [ ] I can explain the listed edge cases.
- [ ] I can reconstruct the code's important condition and state update.
- [ ] I can explain why the output is built in the order it is.

**Revision rule:** Passing a problem once and revising it independently are separate achievements. Track only R1, R2, and R3; do not add duplicate problems.
