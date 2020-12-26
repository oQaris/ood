package structural_patterns.flyweight

enum class HouseType {
    Penthouse,
    Cottage,
    Apartment,
    Hut;
}

data class House(
    val type: HouseType,
    private val schema: String /*предположительно весит несколько гигабайт*/
)