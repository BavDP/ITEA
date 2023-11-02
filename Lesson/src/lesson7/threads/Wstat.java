package lesson7.threads;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Path;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/// читает текстовый файл по 30 строк и подсчитывает статистику по словам
/// длина которых больше 3 символов
public class Wstat extends FileReaderByLines {
    /// файл, текст которого будет анализироваться
    private int readLineCount;
    private Path inputFile;

    public Wstat(int readLineCount, Stream<String> fileLines) {
        super(readLineCount, fileLines);
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
    protected Object doProcessReadData(String readData, Object preProcessReadDataResult) {
        LinkedHashMap<String, Long> stat = new LinkedHashMap<>();
        return this.calcWordStat(readData, preProcessReadDataResult != null ? (LinkedHashMap<String, Long>)preProcessReadDataResult: null);
    }

    @Override
    protected void doReadDataFinished(Object processReadDataResult) {
        System.out.println(" ********* wstat is finished ***********");
        System.out.println("wstat result: ");
        this.writeStat((LinkedHashMap<String, Long>)processReadDataResult, Path.of(""));
    }

    private LinkedHashMap<String, Long> calcWordStat(String buffer, LinkedHashMap<String, Long> prevValue) {
        LinkedHashMap<String, Long> res = new LinkedHashMap<>();
        System.out.println("wstat processing next text block...");
        ArrayList<Map.Entry<String, Long>> stat = new ArrayList<>(Arrays.stream(buffer.split(" "))
                // рассматриваем только слова длиннее 3 символов
                .filter(word -> word.length() > 2)
                // группируем по словам и подсчитываем количество по каждой группе
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet());
        for (Map.Entry<String, Long> elem : stat) {
            res.put(elem.getKey(), elem.getValue());
        }
        // добавляем результаты от предыдущих вычиток файла
        if (prevValue != null) {
            for (Map.Entry<String, Long> entry : prevValue.entrySet()) {
                String key = entry.getKey();
                Long val = entry.getValue();
                Long cnt = res.get(key);
                if (cnt != null) {
                    cnt = cnt + val;
                    res.put(key, cnt);
                } else {
                    res.put(key, val);
                }
            }
        }
        return res;
    }

    private void writeStat(LinkedHashMap<String, Long> stat, Path outputFile) {
        ArrayList<Object> sorted = stat.entrySet().stream()
                .filter(elem -> elem.getValue() > 200)
                .sorted(Comparator.comparing(Map.Entry::getValue, new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                return o1.compareTo(o2);
            }
        })).collect(Collectors.toCollection(ArrayList::new));
        sorted.forEach(word -> {
            Map.Entry item = (Map.Entry)word;
            System.out.println(item.getKey() + ": " + item.getValue());
        });
    }
}
