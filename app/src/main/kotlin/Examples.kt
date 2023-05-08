import java.lang.Exception
import java.lang.NullPointerException

const val PI = 3.1416

fun main(args: Array<String>) {
    // example 11 y 12
    val fraseAleatoria = "En Platzi nunca paramos de aprender".randomCase()
    imprimirFrase(fraseAleatoria)

    // example 13
    imprimirNombre(nombre = "Herian", apellido = "Palencia")

    // example 15
    val largoDelValorInicial = superFuncion(valorInicial = "Hola!") { valor -> valor.length }
    println(largoDelValorInicial)

    val lambda = funcionInception(nombre = "Herian")
    val valorLambda = lambda()
    println(valorLambda)

    example20()
}

// example 1:  if
fun example1() {
    val nombre = "Maria"
    if (nombre.isNotEmpty()) println("El largo de nombe es ${nombre.length}")
    else println("Error, la variable esta vacía")

    val mensaje : String = if (nombre.length > 4) "Tu nombre es largo!"
    else if (nombre.isEmpty()) "Nombre esta vacío"
    else "Tienes un nombre corto"
    println(mensaje)
}

// example 2:  when - when in
fun example2() {
    val nombreColor = "Amarillo"
    when (nombreColor) {
        "Amarillo" -> {
            print("Color Amarillo pues")
            println(" PEPE!!")
        }
        "Rojo", "Carmesi" -> println("Color Rojo pepe")
        else -> println("Error no hay información")
    }

    val code = 200
    when (code) {
        in 200..299 -> println("Todo ha ido bien")
        in 400..500 -> println("Algo ha fallado")
        else -> println("Código desconocido, algo ha fallado")
    }

    val tallaDeZapatos = 41
    val mensaje = when (tallaDeZapatos) {
        41, 21 -> "Tenemos disponibles"
        42, 44 -> "Casi no nos quedan!"
        45 -> "Lo siento no tenemos disponibles"
        else -> "Estos zapatos solo vienen en tallas 41, 42, 43, 44 y 45"
    }
    println(mensaje)
}

// example 3:  while - do while
fun example3() {
    var contador = 10
    while (contador > 0) {
        println("El valor de contador es $contador")
        contador--
    }

    do {
        println("Generando numero aleatorio...")
        val numeroAleatorio = (0..100).random()
        println("El numero generado es $numeroAleatorio")
    } while (numeroAleatorio > 50)
}

// example 4:  for - map - filter
fun example4() {
    val listaDeFrutas: List<String> = listOf("Manzana", "Pera", "Frambuesa", "Durazno")
    for (fruta in listaDeFrutas) println("Hoy voy a comerme una fruta llamada $fruta")

    listaDeFrutas.forEach { fruta -> println("Hoy voy a comerme una fruta nueva llamada $fruta") }

    val caracteresDeFruta: List<Int> = listaDeFrutas.map { fruta -> fruta.length }
    println(caracteresDeFruta)

    val listaFiltrada = caracteresDeFruta.filter { largodeFrutas -> largodeFrutas > 5 }
    println(listaFiltrada)
}

// example 5:  try catch
fun example5() {
    var nombre : String? = null
    try {
        throw NullPointerException("Referencia nula")
    } catch (excepcion : NullPointerException) {
        println("ha ocurrido un error")
    } finally {
        println("ha ocurrido un error... cerrando aplicacion")
    }


    val primerValor = 0
    val segundoValor = 0
    val resultado : Int = try { primerValor / segundoValor } catch (exception : Exception) { 0 }
    println(resultado)
}

// example 6:  elvis operator
fun example6() {
    var nombre : String? = null
    var caracteresDeNombre : Int = nombre?.length ?: 0
    println(caracteresDeNombre)
}

// example 7:  Lists
fun example7() {
    val listaDeNombres = listOf("Juan", "Enrique", "Camila")
    println(listaDeNombres)

    val listaVacia = mutableListOf<String>()
    listaVacia.add("Juan")
    println(listaVacia)

    val valorUsandoget = listaVacia.get(0)
    println(valorUsandoget)

    val valorUsandoOperador = listaVacia[0]
    println(valorUsandoOperador)

    val primerValor = listaDeNombres.firstOrNull()
    println(primerValor)

    listaVacia.removeAt(0)
    println(listaVacia)

    listaVacia.add("Enrique")
    listaVacia.removeIf { caracteres -> caracteres.length > 4 }
    println(listaVacia)

    val myArray = arrayOf(1, 2, 3, 4)
    println("Nuestro array $myArray")
    println("Array como list ${myArray.toList()}")
}

// example 8:  ordenar listas - metodos
fun example8() {
    val numerosDeLoteria = listOf(11, 22, 43, 56, 78, 66)

    val numerosSorted = numerosDeLoteria.sorted()
    println(numerosSorted)

    val numerosDeLoteriaDescendientes = numerosDeLoteria.sortedDescending()
    println(numerosDeLoteriaDescendientes)

    val ordenarPorMultiplos = numerosDeLoteria.sortedBy { numero -> numero < 50 }
    println(ordenarPorMultiplos)

    val numerosAleatorios = numerosDeLoteria.shuffled()
    println(numerosAleatorios)

    val numeroEnReversa = numerosDeLoteria.reversed()
    println(numeroEnReversa)


    val mensajesdeNumeros = numerosDeLoteria.map { numero -> "Tu numero de loteria es $numero" }
    println(mensajesdeNumeros)

    val numerosFiltrados = numerosDeLoteria.filter { numero -> numero > 50 }
    println(numerosFiltrados)
}

// example 9:  Maps
fun example9() {
    val edadDeSuperHeroes = mapOf(
        "Ironman" to 35,
        "Spiderman" to 23,
        "Capitan America" to 99,
    )
    println(edadDeSuperHeroes)

    val edadDeSuperHeroesMutable = mutableMapOf(
        "Ironman" to 35,
        "Spiderman" to 23,
        "Capitan America" to 99,
    )
    println(edadDeSuperHeroesMutable)

    edadDeSuperHeroesMutable.put("Wolverine", 45)
    println(edadDeSuperHeroesMutable)

    edadDeSuperHeroesMutable["Storm"] = 30
    println(edadDeSuperHeroesMutable)

    val edadIronman = edadDeSuperHeroesMutable["Ironman"]
    println(edadIronman)

    edadDeSuperHeroesMutable.remove("Wolverine")
    println(edadDeSuperHeroesMutable)

    println(edadDeSuperHeroesMutable.keys)
    println(edadDeSuperHeroesMutable.values)
    println(edadDeSuperHeroesMutable.entries)
}

// example 10:  Sets
fun example10() {
    val vocalesRepetidas = setOf("a", "e", "i", "o", "u", "a", "e", "i", "o", "u")
    println(vocalesRepetidas)

    val numerosFavoritos = mutableSetOf(1,2,3,4)
    println(numerosFavoritos)
    numerosFavoritos.add(5)
    numerosFavoritos.add(5)
    println(numerosFavoritos)

    numerosFavoritos.remove(5)
    println(numerosFavoritos)

    val valorDelSet : Int? = numerosFavoritos.firstOrNull { numero -> numero > 2 } ?: 0
    println(valorDelSet)
}

// example 11 : funciones de extension
fun String.randomCase() : String {
    val numeroAleatorio = 0..99
    val resultadoAleatorio = numeroAleatorio.random()
    return if (resultadoAleatorio.rem(2) == 0) uppercase() else lowercase()
}

// example 12 : funciones de tipo Unit = no retorna nada
fun imprimirFrase(frase : String) : Unit {
    println("Tu frase es : $frase")
}

// example 13 : parametros nombrados
fun imprimirNombre(nombre : String, segundoNombre : String = "", apellido : String, segundoApellido: String = "") {
    println("Mi nombre completo es $nombre $segundoNombre $apellido $segundoApellido")
}

// example 14 :  creacion y ejecucion de lambdas
fun example14() {
    val myLamba : (String) -> Int = { it.length }
    val lambaEjecutada : Int  = myLamba("Holas Platzi")
    println(lambaEjecutada)

    val saludos = listOf("Hello", "Hola", "ciao")
    val longitudDeSaludos = saludos.map(myLamba)
    println(longitudDeSaludos)
}

// example 15 : ejecucion de funcion dentro de funcion
fun superFuncion(valorInicial : String, block : (String) -> Int) : Int {
    return block(valorInicial)
}

// example 15 : retorno de lambda al ejecutar funcion
fun funcionInception(nombre : String) : () -> String {
    return {
        "Hola desde la lambda $nombre"
    }
}

// example 16 : Let
fun example16() {
    var nombre : String? = null
    nombre?.let { valor -> println("El nombre no es nulo, es $valor") }

    nombre = "Herian"
    nombre?.let { valor -> println("El nombre no es nulo, es $valor") }
}

// example 17 : With
fun example17() {
    val colores = listOf("Azul", "Amarillo", "Rojo")
    with(colores) {
        println("Nuestros colores son $this")
        println("Esta lista tiene una cantidad de colores de $size")
    }
}

// example 18 : Run
fun example18() {
    val moviles = mutableListOf("Google Pixel 2XL", "Google Pixel 4a", "Huawei Redmi 9", "Xiaomi mi a3")
        .run {
            removeIf { movil -> movil.contains("Google") }
            this
        }
    println(moviles)
}

// example 19 : Apply
fun example19() {
    val moviles = mutableListOf("Google Pixel 2XL", "Google Pixel 4a", "Huawei Redmi 9", "Xiaomi mi a3")
        .apply {
            removeIf { movil -> movil.contains("Google") }
        }
    println(moviles)

    val colores : MutableList<String>? = mutableListOf("Amarillo", "Azul", "Rojo")
    colores?.apply {
        println("Nuestros colores son $this")
        println("La cantidad de colores es $size")
    }
}

// example 20 : Also
fun example20() {
    val moviles = mutableListOf("Google Pixel 2XL", "Google Pixel 4a", "Huawei Redmi 9", "Xiaomi mi a3")
        .also {
            lista -> println("El valor original de la lista es $lista")
        }.asReversed()
    println(moviles)
}
