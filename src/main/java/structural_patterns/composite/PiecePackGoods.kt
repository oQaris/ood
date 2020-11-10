package structural_patterns.composite

class PiecePackGoods(override val name: String, weight: Int, packWeight: Int) : Product {
    override val netMass: Int = weight
    override val grossMass: Int = weight + packWeight

    init {
        require(name.trim() != "") { "Название товара не может быть пустым!" }
        require(weight >= 0) { "Вес товара должен быть положительным!" }
        require(packWeight >= 0) { "Вес упаковки должен быть положительным!" }
    }
}