const textInput = document.getElementById("text-input");
const remainingCount = document.getElementById("remaining-count");
const charCounter = document.getElementById("char-counter");

textInput.addEventListener("input", function () {
  const usedCharacters = textInput.value.length;
  const remainingCharacters = 100 - usedCharacters;

  remainingCount.textContent = remainingCharacters;

  if (remainingCharacters < 10) {
    charCounter.classList.add("warning");
  } else {
    charCounter.classList.remove("warning");
  }
});