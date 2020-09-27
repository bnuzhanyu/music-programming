<<< "zhanyu" >>>;

SinOsc s => dac;

1.0594630943592953 => float mul;
1.122462048309373 => float mul2;

//initial freq
220.0 * mul => float freq;
-1 => int dir;
0 => int cnt;
now + 30::second => time end;

while (now < end) {
    //calculate next freq
    mul2 => float nextMul;
    if (cnt == 2 || cnt == 6) {
        mul => nextMul;
    }
    if (dir == 1) {
        freq * nextMul => freq;
    } else {
        freq / nextMul => freq;
    }
    
    //play sound
    freq => s.freq;
    0.5::second => now;

    //calculate up/cnt    
    cnt + dir => cnt;
    if ((dir == 1 && cnt == 7) || (dir == -1 && cnt == -1)) {
        0 - dir => dir;
        cnt + dir => cnt;
    }
}

