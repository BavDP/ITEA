package lesson5.abstractClass.actions.media;

abstract public class Media extends AbstractMedia{
    private String duration;

    public Media(String title, int size, String duration) {
        super(title, size);
        this.duration = duration;
    }
    public String getDuration() {
        return duration;
    }
}
