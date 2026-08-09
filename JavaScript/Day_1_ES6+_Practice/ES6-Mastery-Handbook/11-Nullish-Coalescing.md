# Nullish Coalescing Operator (`??`)

# Part 1 – Introduction & Fundamentals

> **"The Nullish Coalescing Operator (`??`) provides a default value only when the left-hand value is `null` or `undefined`. Unlike `||`, it does not replace valid values such as `0`, `false`, or `""`."**

---

# Table of Contents

1. What is Nullish Coalescing?
2. Why Was It Introduced?
3. Basic Syntax
4. The Core Mental Model
5. `null` with `??`
6. `undefined` with `??`
7. Normal Values with `??`
8. Falsy Values with `??`
9. `??` vs `||`
10. `??` with Different Data Types
11. `??` with Optional Chaining
12. What `??` Does Not Do
13. Common Beginner Mistakes
14. Summary
15. Hands-on Practice

---

# 1. What is Nullish Coalescing?

Nullish Coalescing (`??`) is an ES2020 operator used to provide a **fallback value**.

It uses the right-hand value only when the left-hand value is:

```text
null
```

or:

```text
undefined
```

Basic example:

```js
const name = null;

console.log(name ?? "Guest");
```

Output:

```text
Guest
```

Because:

```text
name
 ↓
null
 ↓
use "Guest"
```

---

If the value exists:

```js
const name = "Om";

console.log(name ?? "Guest");
```

Output:

```text
Om
```

Because `"Om"` is not `null` or `undefined`.

---

# 2. Why Was It Introduced?

Before `??`, developers commonly used `||` for default values.

Example:

```js
const count = 0;

console.log(count || 10);
```

Output:

```text
10
```

But `0` may be a perfectly valid value.

For example:

```text
cart quantity = 0
score = 0
price = 0
```

We may want to keep `0`.

With `??`:

```js
const count = 0;

console.log(count ?? 10);
```

Output:

```text
0
```

This is the main reason `??` is useful.

---

# 3. Basic Syntax

```js
leftValue ?? rightValue
```

Think:

```text
leftValue
    ↓
Is it null?
    OR
Is it undefined?
    ↓
YES
 ↓
use rightValue

NO
 ↓
use leftValue
```

Example:

```js
const age = null;

const result = age ?? 18;

console.log(result);
```

Output:

```text
18
```

---

# 4. The Core Mental Model

The easiest way to remember `??`:

```text
?? means:

"Use the value on the right
ONLY if the value on the left
is missing."

Missing means:

null
OR
undefined
```

So:

```js
value ?? defaultValue
```

means:

```text
value exists?
      ↓
   YES → use value
      ↓
    NO
      ↓
null / undefined
      ↓
use defaultValue
```

---

# 5. `null` with `??`

Example:

```js
const name = null;

console.log(name ?? "Guest");
```

Output:

```text
Guest
```

Another example:

```js
const city = null;

const result = city ?? "Pune";

console.log(result);
```

Output:

```text
Pune
```

Rule:

```text
null ?? value
       ↓
    value
```

---

# 6. `undefined` with `??`

Example:

```js
let city;

console.log(city ?? "Pune");
```

Output:

```text
Pune
```

Because:

```js
city
```

is:

```text
undefined
```

Another example:

```js
const email = undefined;

console.log(email ?? "No Email");
```

Output:

```text
No Email
```

Rule:

```text
undefined ?? value
             ↓
          value
```

---

# 7. Normal Values with `??`

If the left-hand value is valid, JavaScript keeps it.

## String

```js
const name = "Om";

console.log(name ?? "Guest");
```

Output:

```text
Om
```

---

## Number

```js
const age = 22;

console.log(age ?? 18);
```

Output:

```text
22
```

---

## Array

```js
const users = [];

console.log(users ?? ["Om"]);
```

Output:

```js
[]
```

An empty array is still a value.

---

## Object

```js
const user = {};

console.log(user ?? { name: "Guest" });
```

Output:

```js
{}
```

---

# 8. Falsy Values with `??`

This is one of the most important concepts.

JavaScript has several falsy values:

```text
false
0
""
null
undefined
NaN
```

But `??` only treats these two as nullish:

```text
null
undefined
```

So:

### `0`

```js
console.log(0 ?? 10);
```

Output:

```text
0
```

---

### `false`

```js
console.log(false ?? true);
```

Output:

```text
false
```

---

### Empty String

```js
console.log("" ?? "Guest");
```

Output:

```text
""
```

---

### `null`

```js
console.log(null ?? "Default");
```

Output:

```text
Default
```

---

### `undefined`

```js
console.log(undefined ?? "Default");
```

Output:

```text
Default
```

---

# 9. `??` vs `||`

This is the most important comparison.

## `||`

`||` uses the right-hand value when the left-hand value is **falsy**.

```js
console.log(0 || 10);
```

Output:

```text
10
```

---

## `??`

`??` uses the right-hand value only when the left-hand value is:

```text
null
```

or:

```text
undefined
```

```js
console.log(0 ?? 10);
```

Output:

```text
0
```

---

## Comparison

| Value | `value || "Default"` | `value ?? "Default"` |
|---|---|---|
| `null` | `"Default"` | `"Default"` |
| `undefined` | `"Default"` | `"Default"` |
| `0` | `"Default"` | `0` |
| `false` | `"Default"` | `false` |
| `""` | `"Default"` | `""` |
| `"Om"` | `"Om"` | `"Om"` |

### Remember

```text
|| 
↓
Falsy check

??

↓
Nullish check
```

---

# 10. `??` with Different Data Types

## Number

```js
const score = 0;

console.log(score ?? 100);
```

Output:

```text
0
```

---

## Boolean

```js
const isAdmin = false;

console.log(isAdmin ?? true);
```

Output:

```text
false
```

---

## String

```js
const username = "";

console.log(username ?? "Guest");
```

Output:

```text
""
```

---

## Undefined

```js
let city;

console.log(city ?? "Pune");
```

Output:

```text
Pune
```

---

## Null

```js
const data = null;

console.log(data ?? []);
```

Output:

```js
[]
```

---

# 11. `??` with Optional Chaining

This is one of the most important JavaScript patterns.

Optional Chaining:

```js
?.
```

safely accesses a value.

Nullish Coalescing:

```js
??
```

provides a fallback.

Together:

```js
const user = {};

const city =
    user?.address?.city ?? "Unknown";

console.log(city);
```

Output:

```text
Unknown
```

Think:

```text
user
 ↓
?. address
 ↓
?. city
 ↓
undefined
 ↓
??
 ↓
"Unknown"
```

---

Another example:

```js
const user = {
    address: {
        city: "Pune"
    }
};

const city =
    user?.address?.city ?? "Unknown";

console.log(city);
```

Output:

```text
Pune
```

Because the city exists.

---

# 12. What `??` Does Not Do

## It Does Not Check All Falsy Values

This is wrong:

```text
?? checks:

0
false
""
null
undefined
```

Correct:

```text
?? checks:

null
undefined
```

Only.

---

## It Does Not Validate Data

Example:

```js
const age = user?.age ?? 18;
```

This only says:

```text
If age is null/undefined → use 18
```

It does not check whether:

```text
age is positive
age is a number
age is greater than 18
```

Validation is a separate concept.

---

## It Does Not Convert Values

Example:

```js
const value = 0;

console.log(value ?? 10);
```

The result remains:

```text
0
```

`??` does not convert `0` into another value.

---

# 13. Common Beginner Mistakes

## Mistake 1 — Using `||` when `0` is valid

Wrong:

```js
const quantity = 0;

const result = quantity || 1;
```

Result:

```text
1
```

If `0` is meaningful, use:

```js
const result = quantity ?? 1;
```

Result:

```text
0
```

---

## Mistake 2 — Thinking `??` checks falsy values

Wrong mental model:

```text
?? = falsy check
```

Correct:

```text
?? = null/undefined check
```

---

## Mistake 3 — Expecting `??` to replace an empty string

```js
const name = "";

console.log(name ?? "Guest");
```

Output:

```text
""
```

Because an empty string is not nullish.

---

## Mistake 4 — Confusing `?.` and `??`

```js
user?.name
```

means:

```text
Safely access name.
```

While:

```js
user?.name ?? "Guest"
```

means:

```text
Safely access name.
If missing, use "Guest".
```

---

## Mistake 5 — Mixing `||` and `??` Without Parentheses

This is invalid:

```js
a || b ?? c
```

JavaScript throws a syntax error.

Use parentheses:

```js
(a || b) ?? c
```

or:

```js
a || (b ?? c)
```

---

# 14. Summary

The Nullish Coalescing Operator:

```js
??
```

provides a fallback only when the left side is:

```text
null
```

or:

```text
undefined
```

The most important comparison:

```text
||  → checks falsy values

??  → checks null/undefined
```

Therefore:

```js
0 ?? 10
```

returns:

```text
0
```

while:

```js
0 || 10
```

returns:

```text
10
```

And:

```js
false ?? true
```

returns:

```text
false
```

---

# Key Mental Map

```text
              value ?? default
                     │
                     ▼
            Is value null?
             OR undefined?
                /       \
              YES       NO
               ↓         ↓
            default     value
```

Remember:

```text
?. → Safe Access

?? → Default for null/undefined

?. + ?? → Safe Access + Default
```

---

# 15. Hands-on Practice

> **Important: Do not copy the solution immediately. First think, write the code yourself, then run it.**

## Exercise 1 — Easy

Predict:

```js
console.log(10 ?? 20);
```

---

## Exercise 2 — Easy

Predict:

```js
console.log(null ?? "Guest");
```

---

## Exercise 3 — Easy

Predict:

```js
console.log(undefined ?? "Pune");
```

---

## Exercise 4 — Important

Predict:

```js
console.log(0 ?? 100);
console.log(0 || 100);
```

---

## Exercise 5 — Important

Predict:

```js
console.log(false ?? true);
console.log(false || true);
```

---

## Exercise 6 — Important

Predict:

```js
console.log("" ?? "Guest");
console.log("" || "Guest");
```

---

## Exercise 7 — Mixed Values

Predict all outputs:

```js
console.log(null ?? 10);
console.log(undefined ?? 20);
console.log(0 ?? 30);
console.log(false ?? 40);
console.log("" ?? 50);
console.log("Om" ?? 60);
```

---

## Exercise 8 — Real-world Quantity

Write code where:

```js
const quantity = 0;
```

should remain:

```text
0
```

instead of becoming:

```text
1
```

Use `??`.

---

## Exercise 9 — User Name

Given:

```js
const user = {
    name: null
};
```

Return:

```text
Guest
```

using `??`.

---

## Exercise 10 — API Data

Given:

```js
const response = {};
```

Safely get:

```text
Guest
```

from:

```text
response.user.name
```

using both:

```text
?.
??
```

---

## Exercise 11 — Output Prediction

Predict:

```js
const user = {
    age: 0,
    isAdmin: false,
    name: ""
};

console.log(user.age ?? 18);
console.log(user.isAdmin ?? true);
console.log(user.name ?? "Guest");
```

---

## Exercise 12 — Challenge

Create:

```js
function getUserInfo(user) {

}
```

Given:

```js
const user = {
    name: null,
    age: 0,
    isAdmin: false
};
```

Return:

```js
{
    name: "Guest",
    age: 0,
    isAdmin: false
}
```

Requirements:

- Use `??`
- Preserve `0`
- Preserve `false`
- Replace only `null`/`undefined`
- Do not use `if`

---

# Mastery Check

Before moving to Part 2, you should be able to explain this without looking at the notes:

```js
const value =
    user?.profile?.score ?? 0;
```

You should understand:

```text
user
 ↓
?.
 ↓
profile
 ↓
?.
 ↓
score
 ↓
null/undefined?
 ↓
YES → 0
NO  → score
```

And you should immediately know:

```js
0 ?? 10        // 0
false ?? true  // false
"" ?? "Guest"  // ""
null ?? 10     // 10
undefined ?? 10 // 10
```

If you can predict these without guessing, you understand the **fundamentals of Nullish Coalescing**.

---

# Next Part

➡️ **Part 2 – Internal Working, Short-Circuiting, Evaluation Order, `??` vs `||`, Operator Precedence & Deep Understanding**