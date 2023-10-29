package lesson7;

import MenuBuilder.ConsoleMenuBuilder;

public class SubMenuBuilder {
    static public ConsoleMenuBuilder getMenu(String prnTitle) {
        final String ENUMS = "Enums";
        final String THREADS = "Threads";


        return new ConsoleMenuBuilder(prnTitle)
                .AddMenuItem("1", ENUMS, lesson7.enums.SubMenuBuilder.getMenu(prnTitle + " -> " + ENUMS), false)
                //.AddMenuItem("2", THREADS, lesson7.threads.SubMenuBuilder.getMenu(prnTitle + " -> " + THREADS), false)
                .AddMenuItem("0", "Go to previous menu", null, true);
    }
}
