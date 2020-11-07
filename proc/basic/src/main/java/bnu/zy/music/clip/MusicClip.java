package bnu.zy.music.clip;

import bnu.zy.music.basic.duration.FreeNoteDuration;
import bnu.zy.music.basic.duration.NoteDuration;

import java.util.List;

public class MusicClip {

    private List<MusicElementTuple> notes;

    public NoteDuration duration() {
        int dur = 0;
        if (notes != null) {
            for (MusicElementTuple t : notes) {
                if (dur < t.duration().length()) {
                    dur = t.duration().length();
                }
            }
        }
        return FreeNoteDuration.of(dur);
    }
}
