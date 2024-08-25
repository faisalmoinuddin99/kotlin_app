package org.example.collection_types

import kotlin.reflect.typeOf

fun main() {
    println("welcome to CollectionTypes in Kotlin")

    val text: String ="Something - I made up from thin air"
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


}

fun generate(operation: (String) -> String, phrase: String): String {

    return operation(phrase)
}

