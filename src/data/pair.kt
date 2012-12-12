package data.pair

fun main(args: Array<String>) {
    val (a, b) = Pair(10, "a")

    val p = Pair(11, "b")
    val (c, d) = p

    val c0 = p.component1()
    val d0 = p.component2()
}