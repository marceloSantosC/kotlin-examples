package _4Important_Concepts

private data class Id(val value : Int)

fun main() {

    val id = Id(1)
    val id1 = Id(1)

    // Structural equality (==) verifica se dois objetos são iguais em conteúdo ou estrutura
    // Equivale a chamar id.equals(id1), também vale para string
    // Isso é traduzido para id?.equals(id1) ?: (id1 === null)
    // Equals usa referencial equality por padrão (herdado de Any)
    // Value/Data classes e classes que representam primitivos sobrescrevem equals
    println(id == id1)

    // Referential equality (===), compara o endereço de memória de dois objetos para verificar se são iguais
    val idRef = id
    println(idRef === id)


    // Collections são comparados com contentEquals, == usa a referência
    val array1 = arrayOf(2, 3, 4)
    val array2 = arrayOf(2, 3, 5)
    println(array1.contentEquals(array2))



}