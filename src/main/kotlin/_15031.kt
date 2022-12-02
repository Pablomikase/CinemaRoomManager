fun main() {

    val numberOfInputs = readln().toInt()
    val listOfNumbers = mutableListOf<Int>()

    repeat(numberOfInputs){
        listOfNumbers.add(readLine()!!.toInt())
    }
    val numberOfVerification = readln().toInt()

    var finalResult = "NO"

    for (currentNumber in listOfNumbers){
        if (currentNumber == numberOfVerification){
            finalResult = "YES"
        }
    }
    println(finalResult)
}