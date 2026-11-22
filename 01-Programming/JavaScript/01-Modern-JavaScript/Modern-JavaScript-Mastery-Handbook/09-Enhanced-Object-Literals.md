# Enhanced Object Literals

## Part 1 — Foundations

> Enhanced Object Literals are ES6 features that make JavaScript objects shorter, cleaner, and easier to write. The most important features are **property shorthand, method shorthand, and computed property names**.

---

# 1. What Are Enhanced Object Literals?

An object literal is a way to create an object directly.

```js
const person = {
    name: "Om",
    age: 22
};

console.log(person);
```

Output:

```js
{
    name: "Om",
    age: 22
}
```

ES6 introduced several shorter ways to write object literals.

The main features are:

```text
Property Shorthand
        ↓
Method Shorthand
        ↓
Computed Property Names
        ↓
Dynamic Object Creation
```

---

# 2. Property Shorthand

Suppose we have variables:

```js
const name = "Om";
const age = 22;
```

Before ES6, we could write:

```js
const person = {
    name: name,
    age: age
};
```

But the variable name and property name are the same.

ES6 allows us to shorten this:

```js
const person = {
    name,
    age
};
```

This is called **property shorthand**.

JavaScript understands:

```js
{
    name
}
```

as:

```js
{
    name: name
}
```

### Important Rule

Property shorthand works when:

```text
variable name === property name
```

Example:

```js
const city = "Pune";

const address = {
    city
};
```

Internally, this is equivalent to:

```js
const address = {
    city: city
};
```

Output:

```js
{
    city: "Pune"
}
```

---

# 3. When Shorthand Cannot Be Used

Suppose the variable is called `username`, but you want the property to be called `name`.

```js
const username = "Om";
```

You cannot write:

```js
const user = {
    name
};
```

because there is no variable called `name`.

Instead, write:

```js
const user = {
    name: username
};
```

Output:

```js
{
    name: "Om"
}
```

So remember:

```text
const username = "Om";

{
    username       ✅ shorthand
}

{
    name: username ✅ normal property assignment
}

{
    name           ❌ no variable called name
}
```

---

# 4. Method Shorthand

Objects can also contain functions.

Before ES6:

```js
const person = {
    greet: function () {
        console.log("Hello");
    }
};

person.greet();
```

ES6 provides method shorthand:

```js
const person = {
    greet() {
        console.log("Hello");
    }
};

person.greet();
```

Output:

```text
Hello
```

The shorthand is:

```js
greet() {
    // code
}
```

instead of:

```js
greet: function () {
    // code
}
```

---

# 5. Methods With Parameters

Method shorthand works with parameters too.

```js
const calculator = {
    add(a, b) {
        return a + b;
    }
};

console.log(calculator.add(10, 20));
```

Output:

```text
30
```

Another example:

```js
const user = {
    greet(name) {
        console.log(`Hello ${name}`);
    }
};

user.greet("Om");
```

Output:

```text
Hello Om
```

---

# 6. Computed Property Names

Now we come to one of the most important features.

Sometimes we don't know the property name directly.

Instead, the property name comes from a variable.

Example:

```js
const key = "language";

const course = {
    [key]: "JavaScript"
};

console.log(course);
```

Output:

```js
{
    language: "JavaScript"
}
```

Why?

Because JavaScript evaluates:

```js
[key]
```

first.

The variable contains:

```text
key
 ↓
"language"
```

Therefore:

```js
[key]: "JavaScript"
```

becomes:

```js
language: "JavaScript"
```

---

# 7. Why Are the Square Brackets Important?

Compare these two examples.

### Without brackets

```js
const key = "language";

const course = {
    key: "JavaScript"
};
```

Output:

```js
{
    key: "JavaScript"
}
```

JavaScript uses the literal property name:

```text
key
```

---

### With brackets

```js
const key = "language";

const course = {
    [key]: "JavaScript"
};
```

Output:

```js
{
    language: "JavaScript"
}
```

JavaScript evaluates the variable:

```text
key
 ↓
"language"
 ↓
property name
```

### Easy rule

```text
key
 ↓
literal property name

[key]
 ↓
evaluate the expression
 ↓
use its result as the property name
```

---

# 8. Multiple Computed Properties

You can use multiple variables.

```js
const key1 = "name";
const key2 = "city";

const user = {
    [key1]: "Om",
    [key2]: "Pune"
};

console.log(user);
```

Output:

```js
{
    name: "Om",
    city: "Pune"
}
```

Evaluation:

```text
[key1] → "name"
[key2] → "city"
```

Therefore:

```js
{
    name: "Om",
    city: "Pune"
}
```

---

# 9. The Important Duplicate-Key Example

This is a very important concept.

Consider:

```js
const key = "Lang";
const key2 = "Lang";

const course = {
    [key]: "JS",
    [key2]: "JS2"
};

console.log(course);
```

First JavaScript evaluates the keys:

```text
[key]  → "Lang"
[key2] → "Lang"
```

So JavaScript effectively sees:

```js
const course = {
    Lang: "JS",
    Lang: "JS2"
};
```

Both properties have the same name.

Therefore, the second property replaces the first one.

Final object:

```js
{
    Lang: "JS2"
}
```

This is called:

**last property wins**.

### Compare this

```js
const key = "Lang";
const key2 = "Lang2";

const course = {
    [key]: "JS",
    [key2]: "JS2"
};
```

Now:

```text
[key]  → "Lang"
[key2] → "Lang2"
```

So the result is:

```js
{
    Lang: "JS",
    Lang2: "JS2"
}
```

### Remember

```text
Same property name
        ↓
Second value replaces first

Different property names
        ↓
Both values remain
```

---

# 10. Computed Properties Can Use Expressions

The brackets can contain an expression, not only a variable.

```js
const id = 101;

const student = {
    ["student_" + id]: "Om"
};

console.log(student);
```

Output:

```js
{
    student_101: "Om"
}
```

JavaScript evaluates:

```js
"student_" + id
```

to:

```text
"student_101"
```

and uses that as the property name.

---

# 11. Property Shorthand vs Computed Property

These two concepts are different.

### Property shorthand

```js
const name = "Om";

const user = {
    name
};
```

Means:

```js
const user = {
    name: name
};
```

The property name is already known.

---

### Computed property

```js
const key = "name";

const user = {
    [key]: "Om"
};
```

Here the property name comes from a variable.

```text
key → "name"
```

Therefore:

```js
{
    name: "Om"
}
```

### Easy comparison

```text
{name}
   ↓
property shorthand

{[key]: value}
   ↓
computed property
```

---

# 12. Property Shorthand vs Destructuring

These are also different concepts.

### Property shorthand creates an object

```js
const name = "Om";

const user = {
    name
};
```

It creates:

```js
{
    name: "Om"
}
```

---

### Destructuring extracts a value

```js
const user = {
    name: "Om"
};

const { name } = user;

console.log(name);
```

Output:

```text
Om
```

Remember:

```text
Property shorthand
        ↓
CREATE object

Destructuring
        ↓
EXTRACT values
```

---

# 13. Destructuring With Renaming

You can also give the extracted value a different variable name.

```js
const user = {
    name: "Om",
    city: "Pune"
};

const {
    name: fullName,
    city: location
} = user;

console.log(fullName);
console.log(location);
```

Output:

```text
Om
Pune
```

This:

```js
name: fullName
```

means:

```text
object property → variable

name → fullName
```

It does **not** rename the property inside the object.

The object is still:

```js
{
    name: "Om",
    city: "Pune"
}
```

---

# 14. Dynamic Object Creation

Enhanced object literals become especially useful inside functions.

```js
function createUser(name, age) {
    return {
        name,
        age
    };
}

const user = createUser("Om", 22);

console.log(user);
```

Output:

```js
{
    name: "Om",
    age: 22
}
```

Here:

```js
return {
    name,
    age
};
```

is property shorthand.

It is equivalent to:

```js
return {
    name: name,
    age: age
};
```

---

# 15. Dynamic Property + Function

We can combine shorthand and computed properties.

```js
function createCourse(name, field, value) {
    return {
        name,
        [field]: value
    };
}

const course = createCourse(
    "JavaScript",
    "language",
    "JS"
);

console.log(course);
```

Output:

```js
{
    name: "JavaScript",
    language: "JS"
}
```

Here we use two different features:

```text
name
 ↓
Property shorthand

[field]
 ↓
Computed property
```

---

# 16. Quick Revision

### Property shorthand

```js
const name = "Om";

const user = {
    name
};
```

Equivalent to:

```js
const user = {
    name: name
};
```

---

### Method shorthand

```js
const user = {
    greet() {
        console.log("Hello");
    }
};
```

---

### Computed property

```js
const key = "name";

const user = {
    [key]: "Om"
};
```

Result:

```js
{
    name: "Om"
}
```

---

### Duplicate computed property

```js
const key = "name";
const key2 = "name";

const user = {
    [key]: "Om",
    [key2]: "Raj"
};
```

Result:

```js
{
    name: "Raj"
}
```

**Last property wins.**

---

### Destructuring

```js
const { name } = user;
```

Extracts the value.

---

### Destructuring with renaming

```js
const { name: fullName } = user;
```

Means:

```text
user.name → fullName
```

---

# 17. Mental Model

When you see:

```js
const obj = {
    [key]: value
};
```

think:

```text
        key
         ↓
   evaluate the value
         ↓
   "language"
         ↓
 use it as property name
         ↓
{
    language: value
}
```

When you see:

```js
const obj = {
    name
};
```

think:

```text
name → name: name
```

When you see:

```js
const { name: fullName } = obj;
```

think:

```text
obj.name → fullName
```

These three patterns are **different** and should never be mixed up.

---

# 18. Practice

## Exercise 1

What is the output?

```js
const name = "Om";
const age = 22;

const user = {
    name,
    age
};

console.log(user);
```

---

## Exercise 2

Convert this to property shorthand:

```js
const city = "Pune";

const address = {
    city: city
};
```

---

## Exercise 3

Write an object using method shorthand.

The method should print:

```text
Hello
```

---

## Exercise 4

Predict the output:

```js
const key = "language";

const course = {
    [key]: "JavaScript"
};

console.log(course);
```

---

## Exercise 5

Predict the output:

```js
const key1 = "name";
const key2 = "name";

const user = {
    [key1]: "Om",
    [key2]: "Raj"
};

console.log(user);
```

---

## Exercise 6

Predict the output:

```js
const key1 = "name";
const key2 = "city";

const user = {
    [key1]: "Om",
    [key2]: "Pune"
};

console.log(user);
```

---

## Exercise 7

What is the difference between these?

```js
const user = {
    name
};
```

and:

```js
const { name } = user;
```

---

## Exercise 8

Extract `name` into a variable called `fullName`.

```js
const user = {
    name: "Om"
};
```

---

# Final Part 1 Rule

```text
{name}
   ↓
Property shorthand
   ↓
Create property using variable name


{[key]: value}
   ↓
Computed property
   ↓
Evaluate key first


const { name } = user
   ↓
Destructuring
   ↓
Extract value


const { name: fullName } = user
   ↓
Destructuring + renaming
   ↓
user.name → fullName
```
# Enhanced Object Literals

## Part 2 — Internal Working, Evaluation Order & Deep Understanding

> Part 1 taught us how to write Enhanced Object Literals. Part 2 focuses on **what JavaScript does when it evaluates them**.

---

# 1. How JavaScript Evaluates an Object Literal

Consider:

```js
const name = "Om";
const age = 22;

const user = {
    name,
    age
};
```

JavaScript evaluates the object literal and creates an ordinary object.

The shorthand:

```js
name
```

is equivalent to:

```js
name: name
```

Therefore, conceptually:

```js
const user = {
    name: name,
    age: age
};
```

The result is:

```js
{
    name: "Om",
    age: 22
}
```

### Important

Enhanced Object Literals do **not** create a special type of object.

They are simply a cleaner syntax for creating normal JavaScript objects.

---

# 2. Property Shorthand Evaluation

Consider:

```js
const city = "Pune";

const address = {
    city
};
```

JavaScript looks at:

```js
city
```

and resolves the variable:

```text
city
 ↓
"Pune"
```

Then the object receives:

```js
city: "Pune"
```

So:

```js
const address = {
    city
};
```

is conceptually equivalent to:

```js
const address = {
    city: city
};
```

---

# 3. Shorthand Does Not Create a Reference to the Variable

This is an important point.

```js
let name = "Om";

const user = {
    name
};

name = "Raj";

console.log(name);
console.log(user.name);
```

Output:

```text
Raj
Om
```

Why?

When the object is created, the current value of `name` is assigned to the object's property.

The object has:

```js
user.name
```

and the variable has:

```js
name
```

They are separate bindings.

---

# 4. Computed Property Names

Now consider:

```js
const key = "language";

const course = {
    [key]: "JavaScript"
};
```

The important part is:

```js
[key]
```

JavaScript evaluates the expression inside the brackets first.

```text
key
 ↓
"language"
```

Then it uses `"language"` as the property name.

So the result is:

```js
{
    language: "JavaScript"
}
```

---

# 5. Computed Properties Are Expressions

The brackets do not require a simple variable.

They can contain an expression.

```js
const id = 101;

const student = {
    ["student_" + id]: "Om"
};
```

JavaScript evaluates:

```js
"student_" + id
```

First:

```text
"student_" + 101
        ↓
"student_101"
```

Then the object becomes:

```js
{
    student_101: "Om"
}
```

Another example:

```js
const prefix = "user";
const id = 10;

const obj = {
    [prefix + "_" + id]: "Om"
};
```

Result:

```js
{
    user_10: "Om"
}
```

---

# 6. Evaluation Order

JavaScript evaluates object properties from top to bottom.

Example:

```js
const first = "name";
const second = "city";

const user = {
    [first]: "Om",
    [second]: "Pune"
};
```

Evaluation:

```text
Step 1
[first]
  ↓
"name"

Step 2
[second]
  ↓
"city"

Step 3
Create properties
```

Result:

```js
{
    name: "Om",
    city: "Pune"
}
```

---

# 7. The Most Important Case: Duplicate Computed Keys

Consider the example:

```js
const key = "Lang";
const key2 = "Lang";

const course = {
    [key]: "JS",
    [key2]: "JS2"
};

console.log(course);
```

This is the exact situation that often confuses beginners.

### Step 1 — Evaluate `key`

```text
key
 ↓
"Lang"
```

Therefore:

```js
[key]: "JS"
```

becomes:

```js
Lang: "JS"
```

### Step 2 — Evaluate `key2`

```text
key2
 ↓
"Lang"
```

Therefore:

```js
[key2]: "JS2"
```

becomes:

```js
Lang: "JS2"
```

### Step 3 — JavaScript sees

Conceptually:

```js
const course = {
    Lang: "JS",
    Lang: "JS2"
};
```

Both properties have the same key.

The second value replaces the first.

Final object:

```js
{
    Lang: "JS2"
}
```

---

# 8. Why Only One Property Exists

Think of an object as a collection of property names and values:

```text
Property Name → Value
```

Initially:

```text
Lang → JS
```

Then JavaScript processes the second property:

```text
Lang → JS2
```

There is already a property called `Lang`.

So its value is updated.

Final state:

```text
Lang → JS2
```

It does **not** become:

```text
Lang → JS
Lang → JS2
```

An object cannot have two separate own properties with exactly the same property key.

---

# 9. Different Keys Produce Different Properties

Now change the second key:

```js
const key = "Lang";
const key2 = "Lang2";

const course = {
    [key]: "JS",
    [key2]: "JS2"
};
```

Evaluation:

```text
[key]
 ↓
"Lang"

[key2]
 ↓
"Lang2"
```

Final object:

```js
{
    Lang: "JS",
    Lang2: "JS2"
}
```

So the important question is **not**:

> How many variables do I have?

The important question is:

> What property names do those variables evaluate to?

---

# 10. Variable Names Are Not Property Names

This is extremely important.

```js
const key = "Lang";
```

Here:

```text
Variable name = key
Variable value = "Lang"
```

When you write:

```js
[key]
```

JavaScript uses the **value**:

```text
key
 ↓
"Lang"
```

It does not use the word `"key"`.

Compare:

```js
const course = {
    key: "JS"
};
```

with:

```js
const course = {
    [key]: "JS"
};
```

They are completely different.

### First

```js
{
    key: "JS"
}
```

### Second

```js
{
    Lang: "JS"
}
```

---

# 11. Property Override Rule

Duplicate properties follow the basic rule:

```text
LAST PROPERTY WINS
```

Example:

```js
const user = {
    name: "Om",
    name: "Raj"
};
```

Final result:

```js
{
    name: "Raj"
}
```

The same rule applies to computed properties:

```js
const key1 = "name";
const key2 = "name";

const user = {
    [key1]: "Om",
    [key2]: "Raj"
};
```

Final result:

```js
{
    name: "Raj"
}
```

---

# 12. Spread Also Follows the Override Rule

Consider:

```js
const a = {
    name: "Om"
};

const b = {
    name: "Raj"
};

const result = {
    ...a,
    ...b
};
```

First:

```text
...a
 ↓
name: "Om"
```

Then:

```text
...b
 ↓
name: "Raj"
```

Final result:

```js
{
    name: "Raj"
}
```

Again:

```text
LAST PROPERTY WINS
```

---

# 13. Spread Order Matters

Compare:

```js
const result = {
    ...a,
    ...b
};
```

with:

```js
const result = {
    ...b,
    ...a
};
```

If both objects contain `name`:

First:

```js
{
    ...a,
    ...b
}
```

gives:

```js
{
    name: "Raj"
}
```

But:

```js
{
    ...b,
    ...a
}
```

gives:

```js
{
    name: "Om"
}
```

Therefore:

```text
Later property
      ↓
overrides
      ↓
earlier property
```

---

# 14. Spread + Explicit Property

This is another common pattern.

```js
const user = {
    name: "Om",
    age: 22
};

const updatedUser = {
    ...user,
    age: 23
};
```

Evaluation:

```text
...user
 ↓
name: "Om"
age: 22
```

Then:

```text
age: 23
```

overrides the previous `age`.

Result:

```js
{
    name: "Om",
    age: 23
}
```

---

# 15. Explicit Property Before Spread

Now reverse the order:

```js
const updatedUser = {
    age: 23,
    ...user
};
```

The spread comes later.

So the original `age: 22` overrides `age: 23`.

Result:

```js
{
    name: "Om",
    age: 22
}
```

### Important rule

```text
Object properties are processed from left → right.

Later matching keys override earlier keys.
```

---

# 16. Destructuring Is the Opposite Direction

Object creation:

```js
const name = "Om";

const user = {
    name
};
```

moves a value:

```text
variable
   ↓
object property
```

Destructuring does the opposite:

```js
const { name } = user;
```

moves a value:

```text
object property
   ↓
variable
```

Think:

```text
Object shorthand

name
 ↓
user.name


Destructuring

user.name
 ↓
name
```

---

# 17. Destructuring With Renaming

Suppose:

```js
const user = {
    name: "Om"
};
```

You want the value stored in a variable called `fullName`.

Write:

```js
const { name: fullName } = user;
```

This means:

```text
user.name
   ↓
fullName
```

So:

```js
console.log(fullName);
```

prints:

```text
Om
```

The object's property is still called:

```text
name
```

Only the local variable is called:

```text
fullName
```

---

# 18. Common Destructuring Mistake

Suppose:

```js
const user = {
    Lang: "JS",
    Lang2: "JS2"
};
```

This:

```js
const { k, k2 } = user;
```

does NOT mean:

```text
Lang → k
Lang2 → k2
```

It means:

```text
user.k  → k
user.k2 → k2
```

Since the object has no `k` or `k2` properties:

```js
console.log(k);  // undefined
console.log(k2); // undefined
```

To rename the properties:

```js
const {
    Lang: k,
    Lang2: k2
} = user;
```

Now:

```text
user.Lang  → k
user.Lang2 → k2
```

Therefore:

```js
console.log(k);  // JS
console.log(k2); // JS2
```

---

# 19. Shorthand and Destructuring Together

These two can be used together:

```js
const name = "Om";
const age = 22;

const user = {
    name,
    age
};

const {
    name: fullName,
    age
} = user;
```

Object creation:

```text
name → user.name
age  → user.age
```

Destructuring:

```text
user.name → fullName
user.age  → age
```

This gives:

```text
user
 │
 ├── name → "Om" → fullName
 │
 └── age  → 22   → age
```

---

# 20. Computed Properties and Destructuring Are Different

Computed property:

```js
const key = "name";

const user = {
    [key]: "Om"
};
```

This creates a property dynamically.

Destructuring:

```js
const { name } = user;
```

extracts a property.

So:

```text
Computed property
        ↓
CREATE

Destructuring
        ↓
EXTRACT
```

Do not confuse the two.

---

# 21. Evaluation With Function Calls

Computed property expressions can even call functions.

```js
function getKey() {
    return "name";
}

const user = {
    [getKey()]: "Om"
};

console.log(user);
```

JavaScript evaluates:

```js
getKey()
```

which returns:

```text
"name"
```

Therefore the object becomes:

```js
{
    name: "Om"
}
```

---

# 22. Multiple Computed Expressions

```js
function getFirstKey() {
    return "name";
}

function getSecondKey() {
    return "city";
}

const user = {
    [getFirstKey()]: "Om",
    [getSecondKey()]: "Pune"
};
```

Evaluation order:

```text
getFirstKey()
      ↓
"name"

getSecondKey()
      ↓
"city"
```

Final object:

```js
{
    name: "Om",
    city: "Pune"
}
```

---

# 23. Be Careful With Side Effects

Because computed property expressions are evaluated, functions used inside them can have side effects.

```js
let count = 0;

function getKey() {
    count++;
    return "value";
}

const obj = {
    [getKey()]: "JavaScript"
};

console.log(count);
```

Output:

```text
1
```

The function was actually executed while the object was being created.

This is why computed properties are more than simple text substitution.

---

# 24. Property Keys Are Ultimately Strings or Symbols

Most beginner examples use strings:

```js
const key = "name";
```

But JavaScript object property keys can be:

```text
String
Symbol
```

Numbers used as object keys are converted to strings.

Example:

```js
const id = 101;

const obj = {
    [id]: "Om"
};
```

The resulting property is effectively:

```js
{
    "101": "Om"
}
```

---

# 25. Important Mental Model

When you see:

```js
const obj = {
    [expression]: value
};
```

think:

```text
1. Evaluate expression
          ↓
2. Get property key
          ↓
3. Assign value
          ↓
4. Continue to next property
```

For:

```js
const key = "Lang";

const obj = {
    [key]: "JS"
};
```

think:

```text
[key]
 ↓
key
 ↓
"Lang"
 ↓
property name
 ↓
Lang: "JS"
```

---

# 26. Complete Example

Let's combine everything:

```js
const name = "Om";
const key1 = "language";
const key2 = "version";

const course = {
    name,
    
    [key1]: "JavaScript",
    
    [key2]: 2026,

    display() {
        console.log(this.name);
    }
};

console.log(course);
course.display();
```

Result:

```js
{
    name: "Om",
    language: "JavaScript",
    version: 2026,
    display: [Function]
}
```

Here we used:

```text
name
 ↓
Property shorthand

[key1]
 ↓
Computed property

[key2]
 ↓
Computed property

display()
 ↓
Method shorthand
```

---

# 27. Deep Revision Table

| Syntax                           | Meaning                      |
| -------------------------------- | ---------------------------- |
| `{ name: name }`                 | Normal property              |
| `{ name }`                       | Property shorthand           |
| `{ greet: function() {} }`       | Normal method syntax         |
| `{ greet() {} }`                 | Method shorthand             |
| `{ [key]: value }`               | Computed property            |
| `{ key: value }`                 | Literal property named `key` |
| `{ ...obj }`                     | Spread properties            |
| `const { name } = obj`           | Destructuring                |
| `const { name: fullName } = obj` | Destructuring with renaming  |

---

# 28. Golden Rules

### Rule 1

```js
{ name }
```

means:

```js
{ name: name }
```

---

### Rule 2

```js
{ [key]: value }
```

means:

> Evaluate `key`, then use its result as the property name.

---

### Rule 3

```js
{ key: value }
```

means:

> The property is literally called `key`.

---

### Rule 4

If two properties have the same key:

```text
LAST PROPERTY WINS
```

---

### Rule 5

Object properties are processed from:

```text
LEFT → RIGHT
```

---

### Rule 6

```js
const { name: fullName } = user;
```

means:

```text
user.name → fullName
```

It does not rename `user.name`.

---

# 29. Final Mental Model

Keep this diagram in your mind:

```text
                 OBJECT LITERAL
                       │
        ┌──────────────┼──────────────┐
        ↓              ↓              ↓
   name: value       name           [key]: value
        │              │                 │
   normal property   shorthand       computed key
                                      │
                                      ↓
                              evaluate expression
                                      │
                                      ↓
                              use result as key


                 DESTRUCTURING
                       │
                       ↓
                 const { name }
                       │
                       ↓
                  extract value
                       │
                       ↓
                    variable
```

The most important concept from Part 2 is:

```text
[key] does NOT mean the property is called "key".

[key] means:
"evaluate key and use the result as the property name."
```

And:

```text
Same resulting property key
          ↓
Same object property
          ↓
Later value replaces earlier value
          ↓
LAST PROPERTY WINS
```
# Enhanced Object Literals

## Part 3 — Practical Coding Patterns & Problem Solving

> Part 1 taught the syntax. Part 2 explained how JavaScript evaluates it. Part 3 focuses on **using Enhanced Object Literals to solve real coding problems**.

---

# 1. What You Should Know Before Part 3

You should already understand:

```js
// Property shorthand
const name = "Om";

const user = {
    name
};
```

```js
// Method shorthand
const user = {
    greet() {
        console.log("Hello");
    }
};
```

```js
// Computed property
const key = "city";

const user = {
    [key]: "Pune"
};
```

```js
// Destructuring
const { name } = user;
```

Now we combine these features.

---

# 2. Creating a User Object

A common use of property shorthand is creating objects from variables.

```js
const name = "Om";
const age = 22;
const city = "Pune";

const user = {
    name,
    age,
    city
};

console.log(user);
```

Output:

```js
{
    name: "Om",
    age: 22,
    city: "Pune"
}
```

Without shorthand:

```js
const user = {
    name: name,
    age: age,
    city: city
};
```

The shorthand version is cleaner.

---

# 3. Creating a Student Object

```js
const studentName = "Om";
const rollNo = 101;
const course = "JavaScript";

const student = {
    studentName,
    rollNo,
    course
};

console.log(student);
```

Output:

```js
{
    studentName: "Om",
    rollNo: 101,
    course: "JavaScript"
}
```

Notice that the property names come directly from the variable names.

---

# 4. When Property Name and Variable Name Are Different

Suppose:

```js
const username = "Om";
```

But the API expects:

```js
{
    name: "Om"
}
```

Use:

```js
const user = {
    name: username
};
```

Output:

```js
{
    name: "Om"
}
```

Property shorthand cannot be used here because:

```text
username !== name
```

---

# 5. Adding Methods

Objects can contain both data and behavior.

```js
const name = "Om";

const user = {
    name,

    greet() {
        console.log(`Hello ${this.name}`);
    }
};

user.greet();
```

Output:

```text
Hello Om
```

Here we use:

```text
name
 ↓
property shorthand

greet()
 ↓
method shorthand
```

---

# 6. Calculator Object

```js
const calculator = {
    add(a, b) {
        return a + b;
    },

    subtract(a, b) {
        return a - b;
    },

    multiply(a, b) {
        return a * b;
    },

    divide(a, b) {
        return a / b;
    }
};

console.log(calculator.add(10, 20));
console.log(calculator.subtract(20, 10));
console.log(calculator.multiply(5, 4));
console.log(calculator.divide(20, 5));
```

Output:

```text
30
10
20
4
```

This is a practical example of **method shorthand**.

---

# 7. Using `this` With Method Shorthand

```js
const user = {
    name: "Om",
    age: 22,

    introduce() {
        console.log(`My name is ${this.name}`);
        console.log(`My age is ${this.age}`);
    }
};

user.introduce();
```

Output:

```text
My name is Om
My age is 22
```

`this` refers to the object when the method is called as:

```js
user.introduce();
```

---

# 8. Dynamic Property Names

Suppose the property name comes from a variable.

```js
const field = "city";
const value = "Pune";

const address = {
    [field]: value
};

console.log(address);
```

Output:

```js
{
    city: "Pune"
}
```

This is useful when the property name is not known until runtime.

---

# 9. Dynamic Search Filter

Imagine a search system.

```js
const filter = "category";
const value = "Electronics";

const query = {
    [filter]: value
};

console.log(query);
```

Output:

```js
{
    category: "Electronics"
}
```

Now the same function can create different filters:

```js
function createFilter(field, value) {
    return {
        [field]: value
    };
}

console.log(createFilter("category", "Electronics"));
console.log(createFilter("brand", "Apple"));
console.log(createFilter("price", 70000));
```

Output:

```js
{
    category: "Electronics"
}

{
    brand: "Apple"
}

{
    price: 70000
}
```

This is a practical reason for computed property names.

---

# 10. Factory Functions

A factory function is a function that creates and returns objects.

```js
function createUser(name, age) {
    return {
        name,
        age
    };
}

const user1 = createUser("Om", 22);
const user2 = createUser("Raj", 25);

console.log(user1);
console.log(user2);
```

Output:

```js
{
    name: "Om",
    age: 22
}

{
    name: "Raj",
    age: 25
}
```

The shorthand makes factory functions very clean.

---

# 11. Factory Function With a Method

```js
function createUser(name, age) {
    return {
        name,
        age,

        greet() {
            console.log(`Hello ${this.name}`);
        }
    };
}

const user = createUser("Om", 22);

user.greet();
```

Output:

```text
Hello Om
```

Now the factory creates both:

```text
data
+
behavior
```

---

# 12. Product Factory

```js
function createProduct(name, price) {
    return {
        name,
        price,

        getPrice() {
            return this.price;
        }
    };
}

const laptop = createProduct("Laptop", 70000);

console.log(laptop);
console.log(laptop.getPrice());
```

Output:

```text
70000
```

---

# 13. Dynamic Product Fields

Suppose a product can have a dynamic field.

```js
function createProduct(name, field, value) {
    return {
        name,
        [field]: value
    };
}

const product = createProduct(
    "Laptop",
    "brand",
    "Apple"
);

console.log(product);
```

Output:

```js
{
    name: "Laptop",
    brand: "Apple"
}
```

Another call:

```js
createProduct(
    "Laptop",
    "color",
    "Silver"
);
```

creates:

```js
{
    name: "Laptop",
    color: "Silver"
}
```

---

# 14. Configuration Objects

Configuration objects are common in applications.

```js
const host = "localhost";
const port = 5000;
const database = "MongoDB";

const config = {
    host,
    port,
    database
};

console.log(config);
```

Output:

```js
{
    host: "localhost",
    port: 5000,
    database: "MongoDB"
}
```

This is a simple and useful example of property shorthand.

---

# 15. API Request Object

Suppose you have:

```js
const name = "Om";
const email = "om@gmail.com";
const age = 22;
```

You can build an API payload:

```js
const request = {
    name,
    email,
    age
};

console.log(request);
```

Output:

```js
{
    name: "Om",
    email: "om@gmail.com",
    age: 22
}
```

This pattern appears frequently in JavaScript applications.

---

# 16. API Response Object

Suppose:

```js
const success = true;

const data = {
    id: 101,
    course: "JavaScript"
};
```

Create the response:

```js
const response = {
    success,
    data
};

console.log(response);
```

Output:

```js
{
    success: true,
    data: {
        id: 101,
        course: "JavaScript"
    }
}
```

---

# 17. Dynamic API Payload

Suppose the API field is dynamic.

```js
function createPayload(field, value) {
    return {
        [field]: value
    };
}

const payload = createPayload(
    "email",
    "om@gmail.com"
);

console.log(payload);
```

Output:

```js
{
    email: "om@gmail.com"
}
```

This could also produce:

```js
createPayload("city", "Pune");
```

Result:

```js
{
    city: "Pune"
}
```

---

# 18. Combining Shorthand and Computed Properties

This is where the concepts start working together.

```js
const name = "Om";
const field = "city";
const value = "Pune";

const user = {
    name,
    [field]: value
};

console.log(user);
```

Output:

```js
{
    name: "Om",
    city: "Pune"
}
```

We used:

```text
name
 ↓
Property shorthand

[field]
 ↓
Computed property
```

---

# 19. Combining Shorthand, Method, and Computed Property

```js
const name = "Om";
const field = "city";
const value = "Pune";

const user = {
    name,

    [field]: value,

    display() {
        console.log(this.name);
        console.log(this.city);
    }
};

user.display();
```

Output:

```text
Om
Pune
```

This is a good example because it combines three Enhanced Object Literal features.

---

# 20. Spread With Enhanced Object Literals

Suppose we have:

```js
const personal = {
    name: "Om",
    age: 22
};

const professional = {
    role: "Developer",
    company: "OpenAI"
};
```

Combine them:

```js
const employee = {
    ...personal,
    ...professional
};

console.log(employee);
```

Output:

```js
{
    name: "Om",
    age: 22,
    role: "Developer",
    company: "OpenAI"
}
```

---

# 21. Spread and Override

Consider:

```js
const user = {
    name: "Om",
    age: 22
};

const updatedUser = {
    ...user,
    age: 23
};

console.log(updatedUser);
```

Output:

```js
{
    name: "Om",
    age: 23
}
```

Why?

Because:

```text
...user
   ↓
age: 22

age: 23
   ↓
overrides age: 22
```

Remember:

```text
LAST PROPERTY WINS
```

---

# 22. Dynamic Update Object

This is a very useful real coding pattern.

```js
function updateField(field, value) {
    return {
        [field]: value
    };
}

const update = updateField("city", "Pune");

console.log(update);
```

Result:

```js
{
    city: "Pune"
}
```

You can use it with an existing object:

```js
const user = {
    name: "Om",
    city: "Mumbai"
};

const update = {
    ...user,
    ...updateField("city", "Pune")
};

console.log(update);
```

Result:

```js
{
    name: "Om",
    city: "Pune"
}
```

---

# 23. Building an Order Object

Let's combine several concepts.

```js
const product = "Laptop";
const price = 70000;
const quantity = 2;

const order = {
    product,
    price,
    quantity,

    total() {
        return this.price * this.quantity;
    }
};

console.log(order);
console.log(order.total());
```

Output:

```text
140000
```

Here:

```text
product
price
quantity
    ↓
Property shorthand

total()
    ↓
Method shorthand
```

---

# 24. Shopping Cart Product

```js
const productName = "Laptop";
const price = 70000;
const discountKey = "discount";

const product = {
    productName,
    price,
    [discountKey]: 10,

    finalPrice() {
        return this.price - (this.price * this.discount) / 100;
    }
};

console.log(product);
console.log(product.finalPrice());
```

Output:

```text
63000
```

This combines:

```text
Property shorthand
+
Computed property
+
Method shorthand
```

---

# 25. Factory Function for Shopping Products

```js
function createProduct(name, price, discount) {
    return {
        name,
        price,
        discount,

        finalPrice() {
            return this.price - (this.price * this.discount) / 100;
        }
    };
}

const laptop = createProduct(
    "Laptop",
    70000,
    10
);

console.log(laptop.finalPrice());
```

Output:

```text
63000
```

---

# 26. Creating Objects From Form Data

Suppose form values are stored in variables:

```js
const username = "Om";
const email = "om@gmail.com";
const password = "secret";
```

Create a user:

```js
const user = {
    username,
    email,
    password
};
```

This is much cleaner than:

```js
const user = {
    username: username,
    email: email,
    password: password
};
```

---

# 27. Dynamic Form Field

Suppose a form tells us which field changed.

```js
const field = "email";
const value = "new@example.com";

const update = {
    [field]: value
};

console.log(update);
```

Result:

```js
{
    email: "new@example.com"
}
```

If:

```js
const field = "username";
```

then:

```js
{
    username: value
}
```

This is one of the most useful patterns for understanding computed properties.

---

# 28. Building a Dynamic Filter

```js
function createFilter(field, value) {
    return {
        [field]: value
    };
}

const filter = createFilter(
    "category",
    "Electronics"
);

console.log(filter);
```

Output:

```js
{
    category: "Electronics"
}
```

Multiple filters can be combined:

```js
const filter1 = createFilter("category", "Electronics");
const filter2 = createFilter("brand", "Apple");

const filters = {
    ...filter1,
    ...filter2
};

console.log(filters);
```

Result:

```js
{
    category: "Electronics",
    brand: "Apple"
}
```

---

# 29. Object Factory With Dynamic Keys

```js
function createRecord(key, value) {
    return {
        [key]: value
    };
}

console.log(createRecord("name", "Om"));
console.log(createRecord("city", "Pune"));
console.log(createRecord("age", 22));
```

Output:

```js
{
    name: "Om"
}

{
    city: "Pune"
}

{
    age: 22
}
```

The same function creates objects with different property names.

---

# 30. Practical Challenge: Student Object

Create:

```js
const name = "Om";
const rollNo = 101;
const subject = "JavaScript";
```

Then build:

```js
const student = {
    name,
    rollNo,
    [subject]: 95,

    introduce() {
        console.log(this.name);
    }
};
```

The result is:

```js
{
    name: "Om",
    rollNo: 101,
    JavaScript: 95,
    introduce: [Function]
}
```

Notice:

```js
[subject]
```

becomes:

```js
JavaScript
```

because:

```text
subject
   ↓
"JavaScript"
```

---

# 31. Practical Challenge: Employee

Create an employee object using:

```js
const name = "Om";
const department = "IT";
const salary = 50000;
const dynamicField = "location";
const location = "Pune";
```

Solution:

```js
const employee = {
    name,
    department,
    salary,
    [dynamicField]: location,

    getDetails() {
        return `${this.name} works in ${this.department}`;
    }
};

console.log(employee);
console.log(employee.getDetails());
```

---

# 32. Common Practical Mistake

This:

```js
const key = "city";

const user = {
    key: "Pune"
};
```

creates:

```js
{
    key: "Pune"
}
```

Not:

```js
{
    city: "Pune"
}
```

For a dynamic property, use:

```js
const user = {
    [key]: "Pune"
};
```

Result:

```js
{
    city: "Pune"
}
```

---

# 33. Common Practical Mistake: Duplicate Dynamic Keys

Be careful with:

```js
const key1 = "name";
const key2 = "name";

const user = {
    [key1]: "Om",
    [key2]: "Raj"
};
```

Result:

```js
{
    name: "Raj"
}
```

The keys are the same.

Remember:

```text
key1 → "name"
key2 → "name"

same key
   ↓
last value wins
```

---

# 34. Common Practical Mistake: Wrong Destructuring

Given:

```js
const user = {
    name: "Om",
    city: "Pune"
};
```

This:

```js
const { username } = user;
```

does not get `name`.

It looks for:

```js
user.username
```

which doesn't exist.

Result:

```js
undefined
```

If you want a different variable name:

```js
const { name: username } = user;
```

Now:

```js
console.log(username);
```

prints:

```text
Om
```

---

# 35. Real Coding Pattern: Update Any Field

A very common pattern is:

```js
function updateUser(user, field, value) {
    return {
        ...user,
        [field]: value
    };
}
```

Example:

```js
const user = {
    name: "Om",
    age: 22,
    city: "Pune"
};

const updatedUser = updateUser(
    user,
    "age",
    23
);

console.log(updatedUser);
```

Result:

```js
{
    name: "Om",
    age: 23,
    city: "Pune"
}
```

The important part is:

```js
[field]: value
```

combined with:

```js
...user
```

This is a powerful combination.

---

# 36. Real Coding Pattern: Add a Dynamic Field

```js
function addField(user, field, value) {
    return {
        ...user,
        [field]: value
    };
}

const user = {
    name: "Om"
};

const updatedUser = addField(
    user,
    "city",
    "Pune"
);

console.log(updatedUser);
```

Result:

```js
{
    name: "Om",
    city: "Pune"
}
```

---

# 37. Real Coding Pattern: Remove a Field

Enhanced Object Literals are often used alongside destructuring.

```js
const user = {
    name: "Om",
    age: 22,
    city: "Pune"
};

const { age, ...remainingUser } = user;

console.log(remainingUser);
```

Result:

```js
{
    name: "Om",
    city: "Pune"
}
```

Here:

```text
age
 ↓
extracted

...remainingUser
 ↓
remaining properties
```

---

# 38. Interview-Style Question 1

Predict the output:

```js
const name = "Om";

const user = {
    name
};

console.log(user.name);
```

Answer:

```text
Om
```

Reason:

```text
name
 ↓
name: name
```

---

# 39. Interview-Style Question 2

Predict the output:

```js
const key = "name";

const user = {
    [key]: "Om"
};

console.log(user);
```

Answer:

```js
{
    name: "Om"
}
```

---

# 40. Interview-Style Question 3

Predict the output:

```js
const key1 = "name";
const key2 = "name";

const user = {
    [key1]: "Om",
    [key2]: "Raj"
};

console.log(user);
```

Answer:

```js
{
    name: "Raj"
}
```

Reason:

```text
key1 → name
key2 → name

same property
     ↓
last value wins
```

---

# 41. Interview-Style Question 4

Predict:

```js
const user = {
    name: "Om"
};

const { name: username } = user;

console.log(username);
```

Answer:

```text
Om
```

Because:

```text
user.name → username
```

---

# 42. Interview-Style Question 5

Predict:

```js
const user = {
    name: "Om"
};

const { username } = user;

console.log(username);
```

Answer:

```text
undefined
```

Because JavaScript searches for:

```js
user.username
```

not:

```js
user.name
```

---

# 43. Interview-Style Question 6

Predict:

```js
const a = {
    name: "Om"
};

const b = {
    name: "Raj"
};

const result = {
    ...a,
    ...b
};

console.log(result.name);
```

Answer:

```text
Raj
```

Because `b` comes later.

---

# 44. Practical Pattern Summary

```text
Create object
     ↓
Property shorthand

Create methods
     ↓
Method shorthand

Dynamic property
     ↓
Computed property

Merge objects
     ↓
Spread

Extract values
     ↓
Destructuring

Extract + rename
     ↓
Destructuring with renaming

Update dynamic field
     ↓
Spread + computed property
```

---

# 45. Part 3 Practice

## Exercise 1 — Easy

Create:

```js
const name = "Om";
const age = 22;
const city = "Pune";
```

Build the object using property shorthand.

Expected:

```js
{
    name: "Om",
    age: 22,
    city: "Pune"
}
```

---

## Exercise 2 — Method

Create a `calculator` object with:

```text
add()
subtract()
multiply()
```

Use method shorthand.

---

## Exercise 3 — Computed Property

Using:

```js
const key = "language";
const value = "JavaScript";
```

create:

```js
{
    language: "JavaScript"
}
```

---

## Exercise 4 — Dynamic Function

Create:

```js
function createField(key, value)
```

which returns:

```js
{
    [key]: value
}
```

Test:

```js
createField("city", "Pune");
createField("name", "Om");
```

---

## Exercise 5 — Factory Function

Create:

```js
function createStudent(name, rollNo)
```

which returns:

```js
{
    name,
    rollNo
}
```

---

## Exercise 6 — Factory + Method

Create:

```js
function createStudent(name, rollNo)
```

and return:

```js
{
    name,
    rollNo,

    introduce() {
        console.log(this.name);
    }
}
```

---

## Exercise 7 — Spread + Dynamic Property

Create:

```js
function updateUser(user, field, value)
```

that returns a new object without modifying the original.

Example:

```js
const user = {
    name: "Om",
    age: 22
};

const updated = updateUser(user, "age", 23);
```

Expected:

```js
{
    name: "Om",
    age: 23
}
```

---

## Exercise 8 — Challenge

Create a product object containing:

* Property shorthand
* Method shorthand
* Computed property
* Spread operator

Starting data:

```js
const name = "Laptop";
const price = 70000;
const field = "brand";
const value = "Apple";

const details = {
    category: "Electronics"
};
```

Expected object:

```js
{
    category: "Electronics",
    name: "Laptop",
    price: 70000,
    brand: "Apple",
    display() {
        // print product name
    }
}
```

---

# Part 3 Final Mental Model

When writing real code, think:

```text
Do I already have a variable with the same property name?
                ↓
              YES
                ↓
        Use property shorthand
                ↓
             { name }


Do I need a function inside the object?
                ↓
              YES
                ↓
        Use method shorthand
                ↓
            greet() {}


Is the property name dynamic?
                ↓
              YES
                ↓
       Use computed property
                ↓
          [field]: value


Do I need to combine objects?
                ↓
              YES
                ↓
             ...object


Do I need to extract values?
                ↓
              YES
                ↓
          destructuring


Do I need to update a dynamic field?
                ↓
              YES
                ↓
      ...object + [field]: value
```
# Enhanced Object Literals

## Part 4 — Real-World JavaScript, React, Node.js & Production Patterns

> Part 4 connects Enhanced Object Literals to code you will actually see in applications. The goal is to understand **when and why developers use these patterns**, not just memorize syntax.

---

# 1. Why Enhanced Object Literals Matter in Real Projects

In real JavaScript applications, objects are everywhere.

They are used for:

```text
User data
API requests
API responses
Configuration
React props
React state
Database documents
Form data
Search filters
Function results
Application settings
```

Enhanced Object Literals make these objects shorter and easier to maintain.

---

# 2. React Props

Suppose we have:

```js
const title = "Laptop";
const price = 70000;
```

We can pass them to a component:

```jsx
<Card
    title={title}
    price={price}
/>
```

The values can be represented as an object conceptually:

```js
{
    title,
    price
}
```

This is property shorthand.

Instead of repeating:

```js
{
    title: title,
    price: price
}
```

we can write:

```js
{
    title,
    price
}
```

---

# 3. React State Objects

Objects are commonly used as state.

```jsx
const [user, setUser] = useState({
    name: "Om",
    age: 22
});
```

Suppose we want to update the age:

```jsx
setUser({
    ...user,
    age: 23
});
```

Here we combine:

```text
Spread
+
Object literal
```

The spread copies the existing properties:

```text
name → "Om"
age  → 22
```

Then:

```js
age: 23
```

overrides the old value.

Result:

```js
{
    name: "Om",
    age: 23
}
```

---

# 4. Updating a Dynamic React Field

This is one of the most important real-world uses of computed properties.

Suppose:

```js
const field = "email";
const value = "om@example.com";
```

We can create:

```js
const update = {
    [field]: value
};
```

Result:

```js
{
    email: "om@example.com"
}
```

Now imagine a form:

```jsx
function handleChange(event) {
    const field = event.target.name;
    const value = event.target.value;

    setUser({
        ...user,
        [field]: value
    });
}
```

This is a very useful pattern.

If the input is:

```html
<input name="email" />
```

then:

```js
field
```

is:

```text
"email"
```

and:

```js
[field]: value
```

becomes:

```js
email: value
```

If another input is:

```html
<input name="username" />
```

the same code creates:

```js
username: value
```

The code does not need separate logic for every field.

---

# 5. Why Computed Properties Are Useful in Forms

Without a computed property, you might write:

```js
if (field === "email") {
    // update email
}

if (field === "username") {
    // update username
}

if (field === "city") {
    // update city
}
```

With computed properties:

```js
setUser({
    ...user,
    [field]: value
});
```

The property name is determined at runtime.

That's the real value of:

```js
[field]
```

---

# 6. React Custom Hooks

A custom hook often returns an object.

```jsx
function useUser() {
    const name = "Om";
    const age = 22;

    return {
        name,
        age
    };
}
```

This uses property shorthand.

The caller can destructure:

```jsx
const { name, age } = useUser();
```

Think:

```text
Hook
 ↓
returns object
 ↓
{ name, age }
 ↓
destructuring
 ↓
name, age
```

---

# 7. Returning Functions From a Hook

A hook can return both values and functions.

```jsx
function useCounter() {
    let count = 0;

    function increment() {
        count++;
    }

    return {
        count,
        increment
    };
}
```

The returned object uses property shorthand:

```js
{
    count,
    increment
}
```

---

# 8. Node.js Configuration

Node.js applications commonly use configuration objects.

```js
const HOST = "localhost";
const PORT = 5000;
const DATABASE = "MongoDB";

const config = {
    HOST,
    PORT,
    DATABASE
};

console.log(config);
```

Output:

```js
{
    HOST: "localhost",
    PORT: 5000,
    DATABASE: "MongoDB"
}
```

Property shorthand makes configuration objects easier to read.

---

# 9. Configuration With Different Property Names

Sometimes the variable name and property name should be different.

```js
const serverHost = "localhost";
const serverPort = 5000;

const config = {
    host: serverHost,
    port: serverPort
};
```

Here shorthand cannot be used because:

```text
serverHost !== host
serverPort !== port
```

So normal property syntax is appropriate.

---

# 10. Express API Response

An Express route might create a response:

```js
app.get("/user", (req, res) => {
    const name = "Om";
    const age = 22;

    const response = {
        name,
        age,
        success: true
    };

    res.json(response);
});
```

The object contains:

```text
name
age
success
```

Two use shorthand, while `success` uses a normal property because there is no variable called `success`.

---

# 11. API Response With Nested Objects

```js
const success = true;

const data = {
    id: 101,
    course: "JavaScript"
};

const response = {
    success,
    data
};
```

Result:

```js
{
    success: true,
    data: {
        id: 101,
        course: "JavaScript"
    }
}
```

This is a common API pattern.

---

# 12. API Request Payload

Suppose:

```js
const name = "Om";
const email = "om@example.com";
const age = 22;
```

Create a request:

```js
const payload = {
    name,
    email,
    age
};
```

Instead of:

```js
const payload = {
    name: name,
    email: email,
    age: age
};
```

Property shorthand removes unnecessary repetition.

---

# 13. Dynamic API Payload

Suppose an API allows a dynamic field.

```js
function createPayload(field, value) {
    return {
        [field]: value
    };
}
```

Now:

```js
createPayload("email", "om@example.com");
```

returns:

```js
{
    email: "om@example.com"
}
```

And:

```js
createPayload("city", "Pune");
```

returns:

```js
{
    city: "Pune"
}
```

One function can create many different payloads.

---

# 14. Updating API Data

A common pattern is:

```js
function updateUser(user, field, value) {
    return {
        ...user,
        [field]: value
    };
}
```

Example:

```js
const user = {
    name: "Om",
    age: 22,
    city: "Pune"
};

const updatedUser = updateUser(
    user,
    "age",
    23
);

console.log(updatedUser);
```

Result:

```js
{
    name: "Om",
    age: 23,
    city: "Pune"
}
```

The original object is not changed.

A new object is created.

---

# 15. Why `...user` and `[field]` Work Together

Look at:

```js
{
    ...user,
    [field]: value
}
```

Suppose:

```js
field = "city";
value = "Mumbai";
```

JavaScript effectively performs:

```text
...user
    ↓
copy existing properties

[field]: value
    ↓
city: "Mumbai"

city already exists?
    ↓
replace it
```

So:

```js
{
    name: "Om",
    age: 22,
    city: "Mumbai"
}
```

This is one of the most useful object patterns in modern JavaScript.

---

# 16. MongoDB-Style Documents

JavaScript objects are commonly used to represent database documents.

```js
const name = "Om";
const email = "om@example.com";
const age = 22;

const user = {
    name,
    email,
    age
};
```

The resulting object can represent:

```js
{
    name: "Om",
    email: "om@example.com",
    age: 22
}
```

Property shorthand keeps this clean.

---

# 17. Dynamic Database Fields

Suppose the field is determined at runtime:

```js
const field = "department";
const value = "IT";

const employee = {
    name: "Om",
    [field]: value
};
```

Result:

```js
{
    name: "Om",
    department: "IT"
}
```

The key is dynamic.

---

# 18. Search Filters

Search systems often need dynamic filters.

```js
function createFilter(field, value) {
    return {
        [field]: value
    };
}
```

Examples:

```js
createFilter("category", "Electronics");
```

Result:

```js
{
    category: "Electronics"
}
```

Another:

```js
createFilter("brand", "Apple");
```

Result:

```js
{
    brand: "Apple"
}
```

---

# 19. Combining Multiple Filters

```js
const categoryFilter = createFilter(
    "category",
    "Electronics"
);

const brandFilter = createFilter(
    "brand",
    "Apple"
);

const filter = {
    ...categoryFilter,
    ...brandFilter
};

console.log(filter);
```

Result:

```js
{
    category: "Electronics",
    brand: "Apple"
}
```

This combines:

```text
Computed properties
+
Spread
```

---

# 20. Logger Object

Objects are useful for grouping related functions.

```js
const logger = {
    info(message) {
        console.log("INFO:", message);
    },

    error(message) {
        console.log("ERROR:", message);
    },

    warn(message) {
        console.log("WARNING:", message);
    }
};

logger.info("Server started");
logger.error("Database connection failed");
```

This uses method shorthand.

---

# 21. Service Object

A simple service can also use method shorthand.

```js
const userService = {
    create(name) {
        return {
            name
        };
    },

    get(id) {
        return {
            id
        };
    }
};
```

Usage:

```js
const user = userService.create("Om");

console.log(user);
```

Result:

```js
{
    name: "Om"
}
```

---

# 22. Factory Function in a Real Application

A factory function can create application objects.

```js
function createUser(name, email, role) {
    return {
        name,
        email,
        role,

        getSummary() {
            return `${this.name} - ${this.role}`;
        }
    };
}

const user = createUser(
    "Om",
    "om@example.com",
    "Developer"
);

console.log(user.getSummary());
```

Output:

```text
Om - Developer
```

This combines:

```text
Property shorthand
+
Method shorthand
+
Factory function
```

---

# 23. Dynamic Configuration

Computed properties can be useful when configuration keys are generated dynamically.

```js
const environment = "production";
const value = "https://api.example.com";

const config = {
    [environment]: value
};

console.log(config);
```

Result:

```js
{
    production: "https://api.example.com"
}
```

Another environment:

```js
const environment = "development";
```

creates:

```js
{
    development: "https://api.example.com"
}
```

---

# 24. Building a Dynamic Object From an Array

Suppose we have:

```js
const fields = [
    ["name", "Om"],
    ["city", "Pune"],
    ["age", 22]
];
```

We can create an object dynamically:

```js
const user = Object.fromEntries(fields);

console.log(user);
```

Result:

```js
{
    name: "Om",
    city: "Pune",
    age: 22
}
```

This is not itself an Enhanced Object Literal, but it is an important **real-world companion technique** for dynamic object creation.

---

# 25. Dynamic Object + Enhanced Object Literal

Suppose we want to add a timestamp:

```js
const name = "Om";

const user = {
    name,
    createdAt: new Date()
};
```

Here:

```text
name
 ↓
property shorthand

createdAt: new Date()
 ↓
normal property
```

You do not need to use shorthand everywhere.

Use the syntax that makes the object clearest.

---

# 26. Choosing the Correct Syntax

### Use property shorthand when:

```js
const name = "Om";

const user = {
    name
};
```

The variable and property have the same name.

---

### Use normal property syntax when:

```js
const username = "Om";

const user = {
    name: username
};
```

The property and variable names are different.

---

### Use computed properties when:

```js
const field = "email";

const user = {
    [field]: "om@example.com"
};
```

The property name is dynamic.

---

### Use method shorthand when:

```js
const user = {
    greet() {
        console.log("Hello");
    }
};
```

You need a method.

---

### Use spread when:

```js
const result = {
    ...user,
    age: 23
};
```

You need a new object based on another object.

---

# 27. Production Pattern: Form State

A typical form state might look like:

```js
const form = {
    username: "",
    email: "",
    password: ""
};
```

A generic update function:

```js
function updateForm(form, field, value) {
    return {
        ...form,
        [field]: value
    };
}
```

Usage:

```js
let form = {
    username: "",
    email: "",
    password: ""
};

form = updateForm(
    form,
    "username",
    "Om"
);

form = updateForm(
    form,
    "email",
    "om@example.com"
);

console.log(form);
```

Result:

```js
{
    username: "Om",
    email: "om@example.com",
    password: ""
}
```

This pattern is worth understanding deeply.

---

# 28. Production Pattern: API Update

Suppose a server receives:

```js
const field = "status";
const value = "active";
```

An update object can be created:

```js
const update = {
    [field]: value
};
```

Result:

```js
{
    status: "active"
}
```

The server can then use that object as the update data.

The important idea is:

```text
field name is data
        ↓
computed property
        ↓
dynamic object
```

---

# 29. Production Pattern: Options Object

Instead of passing many arguments:

```js
function createServer(host, port, database, debug) {
    // ...
}
```

you can use an options object:

```js
function createServer(options) {
    console.log(options.host);
    console.log(options.port);
    console.log(options.database);
}
```

Create it using shorthand:

```js
const host = "localhost";
const port = 5000;
const database = "MongoDB";

const options = {
    host,
    port,
    database
};

createServer(options);
```

This pattern is common in JavaScript libraries.

---

# 30. Production Pattern: Returning Multiple Values

JavaScript functions can return multiple related values through an object.

```js
function getUser() {
    const name = "Om";
    const age = 22;

    return {
        name,
        age
    };
}
```

Then:

```js
const {
    name,
    age
} = getUser();

console.log(name);
console.log(age);
```

This combines:

```text
Property shorthand
+
Object return
+
Destructuring
```

---

# 31. Production Pattern: Returning Functions

```js
function createCounter() {
    let count = 0;

    function increment() {
        count++;
        return count;
    }

    function reset() {
        count = 0;
    }

    return {
        increment,
        reset
    };
}
```

Usage:

```js
const counter = createCounter();

console.log(counter.increment());
console.log(counter.increment());

counter.reset();

console.log(counter.increment());
```

Output:

```text
1
2
1
```

The returned object uses property shorthand:

```js
{
    increment,
    reset
}
```

---

# 32. Common Production Mistake: Duplicate Keys

Never assume these create two properties:

```js
const key1 = "name";
const key2 = "name";

const user = {
    [key1]: "Om",
    [key2]: "Raj"
};
```

They create one property:

```js
{
    name: "Raj"
}
```

Because:

```text
key1 → name
key2 → name
       ↓
same property
       ↓
last value wins
```

---

# 33. Common Production Mistake: Incorrect Dynamic Key

Wrong:

```js
const field = "email";

const update = {
    field: "new@example.com"
};
```

This creates:

```js
{
    field: "new@example.com"
}
```

Correct:

```js
const update = {
    [field]: "new@example.com"
};
```

This creates:

```js
{
    email: "new@example.com"
}
```

---

# 34. Common Production Mistake: Mutating the Original Object

Suppose:

```js
const user = {
    name: "Om",
    age: 22
};
```

This changes the existing object:

```js
user.age = 23;
```

Sometimes that is fine.

But when you need a new object, use:

```js
const updatedUser = {
    ...user,
    age: 23
};
```

Now:

```text
user.age
   ↓
22

updatedUser.age
   ↓
23
```

The original object remains unchanged.

---

# 35. Object Composition

Multiple objects can be combined:

```js
const personal = {
    name: "Om",
    age: 22
};

const professional = {
    role: "Developer",
    company: "Example"
};

const employee = {
    ...personal,
    ...professional
};
```

Result:

```js
{
    name: "Om",
    age: 22,
    role: "Developer",
    company: "Example"
}
```

This is called **object composition**.

---

# 36. Override During Composition

```js
const defaults = {
    theme: "light",
    language: "English"
};

const settings = {
    ...defaults,
    theme: "dark"
};
```

Result:

```js
{
    theme: "dark",
    language: "English"
}
```

The later property overrides the earlier one.

---

# 37. Real-World Mental Model

When working on a project, ask:

```text
Do I have a variable with the same property name?
        ↓
      YES
        ↓
Use shorthand
```

```text
Is the property name known only at runtime?
        ↓
      YES
        ↓
Use [computedProperty]
```

```text
Do I need to create a new object from an existing one?
        ↓
      YES
        ↓
Use ...spread
```

```text
Do I need to update one dynamic field?
        ↓
      YES
        ↓
Use ...object + [field]: value
```

```text
Do I need to return several related values?
        ↓
      YES
        ↓
Return an object + destructure it
```

---

# 38. Real-World Pattern Summary

```text
                    OBJECTS
                       │
        ┌──────────────┼──────────────┐
        ↓              ↓              ↓
   Data/Values       Methods       Dynamic Fields
        │              │              │
   { name }         greet()        [field]: value
        │              │              │
        └──────────────┼──────────────┘
                       ↓
                    Spread
                       │
                       ↓
              Object Composition
                       │
                       ↓
                Destructuring
                       │
                       ↓
              Extract / Rename
```

---

# 39. What You Should Be Able to Build Now

After Parts 1–4, you should be comfortable writing:

### User objects

```js
const user = {
    name,
    age
};
```

### Objects with methods

```js
const user = {
    name,

    greet() {
        console.log(this.name);
    }
};
```

### Dynamic objects

```js
const user = {
    [field]: value
};
```

### Updated objects

```js
const updated = {
    ...user,
    [field]: value
};
```

### Factory functions

```js
function createUser(name, age) {
    return {
        name,
        age
    };
}
```

### API payloads

```js
const payload = {
    name,
    email,
    age
};
```

### Dynamic filters

```js
const filter = {
    [field]: value
};
```

### Returned objects + destructuring

```js
const { name, age } = getUser();
```

---

# 40. Final Best Practices

### 1. Prefer shorthand when it improves readability

```js
const user = {
    name,
    age
};
```

---

### 2. Don't force shorthand when names are different

```js
const username = "Om";

const user = {
    name: username
};
```

This is perfectly good code.

---

### 3. Use computed properties for genuinely dynamic keys

Good:

```js
const field = "email";

const update = {
    [field]: value
};
```

Don't use computed properties just to look clever.

---

### 4. Remember that object property order matters for overrides

```js
{
    ...defaults,
    theme: "dark"
}
```

The later value wins.

---

### 5. Be careful with duplicate dynamic keys

```js
{
    [key1]: value1,
    [key2]: value2
}
```

Always ask:

```text
What does key1 evaluate to?
What does key2 evaluate to?
```

If both evaluate to the same key, the later value wins.

---

### 6. Use destructuring when extracting values

```js
const {
    name,
    age
} = user;
```

If the local variable should have a different name:

```js
const {
    name: fullName
} = user;
```

---

# 41. Final Revision

```text
PROPERTY SHORTHAND
        ↓
{name}
        ↓
{name: name}


METHOD SHORTHAND
        ↓
greet() {}
        ↓
object method


COMPUTED PROPERTY
        ↓
[field]: value
        ↓
evaluate field first


SPREAD
        ↓
...user
        ↓
copy properties


DYNAMIC UPDATE
        ↓
{
    ...user,
    [field]: value
}
        ↓
copy + update dynamic field


DESTRUCTURING
        ↓
const { name } = user
        ↓
extract value


RENAMING
        ↓
const { name: fullName } = user
        ↓
user.name → fullName


DUPLICATE KEYS
        ↓
same property key
        ↓
last property wins
```

---

# 🎯 Final Challenge

Build a `createStudent()` function that accepts:

```js
name
rollNo
subject
marks
```

and returns an object containing:

* Property shorthand
* A computed property for the subject
* A method called `display()`
* A method called `isPassed()`

Example:

```js
const student = createStudent(
    "Om",
    101,
    "JavaScript",
    85
);
```

Expected structure:

```js
{
    name: "Om",
    rollNo: 101,
    JavaScript: 85,

    display() {
        // print student name
    },

    isPassed() {
        // return true if marks >= 40
    }
}
```
