package _2Object_Oriented

import java.time.LocalDateTime

class Car(name: String, year: Int) {

    // Declarando getter e setter
    // Se o field for private os getters/setters também serão
    // Todos fields tem um valor por trás (backing field), esse valor só pode ser acessado em um getter/setter por meio da palavra field
    // Todos fields possuem um get/set padrão que só retorna/seta o valor as is
    var speed: Double = 0.0
        get() {
            return field * 3.6
        }
        set(value) {
            lastUpdate = LocalDateTime.now()
            field += value
        }

    // tornar o set privado faz com que esse field não possa ser modificado por classes externas, só lido
    var lastUpdate: LocalDateTime = LocalDateTime.now()
        private set

    // val não tem set
    private val name: String = name
        private get() = field.uppercase()

    private val year: Int = year
        private get // implementação padrão do get

    override fun toString(): String {
        return "Model = $name, Year = $year"
    }



}

fun main() {
    val car = Car("Mazda RX7", 2008)

    // Propriedades sendo acessadas pelo getter/setter
    car.speed = 50.0
    car.speed = 25.0

    println("$car - ${car.speed} KM, last update: ${car.lastUpdate}")

}