# Recursion Revision README (Problems 1–27)

Use this file to revise by **pattern**, not by memorizing code.

## How to revise each problem

For every recursion problem, check these 5 things:

1. **What is the base case?**
2. **What is the smaller problem?**
3. **What is the current work?**
4. **What changes in the recursive call?**
5. **What can go wrong?** (off-by-one, wrong return, wrong index, wrong order)

---

## Pattern 1: Print with recursion flow

### 1) Print 1 to N

**Pattern:** post-order print

**Core idea:** go down first, print while returning.

**What to check:**

* Base case must stop at `0`.
* Recursive call must be `n - 1`.
* Printing happens **after** recursion.

**Common mistakes:**

* Printing before recursion by accident.
* Forgetting `return` in the base case.
* Using `n == 1` base case and then printing extra output wrongly.

### 2) Print N to 1

**Pattern:** pre-order print

**Core idea:** print first, then go down.

**What to check:**

* Print before recursive call.
* Base case at `0`.
* Only one recursive call.

**Common mistakes:**

* Putting print after recursion and reversing the output.
* Forgetting that `n == 0` should stop immediately.

### 3) Print Even Numbers / 4) Print Odd Numbers / 5) Print Multiples of K

**Pattern:** conditional pre-order printing

**Core idea:** decide whether to print current value, then recurse.

**What to check:**

* Condition must be correct.
* Recursive call should still reduce by 1.
* No repeated logic in the recursive call.

**Common mistakes:**

* Wrong parity check.
* Using `idx` change incorrectly.
* Printing after recursion when the pattern expects pre-order.

---

## Pattern 2: Single recursive call with combine

### 6) Sum of N

**Pattern:** current contribution + smaller problem

**Core idea:** `n + sumOfN(n - 1)`.

**What to check:**

* Base case returns `0`.
* Recursive call must shrink by 1.
* Current value must be added exactly once.

**Common mistakes:**

* Using `n - 1` as the current contribution.
* Forgetting to return the recursive result.

### 7) Factorial

**Pattern:** multiply current contribution with smaller problem

**Core idea:** `n * fact(n - 1)`.

**What to check:**

* Base case returns `1`.
* Use multiplication, not addition.
* `n <= 0` is okay for learning; interview version usually uses `n == 0`.

**Common mistakes:**

* Returning `0` in base case.
* Using `fact(n - 2)` accidentally.

### 8) Power(x, n)

**Pattern:** repeated multiplication

**Core idea:** `x * power(x, n - 1)`.

**What to check:**

* Base case returns `1`.
* Base stays the same, exponent decreases.
* The recursive call must use `n - 1`.

**Common mistakes:**

* Multiplying by `n` instead of `x`.
* Changing the base accidentally.
* Confusing `x^n` with `n^x`.

### 9) Fibonacci

**Pattern:** two recursive calls

**Core idea:** `fib(n - 1) + fib(n - 2)`.

**What to check:**

* Base cases: `0` and `1`.
* Two recursive branches are expected.
* This is exponential without memoization.

**Common mistakes:**

* Forgetting one base case.
* Thinking it is a single-call recursion.
* Mixing up the order of `n - 1` and `n - 2`.

### 10) Product of Array

**Pattern:** current contribution * smaller problem

**Core idea:** `arr[idx] * productArr(arr, idx + 1)`.

**What to check:**

* Base case is the last element.
* Use `idx + 1`.
* Current element must be used, not `arr[0]`.

**Common mistakes:**

* Returning `1` at the wrong base case.
* Using `idx == arr.length` and then reading `arr[idx]`.

---

## Pattern 3: String recursion

### 11) Reverse String

**Pattern:** smaller answer + current character

**Core idea:** `rev(str.substring(1)) + str.charAt(0)`.

**What to check:**

* Base case: empty string.
* Smaller string must shrink.
* Order matters: smaller answer first, current char later.

**Common mistakes:**

* Using `substring(str.length())`.
* Putting current char before the recursive answer.
* Forgetting that `substring(1)` removes the first character.

### 12) Palindrome String

**Pattern:** two-end compare + recursive faith

**Core idea:** compare first and last, then recurse on the middle.

**What to check:**

* Base case: length `<= 1`.
* Compare `charAt(0)` and `charAt(length - 1)`.
* Recurse with `substring(1, length - 1)`.

**Common mistakes:**

* Comparing whole string to one character.
* Removing only one side.
* Forgetting the base case for empty or single-character strings.

---

## Pattern 4: Digit recursion

### 13) Sum of Digits

**Pattern:** last digit + smaller problem

**Core idea:** `(n % 10) + sumOfDigit(n / 10)`.

**What to check:**

* Base case: `n == 0` returns `0`.
* `% 10` gives the last digit.
* `/ 10` removes the last digit.

**Common mistakes:**

* Using `n - 1` instead of `n / 10`.
* Recursing on `n % 10`.
* Forgetting the base case.

### 14) Count Digits

**Pattern:** count one digit + smaller problem

**Core idea:** `1 + countDigits(n / 10)`.

**What to check:**

* Base case: `n == 0` returns `0`.
* Every call contributes exactly one digit.
* Use division, not subtraction.

**Common mistakes:**

* Returning `1` in the base case.
* Using `n - 1`.
* Forgetting that the recursive answer already counts the remaining digits.

---

## Pattern 5: Recursive faith on arrays

### 15) Check Sorted Array

**Pattern:** compare current pair, then recurse

**Core idea:** if current pair is fine, ask recursion about the rest.

**What to check:**

* Base case should stop at the last index.
* Compare `arr[idx]` and `arr[idx + 1]`.
* Recurse with `idx + 1`.

**Common mistakes:**

* Returning `false` when reaching the end.
* Using `idx == arr.length` for pair comparison.
* Forgetting to return the recursive result.

### 16) First Occurrence

**Pattern:** search left to right

**Core idea:** return index as soon as match is found.

**What to check:**

* Base case: `idx == arr.length` returns `-1`.
* If `arr[idx] == target`, return `idx`.
* Otherwise recurse on `idx + 1`.

**Common mistakes:**

* Stopping at `idx == arr.length - 1` too early.
* Missing the last element.
* Returning `0` instead of `-1` when not found.

### 17) Last Occurrence

**Pattern:** search right to left

**Core idea:** recurse backwards and stop only after index `0` is checked.

**What to check:**

* Base case: `idx < 0` returns `-1`.
* Compare current index before stopping.
* Recurse with `idx - 1`.

**Common mistakes:**

* Returning `-1` at `idx == 0` before checking `arr[0]`.
* Using `idx == 0` as the stopping condition.

### 18) Count Occurrences

**Pattern:** conditional counting

**Core idea:** if match, `1 + recursion`; else just recursion.

**What to check:**

* Base case returns `0`.
* Add `1` only when the current element matches.
* Recurse with `idx + 1`.

**Common mistakes:**

* Returning `-1` in base case.
* Counting every element.
* Forgetting to remove unnecessary `count` parameter when the return value already carries the count.

### 19) Contains Target

**Pattern:** boolean search

**Core idea:** return `true` on first match; otherwise keep searching.

**What to check:**

* Base case returns `false`.
* If found, return `true` immediately.
* Recurse to the next index.

**Common mistakes:**

* Returning `true` in base case.
* Continuing recursion after finding the target.

### 20) Maximum Element

**Pattern:** recursive faith with value return

**Core idea:** get max of the rest, then compare with current.

**What to check:**

* Base case returns the last element.
* Recursive call is on `idx + 1`.
* Compare `arr[idx]` with recursive answer.

**Common mistakes:**

* Using `Integer.MIN_VALUE` inside each call and never combining.
* Returning too early.
* Modifying the array unnecessarily.

### 21) Minimum Element

**Pattern:** same as maximum, but with `Math.min`

**Core idea:** `Math.min(arr[idx], minOfRest)`.

**What to check:**

* Same base case as maximum.
* Only operator changes from max to min.

**Common mistakes:**

* Mixing up max/min.
* Reusing the wrong variable name.

### 22) Index of Maximum

**Pattern:** recursive faith with index return

**Core idea:** get max index of the rest, then compare values at indices.

**What to check:**

* Base case returns the last index.
* Compare `arr[idx]` with `arr[maxIdx]`.
* Return the index of the larger value.

**Common mistakes:**

* Returning the value instead of the index.
* Modifying the array.
* Comparing indices instead of values.

### 23) Index of Minimum

**Pattern:** same as max index, but with `<`

**Core idea:** get min index of the rest, then compare values.

**What to check:**

* Base case returns the last index.
* Compare values, not indices.

**Common mistakes:**

* Replacing `>` with `<` but forgetting the recursive logic.

---

## Pattern 6: Index jump recursion

### 24) Sum of Elements at Even Indices

**Pattern:** skip by 2

**Core idea:** `arr[idx] + sumEvenIdx(arr, idx + 2)`.

**What to check:**

* Base case must be `idx >= arr.length`.
* Current contribution is `arr[idx]`.
* Jump by 2.

**Common mistakes:**

* Using `idx == arr.length`.
* Using `arr[0]` instead of `arr[idx]`.
* Forgetting that jumping by 2 can skip past the end.

### 25) Print Elements at Even Indices

**Pattern:** pre-order traversal with a jump

**Core idea:** print current element, then recurse with `idx + 2`.

**What to check:**

* Base case `idx >= arr.length`.
* Print before recursive call.

**Common mistakes:**

* Using `i` instead of `idx`.
* Missing the semicolon.
* Printing after recursion when you want forward order.

### 26) Print Elements at Even Indices in Reverse

**Pattern:** post-order traversal with a jump

**Core idea:** recurse first, then print current element.

**What to check:**

* Same base case as above.
* Print after recursion to reverse the order.

**Common mistakes:**

* Forgetting that changing print position changes the output order.

### 27) Count Greater Than X

**Pattern:** parameterized conditional counting

**Core idea:** same as counting positives, but condition is `arr[idx] > x`.

**What to check:**

* Base case returns `0`.
* Compare against the parameter `x`.
* Add `1` only when the condition matches.

**Common mistakes:**

* Hardcoding `> 0` instead of using `x`.
* Using the wrong base case.
* Writing a new recursion from scratch instead of reusing the counting template.

---

## Biggest weak points to watch during revision

When you revise, most mistakes will come from these loop holes:

* **Base case off by one** (`==` vs `>=`)
* **Wrong recursive step** (`idx + 1` vs `idx + 2` vs `idx - 1`)
* **Returning too early** (`return true` before checking the rest)
* **Using the wrong current contribution** (`arr[0]` instead of `arr[idx]`)
* **Confusing value return vs index return**
* **Mixing pre-order and post-order accidentally**
* **Forgetting that some jumps can skip past the array end**
* **Using iterative thinking inside recursive code**

---

## Quick self-check before you move on

For every new problem, ask:

* What is the base case?
* What is the exact smaller problem?
* Am I returning a value, an index, a boolean, or printing?
* Do I need pre-order, post-order, or recursive faith?
* Can the recursive call skip past the end?

If you can answer those five questions, you are not memorizing recursion—you are understanding it.
