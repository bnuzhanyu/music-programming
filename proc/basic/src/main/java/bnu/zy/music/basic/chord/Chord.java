package bnu.zy.music.basic.chord;

import bnu.zy.music.basic.pitch.Pitch;
import bnu.zy.music.basic.Harmonic;

public interface Chord extends Harmonic {
    Pitch root();
    String chordType();
}
