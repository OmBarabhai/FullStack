# Todo App — Express.js Conceptual Revision (v3)

> **Purpose:** Revise only the concepts demonstrated in this Todo app. This is not a new architecture or an expanded system-design guide.

## 1. What this application does

The application keeps a list of todo items in a JavaScript array and exposes HTTP endpoints so a client (for example, Postman or a frontend) can manage that list.

```text
Client  ──HTTP request──>  Express server  ──>  todos array
Client  <─HTTP response──  Express server  <──  result
```

The four operations are **CRUD**:

- **Create** — add a todo.
- **Read** — list todos.
- **Update** — change an existing todo.
- **Delete** — remove a todo.

## 2. Your four API routes

| Operation | Method | Route | Where the input comes from | What your code does |
|---|---|---|---|---|
| List todos | `GET` | `/list-todos` | No input | Sends the `todos` array |
| Add todo | `POST` | `/add-todo` | `req.body` — `id`, `todo` | Adds the object using `todos.push()` |
| Update todo | `PUT` | `/update-todo` | `req.body` — `id`, `updatedTodo` | Finds a matching ID and changes its `todo` value |
| Delete todo | `DELETE` | `/delete-todo?id=1` | `req.query.id` | Finds the item and removes it from the array |

**Important:** Your planning note labels update as `POST`, but the code you wrote uses `app.put()`. The actual method in your implementation is **PUT**.

## 3. Concepts used in your code

### Express application and routes

```js
const app = express();
app.get('/list-todos', (req, res) => { ... });
```

- `express()` creates the Express application.
- `app.get()`, `app.post()`, `app.put()` and `app.delete()` register route handlers.
- A route is identified by its HTTP method and URL path.

### Middleware: `express.json()`

```js
app.use(express.json());
```

Middleware runs during the request-processing flow. `express.json()` reads an incoming JSON request body and parses it, making the resulting object available in `req.body`.

It **parses** JSON; it does not validate that your required fields are present or correct. Your route code performs that basic check.

### Request: `req`

The request object contains information sent by the client. In your app, you use:

- `req.body` — data sent in the JSON body. You use it when adding and updating a todo.
- `req.query` — values in the URL query string. You use `req.query.id` when deleting a todo.

Example:

```text
DELETE /delete-todo?id=1
                         └── req.query.id
```

### Response: `res`

The response object is used by the server to send the result back to the client.

- `res.send(todos)` sends the list.
- `res.send('todo added Succesfully')` sends a success message.

A request handler should always send a response (or pass control to error handling). In your validation blocks, `console.log()` followed by `return` does **not** send a response, so the client can keep waiting.

## 4. How each operation works in your implementation

### A. List — GET

```js
app.get('/list-todos', (req, res) => {
  res.send(todos);
});
```

The client asks for the current todo list. The server reads the array and sends it back. This is a **read operation**; it does not add, change or remove an item.

### B. Add — POST

```js
const todoItem = req.body;
// Check id and todo
 todos.push(todoItem);
```

The client sends a todo object in the request body. Your code checks for `id` and `todo`, then `push()` adds that object to the end of the array.

Example body:

```json
{
  "id": "1",
  "todo": "Learn Express"
}
```

`POST` is used here to create a new todo.

### C. Update — PUT

```js
const todoItem = req.body;
todos.map((data) => {
  if (data.id === todoItem.id) {
    data.todo = todoItem.updatedTodo;
  }
});
```

The client sends the ID of the todo and the new text. Your code checks each item; when the IDs match, it changes that item's `todo` property.

Your implementation changes only the todo text. Although the method is `PUT`, the operation shown in this code is a field-level change. Also, `map()` is being used for its side effect here; it normally creates and returns a new array, so it is not the clearest method for this job.

### D. Delete — DELETE

```js
const todoDeleteId = req.query.id;
const [todoItem] = todos.filter((data) => data.id === todoDeleteId);
const todoItemIdx = todos.indexOf(todoItem);
todos.splice(todoItemIdx, 1);
```

The client supplies the ID in the query string. Your code filters the array to find the matching item, gets its index, and `splice()` removes one item at that position.

## 5. JavaScript array methods you used

| Method | What it does | How you use it |
|---|---|---|
| `push(item)` | Adds an item to the end of the existing array | Add todo |
| `map(callback)` | Builds and returns a new array from callback results | You use it to update a matching object's property |
| `filter(callback)` | Returns a new array containing every matching item | Find the todo to delete |
| `indexOf(item)` | Returns the position of an item, or `-1` if it is not found | Get the delete position |
| `splice(index, 1)` | Removes one item from the original array at the given index | Delete todo |

Remember the difference: `filter()` does not remove anything from the original `todos` array. `splice()` changes the original array.

## 6. Important limitations in your current code

These are the main points to understand about the implementation you actually wrote:

1. **In-memory data:** `const todos = []` stores data only while this Node.js process is running. Restarting the server starts with an empty array.
2. **Validation response:** When required data is missing, your code logs a message and returns without responding to the client.
3. **Update not found:** Your update route sends a success message even when the supplied ID does not match any todo.
4. **Delete not found:** If no item matches, `todoItem` is `undefined`, `indexOf()` returns `-1`, and `splice(-1, 1)` can remove the last todo by mistake.
5. **ID type:** `req.query.id` is a string. Your comparison uses strict equality (`===`), so the ID stored in the array must have the same type to match.

These are observations about your current practice app, not additional features you have already implemented.

## 7. Explain this project in an interview

> “I built a basic Todo REST API using Node.js and Express. I used `express.json()` middleware to parse JSON request bodies. I created four endpoints: GET to list todos, POST to add a todo, PUT to update a todo, and DELETE to remove a todo. I stored the todos in a JavaScript array and used array methods to perform the CRUD operations. The project helped me understand routing, middleware, request data through `req.body` and `req.query`, and sending responses with `res`.”

## 8. Quick self-check before an interview

Try answering these without looking at the notes:

1. What is CRUD, and which route performs each operation?
2. What does `express.json()` do? Does it validate the request data?
3. What is the difference between `req.body` and `req.query` in your code?
4. What are `req` and `res`?
5. What happens when `todos.push(todoItem)` runs?
6. What does `filter()` return? Does it modify the original array?
7. What does `splice()` do?
8. Why can your delete code remove the last item when the ID does not exist?
9. Why is the todo list lost after the server restarts?
10. Why should a route send a response when validation fails?

---

**Revision boundary:** This file covers only the concepts present in your current Todo app. Database design, authentication, deployment, scaling, caching, queues, and advanced system design are intentionally outside this revision.
