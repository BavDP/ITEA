package lesson7.threads;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Path;

public class FileReaderByLines {
    private int countReadLine;
    private Path filePath;

    public FileReaderByLines(int countReadLine, Path filePath) {
        this.countReadLine = countReadLine;
        this.filePath = filePath;
    }
    protected void readFileByCertainCountLine() throws FileNotFoundException {
        int lineCnt = 0;
        Object processReadDataResult = null;
        RandomAccessFile ifs = new RandomAccessFile(this.filePath.toString(), "r");
        try {
            String line = "";
            do{
                StringBuilder readBuffer = new StringBuilder();
                while (true) {
                    line = ifs.readLine();
                    if (line == null) break;
                    readBuffer.append(line);
                    lineCnt++;
                    if (lineCnt >= countReadLine) break;
                }
                processReadDataResult = doProcessReadData(readBuffer.toString(), processReadDataResult);
                lineCnt = 0;
            } while(line!=null);
            doReadDataFinished(processReadDataResult);
        } catch (IOException e) {
            e.getStackTrace();
        } finally {
            try {
                ifs.close();
            } catch (IOException e) {
                e.getStackTrace();
            }
        }
    }

    protected Object doProcessReadData(String readData, Object preProcessReadDataResult) {
        return null;
    }

    protected void doReadDataFinished(Object processReadDataResult) {}
}
