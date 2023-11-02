package lesson7.threads;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class FileReaderByLines {
    private int countReadLine;
    private final Stream<String> fileLines;

    public FileReaderByLines(int countReadLine, Stream<String> fileLines) {
        this.countReadLine = countReadLine;
        this.fileLines = fileLines;
    }
    protected void readFileByCertainCountLine() throws FileNotFoundException {
        final int[] lineCnt = {0};
        int preLineCnt = 0;
        Object processReadDataResult = null;
        String line = "";
        do {
            synchronized (fileLines) {
                preLineCnt = lineCnt[0];
                doStartReadFileBlock();
                StringBuilder readBuffer = new StringBuilder();
                fileLines.skip(lineCnt[0]).limit(countReadLine).forEach(fileLine -> {
                    readBuffer.append(fileLine);
                    lineCnt[0]++;
                });
                processReadDataResult = doProcessReadData(readBuffer.toString(), processReadDataResult);
            }
        } while(preLineCnt < lineCnt[0]);
        doReadDataFinished(processReadDataResult);
    }

    protected Object doProcessReadData(String readData, Object preProcessReadDataResult) {
        return null;
    }

    protected void doReadDataFinished(Object processReadDataResult) {}

    protected void doStartReadFileBlock() {}
}
