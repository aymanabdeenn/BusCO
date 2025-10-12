"strict mode";

const title = document.querySelector(".card_title");
const message = document.querySelector(".list_text");

const card = document.querySelector(".card");

const check = document.querySelector(".check");

title.textContent = "Purchase Failed!";
message.textContent= "There are no seats left for this trip :(";
	
title.style.fontSize = "25px";
message.style.fontSize = "18px";
	
card.style.backgroundImage = "	radial-gradient(at 88% 40%, hsla(0, 15%, 9%, 1) 0px, transparent 85%),"
	 +"radial-gradient(at 49% 30%, hsla(0, 15%, 9%, 1) 0px, transparent 85%)," 
	 +"radial-gradient(at 14% 26%, hsla(0, 15%, 9%, 1) 0px, transparent 85%)," 
	  +"radial-gradient(at 0% 64%, hsl(0, 99%, 26%) 0px, transparent 85%),"
	  +"radial-gradient(at 41% 94%, hsl(0, 97%, 36%) 0px, transparent 85%),"
	  +"radial-gradient(at 100% 99%, hsl(0, 94%, 13%) 0px, transparent 85%)";
	  
check.style.backgroundColor = "#8B0000";