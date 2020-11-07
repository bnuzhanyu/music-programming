package bnu.zy.music.basic.pitch;

public interface Pitch {
    /**
     * @return octave level for the pitch
     * e.g. 4 of C4, 3 of bA3
     */
    int octave();

    /**
     * @return the note id
     * e.g. C is 0, #C/bD is 1, A is 9, B is 11
     */
    int note();

    /**
     * @return the midi id of the pitch
     * e.g. C-1 is 0, C4 is 60, A4 is 69
     */
    default int midi() {
        return MidiPitchUtil.pitchToMidi(octave(), note());
    }

    /**
     * @return the frequency of the pitch
     */
    default double hz() {
        return MidiPitchUtil.pitchFrequency(octave(), note());
    }
}
