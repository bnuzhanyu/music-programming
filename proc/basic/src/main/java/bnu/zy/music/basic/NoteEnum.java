package bnu.zy.music.basic;

/**
 * @author zhanyu
 * Definition of Equal Temperaments Pitches
 */
public enum NoteEnum {
    REST(-1),
    C(0),
    sC(1),
    bD(1),
    D(2),
    sD(3),
    bE(3),
    E(4),
    sE(5),
    F(5),
    sF(6),
    bG(6),
    G(7),
    sG(8),
    bA(8),
    A(9),
    sA(10),
    bB(10),
    B(11),
    ;

    public int id;
    NoteEnum(int id) {
        this.id = id;
    }
}
