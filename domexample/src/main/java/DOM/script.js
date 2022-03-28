let registerPassword = document.getElementById("#registerPassword");
let registerPasswordConfirm = document.getElementById("#registerPasswordConfirm");
let registerAgreeTerms = document.getElementById("#agreeTerms");
let registerForm = document.getElementById("#registerForm");

let loginUsername = document.getElementById("#loginUsername");
let loginPassword = document.getElementById("#loginPassword");
let loginForm = document.getElementById("#loginForm");

registerForm.addEventListener("submit", function(e){
    e.preventDefault();
    alert("You submitted on this page");
    if (registerPassword.value === registerPasswordConfirm.value && register.AgreeTerms.checked){
        alert("You successfully registered for an account.");
    }
    else{
        alert("Please validate your input");
    }

});


loginForm.addEventListener("submit", function(e){
    e.preventDefault();
        if(loginUsername.value === "admin", && loginPassword.value==="pass123"){
            alert("You logged in successsfully")
        }
        else{
        alert("wrong username/password");
        }
});
