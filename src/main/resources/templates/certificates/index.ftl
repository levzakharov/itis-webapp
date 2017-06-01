<#include "../main-template.ftl">

<#macro m_body>
<div class="title">Запросить справку</div>
<div class="filter">
    <@form.form commandName="request_creation_form" action="/certificates/new" method="post">
        <a>Запросить справку об учебе в количестве: </a>
        <@form.input type="number" step="1" path="amount" min="1" max="20"/>
        <input type="submit" class="button" value="Запросить">
        <div class="text">
            <@form.errors path="amount" cssStyle="color: #ab2020; padding-left: 10px"/>
        </div>
    </@form.form>
</div>
<div class="history">
    <div class="title">История</div>
    <table>
        <thead>
        <tr>
            <th>Дата запроса</th>
            <th>Количество</th>
            <th>Готовность</th>
        </tr>
        </thead>
        <tbody>
            <#list requests as request>
                <#assign status = "${request.status}">
            <tr>
                <td>${request.date?number_to_datetime}</td>
                <td>${request.amount}</td>
                <#if status == 'ACCEPTED'>
                    <td class="ready">Одобрено</td>
                </#if>
                <#if status == 'PENDING'>
                    <td class="during">В процессе</td>
                </#if>
                <#if status == 'DECLINED'>
                    <td class="declined">Отказано</td>
                </#if>
            </tr>
            </#list>
        </tbody>
    </table>
</div>
</#macro>

<@main title="Справки" customClass=["certificates"]/>