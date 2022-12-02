fun main() {


    val userInput = readln()
    println(
        when {
            userInput == "" -> ""
            userInput.first() == 'i' -> userInput.drop(1).toInt() + 1
            userInput.first() == 's' -> userInput.drop(1).reversed()
            else -> userInput
        }
    )

}