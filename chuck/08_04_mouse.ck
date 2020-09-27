Hid hid;
HidMsg msg;

// device number
0 => int device;
if (hid.openMouse(device) == false) me.exit();

SndBuf buffy => dac;
me.dir() + "/audio/snare_01.wav" => buffy.read;

buffy.samples() => buffy.pos;

while (true) {
    //wait for event
    hid => now;
    //get message
    while (hid.recv(msg)) {
        if (msg.isButtonDown()) {
            <<<"BUTTON DONW" >>>;
            0 => buffy.pos;
            
        } else if (msg.isMouseMotion()) {
            if (msg.deltaX != 0) {
                msg.deltaX / 20 => buffy.rate;
            }
        }
    }
}