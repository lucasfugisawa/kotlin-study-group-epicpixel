package exercicioPoo1

class CarrinhoEmMemoria : Carrinho {
    private val produtos: MutableMap<Produto, Int> = mutableMapOf()

    override var valorTotal: Double = 0.0
        get() = produtos.entries.sumOf { it.key.preco * it.value }
        set(value) {
            if (value >= 0)
                field = value
        }

    override fun adicionarProduto(produto: Produto, quantidade: Int) {
        produtos[produto] = produtos[produto] ?: 0 + quantidade
    }

    override fun removerProduto(produto: Produto) {
        val quantidadeAtual = (produtos[produto] ?: 0)
        if ((quantidadeAtual - 1) == 0) {
            produtos.remove(produto)
        } else {
            produtos[produto] = quantidadeAtual - 1
        }
    }

    override fun alterarQuantidade(produto: Produto, novaQuantidade: Int) {
        produtos[produto] = novaQuantidade
    }

    override fun limparCarrinho() {
        produtos.clear()
    }

    override fun exibirCarrinho() {
        for (item in produtos) {
            val nome = item.key.nome
            val precoUnitario = item.key.preco
            val qtdNoCarrinho = item.value
            val subtotal = precoUnitario * qtdNoCarrinho
            val str = "$nome / Preço: $precoUnitario / Qtd.: $qtdNoCarrinho / Subtotal: $subtotal"
            println(str)
        }
        println("Total do carrinho: $valorTotal")
    }

    override fun confirmarCompra() {
        for (item in produtos) {
            item.key.quantidadeEmEstoque -= item.value
        }
    }
}