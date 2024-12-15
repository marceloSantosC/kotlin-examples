package _2Object_Oriented


// São como interfaces Java, mas podem ter fields
// Os fields não guardam estado, é necessário que eles sejam abstracts ou prover accessors
// Fields declarados em interfaces não podem ter um backing-field
interface Processor {

    val result: Any

    fun process(value: Any)

    fun retrieveResult(): Any

}

class StringProcessor: Processor {

    override var result = "";

    override fun process(value: Any) {
        result = if (value is String) {
            "Result: $value"
        } else {
            "Not processed"
        }

    }

    override fun retrieveResult(): String {
        return result
    }
}

// Herança entre interfaces suportada
// Classes que implementam a interface só precisarão sobrescrever métodos sem implementações
interface SuperInterface {
    fun fullName(): String
    fun firstName(): String
}

interface SubInterface: SuperInterface {

    val firstName: String
    val lastName: String

    // Sobrescrevendo método da interface dentro da outra
    override fun firstName(): String {
        return firstName.uppercase()
    }

    override fun fullName(): String {
        return firstName + lastName
    }

    // Métodos default são suportados
    fun lastName(): String {
        return lastName.uppercase()
    }

}

class InterfaceImpl(override val firstName: String, override val lastName: String): SubInterface



fun main() {

    val stringProcessor = StringProcessor()
    stringProcessor.process("Test")
    println(stringProcessor.retrieveResult())

    val interfaceImpl = InterfaceImpl("Jhon", "Doe")
    println(interfaceImpl.fullName())
    println(interfaceImpl.firstName())
    println(interfaceImpl.lastName())

}