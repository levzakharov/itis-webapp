var stompClient = null;
var myChatName = null;

function appendUser(user) {
    var elem = '<div class="block" data-user="' + user.email + '" data-fullname="' + user.fullName +'">' +
        '<div class="info"> ' +
        '<div class="name">' +
            user.fullName +
        '</div> '  +
        '<div class="course">' +
        (user.userGroup == null ? '' : user.userGroup.number) +
        '</div>' +
        '<div class="course"> ' +
        '</div> ' +
        '</div> ' +
        '</div>';
    $('.students .list').append(elem);
}
function appendMessageFromNotMe(message, withScroll) {
    var content = message.content;
    var time = new Date(message.timestamp);
    var messageElem = '<div class="block notme">' +
        '<div class="image"><a>С</a></div> ' +
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

    readMeassage(message.id);
    if (withScroll)
        chat.animate({ scrollTop: chat[0].scrollHeight }, 600);
}

function appendMessageFromMe(message, withScroll){
    var content = message.content;
    var time = new Date(message.timestamp);
    var messageElem = '<div class="block me' + (message.unread != false ? ' unread' : '') + '" data-message-id="' + message.id + '">' +
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
}

function connect() {
    var socket = new SockJS("/sock-js");
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function () {
        stompClient.subscribe('/websockets/messages-preview', function (response) {
            var users = JSON.parse(response.body);
            users.forEach(function(user, i, users) {
                appendUser(user);
            });
        });

        stompClient.subscribe('/topic/read', function (response) {
            messageIsReaden(response.body);
        });

        stompClient.subscribe('/queue/messages', function (response) {
            var message = JSON.parse(response.body);
            if (message.fromUser != myChatName){
                if (message.fromUser == $('.students .list .block.active').data("user"))
                    appendMessageFromNotMe(message, true);
            }
            else {
                appendMessageFromMe(message, true);
                var content = $('.new-message .message-content').val("");
            }
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
            stompClient.send("/websockets/messages", {}, JSON.stringify({'content': content, 'toUser' : $('.students .list .block.active').data('user')}));
    });

    connect();


});

$(document).on('click', '.students .list .block', function () {
    if ($(this).hasClass('active'))
        return;
    $('.chat .blocks').html("");
    $('.students .list .block').removeClass("active");
    $(this).addClass('active');
    var currUser = $(this).data("user");
    stompClient.subscribe('/websockets/messages/' + currUser, function (response) {
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
                appendMessageFromMe(message, false);
            else
                appendMessageFromNotMe(message, false);
            $('.chat .blocks').scrollTop($('.chat .blocks')[0].scrollHeight);
        });

    });

});