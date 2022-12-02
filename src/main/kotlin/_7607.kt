import java.lang.Exception

fun main() {

    val finalResult = parseCardNumber("1234 5678 9012 3456")

}

fun parseCardNumber(cardNumber: String): Long {

    val splitedInput = cardNumber.split(" ")
    val genericException = Exception("Invalid Card Number")

    // Digit verification
    splitedInput.forEach { numberGrup ->
        numberGrup.forEach {
            if (!it.isDigit()) throw genericException
        }
    }

    val numbersList = mutableListOf<Long>()
    splitedInput.forEach { currentString ->
        numbersList.add(currentString.toLong())
    }

    // Spaces verification
    if (numbersList.size != 4) {
        throw Exception("Invalid card number")
    }

    // Digits per group verification
    splitedInput.forEach { digitGroup ->
        if (digitGroup.length != 4) throw genericException
    }

    return splitedInput.joinToString("").toLong()

}

fun parseCardNumberWithRegex(cardNumber: String): Long {
    val regex = Regex(pattern = "^[0-9]{4} [0-9]{4} [0-9]{4} [0-9]{4}$")
    if (!regex.matches(cardNumber)) throw Exception("Incorrect input!")
    return cardNumber.replace(" ", "").toLong()
}