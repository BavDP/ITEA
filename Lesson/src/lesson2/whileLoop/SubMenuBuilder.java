package lesson2.whileLoop;

import MenuBuilder.ConsoleMenuBuilder;
import lesson2.whileLoop.actions.*;

public class SubMenuBuilder {

    static public ConsoleMenuBuilder getMenu(String prnTitle) {
        return new ConsoleMenuBuilder(prnTitle)
                .AddMenuItem("1", "Sum of input numbers", new InputNumber())
                .AddMenuItem("2", "Input user's name", new InputName())
                .AddMenuItem("0", "Back to previous menu", null, true);
    }
}


