// let submitButton = document.getElementById("submit");
//
// submitButton.addEventListener('click',updateButtonClick)
let lunchButtons = document.getElementsByClassName('lunch-btn');
for (let x=0;x<lunchButtons.length;x++){
    lunchButtons[x].addEventListener('click',updateButtonClick)
}
function updateButtonClick(event){
    const request = new XMLHttpRequest();
    //open
    // const  btn = event.target.id.getAttribute('data-movie-id')
    let movieId = event.target.getAttribute('data-movie-id');
    console.log(movieId);
    console.log(this);
    request.open('GET','/update-movie?id='+movieId,true)
    request.send();

    //on progressßß
    request.onprogress = function (){

    }

    request.onload = function(){
        document.getElementById("demo").innerHTML =this.responseText;
        $('#exampleModalLong').modal('show');
    }
}