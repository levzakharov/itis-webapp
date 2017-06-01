<#include "../main-template.ftl">

<#macro m_body>
<div class="title">Список пользователей</div>
<div class="add">
    <div class="button">Добавить пользователя</div>
    <div class="cancel">Отменить</div>
    <div class="block">
        <div class="title">Создание пользователя</div>
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
                <i class="fa fa-times" aria-hidden="true"></i>
            </div>
            <div class="edit">
                <div class="title">Информация о пользователе</div>
                <form>
                    <div class="name">
                        <input disabled type="text" value="${user.fullName}">
                    </div>
                    <div class="name">
                        <input disabled type="text" value="${user.email}">
                    </div>
                    <div class="name">
                        <input disabled type="date" value="Дата рождения: ${user.birthday?number_to_date}">
                    </div>
                    <div class="name">
                        <input disabled type="text" value="Телефон: ${user.phone}">
                    </div>
                    <#if user.userGroup??>
                        <div class="name">
                            <input disabled type="text" value="Группа: ${user.userGroup.number}">
                        </div>
                        <div class="name">
                            <input disabled type="text" value="Форма обучения: <#if user.contract>контракт<#else>бюджет</#if>">
                        </div>
                    </#if>
                </form>
            </div>
        </div>
    </#list>
</div>
</#macro>

<@main title="Аккаунты" customClass=["users"] customStyles=["/css/users.css"] customScripts=["/js/users.js", "/js/multiple-select.js"]/>