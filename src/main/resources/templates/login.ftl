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
                <div class="error-msg">Неправильный логин или пароль</div>
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
