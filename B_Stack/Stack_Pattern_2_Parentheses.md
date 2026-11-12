# Stack Pattern 2 — Parentheses & Brackets

**Use:** Short revision sheet. Read the clue, explain the idea aloud, then dry-run before looking at the code.

---

## Revision navigation

### Learn the pattern first
- **0. Recognize the question** — identify what each bracket problem is asking before choosing the stack/counter approach.

### Problem-by-problem revision
1. [LC 20 — Valid Parentheses](https://leetcode.com/problems/valid-parentheses/)
2. [LC 678 — Valid Parenthesis String](https://leetcode.com/problems/valid-parenthesis-string/)
3. [LC 32 — Longest Valid Parentheses](https://leetcode.com/problems/longest-valid-parentheses/)
4. [LC 921 — Minimum Add to Make Parentheses Valid](https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/)
5. [Code360 — Minimum Cost to Make String Valid](https://www.naukri.com/code360/problems/minimum-cost-to-make-string-valid_1115770) (`{` and `}`)
6. [LC 1541 — Minimum Insertions to Balance a Parentheses String](https://leetcode.com/problems/minimum-insertions-to-balance-a-parentheses-string/)
7. Minimum Adjacent Swaps for Bracket Balancing
8. [LC 1963 — Minimum Number of Swaps to Make the String Balanced](https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-string-balanced/)
9. [LC 1021 — Remove Outermost Parentheses](https://leetcode.com/problems/remove-outermost-parentheses/)
10. [GFG — Check Redundant Brackets](https://www.geeksforgeeks.org/problems/expression-contains-redundant-bracket-or-not/1)
11. [LC 227 — Basic Calculator II](https://leetcode.com/problems/basic-calculator-ii/)
12. [LC 150 — Evaluate Reverse Polish Notation](https://leetcode.com/problems/evaluate-reverse-polish-notation/)
13. [LC 224 — Basic Calculator](https://leetcode.com/problems/basic-calculator/)

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
| Arithmetic expression with `+`, `-`, `*`, `/` but no parentheses? | Apply the previous operator when each number is complete; use a stack for precedence |
| Arithmetic expression with nested parentheses and `+`/`-`? | Save the outer result and sign at `(`; combine them at `)` |
| Postfix expression (operator after its operands)? | Push numbers; pop the right operand, then the left operand; calculate and push the result |

**Basic model:** an opening bracket creates an obligation. A closing bracket fulfils it, or shows that an opening bracket is missing. What you do with unmatched brackets depends on the question.

Before coding, define each variable in plain English. `open`, `close`, and `balance` do not mean exactly the same thing in every problem.

---

## 1. [LC 20 — Valid Parentheses](https://leetcode.com/problems/valid-parentheses/)

**Idea:** The most recent unmatched opening bracket must be closed first, so use a stack. A close must match the stack top; the stack must be empty at the end.


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
                    st.pop(); // The bracket types match.
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

## 2. [LC 678 — Valid Parenthesis String](https://leetcode.com/problems/valid-parenthesis-string/)

**Idea:** `*` may represent an open bracket, a close bracket, or nothing. Store indices of `(` and `*`. For each `)`, use an available `(` first, otherwise an earlier `*`. At the end, every leftover `(` needs a `*` to its right.

### Two stacks of indices

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
            if (posOfBrkt > posOfStar) { // The star is too early to close this open.
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

## 3. [LC 32 — Longest Valid Parentheses](https://leetcode.com/problems/longest-valid-parentheses/)

**Idea:** Find the longest *continuous* valid part. In a left-to-right scan, reset if closes outnumber opens. In a right-to-left scan, reset if opens outnumber closes. Whenever counts match, candidate length is `2 * open`.

### Two-pass counters

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
            } else if (open < close) { // This prefix cannot be part of a valid substring.
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
            } else if (open > close) { // Reverse scan: too many opens in this prefix.
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

### Stack-based approach

```java
Deque<Integer> st = new ArrayDeque<>();
st.push(-1); // Boundary before the current valid substring.
int maxLen = 0;
for (int i = 0; i < s.length(); i++) {
    char ch = s.charAt(i);
    if (ch == '(') {
        st.push(i);
    } else {
        st.pop();
        if (st.isEmpty()) {
            st.push(i); // New boundary after an unmatched close.
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

## 4. [LC 921 — Minimum Add to Make Parentheses Valid](https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/)

**Idea:** `add` counts closing brackets that need an opening inserted before them. `open` counts remaining opening brackets that need a closing inserted at the end. Answer is `add + open`.

### Counter implementation

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
                add++; // No opening bracket is available for this close.
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

### Stack implementation

```java
Deque<Character> st = new ArrayDeque<>();
int validPair = 0;

for (char ch : s.toCharArray()) {
    if (ch == '(') {
        st.push(ch);
    } else if (st.isEmpty()) {
        validPair++; // Count an unmatched closing bracket.
    } else {
        st.pop();
    }
}
return validPair + st.size();
```

Here `validPair` actually counts unmatched closing brackets. The counter version makes the meaning of the variables clearer.

**Complexity:** `O(n)` time; counter version uses `O(1)` extra space.

---

## 5. [Code360 — Minimum Cost to Make String Valid](https://www.naukri.com/code360/problems/minimum-cost-to-make-string-valid_1115770) (`{` and `}`)

**Idea:** Cancel valid `{}` pairs first. If the original length is odd, return `-1`. For the leftover braces, reverse half of each group, rounding up.


```java
if ((str.length() & 1) == 1) return -1; // Odd length cannot be balanced.

Deque<Character> st = new ArrayDeque<>();
for (char ch : str.toCharArray()) {
    if (ch == '}' && !st.isEmpty() && st.peek() == '{') {
        st.pop(); // Cancel a matching brace pair.
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
return ((open + 1) / 2) + ((close + 1) / 2); // Flip half of each unmatched group, rounding up.
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

## 6. [LC 1541 — Minimum Insertions to Balance a Parentheses String](https://leetcode.com/problems/minimum-insertions-to-balance-a-parentheses-string/)

**Rule:** Each `(` must match two consecutive `)` characters: `())`.

**Idea:** `open` counts unmatched opening brackets. `close` in this code counts insertions needed (it is not simply the number of `)` characters). When a `)` is followed by another `)`, consume both by incrementing `i`. Otherwise, count the missing partner. If no `(` is waiting, count an inserted `(`. Each leftover `(` needs two `)` at the end.


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
                    i++; // Consume the second ')' in this required pair.
                } else {
                    close++; // Insert the missing second ')'.
                }

                if (open > 0) {
                    open--;
                } else {
                    close++; // Insert a missing '('.
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

## 7. Minimum Adjacent Swaps for Bracket Balancing

**Important distinction:** only neighbouring characters may be swapped. This is different from LC 1963, where any two positions may be swapped.

The snippets below are saved practice approaches; an accepted implementation for this adjacent-swap version is not established in these notes.

```java
import java.util.*;
import java.io.*;

public class Solution {
    public static int miniNumSwaps(String brackets, int n) {
        Deque<Character> st = new ArrayDeque<>();

        for (char ch : brackets.toCharArray()) {
            if (ch == ')' && !st.isEmpty() && st.peek() == '(') {
                st.pop(); // Cancel a matching adjacent pair.
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
        swap++; // Repair this unmatched closing bracket.
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

## 8. [LC 1963 — Minimum Number of Swaps to Make the String Balanced](https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-string-balanced/)

**Idea:** Any two positions may be swapped. Count unmatched closing brackets while scanning; the answer is `(close + 1) / 2`, which is integer arithmetic for rounding up half of `close`.

### Counter implementation

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
                    close++; // No earlier '[' is available to match.
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

## 9. [LC 1021 — Remove Outermost Parentheses](https://leetcode.com/problems/remove-outermost-parentheses/)

**Idea:** `open` represents the current nesting depth. Skip an opening parenthesis when depth is `0` before incrementing; skip a closing parenthesis when depth becomes `0` after decrementing.


```java
class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int open = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                if (open > 0) sb.append(ch); // Exclude the outermost opening bracket.
                open++;
            } else {
                open--;
                if (open > 0) sb.append(ch); // Exclude the outermost closing bracket.
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

## 10. [GFG — Check Redundant Brackets](https://www.geeksforgeeks.org/problems/expression-contains-redundant-bracket-or-not/1)

**Idea:** An operator inside a bracket pair shows that the pair groups an operation. If a matching pair closes without any operator inside, it is redundant.


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
                        oprPresent = true; // An operator makes this pair necessary.
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

## 11. [LC 227 — Basic Calculator II](https://leetcode.com/problems/basic-calculator-ii/)

**Recognize it:** The expression contains non-negative integers and the operators `+`, `-`, `*`, and `/`. Multiplication and division must be evaluated before addition and subtraction.

### Core idea

Use the stack to store signed terms:

- `+` → push the current number as positive.
- `-` → push the current number as negative.
- `*` → pop the previous term, multiply it by the current number, then push the product.
- `/` → pop the previous term, divide it by the current number, then push the quotient.

Multiplication and division are performed immediately. Addition and subtraction are represented by positive and negative stack values, so the final sum gives the answer while preserving operator precedence.


Required imports: `java.util.Deque` and `java.util.ArrayDeque`.

```java
class Solution {
    public int calculate(String s) {
        Deque<Integer> st = new ArrayDeque<>();
        int num = 0;
        int res = 0;
        char sign = '+';
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }
            if ((!Character.isDigit(ch) && ch != ' ') || (i == s.length() - 1)) {
                // Apply the previous operator to the completed number.
                switch (sign) {
                    case '+':
                        st.push(num);
                        break;
                    case '-':
                        st.push(-num);
                        break;
                    case '*':
                        st.push(st.pop() * num); // Apply precedence immediately.
                        break;
                    case '/':
                        st.push(st.pop() / num); // Apply precedence immediately.
                        break;
                }
                sign = ch;
                num = 0;
            }

        }
        while (!st.isEmpty()) {
            res = res + st.pop();
        }
        return res;
    }
}
```

### What each variable represents

| Variable | Meaning |
|---|---|
| `num` | The number currently being built; supports multiple digits. |
| `sign` | The operator that must be applied to the current number. It starts as `+`. |
| `st` | Signed terms and multiplication/division results waiting for the final sum. |
| `res` | The final sum of all values left in the stack. |
| `ch` | The current character being read. |

### When does the code process a number?

The condition below becomes true when the current character is an operator, or when the scan reaches the final character:

```text
if ((!Character.isDigit(ch) && ch != ' ') || (i == s.length() - 1))
```

At that moment, `num` is complete. The `switch (sign)` applies the **previous** operator to that number. Only after that does `sign = ch` save the operator that was just encountered for the next number.

### Dry run: `s = "3+2*2"`

The stack is shown **top → bottom**.

| Character processed | Number built | Previous `sign` applied | Stack after processing |
|---|---:|---|---|
| `3` | 3 | None yet; still building the number | `[]` |
| `+` | 3 | `+` → push `3` | `[3]` |
| `2` | 2 | Still building the number | `[3]` |
| `*` | 2 | `+` → push `2` | `[2, 3]` |
| final `2` | 2 | `*` → pop `2`, multiply by `2`, push `4` | `[4, 3]` |

Now sum the stack:

```text
4 + 3 = 7
```

**Result:** `7`

### Why multiplication happens before addition

For `3 + 2 * 2`:

1. The first `+` stores `3` in the stack.
2. The `*` is encountered after building the second `2`, so the previous `+` stores that `2` too.
3. At the final number, the previous sign is `*`. The code removes the previous `2`, calculates `2 * 2 = 4`, and pushes `4`.
4. The final stack contains `3` and `4`; adding them gives `7`.

The multiplication is therefore completed before the final addition.

### Division and integer behaviour

Java integer division truncates toward zero. For example:

```text
14 - 3 / 2
3 / 2 = 1
14 - 1 = 13
```

For a negative intermediate term:

```text
0 - 3 / 2
-3 / 2 = -1
0 + (-1) = -1
```

The division is performed on the signed value popped from the stack, matching Java's integer-division behaviour.

### Edge cases to revise

| Expression | Result | What it checks |
|---|---:|---|
| `"3+2*2"` | 7 | Multiplication before addition |
| `" 3/2 "` | 1 | Spaces and integer division |
| `" 3+5 / 2 "` | 5 | Spaces and division before addition |
| `"14-3/2"` | 13 | Division before subtraction |
| `"0-3/2"` | -1 | Truncation toward zero for a negative intermediate value |
| `"12+34"` | 46 | Building multi-digit numbers |

### Complexity

- **Time:** `O(n)` — each character is processed once, and each stack entry is pushed and popped at most once.
- **Auxiliary space:** `O(n)` in the worst case for the stack of signed terms.

### Recall check

- [ ] Explain how `num = num * 10 + (ch - '0')` builds a multi-digit number.
- [ ] Explain why `sign` starts as `+`.
- [ ] Explain why the code applies the previous `sign` before assigning `sign = ch`.
- [ ] Explain why `+` and `-` push signed values.
- [ ] Explain why `*` and `/` pop the previous term and immediately push the result.
- [ ] Explain why summing the stack at the end respects operator precedence.
- [ ] Explain how Java integer division behaves for negative values.

---

## 12. [LC 150 — Evaluate Reverse Polish Notation](https://leetcode.com/problems/evaluate-reverse-polish-notation/)

**Recognize it:** The expression is written in postfix form, so an operator appears after its two operands. Push numbers onto the stack. When an operator appears, pop the right operand first, then the left operand, calculate, and push the result back.


```java
class Solution {
    public int evalRPN(String[] tokens) {
        String expStr = "*/+-";
        Deque<Integer> st = new ArrayDeque<>();

        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            if (expStr.contains(token)) {
                int val = 0;
                int op2 = st.pop(); // Right operand is popped first.
                int op1 = st.pop(); // Then pop the left operand.
                switch (token) {
                    case "+":
                        val = op1 + op2;
                        break;
                    case "-":
                        val = op1 - op2;
                        break;
                    case "*":
                        val = op1 * op2;
                        break;
                    case "/":
                        val = op1 / op2;
                        break;
                }
                st.push(val);
            } else {
                st.push(Integer.parseInt(token));
            }
        }
        return st.peek();
    }
}
```

### What the stack stores

- A number token is converted to an integer and pushed.
- When an operator arrives, the two most recent operands are popped.
- The calculated result is pushed back because it may be an operand in a later operation.
- At the end, the stack contains the final result at its top.

### Why pop `op2` before `op1`?

The first popped value is the **right operand**; the second popped value is the **left operand**. The operation must be written as `op1 operator op2`.

For example, when evaluating `13 5 /`:

```text
op2 = 5
op1 = 13
13 / 5 = 2   // integer division
```

Reversing the operands would incorrectly calculate `5 / 13`.

### Dry run: `tokens = ["4", "13", "5", "/", "+"]`

Stack is shown **bottom → top**.

| Token | Action | Stack after action |
|---|---|---|
| `"4"` | Convert to integer and push | `[4]` |
| `"13"` | Convert to integer and push | `[4, 13]` |
| `"5"` | Convert to integer and push | `[4, 13, 5]` |
| `"/"` | Pop `op2 = 5`, `op1 = 13`; calculate `13 / 5 = 2`; push `2` | `[4, 2]` |
| `"+"` | Pop `op2 = 2`, `op1 = 4`; calculate `4 + 2 = 6`; push `6` | `[6]` |

**Result:** `6`

### Why operand order matters for subtraction and division

```text
Tokens: ["5", "2", "-"]
op2 = 2
op1 = 5
result = 5 - 2 = 3
```

The same order applies to division: `op1 / op2`. Java integer division truncates the fractional part toward zero.

### Edge cases to check

- A single number, e.g. `["18"]` → `18`.
- Negative number tokens, e.g. `["-3", "4", "+"]` → `1`; `"-3"` is a number token, not the subtraction operator.
- Subtraction and division must use `op1` as the left operand and `op2` as the right operand.
- Multi-digit numbers are parsed by `Integer.parseInt()`.
- The problem's valid input guarantees enough operands for every operator and a valid final result.

### Complexity

- **Time:** `O(n)`, where `n` is the number of tokens; each token is processed once.
- **Auxiliary space:** `O(n)` in the worst case for the operand/result stack.

### Recall check

- [ ] Explain why numbers are pushed without calculating anything immediately.
- [ ] Explain why an operator pops exactly two operands.
- [ ] Explain why `op2` is popped before `op1`.
- [ ] Explain why the intermediate result is pushed back onto the stack.
- [ ] Dry-run `["4", "13", "5", "/", "+"]` and get `6`.

---

## 13. [LC 224 — Basic Calculator](https://leetcode.com/problems/basic-calculator/)

**Problem:** Evaluate a string containing non-negative integers, `+`, `-`, parentheses, and spaces. Parentheses may be nested.

**Idea:** Keep the result of the current parenthesis level. When `(` appears, save the outer result and its sign. When `)` appears, finish the inner expression and combine it with the saved outer context.

### What each variable stores

| Variable | Meaning |
|---|---|
| `result` | Evaluated sum at the current parenthesis level |
| `number` | Number currently being read; supports multiple digits |
| `sign` | Sign (`1` or `-1`) that applies to the current number |
| `st` | Saved outer contexts; each opening parenthesis pushes the previous result and sign |
| `prevSign` | Sign that was active before entering the current parentheses |
| `prevResult` | Result accumulated before entering the current parentheses |

```java
import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int calculate(String s) {
        Deque<Integer> st = new ArrayDeque<>();
        int result = 0;
        int number = 0;
        int sign = 1;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                number = number * 10 + (ch - '0');
            } else if (ch == ' ') {
                continue;
            } else if (ch == '+') {
                result += sign * number;
                number = 0;
                sign = 1;
            } else if (ch == '-') {
                result += sign * number;
                number = 0;
                sign = -1;
            } else if (ch == '(') {
                // Save the expression context before entering the parentheses.
                st.push(result);
                st.push(sign);

                result = 0;
                sign = 1;
            } else if (ch == ')') {
                // Finish the current inner expression.
                result += sign * number;
                number = 0;

                // Restore the outer sign and result.
                int prevSign = st.pop();
                int prevResult = st.pop();
                result = prevResult + prevSign * result;
            }
        }

        // Add the final number if the expression ends with a digit.
        return result + sign * number;
    }
}
```

### The central idea: what happens at `(` and `)`?

At `(`, the current expression pauses. Save two things:

```java
st.push(result);
st.push(sign);
```

Then start evaluating the inner expression with `result = 0` and `sign = 1`.

At `)`, finish the inner expression and restore the saved context:

```java
result += sign * number;
number = 0;

int prevSign = st.pop();
int prevResult = st.pop();
result = prevResult + prevSign * result;
```

The stack stores the outer context in this order: **result first, sign second**. Therefore, the sign is popped first.

### Full dry run: `(1 + (4 + 5 + 2) - 3) + (6 + 8)`

The expression evaluates to `23`. Follow the saved context at each pair of parentheses:

| Event | Current calculation | Saved outer context | `result` after event |
|---|---|---|---:|
| First `(` | Start the outer expression | `(result = 0, sign = +1)` | 0 |
| Read `1`, then `+` | Commit `+1 × 1` | Outer context remains saved | 1 |
| Inner `(` | Start `(4 + 5 + 2)` | Save `(result = 1, sign = +1)` above the outer context | 0 |
| Read `4 + 5 + 2` | Evaluate the inner expression | Both outer contexts remain saved | 11 |
| Inner `)` | Restore `1 + 1 × 11` | Remove the inner saved context | 12 |
| Read `- 3` | Apply `12 - 3` | Outer context remains saved | 9 |
| Outer `)` | Restore `0 + 1 × 9` | Remove the outer saved context | 9 |
| Next `+ (` | Begin the next group | Save `(result = 9, sign = +1)` | 0 |
| Read `6 + 8` | Evaluate the second group | Saved context remains | 14 |
| Final `)` | Restore `9 + 1 × 14` | Stack becomes empty | 23 |

At the end, `number` is `0`, so the final return gives `23`.

### Why don't we return at `)`?

A closing parenthesis finishes **only the current nested expression**. The rest of the input may still contain operators or more expressions.

For the worked example:

- After the inner `(4 + 5 + 2)`, the result becomes `12`, but `- 3) + (6 + 8)` is still left.
- After the outer `(...)`, the result becomes `9`, but `+ (6 + 8)` is still left.
- Only after the loop processes the entire string can the method return the final answer.

A separate final calculation is also necessary when the expression ends with a number:

```text
Input: 1 + 2
At loop end: result = 1, sign = 1, number = 2
Final value: 1 + 1 × 2 = 3
```

If the expression ends with `)`, that closing-parenthesis branch has already committed the last number and reset `number` to `0`; the same final return still works.

### Useful edge cases

| Input | Output | What it checks |
|---|---:|---|
| `"1 + 2"` | 3 | Final number is added after the loop |
| `"(1+(4+5+2)-3)+(6+8)"` | 23 | Nested parentheses and restoring outer context |
| `"2-(5-3)"` | 0 | A minus sign before parentheses applies to the whole inner result |
| `"-(2+3)"` | -5 | Unary minus before parentheses |
| `"42"` | 42 | Multi-digit number and final calculation |
| `" 7 - 3 "` | 4 | Spaces are ignored |

**Complexity:** `O(n)` time because each character is processed once; `O(n)` auxiliary space in the worst case for nested parentheses.

### Recall check

- [ ] Explain why `result` and `sign` are both pushed when `(` appears.
- [ ] Explain why `prevSign` is popped before `prevResult`.
- [ ] Explain why `)` combines the inner result with the saved outer context instead of returning.
- [ ] Explain why `return result + sign * number` is needed after the loop.
- [ ] Dry-run `(1+(4+5+2)-3)+(6+8)` and reach `23`.

---

## Quick recall before solving again

- **LC 20:** stack top must match each close; stack empty at end.
- **LC 678:** a leftover `(` must have a `*` to its right.
- **LC 32:** longest valid continuous part; scan in both directions.
- **LC 921:** answer = unmatched closes + unmatched opens.
- **Brace reversal cost:** cancel valid pairs, then round up half of each leftover group.
- **LC 1541:** each `(` requires two consecutive `)`.
- **Adjacent swaps:** count movement distance, not just leftovers.
- **LC 1963:** arbitrary swaps; answer = `(close + 1) / 2`.
- **LC 1021:** track nesting depth and skip primitive boundaries.
- **Redundant brackets:** no operator inside the pair means redundant.
- **LC 227:** apply `+`/`-` as signed terms; evaluate `*`/`/` immediately, then sum the stack.
- **LC 150:** push operands; on an operator, pop right operand first and left operand second, then push the result.
- **LC 224:** save the outer result and sign at `(`; at `)`, finish the inner expression and restore the outer context.

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
(1+(2+3))   nested expression; restore the outer context
3+2*2        multiplication before addition
4 13 5 / +  postfix evaluation; operand order matters
```
