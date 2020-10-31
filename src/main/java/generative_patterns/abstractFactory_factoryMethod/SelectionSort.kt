package generative_patterns.abstractFactory_factoryMethod

class SelectionSort : ISort {
    override fun sort(array: IntArray) {
        val n = array.size
        for (i in 0 until n - 1) {
            var minIdx = i
            for (j in i + 1 until n) if (array[j] < array[minIdx]) minIdx = j
            val temp = array[minIdx]
            array[minIdx] = array[i]
            array[i] = temp
        }
    }
}