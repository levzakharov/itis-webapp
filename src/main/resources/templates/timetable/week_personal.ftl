<div class="table">
    <table>
        <thead>
        <tr>
            <th>Время</th>
            <th>Пн</th>
            <th>Вт</th>
            <th>Ср</th>
            <th>Чт</th>
            <th>Пт</th>
            <th>Сб</th>
            <th>Вс</th>
        </tr>
        </thead>
        <tbody>
        <#list intervals as interval>
            <tr>
                <td>${interval}</td>
                <#list timetable as day, mapday>
                    <td>
                        <#list mapday as interval_m, events>
                            <#if interval_m == interval>
                                <#list events as event>
                                    ${event.description}
                                </#list>
                            </#if>
                        </#list>
                    </td>
                </#list>
            </tr>
        </#list>

        </tbody>
    </table>
</div>
