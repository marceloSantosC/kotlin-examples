package _4Important_Concepts

import kotlin.concurrent.thread
import kotlin.coroutines.Continuation
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.coroutines.createCoroutine
import kotlin.coroutines.resume

fun main() {

    // Existem várias formas de lidar com async em Kotlin

    // Kotlin vem com a função thread() para criar threads manualmente
    /*
        Threads não são baratas, é necessário fazer troca de contexto, o que é caro, elas também possuem uma quantidade
        limite (SO) e podem aumentar complexidade/são difíceis de debugar (race conditions)
     */
    val threadFunction = {
        Thread.sleep(500)
        println("Thread finished")
    }
    thread(start = true, isDaemon = false, name = "Thread Example", priority = 0, block = threadFunction)


    // Callbacks são suportadas uma vez que funções são high-order, porém pode ocorrer o mesmo problema de JS (callback-hell)
    // Além de callback hell tratamento de erros é mais complexo, pois é necessário propagar os erros na stack
    val callback = {
        it: Int -> println("Thread finished. Result: $it")
    }
    thread {
        Thread.sleep(500)
        callback(1)
    }

    // Embora kotlin não suporte Promises por padrão elas podem ser implementadas facilmente
    // Promises tem problemas similares a callbacks onde tratamento de erros pode ser complexo e pode ocorrer promise hell
    // Também é necessário aprender a API de promises e a assinatura de funções precisa ser alterada para retornar uma Promise


    /*
        Coroutines é a solução de Kotlin para async, ela é baseada na ideia de computações que podem ser pausadas, ou seja,
        a ideia de que a execução de uma função pausada e depois resumida de onde ela parou. É similar a async em C# uma vez que
        o código async parece sync. Não é um conceito novo, GO também possui coroutines
     */
    // Funções que podem ser interrompidas são chamadas de suspendable functions
    // Essa implementação é apenas para exemplo, código real usa a lib oficial de coroutines em vez disso
    val suspendableFunction : suspend () -> String = suspend {
        println("Coroutine iniciada")
        Thread.sleep(1000)
        "Execução acabou"
    }

    val continuation = suspendableFunction.createCoroutine(Continuation(EmptyCoroutineContext) { result : Result<String> ->
        println("Executando código após a pausa, resultado: ${result.getOrNull()}")
    })

    continuation.resume(Unit)

}