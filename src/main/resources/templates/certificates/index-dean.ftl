<#include "../main-template.ftl">

<#macro m_body>
<div class="justify-container">
    <div class="title justify-block">Запросы на справки</div>
    <a class="justify-block" href="/certificates/processed">Обработанные</a>
    <div class="stretch"></div>
</div>
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
                    <button class="button accept" value="${request.id}">
                        Одобрить
                    </button>
                    <button class="button decline" value="${request.id}">
                        Отклонить
                    </button>
                </td>
            </tr>
            </#list>
        </tbody>
    </table>
</div>
</#macro>

<@main title="Справки" customClass=["certificates"] customScripts=["/js/certificates.js"]/>