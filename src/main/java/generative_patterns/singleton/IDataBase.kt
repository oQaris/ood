package generative_patterns.singleton

interface IDataBase {
    val words: MutableSet<String>

    fun addWord(word: String)
}