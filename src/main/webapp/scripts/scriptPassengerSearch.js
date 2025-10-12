"strict mode";

const revealEst = document.querySelector(".estimateFare");
const formEst = document.querySelector(".estForm");

const revealPur = document.querySelector(".purchaseTicket");
const formPur = document.querySelector(".purchaseForm");

revealEst.addEventListener("click", function () {
 
    formEst.classList.remove("hidden");
	formPur.classList.add("hidden");
});

revealPur.addEventListener("click", function () {
 
    formPur.classList.remove("hidden");
	formEst.classList.add("hidden");	
 
});
