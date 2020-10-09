import bnu.zy.music.pitch.MidiPitchImpl;
import bnu.zy.music.pitch.Pitch;
import org.junit.Assert;
import org.junit.Test;

public class PitchTest {
    private void testPitch(int oct, int note, int expectMidi, double expectHz) {
        Pitch p = MidiPitchImpl.ofPitch(oct, note);
        Assert.assertEquals(expectMidi, p.midi());
        Assert.assertEquals(expectHz, p.hz(), 0.01);
    }

    @Test
    public void pitchTest() {
        //bB2
        testPitch(2, 10, 46, 116.54);
        //C4
        testPitch(4, 0, 60, 261.63);
        //A4
        testPitch(4, 9, 69, 440.0);
        //G6
        testPitch(6, 7, 91,  1567.98);
    }

}
