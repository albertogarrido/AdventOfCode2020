package dev.albertogarrido.advent.day2.p2

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
    //part 2 policy
    fun isValid(): Boolean {

        val position1 = try {
            password[policy.first - 1] == policy.third
        } catch (e: StringIndexOutOfBoundsException) {
            false
        }

        val position2 = try {
            password[policy.second - 1] == policy.third
        } catch (e: StringIndexOutOfBoundsException) {
            false
        }

        println("______________________________________________________________________")
        println("${policy.first} - ${policy.second}")
        println(policy.third)
        println(password)
        println((position1 && !position2) || (!position1 && position2))
        println("______________________________________________________________________")


        return (position1 && !position2) || (!position1 && position2)
    }
}