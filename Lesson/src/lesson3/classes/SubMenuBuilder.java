package lesson3.classes;

import MenuBuilder.ConsoleMenuBuilder;
import lesson3.classes.actions.BookAction;

public class SubMenuBuilder {
    static public ConsoleMenuBuilder getMenu(String prnTitle) {
        return new ConsoleMenuBuilder(prnTitle)
                .AddMenuItem("1", "Class \"BOOK\"", new BookAction());
    }
}
