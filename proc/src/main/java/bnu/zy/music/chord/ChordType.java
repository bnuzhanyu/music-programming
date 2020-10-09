package bnu.zy.music.chord;

import bnu.zy.music.basic.MusicInterval;
import bnu.zy.music.pitch.Pitch;
import com.google.common.collect.Lists;

import java.util.List;


import static bnu.zy.music.basic.MusicInterval.*;

/**
 * Definition of ChordTypes
 * https://en.wikipedia.org/wiki/Chord_(music)
 */
public enum ChordType implements ChordGenerator {

    MAJOR("", M3, P5),
    MINOR("m", m3, P5),
    DOM7("7", M3, P5, m7),
    MAJOR7("M7", M3, P5, M7),
    AUG("+", M3, m6),
    AUG7("+7", M3, m6, m7),
    MINOR6("m6", m3, P5, M6),
    MINOR7("m7", m3, P5, m7),
    mM7("mM7", m3, P5, M7),
    DIM("dim", m3, TT),
    DIM7("dim7", m3, TT, M6),
    HALF_DIM7("7b5", m3, TT, m7),
    SUS2("sus2", M2, P5),
    SUS4("sus4", P4, P5),
    ;

    /**
     * intervals to root note
     */
    private final List<MusicInterval> intervalList;
    private final String chordName;

    ChordType(String chordName, MusicInterval ... intervals) {
        this.chordName = chordName;
        this.intervalList = Lists.newArrayList(intervals);
    }

    @Override
    public Chord genChord(Pitch tonic) {
        return FreeChord.buildWithIntervals(chordName, tonic, this.intervalList);
    }
}
