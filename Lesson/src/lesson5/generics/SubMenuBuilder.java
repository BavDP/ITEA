package lesson5.generics;

import MenuBuilder.ConsoleMenuBuilder;
import lesson5.generics.actions.CountUniqueElemsAction;
import lesson5.generics.actions.FindMuchObjectAction;
import lesson5.generics.actions.SearchElemsInArrayAction;

public class SubMenuBuilder {
    static public ConsoleMenuBuilder getMenu(String prnTitle) {
        final String FIND_MUCH_OBJECT = "FindMuchObject";
        final String COUNT_UNIQUE_ELEMS = "CountUniqueElems";
        final String SEARCH_ELEMS_IN_ARRAY = "SearchElemsInArray";


        return new ConsoleMenuBuilder(prnTitle)
                .AddMenuItem("1", FIND_MUCH_OBJECT, new FindMuchObjectAction())
                .AddMenuItem("2", COUNT_UNIQUE_ELEMS, new CountUniqueElemsAction())
                .AddMenuItem("3", SEARCH_ELEMS_IN_ARRAY, new SearchElemsInArrayAction())
                .AddMenuItem("0", "Go to previous menu", null, true);
    }
}
