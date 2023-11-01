package lesson5.abstractClass.actions.media;

public class Audio extends Media{
    public Audio(String title, int size, String duration) {
        super(title, size, duration);
    }

    @Override
    public void displayInfo() {
        System.out.println("Audio: ");
        System.out.println("title: " + this.getTitle() + "; size: " + this.getSize() + "MB; duration: " + this.getDuration());
    }
}
