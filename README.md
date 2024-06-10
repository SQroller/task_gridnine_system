# task_gridnine_system
## Выполнение тестового задания на позицию Java Developer.
### Файловая организация проекта.

task_gridnine_system/src/\
├── "_"main/\
│   ├── java/\
│   │   └── com/\
│   │       └── gridnine/\
│   │           └── testing/\
│   │               ├── Solution.java\
│   │               │   ├── DepartureBeforeNowFilter - **Фильтр, исключающий перелёты с вылетом до текущего момента времени.**\
│   │               │   ├── ArrivalBeforeDepartureFilter - **Фильтр, исключающий перелёты, где имеются сегменты с датой прилёта раньше даты вылета.**\
│   │               │   ├── ExcessiveGroundTimeFilter - **Фильтр, исключающий перелёты, где общее время на земле превышает два часа.**\
│   │               │   └── FlightFilter - **Интерфейс для правил фильтрации.**\
│   │               ├── TestClasses.java\
│   │               │   ├── FlightBuilder\
│   │               │   ├── Flight\
│   │               │   └── Segment\
│   │               └── Main.java\
│   └── resources/\
│       ├── questionary.odt - **Вопросы о Java с ответами.**\
│       └── test-instructions.odt - **Постановка задачи.**\
└── test/java/com/gridnine/testing/FlightFilterTest.java - тестирование **DepartureBeforeNowFilter**, **ArrivalBeforeDepartureFilter**, **ExcessiveGroundTimeFilter**.
### Используемые зависимости.
Для тестирования:\
JUnit 5\
junit-jupiter-engine 5.7.0
