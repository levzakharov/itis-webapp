# Веб-приложение для корпоративного портала ИТИС

Разрабатываемая система предназначена для пользования студентами, преподавателями и сотрудниками Высшей Школы ИТИС. 

###### Цели создания системы:
- облегчить и ускорить работу студентов, преподавателей и сотрудников деканата ВШ ИТИС;
- объединить задачи, ранее выполняемые в разных сервисах;
- облегчить взаимодействие разных категорий пользователей.

###### При реализации были поставлены следующие задачи:
- обеспечить быстрый и удобный просмотр расписания и новостей (для всего института и для своей группы);
- обеспечить возможность отправки и получения уведомлений;
- обеспечить просмотр успеваемости студентов;
- реализовать возможность получения сотрудниками деканата заявлений на выдачу различных справок.


###### Для разработки:
#### Property проекта
1. создать файл **application.properties** аналогично **application.properties.origin**. При необходимости измените параметры под себя.

#### Создание миграций:
1. В директории db/initial : __название таблицы__.xml
2. Остальные изменения в db
3. В **author** changeset\`а указываем свой ник на гитхабе. В **id** - название файла и порадковый номер chageset\`а в файле
4. Импортим созданные миграции в **changelog.xml** в нужном порядке

#### Тестовые пользователи
- starosta-304@test.com, password
- stud-304@test.com, password 
- worker@test.com, password 
- admin@test.com, password 
- teacher@test.com, password 
- stud-405@test.com, password 
- stud-601@test.com, password 
- stud-501@test.com, password 
- stud-401@test.com, password 
- stud-302@test.com, password 
- stud-201@test.com, password 
- stud-101@test.com, password 
- stud-402@test.com, password 
- stud-502@test.com, password 
- stud-303@test.com, password 