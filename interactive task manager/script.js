const todoForm = document.getElementById("todo-form");
const todoInput = document.getElementById("todo-input");
const todoList = document.getElementById("todo-list");

todoForm.addEventListener("submit", function (event) {
  event.preventDefault();

  const taskText = todoInput.value.trim();

  if (taskText === "") {
    return;
  }

  const li = document.createElement("li");
  li.className = "todo-item";

  const span = document.createElement("span");
  span.className = "todo-text";
  span.textContent = taskText;

  const deleteBtn = document.createElement("button");
  deleteBtn.className = "btn btn-delete";
  deleteBtn.type = "button";
  deleteBtn.textContent = "Delete";

  li.appendChild(span);
  li.appendChild(deleteBtn);

  todoList.appendChild(li);

  todoInput.value = "";
});

todoList.addEventListener("click", function (event) {
  if (event.target.classList.contains("btn-delete")) {
    event.target.parentElement.remove();
  }
});