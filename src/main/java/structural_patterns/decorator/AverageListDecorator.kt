package structural_patterns.decorator

class AverageListDecorator(private val list: MutableList<Int> = arrayListOf()) : MutableList<Int> by list {

    override fun add(element: Int): Boolean {
        // к текущему элементу прибавляет среднее арифметическое предыдущих элементов
        return list.add(element + list.average().toInt())
    }
}