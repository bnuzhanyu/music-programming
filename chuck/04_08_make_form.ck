SndBuf click => dac;
SndBuf kick => dac;

me.dir() + "/audio/kick_01.wav" => kick.read;
me.dir() + "/audio/click_01.wav" => click.read;
kick.samples() => kick.pos;
click.samples() => click.pos;

[1,0,0,0,1,0,0,0] @=> int kick_ptrn_1[];
[0,0,1,0,0,0,1,0] @=> int kick_ptrn_2[];
[0,1,0,1,0,1,0,1] @=> int click_ptrn_1[];
[1,1,1,0,1,1,1,0] @=> int click_ptrn_2[];

fun void section(int kick_ptrn[], int click_ptrn[], float beattime) {
    for (0 => int i; i < kick_ptrn.cap(); i++) {
        if (kick_ptrn[i] == 1) {
            0 => kick.pos;
        }
        if (click_ptrn[i] == 1) {
            0 => click.pos;
        }
        beattime::second => now;
    }
}

while(true) {
    section(kick_ptrn_1, click_ptrn_1, .2);
    section(kick_ptrn_2, click_ptrn_2, .2);
}

