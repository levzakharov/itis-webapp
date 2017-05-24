<#include "../main-template.ftl">

<#macro m_body>
<div class="title">Запросы на справки</div>
<div class="history">
    <table>
        <thead>
        <tr>
            <th>ФИО студента</th>
            <th>Количество</th>
            <th>Одобрить</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>Шарипова Лия Ильдаровна</td>
            <td>3</td>
            <td>
                <div class="button">Одобрить</div>
            </td>
        </tr>
        <tr>
            <td>Красноперова Елена Андреевна</td>
            <td>1</td>
            <td>
                <div class="button">Одобрить</div>
            </td>
        </tr>
        <tr>
            <td>Шарипова Лия Ильдаровна</td>
            <td>3</td>
            <td>
                <div class="button">Одобрить</div>
            </td>
        </tr>
        <tr>
            <td>Красноперова Елена Андреевна</td>
            <td>1</td>
            <td>
                <div class="button">Одобрить</div>
            </td>
        </tr>
        </tbody>
    </table>
</div>
</#macro>

<@main title="Справки" customClass=["certificates"]/>
