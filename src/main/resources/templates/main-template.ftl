<#macro main title="ИТИС" username="" customScripts=[] customStyles=[] customFonts=[]>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width">
    <title>${title}</title>
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700&amp;subset=cyrillic"
          rel="stylesheet">
    <link href="/css/font-awesome.min.css" type="text/css"   rel="stylesheet" />
    <link href="/css/style.css" type="text/css" rel="stylesheet"/>
    <#list customStyles as style>
        <link href="${style}" type="text/css" rel="stylesheet"/>
    </#list>
    <#list customScripts as script>
        <script src="${script}" type="text/javascript"></script>
    </#list>
    <#list customFonts as font>
        <link href="${font}" type="text/css" rel="stylesheet" />
    </#list>
</head>
<body>
<div class="main">
    <#include "includes/sidebar.ftl">
    <div class="container">
        <#include "includes/header.ftl">
        <div class="content">
            <@m_body/>
        </div>
    </div>
</div>
</body>
</html>
</#macro>