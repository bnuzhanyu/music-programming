
fun void envlope() {
    SqrOsc clar => Gain g => Envelope env => dac;
    0.1 => g.gain;
    1.0::second => env.duration;
    1 => env.keyOn;
    2::second => now;
    1 => env.keyOff;
    2::second => now;
}

fun void adsr() {
    SqrOsc clar => Gain g => ADSR env => dac;
    (1::second, 2::second, 0.1, 2.0::second) => env.set;
    0.1 => g.gain;
    1 => env.keyOn;
    4::second => now;
    1 => env.keyOff;
    2::second => now;
}

fun void voilin() {
    SinOsc vib => SawOsc viol => ADSR env => dac;
    (0.5::second, 0.1::second, 0.6, 0.3::second) => env.set;
    6.0 => vib.freq; //frequency modulation
    10.0 => vib.gain;
    2 => viol.sync;
    660 => viol.freq;
    1 => env.keyOn;
    2::second => now;
    1 => env.keyOff;
    2::second => now;
}

voilin();
