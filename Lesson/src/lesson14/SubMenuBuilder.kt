package lesson14

import MenuBuilder.ConsoleMenuBuilder
import lesson14.actions.Lesson14

class SubMenuBuilder {
    companion object {
        @JvmStatic
        fun getMenu(prnTitle: String): ConsoleMenuBuilder {
            val LESSON14 = "Lesson14"

            return ConsoleMenuBuilder(prnTitle)
                    .AddMenuItem("1", LESSON14, Lesson14())
                    .AddMenuItem("0", "Go to previous menu", null, true)
        }
    }
}