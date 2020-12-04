package structural_patterns.facade

class TranslationManager {
    private val italianTranslator = ItalianTranslator()
    private val frenchTranslator = FrenchTranslator()
    private val englishTranslator = EnglishTranslator()

    fun translate(text: String, translateFrom: Language, translateTo: Language): String {
        return when (translateTo) {
            Language.Italian -> italianTranslator.translate(text, translateFrom)
            Language.French -> frenchTranslator.translate(text, translateFrom)
            Language.English -> englishTranslator.translate(text, translateFrom)
        }
    }
}