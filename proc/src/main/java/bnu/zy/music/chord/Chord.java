package bnu.zy.music.chord;

import bnu.zy.music.basic.Harmonic;
import bnu.zy.music.pitch.Pitch;

public interface Chord extends Harmonic {
    Pitch root();
    String chordType();
}
