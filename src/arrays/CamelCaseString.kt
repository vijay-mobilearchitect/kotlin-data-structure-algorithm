package arrays

import java.util.*

// In camelcase string - count words.
// Input : saveChangesInTheEditor
//Output : 5

fun camelcase(s: String): Int {

    return s.toCharArray().filter { s -> s.isUpperCase() }.size + 1
}

fun main() {
    val scan = Scanner(System.`in`)

    val s = scan.nextLine()

    val result = camelcase(s)

    println(result)
}