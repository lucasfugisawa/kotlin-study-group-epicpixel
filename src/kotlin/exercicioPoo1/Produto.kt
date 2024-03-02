package exercicioPoo1

data class Produto(
    val codigo: Int,
    var nome: String,
    var preco: Double,
    var quantidadeEmEstoque: Int = 0,
)
