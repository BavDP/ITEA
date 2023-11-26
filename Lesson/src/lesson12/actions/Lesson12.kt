package lesson12.actions

import MenuBuilder.AbstractAction

 // 1. Операции с примитивами:
 // функция, которая принимает 2 целых числа и возвращает их сумму
 //
fun sumInt(a: Int, b: Int) = a + b

interface Displayable {
    fun display()
}

class Person(name: String, age: Int): Displayable {

    // имя может изменяться
    var name: String = ""
        get() {
            return field
        }

    // возраст делаем только для чтения
    private val age: Int = age
        get() = field

    init {
        this.name = name
    }
    override fun display() {
        println("Имя: ${this.name} Возраст: ${this.age}")
    }

    override fun toString(): String {
        return "Имя: $name Возраст: $age"
    }
}

class Lesson12: AbstractAction() {
    override fun doAction() {
        //  ************* Тут будет все, что касается 12-го задания ******************

        // 1. функция, которая принимает 2 целых числа и возвращает их сумму
        println(" **** Пункт №1 **** :")
        println("Сумма целых чисел равна ${sumInt(3, 5)}")

        // 2. Работа со списками
        println(" **** Пункт №2 **** :")
        val listInt = listOf(1, 4, 6, 7, 8)
        println(listInt)
        // к списку добавляем новый элемент и выводим его на экран
        with (listInt.toMutableList()) {
            add(15)
            println(this)
        }

        // 3. создание класса Person и работа с его свойствами
        println(" **** Пункт №3 и №4 **** :")
        val person = Person("Oleksander", 33)
        println(person)
        person.name = "Peter"
        println(person)

        // 5. работа с интерфейсом
        println(" **** Пункт №5 **** :")
        val personMap = HashMap<String, Person>()
        // чтобы не дублировать значения имен в ключах и конструкторе используем with
        with(Person("Oleksander", 25)) {
            personMap.put(this.name, this)
        }
        with(Person("Peter", 18)) {
            personMap.put(this.name, this)
        }
        with(Person("Olga", 15)) {
            personMap.put(this.name, this)
        }
        with(Person("Oleg", 34)) {
            personMap.put(this.name, this)
        }
        personMap.forEach { (_, value) -> value.display() }
    }
}