package actions.Arrays;

import actions.AbstractAction;

public class OutputDuplicates extends AbstractAction {
    public void doAction() {
        int[] data = {4,6,3,8,2,34,6,7,3,2,34,5,6,7,89,3,12,5,4};
        int[] marks = new int[data.length];
        for (int i = 0; i < data.length-1; i++) {
            if (marks[i] != 0) continue;
            for (int j = i+1; j < data.length; j++) {
                if (data[i] == data[j]) {
                    System.out.println(data[i]);
                    marks[j] = 1;
                    for (int z = j+1; z < data.length; z++) {
                        if (data[z] == data[j]) {
                            marks[z] = 1;
                        }
                    }
                    break;
                }
            }
        }
    }
}
