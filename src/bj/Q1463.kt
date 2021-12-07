package bj

import java.lang.Integer.min

val hashMap = HashMap<Int, Int>()

fun main() {
    val max = readLine()?.toInt() ?: 0
    hashMap[0] = 0
    hashMap[1] = 0
    if(max == 1)
        print(1)
    hashMap[2] = 1
    (2..max).forEach { input ->

        if (input % 3 == 0) {
            hashMap[input] = min((hashMap[input / 3] ?: 0) + 1, hashMap[input] ?: Int.MAX_VALUE)
        }
        if (input % 3 == 0) {
            hashMap[input] = min((hashMap[input / 2] ?: 0) + 1, hashMap[input] ?: Int.MAX_VALUE)
        }
        hashMap[input] = min((hashMap[input - 1] ?: 0) + 1, hashMap[input] ?: Int.MAX_VALUE)
    }
    print(hashMap[max] ?: 1)
}