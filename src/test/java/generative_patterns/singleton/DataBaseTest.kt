package generative_patterns.singleton

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class DataBaseTest {
    @Test
    fun testSingleton() {
        val db = DataBase.getInstance()
        db.addWord("Синглтон")
        db.addWord("Паттерн")
        val db2 = DataBase.getInstance()
        db2.addWord("qwerty")
        Assertions.assertEquals(db, db2)
        db.addWord("")
        Assertions.assertEquals(db.words, db2.words)
    }
}