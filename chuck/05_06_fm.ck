SinOsc mod => SinOsc carrier => ADSR env => dac;
(0.1::second, 0.01::second, 0.6, 0.2::second) => env.set;
100 => mod.gain;
2 => carrier.sync;

while (true) {
    Math.random2f(100.0, 1000.0) => mod.freq; //frequency modulation
    Math.random2f(100.0, 1000.0) => carrier.freq;
    1 => env.keyOn;
    0.2::second => now;
    1 => env.keyOff;
    0.2::second => now;
}