package lesson7.threads;

import MenuBuilder.AbstractAction;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.stream.Stream;

public class ThreadAction extends AbstractAction {
    final int READ_LINE_COUNT = 10000;
    // программа создает поток-сервер, который принимает
    // команды с консоли от пользователя. Поддерживаются 2 команды
    // 1. wstat - статистика по словам в указанном файле, длина которых больше 2 символов
    // 2. mrepl - замена множества слов на новое множество
    // Эти команды выполняются для указанного текстового файла и каждая команда
    // работает в отдельном потоке.
    // Формат команды:
    // wstat <filename> - посчитать статистику по словам
    // mrepl:<fromWord1>,<fromWord2>:<toWord1>,<toWord2> <filename> <statFile> - замена слов в файле filename и вывод статистики в statFile
    // wstat+<fromWord1>,<fromWord2>:<toWord1>,<toWord2> <filename>+wstat <filename> <statFile> -
    //     подсчитать статистику, заменить слова и опять подсчитать статистику
    // Разделяемым ресурсом для потоков будет файл-источник текста
    // Чтоб было веселее, то каждый поток будет читать по 30 строк файла в память и пока будет
    // выполнять свою работу над прочитанным текстом, допускать второй поток к работе с указанным файлом
    // Вроде не должно быть сложно... вот только для volatile пока не вижу тут применения :(
    // Поехали!!!
    // Контроль правильности введёной команды не проверяю, ибо не хочу...

    @Override
    public void doAction() {
        /*Scanner sc = new Scanner(System.in);
        System.out.print("Input your command: ");
        String command = sc.nextLine();
        String[] splitCommand = command.split(" ");
        Path fileName = Path.of(splitCommand[1]);
        Wstat wstat = new Wstat(fileName, Path.of(""));
        wstat.run();
        command = splitCommand[0];*/
        Scanner sc = new Scanner(System.in);
        System.out.print("Path to file: ");
        String path = sc.nextLine();
        System.out.print("Enter profit country: ");
        String profitCountry = sc.nextLine();
        System.out.print("Enter profit year: ");
        int profitYear = sc.nextInt();
        Thread calcYearProfitThread = new Thread(new Runnable() {
            @Override
            public void run() {
                CalcYearProfit calcYearProfit = new CalcYearProfit(READ_LINE_COUNT, path, profitYear, profitCountry);
                calcYearProfit.run();
            }
        });
        try {
            calcYearProfitThread.join();
        } catch (InterruptedException e) {
            e.getStackTrace();
        }
        Thread calcYearProfitPerItemTypeThread = new Thread(new Runnable() {
            @Override
            public void run() {
                CalcYearProfitByItemTypes calc = new CalcYearProfitByItemTypes(READ_LINE_COUNT, path, profitYear);
                calc.run();
            }
        });
        calcYearProfitThread.start();
        calcYearProfitPerItemTypeThread.start();
        try {
            calcYearProfitThread.join();
            calcYearProfitPerItemTypeThread.join();
        } catch (InterruptedException e) {
            e.getStackTrace();
        }
        System.out.println("Обработка файла завершена!");
    }
}
