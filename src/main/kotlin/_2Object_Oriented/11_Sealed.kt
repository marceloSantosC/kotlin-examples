package _2Object_Oriented

// Sealed classes e interfaces permitem controlar quais classes podem herdar/implementar de outras
// São uma forma de criar uma hierarquia de herança rígida
// Subclasses devem estar no mesmo módulo e package da sealed class (até 1.5 deveria ser no mesmo arquivo)
// Uma classe sealed também é abstract
// Sealed classes são usadas quando um supertipo tem uma quantidade conhecidas de opções e cada opção é diferente em funcionalidade
// Quando existe um supertipo possui opções conhecidas que só diferem em valor é melhor usar enum
private sealed class Employee(val name: String)

// Somente essas implementações e outras implementações no mesmo módulo/package vão existir, SealedClass não pode ser herdada por terceiros
private class Manager(name: String): Employee(name)
private class Director(name: String): Employee(name)
private class CommonWorker(name: String): Employee(name)



fun main() {

    val manager = Manager("Joe")
    val director = Director("Josef")
    val commonWorker = CommonWorker("Jhon")

    println(saluteEmployee(manager))
    println(saluteEmployee(director))
    println(saluteEmployee(commonWorker))

}

private fun saluteEmployee(employee: Employee): String {

    // Quando when é usado com uma classe sealed é necessário usar else ou especificar uma condição para cada tipo
    // Gera erro de compilador se essa condição não for atendida
    return when(employee) {
        is CommonWorker -> "Hi, Manager ${employee.name}"
        is Director -> "Hi, Director ${employee.name}"
        is Manager -> "Hi, ${employee.name}"
    }
}