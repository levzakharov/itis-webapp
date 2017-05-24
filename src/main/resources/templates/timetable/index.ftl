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
                <input type="hidden" name="interval" value="monday">
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
<#--<div class="panel">
    <div class="days">
        <select name="days">
            <option>Пн</option>
            <option>Вт</option>
            <option>Ср</option>
            <option>Чт</option>
            <option>Пт</option>
            <option>Сб</option>
            <option>Вс</option>
        </select>
    </div>
</div>-->
<div class="response-container">

</div>
</#macro>

<@main title="Расписание" customScripts=["/js/timetable.js"]/>
