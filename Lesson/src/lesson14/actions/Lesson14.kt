package lesson14.actions

import MenuBuilder.AbstractAction
import kotlin.random.Random

//  companion object
class DatabaseConnection() {
    companion object {
        private var connectHandle: Int = 0
        var url: String = ""
        fun connect() {
            connectHandle++
            println("Connected to $url with handle = ${connectHandle}")
        }
    }
}

// Object: Object Expression

enum class OutputFormat {
    lowerCase, upperCase
}
interface Runnable {
    fun run(format: OutputFormat): String
}
fun runner(runnable: Runnable) {
    val r = Random(100)
    println(runnable.run(if (r.nextInt() % 2 == 0) OutputFormat.lowerCase else OutputFormat.upperCase))
}

// Object: Object Declaration
class Logger(private val loggerId: Int) {
    fun log() {
        println("Logger $loggerId")
    }
}
object LoggerManager {
    private var loggerId = 0
    fun getLogger(): Logger = Logger(loggerId++)
}

class Lesson14: AbstractAction() {
    override fun doAction() {
        // Тут будет все, что касается 14-го урока, разделить на
        // отдельные пункты меню не вижу смысла в виду их мало функциональности
        println("*************  Пункт №1 - Singleton   ********************")
        DatabaseConnection.url = "https://mybase.com/lesson14"
        DatabaseConnection.connect()
        DatabaseConnection.connect()
        DatabaseConnection.connect()

        println("*************  Пункт №2 - Object: Object Expression   ********************")
        runner(object: Runnable {
            override fun run(format: OutputFormat): String {
                return when (format) {
                    OutputFormat.lowerCase -> "Part 2 of lesson14 is implemented".lowercase()
                    OutputFormat.upperCase -> "Part 2 of lesson14 is implemented".uppercase()
                }
            }
        })

        println("*************  Пункт №3 - Object: Object Declaration   ********************")
        val logInstance = LoggerManager.getLogger()
        logInstance.log()
        logInstance.log()
        LoggerManager.getLogger().log()
        LoggerManager.getLogger().log()

        println("*************  Пункт №4 - filter   ********************")
        val list = listOf("cat", "dog", "elephant", "lion")
        println( list.filter { elem -> elem.length > 5 })

        println("*************  Пункт №5 - map   ********************")
        println(listOf(1,2,3,4,5).map { elem -> when(elem) {
            1 -> "one"
            2 -> "two"
            3 -> "three"
            4 -> "four"
            5 -> "five"
            else -> ""
        } })
    }
}