package lesson5.abstractClass.actions;

import MenuBuilder.AbstractAction;
import lesson5.abstractClass.actions.media.Audio;
import lesson5.abstractClass.actions.media.Image;
import lesson5.abstractClass.actions.media.Video;

public class MediaAction extends AbstractAction {
    @Override
    public void doAction() {
        Video video = new Video("Any video1", 562, "32:34");
        Audio audio = new Audio("Any audio1", 5, "04:12");
        Image image = new Image("Any audio1", 5, 1200, 800);
        video.displayInfo();
        audio.displayInfo();
        image.displayInfo();
    }
}
