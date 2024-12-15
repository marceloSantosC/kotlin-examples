package _1Intro

fun main() {
    val array = arrayOf(1, 2, 3, 4, 5, 6)

    // return dentro de uma nested function vai retornar para quem chamou main e não para quem chamou forEach (main)
    array.forEach {
        if (it == 0) {
            return // vai parar a execução da função
        }
    }

    // return em função anônima retorna para quem chamou a função
    array.forEach(fun (it: Int) {
        if (it == 1) {
            return
        }
    })

    // implicit label e return
    array.forEach {
        if (it == 2) {
            return@forEach // nesse caso vai retornar para forEach para o elemento atual, é o mesmo que usar continue
        }
    }
    // Também funciona
    array.forEach customLabel@ {
        if (it == 1) {
            return@customLabel
        }
    }


    println("Executou!")
}