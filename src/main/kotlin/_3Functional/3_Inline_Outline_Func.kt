package _3Functional

// O custo de high-order functions é que cada função é um objeto que captura o closure, o que pode usar mais memória
// Quando uma high-order function é declarada é necessário alocar memória para o objeto singleton que guarda os dados da função
// Quando a função usa uma variável do closure é necessário criar um objeto de function para cada invocação da função
// Quando a função usa generics seu tipo é apagado devido ao Type erasure

// Inline functions resolvem esse problema,
// Quando se declara uma function como inline o compilador substituíra a lambda por uma função equivalente com body
// Essa função equivalente não precisa alocar memória para o objeto e nem faz uma chamada extra como ocorre em funções normais
// Todas funções recebidas como param são inline
private inline fun <T> Collection<T>.each(block: (T) -> Unit) {
    for (e in this) block(e)
}

// noinline faz com que a função recebida como param não seja inline, apenas a função myFun
private inline fun myFun(noinline func : () -> Unit, noinline func2 : () -> Unit) {
    func()
    func2()
}

// reified types permitem fazer type check em generics durante tempo de compilação
private inline fun <reified T>  checkType(value : T) {
    when (value) {
        is String -> println("Valor é string")
        is Int -> println("Valor é int")
        else -> println("Valor é outro tipo")
    }
}


private fun main() {

    val numbers = listOf(1, 2, 3, 4, 5)

    // Each é inline, o código será escrito assim
    numbers.each { println(it) }
    // O compilador converterá esse código para algo como isso
    // Não há closure nem objeto criado para essa chamada, é apenas código normal, isso ocorrerá em todos os locais
    // Quando a função é muito longa o código gerado poderá crescer muito
    // A função lambda também foi transformada em inline
    for (number : Int in numbers) println(number)

    // myFun é inline, seu primeiro argumento não é inline, mas o segundo sim
    myFun({ println("No inline") }, { println("Inline") })

    // Inlined lambda suporta usar return para retornar para o caller
    numbers.each {
        if (it % 2 == 0) {
            println("$it é par")
            return
        }
        println("$it não é par")
    }

    checkType(1)

}