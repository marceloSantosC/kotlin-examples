package _1Intro

// Não é um field já que não tem classe. É chamado de top level variable
val topLevelVariable = 10;

fun main() {

    val finalVariable = 10; // Equivalente a final int value = 10; com type inference
    val explicitType:Int = 10; //  val/var é obrigatório sempre
    var implicitType = 10;

    println(finalVariable);
    println(implicitType);
    println(explicitType);
    println(topLevelVariable);
    println("Hello world");

    // String templates: String interpolation suportado, {} não é obrigatório
    println("$topLevelVariable - $finalVariable - $implicitType - $explicitType");

}