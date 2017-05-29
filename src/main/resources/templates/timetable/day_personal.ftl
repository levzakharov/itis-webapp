<#include "days_form.ftl">
<div class="table">
    <table>
        <thead>
        <tr>
            <th>Время</th>
            <th>Занятия</th>

        </tr>
        </thead>
        <tbody>
        <#list intervals as interval>
        <tr>
            <td>${interval}</td>
            <#list timetable as day, mapday>
                <#if day_of_week == day>
                <td>
                    <#list mapday as interval_m, events>
                            <#if interval_m == interval>
                        <#list events as event>
                        ${event.description}
                        </#list>
                    </#if>
                        </#list>
                </td>
                </#if>
            </#list>
        </tr>
        </#list>
        </tbody>
    </table>
</div>
