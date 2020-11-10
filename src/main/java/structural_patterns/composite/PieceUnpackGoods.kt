package structural_patterns.composite

class PieceUnpackGoods(override val name: String, weight: Int) : Product {
    override val netMass: Int = weight
    override val grossMass: Int = weight

    init {
        require(name.trim() != "") { "Название товара не может быть пустым!" }
        require(weight >= 0) { "Вес товара должен быть положительным!" }
    }
}