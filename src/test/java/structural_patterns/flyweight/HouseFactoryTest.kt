package structural_patterns.flyweight

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class HouseFactoryTest {

    @Test
    fun getHouseTest() {
        val hf = HouseFactory()

        val h1 = hf.getHouse(HouseType.Apartment)
        val h2 = hf.getHouse(HouseType.Cottage)
        val h3 = hf.getHouse(HouseType.Apartment)
        val h4 = hf.getHouse(HouseType.Penthouse)
        val h5 = hf.getHouse(HouseType.Apartment)

        assertEquals(
            hashMapOf(
                HouseType.Apartment to House(HouseType.Apartment, "Apartment"),
                HouseType.Cottage to House(HouseType.Cottage, "Cottage"),
                HouseType.Penthouse to House(HouseType.Penthouse, "Penthouse")
            ),
            hf.houseCache
        )
    }
}