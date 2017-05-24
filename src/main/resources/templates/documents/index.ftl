<#include "../main-template.ftl">

<#macro m_body>
<div class="title">Запросить справку</div>
<div class="filter">
    <a>Запросить справку об учебе в количестве: </a>
    <input type="text">
    <div class="button">Запросить</div>
</div>
<div class="history">
    <div class="title">История</div>
    <table>
        <thead>
        <tr>
            <th>Дата запроса</th>
            <th>Готовность</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>19.01.17</td>
            <td class="ready">Готово</td>
        </tr>
        <tr>
            <td>21.01.17</td>
            <td class="during">В процессе</td>
        </tr>
        </tbody>
    </table>
</div>
</#macro>

<@main title="Справки" customClass=["certificates"]/>
