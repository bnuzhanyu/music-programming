ModalBar one => dac.left;
ModalBar two => dac.right;

7 => one.preset;
4 => two.preset;

fun void foo(){
    while (true) {
        <<< "foo" >>>;
        1 => one.strike;
        250::ms => now;
    }
}

fun void bar(){
    while (true) {
        <<< "bar" >>>;
        1 => two.strike;
        1000::ms => now;
    }
}

spork ~ foo();
spork ~ bar();

while (true) 1::second => now;
