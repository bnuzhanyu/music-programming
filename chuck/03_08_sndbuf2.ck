//example of 
SndBuf2 mySound => dac;
me.dir() + "/audio/stereo_fx_01.wav" => string filename;
filename => mySound.read;

while(true) {
    Math.random2f(.6, 3) => mySound.rate;
    0 => mySound.pos;
    3::second => now;
}