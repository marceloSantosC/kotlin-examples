package _2Object_Oriented

// const é equivalente e public static final, mas fora de uma classe, pode ser importado diretamente
// Deve ser um tipo primitivo ou String
const val PI = 3.14

class ClassWithFields {

    // Permite inicializar um valor depois que a classe atual foi instanciada
    // Só funciona tipos não primitivos e non-nullable, com var declarado dentro da classe e num field sem getter/setter custom
    // Acessar um field lateinit antes da inicialização lança uma exception
    lateinit var value: Array<Int>

    // isInitialized só funciona dentro do objeto ou subtipos
    fun initializeValue() {
        if (!this::value.isInitialized) {
            value = arrayOf(0,0,0,0,0)
        }
    }

}

fun main() {
    val obj = ClassWithFields()
    obj.initializeValue()

}