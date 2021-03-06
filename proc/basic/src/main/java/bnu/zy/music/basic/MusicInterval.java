package bnu.zy.music.basic;

/**
 * @author zhanyu
 * Definition of Interval
 * https://en.wikipedia.org/wiki/Interval_(music)
 */

public enum MusicInterval {
    P1(0),
    m2(1),
    M2(2),
    m3(3),
    M3(4),
    P4(5),
    TT(6),
    P5(7),
    m6(8),
    M6(9),
    m7(10),
    M7(11),
    P8(12),
    m9(13),
    M9(14),
    m10(15),
    M10(16),
    P11(17),
    A11(18),
    P12(19),
    m13(20),
    M13(21),
    m14(22),
    M14(23),
    P15(24),
    ;

    public int semiTones;
    MusicInterval(int semiTones) {
        this.semiTones = semiTones;
    }

    public static MusicInterval of(int semiTones) {
        assert semiTones >= 0 && semiTones <= 24;
        return MusicInterval.values()[semiTones];
    }
}
