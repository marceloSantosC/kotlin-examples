

// Packages servem o mesmo propósito de packages Java
// O diretório dos arquivos não precisa ser o mesmo do package declarado, embora seja uma boa prática
// Todos os conteúdos do arquivo atual serão disponibilizados nesse package
// Se o package não é específicado será usado o default package que não tem nome
package _1Intro

// Ainda é necessário fazer os imports, mesmo que no mesmo package (separação é por arquivo)
// Alguns imports são feitos por padrão, por isso println não precisa de import (kotlin.io.println())
// org.example.* pode ser usado para dar import em tudo que tem em um package, independente de arquivos

// Alias é suportado e é possível importar top level variable
// Também possível importar top level functions, functions e objetos declarados em object declarations e constantes de enum
import _1Intro.topLevelVariable as topLevelVar

// é private e não pode ser importado
private val privateVal = 20;
private fun privateFun() {
    println("Private function")
}


fun main() {
    println(sum(10, 20))
    println(sum(topLevelVar, privateVal))
    privateFun()

    // full name também é suportado
    sumVoid(20, 30)

}

