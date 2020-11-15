package bnu.zy.midi;

/**
 * midi 器乐音色表
 * http://tx.liberal.ntu.edu.tw/TxMusic/Docs/Audio-Inst-General%20MIDI%20Patch%20Names.htm
 */
public enum MidiInstrument {
    //钢琴
    ACOUSTIC_PIANO(0),

    //音乐盒
    MUSIC_BOX(10),
    //马林巴
    MARIMBA(12),
    //叮当铃
    TINKLE_BELL(112),

    //手风琴
    ACCORDION(21),
    //口琴
    HARMONICA(22),

    //古典吉他
    ACOUSTIC_GUITA_NYLON(24),
    //民谣吉他
    ACOUSTIC_GUITA_STEEL(25),
    //吉他磨弦
    GUITA_FRET_NOISE(120),

    //贝斯
    ACOUSTIC_BASS(32),

    //小提琴
    VIOLIN(40),
    //中提琴
    VIOLA(41),
    //大提琴
    CELLO(42),

    //小号
    TRUMPET(56),

    //萨克斯
    SAX(64),

    //黑管
    CLARINET(71),

    //长笛
    FLUTE(73),
    //陶笛
    OCARINA(79),
    ;

    public final int id;
    MidiInstrument(int id) {
        this.id = id;
    }

}
