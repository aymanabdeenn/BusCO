"strict mode";

const introText = document.querySelector(".introText");
const bookBtn = document.querySelector(".bookTicket");
const viewBtn = document.querySelector(".viewTickets");
const bookingSection = document.querySelector(".bookingSection");
const history = document.querySelector(".history");

bookBtn.addEventListener("click", function () {
  introText.classList.add("hidden");
  bookingSection.classList.remove("hidden");
});



