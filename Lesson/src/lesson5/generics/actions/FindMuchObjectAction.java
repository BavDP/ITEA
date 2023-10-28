package lesson5.generics.actions;

import MenuBuilder.AbstractAction;
import lesson5.generics.CompareValue;

class Object1 implements CompareValue {
    int val;
    public Object1(int val) {
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

class Object2 implements CompareValue {
    int val;
    public Object2(int val) {
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

public class FindMuchObjectAction extends AbstractAction {
    private <T extends CompareValue> T compareObjects(T obj1, T obj2) {
        int cmp = obj1.toCompareValue() - obj2.toCompareValue();
        return cmp == 0 ? null : (cmp > 0 ? obj1 : obj2);
    }
    @Override
    public void doAction() {
        System.out.println(compareObjects(new Object1(20), new Object2(20)));
    }
}
