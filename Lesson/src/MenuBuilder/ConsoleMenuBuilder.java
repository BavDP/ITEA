package MenuBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class ConsoleMenuBuilder {
    static final private ConsoleMenuBuilder mainMenu = new ConsoleMenuBuilder("ITEA Lessons main menu");
    static public ConsoleMenuBuilder getMainMenuBuilder() {
        return ConsoleMenuBuilder.mainMenu;
    }
    String _menuTitle = "";
    ArrayList<ConsoleMenuItem> _menuItems = new ArrayList<>();

    public ConsoleMenuBuilder(String title) {
        this._menuTitle = title;
    }
    public ConsoleMenuBuilder AddMenuItem(String choiceToken, String title, ConsoleMenuBuilder subMenu, Boolean isExitMenu) {
        this._menuItems.add(new ConsoleMenuItem(choiceToken, title, subMenu, isExitMenu));
        return this;
    }

    public ConsoleMenuBuilder AddMenuItem(String choiceToken, String title, AbstractAction action) {
        this._menuItems.add(new ConsoleMenuItem(choiceToken, title, null, false).setAction(action));
        return this;
    }

    public void Run() {
        this.ClearScreen();
        while (true) {
            System.out.println(" *********** " + this._menuTitle + " ***************** ");
            this._menuItems.forEach(value -> {
                System.out.println(value.getChoiceToken() + " " + value.getTitle());
            });
            System.out.print("Your select: ");
            Scanner menuItemScanner = new Scanner(System.in);
            String userSelect = menuItemScanner.nextLine();
            List<ConsoleMenuItem> menu = this._menuItems
                    .stream()
                    .filter(elem -> elem.getChoiceToken().equals(userSelect))
                    .toList();
            if (!menu.isEmpty()) {
                if ( menu.get(0).getSubMenu() != null ) {
                    menu.get(0).getSubMenu().Run();
                } else {
                    if (menu.get(0).getIsExitMenu()) {
                        break;
                    } else {
                        if (menu.get(0).getAction() != null) {
                            menu.get(0).getAction().doAction();
                        }
                    }
                }
            }
        }
    }

    private void ClearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
