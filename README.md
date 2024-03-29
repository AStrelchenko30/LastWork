# Что необходимо сделать
Нужно собрать бэкенд-часть сайта на Java.
# Бэкенд-часть проекта предполагает реализацию следующего функционала:
- Авторизация и аутентификация пользователей.
- Распределение ролей между пользователями: пользователь и администратор*.
- CRUD для объявлений на сайте: администратор может удалять или редактировать все объявления, а пользователи — только свои.
- Под каждым объявлением пользователи могут оставлять отзывы.
- В заголовке сайта можно осуществлять поиск объявлений по названию.
- Показывать и сохранять картинки объявлений*.
# Этапы проекта:
**Этап I.** Настройка Spring-проекта

**Этап II.** Настройка авторизации и аутентификации.

**Этап III.** Описание моделей объявлений и отзывов.

**Этап IV.** Определение permissions к контроллерам.

**Этап V.** Сохранение и получение картинок. 

**Этап VI.** Финальная доработка проекта и создание презентации.
# Исходные данные:
https://github.com/skypro-backend/example-for-graduate-work.git
# Фронтенд контейнер для Docker’а
docker run --rm --name adsclient -p3000:3000 adsclient:v16 http://localhost:3000
