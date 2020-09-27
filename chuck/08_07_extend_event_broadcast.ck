class TheEvent extends Event {
    int pitch;
    float v;
}

NRev reverb => dac;
.02 => reverb.mix;

fun void foo(StkInstrument instr, TheEvent e) {
    instr => reverb;
    while (true) {
        e => now;
        e.pitch => Std.mtof => instr.freq;
        e.v => instr.noteOn;
    }
}

TheEvent e;

spork ~ foo(new StifKarp, e);
spork ~ foo(new Mandolin, e);
spork ~ foo(new Rhodey, e);
spork ~ foo(new Wurley, e);

1::second => now;

while (true) {
    Math.random2(40, 70) => e.pitch;
    Math.random2f(.5, .9) => e.v;
    e.signal();
    1::second => now;
}