package dev.albertogarrido.advent

import java.io.File

fun main() {

    val lines = File("assets/d01.data").bufferedReader().readLines()
    println("number of lines: ${lines.size}")
    lines.forEachIndexed { index, s ->
        println("${index+1} `$s`")
    }
}