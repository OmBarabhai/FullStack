# Interview Patterns

# Part 1 – Introduction & Pattern Recognition

> **"The biggest mistake beginners make is memorizing array methods instead of recognizing patterns. In interviews, you are rarely asked 'Use map()'. Instead, you're given a problem, and you must identify the correct pattern. This chapter teaches you how to think like an interviewer."**

---

# Table of Contents

1. What Are Interview Patterns?
2. Why Pattern Recognition Matters
3. How to Identify the Correct Method
4. Decision Tree
5. The 12 Core Patterns
6. Pattern Recognition Examples
7. Visualization
8. Best Practices
9. Common Mistakes
10. Interview Questions
11. Coding Exercises
12. Summary

---

# 1. What Are Interview Patterns?

An interview pattern is simply

```
Problem

↓

Recognize Pattern

↓

Choose Method

↓

Solve
```

Example

Question

```
Return only even numbers.
```

Pattern

```
Selection
```

Method

```js
filter()
```

---

Question

```
Double every number.
```

Pattern

```
Transformation
```

Method

```js
map()
```

---

Question

```
Find the first user older than 18.
```

Pattern

```
Searching
```

Method

```js
find()
```

---

# 2. Why Pattern Recognition Matters

Instead of remembering

```
map()

filter()

reduce()

find()

some()

every()
```

remember

```
Problem

↓

Pattern

↓

Method
```

Professional developers think this way.

---

# 3. How to Identify the Correct Method

Ask yourself these questions.

---

## Question 1

Do I need every element?

```
Yes

↓

map()
```

---

## Question 2

Do I need only some elements?

```
Yes

↓

filter()
```

---

## Question 3

Do I need only the first matching element?

```
Yes

↓

find()
```

---

## Question 4

Do I need the index?

```
Yes

↓

findIndex()
```

---

## Question 5

Do I need a single value?

```
Yes

↓

reduce()
```

---

## Question 6

Do I need true or false?

```
At least one?

↓

some()

------------

All?

↓

every()
```

---

## Question 7

Do I need to flatten nested arrays?

```
Yes

↓

flat()

------------

Need transform too?

↓

flatMap()
```

---

## Question 8

Do I only want to perform an action?

```
Yes

↓

forEach()
```

---

## Question 9

Do I need sorting?

```
Yes

↓

sort()
```

---

# 4. Decision Tree

```
Problem

↓

Need New Array?

↓

Yes

↓

Need Every Element?

↓

map()

------------

Need Selected Elements?

↓

filter()

------------

Need Flatten?

↓

flat()

------------

Need Transform + Flatten?

↓

flatMap()

------------

Need Sorted Data?

↓

sort()

------------

Need One Element?

↓

find()

------------

Need Index?

↓

findIndex()

------------

Need Boolean?

↓

some()

every()

------------

Need Single Value?

↓

reduce()

------------

Need Side Effect?

↓

forEach()
```

---

# 5. The 12 Core Patterns

| Pattern | Method |
|----------|---------|
| Transform | map() |
| Select | filter() |
| Find First | find() |
| Find Index | findIndex() |
| Check Any | some() |
| Check All | every() |
| Combine | reduce() |
| Flatten | flat() |
| Transform + Flatten | flatMap() |
| Iterate | forEach() |
| Sort | sort() |
| Chain Multiple Operations | Method Chaining |

---

# 6. Pattern Recognition Examples

---

## Pattern 1

Question

```
Increase every salary by 20%.
```

Pattern

```
Transformation
```

Method

```js
map()
```

---

## Pattern 2

Question

```
Return only active users.
```

Pattern

```
Selection
```

Method

```js
filter()
```

---

## Pattern 3

Question

```
Find first failed student.
```

Pattern

```
Searching
```

Method

```js
find()
```

---

## Pattern 4

Question

```
Calculate total salary.
```

Pattern

```
Aggregation
```

Method

```js
reduce()
```

---

## Pattern 5

Question

```
Does any user have admin access?
```

Pattern

```
Boolean Check
```

Method

```js
some()
```

---

## Pattern 6

Question

```
Are all users verified?
```

Pattern

```
Validation
```

Method

```js
every()
```

---

## Pattern 7

Question

```
Flatten product categories.
```

Pattern

```
Flattening
```

Method

```js
flat()
```

---

## Pattern 8

Question

```
Extract all employee skills.
```

Pattern

```
Transform + Flatten
```

Method

```js
flatMap()
```

---

## Pattern 9

Question

```
Sort products by price.
```

Pattern

```
Ordering
```

Method

```js
sort()
```

---

## Pattern 10

Question

```
Print all usernames.
```

Pattern

```
Iteration
```

Method

```js
forEach()
```

---

# 7. Visualization

```
Interview Question

↓

Understand Requirement

↓

Identify Pattern

↓

Choose Method

↓

Write Code

↓

Done
```

---

# 8. Best Practices

✅ Read the problem completely.

---

✅ Identify the pattern before writing code.

---

✅ Prefer built-in array methods.

---

✅ Choose the simplest method.

---

# 9. Common Mistakes

### Using `map()` instead of `filter()`

Wrong

```
Need Selection

↓

map()
```

---

### Using `forEach()` instead of `map()`

Wrong

```
Need New Array

↓

forEach()
```

---

### Using `reduce()` unnecessarily

Sometimes

```js
map()

↓

filter()
```

is much simpler.

---

# 10. Interview Questions

### Which method creates a new transformed array?

---

### Which method selects elements?

---

### Which method returns only one element?

---

### Which method returns a Boolean?

---

### Which method combines values?

---

### Which method is used for flattening?

---

# 11. Coding Exercises

### Exercise 1

Identify the pattern.

```
Return names of active users.
```

---

### Exercise 2

Identify the pattern.

```
Calculate total revenue.
```

---

### Exercise 3

Identify the pattern.

```
Sort employees by salary.
```

---

### Exercise 4

Identify the pattern.

```
Check if every product is in stock.
```

---

### Exercise 5

Identify the pattern.

```
Flatten nested categories.
```

---

# 12. Summary

- Interviews test pattern recognition more than syntax.
- Always identify the problem before choosing a method.
- Each array method solves a specific category of problems.
- Learning patterns makes solving unseen questions much easier.
- This approach is used by experienced JavaScript developers in real-world projects.

---
# Interview Patterns

# Part 2 – Top 50 JavaScript Array Interview Patterns (Beginner → Intermediate)

> **"Most JavaScript interview questions are not completely unique. They usually belong to a small set of recurring patterns. Once you recognize the pattern, choosing the correct array method becomes straightforward."**

---

# Table of Contents

1. Transformation Pattern
2. Selection Pattern
3. Searching Pattern
4. Validation Pattern
5. Aggregation Pattern
6. Sorting Pattern
7. Flattening Pattern
8. Chaining Pattern
9. Pattern Cheat Sheet
10. Summary

---

# 1. Transformation Pattern

## Pattern

```
Take Every Element

↓

Transform It

↓

Return New Array
```

Method

```js
map()
```

---

### Interview Question 1

Increase every salary by 10%.

```js
employees.map(

    employee=>({

        ...employee,

        salary: employee.salary * 1.1

    })

);
```

---

### Interview Question 2

Convert every name to uppercase.

```js
names.map(

    name=>name.toUpperCase()

);
```

---

### Interview Question 3

Return only product names.

```js
products.map(

    product=>product.name

);
```

---

### Interview Question 4

Square every number.

```js
numbers.map(

    num=>num*num

);
```

---

### Interview Question 5

Convert prices to dollars.

```js
prices.map(

    price=>price/83

);
```

---

# 2. Selection Pattern

## Pattern

```
Keep Only Matching Elements

↓

Discard Others
```

Method

```js
filter()
```

---

### Interview Question 6

Return active users.

```js
users.filter(

    user=>user.active

);
```

---

### Interview Question 7

Return even numbers.

```js
numbers.filter(

    num=>num%2===0

);
```

---

### Interview Question 8

Products costing more than ₹1000.

```js
products.filter(

    product=>product.price>1000

);
```

---

### Interview Question 9

Students scoring above 80.

```js
students.filter(

    student=>student.score>80

);
```

---

### Interview Question 10

Verified users only.

```js
users.filter(

    user=>user.verified

);
```

---

# 3. Searching Pattern

## Pattern

```
Need

↓

First Match
```

Method

```js
find()
```

---

### Interview Question 11

Find first failed student.

```js
students.find(

    student=>student.score<35

);
```

---

### Interview Question 12

Find first admin.

```js
users.find(

    user=>user.role==="Admin"

);
```

---

### Interview Question 13

Find first expensive product.

```js
products.find(

    product=>product.price>10000

);
```

---

### Interview Question 14

Find first even number.

```js
numbers.find(

    num=>num%2===0

);
```

---

### Interview Question 15

Find first verified user.

```js
users.find(

    user=>user.verified

);
```

---

# 4. Validation Pattern

## Pattern

```
Need Boolean

↓

Yes / No
```

Methods

```js
some()

every()
```

---

### Interview Question 16

Any admin?

```js
users.some(

    user=>user.role==="Admin"

);
```

---

### Interview Question 17

Any failed student?

```js
students.some(

    student=>student.score<35

);
```

---

### Interview Question 18

All verified?

```js
users.every(

    user=>user.verified

);
```

---

### Interview Question 19

All products in stock?

```js
products.every(

    product=>product.stock>0

);
```

---

### Interview Question 20

All numbers positive?

```js
numbers.every(

    num=>num>0

);
```

---

# 5. Aggregation Pattern

## Pattern

```
Many Values

↓

One Value
```

Method

```js
reduce()
```

---

### Interview Question 21

Calculate total salary.

```js
employees.reduce(

    (sum,employee)=>sum+employee.salary,

    0

);
```

---

### Interview Question 22

Total cart price.

```js
cart.reduce(

    (sum,item)=>sum+item.price,

    0

);
```

---

### Interview Question 23

Count users.

```js
users.reduce(

    count=>count+1,

    0

);
```

---

### Interview Question 24

Maximum number.

```js
numbers.reduce(

    (max,num)=>

        Math.max(max,num)

);
```

---

### Interview Question 25

Minimum number.

```js
numbers.reduce(

    (min,num)=>

        Math.min(min,num)

);
```

---

# 6. Sorting Pattern

## Pattern

```
Need Ordered Data
```

Method

```js
sort()
```

---

### Interview Question 26

Sort numbers.

```js
numbers.sort(

    (a,b)=>a-b

);
```

---

### Interview Question 27

Sort descending.

```js
numbers.sort(

    (a,b)=>b-a

);
```

---

### Interview Question 28

Sort products by price.

```js
products.sort(

    (a,b)=>a.price-b.price

);
```

---

### Interview Question 29

Sort users by age.

```js
users.sort(

    (a,b)=>a.age-b.age

);
```

---

### Interview Question 30

Sort alphabetically.

```js
names.sort();
```

---

# 7. Flattening Pattern

## Pattern

```
Nested Arrays

↓

Single Array
```

Methods

```js
flat()

flatMap()
```

---

### Interview Question 31

Flatten numbers.

```js
numbers.flat();
```

---

### Interview Question 32

Flatten categories.

```js
categories.flat();
```

---

### Interview Question 33

Extract all skills.

```js
employees.flatMap(

    employee=>employee.skills

);
```

---

### Interview Question 34

Flatten comments.

```js
posts.flatMap(

    post=>post.comments

);
```

---

### Interview Question 35

Flatten orders.

```js
orders.flatMap(

    order=>order.products

);
```

---

# 8. Chaining Pattern

## Pattern

```
Multiple Operations
```

---

### Interview Question 36

Filter → Map

```js
products

.filter(

    product=>product.stock

)

.map(

    product=>product.name

);
```

---

### Interview Question 37

Filter → Reduce

```js
orders

.filter(

    order=>order.completed

)

.reduce(

    (sum,order)=>sum+order.total,

    0

);
```

---

### Interview Question 38

Filter → Map → Reduce

```js
employees

.filter(

    employee=>employee.active

)

.map(

    employee=>employee.salary

)

.reduce(

    (sum,salary)=>sum+salary,

    0

);
```

---

### Interview Question 39

FlatMap → Sort

```js
users

.flatMap(

    user=>user.skills

)

.sort();
```

---

### Interview Question 40

Filter → FlatMap

```js
departments

.filter(

    department=>department.active

)

.flatMap(

    department=>department.employees

);
```

---

# Bonus Interview Patterns

### Interview Question 41

Find index of first match.

```js
findIndex()
```

---

### Interview Question 42

Remove duplicates.

```js
[...new Set(array)]
```

---

### Interview Question 43

Reverse order.

```js
toReversed()
```

---

### Interview Question 44

Immutable sorting.

```js
toSorted()
```

---

### Interview Question 45

Immutable splice.

```js
toSpliced()
```

---

### Interview Question 46

Array to object.

```js
reduce()
```

---

### Interview Question 47

Frequency Counter.

```js
reduce()
```

---

### Interview Question 48

Group Data.

```js
reduce()
```

---

### Interview Question 49

Extract Unique Values.

```js
Set

+

Array.from()
```

---

### Interview Question 50

Pipeline Processing.

```js
filter()

↓

map()

↓

reduce()
```

---

# 9. Pattern Cheat Sheet

| Requirement | Method |
|-------------|---------|
| Transform Data | `map()` |
| Filter Data | `filter()` |
| Find First Match | `find()` |
| Find Index | `findIndex()` |
| Check Any | `some()` |
| Check All | `every()` |
| Total / Sum | `reduce()` |
| Sort | `sort()` |
| Flatten | `flat()` |
| Transform + Flatten | `flatMap()` |
| Iterate | `forEach()` |
| Multiple Steps | Method Chaining |

---

# 10. Summary

You now know the **50 most common beginner-to-intermediate JavaScript interview patterns**.

Instead of memorizing syntax, remember:

```
Question

↓

Identify Pattern

↓

Choose Method

↓

Write Solution
```

This approach is used in JavaScript interviews at startups, product-based companies, and large tech companies.

---
# Real World Patterns

# Part 3 – Advanced Interview Patterns (FAANG/MAANG Level)

> **"Senior JavaScript interviews rarely test whether you know `map()` or `filter()`. Instead, they evaluate your ability to recognize data transformation patterns, optimize solutions, and write clean, scalable code using JavaScript array methods."**

---

# Table of Contents

1. Nested Object Pattern
2. Frequency Counter Pattern
3. Grouping Pattern
4. Lookup Table Pattern
5. Data Transformation Pattern
6. Multi-Level Method Chaining
7. Deduplication Pattern
8. Partition Pattern
9. Aggregation Pattern
10. Real Interview Problems
11. Pattern Recognition Table
12. Summary

---

# 1. Nested Object Pattern

## Problem

Extract all employees from nested departments.

```js
const departments = [
  {
    name: "IT",
    employees: [
      { name: "Om" },
      { name: "Raj" }
    ]
  },
  {
    name: "HR",
    employees: [
      { name: "Amit" }
    ]
  }
];
```

Solution

```js
const employees = departments.flatMap(
  department => department.employees
);

console.log(employees);
```

Output

```js
[
  { name: "Om" },
  { name: "Raj" },
  { name: "Amit" }
]
```

Execution

```
Departments

↓

flatMap()

↓

Employees
```

---

# 2. Frequency Counter Pattern

One of the most common interview patterns.

Problem

Count the occurrence of each fruit.

```js
const fruits = [
  "apple",
  "banana",
  "apple",
  "orange",
  "banana",
  "apple"
];
```

Solution

```js
const frequency = fruits.reduce((acc, fruit) => {

  acc[fruit] = (acc[fruit] || 0) + 1;

  return acc;

}, {});

console.log(frequency);
```

Output

```js
{
  apple:3,
  banana:2,
  orange:1
}
```

---

# 3. Grouping Pattern

Group employees by department.

```js
const employees = [
  { name:"Om", dept:"IT" },
  { name:"Raj", dept:"HR" },
  { name:"Amit", dept:"IT" }
];
```

Solution

```js
const grouped = employees.reduce((acc, employee) => {

  if (!acc[employee.dept]) {
    acc[employee.dept] = [];
  }

  acc[employee.dept].push(employee);

  return acc;

}, {});

console.log(grouped);
```

Output

```js
{
  IT:[...],
  HR:[...]
}
```

---

# 4. Lookup Table Pattern

Convert an array into an object.

```js
const users = [
  { id:1, name:"Om" },
  { id:2, name:"Raj" }
];
```

Solution

```js
const lookup = users.reduce((acc, user) => {

  acc[user.id] = user;

  return acc;

}, {});

console.log(lookup);
```

Output

```js
{
  1:{...},
  2:{...}
}
```

---

# 5. Data Transformation Pattern

Keep only required properties.

```js
const users = [
  {
    id:1,
    name:"Om",
    salary:50000,
    city:"Pune"
  },
  {
    id:2,
    name:"Raj",
    salary:70000,
    city:"Mumbai"
  }
];
```

Solution

```js
const result = users.map(({id,name}) => ({
  id,
  name
}));

console.log(result);
```

Output

```js
[
  { id:1, name:"Om" },
  { id:2, name:"Raj" }
]
```

---

# 6. Multi-Level Method Chaining

Return names of active employees sorted by salary.

```js
const result = employees

.filter(employee => employee.active)

.sort((a,b) => a.salary - b.salary)

.map(employee => employee.name);
```

Execution

```
Employees

↓

filter()

↓

sort()

↓

map()

↓

Names
```

---

# 7. Deduplication Pattern

Remove duplicate values.

```js
const numbers = [1,2,2,3,4,4,5];
```

Solution

```js
const unique = [...new Set(numbers)];

console.log(unique);
```

Output

```js
[1,2,3,4,5]
```

---

# 8. Partition Pattern

Separate passed and failed students.

```js
const students = [
  { name:"Om", score:90 },
  { name:"Raj", score:30 },
  { name:"Amit", score:80 }
];
```

Solution

```js
const result = students.reduce((acc, student) => {

  if(student.score >= 35){

    acc.passed.push(student);

  }else{

    acc.failed.push(student);

  }

  return acc;

},{
  passed:[],
  failed:[]
});

console.log(result);
```

Output

```js
{
  passed:[...],
  failed:[...]
}
```

---

# 9. Aggregation Pattern

Find highest salary.

```js
const employees = [
  { salary:50000 },
  { salary:90000 },
  { salary:70000 }
];
```

Solution

```js
const highest = employees.reduce((max, employee) =>

  employee.salary > max.salary

  ?

  employee

  :

  max

);

console.log(highest);
```

Output

```js
{
  salary:90000
}
```

---

# 10. Real Interview Problems

### Problem 1

Return names of employees earning above ₹50,000.

Pattern

```
filter()

↓

map()
```

---

### Problem 2

Calculate total completed orders.

Pattern

```
filter()

↓

reduce()
```

---

### Problem 3

Extract every comment from posts.

Pattern

```
flatMap()
```

---

### Problem 4

Create lookup table using ID.

Pattern

```
reduce()
```

---

### Problem 5

Count word frequency.

Pattern

```
reduce()
```

---

### Problem 6

Group employees by department.

Pattern

```
reduce()
```

---

### Problem 7

Find average salary.

Pattern

```
reduce()
```

---

### Problem 8

Flatten nested orders.

Pattern

```
flatMap()
```

---

### Problem 9

Remove duplicates.

Pattern

```
Set
```

---

### Problem 10

Sort products by price.

Pattern

```
sort()
```

---

# 11. Pattern Recognition Table

| Requirement | Pattern | Method |
|-------------|---------|---------|
| Transform Data | Mapping | `map()` |
| Filter Data | Selection | `filter()` |
| Find One Item | Search | `find()` |
| Validate Data | Boolean | `some()` / `every()` |
| Sum / Average | Aggregation | `reduce()` |
| Count Frequency | Frequency Counter | `reduce()` |
| Group Data | Grouping | `reduce()` |
| Lookup Object | Lookup Table | `reduce()` |
| Flatten Nested Arrays | Flatten | `flat()` |
| Transform + Flatten | Nested Transformation | `flatMap()` |
| Remove Duplicates | Deduplication | `Set` |
| Sort Data | Ordering | `sort()` |
| Multiple Operations | Pipeline | Method Chaining |

---

# 12. Summary

Advanced JavaScript interviews focus on solving problems through **patterns**, not memorizing syntax.

The most important patterns are:

- Frequency Counter (`reduce()`)
- Grouping (`reduce()`)
- Lookup Tables (`reduce()`)
- Aggregation (`reduce()`)
- Nested Data (`flatMap()`)
- Data Transformation (`map()`)
- Deduplication (`Set`)
- Multi-Step Pipelines (Method Chaining)

Mastering these patterns will help you solve a large percentage of real JavaScript interview questions.

---
# Real World Patterns

# Part 4 – FAANG JavaScript Mastery: Decision Trees, Optimization, Complexity & Interview Traps

> **"The difference between a beginner and a senior JavaScript developer is not knowing more methods—it is knowing when to use them, why they are the best choice, and how to write efficient, scalable, and maintainable solutions."**

---

# Table of Contents

1. FAANG Thinking Process
2. JavaScript Decision Tree
3. Optimization Techniques
4. Time Complexity Cheat Sheet
5. Space Complexity Cheat Sheet
6. Choosing the Correct Method
7. Common Interview Traps
8. Best Practices
9. Common Mistakes
10. 25 Real Interview Scenarios
11. Quick Decision Cheat Sheet
12. Summary

---

# 1. FAANG Thinking Process

Never jump directly into coding.

Professional developers solve problems like this.

```
Understand Problem

↓

Understand Input

↓

Understand Output

↓

Identify Pattern

↓

Choose Method

↓

Analyze Complexity

↓

Write Code

↓

Optimize

↓

Explain Solution
```

---

# 2. JavaScript Decision Tree

```
Need New Array?

↓

YES

↓

Need Transformation?

↓

map()

---------------------

Need Selection?

↓

filter()

---------------------

Need One Item?

↓

find()

---------------------

Need Index?

↓

findIndex()

---------------------

Need Boolean?

↓

some()

every()

---------------------

Need Single Value?

↓

reduce()

---------------------

Need Flatten?

↓

flat()

---------------------

Need Flatten + Transform?

↓

flatMap()

---------------------

Need Sorting?

↓

sort()

---------------------

Need Side Effect?

↓

forEach()
```

---

# 3. Optimization Techniques

## Technique 1

Avoid unnecessary loops.

Instead of

```js
const active = users.filter(user => user.active);

const names = active.map(user => user.name);
```

Sometimes one `reduce()` is enough.

```js
const names = users.reduce((result, user) => {

    if(user.active){

        result.push(user.name);

    }

    return result;

}, []);
```

---

## Technique 2

Avoid Nested Loops

Bad

```
O(n²)
```

Prefer

```
Map

↓

O(1)

Lookup
```

---

## Technique 3

Use Set

Instead of

```js
array.filter((value,index)=>array.indexOf(value)===index);
```

Use

```js
const unique = [...new Set(array)];
```

---

## Technique 4

Create Lookup Tables

Instead of repeatedly searching

```js
users.find(...)
```

Create

```js
const lookup = users.reduce((acc,user)=>{

    acc[user.id]=user;

    return acc;

},{});
```

Lookup becomes

```
O(1)
```

---

# 4. Time Complexity Cheat Sheet

| Method | Time Complexity |
|----------|----------------|
| map() | O(n) |
| filter() | O(n) |
| find() | O(n) Worst Case |
| findIndex() | O(n) |
| some() | O(n) Worst Case |
| every() | O(n) Worst Case |
| reduce() | O(n) |
| forEach() | O(n) |
| flat() | O(n) |
| flatMap() | O(n) |
| sort() | O(n log n) |
| Set Lookup | O(1) |
| Map Lookup | O(1) |

---

# 5. Space Complexity Cheat Sheet

| Method | Space |
|----------|-------|
| map() | O(n) |
| filter() | O(n) |
| flat() | O(n) |
| flatMap() | O(n) |
| reduce() | Depends |
| find() | O(1) |
| some() | O(1) |
| every() | O(1) |
| forEach() | O(1) |
| sort() | Engine Dependent |

---

# 6. Choosing the Correct Method

| Requirement | Best Method |
|-------------|-------------|
| Modify Data | map() |
| Keep Some Data | filter() |
| First Match | find() |
| First Index | findIndex() |
| Check Any | some() |
| Check All | every() |
| Sum | reduce() |
| Average | reduce() |
| Maximum | reduce() |
| Minimum | reduce() |
| Count Frequency | reduce() |
| Group Data | reduce() |
| Convert Array → Object | reduce() |
| Flatten Arrays | flat() |
| Flatten + Transform | flatMap() |
| Print Values | forEach() |
| Sort Data | sort() |

---

# 7. Common Interview Traps

## Trap 1

Using `map()` instead of `filter()`.

Wrong

```js
numbers.map(...)
```

Need

```js
filter()
```

---

## Trap 2

Using `forEach()` to create arrays.

Wrong

```js
forEach()
```

Correct

```js
map()
```

---

## Trap 3

Using `find()` when multiple values are needed.

Need

```js
filter()
```

---

## Trap 4

Sorting numbers incorrectly.

Wrong

```js
numbers.sort();
```

Correct

```js
numbers.sort((a,b)=>a-b);
```

---

## Trap 5

Overusing `reduce()`.

Sometimes

```js
filter()

↓

map()
```

is much easier to read.

---

## Trap 6

Mutating arrays accidentally.

Mutating methods

```
sort()

reverse()

splice()

fill()

copyWithin()
```

Need immutability?

Use

```
toSorted()

toReversed()

toSpliced()
```

---

# 8. Best Practices

✅ Keep one operation per line.

---

✅ Prefer immutable methods.

---

✅ Use descriptive variable names.

---

✅ Keep callbacks small.

---

✅ Write readable chains.

---

✅ Explain complexity during interviews.

---

# 9. Common Mistakes

❌ Using `map()` for logging.

---

❌ Using `filter()` to transform values.

---

❌ Using `find()` for multiple matches.

---

❌ Forgetting compare function in `sort()`.

---

❌ Writing very long unreadable chains.

---

# 10. 25 Real Interview Scenarios

| Problem | Best Method |
|----------|-------------|
| Double numbers | map() |
| Convert names to uppercase | map() |
| Active users | filter() |
| Expensive products | filter() |
| First admin | find() |
| First failed student | find() |
| Find index | findIndex() |
| Any admin exists | some() |
| All users verified | every() |
| Total salary | reduce() |
| Total revenue | reduce() |
| Average marks | reduce() |
| Highest salary | reduce() |
| Lowest price | reduce() |
| Frequency counter | reduce() |
| Group employees | reduce() |
| Lookup by ID | reduce() |
| Flatten comments | flat() |
| Extract skills | flatMap() |
| Sort employees | sort() |
| Remove duplicates | Set |
| Print report | forEach() |
| Filter → Map | Chaining |
| Filter → Reduce | Chaining |
| Filter → Map → Reduce | Chaining |

---

# 11. Quick Decision Cheat Sheet

```
Transform

↓

map()

--------------------

Select

↓

filter()

--------------------

Find One

↓

find()

--------------------

Find Index

↓

findIndex()

--------------------

Check Any

↓

some()

--------------------

Check All

↓

every()

--------------------

Aggregate

↓

reduce()

--------------------

Flatten

↓

flat()

--------------------

Flatten + Transform

↓

flatMap()

--------------------

Sort

↓

sort()

--------------------

Iterate

↓

forEach()
```

---

# 12. Summary

Professional JavaScript developers solve problems using **patterns**, not memorized syntax.

Remember this workflow:

```
Read Problem

↓

Identify Pattern

↓

Choose Method

↓

Think About Complexity

↓

Write Solution

↓

Optimize

↓

Explain Trade-offs
```

If you consistently follow this process, you'll be able to solve most real-world and interview array problems with confidence.

---

# Chapter Complete ✅

You have mastered:

- ✅ Pattern Recognition
- ✅ Decision Trees
- ✅ Method Selection
- ✅ Optimization Techniques
- ✅ Time Complexity
- ✅ Space Complexity
- ✅ Common Interview Traps
- ✅ Real Interview Scenarios
- ✅ Best Practices
- ✅ FAANG Interview Mindset

---

# Next Part

➡️ **15-Interview-Patterns.md** — Company-wise JavaScript Interview Questions (Google, Amazon, Microsoft, Adobe, Flipkart, Atlassian), Mock Interviews, Coding Round Questions, and Pattern-Based Practice.