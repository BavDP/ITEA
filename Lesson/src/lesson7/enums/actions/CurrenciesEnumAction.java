package lesson7.enums.actions;

import MenuBuilder.AbstractAction;

public class CurrenciesEnumAction extends AbstractAction {

    private void showCurrencies() {
        System.out.println("Курси валют щодо гривні:");
        for (Currency c: Currency.values()) {
            System.out.println(c.getName() + " " + Currency.getValue(c));
        }
    }
    @Override
    public void doAction() {
        this.showCurrencies();
        Currency.setValue(Currency.EUR, 39.5);
        this.showCurrencies();
    }
}
