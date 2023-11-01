package lesson4.statics.actions;

import MenuBuilder.AbstractAction;

import java.util.ArrayList;

class Configyration {
    private static  String url;
    private static String userName;
    private static String password;
    static {
        url = "http://mybase.com/test";
        userName = "root";
        password = "root";
    }

    public static String getUrl() {
        return url;
    }

    public static String getUserName() {
        return userName;
    }

    public static String getPassword() {
        return password;
    }
}

class DataBaseConnect {
    public boolean connect(String url, String userName, String password) {
        return (userName.equals("root") && password.equals("root"));
    }
    public void disconnect() {
    }
    public ArrayList<Object> query(String query) {
        return null;
    }
}

public class InitBlockAction extends AbstractAction {
    @Override
    public void doAction() {
        DataBaseConnect dbConnect = new DataBaseConnect();
        try {
            dbConnect.connect(Configyration.getUrl(), Configyration.getUserName(), Configyration.getPassword());
            dbConnect.query("Query text");
        } finally {
            dbConnect.disconnect();
        }
    }
}
