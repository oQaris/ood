package structural_patterns.facade

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class TranslationManagerTest {

    @Test
    fun translate() {
        val translationManager = TranslationManager()

        assertEquals(
            "Перевод (Refactoring Guru) с English на Italian",
            translationManager.translate("Refactoring Guru", Language.English, Language.Italian)
        )

        assertEquals(
            "Перевод (Some text) с French на English",
            translationManager.translate("Some text", Language.French, Language.English)
        )
    }
}