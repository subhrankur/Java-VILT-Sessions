const generateBtn = document.getElementById("generate-btn");
const hexDisplay = document.getElementById("hex-display");

function generateRandomColor() {
  const randomNumber = Math.floor(Math.random() * 16777216);
  return "#" + randomNumber.toString(16).padStart(6, "0").toUpperCase();
}

generateBtn.addEventListener("click", function () {
  const newColor = generateRandomColor();

  document.body.style.backgroundColor = newColor;

  hexDisplay.textContent = newColor;
});