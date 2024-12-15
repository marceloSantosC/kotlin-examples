package _2Object_Oriented

// Visibility modifiers são: private, protected, internal, and public
// public é o padrão para todos que não declaram um modifier

/*
        Em top level declaration private indica que só é visível no arquivo e public visível em qualquer arquivo
        internal indica que só é visível para arquivos no mesmo módulo (módulo maven/intellij) e protected não é suportado
 */

private val privateVal = 10 // Só visível nesse arquivo
public val publicVal = 10 // Visível para todos (padrão)
internal val internalVal = 10 // Visível para todos arquivos no mesmo módulo


private class PrivateClass {

    /*
            Membros de classes podem ser public, private, internal ou protected, public indica que qualquer um que tenha
            acesso à classe tem acesso àquele membro, private indica que só a classe tem acesso ao membro, internal
            indica que qualquer membro no módulo que tenha visibilidade da classe tem acesso ao membro e protected
            indica que só a classe e as subclasses têm acesso ao membro
     */


    private val privateVal = 10 // Só visível nessa classe
    public val publicVal = 10 // Visível para todos quem tem acesso à classe
    internal val internalVal = 10 // Visível para todos que tem acesso à classe e ao módulo
    protected val protectedVal = 10 // Visível para essa classe e classes que herdam dela

    // Uma classe externa não pode acessar membros private de uma inner class
    class InnerClass {

        // Não é acessível a partir de PrivateClass
        private val privateInnerProperty = 20

    }



}

