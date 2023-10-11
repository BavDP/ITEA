package lesson3.strings.actions;

import MenuBuilder.AbstractAction;

import java.util.Scanner;
import java.util.StringTokenizer;

public class SplitStrings extends AbstractAction {
    public void doAction() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input string #1: ");
        String str = sc.nextLine();
        StringTokenizer tokenizer = new StringTokenizer(str);
        System.out.println("Result: ");
        while(tokenizer.hasMoreTokens()) {
            System.out.println(tokenizer.nextToken());
        }
    }
}
