package MenuBuilder;

public class ConsoleMenuItem {
    private String _title = "";
    private String _choiceToken = "";
    private ConsoleMenuBuilder _subMenu = null;
    private Boolean _isExitMenu = false;
    private AbstractAction _action = null;
    public ConsoleMenuItem(String choiceToken, String title, ConsoleMenuBuilder subMenu, Boolean isExitMenu) {
        this._title = title;
        this._choiceToken = choiceToken;
        this._subMenu = subMenu;
        this._isExitMenu = isExitMenu;
    }

    public ConsoleMenuItem(String choiceToken, String title, ConsoleMenuBuilder subMenu) {
        this._title = title;
        this._choiceToken = choiceToken;
        this._subMenu = subMenu;
        this._isExitMenu = false;
    }

    public ConsoleMenuItem(String choiceToken, String title) {
        this._title = title;
        this._choiceToken = choiceToken;
    }

    public String getTitle() {
        return this._title;
    }

    public String getChoiceToken() {
        return this._choiceToken;
    }

    public ConsoleMenuBuilder getSubMenu() {
        return this._subMenu;
    }

    public Boolean getIsExitMenu() {
        return this._isExitMenu;
    }

    public AbstractAction getAction() {
        return _action;
    }

    public ConsoleMenuItem setAction(AbstractAction action) {
        this._action = action;
        return this;
    }
}
