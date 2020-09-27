adc => Gain g => blackhole;

while (true)
{
    if (adc.last() > 0.9) {
        <<< "loud!!!", adc.last() >>>;
    }
    1.0::samp => now;
}
