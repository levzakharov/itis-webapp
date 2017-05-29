var stompClient = null;


function connect() {
    var socket = new SockJS("/sock-js");
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function () {
        console.log('Connected: ');
    });
}

function disconnect() {
    if (stompClient != null) {
        stompClient.disconnect();
    }
    console.log("Disconnected");
}




$(document).ready(function(){
    connect();
});