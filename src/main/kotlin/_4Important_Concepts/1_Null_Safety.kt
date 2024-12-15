package _4Important_Concepts

// Tipos são not null por padrão
private data class Example(val nullableClass: NullableClass? = null)

private data class NullableClass(var value : String = "Value")

fun main() {


    val example = Example()

    // Elvis operator (?) é suportado (retorna null se algum valor for null)
    println(example.nullableClass?.value)

    // Let recebe o valor de this (nullableClass) e executa uma operação
    // Let e ? podem ser combinados para executar uma operação quando um valor não é null
    example.nullableClass?.let { println(it) }

    // Nesse caso o que está a direita de = só é executado se elvis operator não retornar null
    example.nullableClass?.value = "Not null"

    // ?: é equivalente a orElse de Optional, se nullableClass retornar null então retornado o valor "alternative"
    // Poderia ser reescrito para: if (example.nullableClass != null) example.nullableClass.value else "alternative"
    println(example.nullableClass?.value ?: "alternative")


    // not-null assertion operator é similar a elvis operator, porém se o valor for null será lançada uma NPE
    try {
        println(example.nullableClass!!.value)
    } catch (e: NullPointerException) {
        println(e::class)
    }


    // Safe cast (as?) quando se usa esse as? em vez de lança um ClassCastException será retornado null ao fazer um cast inválido
    val any : Any = 10
    println(any as? String)




}