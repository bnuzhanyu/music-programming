package bnu.zy.music.clip;

import bnu.zy.music.basic.duration.NoteDuration;
import bnu.zy.music.basic.pitch.Pitch;
import lombok.Builder;

@Builder
public class SingleNoteElementTuple implements MusicElementTuple {

    private final Pitch pitch;
    private final NoteDuration duration;
    private final int strength;

    @Override
    public Pitch pitch() {
        return pitch;
    }

    @Override
    public NoteDuration duration() {
        return duration;
    }

    @Override
    public int strength() {
        return strength;
    }
}
