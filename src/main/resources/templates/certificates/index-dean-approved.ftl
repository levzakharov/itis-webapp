<#include "../main-template.ftl">

<#macro m_body>
<div class="title">Запросы на справки</div>
<div class="history">
    <table>
        <thead>
        <tr>
            <th>Дата запроса</th>
            <th>ФИО студента</th>
            <th>Количество</th>
            <th>Одобрить</th>
        </tr>
        </thead>
        <tbody>
            <#list pending_requests as request>
            <tr>
                <td>${request.date?number_to_datetime}</td>
                <td>${request.user.fullName}</td>
                <td>${request.amount}</td>
                <td>
                    <div class="success">
                        Одобрено
                    </div>
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
