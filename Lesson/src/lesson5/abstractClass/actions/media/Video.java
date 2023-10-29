package lesson5.abstractClass.actions.media;

public class Video extends Media{
    public Video(String title, int size, String duration) {
        super(title, size, duration);
    }

    @Override
    public void displayInfo() {
        System.out.println("Video: ");
        System.out.println("title: " + this.getTitle() + "; size: " + this.getSize() + "MB; duration: " + this.getDuration());
    }
}
