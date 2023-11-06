package lesson7.threads;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

/// представляет собой одну запись CSV-файла
public class CsvFileLine {
    public final String region;
    public final String country;
    public final String itemType;
    public final String salesChannel;
    public final String orderPriority;
    public final LocalDate orderDate;
    public final String orderID;
    public final LocalDate shipDate;
    public final double unitsSold;
    public final double unitPrice;
    public final double unitCost;
    public final double totalRevenue;
    public final double totalCost;
    public final double totalProfit;

    public CsvFileLine(String csvLine, String delim) throws ParseException {
        String[] items = csvLine.split(delim);
        region = items[0];
        country = items[1];
        itemType = items[2];
        salesChannel = items[3];
        orderPriority = items[4];
        orderDate = strToDate(items[5]);
        orderID = items[6];
        shipDate = strToDate(items[7]);
        unitsSold = Double.parseDouble(items[8]);
        unitPrice = Double.parseDouble(items[9]);
        unitCost = Double.parseDouble(items[10]);
        totalRevenue = Double.parseDouble(items[11]);
        totalCost = Double.parseDouble(items[12]);
        totalProfit = Double.parseDouble(items[13]);
    }

    private LocalDate strToDate(String value) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/y");
        return LocalDate.parse(value, formatter);
    }
}
