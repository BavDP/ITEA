package lesson7.threads;

import MenuBuilder.AbstractAction;

import java.util.Scanner;

public class ThreadAction extends AbstractAction {
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
    //     подсчитать статистику, заменить слова и опять подсчитать статискику
    // Разделяемым ресурсом для потоков будет файл-источник текста
    // Чтоб было веселее, то каждый поток будет читать по 30 строк файла в память и пока будет
    // выполнять свою работу над прочитанным текстом, допускать второй поток к работе с указанным файлом
    // Вроде не должно быть сложно... вот только для volatile пока не вижу тут применения :(
    // Поехали!!!
    // Контроль правильности введеной команды не проверяю, ибо не хочу...

    @Override
    public void doAction() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input your command: ");
        String command = sc.nextLine();
        String[] splitCommand = command.split(" ");
        String fileName = splitCommand[1];

        command = splitCommand[0];

    }
}
