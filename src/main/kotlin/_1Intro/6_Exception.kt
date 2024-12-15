package _1Intro

import kotlin.jvm.Throws

fun main() {

    // Todas exceptions são unchecked por padrão, todas exceptions herdam de Exception que herda de Throwable
    // Error existe e também herda de Throwable, representando o mesmo
    // RuntimeException existem e representa um erro que pode ser impedido pelo dev
    // Stack trace também existe e é inferida automaticamente

    val input = readln().toIntOrNull()

    // require lança IllegalArgumentException se condição for false
    // Deve ser usado para validar inputs
    // require e check podem ser usados para fazer casting e garantir o tipo com o operador is
    require(input != null) // requireNotNull também existe
    require(input != 400) { "O input deve ser diferente de 400" } // sobrescrever e mensagem (padrão é vazia)

    // check lança IllegalStateException se condição for false
    // Deve ser usado para verificar o estado de um objeto ou variável
    check(input < 20000)

    // error Lança uma IllegalStateException com uma mensagem
    if (input == 200) {
        error("Estado inválido")
    }

    // Throw funciona da mesma forma que em Java
    if (input == 250) {
        println("Input inválido")
        throw IllegalArgumentException("Input inválido")
    }

    // try catch normal
    // funciona da mesma forma que em Java, a ordem importa
    try {
        functionThatThrowsException()
    } catch (e: IllegalStateException) {
        print("Exception occurred: ${e.message}")
    } catch (e: ArithmeticException) {
        print("ArithmeticException occurred: ${e.message}")
    } finally {
        println("finally")
    }

    // try catch expression, ou será retornado o valor do bloco try ou será o do bloco catch em caso de exception
    // finally sempre é executado, mas não interfere em nada
    val variable = try {
        functionThatThrowsException()
    } catch (e: CustomException) {
        10 // Se CustomException for lançada variable recebe o valor 10
    }
    println(variable)

    functionThrowsAnnotation() // @Throws não força a tratar a exception, ainda é unchecked

}

// Exception custom
// Exceptions guardam o estado da stack trace de onde elas foram criadas e por isso não devem ser reusadas
// É possível criar uma hierarquia de exceptions como em Java
class CustomException: Exception("Default message")


// Nothing representa um valor que nunca existe
// Toda expressão tem um tipo, a expressão throw é do tipo Nothing
// Nothing é um subtipo de todos os tipos, então Int poderia ser substituído por Nothing
// O compiler vai trocar esse Int para Nothing, nesse caso Nothing representa uma função que nunca retorna um valor
fun functionThatThrowsException(): Int {
    throw CustomException()
}

// @Throws informa a JVM que a exception deve ser adicionada a assinatura do metodo quando a classe for compilada
// Isso não obriga quem chama a função a tratar a exception, é só um metadado usado para interoperabilidade com checked exceptions Java
@Throws(CustomException::class) // será transformado em: void functionThrowsAnnotation() throws CustomException {
fun functionThrowsAnnotation() {
    throw CustomException()
}