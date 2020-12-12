package behavioral_patterns.chain_of_responsibility

class ChainNotDuplicateValues : ChainLink() {
    override fun check(data: List<Int>) =
        if (data.groupingBy { it }.eachCount().filter { it.value > 1 }.isNotEmpty()) false else runNext(data)
}