package _2Object_Oriented

// Similar a generics de Java
private class Box<C>(val content: C)


private open class Animal

private class Dog : Animal()

private class Cat : Animal()

fun main() {

    // O tipo pode ser inferido através do construtor
    val boxOfString: Box<String> = Box("String Content")
    println(boxOfString)

    // Covariância: Permite que um subtipo seja usado onde um super tipo é esperado
    // Como Dog é subtipo de Animal ele pode ser usado no lugar Animal
    // Quando covariância é usada não é possível adicionar elemento na lista (ela é mutável, clear funciona)
    // Em Java é representado por List<? extends Animal> em Kotlin é representado por List<out Animal>
    val dogs : MutableList<Dog> = mutableListOf(Dog(), Dog())
    val animals : MutableList<out Animal> = dogs
    // animals.add não suportado, mesmo sendo MutableList
    println(animals)



    // Contravariância: Permite que um super tipo seja usado onde um subtipo é esperado
    // Em Java é representado por List<? super Animal> em Kotlin é representado por List<in Animal>
    val animals2 : MutableList<Animal> = mutableListOf(Animal(), Cat(), Dog())
    val dogs2 : MutableList<in Dog> = animals2

    // Adicionar é suportado, desde que o tipo seja compatível
    dogs2.add(Dog())

    // Leitura sempre retorna o objeto do tipo Any?
    val dog : Any? = dogs2[0]

    println(dogs2)
    println(dog)



    // Invariância: Não permite que um tipo seja substituído por outro tipo, mesmo que eles tenham relação de herança
    // Kotlin/Java é invariante por padrão, uma lista do tipo List<T> é invariante (isso não inclui interfaces)
    val animals3 : MutableList<Animal> = mutableListOf(Dog(), Dog(), Cat())
    // Gera erro de compilação
    // val dogs3 : List<Dog> = animalsInvariant
    // val cats3 : List<Cat> = animalsInvariant
    println(animals3)

    // Adicionar um elemento do subtipo a uma lista do supertipo é permitido
    animals3.add(Dog())
    animals3.add(Cat())






}