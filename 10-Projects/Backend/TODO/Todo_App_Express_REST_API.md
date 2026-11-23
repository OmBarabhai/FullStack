# Todo App — Express.js REST API Revision (v1)

> **Purpose:** Revise the Express.js, HTTP, REST API, request/response, middleware, JavaScript array and validation concepts demonstrated in the Todo App before a backend interview.
>
> **Project level:** Beginner CRUD API using an in-memory JavaScript array. This is a learning implementation, not a production-ready backend.

---

## 1. What this application does

The Todo App performs the four basic CRUD operations:

| Operation | Your endpoint | HTTP method | Input | What happens |
|---|---|---|---|---|
| Read all todos | `/list-todos` | `GET` | None | Returns the todo array |
| Create a todo | `/add-todo` | `POST` | JSON body: `{ "id", "todo" }` | Adds a todo to the array |
| Update a todo | `/update-todo` | `PUT` in your code | JSON body: `{ "id", "updatedTodo" }` | Finds a todo and changes its text |
| Delete a todo | `/delete-todo?id=1` | `DELETE` | Query parameter: `id` | Finds and removes a todo |

Your planning note says `POST` for update, but the actual implementation uses **`app.put()`**. For your current code, remember that the update request is `PUT`.

### CRUD meaning

- **Create** → add a new record.
- **Read** → retrieve existing record(s).
- **Update** → change an existing record.
- **Delete** → remove an existing record.

CRUD describes the data operation. HTTP methods are how the client asks the API to perform that operation.

---

## 2. Understand the request flow

When a client (Postman, browser, or frontend) sends a request:

1. The client sends an HTTP request to the server, including a method and URL.
2. Express receives the request.
3. Middleware runs in the order in which it was registered.
4. Express matches the method and route, such as `POST /add-todo`.
5. The route handler reads input from `req.body`, `req.query`, or `req.params`.
6. Your JavaScript code validates the input and performs an array operation.
7. The server sends an HTTP response using `res.send()` or `res.json()`.

**Example:** `POST /add-todo` with `{ "id": "1", "todo": "Learn Express" }` → JSON body parser → POST route → validation → `todos.push()` → success response.

---

## 3. Important Express and HTTP concepts

### `express()` — create the application

```js
const express = require('express');
const app = express();
```

- `require('express')` imports the Express package using CommonJS.
- `express()` creates an Express application.
- `app` is used to configure middleware, define routes, and start the server.

### `express.json()` — middleware to parse JSON

```js
app.use(express.json());
```

- This middleware reads an incoming request with a JSON body and parses it.
- The parsed data becomes available through `req.body`.
- Register it **before** routes that need to read JSON request bodies.
- Without a suitable body-parsing middleware, `req.body` may be `undefined`.
- It does not validate whether the JSON contains the fields your application requires. You must validate those fields yourself.

### `app.get()`, `app.post()`, `app.put()`, `app.delete()`

These methods register route handlers for different HTTP methods.

| Method | Normal purpose | Common CRUD use |
|---|---|---|
| `GET` | Retrieve a resource; should not change server state | Read |
| `POST` | Submit data, often to create a resource or trigger an operation | Create |
| `PUT` | Replace the target resource with the supplied representation | Full update/replacement |
| `PATCH` | Apply a partial change to the target resource | Partial update |
| `DELETE` | Remove the target resource | Delete |

**Important for your implementation:** you update only the `todo` field, not the complete todo resource. `PATCH` is therefore a more precise HTTP method for that operation. Your current `PUT` route works as an Express route, but its semantics are closer to `PATCH`.

### `req` and `res`

- `req` (request) contains information sent by the client: method, URL, headers, body, query parameters, and route parameters.
- `res` (response) is used by the server to send a status and response data back to the client.

### Three places to read client input

| Property | Where the data comes from | Example |
|---|---|---|
| `req.body` | Request body, commonly JSON for POST/PUT/PATCH | `{ "id": "1", "todo": "Study" }` |
| `req.query` | Query string after `?` in the URL | `/delete-todo?id=1` → `req.query.id` is `"1"` |
| `req.params` | Named variable segment in the route path | `/todos/:id` with `/todos/1` → `req.params.id` is `"1"` |

Use a **body** for the data being submitted, **query parameters** for optional filtering or options, and **route parameters** to identify a particular resource. Your delete endpoint currently uses a query parameter; a resource-oriented design would normally use `/todos/:id`.

---

## 4. Understand your submitted implementation

The following is your latest submitted implementation, with formatting normalised. Its logic is kept as you wrote it; the issues are explained separately below.

```js
const express = require('express');
const app = express()
const port = 3000
app.use(express.json());

const todos = [];
app.get('/', (req, res) => {
  res.send('Hello From Todo!')
})
app.get('/list-todos', (req, res) => {
  res.send(todos);
})
app.post('/add-todo', (req, res) => {
  const todoItem = req.body;
  if (!todoItem.id || !todoItem.todo) {
    console.log("Required field are Missing");
    return;
  }
  todos.push(todoItem)
  res.send("todo added Succesfully");
})
app.put('/update-todo', (req, res) => {
  const todoItem = req.body;
  if (!todoItem.id || !todoItem.updatedTodo) {
    console.log("Required field are Missing");
    return;
  }
  todos.map((data) => {
    if (data.id === todoItem.id) {
      data.todo = todoItem.updatedTodo;
    }
  })
  res.send("todo updated Succesfully");
})
app.delete('/delete-todo', (req, res) => {
  const todoDeleteId = req.query.id;
  if (!todoDeleteId) {
    console.log("Required field are Missing");
    return;
  }
  const [todoItem] = todos.filter((data) => (data.id === todoDeleteId));
  const todoItemIdx = todos.indexOf(todoItem);
  todos.splice(todoItemIdx, 1);
  res.send("todo delete Succesfully");
})

app.listen(port, () => {
  console.log(`Example app listening on port ${port}`)
})
```

### A. List todos — `GET /list-todos`

```js
app.get('/list-todos', (req, res) => {
  res.send(todos);
})
```

- The client asks for the list; it does not need to send a request body.
- `todos` is the array holding the current todo objects.
- `res.send(todos)` sends the array as the response. `res.json(todos)` would make the JSON response intention explicit.

### B. Add todo — `POST /add-todo`

```js
const todoItem = req.body;
if (!todoItem.id || !todoItem.todo) {
  console.log("Required field are Missing");
  return;
}
todos.push(todoItem)
res.send("todo added Succesfully");
```

- `req.body` contains the JSON sent by the client.
- The `if` statement checks that an ID and todo text were supplied.
- `push()` appends the object to the end of the array.
- The response tells the client that the item was added.

Example request body:

```json
{
  "id": "1",
  "todo": "Learn Express"
}
```

### C. Update todo — `PUT /update-todo`

```js
const todoItem = req.body;
if (!todoItem.id || !todoItem.updatedTodo) {
  console.log("Required field are Missing");
  return;
}
todos.map((data) => {
  if (data.id === todoItem.id) {
    data.todo = todoItem.updatedTodo;
  }
})
res.send("todo updated Succesfully");
```

- The request body supplies the ID to find and the new todo text.
- `map()` visits each element in the array.
- `data.id === todoItem.id` checks whether the current todo is the one to update. `===` compares both value and type.
- When the IDs match, `data.todo` is changed.
- The code sends a success message after the loop.

Example request body:

```json
{
  "id": "1",
  "updatedTodo": "Learn REST API design"
}
```

**Array-method detail:** `map()` is intended to create and return a new array by transforming each element. Your callback changes the existing object instead, and the returned array is ignored. The mutation may still happen, but `map()` is not the clearest choice here. Use `find()` when looking for one object, or `findIndex()` when you need its position. Use `forEach()` if your intention is to visit every element for a side effect.

### D. Delete todo — `DELETE /delete-todo?id=1`

```js
const todoDeleteId = req.query.id;
if (!todoDeleteId) {
  console.log("Required field are Missing");
  return;
}
const [todoItem] = todos.filter((data) => (data.id === todoDeleteId));
const todoItemIdx = todos.indexOf(todoItem);
todos.splice(todoItemIdx, 1);
res.send("todo delete Succesfully");
```

- `req.query.id` reads the `id` from the URL query string.
- `filter()` returns a new array containing every item that matches the condition.
- `[todoItem]` takes the first element from that filtered array.
- `indexOf(todoItem)` gets the position of that same object in the original `todos` array.
- `splice(todoItemIdx, 1)` removes one element starting at that position. It changes the original array.

**Important edge case:** if the ID does not exist, `filter()` returns an empty array and `todoItem` becomes `undefined`. `indexOf(undefined)` returns `-1`. `splice(-1, 1)` removes the **last todo**, which is a bug. Always check that a matching item exists before calling `splice()`.

### E. Start the server

```js
app.listen(port, () => {
  console.log(`Example app listening on port ${port}`)
})
```

- `app.listen()` starts the Express server listening on port `3000`.
- The callback runs when the server has started listening.
- Nodemon can restart the process when it detects file changes; it is a development convenience, not part of Express routing.

---

## 5. JavaScript array operations used in this project

| Method / operation | What it does | Used for |
|---|---|---|
| `todos.push(item)` | Adds an item to the end of the same array | Create |
| `todos.map(callback)` | Builds a new array from callback return values | Used in your update loop, but not ideal for mutation |
| `todos.filter(callback)` | Builds a new array containing matching items | Find matching item(s) before deletion |
| `todos.indexOf(item)` | Finds the index of a value in an array, or returns `-1` | Get the item's position |
| `todos.splice(index, 1)` | Removes one item at an index from the original array | Delete |
| `todos.find(callback)` | Returns the first matching item, or `undefined` | Find one todo object |
| `todos.findIndex(callback)` | Returns the first matching index, or `-1` | Find an item to update/delete |

Remember the difference:

- `filter()` returns a **new array**; it does not remove anything from the original array.
- `splice()` changes the **original array**.
- `map()` returns a **new array**; it is normally used when converting each element into another value.
- `findIndex()` is useful when you need the position of one matching element.

---

## 6. Bugs and improvements to explain in an interview

Your first implementation is useful for learning CRUD. An interviewer may ask what happens in error cases. Know these points:

| Current issue | Why it matters | Better behaviour |
|---|---|---|
| `console.log()` followed by `return` on invalid input | No HTTP response is sent, so the client can keep waiting | Return `400 Bad Request` with a JSON error message |
| No check that `req.body` exists and has the expected shape | Invalid or missing input can cause errors or bad data | Validate the request body and field types |
| `if (!id)` checks truthiness | It rejects valid numeric ID `0`; it also does not validate the type | Check the expected type and whether the value is missing |
| No duplicate-ID check on create | Two todos can have the same ID | Check whether the ID already exists; return `409 Conflict` |
| `map()` is used only for a side effect | The newly returned array is thrown away | Use `find()` / `findIndex()` or `forEach()` appropriately |
| Update responds success even when no ID matched | The client is told an update happened when nothing changed | Return `404 Not Found` when the todo does not exist |
| Delete does not check for a missing match | `splice(-1, 1)` can delete the last todo | Check `findIndex()` result against `-1` before deleting |
| IDs may have different types | `"1" === 1` is `false` | Use one consistent ID type throughout the API |
| `PUT` changes only one field | This is a partial update, not a full replacement | Use `PATCH` for this behaviour, or implement full replacement for `PUT` |
| Success responses use default status codes | The status does not clearly describe the outcome | Return deliberate status codes such as `200`, `201`, `400`, and `404` |
| `todos` exists only in process memory | Restarting the server clears all todos | Use a persistent database for real applications |

### HTTP status codes worth remembering

| Status | Meaning | Example in this API |
|---|---|---|
| `200 OK` | Request succeeded | List or update succeeded |
| `201 Created` | A resource was created | Todo added |
| `204 No Content` | Request succeeded with no response body | Todo deleted, if you choose not to return data |
| `400 Bad Request` | Client sent invalid or missing input | Missing `id` or todo text |
| `404 Not Found` | Requested todo does not exist | Update/delete an unknown ID |
| `409 Conflict` | Request conflicts with current data | Duplicate todo ID |
| `500 Internal Server Error` | Unexpected server-side failure | Unhandled application error |

A good response is not just a text message. It should communicate the correct HTTP status and, where useful, a consistent JSON body.

---

## 7. A cleaner REST-style design

Your original routes include action words (`add-todo`, `update-todo`, `delete-todo`). They work, but a resource-oriented REST style normally names the resource and lets the HTTP method communicate the action.

| Operation | Your learning route | Resource-oriented route |
|---|---|---|
| List | `GET /list-todos` | `GET /todos` |
| Create | `POST /add-todo` | `POST /todos` |
| Update one field | `PUT /update-todo` | `PATCH /todos/:id` |
| Delete | `DELETE /delete-todo?id=1` | `DELETE /todos/:id` |

For example, `PATCH /todos/1` identifies todo `1` in the path and supplies the changed field in the JSON body:

```json
{
  "todo": "Learn REST API design"
}
```

This is a design convention, not a rule that makes your original routes invalid. You should be able to explain both your implementation and the more conventional design.

### Safer reference implementation

This is a separate improved example, not a replacement for your submitted version. It keeps the data in an array but demonstrates clearer REST routes, validation, status codes, and missing-item handling.

```js
const express = require('express');
const app = express();
const port = 3000;

app.use(express.json());

// Learning-only storage: data is lost when the process restarts.
const todos = [];

app.get('/todos', (req, res) => {
  return res.status(200).json(todos);
});

app.post('/todos', (req, res) => {
  const { id, todo } = req.body ?? {};

  if (typeof id !== 'string' || !id.trim() ||
      typeof todo !== 'string' || !todo.trim()) {
    return res.status(400).json({ message: 'A string id and non-empty todo are required.' });
  }

  const alreadyExists = todos.some((item) => item.id === id);
  if (alreadyExists) {
    return res.status(409).json({ message: 'A todo with this id already exists.' });
  }

  const newTodo = { id, todo: todo.trim() };
  todos.push(newTodo);
  return res.status(201).json(newTodo);
});

app.patch('/todos/:id', (req, res) => {
  const { todo } = req.body ?? {};

  if (typeof todo !== 'string' || !todo.trim()) {
    return res.status(400).json({ message: 'A non-empty todo is required.' });
  }

  const todoItem = todos.find((item) => item.id === req.params.id);
  if (!todoItem) {
    return res.status(404).json({ message: 'Todo not found.' });
  }

  todoItem.todo = todo.trim();
  return res.status(200).json(todoItem);
});

app.delete('/todos/:id', (req, res) => {
  const todoItemIdx = todos.findIndex((item) => item.id === req.params.id);

  if (todoItemIdx === -1) {
    return res.status(404).json({ message: 'Todo not found.' });
  }

  const [deletedTodo] = todos.splice(todoItemIdx, 1);
  return res.status(200).json({ message: 'Todo deleted.', todo: deletedTodo });
});

app.listen(port, () => {
  console.log(`Todo API listening on port ${port}`);
});
```

**What this improved version demonstrates:**

- `req.params.id` reads the ID from `/todos/:id`.
- `req.body ?? {}` provides an empty object if the body is absent, so destructuring does not fail for that reason.
- `typeof` and `.trim()` validate that fields are strings and not empty/whitespace-only.
- `some()` checks for a duplicate ID.
- `find()` locates the object to update.
- `findIndex()` locates the position to delete.
- Each failure path returns a response; `return` prevents the handler from continuing after sending it.
- The implementation still uses memory, so it is not persistent or production-ready.

---

## 8. Test the API in Postman

Start the server, then send these requests in order. Use `http://localhost:3000` as the base URL.

### 1. List todos

- Method: `GET`
- URL: `http://localhost:3000/list-todos`
- Expected initially: `[]`

### 2. Add a todo

- Method: `POST`
- URL: `http://localhost:3000/add-todo`
- Body → raw → JSON:

```json
{
  "id": "1",
  "todo": "Learn Express"
}
```

### 3. List again

- Method: `GET`
- URL: `http://localhost:3000/list-todos`
- Check that the new object appears.

### 4. Update the todo

- Method: `PUT` (because this is what your submitted implementation registers)
- URL: `http://localhost:3000/update-todo`
- Body → raw → JSON:

```json
{
  "id": "1",
  "updatedTodo": "Learn REST APIs"
}
```

### 5. List again

- Method: `GET`
- URL: `http://localhost:3000/list-todos`
- Check that the text changed.

### 6. Delete the todo

- Method: `DELETE`
- URL: `http://localhost:3000/delete-todo?id=1`

### 7. List again

- Method: `GET`
- URL: `http://localhost:3000/list-todos`
- Check that the item is gone.

Also test missing fields, an unknown ID, and a repeated ID. Your original implementation has the error-handling problems described above; use these tests to understand why those checks matter.

---

## 9. Interview questions — practise answering aloud

Try answering each in your own words before reading the key point.

1. **What is Express.js?**  
   A Node.js web framework used to define routes, middleware, and HTTP request handlers.

2. **What is middleware?**  
   A function that runs during the request-response cycle. It can read/change request or response data, end the response, or pass control onward.

3. **Why did you use `express.json()`?**  
   To parse incoming JSON request bodies so route handlers can access the parsed data through `req.body`.

4. **What is the difference between `req.body`, `req.query`, and `req.params`?**  
   Body contains submitted data; query contains URL query-string values; params contains named values from the route path.

5. **What is the difference between POST, PUT, and PATCH?**  
   POST commonly creates or submits; PUT replaces a target resource; PATCH applies a partial modification.

6. **What is the difference between `map()` and `forEach()`?**  
   `map()` returns a new array of callback results; `forEach()` iterates for side effects and does not build a transformed array.

7. **What is the difference between `filter()` and `find()`?**  
   `filter()` returns all matches in an array; `find()` returns the first matching item or `undefined`.

8. **What does `findIndex()` return when there is no match?**  
   `-1`. Check this before using the value with `splice()`.

9. **What does `splice(index, 1)` do?**  
   It removes one element from the original array at the given index.

10. **Why can your current application lose data?**  
    Todos are stored in a process-local array, not a database. Restarting the server clears the array.

11. **Why should an API return status codes?**  
    They let the client understand whether the request succeeded or failed and what kind of outcome occurred.

12. **What is wrong with logging an error and simply returning?**  
    The handler does not send a response, so the client may wait until the request times out.

13. **What happens if the todo ID does not exist in your delete implementation?**  
    The filtered array is empty, the destructured item is `undefined`, `indexOf()` returns `-1`, and `splice(-1, 1)` can delete the last todo accidentally.

14. **Is this a complete production backend?**  
    No. It demonstrates CRUD routing and in-memory operations. A real backend needs persistent storage, stronger validation, error handling, and usually authentication/authorization and other operational safeguards depending on the application.

---

## 10. Explain your project in an interview

A concise explanation you can practise:

> “I built a basic Todo REST API using Node.js and Express. It supports the four CRUD operations: listing todos, adding a todo, updating a todo, and deleting a todo. I used Express routes for the HTTP methods and `express.json()` middleware to parse JSON request bodies. I used `req.body` for create and update data, and `req.query` to read the ID for deletion. For storage, I initially used a JavaScript array and methods such as `push`, `filter`, `indexOf`, and `splice`. This helped me understand the request-response cycle and how CRUD operations map to HTTP methods. The current version uses in-memory storage, so my next step would be to connect a database and add proper validation and error responses.”

Do not claim that this version uses a database or persists todos; it currently does neither.

---

## 11. Final revision checklist

You should be able to explain and demonstrate these without looking at the file:

- [ ] What Express does and what `app` represents.
- [ ] What middleware is and why `express.json()` runs before the routes.
- [ ] The request-response flow from client to route handler to response.
- [ ] The difference between `req.body`, `req.query`, and `req.params`.
- [ ] Why GET, POST, PUT/PATCH, and DELETE are used for CRUD.
- [ ] Why partial update is better represented by PATCH in this example.
- [ ] How `push`, `map`, `filter`, `find`, `findIndex`, `indexOf`, and `splice` behave.
- [ ] Why `map()` is not the right choice for the current update loop.
- [ ] Why `splice(-1, 1)` is dangerous.
- [ ] Why every request path must send a response, including validation failures.
- [ ] What status codes such as 200, 201, 400, 404, and 409 mean.
- [ ] Why an in-memory array is not persistent storage.
- [ ] How to test the complete create → read → update → delete flow in Postman.

**Interview readiness test:** Close this file and explain the entire request flow, then recreate the four routes from a blank file. Finally, test the missing-ID case and confirm that your API does not accidentally delete another todo.
