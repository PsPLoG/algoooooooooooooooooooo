package bj

fun main() {
    val count = readLine()?.toInt() ?: 0
    val computerCount = readLine()?.toInt() ?: 0
    val map = Array(count) { IntArray(count) { Int.MAX_VALUE / 2 } }

    (0 until computerCount).forEach {
        val input = readLine()!!.split(" ").map { it.toInt() }
        map[input[0] - 1][input[1] - 1] = 1
    }

    for (i in 0 until count) {
        map[i][i] = 0
    }

    for (k in 0 until count) {
        for (i in 0 until count) {
            for (j in 0 until count) {
                if (i == j) {
                    continue
                }
                if (map[i][k] != Int.MAX_VALUE / 2 && map[k][j] != Int.MAX_VALUE / 2) {
                    map[i][j] = 1
                    map[j][i] = 1
                }
//                if (adj[1][k] == 1 && adj[k][j] == 1)
//                {
//                    adj[1][j] = 1;
//                    adj[j][1] = 1;
//                }
            }
        }
    }
    map.forEach {
        println(it.toList().toString())
    }
    println(map[0].count { it != Int.MAX_VALUE / 2 && it != 0 })
}