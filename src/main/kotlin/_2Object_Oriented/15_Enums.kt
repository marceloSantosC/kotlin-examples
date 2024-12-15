package _2Object_Oriented

import kotlin.enums.EnumEntries

// Enums são similares a enums Java e podem ser usados para guardar valores
// Enums implementam Comparable e usam ordem natural (1 é maior que 2, a é maior que b, etc) para comparar valores
private enum class Direction  {
    NORTH, SOUTH, WEST, EAST
}
private enum class Color(val rgb: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF)
}

// Enums também podem declarar classes anônimas com métodos e sobrescrever funções
private enum class Math {
    SUM {
        override fun exec(a: Int, b: Int) : Int = a + b
    },

    DIVISION {
        override fun exec(a: Int, b: Int) : Int = a / b
    };

    // Também poderia ser uma interface
    abstract fun exec(a: Int, b: Int) : Int
}

fun main() {

    // Métodos de constantes são similares a Java

    // valueOf lança IllegalArgumentException se não der match
    Direction.valueOf("NORTH")

    // enumEntries<T>() e enumValues<T>() também existem
    val entries : EnumEntries<Direction> = Direction.entries // Enum.values() existem mas foi deprecated
    entries.forEach{ println(it) }

    // Ordinal e name
    println(Direction.EAST.name)
    println(Direction.EAST.ordinal) // Ordem de declaração (iniciado em 0)

    // Chamando as funções do enum
    println(Math.SUM.exec(20, 30))
    println(Math.DIVISION.exec(10, 5))

}