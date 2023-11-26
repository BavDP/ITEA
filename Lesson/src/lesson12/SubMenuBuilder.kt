package lesson12

import MenuBuilder.ConsoleMenuBuilder
import lesson12.actions.Lesson12


class SubMenuBuilder {
    companion object {
        @JvmStatic
        fun getMenu(prnTitle: String): ConsoleMenuBuilder {
            val LESSON12 = "Lesson12"

            return ConsoleMenuBuilder(prnTitle)
                    .AddMenuItem("1", LESSON12, Lesson12())
                    .AddMenuItem("0", "Go to previous menu", null, true)
        }
    }
}
