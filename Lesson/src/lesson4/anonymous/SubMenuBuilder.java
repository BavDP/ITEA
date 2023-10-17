package lesson4.anonymous;

import MenuBuilder.ConsoleMenuBuilder;

public class SubMenuBuilder {
    static public ConsoleMenuBuilder getMenu(String prnTitle) {
        final String INTERFACES = "Interface task";
        final String ANONYMOUS = "Anonymous tasks";
        final String STATICS = "Static tasks";

        return new ConsoleMenuBuilder(prnTitle)
                .AddMenuItem("1", "Anonymous shape", new AnonymousShapeAction())
                .AddMenuItem("0", "Go to previous menu", null, true);
    }
}
