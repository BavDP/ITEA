package lesson5.abstractClass.actions.media;

abstract public class AbstractMedia {
    private String title;
    private int size;

    public AbstractMedia(String title, int size) {
        this.title = title;
        this.size = size;
    }

    public String getTitle() {
        return title;
    }

    public int getSize() {
        return size;
    }

    public abstract void displayInfo();
}
