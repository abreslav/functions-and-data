package expr

fun eval_if(e: Expr, env: (String) -> Int): Int {
    if (e is Num) {
        val num = e as Num
        return num.value
    }

    if (e is Var) {
        val v = e as Var
        return env(v.name)
    }

    if (e is Sum) {
        val sum = e as Sum
        return eval_if(sum.left, env) + eval_if(sum.right, env)
    }

    throw IllegalArgumentException("Unknown term: $e")
}

fun eval_when(e: Expr, env: (String) -> Int): Int {
    return when (e) {
        is Num -> e.value
        is Var -> env(e.name)
        is Sum -> eval_when(e.left, env) + eval_when(e.right, env)
        else -> throw IllegalArgumentException("Unknown term: $e")
    }
}

fun Expr.eval(env: (String) -> Int): Int {
    return when (this) {
        is Num -> this.value
        is Var -> env(name)
        is Sum -> left.eval(env) + right.eval(env)
        else -> throw IllegalArgumentException("Unknown term: $this")
    }
}