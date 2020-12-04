package structural_patterns.flyweight

class HouseFactory(val houseCache: HashMap<HouseType, House> = hashMapOf()) {

    fun getHouse(type: HouseType): House {
        if (houseCache[type] == null)
            houseCache[type] = House(type, type.name /*В идеале - схема скачивается откуда то с интернета*/)
        return houseCache[type]!!
    }
}