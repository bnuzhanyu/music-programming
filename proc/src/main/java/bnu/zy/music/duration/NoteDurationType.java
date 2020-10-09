package bnu.zy.music.duration;

public enum NoteDurationType implements NoteDuration {

    WHOLE(NoteDuration.WHOTE_NOTE_LENGTH),
    SEMI(NoteDuration.WHOTE_NOTE_LENGTH / 2),
    TRIPLET(NoteDuration.WHOTE_NOTE_LENGTH / 3),
    QUARTER(NoteDuration.WHOTE_NOTE_LENGTH / 4),
    EIGHTH(NoteDuration.WHOTE_NOTE_LENGTH / 8),
    SIXTEENTH(NoteDuration.WHOTE_NOTE_LENGTH / 16),
    ;

    private final int duration;
    NoteDurationType(int duration) {
        this.duration = duration;
    }

    @Override
    public int length() {
        return this.duration;
    }

    @Override
    public NoteDuration dot() {
        return FreeNoteDuration.of(this.duration + this.duration / 2);
    }
}
