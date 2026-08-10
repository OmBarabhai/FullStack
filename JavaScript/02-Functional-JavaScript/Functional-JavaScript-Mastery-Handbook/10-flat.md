# flat()

# Part 1 – Introduction & Fundamentals

> **"`flat()` is a JavaScript array method that creates a new array by flattening nested arrays into a single array. It removes one or more levels of nesting without modifying the original array."**

---

# Table of Contents

1. Introduction
2. Why `flat()` Was Introduced
3. Syntax
4. Parameters
5. Return Value
6. Internal Working
7. Depth Parameter
8. Visualization
9. Memory Behavior
10. First Examples
11. `flat()` vs `concat()`
12. Best Practices
13. Common Mistakes
14. Interview Questions
15. Coding Exercises
16. Summary

---

# 1. Introduction

Suppose we have an array.

```js
const numbers = [

    [1,2],

    [3,4],

    [5,6]

];
```

Expected Output

```js
[1,2,3,4,5,6]
```

Instead of writing loops,

we use `flat()`.

```js
const numbers = [

    [1,2],

    [3,4],

    [5,6]

];

const result = numbers.flat();

console.log(result);
```

Output

```js
[1,2,3,4,5,6]
```

Notice

`flat()` creates

```js
A New Array
```

---

# 2. Why `flat()` Was Introduced

Before ES2019,

developers used

```js
concat()
```

or loops.

Example

```js
const numbers = [

    [1,2],

    [3,4]

];

const result = [].concat(

    ...numbers

);

console.log(result);
```

Or

```js
let result = [];

for(const arr of numbers){

    result = result.concat(arr);

}
```

Too much code.

---

Using `flat()`

```js
const result = numbers.flat();
```

Cleaner.

---

# 3. Syntax

```js
array.flat()
```

or

```js
array.flat(depth)
```

---

Example

```js
numbers.flat(2);
```

---

# 4. Parameters

| Parameter | Description |
|-----------|-------------|
| depth | How many nesting levels to flatten |

Default

```js
1
```

---

# 5. Return Value

Returns

```
New Flattened Array
```

Original array

```
Does Not Change
```

---

Example

```js
const arr = [

    [1,2],

    [3,4]

];

const result = arr.flat();

console.log(result);

console.log(arr);
```

Output

```js
[1,2,3,4]

[[1,2],[3,4]]
```

---

# 6. Internal Working

Suppose

```js
const arr = [

    [1,2],

    [3,4]

];
```

Execution

```
flat()

↓

Visit First Element

↓

Nested Array?

↓

Yes

↓

Copy Elements

↓

Visit Next

↓

Copy Elements

↓

Return New Array
```

---

# 7. Depth Parameter

Default

```js
flat()
```

means

```js
flat(1)
```

Example

```js
const arr = [

    1,

    [2,[3]]

];

console.log(

    arr.flat()

);
```

Output

```js
[1,2,[3]]
```

Only one level is flattened.

---

Flatten Two Levels

```js
const arr = [

    1,

    [2,[3]]

];

console.log(

    arr.flat(2)

);
```

Output

```js
[1,2,3]
```

---

Flatten Everything

```js
const arr = [

    1,

    [2,[3,[4]]]

];

console.log(

    arr.flat(Infinity)

);
```

Output

```js
[1,2,3,4]
```

---

# 8. Visualization

Original

```
[

1,

[2,

[3]]

]
```

After

```js
flat()
```

```
[

1,

2,

[3]

]
```

---

After

```js
flat(2)
```

```
[

1,

2,

3

]
```

---

# 9. Memory Behavior

Original

```
Memory A

↓

[

[1,2],

[3,4]

]
```

Result

```
Memory B

↓

[1,2,3,4]
```

Unlike

```js
sort()
```

`flat()`

does **not modify** the original array.

---

# 10. First Examples

## Example 1

```js
const arr = [

    [1,2],

    [3,4]

];

console.log(

    arr.flat()

);
```

Output

```js
[1,2,3,4]
```

---

## Example 2

```js
const arr = [

    [1],

    [2],

    [3]

];

console.log(

    arr.flat()

);
```

Output

```js
[1,2,3]
```

---

## Example 3

```js
const arr = [

    1,

    [2,[3]]

];

console.log(

    arr.flat(2)

);
```

Output

```js
[1,2,3]
```

---

# 11. `flat()` vs `concat()`

### `flat()`

```js
const arr = [

    [1,2],

    [3,4]

];

arr.flat();
```

Output

```js
[1,2,3,4]
```

---

### `concat()`

```js
[].concat(

    ...arr

);
```

Output

```js
[1,2,3,4]
```

`flat()` is easier and supports multiple depths.

---

# 12. Best Practices

✅ Use `flat()` for nested arrays.

---

✅ Use `flat(Infinity)` only when necessary.

---

✅ Remember that `flat()` creates a new array.

---

# 13. Common Mistakes

### Expecting Original Array to Change

Wrong

```js
arr.flat();

console.log(arr);
```

Original remains unchanged.

---

### Forgetting Depth

```js
const arr = [

    1,

    [2,[3]]

];

arr.flat();
```

Output

```js
[1,2,[3]]
```

Need

```js
flat(2)
```

---

# 14. Interview Questions

### What does `flat()` do?

---

### Does `flat()` modify the original array?

---

### What is the default depth?

---

### What does `flat(Infinity)` do?

---

### Difference between `flat()` and `concat()`?

---

# 15. Coding Exercises

### Exercise 1

Flatten

```js
[[1],[2],[3]]
```

---

### Exercise 2

Flatten

```js
[1,[2,[3]]]
```

using

```js
flat(2)
```

---

### Exercise 3

Flatten an array completely.

---

### Exercise 4

Predict the output.

```js
const arr = [

    1,

    [2,[3]]

];

console.log(

    arr.flat()

);
```

---

### Exercise 5

Explain why

```js
arr
```

does not change after

```js
flat()
```

---

# 16. Summary

- `flat()` removes nested array levels.
- Default depth is `1`.
- Use `flat(depth)` for deeper nesting.
- Use `flat(Infinity)` to flatten completely.
- `flat()` returns a new array.
- It does not modify the original array.
- It is commonly used when working with nested API responses, React state, and hierarchical data.

---

# Next Part

➡️ **Part 2 – Depth Parameter, Internal Working, Memory & Execution Flow**

You'll learn:

- How `flat()` Works Internally
- Depth Parameter Deep Dive
- Execution Flow
- Dry Runs
- Memory Diagrams
- Callback-Free Nature
- Performance
- Debugging
- Interview Traps

# flat()

# Part 2 – Depth Parameter, Internal Working, Memory & Execution Flow

> **"`flat()` works by visiting each element of an array. If the element is itself an array and the specified depth has not been reached, JavaScript opens that array and copies its elements into a new array. This process continues until the requested depth is reached."**

---

# Table of Contents

1. Internal Working
2. Understanding the Depth Parameter
3. Step-by-Step Execution
4. Dry Runs
5. Memory Visualization
6. Execution Flow
7. `flat()` with Different Depth Values
8. Callback-Free Nature
9. Best Practices
10. Common Mistakes
11. Interview Questions
12. Coding Exercises
13. Summary

---

# 1. Internal Working

Suppose we have

```js
const arr = [

    1,

    [2,3],

    [4,5]

];
```

Execution

```
flat()

↓

Visit First Element

↓

1

↓

Copy

------------

Visit Next

↓

[2,3]

↓

Open Array

↓

Copy 2

↓

Copy 3

------------

Visit Next

↓

[4,5]

↓

Open Array

↓

Copy 4

↓

Copy 5

------------

Return

↓

[1,2,3,4,5]
```

---

# 2. Understanding the Depth Parameter

The depth tells JavaScript

> **How many nested levels should be flattened?**

Syntax

```js
array.flat(depth)
```

Default

```js
flat(1)
```

---

Example

```js
const arr = [

    1,

    [2,[3]]

];

console.log(

    arr.flat()

);
```

Output

```js
[1,2,[3]]
```

Only one nesting level is removed.

---

Using

```js
flat(2)
```

```js
const arr = [

    1,

    [2,[3]]

];

console.log(

    arr.flat(2)

);
```

Output

```js
[1,2,3]
```

---

Using

```js
flat(Infinity)
```

```js
const arr = [

    1,

    [2,[3,[4]]]

];

console.log(

    arr.flat(Infinity)

);
```

Output

```js
[1,2,3,4]
```

---

# 3. Step-by-Step Execution

Example

```js
const arr = [

    1,

    [2,[3]]

];

const result = arr.flat(2);
```

Step 1

```
Take

↓

1

↓

Copy
```

---

Step 2

```
Take

↓

[2,[3]]

↓

Depth Available?

↓

Yes

↓

Open Array
```

---

Step 3

```
Take

↓

2

↓

Copy
```

---

Step 4

```
Take

↓

[3]

↓

Depth Remaining?

↓

Yes

↓

Open
```

---

Step 5

```
Take

↓

3

↓

Copy
```

---

Result

```js
[1,2,3]
```

---

# 4. Dry Runs

## Example 1

```js
const arr = [

    [1,2],

    [3,4]

];

console.log(

    arr.flat()

);
```

Execution

```
[1,2]

↓

Copy

------------

[3,4]

↓

Copy

------------

Return

↓

[1,2,3,4]
```

---

## Example 2

```js
const arr = [

    1,

    [2,[3]]

];

console.log(

    arr.flat()

);
```

Execution

```
1

↓

Copy

------------

[2,[3]]

↓

Open

------------

2

↓

Copy

------------

[3]

↓

Stop

(Default Depth Finished)
```

Output

```js
[1,2,[3]]
```

---

## Example 3

```js
const arr = [

    1,

    [2,[3,[4]]]

];

console.log(

    arr.flat(3)

);
```

Execution

```
1

↓

Copy

------------

2

↓

Copy

------------

3

↓

Copy

------------

4

↓

Copy

------------

Return

↓

[1,2,3,4]
```

---

# 5. Memory Visualization

Original

```
Memory A

↓

[

1,

[2,[3]]

]
```

Result

```
Memory B

↓

[

1,

2,

[3]

]
```

Using

```js
flat(2)
```

Memory

```
Memory B

↓

[

1,

2,

3

]
```

Notice

```
Memory A

↓

Never Changes
```

---

# 6. Execution Flow

```
Array

↓

flat()

↓

Visit Element

↓

Is It An Array?

↓

No

↓

Copy

------------

Yes

↓

Depth Available?

↓

Yes

↓

Open Array

↓

Repeat

------------

No

↓

Copy As It Is

↓

Return New Array
```

---

# 7. `flat()` with Different Depth Values

Original

```js
const arr = [

    1,

    [2,[3,[4]]]

];
```

---

### `flat()`

Equivalent to

```js
flat(1)
```

Output

```js
[1,2,[3,[4]]]
```

---

### `flat(2)`

Output

```js
[1,2,3,[4]]
```

---

### `flat(3)`

Output

```js
[1,2,3,4]
```

---

### `flat(Infinity)`

Output

```js
[1,2,3,4]
```

No matter how deeply nested the array is,

everything is flattened.

---

# 8. Callback-Free Nature

Unlike

```js
map()

filter()

reduce()

find()

some()

every()
```

`flat()`

does **not require a callback function**.

You simply specify the depth.

```js
array.flat(2);
```

There is

- No callback
- No parameters
- No return inside a function

This makes `flat()` one of the simplest array methods.

---

# 9. Best Practices

✅ Use `flat()` when working with nested arrays.

---

✅ Specify the required depth instead of always using `Infinity`.

---

✅ Remember that `flat()` creates a new array.

---

✅ Use `flat(Infinity)` only if the nesting depth is unknown.

---

# 10. Common Mistakes

### Expecting Original Array to Change

Wrong

```js
arr.flat();

console.log(arr);
```

Output

Original array remains unchanged.

---

### Using Wrong Depth

```js
const arr = [

    1,

    [2,[3]]

];

arr.flat();
```

Output

```js
[1,2,[3]]
```

Need

```js
flat(2)
```

for a completely flat result.

---

### Assuming `flat()` Works on Objects

Wrong

```js
const users = [

    {

        name:"Om"

    }

];

users.flat();
```

`flat()` only flattens nested **arrays**, not objects.

---

# 11. Interview Questions

### What is the default depth of `flat()`?

---

### Does `flat()` modify the original array?

---

### What does `flat(Infinity)` do?

---

### Does `flat()` require a callback?

---

### Can `flat()` flatten objects?

---

### Difference between `flat()` and `concat()`?

---

# 12. Coding Exercises

### Exercise 1

Flatten

```js
[[1],[2],[3]]
```

---

### Exercise 2

Flatten

```js
[1,[2,[3]]]
```

using

```js
flat(2)
```

---

### Exercise 3

Flatten

```js
[1,[2,[3,[4]]]]
```

completely.

---

### Exercise 4

Predict the output.

```js
const arr = [

    1,

    [2,[3]]

];

console.log(

    arr.flat(1)

);
```

---

### Exercise 5

Explain why this output still contains a nested array.

```js
const arr = [

    1,

    [2,[3]]

];

console.log(

    arr.flat()

);
```

---

# 13. Summary

- `flat()` visits each element of an array.
- If an element is another array and depth allows, it opens that array.
- The default depth is `1`.
- `flat(Infinity)` removes every level of nesting.
- `flat()` creates a new array and leaves the original array unchanged.
- Unlike many array methods, `flat()` does **not** use a callback function.

---

# Next Part

➡️ **Part 3 – flat() with Nested Arrays, Real-World Examples, React & Node.js**

You'll learn:

- Deeply Nested Arrays
- Flattening API Responses
- Flattening Categories
- React Examples
- Node.js Examples
- Chaining with `flat()`
- `flat()` + `map()`
- `flat()` + `filter()`
- Real-world Interview Problems

# flat()

# Part 3 – `flat()` with Nested Arrays, Real-World Examples, React & Node.js

> **"`flat()` is commonly used when working with nested API responses, database queries, category trees, comments, file systems, shopping carts, and React applications. It helps convert nested arrays into a simpler structure that is easier to process."**

---

# Table of Contents

1. Flattening Nested Arrays
2. Flattening Multi-Level Arrays
3. Chaining with `flat()`
4. `flat()` + `map()`
5. `flat()` + `filter()`
6. Real-World Examples
7. React Examples
8. Node.js Examples
9. Best Practices
10. Common Mistakes
11. Interview Questions
12. Coding Exercises
13. Summary

---

# 1. Flattening Nested Arrays

Example

```js
const numbers = [

    [1,2],

    [3,4],

    [5,6]

];

const result = numbers.flat();

console.log(result);
```

Output

```js
[1,2,3,4,5,6]
```

Execution

```
[1,2]

↓

Copy

------------

[3,4]

↓

Copy

------------

[5,6]

↓

Copy

------------

Result

↓

[1,2,3,4,5,6]
```

---

# 2. Flattening Multi-Level Arrays

Example

```js
const numbers = [

    1,

    [

        2,

        [

            3,

            [

                4

            ]

        ]

    ]

];

console.log(

    numbers.flat(3)

);
```

Output

```js
[1,2,3,4]
```

---

Using

```js
flat(Infinity)
```

```js
console.log(

    numbers.flat(Infinity)

);
```

Output

```js
[1,2,3,4]
```

---

# 3. Chaining with `flat()`

Example

```js
const numbers = [

    [1,2],

    [3,4]

];

const result = numbers

.flat()

.map(

    num=>num*2

);

console.log(result);
```

Output

```js
[2,4,6,8]
```

Execution

```
Nested Array

↓

flat()

↓

[1,2,3,4]

↓

map()

↓

[2,4,6,8]
```

---

# 4. `flat()` + `map()`

Suppose

```js
const students = [

    [

        {

            name:"Om"

        },

        {

            name:"Raj"

        }

    ],

    [

        {

            name:"Amit"

        }

    ]

];
```

Extract names

```js
const names = students

.flat()

.map(

    student=>student.name

);

console.log(names);
```

Output

```js
["Om","Raj","Amit"]
```

---

# 5. `flat()` + `filter()`

Example

```js
const numbers = [

    [1,2],

    [3,4],

    [5,6]

];

const evenNumbers = numbers

.flat()

.filter(

    num=>num%2===0

);

console.log(evenNumbers);
```

Output

```js
[2,4,6]
```

Execution

```
Nested Arrays

↓

flat()

↓

[1,2,3,4,5,6]

↓

filter()

↓

Even Numbers
```

---

# 6. Real-World Examples

## Shopping Categories

```js
const categories = [

    [

        "Laptop",

        "Keyboard"

    ],

    [

        "Mouse",

        "Monitor"

    ]

];

const products = categories.flat();

console.log(products);
```

Output

```js
["Laptop","Keyboard","Mouse","Monitor"]
```

---

## API Response

```js
const response = [

    {

        users:[

            "Om",

            "Raj"

        ]

    },

    {

        users:[

            "Amit"

        ]

    }

];

const users = response

.map(

    item=>item.users

)

.flat();

console.log(users);
```

Output

```js
["Om","Raj","Amit"]
```

---

## Student Marks

```js
const marks = [

    [80,90],

    [70,60],

    [95]

];

const allMarks = marks.flat();

console.log(allMarks);
```

Output

```js
[80,90,70,60,95]
```

---

## Comments

```js
const comments = [

    [

        "Good"

    ],

    [

        "Nice",

        "Awesome"

    ]

];

console.log(

    comments.flat()

);
```

Output

```js
["Good","Nice","Awesome"]
```

---

# 7. React Examples

Suppose

```jsx
const categories = [

    {

        products:[

            "Laptop",

            "Mouse"

        ]

    },

    {

        products:[

            "Keyboard"

        ]

    }

];
```

Flatten products

```jsx
const products = categories

.map(

    category=>category.products

)

.flat();
```

Result

```jsx
["Laptop","Mouse","Keyboard"]
```

---

Rendering

```jsx
products.map(

    product=>

    <li>

        {product}

    </li>

);
```

---

# 8. Node.js Examples

## API Aggregation

```js
const servers = [

    {

        logs:[

            "Log1",

            "Log2"

        ]

    },

    {

        logs:[

            "Log3"

        ]

    }

];

const logs = servers

.map(

    server=>server.logs

)

.flat();

console.log(logs);
```

Output

```js
["Log1","Log2","Log3"]
```

---

## Database Query

```js
const orders = [

    {

        products:[

            "Laptop",

            "Mouse"

        ]

    },

    {

        products:[

            "Keyboard"

        ]

    }

];

const products = orders

.map(

    order=>order.products

)

.flat();

console.log(products);
```

Output

```js
["Laptop","Mouse","Keyboard"]
```

---

# 9. Best Practices

✅ Use `flat()` only when arrays are nested.

---

✅ Prefer the smallest required depth.

---

✅ Use `flat(Infinity)` only when the nesting level is unknown.

---

✅ Combine `flat()` with `map()` or `filter()` for cleaner code.

---

# 10. Common Mistakes

### Expecting Objects to Flatten

Wrong

```js
const users = [

    {

        name:"Om"

    }

];

users.flat();
```

Output

Objects remain unchanged because they are not arrays.

---

### Forgetting to Use `map()`

Wrong

```js
response.flat();
```

If the nested arrays are inside objects,

extract them first.

Correct

```js
response

.map(

    item=>item.users

)

.flat();
```

---

### Using `flat()` Unnecessarily

Wrong

```js
const arr = [1,2,3];

arr.flat();
```

No effect because the array is already flat.

---

# 11. Interview Questions

### When should `flat()` be used?

---

### Can `flat()` flatten objects?

---

### Difference between `flat()` and `concat()`?

---

### Can `flat()` be chained with `map()`?

---

### Can `flat()` be chained with `filter()`?

---

### What does `flat(Infinity)` do?

---

# 12. Coding Exercises

### Exercise 1

Flatten

```js
[[1,2],[3,4]]
```

---

### Exercise 2

Flatten

```js
[1,[2,[3,[4]]]]
```

using

```js
flat(Infinity)
```

---

### Exercise 3

Flatten an array and multiply every number by 10.

---

### Exercise 4

Flatten an array and keep only odd numbers.

---

### Exercise 5

Extract all product names from nested API data.

---

### Exercise 6

Flatten nested student names and sort them alphabetically.

---

# 13. Summary

- `flat()` is useful for nested arrays returned by APIs and databases.
- It is commonly chained with `map()` and `filter()`.
- It simplifies hierarchical data into a single array.
- `flat()` returns a new array without modifying the original.
- It is frequently used in React components, Node.js backends, dashboards, analytics systems, and interview questions involving nested arrays.

---

# Next Part

➡️ **Part 4 – Advanced `flat()`, Performance, Memory, Interview Mastery & Debugging**

You'll learn:

- Performance Analysis
- Memory Behavior
- `flat()` vs `flatMap()`
- `flat()` vs `concat()`
- Debugging
- Predict the Output
- Interview Traps
- Advanced Coding Exercises
- Quick Revision Sheet
- Complete Interview Revision

# flat()

# Part 4 – Advanced `flat()`, Performance, Memory, Interview Mastery & Debugging

> **"`flat()` is simple to use but important to understand deeply. Interviewers often ask about its performance, memory usage, differences from `flatMap()`, and when it should or should not be used."**

---

# Table of Contents

1. Advanced Usage
2. Performance Analysis
3. Memory Behavior
4. `flat()` vs Other Methods
5. Debugging `flat()`
6. Predict the Output
7. Interview Traps
8. Best Practices
9. Common Mistakes
10. Interview Questions
11. Coding Exercises
12. Quick Revision Sheet
13. Summary

---

# 1. Advanced Usage

## Flatten Unknown Nested Levels

```js
const numbers = [

    1,

    [

        2,

        [

            3,

            [

                4,

                [

                    5

                ]

            ]

        ]

    ]

];

const result = numbers.flat(Infinity);

console.log(result);
```

Output

```js
[1,2,3,4,5]
```

---

## Flatten Nested API Results

```js
const users = [

    {

        friends:[

            "Raj",

            "Amit"

        ]

    },

    {

        friends:[

            "Priya",

            "Neha"

        ]

    }

];

const allFriends = users

.map(

    user=>user.friends

)

.flat();

console.log(allFriends);
```

Output

```js
["Raj","Amit","Priya","Neha"]
```

---

# 2. Performance Analysis

Time Complexity

```
O(n)
```

where

```
n

↓

Total Elements Visited
```

Every element is visited once.

---

Space Complexity

```
O(n)
```

Because

```
flat()

↓

Creates

↓

New Array
```

---

Comparison

| Method | Time | Space |
|----------|------|--------|
| map() | O(n) | O(n) |
| filter() | O(n) | O(n) |
| reduce() | O(n) | Depends |
| flat() | O(n) | O(n) |
| sort() | O(n log n) | Engine Dependent |

---

# 3. Memory Behavior

Original

```
Memory A

↓

[

[1,2],

[3,4]

]
```

After

```js
flat()
```

```
Memory B

↓

[1,2,3,4]
```

Original

```
Memory A

↓

Never Changes
```

Unlike

```js
sort()
```

which modifies the same array.

---

# 4. `flat()` vs Other Methods

| Method | Purpose | Returns |
|---------|----------|----------|
| `flat()` | Flatten nested arrays | New Array |
| `flatMap()` | Map then flatten | New Array |
| `concat()` | Merge arrays | New Array |
| `map()` | Transform | New Array |
| `filter()` | Select | New Array |

---

## `flat()` vs `flatMap()`

### `flat()`

```js
const arr = [

    [1,2],

    [3,4]

];

console.log(

    arr.flat()

);
```

Output

```js
[1,2,3,4]
```

---

### `flatMap()`

```js
const numbers = [

    1,

    2,

    3

];

const result = numbers.flatMap(

    num=>[

        num,

        num*2

    ]

);

console.log(result);
```

Output

```js
[1,2,2,4,3,6]
```

Think of it as

```
map()

↓

flat()
```

combined into one step.

---

## `flat()` vs `concat()`

### `concat()`

```js
const arr1 = [1,2];

const arr2 = [3,4];

console.log(

    arr1.concat(arr2)

);
```

Output

```js
[1,2,3,4]
```

---

### `flat()`

```js
const arr = [

    [1,2],

    [3,4]

];

console.log(

    arr.flat()

);
```

Output

```js
[1,2,3,4]
```

Difference

- `concat()` merges arrays.
- `flat()` removes nesting.

---

# 5. Debugging `flat()`

Wrong

```js
const arr = [

    1,

    [2,[3]]

];

console.log(

    arr.flat()

);
```

Expected

```js
[1,2,3]
```

Actual

```js
[1,2,[3]]
```

Reason

```
Default Depth

↓

1
```

---

Correct

```js
arr.flat(2);
```

---

Another Example

Wrong

```js
const arr = [

    {

        name:"Om"

    }

];

arr.flat();
```

Output

```js
[

    {

        name:"Om"

    }

]
```

Reason

Objects are not arrays.

---

# 6. Predict the Output

### Example 1

```js
const arr = [

    [1],

    [2],

    [3]

];

console.log(

    arr.flat()

);
```

Output

```js
[1,2,3]
```

---

### Example 2

```js
const arr = [

    1,

    [2,[3]]

];

console.log(

    arr.flat()

);
```

Output

```js
[1,2,[3]]
```

---

### Example 3

```js
const arr = [

    1,

    [2,[3]]

];

console.log(

    arr.flat(2)

);
```

Output

```js
[1,2,3]
```

---

### Example 4

```js
const arr = [

    [

        [

            1

        ]

    ]

];

console.log(

    arr.flat(Infinity)

);
```

Output

```js
[1]
```

---

# 7. Interview Traps

### Trap 1

Does `flat()` modify the original array?

```
No
```

---

### Trap 2

What is the default depth?

```
1
```

---

### Trap 3

Can `flat()` flatten objects?

```
No
```

Only nested arrays.

---

### Trap 4

Can `flat()` flatten arrays of any depth?

```
Yes

Using

flat(Infinity)
```

---

### Trap 5

Does `flat()` require a callback?

```
No
```

---

# 8. Best Practices

✅ Use `flat()` only when arrays are nested.

---

✅ Prefer the smallest required depth.

---

✅ Use `flat(Infinity)` only when nesting is unknown.

---

✅ Chain with `map()` and `filter()` when processing nested data.

---

# 9. Common Mistakes

### Forgetting Depth

Wrong

```js
flat()
```

when

```js
flat(2)
```

is needed.

---

### Expecting Original Array to Change

Wrong

```js
arr.flat();

console.log(arr);
```

Original remains unchanged.

---

### Using `flat()` on Objects

Wrong

```js
users.flat();
```

Objects are not flattened.

---

### Using `flat()` on an Already Flat Array

```js
[1,2,3].flat();
```

No effect.

---

# 10. Interview Questions

### What does `flat()` return?

---

### Does `flat()` modify the original array?

---

### What is the default depth?

---

### Difference between `flat()` and `flatMap()`?

---

### Difference between `flat()` and `concat()`?

---

### What does `flat(Infinity)` do?

---

### Time Complexity of `flat()`?

---

# 11. Coding Exercises

### Exercise 1

Flatten

```js
[[1],[2],[3]]
```

---

### Exercise 2

Flatten

```js
[1,[2,[3,[4]]]]
```

using

```js
flat(Infinity)
```

---

### Exercise 3

Flatten an array and multiply every number by 5.

---

### Exercise 4

Flatten an array and keep only even numbers.

---

### Exercise 5

Extract all usernames from nested API data.

---

### Exercise 6

Flatten product categories and sort them alphabetically.

---

### Exercise 7

Explain why this output still contains nested arrays.

```js
const arr = [

    1,

    [2,[3]]

];

console.log(

    arr.flat()

);
```

---

# 12. Quick Revision Sheet

```
flat()

↓

Visit Element

↓

Is It An Array?

↓

No

↓

Copy

------------

Yes

↓

Depth Remaining?

↓

Yes

↓

Open Array

↓

Repeat

↓

Return New Array
```

Remember

```
Transform

↓

map()

Select

↓

filter()

Find

↓

find()

Combine

↓

reduce()

Sort

↓

sort()

Flatten

↓

flat()

Map + Flatten

↓

flatMap()
```

---

# 13. Summary

- `flat()` removes nested array levels.
- Default depth is **1**.
- `flat(Infinity)` removes all nesting.
- `flat()` returns a **new array** and never modifies the original.
- Time Complexity is **O(n)**.
- Space Complexity is **O(n)**.
- It is widely used with nested API responses, database queries, React state, dashboards, analytics, and interview questions.
- `flat()` is often combined with `map()`, `filter()`, and `flatMap()` for clean and readable code.

---

# Chapter Complete ✅

You now understand:

- ✔ What `flat()` is
- ✔ Depth Parameter
- ✔ Internal Working
- ✔ Memory Behavior
- ✔ Performance Analysis
- ✔ `flat()` vs `concat()`
- ✔ `flat()` vs `flatMap()`
- ✔ React Usage
- ✔ Node.js Usage
- ✔ Interview Questions
- ✔ Common Mistakes
- ✔ Best Practices
- ✔ Coding Exercises

---

# What's Next?

➡️ **11-flatMap().md**

You'll master:

- What `flatMap()` is
- Why it was introduced
- `map()` + `flat()` relationship
- Internal Working
- Callback Function
- Performance
- Real-world Examples
- React Examples
- Node.js Examples
- Interview Questions
- Advanced Coding Problems