package bnu.zy.music.basic.pitch;

public class PitchOperation {

    public static Pitch inc(Pitch pitch, int semitones) {
        return MidiPitchImpl.ofMidi(pitch.midi() + semitones);
    }

    public static Pitch dec(Pitch pitch, int semitones) {
        return MidiPitchImpl.ofMidi(pitch.midi() - semitones);
    }
}
