package bnu.zy.music.chord;

import bnu.zy.music.pitch.Pitch;

/**
 * generate a chord by root
 */
public interface ChordGenerator {
    Chord genChord(Pitch root);
}
