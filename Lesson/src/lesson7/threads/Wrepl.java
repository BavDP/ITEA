package lesson7.threads;

import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.stream.Stream;

public class Wrepl extends FileReaderByLines{
    String[] search;
    String[] target;

    public Wrepl(int countReadLine, Stream<String> fileLines, String[] search, String[] target) {
        super(countReadLine, fileLines);
        this.search = search;
        this.target = target;
    }

    public void run() throws FileNotFoundException {
        this.readFileByCertainCountLine();
    }

    @Override
    protected void doReadDataFinished(Object processReadDataResult) {
        System.out.println(" ********* wrepl is finished ***********");
        System.out.println("wrepl result: ");
        System.out.println(processReadDataResult);
    }

    @Override
    protected Object doProcessReadData(String readData, Object preProcessReadDataResult) {
        System.out.println("wrepl processing next text block...");
        for (int i = 0; i < this.search.length; i++) {
            readData = readData.replaceAll(this.search[i], this.target[i]);
        }
        StringBuilder pre = (StringBuilder) preProcessReadDataResult;
        if (preProcessReadDataResult != null) {
           pre.append(readData);
           return pre;
        } else {
            return new StringBuilder(readData);
        }
    }
}
