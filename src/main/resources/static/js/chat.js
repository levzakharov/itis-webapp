var stompClient = null;
var myChatName = null;
function appendMessageFromNotMe(message, withScroll) {
    var content = message.content;
    var time = new Date(message.timestamp);
    var messageElem = '<div class="block notme">' +
        '<div class="image"><a>Д</a></div> ' +
        '<div class="message">' +
        '<div class="date">' +
        time +
        '</div> ' +
        '<div class="text">' +
        content +
        '</div>' +
        '</div>' +
        '</div>';
    var chat = $('.chat .blocks');
    chat.append(messageElem);
    if (withScroll)
        chat.animate({ scrollTop: chat[0].scrollHeight }, 600);
    readMeassage(message.id);
}

function appendMessageFromMe(message, withScroll){
    var content = message.content;
    var time = new Date(message.timestamp);
    var messageElem = '<div class="block me' + (message.unread != false ? ' unread' : '') + '" data-message-id="' + message.id + '">' +
        '<div class="image"><a>C</a></div> ' +
        '<div class="message">' +
        '<div class="date">' +
        time +
        '</div> ' +
        '<div class="text">' +
        content +
        '</div>' +
        '</div>' +
        '</div>';
    var chat = $('.chat .blocks');
    chat.append(messageElem);
    if (withScroll)
        chat.animate({ scrollTop: chat[0].scrollHeight }, 600);
}

function connect() {
    var socket = new SockJS("/sock-js");
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function () {
        console.log('Connected: ');
        stompClient.subscribe('/user/queue/messages', function (response) {
            var message = JSON.parse(response.body);
            if (message.fromUser != myChatName)
                appendMessageFromNotMe(message, true);
            else {
                appendMessageFromMe(message, true);
                var content = $('.new-message .message-content').val("");
            }
        });

        stompClient.subscribe('/user/topic/read', function (response) {
            messageIsReaden(response.body);
        });

        stompClient.subscribe('/websockets/messages/dean', function (response) {
            var messages = JSON.parse(response.body);
            function compare(a,b) {
                if (a.timestamp < b.timestamp)
                    return -1;
                if (a.timestamp > b.timestamp)
                    return 1;
                return 0;
            }

            messages = messages.sort(compare);

            messages.forEach(function(message, i, messages) {
                if (message.fromUser == 'dean')
                    appendMessageFromNotMe(message, false);
                else
                    appendMessageFromMe(message, false);
                $('.chat .blocks').scrollTop($('.chat .blocks')[0].scrollHeight);
            });
        });

    });
}



function readMeassage(id) {
    stompClient.send("/websockets/messages/" + id +"/read", {}, JSON.stringify({}));
}

function messageIsReaden(id) {
    $('.chat .blocks .block[data-message-id="' + id + '"]').removeClass('unread');
}

$(document).ready(function(){
    myChatName = $('.content .chat').data('my-chat-name');
    $('.new-message .button').click(function (event) {
        event.preventDefault();
        var content = $('.new-message .message-content').val();
        if (content != "")
            stompClient.send("/websockets/messages", {}, JSON.stringify({'content': content, 'toUser' : 'dean'}));


    });
    connect();
});