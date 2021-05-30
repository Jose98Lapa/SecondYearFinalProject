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
        setTimeout(refreshColab, 2000);
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


