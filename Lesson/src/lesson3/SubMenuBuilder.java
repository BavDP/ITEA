package lesson3;

import MenuBuilder.ConsoleMenuBuilder;

public class SubMenuBuilder {
    static public ConsoleMenuBuilder getMenu(String prnTitle) {
        final String STRING_TASKSS = "Strings tasks";
        final String CLASS_TASKS = "Class tasks";
        return new ConsoleMenuBuilder(prnTitle)
                .AddMenuItem("1", STRING_TASKSS, lesson3.strings.SubMenuBuilder.getMenu(prnTitle + " -> " + STRING_TASKSS), false)
                .AddMenuItem("1", CLASS_TASKS, lesson3.strings.SubMenuBuilder.getMenu(prnTitle + " -> " + CLASS_TASKS), false)
                .AddMenuItem("0", "Go to previous menu", null, true);
    }
}
