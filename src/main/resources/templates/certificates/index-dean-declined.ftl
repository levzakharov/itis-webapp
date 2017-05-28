<#include "../main-template.ftl">

<#macro m_body>
<div class="title">Отклоненные запросы на справки</div>
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
            <#list declined_requests as request>
            <tr>
                <td>${request.date?number_to_datetime}</td>
                <td>${request.user.fullName}</td>
                <td>${request.amount}</td>
                <td>
                    <div class="unsuccess">
                        Не одобрено
                    </div>
                </td>
            </tr>
            </#list>
        </tbody>
    </table>
</div>
</#macro>

<@main title="Справки" customClass=["certificates"] customScripts=["/js/certificates.js"]/>