package data.pair

data class User(
        val name: String,
        val age: Int
)

fun main(args: Array<String>) {
    val user = User("a", 1)
    val (name, age) = user
    println(user.age)

    val (a, b) = Pair(10, "a")

    val p = Pair(11, "b")
    val (c, d) = p

    val c0 = p.component1()
    val d0 = p.component2()
}