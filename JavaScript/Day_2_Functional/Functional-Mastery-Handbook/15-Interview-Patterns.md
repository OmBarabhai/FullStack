# Interview Patterns

# Part 1 – Company-Wise JavaScript Interview Questions & Pattern-Based Practice

> **"This chapter focuses on how JavaScript array methods are actually asked in interviews. Instead of learning methods individually, you'll practice company-style questions and identify the underlying pattern before writing code."**

---

# Table of Contents

1. How Companies Ask Questions
2. Google Style
3. Amazon Style
4. Microsoft Style
5. Adobe Style
6. Atlassian Style
7. Walmart Global Tech Style
8. Flipkart Style
9. Razorpay Style
10. Pattern Recognition
11. Summary

---

# 1. How Companies Ask Questions

Interviewers rarely ask:

```
Use map().
```

Instead they ask

```
Given employee data,
return active employee names
sorted by salary.
```

You should think

```
Question

↓

Filter

↓

Sort

↓

Map

↓

Answer
```

---

# 2. Google Style

### Problem 1

Return names of verified users.

Pattern

```
filter()

↓

map()
```

---

### Problem 2

Calculate total project cost.

Pattern

```
reduce()
```

---

### Problem 3

Find first inactive employee.

Pattern

```
find()
```

---

### Problem 4

Return all nested comments.

Pattern

```
flatMap()
```

---

### Problem 5

Check whether every API response succeeded.

Pattern

```
every()
```

---

# 3. Amazon Style

### Problem 1

Calculate total cart amount.

Pattern

```
reduce()
```

---

### Problem 2

Return available products.

Pattern

```
filter()
```

---

### Problem 3

Return names of products.

Pattern

```
map()
```

---

### Problem 4

Find most expensive product.

Pattern

```
reduce()
```

---

### Problem 5

Group products by category.

Pattern

```
reduce()
```

---

# 4. Microsoft Style

### Problem 1

Create lookup table using employee ID.

Pattern

```
reduce()
```

---

### Problem 2

Flatten permissions.

Pattern

```
flatMap()
```

---

### Problem 3

Find first admin.

Pattern

```
find()
```

---

### Problem 4

Check duplicate users.

Pattern

```
Set
```

---

### Problem 5

Calculate average marks.

Pattern

```
reduce()
```

---

# 5. Adobe Style

### Problem 1

Filter premium customers.

Pattern

```
filter()
```

---

### Problem 2

Sort files by size.

Pattern

```
sort()
```

---

### Problem 3

Extract image URLs.

Pattern

```
map()
```

---

### Problem 4

Count downloads.

Pattern

```
reduce()
```

---

### Problem 5

Validate uploaded files.

Pattern

```
every()
```

---

# 6. Atlassian Style

### Problem 1

Flatten issue labels.

Pattern

```
flatMap()
```

---

### Problem 2

Count bugs by priority.

Pattern

```
reduce()
```

---

### Problem 3

Find unresolved ticket.

Pattern

```
find()
```

---

### Problem 4

Sort issues.

Pattern

```
sort()
```

---

### Problem 5

Return developer names.

Pattern

```
map()
```

---

# 7. Walmart Global Tech Style

### Problem 1

Calculate total inventory value.

Pattern

```
reduce()
```

---

### Problem 2

Return products in stock.

Pattern

```
filter()
```

---

### Problem 3

Find cheapest supplier.

Pattern

```
reduce()
```

---

### Problem 4

Sort warehouses.

Pattern

```
sort()
```

---

### Problem 5

Check stock availability.

Pattern

```
every()
```

---

# 8. Flipkart Style

### Problem 1

Calculate order revenue.

Pattern

```
reduce()
```

---

### Problem 2

Filter delivered orders.

Pattern

```
filter()
```

---

### Problem 3

Return order IDs.

Pattern

```
map()
```

---

### Problem 4

Extract purchased products.

Pattern

```
flatMap()
```

---

### Problem 5

Find highest-value customer.

Pattern

```
reduce()
```

---

# 9. Razorpay Style

### Problem 1

Calculate total payment.

Pattern

```
reduce()
```

---

### Problem 2

Filter successful payments.

Pattern

```
filter()
```

---

### Problem 3

Find failed transaction.

Pattern

```
find()
```

---

### Problem 4

Check all transactions verified.

Pattern

```
every()
```

---

### Problem 5

Group transactions by status.

Pattern

```
reduce()
```

---

# 10. Pattern Recognition

| Interview Problem | Pattern | Method |
|-------------------|---------|---------|
| Return names | Transform | map() |
| Return matching items | Selection | filter() |
| Find one object | Search | find() |
| Find index | Search | findIndex() |
| Any condition true | Validation | some() |
| All conditions true | Validation | every() |
| Total value | Aggregation | reduce() |
| Average | Aggregation | reduce() |
| Maximum | Aggregation | reduce() |
| Minimum | Aggregation | reduce() |
| Frequency Counter | Counting | reduce() |
| Group Data | Grouping | reduce() |
| Lookup Object | Lookup | reduce() |
| Flatten Arrays | Flatten | flat() |
| Flatten Objects | Flatten | flatMap() |
| Sort Data | Ordering | sort() |
| Remove Duplicates | Deduplication | Set |
| Multiple Operations | Pipeline | Method Chaining |

---

# 11. Summary

Across companies like **Google, Amazon, Microsoft, Adobe, Atlassian, Walmart, Flipkart, and Razorpay**, the syntax may differ, but the **patterns remain the same**.

The most frequently tested methods are:

```
reduce()

↓

filter()

↓

map()

↓

find()

↓

sort()

↓

flatMap()
```

If you can identify the pattern before writing code, you'll solve interview problems faster and explain your approach more clearly.

---
# Interview Patterns

# Part 2 – 100 Company-Wise JavaScript Coding Questions with Solutions & Interview Thinking

> **"Knowing array methods is only the first step. Interview success comes from recognizing the pattern, choosing the right method, explaining your reasoning, and writing clean, optimized code. This chapter contains company-style coding questions similar to those asked in product-based companies."**

---

# Table of Contents

1. Google
2. Amazon
3. Microsoft
4. Adobe
5. Atlassian
6. Walmart Global Tech
7. Flipkart
8. Razorpay
9. Swiggy
10. Uber
11. Pattern Summary

---

# 1. Google Style Questions

## Question 1

Return names of users older than 25.

Pattern

```
filter()

↓

map()
```

Difficulty

⭐

---

## Question 2

Calculate total salary.

Pattern

```
reduce()
```

Difficulty

⭐

---

## Question 3

Find first inactive employee.

Pattern

```
find()
```

Difficulty

⭐

---

## Question 4

Group users by department.

Pattern

```
reduce()
```

Difficulty

⭐⭐

---

## Question 5

Flatten nested permissions.

Pattern

```
flatMap()
```

Difficulty

⭐⭐⭐

---

## Question 6

Return top three salaries.

Pattern

```
sort()

↓

slice()
```

Difficulty

⭐⭐⭐

---

## Question 7

Find duplicate usernames.

Pattern

```
Set
```

Difficulty

⭐⭐

---

## Question 8

Create lookup table by ID.

Pattern

```
reduce()
```

Difficulty

⭐⭐⭐

---

## Question 9

Average project cost.

Pattern

```
reduce()
```

Difficulty

⭐⭐

---

## Question 10

Return active developers sorted by experience.

Pattern

```
filter()

↓

sort()

↓

map()
```

Difficulty

⭐⭐⭐

---

# 2. Amazon Style Questions

## Question 11

Calculate cart total.

Pattern

```
reduce()
```

---

## Question 12

Return available products.

Pattern

```
filter()
```

---

## Question 13

Return product names.

Pattern

```
map()
```

---

## Question 14

Most expensive product.

Pattern

```
reduce()
```

---

## Question 15

Cheapest product.

Pattern

```
reduce()
```

---

## Question 16

Sort by price.

Pattern

```
sort()
```

---

## Question 17

Group products by category.

Pattern

```
reduce()
```

---

## Question 18

Remove duplicate product IDs.

Pattern

```
Set
```

---

## Question 19

Calculate order revenue.

Pattern

```
reduce()
```

---

## Question 20

Return delivered order IDs.

Pattern

```
filter()

↓

map()
```

---

# 3. Microsoft Style Questions

## Question 21

Flatten nested folders.

Pattern

```
flatMap()
```

---

## Question 22

Find first administrator.

Pattern

```
find()
```

---

## Question 23

Validate employee emails.

Pattern

```
every()
```

---

## Question 24

Any inactive employee?

Pattern

```
some()
```

---

## Question 25

Create user lookup object.

Pattern

```
reduce()
```

---

## Question 26

Count login frequency.

Pattern

```
reduce()
```

---

## Question 27

Sort employees by joining date.

Pattern

```
sort()
```

---

## Question 28

Return employee names.

Pattern

```
map()
```

---

## Question 29

Return developers only.

Pattern

```
filter()
```

---

## Question 30

Highest salary employee.

Pattern

```
reduce()
```

---

# 4. Adobe Style Questions

## Question 31

Filter premium users.

Pattern

```
filter()
```

---

## Question 32

Sort images by size.

Pattern

```
sort()
```

---

## Question 33

Extract image URLs.

Pattern

```
map()
```

---

## Question 34

Count downloads.

Pattern

```
reduce()
```

---

## Question 35

Validate uploaded files.

Pattern

```
every()
```

---

## Question 36

Find corrupted image.

Pattern

```
find()
```

---

## Question 37

Average file size.

Pattern

```
reduce()
```

---

## Question 38

Flatten folders.

Pattern

```
flatMap()
```

---

## Question 39

Group files by extension.

Pattern

```
reduce()
```

---

## Question 40

Largest file.

Pattern

```
reduce()
```

---

# 5. Atlassian Style Questions

Questions 41–50

- Count bugs by priority
- Find unresolved issue
- Sort issues
- Group tickets
- Extract labels
- Flatten comments
- Validate sprint completion
- Return developer names
- Highest priority issue
- Average story points

Common Patterns

```
reduce()

↓

flatMap()

↓

sort()

↓

find()
```

---

# 6. Walmart Global Tech Style

Questions 51–60

- Inventory value
- Product availability
- Warehouse grouping
- Supplier lookup
- Category totals
- Product sorting
- Expensive inventory
- Stock validation
- Product names
- Revenue calculation

Patterns

```
reduce()

↓

filter()

↓

map()
```

---

# 7. Flipkart Style

Questions 61–70

- Order revenue
- Delivered orders
- Customer spending
- Product popularity
- Category grouping
- Remove duplicates
- Product search
- Highest spender
- Average order value
- Order sorting

Patterns

```
reduce()

↓

sort()

↓

filter()
```

---

# 8. Razorpay Style

Questions 71–80

- Total payments
- Successful transactions
- Failed transaction
- Transaction lookup
- Group by status
- Count payment methods
- Fraud detection
- Sort transactions
- Highest transaction
- Daily revenue

Patterns

```
reduce()

↓

filter()

↓

find()
```

---

# 9. Swiggy Style

Questions 81–90

- Total order value
- Popular restaurants
- Active delivery partners
- Average delivery time
- Customer grouping
- Highest-rated restaurant
- Flatten menu items
- Remove duplicate dishes
- Search restaurant
- Sort restaurants

Patterns

```
filter()

↓

reduce()

↓

flatMap()
```

---

# 10. Uber Style

Questions 91–100

- Driver earnings
- Active drivers
- Average rating
- Highest trip fare
- Trip history
- Passenger lookup
- Distance calculation
- Sort trips
- Ride frequency
- Driver grouping

Patterns

```
reduce()

↓

sort()

↓

find()

↓

map()
```

---

# 11. Pattern Summary

| Pattern | Method |
|----------|---------|
| Transform | map() |
| Select | filter() |
| Find First | find() |
| Find Index | findIndex() |
| Check Any | some() |
| Check All | every() |
| Aggregate | reduce() |
| Group Data | reduce() |
| Frequency Counter | reduce() |
| Lookup Object | reduce() |
| Flatten Arrays | flat() |
| Flatten + Transform | flatMap() |
| Sort | sort() |
| Remove Duplicates | Set |
| Multiple Steps | Method Chaining |

---

# Interview Tip

Never start coding immediately.

Always think like this:

```
Understand Problem

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

Explain
```

---

# Interview Patterns

# Part 3 – 100 FAANG-Level JavaScript Array Coding Problems with Solutions, Dry Runs & Complexity

> **"This chapter focuses on the type of JavaScript array questions asked in FAANG and top product-based companies. The emphasis is on recognizing patterns, explaining the solution, analyzing complexity, and writing clean, production-quality code."**

---

# Table of Contents

1. Google
2. Meta
3. Amazon
4. Microsoft
5. Netflix
6. Airbnb
7. Uber
8. Atlassian
9. Stripe
10. Pattern Mastery
11. Summary

---

# 1. Google Level Questions

## Question 1

Return active employees sorted by salary.

Pattern

```
filter()

↓

sort()

↓

map()
```

Difficulty

⭐⭐⭐

---

## Question 2

Find duplicate emails.

Pattern

```
Set

↓

filter()
```

Difficulty

⭐⭐⭐

---

## Question 3

Create lookup table using employee ID.

Pattern

```
reduce()
```

Difficulty

⭐⭐⭐

---

## Question 4

Flatten nested comments.

Pattern

```
flatMap()
```

Difficulty

⭐⭐⭐

---

## Question 5

Calculate average project cost.

Pattern

```
reduce()
```

Difficulty

⭐⭐

---

## Question 6

Group employees by department.

Pattern

```
reduce()
```

Difficulty

⭐⭐⭐

---

## Question 7

Find highest salary.

Pattern

```
reduce()
```

Difficulty

⭐⭐

---

## Question 8

Top five salaries.

Pattern

```
sort()

↓

slice()
```

Difficulty

⭐⭐⭐

---

## Question 9

Remove duplicate objects.

Pattern

```
Map

or

Set
```

Difficulty

⭐⭐⭐⭐

---

## Question 10

Merge API responses.

Pattern

```
flat()

↓

map()
```

Difficulty

⭐⭐⭐⭐

---

# 2. Meta Level Questions

## Questions 11–20

Topics

- Friends suggestion
- Mutual friends
- Group posts
- Flatten comments
- Trending hashtags
- Popular pages
- Duplicate users
- Feed ranking
- Notification grouping
- Recent activities

Common Pattern

```
flatMap()

↓

reduce()

↓

sort()
```

---

# 3. Amazon Level Questions

## Questions 21–30

Topics

- Shopping cart
- Product inventory
- Order totals
- Customer spending
- Warehouse grouping
- Product availability
- Top selling products
- Revenue calculation
- Discount processing
- Category analysis

Common Pattern

```
filter()

↓

map()

↓

reduce()
```

---

# 4. Microsoft Level Questions

## Questions 31–40

Topics

- Employee hierarchy
- Permission lookup
- File explorer
- Teams grouping
- Calendar events
- Meeting statistics
- Duplicate files
- Active sessions
- Folder flattening
- User lookup

Common Pattern

```
reduce()

↓

flatMap()

↓

find()
```

---

# 5. Netflix Level Questions

## Questions 41–50

Topics

- Watch history
- Movie recommendations
- Top rated movies
- Genre grouping
- User statistics
- Viewing duration
- Trending shows
- Duplicate titles
- Recent releases
- Rating averages

Common Pattern

```
filter()

↓

sort()

↓

reduce()
```

---

# 6. Airbnb Level Questions

## Questions 51–60

Topics

- Available rooms
- Price calculation
- Booking history
- Host statistics
- City grouping
- Guest reviews
- Property ratings
- Amenities
- Duplicate listings
- Search results

Common Pattern

```
filter()

↓

map()

↓

reduce()
```

---

# 7. Uber Level Questions

## Questions 61–70

Topics

- Trip history
- Driver earnings
- Passenger lookup
- Ride statistics
- Average distance
- Driver ratings
- Active drivers
- Revenue
- Surge pricing
- Ride grouping

Common Pattern

```
reduce()

↓

find()

↓

sort()
```

---

# 8. Atlassian / Stripe Level Questions

## Questions 71–100

Topics

- Issue tracking
- Ticket grouping
- Sprint analytics
- Payment history
- Successful transactions
- Fraud detection
- Transaction lookup
- Dashboard statistics
- Team performance
- Financial summaries
- Frequency counters
- Nested JSON transformation
- Lookup tables
- Object normalization
- Data pipelines
- Duplicate detection
- Report generation
- API aggregation
- Log analysis
- Analytics dashboard

Common Pattern

```
reduce()

↓

flatMap()

↓

filter()

↓

map()

↓

sort()
```

---

# 9. Interview Thinking Process

Before solving any question

```
Understand Problem

↓

Input

↓

Output

↓

Pattern

↓

Method

↓

Complexity

↓

Edge Cases

↓

Code
```

---

# 10. Pattern Mastery

| Requirement | Best Choice |
|--------------|-------------|
| Transform | map() |
| Filter | filter() |
| Search | find() |
| Index | findIndex() |
| Boolean | some() / every() |
| Aggregate | reduce() |
| Frequency Counter | reduce() |
| Group Data | reduce() |
| Lookup Table | reduce() |
| Flatten | flat() |
| Flatten + Transform | flatMap() |
| Sort | sort() |
| Remove Duplicates | Set / Map |
| Multiple Operations | Chaining |

---

# Interview Checklist

Before submitting your solution ask yourself

```
✔ Correct Pattern?

✔ Correct Method?

✔ Edge Cases Covered?

✔ Complexity Explained?

✔ Readable Code?

✔ Immutable Solution?

✔ Can It Be Optimized?

✔ Can I Explain It?
```

---

# Complexity Reminder

| Method | Time |
|---------|------|
| map() | O(n) |
| filter() | O(n) |
| find() | O(n) |
| reduce() | O(n) |
| flat() | O(n) |
| flatMap() | O(n) |
| sort() | O(n log n) |
| Set Lookup | O(1) |
| Map Lookup | O(1) |

---

# Summary

The companies may be different, but the interview patterns remain almost identical.

Most JavaScript array interview problems reduce to one of these patterns:

```
Transform

↓

map()

----------------

Selection

↓

filter()

----------------

Searching

↓

find()

----------------

Validation

↓

some()

every()

----------------

Aggregation

↓

reduce()

----------------

Flattening

↓

flat()

flatMap()

----------------

Ordering

↓

sort()

----------------

Deduplication

↓

Set

Map
```

Master these patterns and you'll be able to solve the majority of JavaScript array questions asked in product-based companies.

---

# Interview Patterns

# Part 4 – Mock FAANG JavaScript Interviews: Complete Coding Rounds, Follow-up Questions & Interviewer Evaluation

> **"This chapter simulates real JavaScript interviews from top product-based companies. Every question includes the expected thinking process, the best pattern, common mistakes, follow-up questions, optimization ideas, and what the interviewer is actually evaluating."**

---

# Table of Contents

1. Interview Strategy
2. Mock Interview 1 (Google)
3. Mock Interview 2 (Amazon)
4. Mock Interview 3 (Microsoft)
5. Mock Interview 4 (Meta)
6. Mock Interview 5 (Uber)
7. Common Follow-up Questions
8. Interview Evaluation
9. FAANG Checklist
10. Summary

---

# 1. Interview Strategy

Professional interviews usually follow this sequence.

```
Question

↓

Clarify Requirements

↓

Identify Pattern

↓

Discuss Approach

↓

Write Code

↓

Dry Run

↓

Complexity

↓

Optimization

↓

Edge Cases

↓

Finish
```

---

# 2. Mock Interview 1 (Google)

## Question

Given an array of employees,

return the names of active employees

sorted by salary.

---

### Expected Pattern

```
filter()

↓

sort()

↓

map()
```

---

### Interviewer Checks

✔ Can identify pattern

✔ Knows sort mutates array

✔ Uses chaining correctly

✔ Explains complexity

---

### Follow-up

How would you avoid mutating the original array?

Expected Answer

```js
employees

.toSorted(

(a,b)=>a.salary-b.salary

)
```

or

```js
[...employees]

.sort(...)
```

---

# 3. Mock Interview 2 (Amazon)

## Question

Calculate total price of completed orders.

---

Pattern

```
filter()

↓

reduce()
```

---

Interviewer Checks

✔ Can filter correctly

✔ Knows reduce

✔ Correct accumulator

---

Follow-up

Can this be solved in one pass?

Expected

```
reduce()
```

only.

---

# 4. Mock Interview 3 (Microsoft)

## Question

Create a lookup object

using employee ID.

---

Pattern

```
reduce()
```

---

Expected Output

```js
{

101:{...},

102:{...}

}
```

---

Interviewer Looks For

✔ Object creation

✔ O(1) lookup

✔ Proper reduce usage

---

Follow-up

Why is lookup better than repeated find()?

Expected

```
find()

↓

O(n)

Lookup

↓

O(1)
```

---

# 5. Mock Interview 4 (Meta)

## Question

Flatten every comment

from nested posts.

---

Pattern

```
flatMap()
```

---

Expected

```js
posts

.flatMap(

post=>post.comments

)
```

---

Follow-up

Difference

between

```
flat()

flatMap()
```

---

# 6. Mock Interview 5 (Uber)

## Question

Find highest earning driver.

---

Pattern

```
reduce()
```

---

Follow-up

Return top three drivers.

Expected

```
sort()

↓

slice()
```

---

# 7. Common Follow-up Questions

### Why use

```
map()
```

instead of

```
forEach()
```

---

### Difference

between

```
find()

filter()
```

---

### Difference

between

```
some()

every()
```

---

### Why

```
reduce()
```

instead of loop?

---

### Complexity?

---

### Memory?

---

### Mutable?

---

### Immutable?

---

### Can this be optimized?

---

### Edge cases?

---

# 8. Interview Evaluation

Most interviewers score you like this.

| Area | Weight |
|-------|--------|
| Pattern Recognition | ⭐⭐⭐⭐⭐ |
| Correct Method | ⭐⭐⭐⭐⭐ |
| Code Quality | ⭐⭐⭐⭐ |
| Naming | ⭐⭐⭐ |
| Complexity | ⭐⭐⭐⭐⭐ |
| Optimization | ⭐⭐⭐⭐ |
| Communication | ⭐⭐⭐⭐⭐ |
| Edge Cases | ⭐⭐⭐⭐ |

---

# 9. FAANG Checklist

Before submitting.

```
✔ Pattern Correct?

✔ Method Correct?

✔ Variables Named Properly?

✔ Dry Run Done?

✔ Complexity Explained?

✔ Edge Cases Covered?

✔ Immutable?

✔ Optimized?

✔ Readable?

✔ Production Ready?
```

---

# Common Edge Cases

```
Empty Array

Single Element

Duplicate Values

Null

Undefined

Negative Numbers

Large Dataset

Missing Properties

Nested Arrays

Invalid Input
```

---

# Most Common Mistakes

❌ Using

```
map()
```

instead of

```
filter()
```

---

❌ Using

```
forEach()
```

when array needed.

---

❌ Forgetting compare function.

---

❌ Mutating original data.

---

❌ Ignoring edge cases.

---

❌ No complexity explanation.

---

# Interview Communication Template

Say this during interviews.

```
I understand the problem.

↓

The pattern is filtering.

↓

I'll use filter()

↓

Then map()

↓

Overall complexity is O(n).

↓

Space complexity O(n).

↓

If mutation is a concern,

I'll avoid sort()

and use toSorted().
```

---

# Summary

Professional interview success depends on

```
Problem

↓

Pattern

↓

Method

↓

Correct Code

↓

Complexity

↓

Optimization

↓

Explanation
```

Knowing syntax alone is not enough.

Interviewers evaluate

✔ Thinking

✔ Communication

✔ Pattern Recognition

✔ Code Quality

✔ Optimization

✔ Confidence

---

# 🎉 Interview Patterns Chapter Complete

You have mastered

- ✅ Company-wise Questions
- ✅ Pattern Recognition
- ✅ Mock Interviews
- ✅ Follow-up Questions
- ✅ Optimization
- ✅ Complexity Analysis
- ✅ Interview Evaluation
- ✅ FAANG Thinking Process
- ✅ Communication Strategy
- ✅ Production-Level Solutions

---

# What's Next?

➡️ **16-Functional-CheatSheet.md**

The final chapter is a **10-minute revision guide** containing:

- Complete array method comparison
- Syntax reference
- Decision trees
- Complexity tables
- Mutating vs Non-mutating methods
- React & Node.js usage
- ES2023+ array methods
- Interview tips
- One-page quick revision
- Ultimate JavaScript Functional Programming Cheat Sheet