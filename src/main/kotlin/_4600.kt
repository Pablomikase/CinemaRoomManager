fun main() {

    println(
        readln().let { userInput ->
            when {
                userInput == "one" -> 1
                userInput == "two" -> 2
                userInput == "three" -> 3
                userInput == "four" -> 4
                userInput == "five" -> 5
                userInput == "six" -> 6
                userInput == "seven" -> 7
                userInput == "eight" -> 8
                userInput == "nine" -> 9
                userInput == "ten" -> 10
                else -> "unvalid input"
            }
        }
    )

}