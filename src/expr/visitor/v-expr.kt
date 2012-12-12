package expr.visitor

import lib.env

trait Expr {
    fun <D, R> accept(visitor: ExprVisitor<D, R>, data: D): R
}

trait ExprVisitor<D, R> {
    fun visitNum(e: Num, data: D): R
    fun visitVar(e: Var, data: D): R
    fun visitSum(e: Sum, data: D): R
}

class Num(val value: Int) : Expr {
    override fun <D, R> accept(visitor: ExprVisitor<D, R>, data: D): R {
        return visitor.visitNum(this, data)
    }
}

class Var(val name: String) : Expr {
    override fun <D, R> accept(visitor: ExprVisitor<D, R>, data: D): R {
        return visitor.visitVar(this, data)
    }
}

class Sum(val left: Expr, val right: Expr) : Expr {
    override fun <D, R> accept(visitor: ExprVisitor<D, R>, data: D): R {
        return visitor.visitSum(this, data)
    }
}

fun eval(e: Expr, env: (String) -> Int): Int {
    return e.accept(
            object : ExprVisitor<(String) -> Int, Int> {
                override fun visitNum(e: Num, data: (String) -> Int) = e.value

                override fun visitVar(e: Var, data: (String) -> Int) = data(e.name)

                override fun visitSum(e: Sum, data: (String) -> Int)
                        = e.left.accept(this, data) + e.right.accept(this, data)
            },
            env
    )
}

fun print(e: Expr): String {
    return e.accept(
            object : ExprVisitor<Unit, String> {
                override fun visitNum(e: Num, data: Unit) = "" + e.value

                override fun visitVar(e: Var, data: Unit) = e.name

                override fun visitSum(e: Sum, data: Unit)
                        = e.left.accept(this, data) + " + " + e.right.accept(this, data)
            },
            Unit.VALUE
    )
}

fun main(args: Array<String>) {
    val expr = Sum(Var("x"), Num(2))
    val env = env("x" to 10)
    print(
            print(expr) + " = " + eval(expr, env)
    )
}




