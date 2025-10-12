'strict mode';

const addBtn = document.querySelector(".add");
const addForm = document.querySelector(".addForm");

const updateBtn = document.querySelector(".update");
const updateForm = document.querySelector(".updateForm");

const deleteBtn = document.querySelector(".delete");
const deleteForm = document.querySelector(".deleteForm");

addBtn.addEventListener("click" , function(){
		addForm.classList.remove("hidden");
		updateForm.classList.add("hidden");
		deleteForm.classList.add("hidden");
});

updateBtn.addEventListener("click" , function(){
		updateForm.classList.remove("hidden");
		addForm.classList.add("hidden");
		deleteForm.classList.add("hidden");
});

deleteBtn.addEventListener("click" , function(){
		deleteForm.classList.remove("hidden");
		addForm.classList.add("hidden");
		updateForm.classList.add("hidden");
});