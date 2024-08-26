package org.example.oops
/*
@Composition Example
 */
data class Engine(private val horsePower: Double) {
    fun start() {
        println("Engine with $horsePower has started...")
    }
}

class Car(private val engine: Engine) {
    fun drive() {
        engine.start()
        println("Car is driving...")
    }
}

fun main(args: Array<String>) {
    val engine = Engine(1400.23)
    val eon = Car(engine)
    eon.drive()
    /*
    OUTPUT: Engine with 1400.23 has started...
            Car is driving...
     */
}