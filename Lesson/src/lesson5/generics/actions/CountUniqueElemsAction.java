package lesson5.generics.actions;

import MenuBuilder.AbstractAction;
import lesson5.generics.CompareValue;

class ObjectForCountUniqueTask implements CompareValue {
    int val;
    public ObjectForCountUniqueTask(int val) {
        this.val = val;
    }

    @Override
    public int toCompareValue() {
        return val;
    }

    @Override
    public String toString() {
        return "" + val;
    }
}

public class CountUniqueElemsAction extends AbstractAction {
    private <T extends CompareValue> int countUniqueElems(T[] list) {
        int res = 0;
        StringBuilder acc = new StringBuilder(",");
        for (int i = 0; i < list.length - 2; i++) {
            boolean f = false;
            for (int j=i+1; j < list.length - 1; j++) {
                if (list[i].toCompareValue() == list[j].toCompareValue()) {
                    f = true;
                    break;
                }
            }
            if (!f) {
                res++;
            }
        }
        return res;
    }
    @Override
    public void doAction() {
        ObjectForCountUniqueTask[] data = {
                new ObjectForCountUniqueTask(5),
                new ObjectForCountUniqueTask(15),
                new ObjectForCountUniqueTask(25),
                new ObjectForCountUniqueTask(6),
                new ObjectForCountUniqueTask(6),
                new ObjectForCountUniqueTask(5),
                new ObjectForCountUniqueTask(1),
                new ObjectForCountUniqueTask(2),
                new ObjectForCountUniqueTask(3),

        };
        System.out.println(countUniqueElems(data));
    }
}
