fun main() {

    val theater = requireTheaterDimensions()
    startProgram(theater)
}

fun startProgram(theater: MutableList<MutableList<String>>) {
    var userOption: Int
    do {
        println(
            "1. Show the seats\n" +
                    "2. Buy a ticket\n" +
                    "3. Statistics\n" +
                    "0. Exit"
        )
        userOption = readln().toInt()

        when {
            userOption == 1 -> printTheaterSeats(theater)
            userOption == 2 -> buyTicket(theater)
            userOption == 3 -> showStatistics(theater)
        }

    } while (userOption != 0)
}

fun showStatistics(theater: MutableList<MutableList<String>>) {
    var boughtSeats = 0
    val totalSeats = theater.size * theater.first().size
    var currentIncome = 0
    var totalIncome = 0
    var rowCounter = 0
    theater.forEach { row ->
        rowCounter++
        row.forEach {
            if (it == "B") {
                boughtSeats++
                currentIncome += getSeatPrice(rowCounter, row.size, theater.first().size)
            }
            totalIncome += getSeatPrice(rowCounter, row.size, theater.first().size)
        }
    }
    val percentage: Float = if (boughtSeats == 0) 0.0f else (boughtSeats.toFloat() / totalSeats.toFloat()) * 100
    val formattedPercentage = "%.2f".format(percentage)
    println("Number of purchased tickets: $boughtSeats")
    println("Percentage: $formattedPercentage%")
    println("Current income: \$$currentIncome")
    println("Total income: \$$totalIncome")

}

fun buyTicket(theater: MutableList<MutableList<String>>) {

    var userIsBuying = true

    while (userIsBuying) {

        println("Enter a row number:")
        val selectedRow = readln().toInt()
        println("Enter a seat number in that row:")
        val selectedColumn = readln().toInt()

        when {
            areRowAndColumnIncorrect(theater, selectedRow, selectedColumn) -> {
                println("Wrong input!")
            }

            isSeatUnavailable(theater, selectedRow, selectedColumn) -> {
                println("That ticket has already been purchased!")
            }

            else -> {
                printTicketPrice(selectedRow, theater.size, theater.first().size)
                theater[selectedRow - 1][selectedColumn - 1] = "B"
                userIsBuying = false
            }
        }
    }
}

fun areRowAndColumnIncorrect(
    theater: MutableList<MutableList<String>>,
    selectedRow: Int,
    selectedColumn: Int
): Boolean {
    return when {
        selectedRow > theater.size -> true
        selectedColumn > theater.first().size -> true
        else -> false
    }
}

fun isSeatUnavailable(theater: MutableList<MutableList<String>>, selectedRow: Int, selectedColumn: Int): Boolean =
    theater[selectedRow - 1][selectedColumn - 1] == "B"

fun printIncome(incoming: Int) {
    println("Total income:")
    println("$${incoming}")
}

fun printTheaterSeats(seatsPlane: MutableList<MutableList<String>>) {
    println("Cinema:")
    print("  ")
    println(seatsPlane.first().indices.joinToString(" ") {
        (it + 1).toString()
    })
    var rowCounter = 1
    for (row in seatsPlane) {
        print("${rowCounter++} ")
        println(row.joinToString(" "))
    }

}

fun requireTheaterDimensions(): MutableList<MutableList<String>> {
    println("Enter the number of rows:")
    val theaterRows = readln().toInt()
    println("Enter the number of seats in each row:")
    val theaterSeatsPerRow = readln().toInt()
    return MutableList(theaterRows) {
        MutableList(theaterSeatsPerRow) { "S" }
    }
}

fun printTicketPrice(rowSelected: Int, lastSeat: Int, lastColumn: Int) {
    val seatPrice = getSeatPrice(rowSelected, lastSeat, lastColumn)
    println("Ticket price: \$$seatPrice")
}

fun getSeatPrice(rowSelected: Int, lastSeat: Int, lastColumn: Int): Int {

    if (lastSeat * lastColumn < 60) return 10

    var limit = 0

    limit = lastSeat / 2

    val frontPrice = 10
    val backPrice = 8
    return if (rowSelected <= limit) {
        frontPrice
    } else {
        backPrice
    }
}