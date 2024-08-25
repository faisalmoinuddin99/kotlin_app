package org.example

import kotlinx.coroutines.*

suspend fun main() {
    val cal = calculateTotalSum(listOf(10, 20, 30), listOf(2, 4, 2))
    println(cal)

    val cal2 = improvedVersionOfCalculateSum(listOf(10, 20, 30), listOf(2, 4, 2))
    println(cal2)
}
/*
Title: Calculate the Sum of Two Lists Concurrently

Difficulty: Easy

Description:

Given two lists of integers, you need to calculate the sum of each list concurrently
using Kotlin coroutines. Then, return the total sum of both lists combined.

Task:

Implement the function calculateTotalSum(list1: List<Int>, list2: List<Int>):
Int that calculates the sum of list1 and list2 concurrently and returns the total sum.
 */

inline fun helperFunction(operation: (List<Int>) -> Int, x: List<Int>): Int {
    return operation(x);
}

suspend fun calculateTotalSum(list1: List<Int>, list2: List<Int>): Int {

    var resultOfList1 = 0
    var resultOfList2 = 0
    val job = CoroutineScope(Dispatchers.IO).launch {
        delay(1000L)
        resultOfList1 = helperFunction({
            list1.sum()
        }, list1)

        resultOfList2 = helperFunction({
            list2.sum()
        }, list2)
    }
    job.join()


    return resultOfList1 + resultOfList2
}

suspend fun improvedVersionOfCalculateSum(list1: List<Int>, list2: List<Int>): Int {

    return coroutineScope {
        val sum1 = async { list1.sum() }
        val sum2 = async { list2.sum() }

        sum1.await() + sum2.await()
    }


}