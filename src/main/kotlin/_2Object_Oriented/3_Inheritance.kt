package _2Object_Oriented

// Todas as classes herdam de Any que possui os métodos equals, hashCode e toString (Object de Java)
// Todas as classes são "final" por padrão, para permitir herança deve ser usado open
// Classes abstract e interfaces são "open" por padrão
open class BaseClass(val value : Int) {

    // métodos também são "final" por padrão
    // Se a classe não for open tornar um a função open não fará nada
    open fun calculateValue(): Int {
        return value * 2
    }

}

// Subclasses devem chamar o construtor primário de superclasses (se existir)
// O construtor da superclasse é chamado antes do da subclasse
class DerivedClassOne(value: Int): BaseClass(value) {

    override fun calculateValue(): Int {
        return value * 3
    }

    // Super funciona da mesma forma que em Java
    fun superClassCalculateValue(): Int {
        return super.calculateValue()
    }
}


// Superclasse sem construtor primário
open class BaseClassNoPrimaryConstructor {

    var value: Int = 0

    constructor(value: Int) {
        this.value = value
    }

}

// Herança sem construtor primário, usa-se super para chamar o construtor secundário
class DerivedClassTwo : BaseClassNoPrimaryConstructor {

    var valueTwo: Int = 0

    constructor(value: Int) : super(value)

    constructor(value: Int, valueTwo: Int) : super(value) {
        this.valueTwo = valueTwo
    }

}


// Sobrescrevendo field
open class BaseClassWithValue {

    // Também é final por padrão
    open val defaultValue = 10
}

class DerivedClassThree: BaseClassWithValue() {

    // Sobrescreve o field, poderia transformar o field em var (não funciona de var para val)
    override val defaultValue: Int = 25
}

// Direto no construtor primário
class DerivedClassThreeV2 (override val defaultValue: Int) : BaseClassWithValue()


fun main() {
    val one = DerivedClassOne(10)
    val two = DerivedClassTwo(10)
    val twoSecond = DerivedClassTwo(10, 20)
    val three = DerivedClassThree()
    val threeV2 = DerivedClassThreeV2(55)

    println("""
        1 - ${one.value}, ${one.calculateValue()} , ${one.superClassCalculateValue()}
        2 - ${two.value}, ${two.valueTwo}
        2.1 - ${twoSecond.value}, ${twoSecond.value}
        3 - ${three.defaultValue}
        3V2 - ${threeV2.defaultValue}
        """)
}