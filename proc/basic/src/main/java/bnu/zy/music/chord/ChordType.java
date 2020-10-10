package bnu.zy.music.chord;

import bnu.zy.music.basic.MusicInterval;
import bnu.zy.music.pitch.Pitch;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * Definition of ChordTypes
 * https://en.wikipedia.org/wiki/Chord_(music)
 */
public enum ChordType implements ChordGenerator {

    MAJOR("", MusicInterval.M3, MusicInterval.P5),
    MINOR("m", MusicInterval.m3, MusicInterval.P5),
    DOM7("7", MusicInterval.M3, MusicInterval.P5, MusicInterval.m7),
    MAJOR7("M7", MusicInterval.M3, MusicInterval.P5, MusicInterval.M7),
    AUG("+", MusicInterval.M3, MusicInterval.m6),
    AUG7("+7", MusicInterval.M3, MusicInterval.m6, MusicInterval.m7),
    MINOR6("m6", MusicInterval.m3, MusicInterval.P5, MusicInterval.M6),
    MINOR7("m7", MusicInterval.m3, MusicInterval.P5, MusicInterval.m7),
    mM7("mM7", MusicInterval.m3, MusicInterval.P5, MusicInterval.M7),
    DIM("dim", MusicInterval.m3, MusicInterval.TT),
    DIM7("dim7", MusicInterval.m3, MusicInterval.TT, MusicInterval.M6),
    HALF_DIM7("7b5", MusicInterval.m3, MusicInterval.TT, MusicInterval.m7),
    SUS2("sus2", MusicInterval.M2, MusicInterval.P5),
    SUS4("sus4", MusicInterval.P4, MusicInterval.P5),
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
    public Chord genChord(Pitch root) {
        return FreeChord.buildWithIntervals(chordName, root, this.intervalList);
    }
}
