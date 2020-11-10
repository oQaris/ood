package structural_patterns.composite

class SetGoods(override val name: String, vararg val set: Product) : Product {

    override val netMass: Int
        get() {
            var sum = 0
            for (p in set) {
                sum += p.netMass
            }
            return sum
        }

    override val grossMass: Int
        get() {
            var sum = 0
            for (p in set) {
                sum += p.grossMass
            }
            return sum
        }
}