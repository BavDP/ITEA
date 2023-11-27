package lesson13.actions

import MenuBuilder.AbstractAction

class Person(var name: String?)

fun String.trimAndUpper(): String {
    return this.trim().uppercase()
}

fun displayPersonName(person: Person): String  = "Привіт, ${person.name?:"Аноним"}"


interface FormatOutput {
    fun outputInLine(value: String)
    fun outputFromNewLine(value: String)
    fun outputVertical(value: String)
}

class FormatOutputImpl: FormatOutput {
    override fun outputInLine(value: String) {
        print(value)
    }

    override fun outputFromNewLine(value: String) {
        println(value)
    }

    override fun outputVertical(value: String) {
        value.forEach { c -> println(c) }
    }
}

class FormatOutputDelegate(output: FormatOutput): FormatOutput by output {
    override fun outputVertical(value: String) {
        var margin = 0
        value.forEach { c ->
            val marginStr = "\t".repeat(margin)
            println(marginStr + c)
            margin++
        }
    }
}

class Lesson13 : AbstractAction() {
    override fun doAction() {
        // тут будет все, что касается урока 13

        // 1. класс Person
        println("**** Пункт №1 ****")
        var person = Person(null)
        println(displayPersonName(person))
        person = Person("Oleksander")
        println(displayPersonName(person))

        // 2. kotlin extension function
        println("**** Пункт №2 ****")
        val name = " Oleksander  "
        println(name.trimAndUpper())

        // 3. делегирование
        println("**** Пункт №3 ****")
        val output = FormatOutputImpl()
        output.outputVertical("Oleksander")
        val delegate = FormatOutputDelegate(output)
        delegate.outputVertical("Oleksander")
    }
}