package lesson2.forLoop;

import MenuBuilder.ConsoleMenuBuilder;
import lesson2.forLoop.actions.*;

public class SubMenuBuilder {
    static public ConsoleMenuBuilder getMenu(String prnTitle) {
        return new ConsoleMenuBuilder(prnTitle)
                .AddMenuItem("1","Number from 1 to 20", new From1To20())
                .AddMenuItem("2","A-Z", new FromAToZ())
                .AddMenuItem("3","from 1 to 10 (break on 5)", new From1To10Break5())
                .AddMenuItem("4","from 1 to 10", new From1To10Odd())
                .AddMenuItem("0", "Back to previous menu", null, true);
    }
}
