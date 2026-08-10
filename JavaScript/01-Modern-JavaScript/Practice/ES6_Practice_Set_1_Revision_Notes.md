# 🚀 ES6+ Practice Set 1 – Complete Revision Notes

> **Goal:** Build a strong foundation in JavaScript fundamentals by understanding **What**, **Why**, **How**, and **When** instead of memorizing syntax.

---

# 📚 Topics Covered

* Functions
* Arrow Functions
* Comparison Operators
* if...else
* Logical Operators
* Even & Odd (`%`)
* String Traversal
* String Length
* Manual String Searching
* Object Destructuring
* Array Destructuring
* Passing Objects to Functions
* Updating Objects
* Default Parameters

---

# 1️⃣ Functions

## What?

A function is a reusable block of code that performs a specific task.

```javascript
function greet(name) {
    return `Hello ${name}`;
}
```

Arrow Function

```javascript
const greet = (name) => `Hello ${name}`;
```

---

## Why?

Instead of writing the same code multiple times, write it once and reuse it.

Example:

* Login
* Calculate tax
* Validate email
* Find maximum number

---

## How?

```javascript
function add(a, b) {
    return a + b;
}

let result = add(2, 3);
```

Execution

```
add(2,3)

↓

returns 5

↓

result = 5
```

---

## Remember

A function should usually **return** a value.

Use

```javascript
return
```

instead of

```javascript
console.log()
```

when another part of your program needs the result.

---

# 2️⃣ Comparison Operators

## What?

Comparison operators compare two values and always return a boolean.

| Operator | Meaning               |
| -------- | --------------------- |
| `>`      | Greater than          |
| `<`      | Less than             |
| `>=`     | Greater than or equal |
| `<=`     | Less than or equal    |
| `==`     | Loose equality        |
| `===`    | Strict equality       |
| `!=`     | Not equal             |
| `!==`    | Strict not equal      |

---

## Why?

Used whenever we need to make decisions.

Examples:

* Age verification
* Login authentication
* Product price comparison

---

## Example

```javascript
age >= 18
```

Returns

```text
true

or

false
```

---

# 3️⃣ if...else

## What?

Executes different blocks of code depending on a condition.

```javascript
if (age >= 18) {
    return "Eligible";
} else {
    return "Not Eligible";
}
```

---

## Flow

```
Condition

↓

true ?

↓

Yes → First Block

↓

No → Else Block
```

---

## When?

* Login
* Voting eligibility
* Discounts
* Password checking

---

# 4️⃣ Logical Operators

## AND (`&&`)

Both conditions must be true.

```javascript
age >= 18 && age <= 60
```

---

## OR (`||`)

At least one condition must be true.

```javascript
isAdmin || isManager
```

---

## NOT (`!`)

Reverses a boolean.

```javascript
!isLoggedIn
```

---

## Why?

To combine multiple conditions.

---

# 5️⃣ Even & Odd (`%`)

## What?

The modulus operator returns the remainder after division.

```javascript
10 % 2
```

Output

```
0
```

---

## Even

```javascript
num % 2 === 0
```

---

## Odd

```javascript
num % 2 !== 0
```

---

## Why?

Used in

* Number validation
* DSA
* Mathematics
* Interview questions

---

# 6️⃣ Loop Through a String

## What?

Strings can be accessed one character at a time.

```javascript
for (let i = 0; i < str.length; i++) {
    console.log(str[i]);
}
```

---

## Why?

To search characters manually without built-in methods.

Examples

* Count vowels
* Count digits
* Search words
* Reverse strings

---

# 7️⃣ String Length

## What?

`.length` returns the number of characters.

```javascript
str.length
```

---

## Example

```javascript
if (str.length > 5) {
    return true;
}
```

---

## Why?

Useful for

* Password validation
* Username validation
* Character counting

---

# 8️⃣ Manual Search ("hello")

Instead of using

```javascript
str.includes("hello")
```

practice searching manually.

```javascript
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

---

## Why?

Helps understand

* Loops
* String indexing
* Pattern matching

before using built-in methods.

---

# 9️⃣ Object Destructuring

## What?

Extract values from an object into variables.

Before

```javascript
const name = person.name;
```

After

```javascript
const { name } = person;
```

---

## Why?

Avoid repetitive code.

Instead of

```javascript
person.name
person.age
person.city
```

write

```javascript
name
age
city
```

---

# 🔟 Array Destructuring

## What?

Extract values from an array.

```javascript
const numbers = [1,2,3];

const [a,b,c] = numbers;
```

---

## Why?

Cleaner code.

Very useful for

* Swapping variables
* Returning multiple values

---

# 1️⃣1️⃣ Passing Objects

Instead of

```javascript
function getBook(book){
    return book.pages;
}
```

Use destructuring.

```javascript
function getBook({ pages }) {
    return pages;
}
```

---

## Why?

Cleaner.

Only the required properties are extracted.

---

# 1️⃣2️⃣ Updating Objects

```javascript
person.age = 30;
```

---

## Why does this work with `const`?

```javascript
const person = {
    age:20
};

person.age = 30;
```

Allowed.

Because the object reference doesn't change.

This is **not** allowed.

```javascript
person = {};
```

---

# 1️⃣3️⃣ Default Parameters

Before ES6

```javascript
function multiply(a,b,c){

    if(c===undefined){
        c=4;
    }

    return a*b*c;
}
```

ES6

```javascript
const multiply=(a,b,c=4)=>a*b*c;
```

---

## Why?

Prevents

```text
undefined

↓

NaN
```

Provides safe default values.

---

# ❌ Common Mistakes

## 1. `=>` vs `>=`

Wrong

```javascript
age => 18
```

Correct

```javascript
age >= 18
```

---

## 2. `console.log()` vs `return`

Wrong

```javascript
console.log(value);
```

Correct

```javascript
return value;
```

Remember:

* `return` → Gives the value back to the program.
* `console.log()` → Displays the value for the developer.

---

## 3. Returning the Entire Object

Wrong

```javascript
return book;
```

Correct

```javascript
return book.pages;
```

or

```javascript
return pages > 100;
```

Return only what the question asks for.

---

## 4. Forgetting `toLowerCase()`

Searching should usually ignore case.

```javascript
str = str.toLowerCase();
```

---

## 5. Writing Extra Conditions

Bad

```javascript
if(num){
   return num*10;
}
```

Good

```javascript
return num*10;
```

Keep your code simple.

---

# 🎯 Interview Questions

### Functions

* What is a function?
* Why do we use `return`?
* Difference between Function Declaration and Arrow Function?

### Comparison Operators

* Difference between `==` and `===`?
* Difference between `!=` and `!==`?

### Conditions

* When should you use `if...else`?
* When can a ternary operator replace `if...else`?

### Objects

* What is object destructuring?
* Why is it useful?

### Arrays

* Difference between object and array destructuring?

### Default Parameters

* Why were default parameters introduced?

---

# 🧠 Quick Memory Map

```
ES6

├── Functions
│   ├── Declaration
│   ├── Arrow Function
│   └── return
│
├── Conditions
│   ├── if...else
│   ├── Comparison Operators
│   └── Logical Operators
│
├── Numbers
│   └── % (Even / Odd)
│
├── Strings
│   ├── length
│   ├── toLowerCase()
│   └── Traversal
│
├── Objects
│   ├── Create
│   ├── Update
│   ├── Pass to Function
│   └── Destructuring
│
├── Arrays
│   └── Destructuring
│
└── Functions
    └── Default Parameters
```

---

# ✅ Revision Checklist

Before moving to the next ES6 topic, make sure you can answer **YES** to all of these:

* [ ] I know the difference between `return` and `console.log()`.
* [ ] I know why `===` is preferred over `==`.
* [ ] I understand how `if...else` works.
* [ ] I can combine conditions using `&&`, `||`, and `!`.
* [ ] I know how `%` checks for even and odd numbers.
* [ ] I can loop through a string using a `for` loop.
* [ ] I know how `.length` works.
* [ ] I can manually search for a word inside a string.
* [ ] I can destructure objects and arrays.
* [ ] I know why object destructuring reduces repetitive code.
* [ ] I understand how object properties are updated.
* [ ] I know why default parameters prevent `undefined` values.

---

# 🚀 Next Topics

* Template Literals
* Ternary Operator
* Rest Operator
* Spread Operator
* Optional Chaining (`?.`)
* Nullish Coalescing (`??`)
* `for...of`
* `map()`
* `filter()`
* `reduce()`
* Classes
* Modules (ESM)

---

# 🎯 Final Advice

Whenever you learn a new JavaScript feature, don't just ask **"How do I write it?"**

Ask yourself:

1. **What is it?**
2. **Why was it introduced?**
3. **How does it work internally?**
4. **When should I use it?**
5. **What mistakes do beginners usually make?**

If you can answer these five questions for every topic, you'll build understanding instead of memorizing syntax, and you'll be much more confident in interviews and real-world development.
