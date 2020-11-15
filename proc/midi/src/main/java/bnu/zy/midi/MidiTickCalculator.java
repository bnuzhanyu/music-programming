package bnu.zy.midi;

import bnu.zy.music.basic.duration.NoteDuration;
import lombok.Builder;

@Builder
public class MidiTickCalculator {

    private final NoteDuration beatUnit;
    private final int ticksPerBeatUnit;

    public long calcTicks(NoteDuration duration) {
        return (long)(ticksPerBeatUnit * duration.length() / (1.0 * beatUnit.length()));
    }
}
