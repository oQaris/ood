package structural_patterns.bridge

import generative_patterns.abstractFactory_factoryMethod.ISort

interface MyCollection {
    val sorter: ISort
    val data: Collection<Int>

    fun getSortedArray(): IntArray {
        val out = data.toIntArray()
        sorter.sort(out)
        return out
    }
}