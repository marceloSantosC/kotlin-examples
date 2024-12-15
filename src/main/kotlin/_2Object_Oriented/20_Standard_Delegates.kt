package _2Object_Oriented

import kotlin.properties.Delegates


// São classes que podem ser usadas como Delegate e que já vem na lib padrão do Kotlin
private class StandardDelegates(map : MutableMap<String, Any>) {

    // lazy delegate faz com que a property só seja computada quando ela for acessada a primeira vez
    // similar a @FetchType(Lazy) de hibernate
    val lazy : Double by lazy { 10.0 / 2.0 }

    // observable vai executar a lambda toda vez que o valor da property mudar
    // O primeiro argumento é KProperty (Field), o segundo o valor antigo e o terceiro o valor novo
    // Também existem outros delegates em Delegates
    var observable: String by Delegates.observable("valor inicial") { _, old, new ->
        println("Old value: $old, New value: $new")
    }

    // É possível fazer o delegate para uma property, nesse caso o getter/setter da property vai ser chamado
    var newProperty = ""
    var deprecatedProperty : String by this::newProperty


    // Também dá para usar um map
    // Em vez de escrever/ler na backing property escreve no map
    // útil quando lidando com Json dinâmico
    var name : String by map
    var age : Int by map

}

fun main() {

    val standardDelegates = StandardDelegates(mutableMapOf(Pair("key", "value")))

    // Vai fazer o cáculo agora
    println(standardDelegates.lazy)

    // executa a lambda passada como delegate
    standardDelegates.observable = "novo valor"

    // Lê e escreve em newProperty
    standardDelegates.deprecatedProperty = "20"
    println(standardDelegates.deprecatedProperty)

    // Leitura feita a partir do map
    println(standardDelegates.name)
    println(standardDelegates.age)

    // Variáveis locais com delegates são suportadas
    val delegateVar by lazy { 10.0 }

}