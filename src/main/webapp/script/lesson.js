

displayAll();
function displayLessons(){
	document.getElementById("lessons").style.display = "inline";
	document.getElementById("lessonButton").style.display = "none";
	document.getElementById("lessonButton2").style.display = "inline";
}    
function noDisplay(){
	document.getElementById("lessons").style.display = "none";
	document.getElementById("lessonButton").style.display = "inline";
	document.getElementById("lessonButton2").style.display = "none";
}

function displayAll(){
	var requestURL = 'http://localhost:8080/jboss-javaee-webapp/example/web/getLesson';
	var request = new XMLHttpRequest();
	request.open('GET', requestURL);
	request.responseType = 'json';
	request.send();
	request.onload = function () {
		let reply = request.response;
		console.log(reply.lesson[0]); 
		for(let i=0; i < reply.lesson.length; i++){
			let lesson = document.createElement('button');
			lesson.setAttribute("id","lsnButton");
			lesson.textContent = reply.lesson[i];
			lesson.value= reply.lesson[i];
			lesson.setAttribute("onclick","displayVideo(this)");
			document.getElementById('lessons').appendChild(lesson);
		}   
	}
	}

function displayVideo(elem){
	var requestURL = 'http://localhost:8080/jboss-javaee-webapp/example/web/getVideo/'+elem.textContent;
	var request = new XMLHttpRequest();
	request.open('GET', requestURL);
	request.responseType = 'json';
	request.send();
	request.onload = function () {
		let reply = request.response;
		console.log(reply);
		let parent = document.getElementById("video");
		parent.innerHTML = "";

		let pContent = document.createElement("div");
		pContent.setAttribute("id","pContent");
		let video = document.createElement("div");
		video.setAttribute("id","specific");
		let ifr = document.createElement("iframe");
		ifr.setAttribute("id","ifr");
		console.log(reply.video);
		ifr.setAttribute("src",reply.video);
		ifr.style.width="560px";
		ifr.style.height="315px";

		let learnRule = document.createElement("p");
		learnRule.textContent = "Rule : " + reply.rule;
		
		let learnPlay = document.createElement("p");
		learnPlay.textContent = "Play : " + reply.play;

		let shutdown = document.createElement("button");
		shutdown.textContent = "Back";
		shutdown.setAttribute("id","shutdown");
		shutdown.setAttribute("onclick","shutclose()");

		video.appendChild(ifr);

		pContent.appendChild(shutdown);
		pContent.appendChild(learnRule);
		pContent.appendChild(learnPlay);
		parent.appendChild(video);
		parent.appendChild(pContent);
		video.style.display = "inline";
		parent.style.display = "block";
	}
}


function shutclose(){
	document.getElementById("video").style.display = "none";
}