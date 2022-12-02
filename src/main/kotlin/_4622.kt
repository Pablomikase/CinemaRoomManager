fun main() {

    val fList = listOf(0, 1, 2, 3, 5, 8, 13, 21, 34, 55)
    val tList = listOf(0, 1, 3, 6, 10, 15, 21, 28, 36, 45)
    val plist = listOf(1, 10, 100, 1000, 10000, 100000)

    val userInput = readln().toInt()

    when (userInput) {
        in fList -> println("F")
        in tList -> println("T")
        in plist -> println("P")
        else -> println("N")
    }
}