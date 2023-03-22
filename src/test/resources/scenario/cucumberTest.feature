# language: ru
@withdrawal
Функция: Поиск товара

  @test
  Сценарий: Проверка наименования товара при поиске
    * Нажимаем кнопку 'Каталог'
    * Выбираем категорию товаров - "Комплектующие для ПК"
    * Ожидаем загрузку страницы Категории товаров
    * Выбираем подкатегорию товаров - "Видеокарты"
    * Проверяем заголовок на странице поиска - "Видеокарты"
    * Заполняем поля формы:
      | Цена от       | 20000 |
      | Производитель | ASRock   |
    * Нажимаем на найденного производителя
    * Ожидание результатов поиска
    * Проверить, что в поисковой выдаче не более 24 товаров
    * Сохранить наименование 1 товара в списке
    * В поисковую строку ввести запомненное значение, выполнить поиск
    * Проверить, что в поисковой выдаче товаров не более - 1
    * Проверить, что наименование товара соответствует сохраненному значению

#  @test
#  Сценарий: Проверка наименования товара при поиске
#    * Нажимаем кнопку 'Каталог'
#    * Выбираем категорию товаров - "Периферия"
#    * Ожидаем загрузку страницы Категории товаров
#    * Выбираем подкатегорию товаров - "Клавиатуры"
#    * Проверяем заголовок на странице поиска - "Клавиатуры"
#    * Заполняем поля формы:
#      | Производитель | A4Tech |
#      | Цена от       | 2000   |
#    * Нажимаем на найденного производителя
#    * Ожидание результатов поиска
#    * Проверить, что в поисковой выдаче не более 24 товаров
#    * Сохранить наименование 1 товара в списке
#    * В поисковую строку ввести запомненное значение, выполнить поиск
#    * Проверить, что в поисковой выдаче товаров не более - 1
#    * Проверить, что наименование товара соответствует сохраненному значению

#  @test
#  Структура сценария: Проверка наименования товара при поиске
#    * Нажимаем кнопку 'Каталог'
#    * Выбираем категорию товаров - "<Категория>"
#    * Ожидаем загрузку страницы Категории товаров
#    * Выбираем подкатегорию товаров - "<Подкатегория>"
#    * Проверяем заголовок на странице поиска - "<Заголовок>"
#    * Заполняем поля формы:
#      | Цена от       | <Цена от>       |
#      | Производитель | <Производитель> |
#    * Нажимаем на найденного производителя
#    * Ожидание результатов поиска
#    * Проверить, что в поисковой выдаче не более 24 товаров
#    * Сохранить наименование 1 товара в списке
#    * В поисковую строку ввести запомненное значение, выполнить поиск
#    * Проверить, что в поисковой выдаче товаров не более - 1
#    * Проверить, что наименование товара соответствует сохраненному значению
#
#    Примеры:
#      | Категория            | Подкатегория | Заголовок  | Цена от | Производитель |
#      | Комплектующие для ПК | Видеокарты   | Видеокарты | 20000   | Gigabyte      |
#      | Периферия            | Клавиатуры   | Клавиатуры | 2000    | A4Tech        |