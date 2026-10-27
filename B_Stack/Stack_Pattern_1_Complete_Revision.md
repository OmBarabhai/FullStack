# Stack Pattern 1 — Complete Revision Sheet
**Scope:** The 12 problems in Pattern 1 only  
**Use:** Open this on revision Day 3–4. Try each dry run yourself before reading the trace.

> **Code note:** The exact original submission was recoverable for **LC 735 — Asteroid Collision**. For the other 11 problems, the original code could not be verified from the available history; their snippets are labeled **Java reference code**, not your original submissions.

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

## 1. LC 1047 — Remove All Adjacent Duplicates in String

**Recognize it:** only *adjacent equal* characters disappear. The final result depends on what remains after earlier deletions, so build the answer from left to right.

**How to start:** for each character, compare it with the last character in the built result. Same → remove the top; different or empty → append.

**Key idea to remember:** after deleting `bb` from `abbaca`, the `a` before it becomes the top; the next `a` must remove it. Do not compare against the original string’s previous character.

### Java reference code
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

## 2. LC 1544 — Make The String Great

**Recognize it:** two adjacent characters cancel only when they are the *same letter in opposite cases* (`aA`, `Bb`). Same case does not cancel.

**How to start:** compare the current character with the built result’s top; compare letters case-insensitively, but also require the actual characters to be different.

**Key idea to remember:** `top == curr` is the wrong test: `aa` stays, while `aA` cancels.

### Java reference code
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

## 3. LC 1209 — Remove All Adjacent Duplicates in String II

**Recognize it:** a whole run disappears when its length reaches `k`; storing just the character is not enough. Track **character and count together**.

**How to start:** if current character equals the top run’s character, increment its count; otherwise create a run with count `1`. When count becomes `k`, pop that run.

**Key idea to remember:** popping a run exposes an earlier run. The next input character may continue that exposed run, causing another deletion. Counts belong to the active run, not to the character globally.

### Java reference code
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

## 4. LC 2696 — Minimum String Length After Removing Substrings

**Recognize it:** only the exact pairs `AB` and `CD` are removable; this is not general duplicate removal.

**How to start:** while reading the string, check whether the current character completes `AB` or `CD` with the built result’s top. If yes, remove the top; otherwise append.

**Key idea to remember:** order matters: `AB` can disappear, but `BA` cannot. After a removal, always let the next character compare with the newly exposed top.

### Java reference code
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

## 5. LC 71 — Simplify Path

**Recognize it:** a path is a sequence of directory components, and `..` means “undo the most recent directory.” This is stack-like history.

**How to start:** split on `/`. Ignore empty components and `.`; for `..`, pop one directory only if possible; otherwise push the component as a folder name.

**Key idea to remember:** exactly `.` and `..` have special meanings. `...` is an ordinary directory name. A path cannot go above root `/`.

### Java reference code
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

## 6. LC 394 — Decode String

**Recognize it:** brackets can be nested, so when you enter an inner section you must remember the outer work and resume it later.

**How to start:** build a possibly multi-digit number; at `[`, save the repeat count and current partial string, then start a fresh inner string. At `]`, repeat the inner string and append it to the saved outer string.

**Key idea to remember:** save **both** the count and the previous string. With nesting, the saved contexts are last-in, first-out. Reset the number after saving it.

### Java reference code
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

## 7. LC 1441 — Build an Array With Stack Operations

**Recognize it:** values arrive in order `1, 2, 3, ...`; you must keep only the values that match the next item in `target`.

**How to start:** for each stream value, emit `Push`. If it equals the next wanted target value, advance the target pointer; otherwise emit `Pop` immediately.

**Key idea to remember:** every input value causes a `Push`; an unwanted value needs a following `Pop`. Stop as soon as all target values are matched.

### Java reference code
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

## 8. LC 682 — Baseball Game

**Recognize it:** operations refer to earlier **valid scores**, including undoing the latest one. Keep a history of scores after each operation.

**How to start:** number → append it; `C` → remove last score; `D` → append double of last score; `+` → append the sum of the last two valid scores.

**Key idea to remember:** `C` changes the score history, not the input operations. Therefore `D` and `+` must use the updated history after cancellations.

### Java reference code
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

## 9. LC 344 — Reverse String (stack-practice version)

**Recognize it:** output order is the reverse of input order. A stack’s LIFO behavior naturally reverses the sequence.

**How to start:** push every character, then pop once for each array position from left to right.

**Key idea to remember:** pushing makes the last input character the first one popped. If you use the stack to fill a separate output array instead, make sure the returned order is correct.

> The LeetCode problem can be solved in-place with two pointers. This is the **stack practice** version, matching this pattern's goal.

### Java reference code
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

## 10. LC 844 — Backspace String Compare

**Recognize it:** `#` means “delete the most recent character that still exists.” Build the effective string for each input; compare those final strings.

**How to start:** normal character → append; `#` → delete the last built character if the builder is not empty. Do the same for both strings.

**Key idea to remember:** comparing the original strings index by index is wrong because backspaces shift what survives. Compare the two built results.

### Java reference code
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

## 11. LC 2390 — Removing Stars From a String

**Recognize it:** each `*` deletes the closest character to its left that is still present. This is an undo operation.

**How to start:** normal character → append; `*` → remove the current top. Return the built string.

**Key idea to remember:** consecutive stars remove consecutive surviving characters. The second star acts on the result after the first deletion, not the original input position.

### Java reference code
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

## 12. LC 735 — Asteroid Collision

**Recognize it:** most asteroids never collide. A collision is possible only when the previous survivor at the top moves right (`> 0`) and the current asteroid moves left (`< 0`). One current asteroid may destroy multiple smaller top asteroids, so use `while`, not just `if`.

**How to start:** assume the current asteroid survives. While a collision is possible, compare magnitudes: smaller top → pop and keep checking; equal → pop top and destroy current; larger top → destroy current. Push current only if it survives all collisions.

**Important details to remember:**
- **Why set `isDestroyed = true` in both the `else if` and final `else`?** Both mean the *current* asteroid is destroyed. Equal sizes additionally pop the top because both die; a larger top survives, so do not pop it.
- **Why `break` in these branches?** Once current is destroyed, it cannot collide with another asteroid, and must not be pushed.
- **Why `while`?** The current asteroid can pop one smaller top and then collide with the next top (example: `[10, 2, -5]`).
- **Why does output order need care?** Stack top is the newest survivor; pop into the result from the final index backward, or use `removeLast()` to emit left-to-right.
- **The zero-asteroid confusion:** your saved Coding Ninjas/Code360 practice statement mentioned `0`, while standard LeetCode 735 constraints do not. The earlier discussion mixed advice about retaining/skipping zero; do not copy that advice blindly across platforms. Check the exact platform’s rule and samples. For the standard LeetCode problem, there are no zero-valued asteroids.

**Key trace:** `[10, 2, -5]` → `10`, then `2` are stored; `-5` destroys `2` (`2 < 5`), then loses to `10` (`10 > 5`), so the result is `[10]`.

### Java code preserved from the available discussion
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

# Quick reminders for revision

- **LC 1209:** After a group disappears, the next character may join the newly exposed run.
- **LC 71:** `"."` means current directory, `".."` means parent directory, and `"..."` is an ordinary name.
- **LC 394:** Save both the repeat count and the previous string when entering a nested section.
- **LC 1441:** Every stream value causes `Push`; if it is not needed, follow it with `Pop`.
- **LC 1047 / 1544 / 2696:** After removing a pair, compare the next character with the updated top.

## Pattern 1 — one-minute recall map

| If you see… | Ask yourself… | Action to remember |
|---|---|---|
| Adjacent removals | Does current match the active top under this problem’s exact rule? | Pop or append |
| Counted duplicate group | Did the top run reach `k`? | Pop the run and its count |
| `#` / `*` | What is the last character still alive? | Delete the current top |
| `..` | What is the latest directory? | Pop one directory if available |
| Nested repeats | What outer context must resume after `]`? | Save and restore count + string |
| History operations | What are the last valid scores *now*? | Update score history in order |
| Reverse | Which element should appear first in the output? | Push all, pop in order |
| Collision | Can top-right-moving and current-left-moving meet? | Resolve repeated collisions before pushing |

### Quick self-check

- [ ] I can say what the stack/builder stores in one sentence.
- [ ] I can name the exact condition that triggers `pop`/deletion.
- [ ] I can trace one example without reading the table.
- [ ] I can explain why a `while` is required (if collisions/cascades can continue).
- [ ] I have checked the platform’s special constraints rather than mixing two problem variants.

# Revision checklist

For each problem, mark it only after attempting without looking:
- [ ] I can state the condition that makes me pop, keep, or push.
- [ ] I can dry-run the provided example without reading the trace.
- [ ] I can explain the listed edge cases.
- [ ] I can reconstruct the code's important condition and state update.
- [ ] I can explain why the output is built in the order it is.

**Revision rule:** Passing a problem once and revising it independently are separate achievements. Track only R1, R2, and R3; do not add duplicate problems.
