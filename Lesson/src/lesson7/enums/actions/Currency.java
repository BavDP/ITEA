package lesson7.enums.actions;

import java.util.EnumMap;

public enum Currency {
    EUR("Євро"),
    PLN("Злотий"),
    HUF("Форінт"),
    CZK("Чеська крона");
    private final String name;
    private static EnumMap<Currency, Double> val; // значення курсу може змінюватись

    static {
        Currency.val = new EnumMap<>(Currency.class);
        Currency.val.put(Currency.EUR, 38.65);
        Currency.val.put(Currency.CZK, 1.56);
        Currency.val.put(Currency.HUF, 10.0);
        Currency.val.put(Currency.PLN, 8.6);
    }

    Currency(String name) {
        this.name = name;
    }
    public static void setValue(Currency currency, double value) {
        Currency.val.put(currency, value);
    }

    public String getName() {
        return name;
    }

    public static double getValue(Currency currency) {
        return Currency.val.get(currency);
    }
}
