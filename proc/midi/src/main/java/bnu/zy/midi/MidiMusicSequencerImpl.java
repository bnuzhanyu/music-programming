package bnu.zy.midi;

import bnu.zy.music.basic.NoteEnum;
import bnu.zy.music.basic.chord.Chord;
import bnu.zy.music.basic.chord.ChordType;
import bnu.zy.music.basic.duration.NoteDuration;
import bnu.zy.music.basic.duration.NoteDurationType;
import bnu.zy.music.basic.pitch.MidiPitchImpl;
import bnu.zy.music.basic.pitch.Pitch;
import bnu.zy.music.clip.MusicElementTuple;
import bnu.zy.music.clip.SingleNoteElementTuple;
import com.google.common.collect.Lists;

import javax.sound.midi.*;
import java.util.List;

public class MidiMusicSequencerImpl implements MidiMusicSequencer {

    private Sequencer sequencer = MidiSystem.getSequencer();;
    private Sequence sequence;
    private NoteDuration beatUnit;
    private MidiTickCalculator midiTickCalculator;
    private List<Track> tracks;

    public MidiMusicSequencerImpl(int trackNum, float bpm, NoteDuration beatUnit, int ticksPerBeat) throws InvalidMidiDataException, MidiUnavailableException {
        this.beatUnit = beatUnit;
        sequence = new Sequence(Sequence.PPQ, ticksPerBeat);
        sequencer.setSequence(sequence);
        midiTickCalculator = MidiTickCalculator.builder().beatUnit(beatUnit).ticksPerBeatUnit(ticksPerBeat).build();
        tracks = Lists.newArrayListWithCapacity(trackNum);
        for (int i = 0; i < trackNum; i++) {
            Track track = sequence.createTrack();
            tracks.add(track);
        }
        sequencer.open();
        sequencer.setTempoInBPM(bpm);
        System.out.println("bpm:" + sequencer.getTempoInBPM());
    }

    @Override
    public void changeInstrument(int trackId, long offset, int midiInstrumentId) {
        try {
            ShortMessage instrumentMsg = new ShortMessage(ShortMessage.PROGRAM_CHANGE, midiInstrumentId, 0);
            MidiEvent event = new MidiEvent(instrumentMsg, offset);
            getTrack(trackId).add(event);
        } catch (Exception ex) {
            System.out.println("add track error");
        }
    }

    protected void addToTrack(Track track, long startTick, int midiNote, long noteLenTick, int force) {
        try {
            ShortMessage on = new ShortMessage(ShortMessage.NOTE_ON, midiNote, force);
            ShortMessage off = new ShortMessage(ShortMessage.NOTE_OFF, midiNote, force);
            MidiEvent onEvent = new MidiEvent(on, startTick);
            track.add(onEvent);
            MidiEvent offEvent = new MidiEvent(off, startTick + noteLenTick);
            track.add(offEvent);
        } catch (Exception ex) {
            System.out.println("add track error");
        }
    }

    @Override
    public void addClip(int trackId, long offsetTick, List<MusicElementTuple> clip) {
        for (MusicElementTuple musicElementTuple : clip) {
            long noteLen = midiTickCalculator.calcTicks(musicElementTuple.duration());
            addToTrack(getTrack(trackId), offsetTick, musicElementTuple.pitch().midi(), noteLen, musicElementTuple.strength());
        }
    }

    @Override
    public void playFrom(long offsetTick) {
        sequencer.setTickPosition(offsetTick);
        if (sequencer.isRunning()) {
            sequencer.stop();
        }
        sequencer.start();
    }

    @Override
    public void play() {
        playFrom(0);
    }

    @Override
    public boolean isPlaying() {
        return sequencer.isRunning();
    }

    @Override
    public Track getTrack(int trackId) {
        return tracks.get(trackId);
    }

    @Override
    public void addMidiEvent(int trackId, MidiEvent midiEvent) {
        getTrack(trackId).add(midiEvent);
    }

    @Override
    public void setBpm(float bpm) {
        sequencer.setTempoInBPM(bpm);
    }

    @Override
    public float bpm() {
        return sequencer.getTempoInBPM();
    }

    @Override
    public long ticks() {
        return sequencer.getTickLength();
    }

    @Override
    public long us() {
        return sequencer.getMicrosecondLength();
    }

    public static List<MusicElementTuple> gen(NoteEnum root, int oct, ChordType chordType, NoteDuration duration, int strength) {
        Pitch pr = MidiPitchImpl.ofPitch(oct, root.id);
        Chord chord = chordType.genChord(pr);
        List<MusicElementTuple> musicElementTuples = Lists.newArrayList();
        for (Pitch p : chord.pitches()) {
            MusicElementTuple musicElementTuple = SingleNoteElementTuple.builder().pitch(p).duration(duration).strength(strength).build();
            musicElementTuples.add(musicElementTuple);
        }
        return musicElementTuples;
    }

    public static List<MusicElementTuple> gen(Pitch pitch, NoteDuration duration, int strength) {
        List<MusicElementTuple> musicElementTuples = Lists.newArrayList();
        MusicElementTuple musicElementTuple = SingleNoteElementTuple.builder().pitch(pitch).duration(duration).strength(strength).build();
        musicElementTuples.add(musicElementTuple);
        return musicElementTuples;
    }

    public static void main(String[] args) {
        int trackNum = 1;
        float bpm = 60.0f;
        NoteDuration beatUnit = NoteDurationType.QUARTER;
        int ticksPerBeat = 2000;
        try {
            MidiMusicSequencerImpl musicSequencer = new MidiMusicSequencerImpl(trackNum, bpm, beatUnit, ticksPerBeat);
            musicSequencer.changeInstrument(0, 0, MidiInstrument.ACOUSTIC_GUITA_NYLON.id);
            long offset = 0;
            List<NoteEnum> notes = Lists.newArrayList(NoteEnum.C, NoteEnum.A, NoteEnum.F, NoteEnum.G);
            List<Integer> octs = Lists.newArrayList(4, 3, 3, 3);
            List<ChordType> chords = Lists.newArrayList(ChordType.MAJOR, ChordType.MINOR, ChordType.MAJOR, ChordType.MAJOR);

            for (int i = 0; i < notes.size(); i++) {
                List<MusicElementTuple> musicElementTuples = gen(notes.get(i), octs.get(i), chords.get(i), beatUnit, 50);
                for (int j = 0; j < 4; j++) {
                    musicSequencer.addClip(0, offset + j * ticksPerBeat, musicElementTuples);
                }
                offset += ticksPerBeat * 4;
            }
            musicSequencer.play();
            System.out.println("total len:" + musicSequencer.ticks() + " bpm:" + musicSequencer.bpm() + " us:" + musicSequencer.us());
        } catch (Exception ex) {
            System.err.println("error init sequencer");
            ex.printStackTrace();
        }
    }
}
