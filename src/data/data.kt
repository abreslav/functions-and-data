package data

enum class Error {
    NO_VALUE
    OK
    ABORTED
}

data class Maybe<T>(val data: T, val error: Error)

fun compute(): Maybe<Int> {
    return Maybe(0, Error.OK)
}

fun test() {
    val (x, err) = compute()

    if (err == Error.OK) {
        println(x)
    }
}

