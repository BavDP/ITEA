package lesson3.classes;

import MenuBuilder.ConsoleMenuBuilder;
import lesson3.classes.actions.BankAccountAction;
import lesson3.classes.actions.BookAction;
import lesson3.classes.actions.ProductAction;

public class SubMenuBuilder {
    static public ConsoleMenuBuilder getMenu(String prnTitle) {
        return new ConsoleMenuBuilder(prnTitle)
                .AddMenuItem("1", "Class \"BOOK\"", new BookAction())
                .AddMenuItem("2", "Bank Account", new BankAccountAction())
                .AddMenuItem("3", "Products", new ProductAction())
                .AddMenuItem("0", "Exit", null, true);
    }
}
