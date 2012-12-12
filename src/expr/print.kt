package expr

fun Expr.print(): String {
    return when (this) {
        is Num -> "$value"
        is Var -> name
        is Sum -> "${left.print()} + ${right.print()}"
        else -> throw IllegalArgumentException("Unknown term: $this")
    }
}