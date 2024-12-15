package _2Object_Oriented

// Inline value classes permitem fazer o boxing de um tipo primitivo em uma classe sem grandes impactos no desempenho
/*
    Normalmente boxing de primitivos é relativamente custoso pela necessidade de alocar o objeto no heap e por wrappers
    não serem otimizados pela JVM como ocorre com tipos primitivos
 */
// A anotação @JvmInline é necessária para informar a JVM que essa é uma value class
// O uso mais comum é para prover mais clareza ao código ao dar um nome significativo a um tipo
// Esse tipo de classe só possui um field, em runtime ela é tratada como se fosse do tipo do field
// Suporta métodos, atributos, init e construtores secundários, não suporta backing fields ou lateinit
// É possível implementar interfaces, mas não herdar de classes
@JvmInline
private value class Password(private val value : String) {

    init {
        require(value.isNotEmpty()) { "Password should not be blank" }
    }

    constructor(value: ByteArray) : this(value.contentToString())

    val length: Int
        get() = value.length

    fun compare(other : Password) : Boolean = value == other.value

    override fun toString(): String {
        return "*******"
    }

}

fun main() {

    // Não ocorre instanciação, Password é tratado como se fosse uma string
    val password = Password("TestPassword")
    println(password)
    val other = Password("TestPassword2".toByteArray())
    println(password.compare(other))
    require(password.length > 2)
}