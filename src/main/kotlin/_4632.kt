fun main() {

    val userInput = readln().toInt()
    when (userInput) {
        in 0 until 10 -> println(1)
        in 10 until 100 -> println(2)
        in 100 until 1000 -> println(3)
        else -> println(4)
    }

    readln().length.apply(::println)

}