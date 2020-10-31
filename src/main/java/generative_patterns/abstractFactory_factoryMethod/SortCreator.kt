package generative_patterns.abstractFactory_factoryMethod

object SortCreator {
    fun selectionSort(): ISort {
        return SelectionSort()
    }

    fun heapsort(): ISort {
        return Heapsort()
    }

    fun radixSort(): ISort {
        return RadixSort()
    }
}