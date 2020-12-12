package dev.albertogarrido.advent

import java.io.File

fun main() {
    val lines = File("assets/d02.data").bufferedReader().readLines()
    println(lines.size)

    val passwords: List<PasswordPolicyCheck> = parseList(lines)

    val validPasswordsCount = passwords.filter { it.isValidPart2() }.size
    println(validPasswordsCount)
}

private fun parseList(lines: List<String>) = lines.map {
    val (policy, character, password) = it.split(" ")
    val (from, to) = policy.split("-")
    val policyRange = Triple(from.toInt(), to.toInt(), character[0])
    PasswordPolicyCheck(policyRange, password)
}
