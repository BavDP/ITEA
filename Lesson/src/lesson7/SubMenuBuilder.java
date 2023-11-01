package lesson7;

import MenuBuilder.ConsoleMenuBuilder;
import lesson7.threads.ThreadAction;

public class SubMenuBuilder {
    static public ConsoleMenuBuilder getMenu(String prnTitle) {
        final String ENUMS = "Enums";
        final String THREADS = "Threads";


        return new ConsoleMenuBuilder(prnTitle)
                .AddMenuItem("1", ENUMS, lesson7.enums.SubMenuBuilder.getMenu(prnTitle + " -> " + ENUMS), false)
                .AddMenuItem("2", THREADS, new ThreadAction())
                .AddMenuItem("0", "Go to previous menu", null, true);
    }
}
