<!DOCTYPE html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width">
    <title>Новости</title>
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700&amp;subset=cyrillic" rel="stylesheet">
    <link href="/css/style.css" type="text/css" rel="stylesheet" />
</head>
<body>
<div class="main">
    <aside>
        <div class="logo">
            <img src="/images/logo.png">
        </div>
        <div class="menu">
            <ul>
                <li><a href="#">Новости</a></li>
                <li><a href="#">Расписание</a></li>
                <li><a href="#">Баллы</a></li>
                <li><a href="#">Запрос в деканат</a></li>
                <li><a href="#">Документы</a></li>
            </ul>
        </div>
        <div class="exit">
            <a href="#">Выход</a>
        </div>
    </aside>
    <div class="container">
        <header>
            <div class="col-5">
            </div>
            <div class="col-5">
                <div class="user">
                    <a href="#">Denis</a>
                </div>
            </div>
        </header>
        <div class="content">

            <div class="blocks">
                <div class="block">
                    <div class="name">${post.title}</div>
                    <div class="date">${post.date?number_to_datetime}</div>
                    <div class="text">${post.text}</div>
                    <div class="image"></div>
                </div>
                <div class="block">
                    <h3>Редактировать новость</h3>
                    <form action="/posts/${post.id}" method="post">
                        <input type="hidden" name="action" value="update">
                        <div class="name"><label>Title: <input type="text" name="title" value="${post.title}"></label></div>
                        <div class="text"><label>Text: <textarea name="text">${post.text}</textarea></label></div>
                        <div><input type="submit" value="Save"></div>
                    </form>
                    <h3>Удалить новость</h3>
                    <form action="/posts/${post.id}" method="post">
                        <input type="hidden" name="action" value="delete">
                        <div><input type="submit" value="Удались новость"></div>
                    </form>
                </div>

            </div>
        </div>
    </div>
</div>
</body>
</html>
