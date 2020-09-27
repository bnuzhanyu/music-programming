
fun void impulse() {
    Impulse imp => Delay d => dac;
    d => d; //feedback loop
    0.005::second => d.delay;
    0.99 => d.gain;
    1.0 => imp.next;
    2.0::second => now;
}

impulse();

fun void noise() {
    Noise nois => ADSR env => Delay d => dac;
    (0.005::second, 0.001::second, 0.0, 0.001::second) => env.set;
    d => d;
    0.005::second => d.delay;
    0.99 => d.gain;
    1 => env.keyOn;
    2.0::second => now;
}

noise();