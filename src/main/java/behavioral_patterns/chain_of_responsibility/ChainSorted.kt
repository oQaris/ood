package behavioral_patterns.chain_of_responsibility

class ChainSorted : ChainLink() {
    override fun check(data: List<Int>) =
        if (!data.zip(data.drop(1)).all { (a, b) -> a <= b }) false else runNext(data)
}