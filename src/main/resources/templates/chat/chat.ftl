<#include "../main-template.ftl">

<#macro m_body>
<div class="title">Переписка с деканатом</div>
<div class="chat" data-my-chat-name="${my_chat_name}">
    <div class="blocks">

    </div>
    <div class="write new-message">
        <textarea class="message-content" placeholder="Введите сообщение" required></textarea>
        <div class="button">
            <i class="fa fa-paper-plane" aria-hidden="true"></i>
        </div>
    </div>
</div>
</#macro>

<@main title="Чат" customClass=["chat"] customStyles=["/css/chat.css"] customScripts=["/webjars/sockjs-client/sockjs.min.js", "/webjars/stomp-websocket/stomp.min.js", "/js/chat.js"]/>