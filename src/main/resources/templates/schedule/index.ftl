<#include "../main-template.ftl">

<#macro m_body>
<div class="upload">
    <a href="#">Загрузить расписание через csv файл</a>
</div>
<div class="filter">
    <div class="title">Выберите формат:</div>
    <form class="schedule-form">
        <div class="modes">
            <div class="size">
                <div class="button active">День</div>
                <div class="button">Неделя</div>
                <input type="hidden" name="interval" value="day">
            </div>
            <div class="type">
                <div class="button active">Личный</div>
                <div class="button">Общий</div>
                <input type="hidden" name="personality" value="private">
            </div>
            <input type="submit" value="Изменить" class="button enter">
        </div>
    </form>
</div>

<div class="response-container">

</div>
</#macro>

<@main title="Расписание" customScripts=["/js/jquery-1.11.3.min.js", "/js/schedule.js"]/>
