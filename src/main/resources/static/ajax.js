
let movieId;
let lunchButtons = document.getElementsByClassName('lunch-btn');
for (let x=0;x<lunchButtons.length;x++){
    lunchButtons[x].addEventListener('click',updateButtonClick)
}
function updateButtonClick(event){
    const request = new XMLHttpRequest();
    movieId = event.target.getAttribute('data-movie-id');
    request.open('GET','/update-movie?id='+movieId,true)
    request.send();
    request.onprogress = function (){

    }
    request.onload = function(){
        document.getElementById("demo").innerHTML =this.responseText;
        $('#exampleModalLong').modal('show');
    }
}



function pressedUpdateButton(){

    // $("#btn").click(function(){
    //     $.post("/update-movie/"+movieId,{
    //         id: movieId,
    //         name: document.getElementById('movie-name').value,
    //         category: document.getElementById('movie-category').value,
    //         movieId: document.getElementById('movie-id').value,
    //         rating: document.getElementById('movie-rating').value,
    //         language:document.getElementById('movie-language').value
    //     },function(data, status){
    //         alert("Data: " + data + "\nStatus: " + status);
    //     });
    // });


    let postObj = {
        name: document.getElementById('movie-name').value,
        category: document.getElementById('movie-category').value,
        movieId: document.getElementById('movie-id').value,
        rating: document.getElementById('movie-rating').value,
        language:document.getElementById('movie-language').value
    }

    const request = new XMLHttpRequest();
    let post = JSON.stringify(postObj)

    request.open('POST','http://localhost:8086/update-movie/'+movieId,true)
    request.setRequestHeader('Content-type', 'application/json; charset=UTF-8')

    request.onprogress = function (){
    }
    request.onload = function(){
        $('#exampleModalLong').modal('hide');
        if(request.status === 200) {
            // document.location.href = document.location.href
            console.log('Success');
        }
        else{
            console.log(request.status)
            console.log('Failed');
        }
    }
    request.send(post);
}

