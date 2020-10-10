package bnu.zy.music.chord;

import bnu.zy.music.pitch.Pitch;
import bnu.zy.music.basic.Harmonic;

public interface Chord extends Harmonic {
    Pitch root();
    String chordType();
}
