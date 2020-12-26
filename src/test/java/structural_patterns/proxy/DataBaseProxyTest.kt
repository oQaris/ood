package structural_patterns.proxy

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class DataBaseProxyTest {

    @Test
    fun addWordTest() {
        // Внимание! Запускать отдельно от теста паттерна Singleton, поскольку используется одна база данных!
        val db = DataBaseProxy()
        db.addWord(" qwerty  ")
        db.addWord("09876")
        db.addWord("  database")

        assertEquals(
            mutableSetOf(
                "!proxy! 09876 !proxy!",
                "!proxy! database !proxy!",
                "!proxy! qwerty !proxy!"
            ), db.words
        )
    }
}