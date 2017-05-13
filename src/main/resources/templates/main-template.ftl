<#macro main title="ИТИС" username="" customScripts=[] customStyles=[]>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width">
    <title>${title}</title>
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700&amp;subset=cyrillic"
          rel="stylesheet">
    <link href="/css/style.css" type="text/css" rel="stylesheet"/>
</head>
<body>
<div class="main">
    <#include "includes/sidebar.ftl">
    <div class="container">
        <header>
            <div class="col-5">
            </div>
            <div class="col-5">
                <div class="user">
                    <a href="#">${username}</a>
                </div>
            </div>
        </header>
        <div class="content">
            <@m_body/>
        </div>
    </div>
</div>
</body>
</html>
</#macro>