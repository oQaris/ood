package generative_patterns.abstractFactory_factoryMethod

class Heapsort : ISort {
    override fun sort(array: IntArray) {
        val n = array.size
        for (i in n / 2 - 1 downTo 0) heapify(array, n, i)
        for (i in n - 1 downTo 1) {
            val temp = array[0]
            array[0] = array[i]
            array[i] = temp
            heapify(array, i, 0)
        }
    }

    private fun heapify(arr: IntArray, n: Int, i: Int) {
        var largest = i
        val l = 2 * i + 1
        val r = 2 * i + 2
        if (l < n && arr[l] > arr[largest]) largest = l
        if (r < n && arr[r] > arr[largest]) largest = r
        if (largest != i) {
            val swap = arr[i]
            arr[i] = arr[largest]
            arr[largest] = swap
            heapify(arr, n, largest)
        }
    }
}