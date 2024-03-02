package week1

import kotlin.math.sqrt

fun transformaNumeroEImprime(
    numero: Int,
    transf: (Int) -> (Int),
) {
    val numeroTransformado = transf(numero)
    println(numeroTransformado)
}

fun main() {

    transformaNumeroEImprime(5, { n: Int -> 3 * n })

    // com a lamba dentro dos parênteses da função (não é recomendado fazer assim):
    transformaNumeroEImprime(5, { n: Int ->
        val raiz = sqrt(n.toDouble())
        if (raiz < 10)
            n
        else
            3 * n
    })

    // com a lamba fora dos parênteses da função (é recomendado fazer assim):
    transformaNumeroEImprime(5) { n: Int ->
        val raiz = sqrt(n.toDouble())
        if (raiz < 10)
            n
        else
            3 * n
    }

}