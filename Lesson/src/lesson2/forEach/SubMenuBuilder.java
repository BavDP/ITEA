package lesson2.forEach;

import MenuBuilder.ConsoleMenuBuilder;
import lesson2.forEach.actions.*;

public class SubMenuBuilder {
    static public ConsoleMenuBuilder getMenu(String prnTitle) {
        return new ConsoleMenuBuilder(prnTitle)
                .AddMenuItem("1", "Colors array", new OutColors())
                .AddMenuItem("2", "for-each for string", new OutStringByChar())
                .AddMenuItem("0", "Back to previous menu", null, true);
    }
}
