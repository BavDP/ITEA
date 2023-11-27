package lesson13

import MenuBuilder.ConsoleMenuBuilder
import lesson13.actions.Lesson13

class SubMenuBuilder {
    companion object {
        @JvmStatic
        fun getMenu(prnTitle: String): ConsoleMenuBuilder {
            val LESSON13 = "Lesson13"

            return ConsoleMenuBuilder(prnTitle)
                    .AddMenuItem("1", LESSON13, Lesson13())
                    .AddMenuItem("0", "Go to previous menu", null, true)
        }
    }
}