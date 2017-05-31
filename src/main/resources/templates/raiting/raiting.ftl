<#include "../main-template.ftl">

<#macro m_body>
<div class="title">Рейтинг</div>
<div id="iframeHolder"></div>
</#macro>

<@main title="Баллы" customClass=["raiting"] customScripts=["/js/raiting.js"] customStyles=["/css/raiting.css"]/>