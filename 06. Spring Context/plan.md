# Introduction to Spring

[Документация] (http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/)

## План

* Что такое Spring и зачем он нужен?
* Подготовка конфигурации
* Настройка бинов
  * Объявление простого бина
  * Передача параметров в конструктор
  * Внедрение свойств
  * Ссылка на другой бин
  * factory-method
  * scope
  * Внедрение свойств-коллекций
* Автоматическое связывание свойств компонентов
  * По имени
  * По типу
  * Через конструктор
  * Автоопределение
* Связывание с помощью аннотаций
* Автоматическое определение компонентов



## Useful links
[Книга Spring in action](https://www.assembla.com/spaces/gorsv/documents/aZ5WPupOSr457dacwqEsg8/download/aZ5WPupOSr457dacwqEsg8) (Глава 2)

[Хорошее видео про IoC](http://www.youtube.com/watch?v=ZdBwF26oWhs)

[Википедия](https://ru.wikipedia.org/wiki/%D0%98%D0%BD%D0%B2%D0%B5%D1%80%D1%81%D0%B8%D1%8F_%D1%83%D0%BF%D1%80%D0%B0%D0%B2%D0%BB%D0%B5%D0%BD%D0%B8%D1%8F)

## Домашнее задание

Дописать приложение с прошлого занятия. Подключить Spring. Для сохранения, удаления и изменения твитов использовать отдельные сервлеты, в каждый из которых должно внедряться хранилище твитов. Хранилище должно иметь какие-либо настройки (например, максимальное количество комментариев)
Попробовать внедрение через xml и через аннотации.

Контекст спринга можно подключить к веб приложению, добавив в web.xml
```xml
<context-param>
    <param-name>contextConfigLocation</param-name>
    <param-value>/WEB-INF/applicationContext.xml (Или ваш путь)</param-value>
</context-param>

<listener>
   <listener-class>
        org.springframework.web.context.ContextLoaderListener
   </listener-class>
</listener> 
```

Чтобы поэкспериментировать, можно получить доступ к контексту, вызвав
```java
WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(servlet.getServletContext());
SomeBean someBean = (SomeBean) ctx.getBean("someBean");
```




