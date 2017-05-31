<#include "../main-template.ftl">

<#macro m_body>
<div class="title"><a href="/accounts">Список пользователей</a></div>
    <#if error??>
    ${error}
    </#if>
    <@security.authorize access="hasAnyRole('ADMIN')">
        <div class="add">
            <div class="button">Загрузить список пользователей CSV</div>
            <div class="cancel">Отменить</div>
            <div class="block">
                <div class="title">Загрузка документа</div>
                <form action="/accounts/new" method="post" enctype="multipart/form-data">
                    <div class="name">
                        <label> Пользователи
                            <input type="file" multiple name="file"></label>
                    </div>
                    <input type="submit" value="Загрузить">
                </form>
            </div>
        </div>
    </@security.authorize>

    <#--<@security.authorize access="hasAnyRole('WORKER', 'ADMIN')">-->
    <#--<div class="add">-->
        <#--<div class="button">Добавить пользователя</div>-->
        <#--<div class="cancel">Отменить</div>-->
        <#--<div class="block">-->
            <#--<div class="title">Создание пользователя</div>-->
            <#--<form>-->
                <#--<div class="name">-->
                    <#--<input type="text" name="surname" placeholder="Фамилия">-->
                    <#--<input type="text" name="firstName" placeholder="Имя">-->
                    <#--<input type="text" name="lastName" placeholder="Отчество">-->
                <#--</div>-->
                <#--<div class="name">-->
                    <#--<select name="usertype">-->
                        <#--<option>Студент</option>-->
                        <#--<option>Сотрудник</option>-->
                        <#--<option>Староста</option>-->
                        <#--<option>Преподаватель</option>-->
                    <#--</select>-->
                <#--</div>-->

                <#--<div class="name">-->
                    <#--<select name="group">-->
                        <#--<#list userGroups as userGroup>-->
                            <#--<option>${userGroup.number}</option>-->
                        <#--</#list>-->
                    <#--</select>-->
                <#--</div>-->

                <#--<div class="name">-->
                    <#--<label>Дата рождения: <input type="date" name="birthday" placeholder="Дата рождения">-->
                    <#--</label>-->

                <#--</div>-->
                <#--<div class="name">-->
                    <#--<label>Номер телефона: <input type="tel" name="phone"></label>-->
                <#--</div>-->
                <#--<div class="name">-->
                    <#--<label>Email: <input type="email" name="email"></label>-->
                <#--</div>-->
                <#--<div class="name">-->
                    <#--<label>Контракт: <input type="radio" name="contract" value="contract"></label>-->
                <#--</div>-->

                <#--<input type="submit" value="Создать">-->
            <#--</form>-->
        <#--</div>-->
    <#--</div>-->
    <#--</@security.authorize>-->

<div class="blocks">
    <div class="block">
        <div class="image">
            <a>С</a>
        </div>
        <div class="name">Мельников Станислав Викторович</div>
        <div class="buttons">
            <i class="fa fa-pencil-square-o" aria-hidden="true"></i>
            <i class="fa fa-times" aria-hidden="true"></i>
        </div>
        <div class="edit">
            <div class="title">Редактирование пользователя</div>
            <form>
                <div class="name">
                    <input type="text" value="Мельников">
                    <input type="text" value="Станислав">
                    <input type="text" value="Викторович">
                </div>
                <div class="usertypeedit">
                    <select name="usertypeedit">
                        <option>Студент</option>
                        <option>Сотрудник</option>
                        <option>Староста</option>
                        <option>Преподаватель</option>
                    </select>
                </div>
                <input type="submit" value="Применить">
            </form>
        </div>
    </div>
</div>
</#macro>

<@main title="Пользователи" customScripts=["/js/news.js"] customClass=["docs"] customStyles=["/css/docs.css"]/>
