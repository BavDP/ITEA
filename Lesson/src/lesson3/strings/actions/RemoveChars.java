package lesson3.strings.actions;

import MenuBuilder.AbstractAction;

import java.util.Scanner;

public class RemoveChars extends AbstractAction {
    public void doAction() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input string: ");
        StringBuffer buffer = new StringBuffer(sc.nextLine());
        for (int i = buffer.length() - 1; i>=0; i--) {
            switch (buffer.charAt(i)) {
                case 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U': buffer.deleteCharAt(i);
                break;
            }
        }
        System.out.println("Result: " + buffer);
    }
}
