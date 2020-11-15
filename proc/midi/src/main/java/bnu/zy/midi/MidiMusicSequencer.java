package bnu.zy.midi;

import bnu.zy.music.clip.MusicElementTuple;

import javax.sound.midi.MidiEvent;
import javax.sound.midi.Track;
import java.util.List;

/**
 * 以midi为媒介，创建的sequencer
 */
public interface MidiMusicSequencer {

    /**
     * 设置某个track的乐器
     * @param trackId
     * @param offset
     * @param midiInstrumentId
     */
    void changeInstrument(int trackId, long offset, int midiInstrumentId);

    /**
     * 为trackId增加一段音乐
     * @param trackId
     * @param offsetTick
     * @param clip
     */
    void addClip(int trackId, long offsetTick, List<MusicElementTuple> clip);

    /**
     * 从某个offset开始播放
     * @param offsetTick
     */
    void playFrom(long offsetTick);

    /**
     * 从头开始播放
     */
    void play();

    /**
     * 是否在播放中
     * @return
     */
    boolean isPlaying();

    /**
     * 设置bpm
     * @param bpm
     * @return
     */
    void setBpm(float bpm);
    float bpm();

    /**
     * 获取总ticks
     * @return
     */
    long ticks();

    /**
     * 获取总长度us
     */
    long us();


    /**
     * 获取某个track
     * @param trackId
     * @return
     */
    Track getTrack(int trackId);

    /**
     * 为某个track添加一个midi event
     * @param trackId
     * @param midiMessage
     */
    void addMidiEvent(int trackId, MidiEvent midiMessage);
}
