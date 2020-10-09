# Java音乐基础类



### 音符

音高：Pitch 枚举类型，id（0-11）

音符：类，Pitch + OctaveId，能计算hz

Midi音符：接口，能返回音符 和 midi的id

### 节奏

长度为

NoteLength：接口，可以返回一个int值，表示note长度，可以返回附点NoteLength

NoteLengthEnum: 实现NoteLength的枚举类，含有全音符，二分音符-- 六十四分音符的值

FreeNoteLength：实现NoteLength，构造方法为一个长度

一些工具，bpm转换为真实时间？

### 音程

NoteInterval: 接口，返回半音数，可以为负数

NoteIntervalEnum: 枚举，实现NoteInterval，小二，大二，等等，也可以dec

FreeNoteInterval: 实现NoteInterval, 根据半音数增加音程

### 和音-和弦

harm: 接口，返回`List<MidiNote>`

chord: 实现harm,返回root

ChordDefinition 接口，给定root生成和弦，给定root（MidiNote)和转位生成和弦

ChordType 枚举，实现ChordDefinition，大三，小三，（含音程关系）

#### 调式





