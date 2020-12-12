package behavioral_patterns.chain_of_responsibility

class ChainNonNegativeNumbers : ChainLink() {
    override fun check(data: List<Int>) =
        if (data.indexOfFirst { it < 0 } != -1) false else runNext(data)
}