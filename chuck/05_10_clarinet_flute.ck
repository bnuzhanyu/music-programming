


fun void clar() {
    Clarinet c => dac;
    220 => c.freq;
    while (true) {
        Math.random2f(0.1, 1.0) => c.noteOn;
        0.3::second => now;
        1 => c.noteOff;
        0.1::second => now;
    }
}


fun void flute() {
    Flute f => dac;
    330 => f.freq;
    while (true) {
        1.0 => f.noteOn;
        Math.random2f(0.1, 1.0) => f.jetDelay;
        0.2::second => now;
        1 => f.noteOff;
        0.3::second => now;
    } 
}
flute();