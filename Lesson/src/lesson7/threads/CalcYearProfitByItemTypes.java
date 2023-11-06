package lesson7.threads;

import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CalcYearProfitByItemTypes extends FileReaderByLines{
    /// файл, текст которого будет анализироваться
    private int readLineCount;
    private final int yearForCalcProfit;

    public CalcYearProfitByItemTypes(int readLineCount, String pathToFile, int yearForCalcProfit) {
        super(readLineCount, pathToFile);
        this.yearForCalcProfit = yearForCalcProfit;
    }
    /// запуск команды на выполнение
    public void run() {
        LinkedHashMap<String, Long> stat = new LinkedHashMap<>();
        try {
            readFileByCertainCountLine();
        } catch (FileNotFoundException | SecurityException e) {
            e.getStackTrace();
        }
    }

    @Override
    protected Object doProcessReadData(ArrayList<CsvFileLine> readData, Object preProcessReadDataResult) {
        LinkedHashMap<String, Long> stat = new LinkedHashMap<>();
        return this.calcYearProfit(readData, preProcessReadDataResult != null ? (Map<String, Double>)preProcessReadDataResult: null);
    }

    @Override
    protected void doReadDataFinished(Object processReadDataResult) {
        System.out.println(" ********* Profit of year by item types result ***********");
        this.writeStat((Map<String, Double>)processReadDataResult, Path.of(""));
    }

    private Map<String, Double> calcYearProfit(ArrayList<CsvFileLine> csvLine, Map<String, Double> prevValue) {
        LinkedHashMap<String, Long> res = new LinkedHashMap<>();
        System.out.println("    calcYearProfitPerItemType processing next text block...");
        Map<String, Double> totalProfitOfYear = csvLine.stream()
                // рассматриваем только записи с продажами за указанный год
                .filter(line -> line.orderDate.getYear() == this.yearForCalcProfit)
                .collect(Collectors.groupingBy(item -> item.itemType, Collectors.summingDouble(item -> item.totalProfit)));
        // прибавляем предыдущее значение
        if (prevValue != null) {
            prevValue.forEach((preKey, preVal) -> {
                if (totalProfitOfYear.get(preKey) != null) {
                    double newSum = totalProfitOfYear.get(preKey) + preVal;
                    totalProfitOfYear.put(preKey, newSum);
                } else {
                    totalProfitOfYear.put(preKey, preVal);
                }
            });
        }
        return totalProfitOfYear;
    }

    private void writeStat(Map<String, Double> stat, Path outputFile) {
        DecimalFormat formatter = new DecimalFormat("#####.##");
        System.out.println("Total profit of year per item type: ");
        stat.forEach((key, value) -> {
            System.out.println(key + ": " + formatter.format(value));
        });
    }
}