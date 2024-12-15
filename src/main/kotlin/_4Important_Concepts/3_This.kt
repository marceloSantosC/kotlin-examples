package _4Important_Concepts




fun main() {

    // This é similar this em JS, mas não pode ser usado em funções normais ou quando não possui valor
    // Em uma classe this aponta para a classe atual, em receivers são o objeto à direita da função e em extensions são o que está sendo estendido


    // function literals with receiver são funções anônimas que possuem um receptor
    // O receptor permite que a função acesse membros do objeto de contexto diretamente, sem precisar referenciá-los
    val strBuilder = StringBuilder()
    strBuilder.append("Lorem")
    // This aponta para o receiver (StringBuilder)
    // É similar a passar o receiver como argumento, mas mais simples.
    // It aponta para o argumento string
    val func : StringBuilder.(str : String) -> String = { this.append(" Ipsum $it").toString() }
    println(func(strBuilder, " Sit"))




}

