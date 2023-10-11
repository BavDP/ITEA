package lesson2;
import MenuBuilder.ConsoleMenuBuilder;

public class SubMenuBuilder {
    static public ConsoleMenuBuilder getMenu(String prnTitle) {
        final String FOR_LOOP = "FOR loop";
        final String WHILE_LOOP = "WHILE loop";
        final String DO_WHILE_LOOP = "DO-WHILE loop";
        final String FOR_EACH_LOOP = "FOR-EACH loop";
        final String ARRAYS = "Arrays";
        return new ConsoleMenuBuilder(prnTitle)
                .AddMenuItem("1", FOR_LOOP, lesson2.forLoop.SubMenuBuilder.getMenu(prnTitle + " -> " + FOR_LOOP), false)
                .AddMenuItem("2", WHILE_LOOP, lesson2.whileLoop.SubMenuBuilder.getMenu(prnTitle + " -> " + WHILE_LOOP), false)
                .AddMenuItem("3", DO_WHILE_LOOP, lesson2.doWhile.SubMenuBuilder.getMenu(prnTitle + " -> " + DO_WHILE_LOOP), false)
                .AddMenuItem("4", FOR_EACH_LOOP, lesson2.forEach.SubMenuBuilder.getMenu(prnTitle + " -> " + FOR_EACH_LOOP), false)
                .AddMenuItem("5", ARRAYS, lesson2.arrays.SubMenuBuilder.getMenu(prnTitle + " -> " + ARRAYS), false)
                .AddMenuItem("0", "Exit", null, true);
    }
}
