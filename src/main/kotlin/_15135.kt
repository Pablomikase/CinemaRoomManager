fun main() {

    val matrix = mutableListOf(
        mutableListOf(
            mutableListOf(0, 0, 0), mutableListOf(0, 0, 0), mutableListOf(0, 0, 0)
        ),
        mutableListOf(
            mutableListOf(0, 0, 0), mutableListOf(0, 0, 0), mutableListOf(0, 0, 0)
        ),
        mutableListOf(
            mutableListOf(0, 0, 0), mutableListOf(0, 0, 0), mutableListOf(0, 0, 0)
        )
    )

    val matrixEz = MutableList(3) { MutableList(3) { MutableList(3) { 1 } } }

    println(matrix)
    println(matrixEz)

}