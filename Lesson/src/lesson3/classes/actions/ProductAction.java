package lesson3.classes.actions;

import MenuBuilder.AbstractAction;
import MenuBuilder.ConsoleMenuBuilder;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;


class Product {
    private String name;
    private double price = 0;
    private int amount = 0;

    public Product(String name, double price, int amount) {
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }
    public double commonPrice() {
        return this.price * this.amount;
    }
}
public class ProductAction extends AbstractAction {
    private ArrayList<Product> products = new ArrayList<>();
    private class AddNewProduct extends AbstractAction {
        public void doAction() {
            Scanner sc = new Scanner(System.in);
            System.out.print("Product name: ");
            String name = sc.nextLine();
            System.out.print("Product price: ");
            double price = sc.nextDouble();
            System.out.print("Product amount: ");
            int amount = sc.nextInt();
            Product product = new Product(name, price, amount);
            products.add(product);
        }
    }

    private class ShowCommonPrice extends AbstractAction {
        public void doAction() {
            System.out.print("Common price: ");
            var wrapper = new Object() { double sum; };
            products.forEach(product -> {
                wrapper.sum += product.commonPrice();
            });
            System.out.println(wrapper.sum);
        }
    }
    @Override
    public void doAction() {
        System.out.println("Products");
        ConsoleMenuBuilder bookMenu = new ConsoleMenuBuilder("Books")
                .AddMenuItem("1", "Add New Product", new ProductAction.AddNewProduct())
                .AddMenuItem("2", "View Common price", new ProductAction.ShowCommonPrice())
                .AddMenuItem("0", "Exit", null, true);
        bookMenu.Run();
    }
}
