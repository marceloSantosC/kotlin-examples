package _3Functional


// Operator overloading permite prover implementações customizadas para operadores nativos
private class Square(val length : Int, val width : Int) {

    /*
        Suporta operadores: plus, minus, times, div, rem ou mod (%), plusAssign e minusAssign (+= e -=), get/set ([]),
        equals, compareTo (<), invoke ("()"), contains (in), unaryPlus(+x), unaryMinus(-x) e not(!x)
     */
    // Quando o operador + for usado vai chamar essa função
    operator fun plus(other : Square) : Square {
        val totalLength = this.length + other.length
        val totalWidth = this.width + other.width
        return Square(totalLength, totalWidth)
    }

    override fun toString(): String {
        return "Width = $width, Length = $length, Area = ${width  * length}"
    }

}

// Também possível usar com extension function (agora operador + é subtração)
private operator fun Square.minus(other : Square) = Square(this.length - other.length, this.width - other.width)

// Não funciona (vai ser shadowed)
private operator fun Int.plus(other : Int) = this - other

fun main() {

    val square1 = Square(2, 2)
    val square2 = Square(2, 2)

    // + Vai chamar o método plus de square
    val squareSum = square1 + square2
    println(squareSum)

    println(square1 - square2)

    println(2 + 2) // 4


}