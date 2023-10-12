package lesson2.whileLoop.actions;

import MenuBuilder.AbstractAction;

import java.util.Scanner;

public class InputNumber extends AbstractAction {
    public void doAction() {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        while(true) {
            System.out.print("Input any number (0 - exit): ");
            int inNumber = sc.nextInt();
            sum += inNumber;
            if (inNumber == 0) {
                break;
            }
        }
        System.out.println("Sum = " + sum);
    }
}
