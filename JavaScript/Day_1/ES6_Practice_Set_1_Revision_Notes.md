# ES6+ Practice Set 1 - Revision Notes 🚀

> A quick revision guide for the 15 ES6 practice questions.

------------------------------------------------------------------------

# Table of Contents

1.  Functions
2.  Comparison Operators
3.  `if...else`
4.  Logical Operators
5.  Even/Odd (`%`)
6.  String Traversal
7.  String Length
8.  Searching "hello"
9.  Object Destructuring
10. Array Destructuring
11. Passing Objects
12. Updating Objects
13. Default Parameters
14. Common Mistakes
15. Interview Revision
16. Summary

------------------------------------------------------------------------

# 1. Functions

``` js
function greet(name) {
  return `Hello ${name}`;
}

const greetArrow = (name) => `Hello ${name}`;
```

**Remember** - Reusable block of code. - Prefer `return` over
`console.log()` inside functions.

------------------------------------------------------------------------

# 2. Comparison Operators

  Operator   Meaning
  ---------- -----------------------
  `>`        Greater than
  `<`        Less than
  `>=`       Greater than or equal
  `<=`       Less than or equal
  `==`       Loose equality
  `===`      Strict equality
  `!=`       Not equal
  `!==`      Strict not equal

------------------------------------------------------------------------

# 3. if...else

``` js
if (age >= 18) {
  return "Eligible";
} else {
  return "Not Eligible";
}
```

------------------------------------------------------------------------

# 4. Logical Operators

-   `&&` → Both conditions must be true.
-   `||` → At least one condition must be true.
-   `!` → Reverses a boolean.

Example:

``` js
num > 1 && num <= 10
```

------------------------------------------------------------------------

# 5. Even / Odd

``` js
num % 2 === 0   // Even
num % 2 !== 0   // Odd
```

------------------------------------------------------------------------

# 6. Loop Through a String

``` js
for (let i = 0; i < str.length; i++) {
  if (str[i] === "a") {
    return true;
  }
}
```

------------------------------------------------------------------------

# 7. String Length

``` js
if (str.length > 5) {
  return "More than 5 characters";
}
```

------------------------------------------------------------------------

# 8. Search for "hello"

``` js
str = str.toLowerCase();

for (let i = 0; i <= str.length - 5; i++) {
  if (
    str[i] === "h" &&
    str[i + 1] === "e" &&
    str[i + 2] === "l" &&
    str[i + 3] === "l" &&
    str[i + 4] === "o"
  ) {
    return true;
  }
}
```

------------------------------------------------------------------------

# 9. Object Destructuring

``` js
const product = {
  title: "iPhone",
  price: 5999,
  description: "Apple Phone"
};

const { title, price, description } = product;
```

------------------------------------------------------------------------

# 10. Array Destructuring

``` js
const numbers = [1, 2, 3];

const [a, b, c] = numbers;
```

------------------------------------------------------------------------

# 11. Passing Objects

``` js
function getBookDetails({ pages }) {
  return pages > 100;
}
```

------------------------------------------------------------------------

# 12. Updating Objects

``` js
function changeOccupation(person, newOccupation) {
  person.occupation = newOccupation;
}
```

Objects are passed by reference.

------------------------------------------------------------------------

# 13. Default Parameters

Old:

``` js
function multiply(a, b, c) {
  if (c === undefined) c = 4;
  return a * b * c;
}
```

ES6:

``` js
const multiply = (a, b, c = 4) => a * b * c;
```

------------------------------------------------------------------------

# 14. Common Mistakes

## ❌ `=>` instead of `>=`

Wrong:

``` js
age => 18
```

Correct:

``` js
age >= 18
```

------------------------------------------------------------------------

## ❌ Printing instead of Returning

Wrong:

``` js
console.log(value);
```

Correct:

``` js
return value;
```

------------------------------------------------------------------------

## ❌ Returning the whole object

Wrong:

``` js
return book;
```

Correct:

``` js
return pages > 100;
```

------------------------------------------------------------------------

## ❌ Checking only `'a'`

Better:

``` js
str = str.toLowerCase();
```

------------------------------------------------------------------------

## ❌ Extra condition in multiplyByTen()

Simply write:

``` js
return num * 10;
```

------------------------------------------------------------------------

# 15. Interview Revision

-   Difference between `==` and `===`
-   `return` vs `console.log()`
-   Object vs Array Destructuring
-   Arrow Functions
-   Default Parameters
-   `%` Operator
-   `toLowerCase()`

------------------------------------------------------------------------

# Quick Memory Map

    ES6

    ├── Functions
    ├── Arrow Functions
    ├── if...else
    ├── Comparison Operators
    ├── Logical Operators
    ├── %
    ├── Strings
    │   ├── length
    │   ├── toLowerCase()
    │   └── Looping
    ├── Objects
    │   ├── Destructuring
    │   └── Update
    ├── Arrays
    │   └── Destructuring
    └── Default Parameters

------------------------------------------------------------------------

# Summary

✅ Functions

✅ Arrow Functions

✅ Conditions

✅ Loops

✅ Strings

✅ Objects

✅ Arrays

✅ Destructuring

✅ Default Parameters

------------------------------------------------------------------------

## Next Topics

-   Template Literals
-   Rest Operator
-   Spread Operator
-   Optional Chaining
-   Nullish Coalescing
-   Ternary Operator
-   map()
-   filter()
-   reduce()
-   for...of
-   Classes
-   Modules
