package week2

fun main() {

    val pessoa1 = Pessoa("Lucas", 40)
    val pessoa2 = Pessoa("Lucas", 40)

    println(pessoa1)

    val (nome, idade) = pessoa1
    println("A pessoa $nome tem $idade anos.")
}

data class Pessoa(
    val nome: String,
    val idade: Int,
)