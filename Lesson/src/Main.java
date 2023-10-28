import MenuBuilder.ConsoleMenuBuilder;
import lesson2.SubMenuBuilder;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        final String LESSON2 = "Lesson #2";
        final String LESSON3 = "Lesson #3";
        final String LESSON4 = "Lesson #4";
        final String LESSON5 = "Lesson #5";
        ConsoleMenuBuilder menuBuilder = ConsoleMenuBuilder.getMainMenuBuilder();
        menuBuilder
                .AddMenuItem("1", LESSON2, lesson2.SubMenuBuilder.getMenu(LESSON2), false)
                .AddMenuItem("2", LESSON3, lesson3.SubMenuBuilder.getMenu(LESSON3), false)
                .AddMenuItem("3", LESSON4, lesson4.SubMenuBuilder.getMenu(LESSON4), false)
                .AddMenuItem("4", LESSON5, lesson5.SubMenuBuilder.getMenu(LESSON5), false)
                .AddMenuItem("exit", "Exit from program", null, true)
                .Run();

    }
}