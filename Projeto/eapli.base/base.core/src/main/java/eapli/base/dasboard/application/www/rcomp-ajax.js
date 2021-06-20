// IMPORTANT: notice the next request is scheduled only after the
//            previous request is fully processed either successfully
//	      or not.
function refreshColab() {
    var request = new XMLHttpRequest();
    var vBoard = document.getElementById("colabInfo");
    request.onload = function () {
        vBoard.innerHTML = this.responseText;
        vBoard.style.color = "white";
        console.log(this.responseText);
        setTimeout(refreshColab, 10000);
    };

    request.ontimeout = function () {
        vBoard.innerHTML = "Server timeout, still trying ...";
        vBoard.style.color = "red";
        setTimeout(refreshColab, 100);
    };

    request.onerror = function () {
        vBoard.innerHTML = "No server reply, still trying ...";
        vBoard.style.color = "red";
        setTimeout(refreshColab, 5000);
    };
    request.open("GET", "/colabInfo", true);
    request.timeout = 5000;
    request.send();
}
function refreshUrgency() {
    var request = new XMLHttpRequest();
    var vBoard = document.getElementById("urgencyTable");
    request.onload = function () {
        vBoard.innerHTML = this.responseText;
        vBoard.style.color = "white";
        console.log(this.responseText);
        setTimeout(refreshUrgency, 5000);
    };

    request.ontimeout = function () {
        vBoard.innerHTML = "Server timeout, still trying ...";
        vBoard.style.color = "red";
        setTimeout(refreshUrgency, 100);
    };

    request.onerror = function () {
        vBoard.innerHTML = "No server reply, still trying ...";
        vBoard.style.color = "red";
        setTimeout(refreshUrgency, 5000);
    };
    request.open("GET", "/urgency", true);
    request.timeout = 5000;
    request.send();
}
function refreshCriticality() {
    var request = new XMLHttpRequest();
    var vBoard = document.getElementById("criticalityTable");
    request.onload = function () {
        vBoard.innerHTML = this.responseText;
        vBoard.style.color = "white";
        console.log(this.responseText);
        setTimeout(refreshCriticality, 5000);
    };

    request.ontimeout = function () {
        vBoard.innerHTML = "Server timeout, still trying ...";
        vBoard.style.color = "red";
        setTimeout(refreshCriticality, 100);
    };

    request.onerror = function () {
        vBoard.innerHTML = "No server reply, still trying ...";
        vBoard.style.color = "red";
        setTimeout(refreshCriticality, 5000);
    };
    request.open("GET", "/criticality", true);
    request.timeout = 5000;
    request.send();
}


