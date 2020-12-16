package behavioral_patterns.strategy

class Formatter(private val strategy: (String) -> String) {
    fun format(string: String) = strategy.invoke(string)
}

val toLowerCaseStrategy = { it: String -> it.toLowerCase() }

val prefixStrategy = { it: String -> "Prefix: $it" }