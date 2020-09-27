Hid hid;
HidMsg msg;

// device number
0 => int device;
if (hid.openKeyboard(1) == false) me.exit();

//print
<<< "keyboard:", hid.name(), "ready" >>>;

BeeThree organ => JCRev reverb => dac;
.05 => reverb.mix;

while (true) {
    //wait for event
    hid => now;
    <<<"event">>>;
    //get message
    while (hid.recv(msg)) {
        
        if (msg.isButtonDown()) {
            <<< "BUTTON DOWN:", msg.ascii >>>;
            msg.ascii => Std.mtof => float freq;
            if (freq > 2000) continue;
            freq => organ.freq;
            1 => organ.noteOn;
            
        } else { //button up
            <<< "BUTTON UP:">>>;
            1 => organ.noteOff;
        }
    }
}