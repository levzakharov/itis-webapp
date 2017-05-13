<!DOCTYPE html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width">
    <title>Войти</title>
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700&amp;subset=cyrillic"
          rel="stylesheet">
    <link href="/css/style.css" type="text/css" rel="stylesheet"/>
</head>
<body>
<div class="signin-container">
    <div class="signin">
        <div class="logo">
            <img src="images/logo.png">
        </div>
        <div class="signin-content">
            <form action="/login" method="post">
                <input name="username" type="text" placeholder="Логин">
                <input name="password" type="text" placeholder="Пароль">
                <input type="submit" class="button" value="Войти">
            </form>
            <div class="forgot">
                <a href="#">Забыли свой пароль?</a>
            </div>
        </div>
    </div>
</div>
</body>
</html>
