Shakers shak => dac;

fun void all() {
    for(0 => int i; i < 23; i++) {
        i => shak.preset;
        1.0 => shak.noteOn;
        1.0::second => now;
    }
}


17 => shak.preset;

while (true) {
    Math.random2f(0.0, 128.0) => shak.objects;
    Math.random2f(0.0, 1.0) => shak.decay;
    1.0 => shak.energy;
    1.0::second => now;
}