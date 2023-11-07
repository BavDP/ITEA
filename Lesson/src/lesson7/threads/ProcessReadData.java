package lesson7.threads;

import java.util.ArrayList;

public interface ProcessReadData {
    Object processReadData(ArrayList<CsvFileLine> readData, Object preProcessReadDataResult);
}
