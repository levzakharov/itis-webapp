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

    <#assign person = "">
    <#assign time = "">
    <@security.authorize access="hasAnyRole('WORKER', 'ADMIN')"><#assign person = "overall"><#assign time = "week"></@security.authorize>
    <@security.authorize access="hasAnyRole('STUDENT', 'STAROSTA', 'TEACHER')"><#assign person = "person"><#assign time = "monday"></@security.authorize>
<div class="filter">
    <div class="title">Выберите формат:</div>
    <form class="schedule-form">
        <div class="modes">
            <div class="type">
                <@security.authorize access="hasAnyRole('STUDENT', 'STAROSTA', 'TEACHER')">

                    <div class="button active private">Личное</div>
                </@security.authorize>

                <div class="button overall <@security.authorize access="hasAnyRole('WORKER', 'ADMIN')">active</@security.authorize>">Общее</div>
                <input type="hidden" name="personality" value="${person}">
            </div>
            <div class="size">
                <@security.authorize access="hasAnyRole('STUDENT', 'STAROSTA', 'TEACHER')">

                    <div class="button active">День</div>
                    <div class="button week">Неделя</div>
                </@security.authorize>

                <input type="hidden" name="interval" value="${time}">
            </div>
        </div>
    </form>
</div>

<div class="response-container">

</div>
</#macro>

<@main title="Расписание" customScripts=["/js/timetable.js", "/js/news.js"] customStyles=["/css/schedule.css"]/>
