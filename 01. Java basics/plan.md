# Java basics 1

## План

* Инфраструктура Java — JVM, JDK, байт-код, JIT, GC, утилиты java и javac
* Типы данных в Java, основные структуры управления (условие, цикл)
* Массивы
* Абстракция и инкапсуляция - классы и объекты, поля, методы, инициализаторы, статичные члены, константы
* Наследование — абстрактные классы
* Полиморфизм - интерфейсы

## Useful links
[Хорошая книга по основам Java](https://vk.com/wall-54530371_1604)

[Экспресс курс-шпаргалка](http://developer.alexanderklimov.ru/android/java/java.php)

[Дженерики](http://www.quizful.net/post/java-generics-tutorial)

## Домашнее задание

1) Самостоятельно изучить все темы с занятия, если что-то пропустили

2) Установить JDK, Intellij IDEA (бесплатную версию, есть под Windows, Linux и Mac)

3) Читать про обобщенные типы в Java (Generics)

4) Написать два метода:
  * Метод, принимающий двумерный массив-матрицу и выполняющий транспонирование этой матрицы с выводом результата.
  * Метод, принимающий две матрицы, который выводит на экран результат умножения первой матрицы на вторую.
Плюсом будет реализация ввода матриц из консоли.

5) Написать структуру классов для магазина электроники. Предполагается иметь товары разных типов с общими свойствами (цена, вес, цвет..). 
Написать отдельный класс "Склад", который хранит у себя массив товаров. У него должны быть методы для получения списка товаров, количества товаров, среднего веса всех товаров и получения статистики по цветам товаров (например "красный - 1шт, синий - 2шт")
