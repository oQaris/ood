package behavioral_patterns.chain_of_responsibility

abstract class ChainLink {
    private var next: ChainLink? = null

    abstract fun check(data: List<Int>): Boolean

    fun connect(next: ChainLink): ChainLink {
        this.next = next
        return next
    }

    protected fun runNext(data: List<Int>): Boolean {
        if (next == null)
            return true
        return next!!.check(data)
    }
}