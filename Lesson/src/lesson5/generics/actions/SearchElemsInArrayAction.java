package lesson5.generics.actions;

import MenuBuilder.AbstractAction;

import java.util.Arrays;

interface Comparator<T> {
    boolean compare(T obj1, T obj2);
}
class SearchElementInArray<T> {
    private T [] data;

    public SearchElementInArray(T[] data) {
        this.data = data;
    }

    public int find(T obj, Comparator<T> comparator) {
        for (int i = 0; i < data.length; i++) {
            if (comparator.compare(data[i], obj)) {
                return i;
            }
        }
        return -1;
    }
}

public class SearchElemsInArrayAction extends AbstractAction {
    @Override
    public void doAction() {
        int[] data = {4, 5, 6, 7};
        int f = new SearchElementInArray<Integer>(Arrays.stream(data).boxed().toArray(Integer[]::new)).find(7,
                new Comparator<Integer>() {
                    @Override
                    public boolean compare(Integer obj1, Integer obj2) {
                        return obj1.compareTo(obj2) == 0;
                    }
                }
        );
        System.out.println(f);
        String[] dataSt = {"4", "15", "645", "43457"};
        f = new SearchElementInArray<String>(dataSt).find("7",
                new Comparator<String>() {
                    @Override
                    public boolean compare(String obj1, String obj2) {
                        return obj1.contains(obj2);
                    }
                }
        );
        System.out.println(f);
    }
}
