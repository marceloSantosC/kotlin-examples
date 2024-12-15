package _4Important_Concepts

import kotlin.reflect.full.findAnnotation

// Mesma coisa de Java, porém tem alguns tipos extras como File e Expressions (incluindo lambda)
@Target(AnnotationTarget.CLASS)
// Se a annotation estará na classe compilada e se é visível via reflection durante o runtime (padrão true para ambos)
@Retention(AnnotationRetention.RUNTIME)
// Se pode ser usada várias vezes no mesmo elemento
@Repeatable
// Se deve ser incluída na documentação gerada para um elemento
@MustBeDocumented
private annotation class CustomAnnotation(val value : String)

@CustomAnnotation("MyAnnotatedClass")
// Anotações de java são suportadas, mas não necessariamente vão fazer algo
@FunctionalInterface
private fun interface MyAnnotatedInterface {
    fun get()
}

fun main() {

    // Reflection é similar a Java, mas usa :: em vez de getField, getClass, etc
    // Reflection não faz parte da lib padrão e deve ser incluído como dependência
    val annotation = MyAnnotatedInterface::class.findAnnotation<CustomAnnotation>()
    println("Annotation ${annotation?.annotationClass?.simpleName} encontrada com o valor ${annotation?.value}")


}