import kotlin.math.sqrt

fun isPrime(num: Int): Boolean {
    if (num < 2) {
        return false
    }

    for (i in 2..sqrt(num.toDouble()).toInt()) {
        if (num % i == 0) {
            return false
        }
    }
    
    return true
}

/// O(A * sqrt(B))
fun filterSequence(A: List<Int>, B: List<Int>): List<Int> {
    val elementCountMap = B.groupingBy { it }.eachCount()

    return A.filter { element ->
        val count = elementCountMap[element] ?: 0
        !isPrime(count)
    }
}

fun main() {
    val A = listOf(2, 3, 9, 2, 5, 1, 3, 7, 10)
    val B = listOf(2, 1, 3, 4, 3, 10, 6, 6, 1, 7, 10, 10, 10)
    val C = filterSequence(A, B)
    
    println(C)
}

/// A=[2,3,9,2,5,1,3,7,10] 
/// B=[2,1,3,4,3,10,6,6,1,7,10,10,10] 
/// C=[2,9,2,5,7,10] 

/// 0 YES
/// 1 YES
/// 2 NO
/// 3 ? NO
/// 4 YES