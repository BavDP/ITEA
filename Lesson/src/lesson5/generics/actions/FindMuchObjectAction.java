package lesson5.generics.actions;

import MenuBuilder.AbstractAction;

class ComparableObject implements Comparable<ComparableObject> {
    int val;

    public ComparableObject(int val) {
        this.val = val;
    }

    @Override
    public int compareTo(ComparableObject o) {
        if (o == null) return 0;
        if (this == o) {
            return 0; // это тот же объект
        } else {
            return ((ComparableObject) o).val == this.val ? 0 : (this.val - o.val > 0) ? 1 : -1;
        }
    }

    @Override
    public String toString() {
        return "" + val;
    }
}

public class FindMuchObjectAction extends AbstractAction {
    private <T extends Comparable<T>> T compareObjects(T obj1, T obj2) {
        int cmp = obj1.compareTo(obj2);
        return cmp == 0 ? null : (cmp > 0 ? obj1 : obj2);
    }
    @Override
    public void doAction() {
        System.out.println(compareObjects(new ComparableObject(20), new ComparableObject(21)));
    }
}
