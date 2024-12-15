package _2Object_Oriented

// Extensions permitem adicionar funcionalidades a classes sem usar heranças ou design patterns como Decorator
// É similar a prototype de JS e também funciona com fields

// Extension Function
// Só funciona para MutableList<Int>
// Não modifica a instância de fato, apenas permite chamar funções static a partir da classe
// Uma extension deve ser importada se ela foi declarada em outro package
fun MutableList<Int>.swap(index1: Int, index2: Int) {

    // this = aponta para o objeto que a função vai ser adicionada, MutableList<Int> nesse caso
    val index1OriginalValue = this[index1]
    this[index1] = this[index2]
    this[index2] = index1OriginalValue
}

// Vai funcionar para todos os tipos
fun <T> MutableList<T>.swapGeneric(index1: Int, index2: Int) {
    val tmp = this[index1] // this aponta para a lista
    this[index1] = this[index2]
    this[index2] = tmp
}


// Se a classe possui um metodo com a mesma assinatura da extension function o metodo da instância será chamado
fun <T> MutableList<T>.add(index: Int, element: T) {
    println("Não será executado")
}


// Extension Property
// Uma extension property não possui um backing field e por isso não é possível usar ela em initializer
// Acesso/Escrita é feito por getter e setter
var <T> List<T>.lastIndex: Int
    get() = size - 1
    set(value) { lastIndex = value }

fun main() {

    val list: MutableList<Int> = mutableListOf(0, 1, 2, 3, 4, 5)
    val listString: MutableList<String> = mutableListOf("A", "B", "C")

    // Swap/swapGeneric é chamado como se fosse parte da lista
    list.swap(0, 1)
    println(list.toString())
    listString.swapGeneric(0, 1)
    println(listString.toString())

    // O metodo add de MutableList e não o extension method
    list.add(5, 20)

    // Acessando extension property
    println(list.lastIndex)
    list.lastIndex = 20


}