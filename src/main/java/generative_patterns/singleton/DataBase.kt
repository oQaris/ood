package generative_patterns.singleton

import java.util.*

object DataBase : IDataBase {
    override val words: MutableSet<String>

    fun getInstance(): DataBase {
        return this
    }

    override fun addWord(word: String) {
        words.add(word)
    }

    init {
        words = TreeSet { obj: String, str: String? -> obj.compareTo(str!!, ignoreCase = true) }
    }
}