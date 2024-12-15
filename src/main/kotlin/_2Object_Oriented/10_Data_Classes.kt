package _2Object_Oriented

import java.time.LocalDate


// Data classes são equivalentes a records de Java structs em C#, 1porém não são obrigatóriamente imutáveis
// O compilador gera equals/hashCode, toString, componentN() functions e copy() baseado nos params do construtor primário
// A classe não pode ser abstract, open, sealed ou inner
// É possível fornecer implementações de equals, hashCode e toString
private data class UserData(val name: String, val age: Int, var mother: String) {

    // Field será ignorado nos métodos gerados pelo compilador (equals/hashCode, toString, etc)
    val memberSince: LocalDate = LocalDate.now()

}


fun main() {


    val user = UserData("Jhon Doe", 25, "Joana Doe")

    println("$user, member since ${user.memberSince}") // formato Classe(field=Value, field=Value)


    // Copy faz uma shallow copy do objeto
    val userCopy = user.copy()
    userCopy.mother = "Joane Dao"
    println("$userCopy, $user")


    // componentN permite fazer destructuring no objeto, similar a JS
    val (name, age) = user
    println("name: $name, age: $age")


    // Pair e Triple são data classes que podem ser usadas para representar tuplas
    val pair: Pair<Int, String> = Pair(1, "A")
    val triple: Triple<Int, String, String> = Triple(1, "A", "B")
    println("$pair, $triple")



}