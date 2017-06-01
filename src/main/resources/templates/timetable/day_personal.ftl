<#assign security=JspTaglibs["/META-INF/security.tld"] />

<#include "days_form.ftl">
<div class="table dayp">
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
                                    <p>
                                        <@security.authorize access="hasAnyRole('TEACHER')">
                                            (${event.userGroup.number}) ${event.name}, ${event.place}
                                        </@security.authorize>
                                    <p><@security.authorize access="!hasAnyRole('TEACHER')">
                                    ${event.name} , ${event.description}, ${event.place}
                                    </@security.authorize>
                                    </p>
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

