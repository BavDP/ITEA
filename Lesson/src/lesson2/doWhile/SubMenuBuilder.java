package lesson2.doWhile;

import MenuBuilder.ConsoleMenuBuilder;
import lesson2.doWhile.actions.*;

public class SubMenuBuilder {
    static public ConsoleMenuBuilder getMenu(String prnTitle) {
        return new ConsoleMenuBuilder(prnTitle)
                .AddMenuItem("1", "Random from 1 to 100 (break by 50)", new RandomFrom1To100())
                .AddMenuItem("2", "Input password", new InputPassword())
                .AddMenuItem("0", "Back to previous menu", null, true);
    }
}
