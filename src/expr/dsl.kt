package expr

fun Expr.plus(right: Expr): Expr = Sum(this, right)
fun Expr.plus(num: Int): Expr = this + Num(num)
