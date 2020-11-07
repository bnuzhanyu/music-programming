package bnu.zy.music.basic.pitch;

import org.apache.commons.lang3.tuple.Pair;
import org.checkerframework.common.value.qual.IntRange;
import static bnu.zy.music.basic.pitch.MidiPitchUtil.pitchToMidi;

public class MidiPitchImpl implements Pitch {
    private final int octave;
    private final int note;

    private MidiPitchImpl(int octave, int note) {
        this.octave = octave;
        this.note = note;
    }

    /**
     * @return octave level for the pitch
     * e.g. 4 of C4, 3 of bA3
     */
    @Override
    public int octave() {
        return octave;
    }

    /**
     * @return the note id
     * e.g. C is 0, #C/bD is 1, A is 10, B is 11
     */
    @Override
    public int note() {
        return note;
    }

    //TODO: opt, pre-build all of 128 midi notes
    public static MidiPitchImpl ofMidi(@IntRange(from = 0, to = 127) int midi) {
        Pair<Integer, Integer> pitch = MidiPitchUtil.midiToPitch(midi);
        int octave = pitch.getLeft();
        int note = pitch.getRight();
        return new MidiPitchImpl(octave, note);
    }

    public static MidiPitchImpl ofPitch(int octave, int note) {
        return ofMidi(pitchToMidi(octave, note));
    }
}
