TriOsc chord[3];
Gain master => dac;
for (0 => int i; i < chord.cap(); i++) {
    chord[i] => master;
   
}

fun void playChord(int root, string q, float length) {

    Std.mtof(root) => chord[0].freq;
    4 => int third;
    if (q == "major") {
        4 => third;
    } else {
        3 => third;
    }
    Std.mtof(root+third) => chord[1].freq;
    Std.mtof(root+7) => chord[2].freq;
    length::ms => now;
}

while(true) {
    playChord(Math.random2(60, 72), "major", 200);
    playChord(Math.random2(60, 72), "minor", 200);
}