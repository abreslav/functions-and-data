package expr.oo

import lib.env

trait Expr {
    fun eval(env: (String) -> Int): Int
}

class Num(val value: Int) : Expr {
    override fun eval(env: (String) -> Int): Int = value
}

class Var(val name: String) : Expr {
    override fun eval(env: (String) -> Int): Int = env(name)
}

class Sum(val left: Expr, val right: Expr) : Expr {
    override fun eval(env: (String) -> Int): Int = left.eval(env) + right.eval(env)
}

fun main(args: Array<String>) {
    val expr = Sum(Var("x"), Num(2))
    val env = env("x" to 10)
    println(
            expr.eval(env)
    )
}




