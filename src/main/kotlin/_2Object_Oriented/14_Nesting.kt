package _2Object_Oriented


// Classes podem ser nested como em Java
private class Outer {

    // Não é acessível de dentro de Nested
    val outer = 0

    class Nested {
        val nestedVal = 0
    }

    fun interface NestedInterface {
        fun exec(value: Int)
    }

}


// Classes nested podem ser inner, inner permite a classe nested acessar membros da classe Outer, mesmo que seja private
private class OuterInner {

    val outer = 12

    inner class Inner {
        val inner = 14

        fun outerPlusInner() : Int {
            return outer + inner
        }

    }

}

fun main() {

    // Acessando classes nested
    val nested = Outer.Nested()
    nested.nestedVal
    Outer.NestedInterface { println(it) }

    // Acessando Inner class (construtor de Inner só pode ser chamado a partir de uma instância de OuterInner)
    val inner = OuterInner().Inner().outerPlusInner()
    println(inner)

}