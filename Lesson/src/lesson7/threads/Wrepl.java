package lesson7.threads;

import java.io.FileNotFoundException;
import java.nio.file.Path;

public class Wrepl extends FileReaderByLines{
    String[] search;
    String[] target;

    public Wrepl(int countReadLine, Path filePath, String[] search, String[] target) {
        super(countReadLine, filePath);
        this.search = search;
        this.target = target;
    }

    public void run() throws FileNotFoundException {
        this.readFileByCertainCountLine();
    }

    @Override
    protected void doReadDataFinished(Object processReadDataResult) {
        System.out.println(processReadDataResult);
    }

    @Override
    protected Object doProcessReadData(String readData, Object preProcessReadDataResult) {
        for (int i = 0; i < this.search.length; i++) {
            readData = readData.replaceAll(this.search[i], this.target[i]);
        }
        return readData;
    }
}
