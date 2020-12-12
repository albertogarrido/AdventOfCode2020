package dev.albertogarrido.advent.day01.p1

import java.io.File

fun main() {
    val lines = File("assets/d01.data").bufferedReader().readLines()

    val intLines = lines.map { it.toInt() }

    intLines.forEach { checkedNumber ->
        intLines.forEach { loopNumber ->
            if (checkedNumber + loopNumber == 2020) {
                println("$checkedNumber, $loopNumber, result: ${checkedNumber * loopNumber}")
            }
        }
    }
}