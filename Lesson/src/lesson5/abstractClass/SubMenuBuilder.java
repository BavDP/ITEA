package lesson5.abstractClass;

import MenuBuilder.ConsoleMenuBuilder;
import lesson5.abstractClass.actions.FigureAction;
import lesson5.abstractClass.actions.MediaAction;
import lesson5.generics.actions.CountUniqueElemsAction;
import lesson5.generics.actions.FindMuchObjectAction;
import lesson5.generics.actions.SearchElemsInArrayAction;

public class SubMenuBuilder {
    static public ConsoleMenuBuilder getMenu(String prnTitle) {
        final String MEDIA = "Media";
        final String FIGURE = "Figure";
        final String SEARCH_ELEMS_IN_ARRAY = "SearchElemsInArray";


        return new ConsoleMenuBuilder(prnTitle)
                .AddMenuItem("1", MEDIA, new MediaAction())
                .AddMenuItem("2", FIGURE, new FigureAction())
                .AddMenuItem("0", "Go to previous menu", null, true);
    }
}
