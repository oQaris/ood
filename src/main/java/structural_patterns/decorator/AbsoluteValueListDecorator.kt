package structural_patterns.decorator

import kotlin.math.absoluteValue

class AbsoluteValueListDecorator(private val list: MutableList<Int> = arrayListOf()) :
    MutableList<Int> by list {  // ключевое слово by делегирует все методы из MutableList нашему объекту list

    override fun add(element: Int): Boolean {
        // берёт модуль числа перед добавлением в список
        return list.add(element.absoluteValue)
    }
}