package lesson3;

import MenuBuilder.ConsoleMenuBuilder;

public class SubMenuBuilder {
    static public ConsoleMenuBuilder getMenu(String prnTitle) {
        final String STRINGS = "Strings tasks";
        return new ConsoleMenuBuilder(prnTitle)
                .AddMenuItem("1", STRINGS, lesson3.strings.SubMenuBuilder.getMenu(prnTitle + " -> " + STRINGS), false)
                .AddMenuItem("0", "Go to previous menu", null, true);
    }
}
