package data

fun main(args: Array<String>) {

    val map = hashMapOf(
        "a" to 10,
        "b" to 12,
        "c" to 20
    )

    for ((k, v) in map) {
        println("$k -> $v")
    }
}