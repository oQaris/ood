package structural_patterns.bridge

import generative_patterns.abstractFactory_factoryMethod.RadixSort
import generative_patterns.abstractFactory_factoryMethod.SelectionSort
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

internal class MyCollectionsTest {

    @Test
    fun testCollectionBridge() {
        // Используется интерфейс и классы сортировки из первого задания (паттерн Абстрактная фабрика)

        val list = MyList(RadixSort())
        list.data.add(56)
        list.data.add(32)
        list.data.add(0)
        list.data.add(32)

        val set = MySet(SelectionSort())
        set.data.add(5)
        set.data.add(5)
        set.data.add(67)
        set.data.add(0)

        val list2 = MyList() // по-умолчанию Heapsort
        list2.data.add(7)
        list2.data.add(9)
        list2.data.add(99)
        list2.data.add(31)

        assertArrayEquals(intArrayOf(0, 32, 32, 56), list.getSortedArray())
        assertArrayEquals(
            intArrayOf(0, 5, 67),
            set.getSortedArray()
        )          // так как set не хранит одинаковые объекты
        assertArrayEquals(intArrayOf(7, 9, 31, 99), list2.getSortedArray())
    }
}