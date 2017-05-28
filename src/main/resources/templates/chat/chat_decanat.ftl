<#include "../main-template.ftl">

<#macro m_body>
<div class="title">Переписка со студентами</div>
<div class="students">
    <div class="search">
        <form action="">
            <input type="text" placeholder="ФИО">
            <div class="button">
                <i class="fa fa-search" aria-hidden="true"></i>
            </div>
        </form>
    </div>
    <div class="list">
        <div class="block">
            <div class="image"><a>Д</a></div>
            <div class="info">
                <div class="name">ФИО</div>
                <div class="course">
                    3 курс
                </div>
            </div>
        </div>
        <div class="block current">
            <div class="image"><a>Д</a></div>
            <div class="info">
                <div class="name">ФИО</div>
                <div class="course">
                    3 курс
                </div>
            </div>
        </div>
        <div class="block">
            <div class="image"><a>Д</a></div>
            <div class="info">
                <div class="name">ФИО</div>
                <div class="course">
                    3 курс
                </div>
            </div>
        </div>
        <div class="block">
            <div class="image"><a>Д</a></div>
            <div class="info">
                <div class="name">ФИО</div>
                <div class="course">
                    3 курс
                </div>
            </div>
        </div>
    </div>
</div>
<div class="chat">
    <div class="blocks">
        <div class="block me">
            <div class="image"><a>Д</a></div>
            <div class="message">
                <div class="date">22 марта в 22.40</div>
                <div class="text">
                    Че надо?
                </div>
            </div>
        </div>
        <div class="block notme">
            <div class="image"><a>C</a></div>
            <div class="message">
                <div class="name">ФИО</div>
                <div class="date">22 марта в 22.40</div>
                <div class="text">
                    Можно занятие перенести?
                </div>
            </div>
        </div>
        <div class="block me">
            <div class="image"><a>Д</a></div>
            <div class="message">
                <div class="date">22 марта в 22.40</div>
                <div class="text">
                    Нет
                </div>
            </div>
        </div>
    </div>
    <div class="write">
        <form action="">
            <input type="text" placeholder="Введите сообщение">
            <div class="button">
                <i class="fa fa-paper-plane" aria-hidden="true"></i>
            </div>
        </form>
    </div>
</div>
</#macro>

<@main title="Чат" customClass=["chat", "chat_decanat"] customStyles=["/css/chat.css"]/>