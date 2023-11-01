package lesson5.generics.actions;

import MenuBuilder.AbstractAction;

import java.util.Arrays;
import java.util.Scanner;

class ObjectForCountUniqueTask implements Comparable<ObjectForCountUniqueTask> {
    int val;
    public ObjectForCountUniqueTask(int val) {
        this.val = val;
    }

    @Override
    public int compareTo(ObjectForCountUniqueTask o) {
        if (o == this) return 0;
        return (o.val == this.val) ? 0 : (this.val - o.val > 0) ? 1 : -1;
    }

    @Override
    public String toString() {
        return "" + val;
    }
}

public class CountUniqueElemsAction extends AbstractAction {
    private <T extends Comparable<T>> int countUniqueElems(T[] list) {
        int res = 0;
        for (int i = 0; i < list.length - 2; i++) {
            boolean f = false;
            for (int j=i+1; j < list.length - 1; j++) {
                if (list[i].compareTo(list[j]) == 0) {
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
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter integers, separating by space: ");
        String values = sc.nextLine();
        // из строки чисел, разделенных пробелом, создаем массив ObjectForCountUniqueTask[]
        ObjectForCountUniqueTask[] data = Arrays.stream(values.split(" "))
                .map(elem -> new ObjectForCountUniqueTask(Integer.parseInt(elem)))
                .toArray(ObjectForCountUniqueTask[]::new);
        System.out.println(countUniqueElems(data));
    }
}
