package lesson7.threads.syncWithWaitNotify;

import lesson7.threads.CsvFileLine;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class WaitSyncFileReaderByLines {
    public static final String CSV_DELIMITER = ",";
    private static final HashMap<String, Object> synchObjects = new HashMap<>();
    private static final AtomicInteger counter = new AtomicInteger(0);
    private final int countReadLine;
    private final String pathToFile;

    public WaitSyncFileReaderByLines(int countReadLine, String pathToFile) {
        this.countReadLine = countReadLine;
        this.pathToFile = pathToFile;
        WaitSyncFileReaderByLines.synchObjects.computeIfAbsent(pathToFile, k -> new Object());
    }
    protected void readFileByCertainCountLine() throws FileNotFoundException {
        final int[] lineCnt = {1};
        int preLineCnt = 0;
        Object syncObj = WaitSyncFileReaderByLines.synchObjects.get(pathToFile);
        WaitSyncFileReaderByLines.counter.incrementAndGet();
        Object processReadDataResult = null;
        do {
            try (Stream<String> fileLines = Files.lines(Path.of(pathToFile))) {
                synchronized (syncObj) {
                    try {
                        syncObj.notify();
                        if (WaitSyncFileReaderByLines.counter.get() > 1) {
                            syncObj.wait();
                        }
                        preLineCnt = lineCnt[0];
                        doStartReadFileBlock();
                        ArrayList<CsvFileLine> readBuffer = new ArrayList<>();
                        fileLines.skip(lineCnt[0]).limit(countReadLine).forEach(fileLine -> {
                            try {
                                readBuffer.add(new CsvFileLine(fileLine, WaitSyncFileReaderByLines.CSV_DELIMITER));
                            } catch (ParseException e) {
                                e.getStackTrace();
                            }
                            lineCnt[0]++;
                        });
                        processReadDataResult = doProcessReadData(readBuffer, processReadDataResult);
                    } catch(InterruptedException e) {
                        e.getStackTrace();
                    }

                }
            } catch (IOException e) {
                e.getStackTrace();
                break;
            }
        } while(preLineCnt < lineCnt[0]);
        synchronized (syncObj) {
            syncObj.notify();
        }
        WaitSyncFileReaderByLines.counter.decrementAndGet();
        doReadDataFinished(processReadDataResult);
    }

    protected Object doProcessReadData(ArrayList<CsvFileLine> readData, Object preProcessReadDataResult) {
        return null;
    }

    protected void doReadDataFinished(Object processReadDataResult) {}

    protected void doStartReadFileBlock() {}
}
