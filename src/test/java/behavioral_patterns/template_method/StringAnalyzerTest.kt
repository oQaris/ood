package behavioral_patterns.template_method

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class StringAnalyzerTest {

    @Test
    fun analyze() {
        val out = StringBuilder()

        val sa = object : StringAnalyzer {

            override fun foundTabulation(index: Int, char: Char) {
                // оставляем только отступы на чётных позициях
                out.append("".padEnd(index % 2, char))
            }

            override fun foundDigit(index: Int, char: Char) {
                // От всех чисел отнимаем их позицию в слове
                out.append("${char.toString().toInt() - index}")
            }

            override fun foundLetter(index: Int, char: Char) {
                // Буквы добавляем в верхнем регистре
                out.append(char.toUpperCase())
            }

            override fun foundPunctuation(index: Int, char: Char) {
                // Пунктуации удаляем...
            }
        }

        sa.analyze("!! H e l l o, W o r l d!!")
        assertEquals("HELLO W O R L D", out.toString())
        out.clear()

        sa.analyze("9 9 9 9 9  ^_^ 9 9 9 9 9 9")
        assertEquals("9 7 5 3 1 -6-8-10-12-14-16", out.toString())
    }
}