package bnu.zy.music.basic.chord;

import bnu.zy.music.basic.pitch.Pitch;

/**
 * generate a chord by root
 */
public interface ChordGenerator {
    Chord genChord(Pitch root);
}
