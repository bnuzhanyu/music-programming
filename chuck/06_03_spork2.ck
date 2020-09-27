ModalBar modal => NRev reverb => dac;

.1 => reverb.mix;

7 => modal.preset;
.9 => modal.strikePosition;

spork ~ tune();

while(true) 
{
    1 => modal.strike;
    300::ms => now;
    .7 => modal.strike;
    300::ms => now;
    
    repeat(6) {
        .5 => modal.strike;
        100::ms => now;
    }
}

fun void tune() {
    while (true) {
        84 + Math.sin(now / second * Math.PI*.25) * 2
        => Std.mtof => modal.freq;
        5::ms => now;
    }
}
