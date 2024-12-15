package _2Object_Oriented

// * define um generic como star-projection, também chamado de erased type
// Quando * é usado isso indica ao compilador que qualquer tipo pode ser usado naquele generic, similar a Object
// * será considerado do tipo Any? dentro da função
// Function<*, String> == Function<in Nothing, String>
// Function<Int, *> == Function<Int, out Any?>.
// Function<*, *> == Function<in Nothing, out Any?>
fun printList(list: List<*>) {

    // Só esse type check funciona
    println(list is List<Any?>)

    list.forEach { print("$it ") }
}


// Função com Generic
fun <T> genericFunc(item: T) : String {
    return item.toString()
}


// Generic Constraints: Permitem definir quais tipos podem ser usado com o tipo Generic

// Upper Bounds: Equivalente a extends de Java (<T extends Object>)
// Qualquer classe que implemente Comparable<T>
// O upper bound padrão (<T>) é <T : Any?>
private class UpperBoundClass<T : Comparable<T>>

// Definindo mais de um Upper bound (as condições do upper bound usam AND)
// T deve ser subtipo de CharSequence e implementar Comparable e Function
private class TwoUpperBoundClass<T> where T : CharSequence, T : Comparable<T>, T : Function<T>

// Definitely non-nullable types são tipos Generic que nunca serão null
private class NeverNullGeneric<T> {

    // É usado ao ter certeza que um argumento não será null
    // Normalmente é usado para códigos que se integram com generics Java, anotados com @NotNull
    fun printAny(item: T & Any) {
        println(item)
    }
}


private fun main() {
    printList(mutableListOf(1, 2, 3, 4))

    // Inferência de tipos funciona, mas é possível declarar o tipo se necessário
    genericFunc<Double>(12.2)


    // Assim como em Java Kotlin usa Type erasure para generics, em tempo de execução todos os tipos generics são *
    // Isso quer dizer que List<Int> e List<String> são tratados como List<Any?> em tempo de execução
    // Por esse motivo não é possível fazer type check em generics de maneira confiável
    // Em outras palavras não é possível verificar qual o tipo de um Generic em tempo de execução
    val list: List<Int> = listOf(1, 2 ,3 ,4)

    // Essa verificação retorna true porque o que está sendo verificado em tempo de execução é list is List
    // Se fosse um caso onde mais de um tipo pudesse ser usado no generic isso causaria problemas, pois retornaria true para tudo
    println(list is List<Int>)

}