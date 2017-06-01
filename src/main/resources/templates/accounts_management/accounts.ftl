<#include "../main-template.ftl">

<#macro m_body>
<div class="title">Список пользователей</div>
<div class="add">
    <div class="button" style="float: right;">Добавить/обновить пользователей</div>
    <div class="cancel">Отменить</div>
    <div class="block">
        <div class="title">Загрузить список пользователей CSV</div>
        <form action="/accounts/new" method="post" enctype="multipart/form-data">
            <div class="name">
                <label> Пользователи
                    <input type="file" multiple name="file"></label>
            </div>
            <input type="submit" value="Загрузить">
        </form>
    </div>
</div>
<div class="blocks">
    <#list users as user>
        <div class="block" data-user-id="${user.id}">
            <div class="image">
                <a>
                    <#list user.roles as role >
                        <#assign userRole = "${role}">

                        <#if userRole == 'STAROSTA'>
                            С
                            <#break>
                        </#if>

                        <#if userRole == 'TEACHER'>
                            П
                            <#break>
                        </#if>

                        <#if userRole == 'WORKER'>
                            Д
                            <#break>
                        </#if>
                    </#list>
                </a>
            </div>
            <div class="name">${user.fullName}</div>
            <div class="buttons">
                <i class="fa fa-search" aria-hidden="true"></i>

                <#if user.enabled>
                    <form action="/accounts/${user.id}/ban" name="ban_${user.id}" method="post"></form>
                    <i class="fa fa-ban" onclick="document.forms['ban_${user.id}'].submit();" aria-hidden="true"></i>
                <#else>
                    <form action="/accounts/${user.id}/unban" name="unban_${user.id}" method="post"></form>
                    <i class="fa fa-check" onclick="document.forms['unban_${user.id}'].submit();"
                       aria-hidden="true"></i>
                </#if>
            </div>
            <div class="edit">
                <div class="title">Информация о пользователе</div>
                <form>
                    <div class="name">
                        <input disabled type="text" value="${user.fullName}">
                    </div>
                    <div class="name">
                        <input disabled type="text" value="Аккаунт: <#if user.enabled>активен<#else>заблокирован</#if>">
                    </div>
                    <div class="name">
                        <input disabled type="text" value="${user.email}">
                    </div>
                    <div class="name">
                        <input disabled type="text"
                               value="Дата рождения: <#if user.birthday??>${user.birthday?number_to_date}</#if>">
                    </div>
                    <div class="name">
                        <input disabled type="text" value="Телефон: <#if user.phone??>${user.phone}</#if>">
                    </div>
                    <#if user.userGroup??>
                        <div class="name">
                            <input disabled type="text"
                                   value="Группа: <#if user.userGroup??>${user.userGroup.number}</#if>">
                        </div>
                        <div class="name">
                            <input disabled type="text"
                                   value="Форма обучения: <#if user.contract>контракт<#else>бюджет</#if>">
                        </div>
                        <div class="name">
                            <input disabled type="text" value="Год поступления: ${user.userGroup.startYear}">
                        </div>
                    </#if>
                </form>
            </div>
        </div>
    </#list>
</div>
</#macro>

<@main title="Аккаунты" customClass=["users"] customStyles=["/css/users.css"] customScripts=["/js/users.js", "/js/multiple-select.js"]/>