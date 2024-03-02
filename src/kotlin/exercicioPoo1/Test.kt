package exercicioPoo1

fun mainOld() {

    val produto1 = Produto(1, "Alho", 10.0, 10)
    val produto2 = Produto(2, "Cebola", 20.0, 20)
    val produto3 = Produto(3, "Azeite", 30.0, 5)
    val produto4 = Produto(4, "Sal", 40.0, 50)
    val produto5 = Produto(5, "Pimenta", 50.0, 25)

    val carrinho: Carrinho = CarrinhoEmBD()
}

fun main() {
    var pessoaQualquer: Pessoa = PessoaJuridica("123", "João")
    pessoaQualquer.imprimirDados()

    pessoaQualquer = Pessoa("234", "Maria")
    pessoaQualquer.imprimirDados()

    pessoaQualquer = PessoaFisica("2345", "Mariana")
    pessoaQualquer.imprimirDados()
}

open class Pessoa(document: String, nome: String) {
    val documento: String = document
    val nome: String = nome

    open fun imprimirDados() {
        val dados = "Documento: $documento, Nome: $nome."
        println(dados)
    }
}

class PessoaJuridica(document: String, nome: String) : Pessoa(document, nome) {
    override fun imprimirDados() {
        val dados = "CNPJ: $documento, Razão Social: $nome."
        println(dados)
    }
}

class PessoaFisica(document: String, nome: String) : Pessoa(document, nome) {
    override fun imprimirDados() {
        val dados = "CPF: $documento, Nome: $nome."
        println(dados)
    }
}