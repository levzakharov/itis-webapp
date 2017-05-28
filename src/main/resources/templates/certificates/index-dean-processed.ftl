<#include "../main-template.ftl">

<#macro m_body>
<div class="title">Обработанные запросы на справки</div>
<div class="history">
    <table>
        <thead>
        <tr>
            <th>Дата запроса</th>
            <th>ФИО студента</th>
            <th>Количество</th>
            <th>Статус</th>
        </tr>
        </thead>
        <tbody>
            <#list processed_requests as request>
                <#assign status = "${request.status}">
            <tr>
                <td>${request.date?number_to_datetime}</td>
                <td>${request.user.fullName}</td>
                <td>${request.amount}</td>
                <#if status == 'ACCEPTED'>
                    <td class="ready">Одобрено</td>
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

<@main title="Справки" customClass=["certificates"] customScripts=["/js/certificates.js"]/>
