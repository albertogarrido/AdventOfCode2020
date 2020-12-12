package dev.albertogarrido.advent

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
