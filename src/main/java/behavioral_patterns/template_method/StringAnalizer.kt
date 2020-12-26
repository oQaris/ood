package behavioral_patterns.template_method

interface StringAnalyzer {

    fun foundTabulation(index: Int, char: Char)
    fun foundDigit(index: Int, char: Char)
    fun foundLetter(index: Int, char: Char)
    fun foundPunctuation(index: Int, char: Char)

    fun analyze(string: String) {
        string.forEachIndexed { idx, c ->
            when {
                c == ' ' || c == '\t' || c == '\n' -> foundTabulation(idx, c)
                c.isDigit() -> foundDigit(idx, c)
                c.isLetter() -> foundLetter(idx, c)
                else -> foundPunctuation(idx, c)
            }
        }
    }
}