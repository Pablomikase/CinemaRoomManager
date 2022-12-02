fun main() {

    val inputList = mutableListOf(
        mutableListOf('P', 'R', 'O', 'G', 'R', 'A', 'M', 'M', 'I', 'N', 'G'),
        mutableListOf('I', 'S'),
        mutableListOf('M', 'A', 'G', 'I', 'C')
    )

    val resultList = mutableListOf(
        inputList.last(),
        inputList.first()
    )
    println(resultList)

}