package actions.Arrays;

import actions.AbstractAction;

import java.util.Scanner;

public class FindMaxMin extends AbstractAction {
    public void doAction() {
        int inNum;
        Scanner sc = new Scanner(System.in);
        System.out.print("Input amount numbers: ");
        int len = sc.nextInt();
        if (len > 0) {
            int k = 0;
            int[] buf = new int[len];
            do {
                System.out.print("Input number: ");
                buf[k] = sc.nextInt();
                k++;
            } while (k < len);
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int i: buf) {
                if (i > max) {
                    max = i;
                }
                if (i < min) {
                    min = i;
                }
            }
            System.out.println("MIN = " + min);
            System.out.println("MAX = " + max);
        }
    }
}
