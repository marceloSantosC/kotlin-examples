package _2Object_Oriented


private interface Base {

    val message : String

    fun print()
}

private class BaseImpl(private val x: Int) : Base {

    override val message : String = "Hello world"

    override fun print() { print("$x : $message") }

}

// Delegation pattern: Consiste em usar composição para atingir a mesma reusabilidade que herança
// Derived classes são usadas para implementar esse pattern sem boilerplate
// equivalente a declarar "private Base b;" em Java
// by é usado para indicar que by vai guardar objetos do tipo "Base"
private class Derived(b: Base) : Base by b

private class DerivedTwo(b: Base) : Base by b {

    // Override de membros não afeta a classe BaseImpl
    override val message : String = "Hi"

    // Override funciona normalmente, vai chamar o método que sobrescreve e não o método de BaseImpl
    override fun print() { println("Derived") }
}

fun main() {

    // Vai chamar BaseImpl.print, como se fosse herança
    val base = BaseImpl(10)
    val derived = Derived(base)
    derived.print()
}