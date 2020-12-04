package structural_patterns.facade

enum class Language {
    English,
    Italian,
    French;
}

interface Translator {
    fun translate(text: String, textLanguage: Language): String
}

class ItalianTranslator : Translator {
    override fun translate(text: String, textLanguage: Language): String {
        return "Перевод ($text) с ${textLanguage.name} на Italian"
    }
}

class FrenchTranslator : Translator {
    override fun translate(text: String, textLanguage: Language): String {
        return "Перевод ($text) с ${textLanguage.name} на French"
    }
}

class EnglishTranslator : Translator {
    override fun translate(text: String, textLanguage: Language): String {
        return "Перевод ($text) с ${textLanguage.name} на English"
    }
}