package _1Intro

fun main() {

    // if expression, if funciona como uma expressão e por isso não existe ternário
    // fora isso nada muda para Java
    print("Int input: ")
    val input = readln().toIntOrNull()
    val inputLessThan10 = if (input == null || 10 > input) 1 else 0 // input == null || 10 > input ? 1 : 0
    println("$inputLessThan10");

    // when (switch)
    // Não é necessário break, quando uma condição ocorre a execução para
    when(input) {
        null -> println("Input null");
        0, 1 -> println("Input 0 ou 1");
        2 -> println("Input 2");
        in 3..10 -> println("Input entre 3 e 10"); // in é usado para checar um range, !in também existe
        is Int -> println("Input is int")
        else -> println("Unknown"); // else = default, não é obrigatório se todos casos forem cobertos
    }
    // when(val input2 = readln()) {} // Também funciona

    // for iterator
    // funciona para qualquer coisa que tenha um iterator, ou seja, que tenha um função retornando Iterator<>
    val array = arrayOf(1, 2, 3, 4, 5)
    for (item in array) { // for (item: Int in array) também funciona, o {} não é necessário quando só existe uma instrução
        println(item)
    }

    // fori
    for (i in array.indices) {
        println(array[i])
    }
    for ((index, value) in array.withIndex()) {
        println("$index, $value")
    }


    // for range
    for (i in 1..2) { // for (int i = 1; i < 2; i++)
        println(1)
    }
    for (i in 10 downTo 0 step 5) { // for (int i = 10; i > 0; i - 5)
        println(i)
    }

    // foreach
    array.forEach { // lambda expression
        println(it) // it é declarado automaticamente
    }
    array.forEach(fun(value: Int) { // função anônima
        println(value)
    })

    // while e do-while seguem o mesmo padrão e labels são suportados
    var count = 0;
    label@ while (true) {
        if (count == 0) {
            count++
            continue
        }
        else break@label;
    }





}