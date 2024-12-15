package _2Object_Oriented

// Mesmo conceito de Java
abstract class Polygon {
    abstract fun calculateArea(): Int
}

class Rectangle(private val width: Int, private val length: Int): Polygon() {

    override fun calculateArea(): Int {
        return width * length
    }
}


fun main() {

    val twoByTwo = Rectangle(2, 2)
    println(twoByTwo.calculateArea())

}