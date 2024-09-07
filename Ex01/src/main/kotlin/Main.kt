import arrow.core.andThen
import arrow.core.compose

fun main(args: Array<String>) {
    /*
    Conditional Composition

     Scenario: Ek function banao jo input number ko check kare agar woh even hai,
     dusra function jo number ko square kare.
     */
    val isEven: (Int) -> Boolean = { it % 2 == 0 }
    val squareInteger: (Int) -> Int = { it * it }

    // Using andThen: Squaring first (may not make sense logically)

    val result = squareInteger compose { n: Int ->
        if (isEven(n)) n else 0
    }
    println(result(5))
}

