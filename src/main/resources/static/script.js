
form.addEventListener('submit',function (e){
    if(movieName.value == ''){
        e.preventDefault();
        showError(movieName,'Movie Name is Required')
        return false;
    }
    if(movieCategory.value == 'Select Category'){
        e.preventDefault();
        showError(movieCategory,'Category  is Required')
        return false;
    }

    if(movieCategory.value == ''){
        e.preventDefault();
        showError(movieCategory,'Category  is Required')
        return false;
    }

    if(movieId.value == ''){
        e.preventDefault();
        showError(movieId,'Movie Id is Required')
        return false;
    }
    if(movieRating.value == ''){
        e.preventDefault();
        showError(movieRating,'Movie Rating is Required')
        return false;
    }
    if(movieLanguage.value == 'Select Language'){
        e.preventDefault();
        showError(movieLanguage,'Movie Language is Required')
        return false;
    }
})


function myFunction() {
    alert("Movie Added Successfully!");
}
function updateMovie() {
    alert("Movie Updated Successfully!");
}
function deleteMovie() {
    alert("Movie Delete Successfully");
}
function loginAlert() {
    alert("Login Successfully!");
}
function logoutAlert() {
    alert("Logout Successfully!");
}

const form = document.getElementById('add-form')
const movieName = document.getElementById('movie-name')
const movieCategory = document.getElementById('movie-category')
const movie_Id = document.getElementById('movie-id')
const movieRating = document.getElementById('movie-rating')
const movieLanguage = document.getElementById('movie-language')

function  showError (input, message){
    const formControl = input.parentElement;
    const small = formControl.querySelector('small');
    small.innerText = message;
}



