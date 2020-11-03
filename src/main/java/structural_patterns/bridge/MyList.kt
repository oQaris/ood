package structural_patterns.bridge

import generative_patterns.abstractFactory_factoryMethod.Heapsort
import generative_patterns.abstractFactory_factoryMethod.ISort

class MyList(override val sorter: ISort = Heapsort()) : MyCollection {
    override val data = ArrayList<Int>()
}