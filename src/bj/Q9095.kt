package bj


val hash = HashMap<Int, Int>()
val checkList = listOf(1, 2, 3)

fun surf(route: String, current: Int, target: Int) {
    if (current < target) {
        checkList.forEach {
            surf(route + it, current + it, target)
        }
    }
    if (current == target) {
        hash[target] = hash.getOrDefault(target, 0) + 1
    }
}

fun main() {
    val count = readLine()?.toInt() ?: 0
    (0 until count).forEach {
        val target = readLine()?.toInt() ?: 0
        for (i in checkList) {
            surf("$i", i, target)
        }
        println(hash[target])
    }
}