package lesson7.threads;

import java.io.*;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class FileReaderByLines {
    public static final String CSV_DELIMITER = ",";
    private static HashMap<String, Object> synchObjects = new HashMap();
    private int countReadLine;
    private String pathToFile;

    public FileReaderByLines(int countReadLine, String pathToFile) {
        this.countReadLine = countReadLine;
        this.pathToFile = pathToFile;
        FileReaderByLines.synchObjects.computeIfAbsent(pathToFile, k -> new Object());
    }
    protected void readFileByCertainCountLine() throws FileNotFoundException {
        final int[] lineCnt = {1};
        int preLineCnt = 0;
        Object processReadDataResult = null;
        String line = "";
        do {
            try (Stream<String> fileLines = Files.lines(Path.of(pathToFile))) {
                synchronized (FileReaderByLines.synchObjects.get(pathToFile)) {
                    preLineCnt = lineCnt[0];
                    doStartReadFileBlock();
                    ArrayList<CsvFileLine> readBuffer = new ArrayList<CsvFileLine>();
                    fileLines.skip(lineCnt[0]).limit(countReadLine).forEach(fileLine -> {
                        try {
                            readBuffer.add(new CsvFileLine(fileLine, FileReaderByLines.CSV_DELIMITER));
                        } catch (ParseException e) {
                            e.getStackTrace();
                        }
                        lineCnt[0]++;
                    });
                    processReadDataResult = doProcessReadData(readBuffer, processReadDataResult);
                }
            } catch (IOException e) {
                e.getStackTrace();
            }
        } while(preLineCnt < lineCnt[0]);
        doReadDataFinished(processReadDataResult);
    }

    protected Object doProcessReadData(ArrayList<CsvFileLine> readData, Object preProcessReadDataResult) {
        return null;
    }

    protected void doReadDataFinished(Object processReadDataResult) {}

    protected void doStartReadFileBlock() {}
}
