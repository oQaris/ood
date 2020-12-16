package behavioral_patterns.chain_of_responsibility

class ChainSorted : ChainLink() {
    override fun check(data: List<Int>) =
        if (!data.zip(data.drop(1)).all { (a, b) -> a <= b }) false else runNext(data)
}

class ChainNotDuplicateValues : ChainLink() {
    override fun check(data: List<Int>) =
        if (data.groupingBy { it }.eachCount().filter { it.value > 1 }.isNotEmpty()) false else runNext(data)
}

class ChainNonNegativeNumbers : ChainLink() {
    override fun check(data: List<Int>) =
        if (data.indexOfFirst { it < 0 } != -1) false else runNext(data)
}