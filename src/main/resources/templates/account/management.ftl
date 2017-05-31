<#include "../main-template.ftl">

<#macro m_body>
<div class="title"><a href="/accounts">Список пользователей</a></div>
    <#if error??>
    ${error}
    </#if>
    <@security.authorize access="hasAnyRole('WORKER', 'ADMIN')">
    <div class="add">
        <div class="button">Добавить пользователя</div>
        <div class="cancel">Отменить</div>
        <div class="block">
            <div class="title">Создание пользователя</div>
            <form>
                <div class="name">
                    <input type="text" placeholder="Фамилия">
                    <input type="text" placeholder="Имя">
                    <input type="text" placeholder="Отчество">
                </div>
                <div class="usertype">
                    <select name="usertype">
                        <option>Студент</option>
                        <option>Сотрудник</option>
                        <option>Староста</option>
                        <option>Преподаватель</option>
                    </select>
                </div>
                <input type="submit" value="Создать">
            </form>
        </div>
    </div>
    </@security.authorize>

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

<@main title="Новости" customScripts=["/js/news.js"] customClass=["docs"] customStyles=["/css/docs.css"]/>
