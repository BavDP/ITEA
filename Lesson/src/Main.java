import MenuBuilder.ConsoleMenuBuilder;
import lesson2.SubMenuBuilder;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        final String LESSON2 = "Lesson #2";
        final String LESSON3 = "Lesson #3";
        ConsoleMenuBuilder menuBuilder = ConsoleMenuBuilder.getMainMenuBuilder();
        menuBuilder
                .AddMenuItem("1", LESSON2, SubMenuBuilder.getMenu(LESSON2), false)
                .AddMenuItem("2", LESSON3, lesson3.SubMenuBuilder.getMenu(LESSON3), false)
                .AddMenuItem("exit", "Exit from program", null, true)
                .Run();
    }
}