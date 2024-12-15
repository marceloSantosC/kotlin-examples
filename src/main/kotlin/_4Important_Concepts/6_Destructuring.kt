package _4Important_Concepts


// Destruct é feito através de funções componentN, implementadas por padrão data class
private data class ToDestruct(val name: String, val value: Int)

fun main() {

    // Destructuring funciona em qualquer retorno de função
    val (name, value) = ToDestruct("Test", 1)
    println("$name, $value")


    // Funciona em collections/lambda
    val map = mapOf(Pair(1, ToDestruct("T1", 2)), Pair(2, ToDestruct("T2", 2)))
    for ((k, v) in map) {
        println("$k - $v")
    }

    // Se existisse um terceiro argumento a chamada seria { (k, v), arg -> ... }
    // { a, b -> ... } passa parâmetros e { (a, b) -> ... } destructuring
    map.mapValues { (k, v) -> println("$k / $v") }





}