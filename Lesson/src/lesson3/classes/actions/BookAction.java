package lesson3.classes.actions;

import MenuBuilder.AbstractAction;
import MenuBuilder.ConsoleMenuBuilder;

import java.util.ArrayList;
import java.util.Scanner;

class BookException extends Exception {
    public BookException(String message) {
        super(message);
    }
}
class Book {
    private String title;
    private String author;
    private int year;
    private int pageAmount;

    public Book(String title, String author, int year, int pageAmount) throws BookException {
        this.author = author;
        this.title = title;
        this.pageAmount = pageAmount;
        this.year = year;
        if (year < 0 || pageAmount < 1) {
            throw new BookException("Invalid book's parameters such as 'year' or 'page amount'!");
        }
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) throws BookException {
        if (!title.isEmpty()) {
            this.title = title;
        } else {
            throw new BookException("Title is required!");
        }
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) throws BookException{
        if (!author.isEmpty()) {
            this.author = author;
        } else {
            throw new BookException("Author is required!");
        }
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) throws BookException {
        if (year > 0) {
            this.year = year;
        } else {
            throw new BookException("Year must be greater than 0!");
        }
    }

    public int getPageAmount() {
        return pageAmount;
    }

    public void setPageAmount(int pageAmount) throws BookException {
        if (pageAmount > 0) {
            this.pageAmount = pageAmount;
        } else {
            throw new BookException("PageAmount must be greater than 0!");
        }
    }
}
public class BookAction extends AbstractAction {

    private final ArrayList<Book> books = new ArrayList<>();
    private class AddNewBook extends AbstractAction {
        public void doAction() {
            Scanner sc = new Scanner(System.in);
            System.out.print("Book title: ");
            String title = sc.nextLine();
            System.out.print("Book author: ");
            String author = sc.nextLine();
            System.out.print("Book year: ");
            int year = sc.nextInt();
            System.out.print("Book page amount: ");
            int pageAmount = sc.nextInt();
            try {
                Book book = new Book(title, author, year, pageAmount);
                books.add(book);
            } catch (BookException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private class ViewAllBooks extends AbstractAction {
        public void doAction() {
            books.forEach((book -> {
                System.out.println("*********************************************");
                System.out.println("Name: " + book.getTitle());
                System.out.println("Author: " + book.getAuthor());
                System.out.println("Year: " + book.getYear());
                System.out.println("Pages amount: " + book.getPageAmount());
                System.out.println("*********************************************");
                System.out.println("Press Enter... ");
                Scanner sc = new Scanner(System.in);
                sc.nextLine();
            }));
        }
    }

    @Override
    public void doAction() {
        System.out.println("Creating books");
        ConsoleMenuBuilder bookMenu = new ConsoleMenuBuilder("Books")
                .AddMenuItem("1", "Add New Book", new AddNewBook())
                .AddMenuItem("2", "View All Books", new ViewAllBooks())
                .AddMenuItem("0", "Exit", null, true);
        bookMenu.Run();
    }
}
