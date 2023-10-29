package lesson5;

import MenuBuilder.ConsoleMenuBuilder;
import lesson4.anonymous.AnonymousShapeAction;

public class SubMenuBuilder {
    static public ConsoleMenuBuilder getMenu(String prnTitle) {
        final String GENERICS = "Generics";
        final String ABSTRACTCLASS = "Abstract class";


        return new ConsoleMenuBuilder(prnTitle)
                .AddMenuItem("1", GENERICS, lesson5.generics.SubMenuBuilder.getMenu(prnTitle + " -> " + GENERICS), false)
                .AddMenuItem("2", ABSTRACTCLASS, lesson5.abstractClass.SubMenuBuilder.getMenu(prnTitle + " -> " + GENERICS), false)
                .AddMenuItem("0", "Go to previous menu", null, true);
    }
}
