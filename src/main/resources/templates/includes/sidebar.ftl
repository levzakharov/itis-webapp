<aside>
    <div class="logo">
        <img src="/images/logo.png">
    </div>
    <div class="menu">
        <ul>
            <li><i class="fa fa-newspaper-o" aria-hidden="true"></i><a href="/news">Новости</a></li>
            <li><i class="fa fa-calendar" aria-hidden="true"></i><a href="/timetable">Расписание</a></li>
            <li><i class="fa fa-check" aria-hidden="true"></i><a href="/raiting">Баллы</a></li>
           <@security.authorize access="hasAnyRole('WORKER', 'STAROSTA','STUDENT')">
              <li><i class="fa fa-university" aria-hidden="true"></i><a href="/certificates">Запрос в деканат</a></li>
           </@security.authorize>
            <li><i class="fa fa-file" aria-hidden="true"></i><a href="/documents">Документы</a></li>
            <li><i class="fa fa-paper-plane" aria-hidden="true"></i><a href="/chat">Чат</a></li>
        </ul>
    </div>
    <div class="exit">
        <i class="fa fa-sign-out" aria-hidden="true"></i><a href="/logout">Выход</a>
    </div>
</aside>

<div class="menu-mobile">
    <div class="menu">
        <ul>
            <li><i class="fa fa-newspaper-o" aria-hidden="true"></i><a href="/news">Новости</a></li>
            <li><i class="fa fa-calendar" aria-hidden="true"></i><a href="/timetable">Расписание</a></li>
            <li><i class="fa fa-check" aria-hidden="true"></i><a href="/raiting">Баллы</a></li>
            <li><i class="fa fa-university" aria-hidden="true"></i><a href="/certificates">Запрос в деканат</a></li>
            <li><i class="fa fa-file" aria-hidden="true"></i><a href="/documents">Документы</a></li>
            <li><i class="fa fa-paper-plane" aria-hidden="true"></i><a href="/chat">Чат</a></li>
        </ul>
    </div>
    <div class="exit">
        <i class="fa fa-sign-out" aria-hidden="true"></i><a href="/logout">Выход</a>
    </div>
    <div class="user">
        <a href="/notifications">
            <div class="notif">
                <i class="fa fa-bell" aria-hidden="true"></i>
                <div class="count">
                    <span>${unread_notifications_count}</span>
                </div>
            </div>
        </a>
        <a href="#">${username}</a>
    </div>
</div>