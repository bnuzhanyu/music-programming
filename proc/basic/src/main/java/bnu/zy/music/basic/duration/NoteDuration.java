package bnu.zy.music.basic.duration;

/**
 * @author zhanyu
 * length for a note, with whole note length = 256 * 5 * 7 * 9;
 */
public interface NoteDuration {

    int WHOTE_NOTE_LENGTH = 256 * 5 * 7 * 9;

    /**
     * length of a note by whole note is WHOTE_NOTE_LENGTH
     * @return
     */
    int length();

    /**
     * duration including a dot
     * @return
     */
    NoteDuration dot();

    default float rateOfWhoteNote() {
        return length() * 1.0f / WHOTE_NOTE_LENGTH;
    }
}
