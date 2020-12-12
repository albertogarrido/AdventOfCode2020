package dev.albertogarrido.advent

import java.io.File

fun main() {
    val lines = File("assets/d03.data").bufferedReader().readLines()
    val maxLines = lines.size
    val maxColumnsIndex = lines[0].length - 1
    val mountainMap = listToMatrix(lines)
    val right = 3
    val down = 1

    var treeCount = 0
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
                treeCount++
            }
        }
    println(treeCount)
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
