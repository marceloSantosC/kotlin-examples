package _3Functional

private  fun funWithManyArgs(a : String, b : Int = 10, c : Int, d : Double = 10.0) {
    println("$a - $b - $c - $d")
}


// VarArgs
private fun funWithVarArgs(vararg strings: String) {
    println(strings.contentToString())
}

// Infix permite usar infix notation quando chamando a função (2 multiply 2 * 2 em vez de 2.multiply(2 * 2))
// deve ser extension function, ter um único parâmetro (sem varargs)
infix fun Int.multiply(x : Int) = x * this


fun main() {

    // É possível nomear os argumentos passados e mudar a ordem ou deixar um arg com valor padrão
    // Não funciona quando chamando código Java
    funWithManyArgs(b = 25, c = 30, a = "")

    // Destructuring é suportado com varargs
    val stringArray = arrayOf("a", "b", "d")
    funWithVarArgs(*stringArray)

    // Single-expression functions
    val singleExprFun = fun (value : String) = println(value.uppercase())
    singleExprFun("Lorem Ipsum")

    // Infix notation
    // equivalente a 2.multiply(2 * 2)
    println(2 multiply 2 * 2)

    // Funções podem ser colocadas dentro de funções (Local function)
    val localFunctionVar = 10
    fun localFunction(x : Int) : Int {
        // Pode acessar variáveis de função outer (closure)
        return x * localFunctionVar
    }
    println(localFunction(10))


    // Tailrec permite usar recursão onde seriam usados loops para melhorar legibilidade
    // Quando a função é marcada como tailrec e segue os critérios ela será convertida em um loop
    // Isso elimina o risco de StackOverflow e problemas comuns de recursão
    // Para ser elegível a função deve fazer a chamada recursiva como ultima instrução
    tailrec fun findHighestEven(x : Double = 22.0) : Double {
        return if (x % 2.0 == 0.0 || x < 0) x else findHighestEven(x / 2)
    }
    println(findHighestEven())


}