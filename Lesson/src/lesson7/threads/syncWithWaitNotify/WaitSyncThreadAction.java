package lesson7.threads.syncWithWaitNotify;

import MenuBuilder.AbstractAction;

import java.util.Scanner;

public class WaitSyncThreadAction extends AbstractAction {
    final int READ_LINE_COUNT = 10000;
    // Программа вычитывает файл test.csv и выполняет расчеты в отдельных потоках

    @Override
    public void doAction() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Path to file (test.csv): ");
        String path = sc.nextLine();
        System.out.print("Enter profit country: ");
        String profitCountry = sc.nextLine();
        System.out.print("Enter profit year: ");
        int profitYear = sc.nextInt();
        // расчет годовой выручки за указанный год
        Thread calcYearProfitThread = new Thread(() -> {
            CalcYearProfit calcYearProfit = new CalcYearProfit(READ_LINE_COUNT, path, profitYear, profitCountry);
            calcYearProfit.run();
        });
        try {
            calcYearProfitThread.join();
        } catch (InterruptedException e) {
            e.getStackTrace();
        }
        // расчет годовой выручки за указанный год для указанной страны с разбивкой по
        // типу товара
        Thread calcYearProfitPerItemTypeThread = new Thread(() -> {
            CalcYearProfitByItemTypesWaitSync calc = new CalcYearProfitByItemTypesWaitSync(READ_LINE_COUNT, path, profitYear);
            calc.run();
        });
        // запуск потоков
        calcYearProfitThread.start();
        calcYearProfitPerItemTypeThread.start();
        try {
            // ожидаем пока все потоки завершат свою работу
            while(calcYearProfitThread.isAlive() || calcYearProfitPerItemTypeThread.isAlive()) {
                calcYearProfitThread.join(2000);
                calcYearProfitPerItemTypeThread.join(2000);
                System.out.println("readed: " + WaitSyncFileReaderByLines.readLinesCounter / 2);
            }
        } catch (InterruptedException e) {
            e.getStackTrace();
        }
        System.out.println("Обработка файла завершена!");
    }
}
