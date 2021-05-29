// IMPORTANT: notice the next request is scheduled only after the
//            previous request is fully processed either successfully
//	      or not.


function refreshStatus() {
    var request = new XMLHttpRequest();
    var vBoard = document.getElementById("colabInfo");
    request.onload = function () {
        vBoard.innerHTML = this.responseText;
        vBoard.style.color = "white";
        console.log(this.responseText);
        setTimeout(refreshVotes, 2000);
    };

    request.ontimeout = function () {
        vBoard.innerHTML = "Server timeout, still trying ...";
        vBoard.style.color = "red";
        setTimeout(refreshVotes, 100);
    };

    request.onerror = function () {
        vBoard.innerHTML = "No server reply, still trying ...";
        vBoard.style.color = "red";
        setTimeout(refreshVotes, 5000);
    };
    request.open("GET", "/colabInfo", true);
    request.timeout = 5000;
    request.send();
}


	
