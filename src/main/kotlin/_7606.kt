import java.lang.Exception

fun main() {

    val userInput = readLine()!!
    val word = readLine()!!
    val genericException = Exception("There isn't such an element in the given string, please fix the index!")
    var isThereAnyError = false
    userInput.forEach {
        if (!it.isDigit()) isThereAnyError = true
    }
    if (userInput.isEmpty() || word.isEmpty()) isThereAnyError = true

    val index = userInput.toInt()
    if (index < 0 ||
        index > word.length ||
        isThereAnyError
    ) {
        println(genericException.message)
    } else {
        try {
            println(word[index])
        }catch (ex: Exception){
            println(genericException.message)
        }
    }

}