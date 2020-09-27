Impulse imp => ResonZ filt => dac;

700.0 => filt.freq;
100 => filt.Q;

while (true) {
    500.0 => imp.next;
    Math.random2f(0.1, 0.4)::second => now;
    Math.random2f(500, 2000) => filt.freq;
}

