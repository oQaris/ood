package generative_patterns.abstractFactory_factoryMethod

import generative_patterns.abstractFactory_factoryMethod.SortCreator.heapsort
import generative_patterns.abstractFactory_factoryMethod.SortCreator.radixSort
import generative_patterns.abstractFactory_factoryMethod.SortCreator.selectionSort
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.util.*

internal class SortCreatorTest {
    private lateinit var array1: IntArray
    private lateinit var array2: IntArray

    @BeforeEach
    fun setUp() {
        val size = 1000
        array1 = IntArray(size)
        array2 = IntArray(size)
        for (i in 0 until size) {
            val item = (Math.random() * 200).toInt()
            array1[i] = item
            array2[i] = item
        }
    }

    @Test
    fun testSelectionSort() {
        selectionSort().sort(array1)
        Arrays.sort(array2)
        Assertions.assertArrayEquals(array1, array2)
    }

    @Test
    fun testHeapsort() {
        heapsort().sort(array1)
        Arrays.sort(array2)
        Assertions.assertArrayEquals(array1, array2)
    }

    @Test
    fun testRadixSort() {
        radixSort().sort(array1)
        Arrays.sort(array2)
        Assertions.assertArrayEquals(array1, array2)
    }
}