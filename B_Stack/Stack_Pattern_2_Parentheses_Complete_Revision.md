# Stack Pattern 2 — Parentheses & Brackets

**Use:** Short revision sheet. Read the clue, explain the idea aloud, then dry-run before looking at the code.

> **Code note:** Code is reproduced from the saved practice notes where available. The adjacent-swap snippets are earlier practice attempts; an accepted solution for that version could not be verified from the available history.

---

## 0. Recognize the question

| The question asks… | Start by thinking… |
|---|---|
| Is the whole string valid? | Stack of opening bracket types |
| Longest valid continuous part? | Two-pass counters or an index stack |
| Minimum brackets to add? | Count unmatched opens and closes |
| `*` can be `(`, `)`, or empty? | Track opening and star positions, or possible balance |
| Redundant brackets? | Check whether an operator appears inside each pair |
| Remove outermost parentheses? | Track nesting depth |
| Minimum swaps? | First distinguish adjacent swaps from arbitrary swaps |
| Every `(` needs two `)`? | Consume `))` together and count missing brackets |

**Basic model:** an opening bracket creates an obligation. A closing bracket fulfils it, or shows that an opening bracket is missing. What you do with unmatched brackets depends on the question.

Before coding, define each variable in plain English. `open`, `close`, and `balance` do not mean exactly the same thing in every problem.

---

## 1. LC 20 — Valid Parentheses

**Idea:** The most recent unmatched opening bracket must be closed first, so use a stack. A close must match the stack top; the stack must be empty at the end.

### Code

```java
class Solution {
    public boolean isValid(String s) {
        Deque<Character> st = new ArrayDeque<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } else {
                if (st.isEmpty()) {
                    return false;
                }
                char top = st.peek();
                if (top == '{' && ch != '}') {
                    return false;
                } else if (top == '(' && ch != ')') {
                    return false;
                } else if (top == '[' && ch != ']') {
                    return false;
                } else {
                    st.pop();
                }
            }
        }
        return st.isEmpty();
    }
}
```

### Dry run: `([)]`

| Character | Stack | Result |
|---|---|---|
| `(` | `(` | Push |
| `[` | `([` | Push |
| `)` | `([` | Top is `[`, so `)` does not match → `false` |

**Remember:** `peek()` reads the top; `pop()` removes it. Remove only after the types match.

**Complexity:** `O(n)` time, `O(n)` space.

---

## 2. LC 32 — Longest Valid Parentheses

**Idea:** Find the longest *continuous* valid part. In a left-to-right scan, reset if closes outnumber opens. In a right-to-left scan, reset if opens outnumber closes. Whenever counts match, candidate length is `2 * open`.

### Code — two-pass counters

```java
class Solution {
    public int longestValidParentheses(String s) {
        int open = 0;
        int close = 0;
        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') open++;
            else if (ch == ')') close++;

            if (open == close) {
                maxLen = Math.max(2 * open, maxLen);
            } else if (open < close) {
                open = 0;
                close = 0;
            }
        }

        open = 0;
        close = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (ch == '(') open++;
            else if (ch == ')') close++;

            if (open == close) {
                maxLen = Math.max(2 * open, maxLen);
            } else if (open > close) {
                open = 0;
                close = 0;
            }
        }
        return maxLen;
    }
}
```

### Dry run: `(()`

- Left to right: counts end at `open = 2`, `close = 1`; no equality was found.
- Right to left: read `)`, then `(` → counts become equal at `1` and `1`; candidate length is `2`.
- Answer: `2`, for `()`.

**Remember:** a single direction can miss a valid part when extra opens remain. The reverse pass handles the opposite imbalance.

**Complexity:** `O(n)` time, `O(1)` extra space.

### Alternative stack idea (also kept in your notes)

```java
Deque<Integer> st = new ArrayDeque<>();
st.push(-1);
int maxLen = 0;
for (int i = 0; i < s.length(); i++) {
    char ch = s.charAt(i);
    if (ch == '(') {
        st.push(i);
    } else {
        st.pop();
        if (st.isEmpty()) {
            st.push(i);
        } else {
            int currLen = i - st.peek();
            maxLen = Math.max(currLen, maxLen);
        }
    }
}
return maxLen;
```

The `-1` is a starting boundary. When a closing bracket makes the stack empty, save that index as the new boundary.

---

## 3. LC 678 — Valid Parenthesis String

**Idea:** `*` may represent an open bracket, a close bracket, or nothing. Store indices of `(` and `*`. For each `)`, use an available `(` first, otherwise an earlier `*`. At the end, every leftover `(` needs a `*` to its right.

### Code — two stacks of indices

```java
class Solution {
    public boolean checkValidString(String s) {
        Deque<Integer> stOfbrkt = new ArrayDeque<>();
        Deque<Integer> stOfStar = new ArrayDeque<>();
        for (int pos = 0; pos < s.length(); pos++) {
            char ch = s.charAt(pos);
            if (ch == '(') {
                stOfbrkt.push(pos);
            } else if (ch == '*') {
                stOfStar.push(pos);
            } else {
                if (!stOfbrkt.isEmpty()) {
                    stOfbrkt.pop();
                } else if (!stOfStar.isEmpty()) {
                    stOfStar.pop();
                } else {
                    return false;
                }
            }
        }
        while (!stOfbrkt.isEmpty() && !stOfStar.isEmpty()) {
            int posOfBrkt = stOfbrkt.pop();
            int posOfStar = stOfStar.pop();
            if (posOfBrkt > posOfStar) {
                return false;
            }
        }
        return stOfbrkt.isEmpty();
    }
}
```

### Dry run: `(*`

- Index `0`: save `(` on the opening stack.
- Index `1`: save `*` on the star stack.
- At the end, `0 < 1`, so the star can act as `)` → valid.

For `*(`, the open is at index `1` and the star at index `0`; the star is too early to close it.

**Remember:** `posOfBrkt < posOfStar` is required when a star closes a leftover open.

**Complexity:** `O(n)` time, `O(n)` space.

---

## 4. LC 921 — Minimum Add to Make Parentheses Valid

**Idea:** `add` counts closing brackets that need an opening inserted before them. `open` counts remaining opening brackets that need a closing inserted at the end. Answer is `add + open`.

### Counter code

```java
class Solution {
    public int minAddToMakeValid(String s) {
        int open = 0;
        int add = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                open++;
            } else if (open > 0) {
                open--;
            } else {
                add++;
            }
        }
        return add + open;
    }
}
```

### Dry run: `()))(`

- `(` → `open = 1`
- `)` → matches it; `open = 0`
- Next two `)` → no open exists; `add = 2`
- Final `(` → `open = 1`
- Answer: `add + open = 2 + 1 = 3`

**Stack version recorded in the notes:**

```java
Deque<Character> st = new ArrayDeque<>();
int validPair = 0;

for (char ch : s.toCharArray()) {
    if (ch == '(') {
        st.push(ch);
    } else if (st.isEmpty()) {
        validPair++;
    } else {
        st.pop();
    }
}
return validPair + st.size();
```

Here `validPair` actually counts unmatched closing brackets. The counter version makes the meaning of the variables clearer.

**Complexity:** `O(n)` time; counter version uses `O(1)` extra space.

---

## 5. Coding Ninjas — Minimum Cost to Make String Valid (`{` and `}`)

**Idea:** Cancel valid `{}` pairs first. If the original length is odd, return `-1`. For the leftover braces, reverse half of each group, rounding up.

### Code

```java
if ((str.length() & 1) == 1) return -1;

Deque<Character> st = new ArrayDeque<>();
for (char ch : str.toCharArray()) {
    if (ch == '}' && !st.isEmpty() && st.peek() == '{') {
        st.pop();
    } else {
        st.push(ch);
    }
}

int open = 0, close = 0;
while (!st.isEmpty()) {
    if (st.peek() == '{') open++;
    else close++;
    st.pop();
}
return ((open + 1) / 2) + ((close + 1) / 2);
```

### Dry run: `}}{{`

No valid `{}` pairs cancel. There are two unmatched `}` and two unmatched `{`.

```text
cost = (2 + 1) / 2 + (2 + 1) / 2
     = 1 + 1 = 2
```

**Remember:** in the cancellation condition, the current character is `}` and the stack top is `{`.

**Complexity:** `O(n)` time, `O(n)` space.

---

## 6. GFG — Check Redundant Brackets

**Idea:** An operator inside a bracket pair shows that the pair groups an operation. If a matching pair closes without any operator inside, it is redundant.

### Code

```java
class Solution {
    public boolean checkRedundancy(String s) {
        Deque<Character> st = new ArrayDeque<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } else if (ch == '*' || ch == '+' || ch == '/' || ch == '-') {
                st.push(ch);
            } else if (ch == ']' || ch == ')' || ch == '}') {
                boolean oprPresent = false;

                while (!st.isEmpty()) {
                    char top = st.peek();
                    if (top == '*' || top == '+' || top == '/' || top == '-') {
                        oprPresent = true;
                    }
                    if (ch == '}' && top == '{') { st.pop(); break; }
                    if (ch == ']' && top == '[') { st.pop(); break; }
                    if (ch == ')' && top == '(') { st.pop(); break; }
                    st.pop();
                }
                if (!oprPresent) return true;
            }
        }
        return false;
    }
}
```

### Quick dry run

- `(a)` → no operator inside → redundant.
- `(a+b)` → `+` is found inside → not redundant for this reason.

**Remember:** `oprPresent` resets for each closing bracket pair.

**Complexity:** `O(n)` time, `O(n)` space.

---

## 7. Minimum Adjacent Swaps for Bracket Balancing

**Important distinction:** only neighbouring characters may be swapped. This is different from LC 1963, where any two positions may be swapped.

**Earlier practice attempt — acceptance not verified:**

```java
import java.util.*;
import java.io.*;

public class Solution {
    public static int miniNumSwaps(String brackets, int n) {
        Deque<Character> st = new ArrayDeque<>();

        for (char ch : brackets.toCharArray()) {
            if (ch == ')' && !st.isEmpty() && st.peek() == '(') {
                st.pop();
            } else {
                st.push(ch);
            }
        }

        int open = 0;
        int close = 0;
        while (!st.isEmpty()) {
            if (st.peek() == '(') open++;
            else close++;
            st.pop();
        }
        return ((close + 1) / 2) + ((open + 1) / 2);
    }
}
```

**Another practice approach:**

```java
int balance = 0;
int swap = 0;

for (char ch : brackets.toCharArray()) {
    if (ch == '(') balance++;
    else balance--;

    if (balance < 0) {
        swap++;
        balance = 0;
    }
}
```

An earlier variation used `swap += open` when `balance < 0`.

### Dry run: `))((`

To balance it using adjacent swaps:

```text
))(( → )()( → ())( → ()()
```

This takes 3 adjacent swaps. The exact position/movement matters, so counting only final unmatched brackets is not enough.

**Remember:** reason about how far a bracket must move. Do not reuse the LC 1963 arbitrary-swap formula for this problem.

---

## 8. LC 1963 — Minimum Number of Swaps to Make the String Balanced

**Idea:** Any two positions may be swapped. Count unmatched closing brackets while scanning; the answer is `(close + 1) / 2`, which is integer arithmetic for rounding up half of `close`.

### Counter code

```java
class Solution {
    public int minSwaps(String s) {
        int open = 0;
        int close = 0;

        for (char ch : s.toCharArray()) {
            if (ch == ']' && open > 0) {
                open--;
            } else {
                if (ch == '[') {
                    open++;
                } else if (ch == ']') {
                    close++;
                }
            }
        }
        return (close + 1) / 2;
    }
}
```

### Dry run: `]]][[[`

The first three `]` have no earlier `[` to match, so `close = 3`. The answer is `(3 + 1) / 2 = 2` arbitrary swaps.

**Java detail:** `(open - 1) / 2` means subtract first, then divide. Without parentheses, `open - 1 / 2` evaluates as `open - 0` because integer `1 / 2` is `0`.

**Complexity:** `O(n)` time, `O(1)` extra space.

---

## 9. LC 1021 — Remove Outermost Parentheses

**Idea:** `open` represents the current nesting depth. Skip an opening parenthesis when depth is `0` before incrementing; skip a closing parenthesis when depth becomes `0` after decrementing.

### Code

```java
class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int open = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                if (open > 0) sb.append(ch);
                open++;
            } else {
                open--;
                if (open > 0) sb.append(ch);
            }
        }
        return sb.toString();
    }
}
```

### Dry run: `(()())(())`

- `(()())` → remove its outer pair → `()()`
- `(())` → remove its outer pair → `()`
- Result: `()()()`

**Remember:** check opening brackets before incrementing depth; check closing brackets after decrementing depth.

**Complexity:** `O(n)` time; `O(1)` extra space excluding the output.

---

## 10. LC 1541 — Minimum Insertions to Balance a Parentheses String

**Rule:** Each `(` must match two consecutive `)` characters: `())`.

**Idea:** `open` counts unmatched opening brackets. `close` in this code counts insertions needed (it is not simply the number of `)` characters). When a `)` is followed by another `)`, consume both by incrementing `i`. Otherwise, count the missing partner. If no `(` is waiting, count an inserted `(`. Each leftover `(` needs two `)` at the end.

### Code

```java
class Solution {
    public int minInsertions(String s) {
        int open = 0;
        int close = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                open++;
            } else {
                if (s.length() > i + 1 && s.charAt(i + 1) == ')') {
                    i++;
                } else {
                    close++;
                }

                if (open > 0) {
                    open--;
                } else {
                    close++;
                }
            }
        }
        return close + 2 * open;
    }
}
```

### Dry run: `(()))`

- First `(` → `open = 1`
- Second `(` → `open = 2`
- Next `))` is consumed as one pair → `open = 1`
- Final `)` has no partner `)` after it, so count one insertion; it matches one open → `open = 0`
- Return `close + 2 * open = 1`

**Remember:** the `i++` inside the loop consumes the second `)` too, so it must not be processed again.

**Complexity:** `O(n)` time, `O(1)` extra space.

---

## Quick recall before solving again

- **LC 20:** stack top must match each close; stack empty at end.
- **LC 32:** longest valid continuous part; scan in both directions.
- **LC 678:** a leftover `(` must have a `*` to its right.
- **LC 921:** answer = unmatched closes + unmatched opens.
- **Brace reversal cost:** cancel valid pairs, then round up half of each leftover group.
- **Redundant brackets:** no operator inside the pair means redundant.
- **Adjacent swaps:** count movement distance, not just leftovers.
- **LC 1963:** arbitrary swaps; answer = `(close + 1) / 2`.
- **LC 1021:** track nesting depth and skip primitive boundaries.
- **LC 1541:** each `(` requires two consecutive `)`.

### Small test set

```text
()       already valid
)(       close appears first
((       unmatched opens remain
))       unmatched closes appear
([)]     wrong nesting
(()      valid pair inside an unmatched open
* (      wildcard position matters
}}{{     brace reversal cost
))((     adjacent-swap movement
]]][[[   arbitrary-swap version
```
