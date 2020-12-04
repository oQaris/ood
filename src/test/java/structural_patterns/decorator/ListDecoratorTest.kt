package structural_patterns.decorator

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class ListDecoratorTest {

    @Test
    fun add() {
        val testArr = arrayOf(-5, 12, -1, -9, 0, 7, 10, -34)

        val myList1 = AbsoluteValueListDecorator()
        testArr.forEach { myList1.add(it) }

        val myList2 = AverageListDecorator()
        testArr.forEach { myList2.add(it) }

        val myList3 =
            AverageListDecorator(AbsoluteValueListDecorator()) // сначала берётся модуль, потом прибавляется среднее
        testArr.forEach { myList3.add(it) }

        arrayListOf(5, 12, 1, 9, 0, 7, 10, 34).forEachIndexed { idx, elem ->
            assertEquals(elem, myList1[idx])
        }
        arrayListOf(-5, 7, 0, -9, -1, 6, 10, -33).forEachIndexed { idx, elem ->
            assertEquals(elem, myList2[idx])
        }
        arrayListOf(5, 17, 10, 1, 8, 15, 19, 24).forEachIndexed { idx, elem ->
            assertEquals(elem, myList3[idx])
        }
    }
}