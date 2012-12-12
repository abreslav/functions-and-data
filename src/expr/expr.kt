package expr

import lib.env

trait Expr

class Num(val value: Int) : Expr
class Var(val name: String) : Expr
class Sum(val left: Expr, val right: Expr) : Expr









fun main(args: Array<String>) {
    val expr = Var("x") + 2
    val env = env("x" to 10)
    println(expr)
    println(
            expr.eval(env)
    )
}

