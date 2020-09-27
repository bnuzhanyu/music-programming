//example of sound buf, gain

Gain master => dac;

SndBuf kick => master;
SndBuf hihat => master;
SndBuf snare => master;

me.dir() + "/audio/kick_01.wav" => kick.read;
me.dir() + "/audio/hihat_01.wav" => hihat.read;
me.dir() + "/audio/snare_01.wav" => snare.read;

.4 => master.gain;
//set pos to last to make no sound
kick.samples() => kick.pos;
hihat.samples() => hihat.pos;
snare.samples() => snare.pos;

//initial count
0 => int counter;
while (true) {
    counter % 8 => int beat;
    if (beat == 0 || beat == 4) {
        0 => kick.pos;
    }
    if (beat == 2 || beat == 6) {
        0 => snare.pos;
    }
    0 => hihat.pos;
    .2 => hihat.gain;
    Math.random2f(.5, 1.5) => hihat.rate;
    counter++;
    100::ms=>now;
}
