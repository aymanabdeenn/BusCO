"strict mode";

const range = document.querySelector(".rangeBtn");
const ticket = document.querySelector(".ticketBtn");
const user = document.querySelector(".userBtn");

const rangeForm = document.querySelector(".rangeForm");
const ticketForm = document.querySelector(".ticketForm");
const userForm = document.querySelector(".userForm");

const forms = document.querySelectorAll(".form");

function hideAll(){
	forms.forEach(function(form){
		form.classList.add("hidden");
	});	
}

range.addEventListener("click" , function(){
	hideAll();
	rangeForm.classList.remove("hidden");
	console.log("hi");
});

ticket.addEventListener("click" , function(){
	hideAll();
	ticketForm.classList.remove("hidden");
});

user.addEventListener("click" , function(){
	hideAll();
	userForm.classList.remove("hidden");
});