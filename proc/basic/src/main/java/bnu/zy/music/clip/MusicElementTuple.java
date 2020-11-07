package bnu.zy.music.clip;

import bnu.zy.music.basic.duration.NoteDuration;
import bnu.zy.music.basic.pitch.Pitch;

/**
 * 音乐要素：音高，时长，强度
 */
public interface MusicElementTuple {
    Pitch pitch();
    NoteDuration duration();
    int strength();
    default boolean isRest() {
        return pitch() == null;
    }
}
