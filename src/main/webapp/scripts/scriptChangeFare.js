"strict mode";

const city = document.querySelector(".city");
const cityForm = document.querySelector(".cityForm");

const innerCity = document.querySelector(".innerCity");
const innerCityForm = document.querySelector(".innerCityForm");

const oneTrip = document.querySelector(".oneTrip");
const oneTripForm = document.querySelector(".oneTripForm");

const daily = document.querySelector(".daily");
const dailyForm = document.querySelector(".dailyForm");

const weekly = document.querySelector(".weekly");
const weeklyForm = document.querySelector(".weeklyForm");

const monthly = document.querySelector(".monthly");
const monthlyForm = document.querySelector(".monthlyForm");

const regular = document.querySelector(".regular");
const regularForm = document.querySelector(".regularForm");

const student = document.querySelector(".student");
const studentForm = document.querySelector(".studentForm");

const senior = document.querySelector(".senior");
const seniorForm = document.querySelector(".seniorForm");

const evening = document.querySelector(".evening");
const eveningForm = document.querySelector(".eveningForm");

const allForms = document.querySelectorAll(".form");

function hideAll(){
	allForms.forEach(function(form){
		form.classList.add("hidden");
	});
}

city.addEventListener("click" , function(){
	hideAll();
	cityForm.classList.remove("hidden");
	console.log("hi1");
});

innerCity.addEventListener("click" , function(){
	hideAll();
	innerCityForm.classList.remove("hidden");
});

oneTrip.addEventListener("click" , function(){
	hideAll();
	oneTripForm.classList.remove("hidden");
});

daily.addEventListener("click" , function(){
	hideAll();
	dailyForm.classList.remove("hidden");
});

weekly.addEventListener("click" , function(){
	hideAll();
	weeklyForm.classList.remove("hidden");
});

monthly.addEventListener("click" , function(){
	hideAll();
	monthlyForm.classList.remove("hidden");
});

regular.addEventListener("click" , function(){
	hideAll();
	regularForm.classList.remove("hidden");
});

student.addEventListener("click" , function(){
	hideAll();
	studentForm.classList.remove("hidden");
});

senior.addEventListener("click" , function(){
	hideAll();
	seniorForm.classList.remove("hidden");
});

evening.addEventListener("click" , function(){
	hideAll();
	eveningForm.classList.remove("hidden");
});