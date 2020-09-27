SndBuf buf => Pan2 p => dac;
0.5 => buf.gain;

<<< me.dir() >>>;
for(1 => int i; i <= 5; i++) {
    Math.random2f(-1.0, 1.0) => p.pan;
    me.dir() + "/audio/hihat_0" + i + ".wav" => buf.read;
    1::second => now;
}
