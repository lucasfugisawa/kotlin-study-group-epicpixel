package exercicioPoo1

interface Carrinho {
    val valorTotal: Double
    fun adicionarProduto(produto: Produto, quantidade: Int)
    fun removerProduto(produto: Produto)
    fun alterarQuantidade(produto: Produto, novaQuantidade: Int)
    fun limparCarrinho()
    fun exibirCarrinho()
    fun confirmarCompra()
}