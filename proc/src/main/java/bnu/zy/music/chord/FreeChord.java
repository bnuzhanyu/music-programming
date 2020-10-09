package bnu.zy.music.chord;

import bnu.zy.music.basic.MusicInterval;
import bnu.zy.music.pitch.Pitch;
import bnu.zy.music.pitch.PitchOperation;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.stream.Collectors;

public class FreeChord implements Chord {

    private final Pitch root;
    private final List<Pitch> pitches;
    private final String chordName;

    private FreeChord(String chordName, Pitch tonic, List<Pitch> otherPitches) {
        this.root = tonic;
        this.chordName = chordName;
        this.pitches = Lists.newArrayList(root);
        this.pitches.addAll(Lists.newArrayList(otherPitches));
    }

    @Override
    public Pitch root() {
        return this.root;
    }

    @Override
    public String chordType() {
        return this.chordName;
    }

    @Override
    public List<Pitch> pitches() {
        return this.pitches;
    }

    public static FreeChord buildWithPitches(String chordName, Pitch tonic, Pitch ... otherPitches) {
        return buildWithPitches(chordName, tonic, Lists.newArrayList(otherPitches));
    }

    public static FreeChord buildWithPitches(String chordName, Pitch tonic, List<Pitch> otherPitches) {
        return new FreeChord(chordName, tonic, otherPitches);
    }

    public static FreeChord buildWithIntervals(String chordName, Pitch tonic, MusicInterval... musicIntervals) {
        return buildWithIntervals(chordName, tonic, Lists.newArrayList(musicIntervals));
    }

    public static FreeChord buildWithIntervals(String chordName, Pitch tonic, List<MusicInterval> musicIntervals) {
        List<Pitch> otherPitches = musicIntervals.stream().map(interval -> PitchOperation.inc(tonic, interval.semiTones)).collect(Collectors.toList());
        return new FreeChord(chordName, tonic, otherPitches);
    }
}
