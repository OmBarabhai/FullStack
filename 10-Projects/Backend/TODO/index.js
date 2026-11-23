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
