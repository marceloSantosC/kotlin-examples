package _2Object_Oriented

import java.io.File

// Type alias permitem dar apelidos a tipos existentes
// Não afetam os tipos existentes ou introduzem tipos novos, é só um apelido que será convertido para o nome real pelo compilador
// A diferença entre inline classes e type alias é que inline classes introduzem um tipo novo, enquanto type alias não
typealias FileList = MutableMap<String, File>
typealias PersonName = String
typealias Predicate<T> = (T) -> Boolean

fun main() {

    val fileList : FileList = mutableMapOf(Pair("A", File("")), Pair("B", File("")))
    val personName : PersonName = "Jhon Doe"
    val predicate : Predicate<String> = { it.isNotEmpty() }

    println(fileList)
    println(personName)
    println(predicate)


}