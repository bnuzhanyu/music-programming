package bnu.zy.midi;

import bnu.zy.music.basic.duration.NoteDuration;
import bnu.zy.music.clip.MusicElementTuple;

import java.util.List;

public interface MidiMusicSequencer {
    void setBpm(float bpm, long ticksPerBeat, NoteDuration beatLen);
    long calcTicks(NoteDuration duration);
    void addClip(int instrumentId, List<MusicElementTuple> clip, long totalOffset);
    void appendPhrase(int instrumentId, List<MusicElementTuple> clip);
    void setOffsetTick(long offsetTick);
    void getOffsetTick(long offsetTick);
    void playFrom(long offsetTick);
    void playDuration(long offsetTick, long lengthTick);
    void play();
}
