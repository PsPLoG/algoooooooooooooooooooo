package bj

class Q1145 {

}

fun main() {
    val list = readLine()?.split(" ")
        ?.map { it.toInt() }
        ?: listOf()
    val result = list.reduce { acc, i -> acc * i }
    println("result${result}")
    (1..Int.MAX_VALUE).forEach { num ->
        val findAtLeast = list.count { num % it == 0  }
        if (findAtLeast >= 3) {
            println(num)
            return
        }
    }
}
