function  showError (input,message){
    const formControl = input.parentElement;
    const small = formControl.querySelector('small');
    small.innerText = message;
}


form.addEventListener('submit',function (e) {
    if (adminEmail.value == '') {
        e.preventDefault();
        showError(adminEmail, 'Email is Required');
        return false;
    }
    if (adminPassword.value == '') {
        e.preventDefault();
        showError(adminPassword, 'Password is Required');
        return false;
    }
})

const form = document.getElementById('form')
const adminEmail = document.getElementById('adminEmail')
const adminPassword = document.getElementById('adminPassword')