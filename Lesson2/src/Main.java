import MenuBuilder.ConsoleMenuBuilder;
import actions.Arrays.*;
import actions.DoWhile.*;
import actions.ForEach.*;
import actions.forLoop.*;
import actions.whileLoop.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        ConsoleMenuBuilder menuBuilder = new ConsoleMenuBuilder("Lesson 2");

        menuBuilder
                .AddMenuItem("1", "for loop", new ConsoleMenuBuilder("FOR loop")
                        .AddMenuItem("1","Number from 1 to 20", new From1To20())
                        .AddMenuItem("2","A-Z", new FromAToZ())
                        .AddMenuItem("3","from 1 to 10 (break on 5)", new From1To10Break5())
                        .AddMenuItem("4","from 1 to 10", new From1To10Odd())
                        .AddMenuItem("0", "Back to previous menu", null, true), false)
                .AddMenuItem("2", "while loop", new ConsoleMenuBuilder("While loop")
                        .AddMenuItem("1","Sum of input numbers", new InputNumber())
                        .AddMenuItem("2", "Input user's name", new InputName())
                        .AddMenuItem("0", "Back to previous menu", null, true), false)
                .AddMenuItem("3", "do-while loop", new ConsoleMenuBuilder("Do-While loop")
                        .AddMenuItem("1", "Random from 1 to 100 (break by 50)", new RandomFrom1To100())
                        .AddMenuItem("2", "Input password", new InputPassword())
                        .AddMenuItem("0", "Back to previous menu", null, true), false)
                .AddMenuItem("4", "for-each loop", new ConsoleMenuBuilder("For-each loop")
                        .AddMenuItem("1", "Colors array", new OutColors())
                        .AddMenuItem("2", "for-each for string", new OutStringByChar())
                        .AddMenuItem("0", "Back to previous menu", null, true), false)
                .AddMenuItem("5", "arrays", new ConsoleMenuBuilder("Arrays")
                        .AddMenuItem("1", "Find min and max", new FindMaxMin())
                        .AddMenuItem("2", "revert array", new ReversArray())
                        .AddMenuItem("3", "concat arrays and sort", new ConcatAndSort())
                        .AddMenuItem("4", "search duplicates", new OutputDuplicates())
                        .AddMenuItem("0", "Back to previous menu", null, true), false)
                .AddMenuItem("exit", "Exit from program", null, true)
                .Run();
    }
}