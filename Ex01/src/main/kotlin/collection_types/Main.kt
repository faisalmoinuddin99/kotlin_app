package org.example.collection_types

import kotlin.reflect.typeOf

fun main() {
    println("welcome to CollectionTypes in Kotlin")

    val text: String = "Something - I made up from thin air"
    val result = generate({ pharse ->
        pharse.split(" ")
            .asSequence()
            .flatMap { it.split("_") }
            .flatMap { it.split("-") }
            .filter { it.isNotEmpty() }
            .map { it.first().uppercase() }
            .joinToString("")
    }, text)

    println(result) // SIMUFTA

    val rev = test("robot")
    println(rev)

}

fun generate(operation: (String) -> String, phrase: String): String {

    return operation(phrase)
}

fun reverseHelper(text: String): String {
    return reverse({
        text.reversed()
    }, text)
}

fun reverse(operation: (String) -> String, input: String): String {
    return operation(input)
}
fun test(input: String) : String {
    return input.reversed()
}
