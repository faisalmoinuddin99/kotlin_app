import arrow.core.andThen
import arrow.core.compose

fun main(args: Array<String>) {

    val tagPrice: Double = 1000.00
    val discountPercent: Double = 20.00

    //  calculate discount price
    val applyDiscount: (Double, Double) -> Double = { price, discountPer ->
        price * (discountPer) / 100
    }

    // calculate gst assuming 18%
    val calculateTax: (Double, Int) -> Double = { sellingPrice, gstRate ->
        (sellingPrice * gstRate) / 100
    }
    val calculateSellingPrice: (Double) -> Double = {
        it - applyDiscount(it, discountPercent)
    }
    val finalPriceFunction = calculateSellingPrice andThen { sellingPrice ->
        sellingPrice + calculateTax(sellingPrice, 18)
    }
    println("Final price: ${finalPriceFunction(tagPrice)}")
    // OUTPUT: Final price: 944.0


}

