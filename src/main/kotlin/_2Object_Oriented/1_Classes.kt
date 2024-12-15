package _2Object_Oriented


// Uma classe só pode ser declarada uma vez em um pacote, mesmo que em outro arquivo
// Declaração mais básica, será criado um construtor padrão vazio
// Se a classe não tem nada os {} podem ser omitidos
class PersonV0

// construtor primário, é um construtor usado para inicializar valores do objeto (não obrigatório)
// construtor possui modificador de acesso e pode ser anotado
class PersonV1 public constructor(firstName: String, age: Int)

// a palavra constructor pode ser omitido quando não há anotação ou modificador de acesso no construtor (metodo não args)
// Os parâmetros de construtor são acessíveis em init e em fields
class PersonV2 (firstName: String, age: Int) {

    // Acessando firstName do field
    val upperCaseFirstName = firstName.uppercase()

    // initializer blocks são blocos usados para executar código durante a criação de objetos
    // blocos init são como o corpo de um construtor
    init {
        // Acessando o constructor arg age
        println("Person created with name $upperCaseFirstName and age $age")
    }
}

// val/var é uma forma simples de declarar e inicializar fields com os parâmetros do construtor
// fields declarados assim são public por padrão e suportam valores padrão
class PersonV3 (val firstName: String, private val age: Int = 25) {

    fun getAge(): Int {
        return age
    }
}


class PersonV4 (val firstName: String, val age: Int = 25) {

    val children: MutableList<PersonV4> = mutableListOf()

    // Secondary constructor
    // Precisa chamar o construtor primário sempre e possui corpo
    // Não suporta usar val para inicializar objetos facilmente
    // Blocos init/o construtor primário são executados antes do secundário
    constructor(firstName: String, age: Int, child: PersonV4) : this(firstName, age) {
        this.children.add(child)
    }
}


// Classe completa
class Person (val firstName: String, val age: Int = 25) {

    val children: MutableList<Person> = mutableListOf()

    constructor(firstName: String, age: Int, child: Person? = null) : this(firstName, age) {
        if (child != null) {
            this.children.add(child)
        }
    }

    init {
        println("Pessoa $firstName criada")
    }

    fun addChild(child: Person) {
        this.children.add(child)
    }

}

fun main() {

    // Criação de objetos é o mesmo de Java, porém não existe new
    val personV0 = PersonV0()
    val personV1 = PersonV1("Noa", 25)
    val personV2 = PersonV2("Noa", 23)
    val personV3 = PersonV3("Noa")
    val personV4 = PersonV4("Noa", 32, PersonV4("Joana", 3))
    val person = Person("Noa", 40, Person("Joana", 11))
    person.addChild(Person("Julia", 2))



    println(personV0)
    println(personV1.toString())
    println(personV2.upperCaseFirstName)
    println("Age = ${personV3.getAge()}, Name = ${personV3.firstName}")
    println("Name = ${personV4.firstName}, Age = ${personV4.age}, children = ${personV4.children.joinToString { child -> child.firstName }}")
    println("Name = ${person.firstName}, Age = ${person.age}, children = ${person.children.joinToString { child -> child.firstName }}")

}