Mandolin m => dac;


0.4 => m.bodySize;
500 => m.freq;

fun void playsec(float t) {
    1.0 => m.noteOn;
    t::second => now;
    1.0 => m.noteOff;
}

for (0 => int i; i < 100; i++) {
   i / 100.0 => m.pluckPos;
   playsec(0.3);
}