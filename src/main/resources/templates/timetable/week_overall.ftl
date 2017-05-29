<#assign days = {
    "MONDAY": "Понедельник",
    "TUESDAY": "Вторник",
    "WEDNESDAY": "Среда",
    "THURSDAY": "Четверг",
    "FRIDAY": "Пятница",
    "SATURDAY": "Суббота",
    "SUNDAY": "Воскресенье"
}>

<div class="table">
    <table>
        <thead>
        <tr>
            <th></th>
            <th></th>
        <#list userGroups as group>
            <th>${group.number}</th>
        </#list>

        </tr>
        </thead>
        <tbody>
        <#list timetable as day, mapday>
            <#assign i = 0>
            <#list mapday as time, maptime>
            <tr><#if i == 0>
                <td rowspan="${mapday?size}">${days[day]}</td></#if>
                <#assign i++>
                <td>${time}</td>
                <#list userGroups as group>
                    <td>
                        <#list maptime as event>
                        <#if event.userGroup.id == group.id>
                        ${event.description}
                        </#if>
                        </#list>
                    </td>
                </#list>
            <#--<#list maptime as event>-->
            <#--<td><#if event.userGroup.id == userGroups[num].id>-->
            <#--${event.description}-->
            <#--</#if></td>-->
            <#--</#list>-->
            </tr>

            </#list>
        </#list>
        </tbody>
    </table>
</div>