package lesson4.interfaces;

import MenuBuilder.ConsoleMenuBuilder;
import lesson4.interfaces.actions.ShapesAction;
import lesson4.interfaces.actions.TransportAction;

public class SubMenuBuilder {
    static public ConsoleMenuBuilder getMenu(String prnTitle) {
        final String SHAPES = "Shapes";
        final String TRANSPORT = "Transports";
        final String STATICS = "Static tasks";

        return new ConsoleMenuBuilder(prnTitle)
                .AddMenuItem("1", SHAPES, new ShapesAction())
                .AddMenuItem("2", TRANSPORT, new TransportAction())
                .AddMenuItem("0", "Go to previous menu", null, true);
    }
}
