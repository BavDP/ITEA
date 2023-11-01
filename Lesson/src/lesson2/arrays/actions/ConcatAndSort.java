package lesson2.arrays.actions;

import MenuBuilder.AbstractAction;

public class ConcatAndSort extends AbstractAction {
    public void doAction() {
        int[] v1 = {4, 6, 12, 0, 34};
        int[] v2 = {41, 16, 2, 10, 4, 5, 6, 3};
        int[] v = new int[v1.length + v2.length];
        // объединяем массивы
        for (int i = 0; i < v.length; i++) {
            if (i < v1.length) {
                v[i] = v1[i];
            } else {
                v[i] = v2[i - v1.length];
            }
        }
        // сортируем (алгоритмом "Пузырек")
        for (int i = 0; i < v.length - 1; i++) {
            for (int j = i + 1; j < v.length; j++) {
                if (v[i] > v[j]) {
                    int buf = v[i];
                    v[i] = v[j];
                    v[j] = buf;
                }
            }
        }
        for (int i: v) {
            System.out.print(i + " ");
        }
        System.out.println("\n");
    }
}
