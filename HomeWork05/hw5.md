# • Домашняя работа 5. (Unit-tests gr.3623)

# Задание 1.

<aside>
💡 Задача - придумать как можно больше различных тестов (юнит-тесты, интеграционные тесты, сквозные тесты) для простого приложения - записной книжки.

</aside>

### Представим организацию кода через паттерн MVC.

### Пусть к Model относится класс ‘Contact’, к View класс ‘Show’, к Controller класс ‘Service’, 
а хранение организуем в ‘Repository’ (далее ‘Repo’).

# Юнит-тестирование

## Тестирование класса ‘Service’.

Создание экземпляров классов хранения записей ‘Repository’ и представления ‘Show’.

```java
testRepoCreation // unit -> валидация создания класса для хранения, возврат пустого хранилища
testShowCreation // unit -> валидация создания класса для представления, плюс 'ручное' тестирование визуализации графического интерфейса
```

Создание экземпляра класса ‘Contact’

```java
@BeforeEach
// создание заглушки stub для метода валидации обязательных полей

testContactCreation // unit -> проверка создания нового контакта
```

Тестирование основной логики

```java
// тестирование водимых данных пользователя (UserInput с точки зрения основной логики)
@BeforeEach
// организуем фейковые запросы от пользователя, эмулирующие нажатие мыши и ввода данных с клавиатуры -> fake UserInput
// создание заглушки для работы с базой данных -> mock Repo
// создание фейкового объекта контакт, вовзращаемого при запросе из базы данных -> fake Contact
// создание заглушки для работы с классом представлений -> dummy Show

// юнит-тесты -> вызовы логики
testServiceGetUserInput  // проверка ввода (клавиатура + мышь)

testServiceShowAddressBook        // вызов демонстрации списка контактов

testServiceClickAddContactButton  // вызов меню добавления контакта
testServiceShowAddContactWindow   // вызов демонстрации окна создания нового контакта
testServiceClickCreateButton      // вызов метода для создания контакта, а также метода по перерисовке представления
testServiceClickCancelButton      // вызов метода по перерисовке представления

testServiceClickEditContactButton  // вызов меню изменения контакта
testServiceShowEditContactWindow   // вызов демонстрации окна изменения контакта
testServiceClickSaveButton         // вызов метода валидации, затем сохранения, а также метода по перерисовке представления
testServiceClickCancelButton       // вызов метода по перерисовке представления

testServiceClickDeleteContactButton  // вызов меню удаления контакта
testServiceShowDeleteContactWindow   // вызов демонстрации окна удаления контакта
testServiceClickOKButton             // вызов метода для удаления контакта, а также метода по перерисовке представления
testServiceClickCancelButton         // вызов метода по перерисовке представления
```

## Тестирование класса ‘Show’.

Проверка методов представления.

```java
@BeforeEach
// создание заглушки для взаимодействия с контроллером -> mock Service
// организуем фейковые запросы от пользователя, эмулирующие нажатие мыши и ввода данных с клавиатуры -> fake UserInput

// юнит-тесты + 'ручное' тестирование -> вызовы функций представления и проверка визуализации
testShowAddressBook        // демонстрация списка контактов
testShowAddContactWindow   // демонстрация окна создания нового контакта
testShowEditContactWindow  // демонстрация окна изменения контакта

testClickAddContactButton  // проверка нажатия кнопки 'Добавить'
testClickCreateButton      // проверка нажатия кнопки 'Создать'
testClickCancelButton      // проверка нажатия кнопки 'Отменить'

testClickEditContactButton  // проверка нажатия кнопки 'Изменить'
testClickSaveButton         // проверка нажатия кнопки 'Сохранить'
testClickCancelButton       // проверка нажатия кнопки 'Отменить'

testClickDeleteContactButton  // проверка нажатия кнопки 'Удалить'
testClickOKButton             // проверка нажатия кнопки 'ОК'
testClickCancelButton         // проверка нажатия кнопки 'Отменить'
```

## Тестирование класса ‘Contact’.

Создание контакта (create).

```java
@BeforeEach
// создание заглушки для взаимодействия с базой данных -> mock Repo
// создание заглушки для взаимодействия с контроллером -> mock Service

// юнит-тесты -> валидация при создании новой записи 'Contact'
testCreateContactIdGenerationIsValid  // проверка корректности правил формирования id
testCreateContactFirstNameIsValid     // имя
testCreateContactLastNameIsValid      // фамилия
testCreateContactNickNameIsValid      // псевдоним
testCreateContactBirthdateIsValid     // дата рождения
testCreateContactEmailIsValid         // email
testCreateContactPhoneDictIsValid     // словарь с номерами телефонов с информацией hide/show и тэгами main/home/office/mobile
testCreateContactAddressIsValid       // адрес
testCreateContactRequiredFields       // протестировать корректность валидации на обязательные поля
```

Изменение контакта в два этапа чтение (read) и обновление (update), по сути проверка геттеров и сеттеров.

```java
@BeforeEach
// создание заглушки для работы с базой данных -> mock Repo
// создание фейкового объекта контакт, вовзращаемого при запросе из базы данных -> fake Contact

// юнит-тесты -> валидация при чтении 'Contact' из 'Repo'
testReadContactId              // id
testReadContactFirstName       // имя
testReadContactLastName        // фамилия
testReadContactNickName        // псевдоним
testReadContactBirthdate       // дата рождения
testReadContactEmail           // email
testReadContactPhoneDict       // словарь с номерами телефонов с информацией hide/show и тэгами main/home/office/mobile
testReadContactAddress         // адрес

// юнит-тесты -> валидация при обновлении 'Contact' в 'Repo'
testUpdateContactIdIsFailed        // проверка недопустимости изменения id
testUpdateContactFirstNameIsValid  // имя
testUpdateContactLastNameIsValid   // фамилия
testUpdateContactNickNameIsValid   // псевдоним
testUpdateContactBirthdateIsValid  // дата рождения
testUpdateContactEmailIsValid      // email
testUpdateContactPhoneDictIsValid  // словарь с номерами телефонов с информацией hide/show и тэгами main/home/office/mobile
testUpdateContactAddressIsValid    // адрес
testUpdateContactRequiredFields    // протестировать на обязательные поля при изменении контакта
```

## Тестирование класса ‘Repository’.

Проверка CRUD

```java
@BeforeEach
// создание заглушки для эмуляции запросов из контроллера -> fake Service
// создание фейкового объекта контакт, возвращаемого при запросе из базы данных -> fake Contact

// юнит-тесты -> валидация поведения экземпляра класса ‘Contact’ в 'Repo'
testRepoCreateContact  // проверка записи контакта в базу
testRepoReadContact    // проверка чтения контакта 
testRepoUpdateContact  // проверка обновления контакта
testRepoDeleteContact  // проверка удаления контакта
```

# Интеграционное тестирование

## Тестирование взаимодействия классов ‘Contact’ → ‘Service’ → ‘Repository’.

```java
@BeforeEach
// организуем фейковые запросы от пользователя, эмулирующие нажатие мыши и ввода данных с клавиатуры -> fake UserInput
// создадим несколько экземпляров класса 'Contact'

testAddingContactToRepo  // тестирование сохранения контактов в Repo

testReadingContactInfoFromRepoById         // тестирование поиска и чтения контакта из Repo по id
testReadingContactInfoFromRepoByFirstName  // тестирование поиска и чтения контакта из Repo по имени
testReadingContactInfoFromRepoByLastName   // тестирование поиска и чтения контакта из Repo по фамилии
testReadingContactInfoFromRepoByNickName   // тестирование поиска и чтения контакта из Repo по псевдониму
testReadingContactInfoFromRepoByBirthdate  // тестирование поиска и чтения контакта из Repo по дате рождения
testReadingContactInfoFromRepoByEmail      // тестирование поиска и чтения контакта из Repo по emailу
testReadingContactInfoFromRepoByPhone      // тестирование поиска и чтения контакта из Repo по номеру телефона
testReadingContactInfoFromRepoByAddress    // тестирование поиска и чтения контакта из Repo по адресу

testMassReadingContactsFromRepo  // тестирование поиска и чтения полей всех записей Repo
testMassReadingContactsFromRepoByQuery  // тестирование поиска и чтения полей всех записей Repo по поисковому запросу
```

## Тестирование взаимодействия классов ‘Service’ → ‘Repository’ → ‘Show’.

```java
@BeforeEach
// организуем фейковые запросы от пользователя, эмулирующие нажатие мыши и ввода данных с клавиатуры -> fake UserInput
// создадим несколько экземпляров класса 'Contact'

testContactCreateWindowWithInputCreate  // тестирование вызовов при создании нового контакта и выбором опции 'Создать'
testContactCreateWindowWithInputCancel  // тестирование вызовов при создании нового контакта и выбором опции 'Отмена'
testContactSaveToRepo                   // тестирование записи в Repo

testContactEditWindowWithInputSave    // тестирование вызовов при редактировании контакта и выбором опции 'Сохранить'
testContactEditWindowWithInputCancel  // тестирование вызовов при редактировании контакта и выбором опции 'Отмена'
testContactReadAndUpdateToRepo        // тестирование обновления контакта

testContactDeleteWindowWithInputOK      // тестирование вызовов при редактировании контакта и выбором опции 'Сохранить'
testContactDeleteWindowWithInputCancel  // тестирование вызовов при редактировании контакта и выбором опции 'Отмена'
testContactDeletion                     // тестирование удаление контакта
```

```java
@BeforeEach
// организуем фейковые запросы от пользователя, эмулирующие нажатие мыши и ввода данных с клавиатуры -> fake UserInput
// создадим несколько экземпляров класса 'Contact' и поместим их в 'Repo'

testRepoMassReadAndShowContacts         // тестирование чтения полей всех записей Repo и вывод информации в представление
testRepoMassReadAndShowContactsByQuery  // тестирование поиска и чтения полей всех записей Repo по поисковому запросу 
																				// и вывод инфо в представление
```

# Сквозное тестирование

## Тестирование цикла UserInput → ‘Service’ → ‘Contact’ → ‘Repository’ → ‘Show’.

```java
@BeforeEach
// создадим несколько экземпляров класса 'Contact' и поместим их в 'Repo'

testContactCreationFromInputToRepo  // тестирование цикла создания контакта, с пользовательского ввода до помещения в Repo

testContactMassReadAndShow  // тестирование цикла массового отображения в представлении всех прочитанных в Repo контактов
testContactMassReadAndShowByQuery  // тестирование цикла отображения в представлении прочитанных в Repo контактов по поисковому запросу

testContactEdit  // тестирование цикла редактирования контакта, теперь уже с использованием реального пользовательского ввода

testContactDeleteWindowWithInputOK      // тестирование удаления контакта
```

# Задание 2.

<aside>
💡 Задача - определить тип каждого теста (юнит-тест, интеграционный тест, сквозной тест) для следующего списка тестовых сценариев:

</aside>

### 1. Проверка того, что функция ‘addContact’ корректно добавляет новый контакт в список контактов.

Если окружить проверяемый модуль заглушками со стороны пользовательского ввода данных, метода валидации и репозитория, то можно изолированно протестировать вышеуказанную функцию. В таком случае такое тестирование называется модульным, или юнит тестированием.

### 2. Проверка того, что при добавлении контакта через пользовательский интерфейс, контакт корректно отображается в списке контактов.

Такой тест можно выполнить в рамках интеграционного тестирования. В тесте использовать заглушки для репозитория, а в ответ на запрос контакта, выдавать фейковый. Тогда с использованием правильно заглушенных сервиса и представления можно изолированно, в рамках нескольких модулей, протестировать вышеуказанную функцию.

### 3. Проверка полного цикла работы с контактом: создание контакта, его редактирование и последующее удаление.

Тестирование полного цикла называется сквозным, ‘end-to-end’ или ‘chain’ тестированием. Такой подход обычно затрагивает все элементы тестируемого приложения, а также проверку интеграции с внешними интерфейсами в случае их использования.