package dev.albertogarrido.advent.day2.p1

import java.io.File

fun main() {
    val lines = File("assets/d02.data").bufferedReader().readLines()
    println(lines.size)

    val passwords: List<PasswordPolicyCheck> = parseList(lines)

    val validPasswordsCount = passwords.filter { it.isValid() }.size
    println(validPasswordsCount)
}

fun parseList(lines: List<String>) = lines.map {
    val (policy, character, password) = it.split(" ")
    val (from, to) = policy.split("-")
    val policyRange = Triple(from.toInt(), to.toInt(), character[0])
    PasswordPolicyCheck(policyRange, password)
}

data class PasswordPolicyCheck(
    val policy: Triple<Int, Int, Char>,
    val password: String
) {
    fun isValid(): Boolean {
        val count = password.count { it == policy.third }
        return count >= policy.first && count <= policy.second
    }
}