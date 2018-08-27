


function login(){
    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;
    let jsonobj = {"username":username, "password":password};
    let requestURL = 'http://localhost:8080/jboss-javaee-webapp/example/web/login';
    let request = new XMLHttpRequest();
    console.log(jsonobj);

	request.open('POST', requestURL,true);
    request.responseType = 'json';
	request.send(JSON.stringify(jsonobj));
	request.onload = function () {
        let reply = request.response;
        let loginResult = reply.result;
        if(loginResult === "Login Successful"){
            sessionStorage.username = reply.username;
            alert(reply.result);
            location.reload();
        }
        else{
            alert(reply.reply);
        }
        
    }
    
}
function changeButton(){
    if(sessionStorage.username != ""){
        document.getElementById("links").value = "Logout";
    }
    else{
        document.getElementById("links").value = "Login";
    }
}