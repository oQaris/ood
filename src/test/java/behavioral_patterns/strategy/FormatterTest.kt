package behavioral_patterns.strategy

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class FormatterTest {

    @Test
    fun format() {
        val formatter1 = Formatter(toLowerCaseStrategy)
        val formatter2 = Formatter(prefixStrategy)

        assertEquals("паттерн стратегия", formatter1.format("ПаТтЕрН СТРАТЕГИЯ"))
        assertEquals("Prefix: любое слово", formatter2.format("любое слово"))
        assertEquals("trimmed word", Formatter { it.trim() }.format("   trimmed word  "))
    }
}