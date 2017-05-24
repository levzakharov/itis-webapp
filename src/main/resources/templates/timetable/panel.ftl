<#assign timetable = timetable/>
<#assign groups = timetable?keys>
<div class="table">
    <table>
        <thead>
        <tr>
            <th></th>
            <th></th>
        <#list groups as group>
            <th>${group.number}</th>
        </#list>
        </tr>
        </thead>
        <tbody>
        <tr>
        <#list groups as group>
            <#assign events = timetable?values[group_index]/>
            <#list events as event>
                <td>${event.interval}</td>
                <td rowspan="7">${event.day}</td>
                <td>${event.description}</td>
            </#list>
        </#list>
        </tr>
        </tbody>
    </table>
</div>