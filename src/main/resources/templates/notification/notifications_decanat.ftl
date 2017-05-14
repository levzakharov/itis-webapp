<#include "../main-template.ftl">
<#macro m_body>
<div class="title">Уведомления</div>
<div class="add">
    <div class="button">Добавить уведомление</div>
    <div class="cancel">Отменить</div>
    <div class="block">
        <div class="title">Создание уведомления</div>
        <form>
            <div class="name">
                <div class="sub">Кому</div>
                <select multiple="multiple">
                    <optgroup label="Group 1">
                        <option value="1">000</option>
                        <option value="2">001</option>
                        <option value="3">2</option>
                        <option value="4">3</option>
                        <option value="5">4</option>
                    </optgroup>
                    <optgroup label="Group 2">
                        <option value="6">23</option>
                        <option value="7">002321</option>
                        <option value="8">22</option>
                        <option value="9">23</option>
                        <option value="10">433</option>
                    </optgroup>
                </select>
            </div>
            <div class="text">
                <textarea placeholder="Текст"></textarea>
            </div>
            <img>
            <input type="submit" value="Создать">
        </form>
    </div>
</div>
<div class="blocks">
    <div class="block">
        <div class="name">ФИО</div>
        <div class="date">28.06.2017</div>
        <div class="text">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum</div>
    </div>
    <div class="block">
        <div class="name">ФИО</div>
        <div class="date">28.06.2017</div>
        <div class="text">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum</div>
    </div>
    <div class="block">
        <div class="name">ФИО</div>
        <div class="date">28.06.2017</div>
        <div class="text">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum</div>
    </div>
    <div class="block">
        <div class="name">ФИО</div>
        <div class="date">28.06.2017</div>
        <div class="text">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum</div>
    </div>
    <div class="block">
        <div class="name">ФИО</div>
        <div class="date">28.06.2017</div>
        <div class="text">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum</div>
    </div>
</div>
</#macro>
<@main title="Уведомления" username="Имя пользователя" customScripts=["/js/jquery-1.11.3.min.js", "/js/multiple-select.js", "/js/notifications.js"] customStyles=["/css/multiple-select.css"]/>