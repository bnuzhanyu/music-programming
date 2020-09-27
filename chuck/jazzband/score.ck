//score.ck

//paths to chuck files

["piano", "bass", "drums", "flute"] @=> string paths[];

[0,1,2,3] @=> int ids[];

for (0 => int i; i < 4; i++) {
    Machine.add(me.dir() + "/" + paths[i] + ".ck") => ids[i];
}
