package week1

fun main() {
    `numbers, bools and chars`()
    strings()
    arrays()
}

private fun `numbers, bools and chars`() {

    // Números inteiros (exceto unsigned):
    val byteValue: Byte = 1 // 8 bits
    val shortValue: Short = 1 // 16 bits
    val integerValue: Int = 1 // 32 bits
    val longValue: Long = 1L // 64 bits

    var idade = 5
    // inferência de tipo

    val valor: Int? = null
    // nullable

    // Ponto flutuante:
    val floatValue: Float? = null // 32 bits
    val doubleValue: Double = 1.0 // 64 bits

    // Booleano:
    val booleanValue: Boolean = true // 1 bit

    // Caractere
    val charValue: Char = '#' // 16 bits

    val anotherChar: Char = 35.toChar()
    println(anotherChar)

    val anotherUnicodeChar: Char = '\u0023'
    println(anotherUnicodeChar)
}


private fun strings() {

    var stringLiteral: String = "abcd 123"

    val rawString = """
    #   for (c in "foo")
    #       print(c)
    #       
    """.trimMargin("#")
    println(rawString)

    val stringTemplate = "'$stringLiteral' tem ${stringLiteral.length} caracteres"
    println(stringTemplate)

    for (c in stringLiteral) {
        println("$c é um caractere de '$stringLiteral'")
    }
}


private fun arrays() {

    // Arrays:
    val arrayOfInts = intArrayOf(1, 2, 3)
    val asc = Array(5) { i -> (i * i).toString() }

    // Arrays de tipos primitivos:
    val arr1: IntArray = intArrayOf(1, 2, 3)
    arr1[0] = arr1[1] + arr1[2]
    println(arr1.toList())

    val arr2 = IntArray(5) { 42 }
    println(arr2.toList())

    var arr3 = IntArray(5) { it * 2 }
    println(arr3.toList())
}