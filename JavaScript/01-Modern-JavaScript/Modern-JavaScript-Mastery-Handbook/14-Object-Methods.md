# Object Methods — Part 1: Introduction & Fundamentals

> **Goal:** Understand what JavaScript objects are and why built-in `Object.*` methods exist.
> **Note:** Deep prototype concepts, object internals, and advanced copying will be covered later in `06-Objects-Prototypes`.

---

# 1. What Is an Object?

An object stores data using **key-value pairs**.

```js
const user = {
    name: "Om",
    age: 22,
    city: "Pune"
};
```

Think of it as:

```text
user
 │
 ├── name → "Om"
 ├── age  → 22
 └── city → "Pune"
```

A key is also called a **property name**.

---

# 2. Why Do We Need Object Methods?

Arrays have useful methods such as:

```js
map()
filter()
find()
reduce()
```

Objects don't directly have these methods.

Instead, JavaScript provides the global `Object` utility:

```js
Object.keys()
Object.values()
Object.entries()
Object.assign()
Object.freeze()
Object.seal()
```

Example:

```js
const user = {
    name: "Om",
    age: 22
};

console.log(Object.keys(user));
```

Output:

```text
["name", "age"]
```

---

# 3. The Important Idea

Remember:

```text
Object
   ↓
Built-in JavaScript utility
   ↓
Provides methods for working with objects
```

For example:

```js
Object.keys(user)
```

means:

> "Give me the keys of this object."

---

# 4. Object Methods vs Object's Own Methods

Don't confuse these two.

### `Object.keys()`

```js
Object.keys(user);
```

`keys()` is a method provided by the built-in `Object`.

### A method inside an object

```js
const user = {
    name: "Om",

    greet() {
        console.log("Hello");
    }
};

user.greet();
```

Here:

```text
greet()
```

is a method belonging to `user`.

So:

```text
Object.keys()
    ↓
Built-in Object utility

user.greet()
    ↓
Method defined inside user
```

---

# 5. Why Are Object Methods Important?

They are used constantly when working with:

* API data
* JSON
* React state
* Node.js
* Express
* Configuration objects
* Database documents

Example:

```js
const user = {
    name: "Om",
    age: 22
};

Object.entries(user);
```

This converts the object into something that can easily be iterated.

---

# 6. Object → Array

One of the most important patterns is:

```text
Object
   ↓
Object.keys()
   ↓
Array
```

or:

```text
Object
   ↓
Object.values()
   ↓
Array
```

or:

```text
Object
   ↓
Object.entries()
   ↓
Array of [key, value]
```

Example:

```js
const user = {
    name: "Om",
    age: 22
};

console.log(Object.keys(user));
console.log(Object.values(user));
console.log(Object.entries(user));
```

Output:

```text
["name", "age"]

["Om", 22]

[
    ["name", "Om"],
    ["age", 22]
]
```

This pattern is extremely important for modern JavaScript.

---

# 7. Object Methods You Will Learn

```text
Object.keys()
        ↓
Get keys

Object.values()
        ↓
Get values

Object.entries()
        ↓
Get key-value pairs

Object.fromEntries()
        ↓
Convert entries → object

Object.assign()
        ↓
Copy / merge

Object.freeze()
        ↓
Prevent modifications

Object.seal()
        ↓
Prevent adding/removing

Object.hasOwn()
        ↓
Check direct property

Object.create()
        ↓
Prototype-based object creation

Object.is()
        ↓
Compare values
```

---

# 8. Hands-on Practice

**Don't copy immediately. Write these yourself.**

### Exercise 1

Create:

```js
const student = {
    name: "Om",
    age: 22,
    course: "JavaScript"
};
```

Then print the object.

---

### Exercise 2

Use:

```js
Object.keys()
```

to print:

```text
name
age
course
```

---

### Exercise 3

Use:

```js
Object.values()
```

to print:

```text
Om
22
JavaScript
```

---

### Exercise 4

Use:

```js
Object.entries()
```

and inspect the result.

---

### Exercise 5 — Think Before Running

What will this output?

```js
const user = {
    name: "Om",
    age: 22
};

console.log(Object.keys(user).length);
```

---

# 9. Quick Revision

```text
Object
  ↓
Key + Value
  ↓
Object Methods
  ↓
Inspect / Transform / Control
```

Most important starting pattern:

```js
Object.keys(obj)
Object.values(obj)
Object.entries(obj)
```

### Mastery Check

Before moving to Part 2, you should be able to answer:

1. What is an object?
2. What is `Object.keys()` used for?
3. What does `Object.values()` return?
4. What does `Object.entries()` return?
5. What is the difference between `user.greet()` and `Object.keys(user)`?

**Next → Part 2: `Object.keys()`, `Object.values()`, `Object.entries()` in depth.**
# Object Methods — Part 2: `keys()`, `values()`, `entries()`

> **Goal:** Master the three most commonly used object-inspection methods.
> **Rule:** Write the code yourself first. Don't copy the solution immediately.

---

# 1. `Object.keys()`

`Object.keys()` returns an **array containing the object's own enumerable property names**.

```js
const user = {
    name: "Om",
    age: 22,
    city: "Pune"
};

console.log(Object.keys(user));
```

Output:

```text
["name", "age", "city"]
```

Think:

```text
user
 ↓
Object.keys()
 ↓
["name", "age", "city"]
```

---

# 2. Count Object Properties

Because `Object.keys()` returns an array, you can use `.length`.

```js
const user = {
    name: "Om",
    age: 22,
    city: "Pune"
};

console.log(Object.keys(user).length);
```

Output:

```text
3
```

Useful for:

* Checking whether an object is empty
* Counting properties
* Validation

Example:

```js
if (Object.keys(user).length === 0) {
    console.log("Object is empty");
}
```

---

# 3. `Object.values()`

`Object.values()` returns an array containing the object's values.

```js
const user = {
    name: "Om",
    age: 22,
    city: "Pune"
};

console.log(Object.values(user));
```

Output:

```text
["Om", 22, "Pune"]
```

Think:

```text
user
 ↓
Object.values()
 ↓
["Om", 22, "Pune"]
```

---

# 4. `Object.entries()`

`Object.entries()` returns an array containing `[key, value]` pairs.

```js
const user = {
    name: "Om",
    age: 22
};

console.log(Object.entries(user));
```

Output:

```text
[
    ["name", "Om"],
    ["age", 22]
]
```

Think:

```text
Object

name → Om
age  → 22

        ↓

Object.entries()

        ↓

[
  ["name", "Om"],
  ["age", 22]
]
```

---

# 5. Using `Object.entries()` in a Loop

This is one of the most useful patterns.

```js
const user = {
    name: "Om",
    age: 22
};

for (const [key, value] of Object.entries(user)) {
    console.log(key, value);
}
```

Output:

```text
name Om
age 22
```

Notice the destructuring:

```js
const [key, value]
```

Each entry looks like:

```js
["name", "Om"]
```

So:

```text
key   → "name"
value → "Om"
```

---

# 6. Difference Between the Three

Given:

```js
const user = {
    name: "Om",
    age: 22
};
```

### `Object.keys()`

```js
Object.keys(user);
```

```text
["name", "age"]
```

### `Object.values()`

```js
Object.values(user);
```

```text
["Om", 22]
```

### `Object.entries()`

```js
Object.entries(user);
```

```text
[
    ["name", "Om"],
    ["age", 22]
]
```

### Remember

```text
keys()
   ↓
KEYS

values()
   ↓
VALUES

entries()
   ↓
KEY + VALUE
```

---

# 7. Real-world Example

Suppose you receive:

```js
const product = {
    name: "Laptop",
    price: 70000,
    brand: "Lenovo"
};
```

### Get all property names

```js
Object.keys(product);
```

### Get all values

```js
Object.values(product);
```

### Process key + value together

```js
Object.entries(product).forEach(([key, value]) => {
    console.log(`${key}: ${value}`);
});
```

Output:

```text
name: Laptop
price: 70000
brand: Lenovo
```

---

# 8. Hands-on Practice

### Exercise 1 — Keys

Create:

```js
const student = {
    name: "Om",
    age: 22,
    branch: "Computer Science",
    city: "Pune"
};
```

Print only the keys.

---

### Exercise 2 — Values

Print only the values.

Expected:

```text
Om
22
Computer Science
Pune
```

---

### Exercise 3 — Entries

Print:

```text
name → Om
age → 22
branch → Computer Science
city → Pune
```

Use:

```js
Object.entries()
```

---

### Exercise 4 — Count Properties

Find the number of properties without manually counting them.

Expected:

```text
4
```

---

### Exercise 5 — Find a Value

Given:

```js
const user = {
    name: "Om",
    age: 22,
    city: "Pune"
};
```

Use `Object.values()` to check whether `"Pune"` exists.

**Hint:**

```js
Object.values(user).includes(...)
```

---

### Exercise 6 — Predict Output

Without running:

```js
const product = {
    name: "Phone",
    price: 30000
};

console.log(Object.keys(product));
console.log(Object.values(product));
console.log(Object.entries(product));
```

Write the three outputs yourself.

---

# 9. Interview Quick Check

### `Object.keys()`?

```text
Object → Array of keys
```

### `Object.values()`?

```text
Object → Array of values
```

### `Object.entries()`?

```text
Object → Array of [key, value]
```

### Most useful when both key and value are needed?

```text
Object.entries()
```

---

# 10. Mastery Checklist

Before Part 3, you should be able to write these **without looking at notes**:

```js
Object.keys(obj);

Object.values(obj);

Object.entries(obj);
```

And:

```js
for (const [key, value] of Object.entries(obj)) {
    // your code
}
```

**Next → Part 3: `Object.fromEntries()`, `Object.assign()`, `freeze()`, `seal()`, and `hasOwn()`**
# Object Methods — Part 3: Transforming, Copying & Controlling Objects

> **Goal:** Understand `Object.fromEntries()`, `Object.assign()`, `Object.freeze()`, `Object.seal()`, and `Object.hasOwn()`.
>
> **Practice rule:** Read → understand → close the notes → write the code yourself.

---

# 1. `Object.fromEntries()`

`Object.fromEntries()` does the opposite of `Object.entries()`.

```text
Object
   ↓
Object.entries()
   ↓
[key, value] pairs
```

and:

```text
[key, value] pairs
   ↓
Object.fromEntries()
   ↓
Object
```

Example:

```js
const entries = [
    ["name", "Om"],
    ["age", 22]
];

const user = Object.fromEntries(entries);

console.log(user);
```

Output:

```js
{
    name: "Om",
    age: 22
}
```

---

# 2. Why `fromEntries()` Is Useful

It becomes powerful when you first transform entries and then convert them back into an object.

Example:

```js
const user = {
    name: "Om",
    age: 22
};

const result = Object.fromEntries(
    Object.entries(user).map(([key, value]) => {
        return [key, String(value)];
    })
);

console.log(result);
```

Result:

```js
{
    name: "Om",
    age: "22"
}
```

Mental model:

```text
Object
  ↓
entries()
  ↓
transform
  ↓
fromEntries()
  ↓
Object
```

This pattern is particularly useful when working with dynamic data.

---

# 3. `Object.assign()`

`Object.assign()` copies properties from one or more source objects into a target object.

Basic syntax:

```js
Object.assign(target, source);
```

Example:

```js
const user = {
    name: "Om"
};

const details = {
    age: 22
};

const result = Object.assign({}, user, details);

console.log(result);
```

Output:

```js
{
    name: "Om",
    age: 22
}
```

---

# 4. Merging Objects

Multiple objects can be merged.

```js
const personal = {
    name: "Om"
};

const education = {
    degree: "B.E."
};

const location = {
    city: "Pune"
};

const user = Object.assign(
    {},
    personal,
    education,
    location
);

console.log(user);
```

Result:

```js
{
    name: "Om",
    degree: "B.E.",
    city: "Pune"
}
```

---

# 5. Spread vs `Object.assign()`

Modern JavaScript commonly uses the spread operator:

```js
const user = {
    ...personal,
    ...education,
    ...location
};
```

Instead of:

```js
const user = Object.assign(
    {},
    personal,
    education,
    location
);
```

For simple copying and merging:

```text
Spread
   ↓
Usually cleaner

Object.assign()
   ↓
Still important to understand
```

You will see both in real codebases.

---

# 6. `Object.freeze()`

`Object.freeze()` prevents changes to an object's own properties.

```js
const user = {
    name: "Om",
    age: 22
};

Object.freeze(user);

user.name = "Raj";

console.log(user.name);
```

In non-strict code, the attempted modification is ignored.

Output:

```text
Om
```

A frozen object cannot have its own properties:

```text
modified ❌
added    ❌
deleted  ❌
```

---

# 7. Important: Freeze Is Shallow

This is extremely important.

```js
const user = {
    name: "Om",
    address: {
        city: "Pune"
    }
};

Object.freeze(user);

user.address.city = "Mumbai";

console.log(user.address.city);
```

The nested object can still be changed because:

```text
user
 ↓
address
 ↓
nested object
```

`Object.freeze(user)` only freezes the **top-level object**.

Deep freezing is a separate concept.

---

# 8. `Object.seal()`

`Object.seal()` prevents adding and deleting properties.

However, existing properties can still be modified.

```js
const user = {
    name: "Om",
    age: 22
};

Object.seal(user);

user.name = "Raj";

console.log(user.name);
```

Output:

```text
Raj
```

But:

```js
user.city = "Pune";
```

cannot add a new property.

And:

```js
delete user.age;
```

cannot delete the existing property.

---

# 9. `freeze()` vs `seal()`

Remember this table:

| Operation                | `freeze()` | `seal()` |
| ------------------------ | ---------: | -------: |
| Modify existing property |          ❌ |        ✅ |
| Add property             |          ❌ |        ❌ |
| Delete property          |          ❌ |        ❌ |

Mental model:

```text
freeze()
   ↓
READ ONLY

seal()
   ↓
STRUCTURE LOCKED
   ↓
Existing values can change
```

---

# 10. `Object.hasOwn()`

Checks whether a property belongs **directly to the object**.

```js
const user = {
    name: "Om",
    age: 22
};

console.log(Object.hasOwn(user, "name"));
```

Output:

```text
true
```

For a missing property:

```js
console.log(Object.hasOwn(user, "city"));
```

Output:

```text
false
```

---

# 11. Why `Object.hasOwn()` Matters

Consider:

```js
const user = {
    name: "Om"
};
```

You want to know:

> Does this object directly contain `"name"`?

Use:

```js
Object.hasOwn(user, "name");
```

Result:

```text
true
```

It is the modern, straightforward way to perform this check.

---

# 12. Quick Mental Map

```text
Object.fromEntries()
        ↓
Entries → Object

Object.assign()
        ↓
Copy / Merge

Object.freeze()
        ↓
Cannot modify/add/delete

Object.seal()
        ↓
Cannot add/delete
Can modify existing

Object.hasOwn()
        ↓
Does object directly have this property?
```

---

# 13. Hands-on Practice

## Exercise 1 — `fromEntries()`

Convert:

```js
const entries = [
    ["name", "Om"],
    ["age", 22],
    ["city", "Pune"]
];
```

into:

```js
{
    name: "Om",
    age: 22,
    city: "Pune"
}
```

---

## Exercise 2 — Merge

Given:

```js
const user = {
    name: "Om"
};

const details = {
    age: 22
};
```

Merge them using:

```js
Object.assign()
```

---

## Exercise 3 — Spread

Merge the same objects using:

```js
...
```

---

## Exercise 4 — Freeze

Create:

```js
const product = {
    name: "Laptop",
    price: 70000
};
```

Freeze it and attempt to:

1. Change `price`
2. Add `brand`
3. Delete `name`

Observe what happens.

---

## Exercise 5 — Seal

Create:

```js
const user = {
    name: "Om",
    age: 22
};
```

Seal it and test:

1. Change `name`
2. Add `city`
3. Delete `age`

---

## Exercise 6 — `hasOwn()`

Given:

```js
const user = {
    name: "Om",
    age: 22
};
```

Check:

```text
name → ?
email → ?
age → ?
city → ?
```

---

## Exercise 7 — Transformation Challenge

Start with:

```js
const user = {
    name: "Om",
    age: 22,
    city: "Pune"
};
```

Use:

```text
Object.entries()
      ↓
map()
      ↓
Object.fromEntries()
```

Create an object where all values are strings.

Expected:

```js
{
    name: "Om",
    age: "22",
    city: "Pune"
}
```

---

# 14. Mastery Checklist

Before moving to Part 4:

* [ ] I understand `Object.fromEntries()`
* [ ] I understand `Object.assign()`
* [ ] I understand object merging
* [ ] I understand shallow copying
* [ ] I understand `Object.freeze()`
* [ ] I know that freeze is shallow
* [ ] I understand `Object.seal()`
* [ ] I know `freeze()` vs `seal()`
* [ ] I understand `Object.hasOwn()`
* [ ] I can write examples without looking

**Next → Part 4: Real-world Usage + Interview Questions + Hands-on Revision + Mastery Checklist.**
# Object Methods — Part 4: Real-World, Interview & Revision

> **Goal:** Use object methods in practical JavaScript code, recognize common interview patterns, and prove that you can write them yourself.

---

# 1. React Usage

Object methods are frequently used while working with React state and API data.

### Updating an Object

```jsx
const updatedUser = {
    ...user,
    age: 23
};
```

The original object is not directly modified.

---

### Getting Object Keys

```js
const fields = Object.keys(user);

console.log(fields);
```

Useful when you need to dynamically work with object properties.

---

### Rendering Object Data

```jsx
Object.entries(user).map(([key, value]) => (
    <p key={key}>
        {key}: {value}
    </p>
));
```

Flow:

```text
user object
    ↓
Object.entries()
    ↓
[key, value]
    ↓
map()
    ↓
React UI
```

---

# 2. Node.js / Express Usage

Objects are everywhere in Node.js and Express.

### Request Body

```js
const user = req.body;

console.log(Object.keys(user));
```

Useful for inspecting received fields.

---

### Configuration

```js
const defaults = {
    port: 5000,
    host: "localhost"
};

const custom = {
    port: 3000
};

const config = {
    ...defaults,
    ...custom
};

console.log(config);
```

Result:

```js
{
    port: 3000,
    host: "localhost"
}
```

---

### Environment Variables

```js
console.log(Object.keys(process.env));
```

Useful when inspecting available environment configuration.

---

# 3. API Data

Suppose an API returns:

```js
const response = {
    name: "Om",
    age: 22,
    city: "Pune"
};
```

### Get Keys

```js
Object.keys(response);
```

### Get Values

```js
Object.values(response);
```

### Process Key + Value

```js
Object.entries(response).forEach(([key, value]) => {
    console.log(`${key}: ${value}`);
});
```

---

# 4. Transforming API Data

A very useful pattern:

```js
const user = {
    name: "Om",
    age: 22,
    city: "Pune"
};

const result = Object.fromEntries(
    Object.entries(user).map(([key, value]) => {
        return [key, String(value)];
    })
);

console.log(result);
```

Result:

```js
{
    name: "Om",
    age: "22",
    city: "Pune"
}
```

Remember:

```text
Object
   ↓
entries()
   ↓
Array
   ↓
map()
   ↓
Array
   ↓
fromEntries()
   ↓
Object
```

---

# 5. Common Mistakes

## Mistake 1 — Confusing Keys and Values

```js
Object.keys(user);
```

returns:

```text
["name", "age"]
```

while:

```js
Object.values(user);
```

returns:

```text
["Om", 22]
```

---

## Mistake 2 — Thinking `freeze()` Is Deep

```js
Object.freeze(user);
```

does **not automatically freeze nested objects**.

```js
const user = {
    address: {
        city: "Pune"
    }
};

Object.freeze(user);

user.address.city = "Mumbai";
```

The nested object can still be changed.

---

## Mistake 3 — Thinking `seal()` Means Read-Only

Incorrect:

```text
seal() → everything is read-only
```

Correct:

```text
seal()
 ↓
Cannot add
Cannot delete
Can modify existing properties
```

---

## Mistake 4 — Thinking Spread Creates a Deep Copy

```js
const copy = {
    ...user
};
```

This creates a **shallow copy**.

Nested references can still be shared.

---

# 6. Interview Questions

### Q1. What does `Object.keys()` return?

An array containing the object's own enumerable property names.

---

### Q2. What does `Object.values()` return?

An array containing the object's own enumerable property values.

---

### Q3. What does `Object.entries()` return?

An array containing `[key, value]` pairs.

---

### Q4. What does `Object.fromEntries()` do?

It converts key-value pairs into an object.

```js
Object.fromEntries([
    ["name", "Om"]
]);
```

Result:

```js
{
    name: "Om"
}
```

---

### Q5. What is `Object.assign()` used for?

Copying and merging properties from source objects into a target object.

---

### Q6. What is the difference between `freeze()` and `seal()`?

```text
freeze()
→ Cannot modify
→ Cannot add
→ Cannot delete

seal()
→ Can modify existing
→ Cannot add
→ Cannot delete
```

---

### Q7. Is `Object.freeze()` deep?

No.

It freezes the object's own properties, not nested objects automatically.

---

### Q8. What does `Object.hasOwn()` check?

Whether a property belongs directly to the object.

```js
Object.hasOwn(user, "name");
```

---

### Q9. What is the difference between `Object.assign()` and spread?

Both can perform shallow copying and merging.

Modern JavaScript commonly uses:

```js
const result = {
    ...obj1,
    ...obj2
};
```

because it is concise and readable.

---

# 7. Quick Cheat Sheet

```text
Object.keys(obj)
        ↓
["key1", "key2"]

Object.values(obj)
        ↓
["value1", "value2"]

Object.entries(obj)
        ↓
[["key1", "value1"], ...]

Object.fromEntries(entries)
        ↓
Object

Object.assign()
        ↓
Copy / Merge

Object.freeze()
        ↓
No modify / add / delete

Object.seal()
        ↓
Modify existing only

Object.hasOwn()
        ↓
Direct property?
```

---

# 8. Hands-on Practice

**Do not look at the solution while solving.**

Given:

```js
const user = {
    name: "Om",
    age: 22,
    city: "Pune",
    role: "Developer"
};
```

### Exercise 1

Print all keys.

---

### Exercise 2

Print all values.

---

### Exercise 3

Print:

```text
name → Om
age → 22
city → Pune
role → Developer
```

using `Object.entries()`.

---

### Exercise 4

Count the number of properties.

Expected:

```text
4
```

---

### Exercise 5

Check whether the object contains:

```text
email
```

using `Object.hasOwn()`.

Expected:

```text
false
```

---

### Exercise 6

Create:

```js
const account = {
    username: "Om"
};
```

Merge:

```js
const details = {
    age: 22,
    city: "Pune"
};
```

using the spread operator.

---

### Exercise 7

Convert:

```js
[
    ["name", "Om"],
    ["age", 22],
    ["city", "Pune"]
]
```

into an object using `Object.fromEntries()`.

---

### Exercise 8 — Freeze

Create an object and:

1. Freeze it.
2. Try changing a property.
3. Try adding a property.
4. Try deleting a property.

Observe the result.

---

### Exercise 9 — Seal

Create an object and:

1. Seal it.
2. Modify an existing property.
3. Add a new property.
4. Delete a property.

Observe the difference from `freeze()`.

---

### Exercise 10 — Mini Challenge

Given:

```js
const product = {
    name: "Laptop",
    price: 70000,
    stock: 10
};
```

Using object methods:

1. Get all keys.
2. Get all values.
3. Check whether `price` exists.
4. Create an array of entries.
5. Convert the entries back into an object.

---

# 9. Mastery Checklist

Before leaving Object Methods:

* [ ] I understand `Object.keys()`
* [ ] I understand `Object.values()`
* [ ] I understand `Object.entries()`
* [ ] I understand `Object.fromEntries()`
* [ ] I understand `Object.assign()`
* [ ] I understand spread-based object merging
* [ ] I understand `Object.freeze()`
* [ ] I know freeze is shallow
* [ ] I understand `Object.seal()`
* [ ] I know `freeze()` vs `seal()`
* [ ] I understand `Object.hasOwn()`
* [ ] I can use these with API data
* [ ] I can use these with React objects
* [ ] I can write the examples without looking at notes
* [ ] I completed the hands-on exercises

---

# 10. Final Mental Model

```text
                 OBJECT
                    │
        ┌───────────┼───────────┐
        ↓           ↓           ↓
      INSPECT     TRANSFORM    CONTROL
        │           │           │
     keys()      entries()    freeze()
     values()    fromEntries() seal()
     entries()   assign()     hasOwn()
        │
        ↓
   Array Methods
        │
        ↓
   Functional JS
```

### Important

This file gives you the **JavaScript-level understanding**.

Don't keep expanding this file endlessly.

Deep topics such as:

* prototypes
* prototype chain
* inheritance
* object internals
* advanced copying

will be handled in your later **Objects & Prototypes** section.

**Object Methods Part 4 complete. ✅**
