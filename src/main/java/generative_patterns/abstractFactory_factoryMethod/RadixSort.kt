package generative_patterns.abstractFactory_factoryMethod

class RadixSort : ISort {
    override fun sort(array: IntArray) {
        var digitPlace = 1
        val n = array.size
        val result = IntArray(n)
        val largestNum = getMax(array)
        val count = IntArray(10)
        while (largestNum / digitPlace > 0) {
            for (i in 0..9) count[i] = 0
            for (j in array) {
                val tmpIndex = Math.abs(j / digitPlace % 10)
                count[tmpIndex]++
            }
            for (i in 1..9) count[i] += count[i - 1]
            for (i in n - 1 downTo 0) {
                val tmpIndex = Math.abs(array[i] / digitPlace % 10)
                result[count[tmpIndex] - 1] = array[i]
                count[tmpIndex]--
            }
            System.arraycopy(result, 0, array, 0, n)
            digitPlace *= 10
        }
    }

    private fun getMax(A: IntArray): Int {
        var max = A[0]
        for (i in 1 until A.size) {
            if (A[i] > max) max = A[i]
        }
        return max
    }
}