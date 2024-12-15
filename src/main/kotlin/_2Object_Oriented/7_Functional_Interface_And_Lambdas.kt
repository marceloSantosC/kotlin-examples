package _2Object_Oriented

// Interfaces funcionais funcionam da mesma forma que em Java
// Também são chamadas Single Abstract Method (SAM) interface
fun interface CustomToString {
    fun calculate(value: Int): String
}

// Lambda como argumento de função
fun exec(lambda: (value: Int) -> String): String {
    return lambda(20)
}

fun main() {


    // Lambda
    // Com declaração de tipos (Unit é retornado quando a função é void)
    // A última expressão é o valor que será retornado, return faz o mesmo que return faria fora da função
    // Se for necessário usar return é melhor usar uma função anônima
    val typedSquare: (Int) -> String = {value ->
        value * value
        value.toString()
    }
    println(typedSquare(2))

    // Inferência de tipos é suportada
    //  o compilador vai inferir uma interface funcional que recebe um int e retorna uma string
    val square = {number: Int ->
        val result = number * number
        result.toString()
    }
    println(square(2))

    // It é usado para referenciar o argumento de uma função que só tem um parâmetro
    // Não é necessário declarar "it -> ..."
    val array = arrayOf(1, 2, 3, 4)
    array.forEach { println(it) }

    // Lambda como argumento de função
    exec(square)
    exec({ it.toString() })
    exec { it.toString() }

    // Method reference
    // Funciona como uma lambda normal
    val reference = Double::isFinite
    reference(20.0)

    // Criar e chamar lambda a partir de interface funcional
    val customFi: CustomToString = CustomToString { "$it" }
    customFi.calculate(20)


}