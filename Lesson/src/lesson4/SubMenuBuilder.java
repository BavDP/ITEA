package lesson4;

import MenuBuilder.ConsoleMenuBuilder;
import lesson4.anonymous.AnonymousShapeAction;

public class SubMenuBuilder {
    static public ConsoleMenuBuilder getMenu(String prnTitle) {
        final String INTERFACES = "Interface task";
        final String ANONYMOUS = "Anonymous tasks";
        final String STATICS = "Static tasks";

        return new ConsoleMenuBuilder(prnTitle)
                .AddMenuItem("1", INTERFACES, lesson4.interfaces.SubMenuBuilder.getMenu(prnTitle + " -> " + INTERFACES), false)
                .AddMenuItem("2", ANONYMOUS, new AnonymousShapeAction())
                .AddMenuItem("3", STATICS, lesson4.statics.SubMenuBuilder.getMenu(prnTitle + " -> " + STATICS), false)
                .AddMenuItem("0", "Go to previous menu", null, true);
    }
}
