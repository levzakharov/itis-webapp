<!DOCTYPE html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width">
    <title>Войти</title>
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700&amp;subset=cyrillic" rel="stylesheet">
    <link href="/css/style.css" type="text/css" rel="stylesheet"/>
    <link href="/css/window.css" type="text/css" rel="stylesheet" />
    <link href="/css/font-awesome.min.css" type="text/css" rel="stylesheet" />

    <script type="text/javascript" src="/webjars/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="/js/window.js"></script>
</head>
<body>
<div class="modal-container">
    <div class="modal">
        <i class="fa fa-times close" aria-hidden="true"></i>
        <a>За восстановлением пароля обратитесь к администратору</a>
    </div>
</div>
<div class="info-modal">
    <img src="/images/close.png">
    <p style="font-size: 16px; font-weight: bold; margin-bottom: 5px;">Добро пожаловать на портал группы 11-401!</p>
    <p>Для входа на портал Вы можете использовать следующие email:</p>
    <ul>
        <li>stud1@email.ru - студент</li>
        <li>stud3@email.ru -  студент и староста</li>
        <li>prep1@email.ru -  преподаватель</li>
    </ul>
    <p>Пароль: password</p>
    <p>Сервер перезапускается каждый день в 05:00.</p>
    <p>При перезапуске введенные данные будут сброшены.</p>
    <p><a href="goo.gl/95cYht" style="color: #feebff; text-decoration: underline">Ссылка на apk для Android</a></p>
    <p>Приятного пользования!</p>
    <p style="font-size: 12px;margin-top: 5px;">Для получения данных от аккаунта деканата обратитесь по телефону <br>
        <a href="tel:+79033443530" style="color: #feebff; text-decoration: underline">+79033443530</a> или telegram @arwres</p>
</div>
<div class="signin-container">
    <div class="signin">
        <div class="logo">
            <img src="/images/logo.png">
        </div>
        <div class="signin-content">
            <form action="/login/process" method="post">
                <input name="login" type="text" placeholder="Логин">
                <input name="password" type="password" placeholder="Пароль">
                <label><input type="checkbox" name="remember-me" checked/>Запомнить меня</label>
                <input type="submit" class="button" value="Войти">
            <#if error??>
                <div align="center" style="color: #ab2020;">Неправильный логин или пароль</div>
            </#if>
            </form>
            <div class="forgot">
                <a>Забыли свой пароль?</a>
            </div>
        </div>
    </div>
</div>
</body>
</html>
