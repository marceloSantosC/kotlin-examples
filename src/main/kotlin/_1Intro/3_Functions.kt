package _1Intro


// args é opcional e main serve como entrypoint assim como Java
// fun é usado para declarar uma função, não é necessário usar uma classe aqui
// parâmetros de função seguem o padrão <nome>: <tipo>
// Funções no mesmo arquivo não podem ter a mesma assinatura
fun main(args: Array<String>) {

    println(args) // ; é opcional

    println("Digite algum input: ");
    val input = readln(); // Equivale a inicializar um scanner e usar sc.next() e retorna string
    println(input);


    println(sum());
    println(sumFunExpression(10, 10));
    println(sumVoid(10, 10));

    varArgsFun();
    earlyReturn();

}


// Função com tipo de retorno definido e valor default
fun sum(a: Int = 10, b: Int = 10): Int {
    return a + b;
}

// Função void (Unit pode ser omitido)
fun sumVoid(a: Int, b: Int): Unit {
    println("${a + b}");
}

// Corpo da função pode ser uma expressão, similar a lambda expression
// O tipo retornado é inferido
fun sumFunExpression(a: Int, b: Int) = a + b

// ints é um array
fun varArgsFun(vararg ints: Int) {
    println(ints.contentToString());
}

// early return é suportado
fun  earlyReturn(a: Int = 1) {
    if (a == 0) {
        return;
    }
}