# Optional Chaining (`?.`)

# Part 1 – Introduction & Fundamentals

> **"Optional Chaining (`?.`) allows you to safely access properties, array elements, and methods when a value may be `null` or `undefined`."**

---

# Table of Contents

1. What is Optional Chaining?
2. Why Was It Introduced?
3. The Core Mental Model
4. Basic Syntax
5. Property Access
6. Nested Property Access
7. `user?.address?.city` vs `user.address?.city`
8. `null` vs `undefined`
9. Optional Chaining with Arrays
10. Optional Chaining with Functions
11. What Optional Chaining Returns
12. What Optional Chaining Does Not Do
13. Common Beginner Mistakes
14. Summary
15. Hands-on Practice

---

# 1. What is Optional Chaining?

Optional Chaining (`?.`) is an ES2020 feature that allows JavaScript to safely access a property, array element, or function when the value before it may be `null` or `undefined`.

Without Optional Chaining:

```js
const user = {
    name: "Om"
};

console.log(user.address.city);
```

`user.address` does not exist.

So:

```text
user
 ↓
address
 ↓
undefined
 ↓
.city ❌
```

JavaScript throws:

```text
TypeError:
Cannot read properties of undefined
```

---

With Optional Chaining:

```js
const user = {
    name: "Om"
};

console.log(user.address?.city);
```

Output:

```text
undefined
```

No `TypeError` occurs.

---

# 2. Why Was It Introduced?

Before Optional Chaining, developers often needed repeated checks.

```js
if (
    user &&
    user.address &&
    user.address.city
) {
    console.log(user.address.city);
}
```

Or:

```js
const city =
    user &&
    user.address &&
    user.address.city;
```

This works, but it becomes repetitive when data is deeply nested.

With Optional Chaining:

```js
const city = user?.address?.city;
```

Much cleaner.

---

# 3. The Core Mental Model

The most important rule to remember is:

```text
?.
 ↓
"If the value before me is
null or undefined,
STOP and return undefined."
```

Otherwise:

```text
KEEP GOING
```

Example:

```js
user?.address?.city
```

Think:

```text
user
 ↓
Does user exist?
 ↓
YES
 ↓
address
 ↓
Does address exist?
 ↓
YES
 ↓
city
 ↓
Return city
```

If `user` is missing:

```text
user
 ↓
undefined
 ↓
STOP
 ↓
undefined
```

This is the easiest mental model for Optional Chaining.

---

# 4. Basic Syntax

## Property Access

```js
object?.property
```

Example:

```js
user?.name
```

---

## Nested Property Access

```js
object?.property?.property
```

Example:

```js
user?.address?.city
```

---

## Array Access

```js
array?.[index]
```

Example:

```js
users?.[0]
```

---

## Function Call

```js
object?.method?.()
```

Example:

```js
user.login?.();
```

---

# 5. Property Access

Consider:

```js
const user = {
    name: "Om",
    age: 22
};
```

Normal access:

```js
console.log(user.name);
```

Output:

```text
Om
```

Optional Chaining:

```js
console.log(user?.name);
```

Output:

```text
Om
```

If `user` exists, Optional Chaining continues normally.

---

If the value is `undefined`:

```js
const user = undefined;

console.log(user?.name);
```

Output:

```text
undefined
```

No error.

---

If the value is `null`:

```js
const user = null;

console.log(user?.name);
```

Output:

```text
undefined
```

No error.

---

# 6. Nested Property Access

Consider:

```js
const employee = {
    name: "Om",
    company: {
        location: {
            city: "Pune"
        }
    }
};
```

We can safely access the city:

```js
console.log(
    employee?.company?.location?.city
);
```

Output:

```text
Pune
```

---

If `company` does not exist:

```js
const employee = {
    name: "Om"
};

console.log(
    employee?.company?.location?.city
);
```

Output:

```text
undefined
```

Execution:

```text
employee
 ↓
company
 ↓
undefined
 ↓
STOP
 ↓
undefined
```

---

# 7. `user?.address?.city` vs `user.address?.city`

This is very important.

## Case 1

```js
user.address?.city
```

Here, JavaScript first evaluates:

```js
user.address
```

The Optional Chaining protects the access to `.city`.

So if:

```js
user.address === undefined
```

the result is:

```text
undefined
```

But if `user` itself is:

```js
undefined
```

then:

```js
user.address?.city
```

still throws an error because JavaScript must first access:

```js
user.address
```

---

## Case 2

```js
user?.address?.city
```

Now both levels are protected.

```text
user
 ↓
?. address
 ↓
?. city
```

If `user` is `undefined`:

```text
user
 ↓
undefined
 ↓
STOP
 ↓
undefined
```

### Rule

When the entire object may be missing, prefer:

```js
user?.address?.city
```

---

# 8. `null` vs `undefined`

Optional Chaining stops when the value is either:

```text
null
```

or:

```text
undefined
```

Example:

```js
const user = null;

console.log(user?.name);
```

Output:

```text
undefined
```

---

Example:

```js
const user = undefined;

console.log(user?.name);
```

Output:

```text
undefined
```

Remember:

```text
null
   \
    → Optional Chaining → undefined

undefined
   /
```

---

# 9. Optional Chaining with Arrays

Optional Chaining can safely access an array element.

```js
const users = [
    {
        name: "Om"
    }
];

console.log(users?.[0]?.name);
```

Output:

```text
Om
```

---

If the element does not exist:

```js
console.log(users?.[5]?.name);
```

Output:

```text
undefined
```

---

If the array itself is missing:

```js
const users = undefined;

console.log(users?.[0]?.name);
```

Output:

```text
undefined
```

---

### Important Syntax

Correct:

```js
users?.[0]
```

Incorrect:

```js
users?[0]
```

The `?.` must come before the brackets:

```js
?.[index]
```

---

# 10. Optional Chaining with Functions

Sometimes an object may or may not contain a function.

Without Optional Chaining:

```js
const user = {};

user.login();
```

This throws:

```text
TypeError
```

because `login` does not exist.

---

With Optional Chaining:

```js
const user = {};

user.login?.();
```

Output:

```text
undefined
```

No error occurs.

---

If the function exists:

```js
const user = {

    login() {

        console.log("Welcome");

    }

};

user.login?.();
```

Output:

```text
Welcome
```

---

# 11. What Optional Chaining Returns

When the chain encounters:

```text
null
```

or:

```text
undefined
```

Optional Chaining returns:

```text
undefined
```

Example:

```js
const user = {};

const city = user?.address?.city;

console.log(city);
```

Output:

```text
undefined
```

Important:

```text
?. does NOT return null
?. returns undefined
```

If you want a default value, that is where Nullish Coalescing comes in:

```js
const city =
    user?.address?.city ?? "Unknown";
```

Output:

```text
Unknown
```

---

# 12. What Optional Chaining Does Not Do

## It Does Not Create Missing Properties

```js
const user = {};

console.log(user?.address?.city);
```

This does not create:

```js
user.address
```

The result is simply:

```text
undefined
```

---

## It Does Not Modify Objects

Optional Chaining is primarily used for safe access.

You cannot use it as the left-hand side of an assignment:

```js
user?.address?.city = "Pune";
```

This is invalid.

To modify the object, use normal assignment after ensuring the required object exists.

---

## It Does Not Replace Validation

Consider:

```js
if (user?.age > 18) {
    console.log("Adult");
}
```

If `age` is missing, the expression becomes:

```js
undefined > 18
```

which evaluates to:

```text
false
```

Optional Chaining only safely accesses the value.

It does not decide whether that value is valid for your business logic.

---

# 13. Common Beginner Mistakes

## Mistake 1 — Protecting the Wrong Level

```js
user.address?.city
```

does not protect `user` itself.

If `user` can be missing:

```js
user?.address?.city
```

is safer.

---

## Mistake 2 — Wrong Array Syntax

Wrong:

```js
users?[0]
```

Correct:

```js
users?.[0]
```

---

## Mistake 3 — Expecting a Default Value

```js
user?.address?.city
```

returns:

```text
undefined
```

It does not return:

```text
"Unknown"
```

For a default:

```js
user?.address?.city ?? "Unknown"
```

---

## Mistake 4 — Trying to Assign

Wrong:

```js
user?.name = "Om";
```

Optional Chaining cannot be used this way.

---

## Mistake 5 — Using It Everywhere

Do not automatically write:

```js
user?.name
```

when you already know `user` must exist.

Use Optional Chaining when the value is genuinely optional or may be missing.

---

# 14. Summary

Optional Chaining:

```js
?.
```

allows safe access when a value may be:

```text
null
```

or:

```text
undefined
```

It works with:

```text
Objects
   ↓
user?.name

Nested Objects
   ↓
user?.address?.city

Arrays
   ↓
users?.[0]

Functions
   ↓
user.login?.()
```

The main rule:

```text
null / undefined
        ↓
       ?.
        ↓
      STOP
        ↓
  return undefined
```

And remember:

```text
?.  → Safe Access

??  → Default Value
```

Example:

```js
const city =
    user?.address?.city ?? "Unknown";
```

---

# 15. Hands-on Practice

> **Rule: Do not look at the solution immediately. Write the code yourself first.**

## Exercise 1 — Easy

Given:

```js
const user = {
    name: "Om"
};
```

Safely access:

```js
user.profile.name
```

using Optional Chaining.

Expected result:

```text
undefined
```

---

## Exercise 2 — Easy

Given:

```js
const user = null;
```

Safely access:

```js
user.address.city
```

without causing an error.

---

## Exercise 3 — Easy

Given:

```js
const users = [
    {
        name: "Om"
    }
];
```

Safely access the name of the first user.

Expected:

```text
Om
```

---

## Exercise 4 — Medium

Safely access the name of the second user:

```js
const users = [
    {
        name: "Om"
    }
];
```

Expected:

```text
undefined
```

---

## Exercise 5 — Medium

Safely call:

```js
user.login()
```

when `login` may not exist.

---

## Exercise 6 — Medium

Given:

```js
const user = {
    address: {
        city: "Pune"
    }
};
```

Safely access the city.

---

## Exercise 7 — Medium

Given:

```js
const user = {};
```

Return:

```text
Unknown
```

when the city does not exist.

Use:

```text
?.
```

and:

```text
??
```

---

## Exercise 8 — Output Prediction

Predict the output **before running the code**:

```js
const user = {
    name: "Om"
};

console.log(user?.name);
console.log(user?.age);
console.log(user?.address?.city);
```

---

## Exercise 9 — Output Prediction

```js
const user = null;

console.log(user?.name);
console.log(user?.address?.city);
```

What will happen?

---

## Exercise 10 — Challenge

Create:

```js
function getUserCity(user) {

}
```

Requirements:

```text
If city exists
    ↓
return city

If city doesn't exist
    ↓
return "City Not Found"
```

Use only:

```text
?.
??
```

Do not use `if`.

---

# Final Mental Map

```text
Optional Chaining
       │
       ├── Object
       │     └── user?.name
       │
       ├── Nested Object
       │     └── user?.address?.city
       │
       ├── Array
       │     └── users?.[0]
       │
       ├── Function
       │     └── user.login?.()
       │
       └── Default
             └── user?.city ?? "Unknown"
```

---

# Optional Chaining (`?.`)

# Part 2 – Internal Working & Deep Understanding

> **"Optional Chaining works by checking whether the value at a specific point in the chain is `null` or `undefined`. If it is, the chain stops and returns `undefined`. Otherwise, JavaScript continues evaluating the expression."**

---

# Table of Contents

1. How Optional Chaining Works
2. Short-Circuiting
3. Evaluation Order
4. Where the Chain Stops
5. `undefined` vs `null`
6. Property Access Internals
7. Array Access Internals
8. Function Call Internals
9. `?.` vs `&&`
10. `?.` + `??`
11. Grouping and Parentheses
12. Assignment Restriction
13. Common Mistakes
14. Best Practices
15. Summary
16. Hands-on Practice

---

# 1. How Optional Chaining Works

Consider:

```js
const user = {
    address: {
        city: "Pune"
    }
};

const city = user?.address?.city;

console.log(city);
```

Output:

```text
Pune
```

JavaScript evaluates the chain from left to right.

```text
user
 ↓
address
 ↓
city
 ↓
"Pune"
```

If a value becomes `null` or `undefined`, Optional Chaining stops the chain.

---

# 2. Short-Circuiting

**Short-circuiting** means JavaScript stops evaluating the remaining chain when the Optional Chaining check encounters `null` or `undefined`.

Example:

```js
const user = {
    name: "Om"
};

const city = user?.address?.city;

console.log(city);
```

Evaluation:

```text
user
 ↓
exists
 ↓
address
 ↓
undefined
 ↓
STOP
 ↓
undefined
```

JavaScript does not continue trying to access:

```js
undefined.city
```

That is why no `TypeError` occurs.

---

## Simple Rule

```text
?. encounters null / undefined
            ↓
          STOP
            ↓
        undefined
```

---

# 3. Evaluation Order

Optional Chaining evaluates from **left to right**.

Example:

```js
const user = {
    address: {
        city: "Pune"
    }
};

console.log(
    user?.address?.city
);
```

Execution:

```text
1. Evaluate user
       ↓
2. Check user
       ↓
3. Access address
       ↓
4. Check address
       ↓
5. Access city
       ↓
6. Return "Pune"
```

---

# 4. Where the Chain Stops

Consider:

```js
const user = {
    address: null
};

console.log(
    user?.address?.city
);
```

Execution:

```text
user
 ↓
exists
 ↓
address
 ↓
null
 ↓
STOP
 ↓
undefined
```

The result is:

```text
undefined
```

---

Another example:

```js
const user = undefined;

console.log(
    user?.address?.city
);
```

Execution:

```text
user
 ↓
undefined
 ↓
STOP
 ↓
undefined
```

---

# 5. `undefined` vs `null`

Optional Chaining stops for both:

```js
undefined
```

and:

```js
null
```

Example:

```js
const user = undefined;

console.log(user?.name);
```

Result:

```text
undefined
```

---

```js
const user = null;

console.log(user?.name);
```

Result:

```text
undefined
```

Important:

```text
Input value → null
              ↓
Optional Chaining
              ↓
Result → undefined
```

So Optional Chaining does not preserve `null` as the result of the failed access.

---

# 6. Property Access Internals

Normal property access:

```js
user.address.city
```

requires every step to be valid.

```text
user
 ↓
address
 ↓
city
```

If `address` is `undefined`:

```js
undefined.city
```

causes:

```text
TypeError
```

Optional Chaining changes the behavior:

```js
user?.address?.city
```

Now:

```text
user
 ↓
address
 ↓
undefined
 ↓
STOP
 ↓
undefined
```

---

# 7. Array Access Internals

Optional Chaining can also protect array access.

```js
const users = [
    {
        name: "Om"
    }
];

console.log(users?.[0]?.name);
```

Evaluation:

```text
users
 ↓
exists
 ↓
[0]
 ↓
object exists
 ↓
name
 ↓
"Om"
```

---

If the array element doesn't exist:

```js
console.log(users?.[5]?.name);
```

Evaluation:

```text
users
 ↓
[5]
 ↓
undefined
 ↓
STOP
 ↓
undefined
```

---

If the array itself is missing:

```js
const users = undefined;

console.log(users?.[0]?.name);
```

Result:

```text
undefined
```

---

# 8. Function Call Internals

Optional Chaining can safely call an optional function.

```js
const user = {};

user.login?.();
```

JavaScript checks:

```text
user.login
      ↓
undefined
      ↓
STOP
      ↓
undefined
```

No function call happens.

---

If the function exists:

```js
const user = {

    login() {

        console.log("Logged In");

    }

};

user.login?.();
```

Execution:

```text
user.login
    ↓
function exists
    ↓
call function
    ↓
"Logged In"
```

Output:

```text
Logged In
```

---

# 9. `?.` vs `&&`

Before Optional Chaining, developers often used `&&`.

Example:

```js
const city =
    user &&
    user.address &&
    user.address.city;
```

Modern version:

```js
const city =
    user?.address?.city;
```

The second version is:

- shorter
- easier to read
- specifically designed for optional property access

---

## Important Difference

`&&` checks **truthiness**.

Optional Chaining checks specifically for:

```text
null
undefined
```

Example:

```js
const user = {
    age: 0
};
```

With `&&`:

```js
const age =
    user &&
    user.age;
```

The result is:

```text
0
```

Here the result happens to remain `0`.

But when building longer conditions, `&&` and `?.` should not be treated as identical operators.

The mental distinction is:

```text
&&
↓
truthiness

?.

↓
null / undefined safety
```

---

# 10. `?.` + `??`

These two operators work extremely well together.

```text
?. 
↓
Safely access

??

↓
Provide fallback
```

Example:

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

Execution:

```text
user
 ↓
address
 ↓
undefined
 ↓
?.
 ↓
undefined
 ↓
??
 ↓
"Unknown"
```

---

## Another Example

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

Because the left side of `??` contains a valid value.

---

# 11. Grouping and Parentheses

Be careful when using parentheses in the middle of a chain.

This is a continuous chain:

```js
user?.address?.city
```

But grouping can break the chain.

Example:

```js
const user = {};

const city =
    (user?.address).city;
```

`user?.address` returns:

```text
undefined
```

Then JavaScript tries:

```js
undefined.city
```

which causes an error.

Safer:

```js
const city =
    user?.address?.city;
```

### Rule

Keep the Optional Chaining continuous when you want the whole nested access to be safe.

---

# 12. Assignment Restriction

Optional Chaining cannot be used on the left side of an assignment.

Wrong:

```js
user?.address?.city = "Pune";
```

This is invalid JavaScript.

Why?

Because `?.` is designed for **safe access**, not safe assignment.

Use normal assignment when the required object exists:

```js
user.address.city = "Pune";
```

Or create/update the object using appropriate logic.

---

# 13. Common Mistakes

## Mistake 1 — Thinking `?.` Protects Everything Automatically

This:

```js
user.address?.city
```

does not protect `user`.

If `user` itself may be missing, use:

```js
user?.address?.city
```

---

## Mistake 2 — Confusing `?.` with `??`

```js
user?.name
```

means:

```text
Safely access name
```

While:

```js
user?.name ?? "Unknown"
```

means:

```text
Safely access name
+
use "Unknown" if result is null/undefined
```

---

## Mistake 3 — Forgetting `?.[]`

Wrong:

```js
users?[0]
```

Correct:

```js
users?.[0]
```

---

## Mistake 4 — Assuming `?.` Validates Data

```js
const age = user?.age;
```

This only safely retrieves `age`.

It does not tell you whether:

```text
age is valid
age is positive
age is above 18
```

Those are separate validation rules.

---

# 14. Best Practices

### 1. Use `?.` when data is genuinely optional

Good:

```js
apiResponse?.user?.profile?.name
```

---

### 2. Combine with `??` when a fallback is needed

```js
const city =
    user?.address?.city ?? "Unknown";
```

---

### 3. Don't overuse it

If an object is guaranteed to exist:

```js
user.name
```

is clearer than:

```js
user?.name
```

---

### 4. Keep chains readable

Good:

```js
user?.profile?.address?.city
```

If the chain becomes extremely long, consider extracting intermediate values.

---

# 15. Summary

Optional Chaining works through:

```text
Evaluation
    ↓
Check for null/undefined
    ↓
Continue OR stop
```

The core behavior:

```text
value?.property
       ↓
null / undefined?
       ↓
YES → undefined
NO  → continue
```

You learned:

- Short-circuiting
- Left-to-right evaluation
- Where the chain stops
- `null` vs `undefined`
- Object access
- Array access
- Function calls
- `?.` vs `&&`
- `?.` + `??`
- Parentheses and chain continuity
- Assignment restriction
- Best practices

---

# Key Mental Map

```text
Optional Chaining
       │
       ├── Property
       │      └── user?.name
       │
       ├── Nested
       │      └── user?.address?.city
       │
       ├── Array
       │      └── users?.[0]
       │
       ├── Function
       │      └── user.login?.()
       │
       └── Default
              └── user?.city ?? "Unknown"
```

Remember:

```text
?.  → safely access

??  → provide fallback
```

---

# 16. Hands-on Practice

> **Do not immediately run the code. First predict, then write your own code, then test it.**

## Exercise 1 — Trace the Chain

Predict the output:

```js
const user = {
    address: {
        city: "Pune"
    }
};

console.log(
    user?.address?.city
);
```

---

## Exercise 2 — Find Where It Stops

```js
const user = {
    address: null
};

console.log(
    user?.address?.city
);
```

Answer:

```text
At which point does the chain stop?
Why?
```

---

## Exercise 3 — `null` vs `undefined`

Predict:

```js
const a = null;
const b = undefined;

console.log(a?.name);
console.log(b?.name);
```

---

## Exercise 4 — Array

```js
const users = [
    {
        name: "Om"
    }
];

console.log(users?.[0]?.name);
console.log(users?.[1]?.name);
```

Predict both outputs.

---

## Exercise 5 — Function

Predict:

```js
const user = {};

console.log(user.login?.());
```

---

## Exercise 6 — `?.` + `??`

Predict:

```js
const user = {};

const city =
    user?.address?.city ?? "Unknown";

console.log(city);
```

---

## Exercise 7 — Important Difference

What happens in each case?

```js
const user = undefined;

console.log(
    user.address?.city
);
```

and:

```js
console.log(
    user?.address?.city
);
```

Explain the difference in your own words.

---

## Exercise 8 — Fix the Code

This code can throw an error:

```js
const city =
    user.address?.location?.city;
```

Rewrite it so that `user` can also be `undefined`.

---

## Exercise 9 — Build a Function

Write:

```js
function getCity(user) {

}
```

Requirements:

```text
City exists
    ↓
return city

City missing
    ↓
return "City Not Found"
```

Use:

```js
?.
??
```

Do not use `if`.

---

## Exercise 10 — Real-World Challenge

Given:

```js
const response = {
    data: {
        user: {
            profile: {
                name: "Om",
                address: {
                    city: "Pune"
                }
            }
        }
    }
};
```

Write code to safely extract:

```text
name
city
email
```

Requirements:

- No `if`
- Use Optional Chaining
- Use `??` for missing values

Expected:

```text
Om
Pune
No Email
```

---

# Final Revision

Before moving to Part 3, you should be able to explain this without looking at the notes:

```js
const city =
    user?.address?.city ?? "Unknown";
```

You should understand:

```text
user
 ↓
?.
 ↓
address
 ↓
?.
 ↓
city
 ↓
undefined if missing
 ↓
??
 ↓
"Unknown" if needed
```
---

# Optional Chaining (`?.`)

# Part 3 – Practical Coding Patterns & Real-World JavaScript

> **"Now that you understand how Optional Chaining works, the goal is to use it naturally while writing JavaScript. This part focuses on API data, objects, arrays, functions, configuration, and practical coding patterns."**

---

# Table of Contents

1. Object Data
2. Nested API Data
3. Arrays of Objects
4. Function Calls
5. Configuration Objects
6. User Data
7. Dynamic Data
8. `?.` + `??` Patterns
9. Combining with Destructuring
10. Combining with Array Methods
11. Real Coding Patterns
12. Common Mistakes
13. Hands-on Practice
14. Summary

---

# 1. Object Data

Consider:

```js
const user = {
    name: "Om",
    age: 22
};
```

Safely access:

```js
console.log(user?.name);
```

Output:

```text
Om
```

Optional property:

```js
console.log(user?.email);
```

Output:

```text
undefined
```

With a fallback:

```js
console.log(
    user?.email ?? "No Email"
);
```

Output:

```text
No Email
```

---

# 2. Nested API Data

API responses are often deeply nested.

Example:

```js
const response = {
    data: {
        user: {
            profile: {
                name: "Om"
            }
        }
    }
};
```

Without Optional Chaining:

```js
const name =
    response.data.user.profile.name;
```

This can fail if any intermediate property is missing.

With Optional Chaining:

```js
const name =
    response?.data?.user?.profile?.name;
```

Output:

```text
Om
```

With fallback:

```js
const name =
    response?.data?.user?.profile?.name
    ?? "Unknown User";
```

---

# 3. Arrays of Objects

Consider:

```js
const users = [
    {
        name: "Om",
        email: "om@gmail.com"
    },
    {
        name: "Sahil",
        email: "sahil@gmail.com"
    }
];
```

Access the first user:

```js
console.log(
    users?.[0]?.name
);
```

Output:

```text
Om
```

Access the second user:

```js
console.log(
    users?.[1]?.email
);
```

Output:

```text
sahil@gmail.com
```

Missing user:

```js
console.log(
    users?.[5]?.name ?? "User Not Found"
);
```

Output:

```text
User Not Found
```

---

# 4. Function Calls

Optional Chaining can safely call functions that may not exist.

```js
const user = {};

user.login?.();
```

No error occurs.

---

If the function exists:

```js
const user = {

    login() {
        console.log("Login Successful");
    }

};

user.login?.();
```

Output:

```text
Login Successful
```

---

## Callback Example

Sometimes a callback is optional.

```js
function processUser(user, callback) {

    console.log(user?.name);

    callback?.();
}
```

Call:

```js
processUser(
    { name: "Om" },
    () => {
        console.log("Done");
    }
);
```

Output:

```text
Om
Done
```

Without a callback:

```js
processUser({
    name: "Om"
});
```

Output:

```text
Om
```

No error occurs.

---

# 5. Configuration Objects

Configuration values may be optional.

```js
const config = {
    server: {
        port: 5000
    }
};
```

Access:

```js
const port =
    config?.server?.port;
```

Output:

```text
5000
```

If the server configuration is missing:

```js
const config = {};

const port =
    config?.server?.port ?? 3000;

console.log(port);
```

Output:

```text
3000
```

---

# 6. User Data

Consider:

```js
const user = {
    profile: {
        name: "Om",
        address: {
            city: "Pune"
        }
    }
};
```

Extract safely:

```js
const name =
    user?.profile?.name ?? "Unknown";

const city =
    user?.profile?.address?.city
    ?? "Unknown";

console.log(name);
console.log(city);
```

Output:

```text
Om
Pune
```

---

# 7. Dynamic Data

Optional Chaining is useful when working with data whose structure may vary.

```js
const data = {
    product: {
        details: {
            price: 70000
        }
    }
};
```

Access:

```js
const price =
    data?.product?.details?.price;
```

Output:

```text
70000
```

If details are missing:

```js
const data = {
    product: {}
};

const price =
    data?.product?.details?.price
    ?? 0;

console.log(price);
```

Output:

```text
0
```

---

# 8. `?.` + `??` Patterns

These operators solve two different problems.

```text
?. 
↓
Safely access

??

↓
Provide fallback
```

Example:

```js
const city =
    user?.address?.city ?? "Unknown";
```

Think:

```text
Can I safely reach city?
        ↓
       ?.
        ↓
If missing → undefined
        ↓
       ??
        ↓
Use "Unknown"
```

---

## Example: Email

```js
const email =
    user?.profile?.email
    ?? "No Email";
```

---

## Example: Role

```js
const role =
    user?.account?.role
    ?? "User";
```

---

## Example: Price

```js
const price =
    product?.details?.price
    ?? 0;
```

---

# 9. Combining with Destructuring

Optional Chaining and Destructuring solve different problems.

Destructuring:

```js
const {
    name
} = user;
```

Optional Chaining:

```js
const name =
    user?.name;
```

If the object itself may be missing:

```js
const name =
    user?.profile?.name;
```

For optional nested data, Optional Chaining is often simpler.

---

# 10. Combining with Array Methods

Optional Chaining can safely access arrays before using their elements.

```js
const users = [
    {
        name: "Om"
    },
    {
        name: "Sahil"
    }
];
```

Example:

```js
const firstUser =
    users?.[0]?.name;
```

Output:

```text
Om
```

You can then use the extracted value:

```js
console.log(
    users?.[0]?.name ?? "No User"
);
```

---

# 11. Real Coding Patterns

## Pattern 1 — API Response

```js
const username =
    response?.data?.user?.name
    ?? "Unknown";
```

---

## Pattern 2 — Optional Email

```js
const email =
    user?.email
    ?? "No Email";
```

---

## Pattern 3 — Optional City

```js
const city =
    user?.address?.city
    ?? "Unknown";
```

---

## Pattern 4 — Optional Array Element

```js
const name =
    users?.[0]?.name
    ?? "No User";
```

---

## Pattern 5 — Optional Function

```js
callback?.();
```

---

## Pattern 6 — Configuration

```js
const port =
    config?.server?.port
    ?? 3000;
```

---

## Pattern 7 — Product Data

```js
const price =
    product?.details?.price
    ?? 0;
```

---

# 12. Common Mistakes

## Mistake 1 — Using `?.` Instead of `??`

Wrong if you need a fallback:

```js
const city =
    user?.address?.city;
```

This can return:

```text
undefined
```

If you want a fallback:

```js
const city =
    user?.address?.city
    ?? "Unknown";
```

---

## Mistake 2 — Forgetting the Array Syntax

Wrong:

```js
users?[0]
```

Correct:

```js
users?.[0]
```

---

## Mistake 3 — Protecting Only One Level

Potentially unsafe:

```js
user.address?.location.city;
```

Safer:

```js
user?.address?.location?.city;
```

---

## Mistake 4 — Using Optional Chaining for Validation

This:

```js
const age =
    user?.age;
```

only safely accesses `age`.

It does not validate whether the age is:

- a number
- positive
- above 18
- within a required range

Validation is separate.

---

# 13. Hands-on Practice

> **Important:** First write the code yourself. Do not copy the examples above. Run your solution only after attempting it.

---

## Exercise 1 — User Data

Given:

```js
const user = {
    profile: {
        name: "Om"
    }
};
```

Safely extract:

```text
Om
```

using Optional Chaining.

---

## Exercise 2 — Missing Data

Given:

```js
const user = {};
```

Safely extract:

```text
No Email
```

using:

```text
?.
??
```

---

## Exercise 3 — Nested API

Given:

```js
const response = {
    data: {
        user: {
            profile: {
                name: "Om",
                city: "Pune"
            }
        }
    }
};
```

Extract:

```text
name
city
email
```

Expected:

```text
Om
Pune
No Email
```

---

## Exercise 4 — Array

Given:

```js
const users = [
    {
        name: "Om"
    }
];
```

Safely extract the name of the third user.

Expected:

```text
User Not Found
```

---

## Exercise 5 — Optional Callback

Create:

```js
function saveUser(user, callback) {

}
```

Requirements:

```text
Print user's name.

Call callback only if it exists.
```

Use:

```js
callback?.();
```

---

## Exercise 6 — Configuration

Given:

```js
const config = {
    server: {
        port: 5000
    }
};
```

Write code that returns:

```text
5000
```

and returns:

```text
3000
```

if the port doesn't exist.

---

## Exercise 7 — Product

Given:

```js
const product = {
    details: {
        name: "Laptop",
        price: 70000
    }
};
```

Safely extract:

```text
name
price
category
```

Expected:

```text
Laptop
70000
Unknown Category
```

---

## Exercise 8 — Debugging

Find and fix the problem:

```js
const user = undefined;

const city =
    user.address?.city;

console.log(city);
```

---

## Exercise 9 — Output Prediction

Predict the output before running:

```js
const user = {
    name: "Om",
    profile: null
};

console.log(user?.name);
console.log(user?.profile?.city);
console.log(user?.email ?? "No Email");
```

---

## Exercise 10 — Real-World Challenge

Build:

```js
function getUserInfo(response) {

}
```

Given:

```js
const response = {
    data: {
        user: {
            profile: {
                name: "Om",
                address: {
                    city: "Pune"
                }
            }
        }
    }
};
```

Return:

```js
{
    name: "Om",
    city: "Pune",
    email: "No Email"
}
```

Requirements:

- Use Optional Chaining
- Use Nullish Coalescing
- Do not use `if`
- Use clean object syntax
- Write the complete function yourself

---

# 14. Practical Rule

When you see uncertain nested data, think:

```text
Can this value be null/undefined?
        ↓
YES
        ↓
Use ?.
        ↓
Do I need a fallback?
        ↓
YES
        ↓
Use ??
```

Example:

```js
const city =
    user?.address?.city
    ?? "Unknown";
```

---

# 15. Summary

You can now use Optional Chaining with:

```text
Objects
    ↓
user?.name

Nested Objects
    ↓
user?.profile?.address?.city

Arrays
    ↓
users?.[0]?.name

Functions
    ↓
callback?.()

API Responses
    ↓
response?.data?.user?.profile

Configuration
    ↓
config?.server?.port

Fallback Values
    ↓
user?.email ?? "No Email"
```

The practical pattern to remember:

```text
?. → Safe Access

?? → Fallback

?. + ?? → Safe Access + Fallback
```

---
# Optional Chaining (`?.`)

# Part 4 – Real-World Usage, React, Node.js, Express.js & Interview Mastery

> **"Optional Chaining becomes especially useful when working with real application data. React state, API responses, Express requests, configuration objects, and database documents may not always contain every property. Optional Chaining lets us safely access that data, while Nullish Coalescing (`??`) lets us provide sensible defaults."**

---

# Table of Contents

1. React Props
2. React State
3. React API Data
4. React Conditional Data
5. Node.js Configuration
6. Express.js Request Data
7. Express.js User Data
8. API Development
9. MongoDB Documents
10. Real Project Patterns
11. Interview Questions
12. Common Interview Traps
13. Hands-on Interview Practice
14. Final Cheat Sheet
15. Summary

---

# 1. React Props

React components often receive data through props.

The prop may or may not contain all expected information.

```jsx
function UserCard({ user }) {

    return (
        <h2>
            {user?.name}
        </h2>
    );

}
```

If `user` exists:

```js
{
    name: "Om"
}
```

Output:

```text
Om
```

If `user` is `undefined`:

```text
undefined
```

No property-access error occurs.

---

## Nested Props

```jsx
function UserCard({ user }) {

    return (
        <p>
            {user?.address?.city}
        </p>
    );

}
```

This safely handles:

```js
user
```

or:

```js
user.address
```

being unavailable.

---

# 2. React State

Data loaded from an API may initially be unavailable.

Example:

```jsx
const [user, setUser] = useState(null);
```

Before the API response arrives:

```js
user === null
```

This would be unsafe:

```jsx
<h1>{user.name}</h1>
```

Use:

```jsx
<h1>{user?.name}</h1>
```

Now React can safely render while the data is unavailable.

---

## Nested State

```jsx
<p>
    {user?.profile?.address?.city}
</p>
```

If the data later becomes:

```js
{
    profile: {
        address: {
            city: "Pune"
        }
    }
}
```

React displays:

```text
Pune
```

---

# 3. React API Data

Suppose an API returns:

```js
const response = {
    data: {
        user: {
            name: "Om",
            email: "om@gmail.com"
        }
    }
};
```

Safely access:

```jsx
<h2>
    {response?.data?.user?.name}
</h2>
```

Email:

```jsx
<p>
    {response?.data?.user?.email}
</p>
```

With fallback:

```jsx
<p>
    {response?.data?.user?.email ?? "No Email"}
</p>
```

---

# 4. React Conditional Data

Optional Chaining can be combined with `??` when a UI fallback is needed.

```jsx
<h2>
    {user?.name ?? "Guest"}
</h2>
```

City:

```jsx
<p>
    {user?.address?.city ?? "City Not Available"}
</p>
```

Profile image:

```jsx
<img
    src={user?.profile?.image ?? "/default.png"}
    alt="Profile"
/>
```

The important pattern is:

```text
?. 
↓
Safely access data

??

↓
Provide fallback
```

---

# 5. Node.js Configuration

Node.js applications commonly use configuration objects.

```js
const config = {
    server: {
        port: 5000
    }
};
```

Safely access:

```js
const port =
    config?.server?.port;
```

Output:

```text
5000
```

---

## Default Configuration

```js
const config = {};

const port =
    config?.server?.port ?? 3000;

console.log(port);
```

Output:

```text
3000
```

---

# 6. Express.js Request Data

Request bodies can contain optional nested data.

```js
app.post("/users", (req, res) => {

    const city =
        req.body?.address?.city;

    res.json({
        city
    });

});
```

If the client sends:

```json
{
    "address": {
        "city": "Pune"
    }
}
```

Result:

```js
{
    city: "Pune"
}
```

If `address` is missing:

```js
{
    city: undefined
}
```

No property-access error occurs.

---

# 7. Express.js User Data

Authenticated applications may attach user information to the request.

```js
const role =
    req.user?.role;
```

With fallback:

```js
const role =
    req.user?.role ?? "User";
```

Example:

```js
app.get("/profile", (req, res) => {

    const userId =
        req.user?.id;

    const role =
        req.user?.role ?? "User";

    res.json({
        userId,
        role
    });

});
```

---

# 8. API Development

Consider:

```js
const response = {
    data: {
        user: {
            profile: {
                name: "Om",
                address: {
                    city: "Pune"
                }
            }
        }
    }
};
```

Extract safely:

```js
const name =
    response?.data?.user?.profile?.name
    ?? "Unknown";

const city =
    response?.data?.user?.profile?.address?.city
    ?? "Unknown";

const email =
    response?.data?.user?.profile?.email
    ?? "No Email";
```

Output:

```text
Om
Pune
No Email
```

---

# 9. MongoDB Documents

Database documents can contain optional fields.

```js
const user = {
    name: "Om",
    profile: {
        city: "Pune"
    }
};
```

Safely access:

```js
const city =
    user?.profile?.city;
```

With fallback:

```js
const city =
    user?.profile?.city
    ?? "Unknown";
```

---

# 10. Real Project Patterns

## Pattern 1 — User Profile

```js
const name =
    user?.profile?.name ?? "Guest";

const city =
    user?.profile?.address?.city
    ?? "Unknown";

const email =
    user?.profile?.email
    ?? "No Email";
```

---

## Pattern 2 — Product

```js
const productName =
    product?.details?.name
    ?? "Unknown Product";

const price =
    product?.details?.price
    ?? 0;

const category =
    product?.details?.category
    ?? "Uncategorized";
```

---

## Pattern 3 — Order

```js
const orderId =
    order?.details?.id
    ?? "No Order";

const total =
    order?.payment?.total
    ?? 0;

const city =
    order?.shipping?.address?.city
    ?? "Unknown";
```

---

## Pattern 4 — API Response

```js
const data =
    response?.data ?? [];

const message =
    response?.message ?? "No Message";
```

---

# 11. Interview Questions

## Question 1

### What is Optional Chaining?

Optional Chaining (`?.`) safely accesses properties, array elements, or functions when a value may be `null` or `undefined`.

Example:

```js
user?.profile?.name;
```

---

## Question 2

### What happens when Optional Chaining encounters `null` or `undefined`?

The chain stops and returns:

```text
undefined
```

---

## Question 3

### What is the difference between these?

```js
user.address?.city
```

and:

```js
user?.address?.city
```

Answer:

```text
user.address?.city
```

protects the access to `city` when `address` is `null` or `undefined`, but does not protect `user` itself.

```js
user?.address?.city
```

also protects `user`.

---

## Question 4

### How do you safely access an array element?

```js
users?.[0]
```

---

## Question 5

### How do you safely call an optional function?

```js
callback?.();
```

---

## Question 6

### How do you provide a default value?

Use Optional Chaining with Nullish Coalescing:

```js
const city =
    user?.address?.city ?? "Unknown";
```

---

## Question 7

### Can Optional Chaining be used for assignment?

No.

Invalid:

```js
user?.name = "Om";
```

Optional Chaining is for safe access, not assignment.

---

## Question 8

### What is the difference between `?.` and `??`?

```text
?. 
→ Safely accesses a value.

??
→ Provides a fallback when the value is null/undefined.
```

Example:

```js
user?.name ?? "Guest";
```

---

# 12. Common Interview Traps

## Trap 1

```js
const user = undefined;

console.log(user.address?.city);
```

This throws an error.

Correct:

```js
console.log(
    user?.address?.city
);
```

---

## Trap 2

```js
const user = {
    age: 0
};

console.log(
    user?.age ?? 18
);
```

Output:

```text
0
```

Why?

`??` only uses the fallback for:

```text
null
undefined
```

It does not replace valid values such as:

```text
0
false
""
```

---

## Trap 3

```js
const user = {};

console.log(
    user?.name
);
```

Output:

```text
undefined
```

Not:

```text
null
```

---

## Trap 4

```js
const users = [];

console.log(
    users?.[0]?.name
);
```

Output:

```text
undefined
```

An empty array itself exists, but index `0` does not.

---

# 13. Hands-on Interview Practice

> **Important:** Solve these yourself first. Do not copy the examples from above. Your goal is to build the syntax from memory.**

---

## Exercise 1 — React

Write a React expression that safely displays:

```text
user.profile.name
```

If the name is missing, display:

```text
Guest
```

---

## Exercise 2 — API

Given:

```js
const response = {
    data: {
        user: {
            name: "Om"
        }
    }
};
```

Safely extract:

```text
name
email
city
```

Expected:

```text
Om
No Email
Unknown City
```

---

## Exercise 3 — Node.js

Given:

```js
const config = {};
```

Safely get:

```text
PORT
```

with a default of:

```text
3000
```

---

## Exercise 4 — Express

Write code that safely gets:

```text
req.body.address.city
```

and returns:

```text
Unknown City
```

when it doesn't exist.

---

## Exercise 5 — Optional Callback

Write:

```js
function saveUser(user, callback) {

}
```

Requirements:

1. Print the user's name safely.
2. Call `callback` only when it exists.

---

## Exercise 6 — Output Prediction

Predict the output:

```js
const user = {
    name: "Om",
    age: 0,
    profile: null
};

console.log(user?.name);
console.log(user?.age ?? 18);
console.log(user?.profile?.city ?? "Unknown");
console.log(user?.email ?? "No Email");
```

---

## Exercise 7 — Debugging

Find the problem:

```js
const response = undefined;

const name =
    response.data?.user?.name;

console.log(name);
```

Rewrite it safely.

---

## Exercise 8 — Real API Challenge

Create:

```js
function formatUser(response) {

}
```

Input:

```js
const response = {
    data: {
        user: {
            profile: {
                name: "Om",
                address: {
                    city: "Pune"
                }
            }
        }
    }
};
```

Return:

```js
{
    name: "Om",
    city: "Pune",
    email: "No Email",
    role: "User"
}
```

Requirements:

- Use `?.`
- Use `??`
- Use Enhanced Object Literals where appropriate
- Do not use `if`
- Write the solution yourself

---

# 14. Final Cheat Sheet

```text
OPTIONAL CHAINING

?.property
    ↓
Safe property access

?.[index]
    ↓
Safe array access

?.()
    ↓
Safe function call

?. + ?.
    ↓
Safe nested access

?. + ??
    ↓
Safe access + fallback
```

### Examples

```js
user?.name
```

```js
user?.address?.city
```

```js
users?.[0]?.name
```

```js
callback?.()
```

```js
user?.email ?? "No Email"
```

```js
config?.server?.port ?? 3000
```

---

# Final Mental Model

```text
                Optional Chaining
                       │
                       ▼
              "Can this value
               be missing?"
                       │
                ┌──────┴──────┐
                │             │
               NO            YES
                │             │
                ▼             ▼
             Continue       Stop
                              │
                              ▼
                         undefined
                              │
                              ▼
                         Need fallback?
                              │
                              ▼
                             ??
                              │
                              ▼
                        Default Value
```

---

# 15. Summary

You have now learned Optional Chaining from fundamentals to practical usage.

You should be able to:

- Explain what `?.` does.
- Understand short-circuiting.
- Understand where the chain stops.
- Distinguish `null` and `undefined`.
- Safely access objects.
- Safely access nested objects.
- Safely access arrays.
- Safely call optional functions.
- Combine `?.` with `??`.
- Use it with API responses.
- Use it in React.
- Use it in Node.js.
- Use it in Express.js.
- Safely handle database documents.
- Identify common interview traps.
- Write the syntax yourself without copying.

---

# Mastery Check

Before moving to the next JavaScript topic, you should be able to write this from memory:

```js
const city =
    response?.data?.user?.profile?.address?.city
    ?? "Unknown";
```

And explain:

```text
?. → safely access

?? → fallback for null/undefined

?. + ?? → safely access optional data and provide a fallback
```

If you can **write, explain, debug, and modify this pattern yourself**, Optional Chaining is sufficiently learned for moving forward.

---

# 🎉 Optional Chaining Complete

## Next Topic

➡️ **Nullish Coalescing (`??`)**

You will learn:

- What `??` is
- Why it was introduced
- `??` vs `||`
- `null` and `undefined`
- Default values
- Short-circuiting
- `??` with `?.`
- Real-world React usage
- Node.js usage
- Interview traps
- Hands-on coding practice