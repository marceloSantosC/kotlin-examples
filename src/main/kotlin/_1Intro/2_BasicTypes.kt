package _1Intro

fun main() {

    // São todos objetos, embora existam tipos primitivos igual no java eles não são acessíveis
    // O comportamento é o mesmo de Java
    // Type inference vai usar o menor tipo possível para representar um valor quando ele é declarado sem tipo
    // Conversão de um tipo menor para um maior é explícita. Pode ser feita por meio dos métodos toType() ex: toInt()
    // Operadores são os mesmos do Java +, -, *, /, %, ||, && e !

    // Any, equivalente a Object, todos tipos herdam de Any
    val anyType:Any = "Test";
    println(anyType);

    // signed integers: Byte, Short, Int, Long
    val integers:Int = 234;
    val bytes:Byte = 127;
    val shorts:Short = 2;
    val longs:Long = 12L;
    println("$bytes - $integers - $shorts - $longs");

    // unsigned integers: UByte, UShort, UInt, ULong
    val uIntegers:UInt = 234u;
    val uBytes:UByte = 127u;
    val uShorts:UShort = 2u;
    val uLongs:ULong = 12uL;
    println("$uIntegers - $uBytes - $uShorts - $uLongs");

    // Float, Double
    val floats:Float = 234.2F;
    val doubles:Double = 234.2;
    println("$floats - $doubles");

    // Char, String (string segue sendo imutável)
    // Multi-line string é suportado com """ e String.format existe
    val chars:Char = 'A';
    val strings:String = "Test";
    println("$chars - $strings");


    // Null
    val nulls:Any? = null; // Apenas tipos <tipo>? são null-able, Any causaria erro
    println(nulls);

    // Array, similar a Java, diferente de collections == não compara os elementos
    // Acessado da mesma forma que em Java, com []
    // Existem variações BooleanArray, ByteArray, CharArray, DoubleArray, etc
    val arrays:Array<Int> = arrayOf(1, 2, 3, 4);
    val arrayOfNulls:Array<Int?> = arrayOfNulls(3);
    val emptyArray:Array<Int> = emptyArray();
    val arraysNew:Array<Int> = Array(3) { 0 } // 3 é o tamanho e 0 o valor dos elementos
    val nestedArray:Array<Array<Int>> = Array(3) { Array(3) { 0 } }

    println(arrays.contentEquals(emptyArray)); // == compara a referência
    arrays[0] = 10; // acesso
    arrays.sum() // somar os valores
    arrays.shuffle()
    arrays.toList()

    println("${arrays.contentToString()} - ${arrayOfNulls.contentToString()} - ${emptyArray.contentToString()}" +
            " - ${arraysNew.contentToString()} - ${nestedArray.contentDeepToString()}");

    // NaN e Infinity
    val nans = Double.NaN;
    val infinityN = Double.NEGATIVE_INFINITY;
    val infinityP = Double.POSITIVE_INFINITY;
    println("$nans - $infinityN - $infinityP");

    // Explicit Cast
    val myInt:Int = 10;
    // myInt = 10L; Não faz casting automático
    val myLong:Long = myInt.toLong();
    val myLong2: Any = myInt as Any; // Também funciona
    println("$myLong - $myLong2");

    // Smart Cast, cast automático
    val myAny:Any = 1;
    if (myAny is Int) {
        println(myInt); // MyAny convertido para int automaticamente
    }

    // Type check
    val myString:Any = "Lorem Ipsum";
    val isString = myString is String;
    val isNotString = myString !is String;
    println("$isString - $isNotString");

}