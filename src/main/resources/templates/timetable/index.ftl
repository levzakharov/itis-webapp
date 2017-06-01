<#include "../main-template.ftl">

<#macro m_body>
<div class="title">Расписание</div>
    <@security.authorize access="hasAnyRole('WORKER', 'ADMIN')">
    <div class="add">
        <div class="button">Загрузить расписание через csv файл</div>
        <div class="cancel">Отменить</div>
        <div class="block">
            <div class="title">Загрузка документа</div>
            <form action="/timetable/csv" method="post" enctype="multipart/form-data">
                <div class="name">
                    <label> CSV-файл
                        <input type="file" name="file"></label>
                </div>
                <input type="submit" value="Загрузить">
            </form>
        </div>
    </div>
    </@security.authorize>
    <#if error??>
    ${error}
    </#if>
<div class="filter">
    <div class="title">Выберите формат:</div>
    <form class="schedule-form">
        <div class="modes">
            <div class="type">
                <div class="button active private">Личное</div>
                <div class="button overall">Общее</div>
                <input type="hidden" name="personality" value="private">
            </div>
            <div class="size">
                <div class="button active">День</div>
                <div class="button week">Неделя</div>
                <input type="hidden" name="interval" value="monday">
            </div>
            <input type="submit" value="Изменить" class="button enter">
        </div>
    </form>
</div>

<div class="response-container">

</div>
</#macro>

<@main title="Расписание" customScripts=["/js/timetable.js", "/js/news.js"] customStyles=["/css/schedule.css"]/>
