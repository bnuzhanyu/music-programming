PulseOsc p => dac;

while (true) {
    Math.random2f(0.01, 0.5) => p.width; //x & (1-x) will sound same
    0.3::second => now;
    if (Math.random2(0, 1) == 1) {
        84 => p.freq;
    } else {
        100 => p.freq;
    }
}