package lesson4.statics.actions;

import MenuBuilder.AbstractAction;
import MenuBuilder.ConsoleMenuBuilder;
import lesson4.interfaces.actions.ShapesAction;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Sportsman {
    private static int bestScore = Integer.MAX_VALUE;
    private String name;
    private int score;

    public static int getBestScore() {
        return Sportsman.bestScore;
    }

    public Sportsman(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public Sportsman updateBestScore(int newScore) {
        if (newScore < bestScore) {
            Sportsman.bestScore = newScore;
        }
        return this;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public String toString() {
        return "Name: " + this.name + " score: " + this.getScore();
    }
}
public class SportsmanAction extends AbstractAction {
    private ArrayList<Sportsman> sportsmans = new ArrayList<>();

    private class AddNewSportsman extends AbstractAction {
        @Override
        public void doAction() {
            Scanner sc = new Scanner(System.in);
            System.out.print("Input sportsman name: ");
            String name = sc.nextLine();
            System.out.print("Input result: ");
            int score = sc.nextInt();
            sportsmans.add(new Sportsman(name, score).updateBestScore(score));
        }
    }

    private class ShowBestSportsman extends AbstractAction {
        @Override
        public void doAction() {
            System.out.println("The best score = " + Sportsman.getBestScore());
            System.out.println("Best sportsmans: ");
            sportsmans.stream().filter((elem) -> {
                return elem.getScore() == Sportsman.getBestScore();
            }).forEach(System.out::println);
        }
    }
    @Override
    public void doAction() {
        System.out.println("Sportsmans");
        ConsoleMenuBuilder bookMenu = new ConsoleMenuBuilder("Sportsmans")
                .AddMenuItem("1", "Add new result", new SportsmanAction.AddNewSportsman())
                .AddMenuItem("2", "Show best result", new SportsmanAction.ShowBestSportsman())
                .AddMenuItem("0", "Exit", null, true);
        bookMenu.Run();
    }
}
