
function registerUser(){
    let userName = document.getElementById("username").value;
    let pass = document.getElementById("password").value;
    let fname = document.getElementById("firstName").value;
    let lname = document.getElementById("lastName").value;
    let postc = document.getElementById("postcode").value;
    let street = document.getElementById("street").value;
    let city = document.getElementById("city").value;
    let country = document.getElementById("country").value;


    // let userDetails = {"Username": userName, "Password": pass, "firstName":fname, "lastName":lname,
    // "postcode":postc, "street":street, "city":city, "country":country};
    // let udetails = JSON.parse(userDetails);
    // let requestURL = "http://localhost:8080/jboss-javaee-webapp/example/regis/"+udetails;
    // console.log(userDetails);
    // let request = new XMLHttpRequest();
	// request.open('POST', requestURL);
	// request.responseType = 'json';
	// request.send();
	// request.onload = function () {
	// 	let reply = request.response;
	// 	console.log(reply);   
    // }    
    //dale example
    let xhr = new XMLHttpRequest();
            	xhr.open("POST", "http://localhost:8080/jboss-javaee-webapp/example/web/regis");
            	xhr.setRequestHeader('Content-Type', 'application/json');
                let data = JSON.stringify({"Username": userName, "password": pass});
                console.log(data);
            	xhr.send(data);
}

function signup(){
            
    let userName = document.getElementById("username").value;
    let password = document.getElementById("password").value;
    let fName = document.getElementById("firstName").value;
    let lName = document.getElementById("lastName").value;
    let postC = document.getElementById("postcode").value;
    let street = document.getElementById("street").value;
    let city = document.getElementById("city").value;
    let country = document.getElementById("country").value;
    
    alert("Signed up successfully! Username : " + userName);
    
}