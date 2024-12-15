package _3Functional

private class ClassWithMethod(private val property: String = "ClassWithMethod") {
    fun propertyEquals(value: String) = this.property == value
}

fun main() {

    // Funções são first-class, elas podem ser armazenadas em variáveis/estruturas, retornadas e passadas como argumento para outras funções
    // High-order function: É uma função que recebe outra função parâmetro ou retorna uma função
    // Função que recebe função
    fun <T> highOrder(value: T, verify : (value : T) -> Boolean) {
        if (verify(value)) println("$value succeeded check")
        else println("$value did not succeed check")
    }

    // Função que retorna função
    val function = fun() : (String) -> Boolean {
        return { it.isEmpty() }
    }
    highOrder("test", function())

    // Callable reference permite passar uma função membro de um objeto como parâmetro
    // A função vai usar os dados da instância (ClassWithMethod.property) na hora da chamada, similar a JS
    val classWithMethod = ClassWithMethod()
    highOrder("", classWithMethod::propertyEquals)


    // Trailing lambdas se o último parâmetro de uma função é uma função um lambda expression pode ser passada como arg fora dos parênteses
    // Quando só uma função é passada como arg os parênteses podem ser omitidos
    highOrder("A") { it.isEmpty() } // o mesmo que: highOrder("A", { it.isEmpty() })

    // Return só é suportado com qualified return
    val list = listOf(1, 2, 3, 4)
    list.filter {
        val predicate = it > 0
        return@filter predicate // indica que a fun filter vai retornar predicate
    }

    // Return explicito permite código no estilo LINQ
    list.filter { it > 0 }.sortedBy { it }. map { it.toString().uppercase() }





}
