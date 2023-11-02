package lesson7.threads;

import MenuBuilder.AbstractAction;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.stream.Stream;

public class ThreadAction extends AbstractAction {
    final int READ_LINE_COUNT = 10;
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
        try(Stream<String> fileLines = Files.lines(Path.of(path))) {
            Thread wstatThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    Wstat wstat = new Wstat(READ_LINE_COUNT, fileLines);
                    wstat.run();
                }
            });
            wstatThread.run();
        } catch (IOException e) {
            e.getStackTrace();
        }

        /*Thread wreplThread = new Thread(new Runnable() {
            @Override
            public void run() {
                String[] from = {"non"};
                String[] to = {"NNOONN"};
                Wrepl wrepl = new Wrepl(10, Path.of(path), from, to);
                try {
                    wrepl.run();
                } catch (FileNotFoundException e) {
                    e.getStackTrace();
                }
            }
        });*/
        // wreplThread.run();
    }
}
