package bnu.zy.music.duration;

/**
 * @author zhanyu
 */
public class FreeNoteDuration implements NoteDuration {

    private FreeNoteDuration(int duration) {
        this.duration = duration;
    }

    private final int duration;

    @Override
    public int length() {
        return this.duration;
    }

    @Override
    public NoteDuration dot() {
        int curLength = length();
        return FreeNoteDuration.of(curLength + curLength / 2);
    }

    public static FreeNoteDuration of(int duration) {
        return new FreeNoteDuration(duration);
    }

    public static FreeNoteDuration combine(NoteDuration ... durations) {
        int len = 0;
        for (NoteDuration duration : durations) {
            len += duration.length();
        }
        return FreeNoteDuration.of(len);
    }
}
