package lesson7.threads.syncSimple;

import lesson7.threads.CsvFileLine;

import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.*;

public class CalcYearProfit extends SimpleSyncFileReaderByLines {
    /// файл, текст которого будет анализироваться
    private final int yearForCalcProfit;
    private final String countryForCalcProfit;

    public CalcYearProfit(int readLineCount, String pathToFile, int yearForCalcProfit, String profitCountry) {
        super(readLineCount, pathToFile);
        this.yearForCalcProfit = yearForCalcProfit;
        this.countryForCalcProfit = profitCountry;
    }
    /// запуск команды на выполнение
    public void run() {
        try {
            readFileByCertainCountLine();
        } catch (FileNotFoundException | SecurityException e) {
            e.getStackTrace();
        }
    }

    @Override
    protected Object doProcessReadData(ArrayList<CsvFileLine> readData, Object preProcessReadDataResult) {
        return this.calcYearProfit(readData, preProcessReadDataResult != null ? (Double)preProcessReadDataResult: null);
    }

    @Override
    protected void doReadDataFinished(Object processReadDataResult) {
        System.out.println(" ********* Profit of year result ***********");
        this.writeStat((Double)processReadDataResult);
    }

    private Double calcYearProfit(ArrayList<CsvFileLine> csvLine, Double prevValue) {
        System.out.println("calcYearProfit processing next text block...");
        double totalProfitOfYear = csvLine.stream()
                // рассматриваем только записи с продажами за указанный год
                .filter(line -> line.orderDate.getYear() == this.yearForCalcProfit && line.country.equals(countryForCalcProfit))
                // группируем по словам и подсчитываем количество по каждой группе
                .map(line -> line.totalProfit)
                .reduce(0.0, Double::sum);
        return totalProfitOfYear + (prevValue != null ? prevValue : 0);
    }

    private void writeStat(Double stat) {
        DecimalFormat formatter = new DecimalFormat("#####.##");
        System.out.println("Total profit of " + yearForCalcProfit + " is: " + formatter.format(stat));
    }
}
