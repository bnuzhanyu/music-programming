package bnu.zy.midi;
import javax.sound.midi.*;

public class RawMidiTest {
    private Sequence sequence;

    void addToTrack(Track track, long startTick, int note, long noteLenTick, int force) {
        try {
            ShortMessage on = new ShortMessage(ShortMessage.NOTE_ON, note, force);
            ShortMessage off = new ShortMessage(ShortMessage.NOTE_OFF, note, force);
            MidiEvent onEvent = new MidiEvent(on, startTick);
            track.add(onEvent);
            MidiEvent offEvent = new MidiEvent(off, startTick + noteLenTick);
            track.add(offEvent);
        } catch (Exception ex) {
            System.out.println("add track error");
        }
    }

    void changeInstrument(Track track, long startTick, int instrument) {
        try {
            ShortMessage instrumentMsg = new ShortMessage(ShortMessage.PROGRAM_CHANGE, instrument, 0);
            MidiEvent event = new MidiEvent(instrumentMsg, startTick);
            track.add(event);
        } catch (Exception ex) {
            System.out.println("add track error");
        }
    }

    void init() {
        int ticksPerQuater = 1000;
        try {
            int n = 4;
            for (MidiInstrument ins : MidiInstrument.values()) {
                Sequence sequence = new Sequence(Sequence.PPQ, ticksPerQuater);
                Track track1 = sequence.createTrack();
                long startTick = 100, noteLen = 1000;
                addToTrack(track1, 0, 56, startTick, 0);
                changeInstrument(track1, 0, ins.id);
                for (int i = 0; i < 4; i++) {
                    addToTrack(track1, startTick + noteLen * (n - 1 - i), 60 + i, noteLen, 100 - i * 3);
                    //addToTrack(track1, startTick + noteLen * (n - 1 - i), 64 + i, noteLen, 100 - i * 3);
                }
                Sequencer sequencer = MidiSystem.getSequencer();
                sequencer.setTempoInBPM(60);
                sequencer.setSequence(sequence);
                sequencer.open();
                sequencer.start(); //possibly start another thread
                while (sequencer.isRunning()) {
                    Thread.sleep(10);
                }
                sequencer.stop();

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        RawMidiTest rawMidiTest = new RawMidiTest();
        rawMidiTest.init();
    }
}
