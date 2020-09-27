fun void forever() {
    while (true) {
        1.0::second => now;
    }
}
    
fun void room() {
    adc => Gain inGain;
    Delay d[3];
    
    inGain => d[0];
    inGain => d[1];
    inGain => d[2];
    
    0.06::second => d[0].max => d[0].delay; //allocates memory
    0.08::second => d[1].max => d[1].delay;
    0.10::second => d[2].max => d[2].delay;
    
    0.6 => d[0].gain => d[1].gain => d[2].gain;
    
    d[0] => d[0] => dac;
    d[1] => d[1] => dac;
    d[2] => d[2] => dac;
    
    forever();
}

fun void room2() {
    //JCRev
    //PRCRev
    adc => NRev rev => dac;
    0.1 => rev.mix;
    while (true) {
        1.0::second => now;
    }
}


fun void chorus() {
    adc => Chorus chor => dac;
    0.05 => chor.modDepth;
    2.0 => chor.modFreq;
    forever();
}

fun void pitshift() {
    adc => PitShift pit => dac;
    0.5 => pit.shift;
    forever();
}
