package bnu.zy.music.pitch;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

public class MidiPitchUtil {

    private static final int A4_MIDI = 69;
    private static final double A4_FREQ = 440.0f;

    public static int pitchToMidi(int octave, int note) {
        return (octave + 1) * 12 + note;
    }

    public static Pair<Integer, Integer> midiToPitch(int midi) {
        return ImmutablePair.of(midi / 12 - 1, midi % 12);
    }

    public static double pitchFrequency(int octave, int note) {
        int midi = pitchToMidi(octave, note);
        return Math.pow(2.0, (midi - A4_MIDI) / 12.0) * A4_FREQ;
    }
}
