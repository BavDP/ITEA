package lesson2.arrays;

import MenuBuilder.ConsoleMenuBuilder;
import lesson2.arrays.actions.*;

public class SubMenuBuilder {
    static public ConsoleMenuBuilder getMenu(String prnTitle) {
        return new ConsoleMenuBuilder(prnTitle)
                .AddMenuItem("1", "Find min and max", new FindMaxMin())
                .AddMenuItem("2", "revert array", new ReversArray())
                .AddMenuItem("3", "concat arrays and sort", new ConcatAndSort())
                .AddMenuItem("4", "search duplicates", new OutputDuplicates())
                .AddMenuItem("0", "Back to previous menu", null, true);
    }
}
