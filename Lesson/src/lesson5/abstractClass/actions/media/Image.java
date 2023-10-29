package lesson5.abstractClass.actions.media;

public class Image extends AbstractMedia{
    private int width;
    private int height;

    public Image(String title, int size, int width, int height) {
        super(title, size);
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public void displayInfo() {
        System.out.println("Image: ");
        System.out.println("title: " + this.getTitle() + "; size: " + this.getSize() + "MB; format: " + this.getWidth() + "x" + this.getHeight() + "px");
    }
}
