package dev.albertogarrido.advent.day01.p2

import java.io.File

fun main() {
    val lines = File("assets/d01.data").bufferedReader().readLines()

    val intLines = lines.map { it.toInt() }

    intLines.forEach { n1 ->
        intLines.forEach { n2 ->
            intLines.forEach { n3 ->
                if (n1 + n2 + n3 == 2020) {
                    println("$n1, $n2, $n3 result: ${n1 * n2 * n3}")
                }
            }
        }
    }
}