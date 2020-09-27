//renson filters
ModalBar m => dac;

while(true) {
    //Math.random2(0,8) => m.preset;
    for (0 => int i; i <= 10; i++) {
        i => m.preset;
        //Math.random2f(200.0, 1000.0) => m.freq;
        
        1.0 => m.noteOn;
        1::second => now;
    }
}