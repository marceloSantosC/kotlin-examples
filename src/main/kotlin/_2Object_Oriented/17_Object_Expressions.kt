package _2Object_Oriented

private interface MyInterface {

    fun call() : Int

    fun execute() : Int

}

private abstract class MyClass(val value : Int)

// object declaration
// Objeto só vai ser instanciado uma vez (Singleton) de maneira thread-safe e ocorrerá no primeiro acesso
object SingletonInstance {

    private val items = listOf(20, 30, 40)

    fun getItems() : List<Int> = items

}

// Companion Object
// Permite chamar um nested object usando a Outer class
// Não pode ser local (dentro de função), mas pode ser nested em outros objetos
private class OuterWithCompanion {

    companion object Companion {

        private val items = listOf(20, 30, 40)

        fun getItems() : List<Int> = items
    }

}

// Data é suportado
// Equals e hashCode padrão só vão considerar iguais objetos do mesmo tipo e não podem ser override
// Copy não é suportada (é Singleton) ou componentN
private data object DataObjDec {

    // Pode ter const
    const val CONSTANT : Int = 3

    var value : Int = 25

    // equals e hashCode não podem ser sobrescritos

}




fun main() {

    val name = "Jhon"

    // Object expressions e declarations permitem criar uma classe baseada sem declarar ela como subtipo (herança)
    // Object expressions permitem criar classes anônimas que podem herdar de outras ou implementar interfaces
    // São equivalentes a classes anônimas de Java, mas não possuem construtores
    val helloWorld = object {

        val hello = "Hello"

        // É possível acessar variável declaradas na função
        override fun toString(): String = hello + name
    }
    println(helloWorld)

    // Herança com Object expression
    val anonObj = object : MyInterface, MyClass(20) {
        override fun call(): Int = 10

        override fun execute(): Int = 20
    }
    anonObj.call()
    anonObj.execute()


    // Usando object declaration
    // SingletonInstance será instanciado aqui (primeiro acesso)
    SingletonInstance.getItems()

    // Companion permite chamar getItems como se ele fosse um método de OuterWithCompanion
    OuterWithCompanion.getItems()

    // Data object declaration
    DataObjDec.CONSTANT
    DataObjDec.value = 30


}