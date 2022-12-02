fun pepTalk(name: String): String {
    try{
        val array = name.split(" ").toTypedArray()
        val firstName = array[0]
        val secondName = array[1]
        return "Good luck! \n Don't lose the towel, traveler $firstName $secondName!"
    }catch(ex: Exception){
        return "Good luck! \n Don't lose the towel, nameless one."
    }

}
// do not change the function above

fun main() {
    val name = readLine()!!
    val advice = pepTalk(name) // fix this function call
    print(advice)
}