package lesson7.enums;

import MenuBuilder.ConsoleMenuBuilder;
import lesson7.enums.actions.CurrenciesEnumAction;
import lesson7.enums.actions.FlowersEnumAction;

public class SubMenuBuilder {
    static public ConsoleMenuBuilder getMenu(String prnTitle) {
        final String FLOWERS = "Flowers";
        final String CURRENCIES = "Currencies";


        return new ConsoleMenuBuilder(prnTitle)
                .AddMenuItem("1", FLOWERS, new FlowersEnumAction())
                .AddMenuItem("2", CURRENCIES, new CurrenciesEnumAction())
                .AddMenuItem("0", "Go to previous menu", null, true);
    }
}
