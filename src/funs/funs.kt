package funs





val f_long: (x: String) -> Int

        = {(s: String): Int -> s.length}











val f: (String) -> Int
        = {s -> s.length}























fun main(args: Array<String>) {

    var sum = 0
    listOf(1, 2, 3).forEach {
        x -> sum += x
    }

    println(sum)


    listOf(1, 2, 3).map { x -> 2 * x }


    // builders
}