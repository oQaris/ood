package structural_patterns.proxy

import generative_patterns.singleton.DataBase
import generative_patterns.singleton.IDataBase

class DataBaseProxy : IDataBase {

    override val words: MutableSet<String>
        get() = DataBase.getInstance().words

    override fun addWord(word: String) {
        // инициализация при первом обращении
        DataBase.getInstance().addWord(
            "!proxy! ${word.trim()} !proxy!"
        )
    }
}