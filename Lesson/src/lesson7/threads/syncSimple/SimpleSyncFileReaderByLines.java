package lesson7.threads.syncSimple;

import lesson7.threads.CsvFileLine;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Stream;

public class SimpleSyncFileReaderByLines {
    public static final String CSV_DELIMITER = ",";
    private static final HashMap<String, Object> synchObjects = new HashMap<>();
    private final int countReadLine;
    private final String pathToFile;

    public SimpleSyncFileReaderByLines(int countReadLine, String pathToFile) {
        this.countReadLine = countReadLine;
        this.pathToFile = pathToFile;
        SimpleSyncFileReaderByLines.synchObjects.computeIfAbsent(pathToFile, k -> new Object());
    }
    protected void readFileByCertainCountLine() throws FileNotFoundException {
        final int[] lineCnt = {1};
        int preLineCnt;
        Object processReadDataResult = null;
        Object syncObj = SimpleSyncFileReaderByLines.synchObjects.get(pathToFile);
        do {
            try (Stream<String> fileLines = Files.lines(Path.of(pathToFile))) {
                synchronized (syncObj) {
                    preLineCnt = lineCnt[0];
                    doStartReadFileBlock();
                    ArrayList<CsvFileLine> readBuffer = new ArrayList<>();
                    fileLines.skip(lineCnt[0]).limit(countReadLine).forEach(fileLine -> {
                        try {
                            readBuffer.add(new CsvFileLine(fileLine, SimpleSyncFileReaderByLines.CSV_DELIMITER));
                        } catch (ParseException e) {
                            e.getStackTrace();
                        }
                        lineCnt[0]++;
                    });
                    processReadDataResult = doProcessReadData(readBuffer, processReadDataResult);
                }
            } catch (IOException e) {
                e.getStackTrace();
                break;
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
