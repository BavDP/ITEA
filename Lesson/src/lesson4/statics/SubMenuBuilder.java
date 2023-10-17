package lesson4.statics;

import MenuBuilder.ConsoleMenuBuilder;
import lesson4.statics.actions.InitBlockAction;
import lesson4.statics.actions.SportsmanAction;

public class SubMenuBuilder {
    static public ConsoleMenuBuilder getMenu(String prnTitle) {
        final String SPORTSMAN = "Sportsman";
        final String INIT_BLOCK = "Initialization block";
        final String STATICS = "Static tasks";

        return new ConsoleMenuBuilder(prnTitle)
                .AddMenuItem("1", SPORTSMAN, new SportsmanAction())
                .AddMenuItem("2", INIT_BLOCK, new InitBlockAction())
                .AddMenuItem("0", "Go to previous menu", null, true);
    }
}
