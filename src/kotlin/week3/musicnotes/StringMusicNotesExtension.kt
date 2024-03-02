package week3.musicnotes

fun musicNotes() = listOf("C", "C#/Db", "D", "D#/Eb", "E", "F", "F#/Gb", "G", "G#/Ab", "A", "A#/Bb", "B")

fun String.transpose(interval: Int): String {
    val notes = musicNotes()
    val index = notes.indexOf(this)
    return notes[(index + interval) % notes.size]
}

fun String.majorChord(): List<String> {
    val notes = musicNotes()
    val index = notes.indexOf(this)
    return listOf(notes[index], notes[(index + 4) % notes.size],
        notes[(index + 7) % notes.size])
}

fun String.minorChord(): List<String> {
    val notes = musicNotes()
    val index = notes.indexOf(this)
    return listOf(notes[index], notes[(index + 3) % notes.size],
        notes[(index + 7) % notes.size])
}