var nameError = document.getElementById('name-error')

function validateName(){
    var name = document.getElementById('movie-name').value;
    if(name.length == 0){
        nameError.innerHTML = "Movie Name is Required"
        return false;
    }
}
function  checkFormValidation(){
    if(!validateName()){
        submitError.innerHTML = "Please fix error to submit";
    }
}

function myFunction() {
    alert("Movie Added Successfully!");
}
function updateMovie() {
    alert("Movie updated Successfully!");
}
function deleteMovie() {
    alert("\"Movie delete Successfully\"");
}

