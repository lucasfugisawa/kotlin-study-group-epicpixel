package week1

fun main() {

    // while:
    var counter1 = 0
    while (counter1 < 10) {
        println(counter1)
        counter1++
    }

    // do-while:
    do {
        println(counter1)
        counter1--
    } while (counter1 > 0)

    // for:
    for (i in 0..9) {
        println(i)
    }

    // for (int i = 0; i < 10; i += 2) { println(i); }

    for (i in 0 until 10 step 2) {
        println(i)
    }

    for (i in 9 downTo 0 step 3) {
        println(i)
    }
    // for (int i = 9; i > 0; i = i -3) { println(i); }

    for (c in 'a'..'z') {
        println(c)
    }

    val list1 = listOf("a", "b", "c")
    for (s in list1) {
        println(s)
    }

    for ((index, value) in list1.withIndex()) {
        println("$index: $value")
    }

    val map1 = mapOf(
        1 to "one",
        2 to "two",
        3 to "three",
    )

    for ((key, value) in map1) {
        println("$key -> $value")
    }

    for (ch in "abc") {
        println(ch)
    }

    val nomes = listOf("João", "Maria", "Madalena")

    for (nome in nomes) {
        if (nome.length >= 5) {
            println(nome)
        }
    }
}
