# Fetch API — Hands-On Lab Practice Guide

**Folder:** `03-Asynchronous-JavaScript`

## Goal

Your current difficulty is not mainly Fetch syntax.

It is:

```text
Requirement
    ↓
Break into steps
    ↓
Choose operation
    ↓
Write code
```

Use this process for every lab:

```text
Understand requirement
↓
Identify current data
↓
Identify required output
↓
Choose operation
↓
Write code
↓
Run
↓
Compare
↓
Debug
```

Do not copy the final solution before attempting the scaffold.

---

# Lab 0 — Basic Fetch Shape

Remember this sequence:

```js
const response = await fetch(url);
```

gives:

```text
Response
```

Then:

```js
const data = await response.json();
```

gives:

```text
Parsed JavaScript data
```

Mental model:

```text
fetch()
  ↓
Response
  ↓
json()
  ↓
data
```

---

# Lab 1 — Basic GET

## Requirement

Fetch:

```text
https://jsonplaceholder.typicode.com/users
```

Print the raw `Response`.

## Think First

Ask:

```text
1. What starts the request?
2. Do I need await?
3. Do I want Response or parsed data?
```

Because the requirement says **Response**, do not call `.json()` yet.

## Scaffold

```js
async function getUsers() {

    // fetch users


    // print response

}

getUsers();
```

## Hint

```js
const response = await fetch(...);
```

Then:

```js
console.log(response);
```

## Solution

```js
async function getUsers() {
    const response = await fetch(
        "https://jsonplaceholder.typicode.com/users"
    );

    console.log(response);
}

getUsers();
```

---

# Lab 2 — Parse JSON

## Requirement

Fetch users and print the actual user data.

## Think

You have:

```text
response
```

You want:

```text
users
```

Ask:

> How do I turn the Response body into JavaScript data?

## Scaffold

```js
async function getUsers() {

    const response = await fetch(
        "https://jsonplaceholder.typicode.com/users"
    );

    // Convert response to data


    // Print data

}

getUsers();
```

## Hint

```js
await response.json()
```

## Solution

```js
async function getUsers() {
    const response = await fetch(
        "https://jsonplaceholder.typicode.com/users"
    );

    const users = await response.json();

    console.log(users);
}

getUsers();
```

---

# Lab 3 — Print Only User Names

## Requirement

Fetch users and print only their names.

Each user is roughly:

```js
{
    id: 1,
    name: "Leanne Graham",
    ...
}
```

You have:

```text
many users
```

You want:

```text
one value from every user
```

Therefore:

```text
map()
```

## Scaffold

```js
async function getUserNames() {

    const response = await fetch(
        "https://jsonplaceholder.typicode.com/users"
    );

    const users = await response.json();

    const names = __________________________;

    console.log(names);
}

getUserNames();
```

## Hint

```js
users.map(user => user.name)
```

## Solution

```js
const names = users.map(user => user.name);
```

---

# Lab 4 — Find User With id 5

## Requirement

Find the user whose:

```text
id === 5
```

Logic:

```text
many users
   ↓
need one matching user
   ↓
find()
```

## Scaffold

```js
async function findUser() {

    const response = await fetch(
        "https://jsonplaceholder.typicode.com/users"
    );

    const users = await response.json();

    const user = __________________________;

    console.log(user);
}

findUser();
```

## Hint

```js
users.find(user => user.id === 5)
```

## Solution

```js
const user = users.find(user => user.id === 5);
```

---

# Lab 5 — Filter Users With id > 5

## Requirement

Return all users whose:

```text
id > 5
```

Logic:

```text
many users
   ↓
keep many matching users
   ↓
filter()
```

## Scaffold

```js
async function filterUsers() {

    const response = await fetch(
        "https://jsonplaceholder.typicode.com/users"
    );

    const users = await response.json();

    const selectedUsers = __________________________;

    console.log(selectedUsers);
}

filterUsers();
```

## Hint

```js
users.filter(user => user.id > 5)
```

## Solution

```js
const selectedUsers = users.filter(user => user.id > 5);
```

---

# Lab 6 — Error Handling

There are two situations you must distinguish.

```text
Network/request failure
        vs
HTTP error response
```

An HTTP `404` or `500` can still produce a `Response`.

Check:

```js
if (!response.ok) {
    throw new Error(`HTTP ${response.status}`);
}
```

## Requirement

Build:

```text
fetch
 ↓
check response
 ↓
parse JSON
 ↓
print data
 ↓
catch failure
```

## Scaffold

```js
async function getUsers() {

    try {

        // fetch


        // response check


        // parse JSON


        // print

    } catch (error) {

        // print error

    }

}

getUsers();
```

## Think in this order

```text
fetch
 ↓
response
 ↓
response.ok?
 ↓
json
 ↓
data
```

## Solution

```js
async function getUsers() {
    try {
        const response = await fetch(
            "https://jsonplaceholder.typicode.com/users"
        );

        if (!response.ok) {
            throw new Error(`HTTP ${response.status}`);
        }

        const users = await response.json();

        console.log(users);
    } catch (error) {
        console.log(error.message);
    }
}

getUsers();
```

---

# Lab 7 — Async/Await Pattern

The common pattern is:

```text
async function
   ↓
try
   ↓
await fetch()
   ↓
check response
   ↓
await response.json()
   ↓
use data
   ↓
catch error
```

Do not memorize it blindly.

Understand each stage:

```text
await fetch()
→ Response

response.ok
→ HTTP success check

await response.json()
→ parsed data

catch
→ runtime/request failure handling
```

---

# Lab 8 — POST

## Requirement

Send:

```text
name
email
```

Ask:

```text
Am I reading?
No.

Am I sending?
Yes.

HTTP method?
POST.
```

Then:

```text
JavaScript object
 ↓
JSON.stringify()
 ↓
request body
```

## Scaffold

```js
async function createUser() {

    const userData = {
        name: "Om",
        email: "om@example.com"
    };

    const response = await fetch(
        "https://jsonplaceholder.typicode.com/users",
        {

            // method


            // headers


            // body

        }
    );

    const data = await response.json();

    console.log(data);
}

createUser();
```

## Hint

You need:

```js
method: "POST"
```

```js
headers: {
    "Content-Type": "application/json"
}
```

```js
body: JSON.stringify(userData)
```

## Solution

```js
const response = await fetch(
    "https://jsonplaceholder.typicode.com/users",
    {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(userData)
    }
);
```

---

# Lab 9 — Fetch + Functional JavaScript

This is the most important bridge from Folder 02.

You already know:

```text
map
filter
find
reduce
```

Now combine them with Fetch.

---

## 9A — Fetch → JSON → map

Requirement:

> Print only user names.

Logic:

```text
GET
 ↓
JSON
 ↓
many users
 ↓
one value from each
 ↓
map
```

```js
const names = users.map(user => user.name);
```

---

## 9B — Fetch → JSON → find

Requirement:

> Find user with id 5.

Logic:

```text
GET
 ↓
JSON
 ↓
many users
 ↓
need one
 ↓
find
```

```js
const user = users.find(user => user.id === 5);
```

---

## 9C — Fetch → JSON → filter

Requirement:

> Get users with id > 5.

Logic:

```text
GET
 ↓
JSON
 ↓
many users
 ↓
need many matching
 ↓
filter
```

```js
const selected = users.filter(user => user.id > 5);
```

---

# Lab 10 — First Combination

## Requirement

Fetch users.

Then:

```text
1. Keep users with id > 5
2. Return only their names
```

Think:

```text
users
 ↓
filter
 ↓
map
 ↓
names
```

## Scaffold

```js
const result = users
    .____________________
    .____________________;
```

### Hint 1

First operation keeps:

```text
many users
```

So:

```text
filter()
```

### Hint 2

Second operation returns:

```text
names
```

So:

```text
map()
```

## Solution

```js
const result = users
    .filter(user => user.id > 5)
    .map(user => user.name);
```

---

# Lab 11 — Debugging Method

When your code fails, do not write everything as one chain.

Break it into stages:

```js
const response = await fetch(url);
console.log(response);

const data = await response.json();
console.log(data);

const filtered = data.filter(...);
console.log(filtered);

const result = filtered.map(...);
console.log(result);
```

This gives you:

```text
Request
 ↓
Response
 ↓
Data
 ↓
Filtered
 ↓
Transformed
 ↓
Result
```

This is the easiest way to discover where your logic is wrong.

Once it works, you can simplify it.

---

# Lab 12 — Debug This

Find the problem:

```js
async function getUsers() {
    const response = fetch(url);

    const data = await response.json();

    console.log(data);
}
```

Ask:

```text
What is response?
Why does response.json() fail?
```

Key:

```text
fetch()
→ Promise

await fetch()
→ Response
```

Correct:

```js
const response = await fetch(url);
```

---

# Lab 13 — DevAPI Bridge

Your earlier project used:

```text
static request objects
      ↓
map/filter/find/reduce/sort
```

Now move toward:

```text
external API
      ↓
fetch
      ↓
Response
      ↓
JSON
      ↓
functional processing
      ↓
analytics
```

Do not build the complete system at once.

Build one stage at a time.

---

# Lab 14 — Independent DevAPI Challenge

Do this **without looking at the earlier solutions**.

## Requirement

Fetch:

```text
https://jsonplaceholder.typicode.com/users
```

Then:

```text
1. Get users
2. Keep users with id > 5
3. Return only their names
4. Print the final array
```

Before coding, write:

```text
Input:
__________

First operation:
__________

Second operation:
__________

Final output:
__________
```

Expected thought process:

```text
users
 ↓
filter(id > 5)
 ↓
map(name)
 ↓
result
```

Now write the code yourself.

---

# Lab 15 — Final Mastery Test

Do this without looking back.

```text
Fetch users
   ↓
Check HTTP success
   ↓
Parse JSON
   ↓
Keep users with id > 3
   ↓
Return only names
   ↓
Print result
```

You should independently choose:

```text
fetch()
await
response.ok
response.json()
filter()
map()
```

If you can build this yourself, you are moving from:

```text
I know the methods
```

to:

```text
I can solve a requirement using JavaScript.
```

---

# Logic-Building Rule

When you get stuck, stop thinking about syntax.

Ask:

```text
1. What data do I have?
2. What output do I need?
3. One result or many?
4. Transform?
5. Filter?
6. Find one?
7. Combine values?
8. What can fail?
```

Then choose:

```text
Transform each
→ map

Keep matching elements
→ filter

Find one
→ find

Check any
→ some

Check all
→ every

Combine into one value
→ reduce
```

This is the skill you need to improve.

---

# Completion Checklist

- [ ] Basic GET
- [ ] Parse JSON
- [ ] map() after Fetch
- [ ] find() after Fetch
- [ ] filter() after Fetch
- [ ] HTTP error check
- [ ] try/catch
- [ ] POST
- [ ] JSON.stringify()
- [ ] Fetch + functional chaining
- [ ] Debugging in stages
- [ ] DevAPI Fetch bridge
- [ ] Independent final challenge

**Next after these labs:** `11-Promises.md`
