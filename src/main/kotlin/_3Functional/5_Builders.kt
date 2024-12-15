package _3Functional


// Builder custom
// apply: configura um objeto e retorna o próprio objeto
// with: retorna o resultado da última expressão no bloco
data class Car(
    val make: String,
    val model: String,
    val year: Int,
    val color: String
) {
    class Builder {
        private var make: String = ""
        private var model: String = ""
        private var year: Int = 0
        private var color: String = ""

        fun make(make: String) = apply { this.make = make }
        fun model(model: String) = apply { this.model = model }
        fun year(year: Int) = apply { this.year = year }
        fun color(color: String) = apply { this.color = color }
        fun build() = Car(make, model, year, color)
    }
}

// Builder
class Person {
    var name: String = ""
    var age: Int = 0
}

// Build com lambda
class Address {
    var street: String = ""
    var city: String = ""
    var zipCode: String = ""
}
class Employee {
    var name: String = ""
    var age: Int = 0
    var manager = false
    private var address: Address = Address()

    fun address(block: Address.() -> Unit) {
        address.apply(block)
    }
}
fun employee(block: Employee.() -> Unit): Employee = Employee().apply(block)

fun main() {

    // Builder custom, similar a Java
    val car = Car.Builder()
        .make("Toyota")
        .model("Corolla")
        .year(2023)
        .color("Blue")
        .build()

    // Builder com with
    val person = Person()
    with(person) {
        this.name = "Joana"
        this.age = 25
    }


    // Builder com apply
    val person2 = Person().apply {
        name = "John"
        age = 30
    }


    // Builder com lambda
    val employee = employee {
        name = "Jhon"
        age = 25
        manager = true
        address {
            street = "Test"
            city = "Test"
            zipCode = "Test"
        }
    }

    // buildString (StringBuilder)
    val stringBuilder = buildString {
        append("Hello")
        append("World")
    }

    // buildList, buildSet e buildMap
    val mapBuilder = buildMap<String, String> {
        put("Key", "Value")
        put("Key2", "Value2")
    }

    println(car)
    println(person)
    println(person2)
    println(employee)
    println(stringBuilder)
    println(mapBuilder)
}