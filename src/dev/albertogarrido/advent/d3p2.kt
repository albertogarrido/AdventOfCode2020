package dev.albertogarrido.advent.day03.p2

import java.io.File

fun main() {
    val lines = File("assets/d03.data").bufferedReader().readLines()
    val maxLines = lines.size
    val maxColumnsIndex = lines[0].length - 1
    val mountainMap = listToMatrix(lines)

    val slopes: List<Pair<Int, Int>> =
        listOf(
            1 to 1,
            3 to 1,
            5 to 1,
            7 to 1,
            1 to 2
        )

    var treesMultiplied: Long = 1

    slopes.forEach { (right, down) ->
        var slopeTreeCount = 0
        var horizontalPosition = 0

        (0 until maxLines - 1 step down)
            .asIterable()
            .forEach { i ->
                horizontalPosition = if (horizontalPosition + right > maxColumnsIndex) {
                    horizontalPosition + right - maxColumnsIndex - 1
                } else {
                    horizontalPosition + right
                }

                if (isTree(mountainMap[i + down][horizontalPosition])) {
                    slopeTreeCount++
                }
            }
        treesMultiplied *= slopeTreeCount
    }
    println(treesMultiplied)
}

fun isTree(square: Char) = square == '#'

fun listToMatrix(lines: List<String>): Array<CharArray> {
    val maxLines = lines.size
    val maxColumns = lines[0].length
    val mountainMap = Array(maxLines) { CharArray(maxColumns) }
    for (i in 0 until maxLines) {
        for (k in 0 until maxColumns) {
            mountainMap[i][k] = lines[i][k]
        }
    }
    return mountainMap
}
