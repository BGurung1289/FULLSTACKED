
            function sayhi(){
	            var requestURL = 'http://localhost:8080/jboss-javaee-webapp/example/web/hi/sandwich';
	            var request = new XMLHttpRequest();
	            request.open('GET', requestURL);
	            request.responseType = 'json';
	            request.send();
	            request.onload = function () {
		            var reply = request.response;
		            var myH1 = document.createElement('h1');
		            myH1.textContent = reply.result;
		            document.getElementsByTagName('body')[0].appendChild(myH1);
	            }
	            }
            function display(){
            	var requestURL = 'http://localhost:8080/jboss-javaee-webapp/example/web/showLesson';
	            var request = new XMLHttpRequest();
	            request.open('GET', requestURL);
	            request.responseType = 'json';
	            request.send();
	            request.onload = function () {
	                let reply = request.response;
	                let myH1 = document.createElement('h1');
	                myH1.textContent = "lessons : ";
	                document.getElementById('les').appendChild(myH1);
	                //let lesson = reply.result;

	                for(let i=0; i < reply.lessons.length; i++){
	                	let lesson = document.createElement('p');
	                	lesson.setAttribute("id",i+1);
		                lesson.textContent = reply.lessons[i];
		                document.getElementById('les').appendChild(lesson);
	                }                
	            }
                }
            function displayLesson(){
            	var requestURL = 'http://localhost:8080/jboss-javaee-webapp/example/web/lesson/' + document.getElementById('lookfor').value;
	            var request = new XMLHttpRequest();
	            request.open('GET', requestURL);
	            request.responseType = 'json';
	            request.send();
	            request.onload = function () {
		            var reply = request.response;
		            //var myH1 = document.createElement('iframe');
		            let myp1 = document.createElement('p');
		            myp1.textContent = document.getElementById('lookfor').value;
		            document.getElementsByTagName('body')[0].appendChild(myp1);
	            }
                }
            function displayAll(){
            	var requestURL = 'http://localhost:8080/jboss-javaee-webapp/example/web/getLesson';
	            var request = new XMLHttpRequest();
	            request.open('GET', requestURL);
	            request.responseType = 'json';
	            request.send();
	            request.onload = function () {
		            let reply = request.response;
					//console.log(reply.lesson[0]); 
					for(let i=0; i < reply.lesson.length; i++){
	                	let lesson = document.createElement('p');
	                	lesson.setAttribute("id",i+1);
		                lesson.textContent = reply.lesson[i];
		                document.getElementById('les').appendChild(lesson);
	                }   
	            }
                }