SinOsc s => Pan2 p => dac;
0.2=>s.gain;
263 => s.freq;
[.3,.2,.1,.2,.3] @=> float len[];
float pos;
float t;
0 => int i;
while (true) {
    Math.sin(now /(2*second) * 2 * pi) => pos;
    pos => p.pan;
    i++;
    i % len.cap() => i;
    len[i]::second => now;
}