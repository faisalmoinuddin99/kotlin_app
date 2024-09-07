import arrow.core.andThen
import arrow.core.compose
import kotlin.math.round
import kotlin.math.roundToInt

fun main(args: Array<String>) {

    val celciusToFaherenheit: (Double) -> Double = {
        (it * 9/5) + 32
    }
    val roundToTwoDecimal: (Double) -> Double = {
        round(it * 100) / 100
    }

    val faherenheit = celciusToFaherenheit andThen roundToTwoDecimal
    println("Fahrenheit : ${faherenheit(1.2)}")
}

