package lesson3.classes.actions;

import MenuBuilder.AbstractAction;
import MenuBuilder.ConsoleMenuBuilder;

import java.util.Currency;
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;

class BankAccount {
    private String acoountNumber = "";
    private Currency currency = Currency.getInstance("UAH");
    private double balance = 0;
    private String owner = "";

    public BankAccount(String accountNumber, String owner) {
        this.acoountNumber = accountNumber;
        this.owner = owner;
    }

    public void refill(double value) {
        if (value > 0) {
            this.balance += value;
        }
    }

    public void withdrawal(double value) {
        if (value > 0) {
            this.balance -= value;
        }
    }

    public String getBalance() {
        return balance + " " + this.currency.getCurrencyCode();
    }
}

public class BankAccountAction extends AbstractAction {
    private HashMap<String, BankAccount> accounts = new HashMap<>();

    private class CreateNewBankAccount extends AbstractAction {
        @Override
        public void doAction() {
            Scanner sc = new Scanner(System.in);
            System.out.print("Input account number: ");
            String accountNum = sc.nextLine();
            if (accounts.get(accountNum) == null ) {
                System.out.print("Input owner name: ");
                String ownerName = sc.nextLine();
                BankAccount account = new BankAccount(accountNum, ownerName);
                accounts.put(accountNum, account);
            } else {
                System.out.println("Such bank account is present!");
            }
        }
    }

    private class Refill extends AbstractAction {
        @Override
        public void doAction() {
            Scanner sc = new Scanner(System.in);
            System.out.print("Refill of bank account");
            System.out.print("Input bank account number: ");
            String accountNumber = sc.nextLine();
            if (accounts.get(accountNumber) != null ) {
                System.out.print("Input value: ");
                double value = sc.nextDouble();
                accounts.get(accountNumber).refill(value);
                System.out.println(accounts.get(accountNumber).getBalance());
            } else {
                System.out.println("Bank account not found!");
            }
        }
    }

    private class Withdraw extends AbstractAction {
        @Override
        public void doAction() {
            Scanner sc = new Scanner(System.in);
            System.out.print("Withdraw from bank account");
            System.out.print("Input bank account number: ");
            String accountNumber = sc.nextLine();
            if (accounts.get(accountNumber) != null ) {
                System.out.print("Input value: ");
                double value = sc.nextDouble();
                accounts.get(accountNumber).withdrawal(value);
                System.out.println(accounts.get(accountNumber).getBalance());
            } else {
                System.out.println("Bank account not found!");
            }
        }
    }
    @Override
    public void doAction() {
        System.out.println("Bank account");
        ConsoleMenuBuilder bookMenu = new ConsoleMenuBuilder("Bank Account")
                .AddMenuItem("1", "Add New Book", new BankAccountAction.CreateNewBankAccount())
                .AddMenuItem("2", "Refill account", new BankAccountAction.Refill())
                .AddMenuItem("3", "Withdraw account", new BankAccountAction.Withdraw())
                .AddMenuItem("0", "Exit", null, true);
        bookMenu.Run();
    }
}
