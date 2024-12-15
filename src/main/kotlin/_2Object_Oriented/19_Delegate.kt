package _2Object_Oriented

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

// Delegate properties são fields sem backing field que delegam getters/setters para outras partes do código
// Isso permite compartilhar e abstrair a lógica de getter/setter e compartilhá-la entre fields similares
// Um delegate é uma classe responsável por fazer o getter/setter da property
// Implementar ReadWriteProperty/ReadOnlyProperty não é obrigatório, a classe só precisa ter os métodos com a assinatura correta
private class Delegate : ReadWriteProperty<ClassWithDelegateProperty, String> {

    // Usado como backing field, não é obrigatório
    private var storedValue = ""

    // Essas são as implementações de getter/setter
    // Quando a property for atualizada/lida essas implementações serão chamadas
    // argumento thisRef é uma referência para a classe que armazena a property
    // argumento property é uma referência para a classe de reflection que descreve a property (equivalente a Field de java)
    override operator fun getValue(thisRef: ClassWithDelegateProperty, property: KProperty<*>): String {
        println("${property.name} is const? ${property.isConst}, is lateinit? ${property.isLateinit}")
        return storedValue.lowercase()
    }

    // value é o valor sendo setado
    // Acessar a property (thisRef.name) vai causar recursão
    override operator fun setValue(thisRef: ClassWithDelegateProperty, property: KProperty<*>, value: String) {
        storedValue = value.uppercase()
    }

}

private class ClassWithDelegateProperty() {

    // Vai delegar Getter/Setter para a classe Delegate, não existe backing property
    var name : String by Delegate()
}

fun main() {

    val classWithDelegate = ClassWithDelegateProperty()

    // vai chamar Delegate.setValue
    classWithDelegate.name = "Lorem"

    // vai chamar Delegate.getValue
    println(classWithDelegate.name)



}