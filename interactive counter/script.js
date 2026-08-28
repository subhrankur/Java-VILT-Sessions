const counter = document.getElementById("counter");
const incrementBtn = document.getElementById("increment-btn");
const decrementBtn = document.getElementById("decrement-btn");

let count = 0;

incrementBtn.addEventListener("click", function () {
  count++;
  counter.textContent = count;
});

decrementBtn.addEventListener("click", function () {
  count--;
  counter.textContent = count;
});