fun main() {
    val n = 9
    val list = createList(n)
    println(list)
}

fun createList(n: Int): MutableList<List<Int>> {
    when {
        n == 0 || n < 0 -> throw IllegalArgumentException("n can't be < 1")
    }

    val list = mutableListOf<List<Int>>()
    (1..2 * n).shuffled().take(n).forEach {
        val innerList = List(it) { (0..2 * n).random() }
        list.add(innerList)
    }
    list.forEachIndexed { index, innerList ->
        if (index % 2 == 0) {
            list[index] = innerList.sorted()
        } else {
            list[index] = innerList.sortedDescending()
        }
    }

    return list
}