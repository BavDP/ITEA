package lesson7.threads;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Path;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/// читает текстовый файл по 30 строк и подсчитывает статистику по словам
/// длина которых больше 3 символов
public class Wstat extends FileReaderByLines {
    /// файл, в который будет записана статистика
    private Path outputFile;
    /// файл, текст которого будет анализироваться
    private Path inputFile;

    public Wstat(Path inputFile, Path outputFile) {
        super(10, inputFile);
        this.outputFile = outputFile;
        this.inputFile = inputFile;
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
        this.writeStat((LinkedHashMap<String, Long>)processReadDataResult, Path.of(""));
    }

    private LinkedHashMap<String, Long> calcWordStat(String buffer, LinkedHashMap<String, Long> prevValue) {
        LinkedHashMap<String, Long> res = new LinkedHashMap<>();
        ArrayList<Map.Entry<String, Long>> stat = new ArrayList<>(Arrays.stream(buffer.split(" "))
                .filter(word -> word.length() > 2)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet());
        for (Map.Entry<String, Long> elem : stat) {
            res.put(elem.getKey(), elem.getValue());
        }
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
        ArrayList<Object> sorted = stat.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getValue, new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                return o1.compareTo(o2);
            }
        })).collect(Collectors.toCollection(ArrayList::new));
        System.out.println(sorted);
    }
}
