package structural_patterns.bridge

import generative_patterns.abstractFactory_factoryMethod.Heapsort
import generative_patterns.abstractFactory_factoryMethod.ISort

class MySet(override val sorter: ISort = Heapsort()) : MyCollection {
    override val data = HashSet<Int>()
}