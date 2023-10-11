package lesson3.strings;

import MenuBuilder.ConsoleMenuBuilder;
import lesson3.strings.actions.*;

public class SubMenuBuilder {
    static public ConsoleMenuBuilder getMenu(String prnTitle) {
        return new ConsoleMenuBuilder(prnTitle)
                .AddMenuItem("1", "Concat strings", new ConcatStrings())
                .AddMenuItem("2", "Split string", new SplitStrings())
                .AddMenuItem("3", "Remove chars (A, E, I, O, U) from string", new RemoveChars())
                .AddMenuItem("0", "Back to previous menu", null, true);
    }
}
